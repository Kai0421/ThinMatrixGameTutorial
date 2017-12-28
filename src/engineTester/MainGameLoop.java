package engineTester;

import models.TexturedModel;
import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import models.RawModel;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;

public class MainGameLoop {

	public static void main(String[] args) {
		// TODO Auto-generateTd method stub
		DisplayManager.createDisplay();
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		StaticShader shader = new StaticShader();
		
		float[] vertices = {
			    -0.5f, 0.5f, 0, 	//V0
			    -0.5f, -0.5f, 0,	//V1
			    0.5f, -0.5f, 0,		//V2
			    0.5f, 0.5f, 0,		//V3
			  };

		int[] indices = {
				0, 1, 3,	//Top Left Triangle (V0, V1, V3)
				3, 1, 2		//Bottom right Triangle (V3, V1, V2)
		};

		float[] textureCoords= {
				0, 0,	//V0
				0, 1, 	//V1
				1, 1, 	//V3
				1, 0, 	//V2
		};
		
		RawModel model = loader.loadToVAO(vertices, textureCoords, indices);
		ModelTexture texture = new ModelTexture(loader.loadTexture("image"));
		TexturedModel texturedModel = new TexturedModel(model, texture);
		
		while(!Display.isCloseRequested()){
			//gameLogic

			//render
			renderer.prepare();
			shader.start();
			renderer.render(texturedModel);
			shader.stop();
			DisplayManager.updateDisplay();
		}

		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}

}
