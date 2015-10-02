package hangman;

public class LLCharacterNode {

	private char info;
	private LLCharacterNode link;

	public LLCharacterNode(char guess){
		//String t =Character.toString(guess);
		this.info = guess;
		link = null;
	}

	public char getInfo() {
		return info;
	}

	public void setInfo(char info) {
		this.info = info;
	}

	public LLCharacterNode getLink() {
		return link;
	}

	public void setLink(LLCharacterNode link) {
		this.link = link;
	}
	
		
	}
	

