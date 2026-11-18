package com.spring.extramob.datagen;

import com.spring.extramob.TemplateMod;
import com.spring.extramob.sound.ModSounds;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class ModSoundsProvider extends SoundDefinitionsProvider {
    /**
     * Creates a new instance of this data provider.
     *
     * @param output The {@linkplain PackOutput} instance provided by the data generator.
     */
    public ModSoundsProvider(PackOutput output) {
        super(output, TemplateMod.MOD_ID);
    }

    @Override
    public void registerSounds() {
        add(ModSounds.CUBEMOB_HURT.get(),definition().subtitle("sounds.templatemod.cubemob_hurt")
                .with(sound(Identifier.fromNamespaceAndPath(TemplateMod.MOD_ID,"cubemob_hurt_1"))));
    }
}
