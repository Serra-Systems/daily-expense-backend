package daily_expense.daily_expense_Api.service;

import daily_expense.daily_expense_Api.model.Spent;

import java.util.List;

public interface SpentService {
    Spent findByid(Long id);
    List<Spent> findAll();
    Spent save(Spent spent);
    Spent update(Long id, Spent spent);
    boolean delete(Long id);
}