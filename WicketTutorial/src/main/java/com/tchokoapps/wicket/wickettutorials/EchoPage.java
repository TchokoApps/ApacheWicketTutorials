package com.tchokoapps.wicket.wickettutorials;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

@SuppressWarnings("serial")
public class EchoPage extends WebPage {
	private Label label;
	private TextField textField;
	private Form form;
	private Button button;
	
	public EchoPage() {
		
		label = new Label("message", new Model(""));
		textField = new TextField("textField", new Model(""));
		form = new Form("form");
		button = new Button("button") {
			@Override
			public void onSubmit() {
				String value = (String) textField.getModelObject();
				label.setModelObject(value);
				textField.setModelObject("");
			}
		};
		
		form.add(textField);
		form.add(button);
		
		this.add(form);
		this.add(label);
	}

}
