package com.electric.manual.pasring;

import com.electric.manual.common.constant.DrugManualAttr;
import com.electric.manual.common.constant.LikeIndicationAttr;
import com.electric.manual.common.constant.LikePharmacologyAttr;
import com.electric.manual.common.constant.LikeTabooAttr;
import com.electric.manual.system.entity.Company;
import com.electric.manual.system.entity.Composition;
import com.electric.manual.system.entity.DrugManual;
import com.electric.manual.system.entity.DrugName;
import com.electric.manual.system.service.IDrugManualService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertToEntity {
    @Autowired
    private IDrugManualService drugManualService;

    public void textMark(String context, String drugName) {
        DrugManualAttr[] arr = DrugManualAttr.values();
        Map<DrugManualAttr, Integer> contextMark = new HashMap<>(arr.length);
        for (DrugManualAttr attr : arr) {
            assert attr.getName() != null;
            int index;
            if (attr == DrugManualAttr.INDICATION) {
                index = LikeIndicationAttr.getIndex(context);
            } else if (attr == DrugManualAttr.PHARMACOLOGY) {
                index = LikePharmacologyAttr.getIndex(context);
            } else if (attr == DrugManualAttr.TABOO) {
                index = LikeTabooAttr.getIndex(context);
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
        parseToEntity(context, list, drugName);
    }

    private void parseToEntity(String context, List<Map.Entry<DrugManualAttr, Integer>> list, String drugName) {
        DrugManual drugManual = new DrugManual();
        DrugName drug = new DrugName();
        Company company = new Company();
        Composition composition = new Composition();
        drug.setChName(drugName);

        int listSize = list.size();
        String attrStr;
        context = context.replace("如有问题可与生产企业联系", "");
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

        drugManual.setDrugName(drug);
        drugManual.setComposition(composition);
        drugManual.setCompany(company);

        drugManualService.importDrugManual(drugManual);
    }
}
