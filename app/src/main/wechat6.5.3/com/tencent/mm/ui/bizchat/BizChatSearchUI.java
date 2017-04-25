package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.a.l;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.modelsearch.h;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.protocal.c.gy;
import com.tencent.mm.protocal.c.hb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class BizChatSearchUI extends MMActivity implements com.tencent.mm.pluginsdk.ui.tools.p.a, com.tencent.mm.ui.bizchat.BizChatSearchListView.a {
    p eyI;
    String ezn;
    private OnScrollListener gpO = new OnScrollListener(this) {
        boolean eyw = false;
        final /* synthetic */ BizChatSearchUI ohX;

        {
            this.ohX = r2;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0 && this.eyw && this.ohX.ohW.oil) {
                a a = this.ohX.ohW;
                if (a.bDz() && !a.oin) {
                    a.oin = true;
                    ak.vy().a(new l(a.ezn, a.eSD, a.oir), 0);
                    a.bDB();
                }
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i + i2 == i3) {
                this.eyw = true;
            } else {
                this.eyw = false;
            }
        }
    };
    private String ohS;
    private c ohT;
    BizChatSearchListView ohU;
    TextView ohV;
    private a ohW;
    private int scene;

    private static class b {
        public View dtW;
        public TextView eVt;
        public View hBo;

        private b() {
        }
    }

    private static class c {
        View eyA;
        View eyy;
        View eyz;

        private c() {
        }

        final void i(boolean z, boolean z2) {
            int i;
            int i2 = 0;
            View view = this.eyy;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view.setVisibility(i);
            this.eyz.setVisibility(8);
            View view2 = this.eyA;
            if (!z2) {
                i2 = 8;
            }
            view2.setVisibility(i2);
        }
    }

    private static class d {
        public View dtW;
        public TextView ijk;

        private d() {
        }
    }

    private static class e {
        public View dtW;
        public ImageView eZn;
        public TextView ijk;

        private e() {
        }
    }

    private static class f {
        public View dtW;
        public ImageView dtX;
        public TextView dtY;
        public TextView dtZ;

        private f() {
        }
    }

    private static class g {
        public static int oiA = 6;
        public static int oiB = 1;
        public static int oiC = 2;
        public static int oiu = 0;
        public static int oiv = 1;
        public static int oiw = 2;
        public static int oix = 3;
        public static int oiy = 4;
        public static int oiz = 5;
        public Object data;
        public int eKg;

        public g() {
            this.eKg = oiu;
            this.data = null;
        }

        public g(int i, Object obj) {
            this.eKg = i;
            this.data = obj;
        }
    }

    private static class a extends BaseAdapter implements com.tencent.mm.v.e {
        public static int ohY = 3;
        private int Tr = 0;
        private com.tencent.mm.ae.a.a.c cPf;
        private Context context;
        String eSD;
        String ezn;
        private int ohZ;
        boolean oia;
        boolean oib;
        private ArrayList<com.tencent.mm.modelbiz.a.c> oic = new ArrayList();
        private ArrayList<Object> oid = new ArrayList();
        private ArrayList<com.tencent.mm.modelbiz.a.c> oie = new ArrayList();
        private g oif;
        private ArrayList<g> oig = new ArrayList();
        private g oih;
        private g oii;
        private ArrayList<g> oij = new ArrayList();
        private g oik;
        public boolean oil = true;
        public boolean oim = false;
        public boolean oin = false;
        private boolean oio = true;
        private int oip = 0;
        public boolean oiq = false;
        int oir = 0;
        private int scene;

        public final /* synthetic */ Object getItem(int i) {
            return wT(i);
        }

        public a(Context context, String str, int i) {
            boolean z;
            boolean z2 = false;
            this.context = context;
            this.ezn = str;
            this.scene = i;
            if (this.scene == 1 || this.scene == 2) {
                z = true;
            } else {
                z = false;
            }
            this.oia = z;
            if (this.scene == 1 || this.scene == 3) {
                z2 = true;
            }
            this.oib = z2;
            this.ohZ = this.scene == 1 ? ohY : Integer.MAX_VALUE;
            com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
            aVar.cPv = com.tencent.mm.modelbiz.a.e.ib(this.ezn);
            aVar.cPs = true;
            aVar.cPO = true;
            aVar.cPH = 2131165440;
            this.cPf = aVar.GU();
            if (this.oia) {
                ak.vy().a(1364, (com.tencent.mm.v.e) this);
            }
        }

        public final int getCount() {
            return this.Tr;
        }

        public final int getItemViewType(int i) {
            g wT = wT(i);
            if (wT != null) {
                return wT.eKg;
            }
            return g.oiu;
        }

        public final int getViewTypeCount() {
            return g.oiA;
        }

        public final g wT(int i) {
            int i2;
            if (i < this.oip) {
                if (i == 0) {
                    if (this.oif == null) {
                        this.oif = new g(g.oiz, Integer.valueOf(g.oiB));
                    }
                    return this.oif;
                } else if (i == this.oip - 1 && this.oim && bDy()) {
                    if (this.oih == null) {
                        this.oih = new g();
                    }
                    this.oih.eKg = g.oiy;
                    this.oih.data = Integer.valueOf(g.oiB);
                    return this.oih;
                } else if (i == this.oip - 1 && this.oil && bDy()) {
                    if (this.oih == null) {
                        this.oih = new g();
                    }
                    this.oih.eKg = g.oix;
                    this.oih.data = Integer.valueOf(g.oiB);
                    return this.oih;
                } else {
                    i2 = i - 1;
                    if (i2 >= 0 && i2 < this.oig.size()) {
                        return (g) this.oig.get(i2);
                    }
                }
            } else if (i == this.oip) {
                if (this.oii == null) {
                    this.oii = new g(g.oiz, Integer.valueOf(g.oiC));
                }
                return this.oii;
            } else if (i == this.Tr - 1 && this.oio && bDy()) {
                if (this.oik == null) {
                    this.oik = new g(g.oix, Integer.valueOf(g.oiC));
                }
                return this.oik;
            } else {
                i2 = (i - this.oip) - 1;
                if (i2 >= 0 && i2 < this.oij.size()) {
                    return (g) this.oij.get(i2);
                }
            }
            return new g();
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z = true;
            g wT = wT(i);
            String str;
            CharSequence a;
            if (wT.eKg == g.oiv || wT.eKg == g.oiw) {
                CharSequence charSequence;
                String str2;
                boolean z2;
                CharSequence charSequence2;
                boolean z3;
                if (view == null) {
                    view = LayoutInflater.from(this.context).inflate(2130903677, viewGroup, false);
                    view.measure(ViewGroup.getChildMeasureSpec(MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824), viewGroup.getPaddingLeft() + viewGroup.getPaddingRight(), -1), MeasureSpec.makeMeasureSpec(-2, 1073741824));
                    f fVar = new f();
                    fVar.dtX = (ImageView) view.findViewById(2131755508);
                    fVar.dtY = (TextView) view.findViewById(2131755456);
                    fVar.dtZ = (TextView) view.findViewById(2131755458);
                    fVar.dtW = view.findViewById(2131757157);
                    view.setTag(fVar);
                }
                f fVar2 = (f) view.getTag();
                String str3 = SQLiteDatabase.KeyEmpty;
                String str4 = SQLiteDatabase.KeyEmpty;
                String str5 = SQLiteDatabase.KeyEmpty;
                if (wT.data instanceof com.tencent.mm.modelbiz.a.c) {
                    com.tencent.mm.modelbiz.a.c cVar = (com.tencent.mm.modelbiz.a.c) wT.data;
                    if (cVar != null) {
                        if (!cVar.DN()) {
                            j ig = u.DC().ig(cVar.field_bizChatServId);
                            if (ig != null) {
                                str4 = ig.field_userName;
                                str = ig.field_headImageUrl;
                            }
                        }
                        str4 = cVar.field_chatName;
                        str = cVar.field_headImageUrl;
                    } else {
                        str = str4;
                        str4 = str3;
                    }
                    charSequence = str5;
                    str2 = str;
                    z2 = false;
                    charSequence2 = str4;
                    z3 = true;
                } else if (wT.data instanceof gy) {
                    gy gyVar = (gy) wT.data;
                    hb hbVar = gyVar.mhM;
                    str2 = hbVar.eES;
                    str5 = hbVar.mhE;
                    boolean equals = "userid".equals(gyVar.mhN);
                    z3 = !equals;
                    String str6 = gyVar.mhO;
                    r1 = str2;
                    str2 = str5;
                    z2 = equals;
                    r3 = str6;
                } else {
                    str2 = str4;
                    r1 = str3;
                    r3 = str5;
                    z3 = false;
                    z2 = false;
                }
                if (z3) {
                    a = a(this.context, h.a(this.context, charSequence2, this.eSD), h.cVN);
                } else {
                    a = a(this.context, new SpannableString(charSequence2), h.cVN);
                }
                if (z2) {
                    str = this.context.getString(2131231507);
                    SpannableString a2 = a(this.context, h.a(this.context, charSequence, this.eSD), h.cVN);
                    charSequence2 = TextUtils.concat(new CharSequence[]{str, a2});
                } else {
                    charSequence2 = SQLiteDatabase.KeyEmpty;
                }
                if (wT.eKg == g.oiv && i == this.oip - 1 && this.oip != this.Tr) {
                    z = false;
                }
                m(fVar2.dtW, z);
                n.GL().a(str2, fVar2.dtX, this.cPf);
                h.b(a, fVar2.dtY);
                h.b(charSequence2, fVar2.dtZ);
                return view;
            } else if (wT.eKg == g.oiz) {
                if (view == null) {
                    view = LayoutInflater.from(this.context).inflate(2130903683, viewGroup, false);
                    b bVar = new b();
                    bVar.eVt = (TextView) view.findViewById(2131756332);
                    bVar.hBo = view.findViewById(2131755206);
                    bVar.dtW = view.findViewById(2131757157);
                    view.setTag(bVar);
                }
                b bVar2 = (b) view.getTag();
                str = ((Integer) wT.data).intValue() == g.oiB ? this.context.getResources().getString(2131231505) : ((Integer) wT.data).intValue() == g.oiC ? this.context.getResources().getString(2131231498) : SQLiteDatabase.KeyEmpty;
                h.b(str, bVar2.eVt);
                if (i == 0) {
                    bVar2.hBo.setVisibility(8);
                } else {
                    bVar2.hBo.setVisibility(0);
                }
                bVar2.dtW.setBackgroundResource(2130838472);
                return view;
            } else if (wT.eKg == g.oix) {
                if (view == null) {
                    view = LayoutInflater.from(this.context).inflate(2130903688, viewGroup, false);
                    e eVar = new e();
                    eVar.ijk = (TextView) view.findViewById(2131755314);
                    eVar.eZn = (ImageView) view.findViewById(2131756771);
                    eVar.dtW = view.findViewById(2131757157);
                    view.setTag(eVar);
                }
                e eVar2 = (e) view.getTag();
                a = SQLiteDatabase.KeyEmpty;
                if (((Integer) wT.data).intValue() == g.oiB) {
                    a = this.context.getResources().getString(2131231504);
                } else if (((Integer) wT.data).intValue() == g.oiC) {
                    Object string = this.context.getResources().getString(2131231503);
                }
                if (((Integer) wT.data).intValue() == g.oiB && this.oip != this.Tr) {
                    z = false;
                }
                m(eVar2.dtW, z);
                eVar2.ijk.setText(a);
                eVar2.eZn.setImageResource(2131165595);
                return view;
            } else if (wT.eKg != g.oiy) {
                return null;
            } else {
                if (view == null) {
                    view = LayoutInflater.from(this.context).inflate(2130903685, viewGroup, false);
                    d dVar = new d();
                    dVar.ijk = (TextView) view.findViewById(2131755314);
                    dVar.dtW = view.findViewById(2131757157);
                    view.setTag(dVar);
                }
                d dVar2 = (d) view.getTag();
                if (((Integer) wT.data).intValue() == g.oiB && this.oip != this.Tr) {
                    z = false;
                }
                m(dVar2.dtW, z);
                dVar2.ijk.setText(this.context.getResources().getString(2131231500));
                return view;
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r9, int r10, java.lang.String r11, com.tencent.mm.v.k r12) {
            /*
            r8 = this;
            r1 = 0;
            r2 = 1;
            r3 = 0;
            r0 = r8.oia;
            if (r0 == 0) goto L_0x0045;
        L_0x0007:
            r0 = r12.getType();
            r4 = 1364; // 0x554 float:1.911E-42 double:6.74E-321;
            if (r0 != r4) goto L_0x0045;
        L_0x000f:
            r0 = r12 instanceof com.tencent.mm.modelbiz.a.l;
            if (r0 == 0) goto L_0x0045;
        L_0x0013:
            r8.oin = r3;
            r12 = (com.tencent.mm.modelbiz.a.l) r12;
            r0 = r12.cif;
            if (r0 == 0) goto L_0x0046;
        L_0x001b:
            r0 = r12.cif;
            r0 = r0.czk;
            r0 = r0.czs;
            if (r0 == 0) goto L_0x0046;
        L_0x0023:
            r0 = r12.cif;
            r0 = r0.czk;
            r0 = r0.czs;
            r0 = (com.tencent.mm.protocal.c.gz) r0;
        L_0x002b:
            r4 = r0.aXp;
            r5 = r0.mhJ;
            r6 = r8.eSD;
            r6 = r4.equals(r6);
            if (r6 == 0) goto L_0x0045;
        L_0x0037:
            r6 = r8.ezn;
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x0045;
        L_0x003f:
            r5 = r8.oir;
            r0 = r0.offset;
            if (r5 == r0) goto L_0x0048;
        L_0x0045:
            return;
        L_0x0046:
            r0 = r1;
            goto L_0x002b;
        L_0x0048:
            if (r9 != 0) goto L_0x004c;
        L_0x004a:
            if (r10 == 0) goto L_0x0050;
        L_0x004c:
            r8.bDx();
            goto L_0x0045;
        L_0x0050:
            r0 = r12.cif;
            if (r0 == 0) goto L_0x0074;
        L_0x0054:
            r0 = r12.cif;
            r0 = r0.czl;
            r0 = r0.czs;
            if (r0 == 0) goto L_0x0074;
        L_0x005c:
            r0 = r12.cif;
            r0 = r0.czl;
            r0 = r0.czs;
            r0 = (com.tencent.mm.protocal.c.ha) r0;
        L_0x0064:
            if (r0 == 0) goto L_0x0070;
        L_0x0066:
            r1 = r0.mhP;
            if (r1 == 0) goto L_0x0070;
        L_0x006a:
            r1 = r0.mhP;
            r1 = r1.ret;
            if (r1 == 0) goto L_0x0076;
        L_0x0070:
            r8.bDx();
            goto L_0x0045;
        L_0x0074:
            r0 = r1;
            goto L_0x0064;
        L_0x0076:
            r1 = r0.mhQ;
            r0 = r0.mhR;
            r5 = r8.eSD;
            r5 = r4.equals(r5);
            if (r5 == 0) goto L_0x0045;
        L_0x0082:
            r8.oim = r3;
            r5 = r8.oir;
            r6 = r1.size();
            r5 = r5 + r6;
            r8.oir = r5;
            r5 = r8.bDy();
            if (r5 == 0) goto L_0x00b3;
        L_0x0093:
            r5 = r8.oid;
            r5 = r5.size();
            r6 = r8.oic;
            r6 = r6.size();
            if (r5 >= r6) goto L_0x00a5;
        L_0x00a1:
            r8.aP(r4, r2);
            goto L_0x0045;
        L_0x00a5:
            r4 = r8.oid;
            r4 = r4.size();
            r5 = r8.oic;
            r5 = r5.size();
            if (r4 > r5) goto L_0x0101;
        L_0x00b3:
            r4 = r8.bDz();
            if (r4 == 0) goto L_0x00bb;
        L_0x00b9:
            r8.oil = r0;
        L_0x00bb:
            r0 = r8.bDA();
            if (r0 != 0) goto L_0x0045;
        L_0x00c1:
            r4 = r1.iterator();
        L_0x00c5:
            r0 = r4.hasNext();
            if (r0 == 0) goto L_0x0101;
        L_0x00cb:
            r0 = r4.next();
            r1 = r0;
            r1 = (com.tencent.mm.protocal.c.gy) r1;
            r5 = r1.mhM;
            r0 = r5.mhK;
            r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
            if (r0 != 0) goto L_0x00c5;
        L_0x00dc:
            r0 = r8.oic;
            r6 = r0.iterator();
        L_0x00e2:
            r0 = r6.hasNext();
            if (r0 == 0) goto L_0x0106;
        L_0x00e8:
            r0 = r6.next();
            r0 = (com.tencent.mm.modelbiz.a.c) r0;
            r7 = r5.mhK;
            r0 = r0.field_bizChatServId;
            r0 = r7.equals(r0);
            if (r0 == 0) goto L_0x00e2;
        L_0x00f8:
            r0 = r2;
        L_0x00f9:
            if (r0 != 0) goto L_0x00c5;
        L_0x00fb:
            r0 = r8.oid;
            r0.add(r1);
            goto L_0x00c5;
        L_0x0101:
            r8.jD(r2);
            goto L_0x0045;
        L_0x0106:
            r0 = r3;
            goto L_0x00f9;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.bizchat.BizChatSearchUI.a.a(int, int, java.lang.String, com.tencent.mm.v.k):void");
        }

        private void bDx() {
            if (bDz()) {
                this.oim = false;
                this.oiq = true;
                bDB();
            }
        }

        private boolean bDy() {
            return this.scene == 1;
        }

        final boolean bDz() {
            return this.scene == 2;
        }

        private boolean bDA() {
            return this.scene == 3;
        }

        private static SpannableString a(Context context, Spannable spannable, int i) {
            int i2 = 0;
            SpannableString a = com.tencent.mm.pluginsdk.ui.d.e.a(context, (CharSequence) spannable, i);
            ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spannable.getSpans(0, spannable.length(), ForegroundColorSpan.class);
            if (foregroundColorSpanArr != null) {
                int length = foregroundColorSpanArr.length;
                while (i2 < length) {
                    Object obj = foregroundColorSpanArr[i2];
                    a.setSpan(obj, spannable.getSpanStart(obj), spannable.getSpanEnd(obj), spannable.getSpanFlags(obj));
                    i2++;
                }
            }
            return a;
        }

        private static void m(View view, boolean z) {
            if (z) {
                view.setBackgroundResource(2130838046);
            } else {
                view.setBackgroundResource(2130838048);
            }
        }

        final void aP(String str, boolean z) {
            com.tencent.mm.modelbiz.a.b DB = u.DB();
            String str2 = this.ezn;
            List<com.tencent.mm.modelbiz.a.c> arrayList = new ArrayList();
            if (!be.kS(str)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("select BizChatInfo.*");
                stringBuilder.append(" from BizChatConversation , BizChatInfo");
                stringBuilder.append(" where BizChatConversation.brandUserName").append(" = '").append(str2).append("'");
                stringBuilder.append(" and BizChatInfo.brandUserName").append(" = '").append(str2).append("'");
                stringBuilder.append(" and BizChatConversation.bizChatId");
                stringBuilder.append(" = BizChatInfo.bizChatLocalId");
                stringBuilder.append(" and BizChatInfo.chatName").append(" like '%").append(str).append("%'");
                stringBuilder.append(" order by BizChatConversation.flag").append(" desc");
                stringBuilder.append(" , BizChatConversation.lastMsgTime").append(" desc");
                v.d("MicroMsg.BizConversationStorage", "getBizChatConversationSearchCursor: sql:%s", stringBuilder.toString());
                Cursor rawQuery = DB.rawQuery(stringBuilder.toString(), new String[0]);
                if (rawQuery != null) {
                    if (rawQuery.moveToFirst()) {
                        do {
                            com.tencent.mm.modelbiz.a.c cVar = new com.tencent.mm.modelbiz.a.c();
                            cVar.b(rawQuery);
                            arrayList.add(cVar);
                        } while (rawQuery.moveToNext());
                    }
                    rawQuery.close();
                }
            }
            ua();
            for (com.tencent.mm.modelbiz.a.c cVar2 : arrayList) {
                boolean DN = cVar2.DN();
                if (DN && this.oib) {
                    this.oie.add(cVar2);
                } else if (!DN && this.oia) {
                    this.oid.add(cVar2);
                    this.oic.add(cVar2);
                }
            }
            if (this.oia) {
                boolean z2;
                if (this.oid.size() <= this.ohZ) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.oim = z2;
            }
            jD(z);
        }

        final void OF(final String str) {
            if (this.oia) {
                ad.g(new Runnable(this) {
                    final /* synthetic */ a oit;

                    public final void run() {
                        if (str.equals(this.oit.eSD)) {
                            ak.vy().a(new l(this.oit.ezn, str, 0), 0);
                        }
                    }
                }, 200);
            }
        }

        final void ua() {
            this.oir = 0;
            this.oid.clear();
            this.oic.clear();
            this.oie.clear();
        }

        final void jD(boolean z) {
            int i;
            int i2 = 1;
            this.oig.clear();
            this.oij.clear();
            for (i = 0; i < Math.min(this.ohZ, this.oid.size()); i++) {
                this.oig.add(new g(g.oiv, this.oid.get(i)));
            }
            for (i = 0; i < Math.min(this.ohZ, this.oie.size()); i++) {
                this.oij.add(new g(g.oiw, this.oie.get(i)));
            }
            int size = this.oid.size();
            int size2 = this.oie.size();
            if (this.scene != 2) {
                this.oil = this.oid.size() > this.ohZ;
            }
            this.oio = this.oie.size() > this.ohZ;
            if (size > 0 || this.oim) {
                size = Math.min(size, this.ohZ) + 1;
                if (bDy()) {
                    i = (this.oim || this.oil) ? 1 : 0;
                    i += size;
                } else {
                    i = size;
                }
            } else {
                i = 0;
            }
            this.oip = i;
            if (size2 > 0) {
                i = (i + 1) + Math.min(size2, this.ohZ);
                if (bDy()) {
                    if (!this.oio) {
                        i2 = 0;
                    }
                    i += i2;
                }
            }
            this.Tr = i;
            if (z) {
                notifyDataSetChanged();
                bDB();
            }
        }

        final void bDB() {
            BizChatSearchUI bizChatSearchUI = (BizChatSearchUI) this.context;
            if (!bDy()) {
                if (be.kS(this.eSD)) {
                    bizChatSearchUI.ohV.setVisibility(0);
                    bizChatSearchUI.ohV.setText(SQLiteDatabase.KeyEmpty);
                    bizChatSearchUI.ohU.setVisibility(8);
                } else if (bDz() && this.oim) {
                    bizChatSearchUI.ohV.setVisibility(0);
                    bizChatSearchUI.ohV.setText(2131231500);
                    bizChatSearchUI.ohU.setVisibility(8);
                } else if (bDz() && this.oiq) {
                    bizChatSearchUI.ohV.setVisibility(0);
                    bizChatSearchUI.ohV.setText(2131231501);
                    bizChatSearchUI.ohU.setVisibility(8);
                } else if (getCount() <= 0) {
                    bizChatSearchUI.ohV.setVisibility(0);
                    bizChatSearchUI.ohV.setText(h.m(bizChatSearchUI.getString(2131234830), bizChatSearchUI.getString(2131234829), this.eSD));
                    bizChatSearchUI.ohU.setVisibility(8);
                } else {
                    bizChatSearchUI.ohV.setVisibility(8);
                    bizChatSearchUI.ohU.setVisibility(0);
                }
                if (!bDz()) {
                    return;
                }
                if (this.oin) {
                    bizChatSearchUI.wS(1);
                } else if (this.oil) {
                    bizChatSearchUI.wS(2);
                } else {
                    bizChatSearchUI.wS(0);
                }
            } else if (be.kS(this.eSD)) {
                bizChatSearchUI.ohV.setVisibility(8);
                bizChatSearchUI.ohU.setVisibility(8);
            } else if (getCount() <= 0) {
                bizChatSearchUI.ohV.setVisibility(0);
                bizChatSearchUI.ohU.setVisibility(8);
            } else {
                bizChatSearchUI.ohV.setVisibility(8);
                bizChatSearchUI.ohU.setVisibility(0);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    public final void Oh() {
    }

    protected final void NI() {
        if (be.kS(this.ezn)) {
            this.ezn = getIntent().getStringExtra("enterprise_biz_name");
            this.scene = getIntent().getIntExtra("biz_chat_search_scene", 1);
            this.ohS = getIntent().getStringExtra("biz_chat_search_text");
            if (be.kS(this.ezn)) {
                finish();
            }
        }
        this.ohU = (BizChatSearchListView) findViewById(2131756770);
        this.ohV = (TextView) findViewById(2131755214);
        this.ohW = new a(this.nDR.nEl, this.ezn, this.scene);
        if (this.ohW.bDz()) {
            this.ohT = new c();
            BizChatSearchListView bizChatSearchListView = this.ohU;
            c cVar = this.ohT;
            View inflate = View.inflate(this.nDR.nEl, 2130903863, null);
            cVar.eyy = inflate.findViewById(2131757704);
            cVar.eyz = inflate.findViewById(2131755942);
            cVar.eyA = inflate.findViewById(2131757705);
            cVar.eyy.setVisibility(8);
            cVar.eyz.setVisibility(8);
            cVar.eyA.setVisibility(8);
            bizChatSearchListView.addFooterView(inflate);
            wS(0);
        }
        this.ohU.setAdapter(this.ohW);
        this.ohU.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ BizChatSearchUI ohX;

            {
                this.ohX = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                long j2 = -1;
                g wT = this.ohX.ohW.wT(i);
                MMActivity mMActivity = this.ohX;
                Intent intent;
                if (wT.eKg == g.oiv || wT.eKg == g.oiw) {
                    com.tencent.mm.modelbiz.a.c cVar;
                    if (wT.data instanceof com.tencent.mm.modelbiz.a.c) {
                        cVar = (com.tencent.mm.modelbiz.a.c) wT.data;
                        j2 = cVar != null ? cVar.field_bizChatLocalId : -1;
                    } else if (wT.data instanceof gy) {
                        hb hbVar = ((gy) wT.data).mhM;
                        String str = mMActivity.ezn;
                        j jVar = new j();
                        jVar.field_userId = hbVar.mhK;
                        jVar.field_userName = hbVar.eES;
                        jVar.field_brandUserName = str;
                        jVar.field_headImageUrl = hbVar.mhE;
                        jVar.field_profileUrl = hbVar.mhS;
                        jVar.field_UserVersion = hbVar.ver;
                        jVar.field_addMemberUrl = hbVar.mhI;
                        if (!u.DC().b(jVar) ? u.DC().a(jVar) : true) {
                            cVar = new com.tencent.mm.modelbiz.a.c();
                            cVar.field_bizChatServId = jVar.field_userId;
                            cVar.field_brandUserName = jVar.field_brandUserName;
                            cVar.field_chatName = jVar.field_userName;
                            cVar.field_chatType = 1;
                            cVar = u.DA().c(cVar);
                            if (cVar != null) {
                                com.tencent.mm.modelbiz.a.a T = u.DB().T(cVar.field_bizChatLocalId);
                                T.field_bizChatId = cVar.field_bizChatLocalId;
                                T.field_unReadCount = 0;
                                if (be.kS(T.field_brandUserName)) {
                                    T.field_brandUserName = cVar.field_brandUserName;
                                    T.field_lastMsgTime = System.currentTimeMillis();
                                    T.field_flag = T.field_lastMsgTime;
                                }
                                if (!u.DB().b(T)) {
                                    u.DB().a(T);
                                }
                                j2 = cVar.field_bizChatLocalId;
                            }
                        }
                    }
                    if (!be.kS(mMActivity.ezn) && j2 >= 0) {
                        intent = new Intent();
                        intent.putExtra("Chat_User", mMActivity.ezn);
                        intent.putExtra("key_biz_chat_id", j2);
                        intent.putExtra("finish_direct", true);
                        intent.putExtra("key_need_send_video", false);
                        intent.putExtra("key_is_biz_chat", true);
                        com.tencent.mm.ay.c.a(mMActivity.nDR.nEl, ".ui.chatting.ChattingUI", intent);
                    }
                } else if (wT.eKg != g.oix) {
                } else {
                    if (((Integer) wT.data).intValue() == g.oiB) {
                        intent = new Intent(mMActivity.nDR.nEl, BizChatSearchUI.class);
                        intent.putExtra("enterprise_biz_name", mMActivity.ezn);
                        intent.putExtra("biz_chat_search_scene", 2);
                        intent.putExtra("biz_chat_search_text", mMActivity.eyI.boJ());
                        mMActivity.startActivity(intent);
                    } else if (((Integer) wT.data).intValue() == g.oiC) {
                        intent = new Intent(mMActivity.nDR.nEl, BizChatSearchUI.class);
                        intent.putExtra("enterprise_biz_name", mMActivity.ezn);
                        intent.putExtra("biz_chat_search_scene", 3);
                        intent.putExtra("biz_chat_search_text", mMActivity.eyI.boJ());
                        mMActivity.startActivity(intent);
                    }
                }
            }
        });
        this.ohU.ohR = this;
        if (this.ohW.bDz()) {
            this.ohU.setOnScrollListener(this.gpO);
        }
        this.eyI = new p();
        this.eyI.kj(this.ohW.bDy());
        this.eyI.a(this);
        this.eyI.lUX = false;
    }

    public final void Og() {
    }

    public final void Of() {
        finish();
    }

    public final void ml(String str) {
        CharSequence charSequence = null;
        if (!be.kS(str) || this.ohS == null) {
            a aVar = this.ohW;
            aVar.eSD = str;
            if (be.kS(str)) {
                aVar.ua();
                aVar.oim = false;
                aVar.oiq = false;
                aVar.jD(true);
                return;
            } else if (aVar.bDz()) {
                aVar.oim = true;
                aVar.oiq = false;
                aVar.bDB();
                aVar.aP(str, false);
                aVar.OF(str);
                return;
            } else {
                aVar.aP(str, true);
                if (aVar.oia && aVar.oim) {
                    aVar.OF(str);
                    return;
                }
                return;
            }
        }
        String str2 = this.ohS;
        this.ohS = null;
        if (!str2.equals(SQLiteDatabase.KeyEmpty)) {
            this.eyI.Pw(str2);
        }
        p pVar = this.eyI;
        if (this.ohW.bDy()) {
            charSequence = this.nDR.nEl.getResources().getString(2131231502);
        } else if (this.ohW.bDz()) {
            charSequence = this.nDR.nEl.getResources().getString(2131231506);
        } else if (this.ohW.bDA()) {
            charSequence = this.nDR.nEl.getResources().getString(2131231499);
        }
        pVar.setHint(charSequence);
        this.eyI.clearFocus();
    }

    public final boolean mk(String str) {
        axg();
        return true;
    }

    public final void Yt() {
        axg();
    }

    public final void Yu() {
    }

    protected void onPause() {
        super.onPause();
        this.eyI.cancel();
        this.eyI.clearFocus();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.eyI.a((FragmentActivity) this, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.eyI.a(this, menu);
        return true;
    }

    public final void a(boolean z, String[] strArr, long j, int i) {
    }

    protected final int getLayoutId() {
        return 2130903533;
    }

    public final boolean Yv() {
        axg();
        return false;
    }

    public final void wS(int i) {
        if (this.ohT != null) {
            c cVar = this.ohT;
            switch (i) {
                case 1:
                    cVar.i(true, false);
                    return;
                case 2:
                    cVar.i(false, true);
                    return;
                default:
                    cVar.i(false, false);
                    return;
            }
        }
    }
}
