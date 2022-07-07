package me.codecraft.samemobs.entity.wolflike.entity;

import me.codecraft.samemobs.entity.SameMobsEntity;
import me.codecraft.samemobs.entity.goal.WolfBegGoal;
import me.codecraft.samemobs.entity.goal.WolfBegGoal1;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.UUID;
import java.util.function.Predicate;


public class WolfLikeEntity1 extends TameableEntity implements Angerable, IAnimatable {
    private static final TrackedData<Boolean> BEGGING;
    private static final TrackedData<Integer> COLLAR_COLOR;
    private static final TrackedData<Integer> ANGER_TIME;
    public static final Predicate<LivingEntity> FOLLOW_TAMED_PREDICATE;
    public static final Predicate<LivingEntity> AngeryPredectate;
    private static final float WILD_MAX_HEALTH = 8.0F;
    private static final float TAMED_MAX_HEALTH = 20.0F;
    private float begAnimationProgress;
    private float lastBegAnimationProgress;
    private boolean furWet;
    private boolean canShakeWaterOff;
    private float shakeProgress;
    private float lastShakeProgress;
    private static final UniformIntProvider ANGER_TIME_RANGE;
    @Nullable
    private UUID angryAt;

    private AnimationFactory factory = new AnimationFactory(this);

    public WolfLikeEntity1(EntityType<? extends WolfLikeEntity1> entityType, World world) {
        super(entityType, world);
        this.setTamed(false);
        this.setPathfindingPenalty(PathNodeType.POWDER_SNOW, -1.0F);
        this.setPathfindingPenalty(PathNodeType.DANGER_POWDER_SNOW, -1.0F);
    }

    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(1, new WolfLikeEntity1.WolfEscapeDangerGoal(1.5));
        this.goalSelector.add(2, new SitGoal(this));
        this.goalSelector.add(3, new WolfLikeEntity1.AvoidLlamaGoal(this, LlamaEntity.class, 24.0F, 1.5, 1.5));
        this.goalSelector.add(4, new PounceAtTargetGoal(this, 0.4F));
        this.goalSelector.add(5, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.add(6, new FollowOwnerGoal(this, 1.0, 10.0F, 2.0F, false));
        this.goalSelector.add(7, new AnimalMateGoal(this, 1.0));
        this.goalSelector.add(8, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(9, new WolfBegGoal1(this, 8.0F));
        this.goalSelector.add(10, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(10, new LookAroundGoal(this));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
        this.targetSelector.add(3, (new RevengeGoal(this, new Class[0])).setGroupRevenge(new Class[0]));
        this.targetSelector.add(4, new ActiveTargetGoal(this, PlayerEntity.class, 10, true,false,AngeryPredectate));
        this.targetSelector.add(5, new UntamedActiveTargetGoal(this, AnimalEntity.class, false, FOLLOW_TAMED_PREDICATE));
        this.targetSelector.add(6, new UntamedActiveTargetGoal(this, TurtleEntity.class, false, TurtleEntity.BABY_TURTLE_ON_LAND_FILTER));
        this.targetSelector.add(7, new ActiveTargetGoal(this, AbstractSkeletonEntity.class, false));
        this.targetSelector.add(8, new UniversalAngerGoal(this, true));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    @Override
    public void registerControllers(AnimationData animationData) {

    }
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event){
        if (this.isAlive()) {
            this.lastBegAnimationProgress = this.begAnimationProgress;
            if (this.isBegging()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("beg"));
                return PlayState.CONTINUE;
            } else {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("idle"));
                return PlayState.CONTINUE;
            }

        }
        return PlayState.CONTINUE;
    }


