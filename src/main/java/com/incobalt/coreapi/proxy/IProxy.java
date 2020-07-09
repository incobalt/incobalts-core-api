package com.incobalt.coreapi.proxy;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

/*
    IProxy is a class that performs some proxy server/client helper functions in the case of a packet handler needing to
    avoid accessing improper code for server or client. This is an interface class and needs to be implemented.
    This is based by example on how Mine and Slash does it.
 */

public interface IProxy {

    //getting the player from a context can sometimes crossload an improper class for the dist (server, or client)
    //this avoids the crash when the packet is registered.
    PlayerEntity getEntityFromContext(Supplier<NetworkEvent.Context> ctx);
}
