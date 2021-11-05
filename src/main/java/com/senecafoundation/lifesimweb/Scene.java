package com.senecafoundation.lifesimweb;

import java.util.ArrayList;
import java.util.List;

public class Scene implements IScene {
	private String id;
	private String question;
	private ArrayList<String> choices;
	private ArrayList<Integer> choicePoints;
	private ArrayList<String> responses;
	private Player playerCharacter;
	private String textColor;
	private ArrayList<String> nextScene;
	
	public Scene(
		String id, 
		String question, 
		ArrayList<String> choices, 
		ArrayList<Integer> choicePoints,
		int userChoiceSelection,
		ArrayList<String> responses, 
		Player playerCharacter, 
		String textColor, 
		ArrayList<String> nextScene
	) {
		System.out.println("Scene constructor");
		this.setId(id);
		this.question = question;
		this.choices = choices;
		this.choicePoints = choicePoints;// This isn't passed in the list of arguments above?
		this.responses = responses;
		this.setPlayerCharacter(playerCharacter);
		this.setTextColor(textColor);
		this.nextScene = nextScene;
		System.out.println(this.responses.size());
	}	
    
	public Scene() {
    }

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
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

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String printQuestion() {
		return question;	
	}

	@Override
	public List<String> printChoices() {
		return choices;
	}

	public String getChoicePrompt() {
		return "You can enter the choice number, from 0 to ";
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
	public String getNextScene(int responseIndex) {
		String UUIDtoReturn = nextScene.get(responseIndex);
		return UUIDtoReturn;	
	}
	
}
