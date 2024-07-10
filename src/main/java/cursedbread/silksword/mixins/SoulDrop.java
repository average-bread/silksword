package cursedbread.silksword.mixins;

import cursedbread.silksword.ItemsMod;
import net.minecraft.core.block.Block;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.tool.ItemToolSword;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = EntityLiving.class, remap = false)
public abstract class SoulDrop extends Entity {
	public SoulDrop(World world) {
		super(world);
	}


	@Inject(method = "onDeath(Lnet/minecraft/core/entity/Entity;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/entity/EntityLiving;dropFewItems()V"))
	private void soulDrop(Entity entity, CallbackInfo ci){
		if (entity instanceof EntityPlayer){
			ItemStack heldStack = ((EntityPlayer) entity).getHeldItem();
			ItemStack drop = new ItemStack(ItemsMod.mobSoul);
			if (heldStack != null && heldStack.getItem() == ItemToolSword.toolSwordGold){
				int i = (int) (Math.random() * 64);
				if (i == 0) {
					world.dropItem((int) x, (int) y, (int) z, drop);
				}
			}
		}
	}
}

