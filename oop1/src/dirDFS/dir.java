package dirDFS;

import java.io.File;

public class dir {
    public static void main(String[] args) {
        traverseDir("C:/");

    }

    public static void traverseDir(String path) {
        traverseDir(new File(path), new String());
    }

    public static void traverseDir(File dir, String space) {

        if (dir.isDirectory())
        {
            System.out.println(space+ dir.getAbsolutePath());
            String[] child = dir.list();

            for (String s : child) {
                traverseDir(new File(dir,s),space+"    ");
            }
        }
    }
}
