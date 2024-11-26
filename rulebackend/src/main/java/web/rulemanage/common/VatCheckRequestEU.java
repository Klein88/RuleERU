package web.rulemanage.common;

public class VatCheckRequestEU {
    private String countryCode;
    private String vatNumber;
    private String requesterMemberStateCode;
    private String requesterNumber;
    private String traderName;
    private String traderStreet;
    private String traderPostalCode;
    private String traderCity;
    private String traderCompanyType;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getRequesterMemberStateCode() {
        return requesterMemberStateCode;
    }

    public void setRequesterMemberStateCode(String requesterMemberStateCode) {
        this.requesterMemberStateCode = requesterMemberStateCode;
    }

    public String getRequesterNumber() {
        return requesterNumber;
    }

    public void setRequesterNumber(String requesterNumber) {
        this.requesterNumber = requesterNumber;
    }

    public String getTraderName() {
        return traderName;
    }

    public void setTraderName(String traderName) {
        this.traderName = traderName;
    }

    public String getTraderStreet() {
        return traderStreet;
    }

    public void setTraderStreet(String traderStreet) {
        this.traderStreet = traderStreet;
    }

    public String getTraderPostalCode() {
        return traderPostalCode;
    }

    public void setTraderPostalCode(String traderPostalCode) {
        this.traderPostalCode = traderPostalCode;
    }

    public String getTraderCity() {
        return traderCity;
    }

    public void setTraderCity(String traderCity) {
        this.traderCity = traderCity;
    }

    public String getTraderCompanyType() {
        return traderCompanyType;
    }

    public void setTraderCompanyType(String traderCompanyType) {
        this.traderCompanyType = traderCompanyType;
    }
}
