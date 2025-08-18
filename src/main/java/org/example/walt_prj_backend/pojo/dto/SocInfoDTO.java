package org.example.walt_prj_backend.pojo.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class SocInfoDTO {

    /* =========================
       预留：实体本身字段（若未来需要）
       ========================= */
    private Integer id;
    private String name;
    private Integer brandId;
    private String manufacturer;
    /* 其余字段略 */

    /* =========================
       内部静态 DTO（按场景细分）
       ========================= */

    /** 新增 SOC 时使用的 DTO（预留） */
    @Data
    public static class SocAddDto {
        private String name;
        private Integer brandId;
        private String manufacturer;
        /* 其余字段按需补充 */
    }

    /** 更新 SOC 时使用的 DTO（预留） */
    @Data
    public static class SocUpdateDto {
        private Integer id;
        private String name;
        private Integer brandId;
        private String manufacturer;
        /* 其余字段按需补充 */
    }

    /** 条件查询 SOC 时使用的 DTO（当前唯一在用） */
    @Data
    public static class SocQueryDto {
        /** SOC名称，模糊匹配 */
        private String name;
        /** 品牌ID，精确匹配 */
        private Integer brandId;
        /** 生产制造厂商，模糊匹配 */
        private String manufacturer;

        /** 排序字段：single、multi，空值表示不排序 */
        private String sortBy;
        /** 排序方式：asc、desc，空值默认 asc */
        private String order;
    }

    /** 删除 SOC 时使用的 DTO（预留） */
    @Data
    public static class SocDeleteDto {
        private Integer id;
    }

    /** 分页+条件查询专用 DTO */
    @Data
    public static class SocPageQueryDto {
        /** 当前页码，默认 1 */
        @Min(value = 1, message = "pageNum 必须大于 0")
        private Integer pageNum = 1;

        /** 每页条数，默认 10 */
        @Min(value = 1, message = "pageSize 必须大于 0")
        private Integer pageSize = 10;

        /* 下面完全复用 SocQueryDto 里的查询字段 */
        private String name;
        private Integer brandId;
        private String manufacturer;

        /** 排序字段：single、multi，空值表示不排序 */
        private String sortBy;
        /** 排序方式：asc、desc，空值默认 asc */
        private String order;
    }
}