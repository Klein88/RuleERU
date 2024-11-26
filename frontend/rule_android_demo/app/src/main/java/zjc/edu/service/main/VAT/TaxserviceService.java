package zjc.edu.service.main.VAT;

public interface TaxserviceService {
    public void findAllTaxService();
    public void findAllMainTaxService();
    public void findTaxServicByvatnumber(String vatnumber);
    public void addTaxService(String value);
}
