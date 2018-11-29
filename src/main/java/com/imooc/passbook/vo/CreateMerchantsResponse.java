package com.imooc.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * <h2>创建商户响应对象</h2>
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsResponse {

    /**商户id : 创建失败为-1*/
    private Integer id;
}

