package com.example.lombook.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    String department;
    String message;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "FirstName is not valid")
    String firstName;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "LastName is not valid")
    String lastName;

    @NotNull(message = "Enter Gender")
    String gender;

    @Min(value = 10000, message = " Enter salary more than 10000")
    @Max(value = 90000, message = "Enter salary less than 90000")
    private Long salary;

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate joiningDate;

}