package zjc.edu.util;

import android.os.AsyncTask;
import android.webkit.WebView;

public class LoadUrlTask extends AsyncTask<String, Void, String> {
    private WebView webView;

    public LoadUrlTask(WebView webView) {
        this.webView = webView;
    }

    @Override
    protected String doInBackground(String... urls) {
        String url = urls[0];
        // 在这里执行网络请求，获取网页内容
        // 返回网页内容给onPostExecute()方法
        return getWebPageContent(url);
    }

    @Override
    protected void onPostExecute(String pageContent) {
        super.onPostExecute(pageContent);
        // 在这里更新WebView
        webView.loadData(pageContent, "text/html", "UTF-8");
    }

    private String getWebPageContent(String url) {
        // 执行网络请求，获取网页内容的代码
        // 返回网页内容的字符串
        // 请根据你自己的需求实现这个方法
        return "";
    }
}
