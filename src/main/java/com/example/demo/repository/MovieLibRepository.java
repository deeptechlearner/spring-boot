package com.example.demo.repository;

import com.example.demo.entity.MovieLibDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieLibRepository extends JpaRepository<MovieLibDO, Integer> {

    List<MovieLibDO> findAllByMovieNameIgnoreCaseContaining(String movieName);

    MovieLibDO findByMovieId(int id);

    List<MovieLibDO> findAllByCollectionBetween(String start, String end);


}
