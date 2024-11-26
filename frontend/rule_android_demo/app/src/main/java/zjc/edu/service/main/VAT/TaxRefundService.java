package zjc.edu.service.main.VAT;

public interface TaxRefundService {
    public void findAllTaxRefund();
    public void findTaxRefundByvatnumber(String vatnumber);
    public void updateTaxrefund(String value);
}
