package com.tchokoapps.wicket.tutorial.chap03.section_3_1;

import org.apache.wicket.Request;

import com.tchokoapps.wicket.tutorial.common.WiaSession;

public class CheeseStoreSession extends WiaSession {
	private Cart cart = new Cart();

	public CheeseStoreSession(Request request) {
		super(request);
	}

	public Cart getCart() {
		return cart;
	}
}
