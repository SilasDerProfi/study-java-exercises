package de.dhbwka.java.exam.snatchat;

public class Message {
    private String text;
    private Account sender;

    public Message(String text, Account sender){
     this.text = text;
     this.sender = sender;   
    }

    public Message(String text){
        this.text = text;
    }

    public Message(Account sender){
        this.sender = sender;  
    }

    public Message(){
        
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Account getSender() {
        return this.sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public static String rot13(String message){
        String retVal = "";
    
        for(char c : message.toCharArray()){
            if((c >= 'a' &&  c <= 'm') || (c >= 'A' && c <= 'M'))
                retVal += (char)(c + 13);
            else if((c >= 'n' &&  c <= 'z') || (c >= 'N' && c <= 'Z'))
                retVal += (char)(c - 13);
            else
                retVal += c;
       }

       return retVal;
    }
}
