package cz.ips.showinfo.webclient;

import org.apache.http.HttpStatus;

/**
 * Created by petrkubat on 15/11/14.
 */
public abstract class WebCallback {
    public abstract void handleSuccess(String response);
    public abstract void handleError(int statusCode, String statusMessage);
}
