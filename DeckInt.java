package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Karishma Anand
 * This Java program creates a deck of 52 cards and
 * provides various functionalities which can be performed on it.
 */

public class DeckInt {
	private CardInt[] deckOfCards;
	// Storing the number of cards as a final field, as this will never change
	private final int numberOfCards = 52;
	// Storing the suits as a string array
	static final String[] suits = { "Spades", "Hearts", "Diamonds", "Clubs" };
	// Storing the ranks as a string array
	static final String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
	
	public DeckInt() {
			deckOfCards = new CardInt[numberOfCards];
			// Creating and initializing the deck of cards
			int i = 0;
			for (int suit = 0; suit < suits.length; suit++)
				for (int rank = 0; rank < ranks.length; rank++)
					deckOfCards[i++] = new CardInt(suit, rank);
		}

	// Getter method to fetch the deck of cards
	public CardInt[] getDeckOfCards() {
		return deckOfCards;
	}

	// Functionality to shuffle the deck of cards
	public void shuffle() {
		List<CardInt> shuffledList = new LinkedList<CardInt>(Arrays.asList(deckOfCards));
		Collections.shuffle(shuffledList);
		deckOfCards = shuffledList.toArray(new CardInt[shuffledList.size()]);
	}

	// Functionality to cut the deck of cards at a specific point
	public void cut(int splitPoint) {
		if (deckOfCards.length != 0 && splitPoint > 0 && splitPoint < deckOfCards.length) {
			List<CardInt> splitList = new LinkedList<CardInt>(Arrays.asList(deckOfCards));
			List<CardInt> rearrangeList = new LinkedList<CardInt>(splitList.subList(0, splitPoint));
			splitList.removeAll(rearrangeList);
			splitList.addAll(rearrangeList);
			deckOfCards = splitList.toArray(new CardInt[splitList.size()]);
		} else {
			System.out.println("No cards available in the deck or invalid split Position");
		}
	}

	// Functionality to deal the top card to a player
	public CardInt deal() {
		if (deckOfCards.length != 0) {
			LinkedList<CardInt> dealList = new LinkedList<CardInt>(Arrays.asList(deckOfCards));
			CardInt cardDealt = dealList.remove();
			deckOfCards = dealList.toArray(new CardInt[dealList.size()]);
			return cardDealt;
		} else {
			System.out.println("All cards have been dealt");
			return null;
		}
	}

	// Functionality to turn over the top card to the bottom of the deck
	public CardInt turnOver() {
		if (deckOfCards.length != 0) {
			List<CardInt> turnCardList = new LinkedList<CardInt>(Arrays.asList(deckOfCards));
			CardInt cardTurned = turnCardList.remove(0);
			turnCardList.add(cardTurned);
			deckOfCards = turnCardList.toArray(new CardInt[turnCardList.size()]);
			return cardTurned;
		} else {
			System.out.println("No cards are available in the deck.");
			return null;
		}
	}

	/*
	 * Functionality to search the position of a particular card in the 
	 * deck of cards
	 */
	public int search(CardInt card) {
		if (deckOfCards.length != 0) {
			List<CardInt> searchList = new ArrayList<CardInt>(Arrays.asList(deckOfCards));
			int result = ((searchList.indexOf(card)) + 1);
			return result;
		} else {
			System.out.println("No cards are available in the deck.");
			return 0;
		}
	}

	/* Functionality to re-order the deck of cards in a certain order of 
	 * suits and ascending or descending order of ranks provided by
	 * placeholders - suitOrder and rankOrder
	 */
	public void newOrder(String[] suitOrder, String[] rankOrder) {
		if (deckOfCards.length == 52) {
			List<CardInt> newOrderList = new LinkedList<CardInt>(Arrays.asList(deckOfCards));
			Collections.sort(newOrderList);
			List<CardInt> newList = new LinkedList<CardInt>();
			List<CardInt> Spades = new LinkedList<CardInt>(newOrderList.subList(0, 13));
			List<CardInt> Hearts = new LinkedList<CardInt>(newOrderList.subList(13, 26));
			List<CardInt> Diamonds = new LinkedList<CardInt>(newOrderList.subList(26, 39));
			List<CardInt> Clubs = new LinkedList<CardInt>(newOrderList.subList(39, 52));
			for (int i=0; i<suitOrder.length; i++) {
				if (suitOrder[i] == "Spades") {
					if(rankOrder[i] == "ASC") {
						newList.addAll(Spades);
					} else {
						Collections.reverse(Spades);
						newList.addAll(Spades);
					}
				} else if (suitOrder[i] == "Hearts") {
					if(rankOrder[i] == "ASC") {
						newList.addAll(Hearts);
					} else {
						Collections.reverse(Hearts);
						newList.addAll(Hearts);
					}
				} else if (suitOrder[i] == "Diamonds") {
					if(rankOrder[i] == "ASC") {
						newList.addAll(Diamonds);
					} else {
						Collections.reverse(Diamonds);
						newList.addAll(Diamonds);
					}
				} else if (suitOrder[i] == "Clubs") {
					if(rankOrder[i] == "ASC") {
						newList.addAll(Clubs);
					} else {
						Collections.reverse(Clubs);
						newList.addAll(Clubs);
					}
				}
			}
			deckOfCards = newList.toArray(new CardInt[newList.size()]);
		} else {
			System.out.println("Cannot order the cards in the deck");
		}
	}

	// Functionality to print the deck of cards
	public void print() {
		if (deckOfCards.length != 0) {
			for (int i = 0; i < deckOfCards.length; i++) {
				System.out.println(deckOfCards[i]);
			}
			System.out.println("-------------------------");
		} else {
			System.out.println("No cards are available in the deck");
		}
	}
}