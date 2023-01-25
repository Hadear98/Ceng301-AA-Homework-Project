// 1st and 2nd codes couldn't be run in an online compiler because they need registered files that is why we couldn't provide an online link

import java.util.ArrayList;
import java.util.List;
 
public class Node {
public int value;
public List<Node> children;
public Node(int value) {
this.value = value;
this.children = new ArrayList<Node>();
}
public List<Node> getParents(Node root, int valueToSearch) {
List<Node> path = new ArrayList<Node>();
if (root == null) {
return path;
}
if (root.value == valueToSearch) {
path.add(root);
return path;
}
for (Node child : root.children) {
List<Node> childPath = getParents(child, valueToSearch);
if (!childPath.isEmpty()) {
path.add(root);
path.addAll(childPath);
return path;
}
}
return path;
}
}