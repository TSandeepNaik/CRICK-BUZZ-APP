package com.example.CrickBuzz.repository;


import com.example.CrickBuzz.model.CricketMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CricketMatchRepository extends JpaRepository<CricketMatch, Integer> {
}
