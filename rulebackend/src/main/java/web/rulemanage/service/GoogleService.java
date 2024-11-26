package web.rulemanage.service;

public interface GoogleService {
    String getAccessToken(String authorizationCode);
    String detectIntent(String accessToken, String sessionId, String text, String languageCode, String timeZone);
}
