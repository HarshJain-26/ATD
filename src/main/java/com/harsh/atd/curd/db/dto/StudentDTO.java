package com.harsh.atd.curd.db.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StudentDTO {

    @NotBlank(message = "Name should not be blank")
    private String studentName;

    @NotBlank(message = "Email should not be blank")
    @Email(message = "Enter the valid email")
    private String studentEmail;

    @NotBlank(message = "Number should not be blank")
    @Size(min = 10, max = 10, message = "Enter the valid number")
    private String studentNo;

    @Valid
    private AddressDTO address;
}
