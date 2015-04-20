
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.imgcodecs.Imgcodecs;



public class main {

	public static void main(String[] args) throws IOException {
		//must do this to get library to work
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		
		
		dirHandling p1 = new dirHandling("C:/Users/Julia/GoogleDrive/Examensarbete2/Webbsida/K_Org/K1");
		dirHandling p2 = new dirHandling("C:/Users/Julia/GoogleDrive/Examensarbete2/Webbsida/K_Org/K2");
		dirHandling p3 = new dirHandling("C:/Users/Julia/GoogleDrive/Examensarbete2/Webbsida/K_Org/K3");
		dirHandling p4 = new dirHandling("C:/Users/Julia/GoogleDrive/Examensarbete2/Webbsida/K_Org/K4");
		
		ArrayList<dirHandling> a = new ArrayList<dirHandling>();
		a.add(p1);
		a.add(p2);
		a.add(p3);
		a.add(p4);
		
		Iterator<dirHandling> nuvDir = a.iterator();
		
		//while(true)
		//{
			
			while(nuvDir.hasNext())
			{
				dirHandling temp = nuvDir.next();
				//kollar om filer finns
				if(temp.numberOfFiles() != 0)
				{
					Iterator<Path> p = temp.Iterator();
					//gå igenom alla filer i directory
					while(p.hasNext()){
						String s = p.next().toString();
						s = s.replace("\\", "/");
						if(s.endsWith("jpg"))
						{
							imageAlgo image = new imageAlgo(Imgcodecs.imread(s));
							image.findRedCluster();
							//göra resten av koden. 
							
						}
					}
				}
				
				
			}
			//nuvDir = a.iterator();
		//}
		
	}
	
	

}
