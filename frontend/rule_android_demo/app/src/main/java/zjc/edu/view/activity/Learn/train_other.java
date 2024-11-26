package zjc.edu.view.activity.Learn;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Spinner;

import zjc.edu.R;

public class train_other extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_other);
        Spinner spinner = findViewById(R.id.other_spinner);
        webView = findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinner.getSelectedItemPosition()==0){
                    webView.loadUrl("https://www.gov.uk/government/organisations/hm-revenue-customs");
                } else if (spinner.getSelectedItemPosition()==1) {
                    webView.loadUrl("https://www.impots.gouv.fr/accueil");
                } else if (spinner.getSelectedItemPosition()==2) {
                    webView.loadUrl("https://www.bzst.de/EN/Home/home_node.html");
                } else if (spinner.getSelectedItemPosition()==3) {
                    webView.loadUrl("https://www.agenziaentrate.gov.it/portale/web/english/nse");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}