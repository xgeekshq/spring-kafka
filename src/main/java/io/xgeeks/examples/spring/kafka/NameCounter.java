package io.xgeeks.examples.springkarka;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@Component
public class NameCounter {
    private static final AtomicInteger ZERO = new AtomicInteger(0);

    private final Map<String, AtomicInteger> names;

    public NameCounter() {
        this.names = new ConcurrentHashMap<>();
    }

    public int increment(String name) {
        AtomicInteger counter = this.names.computeIfAbsent(name, k -> new AtomicInteger(0));
        return counter.incrementAndGet();
    }

    public int decrement(String name) {
        AtomicInteger counter = this.names.computeIfAbsent(name, k -> new AtomicInteger(0));
        return counter.decrementAndGet();
    }

    public int get(String name) {
     return this.names.getOrDefault(name, ZERO).get();
    }

    public Stream<Map.Entry<String, AtomicInteger>> getValues() {
        return this.names.entrySet().stream();
    }
}
