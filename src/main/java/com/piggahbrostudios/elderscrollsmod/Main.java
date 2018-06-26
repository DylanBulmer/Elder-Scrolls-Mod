package com.piggahbrostudios.elderscrollsmod;

import com.piggahbrostudios.elderscrollsmod.proxy.CommonProxy;
import com.piggahbrostudios.elderscrollsmod.tab.CreativeTab;
import com.piggahbrostudios.elderscrollsmod.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

    private static Logger logger;

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
        tab = new CreativeTab(CreativeTabs.getNextID(), "tab_elderscrollsmod");

        // setup pre init
        proxy.preInit(event);

        // get the logger
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        proxy.postInit(event);
    }
}
