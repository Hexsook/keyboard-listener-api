package io.github.hexsook.kblapi;

import io.github.hexsook.kblapi.api.KeyboardListenerAPI;
import org.bukkit.plugin.java.JavaPlugin;

public class KBLPlugin extends JavaPlugin {

    private static KBLPlugin instance;
    private static KeyboardListenerAPI api;

    @Override
    public void onEnable() {
        instance = this;
        api = new KeyboardListenerAPI();
        KeyboardListenerAPI.set(api);

        getServer().getPluginManager().registerEvents(new KeyboardListeners(), this);

        getLogger().info("Finished loading, thanks for using KeyboardListenerAPI by Hexsook!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Goodbye, thanks for using KeyboardListenerAPI by Hexsook!");
    }

    public static KBLPlugin getInstance() {
        return instance;
    }

    public static KeyboardListenerAPI getAPI() {
        return api;
    }
}
