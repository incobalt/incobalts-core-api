package com.incobalt.coreapi.chat;

import com.mojang.brigadier.Message;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentUtils;

/*
    ChatUtils is a small class that adds some slight utility for working with the chat, such as creating an ITextComponent
    from a string inline.
 */

public class ChatUtils {

    /*
        toTextComponent is a quick gel function that converts a string into an ITextComponent. From what I can tell, this
        used to exist, but recently TextComponentUtils.toTextComponent requires a Message instead of a string, and
        there's no easy conversion.
     */
    public static ITextComponent toTextComponent(String text){
        return TextComponentUtils.toTextComponent(toMessage(text));
    }

    /*
        toMessage simply converts a string to a Message interface using a lambda expression, rather than an anonymous function
     */
    public static Message toMessage(String text){
        return () -> text;
    }

}
