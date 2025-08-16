package org.example.walt_prj_backend.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * SOC芯片信息实体类
 *
 * @author hfLiuX
 * @since 2025-08-16
 */
@Data
@TableName("soc_info")
public class SocInfo {

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * SOC名称
     */
    @TableField("name")
    private String name;

    /**
     * 品牌ID
     */
    @TableField("brand_id")
    private Integer brandId;

    /**
     * SOC描述信息
     */
    @TableField("description")
    private String description;

    /**
     * 额外备注信息
     */
    @TableField("remarks")
    private String remarks;

    /**
     * SOC图片的URL地址
     */
    @TableField("image_url")
    private String imageUrl;

    /**
     * CPU架构
     */
    @TableField("cpu_architecture")
    private String cpuArchitecture;

    /**
     * CPU主频，单位GHz
     */
    @TableField("cpu_frequency")
    private BigDecimal cpuFrequency;

    /**
     * CPU核心数量
     */
    @TableField("cpu_core_count")
    private String cpuCoreCount;

    /**
     * CPU支持的指令集
     */
    @TableField("cpu_instruction_set")
    private String cpuInstructionSet;

    /**
     * CPU的TDP功耗，单位W
     */
    @TableField("cpu_tdp_power")
    private BigDecimal cpuTdpPower;

    /**
     * CPU二级缓存大小，单位MB
     */
    @TableField("cpu_l2_cache")
    private BigDecimal cpuL2Cache;

    /**
     * CPU一级缓存大小，单位MB
     */
    @TableField("cpu_l1_cache")
    private BigDecimal cpuL1Cache;

    /**
     * CPU制程工艺
     */
    @TableField("cpu_manufacturing_process")
    private String cpuManufacturingProcess;

    /**
     * 生产制造厂商
     */
    @TableField("manufacturer")
    private String manufacturer;

    /**
     * GPU型号
     */
    @TableField("gpu_model")
    private String gpuModel;

    /**
     * GPU主频，单位GHz
     */
    @TableField("gpu_frequency")
    private BigDecimal gpuFrequency;

    /**
     * GPU核心数量
     */
    @TableField("gpu_core_count")
    private Integer gpuCoreCount;

    /**
     * 支持的内存类型
     */
    @TableField("memory_type")
    private String memoryType;

    /**
     * 内存频率，单位MHz
     */
    @TableField("memory_frequency")
    private Integer memoryFrequency;

    /**
     * 内存总线规格
     */
    @TableField("memory_bus")
    private String memoryBus;

    /**
     * 内存最大带宽，单位Gbit/s
     */
    @TableField("memory_max_bandwidth")
    private BigDecimal memoryMaxBandwidth;

    /**
     * 支持的存储类型
     */
    @TableField("storage_type")
    private String storageType;

    /**
     * NPU型号
     */
    @TableField("npu_model")
    private String npuModel;

    /**
     * NPU理论性能
     */
    @TableField("npu_theoretical_performance")
    private BigDecimal npuTheoreticalPerformance;

    /**
     * 是否支持4G网络及相关规格
     */
    @TableField("4g_support")
    private String fourGSupport;

    /**
     * 是否支持5G网络及相关规格
     */
    @TableField("5g_support")
    private String fiveGSupport;

    /**
     * Wi-Fi版本及支持情况
     */
    @TableField("wifi_support")
    private String wifiSupport;

    /**
     * 蓝牙版本及支持情况
     */
    @TableField("bluetooth_support")
    private String bluetoothSupport;

    /**
     * 支持的导航定位系统
     */
    @TableField("navigation_support")
    private String navigationSupport;

    /**
     * SOC发布日期
     */
    @TableField("release_date")
    private LocalDate releaseDate;

    /**
     * 产品定位（如高端、中端、入门级）
     */
    @TableField("product_positioning")
    private String productPositioning;

    /**
     * Geekbench 6单核跑分
     */
    @TableField("geekbench6_single_core")
    private Integer geekbench6SingleCore;

    /**
     * Geekbench 6多核跑分
     */
    @TableField("geekbench6_multi_core")
    private Integer geekbench6MultiCore;

    /**
     * 安兔兔10跑分成绩
     */
    @TableField("antutu10_score")
    private Integer antutu10Score;

    /**
     * SOC跑分加权值
     */
    @TableField("soc_score_weighted")
    private BigDecimal socScoreWeighted;
}