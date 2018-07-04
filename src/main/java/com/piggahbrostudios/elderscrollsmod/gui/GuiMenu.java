package com.piggahbrostudios.elderscrollsmod.gui;

import com.piggahbrostudios.elderscrollsmod.init.ModItems;
import com.piggahbrostudios.elderscrollsmod.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

public class GuiMenu extends GuiScreen {

    ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/general.png");
    int guiHeight = 150;
    int guiWidth = 256;

    GuiMenuButton skills;
    GuiMenuButton items;
    GuiMenuButton map;
    GuiMenuButton magic;

    final int SKILLS = 0;
    final int ITEMS = 1;
    final int MAP = 2;
    final int MAGIC = 3;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);

        int imageCenterX = (width - guiWidth) / 2;
        int imageCenterY = (height - guiHeight) / 2;
        int centerX = width / 2;
        int centerY = height / 2;

        drawTexturedModalRect(imageCenterX, imageCenterY,0,20, guiWidth, guiHeight);

        skills.x = centerX;
        skills.y = centerY - (55 + fontRenderer.FONT_HEIGHT);
        items.x = centerX + 90;
        items.y = centerY - (fontRenderer.FONT_HEIGHT / 2);
        map.x = centerX;
        map.y = centerY + 55;
        magic.x = centerX - (90 + fontRenderer.getStringWidth("Magic"));
        magic.y = centerY - (fontRenderer.FONT_HEIGHT / 2);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void initGui() {

        buttonList.clear();
        buttonList.add(skills = new GuiMenuButton(SKILLS, 0, 0, "Skills", true));
        buttonList.add(items = new GuiMenuButton(ITEMS, 0, 0, "MC Items", false));
        buttonList.add(map = new GuiMenuButton(MAP, 0, 0, "Mod Items", true));
        buttonList.add(magic = new GuiMenuButton(MAGIC, 0, 0, "Magic", false));

        super.initGui();
    }

    public void updateButtons() {
        items.enabled = true;
        items.visible = true;
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        switch (button.id) {
            case SKILLS:
                break;
            case ITEMS:
                Minecraft.getMinecraft().displayGuiScreen(new GuiInventory(Minecraft.getMinecraft().player));
                break;
            case MAP:
                mc.displayGuiScreen(new com.piggahbrostudios.elderscrollsmod.gui.GuiInventory());
                break;
            case MAGIC:
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
        return false;
    }
}
