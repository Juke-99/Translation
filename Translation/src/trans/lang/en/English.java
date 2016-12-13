package trans.lang.en;

public class English {
	
	private String spell,meaning,pert_of_speech;
	private int count;
	
	public English(String Spell,String Meaning,String Pert_of_speech){
		this.spell=Spell;
		this.meaning=Meaning;
		this.pert_of_speech=Pert_of_speech;
	}
	
	public void setCount(int Count){
		this.count=Count;
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
