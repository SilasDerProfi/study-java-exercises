package de.dhbwka.java.exercise.classes.swapgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Zeitnahme
 */
public class Zeitnahme implements java.io.Closeable {
    //#region private members
    private Spielfeld match;
    private PropertyChangeListener pointListener;
    private int countdown = 121;
    private int turn = 1;
    private Timer timer = new Timer();
    private boolean isPause;
    //#endregion private members

    //#region public members
    public Boolean isRunning;
    public ActionListener timeChange;
    public ActionListener pointChange;
    //#endregion public members

    //#region public methods
    
    public void startGame() {
        match = new Spielfeld();
        System.out.println(getMatch());

        pointListener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (++turn % 10 == 1) {
                    countdown += 45;
                }
                if(pointChange != null)
                    pointChange.actionPerformed(new ActionEvent(getMatch(), getMatch().hashCode(), null));
            }
        };
        match.addPointsChangeListener(pointListener);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (--countdown <= 0)
                    close();

                if(!isPause && timeChange != null)
                    timeChange.actionPerformed(new ActionEvent(getCountdown(), timer.hashCode(), null));
            }
        }, 0, 1000);
        isRunning = true;
    }

    public void pauseTimerOutput()
    {
        isPause = true;
    }

    public void resumeTimerOutput()
    {
        isPause = false;
    }

    public void finalize() {
        isRunning = false;
        if (match != null)
            match.removePointsChangeListener(pointListener);
        if (timer != null)
            timer.cancel();
    }

    @Override
    public void close() {
        finalize();
    }
    //#endregion public methods

    //#region GetSet
    public Spielfeld getMatch() {
        return match;
    }

    public int getCountdown(){
        return countdown;
    }

    public int getTurn(){
        return  (turn-1) / 10 + 1;
    }

    public int getLevel(){
        return (turn-1) % 10 + 1;
    }
    //#endregion GetSet
}