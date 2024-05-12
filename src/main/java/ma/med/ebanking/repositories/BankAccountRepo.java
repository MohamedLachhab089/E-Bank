package ma.med.ebanking.repositories;

import ma.med.ebanking.entites.BankAccount;
import ma.med.ebanking.entites.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepo extends JpaRepository<BankAccount,String> {
    
}
