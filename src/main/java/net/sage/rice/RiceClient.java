package net.sage.rice;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.sage.rice.block.ModBlocks;
import net.sage.rice.entity.ModEntities;

public class RiceClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.RICEBALL, FlyingItemEntityRenderer::new);
        BlockRenderLayerMap.putBlock(ModBlocks.RICE_CROP, BlockRenderLayer.CUTOUT);
    }
}
