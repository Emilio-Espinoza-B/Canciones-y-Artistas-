package com.emilio.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.emilio.modelos.Artista;
import com.emilio.modelos.Cancion;
import com.emilio.servicios.ServicioArtistas;
import com.emilio.servicios.ServicioCanciones;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ControladorCanciones {
	
	@Autowired
	private ServicioCanciones servicioCanciones;
	
	@Autowired
	private ServicioArtistas servicioArtistas;
	
	@GetMapping("/canciones")
	public String desplegarCanciones(Model model) {
		List<Cancion> canciones = servicioCanciones.obtenerTodasLasCanciones();
		model.addAttribute("canciones", canciones);
		return "canciones";
	}
	@GetMapping("/canciones/detalle/{idCancion}") public String desplegarDetalleCancion(@PathVariable Long idCancion, Model model) {
		Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
		model.addAttribute("cancion", cancion); 
		return "detalleCancion";
	}
	
	@GetMapping("/canciones/formulario/agregar")
	public String formularioAgregarCancion(Model model) {
		model.addAttribute("cancion", new Cancion());
		List<Artista> artistas = servicioArtistas.obtenerTodosLosArtistas();
		model.addAttribute("artistas",artistas);
		return "agregarCancion";
	}
	
	@PostMapping("/canciones/procesa/agregar")
	public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "agregarCancion";
		}
		Artista artista = servicioArtistas.obtenerArtistaPorId(cancion.getArtista().getId());
		cancion.setArtista(artista);
		servicioCanciones.agregarCancion(cancion);
		return "redirect:/canciones";
	}
	
	@GetMapping("/canciones/formulario/editar/{idCancion}")
	public String formularioEditarCancion(@PathVariable long idCancion, Model model) {
		Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
		model.addAttribute("cancion", cancion);
		return "editarCancion";
	}
	
	@PostMapping("/canciones/procesa/editar/{idCancion}")
	public String procesarEditarCancion(@PathVariable long idCancion, @Valid @ModelAttribute("cancion") Cancion cancion, BindingResult result, Model model ) {
		if (result.hasErrors()) {
			return "editarCancion";
		}
		cancion.setId(idCancion);
		servicioCanciones.actualizaCancion(cancion);
		return "redirect:/canciones";
	}
	
	@DeleteMapping("/canciones/eliminar/{idCancion}")
	public String procesarEliminarCancion(@PathVariable long idCancion) {
		servicioCanciones.eliminaCancion(idCancion);
		return "redirect:/canciones";
	}
}
