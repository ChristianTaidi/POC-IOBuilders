package com.christian.iobuilders.demo.service.impl;

import com.christian.iobuilders.demo.pojos.Claim;
import com.christian.iobuilders.demo.repository.ClaimRepository;
import com.christian.iobuilders.demo.service.ClaimGenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public class ClaimGenServiceImpl implements ClaimGenService {

    @Autowired
    private ClaimRepository repository;

    @Override
    public Claim generateClaim() {

        Claim claim = new Claim("URJC_Claim","DefaultJSON");
        claim = repository.save(claim);
        return claim;
        //ToDo generate new Claim and persist it in the repository
    }
}
