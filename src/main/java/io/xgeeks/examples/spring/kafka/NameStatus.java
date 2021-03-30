package io.xgeeks.examples.spring.kafka;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class NameStatus {

    private final String name;

    private final int value;

    public NameStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "NameStatus{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public static NameStatus of(Map.Entry<String, AtomicInteger> entry) {
        return new NameStatus(entry.getKey(), entry.getValue().intValue());
    }
}
