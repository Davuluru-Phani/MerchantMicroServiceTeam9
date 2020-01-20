package com.coviam.merchantmicroservice9.services.impl;

import com.coviam.merchantmicroservice9.entity.MerchantToken;
import com.coviam.merchantmicroservice9.repository.MerchantTokenRepo;
import com.coviam.merchantmicroservice9.services.MerchantTokenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MerchantTokenServicesImpl implements MerchantTokenServices {
    @Autowired
    MerchantTokenRepo merchantTokenRepo;

    public MerchantToken generateUuid(String email){
        UUID uuid=UUID.randomUUID();
        MerchantToken merchantToken=new MerchantToken();
        merchantToken.setUuid(uuid.toString());
        merchantToken.setMerchEmail(email);
        merchantTokenRepo.save(merchantToken);
//        System.out.println(merchantToken.toString());
        return merchantToken;
    }

    public Optional<MerchantToken> checkUuid(String uuid){
        return merchantTokenRepo.findById(uuid);
    }

    public boolean deleteUuid(String uuid){
        if(merchantTokenRepo.findById(uuid).isPresent()){
            merchantTokenRepo.deleteById(uuid);
            return true;
        }
        else {
            return false;
        }
    }
}
