package com.balugaq.jeg.core.listeners;

import com.balugaq.jeg.api.groups.SearchGroup;
import io.github.thebusybiscuit.slimefun4.api.events.SlimefunItemRegistryFinalizedEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class SearchGroupInitListener implements Listener {
    @EventHandler
    public void onInit(SlimefunItemRegistryFinalizedEvent event) {
        SearchGroup.init();
    }
}
