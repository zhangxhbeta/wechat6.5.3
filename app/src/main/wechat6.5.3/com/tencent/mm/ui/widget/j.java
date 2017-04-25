package com.tencent.mm.ui.widget;

import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public final class j {
    private static LinkedList<WeakReference<a>> pep = new LinkedList();

    public interface a {
        void I(float f);

        boolean Ri();

        void c(boolean z, int i);
    }

    public static void a(a aVar) {
        v.d("MicroMsg.SwipeBackHelper", "pushCallback size %d, %s", Integer.valueOf(pep.size()), aVar);
        pep.add(0, new WeakReference(aVar));
    }

    public static boolean b(a aVar) {
        v.d("MicroMsg.SwipeBackHelper", "popCallback size %d, %s", Integer.valueOf(pep.size()), aVar);
        if (aVar == null) {
            return true;
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < pep.size(); i++) {
            if (aVar == ((WeakReference) pep.get(i)).get()) {
                pep.remove(i);
                v.d("MicroMsg.SwipeBackHelper", "popCallback directly, index %d", Integer.valueOf(i));
                break;
            }
            linkedList.add(0, Integer.valueOf(i));
        }
        if (aVar.Ri() || linkedList.size() != r4) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) pep.remove(((Integer) it.next()).intValue());
                String str = "MicroMsg.SwipeBackHelper";
                String str2 = "popCallback, popup %s";
                Object[] objArr = new Object[1];
                objArr[0] = weakReference != null ? weakReference.get() : "NULL-CALLBACK";
                v.d(str, str2, objArr);
            }
            return linkedList.isEmpty();
        }
        v.d("MicroMsg.SwipeBackHelper", "popCallback Fail! Maybe Top Activity");
        return false;
    }

    public static void al(float f) {
        if (pep.size() <= 0) {
            v.w("MicroMsg.SwipeBackHelper", "notifySwipe callback stack empty!, scrollParent:%f", Float.valueOf(f));
            return;
        }
        a aVar = (a) ((WeakReference) pep.get(0)).get();
        if (aVar == null) {
            v.w("MicroMsg.SwipeBackHelper", "notifySwipe null, scrollParent:%f", Float.valueOf(f));
            return;
        }
        aVar.I(f);
        v.v("MicroMsg.SwipeBackHelper", "notifySwipe scrollParent:%f, callback:%s ", Float.valueOf(f), aVar);
    }

    public static void r(boolean z, int i) {
        if (pep.size() <= 0) {
            v.w("MicroMsg.SwipeBackHelper", "notifySettle callback stack empty!, open:%B, speed:%d", Boolean.valueOf(z), Integer.valueOf(i));
            return;
        }
        a aVar = (a) ((WeakReference) pep.get(0)).get();
        if (aVar == null) {
            v.w("MicroMsg.SwipeBackHelper", "notifySettle null, open:%B, speed:%d", Boolean.valueOf(z), Integer.valueOf(i));
            return;
        }
        aVar.c(z, i);
        v.v("MicroMsg.SwipeBackHelper", "notifySettle, open:%B speed:%d callback:%s", Boolean.valueOf(z), Integer.valueOf(i), aVar);
    }
}
