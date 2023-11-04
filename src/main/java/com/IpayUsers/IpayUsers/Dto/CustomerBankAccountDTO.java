package com.IpayUsers.IpayUsers.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerBankAccountDTO {
    private int accountNumber;
    private String status;
    private boolean isDefault;
}
