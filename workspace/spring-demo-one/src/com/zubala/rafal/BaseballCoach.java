package com.zubala.rafal;

public class BaseballCoach implements Coach {

	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minute on batting practise";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
