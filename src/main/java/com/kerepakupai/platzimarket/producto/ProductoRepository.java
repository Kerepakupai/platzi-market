package com.kerepakupai.platzimarket.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    private final ProductoCrudRepository productoCrudRepository;
    private final ProductMapper mapper;

    @Autowired
    public ProductoRepository(ProductoCrudRepository productoCrudRepository, ProductMapper mapper) {
        this.productoCrudRepository = productoCrudRepository;
        this.mapper = mapper;
    }

    /*public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    public List<Producto> getProductosByCategoria(int idCategoria) {
        return productoRepository.findProductoByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getProductosEscasos(int cantidadStock) {
        return productoRepository.findProductoByCantidadStockLessThanAndEstado(cantidadStock, true);
    }

    public Optional<Producto> getProductoById(int idProducto) {
        return productoRepository.findById(idProducto);
    }

    public Producto addNewProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteProducto(int idProducto) {
        productoRepository.deleteById(idProducto);
    }
*/
    @Override
    public List<Product> getProducts() {
        List<Producto> productos = productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getProductsByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findProductoByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarceProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findProductoByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product addNewProduct(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void deleteProduct(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}
