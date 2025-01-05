package io.github.hexsook.kblapi.api;

import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class KeyListenerRegistry {

    private final Map<Plugin, PluginKeyListenerRegistry> registry = new HashMap<>();

    public Map<Plugin, PluginKeyListenerRegistry> getRegistry() {
        return registry;
    }

    public PluginKeyListenerRegistry getPluginRegistry(Plugin plugin) {
        return registry.get(plugin);
    }

    public void register(Plugin plugin, KeyboardListener listener) {
        PluginKeyListenerRegistry pluginRegistry = getPluginRegistry(plugin);
        if (pluginRegistry == null) {
            pluginRegistry = new PluginKeyListenerRegistry();
            registry.put(plugin, pluginRegistry);
        }

        pluginRegistry.register(listener);
    }

    public void unregisterAll(Plugin plugin) {
        registry.remove(plugin);
    }
}
