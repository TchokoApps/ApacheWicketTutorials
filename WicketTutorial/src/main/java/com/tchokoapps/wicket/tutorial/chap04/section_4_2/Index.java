package com.tchokoapps.wicket.tutorial.chap04.section_4_2;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.tchokoapps.wicket.tutorial.base.AbstractBasePage;

@SuppressWarnings("serial")
public class Index extends AbstractBasePage {

	public static class Address implements Serializable {
		private String street;

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		@Override
		public String toString() {
			return "Address [street=" + street + "]";
		}
	}

	public static class Customer implements Serializable {

		private String firstName;
		private String lastName;
		private Address address = new Address();

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		@Override
		public String toString() {
			return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + "]";
		}
	}

	private Customer customer = new Customer();

	public Index() {
		customer.setFirstName("Foo");
		customer.setLastName("Bar");
		customer.getAddress().setStreet("Dumm Straﬂe 24");

		this.add(new Label("firstname0", customer.getFirstName()));
		this.add(new Label("lastname0", customer.getLastName()));
		this.add(new Label("street0", customer.getAddress().getStreet()));

		this.add(new Label("firstname1", new Model(customer.getFirstName())));
		this.add(new Label("lastname1", new Model(customer.getLastName())));
		this.add(new Label("street1", new Model(customer.getAddress().getStreet())));

		Model staticClock = new Model(getTime());
		this.add(new Label("static", staticClock));

		Model dynamicClock = new Model() {
			public Object getObject() {
				return getTime();
			};
		};

		this.add(new Label("dynamic", dynamicClock));

		this.add(new Link("refresh") {

			@Override
			public void onClick() {

			}
		});

		class MyForm extends Form {
			private TextField name;
			private TextField street;

			public MyForm(String id) {
				super(id);
				name = new TextField("name", new Model(""));
				street = new TextField("street", new Model(""));
				this.add(name);
				this.add(street);
			}

			@Override
			protected void onSubmit() {
				super.onSubmit();
				Customer customer2 = new Customer();
				customer2.setFirstName(name.getModelObjectAsString());
				customer2.getAddress().setStreet(street.getModelObjectAsString());
				System.out.println("customer2 = " + customer2);
			}
		}

		this.add(new MyForm("myform"));
		
		this.add(new Label("firstname2", new PropertyModel(customer, "firstName")));
		this.add(new Label("lastname2", new PropertyModel(customer, "lastName")));
		this.add(new Label("street2", new PropertyModel(customer, "address.street")));
		this.add(new Link("person1") {
			
			@Override
			public void onClick() {
				customer.setFirstName("Patrick");
				customer.setLastName("Firmin");
				customer.getAddress().setStreet("Alabama Str. 20");
			}
		});
		
		this.add(new Link("person2") {
			
			@Override
			public void onClick() {
				customer.setFirstName("Nathalie");
				customer.setLastName("Koah");
				customer.getAddress().setStreet("Elisabeth Str. 11");
			}
		});
	}

	private String getTime() {
		SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
		String time = df.format(new Date());
		return time;
	}

}
