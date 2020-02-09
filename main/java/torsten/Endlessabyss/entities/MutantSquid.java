package com.github.kingtorsten.endlessabyss.entities;

import com.github.kingtorsten.endlessabyss.lists.EntityList;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.FollowBoatGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.world.World;

public class MutantSquid extends SquidEntity
{

	@SuppressWarnings("unchecked")
	public MutantSquid(EntityType<? extends SquidEntity> type, World worldIn) 
	{
		super((EntityType<? extends SquidEntity>) EntityList.MUTANT_SQUID, worldIn);
	}

	@Override
	protected void registerGoals() 
	{
		this.goalSelector.addGoal(0, new MeleeAttackGoal(this, interpTargetHeadYaw, false));
		this.goalSelector.addGoal(1, new FollowBoatGoal(this));
		this.goalSelector.addGoal(2, new NearestAttackableTargetGoal<LivingEntity>(this, null, false));
	}
	
	@Override
	protected void registerAttributes() 
	{
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0d);
		this.getAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(1.3d);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(50.0d);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0d);
	}
}
