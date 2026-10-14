package com.smallmod.client.model;

import com.smallmod.SmallMod;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.util.Mth;

public class BlubModel extends EntityModel<LivingEntityRenderState> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(SmallMod.id("blub"), "main");
	private final ModelPart body;
	private final ModelPart legs;
	private final ModelPart back_left_leg;
	private final ModelPart back_right_leg;
	private final ModelPart front_left_leg;
	private final ModelPart front_right_leg;
	private final ModelPart left_ear;
	private final ModelPart right_ear;
	

	public BlubModel(ModelPart root) {
		super(root);
		this.body = root.getChild("body");
        this.legs = root.getChild("legs");
		this.back_left_leg = legs.getChild("back_left_leg");
		this.back_right_leg = legs.getChild("back_right_leg");
		this.front_left_leg = legs.getChild("front_left_leg");
		this.front_right_leg = legs.getChild("front_right_leg");
		this.left_ear = body.getChild("left_ear");
		this.right_ear = body.getChild("right_ear");

	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition legs = partdefinition.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition back_left_leg = legs.addOrReplaceChild("back_left_leg", CubeListBuilder.create().texOffs(40, 10).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 3.5F));

		PartDefinition back_right_leg = legs.addOrReplaceChild("back_right_leg", CubeListBuilder.create().texOffs(40, 10).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, 3.5F));

		PartDefinition front_left_leg = legs.addOrReplaceChild("front_left_leg", CubeListBuilder.create().texOffs(40, 10).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, -3.0F));

		PartDefinition front_right_leg = legs.addOrReplaceChild("front_right_leg", CubeListBuilder.create().texOffs(40, 10).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, -3.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -7.0F, -4.0F, 10.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition left_ear = body.addOrReplaceChild("left_ear", CubeListBuilder.create().texOffs(41, 2).addBox(-1.5F, -3.0F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -7.0F, -2.5F));

		PartDefinition right_ear = body.addOrReplaceChild("right_ear", CubeListBuilder.create().texOffs(41, 2).addBox(-1.5F, -3.0F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -7.0F, -2.5F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
    public void setupAnim(LivingEntityRenderState state) {
        super.setupAnim(state);
		float phase = state.walkAnimationPos * 0.4442F;
        float strength = state.walkAnimationSpeed;

		float swing = Mth.cos(phase) * 0.5F * strength;
        float swingBack = Mth.cos(phase + Mth.PI) * 0.5F * strength;
        back_right_leg.xRot  = swing;
        back_left_leg.xRot   = swingBack;
        front_right_leg.xRot = swingBack;
        front_left_leg.xRot  = swing;

		// Lift each leg by the sine of its tilt (in pixels, y is down). The legs are 2 px deep, so this keeps the top of a
		// tilted leg from dropping below the body and the foot from sinking into the floor.
		for (ModelPart leg : new ModelPart[] {back_left_leg, back_right_leg, front_left_leg, front_right_leg}) {
			leg.y -= Mth.abs(Mth.sin(leg.xRot));
		}
	}


}