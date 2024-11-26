package web.rulemanage.service;

public interface DialogflowService {
    String getAccessToken();
    String sendRequestToDialogflow(String message);
}
