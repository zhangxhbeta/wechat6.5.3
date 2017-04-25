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
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class f extends d {
    private final int NW;
    private final MMActivity aWn;
    private String dxb;
    private com.tencent.mm.ui.friend.d.a oOp;
    boolean oOx = false;
    private a oOy = new a(this) {
        final /* synthetic */ f oOz;

        {
            this.oOz = r1;
        }

        public final void d(int i, String str, int i2) {
            v.d("MicroMsg.QQFriendAdapterCaseB", "[cpan] postion:%d qq:%s status:%d", new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)});
            af afVar = (af) this.oOz.getItem(i);
            if (afVar == null) {
                v.e("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend is null. qq:%s", new Object[]{str});
                return;
            }
            v.d("MicroMsg.QQFriendAdapterCaseB", "qq friend:%s", new Object[]{afVar.toString()});
            if (afVar.cIB == 1) {
                com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.oOz.aWn, new com.tencent.mm.pluginsdk.ui.applet.a.a(this) {
                    final /* synthetic */ AnonymousClass1 oOA;

                    {
                        this.oOA = r1;
                    }

                    public final void a(boolean z, boolean z2, String str, String str2) {
                        v.i("MicroMsg.QQFriendAdapterCaseB", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2});
                        long longValue = new o(o.ba(str2)).longValue();
                        af ae = ah.FQ().ae(longValue);
                        if (z && ae != null) {
                            ae.username = str;
                        }
                        if (ae != null) {
                            ae.cyA = 2;
                            v.d("MicroMsg.QQFriendAdapterCaseB", "f :%s", new Object[]{ae.toString()});
                            ah.FQ().a(longValue, ae);
                            this.oOA.oOz.Ol();
                        } else {
                            v.w("MicroMsg.QQFriendAdapterCaseB", "cpan qq friend is null. qq:%s", new Object[]{str2});
                        }
                        if (z && ae != null) {
                            f.Pt(str);
                        }
                    }
                });
                aVar.lJm = afVar.cIA;
                aVar.lJl = false;
                LinkedList linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(12));
                if (be.kS(afVar.getUsername())) {
                    v.w("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend username is null.");
                    return;
                }
                aVar.b(afVar.getUsername(), linkedList, true);
                afVar.cyA = 1;
                ah.FQ().a(afVar.cIA, afVar);
                this.oOz.Ol();
            }
        }
    };

    interface a {
        void d(int i, String str, int i2);
    }

    class b {
        String cYN;
        TextView dtE;
        ImageView dtz;
        TextView gJJ;
        ProgressBar igp;
        TextView jTZ;
        int ncf;
        final /* synthetic */ f oOz;
        View ogr;
        TextView ogx;
        int status;

        public b(final f fVar, View view) {
            this.oOz = fVar;
            this.jTZ = (TextView) view.findViewById(2131757129);
            this.dtz = (ImageView) view.findViewById(2131757130);
            this.gJJ = (TextView) view.findViewById(2131757131);
            this.ogx = (TextView) view.findViewById(2131757132);
            this.ogr = view.findViewById(2131757133);
            this.dtE = (TextView) view.findViewById(2131757134);
            this.igp = (ProgressBar) view.findViewById(2131757135);
            this.ogr.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ b oOC;

                public final void onClick(View view) {
                    if (this.oOC.oOz.oOy != null) {
                        this.oOC.oOz.oOy.d(this.oOC.ncf, this.oOC.cYN, this.oOC.status);
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

    public f(MMActivity mMActivity, int i) {
        super(mMActivity, new af());
        this.aWn = mMActivity;
        this.NW = i;
        this.oOx = mMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
        iQ(true);
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
            setCursor(ah.FQ().v(this.NW, this.oOx));
        } else {
            setCursor(ah.FQ().b(this.NW, this.dxb, this.oOx));
        }
        if (!(this.oOp == null || this.dxb == null)) {
            this.oOp.vT(getCursor().getCount());
        }
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        af afVar = (af) getItem(i);
        if (view == null) {
            view = View.inflate(this.aWn, 2130903671, null);
            b bVar2 = new b(this, view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.ncf = i;
        bVar.cYN = afVar.cIA;
        bVar.status = afVar.cIB;
        bVar.gJJ.setText(e.a(this.aWn, afVar.getDisplayName(), bVar.gJJ.getTextSize()));
        bVar.ogx.setText(e.a(this.aWn, afVar.FC(), bVar.ogx.getTextSize()));
        if (this.oOx) {
            Bitmap P;
            if (o.ba(bVar.cYN) != 0) {
                P = com.tencent.mm.u.b.P(afVar.cIA);
            } else {
                P = null;
            }
            if (P == null) {
                bVar.dtz.setImageDrawable(com.tencent.mm.bd.a.a(this.aWn, 2131165440));
            } else {
                bVar.dtz.setImageBitmap(P);
            }
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.m(bVar.dtz, afVar.getUsername());
        }
        if (!this.oOx) {
            switch (afVar.cIB) {
                case 1:
                case 2:
                    ak.yW();
                    if (!c.wH().LT(afVar.getUsername()) && !k.xF().equals(afVar.getUsername())) {
                        if (afVar.cyA != 2) {
                            bVar.ogr.setClickable(true);
                            bVar.ogr.setBackgroundResource(2130837799);
                            bVar.dtE.setText(2131232991);
                            bVar.dtE.setTextColor(this.aWn.getResources().getColor(2131690127));
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
                    bVar.igp.setVisibility(4);
                    break;
                case 1:
                    bVar.dtE.setVisibility(4);
                    bVar.igp.setVisibility(0);
                    break;
                default:
                    break;
            }
        }
        bVar.ogr.setVisibility(8);
        af afVar2 = (af) getItem(i - 1);
        int i2 = afVar2 == null ? -1 : afVar2.cyz;
        String str = "MicroMsg.QQFriendAdapterCaseB";
        String str2 = "qq friend pre:%s";
        Object[] objArr = new Object[1];
        objArr[0] = afVar2 != null ? afVar2.toString() : "";
        v.d(str, str2, objArr);
        str = "MicroMsg.QQFriendAdapterCaseB";
        str2 = "qq friend:%s";
        objArr = new Object[1];
        objArr[0] = afVar != null ? afVar.toString() : "";
        v.d(str, str2, objArr);
        if (i == 0) {
            CharSequence b = b(afVar);
            if (be.kS(b)) {
                v.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", new Object[]{afVar.getUsername(), Integer.valueOf(i)});
                bVar.jTZ.setVisibility(8);
            } else {
                bVar.jTZ.setVisibility(0);
                bVar.jTZ.setText(b);
                bVar.jTZ.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        } else {
            boolean z;
            if (afVar.cyz != i2) {
                z = true;
            } else {
                z = false;
            }
            CharSequence b2 = b(afVar);
            if (be.kS(b2) || !r1) {
                v.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", new Object[]{afVar.getUsername(), Integer.valueOf(i)});
                bVar.jTZ.setVisibility(8);
            } else {
                bVar.jTZ.setVisibility(0);
                bVar.jTZ.setText(b2);
                bVar.jTZ.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        return view;
    }

    private static String b(af afVar) {
        if (afVar.cyz == 123) {
            return "#";
        }
        return String.valueOf((char) afVar.cyz);
    }

    public final void gM(String str) {
    }
}
