package com.rt.aa;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Card
{
	
	 
 
	public int getCardno() {
		return cardno;
	}

	@XmlElement
	public void setCardno(int cardno) {
		this.cardno = cardno;
	}

	public int getCvv() {
		return cvv;
	}

	@XmlElement
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public int getBalance() {
		return balance;
	}
	
	@XmlElement
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getCardholder() {
		return cardholder;
	}
	
	public Card()
	{
		
	} 

	public Card(int id,int cardno, int cvv, int balance, String cardholder) {
		super();
		this.id=id;
		this.cardno = cardno;
		this.cvv = cvv;
		this.balance = balance;
		this.cardholder = cardholder;
	}

	@XmlElement
	public void setCardholder(String cardholder) {
		this.cardholder = cardholder;
	}

	private int cardno;
	private int cvv;
	private int id;
	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	private int balance;
	private String cardholder;
	
 
}
