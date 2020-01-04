package com.cake.repositories;

import com.cake.entities.Cake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CakeRepository extends JpaRepository<Cake, Long> {

    Optional<Cake> findByTitle(String title);

}
