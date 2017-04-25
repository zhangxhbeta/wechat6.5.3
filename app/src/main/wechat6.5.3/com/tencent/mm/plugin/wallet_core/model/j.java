package com.tencent.mm.plugin.wallet_core.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public abstract class j<K> {
    Map<String, Integer> kOH = new HashMap();
    List<K> kOI = new LinkedList();
    public Vector<b> kOJ = new Vector();
    List<String> kOK = new LinkedList();

    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] kOL = new int[a.bfV().length];

        static {
            try {
                kOL[a.kOO - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                kOL[a.kON - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                kOL[a.kOM - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public enum a {
        ;

        static {
            kOM = 1;
            kON = 2;
            kOO = 3;
            kOP = new int[]{kOM, kON, kOO};
        }

        public static int[] bfV() {
            return (int[]) kOP.clone();
        }
    }

    public class b {
        public K kOQ;
        public int kOR;
        final /* synthetic */ j kOS;

        public b(j jVar) {
            this.kOS = jVar;
        }
    }

    public abstract String a(Vector<b> vector, int i);

    public final void c(List<K> list, List<K> list2, List<String> list3) {
        int i;
        this.kOK = list3;
        this.kOI = list2;
        this.kOJ.clear();
        this.kOJ = new Vector(list.size());
        for (i = 0; i < list.size(); i++) {
            b bVar = new b(this);
            Object obj = list.get(i);
            bVar.kOQ = obj;
            if (this.kOI.contains(obj)) {
                bVar.kOR = a.kON;
            } else {
                bVar.kOR = a.kOM;
            }
            this.kOJ.add(bVar);
        }
        this.kOH.clear();
        for (i = 0; i < list3.size(); i++) {
            this.kOH.put(list3.get(i), Integer.valueOf(0));
        }
        bfU();
    }

    public final void cJ(int i, int i2) {
        ((b) this.kOJ.get(i)).kOR = i2;
    }

    public final void bfU() {
        for (int i = 0; i < this.kOJ.size(); i++) {
            if (((b) this.kOJ.get(i)).kOR != a.kON) {
                String a = a(this.kOJ, i);
                if (!this.kOH.containsKey(a)) {
                    Object obj;
                    String[] Do = com.tencent.mm.plugin.wallet_core.ui.a.Do(a);
                    for (int i2 = 0; i2 < this.kOK.size(); i2++) {
                        for (CharSequence contains : Do) {
                            if (!((String) this.kOK.get(i2)).contains(contains)) {
                                obj = null;
                                break;
                            }
                        }
                        int i3 = 1;
                        if (obj != null) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        cJ(i, a.kOM);
                    }
                }
                cJ(i, a.kOO);
            }
        }
    }
}
