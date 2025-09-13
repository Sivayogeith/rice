package net.sage.rice.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.sage.rice.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                createShaped(RecipeCategory.MISC, ModItems.RICEBALL)
                        .pattern(" D ")
                        .pattern("DWD")
                        .pattern(" D ")
                        .input('D', ModItems.RICE_DUST)
                        .input('W', Items.POTION)
                        .criterion(hasItem(ModItems.RICE_DUST), conditionsFromItem(ModItems.RICE_DUST))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "Rice Recipes";
    }
}
