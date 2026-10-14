package com.smallmod.entity;

import org.jspecify.annotations.Nullable;

import com.smallmod.ModItemTags;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Blub extends TamableAnimal {
    
    public Blub(EntityType<? extends Blub> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
		return Animal.createAnimalAttributes().add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.MAX_HEALTH, 8.0).add(Attributes.ATTACK_DAMAGE, 2.0);
	}

    @Override
	public boolean isFood(final ItemStack itemStack) {
		return itemStack.is(ModItemTags.BLUB_FOOD);
	}

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel arg0, AgeableMob arg1) {
        return null;
    }
    
}
