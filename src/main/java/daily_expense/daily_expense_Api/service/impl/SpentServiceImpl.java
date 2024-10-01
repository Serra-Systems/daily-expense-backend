package daily_expense.daily_expense_Api.service.impl;

import daily_expense.daily_expense_Api.model.Spent;
import daily_expense.daily_expense_Api.repository.SpentRepository;
import daily_expense.daily_expense_Api.service.SpentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpentServiceImpl implements SpentService {
    @Autowired
    private SpentRepository repository;
    @Override
    public Spent save(Spent spent) {
        return repository.save(spent);
    }
}

