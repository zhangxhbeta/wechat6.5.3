package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.k;
import com.tencent.mm.plugin.search.ui.a.b.b;
import com.tencent.mm.ui.friend.InviteFriendUI;

public final class g extends b {
    public boolean iJa;
    public af iJd;
    private a iJe = new a(this);

    public class a extends b {
        final /* synthetic */ g iJf;

        public a(g gVar) {
            this.iJf = gVar;
            super(gVar);
        }

        public final boolean a(Context context, com.tencent.mm.ui.f.a.a aVar) {
            g gVar = (g) aVar;
            if (gVar.iJd != null) {
                Intent intent;
                if (gVar.iJd.cIB == 1 || gVar.iJd.cIB == 2) {
                    intent = new Intent();
                    intent.putExtra("Contact_User", this.iJf.iJd.getUsername());
                    intent.putExtra("Contact_Nick", this.iJf.iJd.FC());
                    intent.putExtra("Contact_Uin", this.iJf.iJd.cIA);
                    intent.putExtra("Contact_QQNick", this.iJf.iJd.getDisplayName());
                    intent.putExtra("Contact_Scene", 12);
                    intent.putExtra("Contact_RemarkName", this.iJf.iJd.FG());
                    k iH = ah.FN().iH(this.iJf.iJd.getUsername());
                    if (iH != null) {
                        intent.putExtra("Contact_Sex", iH.bBZ);
                    }
                    if (this.iJf.iJa) {
                        intent.putExtra("add_more_friend_search_scene", 1);
                    }
                    intent.putExtra("Contact_ShowUserName", false);
                    com.tencent.mm.plugin.a.a.drp.d(intent, context);
                } else if (this.iJf.iJd.cIB == 0) {
                    intent = new Intent(context, InviteFriendUI.class);
                    intent.putExtra("friend_type", 0);
                    intent.putExtra("friend_user_name", this.iJf.iJd.getUsername());
                    intent.putExtra("friend_num", this.iJf.iJd.cIA);
                    intent.putExtra("friend_nick", this.iJf.iJd.getDisplayName());
                    intent.putExtra("friend_weixin_nick", this.iJf.iJd.FC());
                    intent.putExtra("friend_scene", 12);
                    context.startActivity(intent);
                }
            }
            return true;
        }
    }

