package com.tencent.mm.plugin.collect.b;

import java.util.LinkedList;
import java.util.List;

public enum a {
    ;
    
    public List<a> eAR;

    public interface a {
        void b(c cVar);
    }

    private a(String str) {
        this.eAR = new LinkedList();
    }

    public final void a(c cVar) {
        for (a aVar : this.eAR) {
            if (aVar != null) {
                aVar.b(cVar);
            }
        }
    }
}
