package com.spring.extramob.event;

import com.spring.extramob.TemplateMod;
import com.spring.extramob.entity.ModEntities;
import com.spring.extramob.entity.custom.CubeMobEntity;
import com.spring.extramob.entity.custom.GiraffeEntity;
import com.spring.extramob.entity.custom.PuffBallEntity;
import com.spring.extramob.entity.custom.WarTurtleEntity;
import com.spring.extramob.item.ModItems;
import com.spring.extramob.potion.ModPotion;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@EventBusSubscriber(modid = TemplateMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        event.getBuilder().addMix(Potions.AWKWARD, ModItems.TEST_ITEM.asItem(), ModPotion.TEST_POTION);
    }

    @SubscribeEvent
    public static void onRegisterAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.CUBEMOB.get(), CubeMobEntity.createCubeMobAttributes().build());
        event.put(ModEntities.PUFFBALL.get(), PuffBallEntity.createPuffBallAttributes().build());
        event.put(ModEntities.WAR_TURTLE.get(), WarTurtleEntity.createWarTurtleAttributes().build());
        event.put(ModEntities.GIRAFFE.get(), GiraffeEntity.createGiraffeAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacement(RegisterSpawnPlacementsEvent event) {
        event.register(ModEntities.GIRAFFE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                PathfinderMob::checkMobSpawnRules,RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }


}
