package com.tencent.mm.plugin.ipcall.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ae.n;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.e.a.ao;
import com.tencent.mm.e.a.aq;
import com.tencent.mm.e.a.hb;
import com.tencent.mm.e.a.hc;
import com.tencent.mm.e.a.hd;
import com.tencent.mm.e.a.on;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.ipcall.a.c.a;
import com.tencent.mm.plugin.ipcall.a.c.b;
import com.tencent.mm.plugin.ipcall.a.g.d;
import com.tencent.mm.plugin.ipcall.a.g.g;
import com.tencent.mm.plugin.ipcall.a.g.h;
import com.tencent.mm.plugin.ipcall.a.g.j;
import com.tencent.mm.plugin.ipcall.a.g.l;
import com.tencent.mm.plugin.ipcall.d.1;
import com.tencent.mm.plugin.ipcall.d.2;
import com.tencent.mm.plugin.ipcall.ui.IPCallDialUI;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import java.util.HashMap;
import java.util.Map;

public final class i implements ag {
    private static HashMap<Integer, c> gFA;
    private static i gFg = null;
    private g gFh = new g();
    private a gFi = new a();
    private b gFj = new b();
    private com.tencent.mm.plugin.ipcall.a.b.b gFk = new com.tencent.mm.plugin.ipcall.a.b.b();
    private f gFl = new f();
    private d gFm;
    private l gFn;
    private j gFo;
    private h gFp;
    private com.tencent.mm.plugin.voip.video.h gFq;
    private com.tencent.mm.plugin.voip.video.d gFr;
    private Context gFs;
    private long gFt;
    private com.tencent.mm.sdk.c.c gFu = new com.tencent.mm.sdk.c.c<aq>(this) {
        final /* synthetic */ i gFB;

        {
            this.gFB = r2;
            this.nhz = aq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            v.d("MicroMsg.SubCoreIPCall", "change language");
            com.tencent.mm.plugin.ipcall.b.a.avz();
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c gFv = new com.tencent.mm.sdk.c.c<ao>(this) {
        final /* synthetic */ i gFB;

        {
            this.gFB = r2;
            this.nhz = ao.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ao aoVar = (ao) bVar;
            if (aoVar instanceof ao) {
                aoVar.aYh.aYi = i.auq().aug();
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c gFw = new com.tencent.mm.sdk.c.c<on>(this) {
        final /* synthetic */ i gFB;

        {
            this.gFB = r2;
            this.nhz = on.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            on onVar = (on) bVar;
            if (onVar instanceof on) {
                Intent intent = new Intent(aa.getContext(), IPCallDialUI.class);
                intent.setFlags(268435456);
                intent.putExtra("IPCallTalkUI_contactId", onVar.bpM.bpN);
                intent.putExtra("IPCallTalkUI_countryCode", onVar.bpM.bpO);
                intent.putExtra("IPCallTalkUI_nickname", onVar.bpM.aGX);
                intent.putExtra("IPCallTalkUI_phoneNumber", onVar.bpM.bpP);
                aa.getContext().startActivity(intent);
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c gFx = new com.tencent.mm.sdk.c.c<hd>(this) {
        final /* synthetic */ i gFB;

        {
            this.gFB = r2;
            this.nhz = hd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            hd hdVar = (hd) bVar;
            if (hdVar instanceof hd) {
                int i;
                h auu = i.auu();
                long j = hdVar.bgT.bgU;
                Map map = hdVar.bgT.bgV;
                if (map != null) {
                    g gVar = new g();
                    gVar.field_svrId = j;
                    gVar.field_title = (String) map.get(".sysmsg.WeChatOutMsg.Title");
                    if (gVar.field_title == null) {
                        gVar.field_title = "";
                    }
                    gVar.field_content = (String) map.get(".sysmsg.WeChatOutMsg.Content");
                    if (gVar.field_content == null) {
                        gVar.field_content = "";
                    }
                    int i2 = be.getInt((String) map.get(".sysmsg.WeChatOutMsg.MsgType"), 0);
                    gVar.field_msgType = i2;
                    gVar.field_pushTime = be.getLong((String) map.get(".sysmsg.WeChatOutMsg.PushTime"), 0);
                    gVar.field_descUrl = (String) map.get(".sysmsg.WeChatOutMsg.DescUrl");
                    if (gVar.field_descUrl == null) {
                        gVar.field_descUrl = "";
                    }
                    v.i("MicroMsg.IPCallMsgStorage", "insertNewXml svrId:%s,title:%s,content:%s,msgType:%s,pushTime:%s,descUrl=%s", new Object[]{gVar.field_svrId, gVar.field_title, gVar.field_content, gVar.field_msgType, gVar.field_pushTime, gVar.field_descUrl});
                    auu.b(gVar);
                    i = i2;
                } else {
                    i = -1;
                }
                if (i != -1) {
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(t.a.nqM, Integer.valueOf(i));
                }
                ak.yW();
                com.tencent.mm.model.c.vf().a(t.a.nqL, Boolean.valueOf(true));
                com.tencent.mm.plugin.report.service.g.iuh.h(13254, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(i), Integer.valueOf(-1)});
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c gFy = new com.tencent.mm.sdk.c.c<hb>(this) {
        final /* synthetic */ i gFB;

        {
            this.gFB = r2;
            this.nhz = hb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            hb hbVar = (hb) bVar;
            if (hbVar instanceof hb) {
                com.tencent.mm.plugin.ipcall.a.g.a uI = com.tencent.mm.plugin.ipcall.a.g.a.uI(hbVar.bgN.bgO);
                if (be.kS(uI.aXz) && be.kS(uI.gkC)) {
                    v.i("MicroMsg.SubCoreIPCall", "IPCallActivityXmlEvent clear activity");
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(t.a.nqW, Boolean.valueOf(false));
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(t.a.nqX, "");
                } else {
                    if (!be.kS(uI.gmz)) {
                        n.GG().a(uI.gmz, null);
                    }
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(t.a.nqW, Boolean.valueOf(true));
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(t.a.nqX, hbVar.bgN.bgO);
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c gFz = new com.tencent.mm.sdk.c.c<hc>(this) {
        final /* synthetic */ i gFB;

        {
            this.gFB = r2;
            this.nhz = hc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            hc hcVar = (hc) bVar;
            if (hcVar instanceof hc) {
                if (hcVar.bgP.bgS && this.gFB.gFt == hcVar.bgP.bgR && this.gFB.gFs != null) {
                    Context b = this.gFB.gFs;
                    v.i("MicroMsg.IPCallPluginUtil", "tryShowNavAlert");
                    if (com.tencent.mm.plugin.ipcall.d.atT()) {
                        int i;
                        int i2 = com.tencent.mm.h.j.sU().getInt("WCOMaxTimesForTryShowWcoMainFromVoip", 0);
                        ak.yW();
                        int intValue = ((Integer) com.tencent.mm.model.c.vf().get(t.a.nqP, Integer.valueOf(0))).intValue();
                        ak.yW();
                        long longValue = ((Long) com.tencent.mm.model.c.vf().get(t.a.nqO, Long.valueOf(0))).longValue();
                        long Nh = be.Nh();
                        if (Nh - longValue > 86400) {
                            i = 0;
                            v.i("MicroMsg.IPCallPluginUtil", "tryShowNavAlert reset time");
                        } else {
                            i = intValue;
                        }
                        if (i >= i2) {
                            v.i("MicroMsg.IPCallPluginUtil", "tryShowNavAlert reach max time" + i2);
                        } else if (Nh - longValue < 1800) {
                            v.i("MicroMsg.IPCallPluginUtil", "tryShowNavAlert not reach INTERVAL_TIMES_TRY_SHOW_WCO_MAIN");
                        } else {
                            i++;
                            ak.yW();
                            com.tencent.mm.model.c.vf().a(t.a.nqP, Integer.valueOf(i));
                            ak.yW();
                            com.tencent.mm.model.c.vf().a(t.a.nqO, Long.valueOf(Nh));
                            com.tencent.mm.ui.base.g.a(b, 2131233333, 2131233443, new 1(), new 2());
                            this.gFB.gFs = null;
                            this.gFB.gFt = 0;
                        }
                    }
                    com.tencent.mm.plugin.report.service.g.iuh.h(13338, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                    this.gFB.gFs = null;
                    this.gFB.gFt = 0;
                }
                if (!hcVar.bgP.bgS) {
                    if (hcVar.bgP.bgR == 0) {
                        this.gFB.gFs = null;
                        this.gFB.gFt = 0;
                    } else {
                        this.gFB.gFs = hcVar.bgP.bgQ;
                        this.gFB.gFt = hcVar.bgP.bgR;
                    }
                }
            }
            return false;
        }
    };

    static {
        HashMap hashMap = new HashMap();
        gFA = hashMap;
        hashMap.put(Integer.valueOf("IPCallAddressItem".hashCode()), new c() {
            public final String[] pS() {
                return d.cic;
            }
        });
        gFA.put(Integer.valueOf("IPCallRecord".hashCode()), new c() {
            public final String[] pS() {
                return l.cic;
            }
        });
        gFA.put(Integer.valueOf("IPCallPopularCountry".hashCode()), new c() {
            public final String[] pS() {
                return j.cic;
            }
        });
        gFA.put(Integer.valueOf("IPCallMsg".hashCode()), new c() {
            public final String[] pS() {
                return h.cic;
            }
        });
    }

    public static i aul() {
        if (gFg == null) {
            gFg = new i();
            ak.yP().a("plugin.ipcall", gFg);
        }
        return gFg;
    }

    public static g aum() {
        return aul().gFh;
    }

    public static a aun() {
        return aul().gFi;
    }

    public static b auo() {
        return aul().gFj;
    }

    public static com.tencent.mm.plugin.ipcall.a.b.b aup() {
        return aul().gFk;
    }

    public static f auq() {
        return aul().gFl;
    }

    public static d aur() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aul().gFm == null) {
            i aul = aul();
            ak.yW();
            aul.gFm = new d(com.tencent.mm.model.c.wE());
        }
        return aul().gFm;
    }

    public static l aus() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aul().gFn == null) {
            i aul = aul();
            ak.yW();
            aul.gFn = new l(com.tencent.mm.model.c.wE());
        }
        return aul().gFn;
    }

    public static j aut() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aul().gFo == null) {
            i aul = aul();
            ak.yW();
            aul.gFo = new j(com.tencent.mm.model.c.wE());
        }
        return aul().gFo;
    }

    public static h auu() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aul().gFp == null) {
            i aul = aul();
            ak.yW();
            aul.gFp = new h(com.tencent.mm.model.c.wE());
        }
        return aul().gFp;
    }

    public static com.tencent.mm.plugin.voip.video.h auv() {
        if (aul().gFq == null) {
            aul().gFq = new com.tencent.mm.plugin.voip.video.h(aa.getContext());
        }
        return aul().gFq;
    }

    public static com.tencent.mm.plugin.voip.video.d auw() {
        if (aul().gFr == null) {
            aul().gFr = new com.tencent.mm.plugin.voip.video.d(aa.getContext());
        }
        return aul().gFr;
    }

    public final HashMap<Integer, c> ti() {
        return gFA;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        Object obj = this.gFh;
        obj.gES.init();
        obj.gET.init();
        obj.gEU.init();
        obj.gEV.init();
        obj.gEW.init();
        obj.gEX.init();
        obj.gEY.init();
        obj.gEZ.init();
        obj.gES.gFC = obj;
        obj.gEU.gFC = obj;
        obj.gEV.gFC = obj;
        obj.gEX.gFC = obj;
        obj.gEZ.gFC = obj;
        obj.gET.gFE = obj;
        obj.gEW.gFE = obj;
        ak.a(obj.gFd);
        b.init();
        com.tencent.mm.sdk.c.a.nhr.e(d.auc().gEE);
        com.tencent.mm.sdk.c.a.nhr.e(e.auf().gEI);
        com.tencent.mm.sdk.c.a.nhr.e(this.gFu);
        com.tencent.mm.sdk.c.a.nhr.e(this.gFv);
        com.tencent.mm.sdk.c.a.nhr.e(this.gFw);
        com.tencent.mm.sdk.c.a.nhr.e(this.gFx);
        com.tencent.mm.sdk.c.a.nhr.e(this.gFz);
        com.tencent.mm.sdk.c.a.nhr.e(this.gFy);
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        g gVar = this.gFh;
        gVar.gES.destroy();
        gVar.gET.destroy();
        gVar.gEU.destroy();
        gVar.gEV.destroy();
        gVar.gEW.destroy();
        gVar.gEY.destroy();
        ak.b(gVar.gFd);
        b.release();
        d auc = d.auc();
        ak.vy().b(159, auc);
        ak.vy().b(160, auc);
        com.tencent.mm.sdk.c.a.nhr.f(auc.gEE);
        com.tencent.mm.sdk.c.a.nhr.f(e.auf().gEI);
        com.tencent.mm.sdk.c.a.nhr.f(this.gFu);
        com.tencent.mm.sdk.c.a.nhr.f(this.gFv);
        com.tencent.mm.sdk.c.a.nhr.f(this.gFw);
        com.tencent.mm.sdk.c.a.nhr.f(this.gFx);
        com.tencent.mm.sdk.c.a.nhr.f(this.gFz);
        com.tencent.mm.sdk.c.a.nhr.f(this.gFy);
    }
}
