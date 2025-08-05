package Tree;

import java.util.HashMap;

class TNode{
    HashMap<Integer , TNode> child;
    boolean Endof;

    TNode(){
        child = new HashMap<>();
        Endof = false;
    }
}
public class Trie {

    TNode root;

    Trie(){
        root = new TNode();
    }

    void insert(String str){
        TNode current = root;
        for(char ch : str.toCharArray()){
            int ind = ch - 'a';
            if(!current.child.containsKey(ind)){
                current.child.put(ind,new TNode());
            }
            current= current.child.get(ind);
        }
        System.out.println(str +" "+ ": successfully Added");
        current.Endof=true;
    }

    void search(String str){
        TNode current = root;
        for(char ch : str.toCharArray()) {
            int ind = ch - 'a';
            if (!current.child.containsKey(ind)) {
                System.out.println(str +" "+ ": Not Found");
                return;
            }
            current = current.child.get(ind);
        }
        if(current.Endof){
            System.out.println(str +" "+": found");
        }else{
            System.out.println(str +" "+": Not found");
        }
    }


    void startWith(String prefix){
        TNode current = root;
        for(char ch : prefix.toCharArray()) {
            int ind = ch - 'a';
            if (!current.child.containsKey(ind)) {
                System.out.println(prefix +" "+": prefix not found");
                return ;
            }
            current = current.child.get(ind);
        }
        System.out.println(prefix +" "+": prefix found");
    }

    public static void main(String[] args) {
        Trie ob = new Trie();
        ob.insert("cook");
        ob.insert("sudhir");
        ob.insert("patel");
        ob.insert("gniot");

        System.out.println();
        ob.search("cook");
        ob.search("sudh");
        ob.search("book");
        ob.search("cccooo");

        System.out.println();
        ob.startWith("co");
        ob.startWith("mk");

    }
}

//leetcode 208
//https://leetcode.com/problems/implement-trie-prefix-tree/