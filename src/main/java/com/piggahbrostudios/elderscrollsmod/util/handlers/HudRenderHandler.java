package com.piggahbrostudios.elderscrollsmod.util.handlers;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HudRenderHandler {

    private Minecraft mc;

    @SubscribeEvent
    public void onHudRender(RenderGameOverlayEvent.Pre event) {

        mc = Minecraft.getMinecraft();

        if (Minecraft.getMinecraft().currentScreen == null) {

            if (event.getType() == ElementType.AIR) {
                event.setCanceled(true);
            } else if (event.getType() == ElementType.HEALTHMOUNT) {
                event.setCanceled(true);
            } else if (event.getType() == ElementType.JUMPBAR) {
                event.setCanceled(true);
//            } else if (event.getType() == ElementType.BOSSHEALTH) {
//                event.setCanceled(true);
            }

        }

    }
}