    public g(int i) {
        super(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r11, com.tencent.mm.ui.f.a.a.a r12) {
        /*
        r10 = this;
        r3 = 0;
        r9 = 2131234839; // 0x7f081017 float:1.8085855E38 double:1.052969917E-314;
        r2 = 0;
        r1 = 1;
        r0 = r10.eAt;
        r0 = r0.cWv;
        r10.username = r0;
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.wH();
        r4 = r10.username;
        r0 = r0.LX(r4);
        r10.euW = r0;
        r0 = com.tencent.mm.modelfriend.ah.FQ();
        r4 = r10.eAt;
        r4 = r4.cWu;
        r0 = r0.ae(r4);
        r10.iJd = r0;
        r0 = r10.iJd;
        r8 = r0.getDisplayName();
        r0 = r10.iJd;
        r0 = r0.FG();
        if (r0 == 0) goto L_0x0122;
    L_0x0037:
        r0 = r10.iJd;
        r0 = r0.FG();
        r0 = r0.length();
        if (r0 <= 0) goto L_0x0122;
    L_0x0043:
        r0 = r1;
    L_0x0044:
        r4 = r10.eAt;
        r4 = r4.cWt;
        switch(r4) {
            case 19: goto L_0x011b;
            case 20: goto L_0x0119;
            case 21: goto L_0x00d0;
            case 22: goto L_0x011e;
            case 23: goto L_0x0116;
            case 24: goto L_0x0091;
            case 25: goto L_0x00b4;
            default: goto L_0x004b;
        };
    L_0x004b:
        r0 = r2;
        r4 = r2;
        r5 = r2;
        r6 = r3;
        r7 = r3;
        r3 = r2;
    L_0x0051:
        if (r5 == 0) goto L_0x0100;
    L_0x0053:
        r5 = com.tencent.mm.modelsearch.h.cVN;
        r5 = com.tencent.mm.pluginsdk.ui.d.e.a(r11, r8, r5);
        r10.eAu = r5;
        if (r3 == 0) goto L_0x00f4;
    L_0x005d:
        r5 = r10.eAu;
        r8 = r10.ezU;
        r9 = r10.bkC;
        r5 = com.tencent.mm.modelsearch.h.a(r5, r8, r0, r9);
        r10.eAu = r5;
    L_0x0069:
        if (r4 == 0) goto L_0x0090;
    L_0x006b:
        r4 = com.tencent.mm.modelsearch.h.cVN;
        r4 = com.tencent.mm.pluginsdk.ui.d.e.a(r11, r6, r4);
        r10.eAv = r4;
        if (r3 == 0) goto L_0x010a;
    L_0x0075:
        r3 = r10.eAv;
        r4 = r10.ezU;
        r5 = r10.bkC;
        r0 = com.tencent.mm.modelsearch.h.a(r3, r4, r0, r5);
        r10.eAv = r0;
    L_0x0081:
        r0 = 2;
        r0 = new java.lang.CharSequence[r0];
        r0[r2] = r7;
        r2 = r10.eAv;
        r0[r1] = r2;
        r0 = android.text.TextUtils.concat(r0);
        r10.eAv = r0;
    L_0x0090:
        return;
    L_0x0091:
        r3 = r1;
    L_0x0092:
        r4 = r1;
    L_0x0093:
        if (r0 == 0) goto L_0x00b2;
    L_0x0095:
        r0 = r2;
    L_0x0096:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = r10.iJd;
        r6 = r6.cIA;
        r5 = r5.append(r6);
        r5 = r5.toString();
        r6 = r11.getString(r9);
        r7 = r6;
        r6 = r5;
        r5 = r0;
        r0 = r3;
        r3 = r4;
        r4 = r2;
        goto L_0x0051;
    L_0x00b2:
        r0 = r1;
        goto L_0x0096;
    L_0x00b4:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r3 = r10.iJd;
        r4 = r3.cIA;
        r0 = r0.append(r4);
        r0 = r0.toString();
        r3 = r11.getString(r9);
        r4 = r1;
        r5 = r2;
        r6 = r0;
        r7 = r3;
        r0 = r2;
        r3 = r2;
        goto L_0x0051;
    L_0x00d0:
        r3 = r1;
    L_0x00d1:
        r4 = r1;
    L_0x00d2:
        if (r0 == 0) goto L_0x00f2;
    L_0x00d4:
        r0 = r2;
    L_0x00d5:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = r10.iJd;
        r6 = r6.cIA;
        r5 = r5.append(r6);
        r5 = r5.toString();
        r6 = r11.getString(r9);
        r7 = r6;
        r6 = r5;
        r5 = r0;
        r0 = r3;
        r3 = r4;
        r4 = r2;
        goto L_0x0051;
    L_0x00f2:
        r0 = r1;
        goto L_0x00d5;
    L_0x00f4:
        r5 = r10.eAu;
        r8 = r10.ezU;
        r5 = com.tencent.mm.modelsearch.h.a(r11, r5, r8);
        r10.eAu = r5;
        goto L_0x0069;
    L_0x0100:
        r5 = com.tencent.mm.modelsearch.h.cVN;
        r5 = com.tencent.mm.pluginsdk.ui.d.e.a(r11, r8, r5);
        r10.eAu = r5;
        goto L_0x0069;
    L_0x010a:
        r0 = r10.eAv;
        r3 = r10.ezU;
        r0 = com.tencent.mm.modelsearch.h.a(r11, r0, r3);
        r10.eAv = r0;
        goto L_0x0081;
    L_0x0116:
        r3 = r2;
        goto L_0x0092;
    L_0x0119:
        r3 = r2;
        goto L_0x00d1;
    L_0x011b:
        r3 = r2;
        r4 = r2;
        goto L_0x00d2;
    L_0x011e:
        r3 = r2;
        r4 = r2;
        goto L_0x0093;
    L_0x0122:
        r0 = r2;
        goto L_0x0044;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.search.ui.a.g.a(android.content.Context, com.tencent.mm.ui.f.a.a$a):void");
    }

    public final com.tencent.mm.ui.f.a.a.b YL() {
        return this.iJe;
    }
}
