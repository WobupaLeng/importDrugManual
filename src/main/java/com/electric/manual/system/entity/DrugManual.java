package com.electric.manual.system.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DrugManual implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 药品名称
     */
    private DrugName drugName;

    /**
     * 来源
     */
    private String manualSource;

    /**
     * 图片
     */
    private String imagesUrl;

    /**
     * 成分
     */
    private Composition composition;

    /**
     * 注射剂辅料
     */
    private String injections;

    /**
     * 性状
     */
    private String nature;

    /**
     * 适应症
     */
    private String indication;

    /**
     * 药理药毒
     */
    private String pharmacology;

    /**
     * 药代动力学
     */
    private String pharmacokinetics;

    /**
     * 用法用量
     */
    private String dosage;

    /**
     * 规格
     */
    private String specification;

    /**
     * 作用类别
     */
    private String roleCategory;

    /**
     * 不良反应
     */
    private String adverseReactions;

    /**
     * 禁忌
     */
    private String taboo;

    /**
     * 注意事项
     */
    private String precautions;

    /**
     * 孕妇及哺乳期妇女用药
     */
    private String pregnantWoman;

    /**
     * 儿童用药
     */
    private String child;

    /**
     * 老年患者用药
     */
    private String elderly;

    /**
     * 药物相互作用
     */
    private String interaction;

    /**
     * 药物过量
     */
    private String drugOverdose;

    /**
     * 贮藏
     */
    private String store;

    /**
     * 包装
     */
    private String pack;

    /**
     * 有效期
     */
    private String expirationDate;

    /**
     * 执行标准
     */
    private String implementationStandards;

    /**
     * 批准文号
     */
    private String ratifyNumber;

    /**
     * 生产企业
     */
    private String company;

    /**
     * 生产地址
     */
    private String address;


}
