/*
 * Copyright 2009 Google Inc.
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

import com.chrome.gwt.client.BrowserAction;
import com.chrome.gwt.client.Icon;
import com.chrome.gwt.client.BrowserAction.ManifestInfo;
import com.chrome.gwt.client.Icon.Source;

/**
 * The MonitorTab page action with button.
 */
@ManifestInfo(name = "MonitorTab", defaultIcon = "mt-icon.png")
public abstract class HelloWorldTabBrowserAction extends BrowserAction {
  @Source("mt-icon.png")
  public abstract Icon mtIcon();

  @Source("mt-icon-active.png")
  public abstract Icon mtIconActive();
  
  @Source("mt-icon-disabled.png")
  public abstract Icon mtIconDisabled();
}
