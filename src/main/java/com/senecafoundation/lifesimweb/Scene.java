package com.senecafoundation.lifesimweb;

import java.io.Console;
import java.util.ArrayList;
import java.util.UUID;

public class Scene implements IScene {
	private UUID id;
	private String question;
	private ArrayList<String> choices;
	private ArrayList<Integer> choicePoints;
	private ArrayList<String> responses;
	private Player playerCharacter;
	private String textColor;
	private ArrayList<UUID> nextScene;
	Console c;
	
	public Scene(
		UUID id, 
		String question, 
		ArrayList<String> choices, 
		ArrayList<Integer> choicePoints,
		int userChoiceSelection,
		ArrayList<String> responses, 
		Player playerCharacter, 
		String textColor, 
		ArrayList<UUID> nextScene
	) {
		this.setId(id);
		this.question = question;
		this.choices = choices;
		this.choicePoints = choicePoints;// This isn't passed in the list of arguments above?
		this.responses = responses;
		this.setPlayerCharacter(playerCharacter);
		this.setTextColor(textColor);
		this.nextScene = nextScene;
	}	
    
	public String getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}

	public Player getPlayerCharacter() {
		return playerCharacter;
	}

	public void setPlayerCharacter(Player playerCharacter) {
		this.playerCharacter = playerCharacter;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@Override
	//asks the question
	public void printQuestion() {
		System.out.println(question);	
	}

	@Override
	//prints the choices
	public void printChoices() {
		for(String choice : choices){
			System.out.println(choice);
		}
	}

	@Override

	//gets the selections
	public int getUserChoiceSelection(Console c) {
		System.out.println("You can enter the choice number, from 0 to " + responses.size() );
		int userChoiceSelection = Integer.parseInt(c.readLine()); //maybe later we can also enter the choice by name
		return userChoiceSelection;
	}

	@Override
	//gets appropriate responses
	public String getAppropriateResponse(int responseIndex) {
		String response = responses.get(responseIndex);
		return response;
	}

	public int getPoints(int responseIndex) {
		int points = choicePoints.get(responseIndex);
		return points;
	}
	

	@Override
	public UUID getNextScene(int responseIndex) {
		UUID UUIDtoReturn = nextScene.get(responseIndex);
		return UUIDtoReturn;	
	}
	
}
