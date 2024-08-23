package com.crimsonbrood.unknownmagic.datagen;

import com.crimsonbrood.unknownmagic.EtherRegistrate;
import com.crimsonbrood.unknownmagic.UnknownMagic;

public class EtherLang {
    /**
     * TODO: This is temporary we should convert it to a more registrate friendly approach
     * Manually create tooltip entries for Registrates datagen logic
     */
    public static void genData() {
        EtherRegistrate reg = UnknownMagic.REGISTRATE;

        reg.addRawLang("tooltip.unknownmagic.ether_detector.tooltip", "Finds concentrated ether and valuables.");
        reg.addRawLang("tooltip.unknownmagic.sound_block.tooltip", "Hey look a didgeridoo!");
    }
}
