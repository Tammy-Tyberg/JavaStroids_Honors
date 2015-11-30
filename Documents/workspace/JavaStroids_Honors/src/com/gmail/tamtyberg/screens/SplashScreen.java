/*
 * This class is the first screen which 
 * 
 * 
 */

package com.HCIHonors.javastroid.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.TimeUtils;

public class SplashScreen extends AbstractScreen{
    
	

	private Stage stage = new Stage();
	private Table table = new Table();
   //draw all needed pictures in the screen
	private SpriteBatch batch;
    private Texture texture;
   	
    private OrthographicCamera camera;
    private long startTime;
    private int rendCount;
    
    int w = 0;
    int h = 0;
    int tw = 0;
    int th = 0;
    
    
   
    public SplashScreen(Game game) {
		super(game);
		Gdx.app.log("my Spash Screen", "constructor called");
	
        //camera.setToOrtho(false, 512, 512);
        batch = new SpriteBatch();

    }

    @Override
    public void render(float delta) {
        //Gdx.gl.glClearColor(0, 0, 10, 1);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        batch.setProjectionMatrix(camera.combined);
       	batch.begin();
       	//this places the screen picture in the middle of the screen
        batch.draw(texture, camera.position.x - (tw / 2), camera.position.y - (th / 2));
        batch.end();
        rendCount++;
        if (TimeUtils.millis()>(startTime+2000)) game.setScreen(new MainMenu(game));
        
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    	Gdx.app.log("my Splash Screen", "show called");
        
    	
    	w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(w, h);
        camera.position.set(w / 2, h/ 2, 0);
        camera.update();
       
      //** texture is now the splash image **//
        texture = new Texture(Gdx.files.internal("assets/SCREEN.png")); 
        tw = texture.getWidth();
        th = texture.getHeight();
        
    	
        startTime = TimeUtils.millis();
        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);


    }

    @Override
    public void hide() {
        Gdx.app.log("my Splash Screen", "hide called");
        Gdx.app.log("my Splash Screen", "rendered " + rendCount + " times.");
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
       stage.dispose();
         }

}
