package com.spring.extramob.entity.client.Sanglier;// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.spring.extramob.entity.client.Sanglier.SanglierRenderState;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class SanglierModel extends EntityModel<SanglierRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	protected  final ModelPart Sanglier;
	protected  final ModelPart upper_body_group;
	protected  final ModelPart Head;
	protected  final ModelPart earsR;
	protected  final ModelPart earsL;
	protected  final ModelPart Butt;
	protected  final ModelPart lower_body_group;
	protected  final ModelPart l_leg;
	protected  final ModelPart l_leg2;
	protected  final ModelPart r_leg;
	protected  final ModelPart r_leg2;
	protected  final KeyframeAnimation walkingAnimation;
	protected  final KeyframeAnimation idleAnimation;

	public SanglierModel(ModelPart root) {
		super(root);
		this.Sanglier = root.getChild("SanglierModel");
		this.upper_body_group = this.Sanglier.getChild("upper_body_group");
		this.Head = this.upper_body_group.getChild("Head");
		this.earsR = this.Head.getChild("earsR");
		this.earsL = this.Head.getChild("earsL");
		this.Butt = this.upper_body_group.getChild("Butt");
		this.lower_body_group = this.Sanglier.getChild("lower_body_group");
		this.l_leg = this.lower_body_group.getChild("l_leg");
		this.l_leg2 = this.lower_body_group.getChild("l_leg2");
		this.r_leg = this.lower_body_group.getChild("r_leg");
		this.r_leg2 = this.lower_body_group.getChild("r_leg2");

		walkingAnimation = SanglierAnimations.Walk.bake(root);
		idleAnimation = SanglierAnimations.Idle.bake(root);
	}

	@Override
	public void setupAnim(SanglierRenderState state) {
		this.root.getAllParts().forEach(p -> {resetPose();});
		this.applyHeadRotation(state.yRot,state.xRot);

		this.walkingAnimation.applyWalk(state.walkAnimationPos,state.walkAnimationSpeed,2f,2.5f);
		this.idleAnimation.apply(state.idleAnimationState,state.ageInTicks,1);
	}

	private void applyHeadRotation(float headYaw, float headPitch) {
		headYaw = Mth.clamp(headYaw, -30f, 30f);
		headPitch = Mth.clamp(headPitch, -25f, 45);

		this.Head.yRot = headYaw * ((float)Math.PI / 180f);
		this.Head.xRot = headPitch *  ((float)Math.PI / 180f);
	}
}