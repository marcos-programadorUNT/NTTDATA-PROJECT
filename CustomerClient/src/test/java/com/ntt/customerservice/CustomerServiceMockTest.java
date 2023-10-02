package com.ntt.customerservice;

import com.ntt.customerservice.customer.domain.dto.CustomerDto;
import com.ntt.customerservice.customer.domain.model.entity.BusinessCustomer;
import com.ntt.customerservice.customer.domain.model.entity.Customer;
import com.ntt.customerservice.customer.domain.model.entity.CustomerType;
import com.ntt.customerservice.customer.domain.model.entity.PersonalCustomer;
import com.ntt.customerservice.customer.domain.repository.CustomerRepository;
import com.ntt.customerservice.customer.domain.service.CustomerService;
import com.ntt.customerservice.service.CustomerServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CustomerServiceMockTest {

  @Mock
  private CustomerRepository customerRepository;

  private CustomerService customerService;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    customerService = new CustomerServiceImpl(customerRepository);
    List<Customer> mockCustomers = new ArrayList<>();
    PersonalCustomer personalCustomer = PersonalCustomer.builder()
        .id(1L)
        .email("emilio@test.com")
        .address("123 Evergreen")
        .phoneNumber("947220067")
        .status("ACTIVE")
        .customerType(CustomerType.personal)
        .firstName("Emilio")
        .lastName("Valdivia")
        .documentNumber("22222222")
        .dateOfBirth(LocalDate.of(2001, 3, 26))
        .build();
    mockCustomers.add(personalCustomer);


    BusinessCustomer businessCustomer = BusinessCustomer.builder()
        .id(2L)
        .email("empresa@test.com")
        .address("321 Business")
        .phoneNumber("999888999")
        .status("ACTIVE")
        .customerType(CustomerType.business)
        .businessName("Big Business")
        .ruc("22222222222")
        .foundationDate(LocalDate.of(1980, 3, 26))
        .build();
    mockCustomers.add(personalCustomer);


    when(customerRepository.findAll()).thenReturn( mockCustomers );
    when(customerRepository.findById(1L)).thenReturn(Optional.ofNullable(personalCustomer));
    when(customerRepository.findById(2L)).thenReturn(Optional.ofNullable(businessCustomer));
    when(customerRepository.findByCustomerType(CustomerType.personal)).thenReturn(List.of(personalCustomer));
    when(customerRepository.findByCustomerType(CustomerType.business)).thenReturn(List.of(businessCustomer));
    when(customerRepository.findByDocumentNumber("22222222")).thenReturn(personalCustomer);
    when(customerRepository.findByRuc("77777777777")).thenReturn(businessCustomer);
  }

  @Test
  public void whenFindAllCustomer_thenReturnListCustomer() {
    List<Customer> founds = customerService.getAll();
    assertThat(founds.size()).isEqualTo(2);
  }

  @Test
  public void whenFindByCustomerType_thenReturnListCustomer() {
    List<Customer> foundsPersonal = customerService.getCustomersByType("personal");
    List<Customer> foundsBusiness = customerService.getCustomersByType("business");

    assertThat(foundsPersonal.size()).isEqualTo(1);
    assertThat(foundsBusiness.size()).isEqualTo(1);
  }

  @Test
  public void whenFindByDocumentNumber_thenReturnPersonalCustomer() {
    PersonalCustomer found = customerService.getCustomerByDocumentNumber("22222222");

    assertThat(found!=null).isTrue();
  }

  @Test
  public void whenFindByRuc_thenReturnBusinessCustomer() {
    BusinessCustomer found = customerService.getCustomerByRuc("77777777777");
    assertThat(found!=null).isTrue();
  }

  @Test
  public void whenFindById_thenReturnCustomer(){
    Customer found = customerService.getCustomerById(1L);
    Assertions.assertThat(found.getPhoneNumber()).isEqualTo("947220067");
  }

  @Test
  public void whenCreatePersonalCustomer_thenReturnPersonalCustomer() {
    PersonalCustomer personalCustomer = PersonalCustomer.builder()
        .email("newpersonal@test.com")
        .address("456 Oak")
        .phoneNumber("123456789")
        .status("ACTIVE")
        .customerType(CustomerType.personal)
        .firstName("New")
        .lastName("Personal")
        .documentNumber("98765432")
        .dateOfBirth(LocalDate.of(1990, 5, 10))
        .build();

    customerService.createPersonalCustomer(personalCustomer);
    verify(customerRepository, times(1)).save(personalCustomer);
  }

  @Test
  public void whenCreateBusinessCustomer_thenReturnBusinessCustomer() {
    BusinessCustomer businessCustomer = BusinessCustomer.builder()
        .email("newbusiness@test.com")
        .address("789 Maple")
        .phoneNumber("987654321")
        .status("ACTIVE")
        .customerType(CustomerType.business)
        .businessName("New Business")
        .ruc("12345678912")
        .foundationDate(LocalDate.of(2000, 8, 15))
        .build();

    customerService.createBusinessCustomer(businessCustomer);
    verify(customerRepository, times(1)).save(businessCustomer);
  }

  @Test
  public void whenUpdateCustomer_thenReturnCustomer() {
    CustomerDto updatedCustomerDto = new CustomerDto();
    updatedCustomerDto.setEmail("updated@test.com");
    updatedCustomerDto.setAddress("Updated Address");

    when(customerRepository.save(any(Customer.class))).thenAnswer(invocation -> invocation.getArgument(0));

    Customer updatedCustomer = customerService.updateCustomer(1L, updatedCustomerDto);

    assertThat(updatedCustomer.getEmail()).isEqualTo("updated@test.com");
    assertThat(updatedCustomer.getAddress()).isEqualTo("Updated Address");
  }

  @Test
  public void whenDeleteCustomer_thenReturnCustomer() {
    Long customerId = 1L;
    Customer customerDb = PersonalCustomer.builder()
        .id(customerId)
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

    when(customerRepository.findById(customerId)).thenReturn(Optional.of(customerDb));
    when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(customerDb);
    Customer deletedCustomer = customerService.deleteCustomer(customerId);
    assertNotNull(deletedCustomer);
    assertEquals("DELETED", deletedCustomer.getStatus());
    Mockito.verify(customerRepository, Mockito.times(1)).findById(customerId);
    Mockito.verify(customerRepository, Mockito.times(1)).save(Mockito.any(Customer.class));
  }

}
