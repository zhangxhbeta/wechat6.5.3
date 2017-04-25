package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class aj<K, O> {
    Map<K, b<O>> jmW = null;
    private a jmX = null;
    private int maxSize;

    public interface a {
        boolean aV(Object obj);
    }

    public class b<OO> {
        final /* synthetic */ aj jmY;
        public Long jmZ;
        public OO obj;

        public b(aj ajVar, OO oo) {
            this.jmY = ajVar;
            this.obj = oo;
            aSZ();
        }

        public final void aSZ() {
            this.jmZ = Long.valueOf(System.currentTimeMillis());
        }
    }

    public aj(int i, a aVar) {
        this.maxSize = i;
        this.jmW = new HashMap();
        this.jmX = aVar;
    }

    public final void aSY() {
        if (this.jmW.size() > this.maxSize) {
            Object arrayList = new ArrayList(this.jmW.entrySet());
            Collections.sort(arrayList, new Comparator<Entry<K, b<O>>>(this) {
                final /* synthetic */ aj jmY;

                {
                    this.jmY = r1;
                }

                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return ((b) ((Entry) obj).getValue()).jmZ.compareTo(((b) ((Entry) obj2).getValue()).jmZ);
                }
            });
            int size = this.jmW.size() - this.maxSize;
            if (size > 0) {
                Iterator it = arrayList.iterator();
                int i = size;
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (this.jmX.aV(entry.getKey())) {
                        v.d("MicroMsg.SnsLRUMap", " remove targetKey: " + entry.getKey());
                        size = i - 1;
                    } else {
                        size = i;
                    }
                    if (size > 0) {
                        i = size;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
