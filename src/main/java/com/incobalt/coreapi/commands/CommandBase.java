package com.incobalt.coreapi.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;

import java.util.ArrayList;


/*
    CommandBase is a class that all our commands inherit. This is used to easily manage all custom commands from the mod.
    This is an abstract class, so it cannot be used by itself. Classes that inherit this must implement
    a constructor and the registerCommand function (which is the main part of the class!
    TODO: Move this to API mod
 */
public abstract class CommandBase {

    //a local copy of the aliases associated with this command
    protected final String[] aliases;

    //the constructor that takes an ArrayList and converts it to a local array.
    //realistically, this could be done better. Derived classes must implelent a constructor, but it just needs to call super(a)
    public CommandBase(ArrayList<String> a){
        aliases = a.toArray(new String[0]);
    }

    //this is where the command magic happens. Every derived class needs this for creating a command in the game!
    public abstract void registerCommand(CommandDispatcher<CommandSource> dispatcher);

}
