package de.dhbwka.java.exercise.collections;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;

import javax.swing.*;
/**
 * Library
 */
public class Library {
    private final String PATH = "io/Library.csv";
    private ArrayList<Book> books = new ArrayList<Book>();
    public Library() {
        initializeComponent();
        
        try {
            for (String s : java.nio.file.Files.readAllLines(Paths.get(PATH))) {
                    books.add(new Book(s.split(";")));
                    System.out.println(books.size());
            }
        } catch (IOException e) {e.printStackTrace();}
    }

    private void initializeComponent() {
        JFrame jf= new JFrame("Book Management");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout(5, 5));
        JPanel top= new JPanel();
        top.setLayout(new GridLayout(4, 2, 2, 2));

        top.add(new JLabel("Title"));
        JTextField titleTextField = new JTextField("");
        top.add(titleTextField);

        top.add(new JLabel("Author"));
        JTextField authorTextField = new JTextField("");
        top.add(authorTextField);

        top.add(new JLabel("Year"));
        JTextField yearTextField = new JTextField("");
        top.add(yearTextField);

        top.add(new JLabel("Publisher"));
        JTextField publisherTextField = new JTextField("");
        top.add(publisherTextField);

        jf.add(top, BorderLayout.NORTH);
        JPanel mid= new JPanel();
        JButton save = new JButton("Save Entry");

        save.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Book newBook = new Book(titleTextField.getText(), authorTextField.getText(), yearTextField.getText(), publisherTextField.getText());

                if(!books.stream().anyMatch(b -> b.compare(b, newBook) == 0))
                {
                    try (FileWriter fw = new FileWriter(PATH, true)) {
                        fw.append(String.format("\r\n%s", newBook.toString()));
                    }catch(IOException ex){ex.printStackTrace();}
                    books.add(newBook);
                    titleTextField.setText("");
                    authorTextField.setText("");
                    yearTextField.setText("");
                    publisherTextField.setText("");
                }
            }
        });

        mid.add(save);
        jf.add(mid, BorderLayout.CENTER);
        JPanel bot= new JPanel();
        bot.setLayout(new FlowLayout());
        bot.add(new JLabel("Ordered output:"));

        JButton orderTitle = new JButton("Title");
        bot.add(orderTitle);
        orderTitle.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Collections.sort(books, (o1,o2) -> o1.getTitle().compareTo(o2.getTitle()));
                showDialog("Books ordered by Title");
            }
        });

        JButton orderAuthor = new JButton("Author");
        bot.add(orderAuthor);
        orderAuthor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Collections.sort(books, (o1,o2) -> o1.getAuthor().compareTo(o2.getAuthor()));
                showDialog("Books ordered by Author");
            }
        });

        JButton orderYear = new JButton("Year");
        bot.add(orderYear);
        orderYear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Collections.sort(books, (o1,o2) -> o1.getYear() -o2.getYear());
                showDialog("Books ordered by Year");
            }
        });

        JButton orderPublisher = new JButton("Publisher");
        bot.add(orderPublisher);
        orderPublisher.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Collections.sort(books, (o1,o2) -> o1.getPublisher().compareTo(o2.getPublisher()));
                showDialog("Books ordered by Publisher");
            }
        });
        
        jf.add(bot, BorderLayout.SOUTH);
        jf.pack();jf.setVisible(true);
    }
    
    private void showDialog(String title) {

        StringBuilder sb = new StringBuilder();
        for(Book b : books)
            sb.append(b.toString() + "\r\n");
            
        JOptionPane.showMessageDialog(null, sb, title, JOptionPane.INFORMATION_MESSAGE);
    }


    private class Book /* implements Comparator*/{
        private String title;
        private String author;
        private int year;
        private String publisher;

        private Book(String... input) {
            if(input.length != 4)
                return;

                title = input[0];
                author = input[1];
                try{ year = Integer.parseInt(input[2]);} catch(NumberFormatException ex){}
                publisher = input[3];
        }

        public String getTitle() { return title;}
        //public void setTitle(String t){title = t;}

        public String getAuthor(){return author;}
        //public void setAuthor(String a){author = a;}

        public int getYear(){return year;}
        //public void setYear(int y){year = y;}

        public String getPublisher(){return publisher;}
        //public void setPublisher(String p){publisher = p;}

        public String toString(){
            return String.format("%s;%s;%d;%s", title, author, year, publisher);
        }


        public int compare(Object o1, Object o2) {

            int res = ((Book)o1).getTitle().compareTo(((Book)o2).getTitle());
            if( res == 0)
                res = ((Book)o1).getAuthor().compareTo(((Book)o2).getAuthor());
            if( res == 0)
                res = ((Book)o1).getYear() - ((Book)o2).getYear();
            if( res == 0)
                res = ((Book)o1).getPublisher().compareTo(((Book)o2).getPublisher());

            return res;
        }
    }
}