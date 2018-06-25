package com.piggahbrostudios.elderscrollsmod;

import com.piggahbrostudios.elderscrollsmod.proxy.CommonProxy;
import com.piggahbrostudios.elderscrollsmod.tab.CreativeTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ElderScrollsMod.MODID, name = ElderScrollsMod.NAME, version = ElderScrollsMod.VERSION)
public class ElderScrollsMod {
    public static final String MODID = "elderscrollsmod";
    public static final String NAME = "Elder Scrolls Mod";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @SidedProxy(clientSide = "com.piggahbrostudios.elderscrollsmod.proxy.ClientProxy", serverSide = "com.piggahbrostudios.elderscrollsmod.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static ElderScrollsMod instance;

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
