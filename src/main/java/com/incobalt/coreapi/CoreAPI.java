package com.incobalt.coreapi;

import com.incobalt.coreapi.proxy.ClientProxy;
import com.incobalt.coreapi.proxy.IProxy;
import com.incobalt.coreapi.proxy.ServerProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
    incobalt's Core API
    This is a tiny API mod for use with incobalt's other mods.
 */

// The value here should match an entry in the META-INF/mods.toml file
@Mod("incobalts_coreapi")
public class CoreAPI
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    //sets up the client or server proxy. This is to avoid crashes when packets are registered that may crossload
    //classes invalid for the dist
    public static IProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);

    public CoreAPI() {

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

    }

    // Use @SubscribeEvent for methods that want to attach to an event
    // The method name doesn't matter, just the event type in the arguments!
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // FMLServerStartingEvent triggers when the server starts
        // This is where you put code for initializing the mod

        //Send information to the log that acts as a header so you can find your mod easier
        LOGGER.info("incobalt's Core API");

    }

}
