package com.chrome.example.helloworld.client;

import com.chrome.gwt.client.Extension;
import com.chrome.gwt.client.Icon;
import com.chrome.gwt.client.Tabs.Tab;
import com.chrome.gwt.client.events.BrowserActionEvent;
import com.google.gwt.core.client.GWT;

@Extension.ManifestInfo(name = "GWT Chromium Hello World", 
		description = "Hello World Chromium extension using GWT.", 
		version = "0.0.1", 
		permissions = { "tabs" }, 
		icons = {
		"resources/icon16.png", 
		"resources/icon32.png", 
		"resources/icon48.png",
		"resources/icon128.png" 
		},
		optionsPage = "option.html"
		)
public abstract class BackgroundPage extends Extension {

	// private static final int CHROME_BROWSER_ID = 0;
	//
	// private static final int FILE_BROWSER_ID = 0x7FFFFFFF;

	private static final String MONITOR_RESOURCE_PATH = "monitor.html";

	// private final HashMap<Integer, BrowserConnectionState>
	// browserConnectionMap = new HashMap<Integer, BrowserConnectionState>();

	private final HelloWorldTabBrowserAction browserAction = GWT
			.create(HelloWorldTabBrowserAction.class);

	@Override
	public void onBackgroundPageLoad() {
		// Register page action and browser action listeners.
		browserAction.addListener(new MonitorTabClickListener());
		browserAction.setBadgeText("1234");
		initialize();
	}

	private void initialize() {
	}

	private static class TabModel {
//		WindowChannel.Client channel = null;
//		DataInstance dataInstance;
		boolean monitorClosed = true;
//		TabDescription tabDescription = null;
		Icon currentIcon;

		TabModel(Icon icon) {
			this.currentIcon = icon;
		}
	}

	 enum Click  {ACTIVE,INACTIVE, NEW};

	 private class MonitorTabClickListener implements
			BrowserActionEvent.Listener {

		Click clicked = Click.NEW;

		public void onClicked(Tab tab) {

			if (clicked == Click.NEW) {
				browserAction.setBadgeText("A");

				browserAction.setIcon(tab.getId(), browserAction.mtIconActive());
				clicked = Click.ACTIVE;
			} else if (clicked == Click.ACTIVE) {
				browserAction.setBadgeText("I");
				browserAction.setIcon(tab.getId(), browserAction.mtIconDisabled());
				clicked = Click.INACTIVE;
			} else if (clicked == Click.INACTIVE) {
				browserAction.setBadgeText("A");
				browserAction.setIcon(tab.getId(), browserAction.mtIconActive());
				clicked = Click.ACTIVE;
			}
			
		}
	}
}