package de.dhbwka.java.exercise.ui;

import java.awt.GridLayout;
import java.awt.TextArea;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileFilter;
import java.util.List;

/**
 * TextfileViewer
 */
public class TextfileViewer {

    public static void main(String[] args) throws IOException {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt");
            }

            @Override
            public String getDescription() {
                return "Text Files";
            }
        });
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            System.out.println(fc.getSelectedFile().getAbsolutePath());

            List<String> fileLines = java.nio.file.Files
                    .readAllLines(Paths.get(fc.getSelectedFile().getAbsolutePath()));

            JFrame frame1 = new JFrame("Frame1");
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame1.setLayout(new GridLayout(10, 1));
            frame1.setSize(300, 200);

            JFrame frame2 = new JFrame("Frame2");
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame2.setSize(300, 200);
            TextArea ta = new TextArea("", 5, 1);
            frame2.add(ta);

            for (int i = 0; i < fileLines.size(); i++) {
                if (i < 10)
                    frame1.add(new JLabel(fileLines.get(i)));

                ta.setText(ta.getText() + fileLines.get(i) + "\r\n");

            }

            frame1.setVisible(true);
            frame2.setVisible(true);

        } else{
            System.out.println("Noselection");
        }
    }
}