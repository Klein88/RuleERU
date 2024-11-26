package zjc.edu.model.EPR;

public class PackagingSummaryDeclaration {
        int summaryid;
        String registrationcode;
        int declarationyear;
        String brandname;
        int declarationdataserialnumber;
        String packagingmaterial;
        float predeclaredweight;
        float actualpackagingweight;
        int eprdeclarationid;

    public int getSummaryid() {
        return summaryid;
    }

    public void setSummaryid(int summaryid) {
        this.summaryid = summaryid;
    }

    public String getRegistrationcode() {
        return registrationcode;
    }

    public void setRegistrationcode(String registrationcode) {
        this.registrationcode = registrationcode;
    }

    public int getDeclarationyear() {
        return declarationyear;
    }

    public void setDeclarationyear(int declarationyear) {
        this.declarationyear = declarationyear;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public int getDeclarationdataserialnumber() {
        return declarationdataserialnumber;
    }

    public void setDeclarationdataserialnumber(int declarationdataserialnumber) {
        this.declarationdataserialnumber = declarationdataserialnumber;
    }

    public String getPackagingmaterial() {
        return packagingmaterial;
    }

    public void setPackagingmaterial(String packagingmaterial) {
        this.packagingmaterial = packagingmaterial;
    }

    public float getPredeclaredweight() {
        return predeclaredweight;
    }

    public void setPredeclaredweight(float predeclaredweight) {
        this.predeclaredweight = predeclaredweight;
    }

    public float getActualpackagingweight() {
        return actualpackagingweight;
    }

    public void setActualpackagingweight(float actualpackagingweight) {
        this.actualpackagingweight = actualpackagingweight;
    }

    public int getEprdeclarationid() {
        return eprdeclarationid;
    }

    public void setEprdeclarationid(int eprdeclarationid) {
        this.eprdeclarationid = eprdeclarationid;
    }
}
