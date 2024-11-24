package com.example.CrickBuzz.repository;

import com.example.CrickBuzz.model.Player;
import com.example.CrickBuzz.model.enums.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    //let us create the own functions using repo attributes
    public List<Player> findByAgeGreaterThan(int age);

    //we use native query= true
//    @Query(value = "select * from player where age >= :age and speciality = :speciality",nativeQuery = true)
//    public List<Player> playerByAgeGreaterThanAndSpeciality(int age, String speciality);

    //if we want to write  JPQL - java persistence query language . nativeQuery will be false which is byDefault false always
    //as we know java is a OOP so use object based approach here the variable we use are not database colum names they are variable entities
    //so we change the data type of speciality to enum in all class from string
    @Query(value = "select p from Player p where p.age >= :age and p.speciality = :speciality")
    public List<Player> playerByAgeGreaterThanAndSpeciality(int age, Speciality speciality);



}




