package com.smallmod.entity.goal;

import java.util.EnumSet;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Vex;

public class VexFollowOwnerGoal extends Goal {
	private static final double START_FOLLOW_DIST_SQ = 4.0 * 4.0;
	private static final double TELEPORT_DIST_SQ = 24.0 * 24.0;

	private final Vex vex;

	public VexFollowOwnerGoal(Vex vex) {
		this.vex = vex;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE));
	}

	@Override
	public boolean canUse() {
		LivingEntity owner = this.vex.getOwner();
		return owner != null && owner.isAlive();
	}

	@Override
	public boolean requiresUpdateEveryTick() {
		return true;
	}

	@Override
	public void tick() {
		LivingEntity owner = this.vex.getOwner();
		if (owner == null) return;

		double distSq = this.vex.distanceToSqr(owner);
		if (distSq > TELEPORT_DIST_SQ) {
			this.vex.teleportTo(owner.getX(), owner.getY() + 1.0, owner.getZ());
		} else if (distSq > START_FOLLOW_DIST_SQ && !this.vex.getMoveControl().hasWanted()) {
			this.vex.getMoveControl().setWantedPosition(owner.getX(), owner.getY() + 1.5, owner.getZ(), 1.0);
		}
	}
}