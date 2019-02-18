package com.atm;

public class WithdrawalData {
	
	//POJO to act as a DataBase Record to hold upto date information

	private String denominationType;

	private int noOfNotesWithdrawal;

	private boolean status;

	private String errMessage;

	private int noOfNotesLeft;

	private int thresholdLimit;

	private int thresholdAmt;

	private int totalAmountLeft;
	
	private int tempHoldNotesToWithdraw;
	


	public WithdrawalData(String denominationType, int noOfNotesWithdrawal, boolean status, String errMessage,
			int noOfNotesLeft, int thresholdLimit, int thresholdAmt, int totalAmountLeft, int tempHoldNotesToWithdraw) {
		super();
		this.denominationType = denominationType;
		this.noOfNotesWithdrawal = noOfNotesWithdrawal;
		this.status = status;
		this.errMessage = errMessage;
		this.noOfNotesLeft = noOfNotesLeft;
		this.thresholdLimit = thresholdLimit;
		this.thresholdAmt = thresholdAmt;
		this.totalAmountLeft = totalAmountLeft;
		this.tempHoldNotesToWithdraw = tempHoldNotesToWithdraw;
	}

	public String getDenominationType() {
		return denominationType;
	}

	public void setDenominationType(String denominationType) {
		this.denominationType = denominationType;
	}

	public int getNoOfNotesWithdrawal() {
		return noOfNotesWithdrawal;
	}

	public void setNoOfNotesWithdrawal(int noOfNotesWithdrawal) {
		this.noOfNotesWithdrawal = noOfNotesWithdrawal;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	public int getNoOfNotesLeft() {
		return noOfNotesLeft;
	}

	public void setNoOfNotesLeft(int noOfNotesLeft) {
		this.noOfNotesLeft = noOfNotesLeft;
	}

	@Override
	public String toString() {
		return "WithDrawalData{" + "Denomination Type='" + denominationType + '\'' + ", Notes WithDraw='"
				+ noOfNotesWithdrawal + '\'' + ", Status='" + status + '\'' + ", Error Message='" + errMessage + '\''
				+ ", Notes Left='" + noOfNotesLeft + '\'' + ", Threshold Limit='" + thresholdLimit + '\'' 
				+ ", Total Amount Left = '" + totalAmountLeft + '\''  + ", Temp Hold Notes='" + tempHoldNotesToWithdraw + '\'' 
				+ '}';
	}

	public int getThresholdLimit() {
		return thresholdLimit;
	}

	public void setThresholdLimit(int thresholdLimit) {
		this.thresholdLimit = thresholdLimit;
	}

	public int getThresholdAmt() {
		return thresholdAmt;
	}

	public void setThresholdAmt(int thresholdAmt) {
		this.thresholdAmt = thresholdAmt;
	}

	public int getTotalAmountLeft() {
		return totalAmountLeft;
	}

	public void setTotalAmountLeft(int totalAmountLeft) {
		this.totalAmountLeft = totalAmountLeft;
	}
	
	public int getTempHoldNotesToWithdraw() {
		return tempHoldNotesToWithdraw;
	}

	public void settempHoldNotesToWithdraw(int tempHoldNotesToWithdraw) {
		this.tempHoldNotesToWithdraw = tempHoldNotesToWithdraw;
	}
}
