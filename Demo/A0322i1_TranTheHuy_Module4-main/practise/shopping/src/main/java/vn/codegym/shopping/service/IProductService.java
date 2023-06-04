package vn.codegym.shopping.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.shopping.model.Product;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    Product findById(Integer id);
}
