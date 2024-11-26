package web.rulemanage.service;

public interface HMRCService {
    String getInitialAccessToken();
    String createTestUser(String accessToken);
    String getAccessTokenWithAuthorizationCode(String authorizationCode);
    String getVATInformation(String accessToken, String vrn);
    String getVATObligations(String accessToken, String vrn, String from, String to);
    String submitVATReturns(String accessToken, String vrn, String requestBody);
    String getFinancialDetails(String accessToken, String vrn, String penaltyChargeReference);
}


