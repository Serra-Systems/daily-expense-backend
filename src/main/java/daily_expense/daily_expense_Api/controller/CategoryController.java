package daily_expense.daily_expense_Api.controller;

import daily_expense.daily_expense_Api.model.Category;
import daily_expense.daily_expense_Api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/{id}")
    public ResponseEntity<Category> searchExpensesById(@PathVariable Long id) {
        Category categoryId = service.findById(id);
        if (categoryId == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoryId);
    }

    @GetMapping
    public ResponseEntity<List<Category>> searchAllExpenses() {
        List<Category> categoryList = service.findAll();
        if (categoryList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(categoryList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateById(@PathVariable Long id, @RequestBody Category category) {
        Category updatedCategory = service.update(id, category);
        if (updatedCategory == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updatedCategory);
    }

}