package com.senecafoundation.lifesimweb.CRUD;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import com.senecafoundation.lifesimweb.IPlayer;
import com.senecafoundation.lifesimweb.Player;
public class FileDataHandler implements IDataHandler {

	private String fileLocation;
	private File file;
	Scanner scanner;

	public FileDataHandler(String fileLocationFromUser) {
		this.fileLocation = fileLocationFromUser;
		try {
			this.file = new File(fileLocationFromUser);
			this.scanner = new Scanner(this.file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Create(IPlayer player) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(this.fileLocation, true));
			bw.write(player.toString());
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public IPlayer Read(String id) throws Exception {
		if (this.file != null) {
			try {
				this.scanner = new Scanner(this.file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			while (this.scanner != null && this.scanner.hasNextLine()) {
				String line = this.scanner.nextLine();
				String[] props = line.split(","); 
				if (props[0].equals("Player")) {
					Player playerToReturn = new Player(Integer.parseInt(props[0]), Player.Gender.valueOf(props[1]),
					Integer.parseInt(props[2]), props[3]);
					playerToReturn.setId(props[0]);
				}
			}
		}
        // We throw a custom error here if we can't find anything with that ID
        throw new Exception("Item not found with that ID");
	}

	@Override
	public IPlayer Update(IPlayer player) {

		try {
			this.Delete(((Player) player).getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.Create(player);
		return player;
	}

	@Override
	public Boolean Delete(String id) throws Exception {
        //now read the file line by line...
        ArrayList<String> lines = new ArrayList<String>();
        if (this.file != null) {
            this.scanner = new Scanner(this.file);
            while (this.scanner != null && this.scanner.hasNextLine()) {
                String line = this.scanner.nextLine();
                if(!line.contains(id.toString())) { 
                    lines.add(line);
                }
            }
        }

        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(this.fileLocation));
            lines.forEach(lineToWrite ->
                { 
                    try {
                        bw.write(lineToWrite);
                        bw.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            );
            bw.flush();
            bw.close();
            return true;
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        // We throw a custom error here if we can't find anything with that ID
        throw new Exception("Item not found with that ID");
	}

}