package zjc.edu.model.EPR;

import androidx.lifecycle.ViewModel;

public class SharedEPRViewModel extends ViewModel {
    int eprserviceid;
    String companyname;
    String registrationnumber;
    String country;
    String servicetype;
    int servicesummit;

    public int getEprserviceid() {
        return eprserviceid;
    }

    public void setEprserviceid(int eprserviceid) {
        this.eprserviceid = eprserviceid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getRegistrationnumber() {
        return registrationnumber;
    }

    public void setRegistrationnumber(String registrationnumber) {
        this.registrationnumber = registrationnumber;
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

    public int getServicesummit() {
        return servicesummit;
    }

    public void setServicesummit(int servicesummit) {
        this.servicesummit = servicesummit;
    }
}
