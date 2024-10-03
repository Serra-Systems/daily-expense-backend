package daily_expense.daily_expense_Api.service.impl;

import daily_expense.daily_expense_Api.model.Spent;
import daily_expense.daily_expense_Api.repository.SpentRepository;
import daily_expense.daily_expense_Api.service.SpentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpentServiceImpl implements SpentService {
    @Autowired
    private SpentRepository repository;

    @Override
    public Spent findByid(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Spent> findAll() {
        return repository.findAll();
    }

    @Override
    public Spent save(Spent spent) {
        return repository.save(spent);
    }

    @Override
    public Spent update(Long id, Spent spent) {
        Spent existingSpent = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Spent with id " + id + " not found."));
        existingSpent.setValue(spent.getValue());
        existingSpent.setDate(spent.getDate());
        return repository.save(existingSpent);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}