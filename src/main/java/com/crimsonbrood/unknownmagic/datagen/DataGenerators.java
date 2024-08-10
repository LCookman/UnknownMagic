package com.crimsonbrood.unknownmagic.datagen;

import com.crimsonbrood.unknownmagic.UnknownMagic;
import com.tterrag.registrate.providers.ProviderType;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.concurrent.CompletableFuture;

import static com.crimsonbrood.unknownmagic.UnknownMagic.REGISTRATE;

@Mod.EventBusSubscriber(modid = UnknownMagic.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

//        REGISTRATE.setDataGenerator(ProviderType.RECIPE, new EtherRecipeProvider(REGISTRATE, packOutput));
        REGISTRATE.setDataGenerator("EtherRecipes", ForgeRegistries.RECIPE_SERIALIZERS.getRegistryKey(), ProviderType.RECIPE, provider ->  new EtherRecipeProvider(provider, packOutput));
        REGISTRATE.addDataGenerator(ProviderType.LOOT, (provider) -> UnknownMagicLootTableProvider.create(packOutput));
//        generator.addProvider(event.includeServer(), new EtherRecipeProvider(packOutput));
//        generator.addProvider(event.includeServer(), UnknownMagicLootTableProvider.create(packOutput));

//        generator.addProvider(event.includeClient(), new UnknownMagicBlockStateProvider(packOutput, existingFileHelper));
//        generator.addProvider(event.includeClient(), new UnknownMagicItemModelProvider(packOutput, existingFileHelper));

        UnknownMagicBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new UnknownMagicBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new UnknownMagicItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));
    }
}
