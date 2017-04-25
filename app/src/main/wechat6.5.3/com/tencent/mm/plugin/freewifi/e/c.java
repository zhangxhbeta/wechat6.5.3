package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.model.f.b;
import com.tencent.mm.v.e;

public final class c {

    static class AnonymousClass1 implements e {
        final /* synthetic */ int fZx = 3;
        final /* synthetic */ String fZy;
        final /* synthetic */ b fZz;

        public AnonymousClass1(String str, b bVar) {
            this.fZy = str;
            this.fZz = bVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r10, int r11, java.lang.String r12, com.tencent.mm.v.k r13) {
            /*
            r9 = this;
            r0 = r9.fZx;
            r1 = "MicroMsg.FreeWifi.Protocol31Handler";
            r2 = "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema.callback, desc=net request [GetInterruptedProtocol31] returns. errType=%d, errCode=%d, errMsg=%s";
            r3 = 5;
            r3 = new java.lang.Object[r3];
            r4 = 0;
            r5 = r9.fZy;
            r3[r4] = r5;
            r4 = 1;
            r0 = r0 + 1;
            r5 = java.lang.Integer.valueOf(r0);
            r3[r4] = r5;
            r4 = 2;
            r5 = java.lang.Integer.valueOf(r10);
            r3[r4] = r5;
            r4 = 3;
            r5 = java.lang.Integer.valueOf(r11);
            r3[r4] = r5;
            r4 = 4;
            r3[r4] = r12;
            com.tencent.mm.sdk.platformtools.v.i(r1, r2, r3);
            if (r10 != 0) goto L_0x00ff;
        L_0x002f:
            if (r11 != 0) goto L_0x00ff;
        L_0x0031:
            r1 = com.tencent.mm.plugin.freewifi.model.f.a.fYK;
            monitor-enter(r1);
            r2 = r9.fZz;	 Catch:{ all -> 0x00d2 }
            r3 = com.tencent.mm.plugin.freewifi.model.f.a.fYK;	 Catch:{ all -> 0x00d2 }
            r3 = r3.apd();	 Catch:{ all -> 0x00d2 }
            if (r2 == r3) goto L_0x0044;
        L_0x0042:
            monitor-exit(r1);	 Catch:{ all -> 0x00d2 }
        L_0x0043:
            return;
        L_0x0044:
            r2 = com.tencent.mm.plugin.freewifi.model.f.a.fYK;	 Catch:{ all -> 0x00d2 }
            r2.ape();	 Catch:{ all -> 0x00d2 }
            monitor-exit(r1);	 Catch:{ all -> 0x00d2 }
            r13 = (com.tencent.mm.plugin.freewifi.d.g) r13;
            r1 = r13.apA();
            r2 = "MicroMsg.FreeWifi.Protocol31Handler";
            r3 = "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema.callback, desc=net request [GetInterruptedProtocol31] gets response. schemaUrl=%s";
            r4 = 3;
            r4 = new java.lang.Object[r4];
            r5 = 0;
            r6 = r9.fZy;
            r4[r5] = r6;
            r5 = 1;
            r6 = r0 + 1;
            r0 = java.lang.Integer.valueOf(r6);
            r4[r5] = r0;
            r0 = 2;
            r4[r0] = r1;
            com.tencent.mm.sdk.platformtools.v.i(r2, r3, r4);
            r0 = com.tencent.mm.plugin.freewifi.m.ty(r1);
            if (r0 != 0) goto L_0x0043;
        L_0x0075:
            r0 = "apKey=([^&]+)&ticket=([^&$]+)";
            r0 = java.util.regex.Pattern.compile(r0);
            r0 = r0.matcher(r1);
            r2 = r0.find();
            if (r2 == 0) goto L_0x0043;
        L_0x0086:
            r2 = 1;
            r2 = r0.group(r2);
            r3 = "utf8";
            r1 = java.net.URLDecoder.decode(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x00d5 }
            r2 = 2;
            r0 = r0.group(r2);
            r2 = new android.content.Intent;
            r2.<init>();
            r3 = "free_wifi_ap_key";
            r2.putExtra(r3, r1);
            r1 = "free_wifi_source";
            r3 = 5;
            r2.putExtra(r1, r3);
            r1 = "free_wifi_threeone_startup_type";
            r3 = 2;
            r2.putExtra(r1, r3);
            r1 = "free_wifi_schema_ticket";
            r2.putExtra(r1, r0);
            r1 = "free_wifi_sessionkey";
            r2.putExtra(r1, r0);
            r0 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
            r2.addFlags(r0);
            r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
            r1 = com.tencent.mm.plugin.freewifi.ui.FreeWifiEntryUI.class;
            r2.setClass(r0, r1);
            com.tencent.mm.plugin.freewifi.e.b.apF();
            com.tencent.mm.plugin.freewifi.e.b.x(r2);
            goto L_0x0043;
        L_0x00d2:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00d2 }
            throw r0;
        L_0x00d5:
            r0 = move-exception;
            r3 = "MicroMsg.FreeWifi.Protocol31Handler";
            r4 = "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=Exception happens when decoding apkey. schemaUrl=%s, apkey=%s, e.getMessage()=%s";
            r5 = 5;
            r5 = new java.lang.Object[r5];
            r7 = 0;
            r8 = r9.fZy;
            r5[r7] = r8;
            r7 = 1;
            r6 = r6 + 1;
            r6 = java.lang.Integer.valueOf(r6);
            r5[r7] = r6;
            r6 = 2;
            r5[r6] = r1;
            r1 = 3;
            r5[r1] = r2;
            r1 = 4;
            r0 = r0.getMessage();
            r5[r1] = r0;
            com.tencent.mm.sdk.platformtools.v.i(r3, r4, r5);
            goto L_0x0043;
        L_0x00ff:
            r0 = -30020; // 0xffffffffffff8abc float:NaN double:NaN;
            if (r11 != r0) goto L_0x0043;
        L_0x0103:
            r1 = com.tencent.mm.plugin.freewifi.model.f.a.fYK;
            monitor-enter(r1);
            r0 = r9.fZz;	 Catch:{ all -> 0x0117 }
            r2 = com.tencent.mm.plugin.freewifi.model.f.a.fYK;	 Catch:{ all -> 0x0117 }
            r2 = r2.apd();	 Catch:{ all -> 0x0117 }
            if (r0 == r2) goto L_0x011a;
        L_0x0114:
            monitor-exit(r1);	 Catch:{ all -> 0x0117 }
            goto L_0x0043;
        L_0x0117:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0117 }
            throw r0;
        L_0x011a:
            r0 = com.tencent.mm.plugin.freewifi.model.f.a.fYK;	 Catch:{ all -> 0x0117 }
            r0.ape();	 Catch:{ all -> 0x0117 }
            monitor-exit(r1);	 Catch:{ all -> 0x0117 }
            goto L_0x0043;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.e.c.1.a(int, int, java.lang.String, com.tencent.mm.v.k):void");
        }
    }
}
