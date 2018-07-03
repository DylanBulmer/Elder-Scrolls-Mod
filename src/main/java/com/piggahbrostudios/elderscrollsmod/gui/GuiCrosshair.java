package com.piggahbrostudios.elderscrollsmod.gui;

import com.piggahbrostudios.elderscrollsmod.capabilities.IStorage;
import com.piggahbrostudios.elderscrollsmod.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.piggahbrostudios.elderscrollsmod.capabilities.Storage.getHandler;

public class GuiCrosshair extends GuiScreen {

    private final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/general.png");
    private int guiVertHeight = 7;
    private int guiVertWidth = 5;
    private int guiHorazonalHeight = 5;
    private int guiHorazonalWidth = 7;
    private int topX = 7;
    private int topY = 221;
    private int rightX = 11;
    private int rightY = 227;
    private int botX = 7;
    private int botY = 231;
    private int leftX = 1;
    private int leftY = 227;

    @SubscribeEvent
    public void renderOverlay (RenderGameOverlayEvent event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.CROSSHAIRS) {

            event.setCanceled(true);

            Minecraft mc = Minecraft.getMinecraft();
            EntityPlayer player = mc.player;
            final IStorage storage = getHandler(mc.player);

            mc.renderEngine.bindTexture(texture);

            int centerX = mc.displayWidth / 4;
            int centerY = mc.displayHeight / 4;


            if (player.isSprinting()) {
                // Sprinting

                // Top hair
                drawTexturedModalRect(centerX - (guiVertWidth/2), centerY - guiVertHeight - 5, topX, topY, guiVertWidth, guiVertHeight);
                // Right hair
                drawTexturedModalRect(centerX + 6, centerY - (guiHorazonalHeight/2), rightX, rightY, guiHorazonalWidth, guiHorazonalHeight);
                // Bottom hair
                drawTexturedModalRect(centerX - (guiVertWidth/2), centerY + 6, botX, botY, guiVertWidth, guiVertHeight);
                // Left hair
                drawTexturedModalRect(centerX - guiHorazonalWidth - 5, centerY - (guiHorazonalHeight/2), leftX, leftY, guiHorazonalWidth, guiHorazonalHeight);
            } else if (storage.isMoving()) {
                // Walking

                // Top hair
                drawTexturedModalRect(centerX - (guiVertWidth/2), centerY - guiVertHeight - 3, topX, topY, guiVertWidth, guiVertHeight);
                // Right hair
                drawTexturedModalRect(centerX + 4, centerY - (guiHorazonalHeight/2), rightX, rightY, guiHorazonalWidth, guiHorazonalHeight);
                // Bottom hair
                drawTexturedModalRect(centerX - (guiVertWidth/2), centerY + 4, botX, botY, guiVertWidth, guiVertHeight);
                // Left hair
                drawTexturedModalRect(centerX - guiHorazonalWidth - 3, centerY - (guiHorazonalHeight/2), leftX, leftY, guiHorazonalWidth, guiHorazonalHeight);
            } else {
                // Standing Still

                // Top hair
                drawTexturedModalRect(centerX - (guiVertWidth/2), centerY - guiVertHeight - 1, topX, topY, guiVertWidth, guiVertHeight);
                // Right hair
                drawTexturedModalRect(centerX + 2, centerY - (guiHorazonalHeight/2), rightX, rightY, guiHorazonalWidth, guiHorazonalHeight);
                // Bottom hair
                drawTexturedModalRect(centerX - (guiVertWidth/2), centerY + 2, botX, botY, guiVertWidth, guiVertHeight);
                // Left hair
                drawTexturedModalRect(centerX - guiHorazonalWidth - 1, centerY - (guiHorazonalHeight/2), leftX, leftY, guiHorazonalWidth, guiHorazonalHeight);
            }
        }
    }
}
