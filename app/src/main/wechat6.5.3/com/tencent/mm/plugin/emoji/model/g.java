package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.emoji.d.b;
import com.tencent.mm.plugin.emoji.d.h;
import com.tencent.mm.plugin.emoji.d.i;
import com.tencent.mm.plugin.emoji.d.k;
import com.tencent.mm.plugin.emoji.d.m;
import com.tencent.mm.plugin.emoji.g.a;
import com.tencent.mm.plugin.emoji.g.e;
import com.tencent.mm.plugin.emoji.ui.smiley.SmileyPanel;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.a.f;
import com.tencent.mm.storage.a.l;
import com.tencent.mm.storage.a.n;
import com.tencent.mm.storage.a.p;
import com.tencent.mm.storage.a.r;
import com.tencent.mm.storage.a.t;
import com.tencent.mm.storage.a.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class g implements ag {
    private static HashMap<Integer, c> bXq;
    private c fdk;
    private b fdl;
    private h fdm;
    private h fdn;
    private d fdo;
    private a<e> fdp;
    private i fdq;
    private com.tencent.mm.plugin.emoji.d.c fdr;
    private m fds;
    private k fdt;
    private com.tencent.mm.ae.a.a fdu;
    private b fdv;

    private static g afp() {
        g gVar = (g) ak.yP().fY("plugin.emoji");
        if (gVar == null) {
            synchronized (g.class) {
                if (gVar == null) {
                    gVar = new g();
                    ak.yP().a("plugin.emoji", gVar);
                }
            }
        }
        return gVar;
    }

    public static com.tencent.mm.ae.a.a afq() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (afp().fdu == null) {
            com.tencent.mm.ae.a.a.b.a aVar = new com.tencent.mm.ae.a.a.b.a(aa.getContext());
            aVar.cPi = new com.tencent.mm.plugin.emoji.c.a();
            aVar.cPg = new com.tencent.mm.plugin.emoji.c.b();
            com.tencent.mm.ae.a.a.b GT = aVar.GT();
            afp().fdu = new com.tencent.mm.ae.a.a(GT);
        }
        return afp().fdu;
    }

    public static c afr() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (afp().fdk == null) {
            afp().fdk = new c();
        }
        return afp().fdk;
    }

    public static b afs() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (afp().fdl == null) {
            afp().fdl = new b();
        }
        return afp().fdl;
    }

    public static h aft() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (afp().fdm == null) {
            afp().fdm = new h();
        }
        return afp().fdm;
    }

    public static a<e> afu() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (afp().fdp == null) {
            afp().fdp = new a();
        }
        return afp().fdp;
    }

    private static i afv() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (afp().fdq == null) {
            afp().fdq = new i();
        }
        return afp().fdq;
    }

    private static com.tencent.mm.plugin.emoji.d.c afw() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (afp().fdr == null) {
            afp().fdr = new com.tencent.mm.plugin.emoji.d.c();
        }
        return afp().fdr;
    }

    public static m afx() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (afp().fds == null) {
            afp().fds = new m();
        }
        return afp().fds;
    }

    public static k afy() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (afp().fdt == null) {
            afp().fdt = new k();
        }
        return afp().fdt;
    }

    public final void th() {
        i afv = afv();
        ak.yU().b("emotionstore", afv.fbe, true);
        ak.yU().b("NewRecommendEmotion", afv.fbf, true);
        ak.yU().b("EmojiBackup", afv.fbg, true);
        ak.yU().b("EmotionBackup", afv.fbg, true);
        com.tencent.mm.plugin.emoji.d.c afw = afw();
        com.tencent.mm.sdk.c.a.nhr.f(afw.faC);
        com.tencent.mm.sdk.c.a.nhr.f(afw.faG);
        com.tencent.mm.sdk.c.a.nhr.f(afw.faH);
        com.tencent.mm.sdk.c.a.nhr.f(afw.faI);
        com.tencent.mm.sdk.c.a.nhr.f(afw.faJ);
        com.tencent.mm.sdk.c.a.nhr.f(afw.faK);
        com.tencent.mm.sdk.c.a.nhr.f(afw.faL);
        com.tencent.mm.sdk.c.a.nhr.f(afw.faM);
        com.tencent.mm.sdk.c.a.nhr.f(afw.faN);
        com.tencent.mm.sdk.c.a.nhr.f(afw.faD);
        com.tencent.mm.sdk.c.a.nhr.f(afw.faE);
        com.tencent.mm.sdk.c.a.nhr.f(afw.faO);
        com.tencent.mm.sdk.c.a.nhr.f(afw.faP);
        com.tencent.mm.sdk.c.a.nhr.f(afw.faF);
        m afx = afx();
        afx.fch.d(afx.fcA);
        afx.fci.d(afx.fcy);
        afx.fcj.d(afx.fcz);
        com.tencent.mm.sdk.c.a.nhr.f(afx.fcB);
        if (m.fcw != null) {
            m.fcw.clear();
            m.fcw = null;
        }
        if (m.fcx != null) {
            m.fcx.clear();
            m.fcx = null;
        }
        afs().clear();
        j.a.lxK = null;
        c afr = afr();
        ak.vy().b(175, afr);
        afr.fcL.clear();
        afr.fcJ.clear();
        afr.fcO.clear();
        k afy = afy();
        afy.fbO = null;
        if (afy.fbP != null) {
            afy.fbP.clear();
        }
        if (afu() != null) {
            com.tencent.mm.plugin.emoji.g.c cVar = afu().feA;
            if (cVar.feW != null) {
                cVar.feW.clear();
            }
            if (cVar.feX != null) {
                cVar.feX.clear();
            }
            if (cVar.feY != null) {
                cVar.feY.clear();
            }
            cVar.feN = false;
            com.tencent.mm.sdk.c.a.nhr.f(cVar.fff);
            com.tencent.mm.sdk.c.a.nhr.f(cVar.ffg);
            aa.getContext().unregisterReceiver(cVar.ffa);
        }
        h hVar = this.fdn;
        com.tencent.mm.sdk.c.a.nhr.f(hVar.fdA);
        com.tencent.mm.sdk.c.a.nhr.f(hVar.fdB);
        if (this.fdu != null) {
            this.fdu.detach();
        }
        ak.vy().b(697, afA());
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("EMOJIINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return f.cic;
            }
        });
        bXq.put(Integer.valueOf("EMOJIGROUPINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return com.tencent.mm.storage.a.b.cic;
            }
        });
        bXq.put(Integer.valueOf("EMOJIINFODESC_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return com.tencent.mm.storage.a.e.cic;
            }
        });
        bXq.put(Integer.valueOf("EMOTIONDETAIL_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return l.cic;
            }
        });
        bXq.put(Integer.valueOf("GETEMOTIONLISTCACHE_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return r.cic;
            }
        });
        bXq.put(Integer.valueOf("EmotionRewardINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return n.cic;
            }
        });
        bXq.put(Integer.valueOf("EmotionDesignerInfoStorage_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return com.tencent.mm.storage.a.j.cic;
            }
        });
        bXq.put(Integer.valueOf("EmotionRewardTipStorage_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return p.cic;
            }
        });
        bXq.put(Integer.valueOf("SmileyInfoStorage_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return t.cic;
            }
        });
        bXq.put(Integer.valueOf("SmileyPanelConfigInfoStorage_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return v.cic;
            }
        });
        bXq.put(Integer.valueOf("EmojiDescMapStorage".hashCode()), new c() {
            public final String[] pS() {
                return com.tencent.mm.storage.a.h.cic;
            }
        });
        bXq.put(Integer.valueOf("DELETE".hashCode()), new c() {
            public final String[] pS() {
                return new String[]{"DROP TABLE IF EXISTS EmotionDetail ", "DROP TABLE IF EXISTS EmojiSummaryInfo", "DROP TABLE IF EXISTS RewardMagicInfo"};
            }
        });
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.emoji.SubCoreEmoji", "[onAccountPostReset]");
        com.tencent.mm.pluginsdk.ui.chat.f.lNK = new com.tencent.mm.pluginsdk.ui.chat.f.a(this) {
            final /* synthetic */ g fdw;

            {
                this.fdw = r1;
            }

            public final ChatFooterPanel bC(Context context) {
                return new SmileyPanel(context);
            }
        };
        j.a.lxK = aft();
        i afv = afv();
        ak.yU().a("emotionstore", afv.fbe, true);
        ak.yU().a("NewRecommendEmotion", afv.fbf, true);
        ak.yU().a("EmojiBackup", afv.fbg, true);
        ak.yU().a("EmotionBackup", afv.fbg, true);
        com.tencent.mm.plugin.emoji.d.c afw = afw();
        com.tencent.mm.sdk.c.a.nhr.e(afw.faC);
        com.tencent.mm.sdk.c.a.nhr.e(afw.faG);
        com.tencent.mm.sdk.c.a.nhr.e(afw.faH);
        com.tencent.mm.sdk.c.a.nhr.e(afw.faI);
        com.tencent.mm.sdk.c.a.nhr.e(afw.faJ);
        com.tencent.mm.sdk.c.a.nhr.e(afw.faK);
        com.tencent.mm.sdk.c.a.nhr.e(afw.faL);
        com.tencent.mm.sdk.c.a.nhr.e(afw.faM);
        com.tencent.mm.sdk.c.a.nhr.e(afw.faN);
        com.tencent.mm.sdk.c.a.nhr.e(afw.faD);
        com.tencent.mm.sdk.c.a.nhr.e(afw.faE);
        com.tencent.mm.sdk.c.a.nhr.e(afw.faO);
        com.tencent.mm.sdk.c.a.nhr.e(afw.faP);
        com.tencent.mm.sdk.c.a.nhr.e(afw.faF);
        m afx = afx();
        afx.fch.c(afx.fcA);
        afx.fci.c(afx.fcy);
        afx.fcj.c(afx.fcz);
        com.tencent.mm.sdk.c.a.nhr.e(afx.fcB);
        afs().aeR();
        k afy = afy();
        String value = com.tencent.mm.h.j.sU().getValue("EmotionRewardTipsLimit");
        if (!be.kS(value)) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateConfig dynamic config %s", new Object[]{value});
            String[] split = value.split(",");
            if (split != null && split.length == 3) {
                afy.fbM = be.getInt(split[0], 0) == 0 ? 863913600000L : ((long) be.getInt(split[0], 0)) * 86400000;
                afy.fbN = be.getInt(split[1], 20) - 1;
                afy.exY = be.getInt(split[2], 80) - 1;
            }
        }
        boolean z2 = (com.tencent.mm.h.j.sU().getInt("EmotionRewardOption", 0) & 2) != 2;
        ak.yW();
        boolean z3 = z2 && ((Boolean) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.noR, Boolean.valueOf(true))).booleanValue();
        afy.fbL = z3;
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.emoji.EmojiRewardTipMgr", "init RewardTipMgr RewardTipEnable:%b isEnableRewardTip:%b isTipsEnable:%b", new Object[]{Boolean.valueOf(afy.fbL), Boolean.valueOf(z2), Boolean.valueOf(r5)});
        ak.vA().x(new Runnable(afy) {
            final /* synthetic */ k fbQ;

            public final void run() {
                /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1439)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1461)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r0 = r5.fbQ;
                r0 = r0.fbL;
                if (r0 == 0) goto L_0x004b;
            L_0x0006:
                r0 = r5.fbQ;
                r1 = com.tencent.mm.plugin.emoji.model.g.afx();
                r1 = r1.fco;
                if (r1 == 0) goto L_0x001c;
            L_0x0010:
                r1 = com.tencent.mm.plugin.emoji.model.g.afx();
                r1 = r1.fco;
                r1 = r1.bxU();
                r0.fbO = r1;
            L_0x001c:
                r0 = r5.fbQ;
                r1 = 0;
                r2 = com.tencent.mm.plugin.emoji.model.g.afx();	 Catch:{ Exception -> 0x004c }
                r2 = r2.fco;	 Catch:{ Exception -> 0x004c }
                r1 = r2.Kp();	 Catch:{ Exception -> 0x004c }
                if (r1 == 0) goto L_0x0046;	 Catch:{ Exception -> 0x004c }
            L_0x002b:
                r2 = r1.moveToFirst();	 Catch:{ Exception -> 0x004c }
                if (r2 == 0) goto L_0x0046;	 Catch:{ Exception -> 0x004c }
            L_0x0031:
                r2 = new com.tencent.mm.storage.a.o;	 Catch:{ Exception -> 0x004c }
                r2.<init>();	 Catch:{ Exception -> 0x004c }
                r2.b(r1);	 Catch:{ Exception -> 0x004c }
                r3 = r0.fbP;	 Catch:{ Exception -> 0x004c }
                r4 = r2.field_prodcutID;	 Catch:{ Exception -> 0x004c }
                r3.put(r4, r2);	 Catch:{ Exception -> 0x004c }
                r2 = r1.moveToNext();	 Catch:{ Exception -> 0x004c }
                if (r2 != 0) goto L_0x0031;
            L_0x0046:
                if (r1 == 0) goto L_0x004b;
            L_0x0048:
                r1.close();
            L_0x004b:
                return;
            L_0x004c:
                r0 = move-exception;
                r2 = "MicroMsg.emoji.EmojiRewardTipMgr";	 Catch:{ all -> 0x005d }
                r0 = com.tencent.mm.sdk.platformtools.be.e(r0);	 Catch:{ all -> 0x005d }
                com.tencent.mm.sdk.platformtools.v.w(r2, r0);	 Catch:{ all -> 0x005d }
                if (r1 == 0) goto L_0x004b;
            L_0x0059:
                r1.close();
                goto L_0x004b;
            L_0x005d:
                r0 = move-exception;
                if (r1 == 0) goto L_0x0063;
            L_0x0060:
                r1.close();
            L_0x0063:
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.d.k.1.run():void");
            }

            {
                this.fbQ = r1;
            }
        });
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.emoji.SubCoreEmoji", "[oneliang]initCore");
        m afx2 = afx();
        Context context = aa.getContext();
        if (context != null) {
            ak.yW();
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.emoji.EmojiStorageMgr", "[oneliang]initCore,need init emoji:%s", new Object[]{String.valueOf(((Boolean) com.tencent.mm.model.c.vf().get(274480, Boolean.valueOf(true))).booleanValue())});
            if (((Boolean) com.tencent.mm.model.c.vf().get(274480, Boolean.valueOf(true))).booleanValue()) {
                afx2.fch.ee(context);
                afx2.fci.ee(context);
            }
            ak.yW();
            com.tencent.mm.model.c.vf().set(274480, Boolean.valueOf(false));
        }
        ak.yW();
        if (((Integer) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.noS, Integer.valueOf(0))).intValue() != d.lWh) {
            long currentTimeMillis = System.currentTimeMillis();
            afx().fci.bxD();
            ak.yW();
            com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.noS, Integer.valueOf(d.lWh));
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.emoji.EmojiStorageMgr", "recoverCustomEmojiGroup use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
        ak.yW();
        if (((Boolean) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.noT, Boolean.valueOf(true))).booleanValue()) {
            long er;
            com.tencent.mm.bg.g gVar;
            long currentTimeMillis2 = System.currentTimeMillis();
            com.tencent.mm.storage.a.b bVar = afx().fci;
            if (bVar.cie instanceof com.tencent.mm.bg.g) {
                com.tencent.mm.bg.g gVar2 = (com.tencent.mm.bg.g) bVar.cie;
                er = gVar2.er(Thread.currentThread().getId());
                gVar = gVar2;
            } else {
                gVar = null;
                er = -1;
            }
            ArrayList bxq = bVar.bxq();
            if (!bxq.isEmpty()) {
                Iterator it = bxq.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.storage.a.a aVar = (com.tencent.mm.storage.a.a) it.next();
                    if (!(aVar == null || be.kS(aVar.field_productID))) {
                        int NB = bVar.NB(aVar.field_productID);
                        if (aVar.field_count != NB) {
                            aVar.field_count = NB;
                            bVar.cie.update("EmojiGroupInfo", aVar.py(), "productID=?", new String[]{aVar.field_productID});
                        }
                    }
                }
            }
            int es = gVar != null ? gVar.es(er) : -1;
            bVar.a("event_update_group", 0, be.bur().toString());
            Object obj = es >= 0 ? 1 : null;
            ak.yW();
            com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.noT, Boolean.valueOf(obj == null));
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.emoji.EmojiStorageMgr", "updateEmojiGroupCount use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
        }
        this.fdn = new h();
        com.tencent.mm.z.a.aZ(z);
        ak.vy().a(697, afA());
        com.tencent.mm.bf.f.buR().buT();
        com.tencent.mm.bf.e.buQ().Th();
    }

    public final void aH(boolean z) {
    }

    public static d afz() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (afp().fdo == null) {
            afp().fdo = new d();
        }
        return afp().fdo;
    }

    public static b afA() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (afp().fdv == null) {
            afp().fdv = new b();
        }
        return afp().fdv;
    }
}
