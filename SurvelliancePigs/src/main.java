
import java.io.IOException;

import org.opencv.core.Core;



public class main {

	public static void main(String[] args) throws IOException {
		//must do this to get library to work
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		
		
		
		dirHandling p1 = new dirHandling("C:/Users/Julia/Google Drive/Examensarbete2/Webbsida/K_Org/K1/");
		dirHandling p2 = new dirHandling("C:/Users/Julia/Google Drive/Examensarbete2/Webbsida/K_Org/K2");
		dirHandling p3 = new dirHandling("C:/Users/Julia/Google Drive/Examensarbete2/Webbsida/K_Org/K3");
		dirHandling p4 = new dirHandling("C:/Users/Julia/Google Drive/Examensarbete2/Webbsida/K_Org/K4");
		
		
	}
	
	

}
