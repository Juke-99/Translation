package trans.lang.diagram;

import java.util.Set;

public class TagCloud {

	private final int maxLevel;
	private final Set<Tag> tags;
	private boolean clouded;
	private int minScore=Integer.MIN_VALUE;
	private int maxScore=Integer.MAX_VALUE;
	public TagCloud(int maxLevel){
		this(maxLevel,16);
	}
	
	public TagCloud(int maxLevel, int capacity) {
		
		if(maxLevel<1)
		{
			throw new IllegalArgumentException("invalid maxLevel "+maxLevel);
		}
		
		this.maxLevel = maxLevel;
        this.tags = new java.util.LinkedHashSet<Tag>(capacity);
	}
	
	 public void addTag(Tag tag) {
	        if (tag != null)
	        {
	            tags.add(tag);
	            int score = tag.getScore();
	            this.minScore = Math.min(minScore, score);
	            this.maxScore = Math.max(maxScore, score);
	            this.clouded = false;
	        }
	}
	 
	 public Set getTags() {
	        cloud();
	        return tags;
	 }
	 
	 private void cloud() {
	        final int size = tags.size();
	        
	        if (clouded || size == 0) 
	        {
	            return;
	        }
	        
	        if (size == 1) 
	        {
	            Tag tag = tags.iterator().next();
	            tag.setCloudLevel(1);
	        }
	        else
	        {
	            double min = (minScore == 0) ? 0.0: Math.log(minScore);
	            double max = (maxScore == 0) ? 0.0: Math.log(maxScore);
	            double f;
	            
	            if (min == max) 
	            {
	                min -= maxLevel;
	                f = 1.0;
	            }
	            else 
	            {
	                f = maxLevel / (max - min);
	            }
	            
	            if (size < maxLevel) 
	            {
	                f *= ((double) size / maxLevel);
	            }
	            
	            for (Tag tag: tags) 
	            {
	                int score = tag.getScore();
	                
	                if (score != 0) 
	                {
	                    tag.setCloudLevel((int) ((Math.log(score) - min) * f));
	                }
	            }
	        }
	        
	        this.clouded = true;
	    }
	
	public static void main(String[] args) {
		 TagCloud tagCloud = new TagCloud(4);
	     tagCloud.addTag(new ExampleTag("abcd", 3));
	     tagCloud.addTag(new ExampleTag("efg", 1));
	     tagCloud.addTag(new ExampleTag("hijk", 2));
	     tagCloud.addTag(new ExampleTag("lmn", 10));
	     tagCloud.addTag(new ExampleTag("opqrstu", 7));
	     tagCloud.addTag(new ExampleTag("vwxyz", 5));
	     System.out.println(tagCloud.getTags());
	}

}
