package com.piggahbrostudios.elderscrollsmod.util.handlers;

import com.piggahbrostudios.elderscrollsmod.gui.GuiMenu;
import com.piggahbrostudios.elderscrollsmod.init.Keybinds;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class KeyInputHandler {
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event)
    {
        if (Keybinds.MENU.isPressed())
        {
            // Open menu
            Minecraft.getMinecraft().displayGuiScreen(new GuiMenu());
        }

        // NOT WORKING?!?!
        for (int i = 0; i < Keybinds.disabledBinds.size(); i++) {
            if (Keybinds.disabledBinds.get(i).isPressed()) {
                if (event.isCancelable()) {
                    event.setCanceled(true);
                }
            }
        }
    }
}
