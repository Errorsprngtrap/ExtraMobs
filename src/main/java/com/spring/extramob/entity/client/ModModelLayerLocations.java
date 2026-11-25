package com.spring.extramob.entity.client;

import com.spring.extramob.ExtraMob;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;

public class ModModelLayerLocations {
    public static final ModelLayerLocation SANGLIER =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(ExtraMob.MOD_ID,"sanglier"),"main");

    public static final ModelLayerLocation BABY_SANGLIER =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(ExtraMob.MOD_ID,"baby_sanglier"),"main");

    public static final ModelLayerLocation VOIDPROWLER =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(ExtraMob.MOD_ID,"voidprowler"),"main");

    public static final ModelLayerLocation VOIDPROWLER_EYE =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(ExtraMob.MOD_ID,"voidprowler_eye"),"eye");


    public static final ModelLayerLocation CUBEMOB =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(ExtraMob.MOD_ID,"cubemob"),"main");

    public static final ModelLayerLocation PUFFBALL =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(ExtraMob.MOD_ID,"puffball"),"main");

    public static final ModelLayerLocation WARTURTLE =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(ExtraMob.MOD_ID,"warturtle"),"main");

    public static final ModelLayerLocation WARTURTLE_ARMOR =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(ExtraMob.MOD_ID,"warturtle_armor"),"armor");

    public static final ModelLayerLocation GIRAFFE =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(ExtraMob.MOD_ID,"giraffe"),"main");

    public static final ModelLayerLocation GIRAFFE_SADDLE =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(ExtraMob.MOD_ID,"giraffe_saddle"),"saddle");

    public static final ModelLayerLocation ROCK =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(ExtraMob.MOD_ID,"rock"),"main");
}
