package de.dhbwka.evolution.magicsquare;

public final class MagicSquareSolver {
    
    private MagicSquareSolver(){
        // Private constructor to avoid creating an instance of this "static" class
    }

    public static void SolveStupidSwap(MagicSquare unsolvedSquare, int maxChildCount){
       // Swap cells with small value difference

       // continue with the best child

       // clear output

       // print generation

       // print best child

    }

    public static void SolveIntelligentSwap(MagicSquare unsolvedSquare, int maxChildCount){
        // Calculate for all Cells the combined fitness (row + col fitness)
        
        // Swap cells where 
        // | combinedFitness(a) − combinedFitness(b) | + (a.value − b.value)^2
        // is low
        
    }
}
