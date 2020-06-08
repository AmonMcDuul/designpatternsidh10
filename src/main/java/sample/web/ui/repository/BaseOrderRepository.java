package sample.web.ui.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sample.web.ui.domain.BaseOrder;
import sample.web.ui.domain.Order;

@RepositoryRestResource(collectionResourceRel = "baseorders", path = "baseorders")
public interface BaseOrderRepository<T extends BaseOrder>  extends CrudRepository<Order, Long> {

}