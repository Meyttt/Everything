package multithreading.recursive;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

interface Node {
    int getValue();

    Node[] getChildren();
}

/**
 * Created by Meyttt on 04.10.2017.
 */
public class Computing {
    public static void main(String[] args) {
        Node leaf1= new MyNode(new Node[]{new MyNode(2),new MyNode(3),new MyNode(4)},1);
        Node leaf2= new MyNode(new Node[]{new MyNode(5),new MyNode(6)},7);
        Node leaf3= new MyNode(new Node[]{new MyNode(8)},9);
        Node point1=new MyNode(new Node[]{leaf1,leaf2},10);
        Node rootNode = new MyNode(new Node[]{point1,leaf3},11);

        RecursiveTreeComputer recursiveTreeComputer= new RecursiveTreeComputer(rootNode);
        ForkJoinTask<Long> task=recursiveTreeComputer.fork();
        System.out.println(task.join());

        ForkJoinTask<Long> task1=ForkJoinTask.adapt(new TreeComputer(rootNode));
        task1.invoke();
        System.out.println(task1.join());
    }
}

class MyNode implements Node {
    public MyNode(int value) {
        this.value = value;
        this.children=new Node[]{};
    }

    public MyNode(Node[] children, int value) {
        this.children = children;
        this.value = value;
    }

    Node[] children;
    int value;

    void addChild(Node node) {
        Node[] newChildren = new Node[children.length + 1];
        for (int i = 0; i < children.length; i++) {
            newChildren[i] = children[i];
        }
        newChildren[children.length] = node;
        this.children = newChildren;
    }

    @Override
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }
}
class TreeComputer implements Callable<Long>{
    Node rootNode;

    public TreeComputer(Node rootNode) {
        this.rootNode = rootNode;
    }

    @Override
    public Long call() throws Exception {
        long sum=rootNode.getValue();
        for(Node childNode:rootNode.getChildren()){
            sum+=new TreeComputer(childNode).call();
        }
        return sum;
    }
}
class RecursiveTreeComputer extends RecursiveTask<Long>{
    public RecursiveTreeComputer(Node rootNode) {
        this.rootNode = rootNode;
    }

    Node rootNode;
    @Override
    protected Long compute() {
        List<ForkJoinTask<Long>> tasks = new LinkedList<>();
        long sum = rootNode.getValue();
        for(Node childNode:rootNode.getChildren()){
            tasks.add(new RecursiveTreeComputer(childNode).fork());
        }
        for (ForkJoinTask<Long> forkJoinTask:tasks){
            sum+=forkJoinTask.join();
        }
        return sum;
    }
}
