package com.chrome.example.helloworld.client;

import com.chrome.gwt.client.Extension;
import com.google.gwt.core.client.GWT;

@Extension.ManifestInfo(name = "My First Extension", 
		description = "The first extension that I made.", 
		version = "1.0", 
		permissions = { "http://api.flickr.com/" }
		)
public abstract class BackgroundPage extends Extension {

	private final MonitorTabBrowserAction browserAction = GWT
	.create(MonitorTabBrowserAction.class);

	@Override
	public void onBackgroundPageLoad() {
		// Register page action and browser action listeners.
//		browserAction.addListener(new MonitorTabClickListener());
		initialize();
	}

	private void initialize() {
	}

}
