package net.api;


import net.entity.Teoni.EntityTeoni;
import net.minecraft.entity.ai.EntityAIAttackMelee;

public class EntityTeoniAttack extends EntityAIAttackMelee
{

    public EntityTeoniAttack(EntityTeoni teoni, double speedIn, boolean longMemoryIn)
    {
        super(teoni, speedIn, longMemoryIn);
    }

    public void startExecuting()
    {
        super.startExecuting();
    }

    public void updateTask()
    {
        super.updateTask();
    }
}