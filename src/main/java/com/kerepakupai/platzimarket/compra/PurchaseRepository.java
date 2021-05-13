package com.kerepakupai.platzimarket.compra;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getPurchases();
    Optional<List<Purchase>> getPurchasesByClient(String clientId);
    Purchase addNewPurchase(Purchase purchase);
}
