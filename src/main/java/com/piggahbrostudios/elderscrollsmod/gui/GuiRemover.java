package com.piggahbrostudios.elderscrollsmod.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GuiRemover extends Gui {

    @SubscribeEvent
    public void renderOverlay (RenderGameOverlayEvent event) {

        if (event.getType() == RenderGameOverlayEvent.ElementType.FOOD) {
            event.setCanceled(true);
        } else if (event.getType() == RenderGameOverlayEvent.ElementType.EXPERIENCE) {
            event.setCanceled(true);
        } else if (event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR) {
            event.setCanceled(true);
        } else if (event.getType() == RenderGameOverlayEvent.ElementType.ARMOR) {
            event.setCanceled(true);
        }
    }
}
