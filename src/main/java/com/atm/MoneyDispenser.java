package com.atm;

import java.util.Map;

public abstract class MoneyDispenser {

	MoneyDispenser moneyDispenser;
	
	public void nextDispenser(MoneyDispenser moneyDispenser)
	{
		this.moneyDispenser = moneyDispenser;
	}
	
	public abstract Map<String, WithdrawalData> getDollarAmount( long givenAmount, Map<String,WithdrawalData> withdrawalCount);
	
}
