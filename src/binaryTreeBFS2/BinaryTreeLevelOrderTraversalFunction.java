package binaryTreeBFS2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeLevelOrderTraversalFunction {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		// Return empty list if its null
		if (root == null) {
			return result;
		}

		// Use queue for bfs and stack for dfs
		Queue<TreeNode> queue = new LinkedList<>();

		// Add the root to the queue as default
		queue.add(root);

		// While the queue not empty
		while (!queue.isEmpty()) {
			// We want to store queue size cause the queue size will change inside the loop, but we want to stop the loop
			int size = queue.size();
			
			// Store the temp list
			List<Integer> temp = new ArrayList<>();

			for (int i = 0; i < size; i++) {
				// Remove the first item in the queue
				TreeNode node = queue.remove();

				temp.add(node.val);

				// Add the children if any
				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}

			}

			// Add each level to the result, 0 to move previous elements to the next index instead
			result.add(0,temp);
		}

		return result;
	}
	
	// Recursive without queue
	public List<List<Integer>> levelOrder1(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		
		bfs(result, root, 0);
		
		return result;
	}
	
	public void bfs(List<List<Integer>> result, TreeNode root, int height){
		// If we reach to the null children
		if(root == null){
			// Do nothing
			return;
		}
		
		// We will only create space of the proper level, won't create extra
		if(height == result.size()){
			// add(0,new) 0 will make sure to create an empty list as the first one, move the previous to the next index
			result.add(0,new ArrayList<Integer>());
		}
		
		// get.(height) will get the level of index, then add the node
		result.get(result.size() - 1 - height).add(root.val);
		
		// Get the left children first, increase the height by 1 every time
		bfs(result, root.left, height + 1);
		
		bfs(result, root.right, height + 1);
		
	}
	
	
}