    public static DefaultAttributeContainer.Builder createWolfAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.30000001192092896).add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0);
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(BEGGING, false);
        this.dataTracker.startTracking(COLLAR_COLOR, DyeColor.RED.getId());
        this.dataTracker.startTracking(ANGER_TIME, 0);
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15F, 1.0F);
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putByte("CollarColor", (byte)this.getCollarColor().getId());
        this.writeAngerToNbt(nbt);
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("CollarColor", 99)) {
            this.setCollarColor(DyeColor.byId(nbt.getInt("CollarColor")));
        }

        this.readAngerFromNbt(this.world, nbt);
    }

    protected SoundEvent getAmbientSound() {
        if (this.hasAngerTime()) {
            return SoundEvents.ENTITY_WOLF_GROWL;
        } else if (this.random.nextInt(3) == 0) {
            return this.isTamed() && this.getHealth() < 10.0F ? SoundEvents.ENTITY_WOLF_WHINE : SoundEvents.ENTITY_WOLF_PANT;
        } else {
            return SoundEvents.ENTITY_WOLF_AMBIENT;
        }
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_WOLF_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WOLF_DEATH;
    }

    protected float getSoundVolume() {
        return 0.4F;
    }

    public void tickMovement() {
        super.tickMovement();
        if (!this.world.isClient && this.furWet && !this.canShakeWaterOff && !this.isNavigating() && this.onGround) {
            this.canShakeWaterOff = true;
            this.shakeProgress = 0.0F;
            this.lastShakeProgress = 0.0F;
            this.world.sendEntityStatus(this, (byte)8);
        }

        if (!this.world.isClient) {
            this.tickAngerLogic((ServerWorld)this.world, true);
        }

    }

    public void tick() {
        super.tick();

    }

    private void resetShake() {
        this.canShakeWaterOff = false;
        this.shakeProgress = 0.0F;
        this.lastShakeProgress = 0.0F;
    }

    public void onDeath(DamageSource damageSource) {
        this.furWet = false;
        this.canShakeWaterOff = false;
        this.lastShakeProgress = 0.0F;
        this.shakeProgress = 0.0F;
        super.onDeath(damageSource);
    }

    public boolean isFurWet() {
        return this.furWet;
    }

    public float getFurWetBrightnessMultiplier(float tickDelta) {
        return Math.min(0.5F + MathHelper.lerp(tickDelta, this.lastShakeProgress, this.shakeProgress) / 2.0F * 0.5F, 1.0F);
    }

    public float getShakeAnimationProgress(float tickDelta, float f) {
        float g = (MathHelper.lerp(tickDelta, this.lastShakeProgress, this.shakeProgress) + f) / 1.8F;
        if (g < 0.0F) {
            g = 0.0F;
        } else if (g > 1.0F) {
            g = 1.0F;
        }

        return MathHelper.sin(g * 3.1415927F) * MathHelper.sin(g * 3.1415927F * 11.0F) * 0.15F * 3.1415927F;
    }

    public float getBegAnimationProgress(float tickDelta) {
        return MathHelper.lerp(tickDelta, this.lastBegAnimationProgress, this.begAnimationProgress) * 0.15F * 3.1415927F;
    }

    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return dimensions.height * 0.8F;
    }

    public int getMaxLookPitchChange() {
        return this.isInSittingPose() ? 20 : super.getMaxLookPitchChange();
    }

    public boolean damage(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else {
            Entity entity = source.getAttacker();
            if (!this.world.isClient) {
                this.setSitting(false);
            }

            if (entity != null && !(entity instanceof PlayerEntity) && !(entity instanceof PersistentProjectileEntity)) {
                amount = (amount + 1.0F) / 2.0F;
            }

            return super.damage(source, amount);
        }
    }

    public boolean tryAttack(Entity target) {
        boolean bl = target.damage(DamageSource.mob(this), (float)((int)this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE)));
        if (bl) {
            this.applyDamageEffects(this, target);
        }

        return bl;
    }

    public void setTamed(boolean tamed) {
        super.setTamed(tamed);
        if (tamed) {
            this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(20.0);
            this.setHealth(20.0F);
        } else {
            this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(8.0);
        }

        this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(4.0);
    }

    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        Item item = itemStack.getItem();
        if (this.world.isClient) {
            boolean bl = this.isOwner(player) || this.isTamed() || itemStack.isOf(Items.BONE) && !this.isTamed() && !this.hasAngerTime();
            return bl ? ActionResult.CONSUME : ActionResult.PASS;
        } else {
            if (this.isTamed()) {
                if (this.isBreedingItem(itemStack) && this.getHealth() < this.getMaxHealth()) {
                    if (!player.getAbilities().creativeMode) {
                        itemStack.decrement(1);
                    }

                    this.heal((float)item.getFoodComponent().getHunger());
                    return ActionResult.SUCCESS;
                }

                if (!(item instanceof DyeItem)) {
                    ActionResult actionResult = super.interactMob(player, hand);
                    if ((!actionResult.isAccepted() || this.isBaby()) && this.isOwner(player)) {
                        this.setSitting(!this.isSitting());
                        this.jumping = false;
                        this.navigation.stop();
                        this.setTarget((LivingEntity)null);
                        return ActionResult.SUCCESS;
                    }

                    return actionResult;
                }

                DyeColor dyeColor = ((DyeItem)item).getColor();
                if (dyeColor != this.getCollarColor()) {
                    this.setCollarColor(dyeColor);
                    if (!player.getAbilities().creativeMode) {
                        itemStack.decrement(1);
                    }

                    return ActionResult.SUCCESS;
                }
            } else if (itemStack.isOf(Items.BONE) && !this.hasAngerTime()) {
                if (!player.getAbilities().creativeMode) {
                    itemStack.decrement(1);
                }

                if (this.random.nextInt(3) == 0) {
                    this.setOwner(player);
                    this.navigation.stop();
                    this.setTarget((LivingEntity)null);
                    this.setSitting(true);
                    this.world.sendEntityStatus(this, (byte)7);
                } else {
                    this.world.sendEntityStatus(this, (byte)6);
                }

                return ActionResult.SUCCESS;
            }

            return super.interactMob(player, hand);
        }
    }

    public void handleStatus(byte status) {
        if (status == 8) {
            this.canShakeWaterOff = true;
            this.shakeProgress = 0.0F;
            this.lastShakeProgress = 0.0F;
        } else if (status == 56) {
            this.resetShake();
        } else {
            super.handleStatus(status);
        }

    }

    public float getTailAngle() {
        if (this.hasAngerTime()) {
            return 1.5393804F;
        } else {
            return this.isTamed() ? (0.55F - (this.getMaxHealth() - this.getHealth()) * 0.02F) * 3.1415927F : 0.62831855F;
        }
    }

    public boolean isBreedingItem(ItemStack stack) {
        Item item = stack.getItem();
        return item.isFood() && item.getFoodComponent().isMeat();
    }

    public int getLimitPerChunk() {
        return 8;
    }

    public int getAngerTime() {
        return (Integer)this.dataTracker.get(ANGER_TIME);
    }

    public void setAngerTime(int angerTime) {
        this.dataTracker.set(ANGER_TIME, angerTime);
    }

    public void chooseRandomAngerTime() {
        this.setAngerTime(ANGER_TIME_RANGE.get(this.random));
    }

    @Nullable
    public UUID getAngryAt() {
        return this.angryAt;
    }

    public void setAngryAt(@Nullable UUID angryAt) {
        this.angryAt = angryAt;
    }

    public DyeColor getCollarColor() {
        return DyeColor.byId((Integer)this.dataTracker.get(COLLAR_COLOR));
    }

    public void setCollarColor(DyeColor color) {
        this.dataTracker.set(COLLAR_COLOR, color.getId());
    }

    public WolfLikeEntity1 createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        WolfLikeEntity1 WolfLikeEntity = (WolfLikeEntity1) SameMobsEntity.WOLFLIKEENTITY1.create(serverWorld);
        UUID uUID = this.getOwnerUuid();
        if (uUID != null) {
            WolfLikeEntity.setOwnerUuid(uUID);
            WolfLikeEntity.setTamed(true);
        }

        return WolfLikeEntity;
    }

    public void setBegging(boolean begging) {
        this.dataTracker.set(BEGGING, begging);
    }

    public boolean canBreedWith(AnimalEntity other) {
        if (other == this) {
            return false;
        } else if (!this.isTamed()) {
            return false;
        } else if (!(other instanceof WolfLikeEntity1)) {
            return false;
        } else {
            WolfLikeEntity1 WolfLikeEntity = (WolfLikeEntity1)other;
            if (!WolfLikeEntity.isTamed()) {
                return false;
            } else if (WolfLikeEntity.isInSittingPose()) {
                return false;
            } else {
                return this.isInLove() && WolfLikeEntity.isInLove();
            }
        }
    }

    public boolean isBegging() {
        return (Boolean)this.dataTracker.get(BEGGING);
    }

    public boolean canAttackWithOwner(LivingEntity target, LivingEntity owner) {
        if (!(target instanceof CreeperEntity) && !(target instanceof GhastEntity)) {
            if (target instanceof WolfLikeEntity1) {
                WolfLikeEntity1 WolfLikeEntity = (WolfLikeEntity1)target;
                return !WolfLikeEntity.isTamed() || WolfLikeEntity.getOwner() != owner;
            } else if (target instanceof PlayerEntity && owner instanceof PlayerEntity && !((PlayerEntity)owner).shouldDamagePlayer((PlayerEntity)target)) {
                return false;
            } else if (target instanceof AbstractHorseEntity && ((AbstractHorseEntity)target).isTame()) {
                return false;
            } else {
                return !(target instanceof TameableEntity) || !((TameableEntity)target).isTamed();
            }
        } else {
            return false;
        }
    }

    public boolean canBeLeashedBy(PlayerEntity player) {
        return !this.hasAngerTime() && super.canBeLeashedBy(player);
    }

    public Vec3d getLeashOffset() {
        return new Vec3d(0.0, (double)(0.6F * this.getStandingEyeHeight()), (double)(this.getWidth() * 0.4F));
    }

    public static boolean canSpawn(EntityType<WolfLikeEntity1> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return world.getBlockState(pos.down()).isIn(BlockTags.WOLVES_SPAWNABLE_ON) && isLightLevelValidForNaturalSpawn(world, pos);
    }

    static {
        BEGGING = DataTracker.registerData(WolfLikeEntity1.class, TrackedDataHandlerRegistry.BOOLEAN);
        COLLAR_COLOR = DataTracker.registerData(WolfLikeEntity1.class, TrackedDataHandlerRegistry.INTEGER);
        ANGER_TIME = DataTracker.registerData(WolfLikeEntity1.class, TrackedDataHandlerRegistry.INTEGER);
        FOLLOW_TAMED_PREDICATE = (entity) -> {
            EntityType<?> entityType = entity.getType();
            return entityType == EntityType.SHEEP || entityType == EntityType.RABBIT || entityType == EntityType.FOX;
        };
        ANGER_TIME_RANGE = TimeHelper.betweenSeconds(20, 39);
        AngeryPredectate = (entity) ->{
            EntityType<?> entityType = entity.getType();
            ServerWorld serverWorld = (ServerWorld) entity.world;
            return entityType==EntityType.PLAYER;

        };
    }



    class WolfEscapeDangerGoal extends EscapeDangerGoal {
        public WolfEscapeDangerGoal(double speed) {
            super(WolfLikeEntity1.this, speed);
        }

        protected boolean isInDanger() {
            return this.mob.shouldEscapePowderSnow() || this.mob.isOnFire();
        }
    }

    private class AvoidLlamaGoal<T extends LivingEntity> extends FleeEntityGoal<T> {
        private final WolfLikeEntity1 wolf;

        public AvoidLlamaGoal(WolfLikeEntity1 wolf, Class<T> fleeFromType, float distance, double slowSpeed, double fastSpeed) {
            super(wolf, fleeFromType, distance, slowSpeed, fastSpeed);
            this.wolf = wolf;
        }

        public boolean canStart() {
            if (super.canStart() && this.targetEntity instanceof LlamaEntity) {
                return !this.wolf.isTamed() && this.isScaredOf((LlamaEntity)this.targetEntity);
            } else {
                return false;
            }
        }

        private boolean isScaredOf(LlamaEntity llama) {
            return llama.getStrength() >= WolfLikeEntity1.this.random.nextInt(5);
        }

        public void start() {
            WolfLikeEntity1.this.setTarget((LivingEntity)null);
            super.start();
        }

        public void tick() {
            WolfLikeEntity1.this.setTarget((LivingEntity)null);
            super.tick();
        }
    }


}
