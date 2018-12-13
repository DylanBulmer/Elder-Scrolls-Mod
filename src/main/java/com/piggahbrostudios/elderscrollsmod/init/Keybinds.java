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

        new KeyBinding("", Keyboard.KEY_1, "");
        new KeyBinding("", Keyboard.KEY_2, "");
        new KeyBinding("", Keyboard.KEY_3, "");
        new KeyBinding("", Keyboard.KEY_4, "");
        new KeyBinding("", Keyboard.KEY_5, "");
        new KeyBinding("", Keyboard.KEY_6, "");
        new KeyBinding("", Keyboard.KEY_7, "");
        new KeyBinding("", Keyboard.KEY_8, "");
        new KeyBinding("", Keyboard.KEY_9, "");

        // Create new inventory bind
        MENU = new KeyBinding("Menu", Keyboard.KEY_E, "key.categories.elderscrollsmod");

        // Register new KeyBinds
        ClientRegistry.registerKeyBinding(MENU);
    }

}
