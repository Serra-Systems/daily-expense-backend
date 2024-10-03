package daily_expense.daily_expense_Api.service;

import daily_expense.daily_expense_Api.model.Category;

import java.util.List;
public interface CategoryService {
    Category findById(Long id);
    List<Category> findAll();
    Category update(Long id, Category category);
}
