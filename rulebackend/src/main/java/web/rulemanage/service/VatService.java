package web.rulemanage.service;

import web.rulemanage.common.VatObligationsRequest;
import web.rulemanage.common.VatObligationsResponse;

public interface VatService {
    VatObligationsResponse retrieveVatObligations(String vatNumber, VatObligationsRequest request);
}
