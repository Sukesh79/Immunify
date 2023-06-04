package com.example.Immunify.Repository;

import com.example.Immunify.Model.Center;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepository extends JpaRepository<Center, Integer> {
}
