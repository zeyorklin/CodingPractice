package treesAndGraphs;
import java.util.*;

public class GraphBuildOrder {
	public static void main(String[] args)
	{
		String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
		String[][] dependencies = {
				{"a", "b"},
				{"b", "c"},
				{"a", "c"},
				{"a", "c"},
				{"d", "e"},
				{"b", "d"},
				{"e", "f"},
				{"a", "f"},
				{"h", "i"},
				{"h", "j"},
				{"i", "j"},
				{"g", "j"},
		};
		
		Project[] buildOrder = buildOrder(projects, dependencies);
		if(buildOrder == null)
		{
			System.out.println("There is circular dependency, cannot build");
		}
		else {
			for(Project project : buildOrder)
				System.out.println(project.getName());
		}
	}
	
	public static Graph buildGraph(String[] projects, String[][] dependencies)
	{
		Graph graph = new Graph();
		for(String project : projects)
		{
			graph.returnNode(project);
		}
		
		for(String[] dependency : dependencies)
		{
			String parent = dependency[0];
			String child = dependency[1];
			graph.addEdge(parent, child);
		}
		
		return graph;
	}
	
	public static int addNonDependent(Project[] order, ArrayList<Project> projects, int offset)
	{
		for(Project project : projects)
		{
			if(project.getDependencies() == 0)
			{
				order[offset] = project;
				offset ++;
			}
		}
		return offset;
	}
	
	public static Project[] orderProjects(ArrayList<Project> projects)
	{
		Project[] order = new Project[projects.size()];
		int endOfList = addNonDependent(order, projects, 0);
		
		int processingProject = 0;
		while(processingProject < order.length)
		{
			Project current = order[processingProject];
			if(current == null)
				return null;
			
			ArrayList<Project> children = current.getChildren();
			for(Project child : children)
			{
				child.decrementDependencies();
			}
			
			endOfList = addNonDependent(order, children, endOfList);
			processingProject ++;
		}
		
		return order;
	}
	
	public static Project[] buildOrder(String[] projects, String[][] dependencies)
	{
		Graph graph = buildGraph(projects, dependencies);
		Project[] order = orderProjects(graph.returnNodes());
		return order;
	}
}
