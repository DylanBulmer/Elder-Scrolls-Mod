package com.piggahbrostudios.elderscrollsmod.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class Keybinds {

    public static KeyBinding MENU;

    public static void register()
    {
        // Get Minecraft instance
        Minecraft mc = Minecraft.getMinecraft();

        // Remove Inventory KeyBind
        mc.gameSettings.keyBindInventory.setKeyCode(Keyboard.KEY_NONE);

        // Remove Hotbar keybinds
        KeyBinding[] hotbar = mc.gameSettings.keyBindsHotbar;

        for (int i = 0; i < hotbar.length; i++) {
            hotbar[i].setKeyCode(Keyboard.KEY_NONE);
        }

        // Create new inventory bind
        MENU = new KeyBinding("Menu", Keyboard.KEY_E, "key.categories.elderscrollsmod");

        // Register new KeyBinds
        ClientRegistry.registerKeyBinding(MENU);
    }

}
