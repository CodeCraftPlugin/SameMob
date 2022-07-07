package me.codecraft.samemobs.entity.goal;

import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity;
import me.codecraft.samemobs.entity.wolflike.entity.WolfLikeEntity1;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class WolfBegGoal1 extends Goal {
    private final WolfLikeEntity1 wolf;
    @Nullable
    private PlayerEntity begFrom;
    private final World world;
    private final float begDistance;
    private int timer;
    private final TargetPredicate validPlayerPredicate;

    public WolfBegGoal1(WolfLikeEntity1 wolf, float begDistance) {
        this.wolf = wolf;
        this.world = wolf.world;
        this.begDistance = begDistance;
        this.validPlayerPredicate = TargetPredicate.createNonAttackable().setBaseMaxDistance((double)begDistance);
        this.setControls(EnumSet.of(Control.LOOK));
    }

    public boolean canStart() {
        this.begFrom = this.world.getClosestPlayer(this.validPlayerPredicate, this.wolf);
        return this.begFrom == null ? false : this.isAttractive(this.begFrom);
    }

    public boolean shouldContinue() {
        if (!this.begFrom.isAlive()) {
            return false;
        } else if (this.wolf.squaredDistanceTo(this.begFrom) > (double)(this.begDistance * this.begDistance)) {
            return false;
        } else {
            return this.timer > 0 && this.isAttractive(this.begFrom);
        }
    }

    public void start() {
        this.wolf.setBegging(true);
        this.timer = this.getTickCount(40 + this.wolf.getRandom().nextInt(40));
    }

    public void stop() {
        this.wolf.setBegging(false);
        this.begFrom = null;
    }

    public void tick() {
        this.wolf.getLookControl().lookAt(this.begFrom.getX(), this.begFrom.getEyeY(), this.begFrom.getZ(), 10.0F, (float)this.wolf.getMaxLookPitchChange());
        --this.timer;
    }

    private boolean isAttractive(PlayerEntity player) {
        Hand[] var2 = Hand.values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Hand hand = var2[var4];
            ItemStack itemStack = player.getStackInHand(hand);
            if (this.wolf.isTamed() && itemStack.isOf(Items.BONE)) {
                return true;
            }

            if (this.wolf.isBreedingItem(itemStack)) {
                return true;
            }
        }

        return false;
    }
}
