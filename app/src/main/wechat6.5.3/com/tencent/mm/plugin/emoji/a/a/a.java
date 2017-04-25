package com.tencent.mm.plugin.emoji.a.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ah;
import java.util.HashMap;

public abstract class a extends BaseAdapter {
    private final String TAG = "MicroMsg.BaseEmojiListAdapter";
    private final String cfX = "lock";
    private HashMap<String, com.tencent.mm.plugin.emoji.a.a> eZH;
    public AbsListView eZV;
    public c eZW;
    public com.tencent.mm.plugin.emoji.model.f.a eZX;
    protected volatile boolean eZY = false;
    private int eZZ = 0;
    private int faa = 0;
    public Context mContext;

    public abstract int aeI();

    public abstract int aeJ();

    public abstract int aeK();

    public abstract View b(int i, View view, ViewGroup viewGroup);

    public abstract com.tencent.mm.plugin.emoji.a.a c(Context context, View view);

    public abstract void jD(int i);

    public abstract void jE(int i);

    public abstract void jF(int i);

    public /* synthetic */ Object getItem(int i) {
        return jG(i);
    }

    public a(Context context) {
        this.mContext = context;
        if (this.mContext != null) {
            this.eZH = new HashMap();
        }
    }

    public final void a(c cVar) {
        if (cVar != null && this.eZW != cVar) {
            this.eZW = cVar.aeN();
            notifyDataSetChanged();
        }
    }

    public void aeH() {
        if (this.eZH != null) {
            this.eZH.clear();
        }
        super.notifyDataSetChanged();
        this.eZY = true;
    }

    public void notifyDataSetChanged() {
        Object[] objArr;
        int i;
        this.eZY = false;
        if (this.eZW != null) {
            this.eZW.notifyDataSetChanged();
            objArr = new Object[1];
            i = this.eZZ;
            this.eZZ = i + 1;
            objArr[0] = Integer.valueOf(i);
            v.d("MicroMsg.BaseEmojiListAdapter", "xxx data Notify: %d", objArr);
        }
        objArr = new Object[1];
        i = this.faa;
        this.faa = i + 1;
        objArr[0] = Integer.valueOf(i);
        v.v("MicroMsg.BaseEmojiListAdapter", "xxx ui Notify: %d", objArr);
        aeH();
    }

    public final void b(final e eVar) {
        ad.o(new Runnable(this) {
            final /* synthetic */ a fac;

            public final void run() {
                if (eVar != null) {
                    this.fac.eZW = this.fac.a(eVar);
                    this.fac.notifyDataSetChanged();
                }
            }
        });
    }

    public c a(e eVar) {
        return new c(eVar);
    }

    public int getCount() {
        return this.eZW == null ? 0 : this.eZW.size();
    }

    public f jG(int i) {
        return this.eZW == null ? null : this.eZW.jK(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        com.tencent.mm.plugin.emoji.a.a aVar = null;
        if (view != null) {
            aVar = (com.tencent.mm.plugin.emoji.a.a) view.getTag();
        }
        f jG = jG(i);
        if (aVar == null) {
            aVar = c(this.mContext, view);
            view = aVar.aeE();
            this.eZH.put(a(jG), aVar);
        } else if (!be.kS(a(jG))) {
            if (this.eZH.containsValue(aVar)) {
                this.eZH.remove(aVar.aex());
            }
            this.eZH.put(a(jG), aVar);
        }
        aVar.kB = i;
        aVar.eYF = jG;
        View b = b(i, view, viewGroup);
        aVar.aeD();
        return b;
    }

    public static String a(f fVar) {
        if (fVar == null) {
            return null;
        }
        if (fVar.fah == com.tencent.mm.plugin.emoji.a.a.f.a.faq) {
            return fVar.faj.aRI + "_cell";
        }
        return fVar.fai.mdM;
    }

    public void clear() {
        if (this.eZH != null) {
            this.eZH.clear();
            this.eZH = null;
        }
        if (this.eZW != null) {
            this.eZW.clear();
            this.eZW = null;
        }
        this.eZY = false;
    }

    public void an(String str, int i) {
        if (this.eZH != null && this.eZW != null && str != null) {
            f qY = this.eZW.qY(str);
            if (qY != null) {
                a(qY, str, i);
            }
            if (!(qY == null || this.eZW == null || qY.mStatus != -1)) {
                v.i("MicroMsg.BaseEmojiListAdapter", "force refresh status");
                qY.a(this.eZW.faf, this.eZW.rc(str), this.eZW.ra(str));
            }
            com.tencent.mm.plugin.emoji.a.a qX = qX(str);
            if (qX != null) {
                String aex = qX.aex() == null ? null : qX.aex();
                if (aex != null && aex.equals(str)) {
                    qX.aeD();
                }
            }
        }
    }

    public final com.tencent.mm.plugin.emoji.a.a qX(String str) {
        if (this.eZH == null) {
            return null;
        }
        return (com.tencent.mm.plugin.emoji.a.a) this.eZH.get(str);
    }

    public final void ao(String str, int i) {
        if (this.eZH != null && this.eZW != null && str != null) {
            f qY = this.eZW.qY(str);
            if (qY != null) {
                if (i >= 0 && i < 100) {
                    a(qY, str, 6);
                    qY.rT = i;
                }
                if (i >= 100) {
                    a(qY, str, 7);
                }
            }
            com.tencent.mm.plugin.emoji.a.a qX = qX(str);
            if (qX != null) {
                String aex = qX.aex() == null ? null : qX.aex();
                if (aex != null && aex.equals(str)) {
                    qX.aeD();
                }
            }
        }
    }

    public final void a(f fVar, String str, int i) {
        if (fVar != null && str != null) {
            fVar.dh(i);
            ah ahVar = (ah) this.eZW.fad.get(str);
            if (ahVar != null) {
                ahVar.ve(i);
            }
        }
    }

    public final void acO() {
        if (this.eZY) {
            super.notifyDataSetChanged();
        }
    }
}
