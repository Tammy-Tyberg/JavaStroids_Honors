/*Mainmenu.java
 * This sets the main menu screen which has the play button 
 * which then calls Main.java to call render and access the game. 
 */
package com.HCIHonors.javastroid.screens;


import com.HCIHonors.javastroid.game.PosComments;
import com.HCIHonors.javastroid.game.NegComments;
import com.HCIHonors.javastroid.game.MixedComments;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;


public class MainMenu extends AbstractScreen {
	
	Skin skin;
    Stage stage;
    SpriteBatch batch;
    Texture texture;
    OrthographicCamera camera;
    Table table = new Table();
    BitmapFont header;
   
    
       
    public MainMenu(Game game) {
		super(game);
        Gdx.app.log("my Main Screen", "constructor called");
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 512, 512);
       create();

    }
   
    
    
    public void create() {
    	Gdx.app.log("Background:", "being called");
    	batch = new SpriteBatch();
    	
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		
		//adding the background screen
		texture = new Texture(Gdx.files.internal("assets/asteroid_bg2.jpg")); 
		header = new BitmapFont(); //initialize the font object
		//this sets the size
		header.scale(3);
		header.setColor(Color.WHITE);//set font color to green
		
		

		// A skin can be loaded via JSON or defined programmatically, either is fine. Using a skin is optional but strongly
		// recommended solely for the convenience of getting a texture, region, etc as a drawable, tinted drawable, etc.
		skin = new Skin();
		// Generate a 1x1 white texture and store it in the skin named "white".
		Gdx.app.log("MainMENU.java:", "TRYING TO GET THE BACKGROUND WORKING");
       		
		
		//THIS COLORS THE BUTTON
		Pixmap pixmap = new Pixmap(100, 100, Format.RGBA8888);
		pixmap.setColor(Color.BLUE);
		pixmap.fill();

		//** texture is now the splash image **//);
		skin.add("white", new Texture(pixmap));

				

		// Store the default libgdx font under the name "default".
		BitmapFont bfont=new BitmapFont();
		bfont.scale((float) .5);
		skin.add("default",bfont);

		// Configure a TextButtonStyle and name it "default". Skin resources are stored by type, so this doesn't overwrite the font.
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.down = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
		textButtonStyle.over = skin.newDrawable("white", Color.YELLOW);
		textButtonStyle.font = skin.getFont("default");
		skin.add("default", textButtonStyle);

		// Create a button with the "default" TextButtonStyle. A 3rd parameter can be used to specify a name other than "default".
		final TextButton textButton1=new TextButton("Option One   ",textButtonStyle);
		final TextButton textButton2=new TextButton("Option Two   ",textButtonStyle);
		final TextButton textButton3=new TextButton("Option Three ",textButtonStyle);
		textButton1.setPosition(330, 340);
		textButton2.setPosition(330, 195);
		textButton3.setPosition(330, 50);
		stage.addActor(textButton1);
		stage.addActor(textButton2);
		stage.addActor(textButton3);
		
		//adding the background image to the tab
		stage.addActor(table);
		Gdx.input.setInputProcessor(stage);
		
		
		// Add a listener to the button. ChangeListener is fired when the button's checked state changes, eg when clicked,
				// Button#setChecked() is called, via a key press, etc. If the event.cancel() is called, the checked state will be reverted.
				// ClickListener could have been used, but would only fire when clicked. Also, canceling a ClickListener event won't
				// revert the checked state
				
		textButton1.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				//textButton.setText("Submitting...");
				
				game.setScreen(new PosComments(game));
				Gdx.app.log("Mode1:", "The Button was clicked");
 			}
		});
		
		textButton2.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				//textButton.setText("Submitting...");
				game.setScreen(new NegComments(game));
				Gdx.app.log("Mode2:", "The Button was clicked");
 			}
		});
		
		
		textButton3.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				//textButton.setText("Submitting...");
				game.setScreen(new MixedComments(game));
				Gdx.app.log("Mode3:", "The Button was clicked");
 			}
		});
		

	}

	
	/**
     * Renders the screen.
     * Clears all objects on the screen and redraws.
     * @param delta The time since the last refresh
     */
    public void render (float delta) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//drawing thebackground image
		batch.begin();
		batch.draw(texture, 0, 0);
		//drawing the header text
		header.draw(batch, "HCI JAVASTROIDS", 150,550);
		batch.end();
		
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
		table.debug();
		
		
	}

    @Override
    public void resize(int width, int height) {
    }
    
    
	@Override
	public void show(){		
		Gdx.app.log("MainMenu:", "Show() called");
		
	}
    
	@Override
    public void hide() {
        Gdx.app.log("my Main Screen", "hide called");
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        Gdx.app.log("my Main Screen", "dispose called");
        stage.dispose();
        skin.dispose();
       
    }

}


