package com.org.work.booking.converter;

import org.modelmapper.ModelMapper;
import com.org.work.booking.model.Movie;
import com.org.work.booking.dto.MovieDTO;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

@Component
public class MovieConverter extends AbstractConverter<Movie, MovieDTO> {

    private final ModelMapper modelMapper;

    public MovieConverter(ModelMapper modelMapper) {
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        this.modelMapper = modelMapper;
    }

    @Override
    public Movie convertToDM(MovieDTO movieDTO) {
        return modelMapper.map(movieDTO, Movie.class);
    }

    @Override
    public MovieDTO convertToDTO(Movie movie) {
        return modelMapper.map(movie, MovieDTO.class);
    }
}
