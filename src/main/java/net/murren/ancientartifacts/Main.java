package net.murren.ancientartifacts;


import net.murren.ancientartifacts.Registers.ArtifactItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.api.ModInitializer;

import static net.murren.ancientartifacts.util.sendLog.logMessage;

public class Main implements ModInitializer {
    public static final String MOD_ID = "ancientartifacts";
    public static final Logger LOGGER = LoggerFactory.getLogger("ancientartifacts");

    @Override
    public void onInitialize() {

        ArtifactItems.registerItems();

        logMessage("Loaded successfully.");
    }
}



