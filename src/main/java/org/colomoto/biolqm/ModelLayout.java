package org.colomoto.biolqm;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple storage for layout information
 *
 * @author Aurelien Naldi
 */
public class ModelLayout {

    private final Map<NodeInfo, LayoutInfo> layout = new HashMap<>();

    public LayoutInfo getInfo(NodeInfo ni) {
        return this.layout.get(ni);
    }

    public LayoutInfo setPosition(NodeInfo ni, int x, int y) {
        LayoutInfo li = layout.get(ni);
        if (li == null) {
            li = new LayoutInfo(x,y);
            layout.put(ni, li);
            return li;
        }

        li.x = x;
        li.y = y;
        return li;
    }

    public void set(NodeInfo ni, int x, int y, int width, int height) {
        LayoutInfo li = layout.get(ni);
        if (li == null) {
            li = new LayoutInfo(x,y);
            layout.put(ni, li);
            return;
        }

        li.x = x;
        li.y = y;
    }

    public void copy(NodeInfo ni, LayoutInfo source) {
        if (source == null) {
            layout.remove(ni);
            return;
        }
        this.set(ni, source.x, source.y, source.width, source.height);
    }

    public class LayoutInfo {
        public int x,y;
        public int width, height;

        protected LayoutInfo(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        protected LayoutInfo(int x, int y) {
            this(x,y, 0, 0);
        }
    }

}
