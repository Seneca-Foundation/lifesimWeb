package com.senecafoundation.lifesimweb.CRUD;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

import com.senecafoundation.lifesimweb.Player;
public class FileDataHandler implements IDataHandler<Player> {

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
	public void create(Player player) {
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
	public Player read() throws Exception {
		if (this.file != null) {
			try {
				this.scanner = new Scanner(this.file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			while (this.scanner != null && this.scanner.hasNextLine()) {
				String line = this.scanner.nextLine();
				String[] props = line.split(","); 
				// if (line.indexOf(UUID.fromString(props[3])) != -1) {
					return new Player(Integer.parseInt(props[0]), Player.Gender.valueOf(props[1]),
					Integer.parseInt(props[2]), UUID.fromString(props[3]));
				// }
			}
		}
		return new Player(18, Player.Gender.MALE, 0, UUID.randomUUID());
	}

	@Override
	public Player update(Player player) {

		try {
			this.delete(player);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.create(player);
		return player;
	}

	@Override
	public void delete(Player player) throws Exception {
			if (this.file != null) {
				try {
					this.scanner = new Scanner(this.file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				while (this.scanner != null && this.scanner.hasNextLine()) {
					String line = this.scanner.nextLine();
					if (line.indexOf(player.getUuid().toString()) != -1) {
						// this should delete the line
					}
				}
			}
		}
	}