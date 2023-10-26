package com.IpayUsers.IpayUsers.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Merchant_Bank_Account {
    @Id
    private int Account_Number;
    private String status;
    private String is_default;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_Account_Number", referencedColumnName = "Account_Number")
    private List<Merchant> merchant;
}
