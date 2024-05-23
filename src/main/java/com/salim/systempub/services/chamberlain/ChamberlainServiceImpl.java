package com.salim.systempub.services.chamberlain;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.salim.systempub.config.ServiceConfig;
import com.salim.systempub.entities.chamberlain.Chamberlain;
import com.salim.systempub.entities.chamberlain.PUBBalance;

@Service
public class ChamberlainServiceImpl extends ServiceConfig implements ChamberlainService {

    @Override
    public String home(Model model) {
        Long lastIncomeBalance = 0L;
        Long lastExpenseBalance = 0L;
        Long lastTotalBalance = 0L;
        Long totalBalance = 0L;

        for (Chamberlain chamberlain : chamberlainRepository.findAll()) {
            lastExpenseBalance = chamberlain.getExpense();
            lastIncomeBalance = chamberlain.getIncome();
            lastTotalBalance = chamberlain.getBalance();
        }
        for (PUBBalance pubBalance : pubBalanceRepository.findAll()) {
            totalBalance = pubBalance.getTotalBalance();
        }
        model.addAttribute("lastIncomeBalance", lastIncomeBalance);
        model.addAttribute("lastExpenseBalance", lastExpenseBalance);
        model.addAttribute("lastTotalBalance", lastTotalBalance);
        model.addAttribute("totalBalance", totalBalance);
        model.addAttribute("balance", pubBalanceRepository.findAll());
        model.addAttribute("data", chamberlainRepository.findAll());
        model.addAttribute("add", new Chamberlain());
        return "bendahara/index";
    }

    @Override
    public String expenseIncomeList(Model model) {
        model.addAttribute("balance", pubBalanceRepository.findAll());
        model.addAttribute("data", chamberlainRepository.findAll());
        return "bendahara/list";
    }

    @Override
    public String add(Model model) {
        Chamberlain bendahara = new Chamberlain();
        model.addAttribute("add", bendahara);
        return "bendahara/add";
    }

    @Override
    public String delete(Long id, Model model) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        
        Optional<Chamberlain> existingChamberlain = chamberlainRepository.findById(id);
        if (!existingChamberlain.isPresent()) {
            throw new IllegalArgumentException("Chamberlain with id " + id + " does not exist");
        }
        
        chamberlainRepository.deleteById(id);
        return "redirect:/bendahara/list/";
    }

    @Override
    public String save(Chamberlain chamberlain) {
        Long lastId = 0L;
        PUBBalance balance = new PUBBalance();
        PUBBalance balancePrimary;
        List<PUBBalance> PUB = pubBalanceRepository.findAll();
        for (PUBBalance pubBalance : PUB) {
            lastId = pubBalance.getId();
        }
        if (!pubBalanceRepository.findAll().isEmpty()) {
            balancePrimary = pubBalanceRepository.getReferenceById(lastId);
        } else {
            balancePrimary = balance;
        }
        balance.setDate(chamberlain.getDate());
        balance.setSavingBalance(chamberlain.getIncome());
        balance.setUsedBalance(chamberlain.getExpense());
        chamberlain.setBalance(balancePrimary.getTotalBalance());
        if (balance.getSavingBalance() == 0)
            balance.setTotalBalance(balance.getSavingBalance() - balance.getUsedBalance());
        balance.setTotalBalance(
                (balancePrimary.getTotalBalance() + balance.getSavingBalance()) - balance.getUsedBalance());
        chamberlainRepository.save(chamberlain);
        pubBalanceRepository.save(balance);
        return "redirect:/bendahara/";
    }

    @Override
    public String deleteBalance(Long id, Model model) {
        if (id != null) {
            pubBalanceRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("id can't be null");
        }
        return "redirect:/bendahara/list/";
    }

}
