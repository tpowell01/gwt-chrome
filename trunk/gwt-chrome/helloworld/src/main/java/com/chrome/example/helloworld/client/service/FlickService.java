package com.chrome.example.helloworld.client.service;

import org.edgebox.gwt.rest.client.RestGWT;
import org.edgebox.gwt.rest.client.RestRemote;
import org.edgebox.gwt.rest.client.annotation.Endpoint;
import org.edgebox.gwt.rest.client.annotation.HttpHeader;
import org.edgebox.gwt.rest.client.annotation.HttpHeaders;
import org.edgebox.gwt.rest.client.annotation.ReqKey;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;

public interface FlickService extends RestRemote {

	@Endpoint(method = RestGWT.Method.Represent, urlTemplate = "http://api.flickr.com/services/rest/")
	@HttpHeaders(headers = { @HttpHeader(name = "a", value = "a"),
			@HttpHeader(name = "b", value = "b") })
	Request ping(@ReqKey("method") String method, @ReqKey("api_key") String apiKey,  @ReqKey("text") String text, @ReqKey("safe_search") String safeSearch, @ReqKey("content_type") String contentType, @ReqKey("sort") String sort, @ReqKey("per_page") String perPage, RequestCallback callback);
}
