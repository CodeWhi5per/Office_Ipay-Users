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
public class Merchant {
    @Id
    private int id;
    private String catagory;
    private String code;


    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
