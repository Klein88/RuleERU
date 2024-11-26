package zjc.edu.model.VAT;

public class TaxPayment {
    int taxpaymentid;
    String companyname;
    String country;
    String vatnumber;
    String declarationtype;
    float amountdue;
    String currency;
    String declarationcycle;
    String declarationperiod;
    String duedate;
    int paymentstatus;

    public int getTaxpaymentid() {
        return taxpaymentid;
    }

    public void setTaxpaymentid(int taxpaymentid) {
        this.taxpaymentid = taxpaymentid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
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

    public float getAmountdue() {
        return amountdue;
    }

    public void setAmountdue(float amountdue) {
        this.amountdue = amountdue;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDeclarationcycle() {
        return declarationcycle;
    }

    public void setDeclarationcycle(String declarationcycle) {
        this.declarationcycle = declarationcycle;
    }

    public String getDeclarationperiod() {
        return declarationperiod;
    }

    public void setDeclarationperiod(String declarationperiod) {
        this.declarationperiod = declarationperiod;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public int getPaymentstatus() {
        return paymentstatus;
    }

    public void setPaymentstatus(int paymentstatus) {
        this.paymentstatus = paymentstatus;
    }
}
