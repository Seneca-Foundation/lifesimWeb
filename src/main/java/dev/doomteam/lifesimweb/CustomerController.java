package dev.doomteam.lifesimweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerRepository repo;
    
    @GetMapping("/createform")
    public String showForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "create_customer";
    }

    @RequestMapping(value = "/createform", method = RequestMethod.POST)
    public String submit(@ModelAttribute("comicbook") Customer customer, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        repo.save(customer);
        model.addAttribute("customer", customer);
        return "customer";
    }
}