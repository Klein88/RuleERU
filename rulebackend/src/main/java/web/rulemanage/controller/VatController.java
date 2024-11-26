package web.rulemanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.rulemanage.common.VatObligationsRequest;
import web.rulemanage.common.VatObligationsResponse;
import web.rulemanage.service.VatService;

@RestController
@RequestMapping("/vat")
public class VatController {

    private final VatService vatService;

    @Autowired
    public VatController(VatService vatService) {
        this.vatService = vatService;
    }

    @GetMapping("/{vatNumber}/obligations")
    public ResponseEntity<VatObligationsResponse> retrieveVatObligations(
            @PathVariable String vatNumber,
            VatObligationsRequest request) {
        VatObligationsResponse response = vatService.retrieveVatObligations(vatNumber, request);
        return ResponseEntity.ok(response);
    }
}
