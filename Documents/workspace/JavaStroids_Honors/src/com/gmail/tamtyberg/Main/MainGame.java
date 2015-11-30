package com.HCIHonors.javastroid.Main;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.TimeUtils;
import com.HCIHonors.javastroid.screens.SplashScreen;

public class MainGame extends Game  {
	
	
    private int rendCount; //** render count **//
    private long startTime; //** time app started **//
    private long endTime; //** time app ended **//
    public Skin skin;
    
    
    
    
    //Game Methods
    
    @Override
    public void create() {
    	
    	
        Gdx.app.log("my Splash Game","App created");
        startTime = TimeUtils.millis();
        setScreen(new SplashScreen(this)); //** start SpashSreen, with Game parameter **//
    }
    
   

    public void dispose() {
        Gdx.app.log("my Splash Game", "App rendered " + rendCount + " times");
        Gdx.app.log("my Splash Game", "App ended");
        endTime = TimeUtils.millis();
        Gdx.app.log("my Splash Game", "App running for " + (endTime-startTime)/1000 + " seconds.");
    }
}



