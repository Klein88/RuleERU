package web.rulemanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.common.VatCheckResponse;
import web.rulemanage.service.VatCheckService;

import java.util.Map;

@RestController
@RequestMapping("/vat-check")
public class VatCheckController {

    private final VatCheckService vatCheckService;

    @Autowired
    public VatCheckController(VatCheckService vatCheckService) {
        this.vatCheckService = vatCheckService;
    }

    @GetMapping("/lookup/{vatNumber}")
    public ResponseEntity<VatCheckResponse> lookupVatNumber(@PathVariable String vatNumber) {
        VatCheckResponse response = vatCheckService.checkVatNumber(vatNumber);
        return ResponseEntity.status(response.isValid() ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .body(response);
    }
}
