package zjc.edu.service.main.VAT;

public interface TaxDeclarationService {
    public void addTaxdeclaration(String taxDeclaration);
    public void findAllTaxdeclaration();
    public void findTaxDeclarationByVatNumber(String vatnumber);
}
