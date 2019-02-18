package com.atm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class ATMService {

	//Define here some statics to initialise with loader
	private static FiftyDollarDispenser fiftyDollarDispenser = new FiftyDollarDispenser();

	private static TwentyDollarDispenser twentyDollarDispenser = new TwentyDollarDispenser();

	public static Map<String, WithdrawalData> withdrawalCount = new HashMap<>();

	static {
		withdrawalCount.put("50", new WithdrawalData("50", 0, true, "", 10, 3, 150, 500,0));
		withdrawalCount.put("20", new WithdrawalData("20", 0, true, "", 20, 3, 60, 400,0));
		fiftyDollarDispenser.nextDispenser(twentyDollarDispenser);
	}
	
	//Calculate Payment Amount for e.g if you pass 100 then 'withdrawalCount' Map Collection
	//will be updated with 2 x 50 Notes, see withdrawalData POJO 
	public Map<String, WithdrawalData> payment(long givenAmount) {
		withdrawalCount = fiftyDollarDispenser.getDollarAmount(givenAmount, withdrawalCount);
		// withdrawalCount = isWithdrawalStatusOK(withdrawalCount);

		return withdrawalCount;
	}

	//check availability 
	public Map<String, WithdrawalData> checkNotesAvailbilityAndUpdate(Map<String, WithdrawalData> noOfNotes) {

		List<WithdrawalData> withdrawalData = noOfNotes.values().stream().filter(e -> e.isStatus() == false)
				.collect(Collectors.toList());
		System.out.println("Value of Status Field --- " + withdrawalData);
		if (withdrawalData.isEmpty()) {

		}
		noOfNotes.forEach((key, wd) -> {
			if (!wd.isStatus()) {

			}
		});
		// WithdrawalData wd = noOfNotes.get(key)
		return noOfNotes;
	}
	
	
	//Get Unto date Data of MAP
	public List<WithdrawalData> getPlatformData() {
		return withdrawalCount.values().stream()
        .collect(Collectors.toList());
		//return ArrayList(withdrawalCount.values());
	}

	//Add Data in Map 
	public String addNotes(String type, int noOfNotes) {
		WithdrawalData wd = withdrawalCount.get(type);
		wd.setNoOfNotesLeft(wd.getNoOfNotesLeft() + noOfNotes);
		withdrawalCount.put(type, wd);

		return type + " denomination of " + noOfNotes + " Notes Added, now Count is " + wd.getNoOfNotesLeft();
	}

	//Remove Data
	public String removeNotes(String type, int noOfNotes) {

		WithdrawalData wd = withdrawalCount.get(type);
		wd.setNoOfNotesLeft(wd.getNoOfNotesLeft() - noOfNotes);
		withdrawalCount.put(type, wd);
		return type + " denomination of " + noOfNotes + " Notes Removed, now Count is " + wd.getNoOfNotesLeft();
	}
}
