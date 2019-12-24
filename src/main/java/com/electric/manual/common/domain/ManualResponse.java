package com.electric.manual.common.domain;

import java.util.HashMap;

public class ManualResponse extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    public ManualResponse message(String message) {
        this.put("message", message);
        return this;
    }

    public ManualResponse data(Object data) {
        this.put("data", data);
        return this;
    }

    @Override
    public ManualResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
