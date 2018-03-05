package treesAndGraphs;
import java.util.*;

public class Graph {
	private ArrayList<Project> nodes = new ArrayList<Project>();
	private HashMap<String, Project> map = new HashMap<String, Project>();
	
	public Project returnNode (String name)
	{
		if(!map.containsKey(name))
		{
			Project node = new Project(name);
			nodes.add(node);
			map.put(name, node);
		}
		return map.get(name);
	}
	
	public void addEdge(String parent, String child)
	{
		Project parentNode = returnNode(parent);
		Project childNode = returnNode(child);
		parentNode.addNeighbor(childNode);
	}
	
	public ArrayList<Project> returnNodes()
	{
		return nodes;
	}

}
