package web.rulemanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.rulemanage.common.VatCheckRequestEU;
import web.rulemanage.service.VatEUService;

@RestController
@RequestMapping("/vat-checkeu")
public class VatEUController {
    private final VatEUService vatEUService;


    @Autowired
    public VatEUController(VatEUService vatEUService) {
        this.vatEUService = vatEUService;
    }

    @PostMapping("/check")
    public ResponseEntity<String> checkVatNumberEU(@RequestBody VatCheckRequestEU request) {
        return vatEUService.checkVatNumberEU(request);
    }
}
