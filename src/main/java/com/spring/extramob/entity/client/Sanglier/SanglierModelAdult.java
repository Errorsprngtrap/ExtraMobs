package com.spring.extramob.entity.client.Sanglier;// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class SanglierModelAdult extends EntityModel<SanglierRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart Sanglier;
	private final ModelPart upper_body_group;
	private final ModelPart Head;
	private final ModelPart HornR;
	private final ModelPart HornL;
	private final ModelPart earsR;
	private final ModelPart earsL;
	private final ModelPart Butt;
	private final ModelPart lower_body_group;
	private final ModelPart l_leg;
	private final ModelPart l_leg2;
	private final ModelPart r_leg;
	private final ModelPart r_leg2;
	private final KeyframeAnimation walkingAnimation;
	private final KeyframeAnimation idleAnimation;

	public SanglierModelAdult(ModelPart root) {
		super(root);
		this.Sanglier = root.getChild("SanglierModel");
		this.upper_body_group = this.Sanglier.getChild("upper_body_group");
		this.Head = this.upper_body_group.getChild("Head");
		this.HornR = this.Head.getChild("HornR");
		this.HornL = this.Head.getChild("HornL");
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

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Sanglier = partdefinition.addOrReplaceChild("SanglierModel", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition upper_body_group = Sanglier.addOrReplaceChild("upper_body_group", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -4.0F, -5.0F, 9.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -7.0F, 0.0F));

		PartDefinition Head = upper_body_group.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 32).addBox(-6.0F, 0.0F, -2.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 18).addBox(-4.0F, -3.0F, -4.0F, 4.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, 0.0F));

		PartDefinition HornR = Head.addOrReplaceChild("HornR", CubeListBuilder.create().texOffs(38, 2).addBox(-2.0F, -1.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 2.0F, -2.5F, 0.0F, -0.2618F, 0.0F));

		PartDefinition cube_r1 = HornR.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(38, 4).addBox(-2.0F, -1.0F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -2.5F, 0.0F, 0.0F, 0.6109F));

		PartDefinition HornL = Head.addOrReplaceChild("HornL", CubeListBuilder.create().texOffs(38, 0).addBox(-2.0F, -1.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 2.0F, 2.5F, 0.0F, 0.2618F, 0.0F));

		PartDefinition cube_r2 = HornL.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(38, 6).addBox(-2.0F, -1.0F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -2.5F, 0.0F, 0.0F, 0.6109F));

		PartDefinition earsR = Head.addOrReplaceChild("earsR", CubeListBuilder.create().texOffs(34, 37).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -3.0F, -4.0F));

		PartDefinition earsL = Head.addOrReplaceChild("earsL", CubeListBuilder.create().texOffs(28, 37).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -3.0F, 4.0F));

		PartDefinition Butt = upper_body_group.addOrReplaceChild("Butt", CubeListBuilder.create().texOffs(24, 18).addBox(0.0F, -3.0F, -4.0F, 2.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 0.0F));

		PartDefinition lower_body_group = Sanglier.addOrReplaceChild("lower_body_group", CubeListBuilder.create(), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition l_leg = lower_body_group.addOrReplaceChild("l_leg", CubeListBuilder.create().texOffs(28, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, 3.0F));

		PartDefinition l_leg2 = lower_body_group.addOrReplaceChild("l_leg2", CubeListBuilder.create().texOffs(12, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -1.0F, 3.0F));

		PartDefinition r_leg = lower_body_group.addOrReplaceChild("r_leg", CubeListBuilder.create().texOffs(36, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -3.0F));

		PartDefinition r_leg2 = lower_body_group.addOrReplaceChild("r_leg2", CubeListBuilder.create().texOffs(20, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -1.0F, -3.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
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