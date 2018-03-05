package treesAndGraphs;
import java.util.*;

public class GraphBuildOrder2 {
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
		
		Stack<Project> order = buildOrder(projects, dependencies);
		if(order == null)
		{
			System.out.println("There is circular dependency, cannot build");
		}
		else {
			while(!order.isEmpty())
				System.out.println(order.pop().getName());
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
	
	public static boolean orderDFS(Project project, Stack<Project> projects)
	{
		if(project.getState() == Project.State.PARTIAL)
		{
			return false;
		}
		
		if(project.getState() == Project.State.BLANK)
		{
			project.setState(Project.State.PARTIAL);
			ArrayList<Project> children = project.getChildren();
			for(Project child : children)
			{
				if(!orderDFS(child, projects))
					return false;
			}
			project.setState(Project.State.COMPLETE);
			projects.push(project);
		}
		return true;
	}
	
	public static Stack<Project> buildOrder(String[] projects, String[][] dependencies)
	{
		Graph graph = buildGraph(projects, dependencies);
		Stack<Project> order = new Stack<Project>();
		ArrayList<Project> projectList = graph.returnNodes();
		for(Project project : projectList)
		{
			if(project.getState() == Project.State.BLANK)
			{
				if(!orderDFS(project, order))
					return null;
			}
		}
		return order;
		
	}
	
}
