package com.crimsonbrood.unknownmagic;

import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.builders.NoConfigBuilder;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.function.Consumer;

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

    /**
     * Implement our own creative tab handling, so we don't create an "itemGroup" Lang entry
     */
    public <P> NoConfigBuilder<CreativeModeTab, CreativeModeTab, P> creativeTab(String name, P parent, Consumer<CreativeModeTab.Builder> config) {
        this.defaultCreativeTab(ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(UnknownMagic.MODID, name)));
        return this.generic(parent, name, Registries.CREATIVE_MODE_TAB, () -> {
            CreativeModeTab.Builder builder = CreativeModeTab.builder();
            config.accept(builder);
            return builder.build();
        });
    }

    /**
     * Get all of our registered items
     *
     * @return Collection of item registry entries
     */
    public Collection<RegistryEntry<Item>> getRegisteredItems() {
        return UnknownMagic.REGISTRATE.getAll(ForgeRegistries.ITEMS.getRegistryKey());
    }
}
