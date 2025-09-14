package org.example.walt_prj_backend.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * SD卡信息实体类
 *
 * @author hfLiuX
 * @since 2025-09-14
 */
@Data
@TableName("sd_card")
public class SdCard {

    /**
     * SD卡唯一标识
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * SD卡名称
     */
    @TableField("name")
    private String name;

    /**
     * 产品型号
     */
    @TableField("product_model")
    private String productModel;

    /**
     * 品牌ID，关联品牌表
     */
    @TableField("brand_id")
    private Integer brandId;

    /**
     * 描述信息
     */
    @TableField("description")
    private String description;

    /**
     * 卡片类型（如sd卡、tf卡、mini sd卡等）
     */
    @TableField("card_type")
    private String cardType;

    /**
     * 卡片级别（标准）
     */
    @TableField("card_level")
    private String cardLevel;

    /**
     * 闪存颗粒类型
     */
    @TableField("flash_memory_type")
    private String flashMemoryType;

    /**
     * 理论速度（单位：M/s）
     */
    @TableField("theoretical_speed")
    private BigDecimal theoreticalSpeed;

    /**
     * 常规写速（单位：M/s）
     */
    @TableField("regular_write_speed")
    private BigDecimal regularWriteSpeed;

    /**
     * 备注
     */
    @TableField("remarks")
    private String remarks;

    /**
     * 保修时间
     */
    @TableField("warranty_period")
    private String warrantyPeriod;

    /**
     * 发布时间
     */
    @TableField("release_date")
    private LocalDate releaseDate;

    /**
     * 官网链接
     */
    @TableField("official_website")
    private String officialWebsite;

    /**
     * 图片链接
     */
    @TableField("image_url")
    private String imageUrl;
}
