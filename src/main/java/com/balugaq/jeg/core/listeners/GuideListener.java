package com.balugaq.jeg.core.listeners;

import com.balugaq.jeg.implementation.JustEnoughGuide;
import com.balugaq.jeg.utils.GuideUtil;
import io.github.thebusybiscuit.slimefun4.api.events.SlimefunGuideOpenEvent;
import io.github.thebusybiscuit.slimefun4.api.player.PlayerProfile;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideImplementation;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

/**
 * This class listens to {@link SlimefunGuideOpenEvent}
 * and opens the corresponding guide for the player.
 *
 * @author balugaq
 * @since 1.0
 */
public class GuideListener implements Listener {
    @EventHandler(priority = EventPriority.LOW)
    public void onGuideOpen(@NotNull SlimefunGuideOpenEvent e) {
        if (!e.isCancelled()) {
            e.setCancelled(true);

            openGuide(e.getPlayer(), e.getGuideLayout());
        }
    }

    public void openGuide(@NotNull Player player, @NotNull SlimefunGuideMode mode) {
        Optional<PlayerProfile> optional = PlayerProfile.find(player);

        if (optional.isPresent()) {
            PlayerProfile profile = optional.get();
            SlimefunGuideImplementation guide = GuideUtil.getGuide(player, mode);
            profile.getGuideHistory().openLastEntry(guide);
        } else {
            GuideUtil.openMainMenuAsync(player, mode, 1);
        }
    }
}
