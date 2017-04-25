package com.tencent.mm.plugin.favorite.b;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.c.qk;
import com.tencent.mm.protocal.c.ql;
import com.tencent.mm.protocal.c.qm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class r {
    public HashMap<String, WeakReference<a>> cJv = new HashMap();
    public qm fKR = new qm();
    private HashSet<Integer> fKS = new HashSet();
    private boolean fKT = true;
    private List<qk> fKU = new LinkedList();

    public interface a {
        void alK();

        void alL();
    }

    public r() {
        ak.yW();
        try {
            this.fKR.az(be.KG((String) c.vf().get(225283, "")));
        } catch (Throwable e) {
            v.a("MicroMsg.FavTagSetMgr", e, "", new Object[0]);
            v.w("MicroMsg.FavTagSetMgr", "init tag info set fail, %s", new Object[]{e.getMessage()});
            this.fKR = new qm();
        }
        v.i("MicroMsg.FavTagSetMgr", "tag:\n%s", new Object[]{this.fKR.mtZ});
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.cJv.put(aVar.toString(), new WeakReference(aVar));
        }
    }

    private void cV(boolean z) {
        for (WeakReference weakReference : this.cJv.values()) {
            if (!(weakReference == null || weakReference.get() == null)) {
                if (z) {
                    ((a) weakReference.get()).alK();
                } else {
                    ((a) weakReference.get()).alL();
                }
            }
        }
    }

    private void save() {
        byte[] toByteArray;
        try {
            toByteArray = this.fKR.toByteArray();
        } catch (Throwable e) {
            v.a("MicroMsg.FavTagSetMgr", e, "", new Object[0]);
            v.w("MicroMsg.FavTagSetMgr", "save tag info set fail, %s", new Object[]{e.getMessage()});
            toByteArray = null;
        }
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ r fKW;

            public final void run() {
                String bn = be.bn(toByteArray);
                ak.yW();
                c.vf().set(225283, bn);
            }

            public final String toString() {
                return super.toString() + "|save";
            }
        });
        this.fKT = true;
    }

    public final List<qk> kE(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        if (this.fKT) {
            v.w("MicroMsg.FavTagSetMgr", "want get tag list, it is dirty, reload data");
            this.fKU.clear();
            Iterator it = this.fKR.mtZ.iterator();
            while (it.hasNext()) {
                this.fKU.addAll(((ql) it.next()).mtY);
            }
            this.fKT = false;
        }
        return this.fKU;
    }

    public final int alJ() {
        Iterator it = this.fKR.mtZ.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = ((ql) it.next()).mtY.size() + i;
        }
        return i;
    }

    public final void sS(final String str) {
        if (!be.kS(str)) {
            if (this.fKS.contains(Integer.valueOf(str.hashCode()))) {
                v.d("MicroMsg.FavTagSetMgr", "has add tag %s", new Object[]{str});
                return;
            }
            this.fKS.add(Integer.valueOf(str.hashCode()));
            if (Looper.myLooper() != Looper.getMainLooper()) {
                v.d("MicroMsg.FavTagSetMgr", "add tag %s, post", new Object[]{str});
                ad.o(new Runnable(this) {
                    final /* synthetic */ r fKW;

                    public final void run() {
                        this.fKW.sT(str);
                    }
                });
                return;
            }
            v.d("MicroMsg.FavTagSetMgr", "add tag %s", new Object[]{str});
            sT(str);
        }
    }

    final void sT(String str) {
        int i;
        ql qlVar;
        ql qlVar2;
        qk qkVar;
        int i2 = 0;
        String lT = com.tencent.mm.platformtools.c.lT(str.toLowerCase());
        if (lT == null || lT.length() <= 0) {
            i = 35;
        } else {
            i = lT.charAt(0);
        }
        Iterator it = this.fKR.mtZ.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            qlVar = (ql) it.next();
            if (qlVar.mtX == i) {
                break;
            } else if (qlVar.mtX > i) {
                qlVar = new ql();
                qlVar.mtX = i;
                this.fKR.mtZ.add(i3, qlVar);
                break;
            } else {
                i3++;
            }
        }
        qlVar = null;
        if (qlVar == null) {
            qlVar = new ql();
            qlVar.mtX = i;
            this.fKR.mtZ.add(qlVar);
            qlVar2 = qlVar;
        } else {
            qlVar2 = qlVar;
        }
        Iterator it2 = qlVar2.mtY.iterator();
        while (it2.hasNext()) {
            int compareTo;
            qkVar = (qk) it2.next();
            i3 = qkVar.mtW.compareTo(lT);
            if (i3 == 0) {
                compareTo = qkVar.lnP.compareTo(str);
            } else {
                compareTo = i3;
            }
            if (compareTo != 0) {
                if (compareTo > 0) {
                    qkVar = new qk();
                    qkVar.lnP = str;
                    qkVar.mtW = lT;
                    qlVar2.mtY.add(i2, qkVar);
                    save();
                    cV(true);
                    return;
                }
                i2++;
            } else {
                return;
            }
        }
        qkVar = new qk();
        qkVar.lnP = str;
        qkVar.mtW = lT;
        qlVar2.mtY.add(qkVar);
        cV(true);
        save();
    }

    public final void i(i iVar) {
        if (iVar != null) {
            for (String removeTag : iVar.field_tagProto.mub) {
                removeTag(removeTag);
            }
        }
    }

    public final void d(Set<String> set) {
        if (set != null && !set.isEmpty()) {
            v.d("MicroMsg.FavTagSetMgr", "do remove tags: %s", new Object[]{set});
            for (String removeTag : set) {
                removeTag(removeTag);
            }
        }
    }

    private void removeTag(final String str) {
        if (!be.kS(str)) {
            this.fKS.remove(Integer.valueOf(str.hashCode()));
            if (Looper.myLooper() != Looper.getMainLooper()) {
                v.d("MicroMsg.FavTagSetMgr", "remove tag %s, post", new Object[]{str});
                ad.o(new Runnable(this) {
                    final /* synthetic */ r fKW;

                    public final void run() {
                        this.fKW.sU(str);
                    }
                });
                return;
            }
            v.d("MicroMsg.FavTagSetMgr", "remove tag %s", new Object[]{str});
            sU(str);
        }
    }

    final void sU(String str) {
        char c;
        ql qlVar;
        String lT = com.tencent.mm.platformtools.c.lT(str.toLowerCase());
        if (lT == null || lT.length() <= 0) {
            c = '#';
        } else {
            c = lT.charAt(0);
        }
        Iterator it = this.fKR.mtZ.iterator();
        int i = 0;
        while (it.hasNext()) {
            ql qlVar2 = (ql) it.next();
            if (qlVar2.mtX == c) {
                qlVar = qlVar2;
                break;
            } else if (qlVar2.mtX <= c) {
                i++;
            } else {
                return;
            }
        }
        qlVar = null;
        if (qlVar != null) {
            Iterator it2 = qlVar.mtY.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                qk qkVar = (qk) it2.next();
                int compareTo = qkVar.mtW.compareTo(lT);
                if (compareTo == 0) {
                    compareTo = qkVar.lnP.compareTo(str);
                }
                if (compareTo == 0) {
                    int i3;
                    n alt = h.alt();
                    String str2 = qkVar.lnP;
                    if (!be.kS(str2)) {
                        v.d("MicroMsg.FavSearchStorage", "is tag exist sql {%s}", new Object[]{"select count(localId) from FavSearchInfo where tagContent like '%" + str2 + "%'"});
                        Cursor rawQuery = alt.cie.rawQuery(str2, null);
                        if (rawQuery == null || !rawQuery.moveToFirst()) {
                            i3 = 0;
                        } else {
                            i3 = rawQuery.getInt(0);
                        }
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        if (i3 > 0) {
                            i3 = 1;
                            if (i3 == 0) {
                                qlVar.mtY.remove(i2);
                                if (qlVar.mtY.isEmpty()) {
                                    this.fKR.mtZ.remove(i);
                                }
                                cV(false);
                                save();
                                return;
                            }
                            return;
                        }
                    }
                    boolean z = false;
                    if (i3 == 0) {
                        qlVar.mtY.remove(i2);
                        if (qlVar.mtY.isEmpty()) {
                            this.fKR.mtZ.remove(i);
                        }
                        cV(false);
                        save();
                        return;
                    }
                    return;
                } else if (compareTo <= 0) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }
}
