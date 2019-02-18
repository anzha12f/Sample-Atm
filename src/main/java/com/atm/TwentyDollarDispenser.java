package com.atm;

import java.util.Map;

public class TwentyDollarDispenser extends MoneyDispenser {

	public Map<String, WithdrawalData> getDollarAmount(long givenAmount, Map<String, WithdrawalData> withdrawalCount) {

		long numberOfNotes = 0;
		long remainingAmount = 0;

		//Money dispenser for 20 dollar notes 
		WithdrawalData wd = withdrawalCount.get("20");
		if (wd.getTotalAmountLeft() >= wd.getThresholdAmt()) {
			if (givenAmount >= wd.getTotalAmountLeft()) {
				givenAmount -= wd.getTotalAmountLeft();
				numberOfNotes = wd.getTotalAmountLeft() / 20;
			} else {
				numberOfNotes = givenAmount / 20;
				givenAmount -= numberOfNotes * 20;
			}

			if (numberOfNotes > 0 && (givenAmount % 20) >= 0) {

				if (numberOfNotes > 1) {
					System.out.println(numberOfNotes + " 20 Dollar Notes");
				} else {
					System.out.println(numberOfNotes + " 20 Dollar Note");
				}
			}
		} else {
			wd.setNoOfNotesWithdrawal(0);
		}

		remainingAmount = givenAmount;

		if (remainingAmount > 0) {
			wd.setStatus(false);
			wd.setErrMessage("Dispenser Error - Invalid Amount");
		    System.out.println("No Dispenser for " + remainingAmount);
			withdrawalCount = rollbackFiftyDollarIfOnHold(withdrawalCount);
		} else {
			wd.setNoOfNotesWithdrawal((int) numberOfNotes);
			wd.setNoOfNotesLeft(wd.getNoOfNotesLeft() - (int) numberOfNotes);
			wd.setTotalAmountLeft(wd.getTotalAmountLeft() - (int) (numberOfNotes * 20));
			withdrawalCount = CommitFiftyDollarTransactionIfOnHold(withdrawalCount);
		}
		withdrawalCount.put("20", wd);
		return withdrawalCount;
	}
	
	
	//if All OK then commit Previous transactions
	public Map<String, WithdrawalData> CommitFiftyDollarTransactionIfOnHold(
			Map<String, WithdrawalData> withdrawalCount) {
		WithdrawalData wd = withdrawalCount.get("50");
		if (wd.getTempHoldNotesToWithdraw() > 0) {
			wd.setNoOfNotesWithdrawal(wd.getTempHoldNotesToWithdraw());
			wd.setNoOfNotesLeft(wd.getNoOfNotesLeft() - wd.getTempHoldNotesToWithdraw());
			wd.setTotalAmountLeft(wd.getTotalAmountLeft() - wd.getTempHoldNotesToWithdraw() * 50);
			wd.settempHoldNotesToWithdraw(0);
			withdrawalCount.put("50", wd);
		}
		return withdrawalCount;
	}
	
	
	//If Something Wrong RollBack Hold Amount
	public Map<String, WithdrawalData> rollbackFiftyDollarIfOnHold(
			Map<String, WithdrawalData> withdrawalCount) {
		WithdrawalData wd = withdrawalCount.get("50");
		wd.settempHoldNotesToWithdraw(0);
		withdrawalCount.put("50", wd);
		return withdrawalCount;
	}
}
