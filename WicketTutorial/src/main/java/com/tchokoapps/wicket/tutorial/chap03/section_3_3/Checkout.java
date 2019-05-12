package com.tchokoapps.wicket.tutorial.chap03.section_3_3;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;

import com.tchokoapps.wicket.tutorial.chap03.section_3_1.Address;
import com.tchokoapps.wicket.tutorial.chap03.section_3_1.Cart;
import com.tchokoapps.wicket.tutorial.chap03.section_3_1.CheeseStorePage;

@SuppressWarnings("serial")
public class Checkout extends CheeseStorePage {
	public Checkout() {
		this.add(new FeedbackPanel("feedback"));
		Form form = new Form("form");
		this.add(form);
		Address address = this.getCart().getBillingAddress();
		
		form.add(new TextField("name", new PropertyModel(address, "name")).setRequired(true));
		form.add(new TextField("street", new PropertyModel(address, "street")).setRequired(true));
		form.add(new TextField("city", new PropertyModel(address, "city")).setRequired(true));
		form.add(new TextField("zipcode", new PropertyModel(address, "zipcode")).setRequired(true));
		form.add(new Link("cancel") {
			@Override
			public void onClick() {
				setResponsePage(Index.class);
			}
		});
		form.add(new Button("order") {
			@Override
			public void onSubmit() {
				Cart cart = getCart();
				cart.getCheeses().clear();
				setResponsePage(Index.class);
			}
		});
		
		this.add(new ShoppingCartPanel("cart", getCart()));
	}
}
