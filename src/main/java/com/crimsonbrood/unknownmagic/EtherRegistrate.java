package com.crimsonbrood.unknownmagic;

import com.tterrag.registrate.AbstractRegistrate;
import net.minecraftforge.eventbus.api.IEventBus;
import org.jetbrains.annotations.NotNull;

public class EtherRegistrate extends AbstractRegistrate<EtherRegistrate> {

    protected EtherRegistrate(String modid) {
        super(modid);
    }

    public static EtherRegistrate create(String modid) {
        return new EtherRegistrate(modid);
    }

    @Override
    protected @NotNull EtherRegistrate registerEventListeners(IEventBus bus) {
        return super.registerEventListeners(bus);
    }

    // TODO: Implement the RegistrateRecipeProvider in order to continue
}
