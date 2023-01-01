package net.entity.projectiles.Shadow;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityShadowslash extends EntityThrowable {
    public EntityShadowslash(World world){
        super(world);
    }
    @Override
    protected void entityInit() {

    }
    public EntityShadowslash(World world, double x, double y, double z){
        super(world, x,y , z);
    }


    @Override
    protected void onImpact(RayTraceResult result){
        if(!this.world.isRemote){

            setDead();

            if(result.entityHit instanceof EntityLivingBase){
                EntityLivingBase entity = (EntityLivingBase)result.entityHit;
                entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.thrower), (float)4);
                Minecraft minecraft = Minecraft.getMinecraft();
                minecraft.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, entity.posX, entity.posY +entity.height, entity.posZ, 0 ,0 ,0);
                minecraft.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, entity.posX, entity.posY +entity.height, entity.posZ+1, 0 ,0 ,.1);
                minecraft.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, entity.posX+1, entity.posY +entity.height, entity.posZ, .1 ,0 ,0);
            }
        }

    }
    @Override
    protected float getGravityVelocity() {
        return 0.00001F;
    }

}