package com.trademehere.movies.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.trademehere.movies.controller.api.MovieRestController;
import com.trademehere.movies.dao.model.MovieDao;
import com.trademehere.movies.dto.model.MovieDto;

import co.elastic.apm.api.CaptureSpan;

@Component
public class MovieAssembler extends RepresentationModelAssemblerSupport<MovieDao, MovieDto> {
	
	@Autowired
    private ModelMapper modelMapper;

	public MovieAssembler() {
		super(MovieRestController.class, MovieDto.class);
	}

	@Override
	@CaptureSpan
	public MovieDto toModel(MovieDao movieDao) {
		MovieDto movieDto = modelMapper.map(movieDao, MovieDto.class);
		Link link = linkTo(methodOn(MovieRestController.class).findById(movieDao.getId())).withSelfRel();
		movieDto.add(link);
        return movieDto;
	}
	
	@Override
	@CaptureSpan
	public CollectionModel<MovieDto> toCollectionModel(Iterable<? extends MovieDao> entities) 
	{
		CollectionModel<MovieDto> movies = super.toCollectionModel(entities);
		
		
		return movies;
	}
	

}
