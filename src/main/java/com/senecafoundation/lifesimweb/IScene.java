package com.senecafoundation.lifesimweb;

import java.util.UUID;
import java.io.Console;

public interface IScene {
	void printQuestion();
	void printChoices();
	int getUserChoiceSelection(Console c);
	String getAppropriateResponse(int responseIndex);
	UUID getNextScene(int responseIndex);
}
