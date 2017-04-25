package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ui.chatting.ad.a;

final class u extends a {
    TextView euh;
    ImageView okm;
    ImageView olJ;
    TextView olK;
    TextView olL;

    public u(int i) {
        super(i);
    }

    public final a o(View view, boolean z) {
        super.cM(view);
        this.olJ = (ImageView) view.findViewById(2131756194);
        this.eTg = (TextView) view.findViewById(2131755027);
        this.olK = (TextView) view.findViewById(2131756197);
        this.olL = (TextView) view.findViewById(2131756196);
        this.euh = (TextView) view.findViewById(2131756195);
        this.iJL = (TextView) view.findViewById(2131755341);
        this.onC = view.findViewById(2131756148);
        this.gfb = (CheckBox) view.findViewById(2131755022);
        this.fIV = view.findViewById(2131755026);
        this.type = z ? 12 : 13;
        if (!z) {
            this.oky = (ImageView) view.findViewById(2131756230);
            this.okm = (ImageView) view.findViewById(2131756258);
            this.ieT = (ProgressBar) view.findViewById(2131756257);
        }
        return this;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(com.tencent.mm.storage.at.a r7) {
        /*
        r2 = 1;
        r1 = 0;
        r3 = r7.bLc;
        r0 = com.tencent.mm.platformtools.t.kS(r3);
        if (r0 == 0) goto L_0x006e;
    L_0x000a:
        r3 = r7.lct;
        r0 = com.tencent.mm.storage.u.LL(r3);
        if (r0 != 0) goto L_0x0018;
    L_0x0012:
        r0 = com.tencent.mm.model.m.eB(r3);
        if (r0 == 0) goto L_0x0066;
    L_0x0018:
        r0 = r2;
    L_0x0019:
        if (r0 == 0) goto L_0x006c;
    L_0x001b:
        com.tencent.mm.model.ak.yW();
        r4 = com.tencent.mm.model.c.wH();
        r5 = r7.lct;
        r4 = r4.LT(r5);
        if (r4 == 0) goto L_0x006c;
    L_0x002a:
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.wH();
        r0 = r0.LX(r3);
        r0 = r0.field_username;
        r3 = com.tencent.mm.storage.u.LL(r0);
        if (r3 != 0) goto L_0x0043;
    L_0x003d:
        r3 = com.tencent.mm.model.m.eB(r0);
        if (r3 == 0) goto L_0x0044;
    L_0x0043:
        r1 = r2;
    L_0x0044:
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x0047:
        if (r0 != 0) goto L_0x006a;
    L_0x0049:
        com.tencent.mm.model.ak.yW();
        r3 = com.tencent.mm.model.c.wH();
        r4 = r7.lct;
        r3 = r3.LT(r4);
        if (r3 != 0) goto L_0x006a;
    L_0x0058:
        r0 = r7.ldy;
        r0 = com.tencent.mm.model.m.eG(r0);
        if (r2 != 0) goto L_0x0062;
    L_0x0060:
        if (r0 == 0) goto L_0x0068;
    L_0x0062:
        r0 = "";
    L_0x0065:
        return r0;
    L_0x0066:
        r0 = r1;
        goto L_0x0019;
    L_0x0068:
        r0 = r1;
        goto L_0x0065;
    L_0x006a:
        r2 = r0;
        goto L_0x0058;
    L_0x006c:
        r1 = r3;
        goto L_0x0047;
    L_0x006e:
        r0 = r1;
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.u.a(com.tencent.mm.storage.at$a):java.lang.String");
    }
}
