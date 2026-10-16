package com.smallmod.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Vex;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Mob.class)
public class MobCanAttackMixin {
	@Inject(method = "canAttack", at = @At("HEAD"), cancellable = true)
	private void smallmod$neverAttackVexOwner(LivingEntity target, CallbackInfoReturnable<Boolean> cir) {
		if ((Object) this instanceof Vex vex && target.equals(vex.getOwner())) {
			cir.setReturnValue(false);
		}
	}
}