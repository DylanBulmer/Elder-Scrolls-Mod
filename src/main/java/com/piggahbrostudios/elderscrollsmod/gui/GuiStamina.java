package com.piggahbrostudios.elderscrollsmod.gui;

import com.piggahbrostudios.elderscrollsmod.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GuiStamina extends Gui {

    private final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/general.png");
    private int guiHeight = 13;
    private int guiWidth = 120;

    private int bar_width = 98;
    private int bar_x = 11;
    private int bar_y = 200;

    @SubscribeEvent
    public void renderOverlay (RenderGameOverlayEvent event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            Minecraft mc = Minecraft.getMinecraft();

            mc.renderEngine.bindTexture(texture);

            int width = mc.displayWidth / 2;
            int bottomY = mc.displayHeight / 2;

            GlStateManager.pushMatrix();
            {
                GlStateManager.enableAlpha();
                GlStateManager.color(1,1,1,0.5F);
                drawTexturedModalRect(width - 30 - guiWidth, bottomY - 30, 0, 170, guiWidth, guiHeight);
                GlStateManager.resetColor();
            }
            GlStateManager.popMatrix();

            float oneUnit = (float)bar_width / mc.player.getMaxHealth();
            int currentWidth = (int)(oneUnit * mc.player.getHealth());

            drawTexturedModalRect(width - 30 - guiWidth + ((guiWidth - bar_width) / 2),bottomY - 26,bar_x + (currentWidth - bar_width), bar_y, currentWidth,5);
        }
    }

}
