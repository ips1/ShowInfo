package cz.ips.showinfo.webclient;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by petrkubat on 15/11/14.
 */
public class WebClient {
    public void downloadFromUrl(String url, WebCallback callback) {
        AsyncClient client = new AsyncClient(callback);

        client.execute(url);
    }
}
