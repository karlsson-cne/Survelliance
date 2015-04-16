import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;


import org.opencv.core.Mat;

import org.opencv.imgproc.Imgproc;



public class imageAlgo {
	
	private Mat imageOrg;
	private Mat imagePro;
	private Mat imageDebug;
	
	public imageAlgo(Mat path)
	{
		 imageOrg = path;
		 Imgproc.cvtColor(imageOrg, imagePro, Imgproc.COLOR_BGR2HSV);
		 
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
	    Imgproc.cvtColor(imagePro, imageDebug, Imgproc.COLOR_HSV2BGR);
	    if (imageDebug.channels() == 1) {
	        type = BufferedImage.TYPE_BYTE_GRAY;
	    } else if (imageDebug.channels() == 3) {
	        type = BufferedImage.TYPE_3BYTE_BGR;
	    }
	       
	    

	    BufferedImage imageC = new BufferedImage(imageDebug.width(), imageDebug.height(), type);
	    WritableRaster raster = imageC.getRaster();
	    DataBufferByte dataBuffer = (DataBufferByte) raster.getDataBuffer();
	    byte[] data = dataBuffer.getData();
	    imageDebug.get(0, 0, data);

	    return imageC;

		}

}
