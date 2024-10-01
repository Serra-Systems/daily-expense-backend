package daily_expense.daily_expense_Api.model;
import daily_expense.daily_expense_Api.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Spent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING) // O campo é armazenado como uma string correspondente ao valor da enum.
    @Column(nullable = false)
    private Category category;
    @Column(nullable = false)
    private BigDecimal value;
    @Column(nullable = false)
    private LocalDate date;
}