package com.legacy.aether.network.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class PacketAchievement extends AetherPacket<PacketAchievement> {

	public int achievementType;

	public PacketAchievement() {

	}

	public PacketAchievement(int achievementType) {
		this.achievementType = achievementType;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.achievementType = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.achievementType);
	}

	@Override
	public void handleClient(PacketAchievement message, EntityPlayer player) {
		net.minecraft.client.Minecraft.getMinecraft().getSoundHandler().playSound(com.legacy.aether.client.audio.AetherMusicHandler.getAchievementSound(message.achievementType));
	}

	@Override
	public void handleServer(PacketAchievement message, EntityPlayer player) {

	}

}