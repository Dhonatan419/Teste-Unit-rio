package com.teste.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.teste.model.usuario;
import com.teste.repository.usuarioRepository;

@Controller
public class usuarioController {
	
	@Autowired
	usuarioRepository usuarioRepository;
	
	@GetMapping("/usuario/list")
	public String listUsuario(Model model) {
		
		model.addAttribute("usuarios", usuarioRepository.findAll());
		return "usuario/list";
	}
	
	@GetMapping("/usuario/add")
	public String addUsuario(Model model) {
		model.addAttribute("usuario", new usuario());
		return "usuario/add";
	}
	
	@PostMapping("/usuario/save")
	public String saveUsuario(usuario usuario) {
		try {
			if(usuario != null) {
				usuarioRepository.save(usuario);
			}
		} catch (Exception e) {
			System.out.println("Erro ao salvar:" + e.getMessage());
		}
		return "redirect:/usuario/view/" + usuario.getId();
		
	}
	
	@GetMapping("/usuario/view/{id}")
	public String viewUsuario(@PathVariable long id, Model model) {
		model.addAttribute("usuario", usuarioRepository.findById(id));
		return "usuario/view";
	}
	
	@GetMapping("/usuario/edit/{id}")
	public String editUsuario(@PathVariable long id, Model model) {
		model.addAttribute("usuario", usuarioRepository.findById(id));
		return "usuario/edit";
	}
	
	@GetMapping("/usuario/delete/{id}")
	public String deleteUsuario(@PathVariable long id) {
		try {
				usuarioRepository.deleteById(id);
			
		} catch (Exception e) {
			System.out.println("Erro ao deletar: " + e.getMessage());
		}
		return "redirect:/usuario/list";
	}

}
