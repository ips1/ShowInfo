package cz.ips.showinfo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import org.apache.http.HttpStatus;

import java.net.URISyntaxException;

import cz.ips.showinfo.webclient.WebCallback;
import cz.ips.showinfo.webclient.WebClient;


public class HomeScreen extends ActionBarActivity {
    private EditText inputField;
    private WebView webView;
    private Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        inputField = (EditText)findViewById(R.id.addressInput);
        webView = (WebView)findViewById(R.id.testView);
        confirmButton = (Button)findViewById(R.id.confirmButton);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void confirmClicked(View view) {
        WebClient client = new WebClient();

        confirmButton.setEnabled(false);
        inputField.setEnabled(false);

        WebCallback callback = new WebCallback() {
            @Override
            public void handleSuccess(String response) {
                downloadFinished(response);
            }

            @Override
            public void handleError(int statusCode, String statusMessage) {
                downloadFailed(statusCode, statusMessage);
            }
        };

        client.downloadFromUrl(inputField.getText().toString(), callback);
    }

    private void downloadFailed(int statusCode, String statusMessage) {
        inputField.setEnabled(true);
        confirmButton.setEnabled(true);

        displayError("Error " + statusCode + ": " + statusMessage);
    }

    private void downloadFinished(String response) {
        inputField.setEnabled(true);
        confirmButton.setEnabled(true);

        if (response == null) {
            displayError("Empty response!");
        }
        else {
            webView.loadData(response, "text/html", null);
        }
    }

    private void displayError(String error) {
        webView.loadData("<html><body><h1>" + error + "</h1></body></html>", "text/html", null);
    }
}
