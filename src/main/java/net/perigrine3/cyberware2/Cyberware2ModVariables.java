package net.perigrine3.cyberware2;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.IServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class Cyberware2ModVariables {
	public Cyberware2ModVariables(Cyberware2ModElements elements) {
		elements.addNetworkMessage(WorldSavedDataSyncMessage.class, WorldSavedDataSyncMessage::buffer, WorldSavedDataSyncMessage::new,
				WorldSavedDataSyncMessage::handler);
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote()) {
			WorldSavedData mapdata = MapVariables.get(event.getPlayer().world);
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (mapdata != null)
				Cyberware2Mod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(0, mapdata));
			if (worlddata != null)
				Cyberware2Mod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote()) {
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (worlddata != null)
				Cyberware2Mod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}
	public static class WorldVariables extends WorldSavedData {
		public static final String DATA_NAME = "cyberware2_worldvars";
		public WorldVariables() {
			super(DATA_NAME);
		}

		public WorldVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !world.isRemote())
				Cyberware2Mod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(((World) world)::getDimensionKey),
						new WorldSavedDataSyncMessage(1, this));
		}
		static WorldVariables clientSide = new WorldVariables();
		public static WorldVariables get(IWorld world) {
			if (world instanceof ServerWorld) {
				return ((ServerWorld) world).getSavedData().getOrCreate(WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends WorldSavedData {
		public static final String DATA_NAME = "cyberware2_mapvars";
		public double PowerNeeded = 0;
		public boolean LiquidRefractionCalibratorInstalled = false;
		public boolean HasCyberlegs = false;
		public boolean HasCyberarms = false;
		public MapVariables() {
			super(DATA_NAME);
		}

		public MapVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
			PowerNeeded = nbt.getDouble("PowerNeeded");
			LiquidRefractionCalibratorInstalled = nbt.getBoolean("LiquidRefractionCalibratorInstalled");
			HasCyberlegs = nbt.getBoolean("HasCyberlegs");
			HasCyberarms = nbt.getBoolean("HasCyberarms");
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			nbt.putDouble("PowerNeeded", PowerNeeded);
			nbt.putBoolean("LiquidRefractionCalibratorInstalled", LiquidRefractionCalibratorInstalled);
			nbt.putBoolean("HasCyberlegs", HasCyberlegs);
			nbt.putBoolean("HasCyberarms", HasCyberarms);
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !world.isRemote())
				Cyberware2Mod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new WorldSavedDataSyncMessage(0, this));
		}
		static MapVariables clientSide = new MapVariables();
		public static MapVariables get(IWorld world) {
			if (world instanceof IServerWorld) {
				return ((IServerWorld) world).getWorld().getServer().getWorld(World.OVERWORLD).getSavedData().getOrCreate(MapVariables::new,
						DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class WorldSavedDataSyncMessage {
		public int type;
		public WorldSavedData data;
		public WorldSavedDataSyncMessage(PacketBuffer buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			this.data.read(buffer.readCompoundTag());
		}

		public WorldSavedDataSyncMessage(int type, WorldSavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(WorldSavedDataSyncMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.type);
			buffer.writeCompoundTag(message.data.write(new CompoundNBT()));
		}

		public static void handler(WorldSavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}
	@CapabilityInject(PlayerVariables.class)
	public static Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = null;
	@SubscribeEvent
	public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))
			event.addCapability(new ResourceLocation("cyberware2", "player_variables"), new PlayerVariablesProvider());
	}
	private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(PLAYER_VARIABLES_CAPABILITY::getDefaultInstance);
		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			return PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new),
					null);
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null,
					nbt);
		}
	}

	private static class PlayerVariablesStorage implements Capability.IStorage<PlayerVariables> {
		@Override
		public INBT writeNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putDouble("PlayerTolerance", instance.PlayerTolerance);
			nbt.putDouble("PlayerPower", instance.PlayerPower);
			nbt.putDouble("PlayerPowerStored", instance.PlayerPowerStored);
			nbt.putBoolean("QuickdrawFlywheelsInstalled", instance.QuickdrawFlywheelsInstalled);
			nbt.putDouble("MarrowBatteryInstalled", instance.MarrowBatteryInstalled);
			nbt.putBoolean("CitrateEnhancementInstalled", instance.CitrateEnhancementInstalled);
			nbt.putDouble("BonelacingInstalled", instance.BonelacingInstalled);
			nbt.putBoolean("AdrenalinePumpInstalled", instance.AdrenalinePumpInstalled);
			nbt.putBoolean("AdrenalinePumpActive", instance.AdrenalinePumpActive);
			nbt.putBoolean("AquaticPropulsionSystemInstalled", instance.AquaticPropulsionSystemInstalled);
			nbt.putBoolean("AquaticPropulsionSystemActive", instance.AquaticPropulsionSystemActive);
			nbt.putBoolean("CardiomechanicPumpInstalled", instance.CardiomechanicPumpInstalled);
			nbt.putBoolean("CardiomechanicPumpActive", instance.CardiomechanicPumpActive);
			nbt.putBoolean("CardiovascularCouplerInstalled", instance.CardiovascularCouplerInstalled);
			nbt.putBoolean("CardiovascularCouplerActive", instance.CardiovascularCouplerActive);
			nbt.putBoolean("ConsiousnessTransmitterInstalled", instance.ConsiousnessTransmitterInstalled);
			nbt.putBoolean("CorticalStackInstalled", instance.CorticalStackInstalled);
			nbt.putBoolean("CybereyesInstalled", instance.CybereyesInstalled);
			nbt.putBoolean("DeployableWheelsInstalled", instance.DeployableWheelsInstalled);
			nbt.putBoolean("DistanceEnhancerInstalled", instance.DistanceEnhancerInstalled);
			nbt.putBoolean("DistanceEnhancerActive", instance.DistanceEnhancerActive);
			nbt.putBoolean("EnderJammerInstalled", instance.EnderJammerInstalled);
			nbt.putBoolean("EnderJammerActive", instance.EnderJammerActive);
			nbt.putBoolean("FallBracersInstalled", instance.FallBracersInstalled);
			nbt.putBoolean("FineManipulatorsInstalled", instance.FineManipulatorsInstalled);
			nbt.putBoolean("HudjackInstalled", instance.HudjackInstalled);
			nbt.putBoolean("HudlensInstalled", instance.HudlensInstalled);
			nbt.putDouble("HyperoxygenationBoostInstalled", instance.HyperoxygenationBoostInstalled);
			nbt.putBoolean("ImplantedSpursInstalled", instance.ImplantedSpursInstalled);
			nbt.putDouble("InternalBatteryInstalled", instance.InternalBatteryInstalled);
			nbt.putBoolean("InternalDefibrillatorInstalled", instance.InternalDefibrillatorInstalled);
			nbt.putBoolean("InternalDefibrillatorActive", instance.InternalDefibrillatorActive);
			nbt.putBoolean("IsothermicSkinInstalled", instance.IsothermicSkinInstalled);
			nbt.putBoolean("IsothermicSkinActive", instance.IsothermicSkinActive);
			nbt.putBoolean("LeftCyberarmInstalled", instance.LeftCyberarmInstalled);
			nbt.putBoolean("RightCyberarmInstalled", instance.RightCyberarmInstalled);
			nbt.putBoolean("LeftCyberlegInstalled", instance.LeftCyberlegInstalled);
			nbt.putBoolean("RightCyberlegInstalled", instance.RightCyberlegInstalled);
			nbt.putBoolean("LinearActuatorsInstalled", instance.LinearActuatorsInstalled);
			nbt.putBoolean("LiverFilterInstalled", instance.LiverFilterInstalled);
			nbt.putBoolean("MetabolicGeneratorInstalled", instance.MetabolicGeneratorInstalled);
			nbt.putBoolean("MetabolicGeneratorActive", instance.MetabolicGeneratorActive);
			nbt.putBoolean("MyomerMuscleReplacementInstalled", instance.MyomerMuscleReplacementInstalled);
			nbt.putBoolean("NeuralContextualizerInstalled", instance.NeuralContextualizerInstalled);
			nbt.putBoolean("NightVisionInstalled", instance.NightVisionInstalled);
			nbt.putBoolean("NightVisionActive", instance.NightVisionActive);
			nbt.putBoolean("PlateletDispatcherInstalled", instance.PlateletDispatcherInstalled);
			nbt.putBoolean("PlateletDispatcherActive", instance.PlateletDispatcherActive);
			nbt.putBoolean("ReinforcedFistInstalled", instance.ReinforcedFistInstalled);
			nbt.putBoolean("RetractableClawsInstalled", instance.RetractableClawsInstalled);
			nbt.putBoolean("SolarSkinInstalled", instance.SolarSkinInstalled);
			nbt.putBoolean("SolarSkinActive", instance.SolarSkinActive);
			nbt.putBoolean("StemCellSynthesizerInstalled", instance.StemCellSynthesizerInstalled);
			nbt.putBoolean("StemCellSynthesizerActive", instance.StemCellSynthesizerActive);
			nbt.putBoolean("SubdermalSpikesInstalled", instance.SubdermalSpikesInstalled);
			nbt.putBoolean("SyntheticChromatophoresInstalled", instance.SyntheticChromatophoresInstalled);
			nbt.putBoolean("SyntheticChromatophoresActive", instance.SyntheticChromatophoresActive);
			nbt.putBoolean("TargetedImmunosuppressantInstalled", instance.TargetedImmunosuppressantInstalled);
			nbt.putBoolean("TargetingOverlayInstalled", instance.TargetingOverlayInstalled);
			nbt.putBoolean("TargetingOverlayActive", instance.TargetingOverlayActive);
			nbt.putBoolean("ThreatMatrixCalculatorInstalled", instance.ThreatMatrixCalculatorInstalled);
			nbt.putBoolean("UltradenseCapacitorInstalled", instance.UltradenseCapacitorInstalled);
			nbt.putDouble("WiredReflexesInstalled", instance.WiredReflexesInstalled);
			nbt.putBoolean("SyntheticSkinInstalled", instance.SyntheticSkinInstalled);
			nbt.putBoolean("CompressedOxygenImplantInstalled", instance.CompressedOxygenImplantInstalled);
			nbt.putBoolean("ConsciousnessTransmitterActive", instance.ConsciousnessTransmitterActive);
			nbt.putDouble("PlayerMaxPower", instance.PlayerMaxPower);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.PlayerTolerance = nbt.getDouble("PlayerTolerance");
			instance.PlayerPower = nbt.getDouble("PlayerPower");
			instance.PlayerPowerStored = nbt.getDouble("PlayerPowerStored");
			instance.QuickdrawFlywheelsInstalled = nbt.getBoolean("QuickdrawFlywheelsInstalled");
			instance.MarrowBatteryInstalled = nbt.getDouble("MarrowBatteryInstalled");
			instance.CitrateEnhancementInstalled = nbt.getBoolean("CitrateEnhancementInstalled");
			instance.BonelacingInstalled = nbt.getDouble("BonelacingInstalled");
			instance.AdrenalinePumpInstalled = nbt.getBoolean("AdrenalinePumpInstalled");
			instance.AdrenalinePumpActive = nbt.getBoolean("AdrenalinePumpActive");
			instance.AquaticPropulsionSystemInstalled = nbt.getBoolean("AquaticPropulsionSystemInstalled");
			instance.AquaticPropulsionSystemActive = nbt.getBoolean("AquaticPropulsionSystemActive");
			instance.CardiomechanicPumpInstalled = nbt.getBoolean("CardiomechanicPumpInstalled");
			instance.CardiomechanicPumpActive = nbt.getBoolean("CardiomechanicPumpActive");
			instance.CardiovascularCouplerInstalled = nbt.getBoolean("CardiovascularCouplerInstalled");
			instance.CardiovascularCouplerActive = nbt.getBoolean("CardiovascularCouplerActive");
			instance.ConsiousnessTransmitterInstalled = nbt.getBoolean("ConsiousnessTransmitterInstalled");
			instance.CorticalStackInstalled = nbt.getBoolean("CorticalStackInstalled");
			instance.CybereyesInstalled = nbt.getBoolean("CybereyesInstalled");
			instance.DeployableWheelsInstalled = nbt.getBoolean("DeployableWheelsInstalled");
			instance.DistanceEnhancerInstalled = nbt.getBoolean("DistanceEnhancerInstalled");
			instance.DistanceEnhancerActive = nbt.getBoolean("DistanceEnhancerActive");
			instance.EnderJammerInstalled = nbt.getBoolean("EnderJammerInstalled");
			instance.EnderJammerActive = nbt.getBoolean("EnderJammerActive");
			instance.FallBracersInstalled = nbt.getBoolean("FallBracersInstalled");
			instance.FineManipulatorsInstalled = nbt.getBoolean("FineManipulatorsInstalled");
			instance.HudjackInstalled = nbt.getBoolean("HudjackInstalled");
			instance.HudlensInstalled = nbt.getBoolean("HudlensInstalled");
			instance.HyperoxygenationBoostInstalled = nbt.getDouble("HyperoxygenationBoostInstalled");
			instance.ImplantedSpursInstalled = nbt.getBoolean("ImplantedSpursInstalled");
			instance.InternalBatteryInstalled = nbt.getDouble("InternalBatteryInstalled");
			instance.InternalDefibrillatorInstalled = nbt.getBoolean("InternalDefibrillatorInstalled");
			instance.InternalDefibrillatorActive = nbt.getBoolean("InternalDefibrillatorActive");
			instance.IsothermicSkinInstalled = nbt.getBoolean("IsothermicSkinInstalled");
			instance.IsothermicSkinActive = nbt.getBoolean("IsothermicSkinActive");
			instance.LeftCyberarmInstalled = nbt.getBoolean("LeftCyberarmInstalled");
			instance.RightCyberarmInstalled = nbt.getBoolean("RightCyberarmInstalled");
			instance.LeftCyberlegInstalled = nbt.getBoolean("LeftCyberlegInstalled");
			instance.RightCyberlegInstalled = nbt.getBoolean("RightCyberlegInstalled");
			instance.LinearActuatorsInstalled = nbt.getBoolean("LinearActuatorsInstalled");
			instance.LiverFilterInstalled = nbt.getBoolean("LiverFilterInstalled");
			instance.MetabolicGeneratorInstalled = nbt.getBoolean("MetabolicGeneratorInstalled");
			instance.MetabolicGeneratorActive = nbt.getBoolean("MetabolicGeneratorActive");
			instance.MyomerMuscleReplacementInstalled = nbt.getBoolean("MyomerMuscleReplacementInstalled");
			instance.NeuralContextualizerInstalled = nbt.getBoolean("NeuralContextualizerInstalled");
			instance.NightVisionInstalled = nbt.getBoolean("NightVisionInstalled");
			instance.NightVisionActive = nbt.getBoolean("NightVisionActive");
			instance.PlateletDispatcherInstalled = nbt.getBoolean("PlateletDispatcherInstalled");
			instance.PlateletDispatcherActive = nbt.getBoolean("PlateletDispatcherActive");
			instance.ReinforcedFistInstalled = nbt.getBoolean("ReinforcedFistInstalled");
			instance.RetractableClawsInstalled = nbt.getBoolean("RetractableClawsInstalled");
			instance.SolarSkinInstalled = nbt.getBoolean("SolarSkinInstalled");
			instance.SolarSkinActive = nbt.getBoolean("SolarSkinActive");
			instance.StemCellSynthesizerInstalled = nbt.getBoolean("StemCellSynthesizerInstalled");
			instance.StemCellSynthesizerActive = nbt.getBoolean("StemCellSynthesizerActive");
			instance.SubdermalSpikesInstalled = nbt.getBoolean("SubdermalSpikesInstalled");
			instance.SyntheticChromatophoresInstalled = nbt.getBoolean("SyntheticChromatophoresInstalled");
			instance.SyntheticChromatophoresActive = nbt.getBoolean("SyntheticChromatophoresActive");
			instance.TargetedImmunosuppressantInstalled = nbt.getBoolean("TargetedImmunosuppressantInstalled");
			instance.TargetingOverlayInstalled = nbt.getBoolean("TargetingOverlayInstalled");
			instance.TargetingOverlayActive = nbt.getBoolean("TargetingOverlayActive");
			instance.ThreatMatrixCalculatorInstalled = nbt.getBoolean("ThreatMatrixCalculatorInstalled");
			instance.UltradenseCapacitorInstalled = nbt.getBoolean("UltradenseCapacitorInstalled");
			instance.WiredReflexesInstalled = nbt.getDouble("WiredReflexesInstalled");
			instance.SyntheticSkinInstalled = nbt.getBoolean("SyntheticSkinInstalled");
			instance.CompressedOxygenImplantInstalled = nbt.getBoolean("CompressedOxygenImplantInstalled");
			instance.ConsciousnessTransmitterActive = nbt.getBoolean("ConsciousnessTransmitterActive");
			instance.PlayerMaxPower = nbt.getDouble("PlayerMaxPower");
		}
	}

	public static class PlayerVariables {
		public double PlayerTolerance = 100.0;
		public double PlayerPower = 0;
		public double PlayerPowerStored = 0;
		public boolean QuickdrawFlywheelsInstalled = false;
		public double MarrowBatteryInstalled = 0;
		public boolean CitrateEnhancementInstalled = false;
		public double BonelacingInstalled = 0;
		public boolean AdrenalinePumpInstalled = false;
		public boolean AdrenalinePumpActive = false;
		public boolean AquaticPropulsionSystemInstalled = false;
		public boolean AquaticPropulsionSystemActive = false;
		public boolean CardiomechanicPumpInstalled = false;
		public boolean CardiomechanicPumpActive = false;
		public boolean CardiovascularCouplerInstalled = false;
		public boolean CardiovascularCouplerActive = false;
		public boolean ConsiousnessTransmitterInstalled = false;
		public boolean CorticalStackInstalled = false;
		public boolean CybereyesInstalled = false;
		public boolean DeployableWheelsInstalled = false;
		public boolean DistanceEnhancerInstalled = false;
		public boolean DistanceEnhancerActive = false;
		public boolean EnderJammerInstalled = false;
		public boolean EnderJammerActive = false;
		public boolean FallBracersInstalled = false;
		public boolean FineManipulatorsInstalled = false;
		public boolean HudjackInstalled = false;
		public boolean HudlensInstalled = false;
		public double HyperoxygenationBoostInstalled = 0;
		public boolean ImplantedSpursInstalled = false;
		public double InternalBatteryInstalled = 0;
		public boolean InternalDefibrillatorInstalled = false;
		public boolean InternalDefibrillatorActive = false;
		public boolean IsothermicSkinInstalled = false;
		public boolean IsothermicSkinActive = false;
		public boolean LeftCyberarmInstalled = false;
		public boolean RightCyberarmInstalled = false;
		public boolean LeftCyberlegInstalled = false;
		public boolean RightCyberlegInstalled = false;
		public boolean LinearActuatorsInstalled = false;
		public boolean LiverFilterInstalled = false;
		public boolean MetabolicGeneratorInstalled = false;
		public boolean MetabolicGeneratorActive = false;
		public boolean MyomerMuscleReplacementInstalled = false;
		public boolean NeuralContextualizerInstalled = false;
		public boolean NightVisionInstalled = false;
		public boolean NightVisionActive = false;
		public boolean PlateletDispatcherInstalled = false;
		public boolean PlateletDispatcherActive = false;
		public boolean ReinforcedFistInstalled = false;
		public boolean RetractableClawsInstalled = false;
		public boolean SolarSkinInstalled = false;
		public boolean SolarSkinActive = false;
		public boolean StemCellSynthesizerInstalled = false;
		public boolean StemCellSynthesizerActive = false;
		public boolean SubdermalSpikesInstalled = false;
		public boolean SyntheticChromatophoresInstalled = false;
		public boolean SyntheticChromatophoresActive = false;
		public boolean TargetedImmunosuppressantInstalled = false;
		public boolean TargetingOverlayInstalled = false;
		public boolean TargetingOverlayActive = false;
		public boolean ThreatMatrixCalculatorInstalled = false;
		public boolean UltradenseCapacitorInstalled = false;
		public double WiredReflexesInstalled = 0;
		public boolean SyntheticSkinInstalled = false;
		public boolean CompressedOxygenImplantInstalled = false;
		public boolean ConsciousnessTransmitterActive = false;
		public double PlayerMaxPower = 0;
		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayerEntity)
				Cyberware2Mod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) entity),
						new PlayerVariablesSyncMessage(this));
		}
	}
	@SubscribeEvent
	public void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PlayerVariables()));
		PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
		clone.PlayerTolerance = original.PlayerTolerance;
		clone.PlayerPower = original.PlayerPower;
		clone.PlayerPowerStored = original.PlayerPowerStored;
		clone.QuickdrawFlywheelsInstalled = original.QuickdrawFlywheelsInstalled;
		clone.MarrowBatteryInstalled = original.MarrowBatteryInstalled;
		clone.CitrateEnhancementInstalled = original.CitrateEnhancementInstalled;
		clone.BonelacingInstalled = original.BonelacingInstalled;
		clone.AdrenalinePumpInstalled = original.AdrenalinePumpInstalled;
		clone.AdrenalinePumpActive = original.AdrenalinePumpActive;
		clone.AquaticPropulsionSystemInstalled = original.AquaticPropulsionSystemInstalled;
		clone.AquaticPropulsionSystemActive = original.AquaticPropulsionSystemActive;
		clone.CardiomechanicPumpInstalled = original.CardiomechanicPumpInstalled;
		clone.CardiomechanicPumpActive = original.CardiomechanicPumpActive;
		clone.CardiovascularCouplerInstalled = original.CardiovascularCouplerInstalled;
		clone.CardiovascularCouplerActive = original.CardiovascularCouplerActive;
		clone.ConsiousnessTransmitterInstalled = original.ConsiousnessTransmitterInstalled;
		clone.CorticalStackInstalled = original.CorticalStackInstalled;
		clone.CybereyesInstalled = original.CybereyesInstalled;
		clone.DeployableWheelsInstalled = original.DeployableWheelsInstalled;
		clone.DistanceEnhancerInstalled = original.DistanceEnhancerInstalled;
		clone.DistanceEnhancerActive = original.DistanceEnhancerActive;
		clone.EnderJammerInstalled = original.EnderJammerInstalled;
		clone.EnderJammerActive = original.EnderJammerActive;
		clone.FallBracersInstalled = original.FallBracersInstalled;
		clone.FineManipulatorsInstalled = original.FineManipulatorsInstalled;
		clone.HudjackInstalled = original.HudjackInstalled;
		clone.HudlensInstalled = original.HudlensInstalled;
		clone.HyperoxygenationBoostInstalled = original.HyperoxygenationBoostInstalled;
		clone.ImplantedSpursInstalled = original.ImplantedSpursInstalled;
		clone.InternalBatteryInstalled = original.InternalBatteryInstalled;
		clone.InternalDefibrillatorInstalled = original.InternalDefibrillatorInstalled;
		clone.InternalDefibrillatorActive = original.InternalDefibrillatorActive;
		clone.IsothermicSkinInstalled = original.IsothermicSkinInstalled;
		clone.IsothermicSkinActive = original.IsothermicSkinActive;
		clone.LeftCyberarmInstalled = original.LeftCyberarmInstalled;
		clone.RightCyberarmInstalled = original.RightCyberarmInstalled;
		clone.LeftCyberlegInstalled = original.LeftCyberlegInstalled;
		clone.RightCyberlegInstalled = original.RightCyberlegInstalled;
		clone.LinearActuatorsInstalled = original.LinearActuatorsInstalled;
		clone.LiverFilterInstalled = original.LiverFilterInstalled;
		clone.MetabolicGeneratorInstalled = original.MetabolicGeneratorInstalled;
		clone.MetabolicGeneratorActive = original.MetabolicGeneratorActive;
		clone.MyomerMuscleReplacementInstalled = original.MyomerMuscleReplacementInstalled;
		clone.NeuralContextualizerInstalled = original.NeuralContextualizerInstalled;
		clone.NightVisionInstalled = original.NightVisionInstalled;
		clone.NightVisionActive = original.NightVisionActive;
		clone.PlateletDispatcherInstalled = original.PlateletDispatcherInstalled;
		clone.PlateletDispatcherActive = original.PlateletDispatcherActive;
		clone.ReinforcedFistInstalled = original.ReinforcedFistInstalled;
		clone.RetractableClawsInstalled = original.RetractableClawsInstalled;
		clone.SolarSkinInstalled = original.SolarSkinInstalled;
		clone.SolarSkinActive = original.SolarSkinActive;
		clone.StemCellSynthesizerInstalled = original.StemCellSynthesizerInstalled;
		clone.StemCellSynthesizerActive = original.StemCellSynthesizerActive;
		clone.SubdermalSpikesInstalled = original.SubdermalSpikesInstalled;
		clone.SyntheticChromatophoresInstalled = original.SyntheticChromatophoresInstalled;
		clone.SyntheticChromatophoresActive = original.SyntheticChromatophoresActive;
		clone.TargetedImmunosuppressantInstalled = original.TargetedImmunosuppressantInstalled;
		clone.TargetingOverlayInstalled = original.TargetingOverlayInstalled;
		clone.TargetingOverlayActive = original.TargetingOverlayActive;
		clone.ThreatMatrixCalculatorInstalled = original.ThreatMatrixCalculatorInstalled;
		clone.UltradenseCapacitorInstalled = original.UltradenseCapacitorInstalled;
		clone.WiredReflexesInstalled = original.WiredReflexesInstalled;
		clone.SyntheticSkinInstalled = original.SyntheticSkinInstalled;
		clone.CompressedOxygenImplantInstalled = original.CompressedOxygenImplantInstalled;
		clone.ConsciousnessTransmitterActive = original.ConsciousnessTransmitterActive;
		clone.PlayerMaxPower = original.PlayerMaxPower;
		if (!event.isWasDeath()) {
		}
	}
	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;
		public PlayerVariablesSyncMessage(PacketBuffer buffer) {
			this.data = new PlayerVariables();
			new PlayerVariablesStorage().readNBT(null, this.data, null, buffer.readCompoundTag());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, PacketBuffer buffer) {
			buffer.writeCompoundTag((CompoundNBT) new PlayerVariablesStorage().writeNBT(null, message.data, null));
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.PlayerTolerance = message.data.PlayerTolerance;
					variables.PlayerPower = message.data.PlayerPower;
					variables.PlayerPowerStored = message.data.PlayerPowerStored;
					variables.QuickdrawFlywheelsInstalled = message.data.QuickdrawFlywheelsInstalled;
					variables.MarrowBatteryInstalled = message.data.MarrowBatteryInstalled;
					variables.CitrateEnhancementInstalled = message.data.CitrateEnhancementInstalled;
					variables.BonelacingInstalled = message.data.BonelacingInstalled;
					variables.AdrenalinePumpInstalled = message.data.AdrenalinePumpInstalled;
					variables.AdrenalinePumpActive = message.data.AdrenalinePumpActive;
					variables.AquaticPropulsionSystemInstalled = message.data.AquaticPropulsionSystemInstalled;
					variables.AquaticPropulsionSystemActive = message.data.AquaticPropulsionSystemActive;
					variables.CardiomechanicPumpInstalled = message.data.CardiomechanicPumpInstalled;
					variables.CardiomechanicPumpActive = message.data.CardiomechanicPumpActive;
					variables.CardiovascularCouplerInstalled = message.data.CardiovascularCouplerInstalled;
					variables.CardiovascularCouplerActive = message.data.CardiovascularCouplerActive;
					variables.ConsiousnessTransmitterInstalled = message.data.ConsiousnessTransmitterInstalled;
					variables.CorticalStackInstalled = message.data.CorticalStackInstalled;
					variables.CybereyesInstalled = message.data.CybereyesInstalled;
					variables.DeployableWheelsInstalled = message.data.DeployableWheelsInstalled;
					variables.DistanceEnhancerInstalled = message.data.DistanceEnhancerInstalled;
					variables.DistanceEnhancerActive = message.data.DistanceEnhancerActive;
					variables.EnderJammerInstalled = message.data.EnderJammerInstalled;
					variables.EnderJammerActive = message.data.EnderJammerActive;
					variables.FallBracersInstalled = message.data.FallBracersInstalled;
					variables.FineManipulatorsInstalled = message.data.FineManipulatorsInstalled;
					variables.HudjackInstalled = message.data.HudjackInstalled;
					variables.HudlensInstalled = message.data.HudlensInstalled;
					variables.HyperoxygenationBoostInstalled = message.data.HyperoxygenationBoostInstalled;
					variables.ImplantedSpursInstalled = message.data.ImplantedSpursInstalled;
					variables.InternalBatteryInstalled = message.data.InternalBatteryInstalled;
					variables.InternalDefibrillatorInstalled = message.data.InternalDefibrillatorInstalled;
					variables.InternalDefibrillatorActive = message.data.InternalDefibrillatorActive;
					variables.IsothermicSkinInstalled = message.data.IsothermicSkinInstalled;
					variables.IsothermicSkinActive = message.data.IsothermicSkinActive;
					variables.LeftCyberarmInstalled = message.data.LeftCyberarmInstalled;
					variables.RightCyberarmInstalled = message.data.RightCyberarmInstalled;
					variables.LeftCyberlegInstalled = message.data.LeftCyberlegInstalled;
					variables.RightCyberlegInstalled = message.data.RightCyberlegInstalled;
					variables.LinearActuatorsInstalled = message.data.LinearActuatorsInstalled;
					variables.LiverFilterInstalled = message.data.LiverFilterInstalled;
					variables.MetabolicGeneratorInstalled = message.data.MetabolicGeneratorInstalled;
					variables.MetabolicGeneratorActive = message.data.MetabolicGeneratorActive;
					variables.MyomerMuscleReplacementInstalled = message.data.MyomerMuscleReplacementInstalled;
					variables.NeuralContextualizerInstalled = message.data.NeuralContextualizerInstalled;
					variables.NightVisionInstalled = message.data.NightVisionInstalled;
					variables.NightVisionActive = message.data.NightVisionActive;
					variables.PlateletDispatcherInstalled = message.data.PlateletDispatcherInstalled;
					variables.PlateletDispatcherActive = message.data.PlateletDispatcherActive;
					variables.ReinforcedFistInstalled = message.data.ReinforcedFistInstalled;
					variables.RetractableClawsInstalled = message.data.RetractableClawsInstalled;
					variables.SolarSkinInstalled = message.data.SolarSkinInstalled;
					variables.SolarSkinActive = message.data.SolarSkinActive;
					variables.StemCellSynthesizerInstalled = message.data.StemCellSynthesizerInstalled;
					variables.StemCellSynthesizerActive = message.data.StemCellSynthesizerActive;
					variables.SubdermalSpikesInstalled = message.data.SubdermalSpikesInstalled;
					variables.SyntheticChromatophoresInstalled = message.data.SyntheticChromatophoresInstalled;
					variables.SyntheticChromatophoresActive = message.data.SyntheticChromatophoresActive;
					variables.TargetedImmunosuppressantInstalled = message.data.TargetedImmunosuppressantInstalled;
					variables.TargetingOverlayInstalled = message.data.TargetingOverlayInstalled;
					variables.TargetingOverlayActive = message.data.TargetingOverlayActive;
					variables.ThreatMatrixCalculatorInstalled = message.data.ThreatMatrixCalculatorInstalled;
					variables.UltradenseCapacitorInstalled = message.data.UltradenseCapacitorInstalled;
					variables.WiredReflexesInstalled = message.data.WiredReflexesInstalled;
					variables.SyntheticSkinInstalled = message.data.SyntheticSkinInstalled;
					variables.CompressedOxygenImplantInstalled = message.data.CompressedOxygenImplantInstalled;
					variables.ConsciousnessTransmitterActive = message.data.ConsciousnessTransmitterActive;
					variables.PlayerMaxPower = message.data.PlayerMaxPower;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
