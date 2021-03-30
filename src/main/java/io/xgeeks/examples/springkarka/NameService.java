package io.xgeeks.examples.springkarka;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class NameService {

    private Map<String, AtomicInteger> names;

    public NameService() {
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
}
