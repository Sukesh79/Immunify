package com.example.Immunify.Repository;

import com.example.Immunify.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmailId(String emailId);

    public User findByMobNo(String mobNo);
    @Query(value = "select * from user where is_dose1_taken = false", nativeQuery = true)
    public List<User> usersNotTakenDose1();

    @Query(value = "select * from user where is_dose1_taken = true and is_dose2_taken = false", nativeQuery = true)
    public List<User> userNotTakenOnlyDose2();

    @Query(value = "select * from user where is_dose2_taken = true", nativeQuery = true)
    public List<User> userFullyVaccinated();

    @Query(value = "select * from user where is_dose1_taken = false and gender = male", nativeQuery = true)
    public List<User> MaleNotTakenDose1();

    @Query(value = "select * from user where is_dose2_taken = true and gender = female", nativeQuery = true)
    public List<User> FemaleFullyVaccinated();
}
