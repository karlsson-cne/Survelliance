import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;


public class main {

	public static void main(String[] args) {
		//must do this to get library to work
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		Mat m = Imgcodecs.imread("C:/Users/Julia/Downloads/KameraBilder/Red.jpg");
		Imgproc.cvtColor(m, m, Imgproc.COLOR_BGR2HSV);
		
		//Kod f�r att f� hue, sat och val i tre olika matriser. F�r att sedan anv�nda treshold
		//BEh�ver �ndra double till mat. Anv�nda mat(int row, int col, int type)
		// ta reda p� vilken type det skall vara f�r 3 channel f�rgbild
		// anv�nd sedan put() f�r att l�gga till.
		/*double [] d = new double [3];
		double [][] hue = new double [m.cols()][m.rows()];
		double [][] sat = new double [m.cols()][m.rows()];
		double [][] val = new double [m.cols()][m.rows()];
		
		for(int i = 0; i<m.cols(); i++)
		{
			for(int j = 0; j<m.rows(); j++)
			{
				d = m.get(j,i);
				hue[i][j]= d[0];
				sat[i][j]= d[1];
				val[i][j]= d[2];
			}
			
			
		}
		*/
		// G�r om till Mat ist f�r double
		Mat hue = new Mat(m.rows(),m.cols(),CvType.CV_8UC1);
		Mat sat = new Mat(m.rows(),m.cols(),CvType.CV_8UC1);
		Mat val = new Mat(m.rows(),m.cols(),CvType.CV_8UC1);
		
		for(int i = 0; i<m.cols(); i++)
		{
			for(int j = 0; j<m.rows(); j++)
			{
				hue.put(j, i, m.get(j, i));
				sat.put(j, i, m.get(j, i));
				val.put(j, i, m.get(j, i));
			}
		}
		
		
		
		//System.out.println("At pos 0: Hue = "+ hue[0][0] + " Sat = "+ sat[0][0] + " Val = "+ val[0][0]);
		
		System.out.println("Hue: "+ hue.dump());
		System.out.println("Sat: "+ sat.dump());
		System.out.println("Val: "+ val.dump());
		
		
	}

}
