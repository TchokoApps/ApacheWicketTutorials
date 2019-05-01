package com.tchokoapps.wicket.wickettutorials;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;

@SuppressWarnings("serial")
public class Index extends WebPage {

	private int counter;
	private int ajaxCounter;
	private Label label;

	
	public Index() {
		
		add(new Label("message", "Hello Fabrice, how are you today"));

		add(new Link("link") {

			@Override
			public void onClick() {
				counter++;
			}
		});
		
		add(new Label("label", new PropertyModel(this, "counter")));
		
		add(new AjaxLink("ajaxLink") {
			
			@Override
			public void onClick(AjaxRequestTarget target) {
				++ajaxCounter;
				if(target != null) {
					target.addComponent(label);
				}
			}
		});
		
		label = new Label("ajaxLabel", new PropertyModel(this, "ajaxCounter"));
		add(label);
		label.setOutputMarkupId(true);
	}

}
