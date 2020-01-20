package com.coviam.merchantmicroservice9.services;


import com.coviam.merchantmicroservice9.entity.Merchant;

public interface MerchantServices {
    public Merchant save(Merchant merch);
    public String getPass(String email);
}
