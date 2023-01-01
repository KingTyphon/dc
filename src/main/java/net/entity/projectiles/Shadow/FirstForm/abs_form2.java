package net.entity.projectiles.Shadow.FirstForm;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class abs_form2 extends EntityThrowable {

    public abs_form2(World worldIn) {super(worldIn);}
    public abs_form2(World worldIn, EntityLivingBase entity){
        super(worldIn, entity);
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        if (ticksExisted > 20)
        {
            setDead();
        }
        this.motionX *= (this.rand.nextFloat() * 0.2F);
        this.motionY *= (this.rand.nextFloat() * 0.2F);
        this.motionZ *= (this.rand.nextFloat() * 0.2F);
    }
    @Override
    protected void onImpact(RayTraceResult result) {
        attackEntityFrom(DamageSource.causeThrownDamage(this, this.thrower), (float) 2.5);
        setDead();
    }
    @Override
    protected float getGravityVelocity()
    {
        return 0.01F;
    }
}
