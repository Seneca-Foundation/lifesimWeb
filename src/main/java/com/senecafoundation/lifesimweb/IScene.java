package com.senecafoundation.lifesimweb;

import java.util.List;
import java.util.UUID;

public interface IScene {
	String printQuestion();
	List<String> printChoices();
	String getAppropriateResponse(int responseIndex);
	String getNextScene(int responseIndex);
}
