package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.friend.InviteFriendUI;

public final class f extends b {
    public b iIZ;
    public boolean iJa;
    private a iJb = new a(this);

    public class a extends b.b {
        final /* synthetic */ f iJc;

        public a(f fVar) {
            this.iJc = fVar;
            super(fVar);
        }

        public final boolean a(Context context, com.tencent.mm.ui.f.a.a aVar) {
            f fVar = (f) aVar;
            if (fVar.iIZ != null) {
                Intent intent;
                if (fVar.iIZ.status == 1 || fVar.iIZ.status == 2) {
                    v.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin On Or Weixin Friend");
                    intent = new Intent();
                    intent.putExtra("Contact_User", this.iJc.iIZ.getUsername());
                    intent.putExtra("Contact_Nick", this.iJc.iIZ.EG());
                    intent.putExtra("Contact_Mobile_MD5", this.iJc.iIZ.EB());
                    intent.putExtra("Contact_Alias", this.iJc.iIZ.cHh);
                    intent.putExtra("Contact_Sex", this.iJc.iIZ.cHc);
                    intent.putExtra("Contact_Signature", this.iJc.iIZ.cHf);
                    intent.putExtra("Contact_RegionCode", RegionCodeDecoder.Y(this.iJc.iIZ.cHl, this.iJc.iIZ.cHd, this.iJc.iIZ.cHe));
                    intent.putExtra("Contact_Scene", 13);
                    intent.putExtra("Contact_ShowUserName", false);
                    if (this.iJc.iJa) {
                        intent.putExtra("add_more_friend_search_scene", 1);
                    }
                    com.tencent.mm.plugin.a.a.drp.d(intent, context);
                } else if (this.iJc.iIZ.status == 0) {
                    v.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin Off");
                    intent = new Intent(context, InviteFriendUI.class);
                    intent.putExtra("friend_type", 1);
                    intent.putExtra("friend_user_name", this.iJc.iIZ.getUsername());
                    intent.putExtra("friend_num", this.iJc.iIZ.EJ());
                    intent.putExtra("friend_nick", this.iJc.iIZ.ED());
                    intent.putExtra("friend_weixin_nick", this.iJc.iIZ.EG());
                    intent.putExtra("friend_scene", 13);
                    context.startActivity(intent);
                } else {
                    v.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin status unknown");
                }
            }
            return true;
        }
    }

