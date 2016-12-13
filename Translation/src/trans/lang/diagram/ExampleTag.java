package trans.lang.diagram;

import java.io.Serializable;

public class ExampleTag implements Tag,Serializable{
	private String value;
	private int score;
	private int cloudLevel;
	
	public ExampleTag(String value,int score){
		this.value=value;
		this.score=score;
	}
	
	@Override
	public String getValue(){
		return value;
	}
	
	@Override
	public int getScore(){
		return score;
	}
	
	@Override
	public int getCloudLevel(){
		return cloudLevel;
	}

	@Override
	public int compareTo(Object o) {
		Tag tag=(Tag) o;
		return (getScore()-tag.getScore());
	}

	@Override
	public void setCloudLevel(int cloudLevel) {
		this.cloudLevel=cloudLevel;
	}
	
	@Override
	public String toString(){
		return "ExampleTag[value="+value+",score="+score+",cloudLevel="+cloudLevel+"]";
	}
}
