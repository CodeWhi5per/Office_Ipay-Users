package com.IpayUsers.IpayUsers.Dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {
    @Id
    private int id;
    private String name;
    private String mobile;
    private String email;
    private String status;
}
