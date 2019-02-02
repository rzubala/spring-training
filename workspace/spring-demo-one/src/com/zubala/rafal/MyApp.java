package com.zubala.rafal;

public class MyApp {

	public static void main(String[] args) {
		Coach theCoach = new BaseballCoach(new HappyFortuneService());
		
		System.out.println(theCoach.getDailyWorkout());
	}
}
