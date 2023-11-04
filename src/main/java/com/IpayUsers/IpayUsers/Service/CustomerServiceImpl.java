package com.IpayUsers.IpayUsers.Service;

import com.IpayUsers.IpayUsers.Dao.CustomerBankAccountDao;
import com.IpayUsers.IpayUsers.Dao.CustomerDao;
import com.IpayUsers.IpayUsers.Dao.CustomerStatusHistoryDao;
import com.IpayUsers.IpayUsers.Domain.Customer;
import com.IpayUsers.IpayUsers.Domain.CustomerStatusHistory;
import com.IpayUsers.IpayUsers.Domain.Customer_Bank_Account;
import com.IpayUsers.IpayUsers.Dto.CustomerBankAccountDTO;
import com.IpayUsers.IpayUsers.Dto.CustomerDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CustomerBankAccountDao customerBankAccountDao;

    @Autowired
    private CustomerStatusHistoryDao customerStatusHistoryDao;




    @Override
    public ResponseEntity<?> createCustomer(CustomerDTO customerDTO) {
        for (CustomerBankAccountDTO accountDTO : customerDTO.getBankAccounts()) {
            int accountNumber = accountDTO.getAccountNumber();
            Customer_Bank_Account existingAccount = customerBankAccountDao.findById(accountNumber).orElse(null);
            if (existingAccount != null) {
                return ResponseEntity.badRequest().body("Account Number " + accountNumber + " is already taken by a Customer");
            }
        }

        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setMobile(customerDTO.getMobile());
        customer.setEmail(customerDTO.getEmail());
        customer.setStatus(customerDTO.getStatus());

        List<Customer_Bank_Account> bankAccounts = new ArrayList<>();
        for (CustomerBankAccountDTO accountDTO : customerDTO.getBankAccounts()) {
            Customer_Bank_Account bankAccount = new Customer_Bank_Account();
            bankAccount.setAccountNumber(accountDTO.getAccountNumber());
            bankAccount.setStatus(accountDTO.getStatus());
            bankAccount.setDefault(accountDTO.isDefault());
            bankAccount.setCustomer(customer);
            bankAccounts.add(bankAccount);
        }
        customer.setBankAccounts(bankAccounts);

        customer = customerDao.save(customer);

        for (Customer_Bank_Account bankAccount : customer.getBankAccounts()) {
            customerBankAccountDao.save(bankAccount);
        }

        return ResponseEntity.ok("Customer created successfully");
    }







    @Override
    public ResponseEntity<?> getActiveBankAccountsByCustomerId(int customerId) {
        Customer customer = customerDao.findById(customerId).orElse(null);

        if (customer == null) {
            return ResponseEntity.badRequest().body("No customers in this ID.");
        }

        List<Customer_Bank_Account> activeBankAccounts = customer.getBankAccounts().stream()
                .filter(account -> "Active".equals(account.getStatus()))
                .collect(Collectors.toList());

        if (activeBankAccounts.isEmpty()) {
            return ResponseEntity.ok("No Active Accounts of this Customer");
        }

        return ResponseEntity.ok(activeBankAccounts);
    }






    @Override
    public ResponseEntity<?> updateCustomerStatus(int customerId, String newStatus, String remark) {
        Customer customer = customerDao.findById(customerId).orElse(null);

        if (customer == null) {
            return ResponseEntity.badRequest().body("No Customers In this ID");
        }

        System.out.println("newStatus: " + newStatus);
        System.out.println("customer.getStatus(): " + customer.getStatus());

        if (newStatus.equals(customer.getStatus())) {
            return ResponseEntity.badRequest().body("The Current Status Is same as You entered!");
        }
        else {

            CustomerStatusHistory statusHistory = new CustomerStatusHistory();
            statusHistory.setPreviousStatus(customer.getStatus());
            statusHistory.setCurrentStatus(newStatus);
            statusHistory.setRemark(remark);
            statusHistory.setDate(new Date());
            statusHistory.setCustomer(customer);

            customer.setStatus(newStatus);

            customerStatusHistoryDao.save(statusHistory);
            customerDao.save(customer);

            return ResponseEntity.ok("Customer status updated successfully");
        }
    }







    @Override
    public List<Customer>getCustomerByByStatus(String status){
        return customerDao.findByStatus(status);
    }
}
