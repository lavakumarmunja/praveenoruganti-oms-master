package com.praveen.oms.customer.errors;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class ErrorResponse {
	private String errorCode;
	private String errorMessage;
	private List<ErrorDetails> errors;
	private Date timestamp;

    @Data
    public static class ErrorDetails {
        private String fieldName;
        private String message;
    }

}
