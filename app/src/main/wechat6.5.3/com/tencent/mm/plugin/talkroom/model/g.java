package com.tencent.mm.plugin.talkroom.model;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.l;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.talkroom.b.f;
import com.tencent.mm.plugin.talkroom.component.TalkRoomService;
import com.tencent.mm.plugin.talkroom.component.a.a;
import com.tencent.mm.plugin.talkroom.component.b;
import com.tencent.mm.plugin.talkroom.component.d;
import com.tencent.mm.plugin.talkroom.model.i.AnonymousClass10;
import com.tencent.mm.plugin.talkroom.model.i.AnonymousClass11;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.j.x;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.azh;
import com.tencent.mm.protocal.c.azi;
import com.tencent.mm.protocal.c.azj;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ab;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g implements v, j.v, x, e {
    public static final int[] klf = new int[]{80, 8080, 16285};
    public static final byte[][] klg = new byte[][]{new byte[]{(byte) 101, (byte) -30, (byte) 76, (byte) 27}, new byte[]{(byte) 112, (byte) 64, (byte) -19, (byte) -29}, new byte[]{(byte) 120, (byte) -52, (byte) -55, (byte) -58}};
    private int gFG;
    private long gFH;
    private final ServiceConnection gfD = new ServiceConnection(this) {
        final /* synthetic */ g kli;

        {
            this.kli = r1;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TalkRoomServer", "onServiceConnected ");
            if (iBinder == null) {
                this.kli.kle.A("enterTalkRoom bindServie or protocalInit failed", 3, -1);
                return;
            }
            this.kli.kkY = a.O(iBinder);
            if (this.kli.state >= 2) {
                new ac(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 klj;

                    {
                        this.klj = r1;
                    }

                    public final void run() {
                        this.klj.kli.gG(true);
                    }
                });
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TalkRoomServer", "onServiceDisconnected ");
        }
    };
    private int kkQ = 0;
    private int kkR = 0;
    private boolean kkS = false;
    public String kkT;
    private int kkU;
    private int kkV;
    private int kkW;
    private LinkedList<azh> kkX = new LinkedList();
    private com.tencent.mm.plugin.talkroom.component.a kkY;
    private b kkZ;
    private com.tencent.mm.plugin.talkroom.component.e kla;
    private d klb;
    private y klc;
    private ah kld;
    private i kle = new i();
    public boolean klh = false;
    private int state = 0;

    public g() {
        TalkRoomReceiver.init();
    }

    public final int baf() {
        if (this.kkQ != 1) {
            return (j.a.lxQ == null || !j.a.lxQ.vJ(this.kkT)) ? 0 : 1;
        } else {
            return 1;
        }
    }

    public final List<azi> awq() {
        return b.aZX().CC(this.kkT);
    }

    public final String bag() {
        Iterator it = b.aZX().CC(this.kkT).iterator();
        while (it.hasNext()) {
            azi com_tencent_mm_protocal_c_azi = (azi) it.next();
            if (com_tencent_mm_protocal_c_azi.mWg == this.kkW) {
                return com_tencent_mm_protocal_c_azi.gln;
            }
        }
        return null;
    }

    public final void a(j.y yVar) {
        i iVar = this.kle;
        synchronized (yVar) {
            if (iVar.bXt.contains(yVar)) {
            } else {
                iVar.bXt.add(yVar);
            }
        }
        this.kle.vT(bag());
    }

    public final void b(j.y yVar) {
        i iVar = this.kle;
        synchronized (yVar) {
            iVar.bXt.remove(yVar);
        }
    }

    private boolean bah() {
        if (baf() == 1) {
            b(b.aZV().kjX);
        } else {
            a(b.aZV().kjX);
        }
        if (this.kkR > 0) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TalkRoomServer", "addListener has init before");
        } else {
            ak.vy().a(332, this);
            ak.vy().a(334, this);
            ak.vy().a(336, this);
            ak.vy().a(335, this);
            b.aZX().a(this);
            ak.oJ().a(this);
            this.kkR = 1;
            if (this.kkY != null) {
                try {
                    this.kkY.Close();
                    this.kkY.uninitLive();
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.v.a("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                }
            }
            aa.getContext().bindService(new Intent(aa.getContext(), TalkRoomService.class), this.gfD, 1);
            this.kkZ = new b.a(this) {
                final /* synthetic */ g kli;

                {
                    this.kli = r1;
                }

                public final void keep_OnOpenSuccess() {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TalkRoomServer", "OnOpenSuccess");
                    if (this.kli.state != 1) {
                        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.TalkRoomServer", "has exit the talkroom state:%d", new Object[]{Integer.valueOf(this.kli.state)});
                        return;
                    }
                    b.aZZ().bae();
                    new ac(Looper.getMainLooper()).post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 klk;

                        {
                            this.klk = r1;
                        }

                        public final void run() {
                            this.klk.kli.gF(true);
                        }
                    });
                    this.kli.bal();
                    this.kli.kle.awP();
                }

                public final void keep_OnError(int i) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.TalkRoomServer", "engineCallback OnError: %d", new Object[]{Integer.valueOf(i)});
                    b.aZZ().bae();
                    b.aZZ().kkn = 1;
                    this.kli.kle.A("component OnError " + i, 99, i);
                    new ac(Looper.getMainLooper()).post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 klk;

                        {
                            this.klk = r1;
                        }

                        public final void run() {
                            this.klk.kli.awO();
                        }
                    });
                }
            };
        }
        return true;
    }

    public final void bd(String str, int i) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TalkRoomServer", "enterTalkRoom %s scene %d", new Object[]{str, Integer.valueOf(i)});
        this.kkQ = i;
        bah();
        if (str.equals(this.kkT)) {
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.TalkRoomServer", "enterTalkRoom %s has enter the talkroom", new Object[]{str});
            if (this.state == 2) {
                this.kle.awP();
                return;
            }
            return;
        }
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.TalkRoomServer", "%s enter the talkroom", new Object[]{str});
        this.kkT = str;
        ak.vy().a(new com.tencent.mm.plugin.talkroom.b.a(this.kkT, baf()), 0);
        b.aZV().kjZ = new f();
        b.aZZ().kkK = be.Nj();
        b.aZZ().kkH = str;
        if (baf() == 0) {
            b.aZV().kjX.gVJ = true;
        }
        i iVar = this.kle;
        Runnable anonymousClass11 = new AnonymousClass11(iVar, str);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass11.run();
        } else {
            iVar.handler.post(anonymousClass11);
        }
    }

    public final void awO() {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TalkRoomServer", "exitTalkRoom");
        gF(false);
        if (be.kS(this.kkT)) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TalkRoomServer", "exitTalkRoom: has exited");
            return;
        }
        int Close;
        f aZZ = b.aZZ();
        if (aZZ.kkK != 0) {
            aZZ.kko = (int) (be.az(aZZ.kkK) / 1000);
        }
        this.state = 0;
        this.kkS = false;
        ak.vy().a(new com.tencent.mm.plugin.talkroom.b.b(this.gFG, this.gFH, this.gFG != 0 ? this.kkT : "", baf()), 0);
        if (this.kkY != null) {
            try {
                Close = this.kkY.Close();
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.v.a("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                Close = -99999;
            }
            if (Close < 0) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.TalkRoomServer", "engine.Close error %d", new Object[]{Integer.valueOf(Close)});
            }
            PByteArray pByteArray = new PByteArray();
            if (a(pByteArray, l.er(this.kkT)) == 0) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TalkRoomServer", "getStatis==> pba.len %d, info: %s", new Object[]{Integer.valueOf(pByteArray.value.length), new String(pByteArray.value)});
                LinkedList linkedList = new LinkedList();
                azj com_tencent_mm_protocal_c_azj = new azj();
                com_tencent_mm_protocal_c_azj.mFd = 10402;
                com_tencent_mm_protocal_c_azj.mWh = new arf().JF(r1);
                azj com_tencent_mm_protocal_c_azj2 = new azj();
                com_tencent_mm_protocal_c_azj2.mFd = 10404;
                com_tencent_mm_protocal_c_azj2.mWh = new arf().JF(b.aZZ().toString());
                linkedList.add(com_tencent_mm_protocal_c_azj);
                linkedList.add(com_tencent_mm_protocal_c_azj2);
                ak.vy().a(new com.tencent.mm.plugin.talkroom.b.g(linkedList, baf()), 0);
            }
        }
        this.kkT = "";
        this.gFG = 0;
        this.gFH = 0;
        this.kkU = 0;
        this.kkV = 0;
        this.kkW = 0;
        this.kkX.clear();
        bai();
        i iVar = this.kle;
        Runnable anonymousClass12 = new Runnable(iVar) {
            final /* synthetic */ i kll;

            {
                this.kll = r1;
            }

            public final void run() {
                synchronized (this.kll.bXt) {
                    for (j.y awR : this.kll.bXt) {
                        awR.awR();
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass12.run();
        } else {
            iVar.handler.post(anonymousClass12);
        }
        c cVar = b.aZV().kjX;
        cVar.mHandler.post(new Runnable(cVar) {
            final /* synthetic */ c kkf;

            {
                this.kkf = r1;
            }

            public final void run() {
                b.aZV();
                com.tencent.mm.sdk.platformtools.v.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
                b.aZV();
                c.bac();
            }
        });
        this.kkR = 0;
        ak.vy().b(332, this);
        ak.vy().b(334, this);
        ak.vy().b(336, this);
        ak.vy().b(335, this);
        b.aZX().b(this);
        ak.oJ().b(this);
        b(b.aZV().kjX);
        if (this.kkY != null) {
            try {
                Close = this.kkY.uninitLive();
            } catch (Throwable e2) {
                com.tencent.mm.sdk.platformtools.v.a("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            }
            aa.getContext().unbindService(this.gfD);
            aa.getContext().stopService(new Intent(aa.getContext(), TalkRoomService.class));
            this.kkY = null;
            if (Close < 0) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.TalkRoomServer", "engine.uninitLive error %d", new Object[]{Integer.valueOf(Close)});
            }
        }
        Close = -99999;
        aa.getContext().unbindService(this.gfD);
        aa.getContext().stopService(new Intent(aa.getContext(), TalkRoomService.class));
        this.kkY = null;
        if (Close < 0) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.TalkRoomServer", "engine.uninitLive error %d", new Object[]{Integer.valueOf(Close)});
        }
    }

    private void bai() {
        if (this.kla != null) {
            try {
                this.kla.release();
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.v.a("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
            this.kla = null;
        }
        if (this.klb != null) {
            try {
                this.klb.release();
            } catch (Throwable e2) {
                com.tencent.mm.sdk.platformtools.v.a("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            }
            this.klb = null;
        }
        if (this.klc != null) {
            this.klc.QI();
            this.klc = null;
        }
        if (this.kld != null) {
            this.kld.QI();
            this.kld = null;
        }
    }

    private void gF(boolean z) {
        if (!be.kS(this.kkT)) {
            ak.yW();
            ab Mh = c.wK().Mh(this.kkT);
            if (Mh != null) {
                Mh.t(com.tencent.mm.storage.ac.a(Mh, z ? 5 : 6, Mh.field_conversationTime));
                ak.yW();
                c.wK().a(Mh, this.kkT, true);
            }
        }
    }

    public final boolean baj() {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TalkRoomServer", "seizeMic");
        if (this.state != 2) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TalkRoomServer", "seizeMic  not int the appropriate state");
            if (this.state == 0) {
                this.kle.g(3, -1, "seizeMic in outside room state");
            }
            return false;
        }
        if (this.kla != null) {
            try {
                this.kla.aPy();
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.v.a("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
        }
        this.state = 3;
        ak.vy().a(new com.tencent.mm.plugin.talkroom.b.d(this.gFG, this.gFH, 1, this.kkT, baf()), 0);
        b.aZZ().kkM = be.Nj();
        b.aZZ().kkP = true;
        return true;
    }

    public final void bak() {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TalkRoomServer", "putAwayMic");
        f aZZ = b.aZZ();
        if (aZZ.kkP && !aZZ.kkO) {
            aZZ.kkJ++;
        }
        aZZ.kkO = false;
        aZZ.kkP = false;
        if (this.state < 3) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.TalkRoomServer", "putAwayMic  err, isnot getting or has not got mic");
            return;
        }
        if (this.kld != null) {
            this.kld.QI();
            this.kld = null;
        }
        bal();
        ak.vy().a(new com.tencent.mm.plugin.talkroom.b.d(this.gFG, this.gFH, 2, this.kkT, baf()), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TalkRoomServer", "type:%d  errType:%d  errCode:%d", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        f fVar = (f) kVar;
        if (fVar.bas() == null || !fVar.bas().equals(this.kkT)) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.TalkRoomServer", "%s, now :%s this is the old sceneEnd, abandon it!!", new Object[]{fVar.bas(), this.kkT});
            return;
        }
        if (!(i == 0 && i2 == 0)) {
            if (kVar.getType() == 332) {
                b.aZZ().rr(2);
                if (i == 4) {
                    b.aZZ().kkI = i2;
                }
                this.kle.A("cgi enter failed : errType:" + i + " errCode:" + i2, i, i2);
                awO();
                return;
            } else if (kVar.getType() == 334) {
                if (((com.tencent.mm.plugin.talkroom.b.d) kVar).actionType == 1) {
                    f aZZ = b.aZZ();
                    aZZ.kkr++;
                    aZZ.kkM = 0;
                    bal();
                    com.tencent.mm.sdk.platformtools.v.w("MicroMsg.TalkRoomServer", "onSceneEnd SeizeMicFailed");
                    if (i == 4 && (i2 == 311 || i2 == 340)) {
                        this.kle.mq(i2);
                        return;
                    } else {
                        this.kle.g(i, i2, "TalkMicAction failed!!");
                        return;
                    }
                }
                return;
            } else if (kVar.getType() == 336) {
                this.kkS = false;
                this.kle.g(i, i2, "TalkGetMember failed!!");
                awO();
                return;
            } else if (kVar.getType() == 335) {
                this.kle.g(i, i2, "TalkNoop failed!!");
                awO();
                return;
            }
        }
        if (kVar.getType() == 332) {
            b.aZZ().rr(1);
            com.tencent.mm.plugin.talkroom.b.a aVar = (com.tencent.mm.plugin.talkroom.b.a) kVar;
            this.gFG = aVar.gFG;
            this.gFH = aVar.gFH;
            this.kkU = aVar.kkU;
            this.kkV = aVar.kkV;
            this.kkX = aVar.kkX;
            aZZ = b.aZZ();
            int i3 = this.gFG;
            long j = this.gFH;
            aZZ.gFG = i3;
            aZZ.gFH = j;
            b.aZX().a(this.kkT, aVar.klq, null, null, fVar.bat());
            rs(100);
        } else if (kVar.getType() == 334) {
            com.tencent.mm.plugin.talkroom.b.d dVar = (com.tencent.mm.plugin.talkroom.b.d) kVar;
            if (dVar.actionType == 1) {
                aZZ = b.aZZ();
                if (aZZ.kkM != 0) {
                    aZZ.kkp = (be.az(aZZ.kkM) + (aZZ.kkp * ((long) aZZ.kkL))) / ((long) (aZZ.kkL + 1));
                    aZZ.kkL++;
                    aZZ.kkq++;
                    aZZ.kkM = 0;
                }
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic seize Mic successFul");
                if (dVar.kkU < this.kkU) {
                    com.tencent.mm.sdk.platformtools.v.w("MicroMsg.TalkRoomServer", "micSeq is smaller seizeSeq %d, now %d", new Object[]{Integer.valueOf(dVar.kkU), Integer.valueOf(this.kkU)});
                    bal();
                    this.kle.mq(311);
                    return;
                }
                this.kkU = dVar.kkU;
                int i4 = -99999;
                try {
                    i4 = this.kkY.SetCurrentMicId(this.kkU);
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.v.a("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                }
                if (this.state != 3) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic not in getting mic state");
                    return;
                }
                i iVar = this.kle;
                Runnable anonymousClass6 = new Runnable(iVar) {
                    final /* synthetic */ i kll;

                    {
                        this.kll = r1;
                    }

                    public final void run() {
                        synchronized (this.kll.bXt) {
                            for (j.y awQ : this.kll.bXt) {
                                awQ.awQ();
                            }
                        }
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    anonymousClass6.run();
                } else {
                    iVar.handler.post(anonymousClass6);
                }
                this.state = 4;
                if (i4 < 0) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.TalkRoomServer", "SetCurrentMicId err: %d ", new Object[]{Integer.valueOf(i4)});
                }
                if (this.kld == null) {
                    this.kld = new ah(new ah.a(this) {
                        final /* synthetic */ g kli;

                        {
                            this.kli = r1;
                        }

                        public final boolean oU() {
                            int e = this.kli.gFG;
                            long f = this.kli.gFH;
                            String g = this.kli.kkT;
                            g gVar = this.kli;
                            this.kli.kkT;
                            ak.vy().a(new com.tencent.mm.plugin.talkroom.b.d(e, f, 1, g, gVar.baf()), 0);
                            return true;
                        }
                    }, true);
                    this.kld.ea(5000);
                    return;
                }
                return;
            }
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TalkRoomServer", "putaway Mic successFul");
        } else {
            if (kVar.getType() == 336) {
                com.tencent.mm.plugin.talkroom.b.c cVar = (com.tencent.mm.plugin.talkroom.b.c) kVar;
                b.aZX().a(this.kkT, cVar.klq, null, null, fVar.bat());
                rt(cVar.kkU);
                this.kkS = false;
                this.kle.vT(bag());
            }
            if (kVar.getType() == 335 && this.state == 0) {
                this.kle.g(3, -1, "talknoop success but in outside room state");
            }
        }
    }

    private void bal() {
        try {
            f aZZ = b.aZZ();
            if (aZZ.kkN != 0) {
                long az = be.az(aZZ.kkN) / 1000;
                if (az < 2) {
                    aZZ.kky++;
                } else if (az < 6) {
                    aZZ.kkz++;
                } else if (az < 11) {
                    aZZ.kkA++;
                } else if (az < 21) {
                    aZZ.kkB++;
                } else if (az < 31) {
                    aZZ.kkC++;
                } else if (az < 41) {
                    aZZ.kkD++;
                } else if (az < 51) {
                    aZZ.kkE++;
                } else if (az < 61) {
                    aZZ.kkF++;
                } else {
                    aZZ.kkG++;
                }
                aZZ.kkN = 0;
            }
            if (this.klb != null) {
                this.klb.aZR();
            }
            if (this.kla != null) {
                this.kla.aZU();
            }
            this.state = 2;
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.a("MicroMsg.TalkRoomServer", e, "", new Object[0]);
        }
    }

    public final void aZS() {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TalkRoomServer", "resumeRecord in state %d", new Object[]{Integer.valueOf(this.state)});
        if (this.state == 4) {
            f aZZ = b.aZZ();
            aZZ.kkO = true;
            aZZ.kkN = be.Nj();
            try {
                this.klb.aZS();
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.v.a("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
        }
    }

    private void rs(final int i) {
        if (this.kkY != null) {
            try {
                this.state = 1;
                this.kkS = false;
                if (bam()) {
                    bai();
                    bao();
                    ban();
                    if (this.klc != null) {
                        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.TalkRoomServer", "enter talkroom not first time");
                        return;
                    }
                    this.klc = new y(new y.a(this) {
                        final /* synthetic */ g kli;

                        {
                            this.kli = r1;
                        }

                        public final boolean oU() {
                            if (this.kli.gFG == 0 || be.kS(this.kli.kkT)) {
                                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.TalkRoomServer", "talkNoopTimer error: roomId %d, talkUsername %s", new Object[]{Integer.valueOf(this.kli.gFG), this.kli.kkT});
                                this.kli.klc = null;
                                return false;
                            }
                            String g = this.kli.kkT;
                            int e = this.kli.gFG;
                            long f = this.kli.gFH;
                            g gVar = this.kli;
                            this.kli.kkT;
                            ak.vy().a(new com.tencent.mm.plugin.talkroom.b.e(g, e, f, gVar.baf()), 0);
                            return true;
                        }
                    });
                    y yVar = this.klc;
                    y.nix = true;
                    yVar.kCe = 50000;
                    yVar.nit = be.Nj();
                    boolean dZ = y.dZ(yVar.kCe);
                    yVar.QI();
                    y.niu.put(Integer.valueOf(yVar.nir), yVar);
                    if (y.bXz != null && dZ) {
                        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.MAlarmHandler", "prepare bumper");
                        y.bXz.prepare();
                    }
                }
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.v.a("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
        } else if (i == 0) {
            this.kle.A("bind talkroomService timeout", 3, -1);
        } else {
            new ac().postDelayed(new Runnable(this) {
                final /* synthetic */ g kli;

                public final void run() {
                    this.kli.rs(i - 1);
                }
            }, 50);
        }
    }

    private boolean bam() {
        int i = -99999;
        try {
            i = this.kkY.aZP();
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.a("MicroMsg.TalkRoomServer", e, "", new Object[0]);
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TalkRoomServer", "engine.protocalInit");
        if (i >= 0 || i == -3) {
            return true;
        }
        this.kkY = null;
        com.tencent.mm.sdk.platformtools.v.f("MicroMsg.TalkRoomServer", "engine.protocalInit error %d", new Object[]{Integer.valueOf(i)});
        this.kle.A("enterTalkRoom protocalInit failed", 3, -1);
        return false;
    }

    private void rt(int i) {
        if (i > this.kkU) {
            this.kkU = i;
            if (this.state >= 3) {
                this.kle.mq(311);
            }
            bal();
        }
    }

    public final void gG(boolean z) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TalkRoomServer", "reConnect talkRoomUsername: %s", new Object[]{this.kkT});
        if (!be.kS(this.kkT) && this.state >= 2) {
            f aZZ = b.aZZ();
            aZZ.kku++;
            if (z) {
                if (bam()) {
                    try {
                        ban();
                    } catch (Throwable e) {
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.TalkRoomServer", e.toString());
                        com.tencent.mm.sdk.platformtools.v.a("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                    }
                } else {
                    return;
                }
            }
            bal();
            this.state = 1;
            try {
                if (this.kkY != null) {
                    this.kkY.Close();
                }
            } catch (Throwable e2) {
                com.tencent.mm.sdk.platformtools.v.a("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            }
            if (this.gFG != 0) {
                bao();
            }
            if (!z) {
                i iVar = this.kle;
                Runnable anonymousClass4 = new Runnable(iVar) {
                    final /* synthetic */ i kll;

                    {
                        this.kll = r1;
                    }

                    public final void run() {
                        synchronized (this.kll.bXt) {
                            for (j.y awU : this.kll.bXt) {
                                awU.awU();
                            }
                        }
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    anonymousClass4.run();
                } else {
                    iVar.handler.post(anonymousClass4);
                }
            }
        }
    }

    private void ban() {
        if (this.kkY == null) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.TalkRoomServer", "the engine should not be null.");
            return;
        }
        this.kla = this.kkY.a(new com.tencent.mm.plugin.talkroom.component.c.a(this) {
            final /* synthetic */ g kli;

            {
                this.kli = r1;
            }

            public final void h(int i, int i2, boolean z) {
                if (z) {
                    this.kli.kkW = 0;
                    this.kli.kle.vT("");
                    return;
                }
                this.kli.rt(i2);
                if (this.kli.kkW != i) {
                    this.kli.kkW = i;
                    String bag = this.kli.bag();
                    if (!this.kli.kkS && bag == null) {
                        this.kli.kkS = true;
                        int e = this.kli.gFG;
                        long f = this.kli.gFH;
                        String g = this.kli.kkT;
                        g gVar = this.kli;
                        this.kli.kkT;
                        ak.vy().a(new com.tencent.mm.plugin.talkroom.b.c(e, f, g, gVar.baf()), 0);
                        f aZZ = b.aZZ();
                        aZZ.kkv++;
                        aZZ = b.aZZ();
                        aZZ.kkw++;
                    }
                    this.kli.kle.vT(bag);
                    ao.T(aa.getContext(), 2131235640);
                }
            }
        });
        this.kla.start();
        this.klb = this.kkY.aZQ();
        this.klb.start();
    }

    private static String ru(int i) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) ((i >>> 24) & 255), (byte) ((i >>> 16) & 255), (byte) ((i >>> 8) & 255), (byte) (i & 255)}).getHostAddress();
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.a("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            return null;
        }
    }

    private void bao() {
        if (this.kkX.size() == 0) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.TalkRoomServer", "engine. talk relay addr list is empty");
            this.kle.g(3, -1, "engine.talk relay addr list empty");
            return;
        }
        int a;
        int[] iArr = new int[this.kkX.size()];
        int[] iArr2 = new int[this.kkX.size()];
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TalkRoomServer", "talk relay addr cnt %d", new Object[]{Integer.valueOf(this.kkX.size())});
        for (int i = 0; i < this.kkX.size(); i++) {
            iArr[i] = ((azh) this.kkX.get(i)).mWf;
            iArr2[i] = ((azh) this.kkX.get(i)).mNM;
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TalkRoomServer", "add talk relay addr %s %d", new Object[]{ru(((azh) this.kkX.get(i)).mWf), Integer.valueOf(((azh) this.kkX.get(i)).mNM)});
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.TalkRoomServer", "engine.Open myRoomMemId %d, roomId %d, roomKey %d", new Object[]{Integer.valueOf(this.kkV), Integer.valueOf(this.gFG), Long.valueOf(this.gFH)});
        try {
            com.tencent.mm.plugin.talkroom.component.a aVar = this.kkY;
            b bVar = this.kkZ;
            ak.yW();
            a = aVar.a(bVar, c.ww(), this.kkV, this.gFG, this.gFH, iArr, iArr2, 0);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.a("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            a = -99999;
        }
        if (a < 0 && a != -3) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.TalkRoomServer", "engine.Open error %d", new Object[]{Integer.valueOf(a)});
            this.kle.g(3, a, "engine.Open error");
        }
    }

    public final short bap() {
        short s = (short) 0;
        if (this.klb == null) {
            return s;
        }
        try {
            return (short) this.klb.aZT();
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.a("MicroMsg.TalkRoomServer", e, "", new Object[s]);
            return s;
        }
    }

    public final short baq() {
        short s = (short) 0;
        if (this.kla == null) {
            return s;
        }
        try {
            return (short) this.kla.aZT();
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.a("MicroMsg.TalkRoomServer", e, "", new Object[s]);
            return s;
        }
    }

    private int a(PByteArray pByteArray, String str) {
        if (this.kkY == null) {
            return -99;
        }
        int[] iArr = new int[1];
        try {
            pByteArray.value = this.kkY.c(iArr, str);
        } catch (Throwable e) {
            iArr[0] = -99999;
            com.tencent.mm.sdk.platformtools.v.a("MicroMsg.TalkRoomServer", e, "", new Object[0]);
        }
        return iArr[0];
    }

    public final void y(String str, String str2, String str3) {
        if (str.equals(this.kkT)) {
            i iVar = this.kle;
            Runnable anonymousClass10 = new AnonymousClass10(iVar, str2, str3);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                anonymousClass10.run();
            } else {
                iVar.handler.post(anonymousClass10);
            }
        }
    }

    public final boolean bar() {
        return this.klh;
    }

    public final void yB() {
        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.TalkRoomServer", "yy talkroom onResume");
        if (be.kS(this.kkT)) {
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.TalkRoomServer", "pause");
        } else {
            bal();
        }
        this.klh = false;
        i iVar = this.kle;
        Runnable anonymousClass3 = new Runnable(iVar) {
            final /* synthetic */ i kll;

            {
                this.kll = r1;
            }

            public final void run() {
                synchronized (this.kll.bXt) {
                    for (j.y awT : this.kll.bXt) {
                        awT.awT();
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass3.run();
        } else {
            iVar.handler.post(anonymousClass3);
        }
    }

    public final void yC() {
        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.TalkRoomServer", "yy talkroom onPause");
        try {
            if (be.kS(this.kkT)) {
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.TalkRoomServer", "pause");
            } else {
                if (this.klb != null) {
                    this.klb.aZR();
                }
                if (this.kla != null) {
                    this.kla.aPy();
                }
                this.state = 2;
            }
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.a("MicroMsg.TalkRoomServer", e, "", new Object[0]);
        }
        this.klh = true;
        i iVar = this.kle;
        Runnable anonymousClass2 = new Runnable(iVar) {
            final /* synthetic */ i kll;

            {
                this.kll = r1;
            }

            public final void run() {
                synchronized (this.kll.bXt) {
                    for (j.y awS : this.kll.bXt) {
                        awS.awS();
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass2.run();
        } else {
            iVar.handler.post(anonymousClass2);
        }
    }
}
