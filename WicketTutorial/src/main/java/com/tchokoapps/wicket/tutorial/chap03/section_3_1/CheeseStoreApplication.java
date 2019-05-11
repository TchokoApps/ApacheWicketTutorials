package com.tchokoapps.wicket.tutorial.chap03.section_3_1;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.apache.wicket.Application;
import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;

import com.tchokoapps.wicket.tutorial.base.WicketTutorialApplicationAbstract;

public class CheeseStoreApplication extends WicketTutorialApplicationAbstract {
	private List<Cheese> cheeses = new ArrayList<>();

	public CheeseStoreApplication() {
	}

	@Override
	protected void init() {
		super.init();
		readCheeses();
	}

	public static CheeseStoreApplication get() {
		return (CheeseStoreApplication) Application.get();
	}

	@Override
	public Session newSession(Request request, Response response) {
		return new CheeseStoreSession(request);
	}

	public List<Cheese> getCheeses() {
		return Collections.unmodifiableList(cheeses);
	}

	private void readCheeses() {
		try (InputStream input = CheeseStoreApplication.class.getClassLoader()
				.getResourceAsStream("cheeses.properties")) {
			Properties properties = new Properties();
			if (input == null) {
				System.out.println(">cheeses.properties< doesn´t exist");
				return;
			}

			properties.load(input);
			properties.forEach((k, v) -> System.out.println(k + "=" + v));

			for (Object obj : properties.keySet()) {
				String key = obj.toString();

				if (!key.endsWith(".name"))
					continue;
				key = key.substring(0, key.indexOf("."));

				String name = properties.getProperty(key + ".name");
				String description = properties.getProperty(key + ".description");
				double price = Double.valueOf(properties.getProperty(key + ".price"));

				cheeses.add(new Cheese(name, description, price));
			}
			System.out.println("### cheeses has " + cheeses.size() + " entries");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
