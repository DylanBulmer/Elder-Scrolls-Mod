package com.piggahbrostudios.elderscrollsmod.gui;

import com.piggahbrostudios.elderscrollsmod.init.ModBlocks;
import com.piggahbrostudios.elderscrollsmod.init.ModItems;
import com.piggahbrostudios.elderscrollsmod.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

public class GuiInventory extends GuiScreen {

    ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/inventory.png");

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);


        int centerX = width / 2;
        int centerY = height / 2;

        // Left column (border, content, border)
        GlStateManager.pushMatrix();
        {
            GlStateManager.enableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.scale( 1, (double)height / 256, 1);
            GlStateManager.color( 1, 1, 1, 0.8F);
            drawTexturedModalRect(10, 0, 0, 0, 3, 256);
            drawTexturedModalRect(13, 0, 8, 0, 75, 256);
            drawTexturedModalRect(88, 0, 0, 0, 3, 256);
        }
        GlStateManager.popMatrix();

        // Right column (border, content, border)
        GlStateManager.pushMatrix();
        {

            GlStateManager.enableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.color(1, 1, 1, 0.8F);
            GlStateManager.scale(1, (double) height / 256, 1);
            drawTexturedModalRect(110, 0, 0, 0, 3, 256);
            drawTexturedModalRect(113, 0, 8, 0, 100, 256);
            drawTexturedModalRect(213, 0, 0, 0, 3, 256);
        }
        GlStateManager.popMatrix();

        // Right column pointer
        GlStateManager.pushMatrix();
        {
            GlStateManager.disableAlpha();
            GlStateManager.color( 1, 1, 1, 1);
            drawTexturedModalRect(203, (height - 21) / 2, 111, 79, 23, 21);
        }
        GlStateManager.popMatrix();

        // Information box content
        GlStateManager.pushMatrix();
        {
            GlStateManager.enableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.color( 1, 1, 1, 0.8F);
            GlStateManager.translate( width - ((width - 216) / 2) - 64, height - 94, 0);
            GlStateManager.scale( 2, 1, 1);
            drawTexturedModalRect(0, 0, 8, 0, 64, 63);
        }
        GlStateManager.popMatrix();

        // Information box border
        GlStateManager.pushMatrix();
        {
            GlStateManager.enableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.color( 1, 1, 1, 1);
            drawTexturedModalRect(width - ((width - 216) / 2) - 70, height - 100, 110, 0, 140, 75);
        }
        GlStateManager.popMatrix();

        drawString(fontRenderer, "Glass Sword", 115, (height - fontRenderer.FONT_HEIGHT) / 2, 0xFFFFFF);

        // Item in top right corner
        drawItemImage(new ItemStack(ModItems.GLASS_SWORD), width - ((width - 216) / 2), (height / 2), 45);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void initGui() {

        // Add buttons here

        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        switch (button.id) {

        }

        super.actionPerformed(button);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    private void drawItemImage(ItemStack is, int xPos, int yPos, float spin) {
        GlStateManager.pushMatrix();
        {
            GlStateManager.translate((float) xPos, (float) yPos, 300.0f);
            GlStateManager.rotate(190.0f, 1.0f, 0.0f, 0.0f);
            float f = spin;
            GlStateManager.rotate(f % 360.0f, 0.0f, 1.0f, 0.0f);
            GlStateManager.scale(100.0f, 100.0f, 100.0f);
            RenderHelper.enableGUIStandardItemLighting();
            this.mc.getRenderItem().renderItem(is, ItemCameraTransforms.TransformType.GROUND);
            RenderHelper.disableStandardItemLighting();
        }
        GlStateManager.popMatrix();
    }
}
