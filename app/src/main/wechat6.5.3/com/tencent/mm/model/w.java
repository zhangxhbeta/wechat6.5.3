package com.tencent.mm.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class w {
    public long crX = 0;

    public static final class a {
        private static final LinkedList<b> crY = new LinkedList();

        public static void a(b bVar) {
            crY.add(bVar);
        }

        public static List<w> yD() {
            List<w> linkedList = new LinkedList();
            Iterator it = crY.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar != null) {
                    w yE = bVar.yE();
                    if (yE != null) {
                        linkedList.add(yE);
                    }
                }
            }
            return linkedList;
        }
    }

    public interface b {
        w yE();
    }

    public abstract boolean eH(int i);

    public abstract String getTag();

    public abstract void transfer(int i);
}
