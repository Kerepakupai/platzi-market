package com.kerepakupai.platzimarket.producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoCrudRepository extends JpaRepository<Producto, Integer> {
    // @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    // @Query("SELECT p FROM Producto p WHERE p.idCategoria = ?1")
    List<Producto> findProductoByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findProductoByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
