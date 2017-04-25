package com.tencent.mm.plugin.emoji.ui.smiley;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.a.c.d;
import com.tencent.mm.ae.a.c.e;
import com.tencent.mm.e.a.bv;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.emoji.d.o;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.q;
import java.util.ArrayList;

public final class c extends a {
    private d fhn = new d(this) {
        final /* synthetic */ c fkB;

        {
            this.fkB = r1;
        }

        public final byte[] f(Object... objArr) {
            if (objArr != null && objArr.length > 0) {
                Object obj = objArr[0];
                if (obj != null && (obj instanceof com.tencent.mm.storage.a.c)) {
                    return com.tencent.mm.pluginsdk.j.a.bmr().g((com.tencent.mm.storage.a.c) obj);
                }
            }
            return null;
        }
    };
    ArrayList<com.tencent.mm.storage.a.c> fjj;
    private e fkA = new e(this) {
        final /* synthetic */ c fkB;

        {
            this.fkB = r1;
        }

        public final void e(Object... objArr) {
            if (objArr != null && objArr.length > 0) {
                Object obj = objArr[0];
                if (obj != null && (obj instanceof com.tencent.mm.storage.a.c)) {
                    bv bvVar = new bv();
                    bvVar.aZp.scene = 1;
                    bvVar.aZp.aZq = (com.tencent.mm.storage.a.c) obj;
                    bvVar.aZp.context = this.fkB.mContext;
                    com.tencent.mm.sdk.c.a.nhr.z(bvVar);
                }
            }
        }
    };

    class a {
        TextView dtZ;
        ImageView eZn;
        final /* synthetic */ c fkB;
        TextView fkC;

        public a(c cVar, View view) {
            this.fkB = cVar;
            this.eZn = (ImageView) view.findViewById(2131759213);
            this.dtZ = (TextView) view.findViewById(2131759214);
            this.fkC = (TextView) view.findViewById(2131759215);
            this.fkC.setTextSize(1, 12.0f);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return jP(i);
    }

    public c(Context context, f fVar) {
        super(context, fVar);
    }

    public final int getCount() {
        if (this.fkv != this.fku - 1) {
            return this.dWc;
        }
        int i = this.exY - (this.fkv * this.dWc);
        if (i < 0) {
            return 0;
        }
        return i;
    }

    private com.tencent.mm.storage.a.c jP(int i) {
        int i2 = (this.fkv * this.dWc) + i;
        if (this.fkt == 25) {
            i2--;
        }
        if (this.fjj == null || i2 < 0 || i2 >= this.fjj.size()) {
            return null;
        }
        return (com.tencent.mm.storage.a.c) this.fjj.get(i2);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = q.em(this.mContext).inflate(2130904408, null);
            view.setLayoutParams(new LayoutParams(this.fks.getColumnWidth(), this.fks.flT));
            a aVar2 = new a(this, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (this.fkt == 25 && this.fkv == 0 && i == 0) {
            g.afq().a("", aVar.eZn);
            aVar.eZn.setBackgroundResource(2130837662);
            aVar.eZn.setImageResource(2131165281);
            if (g.afx().fch.iC(false) <= o.afk()) {
                ak.yW();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    aVar.fkC.setVisibility(8);
                }
            }
            aVar.fkC.setVisibility(0);
            aVar.fkC.setText(2131232350);
        } else {
            aVar.fkC.setVisibility(8);
            com.tencent.mm.storage.a.c jP = jP(i);
            if (jP == null) {
                v.w("MicroMsg.smiley.EmojiSmileyAdapter", "emoji is null.");
                aVar.eZn.setVisibility(8);
                aVar.dtZ.setVisibility(8);
                g.afq().a("", aVar.eZn);
            } else {
                aVar.eZn.setVisibility(0);
                CharSequence rk = com.tencent.mm.pluginsdk.j.a.bmr().rk(jP.EB());
                if (be.kS(rk) || this.fkt != 23) {
                    aVar.dtZ.setVisibility(8);
                } else {
                    aVar.dtZ.setText(rk);
                    aVar.dtZ.setVisibility(0);
                }
                aVar.eZn.setBackgroundResource(2130839193);
                String name;
                com.tencent.mm.ae.a.a afq;
                ImageView imageView;
                com.tencent.mm.ae.a.a.c.a aVar3;
                String dR;
                String str;
                com.tencent.mm.ae.a.a.c.a aVar4;
                if (this.fkt == 25) {
                    if (jP.field_catalog == com.tencent.mm.storage.a.a.nwK || jP.field_catalog == com.tencent.mm.storage.a.c.nwQ || jP.field_catalog == com.tencent.mm.storage.a.c.nwP) {
                        name = jP.getName();
                        if (be.kS(name)) {
                            v.i("MicroMsg.smiley.EmojiSmileyAdapter", "name is null");
                        } else {
                            name = name.replaceAll(".png", "");
                            afq = g.afq();
                            imageView = aVar.eZn;
                            aVar3 = new com.tencent.mm.ae.a.a.c.a();
                            aVar3.cPx = 3;
                            aVar3.cPL = 2130839193;
                            afq.a(name, imageView, aVar3.GU());
                        }
                    } else {
                        dR = jP.dR(jP.field_groupId, jP.EB());
                        str = dR + "_cover";
                        aVar4 = new com.tencent.mm.ae.a.a.c.a();
                        aVar4.cPx = 1;
                        aVar4.cPL = 2130839193;
                        aVar4.cPE = true;
                        aVar4.bdZ = str;
                        aVar4.cPu = dR;
                        aVar4.cPF = true;
                        aVar4.cPT = new Object[]{jP};
                        g.afq().a(dR, aVar.eZn, aVar4.GU(), this.fkA, this.fhn);
                    }
                } else if (!jP.field_groupId.equalsIgnoreCase(String.valueOf(com.tencent.mm.storage.a.a.nwJ))) {
                    dR = jP.dR(jP.field_groupId, jP.EB());
                    str = dR + "_cover";
                    aVar4 = new com.tencent.mm.ae.a.a.c.a();
                    aVar4.cPx = 1;
                    aVar4.cPL = 2130839193;
                    aVar4.cPE = true;
                    aVar4.bdZ = str;
                    aVar4.cPu = dR;
                    aVar4.cPF = true;
                    aVar4.cPT = new Object[]{jP};
                    g.afq().a(dR, aVar.eZn, aVar4.GU(), this.fkA, this.fhn);
                } else if (be.kS(jP.getName())) {
                    v.i("MicroMsg.smiley.EmojiSmileyAdapter", "name is null");
                } else {
                    name = (be.kS(jP.pO()) ? jP.getName() : jP.pO()).replaceAll(".png", "");
                    afq = g.afq();
                    imageView = aVar.eZn;
                    aVar3 = new com.tencent.mm.ae.a.a.c.a();
                    aVar3.cPx = 3;
                    aVar3.cPL = 2130839193;
                    afq.a(name, imageView, aVar3.GU());
                }
            }
        }
        return view;
    }
}
