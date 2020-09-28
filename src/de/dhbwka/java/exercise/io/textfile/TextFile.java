package de.dhbwka.java.exercise.io.textfile;

import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * TextFile
 */
public class TextFile implements Closeable {
    private File file;
    private String[] content;

    public TextFile(File f) {
        file = f;
        read();
    }

    public TextFile(String pathname) {
        this(new File(pathname));
    }

    public void read() {
        try {
            content = java.nio.file.Files.readAllLines(file.toPath()).stream().toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write() throws IOException {
        try (FileWriter fw = new FileWriter(file.getPath())) {
            fw.write(getText());
        }
    }

    private String getText() {
        StringBuilder sb = new StringBuilder();
        for (String s : content)
            sb.append(s + "\r\n");
        return sb.toString();
    }

    public int availableLines() {
        return content.length;
    }

    public String[] getLines() {
        return content;
    }

    public String getLine(int i) throws LineNumberOutOfBoundsException {

        if (i <= availableLines() && i > 0) {
            return content[i - 1];
        } else
            throw new LineNumberOutOfBoundsException();
    }

    public void setLine(int i, String s) throws LineNumberOutOfBoundsException {
        if (i <= availableLines() && i > 0) {
            content[i - 1] = s;
        } else
            throw new LineNumberOutOfBoundsException();
    }

    public void replaceAll(String regexp, String ersatz)
    {
        content = getText().replace(regexp, ersatz).split("\r\n");
    }

    public void close() {
        // hier gibt es nichts zu schließen
    }
}