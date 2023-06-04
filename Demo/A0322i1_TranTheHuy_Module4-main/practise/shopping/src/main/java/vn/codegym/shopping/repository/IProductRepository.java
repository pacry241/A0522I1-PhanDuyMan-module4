package vn.codegym.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.shopping.model.Product;

public interface IProductRepository extends JpaRepository<Product,Integer> {
}
