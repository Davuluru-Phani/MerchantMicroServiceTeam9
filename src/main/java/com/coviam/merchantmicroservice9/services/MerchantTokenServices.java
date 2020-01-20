package com.coviam.merchantmicroservice9.services;

import com.coviam.merchantmicroservice9.entity.MerchantToken;

import java.util.Optional;

public interface MerchantTokenServices {
    public MerchantToken generateUuid(String email);
    public Optional<MerchantToken> checkUuid(String uuid);
    public boolean deleteUuid(String uuid);
}
