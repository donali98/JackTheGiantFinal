package com.dona.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.dona.JackGame;
import helpers.GameInfo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//Modificando alto y ancho del programa
		config.width = GameInfo.WIDTH;
		config.height = GameInfo.HEIGHT;
		new LwjglApplication(new JackGame(), config);
	}
}
