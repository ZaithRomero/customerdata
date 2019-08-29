package mx.zaith.springdata.product.repo;

import org.springframework.data.repository.CrudRepository;

import mx.zaith.springdata.product.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
