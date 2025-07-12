package boggle;

import java.util.HashSet;
import java.util.Set;

/**
 * The BoggleStats class for the first Assignment in CSC207, Fall 2022
 * The BoggleStats will contain statsitics related to game play Boggle 
 */
public class BoggleStats {

    /**
     * set of words the player finds in a given round 
     */  
    private Set<String> playerWords = new HashSet<String>();  
    /**
     * set of words the computer finds in a given round 
     */  
    private Set<String> computerWords = new HashSet<String>();  
    /**
     * the player's score for the current round
     */  
    private int pScore; 
    /**
     * the computer's score for the current round
     */  
    private int cScore; 
    /**
     * the player's total score across every round
     */  
    private int pScoreTotal; 
    /**
     * the computer's total score across every round
     */  
    private int cScoreTotal; 
    /**
     * the average number of words, per round, found by the player
     */  
    private double pAverageWords; 
    /**
     * the average number of words, per round, found by the computer
     */  
    private double cAverageWords; 
    /**
     * the current round being played
     */  
    private int round; 

    /**
     * enumarable types of players (human or computer)
     */  
    public enum Player {
        Human("Human"),
        Computer("Computer");
        private final String player;
        Player(final String player) {
            this.player = player;
        }
    }

    /* BoggleStats constructor
     * ----------------------
     * Sets round, totals and averages to 0.
     * Initializes word lists (which are sets) for computer and human players.
     */
    public BoggleStats() {

        round = 0;
        cScoreTotal = 0;
        pScoreTotal = 0;
        pAverageWords = 0;
        cAverageWords = 0;
        playerWords = new HashSet<>();
        computerWords = new HashSet<>();
    }

    /* 
     * Add a word to a given player's word list for the current round.
     * You will also want to increment the player's score, as words are added.
     *
     * @param word     The word to be added to the list
     * @param player  The player to whom the word was awarded
     */
    public void addWord(String word, Player player) {

        if (player == Player.Computer) {
            cScore = word.length() - 3;
            computerWords.add(word);
        } else if (player == Player.Human) {
            pScore = word.length() - 3;
            playerWords.add(word);
        }

    }

    /* 
     * End a given round.
     * This will clear out the human and computer word lists, so we can begin again.
     * The function will also update each player's total scores, average scores, and
     * reset the current scores for each player to zero.
     * Finally, increment the current round number by 1.
     */
    public void endRound() {

        pScoreTotal += pScore;
        cScoreTotal += cScore;
        pAverageWords= (playerWords.size()+(pAverageWords*round))/(round+1);
        cAverageWords= (computerWords.size()+(cAverageWords*round))/(round+1);
        playerWords.clear();
        computerWords.clear();
        pScore = 0;
        cScore = 0;
        round ++;
    }

    /* 
     * Summarize one round of boggle.  Print out:
     * The words each player found this round.
     * Each number of words each player found this round.
     * Each player's score this round.
     */
    public void summarizeRound() {
       System.out.println(Player.Human+" found:"+playerWords.toString());
       System.out.println(Player.Human+" found:"+playerWords.size()+" words");
       System.out.println(Player.Human+" score:"+pScore);
       System.out.println(Player.Computer+" found: "+computerWords.toString());
       System.out.println(Player.Computer+" found: "+computerWords.size()+" words");
       System.out.println(Player.Computer+" score: "+cScore);

    }

    /* 
     * Summarize the entire boggle game.  Print out:
     * The total number of rounds played.
     * The total score for either player.
     * The average number of words found by each player per round.
     */
    public void summarizeGame() {
        System.out.println("total "+round+" rounds played");
        System.out.println("total score for "+Player.Computer+" "+cScoreTotal);
        System.out.println("total score for "+ Player.Human+" "+pScoreTotal);
        System.out.println("average number of words found by "+Player.Computer+" "+cAverageWords);
        System.out.println("average number of words found by "+Player.Human+ " "+pAverageWords);
    }

    /* 
     * @return Set<String> The player's word list
     */
    public Set<String> getPlayerWords() {
        return this.playerWords;
    }

    /*
     * @return int The number of rounds played
     */
    public int getRound() { return this.round; }

    /*
    * @return int The current player score
    */
    public int getScore() {
        return this.pScore;
    }

}
