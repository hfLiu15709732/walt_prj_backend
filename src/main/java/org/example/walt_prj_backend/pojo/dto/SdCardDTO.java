package org.example.walt_prj_backend.pojo.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * SD卡数据传输对象类
 *
 * @author hfLiuX
 * @since 2025-09-14
 */
@Data
public class SdCardDTO {

    /* =========================
       预留：实体本身字段（若未来需要）
       ========================= */
    private Integer id;
    private String name;
    private String productModel;
    private Integer brandId;
    private String cardType;
    private String cardLevel;
    /* 其余字段略 */

    /* =========================
       内部静态 DTO（按场景细分）
       ========================= */

    /** 新增 SD卡 时使用的 DTO */
    @Data
    public static class SdCardAddDto {
        private String name;
        private String productModel;
        private Integer brandId;
        private String description;
        private String cardType;
        private String cardLevel;
        private String flashMemoryType;
        private BigDecimal theoreticalSpeed;
        private BigDecimal regularWriteSpeed;
        private String remarks;
        private String warrantyPeriod;
        private LocalDate releaseDate;
        private String officialWebsite;
        private String imageUrl;
    }

    /** 更新 SD卡 时使用的 DTO */
    @Data
    public static class SdCardUpdateDto {
        private Integer id;
        private String name;
        private String productModel;
        private Integer brandId;
        private String description;
        private String cardType;
        private String cardLevel;
        private String flashMemoryType;
        private BigDecimal theoreticalSpeed;
        private BigDecimal regularWriteSpeed;
        private String remarks;
        private String warrantyPeriod;
        private LocalDate releaseDate;
        private String officialWebsite;
        private String imageUrl;
    }

    /** 条件查询 SD卡 时使用的 DTO */
    @Data
    public static class SdCardQueryDto {
        /** SD卡ID，精确匹配 */
        private Integer id;

        /** SD卡名称，模糊匹配 */
        private String name;

        /** 产品型号，模糊匹配 */
        private String productModel;

        /** 品牌ID，精确匹配 */
        private Integer brandId;

        /** 卡片类型，精确匹配 */
        private String cardType;

        /** 卡片级别，精确匹配 */
        private String cardLevel;

        /** 排序字段：可根据需要设置如name、productModel等，空值表示不排序 */
        private String sortBy;

        /** 排序方式：asc、desc，空值默认 asc */
        private String order;
    }

    /** 删除 SD卡 时使用的 DTO */
    @Data
    public static class SdCardDeleteDto {
        private Integer id;
    }

    /** 分页+条件查询专用 DTO */
    @Data
    public static class SdCardPageQueryDto {
        /** 当前页码，默认 1 */
        @Min(value = 1, message = "pageNum 必须大于 0")
        private Integer pageNum = 1;

        /** 每页条数，默认 10 */
        @Min(value = 1, message = "pageSize 必须大于 0")
        private Integer pageSize = 10;

        /* 下面完全复用 SdCardQueryDto 里的查询字段 */
        private Integer id;
        private String name;
        private String productModel;
        private Integer brandId;
        private String cardType;
        private String cardLevel;

        /** 排序字段：可根据需要设置如name、productModel等，空值表示不排序 */
        private String sortBy;

        /** 排序方式：asc、desc，空值默认 asc */
        private String order;
    }
}
