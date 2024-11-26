package zjc.edu.view.activity.Learn;

import androidx.appcompat.app.AppCompatActivity;

import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import zjc.edu.R;
import zjc.edu.util.LoadUrlTask;

public class train_market extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_market);
        webView=findViewById(R.id.market_webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                // 忽略 SSL 错误，强行加载网页
                handler.proceed();
            }
        });
        webView.loadUrl("https://www.gov.uk/government/organisations/hm-revenue-customs");
//        String url = "https://www.gov.uk/government/organisations/hm-revenue-customs";
//        LoadUrlTask loadUrlTask = new LoadUrlTask(webView);
//        loadUrlTask.execute(url);
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