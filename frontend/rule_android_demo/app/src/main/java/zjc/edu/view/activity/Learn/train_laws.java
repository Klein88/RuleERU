package zjc.edu.view.activity.Learn;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import zjc.edu.R;
import zjc.edu.view.activity.MainActivity;

public class train_laws extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView laws_vat;
    private TextView statute_epr;
    private ImageButton imb_1;
    private ImageButton imb_2;
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_laws);
        webView = findViewById(R.id.webview);
        statute_epr=findViewById(R.id.statute_epr);
        laws_vat=findViewById(R.id.laws_vat);
        imb_1=findViewById(R.id.imb_1);
        imb_2=findViewById(R.id.imb_2);
        toolbar=findViewById(R.id.Tlfagui);
        //toolbar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        laws_vat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(train_laws.this,train_statute.class);
                startActivity(intent);
            }
        });
        imb_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(train_laws.this,train_statute.class);
                startActivity(intent);
            }
        });
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://eur-lex.europa.eu/homepage.html");
    }
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
    //toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}