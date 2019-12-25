package com.electric.manual.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.electric.manual.system.dao.DrugManualMapper;
import com.electric.manual.system.entity.DrugManual;
import com.electric.manual.system.service.IDrugManualService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("drugManualService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DrugManualServiceImpl extends ServiceImpl<DrugManualMapper, DrugManual> implements IDrugManualService {

    @Override
    @Transactional
    public void importDrugManual(DrugManual drugManual) {
        this.baseMapper.insert(drugManual);
    }
}
