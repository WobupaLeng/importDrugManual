package com.electric.manual.pasring;

import com.alibaba.fastjson.JSON;
import com.electric.manual.common.constant.*;
import com.electric.manual.common.utils.FileUtil;
import com.electric.manual.system.entity.Company;
import com.electric.manual.system.entity.Composition;
import com.electric.manual.system.entity.DrugManual;
import com.electric.manual.system.entity.DrugName;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.electric.manual.common.constant.AttrInitConstant.*;

public class ConvertToEntity {
    public List<DrugManual> startProcess(String dirPath) {
        File file = new File(dirPath);
        File[] fs = file.listFiles();
        assert fs != null;
        StringBuilder echo = new StringBuilder("process ===> start");

        int index = 0;
        int total = fs.length;
        List<DrugManual> drugManualList = new ArrayList<>(total);
        for (File f : fs) {
            index++;
            String context = FileUtil.readFile(f);
            context = context.replace("如有问题可与生产企业联系", "");
            List<Map.Entry<DrugManualAttr, Integer>> list = textMark(context);
            drugManualList.add(parseToEntity(context, list, f.getName().replaceAll(".txt", "")));

            if (index % 200 == 0) {
                System.out.println(echo.append((index * 100) / total).append("%"));
                echo.delete(0, echo.length());
            }
        }
        return drugManualList;
    }

    public List<Map.Entry<DrugManualAttr, Integer>> textMark(String context) {
        DrugManualAttr[] arr = DrugManualAttr.values();
        Map<DrugManualAttr, Integer> contextMark = new HashMap<>(arr.length);
        for (DrugManualAttr attr : arr) {
            assert attr.getName() != null;
            int index;

            if (getCommonNameAttrs().stream().anyMatch(s -> s.getValue() == attr.getValue())) {
                index = LikeCommonNameAttr.getIndex(context);
            } else if (getChemicalNameAttrs().stream().anyMatch(s -> s.getValue() == attr.getValue())) {
                index = LikeChemicalNameAttr.getIndex(context);
            } else if (getIngredientAttrs().stream().anyMatch(s -> s.getValue() == attr.getValue())) {
                index = LikeIngredientAttr.getIndex(context);
            } else if (getIndicationAttrs().stream().anyMatch(s -> s.getValue() == attr.getValue())) {
                index = LikeIndicationAttr.getIndex(context);
            } else if (getPharmacologyAttrs().stream().anyMatch(s -> s.getValue() == attr.getValue())) {
                index = LikePharmacologyAttr.getIndex(context);
            } else if (getTabooAttrs().stream().anyMatch(s -> s.getValue() == attr.getValue())) {
                index = LikeTabooAttr.getIndex(context);
            } else if (attr == DrugManualAttr.PACK) { //包装图 和包装 属性的特殊处理
                int urlIndex = context.indexOf(DrugManualAttr.IMAGES_URL.getName());
                int packIndex = context.lastIndexOf(DrugManualAttr.PACK.getName());
                if (packIndex <= urlIndex) {
                    index = -1;
                } else {
                    index = packIndex;
                }
            } else if (getCompanyNameAttrs().stream().anyMatch(s -> s.getValue() == attr.getValue())) {
                index = LikeCompanyNameAttr.getIndex(context);
            } else {
                index = context.indexOf(attr.getName());
            }

            if (index < 0)
                continue;
            contextMark.put(attr, index);
        }
        //对contextMark value 排序
        List<Map.Entry<DrugManualAttr, Integer>> list = new ArrayList<>(contextMark.entrySet());
        list.sort(Map.Entry.comparingByValue());
        return list;
    }

    public DrugManual parseToEntity(String context, List<Map.Entry<DrugManualAttr, Integer>> list, String drugName) {
        DrugManual drugManual = new DrugManual();
        DrugName drug = new DrugName();
        Company company = new Company();
        Composition composition = new Composition();
        drug.setName(drugName);

        int listSize = list.size();
        String attrStr;
        //相邻的属性下标之间为文本内容 位置靠前的下标为对应属性
        for (int i = 0; i < listSize; i++) {
            Map.Entry<DrugManualAttr, Integer> current = list.get(i);
            if (i < listSize - 1) {
                attrStr = context.substring(current.getValue(), list.get(i + 1).getValue());
            } else {
                attrStr = context.substring(current.getValue());
            }

            attrStr = attrStr
                    .replace(current.getKey().getName(), "")
                    .replaceAll(" ", "")
                    .replaceAll("\r\n", "")
                    .replaceAll("\\[", "")
                    .replaceAll("]", "")
                    .replaceAll("【", "")
                    .replaceAll("】", "");
            if (StringUtils.isNotBlank(attrStr) &&
                    (attrStr.substring(0, 1).equals(":") || attrStr.substring(0, 1).equals("："))) {
                attrStr = attrStr
                        .replaceFirst(":", "")
                        .replaceFirst("：", "");
            }
            DrugManualAttr.setEntity(current.getKey(), attrStr, drugManual, drug, composition, company);
        }

        drugManual.setDrugName(JSON.toJSONString(drug));
        drugManual.setComposition(JSON.toJSONString(composition));
        drugManual.setCompany(JSON.toJSONString(company));
        return drugManual;
    }
}
