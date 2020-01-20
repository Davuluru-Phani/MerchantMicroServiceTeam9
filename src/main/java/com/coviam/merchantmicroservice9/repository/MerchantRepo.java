package com.coviam.merchantmicroservice9.repository;

import com.coviam.merchantmicroservice9.entity.Merchant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepo extends CrudRepository<Merchant,String> {



}
