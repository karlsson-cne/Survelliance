import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;


public class main {

	public static void main(String[] args) {
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		Mat m = Imgcodecs.imread("C:/Users/Julia/Downloads/KameraBilder/GirlRect.jpg");
		
		System.out.println("");
		
	}

}
