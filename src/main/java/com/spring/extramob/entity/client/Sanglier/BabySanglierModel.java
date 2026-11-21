package com.spring.extramob.entity.client.Sanglier;// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.spring.extramob.entity.client.Sanglier.SanglierModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class BabySanglierModel extends SanglierModel {

	public BabySanglierModel(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition BabySanglier = partdefinition.addOrReplaceChild("BabySanglierModel", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition upper_body_group = BabySanglier.addOrReplaceChild("upper_body_group", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, -4.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition Head = upper_body_group.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(8, 26).addBox(-5.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(18, 14).addBox(-3.0F, -3.0F, -3.0F, 3.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -1.0F, 0.0F));

		PartDefinition earsR = Head.addOrReplaceChild("earsR", CubeListBuilder.create().texOffs(28, 8).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -3.0F, -3.0F));

		PartDefinition earsL = Head.addOrReplaceChild("earsL", CubeListBuilder.create().texOffs(28, 4).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -3.0F, 3.0F));

		PartDefinition Butt = upper_body_group.addOrReplaceChild("Butt", CubeListBuilder.create().texOffs(0, 14).addBox(0.0F, -2.0F, -4.0F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -1.0F, 0.0F));

		PartDefinition lower_body_group = BabySanglier.addOrReplaceChild("lower_body_group", CubeListBuilder.create(), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition l_leg = lower_body_group.addOrReplaceChild("l_leg", CubeListBuilder.create().texOffs(26, 25).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 1.0F, 3.0F));

		PartDefinition l_leg2 = lower_body_group.addOrReplaceChild("l_leg2", CubeListBuilder.create().texOffs(18, 25).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 0.0F, 3.0F));

		PartDefinition r_leg = lower_body_group.addOrReplaceChild("r_leg", CubeListBuilder.create().texOffs(28, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 1.0F, -3.0F));

		PartDefinition r_leg2 = lower_body_group.addOrReplaceChild("r_leg2", CubeListBuilder.create().texOffs(0, 26).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 0.0F, -3.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}


}