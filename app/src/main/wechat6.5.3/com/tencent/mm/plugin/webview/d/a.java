package com.tencent.mm.plugin.webview.d;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.d.ai.l;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    public volatile ad ldF = new ad("WebviewWorkerThread");
    ai ldG;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String ldH;
        final /* synthetic */ d ldI;
        final /* synthetic */ a ldJ;

        public AnonymousClass1(a aVar, String str, d dVar) {
            this.ldJ = aVar;
            this.ldH = str;
            this.ldI = dVar;
        }

        public final void run() {
            Map q = bf.q(this.ldH, "DNSAdvanceRelateDomain");
            LinkedList linkedList = new LinkedList();
            if (q != null && q.size() > 0) {
                String str;
                int i = 0;
                while (i < q.size()) {
                    str = (String) q.get(".DNSAdvanceRelateDomain.RelateDomain" + (i == 0 ? "" : Integer.valueOf(i)) + ".$domain");
                    if (be.kS(str)) {
                        v.i("MicroMsg.DNSPreGetOptimize", "now break for main domain i = %d", new Object[]{Integer.valueOf(i)});
                        break;
                    }
                    if (!linkedList.contains(str)) {
                        linkedList.add(str);
                    }
                    i++;
                }
                int i2 = 0;
                while (true) {
                    String str2 = (String) q.get(".DNSAdvanceRelateDomain.RelateDomain" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".Relate");
                    str = (String) q.get(".DNSAdvanceRelateDomain.RelateDomain.Relate" + (i2 == 0 ? "" : Integer.valueOf(i2)));
                    if (be.kS(str2) && be.kS(str)) {
                        break;
                    }
                    if (!(be.kS(str2) || linkedList.contains(str2))) {
                        linkedList.add(str2);
                    }
                    if (!(be.kS(str) || linkedList.contains(str))) {
                        linkedList.add(str);
                    }
                    i2++;
                }
                v.i("MicroMsg.DNSPreGetOptimize", "now break for releated domain j = %d", new Object[]{Integer.valueOf(i2)});
                l bir = this.ldJ.ldG.bir();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    InetAddress inetAddress;
                    long currentTimeMillis;
                    str = (String) it.next();
                    long currentTimeMillis2 = System.currentTimeMillis();
                    InetAddress inetAddress2 = null;
                    try {
                        inetAddress2 = InetAddress.getByName(str);
                        v.i("MicroMsg.DNSPreGetOptimize", "get dns for domain : %s, cost time : %d", new Object[]{str, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
                        inetAddress = inetAddress2;
                        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                    } catch (Exception e) {
                        v.e("MicroMsg.DNSPreGetOptimize", "get dns failed : %s", new Object[]{e.getMessage()});
                        inetAddress = inetAddress2;
                        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                    }
                    try {
                        bir.fVN = currentTimeMillis;
                        bir.url = str;
                        if (inetAddress != null) {
                            bir.bbq = true;
                        } else {
                            bir.bbq = false;
                        }
                        d dVar = this.ldI;
                        if (dVar != null) {
                            v.i("MicroMsg.WebviewReporter", "WebviewPreGetDNSReporter, netType = %d, costTime = %d, url = %s, isSuccess = %s", new Object[]{Integer.valueOf(ai.bip()), Long.valueOf(bir.fVN), bir.url, Boolean.valueOf(bir.bbq)});
                            com.tencent.mm.plugin.webview.ui.tools.d.a(dVar, 11215, Integer.valueOf(1), Long.valueOf(bir.fVN), Integer.valueOf(ak.getNetType(aa.getContext())), bir.url, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ai.leO), Integer.valueOf(ai.leP), Integer.valueOf(bir.bsZ), bir.leY);
                            if (!bir.bbq) {
                                g.iuh.a(32, 12, 1, true);
                            }
                            g.iuh.a(32, 1, 1, true);
                            g.iuh.a(32, 5, bir.fVN, true);
                        }
                    } catch (Exception e2) {
                        v.e("MicroMsg.DNSPreGetOptimize", "get dns failed 2 : %s", new Object[]{e2.getMessage()});
                        return;
                    }
                }
            }
        }
    }

    public a(ai aiVar) {
        this.ldG = aiVar;
    }

    public final ad vA() {
        if (this.ldF == null) {
            this.ldF = new ad("WebviewWorkerThread");
        }
        return this.ldF;
    }
}
