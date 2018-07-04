package com.piggahbrostudios.elderscrollsmod.gui;

import com.piggahbrostudios.elderscrollsmod.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

public class GuiMenuButton extends GuiButton {

    ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/general.png");

    Minecraft mc = Minecraft.getMinecraft();

    String text;
    boolean isCentered;
    int u = 0;
    int v = 20;

    public GuiMenuButton (int buttonId, int x, int y, String text, boolean isCentered) {
        super(buttonId, x, y, Minecraft.getMinecraft().fontRenderer.getStringWidth(text), Minecraft.getMinecraft().fontRenderer.FONT_HEIGHT, text);

        this.text = text;
        this.isCentered = isCentered;
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
        if (visible) {
            mc.renderEngine.bindTexture(texture);

            if (this.isCentered) {
                // Is centered
                drawTexturedModalRect((float)(x - getButtonWidth() / 2), y, u, v, width, height);

                if (mouseX >= x - (width/2) && mouseX <= x + (width/2) && mouseY >= y && mouseY <= y + height) {
                    // Is hovered
                    drawCenteredString(this.mc.fontRenderer, this.text, this.x, this.y, 0xFFFFFF);
                } else {
                    // Is not hovered
                    drawCenteredString(this.mc.fontRenderer, this.text, this.x, this.y, 0xCCCCCC);
                }
            } else {
                // Is not centered
                drawTexturedModalRect(this.x, this.y, this.u, this.v, width, height);

                if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
                    // Is hovered
                    drawString(this.mc.fontRenderer, this.text, this.x, this.y, 0xFFFFFF);
                } else {
                    // Is not hovered
                    drawString(this.mc.fontRenderer, this.text, this.x, this.y, 0xCCCCCC);
                }
            }
        }
    }
}
