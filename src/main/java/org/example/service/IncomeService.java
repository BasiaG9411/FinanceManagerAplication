package org.example.service;


import org.example.Dao.IncomeDao;
import org.example.entity.Income;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


public class IncomeService {

    private IncomeDao incomeDao = new IncomeDao();

    public void addIncome(BigDecimal ammount, String commentary, LocalDate dateFrom) {
        Income income = new Income(null, ammount, dateFrom, commentary);
        incomeDao.insert(income);

    }

    public boolean deleteIncome(Integer id) {
        Income income = incomeDao.findById(id);
        incomeDao.deleteIncome(income);
        return true;
    }

    public List<Income> showAllIncomes() {
        return incomeDao.findAllIncomes();
    }


}



