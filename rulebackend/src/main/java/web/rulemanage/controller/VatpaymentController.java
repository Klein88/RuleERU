package web.rulemanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.domain.Vatpayment;
import web.rulemanage.service.VatpaymentService;

@RestController
@RequestMapping("/api/vat-payments")
public class VatpaymentController {

    @Autowired
    private VatpaymentService vatpaymentService;

    // 提交VAT付款信息
    @PostMapping
    public ResponseEntity<?> submitPayment(@RequestBody Vatpayment payment) {
        Vatpayment savedPayment = vatpaymentService.submitPayment(payment);
        if (savedPayment != null) {
            return ResponseEntity.ok(savedPayment);
        } else {
            return ResponseEntity.badRequest().body("Invalid payment information.");
        }
    }

    // 获取特定VAT付款的信息
    @GetMapping("/{paymentId}")
    public ResponseEntity<?> getPayment(@PathVariable String paymentId) {
        Vatpayment payment = vatpaymentService.getPaymentById(paymentId);
        if (payment != null) {
            return ResponseEntity.ok(payment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 更新VAT付款的状态或信息
    @PutMapping("/{paymentId}")
    public ResponseEntity<?> updatePayment(@PathVariable String paymentId, @RequestBody Vatpayment updatedPayment) {
        boolean isUpdated = vatpaymentService.updatePayment(paymentId, updatedPayment);
        if (isUpdated) {
            return ResponseEntity.ok("Payment information updated successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to update payment information.");
        }
    }
}