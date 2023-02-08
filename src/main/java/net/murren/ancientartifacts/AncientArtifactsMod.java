package net.murren.ancientartifacts;


import net.murren.ancientartifacts.registers.ArtifactEffects;
import net.murren.ancientartifacts.registers.ArtifactItems;
import net.murren.ancientartifacts.registers.VanillaItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.api.ModInitializer;

import static net.murren.ancientartifacts.util.SendLog.logMessage;

public class AncientArtifactsMod implements ModInitializer {
    public static final String MOD_ID = "ancientartifacts";
    public static final Logger LOGGER = LoggerFactory.getLogger("ancientartifacts");

    @Override
    public void onInitialize() {

        ArtifactItems.registerItems();
        VanillaItems.registerVanillaItems();
        ArtifactEffects.registerArtifactEffects();

        logMessage("Loaded successfully.");
    }
}


