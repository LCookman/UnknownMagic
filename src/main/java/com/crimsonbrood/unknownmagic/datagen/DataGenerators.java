package com.crimsonbrood.unknownmagic.datagen;

import com.crimsonbrood.unknownmagic.UnknownMagic;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = UnknownMagic.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new UnknownMagicRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), UnknownMagicLootTableProvider.create(packOutput));

        generator.addProvider(event.includeClient(), new UnknownMagicBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new UnknownMagicItemModelProvider(packOutput, existingFileHelper));

        UnknownMagicBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new UnknownMagicBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new UnknownMagicItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));
    }
}
