package com.piggahbrostudios.elderscrollsmod.gui;

import com.piggahbrostudios.elderscrollsmod.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GuiCompass extends GuiScreen {

    private final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/general.png");
    private int guiHeight = 20;
    private int guiWidth = 256;
    private int innerGui = 200;

    @SubscribeEvent
    public void renderOverlay (RenderGameOverlayEvent event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            Minecraft mc = Minecraft.getMinecraft();
            EntityPlayer player = mc.player;

            mc.renderEngine.bindTexture(texture);

            ScaledResolution resolution = new ScaledResolution(mc);

            int centerX = resolution.getScaledWidth() / 2;

            GlStateManager.pushMatrix();
            {
                GlStateManager.enableAlpha();
                GlStateManager.enableBlend();
                GlStateManager.color(1,1,1,0.5F);
                drawTexturedModalRect(centerX - (guiWidth/2), 0, 0, 0, guiWidth, guiHeight);
            }
            GlStateManager.popMatrix();

            String rightDirection = "Nothing";
            String leftDirection = "Nothing";

            int rightRotation = MathHelper.floor((double)(((player.rotationYaw + 45) * 4.0F) / 360.0F) + 0.5D) & 3;
            int leftRotation = MathHelper.floor((double)(((player.rotationYaw - 45) * 4.0F) / 360.0F) + 0.5D) & 3;
            int degree = MathHelper.floor((double)player.rotationYaw % 90);
            float oneUnit = (float)innerGui / 90;

            if (degree < 0) {
                degree = 90 - Math.abs(degree);
            }

            switch (rightRotation) {
                case 0:
                    rightDirection = "S";
                    break;
                case 1:
                    rightDirection = "W";
                    break;
                case 2:
                    rightDirection = "N";
                    break;
                case 3:
                    rightDirection = "E";
                    break;
            }

            switch (leftRotation) {
                case 0:
                    leftDirection = "S";
                    break;
                case 1:
                    leftDirection = "W";
                    break;
                case 2:
                    leftDirection = "N";
                    break;
                case 3:
                    leftDirection = "E";
                    break;
            }

            if (degree < 45) {
                drawCenteredString(mc.fontRenderer, leftDirection, centerX - (int) (oneUnit * degree), 2 + (guiHeight - mc.fontRenderer.FONT_HEIGHT) / 2, 0xFFFFFF);
            } else {
                drawCenteredString(mc.fontRenderer, rightDirection, centerX + innerGui - (int)(oneUnit * degree), 2 + (guiHeight - mc.fontRenderer.FONT_HEIGHT)/2, 0xFFFFFF);
            }
        }
    }

}
