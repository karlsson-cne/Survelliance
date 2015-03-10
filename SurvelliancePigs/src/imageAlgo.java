import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;


import org.opencv.core.Mat;

import org.opencv.imgproc.Imgproc;



public class imageAlgo {
	
	private Mat image;
	private Mat Hue;
	private Mat Saturation;
	private Mat Value;
	
	public imageAlgo(Mat path)
	{
		 image = path;
		 Imgproc.cvtColor(image, image, Imgproc.COLOR_BGR2HSV);
		 //Split "image" up in Hue(color), Saturation(Colorfulness) and Value(Brightness)
		 
	}
	//check all values of red with all sat and val.
	public void findRedCluster()
	{
		
		
		 
		
	}
	
	public void detectDeadPig()
	{
		
	}
	
	public void measureFoodSupply()
	{
		
	}
	
	//Convert mat to icon
	public BufferedImage createAwtImage() {

	    int type = 0;
	    Imgproc.cvtColor(image, image, Imgproc.COLOR_HSV2BGR);
	    if (image.channels() == 1) {
	        type = BufferedImage.TYPE_BYTE_GRAY;
	    } else if (image.channels() == 3) {
	        type = BufferedImage.TYPE_3BYTE_BGR;
	    }
	       
	    

	    BufferedImage imageC = new BufferedImage(image.width(), image.height(), type);
	    WritableRaster raster = imageC.getRaster();
	    DataBufferByte dataBuffer = (DataBufferByte) raster.getDataBuffer();
	    byte[] data = dataBuffer.getData();
	    image.get(0, 0, data);

	    return imageC;

		}

}
