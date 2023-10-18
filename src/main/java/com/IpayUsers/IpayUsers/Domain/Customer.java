package com.IpayUsers.IpayUsers.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    @Id
    private int id;
    private String name;
    private String mobile;
    private String email;
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