    public f(int i) {
        super(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r11, com.tencent.mm.ui.f.a.a.a r12) {
        /*
        r10 = this;
        r0 = 0;
        r6 = 2131234836; // 0x7f081014 float:1.8085849E38 double:1.0529699157E-314;
        r2 = 0;
        r1 = 1;
        r3 = r10.eAt;
        r3 = r3.cWv;
        r10.username = r3;
        com.tencent.mm.model.ak.yW();
        r3 = com.tencent.mm.model.c.wH();
        r4 = r10.username;
        r3 = r3.LX(r4);
        r10.euW = r3;
        r3 = com.tencent.mm.modelfriend.ah.FL();
        r4 = r10.eAt;
        r4 = r4.cWu;
        r3 = r3.ad(r4);
        r10.iIZ = r3;
        r3 = r10.iIZ;
        r8 = r3.ED();
        r3 = r10.eAt;
        r3 = r3.cWt;
        switch(r3) {
            case 5: goto L_0x00d8;
            case 6: goto L_0x00d6;
            case 7: goto L_0x009e;
            case 8: goto L_0x0036;
            case 9: goto L_0x0036;
            case 10: goto L_0x0036;
            case 11: goto L_0x0036;
            case 12: goto L_0x00d3;
            case 13: goto L_0x00d1;
            case 14: goto L_0x007c;
            case 15: goto L_0x0036;
            case 16: goto L_0x008d;
            default: goto L_0x0036;
        };
    L_0x0036:
        r3 = r2;
        r4 = r2;
        r5 = r2;
        r6 = r0;
        r7 = r0;
        r0 = r2;
    L_0x003c:
        if (r5 == 0) goto L_0x00bd;
    L_0x003e:
        r5 = com.tencent.mm.modelsearch.h.cVN;
        r5 = com.tencent.mm.pluginsdk.ui.d.e.a(r11, r8, r5);
        r10.eAu = r5;
        if (r3 == 0) goto L_0x00b2;
    L_0x0048:
        r5 = r10.eAu;
        r8 = r10.ezU;
        r9 = r10.bkC;
        r5 = com.tencent.mm.modelsearch.h.a(r5, r8, r0, r9);
        r10.eAu = r5;
    L_0x0054:
        if (r4 == 0) goto L_0x007b;
    L_0x0056:
        r4 = com.tencent.mm.modelsearch.h.cVN;
        r4 = com.tencent.mm.pluginsdk.ui.d.e.a(r11, r6, r4);
        r10.eAv = r4;
        if (r3 == 0) goto L_0x00c6;
    L_0x0060:
        r3 = r10.eAv;
        r4 = r10.ezU;
        r5 = r10.bkC;
        r0 = com.tencent.mm.modelsearch.h.a(r3, r4, r0, r5);
        r10.eAv = r0;
    L_0x006c:
        r0 = 2;
        r0 = new java.lang.CharSequence[r0];
        r0[r2] = r7;
        r2 = r10.eAv;
        r0[r1] = r2;
        r0 = android.text.TextUtils.concat(r0);
        r10.eAv = r0;
    L_0x007b:
        return;
    L_0x007c:
        r0 = r1;
    L_0x007d:
        r3 = r1;
    L_0x007e:
        r4 = r10.iIZ;
        r4 = r4.EJ();
        r5 = r11.getString(r6);
        r6 = r4;
        r7 = r5;
        r4 = r2;
        r5 = r1;
        goto L_0x003c;
    L_0x008d:
        r0 = r10.iIZ;
        r0 = r0.EJ();
        r3 = r11.getString(r6);
        r4 = r1;
        r5 = r2;
        r6 = r0;
        r7 = r3;
        r0 = r2;
        r3 = r2;
        goto L_0x003c;
    L_0x009e:
        r0 = r1;
    L_0x009f:
        r3 = r1;
    L_0x00a0:
        r4 = r10.iIZ;
        r4 = r4.EG();
        r5 = 2131234842; // 0x7f08101a float:1.8085861E38 double:1.0529699187E-314;
        r5 = r11.getString(r5);
        r6 = r4;
        r7 = r5;
        r4 = r1;
        r5 = r2;
        goto L_0x003c;
    L_0x00b2:
        r5 = r10.eAu;
        r8 = r10.ezU;
        r5 = com.tencent.mm.modelsearch.h.a(r11, r5, r8);
        r10.eAu = r5;
        goto L_0x0054;
    L_0x00bd:
        r5 = com.tencent.mm.modelsearch.h.cVN;
        r5 = com.tencent.mm.pluginsdk.ui.d.e.a(r11, r8, r5);
        r10.eAu = r5;
        goto L_0x0054;
    L_0x00c6:
        r0 = r10.eAv;
        r3 = r10.ezU;
        r0 = com.tencent.mm.modelsearch.h.a(r11, r0, r3);
        r10.eAv = r0;
        goto L_0x006c;
    L_0x00d1:
        r0 = r2;
        goto L_0x007d;
    L_0x00d3:
        r0 = r2;
        r3 = r2;
        goto L_0x007e;
    L_0x00d6:
        r0 = r2;
        goto L_0x009f;
    L_0x00d8:
        r0 = r2;
        r3 = r2;
        goto L_0x00a0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.search.ui.a.f.a(android.content.Context, com.tencent.mm.ui.f.a.a$a):void");
    }

    public final com.tencent.mm.ui.f.a.a.b YL() {
        return this.iJb;
    }
}
