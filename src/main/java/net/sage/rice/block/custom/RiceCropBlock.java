package net.sage.rice.block.custom;

import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.sage.rice.item.ModItems;

public class RiceCropBlock extends CropBlock {
    public RiceCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.RICE;
    }
}
