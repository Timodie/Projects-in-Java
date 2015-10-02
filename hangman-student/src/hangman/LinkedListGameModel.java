package hangman;

public class LinkedListGameModel implements GameModel {
	
	public String randomWord;
	public boolean correctGuess=false;
	public char think;
	public int place=0;
	public String prev;
	public int numberOfGuesses=0;
	public String words="";
	//private static final int ALPHABET_COUNT = 26*2;
	public static final int STARTING_STATE   = 0;
	private int state;
	//public String guessedWords="";
	public LLCharacterNode board;
	public LLCharacterNode guessWords;
	public char t ='\0';
	
	
	
	
	

	
	
	public LinkedListGameModel(String guessWord){
	this.randomWord= guessWord;
	
	state =STARTING_STATE;
	guessWords = new LLCharacterNode(t);
	
	}

	
	
	@Override
	public boolean isPriorGuess(char guess) {
		this.think =guess;
		
		LLCharacterNode temp = guessWords;
		while(temp!= null){
			if(temp.getInfo() == guess){
				
				return true;
				}
			temp = temp.getLink();
			
		}
		
		return false;
	}


	public void insertLetter(char guess){
		
		LLCharacterNode temp =new LLCharacterNode(guess);
		LLCharacterNode current = guessWords;
		while(current.getLink()!=null){
			current =current.getLink();
		}
		current.setLink(temp);
		
	}
	
	@Override
	public int numberOfGuesses() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isCorrectGuess(char guess) {
		
		for(int i =0;i<randomWord.length();i++){
			if(randomWord.charAt(i) == guess && !isPriorGuess(guess)){
				place++;
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean doMove(char guess) {
		// TODO Auto-generated method stub
		if (!isPriorGuess(guess)) {

			if(!isCorrectGuess(guess) ){
				insertLetter(guess);

				state++;
				return false;
			}
			for(int k=0; k<randomWord.length();k++)
				if(randomWord.charAt(k)==guess){
					insertLetter(guess);
					//		state++;
					return true;
				}
		}
		
		return false;
	}
	
		
		
	

	@Override
	public boolean inWinningState() {
		// TODO Auto-generated method stub
		String t ="";
		System.out.println(randomWord);
		LLCharacterNode temp= guessWords;
		while(temp.getLink()!=null){
			temp = temp.getLink();
			t+=temp.getInfo();
			}
		
		int counter = 0;
		for(int i=0;i<randomWord.length();i++){
			if(t.indexOf(randomWord.charAt(i)) != -1){
				counter++;
			}
		}
		if(counter == randomWord.length()){
		
			return true;
		}else{
			
			return false;	
		}
	}
		

	@Override
	public boolean inLosingState() {
		if(state==10){
			return true;
		}
		return false;
	}
public String toString(){
	
	String s= "";
	String t ="";
	System.out.println(randomWord);
	LLCharacterNode temp= guessWords;
	while(temp.getLink()!=null){
		temp = temp.getLink();
		t+=temp.getInfo();
		}
	int i;
	for(i=0;i<randomWord.length()-1;i++){
		if(t.indexOf(randomWord.charAt(i)) != -1){
			s += (randomWord.charAt(i)+" ");
		}else{
			s += "_ ";
		}
	}
	if(t.indexOf(randomWord.charAt(i)) != -1){
		s += (randomWord.charAt(i));
	}else{
		s += "_";
	}
	// TODO (7)

	return s;
}
	
	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return state;
	}

	@Override
	public String previousGuessString() {
		// TODO Auto-generated method stub
		String s = "[";
		LLCharacterNode temp= guessWords;
		while(temp.getLink()!=null){
			temp = temp.getLink();
			s+=temp.getInfo()+"," ;
			s+=" ";
			}
		 s = s.substring(0, s.length()-2);
		
		s+="]";
		

		return s;
	}
		
	

	@Override
	public String getWord() {
		// TODO Auto-generated method stub
		return randomWord;
	}

}

