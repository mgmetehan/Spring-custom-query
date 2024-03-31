package com.mgmetehan.customquery.repository;

import com.mgmetehan.customquery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // ??? JPA standart sorguları
    List<User> findByActiveTrue();
    List<User> findByUsernameAndActiveTrue(String username);
    List<User> findBySalaryGreaterThan(long salary);
    List<User> findBySalaryBetween(long minSalary, long maxSalary);
    long countByActiveTrue();


    // *** JPQL sorguları
    @Query("SELECT u FROM User u WHERE u.active = true")
    List<User> findActiveUsersJPQL();
    @Query("SELECT u FROM User u WHERE u.username = :username AND u.active = true")
    List<User> findActiveUsersByUsernameJPQL(@Param("username") String username);
    @Query("SELECT u FROM User u WHERE u.salary > :salary")
    List<User> findUsersWithSalaryGreaterThanJPQL(@Param("salary") long salary);
    @Query("SELECT u FROM User u WHERE u.salary BETWEEN :minSalary AND :maxSalary")
    List<User> findUsersWithSalaryBetweenJPQL(@Param("minSalary") long minSalary, @Param("maxSalary") long maxSalary);
    @Query("SELECT COUNT(u) FROM User u WHERE u.active = true")
    long countActiveUsersJPQL();


    //!!! Native query sorguları
    @Query(value = "SELECT * FROM usr WHERE active = true", nativeQuery = true)
    List<User> findActiveUsersNative();
    @Query(value = "SELECT * FROM usr WHERE username = :username AND active = true", nativeQuery = true)
    List<User> findActiveUsersByUsernameNative(@Param("username") String username);
    @Query(value = "SELECT * FROM usr WHERE salary > :salary", nativeQuery = true)
    List<User> findUsersWithSalaryGreaterThanNative(@Param("salary") long salary);
    @Query(value = "SELECT * FROM usr WHERE salary BETWEEN :minSalary AND :maxSalary", nativeQuery = true)
    List<User> findUsersWithSalaryBetweenNative(@Param("minSalary") long minSalary, @Param("maxSalary") long maxSalary);
    @Query(value = "SELECT COUNT(*) FROM usr WHERE active = true", nativeQuery = true)
    long countActiveUsersNative();
}
