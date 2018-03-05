package treesAndGraphs;
import java.util.*;

public class Project {
	private ArrayList<Project> children = new ArrayList<Project>();
	private int dependencies = 0;
	private String name;
	public enum State {COMPLETE, PARTIAL, BLANK}; //for GraphBuildOder2
	private State state = State.BLANK; //for GraphBuildOder2
	
	public Project(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setState(State state) //for GraphBuildOder2
	{ 
		this.state = state;
	}
	
	public State getState() //for GraphBuildOder2
	{
		return state;
	}
	
	public void incrementDependencies()
	{
		dependencies++;
	}
	
	public void decrementDependencies()
	{
		dependencies--;
	}
	
	public int getDependencies()
	{
		return dependencies;
	}
	
	public ArrayList<Project> getChildren()
	{
		return children;
	}
	
	public void addNeighbor(Project node)
	{
		if(!children.contains(node)) //!children.contains(node)
		{
			children.add(node);
			node.incrementDependencies();
		}
	}
}
