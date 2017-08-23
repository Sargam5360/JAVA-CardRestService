package com.ss.services;

 
import java.util.List;



import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 
import com.rt.aa.*;

@Path("/CardService")
public class CardService 
{
	
	private final static String SUCCESS = "<response>SUCCESS</response>";
	private final static String FAILURE = "<response>FAILURE</response>";
	
	ManageCard card = new ManageCard();
	
	@GET
	@Path("/card/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Card getCar(@PathParam("id") int id)
	{
		System.out.println("Hello");
		return card.getCard(id);		
	}


	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_XML)
	public List<Card> getCarts()
	{
		return card.listCards();		
	}
 
	@POST
	@Path("/modify")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_XML)
	public String modifyCard(@FormParam("id") int id, 
			@FormParam("name") String name, 
			@FormParam("balance") int balance,
			@FormParam("cvv") int cvv , 
			@FormParam("cardno") int cardno)
	{ 
		Card thiscard = new Card(id, cardno, cvv, balance, name);
		if(card.modifyCard(thiscard) == id)
		{
			return SUCCESS;
		}
		else
		{
			return FAILURE;
		}		
	}
	
 
}
