package com.tencent.mm.ui.f;

import android.content.Context;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class e {
    private static a oPk = new a();

    public static class a {
        boolean isReady;
        d oPl;
        LinkedList<b> oPm = new LinkedList();
    }

    public interface b extends Comparable<b> {
        f a(Context context, com.tencent.mm.ui.f.f.b bVar, int i);

        int getPriority();

        int getType();
    }

    public static void a(b bVar) {
        a aVar = oPk;
        int size = aVar.oPm.size();
        int i = 0;
        while (i < size) {
            if (((b) aVar.oPm.get(i)).getType() != bVar.getType()) {
                i++;
            } else {
                return;
            }
        }
        aVar.oPm.add(bVar);
        Collections.sort(aVar.oPm);
    }

    public static void xZ(int i) {
        a aVar = oPk;
        b bVar = null;
        Iterator it = aVar.oPm.iterator();
        while (it.hasNext()) {
            b bVar2 = (b) it.next();
            if (bVar2.getType() != i) {
                bVar2 = bVar;
            }
            bVar = bVar2;
        }
        if (bVar != null) {
            aVar.oPm.remove(bVar);
        }
    }

    public static void a(d dVar) {
        a aVar = oPk;
        aVar.oPl = dVar;
        aVar.isReady = true;
    }

    public static void bIL() {
        a aVar = oPk;
        if (aVar.oPl != null) {
            aVar.oPl.aMK();
            aVar.oPl = null;
        }
        aVar.isReady = false;
    }

    public static d bIM() {
        return oPk.oPl;
    }

    public static LinkedList<f> a(HashSet<Integer> hashSet, Context context, com.tencent.mm.ui.f.f.b bVar, int i) {
        LinkedList<f> linkedList = new LinkedList();
        Iterator it = oPk.oPm.iterator();
        while (it.hasNext()) {
            b bVar2 = (b) it.next();
            if (hashSet.contains(Integer.valueOf(bVar2.getType()))) {
                linkedList.add(bVar2.a(context, bVar, i));
            }
        }
        return linkedList;
    }

    public static f a(int i, Context context, com.tencent.mm.ui.f.f.b bVar, int i2) {
        Iterator it = oPk.oPm.iterator();
        while (it.hasNext()) {
            b bVar2 = (b) it.next();
            if (bVar2.getType() == i) {
                return bVar2.a(context, bVar, i2);
            }
        }
        return null;
    }
}
