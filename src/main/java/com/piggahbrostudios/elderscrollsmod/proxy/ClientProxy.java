package com.piggahbrostudios.elderscrollsmod.proxy;

import com.piggahbrostudios.elderscrollsmod.Main;
import com.piggahbrostudios.elderscrollsmod.gui.*;
import com.piggahbrostudios.elderscrollsmod.init.Keybinds;
import com.piggahbrostudios.elderscrollsmod.util.handlers.GuiHandler;
import com.piggahbrostudios.elderscrollsmod.util.handlers.HudRenderHandler;
import com.piggahbrostudios.elderscrollsmod.util.handlers.KeyInputHandler;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {

        // keybind handler
        MinecraftForge.EVENT_BUS.register(new KeyInputHandler());
        Keybinds.register();

        MinecraftForge.EVENT_BUS.register(new HudRenderHandler());

    }

    @Override
    public void init(FMLInitializationEvent event) {

        // All the Gui stuff
        NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());

        MinecraftForge.EVENT_BUS.register(new GuiCompass());
        MinecraftForge.EVENT_BUS.register(new GuiCrosshair());

        MinecraftForge.EVENT_BUS.register(new GuiMagika());
        MinecraftForge.EVENT_BUS.register(new GuiHealth());
        MinecraftForge.EVENT_BUS.register(new GuiStamina());

        // Gui Remover
        MinecraftForge.EVENT_BUS.register(new GuiRemover());
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
    }
}
