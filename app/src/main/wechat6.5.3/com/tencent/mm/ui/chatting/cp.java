package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.a.a.k;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.ae.a.a.c;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.f.a.a.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.applet.h;
import com.tencent.mm.pluginsdk.ui.chat.l;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.j;
import com.tencent.mm.v.e;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import junit.framework.Assert;

public final class cp extends j<at> implements com.tencent.mm.as.o.a, com.tencent.mm.pluginsdk.model.app.j.a, e {
    private static Map<String, Integer> oqL;
    private static HashMap<String, com.tencent.mm.pluginsdk.ui.e> oqR = new HashMap();
    private static String oqe;
    boolean aRp = true;
    private int aZt;
    protected String bdo;
    protected String cyO;
    protected c eSp;
    int eTd;
    int emv;
    protected long ezh;
    ac fnw;
    private LayoutInflater gwU;
    private short[] hjT;
    protected com.tencent.mm.pluginsdk.ui.e ilw;
    protected OnCreateContextMenuListener ima;
    private HashMap<Integer, ad> jUm = new HashMap();
    private boolean lKa;
    private boolean lVu;
    protected com.tencent.mm.ui.chatting.ChattingUI.a ols;
    private short[] opZ;
    boolean oqA = false;
    boolean oqB = false;
    private boolean oqC = false;
    boolean oqD = false;
    boolean oqE = false;
    boolean oqF = false;
    TreeSet<Long> oqG;
    long oqH = -1;
    Map<Long, View> oqI;
    Map<Long, Integer> oqJ;
    private List<Long> oqK;
    at oqM;
    private boolean oqN;
    private boolean oqO;
    boolean oqP;
    OnClickListener oqQ;
    private long oqS;
    public long oqa = -1;
    private HashSet<Long> oqb = new HashSet();
    com.tencent.mm.pluginsdk.ui.d.b oqc;
    protected o oqd;
    private final int oqf;
    private final int oqg;
    protected cq oqh;
    private cq oqi;
    protected cs oqj;
    private cs oqk;
    protected cr oql;
    private cr oqm;
    protected l oqn;
    private l oqo;
    protected a oqp;
    private a oqq;
    protected n oqr;
    private n oqs;
    private OnCreateContextMenuListener oqt;
    protected OnClickListener oqu;
    private long oqv = -1;
    private long oqw = -1;
    private long oqx = -1;
    private int oqy = 0;
    private int oqz = 0;

    class a implements OnClickListener {
        final /* synthetic */ cp oqU;

        a(cp cpVar) {
            this.oqU = cpVar;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof b) {
                b bVar = (b) view.getTag();
                long j = bVar.bao;
                ak.yW();
                bx ek = com.tencent.mm.model.c.wJ().ek(bVar.bao);
                if (ex(j)) {
                    g.iuh.Y(10231, "1");
                    com.tencent.mm.ai.b.HB();
                    if (ek.field_msgId == j) {
                        com.tencent.mm.modelstat.b.daJ.b(ek, false);
                    }
                } else {
                    com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(bVar.blq);
                    if (dV != null) {
                        ajr com_tencent_mm_protocal_c_ajr;
                        g.iuh.Y(10090, "0,1");
                        String valueOf = String.valueOf(bVar.bao);
                        String str = bVar.bhr;
                        ak.yW();
                        String xq = com.tencent.mm.model.c.xq();
                        String str2 = bVar.bhr;
                        if (dV == null) {
                            com_tencent_mm_protocal_c_ajr = null;
                        } else {
                            com_tencent_mm_protocal_c_ajr = new ajr();
                            com_tencent_mm_protocal_c_ajr.mJV = 0;
                            com_tencent_mm_protocal_c_ajr.mJW = valueOf;
                            com_tencent_mm_protocal_c_ajr.mJX = 0.0f;
                            com_tencent_mm_protocal_c_ajr.mKa = SQLiteDatabase.KeyEmpty;
                            com_tencent_mm_protocal_c_ajr.mKb = str;
                            com_tencent_mm_protocal_c_ajr.mKg = str2;
                            com_tencent_mm_protocal_c_ajr.mfh = 1;
                            com_tencent_mm_protocal_c_ajr.mKf = null;
                            com_tencent_mm_protocal_c_ajr.mJY = dV.title;
                            com_tencent_mm_protocal_c_ajr.mJZ = dV.description;
                            com_tencent_mm_protocal_c_ajr.mKe = dV.url;
                            com_tencent_mm_protocal_c_ajr.mKd = dV.coa;
                            com_tencent_mm_protocal_c_ajr.mKc = dV.cos;
                            com_tencent_mm_protocal_c_ajr.glj = dV.appId;
                            com_tencent_mm_protocal_c_ajr.mKh = xq;
                        }
                        com.tencent.mm.ai.b.b(com_tencent_mm_protocal_c_ajr);
                    }
                    if (ek.field_msgId == j) {
                        com.tencent.mm.modelstat.b.daJ.b(ek, true);
                    }
                }
                this.oqU.ols.onh.notifyDataSetChanged();
            }
        }

