package com.electric.instructions.common.domain;

import java.util.HashMap;

public class InstructionsResponse extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    public InstructionsResponse message(String message) {
        this.put("message", message);
        return this;
    }

    public InstructionsResponse data(Object data) {
        this.put("data", data);
        return this;
    }

    @Override
    public InstructionsResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
