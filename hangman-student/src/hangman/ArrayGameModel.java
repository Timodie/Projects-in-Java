package hangman;

/**
 * The Array implementation of the GameModel interface.
 */
public class ArrayGameModel implements GameModel {
	/** The number of characters (lower/upper). */
	//private static final int ALPHABET_COUNT = 26*2;
	public static final int STARTING_STATE   = 0;

	/** hung state */
	private int state;

	public boolean priorGuess;

	public String guessWord;
	public boolean correctGuess=false;
	public char think;
	public int place=0;
	public String prev;
	public int numberOfGuesses=0;
	public String words="";
	public String [] board;
	public String guessedChars="";
	public String randomWord;
	public int pstate;
	/**
	 * Creates a new ArrayGameModel object.
	 * 
	 *  guessWord the word to guess
	 */
	public ArrayGameModel(String guessWord) {
		// TODO (1)
		//		guessWord.toUpperCase();
		randomWord = guessWord;
		board = new String[guessWord.length()];

		state    = STARTING_STATE;
	}

	public boolean isPriorGuess(char guess) {
		// TODO (2)
		this.think=guess;
		for (int i=0; i<guessedChars.length(); i++){
			if (guessedChars.charAt(i) == guess){
				return true;
			}
		}
		return false;
	}


	public int numberOfGuesses() {
		// TODO (3)
		//		System.out.println("no.of guesses:"+numberOfGuesses);
		return guessedChars.length();
	}


	public boolean isCorrectGuess(char guess) {
		// TODO (4)
		for(int i =0;i<randomWord.length();i++){
			if(randomWord.charAt(i) == guess){
				
				return true;
			}
		}

		return false;
	}



	public boolean doMove(char guess) {
		// TODO (5)
		String h =Character.toString(guess);
		//guessedWords = guessedWords+h;
		if(Character.isLetter(guess)){
		if (!isPriorGuess(guess)) {

			if(!isCorrectGuess(guess) ){
				guessedChars = guessedChars+h;

				state++;
				return false;
			}
			for(int k=0; k<randomWord.length();k++)
				if(randomWord.charAt(k)==guess){
					guessedChars = guessedChars+guess;
					
					return true;
				}
		}
		}
		return false;
	}

	public boolean inWinningState() {
		// TODO (6)
		int counter = 0;
		for(int i=0;i<randomWord.length();i++){
			if(guessedChars.indexOf(randomWord.charAt(i)) != -1){
				counter++;
			}
		}
		if(counter == randomWord.length()){
			//			state++;
			//System.out.println(state);
			return true;
		}else{
			//			state++;
			return false;	
		}
	}


	public boolean inLosingState() {
		if(state==10){
			return true;
		}

		return false;
	}

	public String toString() {
		System.out.println(randomWord);
		String s = "";
		int i = 0;
		for(i=0;i<randomWord.length()-1;i++){
			if(guessedChars.indexOf(randomWord.charAt(i)) != -1){
				s += (randomWord.charAt(i)+" ");
			}else{
				s += "_ ";
			}
		}
		if(guessedChars.indexOf(randomWord.charAt(i)) != -1){
			s += (randomWord.charAt(i));
		}else{
			s += "_";
		}
		// TODO (7)

		return s;
	}


	public String previousGuessString() {
		String s = "[";
		int i=0;
		for(i=0;i<guessedChars.length()-1;i++){
			s += (guessedChars.charAt(i)+", ");
		}
		s += (guessedChars.charAt(i)+"]");

		// TODO (8)

		return s;
	}


	public int getState() {
		//if(!isPriorGuess(think))
		//state=pstate;;
		return state ;
	}

	public String getWord() {

		// TODO (10)

		return randomWord;
	}

}
