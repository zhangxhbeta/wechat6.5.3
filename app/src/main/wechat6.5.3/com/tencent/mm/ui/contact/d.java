package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.j;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.List;

public final class d extends j<u> {
    protected MMActivity aWn;
    b cHD = null;
    private b.b cHE = null;
    protected List<String> ejp = null;
    protected f euc;
    protected c eud;
    protected com.tencent.mm.ui.base.MMSlideDelView.d euf = MMSlideDelView.bCp();
    protected e hGa;
    com.tencent.mm.pluginsdk.ui.d lKh;
    protected String oDA = null;

    protected static class a {
        public MaskLayout eST;
        public TextView exG;
        public TextView gKV;
        public ViewGroup oFj;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        ak.yW();
        Object LS = com.tencent.mm.model.c.wH().LS(u.f(cursor));
        if (LS != null) {
            return LS;
        }
        u uVar = new u();
        uVar.b(cursor);
        ak.yW();
        com.tencent.mm.model.c.wH().K(uVar);
        return uVar;
    }

    public d(Context context, String str) {
        super(context, new u());
        this.aWn = (MMActivity) context;
        this.oDA = str;
        this.cHD = new b(new com.tencent.mm.ui.applet.b.a(this) {
            final /* synthetic */ d oFi;

            {
                this.oFi = r1;
            }

            public final Bitmap iG(String str) {
                return com.tencent.mm.u.b.a(str, false, -1);
            }
        });
    }

    public final void a(f fVar) {
        this.euc = fVar;
    }

    public final void a(e eVar) {
        this.hGa = eVar;
    }

    public final void a(c cVar) {
        this.eud = cVar;
    }

    public final int getCount() {
        return getCursor().getCount();
    }

    protected final void Om() {
        Ol();
    }

    public final synchronized void Ol() {
        ak.yW();
        Cursor c = com.tencent.mm.model.c.wH().c(this.oDA, SQLiteDatabase.KeyEmpty, this.ejp);
        avc();
        setCursor(c);
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.cHE == null) {
            this.cHE = new b.b(this) {
                final /* synthetic */ d oFi;

                {
                    this.oFi = r1;
                }

                public final String fo(int i) {
                    if (i < 0 || i >= this.oFi.getCount()) {
                        v.e("MicroMsg.ChatroomContactAdapter", "pos is invalid");
                        return null;
                    }
                    u uVar = (u) this.oFi.getItem(i);
                    return uVar == null ? null : uVar.field_username;
                }

                public final int EU() {
                    return this.oFi.getCount();
                }
            };
        }
        if (this.cHD != null) {
            this.cHD.a(i, this.cHE);
        }
        if (view == null) {
            view = View.inflate(this.aWn, 2130903272, null);
            a aVar2 = new a();
            aVar2.gKV = (TextView) view.findViewById(2131755332);
            aVar2.eST = (MaskLayout) view.findViewById(2131756021);
            aVar2.exG = (TextView) view.findViewById(2131756022);
            aVar2.oFj = (ViewGroup) view.findViewById(2131756020);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        u uVar = (u) getItem(i - 1);
        int i2 = uVar == null ? -1 : uVar.field_showHead;
        uVar = (u) getItem(i);
        if (i == 0) {
            CharSequence S = S(uVar);
            if (t.kS(S)) {
                v.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", uVar.field_username, Integer.valueOf(i));
                aVar.gKV.setVisibility(8);
            } else {
                aVar.gKV.setVisibility(0);
                aVar.gKV.setText(S);
                aVar.gKV.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            if (getItem(i + 1) == null) {
                aVar.oFj.setBackgroundResource(0);
            }
        } else if (i <= 0 || uVar.field_showHead == i2) {
            aVar.gKV.setVisibility(8);
            a(aVar, i, i2);
        } else {
            CharSequence S2 = S(uVar);
            aVar.oFj.setBackgroundResource(2130838046);
            if (t.kS(S2)) {
                v.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", uVar.field_username, Integer.valueOf(i));
                aVar.gKV.setVisibility(8);
            } else {
                aVar.gKV.setVisibility(0);
                aVar.gKV.setText(S2);
                if (uVar.field_showHead == 32) {
                    aVar.gKV.setCompoundDrawablesWithIntrinsicBounds(2130838660, 0, 0, 0);
                    aVar.gKV.setCompoundDrawablePadding(2);
                } else {
                    aVar.gKV.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
            }
            a(aVar, i, i2);
        }
        aVar.exG.setTextColor(com.tencent.mm.bd.a.M(this.aWn, !m.fn(uVar.field_username) ? 2131690159 : 2131690160));
        ImageView imageView = (ImageView) aVar.eST.view;
        com.tencent.mm.pluginsdk.ui.a.b.m(imageView, uVar.field_username);
        com.tencent.mm.pluginsdk.ui.a aVar3 = (com.tencent.mm.pluginsdk.ui.a) imageView.getDrawable();
        if (this.lKh != null) {
            this.lKh.a(aVar3);
        }
        aVar.eST.bCM();
        try {
            aVar.exG.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.aWn, l.er(uVar.field_username), (int) aVar.exG.getTextSize()));
        } catch (Exception e) {
            aVar.exG.setText(SQLiteDatabase.KeyEmpty);
        }
        return view;
    }

    private void a(a aVar, int i, int i2) {
        u uVar = (u) getItem(i + 1);
        if (uVar == null || !(uVar.field_showHead == i2 || t.kS(S(uVar)))) {
            aVar.oFj.setBackgroundResource(0);
        }
    }

    private String S(u uVar) {
        if (uVar.field_showHead == 31) {
            return SQLiteDatabase.KeyEmpty;
        }
        if (uVar.field_showHead == 43) {
            return this.aWn.getString(2131234604);
        }
        return String.valueOf((char) uVar.field_showHead);
    }
}
