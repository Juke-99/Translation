package trans.lang.diagram;

public interface Tag extends Comparable<Object>{
	String getValue();
	int getScore();
	int getCloudLevel();
	void setCloudLevel(int cloudLevel);
}
