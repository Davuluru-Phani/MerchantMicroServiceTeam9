package com.coviam.merchantmicroservice9.repository;

import com.coviam.merchantmicroservice9.entity.MerchantToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantTokenRepo extends CrudRepository<MerchantToken,String> {
}
