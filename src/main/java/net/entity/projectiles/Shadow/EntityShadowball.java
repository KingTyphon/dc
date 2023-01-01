package net.entity.projectiles.Shadow;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityShadowball extends EntityThrowable {
    public EntityShadowball(World world){
    super(world);
    }

    @Override
    protected void entityInit() {

    }

    public EntityShadowball(World world, double x, double y, double z){
        super(world, x,y , z);
    }


    @Override
    protected void onImpact(RayTraceResult result){
        if(!this.world.isRemote){
            setDead();

            if(result.entityHit instanceof EntityLivingBase){
                EntityLivingBase entity = (EntityLivingBase)result.entityHit;
                entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.thrower), (float)4);
                entity.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 100, 3));
            }
        }
    }
    @Override
    protected float getGravityVelocity() {
        return 0.00001F;
    }



    @Override
    public void onUpdate() {
        super.onUpdate();
        BlockPos entity = this.getPosition();
        for(int countparticles = 0; countparticles <= 5; ++countparticles) {

            this.world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, entity.getX()-1, entity.getY(), entity.getZ(), 0, 0, 0);
        }
    }

}
