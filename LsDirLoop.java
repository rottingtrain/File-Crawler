import java.nio.file.*;
import java.io.*;
import java.util.*;

class LsDirLoop {
    public static void printDirectory(String directory){
        Path p = Paths.get(directory);
        if (Files.isDirectory(p)) {
            try {
                DirectoryStream<Path> ds = Files.newDirectoryStream(p);
                Iterator<Path> pIter = ds.iterator();
                while (pIter.hasNext()) {
                    Path subP = pIter.next();
                    System.out.println(subP);
                    printDirectory(subP.toString());
                }
            }
            catch (IOException e) {
                System.out.println("There was something wrong with " + p);
            }
        }
        else {
            // Must be a normal file: print it out
            System.out.println(p);
        }
    }
    public static void main(String[] args) {
        printDirectory("/Users/csstudent");
    }
}