package com.christian.iobuilders.demo.service.impl;

import com.christian.iobuilders.demo.contracts.TestLurien;
import com.christian.iobuilders.demo.pojos.Claim;
import com.christian.iobuilders.demo.service.ClaimDeployService;
import com.christian.iobuilders.demo.service.ContractEventObserverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.web3j.crypto.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;

import javax.annotation.PostConstruct;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

@Service
@Configurable
public class ClaimDeployServiceImpl implements ClaimDeployService {

    Credentials credentials;
    @Autowired
    private Web3j web3j;

    @Autowired
    private ContractEventObserverService observerService;

    //Gas values for Rinkeby network
//    private static final BigInteger GAS_PRICE = BigInteger.valueOf(2000000L);
//    private static final BigInteger GAS_LIMIT = BigInteger.valueOf(672290L);
    //Gas values for local network
    private static final BigInteger GAS_PRICE = BigInteger.valueOf(20000L);
    private static final BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);


    @PostConstruct
    public void init() throws IOException, CipherException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException {
        BigInteger privateKeyInBT = new BigInteger("5beeda0befb179ad48b656af710e4225f119d8490675f4f8361ab426b4003b94", 16);

        //BigInteger privateKeyInBT = new BigInteger("AAC4EA9967D456C9B77209534799B7B158F78372C6E7603A3871CB4CA192A56C", 16);
        ECKeyPair aPair = ECKeyPair.create(privateKeyInBT);
        credentials = Credentials.create(aPair);
        //credentials = WalletUtils.loadBip39Credentials(null,"twice require display resemble execute suffer celery digital ignore tackle chicken soldier");
        EthGetBalance ethGetBalance = null;
            ethGetBalance = web3j
                        .ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST)
                        .send();

//
        System.out.println(ethGetBalance.getBalance());
        LOGGER.info("Credentials created: file={}, address={"+credentials.getAddress()+"}");

    }

    @Override
    public String deployClaim(Claim claim) throws Exception {

        TestLurien contract = TestLurien.deploy(web3j, this.credentials, GAS_PRICE, GAS_LIMIT,credentials.getEcKeyPair().getPublicKey().toString()).send();
        //TestLurien remoteContract = TestLurien.load("0xbF833D198101afEC77fD65C533642a71d8DdDe1a", web3j, credentials, GAS_PRICE, GAS_LIMIT);

        observerService.manageContractEvent(contract);
        System.out.println(contract.getContractAddress());

        return contract.getContractAddress();
        //return "0xbF833D198101afEC77fD65C533642a71d8DdDe1a";


    }

}
