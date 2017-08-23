package com.rt.aa;

 import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageCard {
	 private static SessionFactory factory; 
	 
	 public static void main(String[] args) {
	     
	       
	 }  
	 
	 
	 public Card getCard(int id) {
		 Card card = null;
		 
		 
		 try{
	         factory = new Configuration().configure().buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to createa sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
 		
	      Session session = factory.openSession();
	      Transaction tx = null;
 	      try{
	         tx = session.beginTransaction();
	         card =   (Card)session.get(Card.class, id); 
	         
	         
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }

		 
		 
		 return card;	 
		 
	 }
	 
	   /* Method to  READ all the cards */
 	public List<Card> listCards(){
 		
 		 try{
	         factory = new Configuration().configure().buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to createa sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
 		
	      Session session = factory.openSession();
	      Transaction tx = null;
	      List<Card>  cards = null;
	      try{
	         tx = session.beginTransaction();
	         String hql = "FROM Card ";
	           cards = (List<Card>) session.createQuery(hql).list(); 
	         for (Iterator<Card> iterator = cards.iterator(); iterator.hasNext();){
	            Card card = (Card) iterator.next(); 
	            System.out.print(" cardholder Name: " + card.getCardholder()); 
	          //  System.out.print(" No: " + flight.getDestination()); 
	           // System.out.println("  Seats: " + flight.getTickets()); 
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      
	    return cards;
 
	   }
 	
 		public int modifyCard(Card card)
 		{
 			int id = 0;
  			 try{
 		         factory = new Configuration().configure().buildSessionFactory();
 		      }catch (Throwable ex) { 
 		         System.err.println("Failed to createa sessionFactory object." + ex);
 		         throw new ExceptionInInitializerError(ex); 
 		      }
 	 		
 		      Session session = factory.openSession();
 		      
 		      
 		     Transaction tx = null;
 		      try{
 		         tx = session.beginTransaction();
 		         Card c = (Card)session.get(Card.class, card.getId()); 
 		         c.setBalance(card.getBalance());
 		         c.setCardholder(card.getCardholder());
 		         c.setCardno(card.getCardno());
 		         c.setCvv(card.getCvv());
 		         id = c.getId();
 				 session.update(c); 
 		         tx.commit();
 		      }catch (HibernateException e) {
 		         if (tx!=null) tx.rollback();
 		         e.printStackTrace(); 
 		      }finally {
 		         session.close(); 
 		      }

  			return id;
 			
 			
 		}
	      
}
