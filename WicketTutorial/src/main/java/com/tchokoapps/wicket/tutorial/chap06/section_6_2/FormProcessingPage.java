package com.tchokoapps.wicket.tutorial.chap06.section_6_2;

import org.apache.wicket.feedback.ContainerFeedbackMessageFilter;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.value.ValueMap;

import com.tchokoapps.wicket.tutorial.base.AbstractBasePage;

@SuppressWarnings("serial")
public class FormProcessingPage extends AbstractBasePage {
	
	public FormProcessingPage() {
		Form formGet = new Form("search") {
			@Override
			protected void onSubmit() {
				System.out.println("Form was submitted using method : " + getMethod());
				setRedirect(false);
			}
		};
		
		this.add(formGet);
		
		formGet.add(new TextField("q", new Model("") {
			@Override
			public Object getObject() {
				Object o = super.getObject();
				System.out.println("textField value is = " + o.toString());
				return o;
			}
		}));
		
		Form formPost = new Form("formPost") {
			@Override
			protected void onSubmit() {
				System.out.println("Form was submitted using method : " + getMethod());
			}
		};
		
		this.add(formPost);
		
		formPost.add(new TextField("field", new Model("")));
		
		// --------------------------------------------------------------------
		
		CompoundPropertyModel model = new CompoundPropertyModel(new ValueMap());
		Form form2 = new Form("form", model) {
			@Override
			protected void onSubmit() {
				super.onSubmit();
			}
		};
		
		this.add(form2);
		
		form2.add(new TextField("required", model.bind("value1")).setRequired(true));
		form2.add(new TextField("integer", model.bind("value2")).setRequired(true));
		form2.add(new TextField("mustbeone", model.bind("value3")).setRequired(true));
		
		form2.add(new Label("value1"));
		form2.add(new Label("value2"));
		form2.add(new Label("value3"));
		
		form2.add(new FeedbackPanel("feedback", new ContainerFeedbackMessageFilter(form2)));
		
	}
}
