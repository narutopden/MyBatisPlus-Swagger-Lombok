package com.topdent.swl.demo.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author blue sky
 * @since 2021-07-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("product_order_item")
public class ProductOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    private Long productOrderId;

    private String outTradeNo;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品图片
     */
    private String productImg;

    /**
     * 购买数量
     */
    private Integer buyNum;

    private Date createTime;

    /**
     * 购物项商品总价格
     */
    private BigDecimal totalFee;

    /**
     * 购物项商品支付总价格
     */
    private BigDecimal payFee;


}
