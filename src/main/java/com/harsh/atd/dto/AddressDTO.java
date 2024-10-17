package com.harsh.atd.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddressDTO {
    @NotBlank(message = "State should not be blank")
    private String state;

    @NotBlank(message = "City should not be blank")
    private String city;

    @NotBlank(message = "Pincode should not be blank")
    @Size(min = 6, max = 6, message = "Enter the valid Pincode")
    private String pincode;
}
