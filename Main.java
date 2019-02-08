package com.practice;

/**
 * @author Karishma Anand
 * 
 * This Java program is used to call the Deck class 
 * and perform various functionalities on it.
 */
public class Main {
	
	public static void main(String[] args) {		
		 // Create a new Deck of cards
		 DeckInt d = new DeckInt();
		  System.out.println("New Deck of cards initialized ");
		  d.print();
		  
		  // Shuffle the cards
		  d.shuffle();
		  System.out.println("After shuffling of cards ");
		  d.print();
		  
		  // Provide a new order for the deck of cards
		  String[] suitOrder = {"Hearts","Clubs","Diamonds","Spades"};
		  String[] rankOrder = {"ASC","ASC","DESC","DESC"};
		  d.newOrder(suitOrder, rankOrder);
		  System.out.println("Deck of cards with new order "); 
		  d.print();
		  
		  // Cut the cards
		  d.cut(20);
		  System.out.println("Deck of cards after cutting ");
		  d.print();
		  
		  // Deal the card
		  System.out.println("Card dealt is "+d.deal());
      System.out.println("-------------------------");
      
		  // Turn the card over
		  System.out.println("Card turned over is "+d.turnOver());
		  System.out.println("-------------------------");
		  
		  // Search a specific card
		  CardInt searchCard = new CardInt("Spades", "Queen");
		  System.out.println("The card "+searchCard.toString()+" is at position "+d.search(searchCard));
		  System.out.println("-------------------------");
	}	
}
