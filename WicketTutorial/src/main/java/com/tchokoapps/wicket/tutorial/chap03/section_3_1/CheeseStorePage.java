package com.tchokoapps.wicket.tutorial.chap03.section_3_1;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;

public abstract class CheeseStorePage extends WebPage {
	public CheeseStoreSession getCheeseStoreSession() {
		return (CheeseStoreSession) getSession();
	}

	public Cart getCart() {
		return getCheeseStoreSession().getCart();
	}

	public List<Cheese> getCheeses() {
		return CheeseStoreApplication.get().getCheeses();
	}
}
