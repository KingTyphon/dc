package net.entity.projectiles.Wind.Form6;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class kokuhuu extends abs_kokuhuu{
    public int explosionPower = 1;

    public kokuhuu(World worldIn) {
        super(worldIn);
    }

    @SideOnly(Side.CLIENT)
    public kokuhuu(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
        super(worldIn, x, y, z, accelX, accelY, accelZ);
    }

    public kokuhuu(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ) {
        super(worldIn, shooter, accelX, accelY, accelZ);
    }


    protected void onImpact(RayTraceResult result) {
        if (!this.getEntityWorld().isRemote)
            if (!(result.entityHit instanceof net.minecraft.entity.player.EntityPlayer) &&
                    !(result.entityHit instanceof kokuhuu) &&
                    result.entityHit != null) {
                result.entityHit.attackEntityFrom(DamageSource.causeThornsDamage(this.shootingEntity), 5.0F);
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