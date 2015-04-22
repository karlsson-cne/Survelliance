
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
		
		
		
		Thread thread = new Thread(new Runnable() {

		     public void run() {
		    	 Iterator<dirHandling> nuvDir = a.iterator();

					while(nuvDir.hasNext())
					{
						dirHandling temp = nuvDir.next();
						//kollar om filer finns
						if(temp.numberOfFiles() != 0)
						{
							Iterator<Path> p = temp.Iterator();
							int i = 0;
							//gå igenom alla filer i directory
							while(p.hasNext()){ 
									
									//Bildbehandling
									String s = p.next().toString();
									s = s.replace("\\", "/");
									//imageAlgo image = new imageAlgo(Imgcodecs.imread(s));
									//image.findRedCluster();
									
									//Kopiering av fil
									String t = temp.getNameDir().toString();
									String dst = "C:/Users/Julia/GoogleDrive/Examensarbete2/Webbsida/K1/k_1.jpg";
									dst = dst.replace("K1", t);
									StringBuilder sb = new StringBuilder();
									sb.append("k_");
									sb.append(i+1);
									sb.append(".jpg");
									dst = dst.replace("k_1.jpg", sb.toString());
									try {
										temp.copyFile(Paths.get(dst), i);
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									i++;
								}
							//Ta bort filer här
							
							
							for(int j = 0; j < temp.numberOfFiles(); j++)
							{
								String dstOld = "C:/Users/Julia/GoogleDrive/Examensarbete2/Webbsida/K_Old/K1/k_1.jpg";
								String t = temp.getNameDir().toString();
								t = temp.getNameDir().toString();
								dstOld = dstOld.replace("K1", t);
								StringBuilder sb = new StringBuilder();
								sb.append("k_");
								sb.append(j+1);
								sb.append(".jpg");
								dstOld = dstOld.replace("k_1.jpg", sb.toString());
								try {
									temp.moveFile(Paths.get(dstOld), j);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						
							
						}
						
					nuvDir = a.iterator();
					
					try {
					    Thread.sleep(7200000);                 //2 * 60 * 60 *1000 sov i 2 timmar.
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
					
		     }

		});
		thread.start();
		
			}
			
		}
		
	
	

