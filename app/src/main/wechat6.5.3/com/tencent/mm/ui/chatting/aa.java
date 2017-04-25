package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import java.util.List;

public final class aa {
    public static boolean a(a aVar, List<at> list, u uVar) {
        if (aVar == null) {
            v.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, context is null");
            return false;
        } else if (list == null || list.isEmpty()) {
            v.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, select item empty");
            return false;
        } else if (uVar != null && ((int) uVar.chr) > 0) {
            return b(aVar, list, uVar);
        } else {
            v.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, contact error");
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b(com.tencent.mm.ui.chatting.ChattingUI.a r10, java.util.List<com.tencent.mm.storage.at> r11, com.tencent.mm.storage.u r12) {
        /*
        r9 = 0;
        r8 = 2;
        r4 = 1;
        r5 = 0;
        r0 = r12.field_username;
        r1 = "@chatroom";
        r0 = r0.endsWith(r1);
        if (r0 != 0) goto L_0x00ad;
    L_0x000f:
        r0 = 2131234910; // 0x7f08105e float:1.8086E38 double:1.0529699522E-314;
        r0 = r10.getString(r0);
        r1 = new java.lang.Object[r8];
        r2 = r12.tT();
        r1[r5] = r2;
        com.tencent.mm.model.ak.yW();
        r2 = com.tencent.mm.model.c.vf();
        r3 = 4;
        r2 = r2.get(r3, r9);
        r1[r4] = r2;
        r0 = java.lang.String.format(r0, r1);
        r3 = r0;
    L_0x0031:
        r0 = com.tencent.mm.plugin.report.service.g.iuh;
        r1 = 10811; // 0x2a3b float:1.515E-41 double:5.3413E-320;
        r2 = new java.lang.Object[r8];
        r6 = 7;
        r6 = java.lang.Integer.valueOf(r6);
        r2[r5] = r6;
        r6 = r11.size();
        r6 = java.lang.Integer.valueOf(r6);
        r2[r4] = r6;
        r0.h(r1, r2);
        r0 = com.tencent.mm.model.k.xQ();
        r0 = r0 & 1;
        if (r0 != 0) goto L_0x0193;
    L_0x0053:
        r0 = "MicroMsg.ChattingEditModeSendToMail";
        r1 = "use qq mail plugin to send mail";
        com.tencent.mm.sdk.platformtools.v.d(r0, r1);
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = new java.util.ArrayList;
        r2.<init>();
        r6 = r11.iterator();
    L_0x006a:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x014a;
    L_0x0070:
        r0 = r6.next();
        r0 = (com.tencent.mm.storage.at) r0;
        r7 = r0.bwn();
        if (r7 == 0) goto L_0x010e;
    L_0x007c:
        com.tencent.mm.as.k.KV();
        r0 = r0.field_imgPath;
        r0 = com.tencent.mm.as.o.lc(r0);
        r1.add(r0);
        r2.add(r9);
    L_0x008b:
        r0 = "MicroMsg.ChattingEditModeSendToMail";
        r7 = new java.lang.StringBuilder;
        r8 = "file path = ";
        r7.<init>(r8);
        r7 = r7.append(r1);
        r8 = "file name = ";
        r7 = r7.append(r8);
        r7 = r7.append(r2);
        r7 = r7.toString();
        com.tencent.mm.sdk.platformtools.v.i(r0, r7);
        goto L_0x006a;
    L_0x00ad:
        r0 = r12.field_nickname;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 == 0) goto L_0x0109;
    L_0x00b5:
        r0 = r12.field_username;
        r1 = com.tencent.mm.model.i.ej(r0);
        r0 = "";
        r2 = r1.iterator();
        r1 = r0;
    L_0x00c3:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x00ed;
    L_0x00c9:
        r0 = r2.next();
        r0 = (java.lang.String) r0;
        r0 = com.tencent.mm.model.l.er(r0);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r1 = r3.append(r1);
        r0 = r1.append(r0);
        r1 = ", ";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r1 = r0;
        goto L_0x00c3;
    L_0x00ed:
        r0 = r1.length();
        r0 = r0 + -2;
        r0 = r1.substring(r5, r0);
    L_0x00f7:
        r1 = 2131234911; // 0x7f08105f float:1.8086001E38 double:1.0529699527E-314;
        r1 = r10.getString(r1);
        r2 = new java.lang.Object[r4];
        r2[r5] = r0;
        r0 = java.lang.String.format(r1, r2);
        r3 = r0;
        goto L_0x0031;
    L_0x0109:
        r0 = r12.tT();
        goto L_0x00f7;
    L_0x010e:
        r7 = r0.bvY();
        if (r7 == 0) goto L_0x008b;
    L_0x0114:
        r0 = r0.field_content;
        r0 = com.tencent.mm.q.a.a.dV(r0);
        if (r0 == 0) goto L_0x006a;
    L_0x011c:
        r7 = r0.type;
        switch(r7) {
            case 4: goto L_0x0123;
            case 5: goto L_0x0121;
            case 6: goto L_0x0123;
            default: goto L_0x0121;
        };
    L_0x0121:
        goto L_0x008b;
    L_0x0123:
        r7 = com.tencent.mm.pluginsdk.model.app.am.Wf();
        r8 = r0.aXa;
        r7 = r7.Gu(r8);
        if (r7 == 0) goto L_0x006a;
    L_0x012f:
        r8 = new java.io.File;
        r7 = r7.field_fileFullPath;
        r8.<init>(r7);
        r7 = r8.exists();
        if (r7 == 0) goto L_0x008b;
    L_0x013c:
        r7 = r8.getAbsolutePath();
        r1.add(r7);
        r0 = r0.title;
        r2.add(r0);
        goto L_0x008b;
    L_0x014a:
        r0 = new com.tencent.mm.ui.chatting.QQMailHistoryExporter;
        r6 = r10.nDR;
        r6 = r6.nEl;
        r0.<init>(r6, r11, r12);
        r0 = r0.bGp();
        r6 = new android.content.Intent;
        r6.<init>();
        r7 = "mail_mode";
        r8 = 6;
        r6.putExtra(r7, r8);
        r7 = "mail_content";
        r6.putExtra(r7, r0);
        r0 = "subject";
        r6.putExtra(r0, r3);
        r0 = "show_qqmail";
        r6.putExtra(r0, r4);
        r3 = "mail_attach";
        r0 = r1;
        r0 = (java.util.ArrayList) r0;
        r6.putStringArrayListExtra(r3, r0);
        r1 = "mail_attach_title";
        r0 = r2;
        r0 = (java.util.ArrayList) r0;
        r6.putStringArrayListExtra(r1, r0);
        r0 = "qqmail";
        r1 = ".ui.ComposeUI";
        r2 = 220; // 0xdc float:3.08E-43 double:1.087E-321;
        com.tencent.mm.ay.c.a(r10, r0, r1, r6, r2);
    L_0x0192:
        return r5;
    L_0x0193:
        r0 = "MicroMsg.ChattingEditModeSendToMail";
        r1 = "use order mail app to send mail";
        com.tencent.mm.sdk.platformtools.v.w(r0, r1);
        r1 = new com.tencent.mm.ui.chatting.dt;
        r0 = r10.nDR;
        r0 = r0.nEl;
        r1.<init>(r0, r11, r12);
        r0 = r1.bGp();
        r2 = new android.content.Intent;
        r6 = "android.intent.action.SEND_MULTIPLE";
        r2.<init>(r6);
        r6 = "message/rfc822";
        r2.setType(r6);
        r6 = "android.intent.extra.SUBJECT";
        r2.putExtra(r6, r3);
        r3 = "android.intent.extra.TEXT";
        r2.putExtra(r3, r0);
        r3 = "android.intent.extra.STREAM";
        r6 = "MicroMsg.OtherMailHistoryExporter";
        r7 = "get image attach: history is null? %B, selectItems.size = %d";
        r8 = new java.lang.Object[r8];
        r0 = r1.oyJ;
        if (r0 != 0) goto L_0x0201;
    L_0x01d2:
        r0 = r4;
    L_0x01d3:
        r0 = java.lang.Boolean.valueOf(r0);
        r8[r5] = r0;
        r0 = r1.omM;
        r0 = r0.size();
        r0 = java.lang.Integer.valueOf(r0);
        r8[r4] = r0;
        com.tencent.mm.sdk.platformtools.v.d(r6, r7, r8);
        r0 = r1.oyJ;
        if (r0 == 0) goto L_0x0203;
    L_0x01ec:
        r0 = r1.oyK;
    L_0x01ee:
        r2.putParcelableArrayListExtra(r3, r0);
        r0 = 2131234909; // 0x7f08105d float:1.8085997E38 double:1.052969952E-314;
        r0 = r10.getString(r0);	 Catch:{ ActivityNotFoundException -> 0x0212 }
        r0 = android.content.Intent.createChooser(r2, r0);	 Catch:{ ActivityNotFoundException -> 0x0212 }
        r10.startActivity(r0);	 Catch:{ ActivityNotFoundException -> 0x0212 }
    L_0x01ff:
        r5 = r4;
        goto L_0x0192;
    L_0x0201:
        r0 = r5;
        goto L_0x01d3;
    L_0x0203:
        r0 = "MicroMsg.OtherMailHistoryExporter";
        r6 = "had not exported, do export first";
        com.tencent.mm.sdk.platformtools.v.w(r0, r6);
        r1.bGp();
        r0 = r1.oyK;
        goto L_0x01ee;
    L_0x0212:
        r0 = move-exception;
        r0 = r10.nDR;
        r0 = r0.nEl;
        r1 = 2131234912; // 0x7f081060 float:1.8086003E38 double:1.052969953E-314;
        r0 = android.widget.Toast.makeText(r0, r1, r5);
        r0.show();
        goto L_0x01ff;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.aa.b(com.tencent.mm.ui.chatting.ChattingUI$a, java.util.List, com.tencent.mm.storage.u):boolean");
    }
}
