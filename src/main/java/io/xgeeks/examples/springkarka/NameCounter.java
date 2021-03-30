package io.xgeeks.examples.springkarka;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class NameCounter {

    private String name;

    private AtomicInteger value;

    public NameCounter(String name) {
        this.name = name;
        this.value = new AtomicInteger(0);
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value.intValue();
    }

    public int increment() {
        return this.value.incrementAndGet();
    }

    public int decrement() {
        return this.value.decrementAndGet();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NameCounter that = (NameCounter) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "NameCounter{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
