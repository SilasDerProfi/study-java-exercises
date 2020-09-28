package de.jdsr.java.exercise.maidenhead;

public class Geo2 {

	//Gr�sstfeldberechnung
    public void locatorGGF(double l, double b) {
	int i_laenge, i_breite;
	i_laenge = (int) l; //-8 
	i_breite = (int) b; //49
	
	//Zahlenwerte noch korrigieren!
	if ((i_laenge <= 20)   & (i_laenge > 0))   {System.out.print("A");}
	if ((i_laenge <= 0)    & (i_laenge > 20))  {System.out.print("B");}
	if ((i_laenge <= 20)   & (i_laenge > 40))  {System.out.print("C");}
	if ((i_laenge <= 40)   & (i_laenge > 60))  {System.out.print("D");}
	if ((i_laenge <= 60)   & (i_laenge > 80))  {System.out.print("E");}
	if ((i_laenge <= 80)   & (i_laenge > 100)) {System.out.print("F");}
	if ((i_laenge <= 100)  & (i_laenge > 120)) {System.out.print("G");}
	if ((i_laenge <= 120)  & (i_laenge > 140)) {System.out.print("H");}
	if ((i_laenge <= 20)   & (i_laenge > 0))   {System.out.print("I");}
	if ((i_laenge <= 0)    & (i_laenge > -20)) {System.out.print("J");}
	if ((i_laenge <= -20)  & (i_laenge > -40)) {System.out.print("K");}
	if ((i_laenge <= -40)  & (i_laenge > -60)) {System.out.print("L");}
	if ((i_laenge <= -60)  & (i_laenge > -80)) {System.out.print("M");}
	if ((i_laenge <= -80)  & (i_laenge > -100)){System.out.print("N");}
	if ((i_laenge <= -100) & (i_laenge > -120)){System.out.print("O");}
	if ((i_laenge <= -120) & (i_laenge > -140)){System.out.print("P");}
	if ((i_laenge <= -140) & (i_laenge > -160)){System.out.print("Q");}
	if ((i_laenge <= -160) & (i_laenge > -180)){System.out.print("R");}
	//noch erg�nzen auf weltweit
	if ((i_breite >= 36)  & (i_breite < 47)) {System.out.print("M");}
	if ((i_breite >= 45)  & (i_breite < 54)) {System.out.print("N");}
	if ((i_breite >= 54)  & (i_breite > 63)) {System.out.print("O");}
    
    }
    
  //Grossfeldberechnung
    public void locatorGF(double l, double b) {
	int i_laenge, i_breite;
	i_laenge = (int) l;   if (l < 0) i_laenge = (-1)*i_laenge;
	i_breite = (int) b;   if (b < 0) i_breite = (-1)*i_breite;
	
	if (((i_laenge % 20) == 0) | ((i_laenge % 20) == 1)){System.out.print("0");}
	if (((i_laenge % 20) == 2) | ((i_laenge % 20) == 3)) {System.out.print("1");}
	if (((i_laenge % 20) == 4) | ((i_laenge % 20) == 5)) {System.out.print("2");}
	if (((i_laenge % 20) == 6) | ((i_laenge % 20) == 7)) {System.out.print("3");}
	if (((i_laenge % 20) == 8) | ((i_laenge % 20) == 9)) {System.out.print("4");}
	if (((i_laenge % 20) == 10) | ((i_laenge % 20) == 11)) {System.out.print("5");}
	if (((i_laenge % 20) == 12) | ((i_laenge % 20) == 13)) {System.out.print("6");}
	if (((i_laenge % 20) == 14) | ((i_laenge % 20) == 15)) {System.out.print("7");}
	if (((i_laenge % 20) == 16) | ((i_laenge % 20) == 17)) {System.out.print("8");}
	if (((i_laenge % 20) == 18) | ((i_laenge % 20) == 19)) {System.out.print("9");}
	
	if ((i_breite % 10) == 0) {System.out.print("0");}
	if ((i_breite % 10) == 1) {System.out.print("1");}
	if ((i_breite % 10) == 2) {System.out.print("2");}
	if ((i_breite % 10) == 3) {System.out.print("3");}
	if ((i_breite % 10) == 4) {System.out.print("4");}
	if ((i_breite % 10) == 5) {System.out.print("5");}
	if ((i_breite % 10) == 6) {System.out.print("6");}
	if ((i_breite % 10) == 7) {System.out.print("7");}
	if ((i_breite % 10) == 8) {System.out.print("8");}
	if ((i_breite % 10) == 9) {System.out.print("9");}
    }
}
