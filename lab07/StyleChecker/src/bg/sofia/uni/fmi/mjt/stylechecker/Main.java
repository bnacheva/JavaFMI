package bg.sofia.uni.fmi.mjt.stylechecker;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        String fileToRead = "src\\bg\\sofia\\uni\\fmi\\mjt\\stylechecker\\files\\source_java_file.txt";
        String fileToWrite = "src\\bg\\sofia\\uni\\fmi\\mjt\\stylechecker\\files\\output_java_file.txt";
        Path pathToReadFile = Paths.get(fileToRead);
        Path pathToWriteFile = Paths.get(fileToWrite);
        StyleChecker newStyleChecker = new StyleChecker();
        newStyleChecker.checkStyle(pathToReadFile, pathToWriteFile);
    }
}
