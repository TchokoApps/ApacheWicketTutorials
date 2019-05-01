package com.tchokoapps.wicket.wickettutorials;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class MyApplication extends WebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return EchoPage.class;
	}

}
