package com.spring.extramob.event;

import com.spring.extramob.ExtraMob;
import com.spring.extramob.networking.ServerBoundPackets;
import com.spring.extramob.networking.packet.TestPacketC2S;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(modid = ExtraMob.MOD_ID)
public class ModPackageEvents {

    @SubscribeEvent
    public static void RegisterPayloads(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar("1");

        registrar.playToServer(TestPacketC2S.TYPE,TestPacketC2S.STREAM_CODEC, ServerBoundPackets::handleTestPacket);
    }
}
