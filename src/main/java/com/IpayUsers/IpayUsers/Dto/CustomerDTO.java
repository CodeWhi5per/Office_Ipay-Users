package com.IpayUsers.IpayUsers.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {
    private int id;
    private String name;
    private String mobile;
    private String email;
    private String status;
}
