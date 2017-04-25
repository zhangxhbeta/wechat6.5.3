package com.tencent.mm.plugin.webview.e;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.e.a.bi;
import com.tencent.mm.e.a.bt;
import com.tencent.mm.e.a.hj;
import com.tencent.mm.e.a.rc;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.bo.b;
import com.tencent.mm.model.n;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.d.ae;
import com.tencent.mm.plugin.webview.d.d;
import com.tencent.mm.plugin.webview.d.w;
import com.tencent.mm.plugin.webview.d.y;
import com.tencent.mm.plugin.webview.modelcache.k;
import com.tencent.mm.plugin.webview.modelcache.t;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.d.a;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class e implements ag {
    private static final HashMap<Integer, c> bXq;
    private b eiI = new b(this) {
        final /* synthetic */ e lhi;

        {
            this.lhi = r1;
        }

        public final void a(a aVar) {
            final String a = m.a(aVar.czu.mbW);
            final h bje = e.bje();
            new Thread(new Runnable(this) {
                final /* synthetic */ AnonymousClass5 lhk;

                public final void run() {
                    v.d("MicroMsg.SubCoreTools", "webview hijack sysMsgListener");
                    Map q = bf.q(a, "sysmsg");
                    long j = be.getLong((String) q.get(".sysmsg.hijackconfig.expiretime"), Long.MAX_VALUE);
                    String str = ".sysmsg.hijackconfig.domainlist.domain";
                    int i = 0;
                    String str2 = str;
                    while (true) {
                        String str3;
                        if (i > 0) {
                            str3 = str + i;
                        } else {
                            str3 = str2;
                        }
                        i++;
                        str2 = (String) q.get(str3);
                        if (!be.kS(str2)) {
                            g gVar = new g();
                            gVar.field_expireTime = j;
                            gVar.field_host = str2;
                            bje.b(gVar);
                            str2 = str3;
                        } else {
                            return;
                        }
                    }
                }
            }).start();
        }
    };
    private com.tencent.mm.network.m fZi = new com.tencent.mm.network.m.a(this) {
        private final byte[] bXX = new byte[0];
        final /* synthetic */ e lhi;

        {
            this.lhi = r2;
        }

        public final void cI(int i) {
            synchronized (this.bXX) {
                if (ak.getNetType(aa.getContext()) == 0) {
                    com.tencent.mm.plugin.webview.d.ag.bim().setNetWorkState(1);
                } else {
                    com.tencent.mm.plugin.webview.d.ag.bim().setNetWorkState(2);
                }
            }
        }
    };
    private w lgQ;
    private y lgR;
    private com.tencent.mm.plugin.webview.d.v lgS;
    private h lgT;
    private k lgU;
    private d lgV;
    private ae lgW;
    private com.tencent.mm.plugin.webview.c.a lgX;
    private com.tencent.mm.plugin.webview.c.b lgY;
    private com.tencent.mm.plugin.webview.b.a lgZ;
    private com.tencent.mm.plugin.webview.f.a lha = new com.tencent.mm.plugin.webview.f.a();
    private final t lhb = new t();
    private com.tencent.mm.plugin.webview.f.b lhc;
    com.tencent.mm.sdk.c.c lhd = new com.tencent.mm.sdk.c.c<rc>(this) {
        final /* synthetic */ e lhi;

        {
            this.lhi = r2;
            this.nhz = rc.class.getName().hashCode();
        }

        private static boolean a(rc rcVar) {
            if (!(rcVar instanceof rc)) {
                return false;
            }
            String xF = com.tencent.mm.model.k.xF();
            List arrayList = new ArrayList();
            arrayList.add(rcVar.bsP.bsQ);
            arrayList.add(rcVar.bsP.bsR);
            arrayList.add(rcVar.bsP.bsS);
            arrayList.add(rcVar.bsP.bsT);
            arrayList.add(rcVar.bsP.url);
            arrayList.add(rcVar.bsP.bsU);
            arrayList.add(rcVar.bsP.bsV);
            arrayList.add(rcVar.bsP.bsW);
            arrayList.add(rcVar.bsP.bsX);
            arrayList.add(rcVar.bsP.bsY);
            arrayList.add(xF);
            arrayList.add(rcVar.bsP.bsZ);
            arrayList.add(rcVar.bsP.bta);
            PString pString = new PString();
            String b = o.b(rcVar.bsP.btb, pString);
            arrayList.add(b);
            arrayList.add("");
            arrayList.add("");
            arrayList.add("");
            int F = n.F(rcVar.bsP.bsS, rcVar.bsP.bsT);
            int F2 = n.F(xF, rcVar.bsP.bsV);
            arrayList.add(String.valueOf(F));
            arrayList.add(String.valueOf(F2));
            Object obj = rcVar.bsP.btc;
            try {
                obj = URLEncoder.encode(obj, "UTF-8");
            } catch (Throwable e) {
                v.a("MicroMsg.SubCoreTools", e, "", new Object[0]);
            }
            arrayList.add(obj);
            arrayList.add(pString.value);
            String str = "MicroMsg.SubCoreTools";
            String str2 = "report(11954) : prePublishId : %s, curPublishId : %s, preUsername : %s, preChatName : %s, url : %s, preMsgIndex : %s, curChatName : %s, curChatTitle : %s, curChatMemberCount : %s, sendAppMsgScene : %s, curUserName : %s, getA8KeyScene : %s, referUrl : %s. : statExtStr:%s(%s), preChatType:%d, curChatType:%d, webViewTitle:%s, sourceAppId:%s";
            Object[] objArr = new Object[19];
            objArr[0] = rcVar.bsP.bsQ;
            objArr[1] = rcVar.bsP.bsR;
            objArr[2] = rcVar.bsP.bsS;
            objArr[3] = rcVar.bsP.bsT;
            objArr[4] = rcVar.bsP.url == null ? rcVar.bsP.url : rcVar.bsP.url.replace(",", "!");
            objArr[5] = Integer.valueOf(rcVar.bsP.bsU);
            objArr[6] = rcVar.bsP.bsV;
            objArr[7] = rcVar.bsP.bsW;
            objArr[8] = Integer.valueOf(rcVar.bsP.bsX);
            objArr[9] = Integer.valueOf(rcVar.bsP.bsY);
            objArr[10] = xF;
            objArr[11] = Integer.valueOf(rcVar.bsP.bsZ);
            objArr[12] = rcVar.bsP.bta == null ? rcVar.bsP.bta : rcVar.bsP.bta.replace(",", "!");
            objArr[13] = rcVar.bsP.btb;
            objArr[14] = b;
            objArr[15] = Integer.valueOf(F);
            objArr[16] = Integer.valueOf(F2);
            objArr[17] = rcVar.bsP.btc;
            objArr[18] = pString.value;
            v.d(str, str2, objArr);
            g.iuh.d(11954, arrayList);
            return true;
        }
    };
    com.tencent.mm.sdk.c.c lhe = new com.tencent.mm.sdk.c.c<hj>(this) {
        final /* synthetic */ e lhi;

        {
            this.lhi = r2;
            this.nhz = hj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            hj hjVar = (hj) bVar;
            if (!(hjVar instanceof hj)) {
                return false;
            }
            j.blE().a(hjVar.bhc.aZt, hjVar.bhc.aKK, hjVar.bhc.aZu);
            return true;
        }
    };
    com.tencent.mm.sdk.c.c lhf = new com.tencent.mm.sdk.c.c<bt>(this) {
        final /* synthetic */ e lhi;

        {
            this.lhi = r2;
            this.nhz = bt.class.getName().hashCode();
        }

        private static boolean a(bt btVar) {
            if (btVar instanceof bt) {
                Editor edit = aa.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                String value = com.tencent.mm.h.j.sU().getValue("WebviewDownloadTbs");
                String value2 = com.tencent.mm.h.j.sU().getValue("WebviewEnableTbs");
                String value3 = com.tencent.mm.h.j.sU().getValue("WebviewSupportedTbsVersionSection");
                v.i("MicroMsg.SubCoreTools", "updateWebViewDynamicConfig, tbsDownload = %s, tbsEnable = %s, tbsSupportedVerSec = %s", new Object[]{value, value2, value3});
                if (value != null) {
                    edit.putString("tbs_download", value);
                }
                if (value2 != null) {
                    edit.putString("tbs_enable", value2);
                }
                if (value3 != null) {
                    edit.putString("tbs_supported_ver_sec", value3);
                }
                edit.apply();
                if ("1".equals(value) && "1".equals(value2)) {
                    com.tencent.mm.pluginsdk.ui.tools.k.kZ(1);
                }
                if (value != null) {
                    try {
                        if ("0".equals(value)) {
                            v.i("MicroMsg.SubCoreTools", "tbs download disable, reset tbssdk in sandbox");
                            Intent intent = new Intent();
                            intent.setComponent(new ComponentName(aa.getPackageName(), "com.tencent.mm.booter.MMReceivers$SandBoxProcessReceiver"));
                            aa.getContext().sendBroadcast(intent);
                        }
                    } catch (Exception e) {
                        v.w("MicroMsg.SubCoreTools", "sendbroadcast ,ex = %s", new Object[]{e.getMessage()});
                    }
                }
            }
            return false;
        }
    };
    com.tencent.mm.sdk.c.c lhg = new com.tencent.mm.sdk.c.c<com.tencent.mm.e.a.b>(this) {
        final /* synthetic */ e lhi;

        {
            this.lhi = r2;
            this.nhz = com.tencent.mm.e.a.b.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            com.tencent.mm.e.a.b bVar2 = (com.tencent.mm.e.a.b) bVar;
            if (bVar2 instanceof com.tencent.mm.e.a.b) {
                Intent intent = new Intent();
                intent.putExtra("card_list", bVar2.aWk.aWl);
                intent.putExtra("result_code", bVar2.aWk.aKK);
                if (bVar2.aWk == null || bVar2.aWk.aKK != -1) {
                    j.blE().a(16, 0, intent);
                } else {
                    j.blE().a(16, -1, intent);
                }
            }
            return false;
        }
    };
    com.tencent.mm.sdk.c.c lhh = new com.tencent.mm.sdk.c.c<bi>(this) {
        final /* synthetic */ e lhi;

        {
            this.lhi = r2;
            this.nhz = bi.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            bi biVar = (bi) bVar;
            if (biVar instanceof bi) {
                Intent intent = new Intent();
                if (biVar.aYP == null || biVar.aYP.aKK != -1) {
                    j.blE().a(29, 0, intent);
                } else {
                    j.blE().a(29, -1, intent);
                }
            }
            return false;
        }
    };

    public static e biX() {
        e eVar = (e) com.tencent.mm.model.ak.yP().fY("plugin.tool");
        if (eVar != null) {
            return eVar;
        }
        eVar = new e();
        com.tencent.mm.model.ak.yP().a("plugin.tool", eVar);
        return eVar;
    }

    public static com.tencent.mm.plugin.webview.b.a biY() {
        if (biX().lgZ == null) {
            biX().lgZ = new com.tencent.mm.plugin.webview.b.a();
        }
        return biX().lgZ;
    }

    public static com.tencent.mm.plugin.webview.c.b biZ() {
        if (biX().lgY == null) {
            biX().lgY = new com.tencent.mm.plugin.webview.c.b();
        }
        return biX().lgY;
    }

    public static com.tencent.mm.plugin.webview.c.a bja() {
        if (biX().lgX == null) {
            biX().lgX = new com.tencent.mm.plugin.webview.c.a();
        }
        return biX().lgX;
    }

    public static com.tencent.mm.plugin.webview.f.b bjb() {
        if (biX().lhc == null) {
            biX().lhc = new com.tencent.mm.plugin.webview.f.b();
        }
        return biX().lhc;
    }

    public static w bjc() {
        if (biX().lgQ == null) {
            biX().lgQ = new w();
        }
        return biX().lgQ;
    }

    public static y bjd() {
        if (biX().lgR == null) {
            biX().lgR = y.bik();
        }
        return biX().lgR;
    }

    public static h bje() {
        if (biX().lgT == null) {
            e biX = biX();
            com.tencent.mm.model.ak.yW();
            biX.lgT = new h(com.tencent.mm.model.c.wE());
        }
        return biX().lgT;
    }

    public static d bjf() {
        if (biX().lgV == null) {
            e biX = biX();
            com.tencent.mm.model.ak.yW();
            biX.lgV = new d(com.tencent.mm.model.c.wE());
        }
        return biX().lgV;
    }

    public static k bjg() {
        if (biX().lgU == null) {
            e biX = biX();
            com.tencent.mm.model.ak.yW();
            biX.lgU = new k(com.tencent.mm.model.c.wE());
        }
        return biX().lgU;
    }

    public static ae bjh() {
        if (biX().lgW == null) {
            e biX = biX();
            com.tencent.mm.model.ak.yW();
            biX.lgW = new ae(com.tencent.mm.model.c.wE());
        }
        return biX().lgW;
    }

    public final void th() {
        com.tencent.mm.sdk.c.a.nhr.f(this.lhe);
        com.tencent.mm.sdk.c.a.nhr.f(this.lhf);
        com.tencent.mm.sdk.c.a.nhr.f(this.lhg);
        com.tencent.mm.sdk.c.a.nhr.f(this.lhh);
        com.tencent.mm.sdk.c.a.nhr.f(this.lhd);
        com.tencent.mm.sdk.c.a.nhr.f(this.lha);
        com.tencent.mm.model.ak.b(this.fZi);
        if (this.lgS != null) {
            com.tencent.mm.plugin.webview.d.v vVar = this.lgS;
            if (vVar.lef != null) {
                com.tencent.mm.pluginsdk.model.downloader.d.bnK();
                com.tencent.mm.pluginsdk.model.downloader.a.b(vVar.lef);
            }
            if (vVar.leg != null && vVar.leg.size() > 0) {
                for (Long l : vVar.leg) {
                    v.i("MicroMsg.WebViewAutoDownloader", "remove download task : %d", new Object[]{l});
                    com.tencent.mm.pluginsdk.model.downloader.d.bnK().dm(l.longValue());
                }
            }
        }
        if (this.lgY != null) {
            com.tencent.mm.plugin.webview.c.b bVar = this.lgY;
            com.tencent.mm.sdk.c.a.nhr.f(bVar.jeg);
            com.tencent.mm.sdk.c.a.nhr.f(bVar.dHB);
            com.tencent.mm.u.n.Bo().d(bVar);
            bVar.bhZ();
        }
        if (this.lgX != null) {
            com.tencent.mm.plugin.webview.c.a aVar = this.lgX;
            b bVar2 = aVar.lcQ;
            if (bVar2.ldf != null) {
                com.tencent.mm.model.ak.vy().c(bVar2.ldf);
            }
            c cVar = aVar.lcR;
            if (cVar.pRq != null) {
                com.tencent.mm.model.ak.vy().b(cVar.pRq.getType(), cVar.lcT);
            }
            com.tencent.mm.sdk.c.a.nhr.f(aVar.lcJ);
            if (aVar.lcS != null) {
                p.a(aVar.lcS);
                aVar.lcS = null;
            }
        }
        com.tencent.mm.model.ak.yU().b("hijackconfig", this.eiI, true);
        if (this.lgV != null) {
            this.lgV.bia();
        }
        t tVar = this.lhb;
        com.tencent.mm.model.ak.yU().b("webcache", tVar.lfU, true);
        com.tencent.mm.sdk.c.a.nhr.f(tVar.lfV);
        com.tencent.mm.sdk.c.a.nhr.f(tVar.lfW);
        com.tencent.mm.plugin.webview.modelcache.w biP = b.lgu;
        com.tencent.mm.sdk.c.a.nhr.f(biP.lgc);
        com.tencent.mm.sdk.c.a.nhr.f(biP.lgd);
        biP.dj(true);
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("WebViewHostsFilterTable".hashCode()), new c() {
            public final String[] pS() {
                return h.cic;
            }
        });
        List<com.tencent.mm.plugin.webview.modelcache.e.a> linkedList = new LinkedList();
        linkedList.add(com.tencent.mm.plugin.webview.modelcache.a.biD());
        linkedList.addAll(com.tencent.mm.plugin.webview.modelcache.p.biK());
        linkedList.add(k.biD());
        for (com.tencent.mm.plugin.webview.modelcache.e.a aVar : linkedList) {
            bXq.put(Integer.valueOf(aVar.id), aVar);
        }
        bXq.put(Integer.valueOf("WEBVIEW_JSLOG_BLOCK_LIST_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return d.cic;
            }
        });
        bXq.put(Integer.valueOf("WEBVIEW_LOCAL_DATA".hashCode()), new c() {
            public final String[] pS() {
                return ae.cic;
            }
        });
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        if (((e) com.tencent.mm.model.ak.yP().fY("plugin.webview")) == null) {
            v.e("MicroMsg.SubCoreTools", "getCore, should not be here");
            com.tencent.mm.model.ak.yP().a("plugin.webview", new e());
        }
        com.tencent.mm.sdk.c.a.nhr.e(this.lhe);
        com.tencent.mm.sdk.c.a.nhr.e(this.lhf);
        com.tencent.mm.sdk.c.a.nhr.e(this.lhg);
        com.tencent.mm.sdk.c.a.nhr.e(this.lhh);
        com.tencent.mm.sdk.c.a.nhr.e(this.lhd);
        com.tencent.mm.sdk.c.a.nhr.e(this.lha);
        com.tencent.mm.model.ak.yU().a("hijackconfig", this.eiI, true);
        com.tencent.mm.model.ak.a(this.fZi);
        t tVar = this.lhb;
        t.biM();
        com.tencent.mm.plugin.webview.modelcache.w biP = b.lgu;
        com.tencent.mm.sdk.c.a.nhr.e(biP.lgc);
        com.tencent.mm.sdk.c.a.nhr.e(biP.lgd);
        if (com.tencent.mm.plugin.webview.modelcache.c.biI()) {
            String str = "webview_cache_mp_pre_shared_preferences";
            SharedPreferences btk = aa.btk();
            str = btk != null ? btk.getString(str, "") : null;
            v.d("MicroMsg.WebViewCacheWorkerManager", "get saved cacheMsg = \n%s", new Object[]{str});
            if (!be.kS(str) && com.tencent.mm.plugin.webview.modelcache.c.biI()) {
                a.Eg(str);
            }
        }
        com.tencent.mm.model.ak.yU().a("webcache", tVar.lfU, true);
        com.tencent.mm.sdk.c.a.nhr.e(tVar.lfV);
        com.tencent.mm.sdk.c.a.nhr.e(tVar.lfW);
    }

    public final void aH(boolean z) {
        t.biM();
    }
}
