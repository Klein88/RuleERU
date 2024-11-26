package zjc.edu.model.VAT;

import androidx.lifecycle.ViewModel;

public class SharedVATViewModel extends ViewModel {
    int taxserviceid;
    String taxtype;
    String country;
    String servicetype;
    String companyname;
    String vatnumber;
    String serviceprogress;
    float taxrate;
    int servicesummit;

    public int getTaxserviceid() {
        return taxserviceid;
    }

    public void setTaxserviceid(int taxserviceid) {
        this.taxserviceid = taxserviceid;
    }

    public String getTaxtype() {
        return taxtype;
    }

    public void setTaxtype(String taxtype) {
        this.taxtype = taxtype;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getServicetype() {
        return servicetype;
    }

    public void setServicetype(String servicetype) {
        this.servicetype = servicetype;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getVatnumber() {
        return vatnumber;
    }

    public void setVatnumber(String vatnumber) {
        this.vatnumber = vatnumber;
    }

    public String getServiceprogress() {
        return serviceprogress;
    }

    public void setServiceprogress(String serviceprogress) {
        this.serviceprogress = serviceprogress;
    }

    public float getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(float taxrate) {
        this.taxrate = taxrate;
    }

    public int getServicesummit(int i) {
        return servicesummit;
    }

    public void setServicesummit(int servicesummit) {
        this.servicesummit = servicesummit;
    }
}
