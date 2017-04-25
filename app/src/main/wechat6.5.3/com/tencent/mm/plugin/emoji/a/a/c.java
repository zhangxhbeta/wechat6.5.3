package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.mm.model.k;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.storage.ah;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class c implements Cloneable, Iterable<f> {
    HashMap<String, ah> fad;
    protected HashMap<String, ah> fae;
    public boolean faf;
    protected ArrayList<f> mItemList;

    private class a implements Iterator<f> {
        final /* synthetic */ c fag;
        private int mIndex;

        private a(c cVar) {
            this.fag = cVar;
            this.mIndex = 0;
        }

        public final /* synthetic */ Object next() {
            c cVar = this.fag;
            int i = this.mIndex;
            this.mIndex = i + 1;
            return cVar.jK(i);
        }

        public final boolean hasNext() {
            return this.mIndex < this.fag.size();
        }

        public final void remove() {
        }
    }

    public /* synthetic */ Object clone() {
        return aeN();
    }

    public void clear() {
        if (this.mItemList != null) {
            this.mItemList.clear();
            this.mItemList = null;
        }
        if (this.fad != null) {
            this.fad.clear();
            this.fad = null;
        }
        if (this.fae != null) {
            this.fae.clear();
            this.fae = null;
        }
    }

    public c(e eVar) {
        this(eVar == null ? null : eVar.fcT);
    }

    public c() {
        this.fad = new HashMap();
        this.fae = new HashMap();
        this.faf = k.xS();
    }

    public c(List<f> list) {
        this();
        if (list != null) {
            this.mItemList = new ArrayList();
            this.mItemList.addAll(list);
        }
    }

    public final int size() {
        return this.mItemList == null ? 0 : this.mItemList.size();
    }

    public final f jK(int i) {
        if (this.mItemList == null || this.mItemList.size() <= i || i < 0 || this.mItemList == null) {
            return null;
        }
        return (f) this.mItemList.get(i);
    }

    public final f qY(String str) {
        if (this.mItemList != null) {
            Iterator it = this.mItemList.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                ol olVar = fVar.fai;
                if (olVar != null && olVar.mdM != null && olVar.mdM.equals(str)) {
                    return fVar;
                }
            }
        }
        return null;
    }

    public final c aeN() {
        try {
            c cVar = (c) super.clone();
            try {
                if (this.mItemList == null) {
                    return cVar;
                }
                cVar.mItemList = (ArrayList) this.mItemList.clone();
                return cVar;
            } catch (CloneNotSupportedException e) {
                return cVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public void notifyDataSetChanged() {
        if (this.mItemList != null) {
            this.fae = g.afx().fci.bxs();
            Iterator it = this.mItemList.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                ol olVar = fVar.fai;
                if (olVar != null) {
                    if (com.tencent.mm.plugin.emoji.h.a.d(olVar)) {
                        fVar.dh(com.tencent.mm.plugin.emoji.h.a.agV() ? 7 : 3);
                    } else {
                        String str = olVar.mdM;
                        fVar.a(this.faf, rc(str), ra(str));
                    }
                }
            }
            aeO();
        }
    }

    public final void qZ(String str) {
        f qY = qY(str);
        if (qY != null) {
            qY.dh(-1);
            qY.a(this.faf, rc(str), ra(str));
        }
    }

    public final boolean ra(String str) {
        return this.fae == null ? false : this.fae.containsKey(str);
    }

    public final ah rb(String str) {
        ah rc = rc(str);
        if (rc != null) {
            return rc;
        }
        rc = new ah(str);
        this.fad.put(str, rc);
        return rc;
    }

    public final ah rc(String str) {
        return (ah) this.fad.get(str);
    }

    public Iterator<f> iterator() {
        return new a();
    }

    public void aeO() {
        if (this.mItemList != null && g.afz().fcR != null) {
            Iterator it = this.mItemList.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                ol olVar = fVar.fai;
                if (olVar != null) {
                    Integer num = (Integer) g.afz().fcR.get(olVar.mdM);
                    int intValue = num == null ? -1 : num.intValue();
                    if (intValue >= 0) {
                        fVar.dh(6);
                        fVar.rT = intValue;
                    }
                    if (intValue < 0 && fVar.mStatus == 6) {
                        fVar.dh(3);
                    }
                }
            }
        }
    }
}
