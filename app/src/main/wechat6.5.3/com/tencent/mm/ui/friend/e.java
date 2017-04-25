package com.tencent.mm.ui.friend;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.a.o;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.ag;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;

public final class e extends d {
    private final int NW;
    private final MMActivity aWn;
    private String dxb;
    private final a oOn;
    private final c oOo;
    private com.tencent.mm.ui.friend.d.a oOp;
    boolean oOq = false;
    private a oOr = new a(this) {
        final /* synthetic */ e oOs;

        {
            this.oOs = r1;
        }

        public final void d(int i, String str, int i2) {
            v.d("MicroMsg.QQFriendAdapter", "[cpan] postion:%d qq:%s status:%d", Integer.valueOf(i), str, Integer.valueOf(i2));
            af afVar = (af) this.oOs.getItem(i);
            if (afVar == null) {
                v.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend is null. qq:%s", str);
            } else if (be.kS(afVar.getUsername())) {
                v.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend username is null. qq:%s", str);
            } else {
                v.d("MicroMsg.QQFriendAdapter", "qq friend:%s", afVar.toString());
                if (afVar.cIB == 0) {
                    int[] iArr = new int[]{o.ba(afVar.cIA)};
                    g gVar = new g(this.oOs.aWn, new com.tencent.mm.ui.friend.g.a(this) {
                        final /* synthetic */ AnonymousClass1 oOt;

                        {
                            this.oOt = r1;
                        }

                        public final void j(boolean z, String str) {
                            af ae = ah.FQ().ae((long) o.ba(str));
                            if (ae != null) {
                                ae.cyA = 2;
                                v.d("MicroMsg.QQFriendAdapter", "qq friend onSendInviteEmail:%s", ae.toString());
                                ah.FQ().a(ae.cIA, ae);
                                this.oOt.oOs.Ol();
                                return;
                            }
                            v.w("MicroMsg.QQFriendAdapter", "cpan qq friedn is null. qq:%s", ae);
                        }
                    }, (byte) 0);
                    gVar.t(iArr);
                    gVar.lJm = afVar.cIA;
                    afVar.cyA = 1;
                    ah.FQ().a(afVar.cIA, afVar);
                    this.oOs.Ol();
                } else if (afVar.cIB == 1) {
                    com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.oOs.aWn, new com.tencent.mm.pluginsdk.ui.applet.a.a(this) {
                        final /* synthetic */ AnonymousClass1 oOt;

                        {
                            this.oOt = r1;
                        }

                        public final void a(boolean z, boolean z2, String str, String str2) {
                            v.i("MicroMsg.QQFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", Boolean.valueOf(z), Boolean.valueOf(z2), str, str2);
                            long longValue = new o(o.ba(str2)).longValue();
                            af ae = ah.FQ().ae(longValue);
                            if (ae != null && z) {
                                ae.username = str;
                            }
                            if (ae != null) {
                                ae.cyA = 2;
                                v.d("MicroMsg.QQFriendAdapter", "f :%s", ae.toString());
                                ah.FQ().a(longValue, ae);
                                this.oOt.oOs.Ol();
                            } else {
                                v.w("MicroMsg.QQFriendAdapter", "cpan qq friend is null. qq:%s", str2);
                            }
                            if (z && ae != null) {
                                d.Pt(str);
                            }
                        }
                    });
                    aVar.lJm = afVar.cIA;
                    aVar.lJl = false;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(Integer.valueOf(12));
                    aVar.b(afVar.getUsername(), linkedList, true);
                    afVar.cyA = 1;
                    ah.FQ().a(afVar.cIA, afVar);
                    this.oOs.Ol();
                }
            }
        }
    };

    interface a {
        void d(int i, String str, int i2);
    }

    class b {
        TextView cHI;
        TextView dtE;
        ImageView dtz;
        int ncf;
        final /* synthetic */ e oOs;
        String oOu;
        View ogr;
        ProgressBar ogs;
        int status;

        public b(final e eVar, View view) {
            this.oOs = eVar;
            this.dtz = (ImageView) view.findViewById(2131756891);
            this.cHI = (TextView) view.findViewById(2131756892);
            this.ogr = view.findViewById(2131758678);
            this.dtE = (TextView) view.findViewById(2131758679);
            this.ogs = (ProgressBar) view.findViewById(2131758680);
            this.ogr.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ b oOw;

                public final void onClick(View view) {
                    if (this.oOw.oOs.oOr != null) {
                        this.oOw.oOs.oOr.d(this.oOw.ncf, this.oOw.oOu, this.oOw.status);
                    }
                }
            });
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (af) obj;
        if (obj == null) {
            obj = new af();
        }
        obj.b(cursor);
        return obj;
    }

    public e(MMActivity mMActivity, int i) {
        super(mMActivity, new af());
        this.aWn = mMActivity;
        this.NW = i;
        this.oOq = mMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
        this.oOn = new a(mMActivity, new com.tencent.mm.ui.friend.a.a(this) {
            final /* synthetic */ e oOs;

            {
                this.oOs = r1;
            }

            public final void Ps(String str) {
                ag FQ = ah.FQ();
                af iM = FQ.iM(str);
                if (iM == null) {
                    v.w("MicroMsg.QQFriendAdapter", "[cpan] dealSucc failed. qqlist is null. username is :%s", str);
                    return;
                }
                iM.cIB = 2;
                FQ.a(iM.cIA, iM);
                this.oOs.notifyDataSetChanged();
                ak.yW();
                ab LX = c.wH().LX(str);
                if (LX == null) {
                    af iM2 = ah.FQ().iM(str);
                    if (iM2 != null) {
                        iM2.FJ();
                        v.d("MicroMsg.QQFriendAdapter", "user " + str + " qq " + iM2.cIA);
                        ah.FQ().a(iM2.cIA, iM2);
                    }
                } else if (!((LX.field_conRemark != null && !LX.field_conRemark.equals(SQLiteDatabase.KeyEmpty)) || iM == null || iM.FG() == null || iM.FG().equals(SQLiteDatabase.KeyEmpty))) {
                    m.b(LX, iM.FG());
                }
                bl.zQ().b(26, new Object[0]);
            }

            public final void aS(String str, boolean z) {
                if (z) {
                    af iM = ah.FQ().iM(str);
                    if (iM != null) {
                        iM.FJ();
                        v.d("MicroMsg.QQFriendAdapter", "user " + str + " qq " + iM.cIA);
                        ah.FQ().a(iM.cIA, iM);
                    } else {
                        v.w("MicroMsg.QQFriendAdapter", "[cpan] dealFail failed. qqlist is null. username is :%s", str);
                    }
                }
                this.oOs.notifyDataSetChanged();
            }
        });
        this.oOo = new c(mMActivity, new com.tencent.mm.ui.friend.c.a(this) {
            final /* synthetic */ e oOs;

            {
                this.oOs = r1;
            }

            public final void ka(boolean z) {
                if (z) {
                    this.oOs.notifyDataSetChanged();
                }
            }
        });
    }

    public final void a(com.tencent.mm.ui.friend.d.a aVar) {
        this.oOp = aVar;
    }

    public final void uU(String str) {
        this.dxb = be.lZ(str.trim());
        avc();
        Ol();
    }

    protected final void Om() {
        Ol();
    }

    public final void Ol() {
        avc();
        if (be.kS(this.dxb)) {
            setCursor(ah.FQ().v(this.NW, this.oOq));
        } else {
            setCursor(ah.FQ().b(this.NW, this.dxb, this.oOq));
        }
        if (!(this.oOp == null || this.dxb == null)) {
            this.oOp.vT(getCursor().getCount());
        }
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        Bitmap P;
        af afVar = (af) getItem(i);
        if (view == null) {
            view = View.inflate(this.aWn, 2130904209, null);
            bVar = new b(this, view);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.ncf = i;
        bVar.oOu = afVar.cIA;
        bVar.status = afVar.cIB;
        bVar.cHI.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.aWn, afVar.getDisplayName(), bVar.cHI.getTextSize()));
        if (o.ba(afVar.cIA) != 0) {
            P = com.tencent.mm.u.b.P(afVar.cIA);
        } else {
            P = null;
        }
        if (P == null) {
            bVar.dtz.setImageDrawable(com.tencent.mm.bd.a.a(this.aWn, 2131165440));
        } else {
            bVar.dtz.setImageBitmap(P);
        }
        if (!this.oOq) {
            switch (afVar.cIB) {
                case 0:
                    if (afVar.cyA != 2) {
                        bVar.ogr.setClickable(true);
                        bVar.ogr.setBackgroundResource(2130837799);
                        bVar.dtE.setText(2131232993);
                        bVar.dtE.setTextColor(this.aWn.getResources().getColor(com.tencent.mm.bi.a.a.white));
                        break;
                    }
                    bVar.ogr.setClickable(false);
                    bVar.ogr.setBackgroundDrawable(null);
                    bVar.dtE.setText(2131232994);
                    bVar.dtE.setTextColor(this.aWn.getResources().getColor(2131689817));
                    break;
                case 1:
                case 2:
                    ak.yW();
                    if (!c.wH().LT(afVar.getUsername()) && !k.xF().equals(afVar.getUsername())) {
                        if (afVar.cyA != 2) {
                            bVar.ogr.setClickable(true);
                            bVar.ogr.setBackgroundResource(2130837799);
                            bVar.dtE.setText(2131232991);
                            bVar.dtE.setTextColor(this.aWn.getResources().getColor(com.tencent.mm.bi.a.a.white));
                            break;
                        }
                        bVar.ogr.setClickable(false);
                        bVar.ogr.setBackgroundDrawable(null);
                        bVar.dtE.setText(2131232997);
                        bVar.dtE.setTextColor(this.aWn.getResources().getColor(2131689817));
                        break;
                    }
                    bVar.ogr.setClickable(false);
                    bVar.ogr.setBackgroundDrawable(null);
                    bVar.dtE.setText(2131232992);
                    bVar.dtE.setTextColor(this.aWn.getResources().getColor(2131689817));
                    break;
                    break;
            }
            switch (afVar.cyA) {
                case 0:
                case 2:
                    bVar.dtE.setVisibility(0);
                    bVar.ogs.setVisibility(4);
                    break;
                case 1:
                    bVar.dtE.setVisibility(4);
                    bVar.ogs.setVisibility(0);
                    break;
                default:
                    break;
            }
        }
        bVar.ogr.setVisibility(8);
        return view;
    }

    public final void gM(String str) {
        notifyDataSetChanged();
    }
}
