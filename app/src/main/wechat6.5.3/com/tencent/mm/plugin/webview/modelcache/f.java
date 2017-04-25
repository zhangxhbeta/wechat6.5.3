package com.tencent.mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.be;
import java.util.LinkedList;
import java.util.List;

public final class f {
    private final SparseArray<b<a>> lfz = new SparseArray();

    private static final class a {
        public final String appId;
        public final String bsI;
        public final String bsJ;
        public final int bsK;
        public final int key;
        public final int lfA;
        public final int lfB;
        public final String lfC;

        private a(int i, int i2, int i3, String str, String str2, String str3, String str4) {
            this.lfA = i;
            this.lfB = i2;
            this.bsK = i3;
            this.appId = str;
            this.bsI = str2;
            this.bsJ = str3;
            this.lfC = str4;
            this.key = String.format("%d_%d_%s_%s_%s_%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2, str3, str4}).hashCode();
        }
    }

    private static final class b<T> {
        final byte[] cGJ = new byte[0];
        final SparseArray<T> lfD = new SparseArray();

        public final T valueAt(int i) {
            return this.lfD.valueAt(i);
        }

        public final void remove(int i) {
            this.lfD.remove(i);
        }
    }

    public static final class c {
        public final int lfA;
        public final int lfB;

        public c(int i, int i2) {
            this.lfB = i;
            this.lfA = i2;
        }
    }

    public final void a(i iVar, int i, int i2) {
        b bVar;
        String str = iVar.field_appId;
        String str2 = iVar.field_domain;
        String str3 = iVar.field_packageId;
        int i3 = iVar.field_cacheType;
        String str4 = iVar.field_url;
        synchronized (this.lfz) {
            b bVar2 = (b) this.lfz.get(i);
            if (bVar2 == null) {
                bVar2 = new b();
                this.lfz.put(i, bVar2);
                bVar = bVar2;
            } else {
                bVar = bVar2;
            }
        }
        a aVar = new a(i, i2, i3, str, str2, str3, str4);
        synchronized (bVar.cGJ) {
            bVar.lfD.put(aVar.key, aVar);
        }
    }

    public final boolean sI(int i) {
        synchronized (this.lfz) {
            b bVar = (b) this.lfz.get(i);
            this.lfz.remove(i);
        }
        if (bVar != null) {
            synchronized (bVar.cGJ) {
                bVar.lfD.clear();
            }
        }
        return true;
    }

    public final boolean a(int i, String str, String str2, String str3, int i2) {
        if (be.kS(str) || be.kS(str2) || be.kS(str3) || (i2 != 2 && i2 != 1 && i2 != 3)) {
            return false;
        }
        synchronized (this.lfz) {
            b bVar = (b) this.lfz.get(i);
        }
        if (bVar == null) {
            return true;
        }
        synchronized (bVar.cGJ) {
            if (bVar.lfD.size() == 0) {
                return true;
            }
            List<Integer> linkedList = new LinkedList();
            for (int i3 = 0; i3 < bVar.lfD.size(); i3++) {
                a aVar = (a) bVar.valueAt(i3);
                if (be.ma(aVar.appId).equals(str) && be.ma(aVar.bsI).equals(str2) && be.ma(aVar.bsJ).equals(str3) && aVar.bsK == i2) {
                    linkedList.add(Integer.valueOf(aVar.key));
                }
            }
            for (Integer intValue : linkedList) {
                bVar.remove(intValue.intValue());
            }
            return true;
        }
    }

    public final boolean a(int i, String str, String str2, String str3, int i2, String str4) {
        if (be.kS(str) || be.kS(str2) || be.kS(str3) || be.kS(str4) || (i2 != 2 && i2 != 1 && i2 != 3)) {
            return false;
        }
        synchronized (this.lfz) {
            b bVar = (b) this.lfz.get(i);
        }
        if (bVar == null) {
            return true;
        }
        synchronized (bVar.cGJ) {
            if (bVar.lfD.size() == 0) {
                return true;
            }
            List<Integer> linkedList = new LinkedList();
            for (int i3 = 0; i3 < bVar.lfD.size(); i3++) {
                a aVar = (a) bVar.valueAt(i3);
                if (be.ma(aVar.appId).equals(str) && be.ma(aVar.bsI).equals(str2) && be.ma(aVar.bsJ).equals(str3) && be.ma(aVar.lfC).equals(str4) && aVar.bsK == i2) {
                    linkedList.add(Integer.valueOf(aVar.key));
                }
            }
            for (Integer intValue : linkedList) {
                bVar.remove(intValue.intValue());
            }
            return true;
        }
    }

    public final List<c> k(String str, String str2, String str3, String str4) {
        if (be.kS(str) || be.kS(str2) || be.kS(str3) || be.kS(str4)) {
            return null;
        }
        String Eo = v.Eo(str);
        if (be.kS(Eo)) {
            return null;
        }
        List<c> linkedList = new LinkedList();
        synchronized (this.lfz) {
            for (int i = 0; i < this.lfz.size(); i++) {
                b bVar = (b) this.lfz.valueAt(i);
                if (bVar != null) {
                    synchronized (bVar.cGJ) {
                        for (int i2 = 0; i2 < bVar.lfD.size(); i2++) {
                            a aVar = (a) bVar.valueAt(i2);
                            if (be.ma(aVar.lfC).equals(Eo) && be.ma(aVar.appId).equals(str2) && be.ma(aVar.bsI).equals(str3) && be.ma(aVar.bsJ).equals(str4)) {
                                linkedList.add(new c(aVar.lfB, aVar.lfA));
                            }
                        }
                    }
                }
            }
        }
        return linkedList;
    }
}
