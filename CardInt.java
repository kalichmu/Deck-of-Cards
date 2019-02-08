package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Karishma Anand
 * This POJO class defines the Card class with its respective fields - 
 * suit and rank
 */
public class CardInt implements Comparable<CardInt> {
		private int suit;
		private int rank;

		// Parameterized constructor to initialize the Card
		public CardInt(int suit, int rank) {
			this.suit = suit;
			this.rank = rank;
		}
		
		public CardInt(String suitName, String rankName) {
			List<String> suitNameList = new ArrayList<String>(Arrays.asList(Deck.suits));
			List<String> rankNameList = new ArrayList<String>(Arrays.asList(Deck.ranks));
			this.suit = suitNameList.indexOf(suitName);;
			this.rank = rankNameList.indexOf(rankName);;
		}

		// Providing getter methods for the fields
		public int getSuit() {
			return suit;
		}

		public int getRank() {
			return rank;
		}

		// Providing custom implementation of the toString() method
		@Override
		public String toString() {
			return "" + Deck.ranks[getRank()] + " of " + Deck.suits[getSuit()];
		}

		/* Providing custom implementation of the compareTo() method
		 * which will be used when sorting Cards in order
		 */
		@Override
		public int compareTo(CardInt o) {
			int cmp = 0;
			if (getSuit() > o.getSuit()) {
			   cmp = +1;
			} else if (getSuit() < o.getSuit()) {
			   cmp = -1;
			} else if (getSuit() == o.getSuit()) {
					if (getRank() > o.getRank())
					   cmp = +1;
					else if (getRank() < o.getRank())
					   cmp = -1;
					else
					   cmp = 0;
			}
			return cmp;
		}
		
		
		/* Providing custom implementation of the equals() method and 
		 * hashCode() method which will be used internally while fetching the 
		 * index of a particular Card
		 */
		@Override
		public boolean equals (Object obj) {
			 if (this == obj) {
		            return true;
		        }
		        if (obj == null || obj.getClass() != getClass()) {
		            return false;
		        }
		        CardInt card1 = (CardInt) obj;
		        return getSuit() == card1.getSuit() &&
		                getRank() == card1.getRank();
		}
		
		@Override
		public int hashCode () {
			return (49 * (49 + getRank()) + getSuit());
		}	
}