package com.incobalt.coreapi.proxy;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

/*
    ServerProxy is a helper class that provides some useful functions to avoid a packet handler accidentally crossloading
    client classes and similar other function.
 */

public class ServerProxy implements IProxy {

    //getting the player from a context can sometimes crossload an improper class for the dist (server, or client)
    //this avoids the crash when the packet is registered.
    @Override
    public PlayerEntity getEntityFromContext(Supplier<NetworkEvent.Context> ctx){
        return ctx.get().getSender();
    }

}
