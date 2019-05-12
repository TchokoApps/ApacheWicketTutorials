package com.tchokoapps.wicket.tutorial.base;

import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.io.IObjectStreamFactory;
import org.apache.wicket.util.lang.Objects;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public abstract class AbstractWicketTutorialApplication extends WebApplication implements ApplicationContextAware {

	public static AbstractWicketTutorialApplication get() {
		return (AbstractWicketTutorialApplication) Application.get();
	}

	private boolean cheeseStoreRequestCycle = false;

	private ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ctx = applicationContext;
	}

	@Override
	protected void init() {
		Objects.setObjectStreamFactory(new IObjectStreamFactory.DefaultObjectStreamFactory());

		getDebugSettings().setAjaxDebugModeEnabled(false);
		getMarkupSettings().setStripWicketTags(true);
		getResourceSettings().setThrowExceptionOnMissingResource(true);

		mountBookmarkablePage("/home", Index.class);
		mountBookmarkablePage("/book", Book.class);
		mountBookmarkablePage("/examples", Examples.class);
		mountBookmarkablePage("/shop", Shop.class);
		mountBookmarkablePage("/support", Support.class);
		mountBookmarkablePage("/section_1_3", com.tchokoapps.wicket.tutorial.chap01.section_1_3.Index.class);
		mountBookmarkablePage("/section_3_1", com.tchokoapps.wicket.tutorial.chap03.section_3_1.Index.class);
		mountBookmarkablePage("/section_3_2", com.tchokoapps.wicket.tutorial.chap03.section_3_2.Index.class);
		mountBookmarkablePage("/section_3_3", com.tchokoapps.wicket.tutorial.chap03.section_3_3.Index.class);
		mountBookmarkablePage("/section_4_2", com.tchokoapps.wicket.tutorial.chap04.section_4_2.Index.class);
	}

	@Override
	public Class<? extends Page> getHomePage() {
		return Index.class;
	}

	@Override
	public abstract Session newSession(Request request, Response response);

}
