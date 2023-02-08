package net.murren.ancientartifacts;

import net.fabricmc.api.ClientModInitializer;
import net.murren.ancientartifacts.registers.VanillaItems;

public class AncientArtifactsClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        VanillaItems.registerVanillaItems();
    }
}
