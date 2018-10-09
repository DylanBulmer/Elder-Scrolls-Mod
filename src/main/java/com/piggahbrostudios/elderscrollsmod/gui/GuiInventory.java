package com.piggahbrostudios.elderscrollsmod.gui;

import com.piggahbrostudios.elderscrollsmod.init.ModBlocks;
import com.piggahbrostudios.elderscrollsmod.init.ModItems;
import com.piggahbrostudios.elderscrollsmod.item.ItemBase;
import com.piggahbrostudios.elderscrollsmod.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;

import java.io.IOException;

public class GuiInventory extends GuiScreen {

    private ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/inventory.png");

    private String[] itemTypes = new String[]{ "FAVORITES", "ALL", "WEAPONS", "ARMOR", "FOOD", "BOOKS", "MISC" };
    private Item[] inventory = new Item[]{ ModItems.MOONSTONE_INGOT, ModItems.MALACHITE_INGOT, ModItems.STEEL_INGOT, ModItems.GLASS_SWORD, Items.APPLE };
    private int itemSelected = 0;
    private int colSelected = 0;
    private int typeSelected = 0;
    private Item selected = inventory[itemSelected];

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);


        int centerX = width / 2;
        int centerY = height / 2;

        // Left column content
        GlStateManager.pushMatrix();
        {
            GlStateManager.enableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.scale( 1, (double)height / 256, 1);
            if (colSelected != 0) {
                GlStateManager.color(1, 1, 1, 0.8F);
            } else {
                GlStateManager.color(0, 0, 0, 0.2F);
            }
            drawTexturedModalRect(10, 0, 2, 0, 81, 256);
        }
        GlStateManager.popMatrix();

        // Left column borders
        GlStateManager.pushMatrix();
        {
            GlStateManager.enableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.scale( 1, (double) height / 256, 1);
            GlStateManager.color( 1, 1, 1, 0.8F);
            drawTexturedModalRect(11, 2, 0, 0, 1, 252);
            drawTexturedModalRect(89, 2, 0, 0, 1, 252);
        }
        GlStateManager.popMatrix();

        /*
        // Left column pointer
        GlStateManager.pushMatrix();
        {
            GlStateManager.disableAlpha();
            GlStateManager.color( 1, 1, 1, 1);
            drawTexturedModalRect(78, (height - 21) / 2, 111, 79, 23, 21);
        }
        GlStateManager.popMatrix();
        */

        // Right column content box
        GlStateManager.pushMatrix();
        {
            GlStateManager.enableBlend();
            GlStateManager.enableAlpha();
            if (colSelected != 1) {
                GlStateManager.color(1, 1, 1, 0.8F);
            } else {
                GlStateManager.color(0, 0, 0, 0.2F);
            }
            GlStateManager.translate(110,0,0);
            GlStateManager.scale(2, (double) height / 256, 1);
            drawTexturedModalRect(0, 0, 2, 0, 53, 256);
        }
        GlStateManager.popMatrix();

        // Right column border lines
        GlStateManager.pushMatrix();
        {
            GlStateManager.enableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.color(1, 1, 1, 0.8F);
            GlStateManager.scale(1, (double)height / 256, 1);
            drawTexturedModalRect(111, 2, 0, 0, 1, 252);
            drawTexturedModalRect(214, 2, 0, 0, 1, 252);
        }
        GlStateManager.popMatrix();

        /*
        // Right column pointer
        GlStateManager.pushMatrix();
        {
            GlStateManager.disableAlpha();
            GlStateManager.color( 1, 1, 1, 1);
            drawTexturedModalRect(203, (height - 21) / 2, 111, 79, 23, 21);
        }
        GlStateManager.popMatrix();
        */

        // Information box content
        GlStateManager.pushMatrix();
        {
            GlStateManager.enableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.color( 1, 1, 1, 0.6F);
            GlStateManager.translate( width - ((width - 216) / 2) - 64, height - 114, 0);
            GlStateManager.scale( 2, 1, 1);
            drawTexturedModalRect(0, 0, 8, 0, 64, 63);
        }
        GlStateManager.popMatrix();

        // Information box border
        GlStateManager.pushMatrix();
        {
            GlStateManager.color( 1, 1, 1, 1);
            drawTexturedModalRect(width - ((width - 216) / 2) - 70, height - 120, 110, 0, 140, 75);
        }
        GlStateManager.popMatrix();

        // bottom navigation info
        GlStateManager.pushMatrix();
        {
            GlStateManager.enableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.color(0, 0, 0, 0.5F);
            GlStateManager.translate(0,height - 25,0);
            GlStateManager.scale((double) width / 50, 1, 1);
            drawTexturedModalRect(0, 0, 2, 0, 50, 25);
        }
        GlStateManager.popMatrix();

        // bottom navigation info border
        GlStateManager.pushMatrix();
        {
            GlStateManager.enableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.color(1, 1, 1, 1);
            GlStateManager.translate(3,height - 23,0);
            GlStateManager.scale(width - 6, 1, 1);
            drawTexturedModalRect(0, 0, 0, 0, 1, 1);
        }
        GlStateManager.popMatrix();

        // navigation arrows
        GlStateManager.pushMatrix();
        {
            GlStateManager.enableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.color(1, 1, 1, 1);
            GlStateManager.translate(11,(float) height - 7.5,0);
            GlStateManager.rotate(180, 0, 0, 1);
            GlStateManager.scale(0.5, 0.5, 1);
            drawTexturedModalRect(0, 0, 256-11, 256-11, 11, 11);
        }
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        {
            GlStateManager.enableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.color(1, 1, 1, 1);
            GlStateManager.translate(12,height - 13,0);
            GlStateManager.scale(0.5, 0.5, 1);
            drawTexturedModalRect(0, 0, 256-11, 256-11, 11, 11);
        }
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        {
            GlStateManager.enableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.color(1, 1, 1, 1);
            GlStateManager.translate(23,height - 13,0);
            GlStateManager.rotate(90, 0, 0, 1);
            GlStateManager.scale(0.5, 0.5, 1);
            drawTexturedModalRect(0, 0, 256-11, 256-11, 11, 11);
        }
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        {
            GlStateManager.enableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.color(1, 1, 1, 1);
            GlStateManager.translate(23,(float) height - 7.5,0);
            GlStateManager.rotate(270, 0, 0, 1);
            GlStateManager.scale(0.5, 0.5, 1);
            drawTexturedModalRect(0, 0, 256-11, 256-11, 11, 11);
        }
        GlStateManager.popMatrix();

        // Navigation text
        drawString(fontRenderer, "Navigate", 34, height - (fontRenderer.FONT_HEIGHT + 5), 0xFFFFFF);

        int textHeight = fontRenderer.FONT_HEIGHT + 5;
        int textCenter = (height - fontRenderer.FONT_HEIGHT + 3) / 2;

        // Left column text
        for (int i = 0; i < itemTypes.length; i++) {
            if (i != typeSelected) {
                drawString(fontRenderer, itemTypes[i], 15, textCenter + (textHeight * i) - (textHeight * typeSelected), 0xAAAAAA);
            } else {
                drawString(fontRenderer, itemTypes[i], 15, textCenter + (textHeight * i) - (textHeight * typeSelected), 0xFFFFFF);
            }
        }

        // Right column text
        for (int i = 0; i < inventory.length; i++) {
            if (i != itemSelected) {
                drawString(fontRenderer, inventory[i].getItemStackDisplayName(new ItemStack(inventory[i])), 115, textCenter + (textHeight * i) - (textHeight * itemSelected), 0xAAAAAA);
            } else {
                drawString(fontRenderer, inventory[i].getItemStackDisplayName(new ItemStack(inventory[i])), 115, textCenter + (textHeight * i) - (textHeight * itemSelected), 0xFFFFFF);
            }
        }

        // Item in top right corner
        drawItemImage(new ItemStack(selected), width - ((width - 216) / 2), (height / 2) - 20, 45);

        // Draw the item's name that is displayed
        drawCenteredString(fontRenderer, selected.getItemStackDisplayName(new ItemStack(selected)), width - ((width - 216) / 2), height - 109, 0xFFFFFF);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public void updateItemDisplay() {
        drawItemImage(new ItemStack(selected), width - ((width - 216) / 2), (height / 2), 45);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
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

        switch (keyCode) {
            case 200:
                // up arrow
                if (colSelected == 1) {
                    if (itemSelected > 0) {
                        this.itemSelected -= 1;
                        this.selected = inventory[itemSelected];
                    }
                } else if (colSelected == 0) {
                    if (typeSelected > 0) {
                        this.typeSelected -= 1;
                    }
                }
                break;
            case 203:
                // left
                if (colSelected > 0) {
                    this.colSelected -= 1;
                }
                break;
            case 205:
                //right
                if (colSelected < 1) {
                    this.colSelected += 1;
                }
                break;
            case 208:
                // down arrow
                if (colSelected == 1) {
                    if (itemSelected < inventory.length - 1) {
                        this.itemSelected += 1;
                        this.selected = inventory[itemSelected];
                    }
                } else if (colSelected == 0) {
                    if (typeSelected < itemTypes.length - 1) {
                        this.typeSelected += 1;
                    }
                }
                break;
        }

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
            GlStateManager.rotate(spin % 360.0f, 0.0f, 1.0f, 0.0f);
            GlStateManager.scale(100.0f, 100.0f, 100.0f);
            RenderHelper.enableGUIStandardItemLighting();
            this.mc.getRenderItem().renderItem(is, ItemCameraTransforms.TransformType.GROUND);
            RenderHelper.disableStandardItemLighting();
        }
        GlStateManager.popMatrix();
    }
}
