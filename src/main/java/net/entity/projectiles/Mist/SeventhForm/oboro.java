package net.entity.projectiles.Mist.SeventhForm;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class oboro extends abs_oboro {
    public int explosionPower = 1;

    public oboro(World worldIn) {
        super(worldIn);
    }

    @SideOnly(Side.CLIENT)
    public oboro(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
        super(worldIn, x, y, z, accelX, accelY, accelZ);
    }

    public oboro(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ) {
        super(worldIn, shooter, accelX, accelY, accelZ);
    }


    protected void onImpact(RayTraceResult result) {
        if (!this.getEntityWorld().isRemote)
            if (!(result.entityHit == shootingEntity) &&
                    !(result.entityHit instanceof oboro) &&
                    result.entityHit != null) {
                result.entityHit.attackEntityFrom(DamageSource.causeThornsDamage(this.shootingEntity), 13.0F);
                applyEnchantments(this.shootingEntity, result.entityHit);
            }
        setDead();
    }




    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setInteger("ExplosionPower", this.explosionPower);
    }

    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);

        if (compound.hasKey("ExplosionPower", 99))
        {
            this.explosionPower = compound.getInteger("ExplosionPower");
        }
    }
}