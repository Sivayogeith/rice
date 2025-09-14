package net.sage.rice.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.sage.rice.block.ModBlocks;
import net.sage.rice.block.custom.RiceCropBlock;
import net.sage.rice.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCrop(ModBlocks.RICE_CROP, RiceCropBlock.AGE, 0,1,2,3,4,5,6,7);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RICEBALL, Models.GENERATED);
        itemModelGenerator.register(ModItems.RICE_DUST, Models.GENERATED);
    }
}
