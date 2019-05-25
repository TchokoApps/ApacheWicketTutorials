package com.tchokoapps.wicket.tutorial.chap06.section_6_3;

import org.apache.wicket.behavior.SimpleAttributeModifier;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.tchokoapps.wicket.tutorial.base.AbstractBasePage;

@SuppressWarnings("serial")
public class TextComponentsPage extends AbstractBasePage {
	public TextComponentsPage() {
		class Person {
			String name;
		}

		Person person = new Person();
		this.add(new TextField("name0", new PropertyModel(person, "name")));
		this.add(new TextField("name1", new PropertyModel(person, "name"))
				.add(new SimpleAttributeModifier("maxlength", "48")).add(new SimpleAttributeModifier("size", "48")));
		this.add(new PasswordTextField("password", new Model("")));
		
		class Cheese {
			private String description;
		}
		
		Cheese cheese = new Cheese();
		
		this.add(new TextArea("description", new PropertyModel(cheese, "description")));
	}
}
