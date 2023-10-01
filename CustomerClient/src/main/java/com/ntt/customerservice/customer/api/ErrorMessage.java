package com.ntt.customerservice.customer.api;

import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;



/**
 * Class that defines the format of REST errors.
 *
 */
@Getter
@Setter
@Builder
public class ErrorMessage {
  private String code;
  private List<Map<String, String>> messages;
}
