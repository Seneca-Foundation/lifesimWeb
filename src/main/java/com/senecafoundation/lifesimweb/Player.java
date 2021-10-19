package com.senecafoundation.lifesimweb;

import org.springframework.data.annotation.Id;

public class Player implements IPlayer {
	
	public static enum Gender {
		MALE, FEMALE, NONBINARY
	}
	@Id
	private String id;
	private int age;
	private Gender gender;
	private int reputation;
	
	public Player(int age, Gender gender, int reputation, String Id) {
		this.age = age;
		this.gender = gender;
		this.reputation = reputation;
		this.id = Id;
	}

	public Player() {
    }

    public int getReputation() {
		return reputation;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public void setReputation(int reputation) {
		this.reputation = reputation;
	}
	public String toString() {
		return this.getAge() + "," + this.getGender() + "," + this.getReputation() + "," + this.getId();
	}
	public void setId(String Id) {
		this.id = Id;
	}
	public String getId() {
		return this.id;
	}
}
