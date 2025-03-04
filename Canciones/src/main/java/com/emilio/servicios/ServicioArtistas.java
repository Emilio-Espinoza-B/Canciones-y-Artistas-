package com.emilio.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emilio.modelos.Artista;
import com.emilio.repositorios.RepositorioArtistas;

@Service
public class ServicioArtistas {
	
	@Autowired
	private RepositorioArtistas repositorio;
	
	public List<Artista> obtenerTodosLosArtistas(){
		return repositorio.findAll();
	}
	
	public Artista obtenerArtistaPorId(Long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public Artista agregarArtista(Artista artista) {
		return repositorio.save(artista);
	}
}
