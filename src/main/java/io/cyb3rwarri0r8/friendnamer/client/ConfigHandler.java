package io.cyb3rwarri0r8.friendnamer.client;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import io.cyb3rwarri0r8.friendnamer.lib.Strings;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * FriendNamer - A Minecraft Modification
 * Copyright (C) 2015 Cyb3rWarri0r8
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
public class ConfigHandler {
    public static Configuration configuration;

    public static void init(File configFile){
        if (configuration == null){
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    private static void loadConfiguration(){



        if (configuration.hasChanged()){
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChanged(ConfigChangedEvent.OnConfigChangedEvent event){
        if (event.modID.equalsIgnoreCase(Strings.MODID)){
            loadConfiguration();
        }
    }
}
