package com.skillsoft.collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, String> {

    private static final long serialVersionUID = 1L;

    private static final int MAX_ENTRIES = 5;

    public LRUCache() {
        super(16, 0.75f, true);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
        return size() > MAX_ENTRIES;
    }
}
