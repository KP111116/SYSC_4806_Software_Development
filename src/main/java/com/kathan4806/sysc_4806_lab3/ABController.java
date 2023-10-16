package com.kathan4806.sysc_4806_lab3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ABController {

    private final AddressBookRepo addressBookRepository;

    public ABController(AddressBookRepo addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    @RequestMapping(value = "/addressBooks")
    public String addressBook(Model model){
        model.addAttribute("listOfAddressBooks", addressBookRepository.findAll());
        return "addressBooks";
    }


}
