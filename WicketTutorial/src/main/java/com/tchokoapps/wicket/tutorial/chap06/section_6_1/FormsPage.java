package com.tchokoapps.wicket.tutorial.chap06.section_6_1;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

import com.tchokoapps.wicket.tutorial.base.AbstractBasePage;

@SuppressWarnings("serial")
public class FormsPage extends AbstractBasePage {
	public FormsPage() {
		Form form = new Form("form") {
			@Override
			protected void onSubmit() {
				System.out.println("### onSubmit pressed");
			}
		};
		this.add(form);
		form.add(new TextField("field", new Model("")));
	}
}
