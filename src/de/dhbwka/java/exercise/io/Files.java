package de.dhbwka.java.exercise.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.swing.JFileChooser;

/**
 * Files
 */
public class Files {

    public static void main(String[] args) throws IOException {
        File mainPath = Paths.get(new JFileChooser().getFileSystemView().getDefaultDirectory().toString(), "myDir").toFile();
        mainPath.mkdirs();
        Paths.get(mainPath.getAbsolutePath(), "foo1").toFile().createNewFile();
        Paths.get(mainPath.getAbsolutePath(), "foo2").toFile().createNewFile();
        Paths.get(mainPath.getAbsolutePath(), "foo3").toFile().createNewFile();

        System.out.println(mainPath.getAbsolutePath());
        for(String fileName : mainPath.list())
            System.out.println(mainPath.getAbsolutePath() + '\\' + fileName);
        
        System.out.printf("Das Verzeichnis %s wird nun gelöscht. Mit Enter bestätigen.", mainPath.getAbsolutePath());
        System.console().readLine();
        
        for(String fileName : mainPath.list())
            Paths.get(mainPath.getAbsolutePath(), fileName).toFile().delete();
        mainPath.delete();
    }
}