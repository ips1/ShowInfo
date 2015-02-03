package cz.ips.showinfo.webclient;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * Created by petrkubat on 15/11/14.
 */
public class AsyncClient extends AsyncTask<String, Void, String> {
    private WebCallback callback;
    private StatusLine status;

    public AsyncClient(WebCallback callback) {
        this.callback = callback;
    }

    @Override
    protected String doInBackground(String... uris) {
        // TODO smarter way of error / status reporting?

        HttpClient httpClient = new DefaultHttpClient();
        String result = null;
        try {
            HttpResponse response = httpClient.execute(new HttpGet(uris[0]));

            status = response.getStatusLine();

            if (status.getStatusCode() != HttpStatus.SC_OK) {
                response.getEntity().getContent().close();
                System.err.println(status.getReasonPhrase());
                // TODO logging?
                return null;
            }

            result = EntityUtils.toString(response.getEntity());
        }
        catch (IOException e) {
            e.printStackTrace();
            // TODO logging?
            return null;
        }
        catch (IllegalStateException e) {
            e.printStackTrace();
            return null;
        }

        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        if (s != null) {
            callback.handleSuccess(s);
        }
        else {
            if (status != null) {
                callback.handleError(status.getStatusCode(), status.getReasonPhrase());
            }
            else {
                callback.handleError(0, "Unknown error.");
            }
        }
    }
}
