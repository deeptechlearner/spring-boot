package com.example.demo.service;

import com.example.demo.entity.MovieLibDO;
import com.example.demo.model.AddMovieModel;
import com.example.demo.model.MovieDetailsOutputModel;
import com.example.demo.model.UpdateMovieModel;
import com.example.demo.repository.MovieLibRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieLibService {
    private final MovieLibRepository movieLibRepo;


    public MovieLibService(MovieLibRepository movieLibRepo) {
        this.movieLibRepo = movieLibRepo;
    }

    public List<MovieDetailsOutputModel> getAllMoviesByName(String movieName) {
        List<MovieDetailsOutputModel> movieDetailsOutputModelList = new ArrayList<>();
        List<MovieLibDO> entityList = movieLibRepo.findAllByMovieNameIgnoreCaseContaining(movieName);
        MovieDetailsOutputModel model;
        if (CollectionUtils.isNotEmpty(entityList)) {
            for (MovieLibDO movieData : entityList) {
                model = new MovieDetailsOutputModel();
                model.setMovieId(movieData.getMovieId());
                model.setMovieName(movieData.getMovieName());
                model.setCollection(movieData.getCollection());
                movieDetailsOutputModelList.add(model);
            }
        }
        movieDetailsOutputModelList.forEach(System.out::println);
        return movieDetailsOutputModelList;
    }

    public MovieDetailsOutputModel getMovieById(int movieId) {
        MovieDetailsOutputModel model = new MovieDetailsOutputModel();
        MovieLibDO entityData = movieLibRepo.findByMovieId(movieId);
        if (ObjectUtils.isNotEmpty(entityData)) {
            model.setMovieName(entityData.getMovieName());
            model.setMovieId(entityData.getMovieId());
            model.setCollection(entityData.getCollection());
        }
        return model;
    }

    public List<MovieDetailsOutputModel> getMovieDetailsByCollectionRange(String start, String end) {
        List<MovieDetailsOutputModel> movieDetailsOutputModelList = new ArrayList<>();
        List<MovieLibDO> entityList = movieLibRepo.findAllByCollectionBetween(start, end);
        MovieDetailsOutputModel model;
        if (CollectionUtils.isNotEmpty(entityList)) {
            for (MovieLibDO movieData : entityList) {
                model = new MovieDetailsOutputModel();
                model.setMovieId(movieData.getMovieId());
                model.setMovieName(movieData.getMovieName());
                model.setCollection(movieData.getCollection());
                movieDetailsOutputModelList.add(model);
            }
        }
        movieDetailsOutputModelList.forEach(System.out::println);
        return movieDetailsOutputModelList;
    }

    public MovieDetailsOutputModel addMovieByAdmin(AddMovieModel inputModel) {
        MovieLibDO entityDataToSave = new MovieLibDO();
        if (ObjectUtils.isNotEmpty(inputModel)) {
            entityDataToSave.setMovieName(inputModel.getMovieName());
            entityDataToSave.setCollection(inputModel.getCollection());
        }
        MovieLibDO savedData = movieLibRepo.save(entityDataToSave);
        MovieDetailsOutputModel model = new MovieDetailsOutputModel();
        if (ObjectUtils.isNotEmpty(savedData)) {
            model.setMovieName(savedData.getMovieName());
            model.setMovieId(savedData.getMovieId());
            model.setCollection(savedData.getCollection());
        }
        return model;
    }

    public MovieDetailsOutputModel modifyMovieByAdmin(UpdateMovieModel inputModel) {
        MovieLibDO entityDataToSave = movieLibRepo.findByMovieId(inputModel.getMovieId());
        if (ObjectUtils.isNotEmpty(entityDataToSave)) {
            entityDataToSave.setMovieName(inputModel.getMovieName());
            entityDataToSave.setCollection(inputModel.getCollection());
        }
        MovieLibDO savedData = movieLibRepo.save(entityDataToSave);
        MovieDetailsOutputModel model = new MovieDetailsOutputModel();
        if (ObjectUtils.isNotEmpty(savedData)) {
            model.setMovieName(savedData.getMovieName());
            model.setMovieId(savedData.getMovieId());
            model.setCollection(savedData.getCollection());
        }
        return model;
    }

}
