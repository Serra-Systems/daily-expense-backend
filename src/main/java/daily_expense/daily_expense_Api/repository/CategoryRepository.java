package daily_expense.daily_expense_Api.repository;

import daily_expense.daily_expense_Api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
