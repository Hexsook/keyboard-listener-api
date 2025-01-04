package me.hexsook.kblapi.api;

import java.util.ArrayList;
import java.util.List;

public class PluginKeyListenerRegistry {

    private final List<KeyboardListener> registry = new ArrayList<>();

    public List<KeyboardListener> getRegistry() {
        return registry;
    }

    public void register(KeyboardListener listener) {
        registry.add(listener);
    }

    public void unregisterAll(KeyboardListener listener) {
        registry.add(listener);
    }
}
