package com.piggahbrostudios.elderscrollsmod.gui;

import com.piggahbrostudios.elderscrollsmod.init.ModItems;
import com.piggahbrostudios.elderscrollsmod.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

public class GuiMenu extends GuiScreen {

    ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/compass.png");
    int guiHeight = 150;
    int guiWidth = 256;

    GuiButton items;

    final int ITEMS = 0;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);

        int imageCenterX = (width - guiWidth) / 2;
        int imageCenterY = (height - guiHeight) / 2;
        int centerX = width / 2;
        int centerY = height / 2;

        drawTexturedModalRect(imageCenterX, imageCenterY,0,20, guiWidth, guiHeight);

        drawCenteredString(fontRenderer, "Skills", centerX, centerY - (55 + fontRenderer.FONT_HEIGHT), 0xFFFFFF);
        //drawString(fontRenderer, "Items", centerX + 90, centerY - 5, 0xFFFFFF);
        items.x = centerX + 90;
        items.y = centerY - (fontRenderer.FONT_HEIGHT / 2);


        GlStateManager.pushMatrix();
        {
            GlStateManager.translate(centerX + 50, centerY - 100, 0);
            GlStateManager.scale(4,4,1);
            mc.getRenderItem().renderItemAndEffectIntoGUI(new ItemStack(ModItems.ELVEN_DAGGER), 0,0);
        }
        GlStateManager.popMatrix();

        drawCenteredString(fontRenderer, "Map", centerX, centerY + 55, 0xFFFFFF);
        drawString(fontRenderer, "Magic", centerX - (90 + fontRenderer.getStringWidth("Magic")) , centerY - 5, 0xFFFFFF);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void initGui() {

        buttonList.clear();
        buttonList.add(items = new GuiButton(ITEMS, 0, 0, fontRenderer.getStringWidth("Items"),fontRenderer.FONT_HEIGHT, "Items"));

        super.initGui();
    }

    public void updateButtons() {
        items.enabled = true;
        items.visible = true;
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        switch (button.id) {
            case ITEMS:
                Minecraft.getMinecraft().displayGuiScreen(new GuiInventory(Minecraft.getMinecraft().player));
                break;
        }

        updateButtons();

        super.actionPerformed(button);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return true;
    }
}
