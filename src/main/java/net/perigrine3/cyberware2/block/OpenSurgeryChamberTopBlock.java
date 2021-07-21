
package net.perigrine3.cyberware2.block;

import net.perigrine3.cyberware2.procedures.TopSCBreakProcedure;
import net.perigrine3.cyberware2.procedures.OpenSurgeryChamberRightClickedProcedure;
import net.perigrine3.cyberware2.Cyberware2ModElements;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.util.ActionResultType;
import net.minecraft.state.StateContainer;
import net.minecraft.state.DirectionProperty;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockItem;
import net.minecraft.fluid.FluidState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

@Cyberware2ModElements.ModElement.Tag
public class OpenSurgeryChamberTopBlock extends Cyberware2ModElements.ModElement {
	@ObjectHolder("cyberware2:open_surgery_chamber_top")
	public static final Block block = null;
	public OpenSurgeryChamberTopBlock(Cyberware2ModElements instance) {
		super(instance, 136);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}
	public static class CustomBlock extends Block {
		public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
		public CustomBlock() {
			super(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0).notSolid()
					.setOpaque((bs, br, bp) -> false));
			this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
			setRegistryName("open_surgery_chamber_top");
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
			Vector3d offset = state.getOffset(world, pos);
			switch ((Direction) state.get(FACING)) {
				case SOUTH :
				default :
					return VoxelShapes
							.combineAndSimplify(
									VoxelShapes.or(makeCuboidShape(16, 14, 16, 0, 2, 0), makeCuboidShape(16, 0, 16, 14, 14, 0),
											makeCuboidShape(2, 0, 16, 14, 14, 0), makeCuboidShape(14, 0, 2, 4, 14, 14)),
									VoxelShapes.or(makeCuboidShape(14, 16, 16, 4, 14, 2)), IBooleanFunction.ONLY_FIRST)
							.withOffset(offset.x, offset.y, offset.z);
				case NORTH :
					return VoxelShapes
							.combineAndSimplify(
									VoxelShapes.or(makeCuboidShape(0, 14, 0, 16, 2, 16), makeCuboidShape(0, 0, 0, 2, 14, 16),
											makeCuboidShape(14, 0, 0, 2, 14, 16), makeCuboidShape(2, 0, 14, 12, 14, 2)),
									VoxelShapes.or(makeCuboidShape(2, 16, 0, 12, 14, 14)), IBooleanFunction.ONLY_FIRST)
							.withOffset(offset.x, offset.y, offset.z);
				case EAST :
					return VoxelShapes
							.combineAndSimplify(
									VoxelShapes.or(makeCuboidShape(16, 14, 0, 0, 2, 16), makeCuboidShape(16, 0, 0, 0, 14, 2),
											makeCuboidShape(16, 0, 14, 0, 14, 2), makeCuboidShape(2, 0, 2, 14, 14, 12)),
									VoxelShapes.or(makeCuboidShape(16, 16, 2, 2, 14, 12)), IBooleanFunction.ONLY_FIRST)
							.withOffset(offset.x, offset.y, offset.z);
				case WEST :
					return VoxelShapes
							.combineAndSimplify(
									VoxelShapes.or(makeCuboidShape(0, 14, 16, 16, 2, 0), makeCuboidShape(0, 0, 16, 16, 14, 14),
											makeCuboidShape(0, 0, 2, 16, 14, 14), makeCuboidShape(14, 0, 14, 2, 14, 4)),
									VoxelShapes.or(makeCuboidShape(0, 16, 14, 14, 14, 4)), IBooleanFunction.ONLY_FIRST)
							.withOffset(offset.x, offset.y, offset.z);
			}
		}

		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
			builder.add(FACING);
		}

		public BlockState rotate(BlockState state, Rotation rot) {
			return state.with(FACING, rot.rotate(state.get(FACING)));
		}

		public BlockState mirror(BlockState state, Mirror mirrorIn) {
			return state.rotate(mirrorIn.toRotation(state.get(FACING)));
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			;
			return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(OpenSurgeryChamberBottomBlock.block, (int) (1)));
		}

		@Override
		public boolean removedByPlayer(BlockState state, World world, BlockPos pos, PlayerEntity entity, boolean willHarvest, FluidState fluid) {
			boolean retval = super.removedByPlayer(state, world, pos, entity, willHarvest, fluid);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				TopSCBreakProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}

		@Override
		public void onExplosionDestroy(World world, BlockPos pos, Explosion e) {
			super.onExplosionDestroy(world, pos, e);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				TopSCBreakProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity entity, Hand hand,
				BlockRayTraceResult hit) {
			super.onBlockActivated(state, world, pos, entity, hand, hit);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			Direction direction = hit.getFace();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				OpenSurgeryChamberRightClickedProcedure.executeProcedure($_dependencies);
			}
			return ActionResultType.SUCCESS;
		}
	}
}
