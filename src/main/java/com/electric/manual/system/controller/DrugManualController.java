package com.electric.manual.system.controller;

import com.electric.manual.system.service.IDrugManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drug-manual")
public class DrugManualController {
    @Autowired
    private IDrugManualService drugManualService;
}
