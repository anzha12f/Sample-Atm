package com.atm;

import java.util.Map;

public class FiftyDollarDispenser extends MoneyDispenser {

	public Map<String, WithdrawalData> getDollarAmount(long givenAmount, Map<String, WithdrawalData> withdrawalCount) {

		long numberOfNotes = 0;
		long remainingAmount = 0;

		// Get $50 record and update calculated data, send reaming to next handler
		WithdrawalData wd = withdrawalCount.get("50");
		if (wd.getTotalAmountLeft() >= wd.getThresholdAmt()) {
			if (givenAmount >= wd.getTotalAmountLeft()) {
				givenAmount -= wd.getTotalAmountLeft();
				numberOfNotes = wd.getTotalAmountLeft() / 50;
			} else {
				numberOfNotes = givenAmount / 50;
				givenAmount -= numberOfNotes * 50;
			}
			if (numberOfNotes > 0 && (givenAmount % 50 >= 0)) {
				wd.settempHoldNotesToWithdraw((int) numberOfNotes);

				if (numberOfNotes > 1) {
					System.out.println(numberOfNotes + " 50 Dollar Notes");
				} else {
					System.out.println(numberOfNotes + " 50 Dollar Note");
				}
			}
		} else {
			wd.setNoOfNotesWithdrawal(0);

		}

		withdrawalCount.put("50", wd);
		remainingAmount = givenAmount;

		if (remainingAmount > 0) {
			withdrawalCount = moneyDispenser.getDollarAmount(remainingAmount, withdrawalCount);
		}

		return withdrawalCount;

	}
}
