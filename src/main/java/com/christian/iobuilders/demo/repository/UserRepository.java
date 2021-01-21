package com.christian.iobuilders.demo.repository;

import com.christian.iobuilders.demo.pojos.Claim;
import com.christian.iobuilders.demo.pojos.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findAll();
}
