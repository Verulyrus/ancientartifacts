package net.murren.ancientartifacts.util;

import net.murren.ancientartifacts.Main;

import static net.murren.ancientartifacts.Main.MOD_ID;

public class sendLog {
    public static void logMessage(String msg)
    {
        Main.LOGGER.info(" ["+MOD_ID+"] : " + msg);
    }
}
