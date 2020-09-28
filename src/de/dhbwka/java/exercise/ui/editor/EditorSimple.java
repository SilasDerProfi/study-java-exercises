package de.dhbwka.java.exercise.ui.editor;

import java.awt.BorderLayout;

import javax.swing.*;

/**
 * EditorSimple
 */
public class EditorSimple extends JFrame{

    private static final long serialVersionUID = 1L;

    EditorSimple() {
        initializeComponent();
    }

    private void initializeComponent() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar b = new JMenuBar();
        setLayout(new BorderLayout());
        setJMenuBar(b);

        JMenu file = new JMenu("Datei");
        JMenu edit  =new JMenu("Bearbeiten");
        JMenu sendTo = new JMenu("Senden an");

        sendTo.add(new JMenuItem("E-Mail-Empfänger"));
        sendTo.add(new JMenuItem("E-Mail-Empfänger (zur Überarbeitung)"));
        sendTo.add(new JMenuItem("E-Mail-Empfänger (als Anlage)"));
        sendTo.addSeparator();
        sendTo.add(new JMenuItem("Verteilerempfänger"));
        sendTo.add(new JMenuItem("Onlinebesprechungsteilnehmer"));
        sendTo.add(new JMenuItem("Exchange-Ordner..."));
        sendTo.add(new JMenuItem("Fax-Empfänger"));
        sendTo.addSeparator();
        sendTo.add(new JMenuItem("Microsoft PowerPoint"));

        file.add(new JMenuItem("Neu"));
        file.add(new JMenuItem("Öffnen"));
        file.addSeparator();
        file.add(new JMenuItem("Schließen"));
        file.addSeparator();
        file.add(new JMenuItem("Speichern"));
        file.add(new JMenuItem("Speichern unter..."));
        file.add(new JMenuItem("Als Webseite speichern"));
        file.add(new JMenuItem("Suchen"));
        file.addSeparator();
        file.add(new JMenuItem("Versionen"));
        file.addSeparator();
        file.add(new JMenuItem("Webseitenvorschau"));
        file.addSeparator();
        file.add(new JMenuItem("Seite einrichten"));
        file.add(new JMenuItem("Seitenansicht"));
        file.add(new JMenuItem("Drucken"));
        file.add(sendTo);
        file.add(new JMenuItem("Eigenschaften"));
        file.addSeparator();
        file.add(new JMenuItem("bilanz_2017.doc"));
        file.add(new JMenuItem("bericht_2018_01.doc"));
        file.add(new JMenuItem("Ziele.doc"));
        file.addSeparator();
        file.add(new JMenuItem("Beenden"));

        edit.add(new JMenuItem("Rückgängig"));
        edit.add(new JMenuItem("Wiederholen"));
        edit.addSeparator();
        edit.add(new JMenuItem("Ausschneiden"));
        edit.add(new JMenuItem("Kopieren"));
        edit.add(new JMenuItem("Office-Zwischenablage"));
        edit.add(new JMenuItem("Einfügen"));
        edit.add(new JMenuItem("Inhalte einfügen"));
        edit.add(new JMenuItem("Als Hyperlink einfügen"));
        edit.addSeparator();
        edit.add(new JMenuItem("Löschen"));
        edit.add(new JMenuItem("Alles markieren"));
        edit.addSeparator();
        edit.add(new JMenuItem("Suchen..."));
        edit.add(new JMenuItem("Ersetzen..."));
        edit.add(new JMenuItem("Gehe zu..."));
        edit.addSeparator();
        edit.add(new JMenuItem("Verknüpfungen..."));
        edit.add(new JMenuItem("Objekt"));

        b.add(file);
        b.add(edit);
        add(new JScrollPane(new JTextArea()));
        setSize(500, 400);
        setMinimumSize(getSize());
    }
}