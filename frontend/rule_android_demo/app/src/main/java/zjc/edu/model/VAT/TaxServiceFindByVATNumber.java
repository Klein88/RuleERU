package zjc.edu.model.VAT;

public class TaxServiceFindByVATNumber {
    int code;
    TaxService[] data;
    String message;
    String description;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public TaxService[] getData() {
        return data;
    }

    public void setData(TaxService[] data) {
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
