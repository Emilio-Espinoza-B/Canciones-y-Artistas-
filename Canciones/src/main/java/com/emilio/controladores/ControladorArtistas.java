package com.emilio.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.emilio.modelos.Artista;
import com.emilio.servicios.ServicioArtistas;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class ControladorArtistas {

	@Autowired
	private ServicioArtistas servicio;
	
	@GetMapping("/artistas")
	public String desplegarArtistas(Model model) {
		List<Artista> artistas = servicio.obtenerTodosLosArtistas();
		model.addAttribute("artistas",artistas);
		return "artistas";
	}
	
	@GetMapping("/artistas/detalle/{idArtista}")
	public String desplegarDetalleArtista(@PathVariable long idArtista, Model model) {
		Artista artista = servicio.obtenerArtistaPorId(idArtista);
		model.addAttribute("artista",artista);
		return "detalleArtista";
	}
	
	@GetMapping("/artistas/formulario/agregar")
	public String formularioAgregarArtista(Model model) {
		model.addAttribute("artista", new Artista());
		return "agregarArtista";
	}
	
	@PostMapping("/artistas/procesa/agregar")
	public String procesarAgregarArtista(@Valid @ModelAttribute("artista")Artista artista, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "agregarArtista";
		}
		servicio.agregarArtista(artista);
		return "redirect:/artistas";
	}
	
	
}
