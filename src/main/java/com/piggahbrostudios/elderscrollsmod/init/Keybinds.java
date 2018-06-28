package com.piggahbrostudios.elderscrollsmod.init;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class Keybinds {

    public static KeyBinding MENU;

    public static void register()
    {
        MENU = new KeyBinding("Menu", Keyboard.KEY_V, "key.categories.elderscrollsmod");

        ClientRegistry.registerKeyBinding(MENU);
    }

}
