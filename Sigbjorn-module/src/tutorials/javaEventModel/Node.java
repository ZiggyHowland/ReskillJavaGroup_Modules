package tutorials.javaEventModel;

public class Node {
    private Object value;
    private Node previous;
    private Node next;
    private NodeEventListener[] listeners;

    public Node (Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrevious() {
        return previous;
    }


    public void link(Node node) {
        notifyListeners(node, NodeEventState.PRE_LINK);
        node.previous = this;
        node.next = next;
        if (next != null) {
            node.next.previous = node;
        }
        next = node;
        notifyListeners(node, NodeEventState.AFTER_LINK);
    }

    private void notifyListeners(Node node, NodeEventState nodeState) {
        NodeEvent event = new NodeEvent(this, node, nodeState);
        NodeEventListener interested[] = listeners;
        for (int i = 0; i < interested.length; i++) {
            interested[i].handleNodeEvent(event);
        }
    }

    public void unlink() {
        if (next != null) {
            next.previous = previous;
        }
        if (previous != null) {
            previous.next = next;
        }
        notifyListenersNodeUnlinked();
    }

    private void notifyListenersNodeUnlinked() {
        NodeEvent event = new NodeEvent(this, NodeEventState.UNLINK);
        NodeEventListener interested[] = listeners;
        for (int i = 0; i < interested.length; i++) {
            interested[i].onNodeUnlinked(event);
        }
    }




    public void addNodeEventListener(NodeEventListener listener) {
        if (listeners == null) {
            listeners = new NodeEventListener[] { listener };
        }
        else {
            NodeEventListener results[] = new NodeEventListener[listeners.length +1];
            for (int i = 0; i < listeners.length; i++) {
                results[i] = listeners[i];
            }
            results[listeners.length] = listener;
            listeners = results;
        }
    }

    public void removeNodeEventListener(NodeEventListener listener) {
        int n = -1;
        for (int i = 0; i < listeners.length; i++) {
            if (listeners[i] == listener) {
                n = i;
                break;
            }
        }
        if (n < 0) {
            return;
        }
        NodeEventListener results[] = new NodeEventListener[listeners.length -1];
        int j = 0;
        for (int i = 0; i < listeners.length; i++) {
            if (i != n) {
                results[j++] = listeners[i];
            }
        }
        listeners = results;
    }

    public String toString() {
        if (value != null) {
            return value.toString();
        }
        return "x";

    }

}
