package com.spring.extramob.worldgen;

import com.spring.extramob.ExtraMob;
import com.spring.extramob.entity.ModEntities;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.Weighted;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;

public class ModBiomeModifiers {
    //place resource_key here
    public static final ResourceKey<BiomeModifier> SPAWN_SANGLIER = registerKey("spawn_sanglier");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        //mobs
        context.register(SPAWN_SANGLIER, new BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(
                        biomes.getOrThrow(Biomes.FOREST),
                        biomes.getOrThrow(Biomes.BIRCH_FOREST),
                        biomes.getOrThrow(Biomes.FLOWER_FOREST)),
                WeightedList.of(List.of(new Weighted<>(new MobSpawnSettings.SpawnerData(ModEntities.SANGLIER.get(),
                        1,8),5)))
        ));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name){
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(ExtraMob.MOD_ID,name));
    }
}
