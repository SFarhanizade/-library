package repository;

import entity.Loan;

import java.util.List;

public interface LoanRepository {

    void save(Loan loan);

    Loan findById(int id);

    void update(Loan loan);

    List<Loan> findActiveLoans();

}
