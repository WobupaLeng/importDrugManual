package com.electric.manual.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.electric.manual.system.entity.DrugManual;

public interface IDrugManualService extends IService<DrugManual> {
    void importDrugManual(DrugManual drugManual);
}
