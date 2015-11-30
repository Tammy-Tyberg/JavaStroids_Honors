package com.HCIHonors.javastroid.desktop;


import com.HCIHonors.javastroid.Main.MainGame;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class JavaStroidsLauncher {
	
	public static void main (String[] arg) {
		
		//Lwjgl object and initializes it
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		 
		
		// whether to use OpenGL ES 2.0
    
		config.title = "JavaStroids"; //gives title to frame
		
		config.width = 800; //frame width
		
		config.height = 600;  //frame height
		
		//this one line is the whole game
		new LwjglApplication(new MainGame(), config); //lgwjglApp with Game passed in and config object
	}
}
