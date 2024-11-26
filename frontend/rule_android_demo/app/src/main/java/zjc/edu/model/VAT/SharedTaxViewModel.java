package zjc.edu.model.VAT;

import androidx.lifecycle.ViewModel;

public class SharedTaxViewModel extends ViewModel {
    int declarationid;
    String vatnumber;
    float taxrate;
    String taxnumbereffectivedate;
    String lastdeclarationdate;
    String gatewayid;
    String gatewaypassword;
    String lastreporteddate;
    String mtdusername;
    String mtdpassword;
    String companyregistrationlocation;
    String companyname;
    String businesslicensenumber;
    String companyestablishmentdate;
    String companyoperationaladdress;
    String postalcode;
    String companyphonenumber;
    String companycontactemail;
    String legalrepresentativename;
    String mainsalesplatform;
    String shopname;
    String informationlink;
    String shopbackendselleraddress;
    String shopbackendcompanyname;
    String mainbusinessscope;
    byte[] vatcertificate;
    byte[] vatdeclarationdocument;
    byte[] proxycommitmentdocument;
    byte[] companyregistrationproof;
    byte[] idcardfront;
    byte[] idcardback;
    byte[] signature;

    public int getDeclarationid() {
        return declarationid;
    }

    public void setDeclarationid(int declarationid) {
        this.declarationid = declarationid;
    }

    public String getVatnumber() {
        return vatnumber;
    }

    public void setVatnumber(String vatnumber) {
        this.vatnumber = vatnumber;
    }

    public float getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(float taxrate) {
        this.taxrate = taxrate;
    }

    public String getTaxnumbereffectivedate() {
        return taxnumbereffectivedate;
    }

    public void setTaxnumbereffectivedate(String taxnumbereffectivedate) {
        this.taxnumbereffectivedate = taxnumbereffectivedate;
    }

    public String getLastdeclarationdate() {
        return lastdeclarationdate;
    }

    public void setLastdeclarationdate(String lastdeclarationdate) {
        this.lastdeclarationdate = lastdeclarationdate;
    }

    public String getGatewayid() {
        return gatewayid;
    }

    public void setGatewayid(String gatewayid) {
        this.gatewayid = gatewayid;
    }

    public String getGatewaypassword() {
        return gatewaypassword;
    }

    public void setGatewaypassword(String gatewaypassword) {
        this.gatewaypassword = gatewaypassword;
    }

    public String getLastreporteddate() {
        return lastreporteddate;
    }

    public void setLastreporteddate(String lastreporteddate) {
        this.lastreporteddate = lastreporteddate;
    }

    public String getMtdusername() {
        return mtdusername;
    }

    public void setMtdusername(String mtdusername) {
        this.mtdusername = mtdusername;
    }

    public String getMtdpassword() {
        return mtdpassword;
    }

    public void setMtdpassword(String mtdpassword) {
        this.mtdpassword = mtdpassword;
    }

    public String getCompanyregistrationlocation() {
        return companyregistrationlocation;
    }

    public void setCompanyregistrationlocation(String companyregistrationlocation) {
        this.companyregistrationlocation = companyregistrationlocation;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getBusinesslicensenumber() {
        return businesslicensenumber;
    }

    public void setBusinesslicensenumber(String businesslicensenumber) {
        this.businesslicensenumber = businesslicensenumber;
    }

    public String getCompanyestablishmentdate() {
        return companyestablishmentdate;
    }

    public void setCompanyestablishmentdate(String companyestablishmentdate) {
        this.companyestablishmentdate = companyestablishmentdate;
    }

    public String getCompanyoperationaladdress() {
        return companyoperationaladdress;
    }

    public void setCompanyoperationaladdress(String companyoperationaladdress) {
        this.companyoperationaladdress = companyoperationaladdress;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCompanyphonenumber() {
        return companyphonenumber;
    }

    public void setCompanyphonenumber(String companyphonenumber) {
        this.companyphonenumber = companyphonenumber;
    }

    public String getCompanycontactemail() {
        return companycontactemail;
    }

    public void setCompanycontactemail(String companycontactemail) {
        this.companycontactemail = companycontactemail;
    }

    public String getLegalrepresentativename() {
        return legalrepresentativename;
    }

    public void setLegalrepresentativename(String legalrepresentativename) {
        this.legalrepresentativename = legalrepresentativename;
    }

    public String getMainsalesplatform() {
        return mainsalesplatform;
    }

    public void setMainsalesplatform(String mainsalesplatform) {
        this.mainsalesplatform = mainsalesplatform;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getInformationlink() {
        return informationlink;
    }

    public void setInformationlink(String informationlink) {
        this.informationlink = informationlink;
    }

    public String getShopbackendselleraddress() {
        return shopbackendselleraddress;
    }

    public void setShopbackendselleraddress(String shopbackendselleraddress) {
        this.shopbackendselleraddress = shopbackendselleraddress;
    }

    public String getShopbackendcompanyname() {
        return shopbackendcompanyname;
    }

    public void setShopbackendcompanyname(String shopbackendcompanyname) {
        this.shopbackendcompanyname = shopbackendcompanyname;
    }

    public String getMainbusinessscope() {
        return mainbusinessscope;
    }

    public void setMainbusinessscope(String mainbusinessscope) {
        this.mainbusinessscope = mainbusinessscope;
    }

    public byte[] getVatcertificate() {
        return vatcertificate;
    }

    public void setVatcertificate(byte[] vatcertificate) {
        this.vatcertificate = vatcertificate;
    }

    public byte[] getVatdeclarationdocument() {
        return vatdeclarationdocument;
    }

    public void setVatdeclarationdocument(byte[] vatdeclarationdocument) {
        this.vatdeclarationdocument = vatdeclarationdocument;
    }

    public byte[] getProxycommitmentdocument() {
        return proxycommitmentdocument;
    }

    public void setProxycommitmentdocument(byte[] proxycommitmentdocument) {
        this.proxycommitmentdocument = proxycommitmentdocument;
    }

    public byte[] getCompanyregistrationproof() {
        return companyregistrationproof;
    }

    public void setCompanyregistrationproof(byte[] companyregistrationproof) {
        this.companyregistrationproof = companyregistrationproof;
    }

    public byte[] getIdcardfront() {
        return idcardfront;
    }

    public void setIdcardfront(byte[] idcardfront) {
        this.idcardfront = idcardfront;
    }

    public byte[] getIdcardback() {
        return idcardback;
    }

    public void setIdcardback(byte[] idcardback) {
        this.idcardback = idcardback;
    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }
}
