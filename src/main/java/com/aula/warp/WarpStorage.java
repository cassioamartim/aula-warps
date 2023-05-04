package com.aula.warp;

import java.util.HashMap;
import java.util.Map;

public class WarpStorage {

    public Map<String, Warp> getWarpMap() {
        return warpMap;
    }

    private final Map<String, Warp> warpMap = new HashMap<>();

    public void create(Warp warp) {
        warpMap.put(warp.getName().toLowerCase(), warp);
    }

    public void delete(String name) {
        warpMap.remove(name.toLowerCase());
    }

    public Warp get(String name) {
        return warpMap.get(name.toLowerCase());
    }
}
