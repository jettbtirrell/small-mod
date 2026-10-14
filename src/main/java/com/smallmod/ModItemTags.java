package com.smallmod;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> BLUB_FOOD = TagKey.create(Registries.ITEM, SmallMod.id("blub_food"));
}
