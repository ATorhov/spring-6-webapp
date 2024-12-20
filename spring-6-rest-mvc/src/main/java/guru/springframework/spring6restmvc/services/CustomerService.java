package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> listCustomers();
}
