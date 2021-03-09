package tutorials.javaEventModel;

import java.util.EventObject;

public class NodeEvent extends EventObject {
    private Node node2;
    private NodeEventState mNodeEventState;
    private static final long serialVersionUID = 1L;

    public NodeEvent(Object source, Node node, NodeEventState eventState) {
        super(source);
        node2 = node;
        mNodeEventState = eventState;
    }

    public NodeEvent(Object source, NodeEventState eventState) {
        super(source);
        mNodeEventState = eventState;
    }


    public NodeEventState getNodeEventState() {
        return mNodeEventState;
    }

    public Node getNode1() {
        return (Node) getSource();
    }

    public Node getNode2() {
        return node2;
    }

    public String toString() {
        return String.format("%s-%s-%s", getNode1(), getNode2(), getNodeEventState());
    }



}
