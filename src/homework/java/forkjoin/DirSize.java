package homework.java.forkjoin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DirSize {

    static long size = 0;

    protected Long compute(Path path) {
        long fileSize = 0;

        try {
            List<Path> fileList = Files.list(path).collect(Collectors.toList());
            for (Path file : fileList) {
                if (Files.isDirectory(file)) {
                    fileSize += compute(file);
                } else {
                    fileSize += Files.size(file);
                    size += fileSize;
                }
            }
        } catch (IOException e) {
            System.out.printf("Error : " + path);
        }
        return fileSize;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Path rootPath = Paths.get("/Users/dongyeol/eclipse-workspace/Algorithm");
        DirSize dirSize = new DirSize();
        System.out.printf("합계 : %s Byte\n", dirSize.compute(rootPath));

        long endTime = System.currentTimeMillis();

        System.out.println("처리시간 : " + (endTime - startTime));


    }
}
