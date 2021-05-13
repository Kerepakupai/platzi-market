package com.kerepakupai.platzimarket.compra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("")
    public ResponseEntity<List<Purchase>> getPurchases() {
        return new ResponseEntity<>(purchaseService.getPurchases(), HttpStatus.OK);
    }

    @GetMapping("/client/{idClient}")
    public ResponseEntity<List<Purchase>> getPurchasesByClient(@PathVariable("idClient") String clientId) {
        return purchaseService.getPurchasesByClient(clientId)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public ResponseEntity<Purchase> addNewPurchase(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.addNewPurchase(purchase), HttpStatus.CREATED);
    }
}
