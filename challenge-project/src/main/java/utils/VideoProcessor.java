package utils;

import java.io.IOException;

public class VideoProcessor {
    private static final String FFMPEG_PATH = "/opt/homebrew/bin/ffmpeg";
    public static void speedUpVideo(String inputFile, String outputFile) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(
                FFMPEG_PATH, "-i", inputFile,
                "-filter:v", "setpts=PTS/1.09",
                "-filter:a", "atempo=1.09",
                "-c:v", "libx264",
                "-c:a", "aac",
                "-b:v", "2000k",
                "-b:a", "128k",
                "-vf", "scale=-2:720",
                outputFile
        );

        pb.inheritIO();
        Process process = pb.start();
        process.waitFor();
    }
}