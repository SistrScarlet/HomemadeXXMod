package com.sistr.homemadexx.setup;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public interface IProxy {

    World getClientWorld();

    PlayerEntity getClientPlayer();
}
