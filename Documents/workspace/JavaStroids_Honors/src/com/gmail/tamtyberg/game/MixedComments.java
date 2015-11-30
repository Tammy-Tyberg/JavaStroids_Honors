package com.HCIHonors.javastroid.game;


import com.HCIHonors.javastroid.screens.AbstractScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;


public class MixedComments extends AbstractScreen{

//////////////////////////////////////////////Member Variables/////////////////////////////////////////////////////////////////


	Controller control;  //instance of Controller
	Renderer render;
	
	int mode;
			
	    	    
/////////////////////////////////////////////////Member Methods////////////////////////////////////////////////////////////////////////
	    
	public MixedComments(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}  
	
	    //create method- creates controller object and then using that a renderer object
	    @Override
		public void show() {
			
			control = new Controller();
			render = new Renderer(control);	
			
	 		}
	    
	    

		@Override
		public void render(float arg0) {
	    	Gdx.gl.glClearColor( 0, 0, 0,1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
			control.update(); // Process inputs and update game world.

			//mixed comments
			Gdx.app.log("Main3", "The mixed comments");
				render.render(3);
		}
	    
		
		
		//dispose method
		@Override
		public void dispose(){
			Gdx.app.log("my Main Screen", "dispose called");
	        stage.dispose();
			
	        control.dispose();
		}
		

				@Override
				public void hide() {
					
					 Gdx.app.log("my Main Screen", "hide called");
				}

								
			
		
}
