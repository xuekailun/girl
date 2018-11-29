package com.imooc.passbook.controller;

import com.alibaba.fastjson.JSON;
import com.imooc.passbook.service.IMerchantsServ;
import com.imooc.passbook.vo.CreateMerchantsRequest;
import com.imooc.passbook.vo.PassTemplate;
import com.imooc.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/***
 * 商户服务
 */
@Slf4j
@RestController
@RequestMapping("/merchants")
public class MerchantsController {


    //商户服务接口
    private final IMerchantsServ iMerchantsServ;

    @Autowired
    public MerchantsController(IMerchantsServ iMerchantsServ) {
       this.iMerchantsServ=iMerchantsServ;
    }

    @ResponseBody
    @PostMapping("/create")
    public Response createMerchants(@RequestBody CreateMerchantsRequest request){
        log.info("CreateMerchants: {}",JSON.toJSONString(request));
        return iMerchantsServ.createMerchants(request);
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Response buildMerchantsInfo(@PathVariable Integer id){
        log.info("BuildMerchantsInfo:{}",id);
        return iMerchantsServ.buildMerchantsInfoById(id);
    }

    @ResponseBody
    @PostMapping("/drop")
    public Response dropPassTemplate(@RequestBody PassTemplate passTemplate){
        log.info("DropPassTemplate :{}",passTemplate);
        return iMerchantsServ.dropPassTemplate(passTemplate);
    }
}
