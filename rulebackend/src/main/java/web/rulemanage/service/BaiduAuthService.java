// BaiduAuthService.java

package web.rulemanage.service;

public interface BaiduAuthService {
    void refreshAccessToken();
    String getAccessToken();
}
