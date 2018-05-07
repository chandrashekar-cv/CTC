package grpahsNtrees;

import java.util.ArrayList;
import java.util.List;


public class ImplementATrie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie obj = new Trie();
		
		obj.insert("a");
		System.out.println(obj.search("a"));
		System.out.println(obj.startsWith("a"));
	}

}

class Trie{
	
	Trie[] trieRoot = null;
	List<String> wordsUnderCurrentLevel=null;
	boolean isEndofWord;
	/** Initialize your data structure here. */
    public Trie() {
        trieRoot = new Trie[26];
        wordsUnderCurrentLevel = new ArrayList<>();
        isEndofWord = true;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        StringBuilder wordChar = new StringBuilder(word);
        Trie trie = this;
        int i=0;
        for(;i<wordChar.length();i++) {
        	Trie trieNode = trie.trieRoot[wordChar.charAt(i)-'a'];
        	if(trieNode!=null) {
        		trieNode.wordsUnderCurrentLevel.add(word);
        		trie = trieNode;
        	}
        	else
        		break;
        }
        
        for(;i<wordChar.length();i++) {
        	Trie newChild = new Trie();
        	newChild.wordsUnderCurrentLevel.add(word);
        	trie.trieRoot[wordChar.charAt(i)-'a'] = newChild;
        	trie = newChild;
        }
        trie.isEndofWord=true;
        
    }
    
    /** Returns true if the word is in the trie. */
    public boolean search(String word) {
    	
    	StringBuilder wordChar = new StringBuilder(word);
    	Trie trie = this;
    	
    	for(int i=0;i<wordChar.length() && trie!=null;i++) {
    		trie = trie.trieRoot[wordChar.charAt(i)-'a'];
    		if(trie==null)
        		return false;
    	}
    	
    	
    	return trie.isEndofWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	
    	Trie trie = this;
    	
    	for(int i=0;i<prefix.length() && trie!=null;i++) {
    		trie = trie.trieRoot[prefix.charAt(i)-'a'];
    	}
    	
    	return trie!=null;
        
    }
}
