package com.christian.iobuilders.demo.service.impl;

import com.christian.iobuilders.demo.service.CredentialsGenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.web3j.crypto.*;
import org.web3j.protocol.Web3j;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;
import java.util.Map;

@Service
@Configurable
public class CredentialsGenServiceImpl implements CredentialsGenService {

    @Autowired
    private Web3j web3j;

    @Override
    public Map generateCredentials(String userPass){

        Map result = new HashMap<String,Object>();
        try{

            ECKeyPair keyPair = Keys.createEcKeyPair();
            result.put("key-pair",keyPair);
            WalletFile wallet = Wallet.createStandard(userPass,keyPair);
            result.put("wallet",wallet);

        } catch (CipherException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return result;
    }
}
