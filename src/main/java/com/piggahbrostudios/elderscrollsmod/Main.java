package com.piggahbrostudios.elderscrollsmod;

import com.piggahbrostudios.elderscrollsmod.capabilities.IStorage;
import com.piggahbrostudios.elderscrollsmod.capabilities.Storage;
import com.piggahbrostudios.elderscrollsmod.capabilities.StorageHandler;
import com.piggahbrostudios.elderscrollsmod.gui.GuiCompass;
import com.piggahbrostudios.elderscrollsmod.gui.GuiHealth;
import com.piggahbrostudios.elderscrollsmod.gui.GuiMagika;
import com.piggahbrostudios.elderscrollsmod.gui.GuiStamina;
import com.piggahbrostudios.elderscrollsmod.init.Keybinds;
import com.piggahbrostudios.elderscrollsmod.init.ModRecipes;
import com.piggahbrostudios.elderscrollsmod.proxy.CommonProxy;
import com.piggahbrostudios.elderscrollsmod.tab.CreativeTab;
import com.piggahbrostudios.elderscrollsmod.util.Reference;
import com.piggahbrostudios.elderscrollsmod.init.ModOres;
import com.piggahbrostudios.elderscrollsmod.util.handlers.HudRenderHandler;
import com.piggahbrostudios.elderscrollsmod.util.handlers.ModEventHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

    private static Logger logger;

    @CapabilityInject(IStorage.class)
    public static final Capability<IStorage> CAPABILITY_STORAGE = null;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.Instance
    public static Main instance;

    public static CreativeTab tab;

    /* Initialization Events */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        // append the creative tab into the game
        tab = new CreativeTab(CreativeTabs.getNextID(), "tab_" + Reference.MODID);

        // setup pre init
        proxy.preInit(event);
        ModOres.mainRegistry();

        CapabilityManager.INSTANCE.register(IStorage.class, new StorageHandler(), Storage::new);

        // get the logger
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        ModRecipes.init();

        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        MinecraftForge.EVENT_BUS.register(new ModEventHandler());
        proxy.postInit(event);
    }
}
