package com.atm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ATMController {

	//Controller to control Rest API Request and return data
	@Autowired
	private ATMService atmService;

	//Get Dispenser Status (display what it has)
	@RequestMapping(method = RequestMethod.GET, value = "/getAllDetailsOfDispenser")
	public List<WithdrawalData> getPlatformData() {
		return atmService.getPlatformData();
	}

	//Add Denomination in existing one and return updated Dispenser
	@RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "/add/{type}/{noOfNotes}")
	@ResponseBody
	public List<WithdrawalData> addNotes(@PathVariable String type, @PathVariable int noOfNotes) {
		atmService.addNotes(type, noOfNotes);
		return atmService.getPlatformData();
	}
	
	//Remove Denomination Notes send Type like 50 or 20 and No. of Notes to remove
	@RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "/remove/{type}/{noOfNotes}")
	@ResponseBody
	public List<WithdrawalData> removeNotes(@PathVariable String type, @PathVariable int noOfNotes) {
		atmService.removeNotes(type, noOfNotes);
		return atmService.getPlatformData();
	}
	
	//get Money - Input /getMoney/amount like 50, 70, 100 etc, it will display dispenser data
	//which has no.of Notes withdraw Or Error 
	@RequestMapping(method = RequestMethod.GET, value = "/getMoney/{amount}")
	public List<WithdrawalData> getMoney(@PathVariable int amount) {
		atmService.payment(amount);
		return atmService.getPlatformData();
	}
}
