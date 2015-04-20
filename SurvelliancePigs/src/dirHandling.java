import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import static java.nio.file.StandardCopyOption.*;


public class dirHandling{

	private Path dir;
	private ArrayList<Path> list = new ArrayList<Path>();
	
	/*
	 * p is the directory which the files are in
	 */
	public dirHandling(String p) throws IOException
	{
		dir = Paths.get(p);
		
		Files.walk(Paths.get(dir.toUri())).forEach(filePath -> {
		    if (Files.isRegularFile(filePath)) {
		        list.add(filePath);
		    }
		});
		
	}
	/*
	 * Delete file number index in list
	 */
	public void removeFile(int index)
	{
		try {
		    Files.delete(list.remove(index));
		} catch (NoSuchFileException x) {
		    System.err.format("%s: no such" + " file or directory%n", list.get(index));
		} catch (DirectoryNotEmptyException x) {
		    System.err.format("%s not empty%n", list.get(index));
		} catch (IOException x) {
		    // File permission problems are caught here.
		    System.err.println(x);
		}
	}
	/*
	 Moving file number index to dst.
	 */
	public void moveFile(Path dst, int index) throws IOException
	{
		Files.move(list.get(index), dst, REPLACE_EXISTING);
		updateList();
	}
	/*
	 Copying file number index to dst
	 */
	public void copyFile(Path dst, int index) throws IOException
	{
		Files.copy(list.get(index), dst, REPLACE_EXISTING);
		updateList();
	}
	/*
	 Return iterator of all elements of the directory
	 */
	public Iterator<Path> Iterator()
	{	
		return list.iterator();
		
	}
	/*
	 Return fileName of the object number index in list
	 */
	public Path getFileName(int index) {
		
		return list.get(index).getFileName();
	}
	/*
	 Return name of file with index number from list
	 */
	public Path getNameDir() {
		
		return dir.getFileName();
	}
	
	public int numberOfFiles()
	{
		return list.size();
	}
	
	private void updateList() throws IOException
	{
		Files.walk(Paths.get(dir.toUri())).forEach(filePath -> {
		    if (Files.isRegularFile(filePath)) {
		        list.add(filePath);
		    }
		});
	}
	
}