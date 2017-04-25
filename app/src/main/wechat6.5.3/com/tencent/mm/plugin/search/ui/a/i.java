package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.storage.u;
import java.util.List;

public final class i extends com.tencent.mm.ui.f.a.a {
    public h eAt;
    public CharSequence eAu;
    public CharSequence eAv;
    public u euW;
    public List<String> ezU;
    public CharSequence iJg;
    private b iJh = new b(this);
    a iJi = new a(this);
    public String username;

    public class a extends com.tencent.mm.ui.f.a.a.a {
        public View dtW;
        public ImageView dtX;
        public TextView dtY;
        public TextView dtZ;
        final /* synthetic */ i iJj;
        public TextView ijk;

        public a(i iVar) {
            this.iJj = iVar;
            super(iVar);
        }
    }

    public class b extends com.tencent.mm.ui.f.a.a.b {
        final /* synthetic */ i iJj;

        public b(i iVar) {
            this.iJj = iVar;
            super(iVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(2130903677, viewGroup, false);
            inflate.measure(ViewGroup.getChildMeasureSpec(MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824), viewGroup.getPaddingLeft() + viewGroup.getPaddingRight(), -1), MeasureSpec.makeMeasureSpec(-2, 1073741824));
            a aVar = this.iJj.iJi;
            aVar.dtX = (ImageView) inflate.findViewById(2131755508);
            aVar.dtY = (TextView) inflate.findViewById(2131755456);
            aVar.dtZ = (TextView) inflate.findViewById(2131755458);
            aVar.ijk = (TextView) inflate.findViewById(2131755314);
            aVar.dtW = inflate.findViewById(2131757157);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.f.a.a.a aVar, com.tencent.mm.ui.f.a.a aVar2) {
            a aVar3 = (a) aVar;
            i iVar = (i) aVar2;
            cY(aVar3.dtW);
            if (iVar.username == null || iVar.username.length() <= 0) {
                aVar3.dtX.setImageResource(2130838080);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.m(aVar3.dtX, iVar.username);
            }
            aVar3.dtY.setText(iVar.eAu);
            aVar3.dtY.setMaxWidth(com.tencent.mm.bd.a.fromDPToPix(context, 200));
            com.tencent.mm.modelsearch.h.b(iVar.eAv, aVar3.dtZ);
            com.tencent.mm.modelsearch.h.b(iVar.iJg, aVar3.ijk);
        }

        public final boolean a(Context context, com.tencent.mm.ui.f.a.a aVar) {
            i iVar = (i) aVar;
            p.b(this.iJj.bkC, iVar.eAt, 0);
            com.tencent.mm.plugin.search.a.drp.e(new Intent().putExtra("Chat_User", iVar.username).putExtra("finish_direct", true), context);
            return true;
        }
    }

