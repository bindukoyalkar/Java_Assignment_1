package PathOfRegexFile;

import java.io.File;
import java.io.FilenameFilter;

public class ListFilesRecursively {
    public static void listFiles(String startDir) {
        File dir = new File(startDir);
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File f, String name) {
                // We want to find only .c files
                return name.endsWith(".java");
            }
        };
        File[] files = dir.listFiles(filter);

        if (files != null && files.length > 0) {
            for (File file : files) {
                // Check if the file is a directory
                if (file.isDirectory()) {
                    // We will not print the directory name, just use it as a new
                    // starting point to list files from
                    listFiles(file.getAbsolutePath());
                } else {
                    // We can use .length() to get the file size
                    System.out.println(file.getName() + " (size in bytes: " + file.length()+")");
                }
            }
        }
    }
    public static void main(String[] args) {
        ListFilesRecursively test = new ListFilesRecursively();
        String startDir = ("/home/binduk/");
        test.listFiles(startDir);
    }
}