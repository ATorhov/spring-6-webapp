package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

private Map<UUID, CustomerDTO> customers;

public CustomerServiceImpl() {
    customers = new HashMap<>();

    CustomerDTO customer1 = CustomerDTO.builder()
            .id(UUID.randomUUID())
            .firstName("John")
            .lastName("Doe")
            .address("Shitty street, 15")
            .state("TX")
            .zip("1563")
            .phone("25636985")
            .city("Austin")
            .email("JohnDoe@gmail.com")
            .dateOfBirth(LocalDate.of(1986, 12, 6))
            .version(1)
            .build();

    CustomerDTO customer2 = CustomerDTO.builder()
            .id(UUID.randomUUID())
            .firstName("Jane")
            .lastName("Smith")
            .address("Sunny Lane, 24")
            .state("CA")
            .zip("90210")
            .phone("987654321")
            .city("Los Angeles")
            .email("JaneSmith@gmail.com")
            .dateOfBirth(LocalDate.of(1990, 3, 14))
            .version(1)
            .build();

    CustomerDTO customer3 = CustomerDTO.builder()
            .id(UUID.randomUUID())
            .firstName("Robert")
            .lastName("Johnson")
            .address("Broadway Avenue, 48")
            .state("NY")
            .zip("10036")
            .phone("123456789")
            .city("New York")
            .email("RobertJohnson@gmail.com")
            .dateOfBirth(LocalDate.of(1982, 7, 23))
            .version(1)
            .build();

    CustomerDTO customer4 = CustomerDTO.builder()
            .id(UUID.randomUUID())
            .firstName("Emily")
            .lastName("Davis")
            .address("Elm Street, 10")
            .state("IL")
            .zip("60605")
            .phone("654987321")
            .city("Chicago")
            .email("EmilyDavis@gmail.com")
            .dateOfBirth(LocalDate.of(1995, 11, 30))
            .version(1)
            .build();

    CustomerDTO customer5 = CustomerDTO.builder()
            .id(UUID.randomUUID())
            .firstName("Michael")
            .lastName("Brown")
            .address("Maple Road, 77")
            .state("FL")
            .zip("33101")
            .phone("789123456")
            .city("Miami")
            .email("MichaelBrown@gmail.com")
            .dateOfBirth(LocalDate.of(1988, 4, 18))
            .version(1)
            .build();

    customers.put(customer1.getId(), customer1);
    customers.put(customer2.getId(), customer2);
    customers.put(customer3.getId(), customer3);
    customers.put(customer4.getId(), customer4);
    customers.put(customer5.getId(), customer5);
}


    @Override
    public List<CustomerDTO> listCustomers() {
        return new ArrayList<>(customers.values());
    }
}
