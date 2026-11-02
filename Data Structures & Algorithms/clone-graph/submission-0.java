/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

 public class Solution {
        Map<Node,Node> mp = new HashMap<>();
        public Node cloneGraph(Node node){
            if(node == null)return null;
            Node curr=new Node(node.val);
            mp.put(node,curr);
            for(Node i: node.neighbors){
                if(!mp.containsKey(i)) curr.neighbors.add(cloneGraph(i));
                else
                curr.neighbors.add(mp.get(i));
            }
            return curr;
        }
        
    }