package com.ntt.customerService.customer.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * Class that defines the format of REST errors.
 *
 */
@Getter
@Setter
@Builder
public class ErrorMessage {
    private String code;
    private List<Map<String,String>> messages;
}
