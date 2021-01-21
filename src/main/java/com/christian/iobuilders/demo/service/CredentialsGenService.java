package com.christian.iobuilders.demo.service;

import com.christian.iobuilders.demo.pojos.Claim;
import org.web3j.crypto.ECKeyPair;

import java.security.InvalidAlgorithmParameterException;
import java.security.interfaces.ECKey;
import java.util.Map;

public interface CredentialsGenService {

    Map generateCredentials(String userPass);
}
