package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;

public class MainGameLoop {

	public static void main(String[] args) {
		// TODO Auto-generateTd method stub
		DisplayManager.createDisplay();
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		
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
		
		RawModel model = loader.loadToVAO(vertices, indices);
		
		while(!Display.isCloseRequested()){
			//gameLogic
			renderer.prepare();
			renderer.render(model);
			
			
			//render
			
			DisplayManager.updateDisplay();
		}
		
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}

}
