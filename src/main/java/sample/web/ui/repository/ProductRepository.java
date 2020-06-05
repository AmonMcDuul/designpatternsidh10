package sample.web.ui.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sample.web.ui.domain.Product;

@RepositoryRestResource
public interface ProductRepository extends CrudRepository<Product, Long> {

}