    public i(int i) {
        super(2, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r14, com.tencent.mm.ui.f.a.a.a r15) {
        /*
        r13 = this;
        r1 = 0;
        r6 = 1;
        r7 = 0;
        r0 = r13.eAt;
        r0 = r0.cWv;
        r13.username = r0;
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.wH();
        r2 = r13.username;
        r0 = r0.LX(r2);
        r13.euW = r0;
        r3 = r13.ezU;
        r0 = com.tencent.mm.modelsearch.h.cVQ;
        r4 = com.tencent.mm.modelsearch.h.cVP;
        r8 = r14.getResources();
        r5 = r13.euW;
        r0 = r5.field_username;
        r9 = com.tencent.mm.model.l.a(r5, r0);
        r0 = "SELECT memberlist FROM chatroom WHERE chatroomname=?;";
        com.tencent.mm.model.ak.yW();
        r2 = com.tencent.mm.model.c.wE();
        r10 = new java.lang.String[r6];
        r11 = r5.field_username;
        r10[r7] = r11;
        r10 = r2.rawQuery(r0, r10);
        r0 = r10.moveToFirst();
        if (r0 == 0) goto L_0x00f3;
    L_0x0044:
        r0 = r10.getString(r7);
        if (r0 != 0) goto L_0x0090;
    L_0x004a:
        r0 = r1;
    L_0x004b:
        r2 = r0;
    L_0x004c:
        r10.close();
        if (r2 == 0) goto L_0x006e;
    L_0x0051:
        r0 = r2.length;
        if (r0 <= 0) goto L_0x006e;
    L_0x0054:
        r0 = new java.lang.StringBuilder;
        r10 = "(";
        r0.<init>(r10);
        r10 = r2.length;
        r0 = r0.append(r10);
        r10 = ")";
        r0 = r0.append(r10);
        r0 = r0.toString();
        r13.iJg = r0;
    L_0x006e:
        r0 = r13.eAt;
        r0 = r0.cWt;
        switch(r0) {
            case 1: goto L_0x00f1;
            case 2: goto L_0x00ef;
            case 3: goto L_0x0097;
            case 5: goto L_0x00f1;
            case 6: goto L_0x00ef;
            case 7: goto L_0x0097;
            case 38: goto L_0x00a7;
            default: goto L_0x0075;
        };
    L_0x0075:
        r0 = r7;
        r6 = r7;
    L_0x0077:
        if (r6 == 0) goto L_0x00e6;
    L_0x0079:
        r2 = com.tencent.mm.modelsearch.h.cVN;
        r2 = com.tencent.mm.pluginsdk.ui.d.e.a(r14, r9, r2);
        r13.eAu = r2;
        if (r0 == 0) goto L_0x00d9;
    L_0x0083:
        r0 = r13.eAu;
        r2 = r13.bkC;
        r0 = com.tencent.mm.modelsearch.h.a(r0, r3, r7, r2);
        r13.eAu = r0;
    L_0x008d:
        r13.eAv = r1;
        return;
    L_0x0090:
        r2 = com.tencent.mm.modelsearch.d.cVB;
        r0 = r2.split(r0);
        goto L_0x004b;
    L_0x0097:
        r0 = r6;
    L_0x0098:
        r7 = r6;
    L_0x0099:
        r2 = r5.field_nickname;
        r13.eAv = r2;
        r2 = 2131234837; // 0x7f081015 float:1.808585E38 double:1.052969916E-314;
        r8.getString(r2);
        r12 = r0;
        r0 = r7;
        r7 = r12;
        goto L_0x0077;
    L_0x00a7:
        if (r2 == 0) goto L_0x0075;
    L_0x00a9:
        r0 = r13.eAt;
        r0 = r0.userData;
        if (r0 == 0) goto L_0x0075;
    L_0x00af:
        r0 = r13.eAt;
        r0 = r0.userData;
        r0 = r0 instanceof java.util.List;
        if (r0 == 0) goto L_0x0075;
    L_0x00b7:
        r0 = r13.eAt;
        r1 = r0.userData;
        r1 = (java.util.List) r1;
        r5 = r13.bkC;
        r0 = r14;
        r0 = com.tencent.mm.modelsearch.h.a(r0, r1, r2, r3, r4, r5);
        r1 = 2131234835; // 0x7f081013 float:1.8085847E38 double:1.052969915E-314;
        r1 = r8.getString(r1);
        r2 = 2;
        r2 = new java.lang.CharSequence[r2];
        r2[r7] = r1;
        r2[r6] = r0;
        r1 = android.text.TextUtils.concat(r2);
        r0 = r7;
        r6 = r7;
        goto L_0x0077;
    L_0x00d9:
        r0 = r13.eAu;
        r2 = r13.bkC;
        r4 = r13.eAt;
        r0 = com.tencent.mm.modelsearch.h.a(r0, r3, r2, r4);
        r13.eAu = r0;
        goto L_0x008d;
    L_0x00e6:
        r0 = com.tencent.mm.modelsearch.h.cVN;
        r0 = com.tencent.mm.pluginsdk.ui.d.e.a(r14, r9, r0);
        r13.eAu = r0;
        goto L_0x008d;
    L_0x00ef:
        r0 = r7;
        goto L_0x0098;
    L_0x00f1:
        r0 = r7;
        goto L_0x0099;
    L_0x00f3:
        r2 = r1;
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.search.ui.a.i.a(android.content.Context, com.tencent.mm.ui.f.a.a$a):void");
    }

    public final com.tencent.mm.ui.f.a.a.b YL() {
        return this.iJh;
    }

    public final int YM() {
        return this.eAt.cWA;
    }

    public final int aML() {
        if (this.eAt.cWt == 38) {
            List list = (List) this.eAt.userData;
            if (list != null && list.size() > 0) {
                return ((com.tencent.mm.modelsearch.p.i) list.get(0)).cWt;
            }
        }
        return super.aML();
    }

    public final boolean aMM() {
        return this.eAt.cWB;
    }
}
