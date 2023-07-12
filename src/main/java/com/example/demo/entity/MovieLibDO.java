package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;


@Data
@Entity
@Table(name="movie_library")
public class MovieLibDO implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "movie_id")
    private int movieId;

    @NotBlank(message="Movie name must not be blank")
    @Size(max=80, message="Movie name cannot exceed 80 characters")
    @Column(name="movie_name")
    private String movieName;

    @NotBlank(message="Movie collection must not be blank")
    @Size(max=10, message="Movie collection cannot exceed 80 characters")
    @Column(name="collection")
    private String collection;

}
