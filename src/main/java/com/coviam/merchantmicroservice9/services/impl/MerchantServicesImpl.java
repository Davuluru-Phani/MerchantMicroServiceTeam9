package com.coviam.merchantmicroservice9.services.impl;

import com.coviam.merchantmicroservice9.entity.Merchant;
import com.coviam.merchantmicroservice9.repository.MerchantRepo;
import com.coviam.merchantmicroservice9.services.MerchantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantServicesImpl implements MerchantServices {
    @Autowired
    MerchantRepo merchRepo;

    public Merchant save(Merchant merch) { return merchRepo.save(merch); }

    public String getPass(String email){
        return merchRepo.findById(email).get().getMerchPassword();
    }
}
