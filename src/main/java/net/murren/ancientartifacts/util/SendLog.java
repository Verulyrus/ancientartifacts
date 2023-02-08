package net.murren.ancientartifacts.util;

import net.murren.ancientartifacts.AncientArtifactsMod;

import static net.murren.ancientartifacts.AncientArtifactsMod.MOD_ID;

public class SendLog {
    public static void logMessage(String msg)
    {
        AncientArtifactsMod.LOGGER.info(" ["+MOD_ID+"] : " + msg);
    }
}
