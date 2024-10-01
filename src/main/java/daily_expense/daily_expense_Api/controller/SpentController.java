package daily_expense.daily_expense_Api.controller;
import daily_expense.daily_expense_Api.model.Spent;
import daily_expense.daily_expense_Api.service.SpentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spents")
public class SpentController {
    @Autowired
    private SpentService spentservice;
    @PostMapping
    public ResponseEntity<Spent> saveexpenses(@RequestBody @Valid Spent spent){
        Spent spents = spentservice.save(spent);
        if (spents == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(spents);
    }
}