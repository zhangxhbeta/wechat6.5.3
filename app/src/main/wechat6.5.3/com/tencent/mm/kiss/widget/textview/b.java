package com.tencent.mm.kiss.widget.textview;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    public ConcurrentHashMap<String, LinkedList<f>> clK = new ConcurrentHashMap();

    public final synchronized void a(f fVar) {
        if (fVar != null) {
            if (fVar.cmo != null) {
                LinkedList linkedList = (LinkedList) this.clK.get(fVar.cmo.toString());
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                linkedList.add(fVar);
                this.clK.put(fVar.cmo.toString(), linkedList);
            }
        }
    }

    public final synchronized f n(CharSequence charSequence) {
        f fVar;
        LinkedList linkedList = (LinkedList) this.clK.get(charSequence.toString());
        if (linkedList == null || linkedList.size() == 0) {
            fVar = null;
        } else {
            fVar = (f) linkedList.removeFirst();
        }
        return fVar;
    }
}
