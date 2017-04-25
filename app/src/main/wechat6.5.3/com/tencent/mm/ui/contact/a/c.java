package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelsearch.p.h;
import java.util.List;
import java.util.regex.Pattern;

public final class c extends a {
    private static final Pattern cVB = Pattern.compile(";");
    public String[] cUQ;
    public CharSequence dtS;
    public CharSequence dtT;
    public h eAt;
    private List<String> ezU;
    public CharSequence oJl;
    private b oJm = new b(this);
    a oJn = new a(this);
    public String username;

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public View dtW;
        public ImageView dtX;
        public TextView dtY;
        public TextView dtZ;
        public CheckBox dua;
        public TextView ijk;
        final /* synthetic */ c oJo;

        public a(c cVar) {
            this.oJo = cVar;
            super(cVar);
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        final /* synthetic */ c oJo;

        public b(c cVar) {
            this.oJo = cVar;
            super(cVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(2130904338, viewGroup, false);
            a aVar = this.oJo.oJn;
            aVar.dtX = (ImageView) inflate.findViewById(2131755508);
            aVar.dtY = (TextView) inflate.findViewById(2131755456);
            aVar.dtY.setMaxWidth(com.tencent.mm.bd.a.fromDPToPix(context, 200));
            aVar.dtZ = (TextView) inflate.findViewById(2131755458);
            aVar.ijk = (TextView) inflate.findViewById(2131755314);
            aVar.dtW = inflate.findViewById(2131758337);
            aVar.dua = (CheckBox) inflate.findViewById(2131755510);
            if (this.oJo.eyw) {
                aVar.dtW.setBackgroundResource(2130838048);
            }
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            a aVar3 = (a) aVar;
            c cVar = (c) aVar2;
            if (cVar.username == null || cVar.username.length() <= 0) {
                aVar3.dtX.setImageResource(2130838080);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.m(aVar3.dtX, cVar.username);
            }
            com.tencent.mm.modelsearch.h.a(cVar.dtS, aVar3.dtY);
            com.tencent.mm.modelsearch.h.a(cVar.dtT, aVar3.dtZ);
            com.tencent.mm.modelsearch.h.a(cVar.oJl, aVar3.ijk);
            if (this.oJo.oHa) {
                if (z) {
                    aVar3.dua.setChecked(true);
                    aVar3.dua.setEnabled(false);
                } else {
                    aVar3.dua.setChecked(z2);
                    aVar3.dua.setEnabled(true);
                }
                aVar3.dua.setVisibility(0);
                return;
            }
            aVar3.dua.setVisibility(8);
        }

        public final boolean NG() {
            if (this.oJo.eAt != null) {
                p.b(this.oJo.bkC, this.oJo.eAt, 1);
            }
            return false;
        }
    }

    public c(int i) {
        super(3, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bo(android.content.Context r12) {
        /*
        r11 = this;
        r1 = 0;
        r6 = 1;
        r7 = 0;
        r0 = r11.eAt;
        if (r0 == 0) goto L_0x005d;
    L_0x0007:
        r0 = r11.cUQ;
        if (r0 == 0) goto L_0x005b;
    L_0x000b:
        r0 = r11.cUQ;
        r0 = r0.length;
        if (r0 <= 0) goto L_0x005b;
    L_0x0010:
        r0 = r11.cUQ;
        r0 = com.tencent.mm.sdk.platformtools.be.g(r0);
        r11.ezU = r0;
        r0 = r6;
    L_0x0019:
        r2 = r11.euW;
        if (r2 != 0) goto L_0x0043;
    L_0x001d:
        com.tencent.mm.model.ak.yW();
        r2 = com.tencent.mm.model.c.wH();
        r3 = r11.eAt;
        r3 = r3.cWv;
        r2 = r2.LS(r3);
        r11.euW = r2;
        r2 = r11.euW;
        if (r2 != 0) goto L_0x0043;
    L_0x0032:
        com.tencent.mm.model.ak.yW();
        r2 = com.tencent.mm.model.c.wH();
        r3 = r11.eAt;
        r3 = r3.cWv;
        r2 = r2.LW(r3);
        r11.euW = r2;
    L_0x0043:
        r2 = r11.euW;
        if (r2 != 0) goto L_0x005f;
    L_0x0047:
        r0 = "MicroMsg.ChatroomDataItem";
        r1 = "filling dataItem Occur Error Contact is null, position=%d";
        r2 = new java.lang.Object[r6];
        r3 = r11.position;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r7] = r3;
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
    L_0x005a:
        return;
    L_0x005b:
        r0 = r7;
        goto L_0x0019;
    L_0x005d:
        r0 = r7;
        goto L_0x0043;
    L_0x005f:
        r2 = r11.euW;
        r2 = r2.field_username;
        r11.username = r2;
        if (r0 == 0) goto L_0x0127;
    L_0x0067:
        r3 = r11.eAt;
        r0 = r11.euW;
        r8 = r11.cUQ;
        r9 = r12.getResources();
        r2 = r0.field_username;
        r10 = com.tencent.mm.model.l.a(r0, r2);
        r2 = "SELECT memberlist FROM chatroom WHERE chatroomname=?;";
        com.tencent.mm.model.ak.yW();
        r4 = com.tencent.mm.model.c.wE();
        r5 = new java.lang.String[r6];
        r0 = r0.field_username;
        r5[r7] = r0;
        r4 = r4.rawQuery(r2, r5);
        r0 = r4.moveToFirst();
        if (r0 == 0) goto L_0x0158;
    L_0x0091:
        r0 = r4.getString(r7);
        if (r0 != 0) goto L_0x00db;
    L_0x0097:
        r0 = r1;
    L_0x0098:
        r2 = r0;
    L_0x0099:
        r4.close();
        if (r2 == 0) goto L_0x00bb;
    L_0x009e:
        r0 = r2.length;
        if (r0 <= 0) goto L_0x00bb;
    L_0x00a1:
        r0 = new java.lang.StringBuilder;
        r4 = "(";
        r0.<init>(r4);
        r4 = r2.length;
        r0 = r0.append(r4);
        r4 = ")";
        r0 = r0.append(r4);
        r0 = r0.toString();
        r11.oJl = r0;
    L_0x00bb:
        r0 = r3.cWt;
        switch(r0) {
            case 1: goto L_0x0156;
            case 2: goto L_0x00e3;
            case 3: goto L_0x00e2;
            case 5: goto L_0x0156;
            case 6: goto L_0x00e3;
            case 7: goto L_0x00e2;
            case 38: goto L_0x00eb;
            default: goto L_0x00c0;
        };
    L_0x00c0:
        r0 = r7;
        r6 = r7;
    L_0x00c2:
        r2 = com.tencent.mm.sdk.platformtools.be.g(r8);
        if (r6 == 0) goto L_0x0120;
    L_0x00c8:
        r3 = cVP;
        r3 = com.tencent.mm.pluginsdk.ui.d.e.a(r12, r10, r3);
        if (r0 == 0) goto L_0x011b;
    L_0x00d0:
        r0 = r11.bkC;
        r0 = com.tencent.mm.modelsearch.h.a(r3, r2, r7, r0);
    L_0x00d6:
        r11.dtS = r0;
        r11.dtT = r1;
        goto L_0x005a;
    L_0x00db:
        r2 = cVB;
        r0 = r2.split(r0);
        goto L_0x0098;
    L_0x00e2:
        r7 = r6;
    L_0x00e3:
        r0 = r6;
    L_0x00e4:
        r2 = 2131234837; // 0x7f081015 float:1.808585E38 double:1.052969916E-314;
        r9.getString(r2);
        goto L_0x00c2;
    L_0x00eb:
        if (r2 == 0) goto L_0x00c0;
    L_0x00ed:
        r0 = r3.userData;
        if (r0 == 0) goto L_0x00c0;
    L_0x00f1:
        r0 = r3.userData;
        r0 = r0 instanceof java.util.List;
        if (r0 == 0) goto L_0x00c0;
    L_0x00f7:
        r1 = r3.userData;
        r1 = (java.util.List) r1;
        r3 = r11.ezU;
        r4 = cVP;
        r5 = r11.bkC;
        r0 = r12;
        r0 = com.tencent.mm.modelsearch.h.a(r0, r1, r2, r3, r4, r5);
        r1 = 2131234835; // 0x7f081013 float:1.8085847E38 double:1.052969915E-314;
        r1 = r9.getString(r1);
        r2 = 2;
        r2 = new java.lang.CharSequence[r2];
        r2[r7] = r1;
        r2[r6] = r0;
        r1 = android.text.TextUtils.concat(r2);
        r0 = r7;
        r6 = r7;
        goto L_0x00c2;
    L_0x011b:
        r0 = com.tencent.mm.modelsearch.h.a(r12, r3, r2);
        goto L_0x00d6;
    L_0x0120:
        r0 = cVP;
        r0 = com.tencent.mm.pluginsdk.ui.d.e.a(r12, r10, r0);
        goto L_0x00d6;
    L_0x0127:
        r0 = r11.euW;
        r1 = r11.euW;
        r1 = r1.field_username;
        r0 = com.tencent.mm.model.l.a(r0, r1);
        r11.dtS = r0;
        r0 = r11.username;
        r0 = com.tencent.mm.modelsearch.h.jA(r0);
        if (r0 <= 0) goto L_0x005a;
    L_0x013b:
        r1 = new java.lang.StringBuilder;
        r2 = "(";
        r1.<init>(r2);
        r0 = r1.append(r0);
        r1 = ")";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r11.oJl = r0;
        goto L_0x005a;
    L_0x0156:
        r0 = r7;
        goto L_0x00e4;
    L_0x0158:
        r2 = r1;
        goto L_0x0099;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.contact.a.c.bo(android.content.Context):void");
    }

    public final com.tencent.mm.ui.contact.a.a.b NE() {
        return this.oJm;
    }

    protected final com.tencent.mm.ui.contact.a.a.a NF() {
        return this.oJn;
    }

    public final boolean aMM() {
        return this.eAt.cWB;
    }
}
