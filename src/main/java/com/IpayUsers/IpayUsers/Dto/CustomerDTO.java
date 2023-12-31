package com.IpayUsers.IpayUsers.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {
    private String name;
    private int mobile;
    private String email;
    private String status;
    private List<CustomerBankAccountDTO> bankAccounts;
}
