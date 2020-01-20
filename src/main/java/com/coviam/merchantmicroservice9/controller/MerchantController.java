package com.coviam.merchantmicroservice9.controller;

import com.coviam.merchantmicroservice9.dto.MerchantDTO;
import com.coviam.merchantmicroservice9.dto.MerchantLoginDTO;
import com.coviam.merchantmicroservice9.dto.MerchantTokenDTO;
import com.coviam.merchantmicroservice9.entity.Merchant;
import com.coviam.merchantmicroservice9.entity.MerchantToken;
import com.coviam.merchantmicroservice9.services.MerchantServices;
import com.coviam.merchantmicroservice9.services.MerchantTokenServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/merch")
public class MerchantController {

    @Autowired
    MerchantServices merchServices;

    @Autowired
    MerchantTokenServices merchantTokenServices;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public ResponseEntity<String> addUser(@RequestBody MerchantDTO merchDTO) {
        System.out.println(merchDTO);
        Merchant merch = new Merchant();
        BeanUtils.copyProperties(merchDTO, merch);
        Merchant merchCreated = merchServices.save(merch);

        return new ResponseEntity<String>(merchCreated.getMerchEmail(), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/editMerch")
    public ResponseEntity<String> editUser(@RequestBody MerchantDTO merchDTO) {
        System.out.println(merchDTO);
        Merchant merch = new Merchant();
        BeanUtils.copyProperties(merchDTO, merch);
        Merchant userCreated = merchServices.save(merch);

        return new ResponseEntity<String>(userCreated.getMerchEmail(), HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/checkUuid")  //name
    public ResponseEntity<String> checkUuid(@RequestBody String uuid) {
//        UserTokenDTO userTokenDTO=new UserTokenDTO();
//        BeanUtils.copyProperties();
        return new ResponseEntity<String>(merchantTokenServices.checkUuid(uuid).get().getMerchEmail(), HttpStatus.CREATED);
    }

//    @RequestMapping("/getUuid")
//    public ResponseEntity<UserToken> getUuid(Email email) {
//        return new ResponseEntity<UserToken>(userTokenService.getUuid(email),HttpStatus.CREATED);
//    }

    @RequestMapping(method = RequestMethod.POST, value = "/generateUuid")  //uuid
    public ResponseEntity<String> generateUuid(@RequestBody String email) {
        System.out.println("===>" + email);
        MerchantTokenDTO merchTokenDTO = new MerchantTokenDTO();
        MerchantToken merchToken = merchantTokenServices.generateUuid(email.toString());
        merchTokenDTO.setMerchEmail(email);
        merchTokenDTO.setUuid(merchToken.getUuid().toString());
        BeanUtils.copyProperties(merchToken, merchTokenDTO);
        return new ResponseEntity<String>(merchTokenDTO.getUuid(), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/logout")
    public ResponseEntity<Boolean> logoutButton(@RequestBody String uuid) {
        return new ResponseEntity<Boolean>(merchantTokenServices.deleteUuid(uuid), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<Boolean> loginButton(@RequestBody MerchantLoginDTO merchLogin) {
        return new ResponseEntity<Boolean>(merchServices.getPass(merchLogin.getUserEmail()).equals(merchLogin.getUserPassword()), HttpStatus.CREATED);
    }
//
//    @RequestMapping(method = RequestMethod.POST,value = "/login")
//    public ResponseEntity<String> userLoginCheck(@RequestBody )

}
