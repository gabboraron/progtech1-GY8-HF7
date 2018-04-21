package tilitoli;

import java.util.Random;
import java.util.Vector;

/**
 * This describes the game db
 * @author Burian Sándor
 */
public class Game {
    private Vector game;
    private int blankIndex = 8;
    
    /**
     * Initialize the vector, and fill it with random numbers.
     */
    public Game() {
        this.game = new Vector();
        generateNewGame();
    }
    
    /**
     * Fill the game vector with random values.
     */
    private void generateNewGame() {
        /*int idx=0;
        int idx2=0;
        while(idx < 3){                                //game matrix rows
            int tmp1 =0;
            int tmp2 =0;
            int tmp3 =0;
            
            tmp1 = randomGenerator(1,9);
            while ((tmp2 == 0) || (tmp2 == tmp1)) {   //generate while the generated is not different from old one.
                tmp2 = randomGenerator(1, 9);
            }
            while ((tmp3 == 0) || (tmp3 == tmp1) || (tmp3 == tmp2)) {   //generate while the generated is not different from old ones.
                tmp3 = randomGenerator(1, 9);
            }
        }*/
        
         /*
        int idx=0;
        int tmp;
        boolean alreadyIsThere;
        int tmpidx;
        while (idx<8){
            
            System.out.println("LOG\t game while");
            
            tmp = randomGenerator(1,9);
            if(game.isEmpty()){
                game.add(tmp);
            } else {
                alreadyIsThere = false;
                tmpidx = 0;
                while ((!alreadyIsThere) && (tmpidx<game.size())){
                    
                    System.out.println("LOG\t elem control while");
                    
                    if(game.get(tmpidx).equals(tmp)){
                        alreadyIsThere = true;
                        System.out.println("LOG\t elem control same found");
                    }
                    ++tmpidx;
                }
                if(!alreadyIsThere){
                    game.add(tmp);
                    ++idx;
                    System.out.println("LOG\t current elem numbers: " + idx);
                }
            }
        }
        */
         
        Vector possibleValues;
        possibleValues = new Vector();
        possibleValues.add(1);
        possibleValues.add(2);
        possibleValues.add(3);
        possibleValues.add(4);
        possibleValues.add(5);
        possibleValues.add(6);
        possibleValues.add(7);
        possibleValues.add(8);
        //possibleValues.add(9);
        
        int idx=0;
        int tmp;
        int tmpidx;
        while (idx<8){
            tmp = randomGenerator(0,possibleValues.size());
            game.add(possibleValues.get(tmp));
            possibleValues.remove(tmp);
            ++idx;
        }
        game.add(9);
    }
    
    /**
     * Random number generator with parameters
     * @param Low int the lowest inclusive value of generated number
     * @param High int the highest exclusive value of generated number
     * @return an int, the gereated random number
     */
    private int randomGenerator(int Low, int High){
        Random r = new Random();
        return r.nextInt(High-Low) + Low;
    }
    
    /**
     * 
     * @return the game vector
     */
    public Vector getGame() {
        return game;
    }
    
    /**
     * Test if The game is completed.
     * The game is completed when every value is in growing order.
     * @return a boolean value true if completed false if isn't
     */
    public boolean isItCompleted(){
        boolean less = true;
        int idx = 1;
        while((less) && (idx<game.size())){
            //if(game.get(idx).compareTo(game.get(idx-1))){
            if(((int)game.get(idx))>((int)game.get(idx-1))){
                less = false;
            }
            ++idx;
        }
        return less;
    }
    
    /**
     * Change position to the blank.
     * @param idx int, the index of number which change its position to the blank
     */
    public void change(int idx){
        int tmp = (int) game.get(idx) ;
        game.set(idx,9);
        game.set(blankIndex, tmp);
        blankIndex = idx;
    }
    
    /**
     * Print the current state of game to the console.
     */
    public void log(){
        System.out.println("Game: " + game);
    }
}
