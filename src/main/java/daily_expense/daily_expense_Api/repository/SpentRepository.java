package daily_expense.daily_expense_Api.repository;

import daily_expense.daily_expense_Api.model.Spent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpentRepository extends JpaRepository<Spent, Long> {
    List<Spent> findByCategoryId(Long categoryId);
}