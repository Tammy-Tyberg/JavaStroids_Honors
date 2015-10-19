package com.gmail.tamtyberg.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gmail.tamtyberg.game.Game;



public class JavaStroidsLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "JavaStroids";
		config.width = 800;
		config.height = 480; 
		new LwjglApplication(new Game(), config);
	}
}
