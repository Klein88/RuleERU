package web.rulemanage.common;

public class ContentCheckResponse {
    private boolean isAcceptable;

    // Constructor
    public ContentCheckResponse(boolean isAcceptable) {
        this.isAcceptable = isAcceptable;
    }

    // Getters
    public boolean isAcceptable() {
        return isAcceptable;
    }
}
