package homework.java.forkjoin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class ForkJoinDirSize extends RecursiveTask<Long> {

    private final Path path;

    public ForkJoinDirSize(Path path) {
        this.path = path;
    }


    @Override
    protected Long compute() {
        Long filesize = 0L;

        if (Files.isDirectory(path)) {
            try {
                List<Path> fileList = Files.list(path).collect(Collectors.toList());
                List<ForkJoinDirSize> subTaskList = new ArrayList<>();

                // 하위작업을 생성 후 포크 (백그라운드 실헹)
                for (Path file : fileList) {
                    ForkJoinDirSize subTask = new ForkJoinDirSize(file);
                    subTask.fork();
                    // 작업 목록 관리 (List에 추가)
                    subTaskList.add(subTask);
                }

                Long subSize = 0L;

                // 하위 작업 종료까지 대기
                for (ForkJoinDirSize forkJoinDirSize : subTaskList) {
                    subSize += forkJoinDirSize.join();
                }

                return subSize;

            } catch (IOException e) {
                System.out.println("Error : " + path);
            }
        } else {
            try {
                filesize = Files.size(path);
            } catch (IOException e) {
                System.out.println("Error : " + path);
            }
        }
        return filesize;
    }

    // RecursiveTask 사용
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Path rootPath = Paths.get("/Users/dongyeol/eclipse-workspace/Algorithm");
        ForkJoinPool pool = new ForkJoinPool();

        System.out.printf("병렬 처리 크기 : %s\n", pool.getParallelism());
        System.out.printf("합계 : %s Byte\n", pool.invoke(new ForkJoinDirSize(rootPath)));

        long endTime = System.currentTimeMillis();

        System.out.println("처리시간 : " + (endTime - startTime));
    }
}
