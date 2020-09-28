package de.dhbwka.java.exercise.ui;

import java.awt.TextArea;
import java.io.IOException;
import java.nio.file.Paths;

import javax.swing.*;

/**
 * TextFrame
 */
public class TextFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    public TextFrame(String path, int width, int height) {
        setTitle(path);
        setSize(width, height);
        TextArea ta = new TextArea();

        String content = "";
        try {
            content = new String(java.nio.file.Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ta.append(content);

        add(ta);
    }
}