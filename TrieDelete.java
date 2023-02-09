
import java.util.*;

public class TrieDelete{
	
	static int ALPHABET_SIZE = 26;

	// trie node
	static class TrieNode {
		TrieNode children[] = new TrieNode[ALPHABET_SIZE];

		
		boolean isEndOfWord;
	}



	static void insert(TrieNode root, String key)
	{
		TrieNode pCrawl = root;

		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';
			if (pCrawl.children[index] == null)
				pCrawl.children[index] = new TrieNode();

			pCrawl = pCrawl.children[index];
		}

		// mark last node as leaf
		pCrawl.isEndOfWord = true;
	}


	static boolean search(TrieNode root, String key)
	{
		TrieNode pCrawl = root;

		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';
			if (pCrawl.children[index] == null)
				return false;

			pCrawl = pCrawl.children[index];
		}

		return (pCrawl != null && pCrawl.isEndOfWord);
	}

	// Returns true if root has no children, else false
	static boolean isEmpty(TrieNode root)
	{
		for (int i = 0; i < ALPHABET_SIZE; i++)
			if (root.children[i] != null)
				return false;
		return true;
	}


	static TrieNode remove(TrieNode root, String key, int depth)
	{
	
		if (root == null)
			return null;

		
		if (depth == key.length()) {

			
			if (root.isEndOfWord)
				root.isEndOfWord = false;

			// If given is not prefix of any other word
			if (isEmpty(root)) {
				root = null;
			}

			return root;
		}

		
		int index = key.charAt(depth) - 'a';
		root.children[index] =
			remove(root.children[index], key, depth + 1);

		
		if (isEmpty(root) && root.isEndOfWord == false){
			root = null;
		}

		return root;
	}

	// Driver
	public static void main(String args[])
	{
		
		String keys[] = { "the", "a", "there",
						"answer", "any", "by",
						"bye", "their", "hero", "heroplane" };
		int n = keys.length;

		TrieNode root = new TrieNode();

		
		for (int i = 0; i < n; i++)
			insert(root, keys[i]);

		
		if(search(root, "the"))
			System.out.println("Yes");
		else
			System.out.println("No");

		if(search(root, "these"))
			System.out.println("Yes");
		else
			System.out.println("No");

		remove(root, "heroplane", 0);
		
		if(search(root, "hero"))
			System.out.println("Yes");
		else
			System.out.println("No");

	}
}


