package com.alpine.cucumber;

import com.alpine.enums.Context;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private final Map<String, Object> scenarioContext;

    public ScenarioContext() {
        scenarioContext = new HashMap<>();
    }

    public void setContext(@NotNull Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(@NotNull Context key) {
        return scenarioContext.get(key.toString());
    }

    public Boolean isContains(@NotNull Context key) {
        return scenarioContext.containsKey(key.toString());
    }
}
