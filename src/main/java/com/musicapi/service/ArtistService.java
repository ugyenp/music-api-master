package com.musicapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicapi.model.ArtistModel;
import com.musicapi.repository.ArtistRepository;

@Service
public class ArtistService {

	@Autowired
	private ArtistRepository artistRepository;
	
	public List<ArtistModel> getAllArtist() {
		List<ArtistModel> artistModel = new ArrayList<>();
		artistRepository.findAll().forEach(artistModel::add);
		return artistModel;
	}

	public ArtistModel getArtistById(int id) {
		return artistRepository.findById(id).get();
	}

	public ArtistModel saveArtist(ArtistModel artistModel) {
		return artistRepository.save(artistModel);
	}

	public Optional<Object> updateArtist(ArtistModel artistModel, int id) {
		return artistRepository.findById(id).map(x -> {
			x.setUser_name(artistModel.getUser_name());
			x.setPassword(artistModel.getPassword());
			return artistRepository.save(x);
		});
	}

	public void deletArtist(int id) {
		artistRepository.deleteById(id);
	}

	
	
}
