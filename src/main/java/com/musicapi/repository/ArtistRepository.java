package com.musicapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musicapi.model.ArtistModel;

public interface ArtistRepository extends JpaRepository<ArtistModel, Integer> {

}
