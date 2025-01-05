package io.github.hexsook.kblapi.api;

import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class KeyboardListenerAPI {

    private static KeyboardListenerAPI api;

    public static KeyboardListenerAPI get() {
        if (api == null) {
            throw new IllegalStateException("API is not loaded!");
        }
        return api;
    }

    public static void set(KeyboardListenerAPI api) {
        if (KeyboardListenerAPI.api != null) {
            throw new IllegalStateException("API is already set, and can only be set once!");
        }
        KeyboardListenerAPI.api = api;
    }

    private final Map<Key, KeyListenerRegistry> listenerRegistry = new HashMap<>();

    public KeyboardListenerAPI() {
        for (Key value : Key.values()) {
            listenerRegistry.put(value, new KeyListenerRegistry());
        }
    }

    public Map<Key, KeyListenerRegistry> getListenerRegistry() {
        return listenerRegistry;
    }

    public void addKeyListener(Plugin plugin, Key key, KeyboardListener listener) {
        KeyListenerRegistry keyListenerRegistry = listenerRegistry.get(key);
        if (keyListenerRegistry == null) {
            throw new IllegalArgumentException("Key " + key + " is not registered");
        }

        keyListenerRegistry.register(plugin, listener);
    }

    public void removeAllKeyListeners(Plugin plugin, Key key) {
        KeyListenerRegistry keyListenerRegistry = listenerRegistry.get(key);
        if (keyListenerRegistry == null) {
            throw new IllegalArgumentException("Key " + key + " is not registered");
        }

        keyListenerRegistry.unregisterAll(plugin);
    }
}
