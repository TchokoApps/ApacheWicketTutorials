package com.tchokoapps.wicket.tutorial.chap06.section_6_4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.form.CheckBoxMultipleChoice;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.ListChoice;
import org.apache.wicket.markup.html.form.ListMultipleChoice;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;

import com.tchokoapps.wicket.tutorial.base.AbstractBasePage;

@SuppressWarnings("serial")
public class SelectionComponentsPage extends AbstractBasePage {
	public SelectionComponentsPage() {
		class MilkType implements Serializable {
			private final long id;
			private final String name;

			public MilkType(long id, String name) {
				this.id = id;
				this.name = name;
			}

			public long getId() {
				return id;
			}

			public String getName() {
				return name;
			}
		}

		class Cheese implements Serializable {
			private String category;
			private List<String> milkTypes = new ArrayList<>();
			private MilkType milkType;

			public String getCategory() {
				return category;
			}

			public void setCategory(String category) {
				this.category = category;
			}

			public List<String> getMilkTypes() {
				return milkTypes;
			}

			public void setMilkTypes(List<String> milkTypes) {
				this.milkTypes = milkTypes;
			}

			public MilkType getMilkType() {
				return milkType;
			}

			public void setMilkType(MilkType milkType) {
				this.milkType = milkType;
			}
		}

		class MilkTypesModel extends LoadableDetachableModel {

			@Override
			protected Object load() {
				return Arrays.asList("Bison", "Camel", "Cow", "Goat", "Reindeer", "Sheep", "Yak");
			}
		}

		Cheese cheese = new Cheese();
		List<String> categories = Arrays.asList("Fresh", "Whey", "Goat or sheep", "Hard", "Blue vein");

		this.add(new ListChoice("category1", new PropertyModel(cheese, "category"), categories));
		cheese.setCategory("Blue vein");

		this.add(new DropDownChoice("category2", new PropertyModel(cheese, "category"), categories));
		cheese.setCategory("Blue vein");

		this.add(new RadioChoice("category3", new PropertyModel(cheese, "category"), categories).setSuffix(" "));

		List<String> choices = Arrays.asList("Camel", "Cow", "Goat", "Reindeer", "Sheep", "Yak");
		add(new ListMultipleChoice("milkTypes1", new PropertyModel(cheese, "milkTypes"), choices));
		cheese.getMilkTypes().clear();
		cheese.getMilkTypes().add("Cow");
		cheese.getMilkTypes().add("Yak");

		add(new CheckBoxMultipleChoice("milkTypes2", new PropertyModel(cheese, "milkTypes"), choices).setSuffix(" "));

		List<MilkType> milktypes = Arrays.asList(new MilkType(1, "Camel"), new MilkType(2, "Cow"),
				new MilkType(3, "Goat"));
		add(new DropDownChoice("milkTypes3", new PropertyModel(cheese, "milkType"), milktypes,
				new ChoiceRenderer("name", "id")));
	}

}
