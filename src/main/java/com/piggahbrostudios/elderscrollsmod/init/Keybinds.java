package com.piggahbrostudios.elderscrollsmod.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

public class Keybinds {

    public static KeyBinding MENU;
    public static List<KeyBinding> disabledBinds = new ArrayList<>();

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

        disabledBinds.add(new KeyBinding("", Keyboard.KEY_1, ""));
        disabledBinds.add(new KeyBinding("", Keyboard.KEY_2, ""));
        disabledBinds.add(new KeyBinding("", Keyboard.KEY_3, ""));
        disabledBinds.add(new KeyBinding("", Keyboard.KEY_4, ""));
        disabledBinds.add(new KeyBinding("", Keyboard.KEY_5, ""));
        disabledBinds.add(new KeyBinding("", Keyboard.KEY_6, ""));
        disabledBinds.add(new KeyBinding("", Keyboard.KEY_7, ""));
        disabledBinds.add(new KeyBinding("", Keyboard.KEY_8, ""));
        disabledBinds.add(new KeyBinding("", Keyboard.KEY_9, ""));

        for (int i = 0; i < disabledBinds.size(); i++) {
            ClientRegistry.registerKeyBinding(disabledBinds.get(i));
        }

        // Create new inventory bind
        MENU = new KeyBinding("Menu", Keyboard.KEY_E, "key.categories.elderscrollsmod");

        // Register new KeyBinds
        ClientRegistry.registerKeyBinding(MENU);
    }

}
