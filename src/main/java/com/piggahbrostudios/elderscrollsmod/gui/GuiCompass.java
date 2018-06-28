package com.piggahbrostudios.elderscrollsmod.gui;

import com.piggahbrostudios.elderscrollsmod.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

public class GuiCompass extends GuiScreen {

    ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/compass.png");
    int guiHeight = 20;
    int guiWidth = 256;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);

        int centerX = (width - guiWidth) / 2;

        drawTexturedModalRect(centerX,5,0,0, guiWidth, guiHeight);

        super.drawScreen(mouseX, mouseY, partialTicks);

    }

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
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
