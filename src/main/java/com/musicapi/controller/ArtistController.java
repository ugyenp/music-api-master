package com.musicapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.musicapi.model.ArtistModel;
import com.musicapi.service.ArtistService;

@RestController
public class ArtistController {
	
	@Autowired
	private ArtistService artistService;

	@GetMapping("/allartist")
	public List<ArtistModel> getAllArtist(){
     return artistService.getAllArtist();
	}
	
	@GetMapping("/artist/{id}")
	public ArtistModel getArtistById(@PathVariable ("id") int id) {
		return artistService.getArtistById(id);
	}

	
	@PostMapping("/saveArtist")
	public ArtistModel saveArtist(@RequestBody ArtistModel artistModel) {
		return artistService.saveArtist(artistModel);
	}
	
	@PutMapping("/updateArtist/{id}")
	public Optional<Object> updateArtist(@RequestBody ArtistModel artistModel, @PathVariable ("id") int id){
		return artistService.updateArtist(artistModel,id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteArtist(@PathVariable ("id") int id) {
		artistService.deletArtist(id);
	}
	
}
