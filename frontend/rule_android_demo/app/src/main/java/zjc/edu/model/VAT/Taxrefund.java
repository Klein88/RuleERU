package zjc.edu.model.VAT;

public class Taxrefund {
    int taxrefundid;
    String country;
    String vatnumber;
    String declarationtype;
    String declarationcycle;
    String declarationdate;
    float refundamount;
    int operation;

    public int getTaxrefundid() {
        return taxrefundid;
    }

    public void setTaxrefundid(int taxrefundid) {
        this.taxrefundid = taxrefundid;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVatnumber() {
        return vatnumber;
    }

    public void setVatnumber(String vatnumber) {
        this.vatnumber = vatnumber;
    }

    public String getDeclarationtype() {
        return declarationtype;
    }

    public void setDeclarationtype(String declarationtype) {
        this.declarationtype = declarationtype;
    }

    public String getDeclarationcycle() {
        return declarationcycle;
    }

    public void setDeclarationcycle(String declarationcycle) {
        this.declarationcycle = declarationcycle;
    }

    public String getDeclarationdate() {
        return declarationdate;
    }

    public void setDeclarationdate(String declarationdate) {
        this.declarationdate = declarationdate;
    }

    public float getRefundamount() {
        return refundamount;
    }

    public void setRefundamount(float refundamount) {
        this.refundamount = refundamount;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }
}
