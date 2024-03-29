
public class TrieSearch {
	
	static final int ALPHABET_SIZE = 26;
	
	// trie node
	static class TrieNode
	{
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
	
		
		boolean isEndOfWord;
		
		TrieNode(){
			isEndOfWord = false;
			for (int i = 0; i < ALPHABET_SIZE; i++)
				children[i] = null;
		}
	};
	
	static TrieNode root;
	
	
	static void insert(String key)
	{
		int level;
		int length = key.length();
		int index;
	
		TrieNode pCrawl = root;
	
		for (level = 0; level < length; level++)
		{
			index = key.charAt(level) - 'a';
			if (pCrawl.children[index] == null)
				pCrawl.children[index] = new TrieNode();
	
			pCrawl = pCrawl.children[index];
		}
	
		// mark last node as leaf
		pCrawl.isEndOfWord = true;
	}
	
	// Returns true if key presents in trie, else false
	static boolean search(String key)
	{
		int level;
		int length = key.length();
		int index;
		TrieNode pCrawl = root;
	
		for (level = 0; level < length; level++)
		{
			index = key.charAt(level) - 'a';
	
			if (pCrawl.children[index] == null)
				return false;
	
			pCrawl = pCrawl.children[index];
		}
	
		return (pCrawl.isEndOfWord);
	}
	
	// Driver
	public static void main(String args[])
	{
		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = {"the", "a", "there", "answer", "any",
						"by", "bye", "their"};
	
		String output[] = {"Not present in trie", "Present in trie"};
	
	
		root = new TrieNode();
	
		// Construct trie
		int i;
		for (i = 0; i < keys.length ; i++)
			insert(keys[i]);
	
		// Search for different keys
		if(search("the") == true)
			System.out.println("the --- " + output[1]);
		else System.out.println("the --- " + output[0]);
		
		if(search("these") == true)
			System.out.println("these --- " + output[1]);
		else System.out.println("these --- " + output[0]);
		
		if(search("their") == true)
			System.out.println("their --- " + output[1]);
		else System.out.println("their --- " + output[0]);
		
		if(search("thaw") == true)
			System.out.println("thaw --- " + output[1]);
		else System.out.println("thaw --- " + output[0]);
		
	}
}

