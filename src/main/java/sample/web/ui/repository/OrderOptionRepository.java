package sample.web.ui.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sample.web.ui.domain.OrderOption;

public interface OrderOptionRepository extends CrudRepository<OrderOption, Long> {
}
