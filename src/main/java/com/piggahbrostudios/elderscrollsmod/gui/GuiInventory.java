package com.piggahbrostudios.elderscrollsmod.gui;

import com.piggahbrostudios.elderscrollsmod.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuiInventory extends GuiScreen {

    private ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/inventory.png");

    private String[] itemTypes = new String[]{ "FAVORITES", "ALL", "WEAPONS", "ARMOR", "FOOD", "BOOKS", "MISC" };
    private List<ItemStack> inventory;
    private List<ItemStack> foodList;
    private List<ItemStack> miscList;
    private List<ItemStack> weaponList;
    private List<ItemStack> armorList;
    private List<ItemStack> bookList;
    private int itemSelected = 0;
    private int colSelected = 0;
    private int typeSelected = 1;
    private Item selected = null;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {

        int textHeight = fontRenderer.FONT_HEIGHT + 5;
        int textCenter = (height - fontRenderer.FONT_HEIGHT + 3) / 2;

        drawDefaultBackground();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);

        // reset arrays
        inventory = new ArrayList<>();
        foodList = new ArrayList<>();
        miscList = new ArrayList<>();
        weaponList = new ArrayList<>();
        armorList = new ArrayList<>();
        bookList = new ArrayList<>();

        int size = mc.player.inventory.getSizeInventory();

        for (int i = 0; i < size; i++) {
            // grab the ItemStack from the player's inventory
            ItemStack stack = mc.player.inventory.getStackInSlot(i);
            // Check if it is empty
            if (!stack.isEmpty()) {

                // Add the Item to the everything List
                inventory.add(stack);

                // get item to test for its type
                Item item = stack.getItem();

                if (item instanceof ItemBook ||
                        item instanceof ItemEnchantedBook || item instanceof ItemWritableBook ||
                        item instanceof ItemWrittenBook || item instanceof ItemKnowledgeBook) {
                    // if it is any type of book
                    bookList.add(stack);
                } else if (item instanceof ItemFood) {
                    // if it is a food
                    foodList.add(stack);
                } else if (item instanceof ItemSword ||
                        item instanceof ItemArrow || item instanceof ItemBow ||
                        item instanceof ItemPotion || item instanceof ItemShield) {
                    // if it is any weapon
                    weaponList.add(stack);
                } else if (item instanceof ItemArmor) {
                    // if it is armor
                    armorList.add(stack);
                } else if (!(item instanceof ItemAir)) {
                    // if not anything else and not air
                    miscList.add(stack);
                }
            }
        }

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

        // Left column text
        for (int i = 0; i < itemTypes.length; i++) {
            if (i != typeSelected) {
                drawString(fontRenderer, itemTypes[i], 15, textCenter + (textHeight * i) - (textHeight * typeSelected), 0xAAAAAA);
            } else {
                drawString(fontRenderer, itemTypes[i], 15, textCenter + (textHeight * i) - (textHeight * typeSelected), 0xFFFFFF);
            }
        }

        // Right column text
        List<ItemStack> list = getList(typeSelected);
        if (!list.isEmpty()) {
            drawItemList(list, 0);
        }

        if (selected != null) {
            // Item in top right corner
            drawItemImage(new ItemStack(selected), width - ((width - 216) / 2), (height / 2) - 20, 45);

            // Draw the item's name that is displayed
            drawCenteredString(fontRenderer, selected.getItemStackDisplayName(new ItemStack(selected)), width - ((width - 216) / 2), height - 109, 0xFFFFFF);
        }
        
        // draw the navigation bar at the bottom
        drawNav();

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    private int drawItemList(List<ItemStack> list, int seek) {
        if (seek < list.size()) {
            // Constants
            int textHeight = fontRenderer.FONT_HEIGHT + 5;
            int textCenter = (height - fontRenderer.FONT_HEIGHT + 3) / 2;
            // item being used
            Item item = list.get(seek).getItem();

            if (seek != itemSelected) {
                drawString(fontRenderer, item.getItemStackDisplayName(list.get(seek)), 115, textCenter + (textHeight * seek) - (textHeight * itemSelected), 0xAAAAAA);
            } else {
                drawString(fontRenderer, item.getItemStackDisplayName(list.get(seek)), 115, textCenter + (textHeight * seek) - (textHeight * itemSelected), 0xFFFFFF);
            }

            return drawItemList(list, seek+1);
        } else {
            return seek;
        }
    }

    private void updateSelected (int type, int index) {
        List<ItemStack> list = getList(type);
        if (!list.isEmpty()) this.selected = list.get(index).getItem();
        else this.selected = null;
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
        /*
        switch (button.id) {

        }
        */

        super.actionPerformed(button);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {

        List list = getList(typeSelected);

        switch (keyCode) {
            case 200:
            case 17:
                // up arrow or [w]
                if (colSelected == 1) {
                    if (itemSelected > 0) {
                        this.itemSelected -= 1;
                        this.updateSelected(typeSelected, itemSelected);
                    }
                } else if (colSelected == 0) {
                    if (typeSelected > 0) {
                        this.typeSelected -= 1;
                        this.itemSelected = 0;
                        this.updateSelected(typeSelected, itemSelected);
                    }
                }
                break;
            case 203:
            case 30:
                // left
                if (colSelected > 0) {
                    this.colSelected -= 1;
                }
                break;
            case 205:
            case 32:
                //right
                if (colSelected < 1) {
                    this.colSelected += 1;
                }
                break;
            case 208:
            case 31:
                // down arrow
                if (colSelected == 1) {
                    if (itemSelected < list.size() - 1) {
                        this.itemSelected += 1;
                        this.updateSelected(typeSelected, itemSelected);
                    }
                } else if (colSelected == 0) {
                    if (typeSelected < itemTypes.length - 1) {
                        this.typeSelected += 1;
                        this.itemSelected = 0;
                        this.updateSelected(typeSelected, itemSelected);
                    }
                }
                break;
            case 18:
                // [E] - Equip
                mc.player.inventory.setPickedItemStack(new ItemStack(selected));
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

    private List<ItemStack> getList (int type) {

        switch (type) {
            case 0:
                return new ArrayList<>();
            case 1:
                return inventory;
            case 2:
                return weaponList;
            case 3:
                return armorList;
            case 4:
                return foodList;
            case 5:
                return bookList;
            case 6:
                return miscList;
            default:
                return new ArrayList<>();
        }
    }

    private void drawNav () {

        Minecraft.getMinecraft().renderEngine.bindTexture(texture);

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

        // Navigation text
        drawString(fontRenderer, "[ E ] Equip", 34 + fontRenderer.getStringWidth("Navigate") + 5, height - (fontRenderer.FONT_HEIGHT + 5), 0xFFFFFF);

    }
}
