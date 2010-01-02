/*
 * Copyright 2008 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.chrome.example.helloworld.client;

import com.chrome.example.helloworld.client.service.FlickService;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.XMLParser;

/**
 * EntryPoint class for Speed Tracer's monitor.
 */
public class Monitor implements EntryPoint {

	public void onModuleLoad() {
		FlickService pingService = GWT.create(FlickService.class);
		pingService.ping("flickr.photos.search",
				"90485e931f687a9b9c2a66bf58a3861a", "hello world", "1", "1",
				"relevance", "20", new RequestCallback() {

					public void onError(Request arg0, Throwable arg1) {

					}

					public void onResponseReceived(Request arg0, Response resp) {
						Document dom = XMLParser.parse(resp.getText());
						NodeList photos = dom.getElementsByTagName("photo");
						for (int i = 0; i < photos.getLength(); i++) {
							Element photo = (Element) photos.item(i);
							com.google.gwt.dom.client.Element imgElement = com.google.gwt.dom.client.Document
									.get().createImageElement();
							imgElement.setAttribute("src",
									constructImageURL(photo));
							RootPanel.get().getElement()
									.appendChild(imgElement);
						}
					}

					private String constructImageURL(Element photo) {
						return "http://farm" + photo.getAttribute("farm")
								+ ".static.flickr.com/"
								+ photo.getAttribute("server") + "/"
								+ photo.getAttribute("id") + "_"
								+ photo.getAttribute("secret") + "_s.jpg";

					}
				});
	}

}
