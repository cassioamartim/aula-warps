package com.aula.user;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserStorage {

    private final Map<UUID, User> userMap = new HashMap<>();

    public void create(User user) {
        userMap.put(user.getPlayer().getUniqueId(), user);
    }

    public void remove(UUID uniqueId) {
        userMap.remove(uniqueId);
    }

    public User get(UUID uniqueId) {
        return userMap.get(uniqueId);
    }
}
