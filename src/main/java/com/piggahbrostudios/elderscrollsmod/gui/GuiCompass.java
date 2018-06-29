package com.piggahbrostudios.elderscrollsmod.gui;

import com.piggahbrostudios.elderscrollsmod.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.IOException;

public class GuiCompass extends GuiScreen {

    private final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/general.png");
    private int guiHeight = 20;
    private int guiWidth = 256;

    @SubscribeEvent
    public void renderOverlay (RenderGameOverlayEvent event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            Minecraft mc = Minecraft.getMinecraft();

            mc.renderEngine.bindTexture(texture);

            int centerX = mc.displayWidth / 4;

            GlStateManager.pushMatrix();
            {
                GlStateManager.enableAlpha();
                GlStateManager.color(1,1,1,0.5F);
                drawTexturedModalRect(centerX - (guiWidth/2), 0, 0, 0, guiWidth, guiHeight);
            }
            GlStateManager.popMatrix();
        }
    }

}
