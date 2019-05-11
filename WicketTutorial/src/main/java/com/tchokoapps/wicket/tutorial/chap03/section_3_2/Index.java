package com.tchokoapps.wicket.tutorial.chap03.section_3_2;

import java.text.NumberFormat;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.tchokoapps.wicket.tutorial.chap03.section_3_1.Cheese;
import com.tchokoapps.wicket.tutorial.chap03.section_3_1.CheeseStorePage;

@SuppressWarnings("serial")
public class Index extends CheeseStorePage {

	public Index() {

		PageableListView cheesesPageableListView = new PageableListView("cheeses", getCheeses(), 2) {

			@Override
			protected void populateItem(ListItem item) {
				Cheese cheese = (Cheese) item.getModelObject();
				item.add(new Label("name", cheese.getName()));
				item.add(new Label("description", cheese.getDescription()));
				item.add(new Label("price", "$" + cheese.getPrice()));
				item.add(new Link("add", item.getModel()) {

					@Override
					public void onClick() {
						Cheese selectedCheese = (Cheese) this.getModelObject();
						getCart().getCheeses().add(selectedCheese);
					}
				});
			}
		};

		this.add(cheesesPageableListView);
		this.add(new PagingNavigator("navigator", cheesesPageableListView));

		this.add(new ListView("cart", new PropertyModel(this, "cart.cheeses")) {

			@Override
			protected void populateItem(ListItem item) {
				Cheese selectedCheese = (Cheese) item.getModelObject();
				item.add(new Label("name", selectedCheese.getName()));
				item.add(new Label("price", "$" + selectedCheese.getPrice()));
				item.add(new Link("remove", item.getModel()) {

					@Override
					public void onClick() {
						Cheese cheeseToRemove = (Cheese) item.getModelObject();
						getCart().getCheeses().remove(cheeseToRemove);
					}
				});
			}
		});

//		this.add(new Label("total", "$"+getCart().getTotal()));

		this.add(new Label("total", new Model() {
			@Override
			public Object getObject() {
				NumberFormat curInstance = NumberFormat.getCurrencyInstance();
				return curInstance.format(getCart().getTotal());
			}
		}));

		this.add(new Link("checkout") {

			@Override
			public void onClick() {
				setResponsePage(new Checkout());
			}

			@Override
			public boolean isVisible() {
				return !getCart().getCheeses().isEmpty();
			}
		});
	}
}
