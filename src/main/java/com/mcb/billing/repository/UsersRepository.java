package com.mcb.billing.repository;

import com.mcb.billing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UsersRepository extends JpaRepository<User,Long> {


    @Query(value = "SELECT * FROM users",nativeQuery = true) // native query
    public List<User> getAllUsers();


    @Query("SELECT u FROM User u where meterNumber =:number")//JPQL with ID param
    public User getUserById(@Param("number") Integer number);

//    @Query("SELECT u FROM User u where id=?1")// JPQL with Index parameter
//    public User getUserById(Long id);

    public User findByEmail(String email); // custom query

//    @Transactional
//    @Modifying
//    @Query(value = "DELETE FROM users WHERE meter_number=:number",nativeQuery = true) // native query with param
//    public void deleteUserById(@Param("number") Integer number);


    @Query("DELETE FROM User WHERE meterNumber =:number")
    public void deleteUserById(@Param("number") Integer number);

}
