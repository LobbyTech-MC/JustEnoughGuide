package com.balugaq.jeg.implementation.items;

import com.balugaq.jeg.api.groups.HiddenItemsGroup;
import com.balugaq.jeg.api.groups.NexcavateItemsGroup;
import com.balugaq.jeg.implementation.JustEnoughGuide;
import com.balugaq.jeg.utils.SlimefunItemUtil;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

/**
 * This class is responsible for registering all the JEG groups.
 *
 * @author balugaq
 * @since 1.3
 */
public class GroupSetup {
    public static JEGGuideGroup guideGroup;
    public static HiddenItemsGroup hiddenItemsGroup;
    public static NexcavateItemsGroup nexcavateItemsGroup;

    public static void setup() {
        guideGroup = new JEGGuideGroup(
                new NamespacedKey(JustEnoughGuide.getInstance(), "jeg_guide_group"),
                new CustomItemStack(Material.KNOWLEDGE_BOOK, "&b粘液科技指南操作提示"));
        guideGroup.register(JustEnoughGuide.getInstance());
        hiddenItemsGroup = new HiddenItemsGroup(
                new NamespacedKey(JustEnoughGuide.getInstance(), "hidden_items_group"),
                new CustomItemStack(Material.BARRIER, "&c隐藏物品"));
        hiddenItemsGroup.register(JustEnoughGuide.getInstance());
        nexcavateItemsGroup = new NexcavateItemsGroup(
                new NamespacedKey(JustEnoughGuide.getInstance(), "nexvacate_items_group"),
                new CustomItemStack(Material.BLACKSTONE, "&6Nexvacate 物品"));
        nexcavateItemsGroup.register(JustEnoughGuide.getInstance());
    }

    public static void shutdown() {
        SlimefunItemUtil.unregisterItemGroup(guideGroup);
        SlimefunItemUtil.unregisterItemGroup(hiddenItemsGroup);
        SlimefunItemUtil.unregisterItemGroup(nexcavateItemsGroup);
    }
}
