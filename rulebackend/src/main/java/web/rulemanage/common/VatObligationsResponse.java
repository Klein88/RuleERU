package web.rulemanage.common;

import java.util.List;

public class VatObligationsResponse {
    private List<VatObligation> obligations;
    private String errorCode;
    private String errorMessage;

    // 正常情况下使用的构造器
    public VatObligationsResponse(List<VatObligation> obligations) {
        this.obligations = obligations;
    }

    // 错误情况下使用的构造器
    public VatObligationsResponse(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public static class VatObligation {

        private String periodKey;
        private String start;
        private String end;
        private String due;
        private String status;
        private String received;
        public String getPeriodKey() {
            return periodKey;
        }

        public void setPeriodKey(String periodKey) {
            this.periodKey = periodKey;
        }

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public String getDue() {
            return due;
        }

        public void setDue(String due) {
            this.due = due;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getReceived() {
            return received;
        }

        public void setReceived(String received) {
            this.received = received;
        }


    }

    public List<VatObligation> getObligations() {
        return obligations;
    }

    public void setObligations(List<VatObligation> obligations) {
        this.obligations = obligations;
    }

}
