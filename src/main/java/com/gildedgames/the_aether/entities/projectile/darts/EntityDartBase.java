package com.gildedgames.the_aether.entities.projectile.darts;

import java.util.List;

import cpw.mods.fml.common.registry.IThrowableEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class EntityDartBase
    extends EntityArrow implements IProjectile, IThrowableEntity {
    private int tileX = -1;
    private int tileY = -1;
    private int tileZ = -1;
    private Block inTile;
    private int inData;
    private boolean wasInGround;
    private boolean inGround;
    public int dartShake;
    private int ticksInGround;
    private int ticksInAir;
    private double damage = 2.0D;
    private float gravityVelocity;

    public EntityDartBase(World world) {
        super(world);

        this.renderDistanceWeight = 10.0D;
        this.setSize(0.5F, 0.5F);
    }

    public EntityDartBase(World world, double x, double y, double z) {
        super(world);

        this.renderDistanceWeight = 10.0D;
        this.setSize(0.5F, 0.5F);
        this.setPosition(x, y, z);
        this.yOffset = 0.0F;
    }

    public EntityDartBase(
        World world,
        EntityLivingBase shooter,
        EntityLivingBase target,
        float velocity,
        float inaccuracy
    ) {
        super(world);

        this.renderDistanceWeight = 10.0D;
        this.shootingEntity = shooter;

        if (shooter instanceof EntityPlayer) {
            this.canBePickedUp = 1;
        }

        this.posY = shooter.posY + (double) shooter.getEyeHeight() - 0.10000000149011612D;
        double d0 = target.posX - shooter.posX;
        double d1 = target.boundingBox.minY + (double) (target.height / 3.0F) - this.posY;
        double d2 = target.posZ - shooter.posZ;
        double d3 = (double) MathHelper.sqrt_double(d0 * d0 + d2 * d2);

        if (d3 >= 1.0E-7D) {
            float f2 = (float) (Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
            float f3 = (float) (-(Math.atan2(d1, d3) * 180.0D / Math.PI));
            double d4 = d0 / d3;
            double d5 = d2 / d3;
            this.setLocationAndAngles(
                shooter.posX + d4, this.posY, shooter.posZ + d5, f2, f3
            );
            this.yOffset = 0.0F;
            float f4 = (float) d3 * 0.2F;
            this.setThrowableHeading(d0, d1 + (double) f4, d2, velocity, inaccuracy);
        }
    }

    public EntityDartBase(World world, EntityLivingBase shooter, float velocity) {
        super(world);
        this.renderDistanceWeight = 10.0D;
        this.shootingEntity = shooter;

        if (shooter instanceof EntityPlayer) {
            this.canBePickedUp = 1;
        }

        this.setSize(0.5F, 0.5F);
        this.setLocationAndAngles(
            shooter.posX,
            shooter.posY + (double) shooter.getEyeHeight(),
            shooter.posZ,
            shooter.rotationYaw,
            shooter.rotationPitch
        );
        this.posX -= (double
        ) (MathHelper.cos(this.rotationYaw / 180.0F * (float) Math.PI) * 0.16F);
        this.posY -= 0.10000000149011612D;
        this.posZ -= (double
        ) (MathHelper.sin(this.rotationYaw / 180.0F * (float) Math.PI) * 0.16F);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0F;
        this.motionX = (double
        ) (-MathHelper.sin(this.rotationYaw / 180.0F * (float) Math.PI)
           * MathHelper.cos(this.rotationPitch / 180.0F * (float) Math.PI));
        this.motionZ = (double
        ) (MathHelper.cos(this.rotationYaw / 180.0F * (float) Math.PI)
           * MathHelper.cos(this.rotationPitch / 180.0F * (float) Math.PI));
        this.motionY
            = (double) (-MathHelper.sin(this.rotationPitch / 180.0F * (float) Math.PI));
        this.setThrowableHeading(
            this.motionX, this.motionY, this.motionZ, velocity * 1.5F, 1.0F
        );
    }

    @Override
    protected void entityInit() {}

    @Override
    public void
    setThrowableHeading(double x, double y, double z, float velocity, float inaccuracy) {
        float f2 = MathHelper.sqrt_double(x * x + y * y + z * z);
        x /= (double) f2;
        y /= (double) f2;
        z /= (double) f2;
        x += this.rand.nextGaussian() * (double) (this.rand.nextBoolean() ? -1 : 1)
            * 0.007499999832361937D * (double) inaccuracy;
        y += this.rand.nextGaussian() * (double) (this.rand.nextBoolean() ? -1 : 1)
            * 0.007499999832361937D * (double) inaccuracy;
        z += this.rand.nextGaussian() * (double) (this.rand.nextBoolean() ? -1 : 1)
            * 0.007499999832361937D * (double) inaccuracy;
        x *= (double) velocity;
        y *= (double) velocity;
        z *= (double) velocity;
        this.motionX = x;
        this.motionY = y;
        this.motionZ = z;
        float f3 = MathHelper.sqrt_double(x * x + z * z);
        this.prevRotationYaw = this.rotationYaw
            = (float) (Math.atan2(x, z) * 180.0D / Math.PI);
        this.prevRotationPitch = this.rotationPitch
            = (float) (Math.atan2(y, (double) f3) * 180.0D / Math.PI);
        this.ticksInGround = 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void setPositionAndRotation2(
        double x, double y, double z, float yaw, float pitch, int type
    ) {
        this.setPosition(x, y, z);
        this.setRotation(yaw, pitch);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void setVelocity(double x, double y, double z) {
        this.motionX = x;
        this.motionY = y;
        this.motionZ = z;

        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
            float f = MathHelper.sqrt_double(x * x + z * z);
            this.prevRotationYaw = this.rotationYaw
                = (float) (Math.atan2(x, z) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch
                = (float) (Math.atan2(y, (double) f) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch;
            this.prevRotationYaw = this.rotationYaw;
            this.setLocationAndAngles(
                this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch
            );
            this.ticksInGround = 0;
        }
    }

    @Override
    public void onUpdate() {
        super.onEntityUpdate();

        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
            float f = MathHelper.sqrt_double(
                this.motionX * this.motionX + this.motionZ * this.motionZ
            );
            this.prevRotationYaw = this.rotationYaw
                = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch
                = (float) (Math.atan2(this.motionY, (double) f) * 180.0D / Math.PI);
        }

        Block block = this.worldObj.getBlock(this.tileX, this.tileY, this.tileZ);

        if (block.getMaterial() != Material.air) {
            block.setBlockBoundsBasedOnState(
                this.worldObj, this.tileX, this.tileY, this.tileZ
            );
            AxisAlignedBB axisalignedbb = block.getCollisionBoundingBoxFromPool(
                this.worldObj, this.tileX, this.tileY, this.tileZ
            );

            if (axisalignedbb != null
                && axisalignedbb.isVecInside(
                    Vec3.createVectorHelper(this.posX, this.posY, this.posZ)
                )) {
                this.inGround = true;
                this.wasInGround = true;
            }
        }

        if (this.dartShake > 0) {
            --this.dartShake;
        }

        if (this.inGround) {
            int j = this.worldObj.getBlockMetadata(this.tileX, this.tileY, this.tileZ);

            if (block == this.inTile && j == this.inData) {
                ++this.ticksInGround;

                if (this.ticksInGround == 1200) {
                    this.setDead();
                }
            } else {
                this.inGround = false;
                this.motionX *= (double) (this.rand.nextFloat() * 0.2F);
                this.motionY *= (double) (this.rand.nextFloat() * 0.2F);
                this.motionZ *= (double) (this.rand.nextFloat() * 0.2F);
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            }
        } else {
            ++this.ticksInAir;
            Vec3 vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            Vec3 vec3 = Vec3.createVectorHelper(
                this.posX + this.motionX,
                this.posY + this.motionY,
                this.posZ + this.motionZ
            );
            MovingObjectPosition movingobjectposition
                = this.worldObj.func_147447_a(vec31, vec3, false, true, false);
            vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            vec3 = Vec3.createVectorHelper(
                this.posX + this.motionX,
                this.posY + this.motionY,
                this.posZ + this.motionZ
            );

            if (movingobjectposition != null) {
                vec3 = Vec3.createVectorHelper(
                    movingobjectposition.hitVec.xCoord,
                    movingobjectposition.hitVec.yCoord,
                    movingobjectposition.hitVec.zCoord
                );
            }

            Entity entity = null;
            List<?> list = this.worldObj.getEntitiesWithinAABBExcludingEntity(
                this,
                this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ)
                    .expand(1.0D, 1.0D, 1.0D)
            );
            double d0 = 0.0D;
            int i;
            float f1;

            for (i = 0; i < list.size(); ++i) {
                Entity entity1 = (Entity) list.get(i);

                if (entity1.canBeCollidedWith()
                    && (entity1 != this.shootingEntity || this.ticksInAir >= 5)) {
                    f1 = 0.3F;
                    AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand(
                        (double) f1, (double) f1, (double) f1
                    );
                    MovingObjectPosition movingobjectposition1
                        = axisalignedbb1.calculateIntercept(vec31, vec3);

                    if (movingobjectposition1 != null) {
                        double d1 = vec31.distanceTo(movingobjectposition1.hitVec);

                        if (d1 < d0 || d0 == 0.0D) {
                            entity = entity1;
                            d0 = d1;
                        }
                    }
                }
            }

            if (entity != null) {
                movingobjectposition = new MovingObjectPosition(entity);
            }

            if (movingobjectposition != null && movingobjectposition.entityHit != null
                && movingobjectposition.entityHit instanceof EntityPlayer) {
                EntityPlayer entityplayer = (EntityPlayer) movingobjectposition.entityHit;

                if (entityplayer.capabilities.disableDamage
                    || this.shootingEntity instanceof EntityPlayer
                        && !((EntityPlayer) this.shootingEntity)
                                .canAttackPlayer(entityplayer)) {
                    movingobjectposition = null;
                }
            }

            float f2;
            float f4;

            if (movingobjectposition != null) {
                this.onDartHit(movingobjectposition);
            }

            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;

            f2 = MathHelper.sqrt_double(
                this.motionX * this.motionX + this.motionZ * this.motionZ
            );
            this.rotationYaw
                = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

            for (this.rotationPitch
                 = (float) (Math.atan2(this.motionY, (double) f2) * 180.0D / Math.PI);
                 this.rotationPitch - this.prevRotationPitch < -180.0F;
                 this.prevRotationPitch -= 360.0F) {
                ;
            }

            while (this.rotationPitch - this.prevRotationPitch >= 180.0F) {
                this.prevRotationPitch += 360.0F;
            }

            while (this.rotationYaw - this.prevRotationYaw < -180.0F) {
                this.prevRotationYaw -= 360.0F;
            }

            while (this.rotationYaw - this.prevRotationYaw >= 180.0F) {
                this.prevRotationYaw += 360.0F;
            }

            this.rotationPitch = this.prevRotationPitch
                + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
            this.rotationYaw
                = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
            float f3 = 0.99F;
            f1 = 0.05F;

            if (this.isInWater()) {
                for (int l = 0; l < 4; ++l) {
                    f4 = 0.25F;
                    this.worldObj.spawnParticle(
                        "bubble",
                        this.posX - this.motionX * (double) f4,
                        this.posY - this.motionY * (double) f4,
                        this.posZ - this.motionZ * (double) f4,
                        this.motionX,
                        this.motionY,
                        this.motionZ
                    );
                }

                f3 = 0.8F;
            }

            if (this.isWet()) {
                this.extinguish();
            }

            this.motionX *= (double) f3;
            this.motionY *= (double) f3;
            this.motionZ *= (double) f3;

            if (this.wasInGround) {
                this.motionY
                    -= this.wasInGround ? ((double) f1) : this.getGravityVelocity();
            }

            this.setPosition(this.posX, this.posY, this.posZ);
            this.func_145775_I();
        }

        if (this.ticksInAir == 500) {
            this.setDead();
        }
    }

    public void onDartHit(MovingObjectPosition movingobjectposition) {
        if (movingobjectposition.entityHit != null) {
            float f2 = MathHelper.sqrt_double(
                this.motionX * this.motionX + this.motionY * this.motionY
                + this.motionZ * this.motionZ
            );
            int k = MathHelper.ceiling_double_int((double) f2 * this.damage);

            DamageSource damagesource = null;

            if (this.shootingEntity == null) {
                damagesource = EntityDartBase.causeDartDamage(this, this);
            } else {
                damagesource = EntityDartBase.causeDartDamage(this, this.shootingEntity);
            }

            if (this.isBurning()
                && !(movingobjectposition.entityHit instanceof EntityEnderman)) {
                movingobjectposition.entityHit.setFire(5);
            }

            if (movingobjectposition.entityHit.attackEntityFrom(
                    damagesource, (float) k
                )) {
                if (movingobjectposition.entityHit instanceof EntityLivingBase) {
                    EntityLivingBase entitylivingbase
                        = (EntityLivingBase) movingobjectposition.entityHit;

                    if (!this.worldObj.isRemote) {
                        entitylivingbase.setArrowCountInEntity(
                            entitylivingbase.getArrowCountInEntity() + 1
                        );
                    }

                    float f4 = MathHelper.sqrt_double(
                        this.motionX * this.motionX + this.motionZ * this.motionZ
                    );

                    if (f4 > 0.0F) {
                        movingobjectposition.entityHit.addVelocity(
                            this.motionX * 0.6000000238418579D / (double) f4,
                            0.1D,
                            this.motionZ * 0.6000000238418579D / (double) f4
                        );
                    }

                    if (this.shootingEntity != null
                        && this.shootingEntity instanceof EntityLivingBase) {
                        EnchantmentHelper.func_151384_a(
                            entitylivingbase, this.shootingEntity
                        );
                        EnchantmentHelper.func_151385_b(
                            (EntityLivingBase) this.shootingEntity, entitylivingbase
                        );
                    }

                    if (this.shootingEntity != null
                        && movingobjectposition.entityHit != this.shootingEntity
                        && movingobjectposition.entityHit instanceof EntityPlayer
                        && this.shootingEntity instanceof EntityPlayerMP) {
                        ((EntityPlayerMP) this.shootingEntity)
                            .playerNetServerHandler.sendPacket(
                                new S2BPacketChangeGameState(6, 0.0F)
                            );
                    }
                }

                this.playSound(
                    "random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F)
                );

                if (!(movingobjectposition.entityHit instanceof EntityEnderman)) {
                    this.setDead();
                }
            } else {
                this.motionX *= -0.1D;
                this.motionY *= -0.1D;
                this.motionZ *= -0.1D;
                this.rotationYaw += 180.0F;
                this.prevRotationYaw += 180.0F;
                this.ticksInAir = 0;
            }
        } else {
            this.tileX = movingobjectposition.blockX;
            this.tileY = movingobjectposition.blockY;
            this.tileZ = movingobjectposition.blockZ;
            this.inTile = this.worldObj.getBlock(this.tileX, this.tileY, this.tileZ);
            this.inData
                = this.worldObj.getBlockMetadata(this.tileX, this.tileY, this.tileZ);
            this.motionX
                = (double) ((float) (movingobjectposition.hitVec.xCoord - this.posX));
            this.motionY
                = (double) ((float) (movingobjectposition.hitVec.yCoord - this.posY));
            this.motionZ
                = (double) ((float) (movingobjectposition.hitVec.zCoord - this.posZ));
            float f2 = MathHelper.sqrt_double(
                this.motionX * this.motionX + this.motionY * this.motionY
                + this.motionZ * this.motionZ
            );
            this.posX -= this.motionX / (double) f2 * 0.05D;
            this.posY -= this.motionY / (double) f2 * 0.05D;
            this.posZ -= this.motionZ / (double) f2 * 0.05D;
            this.playSound(
                "random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F)
            );
            this.inGround = true;
            this.wasInGround = true;
            this.dartShake = 7;

            if (this.inTile.getMaterial() != Material.air) {
                this.inTile.onEntityCollidedWithBlock(
                    this.worldObj, this.tileX, this.tileY, this.tileZ, this
                );
            }
        }

        if (movingobjectposition.entityHit != null
            && movingobjectposition.typeOfHit != null && this.shootingEntity != null) {
            if (movingobjectposition.entityHit != this.shootingEntity
                && movingobjectposition.typeOfHit
                    == MovingObjectPosition.MovingObjectType.ENTITY
                && movingobjectposition.entityHit != this.shootingEntity.riddenByEntity) {
                this.setDead();
            } else {
                this.setGravityVelocity(0.03F);
            }
        }
    }

    protected float getGravityVelocity() {
        return this.gravityVelocity;
    }

    public void setGravityVelocity(float gravityVelocity) {
        this.gravityVelocity = gravityVelocity;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
        p_70014_1_.setShort("xTile", (short) this.tileX);
        p_70014_1_.setShort("yTile", (short) this.tileY);
        p_70014_1_.setShort("zTile", (short) this.tileZ);
        p_70014_1_.setShort("life", (short) this.ticksInGround);
        p_70014_1_.setByte("inTile", (byte) Block.getIdFromBlock(this.inTile));
        p_70014_1_.setByte("inData", (byte) this.inData);
        p_70014_1_.setByte("shake", (byte) this.dartShake);
        p_70014_1_.setByte("inGround", (byte) (this.inGround ? 1 : 0));
        p_70014_1_.setByte("wasInGround", (byte) (this.wasInGround ? 1 : 0));
        p_70014_1_.setByte("pickup", (byte) this.canBePickedUp);
        p_70014_1_.setDouble("damage", this.damage);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
        this.tileX = p_70037_1_.getShort("xTile");
        this.tileY = p_70037_1_.getShort("yTile");
        this.tileZ = p_70037_1_.getShort("zTile");
        this.ticksInGround = p_70037_1_.getShort("life");
        this.inTile = Block.getBlockById(p_70037_1_.getByte("inTile") & 255);
        this.inData = p_70037_1_.getByte("inData") & 255;
        this.dartShake = p_70037_1_.getByte("shake") & 255;
        this.inGround = p_70037_1_.getByte("inGround") == 1;
        this.wasInGround = p_70037_1_.getByte("wasInGround") == 1;

        if (p_70037_1_.hasKey("damage", 99)) {
            this.damage = p_70037_1_.getDouble("damage");
        }

        if (p_70037_1_.hasKey("pickup", 99)) {
            this.canBePickedUp = p_70037_1_.getByte("pickup");
        } else if (p_70037_1_.hasKey("player", 99)) {
            this.canBePickedUp = p_70037_1_.getBoolean("player") ? 1 : 0;
        }
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer player) {
        if (!this.worldObj.isRemote && this.inGround && this.dartShake <= 0) {
            boolean flag = this.canBePickedUp == 1
                || this.canBePickedUp == 2 && player.capabilities.isCreativeMode;

            if (this.canBePickedUp == 1
                && !player.inventory.addItemStackToInventory(this.getStack())) {
                flag = false;
            }

            if (flag) {
                this.playSound(
                    "random.pop",
                    0.2F,
                    ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F
                );
                player.onItemPickup(this, 1);
                this.setDead();
            }
        }
    }

    protected abstract ItemStack getStack();

    public void setDamage(double p_70239_1_) {
        this.damage = p_70239_1_;
    }

    public double getDamage() {
        return this.damage;
    }

    @Override
    public void setThrower(Entity entity) {
        this.shootingEntity = entity;
    }

    @Override
    public Entity getThrower() {
        return this.shootingEntity;
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getShadowSize() {
        return 0.0F;
    }

    @Override
    public boolean canAttackWithItem() {
        return false;
    }

    public static DamageSource causeDartDamage(EntityDartBase dart, Entity thrower) {
        return (new EntityDamageSourceIndirect("aether_legacy.dart", dart, thrower))
            .setProjectile();
    }

    @Override
    public void setIsCritical(boolean p_70243_1_) {}

    @Override
    public boolean getIsCritical() {
        return false;
    }
}