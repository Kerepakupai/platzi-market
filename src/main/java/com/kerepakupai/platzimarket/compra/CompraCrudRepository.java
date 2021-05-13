package com.kerepakupai.platzimarket.compra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompraCrudRepository extends JpaRepository<Compra, Integer> {
    Optional<List<Compra>> findByIdCliente(String idCliente);
}
