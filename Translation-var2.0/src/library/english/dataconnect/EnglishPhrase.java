package library.english.dataconnect;


public class EnglishPhrase {
	private String spell, meaning;
	
	public EnglishPhrase(String spell, String meaning) {
		this.spell = spell;
		this.meaning = meaning;
	}
	
	public String getSpell(){
		return spell;
	}
	
	public String getMeaning(){
		return meaning;
	}
}
