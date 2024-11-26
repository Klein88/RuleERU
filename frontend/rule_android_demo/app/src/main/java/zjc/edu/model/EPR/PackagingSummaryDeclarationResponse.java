package zjc.edu.model.EPR;

import zjc.edu.model.VAT.TaxPayment;

public class PackagingSummaryDeclarationResponse {
    int code;
    PackagingSummaryDeclaration[] data;
    String message;
    String description;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public PackagingSummaryDeclaration[] getData() {
        return data;
    }

    public void setData(PackagingSummaryDeclaration[] data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
