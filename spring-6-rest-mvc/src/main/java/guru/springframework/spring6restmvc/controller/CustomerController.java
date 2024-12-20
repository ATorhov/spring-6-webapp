package guru.springframework.spring6restmvc.controller;


import guru.springframework.spring6restmvc.model.CustomerDTO;
import guru.springframework.spring6restmvc.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers/")
public class CustomerController {

    private final CustomerService customerService;

    public static final String CUSTOMER_PATH =  "/api/v1/customers/";
    public static final String CUSTOMER_BY_ID_URL = "{customerId}";

    @RequestMapping(method = RequestMethod.GET)
    public List<CustomerDTO> getAllCustomers() {
        return customerService.listCustomers();
    }

}
