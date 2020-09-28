package de.dhbwka.java.exercise.classes;
/**
 * LottoTest
 */
public class LottoTest {

    public static void main(String[] args) {
        Lotto lotto = new Lotto(6, 49);
        //lotto.tippen();
        lotto.tippen(1,2,3,4,5,6);

        System.out.println(lotto);
        lotto.ziehen();
        System.out.println(lotto);
        System.out.println("Richtige:" + lotto.richtige());
    }
}