package com.spring.extramob.datagen;

import com.spring.extramob.ExtraMob;
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
        super(output, ExtraMob.MOD_ID);
    }

    @Override
    public void registerSounds() {
        add(ModSounds.CUBEMOB_HURT.get(),definition().subtitle("sounds.templatemod.cubemob_hurt")
                .with(sound(Identifier.fromNamespaceAndPath(ExtraMob.MOD_ID,"cubemob_hurt_1")))
        );

        add(ModSounds.SANGLIER_HURT.get(),definition().subtitle("sounds.extramob.sanglier_hurt")
                .with(sound(Identifier.fromNamespaceAndPath(ExtraMob.MOD_ID,"sanglier/sanglier_noise_hurt")))
        );

        add(ModSounds.SANGLIER_NOISE.get(),definition().subtitle("sounds.extramob.sanglier_noise")
                .with(sound(Identifier.fromNamespaceAndPath(ExtraMob.MOD_ID,"sanglier/sanglier_noise_1")))
                .with(sound(Identifier.fromNamespaceAndPath(ExtraMob.MOD_ID,"sanglier/sanglier_noise_2")))
                .with(sound(Identifier.fromNamespaceAndPath(ExtraMob.MOD_ID,"sanglier/sanglier_noise_3")))
        );
    }
}
