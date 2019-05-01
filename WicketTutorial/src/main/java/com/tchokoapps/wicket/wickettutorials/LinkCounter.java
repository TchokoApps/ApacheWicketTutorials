package com.tchokoapps.wicket.wickettutorials;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;

@SuppressWarnings("serial")
public class LinkCounter extends WebPage {

	private int counter = 0;

	public LinkCounter() {
		add(new Link("link") {

			@Override
			public void onClick() {
				++counter; 
			}
		});

		add(new Label("label", new PropertyModel(this, "counter")));
	}

}
