package com.tencent.mm.ui.chatting.gallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.a.a.f;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.mm.a.e;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.n;
import com.tencent.mm.as.o;
import com.tencent.mm.as.p;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.i;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.gallery.j.AnonymousClass5;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@SuppressLint({"UseSparseArrays"})
public final class b extends t {
    public static long ezh = -1;
    public static boolean lKa = false;
    public ImageGalleryUI ozH;
    protected a ozI;
    private String ozJ;
    boolean ozK = true;
    public boolean ozL = false;
    public d ozM;
    public i ozN;
    public h ozO;
    public c ozP;
    boolean ozQ;
    protected boolean ozR = true;
    private ArrayList<at> ozS = new ArrayList();

    public static class a {
        private String bdo;
        int emv;
        ac handler = new ac();
        private int kWz;
        protected long oAa;
        private b oAb;
        public HashMap<Long, d> oAc = new HashMap();
        public HashMap<Long, d> oAd = new HashMap();
        private List<at> ozU;
        int ozV;
        protected boolean ozW = false;
        protected int ozX;
        protected int ozY;
        protected int ozZ;

        static /* synthetic */ void a(a aVar) {
            aVar.ozW = true;
            aVar.emv = aVar.ozX;
            aVar.kWz = aVar.ozY;
            aVar.ozV = aVar.ozZ;
            v.i("MicroMsg.AutoList", "totalCount %s min %s start %s", Integer.valueOf(aVar.emv), Integer.valueOf(aVar.kWz), Integer.valueOf(aVar.ozV));
            long currentTimeMillis = System.currentTimeMillis();
            v.i("MicroMsg.AutoList", "min spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            currentTimeMillis = System.currentTimeMillis();
            aVar.l(aVar.oAa, true);
            v.i("MicroMsg.AutoList", "loadMsgInfo spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            currentTimeMillis = System.currentTimeMillis();
            aVar.l(aVar.oAa, false);
            v.i("MicroMsg.AutoList", "loadMsgInfo spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            aVar.oAb.notifyDataSetChanged();
            if (!aVar.oAb.ozH.isFinishing()) {
                aVar.oAb.c(99999, (View) aVar.oAb.nZE.get(99999));
            }
        }

        static /* synthetic */ void a(a aVar, long j) {
            long currentTimeMillis = System.currentTimeMillis();
            v.i("MicroMsg.AutoList", "isBizChat = " + b.lKa);
            if (b.lKa) {
                aVar.ozX = ak.yW().cqY.O(aVar.bdo, b.ezh);
            } else {
                ak.yW();
                aVar.ozX = com.tencent.mm.model.c.wJ().Nc(aVar.bdo);
            }
            v.i("MicroMsg.AutoList", "<init>, totalCount = " + aVar.ozX);
            v.i("MicroMsg.AutoList", "totalCount spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            if (b.lKa) {
                aVar.ozY = ak.yW().cqY.g(aVar.bdo, b.ezh, j);
            } else {
                ak.yW();
                aVar.ozY = com.tencent.mm.model.c.wJ().ac(aVar.bdo, j);
            }
            v.i("MicroMsg.AutoList", "min spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            if (System.currentTimeMillis() - currentTimeMillis2 > 1000) {
                ak.yW();
                String ad = com.tencent.mm.model.c.wJ().ad(aVar.bdo, j);
                v.w("MicroMsg.AutoList", "explain : %s", ad);
            }
            aVar.ozZ = aVar.ozY;
            aVar.oAa = j;
        }

        public a(long j, String str, final b bVar, Boolean bool) {
            this.bdo = str;
            this.ozU = new LinkedList();
            this.oAb = bVar;
            ak.yW();
            bx ek = com.tencent.mm.model.c.wJ().ek(j);
            if (ek.field_msgId == 0) {
                Assert.assertTrue("MicroMsg.AutoList <init>, currentMsg does not exist, currentMsgId = " + j + ", stack = " + be.bur(), false);
                return;
            }
            this.ozU.add(ek);
            final long j2 = j;
            final Boolean bool2 = bool;
            final b bVar2 = bVar;
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ a oAh;

                public final void run() {
                    a.a(this.oAh, j2);
                    if (bool2.booleanValue()) {
                        this.oAh.handler.postDelayed(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 oAi;

                            {
                                this.oAi = r1;
                            }

                            public final void run() {
                                a.a(this.oAi.oAh);
                                if (bVar2.ozP != null) {
                                    bVar2.ozP.abH();
                                }
                            }
                        }, 0);
                    }
                }
            });
            bVar.ozH.oBX = new com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.a(this) {
                final /* synthetic */ a oAh;

                public final void g(Boolean bool) {
                    v.i("MicroMsg.AutoList", "isPlaying : " + bool);
                    if (!bool.booleanValue()) {
                        a.a(this.oAh);
                        if (bVar.ozP != null) {
                            bVar.ozP.abH();
                        }
                    }
                }
            };
        }

