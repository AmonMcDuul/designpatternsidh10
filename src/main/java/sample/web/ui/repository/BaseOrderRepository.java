package sample.web.ui.repository;

import org.springframework.data.repository.CrudRepository;

import sample.web.ui.domain.BaseOrder;

public interface BaseOrderRepository<T extends BaseOrder>  extends CrudRepository<T, Long> {

}