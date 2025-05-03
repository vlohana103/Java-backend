package com.d288.vikas.bootstrap;

import com.d288.vikas.dao.CustomerRepository;
import com.d288.vikas.dao.DivisionRepository;
import com.d288.vikas.entities.Customer;
import com.d288.vikas.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        if(customerRepository.count() < 2){
            Division division = divisionRepository.getReferenceById(2L);
            Customer customer1 = new Customer("SpongeBob","SquarePants", "124 Conch Street", "12345", "987-836-2123", division);
            customerRepository.save(customer1);

            Customer customer2 = new Customer("Patrick","Star", "631 Star Street", "73283", "876-234-3453", division);
            customerRepository.save(customer2);

            Customer customer3 = new Customer("Scooby","Doo", "97 Scary Street", "47483", "238-543-2345", division);
            customerRepository.save(customer3);

            Customer customer4 = new Customer("Sheldon","Plankton", "123 Bucket Street", "38372", "373-382-0309", division);
            customerRepository.save(customer4);

            Customer customer5 = new Customer("Eugene","Krabs", "3541 Anchor Street", "23499", "291-382-9843", division);
            customerRepository.save(customer5);

        }

    }
}
