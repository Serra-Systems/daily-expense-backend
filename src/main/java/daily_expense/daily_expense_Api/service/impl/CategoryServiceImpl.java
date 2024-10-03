package daily_expense.daily_expense_Api.service.impl;

import daily_expense.daily_expense_Api.model.Category;
import daily_expense.daily_expense_Api.repository.CategoryRepository;
import daily_expense.daily_expense_Api.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repository;

    @Override
    public Category findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category update(Long id, Category category) {
        Category existingCategory = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Spent with id " + id + " not found."));
        existingCategory.setLeisure(category.getLeisure());
        existingCategory.setFood(category.getFood());
        existingCategory.setHousing(category.getHousing());
        existingCategory.setTranspost(category.getTranspost());
        existingCategory.setEducation(category.getEducation());
        existingCategory.setHealth(category.getHealth());
        return repository.save(existingCategory);
    }
}