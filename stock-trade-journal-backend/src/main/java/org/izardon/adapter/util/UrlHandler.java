package org.izardon.adapter.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlHandler {
    public HttpURLConnection openConnection(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }
}
