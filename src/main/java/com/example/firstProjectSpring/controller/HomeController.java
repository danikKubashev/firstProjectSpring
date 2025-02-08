package com.example.firstProjectSpring.controller;

import com.example.firstProjectSpring.FirstProjectSpringApplication;
import com.example.firstProjectSpring.client.Appartment;
import com.example.firstProjectSpring.client.Client;
import com.example.firstProjectSpring.impl.AppartmentService;
import com.example.firstProjectSpring.impl.ClientService;
import com.example.firstProjectSpring.repository.AppartmentRepository;
import com.example.firstProjectSpring.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final ClientService clientService;
    private final AppartmentService appartmentService;

    @GetMapping(value = "/")
    public String homePage() {
        return "main";
    }

    @GetMapping(value = "/spisok")
    public String allClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "spisok";
    }

    @GetMapping(value = "/ipoteka")
    public String allIpoteks(Model model) {
        model.addAttribute("appartments", appartmentService.getAllAppartments());
        return "ipoteka";
    }





    @PostMapping("/result/{appartmentId}")
    public String applyForMortgage(@PathVariable Long appartmentId, @ModelAttribute Client client, Model model) {

        Appartment appartment = appartmentService.getApartmentById(appartmentId);


        boolean isApproved = appartmentService.canGetMortgage(client, appartment);


        if (isApproved) {
            model.addAttribute("message", "Поздравляем! Ваша заявка на ипотеку одобрена.");
        } else {
            model.addAttribute("message", "Извините, ваша заявка на ипотеку отклонена.");
        }


        return "/result";
    }







}
