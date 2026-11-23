package com.spring.extramob.entity.client.VoidProwler;// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.spring.extramob.entity.client.VoidProwler.VoidProwlerRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class VoidProwlerModel extends EntityModel<VoidProwlerRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
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

	public VoidProwlerModel(ModelPart root) {
        super(root);
        this.VoidProwler = root.getChild("VoidProwlerModel");
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
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition VoidProwler = partdefinition.addOrReplaceChild("VoidProwlerModel", CubeListBuilder.create(), PartPose.offset(0.0F, -11.0F, -4.0F));

		PartDefinition upper_body_group = VoidProwler.addOrReplaceChild("upper_body_group", CubeListBuilder.create(), PartPose.offset(0.0F, 13.0F, 5.0F));

		PartDefinition P1 = upper_body_group.addOrReplaceChild("P1", CubeListBuilder.create().texOffs(48, 0).addBox(-3.0F, -3.0F, -2.0F, 6.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition P2 = P1.addOrReplaceChild("P2", CubeListBuilder.create().texOffs(48, 7).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 15).addBox(-3.0F, -6.0F, 2.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(48, 17).addBox(-3.0F, -4.0F, 2.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = P2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 49).addBox(-3.0F, -4.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 23).addBox(-3.0F, -6.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, -1.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r2 = P2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(48, 21).addBox(-3.0F, -4.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(48, 19).addBox(-3.0F, -6.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, -1.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition P3 = P2.addOrReplaceChild("P3", CubeListBuilder.create().texOffs(0, 17).addBox(-6.0F, -5.0F, -3.0F, 12.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 1.0F));

		PartDefinition cube_r3 = P3.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(42, 23).addBox(-5.0F, 0.0F, -2.0F, 10.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.4F, -1.8F, 0.1745F, 0.0F, 0.0F));

		PartDefinition l_arm = P3.addOrReplaceChild("l_arm", CubeListBuilder.create().texOffs(34, 0).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 19.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.5F, -5.0F, -1.0F));

		PartDefinition r_arm = P3.addOrReplaceChild("r_arm", CubeListBuilder.create().texOffs(28, 26).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 19.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(7.5F, -5.0F, -1.0F));

		PartDefinition Head = P3.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(42, 39).addBox(-3.0F, 0.0F, -5.6F, 6.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -8.0F, -5.6F, 8.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -4.0F));

		PartDefinition lower_body_group = VoidProwler.addOrReplaceChild("lower_body_group", CubeListBuilder.create().texOffs(42, 32).addBox(-5.0F, -3.0F, 3.0F, 10.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition l_leg = lower_body_group.addOrReplaceChild("l_leg", CubeListBuilder.create().texOffs(0, 26).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 19.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 0.0F, 5.0F));

		PartDefinition r_leg = lower_body_group.addOrReplaceChild("r_leg", CubeListBuilder.create().texOffs(14, 26).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 19.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 0.0F, 5.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(VoidProwlerRenderState state) {
		super.setupAnim(state);
	}

}