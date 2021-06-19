package com.launchacademy.petTracker.controllers;


import com.launchacademy.petTracker.models.Pet;
import com.launchacademy.petTracker.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pets")
public class PetController {

  @Autowired
  private PetRepository petRepository;

  @GetMapping
  public String listPets(Pageable pageable, Model model) {
    Page<Pet> pets = petRepository.findAll(pageable);
    model.addAttribute("pets", pets);
    return "pets/index";
  }

  @GetMapping("/new")
  public String getNew(@ModelAttribute("pet") Pet pet) {
    return "pets/new";
  }

  @PostMapping
  public String addDonut(@ModelAttribute("pet") Pet pet) {
    petRepository.save(pet);
    return "redirect:/pets";
  }

}


























