package me.hexsook.kblapi;

import me.hexsook.kblapi.api.Key;
import me.hexsook.kblapi.api.KeyListenerRegistry;
import me.hexsook.kblapi.api.KeyboardListener;
import me.hexsook.kblapi.api.PluginKeyListenerRegistry;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.Plugin;

import java.util.Map;

public class KeyboardListeners implements Listener {

    @EventHandler(
            priority = EventPriority.NORMAL,
            ignoreCancelled = true
    )
    public void shiftKey(PlayerToggleSneakEvent event) {
        if (event.isSneaking()) {
            return;
        }
        trigger(Key.SHIFT, event.getPlayer());
    }

    @EventHandler(
            priority = EventPriority.NORMAL,
            ignoreCancelled = true
    )
    public void fKey(PlayerSwapHandItemsEvent event) {
        Player player = event.getPlayer();
        if (player.isSneaking()) {
            System.out.println("Sneaking");
            if (trigger(Key.SHIFT_F, player)) {
                event.setCancelled(true);
            }
            return;
        }
        if (trigger(Key.F, player)) {
            event.setCancelled(true);
        }
    }

    @EventHandler(
            priority = EventPriority.NORMAL,
            ignoreCancelled = true
    )
    public void qKey(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (player.isSneaking()) {
            if (trigger(Key.SHIFT_Q, player)) {
                event.setCancelled(true);
            }
            return;
        }
        if (trigger(Key.Q, player)) {
            event.setCancelled(true);
        }
    }

    private boolean trigger(Key key, Player player) {
        KeyListenerRegistry keyListenerRegistry =  KBLPlugin.getAPI().getListenerRegistry().get(key);
        if (keyListenerRegistry == null) {
            return false;
        }
        Map<Plugin, PluginKeyListenerRegistry> pluginKeyListenerRegistryMap = keyListenerRegistry.getRegistry();
        if (pluginKeyListenerRegistryMap == null || pluginKeyListenerRegistryMap.isEmpty()) {
            return false;
        }
        for (PluginKeyListenerRegistry value : pluginKeyListenerRegistryMap.values()) {
            for (KeyboardListener keyboardListener : value.getRegistry()) {
                keyboardListener.pressed(player);
                return true;
            }
        }
        return false;
    }
}