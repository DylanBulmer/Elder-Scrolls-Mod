package com.piggahbrostudios.elderscrollsmod.gui;

import com.piggahbrostudios.elderscrollsmod.capabilities.IStorage;
import com.piggahbrostudios.elderscrollsmod.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.piggahbrostudios.elderscrollsmod.capabilities.Storage.getHandler;

public class GuiMagika extends Gui {

    private final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/general.png");
    private int guiHeight = 13;
    private int guiWidth = 120;

    private int bar_width = 98;
    private int bar_x = 11;
    private int bar_y = 210;

    @SubscribeEvent
    public void renderOverlay (RenderGameOverlayEvent event) {

        Minecraft mc = Minecraft.getMinecraft();
        final IStorage storage = getHandler(mc.player);

        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT && !storage.isMagikaFull()) {

            mc.renderEngine.bindTexture(texture);

            ScaledResolution resolution = new ScaledResolution(mc);

            int bottomY = resolution.getScaledHeight();

            GlStateManager.pushMatrix();
            {
                GlStateManager.enableAlpha();
                GlStateManager.enableBlend();
                GlStateManager.color(1,1,1,0.5F);
                drawTexturedModalRect(30, bottomY - 30, 0, 170, guiWidth, guiHeight);
            }
            GlStateManager.popMatrix();

            float oneUnit = (float)bar_width / storage.getMaxMagika();
            int currentWidth = (int)(oneUnit * storage.getMagika());

            GlStateManager.pushMatrix();
            {
                GlStateManager.color(1,1,1,1);
                drawTexturedModalRect(30 + ((guiWidth - bar_width) / 2) + ((bar_width - currentWidth)/2), bottomY - 26, bar_x + (bar_width - currentWidth), bar_y, currentWidth, 5);
            }
            GlStateManager.popMatrix();
        }
    }

}
