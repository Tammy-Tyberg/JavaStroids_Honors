package com.HCIHonors.javastroid.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AbstractScreen implements Screen {
	
	protected final Game game;
	protected final Stage stage;
	
	private BitmapFont font;
    private SpriteBatch batch;
    private Skin skin;
    
    public AbstractScreen(
           Game game )
        {
            this.game = game;
            this.stage = new Stage();
        }
    
 // Lazily loaded collaborators

    public BitmapFont getFont()
    {
        if( font == null ) {
            font = new BitmapFont();
        }
        return font;
    }

    public SpriteBatch getBatch()
    {
        if( batch == null ) {
            batch = new SpriteBatch();
        }
        return batch;
    }
    
    protected Skin getSkin()
    {
        if( skin == null ) {
            skin = new Skin();
        }
        return skin;
    }
    
    
    // Screen implementation

    @Override
    public void show()
    {
    	Gdx.app.log("AbstractScreen", "Show() called");

        // set the stage as the input processor
        Gdx.input.setInputProcessor(stage );
    }

    @Override
    public void resize(
        int width,
        int height )
    {
        Gdx.app.log("AbstractScreen ", "Resize() called" );
    }

    @Override
    public void render(
        float delta )
    {
        // (1) process the game logic

        // update the actors
        stage.act( delta );

        // (2) draw the result

        // clear the screen with the given RGB color (black)
        Gdx.gl.glClearColor( 0f, 0f, 0f, 1f );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );

        // draw the actors
        stage.draw();
    }

    @Override
    public void hide()
    {
        Gdx.app.log( "AbstractScreen", "Hide() called");

        // dispose the screen when leaving the screen;
        // note that the dipose() method is not called automatically by the
        // framework, so we must figure out when it's appropriate to call it
        dispose();
    }

    @Override
    public void pause()
    {
       
    }

    @Override
    public void resume()
    {
       
    }

    @Override
    public void dispose()
    {
        Gdx.app.log("AbstractScreen:", "Disposing screen called ");

        // as the collaborators are lazily loaded, they may be null
        if( font != null ) font.dispose();
        if( batch != null ) batch.dispose();
        if( skin != null ) skin.dispose();
       
    }

}
    