        private void cy(List<at> list) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                if (b.aH((at) list.get(i))) {
                    arrayList.add(Long.valueOf(((at) list.get(i)).field_msgSvrId));
                    if (((at) list.get(i)).field_isSend == 1) {
                        arrayList2.add(Long.valueOf(((at) list.get(i)).field_msgId));
                    }
                }
            }
            this.oAc.putAll(n.GH().a((Long[]) arrayList.toArray(new Long[0])));
            this.oAd.putAll(n.GH().b((Long[]) arrayList2.toArray(new Long[0])));
        }

        public final int xC(int i) {
            return (i - 100000) + this.ozV;
        }

        public final at xD(int i) {
            int xC = xC(i);
            int size = (this.kWz + this.ozU.size()) - 1;
            if (xC < this.kWz || xC > size) {
                v.e("MicroMsg.AutoList", "get, invalid pos " + xC + ", min = " + this.kWz + ", max = " + size);
                return null;
            }
            v.d("MicroMsg.AutoList", "get, pos = " + xC);
            at atVar;
            if (xC == this.kWz) {
                atVar = (at) this.ozU.get(0);
                if (!this.ozW) {
                    return atVar;
                }
                l(atVar.field_msgId, false);
                return atVar;
            } else if (xC != size || size >= this.emv - 1) {
                return (at) this.ozU.get(xC - this.kWz);
            } else {
                atVar = (at) this.ozU.get(this.ozU.size() - 1);
                if (!this.ozW) {
                    return atVar;
                }
                l(atVar.field_msgId, true);
                return atVar;
            }
        }

        private void l(long j, boolean z) {
            List a;
            v.i("MicroMsg.AutoList", "start loadMsgInfo, currentMsgId = " + j + ", forward = " + z);
            if (b.lKa) {
                a = ak.yW().cqY.a(this.bdo, b.ezh, j, z);
            } else {
                ak.yW();
                a = com.tencent.mm.model.c.wJ().d(this.bdo, j, z);
            }
            if (a == null || a.size() == 0) {
                v.w("MicroMsg.AutoList", "loadMsgInfo fail, addedMsgList is null, forward = " + z);
                return;
            }
            v.i("MicroMsg.AutoList", "loadMsgInfo done, new added list, size = " + a.size() + ", forward = " + z);
            long currentTimeMillis = System.currentTimeMillis();
            cy(a);
            v.i("MicroMsg.AutoList", "loadImgInfo spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (z) {
                this.ozU.addAll(a);
                return;
            }
            this.ozU.addAll(0, a);
            this.kWz -= a.size();
            if (this.kWz < 0) {
                v.e("MicroMsg.AutoList", "loadMsgInfo fail, min should not be minus, min = " + this.kWz);
                return;
            }
            v.i("MicroMsg.AutoList", "min from " + (a.size() + this.kWz) + " to " + this.kWz);
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AutoList, Size = " + this.ozU.size());
            stringBuilder.append("; Content = {");
            for (at atVar : this.ozU) {
                stringBuilder.append(atVar.field_msgId);
                stringBuilder.append(",");
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public enum b {
        unkown,
        image,
        video,
        sight,
        appimage
    }

    public interface c {
        void abH();
    }

    public final /* synthetic */ Object d(int i, View view) {
        return c(i, view);
    }

    public b(ImageGalleryUI imageGalleryUI, long j, String str, boolean z, long j2, boolean z2, String str2, Boolean bool) {
        String str3 = "MicroMsg.ImageGalleryAdapter, invalid argument, context = " + imageGalleryUI + ", currentMsgId = " + j + ", talker = " + str + ", stack = " + be.bur();
        boolean z3 = imageGalleryUI != null && j > 0 && str != null && str.length() > 0;
        Assert.assertTrue(str3, z3);
        this.ozH = imageGalleryUI;
        lKa = z;
        ezh = j2;
        this.ozI = new a(j, str, this, bool);
        this.ozL = z2;
        this.ozJ = str2;
        this.ozM = new d(this);
        this.ozN = new i(this);
        this.ozO = new h(this);
    }

    public final void W(int i) {
        if (this.ozM != null && aH(xs(i))) {
            this.ozM.oBc.W(i);
        }
    }

    public final int getCount() {
        a aVar = this.ozI;
        return ((aVar.emv - aVar.ozV) + 100000) + 1;
    }

    public final int aij() {
        return this.ozI.emv;
    }

    public final at xs(int i) {
        return this.ozI.xD(i);
    }

    public final d e(at atVar, boolean z) {
        return this.ozM.e(atVar, z);
    }

    public static boolean aH(at atVar) {
        if (atVar == null) {
            return false;
        }
        if (atVar.field_type == 3 || atVar.field_type == 39 || atVar.field_type == 13) {
            return true;
        }
        return false;
    }

    public static boolean aI(at atVar) {
        if (atVar == null || aO(atVar)) {
            return false;
        }
        if (atVar.field_type == 43 || atVar.field_type == 44 || atVar.field_type == 62) {
            return true;
        }
        return false;
    }

    public static boolean aJ(at atVar) {
        if (atVar != null && atVar.field_type == 62) {
            return true;
        }
        return false;
    }

    public static boolean aK(at atVar) {
        if (atVar != null && atVar.field_type == 49) {
            return true;
        }
        return false;
    }

    public static boolean aL(at atVar) {
        if (atVar != null && atVar.field_type == 268435505) {
            return true;
        }
        return false;
    }

    public final boolean aM(at atVar) {
        if (atVar == null) {
            return false;
        }
        d e = e(atVar, false);
        if (e == null) {
            com.tencent.mm.as.n bb = i.bb(atVar);
            if (bb == null || bb == null) {
                return false;
            }
            int i = bb.status;
            boolean z = (i == MMGIFException.D_GIF_ERR_IMAGE_DEFECT || i == 122) && p.f(bb) < 100;
            v.i("MicroMsg.ImageGalleryAdapter", "it is video downloading %b, status %d, download progress %d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(r2));
            return z;
        } else if (atVar == null || e == null) {
            return false;
        } else {
            if (n.GI().a(e.cLu, atVar.field_msgId, 0) || a(atVar, e)) {
                return true;
            }
            return false;
        }
    }

    public static boolean a(at atVar, d dVar) {
        if (atVar == null || dVar == null) {
            return false;
        }
        return n.GI().a(dVar.cLu, atVar.field_msgId, 1);
    }

    public final void xt(int i) {
        bx xs = xs(i);
        switch (aN(xs)) {
            case video:
            case sight:
                aP(xs);
                return;
            case appimage:
                String aR = aR(xs);
                Intent intent = new Intent(this.ozH, MsgRetransmitUI.class);
                intent.putExtra("Retr_File_Name", aR);
                intent.putExtra("Retr_Msg_Id", xs.field_msgId);
                intent.putExtra("Retr_Msg_Type", 16);
                intent.putExtra("Retr_Msg_content", xs.field_content);
                intent.putExtra("Retr_Compress_Type", 0);
                this.ozH.startActivity(intent);
                return;
            default:
                aQ(xs);
                return;
        }
    }

    public final void xu(int i) {
        bx xs = xs(i);
        switch (aN(xs)) {
            case video:
            case sight:
            case image:
                Intent intent = new Intent(this.ozH, ChattingSendDataToDeviceUI.class);
                intent.putExtra("Retr_Msg_Id", xs.field_msgId);
                this.ozH.startActivity(intent);
                return;
            default:
                return;
        }
    }

    public static b aN(at atVar) {
        b bVar = b.unkown;
        if (atVar == null) {
            bVar = b.unkown;
        }
        if (aL(atVar)) {
            return b.appimage;
        }
        if (aH(atVar)) {
            return b.image;
        }
        if (aO(atVar)) {
            return b.sight;
        }
        if (aI(atVar)) {
            return b.video;
        }
        if (aJ(atVar)) {
            return b.video;
        }
        return b.unkown;
    }

    private static boolean aO(at atVar) {
        if (atVar != null) {
            com.tencent.mm.as.n lp = p.lp(atVar.field_imgPath);
            if (!(lp == null || lp.dhT == null || (be.kS(lp.dhT.cqg) && lp.dhT.mtD <= 0 && be.kS(lp.dhT.cqj) && be.kS(lp.dhT.cqk) && be.kS(lp.dhT.cqi) && be.kS(lp.dhT.cql) && be.kS(lp.dhT.cqm) && be.kS(lp.dhT.cqn)))) {
                return true;
            }
        }
        return false;
    }

    public final void aP(at atVar) {
        ak.yW();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            com.tencent.mm.as.n lp = p.lp(atVar.field_imgPath);
            if (lp == null) {
                v.e("MicroMsg.ImageGalleryAdapter", "videoInfo should not be null");
                return;
            }
            Intent intent = new Intent(this.ozH, MsgRetransmitUI.class);
            intent.putExtra("Retr_length", lp.dhK);
            intent.putExtra("Retr_File_Name", atVar.field_imgPath);
            intent.putExtra("Retr_video_isexport", lp.dhO);
            intent.putExtra("Retr_Msg_Type", aJ(atVar) ? 11 : 1);
            intent.putExtra("Retr_Msg_Id", atVar.field_msgId);
            intent.putExtra("Retr_From", "gallery");
            this.ozH.startActivity(intent);
            return;
        }
        s.ey(this.ozH);
    }

    public final void aQ(at atVar) {
        d aW = d.aW(atVar);
        if (atVar == null || atVar.field_msgId == 0 || aW == null || aW.cLu == 0) {
            Object obj;
            String str = "MicroMsg.ImageGalleryAdapter";
            StringBuilder stringBuilder = new StringBuilder("doRestransmitMsg fail, msgLocalId = ");
            if (atVar == null) {
                obj = "null";
            } else {
                obj = Long.valueOf(atVar.field_msgId);
            }
            stringBuilder = stringBuilder.append(obj).append(", imgLocalId = ");
            if (aW == null) {
                obj = "null";
            } else {
                obj = Long.valueOf(aW.cLu);
            }
            v.e(str, stringBuilder.append(obj).toString());
            return;
        }
        String a = d.a(atVar, aW, false);
        if (a == null || a.length() == 0) {
            v.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + atVar.field_msgId + ", imgLocalId = " + aW.cLu);
        } else if (be.kS(this.ozJ)) {
            v.i("MicroMsg.ImageGalleryAdapter", "directly send user is empty, select one");
            Intent intent = new Intent(this.ozH, MsgRetransmitUI.class);
            intent.putExtra("Retr_File_Name", a);
            intent.putExtra("Retr_Msg_Id", atVar.field_msgId);
            intent.putExtra("Retr_Msg_Type", 0);
            intent.putExtra("Retr_Compress_Type", b(atVar, aW));
            this.ozH.startActivity(intent);
        } else {
            int i;
            v.i("MicroMsg.ImageGalleryAdapter", "directly send user %s", this.ozJ);
            if (atVar.field_isSend == 1) {
                if (aW.Gp()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else if (aW.Gp()) {
                if (e.aR(n.GH().l(com.tencent.mm.ae.e.a(aW).cLv, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty))) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
                i = 0;
            }
            String xF = k.xF();
            String l = n.GH().l(com.tencent.mm.ae.e.c(aW), SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
            if (!be.kS(l)) {
                v.i("MicroMsg.ImageGalleryAdapter", "connector click[img]: to[%s] fileName[%s]", aW, l);
                ak.vy().a(new com.tencent.mm.ae.k(xF, this.ozJ, l, i), 0);
                bl.zQ().b(bl.cvm, null);
            }
            if (this.ozK) {
                Intent intent2 = new Intent(this.ozH, ChattingUI.class);
                intent2.addFlags(67108864);
                intent2.putExtra("Chat_User", this.ozJ);
                this.ozH.startActivity(intent2);
            } else {
                g.bf(this.ozH, this.ozH.getString(2131231147));
            }
            com.tencent.mm.plugin.report.service.g.iuh.h(10424, Integer.valueOf(3), Integer.valueOf(4), this.ozJ);
        }
    }

    public static boolean c(Context context, List<at> list) {
        if (context == null || list == null || list.size() <= 0) {
            return false;
        }
        boolean z;
        if (list.size() <= 1) {
            z = true;
        } else {
            z = false;
        }
        for (at atVar : list) {
            if (aI(atVar)) {
                a(context, atVar, z);
            } else {
                String aR;
                if (aL(atVar)) {
                    aR = aR(atVar);
                } else if (atVar == null || atVar.field_msgId == 0) {
                    v.e("MicroMsg.ImageGalleryAdapter", "msg is null");
                } else {
                    d aW = d.aW(atVar);
                    if (aW == null || aW.cLu == 0) {
                        v.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, msgLocalId = " + (atVar == null ? "null" : Long.valueOf(atVar.field_msgId)) + ", imgLocalId = " + (aW == null ? "null" : Long.valueOf(aW.cLu)));
                    } else {
                        aR = d.a(atVar, aW, false);
                    }
                }
                if (aR == null || aR.length() == 0) {
                    v.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + atVar.field_msgId);
                } else {
                    com.tencent.mm.platformtools.d.a(aR, context, z);
                }
            }
        }
        if (z) {
            return true;
        }
        Toast.makeText(context, context.getString(2131232597, new Object[]{com.tencent.mm.compatible.util.e.cgg}), 1).show();
        return true;
    }

    public static void a(Context context, at atVar, boolean z) {
        if (atVar != null) {
            com.tencent.mm.as.n kZ = com.tencent.mm.as.k.KV().kZ(atVar.field_imgPath);
            if (kZ != null) {
                int el;
                if (m.dE(kZ.Ld())) {
                    el = i.el(kZ.Ld());
                } else {
                    el = 0;
                }
                com.tencent.mm.plugin.report.service.g.iuh.a(106, 216, 1, false);
                com.tencent.mm.plugin.report.service.g.iuh.h(12084, Integer.valueOf(kZ.cyu), Integer.valueOf(kZ.dhK * 1000), Integer.valueOf(0), Integer.valueOf(2), kZ.Ld(), Integer.valueOf(el), com.tencent.mm.as.n.kY(kZ.Lg()), Long.valueOf(kZ.dhH));
            }
            com.tencent.mm.as.k.KV();
            String lq = p.lq(o.lc(atVar.field_imgPath));
            if (!be.kS(lq)) {
                if (z) {
                    Toast.makeText(context, context.getString(2131235795, new Object[]{lq}), 1).show();
                }
                l.c(lq, context);
            } else if (z) {
                Toast.makeText(context, context.getString(2131235794), 1).show();
            }
        }
    }

    public final void xv(int i) {
        at xs = xs(i);
        bp bpVar = new bp();
        com.tencent.mm.pluginsdk.model.d.a(bpVar, xs);
        bpVar.aZd.aXH = this.ozH;
        bpVar.aZd.aZl = 44;
        com.tencent.mm.sdk.c.a.nhr.z(bpVar);
        if (bpVar.aZe.ret == 0) {
            if (xs.bwo()) {
                com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.Fav, com.tencent.mm.ui.chatting.a.d.Full, xs, 0);
            }
            com.tencent.mm.modelstat.b.daJ.q(xs);
        }
    }

    public final View c(int i, View view) {
        j jVar;
        at xs = xs(i);
        if (view == null) {
            view = View.inflate(this.ozH, 2130903793, null);
            jVar = new j(this, view);
            view.setTag(jVar);
        } else {
            jVar = (j) view.getTag();
        }
        b aN = aN(xs);
        jVar.kB = i;
        jVar.oCO = aN;
        j.G(jVar.kad, 0);
        switch (AnonymousClass5.ozT[aN.ordinal()]) {
            case 1:
                j.G(jVar.oCW, 8);
                j.G(jVar.oCQ, 8);
                break;
            case 2:
                jVar.bHf();
                j.G(jVar.oCW, 0);
                j.G(jVar.oCQ, 8);
                if (jVar.oCQ != null) {
                    j.G(jVar.oCS, 8);
                    break;
                }
                break;
            case 3:
                jVar.bHe();
                j.G(jVar.oCW, 8);
                j.G(jVar.oCQ, 0);
                break;
            case 4:
                j.G(jVar.kad, 8);
                j.G(jVar.oCW, 8);
                j.G(jVar.oCQ, 8);
                break;
        }
        j.G(jVar.oDl, 8);
        j.G(jVar.oDc, 8);
        j.G(jVar.oDi, 8);
        j.G(jVar.oDh, 8);
        v.d("MicroMsg.ImageGalleryAdapter", "position:%d, type: %s", Integer.valueOf(i), aN);
        switch (aN) {
            case video:
                this.ozN.a(jVar, xs, i);
                break;
            case sight:
                this.ozO.a(jVar, xs, i);
                break;
            case appimage:
                j.G(jVar.oDl, 0);
                j.G(jVar.oDc, 8);
                j.G(jVar.oDh, 8);
                j.G(jVar.oDi, 8);
                j.G(jVar.oDa, 8);
                Bitmap lW = j.lW(aR(xs));
                if (lW != null) {
                    jVar.oDl.jOS = false;
                    jVar.oDl.di(lW.getWidth(), lW.getHeight());
                    jVar.oDl.setImageBitmap(lW);
                    jVar.oDl.invalidate();
                    break;
                }
                v.w("MicroMsg.ImageGalleryAdapter", "get image fail");
                jVar.oDl.setVisibility(8);
                jVar.bHd().oDi.setVisibility(0);
                jVar.bHd().oDk.setImageResource(2131165612);
                jVar.bHd().oDj.setText(this.ozH.getString(2131233293));
                break;
            case image:
                this.ozM.a(jVar, xs, i);
                break;
        }
        this.ozR = false;
        return view;
    }

    public static String aR(at atVar) {
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(atVar.field_content);
        if (dV == null || dV.aXa == null || dV.aXa.length() <= 0) {
            return null;
        }
        com.tencent.mm.pluginsdk.model.app.b Gu = am.Wf().Gu(dV.aXa);
        if (Gu != null) {
            return Gu.field_fileFullPath;
        }
        return null;
    }

    public final void detach() {
        this.ozM.detach();
        this.ozN.detach();
        this.ozO.detach();
        super.detach();
    }

    public static int b(at atVar, d dVar) {
        d a;
        if (atVar.field_isSend == 1) {
            if (dVar.Gp()) {
                a = com.tencent.mm.ae.e.a(dVar);
                if (a != null && a.cLu > 0 && a.Go() && e.aR(n.GH().l(a.cLv, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty))) {
                    return 1;
                }
            }
            return 0;
        } else if (!dVar.Go()) {
            return 0;
        } else {
            if (dVar.Gp()) {
                a = com.tencent.mm.ae.e.a(dVar);
                if (a != null && a.cLu > 0 && a.Go() && e.aR(n.GH().l(a.cLv, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty))) {
                    return 1;
                }
            }
            return 0;
        }
    }

    public final boolean bGs() {
        return this.ozI.ozW;
    }

    public final int bCI() {
        return 100000 - this.ozI.ozV;
    }

    public final int bCJ() {
        return ((100000 - this.ozI.ozV) + this.ozI.emv) - 1;
    }

    public final MultiTouchImageView lo(int i) {
        View wA = super.wA(i);
        if (wA == null) {
            v.e("MicroMsg.ImageGalleryAdapter", "position : %s getMultiTouchImageViewByPosition is null", Integer.valueOf(i));
            return null;
        }
        wA = wA.findViewById(f.Jm);
        if (wA == null || wA.getVisibility() == 8) {
            return null;
        }
        return (MultiTouchImageView) wA;
    }

    public final View xw(int i) {
        View wA = super.wA(i);
        if (wA == null) {
            v.e("MicroMsg.ImageGalleryAdapter", "position : %s getVideoViewByPosition is null", Integer.valueOf(i));
            return null;
        }
        View findViewById = wA.findViewById(2131757478);
        if (findViewById == null) {
            findViewById = wA.findViewById(2131756998);
        }
        if (findViewById == null || findViewById.getVisibility() == 8) {
            return null;
        }
        return findViewById;
    }

    public final void xx(int i) {
        this.ozN.c(xs(i), i);
    }

    public final void xy(int i) {
        this.ozN.d(xs(i), i);
    }

    public final at bGt() {
        return xs(this.ozH.bGP());
    }

    public final j bGu() {
        j xq = this.ozM.xq(this.ozH.bGP());
        if (xq == null) {
            xq = this.ozN.xq(this.ozH.bGP());
        }
        if (xq == null) {
            return this.ozO.xq(this.ozH.bGP());
        }
        return xq;
    }

    public final void xz(int i) {
        this.ozN.xr(i);
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public final void bGv() {
        this.ozN.bGF();
        this.ozO.bGF();
    }

    public final void bGw() {
        this.ozN.onPause();
        this.ozO.bGF();
    }

    public final void bGx() {
        this.ozN.onResume();
    }

    public final void xA(int i) {
        bx xs = xs(i);
        if (xs != null && aH(xs)) {
            com.tencent.mm.ae.c.a aVar = this.ozM;
            d aW = d.aW(xs);
            if (aW != null && xs != null) {
                com.tencent.mm.ae.c GI = n.GI();
                long j = aW.cLu;
                long j2 = xs.field_msgId;
                if (aVar == null) {
                    v.e("ModelImage.DownloadImgService", "listener is null");
                } else {
                    b bVar = new b(j, j2, 1);
                    b bVar2 = null;
                    if (GI.cLj == null || !GI.cLj.equals(bVar)) {
                        int indexOf = GI.cLh.indexOf(bVar);
                        if (-1 != indexOf) {
                            bVar2 = (b) GI.cLh.get(indexOf);
                        }
                    } else {
                        bVar2 = GI.cLj;
                    }
                    if (bVar2 != null) {
                        bVar2.b(aVar);
                        GI.a(bVar2);
                        v.i("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] task has been canceled, (" + j + ", " + j2 + ", 1)");
                    } else {
                        v.e("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] task no found, (" + j + ", " + j2 + ", 1)");
                    }
                }
                n.GI().d(aW.cLu, xs.field_msgId);
            }
        }
    }

    public final void xB(int i) {
        this.ozO.xI(i);
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
        super.a(viewGroup, i, obj);
    }
}
