package de.dhbwka.java.exam.soedermemory;

import java.util.Collections;
import java.util.List;

import de.dhbwka.java.exam.soedermemory.MemoryImages.MemoryImage;
/**
 * MemoryGame
 */
public class MemoryGame {
	private int rows;
    private int cols;
    private List<Player> players;
    private List<MemoryImage> images;
    private int curPlayerIndex = -1;

    public MemoryGame(List<Player> players, List<MemoryImage> images, int rows, int cols) throws MemoryException {
        if(players.size() < 2)
            throw new MemoryException("At least two players required");
        
        if((int)((rows * cols)/2) > images.size())
            throw new MemoryException("Too few images available");
        else
        {
            Collections.shuffle(images);
            setImages(images);
        }
        setPlayers(players);
        setRows(rows);
        setCols(cols);
	}

    public int getRows() {
        return this.rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return this.cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<MemoryImage> getImages() {
        return this.images;
    }

    public List<MemoryImage> getFullShuffledImages() {
        List<MemoryImage> fullShuffledImages = getImages().subList(0, (int)((getRows() * getCols())/2) );

        fullShuffledImages.addAll(getImages().subList(0, (int)((getRows() * getCols())/2)));
        if(isBlankRequired())
            fullShuffledImages.add(new MemoryImage("blank", MemoryImages.getBlank()));

        Collections.shuffle(fullShuffledImages);
        return fullShuffledImages;
    }

    public void setImages(List<MemoryImage> images) {
        this.images = images;
    }

    public int getCurPlayerIndex() {
        return this.curPlayerIndex;
    }

    public void setCurPlayerIndex(int curPlayer) {
        this.curPlayerIndex = curPlayer % getPlayers().size();
    }

    public Player getCurrentPlayer(){
        return getPlayers().get(getCurPlayerIndex());
    }

    public Boolean isBlankRequired(){
        return (rows * cols) % 2 == 1;
    }

    public void nextPlayer(){
        if(getCurPlayerIndex() >= 0)
            getPlayers().get(getCurPlayerIndex()).setStatus(PlayerStatus.WAITING);
            
        setCurPlayerIndex(getCurPlayerIndex() + 1);
        getPlayers().get(getCurPlayerIndex()).setStatus(PlayerStatus.ACTIVE);
    }
}