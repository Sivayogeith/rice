package net.sage.rice.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.sage.rice.item.ModItems;
import net.sage.rice.entity.ModEntities;

public class RiceballEntity extends ThrownItemEntity {
    public RiceballEntity(World world, LivingEntity owner, ItemStack stack) {
        super(ModEntities.RICEBALL, owner, world, stack);
    }

    public RiceballEntity(double x, double y, double z, World world, ItemStack stack) {
        super(ModEntities.RICEBALL, x, y, z, world, stack);
    }

    public RiceballEntity(EntityType<? extends RiceballEntity> entityType, World world) {
        super(entityType, world);
    }

    private ParticleEffect getParticleParameters() {
        ItemStack itemStack = this.getStack();
        return (itemStack.isEmpty() ? ParticleTypes.ITEM_SNOWBALL : new ItemStackParticleEffect(ParticleTypes.ITEM, itemStack));
    }

    public void handleStatus(byte status) {
        if (status == 3) {
            ParticleEffect particleEffect = this.getParticleParameters();

            for(int i = 0; i < 8; ++i) {
                this.getWorld().addParticleClient(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F, 0.0F);
            }
        }

    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        if (!this.getWorld().isClient) {
            entity.damage((ServerWorld) this.getWorld(), this.getDamageSources().thrown(this, this.getOwner()), 6);
        }
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            this.discard();
        }

    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.RICEBALL;
    }
}
