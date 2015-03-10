import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;


public class main {

	public static void main(String[] args) {
		//must do this to get library to work
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		Mat m = Imgcodecs.imread("C:/Users/Julia/Downloads/KameraBilder/Red.jpg");
		Imgproc.cvtColor(m, m, Imgproc.COLOR_BGR2HSV);
		
		//Kod för att få hue, sat och val i tre olika matriser. För att sedan använda treshold
		//BEhöver ändra double till mat. Använda mat(int row, int col, int type)
		// ta reda på vilken type det skall vara för 3 channel färgbild
		// använd sedan put() för att lägga till.
		double [] d = new double [3];
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
		
		
		
		System.out.println("At pos 0: Hue = "+ hue[0][0] + " Sat = "+ sat[0][0] + " Val = "+ val[0][0]);
		
		//System.out.println("Mat: "+ m.col(100).dump());
		
		
	}

}
