package com.piggahbrostudios.elderscrollsmod.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class Keybinds {

    public static KeyBinding MENU;

    public static void register()
    {
        // Remove Inventory KeyBind
        Minecraft.getMinecraft().gameSettings.keyBindInventory.setKeyCode(Keyboard.KEY_NONE);

        // Create new inventory bind
        MENU = new KeyBinding("Menu", Keyboard.KEY_E, "key.categories.elderscrollsmod");

        // Register new KeyBinds
        ClientRegistry.registerKeyBinding(MENU);
    }

}
