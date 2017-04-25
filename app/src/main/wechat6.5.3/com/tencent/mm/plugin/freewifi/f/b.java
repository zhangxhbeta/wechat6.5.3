package com.tencent.mm.plugin.freewifi.f;

import com.tencent.mm.plugin.freewifi.d.e;
import com.tencent.mm.plugin.freewifi.g.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b {
    private static volatile boolean gaG = true;
    static Pattern gaH = Pattern.compile("\"result\":(-?[0-9]+)");
    static Pattern gaI = Pattern.compile("\"stageName\":\"(.+?)\"");

    public static void kZ(final int i) {
        j.apn().aoU().post(new Runnable() {
            public final void run() {
                if (b.gaG) {
                    if (i == 0) {
                        long currentTimeMillis = System.currentTimeMillis() - a.fWV.tw("LOCAL_CONFIG_LAST_MOBILE_NETWORK_REPORT_TIMEMILLIS");
                        v.v("MicroMsg.FreeWifi.FreeWifiServerReporter", "mobile netowrk report interval between last time is : " + currentTimeMillis);
                        if (currentTimeMillis < 0 || currentTimeMillis > 86400000) {
                            a.fWV.s("LOCAL_CONFIG_LAST_MOBILE_NETWORK_REPORT_TIMEMILLIS", System.currentTimeMillis());
                        } else {
                            v.v("MicroMsg.FreeWifi.FreeWifiServerReporter", "interval less than 24 hours. return.");
                            return;
                        }
                    }
                    b.gaG = false;
                    f apl = j.apl();
                    m.a("FreeWifiLog", f.gaM, apl, "MicroMsg.FreeWifi.FreeWifiLogStorage");
                    LinkedList apM = apl.apM();
                    String str = "ServerReportSimpleLog:" + b.E(apM);
                    m.tE(str);
                    v.i("MicroMsg.FreeWifi.FreeWifiServerReporter", str);
                    if (apM.size() > 0) {
                        new e(apM).b(new com.tencent.mm.v.e(this) {
                            final /* synthetic */ AnonymousClass1 gaK;

                            {
                                this.gaK = r1;
                            }

                            /* JADX WARNING: inconsistent code. */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public final void a(int r11, int r12, java.lang.String r13, com.tencent.mm.v.k r14) {
                                /*
                                r10 = this;
                                r9 = 1;
                                r0 = "MicroMsg.FreeWifi.FreeWifiServerReporter";
                                r1 = "errType=%d, errCode=%d, errMsg=%s";
                                r2 = 3;
                                r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x009c }
                                r3 = 0;
                                r4 = java.lang.Integer.valueOf(r11);	 Catch:{ Exception -> 0x009c }
                                r2[r3] = r4;	 Catch:{ Exception -> 0x009c }
                                r3 = 1;
                                r4 = java.lang.Integer.valueOf(r12);	 Catch:{ Exception -> 0x009c }
                                r2[r3] = r4;	 Catch:{ Exception -> 0x009c }
                                r3 = 2;
                                r2[r3] = r13;	 Catch:{ Exception -> 0x009c }
                                com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);	 Catch:{ Exception -> 0x009c }
                                r0 = com.tencent.mm.plugin.freewifi.m.bF(r11, r12);	 Catch:{ Exception -> 0x009c }
                                if (r0 == 0) goto L_0x00ab;
                            L_0x0024:
                                r14 = (com.tencent.mm.plugin.freewifi.d.e) r14;	 Catch:{ Exception -> 0x009c }
                                r0 = r14.apz();	 Catch:{ Exception -> 0x009c }
                                if (r0 == 0) goto L_0x00ab;
                            L_0x002c:
                                r1 = r0.size();	 Catch:{ Exception -> 0x009c }
                                if (r1 <= 0) goto L_0x00ab;
                            L_0x0032:
                                r1 = com.tencent.mm.plugin.freewifi.model.j.apl();	 Catch:{ Exception -> 0x009c }
                                r2 = r0.iterator();	 Catch:{ Exception -> 0x009c }
                            L_0x003a:
                                r0 = r2.hasNext();	 Catch:{ Exception -> 0x009c }
                                if (r0 == 0) goto L_0x00ab;
                            L_0x0040:
                                r0 = r2.next();	 Catch:{ Exception -> 0x009c }
                                r0 = (com.tencent.mm.protocal.c.qv) r0;	 Catch:{ Exception -> 0x009c }
                                r3 = r0.id;	 Catch:{ Exception -> 0x009c }
                                r0 = r0.bcd;	 Catch:{ Exception -> 0x009c }
                                r4 = "MicroMsg.FreeWifi.FreeWifiServerReporter";
                                r5 = "resp LinkedList<FreeWifiReport>. id=%s, errcode=%d";
                                r6 = 2;
                                r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x009c }
                                r7 = 0;
                                r6[r7] = r3;	 Catch:{ Exception -> 0x009c }
                                r7 = 1;
                                r8 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x009c }
                                r6[r7] = r8;	 Catch:{ Exception -> 0x009c }
                                com.tencent.mm.sdk.platformtools.v.i(r4, r5, r6);	 Catch:{ Exception -> 0x009c }
                                r4 = com.tencent.mm.plugin.freewifi.m.ty(r3);	 Catch:{ Exception -> 0x009c }
                                if (r4 != 0) goto L_0x003a;
                            L_0x0066:
                                if (r0 != 0) goto L_0x003a;
                            L_0x0068:
                                r0 = "MicroMsg.FreeWifi.FreeWifiLogStorage";
                                r4 = "delete. id=%s";
                                r5 = 1;
                                r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x009c }
                                r6 = 0;
                                r5[r6] = r3;	 Catch:{ Exception -> 0x009c }
                                com.tencent.mm.sdk.platformtools.v.i(r0, r4, r5);	 Catch:{ Exception -> 0x009c }
                                r0 = new com.tencent.mm.plugin.freewifi.g.e;	 Catch:{ Exception -> 0x009c }
                                r0.<init>();	 Catch:{ Exception -> 0x009c }
                                r0.field_id = r3;	 Catch:{ Exception -> 0x009c }
                                r3 = 0;
                                r3 = new java.lang.String[r3];	 Catch:{ Exception -> 0x009c }
                                r0 = r1.c(r0, r3);	 Catch:{ Exception -> 0x009c }
                                r3 = "MicroMsg.FreeWifi.FreeWifiLogStorage";
                                r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x009c }
                                r5 = "delete ret";
                                r4.<init>(r5);	 Catch:{ Exception -> 0x009c }
                                r0 = r4.append(r0);	 Catch:{ Exception -> 0x009c }
                                r0 = r0.toString();	 Catch:{ Exception -> 0x009c }
                                com.tencent.mm.sdk.platformtools.v.i(r3, r0);	 Catch:{ Exception -> 0x009c }
                                goto L_0x003a;
                            L_0x009c:
                                r0 = move-exception;
                                r1 = "MicroMsg.FreeWifi.FreeWifiServerReporter";
                                r0 = com.tencent.mm.plugin.freewifi.m.f(r0);	 Catch:{ all -> 0x00af }
                                com.tencent.mm.sdk.platformtools.v.e(r1, r0);	 Catch:{ all -> 0x00af }
                                com.tencent.mm.plugin.freewifi.f.b.gaG = r9;
                            L_0x00aa:
                                return;
                            L_0x00ab:
                                com.tencent.mm.plugin.freewifi.f.b.gaG = r9;
                                goto L_0x00aa;
                            L_0x00af:
                                r0 = move-exception;
                                com.tencent.mm.plugin.freewifi.f.b.gaG = r9;
                                throw r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.f.b.1.1.a(int, int, java.lang.String, com.tencent.mm.v.k):void");
                            }
                        });
                    } else {
                        b.gaG = true;
                    }
                }
            }
        });
    }

    static String E(LinkedList<qv> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            qv qvVar = (qv) it.next();
            stringBuilder.append("|id=").append(m.tA(qvVar.id)).append("|");
            for (CharSequence charSequence : m.tA(qvVar.muG).split("\\},")) {
                Matcher matcher = gaI.matcher(charSequence);
                String str = "";
                if (matcher.find()) {
                    str = matcher.group(1);
                }
                matcher = gaH.matcher(charSequence);
                String str2 = "0";
                if (matcher.find()) {
                    str2 = matcher.group(1);
                }
                stringBuilder.append(k.tx(str) + "=" + str2).append("|");
            }
        }
        return stringBuilder.toString();
    }
}
