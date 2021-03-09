package tutorials.javaEventModel;

import java.util.EventListener;

public interface NodeEventListener extends EventListener {
    // Example of generic API
    void handleNodeEvent(NodeEvent nodeEvent);

    // Example of specific API
    void onNodeUnlinked(NodeEvent nodeEvent);

}
