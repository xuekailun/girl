package com.imooc.passbook.entity;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.retry.annotation.Backoff;

import javax.persistence.*;

/**
 * <h1>商户对象模型</h1>
 */
//实现get和set注解
@Data
//无参的构造函数
@NoArgsConstructor
//全参的构造函数
@AllArgsConstructor
//表明是一个实体对象
@Entity
//实体属性对象的定义
@Table(name = "merchants")
public class Merchants {

    /** 商户id 主键*/
    //表明merchants的主键
    @Id
    //自动生成
    @GeneratedValue
    //nullbale 代表是否可空类型
    @Column(name="id",nullable = false)
    private Integer id;

    /** 商户名称 需要全局唯一的*/
    //unique 代表的是全局唯一
    @Basic
    /**
     * @Transient 代表的时候这个列不在这个表里面的话，加上这个注解
     * */
    @Column(name = "name",nullable = false,unique = true)
    private String name;

    /** 商户 logo */
    @Basic
    @Column(name ="logo_url",nullable = false)
    private String logoUrl;

    /** 商户营业执照 */
    @Basic
    @Column(name="business_license_url", nullable = false)
    private String businessLicenseUrl;

    /** 商户的联系电话*/
    @Basic
    @Column(name="phone",nullable = false)
    private String phone;

    /** 商户的地址 */
    @Basic
    @Column(name="address",nullable = false)
    private String address;

    /** 商户是否通过审核*/
    @Basic
    @Column(name = "is_audit", nullable = false)
    private Boolean isAudit = false;


}
