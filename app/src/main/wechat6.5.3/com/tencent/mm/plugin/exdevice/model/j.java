package com.tencent.mm.plugin.exdevice.model;

import android.util.SparseArray;
import java.util.LinkedList;
import java.util.List;

public final class j {
    private static j fur;
    private SparseArray<List<a>> fus = new SparseArray();

    public interface a {
        void e(int i, Object... objArr);
    }

    private j() {
    }

    public static j ajh() {
        if (fur == null) {
            fur = new j();
        }
        return fur;
    }

    public final boolean a(int i, a aVar) {
        if (aVar == null) {
            return false;
        }
        List list = (List) this.fus.get(i);
        if (list == null) {
            list = new LinkedList();
            this.fus.put(i, list);
        } else if (list.contains(aVar)) {
            return false;
        }
        return list.add(aVar);
    }

    public final boolean b(int i, a aVar) {
        List list = (List) this.fus.get(i);
        if (list != null) {
            list.remove(aVar);
            if (list.size() == 0) {
                this.fus.remove(i);
            }
        }
        return false;
    }

    public final void f(int i, Object... objArr) {
        List list = (List) this.fus.get(i);
        if (list != null && list.size() != 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ((a) list.get(i2)).e(i, objArr);
            }
        }
    }
}
