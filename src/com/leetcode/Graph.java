package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Graph {
  Integer size;
  Map<Integer, List<Integer>> traversal = new HashMap<>();
  Graph(Integer size) {
    this.size = size;
  }

  public void addEdge(int i, int y) {
  List<Integer> mappings = null;
  if (this.traversal.get(i) == null)  mappings = new ArrayList<>();
  else mappings = this.traversal.get(i);
  mappings.add(y);
  this.traversal.put(i,mappings);
  }

  public void BFS(Integer x, StringBuilder output, Boolean[] visited) {
    if ( visited[x] == null || !visited[x]){
        output.append(x + " ");
        visited[x] = true;
    }
    List<Integer> toDo = new ArrayList<>();
    List<Integer> mappings = this.traversal.get(x);
    if (mappings != null) {
        for (Integer map : mappings) {
            if ( visited[map] == null || !visited[map]) {
                visited[map] = true;
                output.append(map + " ");
                toDo.add(map);
            }
        }

        for (Integer map : toDo) {
            BFS(map, output, visited);
        }
    }

  }

  public void DFS(Integer x, StringBuilder output, Boolean[] visited) {
    visited[x] = true;
    output.append(x + " ");
    List<Integer> maps = this.traversal.get(x);
    for(Integer map : maps) {
      if (visited[map] == null || !visited[map]) {
        DFS(map, output,visited);
      }
    }
  }

  public static void main(String[] args) {
    StringBuilder bfsOutput = new StringBuilder();
    Graph graph = new Graph(4);
    Boolean[] bfsVisited = new Boolean[4];
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(2, 0);
    graph.addEdge(2, 3);
    graph.addEdge(3, 3);
    graph.BFS(2, bfsOutput, bfsVisited);
    System.out.println(bfsOutput);
    StringBuilder dfsOutput = new StringBuilder();
    Boolean[] dfsVisited = new Boolean[4];
    graph.DFS(2, dfsOutput, dfsVisited);
    System.out.println(dfsOutput);

  }

}
