package daily_expense.daily_expense_Api.controller;

import daily_expense.daily_expense_Api.model.Spent;
import daily_expense.daily_expense_Api.service.SpentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spents")
public class SpentController {
    @Autowired
    private SpentService spentservice;

    @GetMapping("/{id}")
    public ResponseEntity<Spent> searchExpensesById(@PathVariable Long id) {
        Spent spentId = spentservice.findByid(id);
        if (spentId == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(spentId);
    }

    @GetMapping
    public ResponseEntity<List<Spent>> searchAllExpenses() {
        List<Spent> spentList = spentservice.findAll();
        if (spentList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(spentList);
    }

    @PostMapping
    public ResponseEntity<Spent> saveExpenses(@RequestBody @Valid Spent spent) {
        Spent createdSpent= spentservice.save(spent);
        if (createdSpent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(createdSpent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Spent> updateById(@PathVariable Long id, @RequestBody Spent spent) {
        Spent updatedSpent = spentservice.update(id, spent);
        if(updatedSpent == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updatedSpent);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        spentservice.delete(id);
        return ResponseEntity.noContent().build();
    }
}

