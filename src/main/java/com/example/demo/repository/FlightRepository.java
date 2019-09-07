package com.example.demo.repository;

import com.example.demo.model.AvioCompany;
import com.example.demo.model.Flight;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT f FROM Flight f WHERE f.avioCompany = ?1 AND f.active = true")
    List<Flight> findAllByCompany(AvioCompany id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Flight f SET f.active = false WHERE f.from = :from AND f.fromCode = :fromCode AND" +
            " f.to = :to AND f.toCode = :toCode AND f.avioCompany = :avioCompany")
    void removeFlight(@Param("from") String from, @Param("to") String to, @Param("fromCode") String fromCode,
                      @Param("toCode") String toCode, @Param("avioCompany") AvioCompany company);
}
