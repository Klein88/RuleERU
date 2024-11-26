package zjc.edu.model.VAT;

public class TaxPaymentList {
    int code;
    TaxPayment[] data;
    String message;
    String description;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public TaxPayment[] getData() {
        return data;
    }

    public void setData(TaxPayment[] data) {
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
