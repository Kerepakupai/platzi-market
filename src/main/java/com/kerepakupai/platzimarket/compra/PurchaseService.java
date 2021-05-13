package com.kerepakupai.platzimarket.compra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public List<Purchase> getPurchases() {
        return purchaseRepository.getPurchases();
    }

    public Optional<List<Purchase>> getPurchasesByClient(String clientId) {
        return purchaseRepository.getPurchasesByClient(clientId);
    }

    public Purchase addNewPurchase(Purchase purchase) {
        return purchaseRepository.addNewPurchase(purchase);
    }
}
