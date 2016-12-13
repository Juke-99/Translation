package trans.lang.en;

public class EnglishPhrase {
	
	private String spell,meaning;
	
	public EnglishPhrase(String Spell,String Meaning){
		this.spell=Spell;
		this.meaning=Meaning;
	}
	
	public String getSpell(){
		return spell;
	}
	
	public String getMeaning(){
		return meaning;
	}
}
