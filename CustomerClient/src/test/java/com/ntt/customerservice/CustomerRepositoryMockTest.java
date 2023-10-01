package com.ntt.customerservice;

import com.ntt.customerservice.customer.domain.model.entity.BusinessCustomer;
import com.ntt.customerservice.customer.domain.model.entity.Customer;
import com.ntt.customerservice.customer.domain.model.entity.CustomerType;
import com.ntt.customerservice.customer.domain.model.entity.PersonalCustomer;
import com.ntt.customerservice.customer.domain.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import java.time.LocalDate;

@DataJpaTest
public class CustomerRepositoryMockTest {
  @Autowired
  private CustomerRepository customerRepository;

  @Test
  public void whenFindByCustomerType_thenReturnListCustomer(){
    PersonalCustomer personalCustomer = PersonalCustomer.builder()
        .email("emilio@test.com")
        .address("123 Evergreen")
        .phoneNumber("947220067")
        .status("ACTIVE")
        .customerType(CustomerType.personal)
        .firstName("Emilio")
        .lastName("Valdivia")
        .documentNumber("71892794")
        .dateOfBirth(LocalDate.of(2001, 3, 26))
        .build();
    customerRepository.save(personalCustomer);
    BusinessCustomer businessCustomer = BusinessCustomer.builder()
        .email("empresa@test.com")
        .address("321 Business")
        .phoneNumber("999888999")
        .status("ACTIVE")
        .customerType(CustomerType.business)
        .businessName("Big Business")
        .ruc("77777777777")
        .foundationDate(LocalDate.of(1980, 3, 26))
        .build();
    customerRepository.save(businessCustomer);

    List<Customer> foundsPersonal = customerRepository.findByCustomerType(CustomerType.personal);
    List<Customer> foundsBusiness = customerRepository.findByCustomerType(CustomerType.business);

    Assertions.assertThat(foundsPersonal.size()).isEqualTo(3);
    Assertions.assertThat(foundsBusiness.size()).isEqualTo(3);
  }


  @Test
  public void whenFindByRuc_thenReturnBusinessCustomer() {
    BusinessCustomer businessCustomer = BusinessCustomer.builder()
        .email("empresa@test.com")
        .address("321 Business")
        .phoneNumber("999888999")
        .status("ACTIVE")
        .customerType(CustomerType.business)
        .businessName("Big Business")
        .ruc("77777777777")
        .foundationDate(LocalDate.of(1980, 3, 26))
        .build();
    customerRepository.save(businessCustomer);
    BusinessCustomer found = customerRepository.findByRuc("77777777777");
    Assertions.assertThat(found.getBusinessName()).isEqualTo("Big Business");
  }
  @Test
  public void whenFindByDocumentNumber_thenReturnPersonalCustomer(){
    PersonalCustomer personalCustomer = PersonalCustomer.builder()
        .email("emilio@test.com")
        .address("123 Evergreen")
        .phoneNumber("947220067")
        .status("ACTIVE")
        .customerType(CustomerType.personal)
        .firstName("Emilio")
        .lastName("Valdivia")
        .documentNumber("71892794")
        .dateOfBirth(LocalDate.of(2001, 3, 26))
        .build();
    customerRepository.save(personalCustomer);
    PersonalCustomer found = customerRepository.findByDocumentNumber("71892794");
    Assertions.assertThat(found.getFirstName()).isEqualTo("Emilio");
  }
}
