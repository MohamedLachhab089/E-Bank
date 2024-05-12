package ma.med.ebanking.services;

import ma.med.ebanking.dtos.*;
import ma.med.ebanking.entites.BankAccount;
import ma.med.ebanking.entites.CurrentAccount;
import ma.med.ebanking.entites.Customer;
import ma.med.ebanking.entites.SavingAccount;
import ma.med.ebanking.exceptions.BalanceNotSufficientException;
import ma.med.ebanking.exceptions.BankAccountNotFoundException;
import ma.med.ebanking.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    CurrentBankAccountDTO saveCurrentBankAccount(Long customerId, double overDraft, double initialBalance) throws CustomerNotFoundException;

    SavingBankAccountDTO saveSavingBankAccount(Long customerId, double interestRate, double initialBalance) throws CustomerNotFoundException;

    List<CustomerDTO> listCustomers();

    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;

    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;

    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;

    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;

    List<BankAccountDTO> bankAccountList();

    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperationDTO> accountHistory(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;

    List<CustomerDTO> searchCustomers(String keyword);
}
