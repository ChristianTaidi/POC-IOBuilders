package com.christian.iobuilders.demo.repository;

import com.christian.iobuilders.demo.pojos.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimRepository extends JpaRepository<Claim,Long> {

    List<Claim> findAll();
}
