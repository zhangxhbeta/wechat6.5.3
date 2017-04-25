package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.l;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelsearch.i;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.storage.u;
import java.util.List;

public final class a extends com.tencent.mm.ui.f.a.a {
    public h eAt;
    public CharSequence eAu;
    public CharSequence eAv;
    private b eAw = new b(this);
    a eAx = new a(this);
    public u euW;
    public List<String> ezU;
    public String iconUrl;
    public String username;

    public class a extends com.tencent.mm.ui.f.a.a.a {
        public View dtW;
        public ImageView dtX;
        public TextView dtY;
        public TextView dtZ;
        final /* synthetic */ a eAy;

        public a(a aVar) {
            this.eAy = aVar;
            super(aVar);
        }
    }

    public class b extends com.tencent.mm.ui.f.a.a.b {
        final /* synthetic */ a eAy;

        public b(a aVar) {
            this.eAy = aVar;
            super(aVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(2130903676, viewGroup, false);
            inflate.measure(ViewGroup.getChildMeasureSpec(MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824), viewGroup.getPaddingLeft() + viewGroup.getPaddingRight(), -1), MeasureSpec.makeMeasureSpec(-2, 1073741824));
            a aVar = this.eAy.eAx;
            aVar.dtX = (ImageView) inflate.findViewById(2131755508);
            aVar.dtY = (TextView) inflate.findViewById(2131755456);
            aVar.dtZ = (TextView) inflate.findViewById(2131755458);
            aVar.dtW = inflate.findViewById(2131757157);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.f.a.a.a aVar, com.tencent.mm.ui.f.a.a aVar2) {
            a aVar3 = (a) aVar2;
            a aVar4 = (a) aVar;
            cY(aVar4.dtW);
            com.tencent.mm.modelsearch.h.a(context, aVar4.dtX, aVar3.iconUrl, null, 2130837790);
            com.tencent.mm.modelsearch.h.b(aVar3.eAu, aVar4.dtY);
            com.tencent.mm.modelsearch.h.b(aVar3.eAv, aVar4.dtZ);
        }

        public final boolean a(Context context, com.tencent.mm.ui.f.a.a aVar) {
            a aVar2 = (a) aVar;
            p.b(this.eAy.bkC, aVar2.eAt, 0);
            Intent intent;
            if (e.hB(aVar2.username)) {
                intent = new Intent();
                intent.putExtra("enterprise_biz_name", aVar2.username);
                intent.putExtra("enterprise_biz_display_name", l.er(aVar2.username));
                intent.putExtra("enterprise_from_scene", 3);
                c.a(context, ".ui.conversation.EnterpriseConversationUI", intent);
            } else if (e.hC(aVar2.username)) {
                intent = new Intent();
                intent.putExtra("Contact_User", aVar2.username);
                intent.addFlags(67108864);
                intent.putExtra("biz_chat_from_scene", 5);
                c.a(context, ".ui.bizchat.BizChatConversationUI", intent);
            } else if (e.hD(aVar2.username)) {
                BizInfo hw = e.hw(aVar2.username);
                String CD = hw == null ? null : hw.CD();
                if (CD == null) {
                    CD = "";
                }
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", CD);
                intent2.putExtra("useJs", true);
                intent2.putExtra("srcUsername", aVar2.username);
                intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                intent2.addFlags(67108864);
                c.b(context, "webview", ".ui.tools.WebViewUI", intent2);
            } else {
                intent = new Intent();
                intent.putExtra("Chat_User", aVar2.username);
                intent.putExtra("finish_direct", true);
                c.a(context, ".ui.chatting.ChattingUI", intent);
            }
            i.jF(aVar2.username);
            return true;
        }
    }

    public a(int i) {
        super(4, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r10, com.tencent.mm.ui.f.a.a.a r11) {
        /*
        r9 = this;
        r4 = 0;
        r1 = 1;
        r2 = 0;
        r0 = r9.eAt;
        r0 = r0.cWv;
        r9.username = r0;
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.wH();
        r3 = r9.username;
        r0 = r0.LX(r3);
        r9.euW = r0;
        r0 = r9.username;
        r0 = com.tencent.mm.modelbiz.e.hw(r0);
        if (r0 != 0) goto L_0x0064;
    L_0x0020:
        r0 = "";
    L_0x0023:
        r9.iconUrl = r0;
        r0 = r9.username;
        r8 = com.tencent.mm.model.l.er(r0);
        r0 = r9.eAt;
        r0 = r0.cWt;
        switch(r0) {
            case 1: goto L_0x00a4;
            case 2: goto L_0x00a2;
            case 3: goto L_0x0067;
            case 15: goto L_0x006e;
            default: goto L_0x0032;
        };
    L_0x0032:
        r0 = r2;
        r3 = r2;
        r5 = r2;
        r6 = r4;
        r7 = r4;
        r4 = r2;
    L_0x0038:
        if (r5 == 0) goto L_0x0099;
    L_0x003a:
        r5 = com.tencent.mm.modelsearch.h.cVN;
        r5 = com.tencent.mm.pluginsdk.ui.d.e.a(r10, r8, r5);
        r9.eAu = r5;
        if (r3 == 0) goto L_0x008c;
    L_0x0044:
        r3 = r9.ezU;
        r5 = r9.bkC;
        r0 = com.tencent.mm.modelsearch.h.a(r8, r3, r0, r5);
        r9.eAu = r0;
    L_0x004e:
        if (r4 == 0) goto L_0x0063;
    L_0x0050:
        r0 = 2;
        r0 = new java.lang.CharSequence[r0];
        r0[r2] = r6;
        r2 = r9.ezU;
        r2 = com.tencent.mm.modelsearch.h.a(r10, r7, r2);
        r0[r1] = r2;
        r0 = android.text.TextUtils.concat(r0);
        r9.eAv = r0;
    L_0x0063:
        return;
    L_0x0064:
        r0 = r0.field_brandIconURL;
        goto L_0x0023;
    L_0x0067:
        r0 = r1;
    L_0x0068:
        r3 = r1;
    L_0x0069:
        r5 = r1;
        r6 = r4;
        r7 = r4;
        r4 = r2;
        goto L_0x0038;
    L_0x006e:
        r0 = r9.euW;
        r0 = r0.pD();
        r3 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r3 == 0) goto L_0x007e;
    L_0x007a:
        r0 = r9.euW;
        r0 = r0.field_username;
    L_0x007e:
        r3 = 2131234841; // 0x7f081019 float:1.808586E38 double:1.052969918E-314;
        r3 = r10.getString(r3);
        r4 = r1;
        r5 = r2;
        r6 = r3;
        r7 = r0;
        r0 = r2;
        r3 = r2;
        goto L_0x0038;
    L_0x008c:
        r0 = r9.ezU;
        r3 = r9.bkC;
        r5 = r9.eAt;
        r0 = com.tencent.mm.modelsearch.h.a(r8, r0, r3, r5);
        r9.eAu = r0;
        goto L_0x004e;
    L_0x0099:
        r0 = com.tencent.mm.modelsearch.h.cVN;
        r0 = com.tencent.mm.pluginsdk.ui.d.e.a(r10, r8, r0);
        r9.eAu = r0;
        goto L_0x004e;
    L_0x00a2:
        r0 = r2;
        goto L_0x0068;
    L_0x00a4:
        r0 = r2;
        r3 = r2;
        goto L_0x0069;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.a.a.a(android.content.Context, com.tencent.mm.ui.f.a.a$a):void");
    }

    public final com.tencent.mm.ui.f.a.a.b YL() {
        return this.eAw;
    }

    public final int YM() {
        return this.eAt.cWA;
    }
}
