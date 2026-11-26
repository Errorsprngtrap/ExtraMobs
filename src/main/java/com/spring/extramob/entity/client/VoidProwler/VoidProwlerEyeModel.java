package com.spring.extramob.entity.client.VoidProwler;// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class VoidProwlerEyeModel extends EntityModel<VoidProwlerRenderState> {
	private final ModelPart VoidProwler;
	private final ModelPart upper_body_group;
	private final ModelPart P1;
	private final ModelPart P2;
	private final ModelPart P3;
	private final ModelPart l_arm;
	private final ModelPart r_arm;
	private final ModelPart Head;
	private final ModelPart lower_body_group;
	private final ModelPart l_leg;
	private final ModelPart r_leg;

	protected  final KeyframeAnimation walkingAnimation;
	protected  final KeyframeAnimation idleAnimation;

	public VoidProwlerEyeModel(ModelPart root) {
        super(root);
        this.VoidProwler = root.getChild("VoidProwler");
		this.upper_body_group = this.VoidProwler.getChild("upper_body_group");
		this.P1 = this.upper_body_group.getChild("P1");
		this.P2 = this.P1.getChild("P2");
		this.P3 = this.P2.getChild("P3");
		this.l_arm = this.P3.getChild("l_arm");
		this.r_arm = this.P3.getChild("r_arm");
		this.Head = this.P3.getChild("Head");
		this.lower_body_group = this.VoidProwler.getChild("lower_body_group");
		this.l_leg = this.lower_body_group.getChild("l_leg");
		this.r_leg = this.lower_body_group.getChild("r_leg");

		walkingAnimation = VoidProwlerAnimations.Walk.bake(root);
		idleAnimation = VoidProwlerAnimations.Idle.bake(root);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition VoidProwler = partdefinition.addOrReplaceChild("VoidProwler", CubeListBuilder.create(), PartPose.offset(0.0F, -11.0F, -4.0F));

		PartDefinition upper_body_group = VoidProwler.addOrReplaceChild("upper_body_group", CubeListBuilder.create(), PartPose.offset(0.0F, 13.0F, 5.0F));

		PartDefinition P1 = upper_body_group.addOrReplaceChild("P1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition P2 = P1.addOrReplaceChild("P2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition P3 = P2.addOrReplaceChild("P3", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, 1.0F));

		PartDefinition l_arm = P3.addOrReplaceChild("l_arm", CubeListBuilder.create(), PartPose.offset(-7.5F, -5.0F, -1.0F));

		PartDefinition r_arm = P3.addOrReplaceChild("r_arm", CubeListBuilder.create(), PartPose.offset(7.5F, -5.0F, -1.0F));

		PartDefinition Head = P3.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(6, 0).addBox(-2.0F, -4.0F, -5.6F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(4, 0).addBox(1.0F, -4.0F, -5.6F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, -7.0F, -5.6F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 3).addBox(-1.0F, -7.0F, -5.6F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(2, 2).addBox(-2.0F, -6.0F, -5.6F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(2, 3).addBox(1.0F, -6.0F, -5.6F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -4.0F));

		PartDefinition lower_body_group = VoidProwler.addOrReplaceChild("lower_body_group", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition l_leg = lower_body_group.addOrReplaceChild("l_leg", CubeListBuilder.create(), PartPose.offset(-3.5F, 0.0F, 5.0F));

		PartDefinition r_leg = lower_body_group.addOrReplaceChild("r_leg", CubeListBuilder.create(), PartPose.offset(3.5F, 0.0F, 5.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(VoidProwlerRenderState state) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
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