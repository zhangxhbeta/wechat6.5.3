package com.tencent.mm.ui.voicesearch;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.c.arq;
import com.tencent.mm.protocal.c.ars;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.j;
import com.tencent.mm.ui.q;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class b extends j<u> implements e {
    private int aXx = 1;
    public com.tencent.mm.ui.applet.b cHD = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a(this) {
        final /* synthetic */ b oYO;

        {
            this.oYO = r1;
        }

        public final Bitmap iG(String str) {
            return com.tencent.mm.u.b.a(str, false, -1);
        }
    });
    private com.tencent.mm.ui.applet.b.b cHE = null;
    private Context context;
    private LinkedList<arq> cqE = new LinkedList();
    private ProgressDialog dwR = null;
    private List<String> ejp = null;
    public String oDA;
    private String oYI;
    private boolean oYJ = false;
    private u oYK = null;
    private boolean oYL = true;
    public boolean oYM = false;
    private boolean oYN = false;
    private String[] ohb;

    protected static class a {
        public CheckBox dua;
        public MaskLayout eST;
        public TextView exG;
        public TextView gKV;
        public TextView oIU;
        public ProgressBar oYQ;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        ak.yW();
        Object LS = c.wH().LS(u.f(cursor));
        if (LS != null) {
            return LS;
        }
        u uVar = new u();
        uVar.b(cursor);
        ak.yW();
        c.wH().K(uVar);
        return uVar;
    }

    public final /* synthetic */ Object getItem(int i) {
        return js(i);
    }

    public b(Context context, int i) {
        super(context, new u());
        this.context = context;
        this.aXx = i;
        this.oYK = new u();
        this.oYK.setUsername("_find_more_public_contact_");
        this.oYK.tw();
        this.oDA = "@micromsg.with.all.biz.qq.com";
    }

    public final void cB(final List<String> list) {
        R(new Runnable(this) {
            final /* synthetic */ b oYO;

            public final void run() {
                if (this.oYO.ejp == null) {
                    this.oYO.ejp = new ArrayList();
                }
                this.oYO.ejp.clear();
                this.oYO.ejp.addAll(list);
                this.oYO.ejp.add("officialaccounts");
                this.oYO.ejp.add("helper_entry");
            }
        });
    }

    public final void kn(boolean z) {
        this.oYM = z;
        if (z) {
            this.oYK.tw();
        }
    }

    public final void detach() {
        if (this.cHD != null) {
            this.cHD.detach();
            this.cHD = null;
        }
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public final int getItemViewType(int i) {
        if (this.aXx == 2) {
            return 2;
        }
        return yp(i) ? 1 : 0;
    }

    protected final int asv() {
        int i = 0;
        if (!this.oYJ) {
            return 0;
        }
        if (!this.oYK.isHidden()) {
            i = this.cqE.size();
        }
        return i + 1;
    }

    public final arq yo(int i) {
        try {
            v.d("MicroMsg.SearchResultAdapter", "position " + i + " size " + this.cqE.size() + "  " + (i - aij()));
            return (arq) this.cqE.get((i - aij()) - 1);
        } catch (Throwable e) {
            v.a("MicroMsg.SearchResultAdapter", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return null;
        }
    }

    public final u js(int i) {
        if (lB(i)) {
            return (u) asw();
        }
        return (u) super.getItem(i);
    }

    public final void ko(final boolean z) {
        R(new Runnable(this) {
            final /* synthetic */ b oYO;

            public final void run() {
                this.oYO.oYJ = z;
            }
        });
    }

    public final void PI(final String str) {
        R(new Runnable(this) {
            final /* synthetic */ b oYO;

            public final void run() {
                if (this.oYO.oYK.isHidden()) {
                    this.oYO.oYK.tx();
                    if (this.oYO.oYL) {
                        ak.vy().a(new y(str, 3), 0);
                        this.oYO.oYN = true;
                        return;
                    }
                    return;
                }
                this.oYO.oYK.tw();
            }
        });
    }

    public final boolean yp(int i) {
        if (this.oYJ) {
            int aij = aij();
            if (i == aij && i < aij + asv()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isEnabled(int i) {
        if (!yp(i) || ((this.cqE != null && this.cqE.size() != 0) || this.oYL)) {
            return true;
        }
        return false;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean lB = lB(i);
        boolean yp = yp(i);
        a aVar;
        a aVar2;
        String eJ;
        if (this.oYJ && lB) {
            if (view != null) {
                aVar = (a) view.getTag();
                if (yp && aVar.oYQ == null) {
                    view = null;
                }
            }
            if (view != null) {
                aVar2 = (a) view.getTag();
            } else if (yp) {
                view = View.inflate(this.context, 2130903407, null);
                aVar2 = new a();
                aVar2.exG = (TextView) view.findViewById(2131756022);
                aVar2.oYQ = (ProgressBar) view.findViewById(2131756436);
                view.setTag(aVar2);
            } else {
                view = View.inflate(this.context, 2130903416, null);
                aVar2 = new a();
                aVar2.gKV = (TextView) view.findViewById(2131755332);
                aVar2.eST = (MaskLayout) view.findViewById(2131756021);
                aVar2.exG = (TextView) view.findViewById(2131756022);
                aVar2.dua = (CheckBox) view.findViewById(2131756492);
                aVar2.oIU = (TextView) view.findViewById(2131756493);
                view.setTag(aVar2);
            }
            if (yp) {
                if (this.oYN) {
                    aVar2.oYQ.setVisibility(0);
                } else {
                    aVar2.oYQ.setVisibility(8);
                }
                v.d("MicroMsg.SearchResultAdapter", "refresh  " + this.oYL);
                if ((this.cqE == null || this.cqE.size() == 0) && !this.oYL) {
                    aVar2.exG.setText(this.context.getString(2131230862));
                    aVar2.exG.setTextColor(this.context.getResources().getColor(2131689817));
                    return view;
                }
                aVar2.exG.setText(this.context.getString(2131230863));
                aVar2.exG.setTextColor(com.tencent.mm.bd.a.M(this.context, 2131690159));
                return view;
            }
            if (this.cHE == null) {
                this.cHE = new com.tencent.mm.ui.applet.b.b(this) {
                    final /* synthetic */ b oYO;

                    {
                        this.oYO = r1;
                    }

                    public final String fo(int i) {
                        if (i < 0) {
                            v.e("MicroMsg.SearchResultAdapter", "pos is invalid");
                            return null;
                        }
                        arq yo = this.oYO.yo((this.oYO.aij() + i) + 1);
                        if (yo != null) {
                            return yo.moM.mQy;
                        }
                        return null;
                    }

                    public final int EU() {
                        return this.oYO.cqE == null ? 0 : this.oYO.cqE.size();
                    }
                };
            }
            if (this.cHD != null) {
                this.cHD.a((i - aij()) - 1, this.cHE);
            }
            arq yo = yo(i);
            aVar2.gKV.setVisibility(8);
            if (yo == null) {
                return view;
            }
            aVar2.oIU.setVisibility(8);
            com.tencent.mm.pluginsdk.ui.a.b.m((ImageView) aVar2.eST.view, yo.moM.mQy);
            if (yo.mFu == 0) {
                aVar2.eST.bCM();
            } else if (com.tencent.mm.model.ab.a.csb != null) {
                eJ = com.tencent.mm.model.ab.a.csb.eJ(yo.mFu);
                if (eJ != null) {
                    aVar2.eST.d(com.tencent.mm.modelbiz.j.hL(eJ), com.tencent.mm.ui.base.MaskLayout.a.nZN);
                } else {
                    aVar2.eST.bCM();
                }
            } else {
                aVar2.eST.bCM();
            }
            try {
                aVar2.exG.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.context, be.ma(yo.mEj.mQy), aVar2.exG.getTextSize()));
                return view;
            } catch (Throwable e) {
                v.a("MicroMsg.SearchResultAdapter", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                aVar2.exG.setText(SQLiteDatabase.KeyEmpty);
                return view;
            }
        } else if (this.aXx == 2) {
            if (view == null) {
                view = View.inflate(this.context, 2130904579, null);
                aVar2 = new a();
                aVar2.exG = (TextView) view.findViewById(2131756022);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            ab js = js(i);
            aVar.exG.setTextColor(com.tencent.mm.bd.a.M(this.context, 2131690159));
            try {
                aVar.exG.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.context, this.context.getString(2131235836, new Object[]{l.a(js, js.field_username)}), aVar.exG.getTextSize()));
            } catch (Exception e2) {
                aVar.exG.setText(SQLiteDatabase.KeyEmpty);
            }
            aVar.exG.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            return view;
        } else {
            View view2;
            View inflate;
            if (view != null) {
                aVar = (a) view.getTag();
                view2 = aVar == null ? null : view;
            } else {
                aVar = null;
                view2 = view;
            }
            if (view2 == null) {
                inflate = q.em(this.context).inflate(2130903416, null);
                aVar2 = new a();
                aVar2.gKV = (TextView) inflate.findViewById(2131755332);
                aVar2.eST = (MaskLayout) inflate.findViewById(2131756021);
                aVar2.exG = (TextView) inflate.findViewById(2131756022);
                aVar2.dua = (CheckBox) inflate.findViewById(2131756492);
                aVar2.oIU = (TextView) inflate.findViewById(2131756493);
                inflate.setTag(aVar2);
            } else {
                inflate = view2;
                aVar2 = aVar;
            }
            ab js2 = js(i);
            if (aVar2.gKV != null) {
                aVar2.gKV.setVisibility(8);
            }
            aVar2.exG.setTextColor(com.tencent.mm.bd.a.M(this.context, !m.fn(js2.field_username) ? 2131690159 : 2131690160));
            com.tencent.mm.pluginsdk.ui.a.b.m((ImageView) aVar2.eST.view, js2.field_username);
            aVar2.oIU.setVisibility(8);
            if (js2.field_verifyFlag == 0) {
                aVar2.eST.bCM();
            } else if (com.tencent.mm.model.ab.a.csb != null) {
                eJ = com.tencent.mm.model.ab.a.csb.eJ(js2.field_verifyFlag);
                if (eJ != null) {
                    aVar2.eST.d(com.tencent.mm.modelbiz.j.hL(eJ), com.tencent.mm.ui.base.MaskLayout.a.nZN);
                } else {
                    aVar2.eST.bCM();
                }
            } else {
                aVar2.eST.bCM();
            }
            try {
                aVar2.exG.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.context, l.a(js2, js2.field_username), aVar2.exG.getTextSize()));
            } catch (Exception e3) {
                aVar2.exG.setText(SQLiteDatabase.KeyEmpty);
            }
            return inflate;
        }
    }

    public final void Ol() {
        R(new Runnable(this) {
            final /* synthetic */ b oYO;

            {
                this.oYO = r1;
            }

            public final void run() {
                int i = 0;
                b bVar;
                if (this.oYO.ohb != null && this.oYO.ohb.length != 0) {
                    List arrayList = new ArrayList();
                    String[] g = this.oYO.ohb;
                    int length = g.length;
                    while (i < length) {
                        String str = g[i];
                        if (this.oYO.PJ(str)) {
                            arrayList.add(str);
                        }
                        i++;
                    }
                    if (arrayList.size() > 0) {
                        b bVar2 = this.oYO;
                        ak.yW();
                        bVar2.setCursor(c.wH().a((String[]) arrayList.toArray(new String[arrayList.size()]), this.oYO.oDA, this.oYO.ejp));
                        return;
                    }
                    bVar = this.oYO;
                    ak.yW();
                    bVar.setCursor(c.wH().bvF());
                } else if (this.oYO.oYI == null) {
                    bVar = this.oYO;
                    ak.yW();
                    bVar.setCursor(c.wH().bvF());
                } else if (this.oYO.oDA.equals("@all.chatroom.contact")) {
                    Cursor a = ak.yW().cqX.a(this.oYO.oYI, "@micromsg.with.all.biz.qq.com", this.oYO.ejp, false);
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    while (a.moveToNext()) {
                        String string = a.getString(a.getColumnIndex("username"));
                        if (string.endsWith("@chatroom")) {
                            arrayList3.add(string);
                        } else {
                            arrayList2.add(string);
                        }
                    }
                    if (!a.isClosed()) {
                        a.close();
                    }
                    if (arrayList2.size() == 0 && arrayList3.size() == 0) {
                        ak.yW();
                        a = c.wH().bvF();
                    } else {
                        a = ak.yW().cqX.a(this.oYO.oYI, arrayList2, null, arrayList3, this.oYO.ejp);
                    }
                    this.oYO.setCursor(a);
                } else {
                    this.oYO.setCursor(ak.yW().cqX.a(this.oYO.oYI, this.oYO.oDA, this.oYO.ejp, true));
                }
            }
        });
    }

    protected final void Om() {
        avc();
        Ol();
    }

    public final void onResume() {
        ak.vy().a((int) MMGIFException.D_GIF_ERR_NO_COLOR_MAP, (e) this);
    }

    public final void onPause() {
        ak.vy().b((int) MMGIFException.D_GIF_ERR_NO_COLOR_MAP, (e) this);
    }

    public final void cI(List<String> list) {
        this.ohb = (String[]) list.toArray(new String[list.size()]);
        this.oYI = null;
        avc();
        Ol();
    }

    public final void uU(String str) {
        String trim = str.trim();
        if (trim.startsWith("@")) {
            trim = trim.substring(1) + "%@micromsg.with.all.biz.qq.com";
        }
        v.d("MicroMsg.SearchResultAdapter", "translateQueryText [" + trim + "]");
        if (!(trim == null || trim.equals(this.oYI))) {
            R(new Runnable(this) {
                final /* synthetic */ b oYO;

                {
                    this.oYO = r1;
                }

                public final void run() {
                    this.oYO.oYL = true;
                    this.oYO.cqE.clear();
                }
            });
        }
        this.oYI = trim;
        this.ohb = null;
        if (this.oYI == null) {
            this.oYI = SQLiteDatabase.KeyEmpty;
        }
        avc();
        Ol();
    }

    public final void a(int i, int i2, String str, final k kVar) {
        v.d("MicroMsg.SearchResultAdapter", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() != MMGIFException.D_GIF_ERR_NO_COLOR_MAP) {
            v.e("MicroMsg.SearchResultAdapter", "error type");
            return;
        }
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        this.oYN = false;
        if (com.tencent.mm.ui.o.a.a(this.context, i, i2, str, 7)) {
            this.oYL = false;
        } else if (i == 4 && i2 == -4) {
            R(new Runnable(this) {
                final /* synthetic */ b oYO;

                {
                    this.oYO = r1;
                }

                public final void run() {
                    this.oYO.oYL = false;
                }
            });
        } else if (i == 0 && i2 == 0) {
            R(new Runnable(this) {
                final /* synthetic */ b oYO;

                public final void run() {
                    ars Jx = ((y) kVar).Jx();
                    v.d("MicroMsg.SearchResultAdapter", "count " + Jx.mxP);
                    if (Jx.mxP > 0) {
                        for (arq com_tencent_mm_protocal_c_arq : Jx.mxQ) {
                            if (m.eG(com_tencent_mm_protocal_c_arq.mFu)) {
                                if (this.oYO.cqE == null) {
                                    this.oYO.cqE = new LinkedList();
                                }
                                this.oYO.cqE.add(com_tencent_mm_protocal_c_arq);
                            }
                        }
                    } else {
                        String a = com.tencent.mm.platformtools.m.a(Jx.moM);
                        v.d("MicroMsg.SearchResultAdapter", "user " + a);
                        if (be.ma(a).length() > 0) {
                            arq com_tencent_mm_protocal_c_arq2 = new arq();
                            com_tencent_mm_protocal_c_arq2.moM = Jx.moM;
                            com_tencent_mm_protocal_c_arq2.mFu = Jx.mFu;
                            com_tencent_mm_protocal_c_arq2.cHf = Jx.cHf;
                            com_tencent_mm_protocal_c_arq2.mEj = Jx.mEj;
                            com_tencent_mm_protocal_c_arq2.cHh = Jx.cHh;
                            com_tencent_mm_protocal_c_arq2.cHl = Jx.cHl;
                            com_tencent_mm_protocal_c_arq2.cHe = Jx.cHe;
                            com_tencent_mm_protocal_c_arq2.cHd = Jx.cHd;
                            com_tencent_mm_protocal_c_arq2.cHc = Jx.cHc;
                            com_tencent_mm_protocal_c_arq2.mFv = Jx.mFv;
                            com_tencent_mm_protocal_c_arq2.mFy = Jx.mFy;
                            com_tencent_mm_protocal_c_arq2.mFw = Jx.mFw;
                            com_tencent_mm_protocal_c_arq2.mFx = Jx.mFx;
                            com_tencent_mm_protocal_c_arq2.mFA = Jx.mFA;
                            n.AX().g(a, com.tencent.mm.platformtools.m.a(Jx.mbY));
                            if (this.oYO.cqE == null) {
                                this.oYO.cqE = new LinkedList();
                            }
                            this.oYO.cqE.clear();
                            if (m.eG(com_tencent_mm_protocal_c_arq2.mFu)) {
                                this.oYO.cqE.add(com_tencent_mm_protocal_c_arq2);
                            }
                            v.d("MicroMsg.SearchResultAdapter", "count " + this.oYO.cqE.size());
                        }
                    }
                    this.oYO.oYL = false;
                }
            });
        } else {
            R(new Runnable(this) {
                final /* synthetic */ b oYO;

                {
                    this.oYO = r1;
                }

                public final void run() {
                    this.oYO.oYL = false;
                }
            });
        }
    }

    private void R(final Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            notifyDataSetChanged();
            return;
        }
        ad.o(new Runnable(this) {
            final /* synthetic */ b oYO;

            public final void run() {
                runnable.run();
                this.oYO.notifyDataSetChanged();
            }
        });
    }

    public final boolean PJ(String str) {
        if (!(this.ejp == null || str == null)) {
            for (String equals : this.ejp) {
                if (equals.equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }
}
