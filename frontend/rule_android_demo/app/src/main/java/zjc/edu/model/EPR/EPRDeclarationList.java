package zjc.edu.model.EPR;

import zjc.edu.model.VAT.TaxPayment;

public class EPRDeclarationList {
    int code;
    EPRDeclaration[] data;
    String message;
    String description;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public EPRDeclaration[] getData() {
        return data;
    }

    public void setData(EPRDeclaration[] data) {
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
