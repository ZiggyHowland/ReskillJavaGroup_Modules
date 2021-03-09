package tutorials.javaEventModel;

import junit.framework.TestCase;

public class JavaBeansTest extends TestCase {
    public void testNodeListeners() {
        final Node node1 = new Node(1);
        final Node node2 = new Node(2);
        System.out.println("1: Setting up listeners and adding to event source");
        NodeEventListener nodeEventListener1 = new NodeListener1();
        NodeEventListener nodeEventListener2 = new NodeListener2();
        node1.addNodeEventListener(nodeEventListener1);
        node2.addNodeEventListener(nodeEventListener2);
        System.out.println("2: Link node 2 to node 1");
        node1.link(node2);
        System.out.println("3: Unlinks node 2");
        node2.unlink();
        System.out.println("4: Remove event listener 2 from node 1 (Doesn't really exist...)");
        node1.removeNodeEventListener(nodeEventListener2);
        System.out.println("5: Link new node (3) to node 1");
        node1.link(new Node(3));
        System.out.println("6: Remove event listener 1 from node 1");
        node1.removeNodeEventListener(nodeEventListener1);
        System.out.println("5: Link new node (4) to node 1");
        node1.link(new Node(4));


    }


    private class NodeListener1 implements NodeEventListener {
        @Override
        public void handleNodeEvent(NodeEvent nodeEvent) {
            System.out.println("Listener 1 receives " + nodeEvent + " event");
        }

        @Override
        public void onNodeUnlinked(NodeEvent nodeEvent) {
            System.out.println("Listener 1 unlinks: " + nodeEvent);
        }
    }

    private class NodeListener2 implements NodeEventListener {
        @Override
        public void handleNodeEvent(NodeEvent nodeEvent) {
            System.out.println("Listener 2 receives " + nodeEvent + " event");
        }

        @Override
        public void onNodeUnlinked(NodeEvent nodeEvent) {
            System.out.println("Listener 2 unlinks: " + nodeEvent);
        }
    }
}
