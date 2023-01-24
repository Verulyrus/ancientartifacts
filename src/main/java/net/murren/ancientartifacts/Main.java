package net.murren.ancientartifacts;


import net.murren.ancientartifacts.item.ArtifactItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer {
    public static final String MOD_ID = "ancientartifacts";
    public static final Logger LOGGER = LoggerFactory.getLogger("ancientartifacts");

    @Override
    public void onInitialize() {

        ArtifactItems.registerItems();

        LOGGER.info("Mod loaded successfully.");
    }
}



