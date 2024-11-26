package web.rulemanage.service;

import org.springframework.http.ResponseEntity;
import web.rulemanage.common.VatCheckRequestEU;

public interface VatEUService {
    ResponseEntity<String> checkVatNumberEU(VatCheckRequestEU requesteu);
}
