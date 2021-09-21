package com.senecafoundation.lifesimweb;

import com.senecafoundation.lifesimweb.Player.Gender;

public interface IPlayer {
	void setReputation(int reputation);
	void setAge(int age);
	void setGender(Gender gender);
}
