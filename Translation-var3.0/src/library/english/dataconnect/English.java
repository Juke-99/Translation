package library.english.dataconnect;

public class English {
	private String spell, meaning, pert_of_speech;
	private int count;
	
	public English(String spell, String meaning, String pert_of_speech) {
		this.spell = spell;
		this.meaning = meaning;
		this.pert_of_speech = pert_of_speech;
	}
	
	public void setCount(int count){
		this.count = count;
	}
	
	public String getSpell(){
		return spell;
	}
	
	public String getMeaning(){
		return meaning;
	}
	
	public String getPertOfSpeech(){
		return pert_of_speech;
	}
	
	public int getCount(){
		return count;
	}
}
