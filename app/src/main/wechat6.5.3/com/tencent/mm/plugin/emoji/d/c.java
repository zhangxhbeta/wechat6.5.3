package com.tencent.mm.plugin.emoji.d;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;
import com.tencent.mm.bf.e;
import com.tencent.mm.bf.f;
import com.tencent.mm.e.a.aq;
import com.tencent.mm.e.a.bu;
import com.tencent.mm.e.a.bv;
import com.tencent.mm.e.a.bw;
import com.tencent.mm.e.a.by;
import com.tencent.mm.e.a.gx;
import com.tencent.mm.e.a.hx;
import com.tencent.mm.e.a.kl;
import com.tencent.mm.e.a.lb;
import com.tencent.mm.e.a.qa;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.emoji.b.a;
import com.tencent.mm.plugin.emoji.b.b;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.t;
import com.tencent.tmassistantsdk.logreport.UpdateInfoReportManager.UpdateLogConst;
import java.util.ArrayList;
import java.util.Iterator;

public final class c {
    public a faC = new a();
    public b faD = new b();
    public d faE = new d();
    public com.tencent.mm.plugin.emoji.b.c faF = new com.tencent.mm.plugin.emoji.b.c();
    public com.tencent.mm.sdk.c.c faG = new com.tencent.mm.sdk.c.c<qa>(this) {
        final /* synthetic */ c faQ;

        {
            this.faQ = r2;
            this.nhz = qa.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            at atVar = ((qa) bVar).brp.aXd;
            com.tencent.mm.storage.a.c NF = g.afx().fch.NF(atVar.field_imgPath);
            if (NF != null) {
                if (NF.field_type == com.tencent.mm.storage.a.c.nwS) {
                    Cursor cursor = null;
                    if (com.tencent.mm.storage.a.c.vk(NF.field_catalog)) {
                        cursor = g.afx().fch.vm(NF.field_catalog);
                    } else if (NF.field_catalog == com.tencent.mm.storage.a.c.nwN && NF.pO().length() > 0 && com.tencent.mm.storage.a.c.vk(be.getInt(NF.pO(), 0))) {
                        cursor = g.afx().fch.vm(be.getInt(NF.pO(), 0));
                    }
                    if (cursor != null) {
                        int cW = be.cW(cursor.getCount() - 1, 0);
                        NF = new com.tencent.mm.storage.a.c();
                        cursor.moveToPosition(cW);
                        NF.b(cursor);
                        cursor.close();
                    }
                    atVar.cI(NF.EB());
                    atVar.ds(0);
                    ag Mv = ag.Mv(atVar.field_content);
                    Mv.dhD = false;
                    atVar.dh(1);
                    atVar.setContent(Mv.bvQ());
                    ak.yW();
                    com.tencent.mm.model.c.wJ().a(atVar.field_msgId, atVar);
                }
                g.aft().a(atVar.field_talker, NF, atVar);
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.c.c faH = new com.tencent.mm.sdk.c.c<hx>(this) {
        final /* synthetic */ c faQ;

        {
            this.faQ = r2;
            this.nhz = hx.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            hx hxVar = (hx) bVar;
            if (hxVar != null && (hxVar instanceof hx)) {
                v.i("MicroMsg.emoji.EmojiEventMgr", "manualAuthEventListener callback");
                if (hxVar.bhK.aXR) {
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(t.a.noK, Boolean.valueOf(true));
                }
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.c.c faI = new com.tencent.mm.sdk.c.c<bw>(this) {
        final /* synthetic */ c faQ;

        {
            this.faQ = r2;
            this.nhz = bw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            boolean z = true;
            switch (((bw) bVar).aZr.state) {
                case 0:
                    e aeU = e.aeU();
                    ak.yW();
                    String wY = com.tencent.mm.model.c.wY();
                    aeU.faY = true;
                    if (be.kS(wY)) {
                        v.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "filepath is empty.");
                    } else {
                        ak.yW();
                        v.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "need clean emoji file:%B", new Object[]{Boolean.valueOf(System.currentTimeMillis() - ((Long) com.tencent.mm.model.c.vf().get(t.a.noO, Long.valueOf(0))).longValue() >= 86400000)});
                        if (System.currentTimeMillis() - ((Long) com.tencent.mm.model.c.vf().get(t.a.noO, Long.valueOf(0))).longValue() >= 86400000) {
                            v.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "startClean");
                            ak.vA().x(new com.tencent.mm.plugin.emoji.d.e.AnonymousClass1(aeU, wY));
                        }
                    }
                    f aeV = f.aeV();
                    if (aeV.aeX()) {
                        if (!aeV.aHp) {
                            aeV.aHp = true;
                            ak.yW();
                            if (System.currentTimeMillis() - ((Long) com.tencent.mm.model.c.vf().get(t.a.noP, Long.valueOf(0))).longValue() < 86400000) {
                                z = false;
                            }
                            if (!z) {
                                v.i("MicroMsg.emoji.EmojiFileEncryptMgr", "need no encrypt.");
                                break;
                            }
                            ak.vA().x(new Runnable(aeV) {
                                final /* synthetic */ f fbc;

                                {
                                    this.fbc = r1;
                                }

                                public final void run() {
                                    ArrayList bxT = g.afx().fch.bxT();
                                    if (bxT != null && bxT.size() > 0) {
                                        Iterator it = bxT.iterator();
                                        while (it.hasNext()) {
                                            c cVar = (c) it.next();
                                            if (this.fbc.aHp) {
                                                this.fbc.c(cVar, false);
                                            }
                                        }
                                    }
                                    if (this.fbc.aHp) {
                                        ak.yW();
                                        com.tencent.mm.model.c.vf().a(t.a.noP, Long.valueOf(System.currentTimeMillis()));
                                    }
                                }
                            });
                            break;
                        }
                        v.d("MicroMsg.emoji.EmojiFileEncryptMgr", "encrypt process file is running.");
                        break;
                    }
                    v.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encrypt is disable.");
                    break;
                case 1:
                    e.aeU().faY = false;
                    f.aeV().aHp = false;
                    break;
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.c.c faJ = new com.tencent.mm.sdk.c.c<bv>(this) {
        final /* synthetic */ c faQ;

        {
            this.faQ = r2;
            this.nhz = bv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            bv bvVar = (bv) bVar;
            d aeS = d.aeS();
            if (bvVar != null && (bvVar instanceof bv)) {
                bvVar = bvVar;
                switch (bvVar.aZp.scene) {
                    case 0:
                        ak.vA().x(new com.tencent.mm.plugin.emoji.d.d.AnonymousClass1(aeS, bvVar.aZp.aZq));
                        break;
                    case 1:
                        Context context = bvVar.aZp.context;
                        ak.vA().x(new com.tencent.mm.plugin.emoji.d.d.AnonymousClass2(aeS, bvVar.aZp.aZq, context));
                        break;
                }
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.c.c faK = new com.tencent.mm.sdk.c.c<com.tencent.mm.e.a.ak>(this) {
        final /* synthetic */ c faQ;

        {
            this.faQ = r2;
            this.nhz = com.tencent.mm.e.a.ak.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            com.tencent.mm.e.a.ak akVar = (com.tencent.mm.e.a.ak) bVar;
            int i = akVar.aYa.type;
            com.tencent.mm.storage.a.c cVar;
            if (i == 0) {
                cVar = akVar.aYa.aYc;
                if (cVar != null && cVar.bxE()) {
                    akVar.aYb.aXR = f.aeV().b(cVar);
                    if (!akVar.aYb.aXR) {
                        com.tencent.mm.plugin.report.service.g.iuh.a(252, 8, 1, false);
                    }
                }
            } else if (i == 1) {
                String str = akVar.aYa.aYd;
                if (!be.kS(str)) {
                    cVar = g.afx().fch.NG(str);
                    if (cVar != null && cVar.bxE()) {
                        akVar.aYb.aXR = f.aeV().b(cVar);
                        if (!akVar.aYb.aXR) {
                            com.tencent.mm.plugin.report.service.g.iuh.a(252, 9, 1, false);
                        }
                    }
                }
            }
            return false;
        }
    };
    public final com.tencent.mm.sdk.c.c faL = new com.tencent.mm.sdk.c.c<aq>(this) {
        final /* synthetic */ c faQ;

        {
            this.faQ = r2;
            this.nhz = aq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            b afs = g.afs();
            v.i("MicroMsg.emoji.EmojiDescNewMgr", "[cpan] language change Current Language:%s LastLanguage:%s", new Object[]{u.bsY().toLowerCase(), afs.fat});
            if (be.kS(afs.fat) || !afs.fat.equalsIgnoreCase(r1)) {
                afs.aeR();
            }
            g.afx();
            m.fcs = true;
            return false;
        }
    };
    public com.tencent.mm.sdk.c.c faM = new com.tencent.mm.sdk.c.c<kl>(this) {
        final /* synthetic */ c faQ;

        {
            this.faQ = r2;
            this.nhz = kl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            kl klVar = (kl) bVar;
            if (!(klVar == null || !(klVar instanceof kl) || klVar.blI == null)) {
                String str = klVar.blI.aZD;
                if (!be.kS(str) && g.afx().fci.Nz(str)) {
                    g.afs().aeR();
                }
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.c.c faN = new com.tencent.mm.sdk.c.c<by>(this) {
        final /* synthetic */ c faQ;

        {
            this.faQ = r2;
            this.nhz = by.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            by byVar = (by) bVar;
            if (byVar != null && (byVar instanceof by)) {
                boolean z = byVar.aZv.aZw;
                ak.yW();
                com.tencent.mm.model.c.vf().a(t.a.noR, Boolean.valueOf(z));
                g.afy().fbL = z;
                if (z) {
                    Toast.makeText(aa.getContext(), 2131232332, 0).show();
                } else {
                    com.tencent.mm.plugin.report.service.g.iuh.h(12953, new Object[]{Integer.valueOf(2), ""});
                    Toast.makeText(aa.getContext(), 2131232330, 0).show();
                }
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.c.c faO = new com.tencent.mm.sdk.c.c<bu>(this) {
        final /* synthetic */ c faQ;

        {
            this.faQ = r2;
            this.nhz = bu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            switch (((bu) bVar).aZo.aYp) {
                case 1:
                    f.buR().buT();
                    e.buQ().Th();
                    com.tencent.mm.sdk.c.a.nhr.z(new lb());
                    break;
                case 2:
                    e.buQ().Th();
                    com.tencent.mm.sdk.c.a.nhr.z(new lb());
                    break;
                default:
                    v.i("MicroMsg.emoji.EmojiEventMgr", "unknown event.");
                    break;
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.c.c faP = new com.tencent.mm.sdk.c.c<gx>(this) {
        final /* synthetic */ c faQ;

        {
            this.faQ = r2;
            this.nhz = gx.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            switch (((gx) bVar).bgB.errorCode) {
                case 101:
                    com.tencent.mm.plugin.report.service.g.iuh.a(401, 3, 1, false);
                    break;
                case 102:
                    com.tencent.mm.plugin.report.service.g.iuh.a(401, 4, 1, false);
                    break;
                case UpdateLogConst.ACTION_POP_INSTALL_DIALOG /*104*/:
                    com.tencent.mm.plugin.report.service.g.iuh.a(401, 6, 1, false);
                    break;
                case 105:
                    com.tencent.mm.plugin.report.service.g.iuh.a(401, 7, 1, false);
                    break;
                case 106:
                    com.tencent.mm.plugin.report.service.g.iuh.a(401, 8, 1, false);
                    break;
                case 107:
                    com.tencent.mm.plugin.report.service.g.iuh.a(401, 9, 1, false);
                    break;
                case ba.CTRL_INDEX /*108*/:
                    com.tencent.mm.plugin.report.service.g.iuh.a(401, 10, 1, false);
                    break;
                case 109:
                    com.tencent.mm.plugin.report.service.g.iuh.a(401, 11, 1, false);
                    break;
                case 110:
                    com.tencent.mm.plugin.report.service.g.iuh.a(401, 12, 1, false);
                    break;
                case 111:
                    com.tencent.mm.plugin.report.service.g.iuh.a(401, 13, 1, false);
                    break;
                case 112:
                    com.tencent.mm.plugin.report.service.g.iuh.a(401, 14, 1, false);
                    break;
                case 113:
                    com.tencent.mm.plugin.report.service.g.iuh.a(401, 15, 1, false);
                    break;
            }
            return false;
        }
    };
}
