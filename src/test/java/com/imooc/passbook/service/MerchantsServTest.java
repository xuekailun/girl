package com.imooc.passbook.service;

import com.alibaba.fastjson.JSON;
import com.imooc.passbook.vo.CreateMerchantsRequest;
import com.imooc.passbook.vo.PassTemplate;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.lang.ref.ReferenceQueue;
import java.util.Date;

/***
 * 商户服务测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MerchantsServTest {

    @Autowired
    private IMerchantsServ merchantsServ;
    //{"data":{"id":1},"errorMsg":""}
    @Test
//    @Transactional 在测试的时候 如果有这个只是会显示数据是否成功，但是不会对数据库进行事物的操作
    public void testCreateMerchanteServ(){
        CreateMerchantsRequest request = new CreateMerchantsRequest();
        request.setName("慕课1");
        request.setLogoUrl("www.imooc.com");
        request.setBusinessLicenseUrl("www.imooc.com");
        request.setPhone("12345678");
        request.setAddress("北京市");
        System.out.println(JSON.toJSONString(merchantsServ.createMerchants(request)));
    }

    /**
     * {"data":{"address":"北京市","businessLicenseUrl":"www.imooc.com","id":3,
     * "isAudit":false,"logoUrl":"www.imooc.com","name":"慕课","phone":"12345678"},
     * "errorCode":0,"errorMsg":""}
     */
    @Test
    public void testBuildMerchantsInfoById(){
        System.out.println(JSON.toJSONString(merchantsServ.buildMerchantsInfoById(3)));
    }

    @Test
    public void testDropPassTemplate(){
        PassTemplate passTemplate = new PassTemplate();
        passTemplate.setId(4);
        passTemplate.setTitle("titile : 慕课");
        passTemplate.setSummary("简介 : 慕课");
        passTemplate.setDesc("详情 : 慕课");
        passTemplate.setLimit(10000L);
        passTemplate.setHanToken(false);
        passTemplate.setBackground(3);
        passTemplate.setStart(new Date());
        passTemplate.setEnd(DateUtils.addDays(new Date(),10));
        System.out.println(JSON.toJSONString(merchantsServ.dropPassTemplate(passTemplate)));

    }
}
