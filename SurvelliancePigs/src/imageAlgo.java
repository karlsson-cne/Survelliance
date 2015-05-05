


import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;



public class imageAlgo {
	
	private Mat imgOriginal;
	private Mat imgHSV;
	private Mat imgThresholded;
	
	
	 private int iLowH = 117;
	 private int iHighH = 150;
	 
	 private int iLowS = 0; 
	 private int iHighS = 255;

	 private int iLowV = 0;
	 private int iHighV = 255;
	 private Size s = new Size(5,5);
	
	public imageAlgo(Mat path)
	{
		 imgOriginal = path;
		 imgHSV = imgOriginal.clone();
		 imgThresholded = imgOriginal.clone();
		 
	}
	//check all values of red with all sat and val.
	public Mat findRedCluster()
	{
		 Imgproc.cvtColor(imgOriginal, imgHSV, Imgproc.COLOR_BGR2HSV); //Convert the captured frame from BGR to HSV	 
		 
		 Core.inRange(imgHSV, new Scalar(iLowH, iLowS, iLowV), new Scalar(iHighH, iHighS, iHighV), imgThresholded); //Threshold the image
		      
		 
		 
		 // Strukturelementet bestäms av datainsamling.
		 //morphological closing (fill small holes in the foreground)
		 Imgproc.morphologyEx(imgThresholded, imgThresholded, Imgproc.MORPH_CLOSE, Imgproc.getStructuringElement(Imgproc.MORPH_RECT,s));
		
		 //morphological opening (remove small objects from the foreground)
		 Imgproc.morphologyEx(imgThresholded, imgThresholded, Imgproc.MORPH_OPEN, Imgproc.getStructuringElement(Imgproc.MORPH_RECT,s));
		
		 
		 List<MatOfPoint> contours = new ArrayList<MatOfPoint>(); 
		 Mat imgTemp = new Mat(imgThresholded,new Rect(664,58,386,268));
		 Imgproc.findContours(imgTemp, contours, new Mat(), Imgproc.RETR_LIST,Imgproc.CHAIN_APPROX_SIMPLE);
		 if(!contours.isEmpty())
		 {
			Imgproc.drawContours(imgOriginal, contours, -1, new Scalar(255,0,0),2, 0, new Mat(), 0, new Point(664,58)); 
		 	return imgOriginal;
		 }
		 else
		 {
			 return null;
		 }
	}
	


}
