package web.rulemanage.service;

import web.rulemanage.common.VatCheckResponse;

public interface VatCheckService {
    VatCheckResponse checkVatNumber(String vatNumber);
}