        private static boolean ex(long j) {
            ajr HE = com.tencent.mm.ai.b.HE();
            if (HE == null || HE.mJW == null || HE.mJV != 0 || !com.tencent.mm.ai.b.HC()) {
                return false;
            }
            try {
                if (j == Long.parseLong(HE.mJW)) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
    }

    static class b {
        public long bao;
        public String bhr;
        public String blq;

        b() {
        }
    }

    static /* synthetic */ void a(cp cpVar, h hVar) {
        int lastIndexOf;
        LinkedList linkedList = new LinkedList();
        if (m.dE(cpVar.bdo)) {
            lastIndexOf = hVar.url.lastIndexOf("/");
            if (lastIndexOf >= 0) {
                linkedList.add(hVar.url.substring(lastIndexOf + 1));
            } else {
                return;
            }
        }
        linkedList.add(cpVar.bdo);
        LinkedList linkedList2 = new LinkedList();
        for (lastIndexOf = 0; lastIndexOf < linkedList.size(); lastIndexOf++) {
            linkedList2.add(Integer.valueOf(3));
        }
        new com.tencent.mm.pluginsdk.ui.applet.j(cpVar.ols.nDR.nEl, new com.tencent.mm.pluginsdk.ui.applet.j.a(cpVar) {
            final /* synthetic */ cp oqU;

            {
                this.oqU = r1;
            }

            public final void cr(boolean z) {
            }
        }).f(linkedList, linkedList2);
    }

    static {
        Map hashMap = new HashMap();
        oqL = hashMap;
        hashMap.put("T49S", Integer.valueOf(19));
        oqL.put("T49R", Integer.valueOf(18));
        oqL.put("T268435505S", Integer.valueOf(21));
        oqL.put("T268435505R", Integer.valueOf(20));
        oqL.put("T1048625S", Integer.valueOf(30));
        oqL.put("T1048625R", Integer.valueOf(29));
        oqL.put("T369098801S", Integer.valueOf(47));
        oqL.put("T369098801R", Integer.valueOf(46));
        oqL.put("T335544369S", Integer.valueOf(42));
        oqL.put("T335544369R", Integer.valueOf(41));
        oqL.put("T402653233S", Integer.valueOf(45));
        oqL.put("T402653233R", Integer.valueOf(44));
        oqL.put("T16777265S", Integer.valueOf(23));
        oqL.put("T16777265R", Integer.valueOf(22));
        oqL.put("T10000R", Integer.valueOf(5));
        oqL.put("T10000S", Integer.valueOf(5));
        oqL.put("T10002R", Integer.valueOf(5));
        oqL.put("T64R", Integer.valueOf(5));
        oqL.put("T39S", Integer.valueOf(3));
        oqL.put("T39R", Integer.valueOf(1));
        oqL.put("T3S", Integer.valueOf(3));
        oqL.put("T3R", Integer.valueOf(1));
        oqL.put("T23S", Integer.valueOf(3));
        oqL.put("T23R", Integer.valueOf(1));
        oqL.put("T47S", Integer.valueOf(15));
        oqL.put("T47R", Integer.valueOf(14));
        oqL.put("T34S", Integer.valueOf(7));
        oqL.put("T34R", Integer.valueOf(6));
        oqL.put("T35R", Integer.valueOf(8));
        oqL.put("T42S", Integer.valueOf(13));
        oqL.put("T42R", Integer.valueOf(12));
        oqL.put("T37R", Integer.valueOf(9));
        oqL.put("T40R", Integer.valueOf(9));
        oqL.put("T43S", Integer.valueOf(11));
        oqL.put("T43R", Integer.valueOf(10));
        oqL.put("T48S", Integer.valueOf(17));
        oqL.put("T48R", Integer.valueOf(16));
        oqL.put("T52R", Integer.valueOf(25));
        oqL.put("T50R", Integer.valueOf(24));
        oqL.put("T50S", Integer.valueOf(43));
        oqL.put("T285212721R", Integer.valueOf(26));
        oqL.put("T301989937S", Integer.valueOf(32));
        oqL.put("T301989937R", Integer.valueOf(31));
        oqL.put("T1S", Integer.valueOf(4));
        oqL.put("T1R", Integer.valueOf(2));
        oqL.put("T11S", Integer.valueOf(4));
        oqL.put("T11R", Integer.valueOf(2));
        oqL.put("T13S", Integer.valueOf(3));
        oqL.put("T13R", Integer.valueOf(1));
        oqL.put("T21S", Integer.valueOf(4));
        oqL.put("T21R", Integer.valueOf(2));
        oqL.put("T31S", Integer.valueOf(4));
        oqL.put("T31R", Integer.valueOf(2));
        oqL.put("T36S", Integer.valueOf(4));
        oqL.put("T36R", Integer.valueOf(2));
        oqL.put("T53R", Integer.valueOf(27));
        oqL.put("T53S", Integer.valueOf(28));
        oqL.put("T55R", Integer.valueOf(36));
        oqL.put("T55S", Integer.valueOf(37));
        oqL.put("T57R", Integer.valueOf(36));
        oqL.put("T57S", Integer.valueOf(37));
        oqL.put("T-1879048191R", Integer.valueOf(33));
        oqL.put("T-1879048189R", Integer.valueOf(34));
        oqL.put("T-1879048190R", Integer.valueOf(35));
        oqL.put("T-1879048188R", Integer.valueOf(38));
        oqL.put("T-1879048187R", Integer.valueOf(39));
        oqL.put("T318767153R", Integer.valueOf(40));
        oqL.put("T486539313R", Integer.valueOf(65));
        oqL.put("T-1879048186R", Integer.valueOf(48));
        oqL.put("T-1879048186S", Integer.valueOf(49));
        oqL.put("T-1879048185R", Integer.valueOf(52));
        oqL.put("T-1879048185S", Integer.valueOf(52));
        oqL.put("T-1879048183R", Integer.valueOf(57));
        oqL.put("T-1879048183S", Integer.valueOf(57));
        oqL.put("T-1879048176R", Integer.valueOf(58));
        oqL.put("T-1879048176S", Integer.valueOf(58));
        oqL.put("T419430449R", Integer.valueOf(53));
        oqL.put("T419430449S", Integer.valueOf(54));
        oqL.put("T436207665R", Integer.valueOf(59));
        oqL.put("T436207665S", Integer.valueOf(60));
        oqL.put("T62R", Integer.valueOf(55));
        oqL.put("T62S", Integer.valueOf(56));
        oqL.put("T452984881R", Integer.valueOf(61));
        oqL.put("T452984881S", Integer.valueOf(62));
        oqL.put("T469762097R", Integer.valueOf(63));
        oqL.put("T469762097S", Integer.valueOf(64));
        oqL.put("T503316529R", Integer.valueOf(66));
        oqL.put("T503316529S", Integer.valueOf(67));
        oqL.put("T520093745R", Integer.valueOf(68));
        oqL.put("T520093745S", Integer.valueOf(69));
    }

    public cp(final com.tencent.mm.ui.chatting.ChattingUI.a aVar, at atVar, String str, String str2, o oVar, OnCreateContextMenuListener onCreateContextMenuListener) {
        super(aVar.nDR.nEl, atVar);
        this.jUm.put(Integer.valueOf(19), new aw(19));
        this.jUm.put(Integer.valueOf(18), new ao(18));
        this.jUm.put(Integer.valueOf(21), new ax());
        this.jUm.put(Integer.valueOf(20), new ap());
        this.jUm.put(Integer.valueOf(23), new av());
        this.jUm.put(Integer.valueOf(22), new au());
        this.jUm.put(Integer.valueOf(30), new an());
        this.jUm.put(Integer.valueOf(29), new am());
        this.jUm.put(Integer.valueOf(47), new aw(47));
        this.jUm.put(Integer.valueOf(46), new ao(46));
        this.jUm.put(Integer.valueOf(42), new aw(42));
        this.jUm.put(Integer.valueOf(41), new ao(41));
        this.jUm.put(Integer.valueOf(45), new aw(45));
        this.jUm.put(Integer.valueOf(44), new ao(44));
        this.jUm.put(Integer.valueOf(5), new bu());
        this.jUm.put(Integer.valueOf(3), new bn());
        this.jUm.put(Integer.valueOf(1), new bm());
        this.jUm.put(Integer.valueOf(15), new bh());
        this.jUm.put(Integer.valueOf(14), new bg());
        this.jUm.put(Integer.valueOf(7), new ce());
        this.jUm.put(Integer.valueOf(6), new ca());
        this.jUm.put(Integer.valueOf(8), new bq());
        this.jUm.put(Integer.valueOf(13), new bc());
        this.jUm.put(Integer.valueOf(12), new bb());
        this.jUm.put(Integer.valueOf(9), new bi());
        this.jUm.put(Integer.valueOf(11), new bz(11));
        this.jUm.put(Integer.valueOf(10), new by(10));
        this.jUm.put(Integer.valueOf(17), new bp());
        this.jUm.put(Integer.valueOf(16), new bo());
        this.jUm.put(Integer.valueOf(25), new ck());
        this.jUm.put(Integer.valueOf(24), new ch());
        this.jUm.put(Integer.valueOf(43), new cl());
        this.jUm.put(Integer.valueOf(4), new bx(4));
        this.jUm.put(Integer.valueOf(2), new bw(2));
        this.jUm.put(Integer.valueOf(26), new az());
        this.jUm.put(Integer.valueOf(27), new ci());
        this.jUm.put(Integer.valueOf(28), new cj());
        this.jUm.put(Integer.valueOf(31), new bw(2));
        this.jUm.put(Integer.valueOf(32), new bx(4));
        this.jUm.put(Integer.valueOf(33), new cd());
        this.jUm.put(Integer.valueOf(34), new cb());
        this.jUm.put(Integer.valueOf(35), new cc());
        this.jUm.put(Integer.valueOf(36), new bs());
        this.jUm.put(Integer.valueOf(37), new bt());
        this.jUm.put(Integer.valueOf(38), new co());
        this.jUm.put(Integer.valueOf(39), new cn());
        this.jUm.put(Integer.valueOf(40), new be());
        this.jUm.put(Integer.valueOf(65), new ba());
        this.jUm.put(Integer.valueOf(48), new aq());
        this.jUm.put(Integer.valueOf(49), new ar());
        this.jUm.put(Integer.valueOf(52), new bj());
        this.jUm.put(Integer.valueOf(57), new bk());
        this.jUm.put(Integer.valueOf(58), new bl());
        this.jUm.put(Integer.valueOf(54), new at());
        this.jUm.put(Integer.valueOf(53), new as());
        this.jUm.put(Integer.valueOf(60), new ah());
        this.jUm.put(Integer.valueOf(59), new ae());
        this.jUm.put(Integer.valueOf(56), new bz(56));
        this.jUm.put(Integer.valueOf(55), new by(55));
        this.jUm.put(Integer.valueOf(62), new al());
        this.jUm.put(Integer.valueOf(61), new ak());
        this.jUm.put(Integer.valueOf(64), new ag());
        this.jUm.put(Integer.valueOf(63), new af());
        this.jUm.put(Integer.valueOf(67), new aj());
        this.jUm.put(Integer.valueOf(66), new ai());
        this.jUm.put(Integer.valueOf(69), new al());
        this.jUm.put(Integer.valueOf(68), new ak());
        this.oqM = new at();
        this.lKa = false;
        this.oqN = false;
        this.oqO = false;
        this.oqP = false;
        this.oqQ = null;
        this.ilw = null;
        this.lVu = false;
        this.oqS = 0;
        this.eSp = null;
        this.oqH = -1;
        this.ols = aVar;
        this.aZt = 211;
        this.oqf = aVar.getResources().getDimensionPixelSize(com.tencent.mm.bi.a.b.peR);
        this.oqg = aVar.getResources().getDimensionPixelSize(2131493144);
        this.oqc = new com.tencent.mm.pluginsdk.ui.d.b(this) {
            final /* synthetic */ cp oqU;

            public final Object a(h hVar) {
                f.ux(6);
                switch (hVar.type) {
                    case 1:
                        return cp.oqe;
                    case 2:
                    case 6:
                    case 7:
                    case 9:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case k.MG /*18*/:
                    case 20:
                    case 21:
                    case k.MM /*22*/:
                    case k.Nb /*23*/:
                        aVar.finish();
                        break;
                    case 4:
                        cp.a(this.oqU, hVar);
                        break;
                    case 25:
                    case 30:
                    case 31:
                        return cp.oqe;
                }
                return null;
            }
        };
        this.oqt = onCreateContextMenuListener;
        this.ima = onCreateContextMenuListener;
        cs csVar = new cs(onCreateContextMenuListener, aVar);
        this.oqk = csVar;
        this.oqj = csVar;
        cr crVar = new cr(aVar);
        this.oqm = crVar;
        this.oql = crVar;
        l lVar = new l(aVar.nDR.nEl);
        this.oqo = lVar;
        this.oqn = lVar;
        a aVar2 = new a(this);
        this.oqq = aVar2;
        this.oqp = aVar2;
        n nVar = new n(aVar);
        this.oqs = nVar;
        this.oqr = nVar;
        this.oqu = new cy(aVar);
        for (Integer num : this.jUm.keySet()) {
            ((ad) this.jUm.get(num)).nQK = aVar.nQK;
        }
        a(str, oVar, str2);
        this.oqI = new HashMap();
        this.oqJ = new HashMap();
        this.oqK = new ArrayList();
        if (this.eSp == null) {
            com.tencent.mm.ae.a.a.c.a aVar3 = new com.tencent.mm.ae.a.a.c.a();
            aVar3.cPv = com.tencent.mm.modelbiz.a.e.ic(this.ols.bEn());
            aVar3.cPs = true;
            aVar3.cPO = true;
            aVar3.cPH = 2131165440;
            this.eSp = aVar3.GU();
        }
    }

    public final void a(String str, o oVar, String str2) {
        this.oqG = new TreeSet();
        oqe = str;
        if (u.ew(str)) {
            this.cyO = u.LM(str2);
        } else {
            this.cyO = str2;
        }
        this.oqd = oVar;
        cq cqVar = new cq(this.ols, str);
        this.oqi = cqVar;
        this.oqh = cqVar;
        this.bdo = str;
        this.ezh = this.ols.bFS();
        bEC();
    }

    public final void bEC() {
        if (this.oqG != null) {
            this.oqG.clear();
        }
        this.emv = 0;
        this.eTd = -1;
        this.oqv = -1;
        this.oqw = -1;
        this.oqx = -1;
        this.oqa = -1;
        this.oqy = 0;
        this.oqz = 0;
        this.oqA = false;
        this.oqB = false;
        this.oqC = false;
        this.oqD = false;
    }

    public final int k(long j, boolean z) {
        ak.yW();
        bx ek = com.tencent.mm.model.c.wJ().ek(j);
        if (ek.field_msgId != j) {
            v.w("MicroMsg.ChattingListAdapter", "get msg info by id %d error", Long.valueOf(j));
            return 0;
        }
        int j2;
        long j3 = ek.field_createTime;
        if (j3 < this.oqv || j3 > this.oqw) {
            this.oqv = j3;
            this.oqx = ((d) com.tencent.mm.kernel.g.f(d.class)).azI().Nh(this.bdo);
            if (z) {
                this.oqw = this.oqx;
            } else {
                ak.yW();
                this.oqw = com.tencent.mm.model.c.wJ().ag(this.bdo, j3);
            }
            this.oqC = true;
            ak.yW();
            v.v("MicroMsg.ChattingListAdapter", "reset position, reload count %d", Integer.valueOf(com.tencent.mm.model.c.wJ().j(this.bdo, this.oqv, this.oqw)));
            if (com.tencent.mm.model.c.wJ().j(this.bdo, this.oqv, this.oqw) < 18) {
                v.d("MicroMsg.ChattingListAdapter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", Long.valueOf(this.oqv), Integer.valueOf(0));
                ak.yW();
                this.oqv = com.tencent.mm.model.c.wJ().af(this.bdo, this.oqv);
                ak.yW();
                j2 = com.tencent.mm.model.c.wJ().j(this.bdo, this.oqv, j3);
            } else {
                j2 = 0;
            }
        } else {
            ak.yW();
            j2 = com.tencent.mm.model.c.wJ().j(this.bdo, this.oqv, j3);
        }
        v.v("MicroMsg.ChattingListAdapter", "set local message id, id[%d] top create time[%d] bottom create time[%d] last create time[%d] selection[%d]", Long.valueOf(j), Long.valueOf(this.oqv), Long.valueOf(this.oqw), Long.valueOf(this.oqx), Integer.valueOf(j2));
        return j2;
    }

    static at a(at atVar, Cursor cursor) {
        if (atVar == null) {
            atVar = new at();
        }
        atVar.b(cursor);
        return atVar;
    }

    public final boolean bED() {
        if (this.oqC) {
            this.oqx = ((d) com.tencent.mm.kernel.g.f(d.class)).azI().Nh(this.bdo);
            if (this.oqx >= this.oqw) {
                this.oqw = this.oqx;
                Ol();
                return true;
            }
        }
        return false;
    }

    protected final void Om() {
        boolean z;
        ak.yW();
        au wJ = com.tencent.mm.model.c.wJ();
        if (wJ.nwa.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        setCursor(wJ.cuX.query(((com.tencent.mm.storage.au.b) wJ.nwa.get(0)).name, null, "msgId=?", new String[]{"-1"}, null, null, null));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Ol() {
        /*
        r12 = this;
        r0 = r12.ezh;
        r2 = -1;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 == 0) goto L_0x00d1;
    L_0x0008:
        r0 = r12.ols;
        r0 = r0.lKa;
        if (r0 == 0) goto L_0x00d1;
    L_0x000e:
        r0 = 1;
        r12.lKa = r0;
    L_0x0011:
        r0 = r12.oqC;
        if (r0 != 0) goto L_0x03b2;
    L_0x0015:
        r0 = r12.lKa;
        if (r0 == 0) goto L_0x00d6;
    L_0x0019:
        r0 = com.tencent.mm.model.ak.yW();
        r0 = r0.cqY;
        r1 = r12.bdo;
        r2 = r12.ezh;
        r0 = r0.M(r1, r2);
        r12.emv = r0;
    L_0x0029:
        r0 = 0;
        r1 = r12.eTd;
        if (r1 < 0) goto L_0x0034;
    L_0x002e:
        r1 = r12.eTd;
        r2 = r12.emv;
        if (r1 <= r2) goto L_0x003b;
    L_0x0034:
        r0 = 1;
        r1 = r12.emv;
        r1 = r1 + -18;
        r12.eTd = r1;
    L_0x003b:
        r1 = "MicroMsg.ChattingListAdapter";
        r2 = "summerbadcr resetCursor restart:%b fromCount:%d totalcount:%d limit:%d, talker:%s isBizChat:%b";
        r3 = 6;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = java.lang.Boolean.valueOf(r0);
        r3[r4] = r5;
        r4 = 1;
        r5 = r12.eTd;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 2;
        r5 = r12.emv;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 3;
        r5 = r12.emv;
        r6 = r12.eTd;
        r5 = r5 - r6;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 4;
        r5 = r12.bdo;
        r3[r4] = r5;
        r4 = 5;
        r5 = r12.lKa;
        r5 = java.lang.Boolean.valueOf(r5);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.v.i(r1, r2, r3);
        r1 = r12.lKa;
        if (r1 == 0) goto L_0x00e7;
    L_0x007e:
        r0 = com.tencent.mm.model.ak.yW();
        r0 = r0.cqY;
        r1 = r12.bdo;
        r2 = r12.ezh;
        r4 = r12.emv;
        r5 = r12.eTd;
        r4 = r4 - r5;
        r3 = r0.i(r1, r2, r4);
    L_0x0091:
        if (r3 == 0) goto L_0x0099;
    L_0x0093:
        r0 = r3.isClosed();
        if (r0 == 0) goto L_0x0366;
    L_0x0099:
        r0 = "MicroMsg.ChattingListAdapter";
        r1 = "update pos fail, cursor is null";
        com.tencent.mm.sdk.platformtools.v.w(r0, r1);
    L_0x00a2:
        r12.setCursor(r3);
    L_0x00a5:
        r0 = r12.getCount();
        if (r0 <= 0) goto L_0x00b3;
    L_0x00ab:
        r1 = new short[r0];
        r12.opZ = r1;
        r0 = new short[r0];
        r12.hjT = r0;
    L_0x00b3:
        r0 = r12.oqI;
        r0.clear();
        r0 = r12.oqJ;
        r0.clear();
        r0 = r12.oqK;
        r0.clear();
        super.notifyDataSetChanged();
        r0 = r12.oqF;
        if (r0 == 0) goto L_0x00d0;
    L_0x00c9:
        r0 = com.tencent.mm.ar.l.KE();
        r0.Ky();
    L_0x00d0:
        return;
    L_0x00d1:
        r0 = 0;
        r12.lKa = r0;
        goto L_0x0011;
    L_0x00d6:
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.wJ();
        r1 = r12.bdo;
        r0 = r0.MW(r1);
        r12.emv = r0;
        goto L_0x0029;
    L_0x00e7:
        r1 = r12.ols;
        r1 = r1.onl;
        if (r1 != 0) goto L_0x0100;
    L_0x00ed:
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.wJ();
        r1 = r12.bdo;
        r2 = r12.emv;
        r3 = r12.eTd;
        r2 = r2 - r3;
        r3 = r0.bQ(r1, r2);
        goto L_0x0091;
    L_0x0100:
        com.tencent.mm.model.ak.yW();
        r1 = com.tencent.mm.model.c.wJ();
        r2 = r12.bdo;
        r3 = r12.emv;
        r4 = r12.eTd;
        r3 = r3 - r4;
        r3 = r1.bQ(r2, r3);
        r1 = r12.ols;
        r1 = r1.ota;
        if (r1 == 0) goto L_0x0091;
    L_0x0118:
        if (r3 != 0) goto L_0x01cc;
    L_0x011a:
        r1 = -1;
    L_0x011b:
        r2 = "MicroMsg.ChattingListAdapter";
        r4 = "summerbadcr resetCursor check fault count[%d], talker[%s]";
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = java.lang.Integer.valueOf(r1);
        r5[r6] = r7;
        r6 = 1;
        r7 = r12.bdo;
        r5[r6] = r7;
        com.tencent.mm.sdk.platformtools.v.i(r2, r4, r5);
        if (r1 <= 0) goto L_0x0091;
    L_0x0135:
        if (r0 == 0) goto L_0x01d2;
    L_0x0137:
        r1 = r3.moveToLast();
        if (r1 == 0) goto L_0x01d8;
    L_0x013d:
        r4 = 1;
        r6 = java.lang.System.currentTimeMillis();
        com.tencent.mm.model.ak.yW();
        r1 = com.tencent.mm.model.c.wK();
        r2 = r12.bdo;
        r1 = r1.Mh(r2);
        if (r1 != 0) goto L_0x01da;
    L_0x0151:
        r1 = 0;
    L_0x0152:
        r2 = "MicroMsg.ChattingListAdapter";
        r5 = "summerbadcr revisedCursor check fault first/last seq[%d], restart[%b], undeliver[%d]";
        r8 = 3;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = "msgSeq";
        r10 = r3.getColumnIndex(r10);
        r10 = r3.getInt(r10);
        r10 = java.lang.Integer.valueOf(r10);
        r8[r9] = r10;
        r9 = 1;
        r10 = java.lang.Boolean.valueOf(r0);
        r8[r9] = r10;
        r9 = 2;
        r10 = java.lang.Integer.valueOf(r1);
        r8[r9] = r10;
        com.tencent.mm.sdk.platformtools.v.i(r2, r5, r8);
        r2 = 0;
    L_0x017f:
        r5 = "flag";
        r5 = r3.getColumnIndex(r5);
        r5 = r3.getInt(r5);
        r8 = r5 & 2;
        if (r8 != 0) goto L_0x01de;
    L_0x018e:
        r8 = "isSend";
        r8 = r3.getColumnIndex(r8);
        r8 = r3.getInt(r8);
        if (r8 == 0) goto L_0x01de;
    L_0x019b:
        r2 = r2 + 1;
    L_0x019d:
        if (r0 == 0) goto L_0x035e;
    L_0x019f:
        r5 = r3.moveToPrevious();
        if (r5 != 0) goto L_0x017f;
    L_0x01a5:
        r1 = r4;
        r0 = r3;
    L_0x01a7:
        if (r1 == 0) goto L_0x01c9;
    L_0x01a9:
        r1 = "MicroMsg.ChattingListAdapter";
        r3 = "summerbadcr resetCursor check fault traversal all not found take time[%d]ms, cursor index:%d";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r8 = java.lang.System.currentTimeMillis();
        r6 = r8 - r6;
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        r5 = 1;
        r2 = java.lang.Integer.valueOf(r2);
        r4[r5] = r2;
        com.tencent.mm.sdk.platformtools.v.i(r1, r3, r4);
    L_0x01c9:
        r3 = r0;
        goto L_0x0091;
    L_0x01cc:
        r1 = r3.getCount();
        goto L_0x011b;
    L_0x01d2:
        r1 = r3.moveToFirst();
        if (r1 != 0) goto L_0x013d;
    L_0x01d8:
        r0 = r3;
        goto L_0x01c9;
    L_0x01da:
        r1 = r1.field_UnDeliverCount;
        goto L_0x0152;
    L_0x01de:
        if (r1 != 0) goto L_0x0263;
    L_0x01e0:
        r8 = r5 & 2;
        if (r8 != 0) goto L_0x0263;
    L_0x01e4:
        r5 = "type";
        r5 = r3.getColumnIndex(r5);
        r5 = r3.getInt(r5);
        r8 = 50;
        if (r5 > r8) goto L_0x01f5;
    L_0x01f3:
        if (r5 >= 0) goto L_0x01f8;
    L_0x01f5:
        r2 = r2 + 1;
        goto L_0x019d;
    L_0x01f8:
        r0 = r12.ols;
        r1 = 0;
        r0.ota = r1;
        r0 = new com.tencent.mm.storage.at;
        r0.<init>();
        r0.b(r3);
        r3.moveToFirst();
        r1 = "MicroMsg.ChattingListAdapter";
        r4 = "summerbadcr revisedCursor check fault but not needCheckFault more break[%d, %d, %d, %d, %d, %d] take time[%d]ms, cursor index:%d";
        r5 = 8;
        r5 = new java.lang.Object[r5];
        r8 = 0;
        r9 = r0.field_flag;
        r9 = java.lang.Integer.valueOf(r9);
        r5[r8] = r9;
        r8 = 1;
        r9 = r0.field_isSend;
        r9 = java.lang.Integer.valueOf(r9);
        r5[r8] = r9;
        r8 = 2;
        r10 = r0.field_msgId;
        r9 = java.lang.Long.valueOf(r10);
        r5[r8] = r9;
        r8 = 3;
        r10 = r0.field_msgSvrId;
        r9 = java.lang.Long.valueOf(r10);
        r5[r8] = r9;
        r8 = 4;
        r10 = r0.field_msgSeq;
        r9 = java.lang.Long.valueOf(r10);
        r5[r8] = r9;
        r8 = 5;
        r0 = r0.field_type;
        r0 = java.lang.Integer.valueOf(r0);
        r5[r8] = r0;
        r0 = 6;
        r8 = java.lang.System.currentTimeMillis();
        r8 = r8 - r6;
        r8 = java.lang.Long.valueOf(r8);
        r5[r0] = r8;
        r0 = 7;
        r8 = java.lang.Integer.valueOf(r2);
        r5[r0] = r8;
        com.tencent.mm.sdk.platformtools.v.i(r1, r4, r5);
        r0 = 0;
        r1 = r0;
        r0 = r3;
        goto L_0x01a7;
    L_0x0263:
        r8 = r5 & 1;
        if (r8 != 0) goto L_0x026b;
    L_0x0267:
        r2 = r2 + 1;
        goto L_0x019d;
    L_0x026b:
        if (r2 != 0) goto L_0x027a;
    L_0x026d:
        r2 = r2 + 1;
        r5 = "MicroMsg.ChattingListAdapter";
        r8 = "summerbadcr revisedCursor check fault index == 0 continue";
        com.tencent.mm.sdk.platformtools.v.i(r5, r8);
        goto L_0x019d;
    L_0x027a:
        r1 = r5 & 4;
        if (r1 == 0) goto L_0x0325;
    L_0x027e:
        r1 = 1;
    L_0x027f:
        r4 = new com.tencent.mm.storage.at;
        r4.<init>();
        r4.b(r3);
        r3.close();
        if (r0 == 0) goto L_0x0328;
    L_0x028c:
        r0 = r12.emv;
        r0 = r0 - r2;
        r0 = r0 + -1;
        r12.eTd = r0;
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.wJ();
        r3 = r12.bdo;
        r5 = r12.emv;
        r8 = r12.eTd;
        r5 = r5 - r8;
        r0 = r0.bQ(r3, r5);
    L_0x02a5:
        r3 = "MicroMsg.ChattingListAdapter";
        r5 = "summerbadcr revisedCursor check fault faultUp[%b]  break[%d, %d, %d, %d, %d, %d, %d] take time[%d]ms, cursor index:%d, nowCount:%d, fromCount:%d";
        r8 = 12;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r1 = java.lang.Boolean.valueOf(r1);
        r8[r9] = r1;
        r1 = 1;
        r9 = r4.field_flag;
        r9 = java.lang.Integer.valueOf(r9);
        r8[r1] = r9;
        r1 = 2;
        r9 = r4.field_isSend;
        r9 = java.lang.Integer.valueOf(r9);
        r8[r1] = r9;
        r1 = 3;
        r10 = r4.field_msgId;
        r9 = java.lang.Long.valueOf(r10);
        r8[r1] = r9;
        r1 = 4;
        r10 = r4.field_msgSvrId;
        r9 = java.lang.Long.valueOf(r10);
        r8[r1] = r9;
        r1 = 5;
        r10 = r4.field_msgSeq;
        r9 = java.lang.Long.valueOf(r10);
        r8[r1] = r9;
        r1 = 6;
        r9 = r4.field_type;
        r9 = java.lang.Integer.valueOf(r9);
        r8[r1] = r9;
        r1 = 7;
        r10 = r4.field_createTime;
        r4 = java.lang.Long.valueOf(r10);
        r8[r1] = r4;
        r1 = 8;
        r10 = java.lang.System.currentTimeMillis();
        r10 = r10 - r6;
        r4 = java.lang.Long.valueOf(r10);
        r8[r1] = r4;
        r1 = 9;
        r4 = java.lang.Integer.valueOf(r2);
        r8[r1] = r4;
        r4 = 10;
        if (r0 != 0) goto L_0x0359;
    L_0x030e:
        r1 = -1;
    L_0x030f:
        r1 = java.lang.Integer.valueOf(r1);
        r8[r4] = r1;
        r1 = 11;
        r4 = r12.eTd;
        r4 = java.lang.Integer.valueOf(r4);
        r8[r1] = r4;
        com.tencent.mm.sdk.platformtools.v.i(r3, r5, r8);
        r1 = 0;
        goto L_0x01a7;
    L_0x0325:
        r1 = 0;
        goto L_0x027f;
    L_0x0328:
        if (r1 == 0) goto L_0x0343;
    L_0x032a:
        r0 = r12.eTd;
        r0 = r0 + r2;
        r12.eTd = r0;
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.wJ();
        r3 = r12.bdo;
        r5 = r12.emv;
        r8 = r12.eTd;
        r5 = r5 - r8;
        r0 = r0.bQ(r3, r5);
        goto L_0x02a5;
    L_0x0343:
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.wJ();
        r3 = r12.bdo;
        r5 = r12.emv;
        r8 = r12.eTd;
        r5 = r5 - r8;
        r8 = r4.field_createTime;
        r0 = r0.d(r3, r5, r8);
        goto L_0x02a5;
    L_0x0359:
        r1 = r0.getCount();
        goto L_0x030f;
    L_0x035e:
        r5 = r3.moveToNext();
        if (r5 != 0) goto L_0x017f;
    L_0x0364:
        goto L_0x01a5;
    L_0x0366:
        r0 = r3.moveToLast();
        if (r0 == 0) goto L_0x037a;
    L_0x036c:
        r0 = r12.oqM;
        r0 = a(r0, r3);
        r12.oqM = r0;
        r0 = r12.oqM;
        r0 = r0.field_createTime;
        r12.oqw = r0;
    L_0x037a:
        r0 = -1;
        r12.oqH = r0;
        r0 = r3.moveToFirst();
        if (r0 == 0) goto L_0x0392;
    L_0x0384:
        r0 = r12.oqM;
        r0 = a(r0, r3);
        r12.oqM = r0;
        r0 = r12.oqM;
        r0 = r0.field_createTime;
        r12.oqv = r0;
    L_0x0392:
        r0 = "MicroMsg.ChattingListAdapter";
        r1 = "update pos topCreateTime[%d] downCreateTime[%d]";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r4 = 0;
        r6 = r12.oqv;
        r5 = java.lang.Long.valueOf(r6);
        r2[r4] = r5;
        r4 = 1;
        r6 = r12.oqw;
        r5 = java.lang.Long.valueOf(r6);
        r2[r4] = r5;
        com.tencent.mm.sdk.platformtools.v.d(r0, r1, r2);
        goto L_0x00a2;
    L_0x03b2:
        r0 = "MicroMsg.ChattingListAdapter";
        r1 = "topLoadMore[%B] downLoadMore[%B]";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r12.oqA;
        r4 = java.lang.Boolean.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = r12.oqB;
        r4 = java.lang.Boolean.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
        r0 = r12.oqA;
        if (r0 != 0) goto L_0x0413;
    L_0x03d4:
        r0 = r12.oqB;
        if (r0 != 0) goto L_0x0413;
    L_0x03d8:
        r0 = r12.oqw;
        r2 = r12.oqx;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 < 0) goto L_0x0413;
    L_0x03e0:
        r0 = r12.lKa;
        if (r0 == 0) goto L_0x04f8;
    L_0x03e4:
        r0 = com.tencent.mm.model.ak.yW();
        r0 = r0.cqY;
        r1 = r12.bdo;
        r2 = r12.ezh;
        r0 = r0.P(r1, r2);
        r12.oqx = r0;
        r8 = 0;
        r0 = com.tencent.mm.model.ak.yW();
        r0 = r0.cqY;
        r1 = r12.bdo;
        r2 = r12.ezh;
        r4 = r12.oqw;
        r6 = r12.oqx;
        r0 = r0.a(r1, r2, r4, r6);
        r0 = r0 + -1;
        r0 = java.lang.Math.max(r8, r0);
        r12.oqz = r0;
    L_0x040f:
        r0 = r12.oqx;
        r12.oqw = r0;
    L_0x0413:
        r0 = r12.oqA;
        if (r0 == 0) goto L_0x0449;
    L_0x0417:
        r0 = 0;
        r12.oqA = r0;
        r0 = r12.lKa;
        if (r0 == 0) goto L_0x0528;
    L_0x041e:
        r0 = com.tencent.mm.model.ak.yW();
        r0 = r0.cqY;
        r1 = r12.bdo;
        r2 = r12.ezh;
        r4 = r12.oqv;
        r4 = r0.h(r1, r2, r4);
        r8 = 0;
        r0 = com.tencent.mm.model.ak.yW();
        r0 = r0.cqY;
        r1 = r12.bdo;
        r2 = r12.ezh;
        r6 = r12.oqv;
        r0 = r0.a(r1, r2, r4, r6);
        r0 = r0 + -1;
        r0 = java.lang.Math.max(r8, r0);
        r12.oqy = r0;
    L_0x0447:
        r12.oqv = r4;
    L_0x0449:
        r0 = r12.oqB;
        if (r0 == 0) goto L_0x047f;
    L_0x044d:
        r0 = 0;
        r12.oqB = r0;
        r0 = r12.lKa;
        if (r0 == 0) goto L_0x0552;
    L_0x0454:
        r0 = com.tencent.mm.model.ak.yW();
        r0 = r0.cqY;
        r1 = r12.bdo;
        r2 = r12.ezh;
        r4 = r12.oqw;
        r6 = r0.i(r1, r2, r4);
        r8 = 0;
        r0 = com.tencent.mm.model.ak.yW();
        r0 = r0.cqY;
        r1 = r12.bdo;
        r2 = r12.ezh;
        r4 = r12.oqw;
        r0 = r0.a(r1, r2, r4, r6);
        r0 = r0 + -1;
        r0 = java.lang.Math.max(r8, r0);
        r12.oqz = r0;
    L_0x047d:
        r12.oqw = r6;
    L_0x047f:
        r0 = "MicroMsg.ChattingListAdapter";
        r1 = "query topCreateTime[%d] downCreateTime[%d], lastCreateTime[%d], topInc[%d], bottomInc[%d]";
        r2 = 5;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r12.oqv;
        r4 = java.lang.Long.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = r12.oqw;
        r4 = java.lang.Long.valueOf(r4);
        r2[r3] = r4;
        r3 = 2;
        r4 = r12.oqx;
        r4 = java.lang.Long.valueOf(r4);
        r2[r3] = r4;
        r3 = 3;
        r4 = r12.oqy;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 4;
        r4 = r12.oqz;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.v.v(r0, r1, r2);
        r0 = r12.lKa;
        if (r0 == 0) goto L_0x057c;
    L_0x04bc:
        r8 = "MicroMsg.ChattingListAdapter";
        r9 = "count([top, down]) = %d";
        r0 = 1;
        r10 = new java.lang.Object[r0];
        r11 = 0;
        r0 = com.tencent.mm.model.ak.yW();
        r0 = r0.cqY;
        r1 = r12.bdo;
        r2 = r12.ezh;
        r4 = r12.oqv;
        r6 = r12.oqw;
        r0 = r0.a(r1, r2, r4, r6);
        r0 = java.lang.Integer.valueOf(r0);
        r10[r11] = r0;
        com.tencent.mm.sdk.platformtools.v.v(r8, r9, r10);
        r0 = com.tencent.mm.model.ak.yW();
        r0 = r0.cqY;
        r1 = r12.bdo;
        r2 = r12.ezh;
        r4 = r12.oqv;
        r6 = r12.oqw;
        r0 = r0.b(r1, r2, r4, r6);
        r12.setCursor(r0);
        goto L_0x00a5;
    L_0x04f8:
        r0 = com.tencent.mm.plugin.f.a.a.d.class;
        r0 = com.tencent.mm.kernel.g.f(r0);
        r0 = (com.tencent.mm.plugin.f.a.a.d) r0;
        r0 = r0.azI();
        r1 = r12.bdo;
        r0 = r0.Nh(r1);
        r12.oqx = r0;
        r6 = 0;
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.wJ();
        r1 = r12.bdo;
        r2 = r12.oqw;
        r4 = r12.oqx;
        r0 = r0.j(r1, r2, r4);
        r0 = r0 + -1;
        r0 = java.lang.Math.max(r6, r0);
        r12.oqz = r0;
        goto L_0x040f;
    L_0x0528:
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.wJ();
        r1 = r12.bdo;
        r2 = r12.oqv;
        r2 = r0.af(r1, r2);
        r6 = 0;
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.wJ();
        r1 = r12.bdo;
        r4 = r12.oqv;
        r0 = r0.j(r1, r2, r4);
        r0 = r0 + -1;
        r0 = java.lang.Math.max(r6, r0);
        r12.oqy = r0;
        r4 = r2;
        goto L_0x0447;
    L_0x0552:
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.wJ();
        r1 = r12.bdo;
        r2 = r12.oqw;
        r4 = r0.ag(r1, r2);
        r6 = 0;
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.wJ();
        r1 = r12.bdo;
        r2 = r12.oqw;
        r0 = r0.j(r1, r2, r4);
        r0 = r0 + -1;
        r0 = java.lang.Math.max(r6, r0);
        r12.oqz = r0;
        r6 = r4;
        goto L_0x047d;
    L_0x057c:
        r6 = "MicroMsg.ChattingListAdapter";
        r7 = "count([top, down]) = %d";
        r0 = 1;
        r8 = new java.lang.Object[r0];
        r9 = 0;
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.wJ();
        r1 = r12.bdo;
        r2 = r12.oqv;
        r4 = r12.oqw;
        r0 = r0.j(r1, r2, r4);
        r0 = java.lang.Integer.valueOf(r0);
        r8[r9] = r0;
        com.tencent.mm.sdk.platformtools.v.v(r6, r7, r8);
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.wJ();
        r1 = r12.bdo;
        r2 = r12.oqv;
        r4 = r12.oqw;
        r0 = r0.k(r1, r2, r4);
        r12.setCursor(r0);
        goto L_0x00a5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.cp.Ol():void");
    }

    public final void jI(boolean z) {
        this.oqN = z;
        if (!z) {
            this.oqP = false;
        }
        if (!z && this.oqO) {
            a(null, null);
            this.oqO = false;
        }
    }

    public final void bEE() {
        this.oqO = false;
        this.oqN = false;
        this.oqP = false;
        a(null, null);
    }

    public final void a(String str, i iVar) {
        if (this.oqP) {
            this.oqP = false;
        } else if (this.oqN) {
            this.oqO = true;
        } else if (this.bdo == null) {
        } else {
            if (this.aRp) {
                super.a(str, iVar);
            } else {
                v.i("MicroMsg.ChattingListAdapter", "is not resumeState ");
            }
        }
    }

    public final int getItemViewType(int i) {
        return ai((at) getItem(i));
    }

    private static short ai(at atVar) {
        int i = 0;
        int i2 = 1;
        int i3 = atVar.field_isSend == 1 ? 1 : 0;
        if (atVar.field_type == 49) {
            String KK = be.KK(atVar.field_content);
            if (KK != null) {
                com.tencent.mm.q.a.a B = com.tencent.mm.q.a.a.B(KK, atVar.field_reserved);
                if (B != null && B.type == 2000) {
                    atVar.setType(419430449);
                    ak.yW();
                    com.tencent.mm.model.c.wJ().a(atVar.field_msgId, atVar);
                    i = 1;
                }
            }
            if (i != 0) {
                return (short) be.f((Integer) oqL.get("T419430449" + (i3 != 0 ? "S" : "R")));
            }
        }
        i = be.f((Integer) oqL.get("T" + atVar.field_type + (i3 != 0 ? "S" : "R")));
        if (i > 0) {
            return (short) i;
        }
        boolean bwj = atVar.bwj();
        boolean bwb = atVar.bwb();
        if (bwj) {
            if (i3 != 0) {
                i2 = 3;
            }
            return (short) i2;
        } else if (bwb) {
            return (short) (i3 != 0 ? 7 : 6);
        } else if (atVar.bwp()) {
            return (short) (i3 != 0 ? 15 : 14);
        } else {
            return (short) (i3 != 0 ? 4 : 2);
        }
    }

    public final int getViewTypeCount() {
        return 71;
    }

    public final int xb(int i) {
        if (this.oqC) {
            return this.oqy;
        }
        if (i <= 0) {
            return 0;
        }
        if (this.eTd < i) {
            i = this.eTd;
            this.eTd = 0;
            return i;
        }
        this.eTd -= i;
        return i;
    }

    public final boolean bEF() {
        if (this.oqC) {
            return this.oqv <= ((d) com.tencent.mm.kernel.g.f(d.class)).azI().Ng(this.bdo);
        } else if (this.eTd <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean bEG() {
        if (!this.oqC) {
            return true;
        }
        return this.oqw >= ((d) com.tencent.mm.kernel.g.f(d.class)).azI().Nh(this.bdo);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r13, android.view.View r14, android.view.ViewGroup r15) {
        /*
        r12 = this;
        r4 = r12.getItem(r13);
        r4 = (com.tencent.mm.storage.at) r4;
        r0 = "MicroMsg.ChattingListAdapter";
        r1 = "shwen getview:%d, msgId %d, svrId %d, type:%d, send:%d, talker:%s";
        r2 = 6;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r5 = java.lang.Integer.valueOf(r13);
        r2[r3] = r5;
        r3 = 1;
        r6 = r4.field_msgId;
        r5 = java.lang.Long.valueOf(r6);
        r2[r3] = r5;
        r3 = 2;
        r6 = r4.field_msgSvrId;
        r5 = java.lang.Long.valueOf(r6);
        r2[r3] = r5;
        r3 = 3;
        r5 = r4.field_type;
        r5 = java.lang.Integer.valueOf(r5);
        r2[r3] = r5;
        r3 = 4;
        r5 = r4.field_isSend;
        r5 = java.lang.Integer.valueOf(r5);
        r2[r3] = r5;
        r3 = 5;
        r5 = r4.field_talker;
        r2[r3] = r5;
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
        if (r13 != 0) goto L_0x0049;
    L_0x0044:
        r0 = r12.ols;
        r0.bFk();
    L_0x0049:
        if (r13 == 0) goto L_0x008f;
    L_0x004b:
        r0 = r12.hjT;
        r0 = r0[r13];
        if (r0 == 0) goto L_0x0059;
    L_0x0051:
        r0 = r12.opZ;
        r1 = r13 + -1;
        r0 = r0[r1];
        if (r0 != 0) goto L_0x008f;
    L_0x0059:
        r0 = r13 + -1;
        r0 = r12.getItem(r0);
        r0 = (com.tencent.mm.storage.at) r0;
        r2 = r0.field_createTime;
        r6 = r4.field_createTime;
        r8 = r6 - r2;
        r10 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r1 >= 0) goto L_0x02b0;
    L_0x006e:
        r1 = 1;
    L_0x006f:
        r2 = r6 - r2;
        r6 = 180000; // 0x2bf20 float:2.52234E-40 double:8.8932E-319;
        r2 = r2 / r6;
        r6 = 1;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 >= 0) goto L_0x02b3;
    L_0x007b:
        r2 = 1;
    L_0x007c:
        if (r1 != 0) goto L_0x0080;
    L_0x007e:
        if (r2 == 0) goto L_0x02b6;
    L_0x0080:
        r1 = r12.hjT;
        r2 = 2;
        r1[r13] = r2;
    L_0x0085:
        r1 = r12.opZ;
        r2 = r13 + -1;
        r0 = ai(r0);
        r1[r2] = r0;
    L_0x008f:
        r0 = r12.hjT;
        r0 = r0[r13];
        r1 = 1;
        if (r0 == r1) goto L_0x00a6;
    L_0x0096:
        if (r13 == 0) goto L_0x00a6;
    L_0x0098:
        r0 = r12.oqb;
        r2 = r4.field_msgId;
        r1 = java.lang.Long.valueOf(r2);
        r0 = r0.contains(r1);
        if (r0 == 0) goto L_0x02bd;
    L_0x00a6:
        r0 = r4.field_createTime;
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x02bd;
    L_0x00ae:
        r0 = 1;
    L_0x00af:
        r2 = r4.field_msgId;
        r6 = r12.oqa;
        r1 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r1 != 0) goto L_0x02c0;
    L_0x00b7:
        r1 = 1;
        r2 = r1;
    L_0x00b9:
        r3 = r4.field_type;
        r1 = r4.field_isSend;
        r5 = 1;
        if (r1 != r5) goto L_0x02c4;
    L_0x00c0:
        r1 = 1;
    L_0x00c1:
        r1 = r12.X(r3, r1);
        if (r1 == 0) goto L_0x00d0;
    L_0x00c7:
        r3 = r12.opZ;
        r5 = r1.bEx();
        r5 = (short) r5;
        r3[r13] = r5;
    L_0x00d0:
        if (r1 != 0) goto L_0x00f9;
    L_0x00d2:
        if (r14 != 0) goto L_0x00f9;
    L_0x00d4:
        r3 = "MicroMsg.ChattingListAdapter";
        r5 = new java.lang.StringBuilder;
        r6 = "inflating fail, item & convertView both are null, msgtype = ";
        r5.<init>(r6);
        r6 = r4.field_type;
        r5 = r5.append(r6);
        r6 = ", isSend = ";
        r5 = r5.append(r6);
        r6 = r4.field_isSend;
        r5 = r5.append(r6);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.v.e(r3, r5);
    L_0x00f9:
        if (r14 != 0) goto L_0x0111;
    L_0x00fb:
        r3 = r12.gwU;
        if (r3 != 0) goto L_0x010b;
    L_0x00ff:
        r3 = r12.ols;
        r3 = r3.nDR;
        r3 = r3.nEl;
        r3 = com.tencent.mm.ui.q.em(r3);
        r12.gwU = r3;
    L_0x010b:
        r3 = r12.gwU;
        r14 = r1.a(r3, r14);
    L_0x0111:
        r1 = r14.getTag();
        r1 = (com.tencent.mm.ui.chatting.ad.a) r1;
        junit.framework.Assert.assertNotNull(r14);
        junit.framework.Assert.assertNotNull(r1);
        r3 = r12.oqD;
        if (r3 == 0) goto L_0x02c7;
    L_0x0121:
        r3 = 1;
    L_0x0122:
        r1.onD = r3;
        if (r0 == 0) goto L_0x02ca;
    L_0x0126:
        r0 = r1.eTg;
        r3 = 0;
        r0.setVisibility(r3);
        r0 = r1.eTg;
        r3 = r12.ols;
        r3 = r3.nDR;
        r3 = r3.nEl;
        r6 = r4.field_createTime;
        r5 = 0;
        r3 = com.tencent.mm.pluginsdk.j.o.c(r3, r6, r5);
        r0.setText(r3);
    L_0x013e:
        r0 = r1.onB;
        if (r0 == 0) goto L_0x014a;
    L_0x0142:
        if (r2 == 0) goto L_0x02d3;
    L_0x0144:
        r0 = r1.onB;
        r2 = 0;
        r0.setVisibility(r2);
    L_0x014a:
        r2 = r4.field_type;
        r0 = r4.field_isSend;
        r3 = 1;
        if (r0 != r3) goto L_0x02dc;
    L_0x0151:
        r0 = 1;
    L_0x0152:
        r0 = r12.X(r2, r0);
        if (r0 == 0) goto L_0x01a3;
    L_0x0158:
        r2 = r12.opZ;
        r3 = r0.bEx();
        r3 = (short) r3;
        r2[r13] = r3;
        r2 = 0;
        r1.onE = r2;
        r2 = com.tencent.mm.ai.b.HE();
        if (r2 == 0) goto L_0x0183;
    L_0x016b:
        r3 = r2.mJW;
        if (r3 == 0) goto L_0x0183;
    L_0x016f:
        r3 = r2.mJV;
        if (r3 != 0) goto L_0x0183;
    L_0x0173:
        r3 = com.tencent.mm.ai.b.HC();
        if (r3 == 0) goto L_0x0183;
    L_0x0179:
        r2 = r2.mJW;	 Catch:{ Exception -> 0x02df }
        r6 = 0;
        r2 = com.tencent.mm.sdk.platformtools.be.getLong(r2, r6);	 Catch:{ Exception -> 0x02df }
        r1.onE = r2;	 Catch:{ Exception -> 0x02df }
    L_0x0183:
        r3 = r12.ols;
        r6 = r12.oqS;
        r8 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r6 = r6 + r8;
        r8 = java.lang.System.currentTimeMillis();
        r12.oqS = r8;
        r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r2 >= 0) goto L_0x019d;
    L_0x0194:
        com.tencent.mm.model.ak.yW();
        r2 = com.tencent.mm.model.c.isSDCardAvailable();
        r12.lVu = r2;
    L_0x019d:
        r5 = r12.lVu;
        r2 = r13;
        r0.a(r1, r2, r3, r4, r5);
    L_0x01a3:
        r0 = r1.eTg;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x01ea;
    L_0x01ab:
        r0 = r12.ilw;
        if (r0 == 0) goto L_0x01ea;
    L_0x01af:
        r0 = r1.eTg;
        r2 = r12.ilw;
        r2 = r2.lGe;
        r0.setTextColor(r2);
        r0 = r12.ilw;
        r0 = r0.lGf;
        if (r0 == 0) goto L_0x02e6;
    L_0x01be:
        r0 = r1.eTg;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = 1067030938; // 0x3f99999a float:1.2 double:5.271833295E-315;
        r5 = 1067030938; // 0x3f99999a float:1.2 double:5.271833295E-315;
        r6 = r12.ilw;
        r6 = r6.lGg;
        r0.setShadowLayer(r2, r3, r5, r6);
    L_0x01cf:
        r0 = r12.ilw;
        r0 = r0.lGh;
        if (r0 == 0) goto L_0x02f1;
    L_0x01d5:
        r0 = r1.eTg;
        r2 = 2130837935; // 0x7f0201af float:1.7280838E38 double:1.0527738205E-314;
        r0.setBackgroundResource(r2);
        r0 = r1.eTg;
        r2 = r12.oqg;
        r3 = r12.oqf;
        r5 = r12.oqg;
        r6 = r12.oqf;
        r0.setPadding(r2, r3, r5, r6);
    L_0x01ea:
        r0 = r1.iJL;
        if (r0 == 0) goto L_0x021f;
    L_0x01ee:
        r0 = r1.iJL;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x021f;
    L_0x01f6:
        r0 = r12.ilw;
        if (r0 == 0) goto L_0x021f;
    L_0x01fa:
        r0 = r12.bdo;
        r2 = "qqmail";
        r0 = r0.equals(r2);
        if (r0 != 0) goto L_0x021f;
    L_0x0205:
        r0 = ai(r4);
        r2 = 40;
        if (r0 == r2) goto L_0x021f;
    L_0x020d:
        r0 = r1.iJL;
        r2 = r12.ilw;
        r2 = r2.lGi;
        r0.setTextColor(r2);
        r0 = r1.iJL;
        r2 = 0;
        r3 = 0;
        r5 = 0;
        r6 = 0;
        r0.setShadowLayer(r2, r3, r5, r6);
    L_0x021f:
        r0 = r12.oqD;
        if (r0 == 0) goto L_0x022c;
    L_0x0223:
        r0 = r4.isSystem();
        if (r0 == 0) goto L_0x02f9;
    L_0x0229:
        r0 = 0;
    L_0x022a:
        if (r0 != 0) goto L_0x0230;
    L_0x022c:
        r0 = r12.oqE;
        if (r0 == 0) goto L_0x02fc;
    L_0x0230:
        r0 = r1.gfb;
        if (r0 == 0) goto L_0x0245;
    L_0x0234:
        r0 = r1.gfb;
        r2 = r12.oqG;
        r6 = r4.field_msgId;
        r3 = java.lang.Long.valueOf(r6);
        r2 = r2.contains(r3);
        r0.setChecked(r2);
    L_0x0245:
        r0 = r1.fIV;
        if (r0 == 0) goto L_0x025b;
    L_0x0249:
        r0 = r1.fIV;
        r2 = r4.field_msgId;
        r2 = java.lang.Long.valueOf(r2);
        r0.setTag(r2);
        r0 = r1.fIV;
        r2 = r12.oqQ;
        r0.setOnClickListener(r2);
    L_0x025b:
        r0 = 1;
        r1.jH(r0);
    L_0x025f:
        r0 = r12.oqI;
        r0 = r0.entrySet();
        r1 = r0.iterator();
    L_0x0269:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x028d;
    L_0x026f:
        r0 = r1.next();
        r0 = (java.util.Map.Entry) r0;
        r2 = r0.getValue();
        if (r2 != r14) goto L_0x0269;
    L_0x027b:
        r1 = r12.oqI;
        r2 = r0.getKey();
        r1.remove(r2);
        r1 = r12.oqJ;
        r0 = r0.getKey();
        r1.remove(r0);
    L_0x028d:
        r0 = r12.oqI;
        r2 = r4.field_msgId;
        r1 = java.lang.Long.valueOf(r2);
        r0.put(r1, r14);
        r0 = r4.bwj();
        if (r0 == 0) goto L_0x02af;
    L_0x029e:
        r0 = r12.oqJ;
        r2 = r4.field_msgId;
        r1 = java.lang.Long.valueOf(r2);
        r2 = r4.field_isSend;
        r2 = java.lang.Integer.valueOf(r2);
        r0.put(r1, r2);
    L_0x02af:
        return r14;
    L_0x02b0:
        r1 = 0;
        goto L_0x006f;
    L_0x02b3:
        r2 = 0;
        goto L_0x007c;
    L_0x02b6:
        r1 = r12.hjT;
        r2 = 1;
        r1[r13] = r2;
        goto L_0x0085;
    L_0x02bd:
        r0 = 0;
        goto L_0x00af;
    L_0x02c0:
        r1 = 0;
        r2 = r1;
        goto L_0x00b9;
    L_0x02c4:
        r1 = 0;
        goto L_0x00c1;
    L_0x02c7:
        r3 = 0;
        goto L_0x0122;
    L_0x02ca:
        r0 = r1.eTg;
        r3 = 8;
        r0.setVisibility(r3);
        goto L_0x013e;
    L_0x02d3:
        r0 = r1.onB;
        r2 = 8;
        r0.setVisibility(r2);
        goto L_0x014a;
    L_0x02dc:
        r0 = 0;
        goto L_0x0152;
    L_0x02df:
        r2 = move-exception;
        r2 = 0;
        r1.onE = r2;
        goto L_0x0183;
    L_0x02e6:
        r0 = r1.eTg;
        r2 = 0;
        r3 = 0;
        r5 = 0;
        r6 = 0;
        r0.setShadowLayer(r2, r3, r5, r6);
        goto L_0x01cf;
    L_0x02f1:
        r0 = r1.eTg;
        r2 = 0;
        r0.setBackgroundColor(r2);
        goto L_0x01ea;
    L_0x02f9:
        r0 = 1;
        goto L_0x022a;
    L_0x02fc:
        r0 = 0;
        r1.jH(r0);
        goto L_0x025f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.cp.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public final boolean ew(long j) {
        if (this.oqG.contains(Long.valueOf(j))) {
            v.d("MicroMsg.ChattingListAdapter", "remove select item, msgId = %d", Long.valueOf(j));
            this.oqG.remove(Long.valueOf(j));
        } else {
            v.d("MicroMsg.ChattingListAdapter", "add select item, msgId = %d", Long.valueOf(j));
            if (this.oqG.size() >= 100) {
                com.tencent.mm.ui.base.g.A(this.ols.nDR.nEl, this.ols.getString(2131232486, Integer.valueOf(100)), SQLiteDatabase.KeyEmpty);
                return false;
            }
            this.oqG.add(Long.valueOf(j));
        }
        a(null, null);
        return true;
    }

    final void bEH() {
        v.d("MicroMsg.ChattingListAdapter", "disable clickListener");
        this.oqh = null;
        this.oqj = null;
        this.oql = null;
        this.oqn = null;
        this.oqp = null;
        this.oqr = null;
    }

    public final void bEI() {
        this.oqD = true;
        notifyDataSetChanged();
        bEH();
    }

    public final void amG() {
        this.oqD = false;
        notifyDataSetChanged();
        v.d("MicroMsg.ChattingListAdapter", "enable ClickListener");
        this.oqh = this.oqi;
        this.oqj = this.oqk;
        this.oql = this.oqm;
        this.oqn = this.oqo;
        this.oqp = this.oqq;
        this.oqr = this.oqs;
        this.ols.bFT();
    }

    public final ad X(int i, boolean z) {
        int f = be.f((Integer) oqL.get("T" + i + (z ? "S" : "R")));
        if (f == 0) {
            f = be.f((Integer) oqL.get("T1" + (z ? "S" : "R")));
        }
        return (ad) this.jUm.get(Integer.valueOf(f));
    }

    public final void xc(int i) {
        at atVar = (at) getItem(i);
        if (atVar != null && atVar.field_msgId != 0) {
            this.oqb.add(Long.valueOf(atVar.field_msgId));
        }
    }

    public final boolean OP(String str) {
        try {
            this.ilw = new com.tencent.mm.pluginsdk.ui.e(be.e(new FileInputStream(str)));
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.ChattingListAdapter", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            this.ilw = null;
            return false;
        }
    }

    public final boolean bh(Context context, String str) {
        if (oqR.containsKey(str)) {
            this.ilw = (com.tencent.mm.pluginsdk.ui.e) oqR.get(str);
            return true;
        }
        try {
            this.ilw = new com.tencent.mm.pluginsdk.ui.e(be.e(context.getAssets().open(str)));
            oqR.put(str, this.ilw);
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.ChattingListAdapter", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return false;
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (this.fnw != null) {
            this.fnw.post(new Runnable(this) {
                final /* synthetic */ cp oqU;

                {
                    this.oqU = r1;
                }

                public final void run() {
                    this.oqU.notifyDataSetChanged();
                }
            });
        }
    }

    public final void bnt() {
        if (this.fnw != null) {
            this.fnw.post(new Runnable(this) {
                final /* synthetic */ cp oqU;

                {
                    this.oqU = r1;
                }

                public final void run() {
                    this.oqU.notifyDataSetChanged();
                }
            });
        }
    }

    public final void a(com.tencent.mm.as.o.a.a aVar) {
        boolean z = false;
        if (aVar != null) {
            if (aVar.dhR == 3) {
                z = ea.b(aVar);
            } else if (aVar.dhR == 2 || aVar.dhR == -1 || aVar.dhR == 1) {
                z = ee.b(aVar);
            }
        }
        if (!z) {
            ad.o(new Runnable(this) {
                final /* synthetic */ cp oqU;

                {
                    this.oqU = r1;
                }

                public final void run() {
                    this.oqU.a(null, null);
                }
            });
        }
    }

    public static void M(String str, int i, int i2) {
        g.f(str, i, i2);
    }
}
