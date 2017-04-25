package com.tencent.mm.plugin.voip.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.qh;
import com.tencent.mm.e.a.qy;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.ui.b;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.plugin.voip.video.h;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.Map;

public final class j implements com.tencent.mm.compatible.b.d.a, com.tencent.mm.plugin.voip.model.k.a, p, b, f, com.tencent.mm.plugin.voip.video.j.a {
    public com.tencent.mm.compatible.util.b aUX;
    private boolean aUy = false;
    public String bZy;
    private long gGB = 0;
    private boolean hmU = false;
    public ac ihw;
    public c ktH;
    public HeadsetPlugReceiver ktI;
    public TelephonyManager ktJ;
    private com.tencent.mm.plugin.voip.ui.a ktK;
    private com.tencent.mm.plugin.voip.video.a ktL;
    private CaptureView ktM;
    private a ktN = null;
    private boolean ktO = false;
    private Object ktP = new Object();
    public u ktQ;
    public boolean ktR;
    public boolean ktS;
    public boolean ktT = false;
    private int ktU = 4096;
    private boolean ktV = false;
    public int ktW = 1;
    private long ktX = -1;
    private boolean ktY = false;
    public boolean ktZ = false;
    private boolean kua = false;
    private boolean kub = false;
    private int kuc = 0;
    public com.tencent.mm.plugin.voip.video.j kud = new com.tencent.mm.plugin.voip.video.j();
    private ah kue = null;
    private ad kuf;
    private boolean kug = false;
    private boolean kuh = false;
    private int kui = 0;
    private boolean kuj = false;
    public boolean kuk = false;
    public com.tencent.mm.plugin.voip.widget.b kul;
    private boolean kum = false;
    public BroadcastReceiver kun = new BroadcastReceiver(this) {
        final /* synthetic */ j kus;

        {
            this.kus = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            PowerManager powerManager = (PowerManager) aa.getContext().getSystemService("power");
            if ("android.intent.action.USER_PRESENT".equals(action) && powerManager.isScreenOn()) {
                this.kus.kub = false;
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                this.kus.kub = false;
            } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                this.kus.kub = true;
                if (!com.tencent.mm.plugin.voip.b.b.rY(this.kus.ktH.mState) && !this.kus.ktR) {
                    d.bbw().aCp();
                }
            }
        }
    };
    public com.tencent.mm.sdk.c.c kuo = new com.tencent.mm.sdk.c.c<qh>(this) {
        final /* synthetic */ j kus;

        {
            this.kus = r2;
            this.nhz = qh.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            qh qhVar = (qh) bVar;
            if (qhVar instanceof qh) {
                qhVar.bry.brz = com.tencent.mm.plugin.voip.b.b.rZ(this.kus.ktH.mState);
                qhVar.bry.brA = this.kus.ktL != null;
                qhVar.bry.brB = true;
                qhVar.bry.bdo = this.kus.bZy;
            }
            return false;
        }
    };
    public com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a kup = new com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a(this) {
        final /* synthetic */ j kus;

        {
            this.kus = r1;
        }

        public final void dG(boolean z) {
            v.d("MicroMsg.Voip.VoipMgr", "onHeadsetState, on:%b", new Object[]{Boolean.valueOf(z)});
            if (!(true == z && 3 == this.kus.ktW) && (z || 3 == this.kus.ktW)) {
                if (com.tencent.mm.plugin.voip.b.b.rZ(this.kus.ktH.mState)) {
                    if (z) {
                        this.kus.gN(false);
                        this.kus.ktW = 3;
                    } else {
                        Toast.makeText(this.kus.getContext(), this.kus.getContext().getString(2131235957), 0).show();
                        this.kus.gN(true);
                        this.kus.ktW = 1;
                    }
                } else if (z) {
                    if (1 == this.kus.ktW) {
                        this.kus.gN(false);
                        this.kus.ktY = true;
                    } else {
                        this.kus.ktY = false;
                    }
                    this.kus.ktW = 3;
                } else {
                    if (this.kus.ktY || 2 == this.kus.mUIType) {
                        Toast.makeText(this.kus.getContext(), this.kus.getContext().getString(2131235957), 0).show();
                        this.kus.gN(true);
                        this.kus.ktW = 1;
                    } else {
                        Toast.makeText(this.kus.getContext(), this.kus.getContext().getString(2131235956), 0).show();
                        this.kus.ktW = 2;
                    }
                    this.kus.ktY = false;
                }
                this.kus.rG(this.kus.ktW);
                return;
            }
            v.d("MicroMsg.Voip.VoipMgr", "same status, no changed");
        }
    };
    public PhoneStateListener kuq = new PhoneStateListener(this) {
        final /* synthetic */ j kus;

        {
            this.kus = r1;
        }

        public final void onCallStateChanged(int i, String str) {
            int i2 = 1;
            super.onCallStateChanged(i, str);
            v.d("MicroMsg.Voip.VoipMgr", "onCallStateChanged :%d, isStartVoip: %b", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.kus.kuk)});
            if (!this.kus.kuk) {
                return;
            }
            if (i == 1) {
                this.kus.kum = true;
                d.bbw().rP(1);
            } else if (i == 2) {
                String string;
                v.i("MicroMsg.Voip.VoipMgr", "phone call coming now!");
                if (this.kus.ktR && !com.tencent.mm.plugin.voip.b.b.rY(this.kus.ktH.mState)) {
                    n nVar = d.bbw().kuO;
                    v.i("MicroMsg.Voip.VoipServiceEx", "cancelCallByPhoneInter, roomId:" + nVar.kqI.ksc.gFG);
                    if (nVar.kqI.ksc.gFG != 0) {
                        nVar.kqI.ksc.kxf.ksP = 102;
                        nVar.kqI.ksc.kxf.ktb = 6;
                        g.iuh.a(11521, true, true, new Object[]{Integer.valueOf(d.bbw().kuO.kqI.ksc.gFG), Long.valueOf(d.bbw().bcC()), Long.valueOf(d.bbw().bcD()), Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis())});
                        nVar.bcN();
                    }
                }
                if (com.tencent.mm.plugin.voip.b.b.rY(this.kus.ktH.mState)) {
                    string = aa.getContext().getString(2131235864, new Object[]{j.ao(be.ax(this.kus.ktX))});
                } else {
                    string = aa.getContext().getString(2131235861);
                }
                n nVar2 = d.bbw().kuO;
                v.i("MicroMsg.Voip.VoipServiceEx", "hangUpByPhoneInter");
                if (nVar2.kqI.ksc.gFG == 0) {
                    nVar2.kqI.kse.bbP();
                    nVar2.reset();
                } else {
                    nVar2.kqI.ksc.kxf.ksP = 109;
                    nVar2.kqI.ksc.kxf.kth = 4;
                    nVar2.bcP();
                }
                String str2 = this.kus.ktQ.field_username;
                String str3 = this.kus.ktS ? at.nvC : at.nvB;
                if (!this.kus.ktR) {
                    i2 = 0;
                }
                l.a(str2, str3, i2, 6, string);
                this.kus.rI(4107);
                this.kus.bcg();
                at atVar = new at();
                atVar.setType(10000);
                atVar.z(System.currentTimeMillis());
                atVar.dh(6);
                atVar.setContent(aa.getContext().getString(2131235863) + ", <a href=\"weixin://voip/callagain/?username=" + this.kus.bZy + "&isvideocall=" + this.kus.ktS + "\">" + aa.getContext().getString(2131235858) + "</a>");
                if (!(this.kus.bZy == null || this.kus.bZy.equals(""))) {
                    atVar.cH(this.kus.bZy);
                    ak.yW();
                    com.tencent.mm.model.c.wJ().R(atVar);
                }
                d.bbw().rP(2);
            } else if (i == 0) {
                d.bbw().rP(2);
                if (1 == this.kus.ktW && com.tencent.mm.plugin.voip.b.b.rY(this.kus.ktH.mState) && this.kus.kum) {
                    this.kus.gN(true);
                }
            }
        }
    };
    public com.tencent.mm.sdk.c.c kur = new com.tencent.mm.sdk.c.c<qy>(this) {
        final /* synthetic */ j kus;

        {
            this.kus = r2;
            this.nhz = qy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            final qy qyVar = (qy) bVar;
            if (qyVar instanceof qy) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass10 kuz;

                    public final void run() {
                        switch (qyVar.bsD.aYt) {
                            case 1:
                                if (com.tencent.mm.plugin.voip.b.b.rZ(this.kuz.kus.ktH.mState)) {
                                    this.kuz.kus.bbX();
                                    return;
                                } else {
                                    this.kuz.kus.bbZ();
                                    return;
                                }
                            case 2:
                                if (com.tencent.mm.plugin.voip.b.b.rZ(this.kuz.kus.ktH.mState)) {
                                    this.kuz.kus.bbW();
                                    return;
                                } else {
                                    this.kuz.kus.bbY();
                                    return;
                                }
                            case 3:
                                this.kuz.kus.bbU();
                                return;
                            default:
                                return;
                        }
                    }
                });
            }
            return false;
        }
    };
    private int mUIType;

    class AnonymousClass12 implements OnClickListener {
        final /* synthetic */ Context kuA;
        final /* synthetic */ j kus;

        public AnonymousClass12(j jVar, Context context) {
            this.kus = jVar;
            this.kuA = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            v.i("MicroMsg.Voip.VoipMgr", "show Permission settings");
            com.tencent.mm.compatible.e.b.ay(this.kuA);
            if (this.kus.ktR) {
                if (this.kus.ktS) {
                    this.kus.bca();
                } else {
                    this.kus.bcb();
                }
            } else if (this.kus.ktS) {
                this.kus.bbW();
            } else {
                this.kus.bbY();
            }
        }
    }

    class a implements Runnable {
        final /* synthetic */ j kus;

        a(j jVar) {
            this.kus = jVar;
        }

        public final void run() {
            this.kus.bcm();
            this.kus.ktN = null;
        }
    }

    static /* synthetic */ void d(j jVar, boolean z) {
        v.i("MicroMsg.Voip.VoipMgr", "do minimizeVoip");
        if (2 != jVar.mUIType || VERSION.SDK_INT >= 24) {
            jVar.mUIType = 2;
            jVar.kuc++;
            jVar.kul = new com.tencent.mm.plugin.voip.widget.b(jVar, jVar.ktH.mState, jVar.ktQ, jVar.ktS, jVar.ktR, z);
            int i = (261 == jVar.ktH.mState || 7 == jVar.ktH.mState) ? true : 0;
            if (2 == jVar.ktW && i != 0) {
                jVar.gN(true);
                jVar.rG(1);
                ak.yW();
                if (1 == com.tencent.mm.model.c.vf().getInt(327949, 0)) {
                    Toast.makeText(jVar.getContext(), jVar.getContext().getString(2131235962), 0).show();
                } else {
                    Toast.makeText(jVar.getContext(), jVar.getContext().getString(2131235961), 1).show();
                    ak.yW();
                    com.tencent.mm.model.c.vf().setInt(327949, 1);
                }
            }
            if (260 == jVar.ktH.mState || 6 == jVar.ktH.mState) {
                ak.yW();
                if (1 == com.tencent.mm.model.c.vf().getInt(327948, 0)) {
                    Toast.makeText(jVar.getContext(), jVar.getContext().getString(2131235955), 0).show();
                } else {
                    Toast.makeText(jVar.getContext(), jVar.getContext().getString(2131235954), 1).show();
                    ak.yW();
                    com.tencent.mm.model.c.vf().setInt(327948, 1);
                }
            }
            if (jVar.ktH.mState == 0 || 2 == jVar.ktH.mState || 256 == jVar.ktH.mState) {
                jVar.bcn();
            }
            d.bbw().aCp();
            d.bbw().t(true, z);
            return;
        }
        v.e("MicroMsg.Voip.VoipMgr", "already is widget");
    }

    static /* synthetic */ void w(j jVar) {
        if (com.tencent.mm.plugin.voip.b.b.rY(jVar.ktH.mState)) {
            jVar.kud.kCn = jVar.kuh;
            jVar.kud.kCo = jVar.kui;
            com.tencent.mm.plugin.voip.video.j jVar2 = jVar.kud;
            int[] iArr = new int[2];
            if (jVar.kuj) {
                iArr[0] = 1;
                iArr[1] = 0;
            } else {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.asIntBuffer().put(iArr);
            byte[] array = allocate.array();
            if (jVar2.kuB.setAppCmd(13, array, array.length) >= 0) {
                int length = (array.length % 4 == 0 ? 0 : 1) + (array.length / 4);
                ByteBuffer allocate2 = ByteBuffer.allocate(length * 4);
                allocate2.put(array);
                allocate2.order(ByteOrder.nativeOrder());
                allocate2.rewind();
                int[] iArr2 = new int[length];
                allocate2.asIntBuffer().get(iArr2);
                int i = iArr2[0];
                length = iArr2[1];
                if (i + length != 0) {
                    b bVar = new b(jVar2);
                    bVar = new b(jVar2);
                    bVar.kCr = i & 65535;
                    bVar.kCs = (i >> 16) & 65535;
                    bVar.kCt = length & 65535;
                    bVar.kCu = (length >> 16) & 65535;
                    v.d("MicroMsg.VoipFaceDetector", "detect face, location:%s", new Object[]{bVar});
                    Iterator it = jVar2.epu.iterator();
                    while (it.hasNext()) {
                        ((com.tencent.mm.plugin.voip.video.j.a) it.next()).a(new int[]{bVar.kCr, bVar.kCs, bVar.kCt, bVar.kCu}, jVar2.kCn, jVar2.kCo);
                    }
                    return;
                }
                Iterator it2 = jVar2.epu.iterator();
                while (it2.hasNext()) {
                    ((com.tencent.mm.plugin.voip.video.j.a) it2.next()).a(null, jVar2.kCn, jVar2.kCo);
                }
            }
        }
    }

    public final void cK(int i) {
        int i2 = 1;
        v.d("MicroMsg.Voip.VoipMgr", "onBluetoothHeadsetStateChange status: %d, mBTRecoverSpeakerOn: %b", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.ktZ)});
        switch (i) {
            case 1:
                ak.yX().a(false, d.bbw().bbu());
                d.bbw().gL(false);
                d.bbw().gS(false);
                i2 = 4;
                break;
            case 2:
                ak.yX().qT();
                gN(this.ktZ);
                if (!this.ktZ) {
                    i2 = 2;
                    break;
                }
                break;
            case 3:
                ak.yX().qS();
                return;
            case 4:
                ak.yX().qT();
                ak.yX().qR();
                gN(this.ktZ);
                if (!this.ktZ) {
                    i2 = 2;
                }
                rG(i2);
                return;
            default:
                return;
        }
        rG(i2);
    }

    private void rG(int i) {
        this.ktW = i;
        if (this.ktK != null) {
            this.ktK.rQ(this.ktW);
        }
    }

    private void gN(boolean z) {
        v.h("MicroMsg.Voip.VoipMgr", "enableSpeaker: " + z, new Object[0]);
        this.ktY = z;
        this.ktZ = z;
        v.d("MicroMsg.Voip.VoipMgr", "MMCore.getAudioManager() " + ak.yX().qY());
        if (ak.yX().qU()) {
            z = false;
        }
        if (p.ceB.cbr) {
            p.ceB.dump();
            if (p.ceB.cbs > 0) {
                d.bbw().gL(z);
            }
        }
        if (p.ceB.cbT >= 0 || p.ceB.cbU >= 0) {
            d.bbw().gL(z);
        }
        ak.yX().a(z, d.bbw().bbu());
        d.bbw().gS(z);
        this.kua = z;
    }

    public final void gO(boolean z) {
        int i;
        v.d("MicroMsg.Voip.VoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", new Object[]{Boolean.valueOf(z)});
        if (d.bbw().bcI()) {
            gN(z);
        } else {
            n nVar = d.bbw().kuO;
            if (nVar.kve != null) {
                nVar.kve.gY(z);
            }
        }
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        rG(i);
        g gVar = g.iuh;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(2);
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(0);
        gVar.h(11080, objArr);
    }

    public final void ew(boolean z) {
        int i = 1;
        g gVar;
        if (z) {
            gVar = d.bbw().kuO.kqI.kse;
            if (gVar.hza != null) {
                gVar.hza.an(true);
            }
            d.bbw().rC(9);
            d.bbw().gR(true);
        } else {
            gVar = d.bbw().kuO.kqI.kse;
            if (gVar.hza != null) {
                gVar.hza.an(false);
            }
            d.bbw().rC(8);
            d.bbw().gR(false);
        }
        this.aUy = z;
        g gVar2 = g.iuh;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = Integer.valueOf(0);
        if (z) {
            i = 2;
        }
        objArr[2] = Integer.valueOf(i);
        gVar2.h(11080, objArr);
    }

    public final boolean bbU() {
        if (!this.ktH.sb(4103)) {
            return false;
        }
        rH(4103);
        return true;
    }

    public final boolean bbV() {
        if (!this.ktH.sb(4101)) {
            return false;
        }
        d.bbw().aCp();
        d.bbw().rC(1);
        d.bbw().u(true, this.ktS);
        g gVar = g.iuh;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = Long.valueOf(d.bbw().bcC());
        objArr[2] = Integer.valueOf(d.bbw().kuO.kqI.ksc.gFG);
        objArr[3] = Integer.valueOf(0);
        objArr[4] = Integer.valueOf(this.ktR ? 1 : 0);
        gVar.h(11046, objArr);
        g.iuh.h(11080, new Object[]{Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0)});
        rI(4101);
        rI(4100);
        return true;
    }

    public final boolean bbW() {
        int i = 0;
        if (!this.ktH.sb(4099)) {
            return false;
        }
        String str = this.ktQ.field_username;
        String str2 = this.ktS ? at.nvC : at.nvB;
        if (this.ktR) {
            i = 1;
        }
        l.a(str, str2, i, 6, aa.getContext().getString(2131235868));
        d.bbw().aCp();
        d.bbw().kuO.bcO();
        rI(4099);
        bcg();
        return true;
    }

    public final boolean bbX() {
        if (!this.ktH.sb(4100)) {
            return false;
        }
        v.i("MicroMsg.Voip.VoipMgr", "onAcceptVideoInvite");
        d.bbw().aCp();
        d.bbw().u(false, this.ktS);
        rI(4100);
        return true;
    }

    public final boolean bbY() {
        int i = 0;
        if (!this.ktH.sb(4099)) {
            return false;
        }
        v.i("MicroMsg.Voip.VoipMgr", "onRejectVoiceInvite");
        String str = this.ktQ.field_username;
        String str2 = this.ktS ? at.nvC : at.nvB;
        if (this.ktR) {
            i = 1;
        }
        l.a(str, str2, i, 6, aa.getContext().getString(2131235868));
        d.bbw().aCp();
        d.bbw().kuO.bcO();
        rI(4099);
        bcg();
        return true;
    }

    public final boolean bbZ() {
        if (!this.ktH.sb(4100)) {
            return false;
        }
        v.i("MicroMsg.Voip.VoipMgr", "onAcceptVoiceInvite");
        d.bbw().aCp();
        d.bbw().u(true, this.ktS);
        rI(4100);
        return true;
    }

    public final boolean bca() {
        if (!this.ktH.sb(4098)) {
            return false;
        }
        v.i("MicroMsg.Voip.VoipMgr", "onCancelVideoInvite");
        rH(4098);
        return true;
    }

    public final boolean bcb() {
        if (!this.ktH.sb(4098)) {
            return false;
        }
        v.i("MicroMsg.Voip.VoipMgr", "onCancelVoiceInvite");
        rH(4098);
        return true;
    }

    public final void a(com.tencent.mm.plugin.voip.ui.a aVar, int i) {
        v.i("MicroMsg.Voip.VoipMgr", "onVoipUICreated");
        if (1 == i && this.ktK != null) {
            this.ktK.uninit();
        }
        this.ktK = aVar;
        this.mUIType = i;
        int i2 = 320;
        int i3 = 240;
        if (this.ktL == null && com.tencent.mm.plugin.voip.b.b.rZ(this.ktH.mState)) {
            this.ktM = new CaptureView(aa.getContext());
            if (v2protocal.kvD) {
                v.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
                i2 = 640;
                i3 = 480;
            }
            this.ktL = new com.tencent.mm.plugin.voip.video.a(i2, i3);
            this.ktL.a((f) this, true);
            this.ktL.a(this.ktM);
            d.bbw().rN(this.ktL.bdJ());
            this.ihw.postDelayed(new Runnable(this) {
                final /* synthetic */ j kus;

                {
                    this.kus = r1;
                }

                public final void run() {
                    v.d("MicroMsg.Voip.VoipMgr", "mCaptureRender == " + this.kus.ktL);
                    if (this.kus.ktL != null) {
                        this.kus.ktL.bdE();
                    }
                }
            }, 50);
        }
        this.ktK.a(this.ktM);
        this.ktK.cC(-1, this.ktH.mState);
        this.ktK.dr(this.ktX);
        this.ktK.rQ(this.ktW);
        this.ktK.dJ(this.aUy);
    }

    public final void a(com.tencent.mm.plugin.voip.ui.a aVar) {
        v.i("MicroMsg.Voip.VoipMgr", "onVoipUIDestroy");
        if (this.ktK == aVar) {
            v.d("MicroMsg.Voip.VoipMgr", "same VoipUI, clear it");
            this.ktK = null;
        }
        if (this.ihw != null) {
            this.ihw = null;
        }
    }

    public final void bcc() {
        v.i("MicroMsg.Voip.VoipMgr", "onSwitchCamera");
        if (this.ktL != null) {
            this.ktL.bdD();
        }
        g.iuh.h(11079, new Object[]{Integer.valueOf(1)});
    }

    private void rH(int i) {
        String string;
        v.i("MicroMsg.Voip.VoipMgr", "hangupTalkingOrCancelInvite");
        if (true == bco()) {
            this.ktU = i;
        }
        Context context = aa.getContext();
        if (com.tencent.mm.plugin.voip.b.b.rY(this.ktH.mState)) {
            string = context.getString(2131235864, new Object[]{ao(be.ax(this.ktX))});
        } else if (this.ktR) {
            string = context.getString(2131235860);
        } else {
            string = context.getString(2131235859);
        }
        l.a(this.ktQ.field_username, this.ktS ? at.nvC : at.nvB, this.ktR ? 1 : 0, 6, string);
        if (!this.ktR || com.tencent.mm.plugin.voip.b.b.rY(this.ktH.mState)) {
            e.a(new Runnable(this) {
                final /* synthetic */ j kus;

                {
                    this.kus = r1;
                }

                public final void run() {
                    d.bbw().aCp();
                    if (this.kus.ktS) {
                        d.bbw().rO(0);
                    } else {
                        d.bbw().rO(1);
                    }
                }
            }, "VoipMgr_play_end_sound");
            this.ktO = true;
            d.bbw().bcA();
            if (4096 == this.ktU) {
                rI(i);
                bcg();
                return;
            }
            return;
        }
        d.bbw().aCp();
        if (this.ktR && !com.tencent.mm.plugin.voip.b.b.rY(this.ktH.mState)) {
            v.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call cancelCall");
            n nVar = d.bbw().kuO;
            v.i("MicroMsg.Voip.VoipServiceEx", "cancelCall, roomId:" + nVar.kqI.ksc.gFG);
            if (nVar.kqI.ksc.gFG == 0 && nVar.kqI.ksc.gFJ == 0) {
                nVar.reset();
            } else {
                nVar.kqI.ksc.kxf.ksP = nVar.kqI.bbB();
                nVar.kqI.ksc.kxf.ktb = 3;
                if (nVar.kqI.mStatus < 6) {
                    nVar.kqI.ksc.kxf.ktd = 1;
                }
                g gVar = g.iuh;
                Object[] objArr = new Object[6];
                objArr[0] = Integer.valueOf(d.bbw().kuO.kqI.ksc.gFG);
                objArr[1] = Long.valueOf(d.bbw().bcC());
                objArr[2] = Long.valueOf(d.bbw().bcD());
                objArr[3] = Integer.valueOf(nVar.kqI.mStatus == 5 ? 2 : 1);
                objArr[4] = Long.valueOf(System.currentTimeMillis());
                objArr[5] = Long.valueOf(System.currentTimeMillis());
                gVar.a(11521, true, true, objArr);
                nVar.bcN();
            }
        }
        v.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call hangUp");
        d.bbw().bcA();
        if (4096 == this.ktU) {
            rI(i);
            bcg();
        }
    }

    public final boolean bcd() {
        if (d.bbw().kuO.kqI.ksc.gFG != 0) {
            return bce();
        }
        this.ktV = true;
        return true;
    }

    private boolean bce() {
        int i = 4;
        int i2 = 0;
        if (!this.ktH.sb(4101)) {
            return false;
        }
        Object[] objArr;
        g gVar;
        int i3;
        Object[] objArr2;
        int i4;
        Object[] objArr3;
        rI(4101);
        Object[] objArr4;
        if (261 == this.ktH.mState || 7 == this.ktH.mState) {
            d.bbw().rC(1);
            g gVar2 = g.iuh;
            Object[] objArr5 = new Object[5];
            objArr5[0] = Integer.valueOf(2);
            objArr5[1] = Long.valueOf(d.bbw().bcC());
            objArr5[2] = Integer.valueOf(d.bbw().kuO.kqI.ksc.gFG);
            objArr5[3] = Integer.valueOf(0);
            objArr5[4] = Integer.valueOf(this.ktR ? 1 : 0);
            gVar2.h(11046, objArr5);
            gVar2 = g.iuh;
            objArr = new Object[3];
            objArr[0] = Integer.valueOf(2);
            objArr[1] = Integer.valueOf(0);
            gVar = gVar2;
            i3 = 11080;
            objArr2 = objArr;
            objArr4 = objArr;
            i4 = 2;
            objArr3 = objArr4;
        } else {
            if (1 == this.ktH.mState || 3 == this.ktH.mState) {
                d.bbw().rC(1);
                gVar = g.iuh;
                i3 = 11046;
                objArr = new Object[5];
                objArr[0] = Integer.valueOf(1);
                objArr[1] = Long.valueOf(d.bbw().bcC());
                objArr[2] = Integer.valueOf(d.bbw().kuO.kqI.ksc.gFG);
                objArr[3] = Integer.valueOf(0);
                if (this.ktR) {
                    i2 = 1;
                    objArr3 = objArr;
                    objArr[i] = Integer.valueOf(i2);
                    gVar.h(i3, objArr3);
                } else {
                    objArr3 = objArr;
                    objArr4 = objArr;
                    i4 = 4;
                    objArr2 = objArr4;
                }
            }
            d.bbw().bcE();
            d.bbw().bcF();
            return true;
        }
        int i5 = i4;
        objArr = objArr2;
        i = i5;
        objArr[i] = Integer.valueOf(i2);
        gVar.h(i3, objArr3);
        d.bbw().bcE();
        d.bbw().bcF();
        return true;
    }

    public final void bcf() {
        v.i("MicroMsg.Voip.VoipMgr", "onRoomReady");
        if (this.ktV && d.bbw().kuO.kqI.ksc.gFG != 0) {
            this.ktV = false;
            bce();
        }
        if (this.ktR) {
            rI(4097);
        }
        if (com.tencent.mm.plugin.voip.b.a.bdu()) {
            d.bbw().rC(3);
            rI(4101);
        }
    }

    private void rI(final int i) {
        v.h("MicroMsg.Voip.VoipMgr", "swtchState, action: %s, currentState: %s", new Object[]{com.tencent.mm.plugin.voip.b.b.rV(i), com.tencent.mm.plugin.voip.b.b.rV(this.ktH.mState)});
        if (4101 == i && com.tencent.mm.plugin.voip.b.b.rZ(this.ktH.mState)) {
            bcn();
        }
        if (4101 == i && com.tencent.mm.plugin.voip.b.b.rZ(this.ktH.mState) && 1 == this.mUIType && 1 == this.ktW) {
            gN(false);
            rG(2);
        }
        c cVar = this.ktH;
        if (cVar.sb(i)) {
            v.d("MicroMsg.Voip.VoipStateMachine", "from oldState: %s to newState: %s, action: %s", new Object[]{com.tencent.mm.plugin.voip.b.b.rV(cVar.mState), com.tencent.mm.plugin.voip.b.b.rV(((Integer) ((Map) cVar.kzR.get(Integer.valueOf(cVar.mState))).get(Integer.valueOf(i))).intValue()), com.tencent.mm.plugin.voip.b.b.rV(i)});
            cVar.mState = r0;
        } else {
            v.e("MicroMsg.Voip.VoipStateMachine", "can't tranform due to no such rule");
        }
        this.ihw.post(new Runnable(this) {
            final /* synthetic */ j kus;

            public final void run() {
                if (this.kus.ktK != null) {
                    this.kus.ktK.cC(i, this.kus.ktH.mState);
                }
            }
        });
        if (6 == this.ktH.mState || 260 == this.ktH.mState) {
            bcs();
        }
        switch (this.ktH.mState) {
            case 258:
            case 259:
                rJ(5);
                return;
            case 262:
                rJ(6);
                return;
            default:
                return;
        }
    }

    private static void rJ(int i) {
        qy qyVar = new qy();
        qyVar.bsD.aYt = i;
        com.tencent.mm.sdk.c.a.nhr.z(qyVar);
    }

    public final void onError(int i, String str) {
        if (this.ktS) {
            d.bbw().rO(0);
        } else {
            d.bbw().rO(1);
        }
        if (i == 241 && be.kS(str)) {
            str = getContext().getString(2131235936);
        }
        if (this.ktK != null) {
            this.ktK.ai(i, str);
        }
        rI(4109);
        v.i("MicroMsg.Voip.VoipMgr", "onError, errCode: %s, roomId: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(d.bbw().kuO.kqI.ksc.gFG)});
        Context context = aa.getContext();
        v.d("MicroMsg.Voip.VoipMgr", "getErrorMsgContent, errorCode" + i);
        String string = i == 235 ? context.getString(2131235870) : i == 233 ? context.getString(2131235862) : i == 237 ? context.getString(2131235870) : i == 236 ? context.getString(2131235862) : i == 211 ? context.getString(2131235869) : context.getString(2131235861);
        String str2;
        String str3;
        int i2;
        if (d.bbw().kuO.kqI.ksc.gFG != 0 && d.bbw().kuT.get(Integer.valueOf(d.bbw().kuO.kqI.ksc.gFG)) == null) {
            str2 = this.ktQ.field_username;
            str3 = this.ktS ? at.nvC : at.nvB;
            i2 = this.ktR ? 1 : 0;
            if (com.tencent.mm.plugin.voip.b.b.rY(this.ktH.mState)) {
                string = aa.getContext().getString(2131235865, new Object[]{ao(be.ax(this.ktX))});
            }
            d.bbw().kuT.put(Integer.valueOf(d.bbw().kuO.kqI.ksc.gFG), Long.valueOf(l.a(str2, str3, i2, 6, string, true)));
        } else if (d.bbw().kuO.kqI.ksc.gFG == 0) {
            str2 = this.ktQ.field_username;
            str3 = this.ktS ? at.nvC : at.nvB;
            i2 = this.ktR ? 1 : 0;
            if (com.tencent.mm.plugin.voip.b.b.rY(this.ktH.mState)) {
                string = aa.getContext().getString(2131235865, new Object[]{ao(be.ax(this.ktX))});
            }
            l.a(str2, str3, i2, 6, string, true);
        }
        bcg();
    }

    public final void atM() {
        v.i("MicroMsg.Voip.VoipMgr", "on accept");
        d.bbw().aCp();
        rI(4100);
    }

    public final void onReject() {
        v.i("MicroMsg.Voip.VoipMgr", "onReject");
        rI(4099);
        l.a(this.ktQ.field_username, this.ktS ? at.nvC : at.nvB, this.ktR ? 1 : 0, 6, aa.getContext().getString(2131235872));
        bcg();
    }

    private void bcg() {
        v.d("MicroMsg.Voip.VoipMgr", "delayFinish");
        this.ihw.postDelayed(new Runnable(this) {
            final /* synthetic */ j kus;

            {
                this.kus = r1;
            }

            public final void run() {
                this.kus.gP(false);
            }
        }, 2000);
    }

    public final void gP(boolean z) {
        m bbw;
        v.i("MicroMsg.Voip.VoipMgr", "finish");
        this.kuk = false;
        this.kum = false;
        if (this.kuc != -1) {
            g.iuh.h(11700, new Object[]{Integer.valueOf(this.kuc), Long.valueOf(be.ax(this.ktX))});
            this.kuc = -1;
        }
        try {
            aa.getContext().unregisterReceiver(this.kun);
        } catch (Exception e) {
        }
        com.tencent.mm.sdk.c.a.nhr.f(this.kuo);
        com.tencent.mm.sdk.c.a.nhr.f(this.kur);
        if (this.ktK != null) {
            this.ktK.uninit();
            this.ktK = null;
        }
        this.ktM = null;
        ak.yX().b(this);
        ak.yX().qT();
        if (d.bbw() != null) {
            d.bbw().aCp();
            if (z) {
                d.bbw().kuO.bcQ();
            } else {
                d.bbw().bcA();
            }
            if (this.ktS) {
                d.bbw().a(false, true, this.bZy);
            } else {
                d.bbw().a(false, false, this.bZy);
            }
            bbw = d.bbw();
            Context context = aa.getContext();
            n nVar = bbw.kuO;
            if (context == nVar.kqI.fda && this == nVar.kqI.ksd) {
                nVar.kqI.fda = null;
                nVar.kqI.ksd = p.kvn;
                com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipServiceEx", "detach ui........");
                com.tencent.mm.plugin.voip.b.a.bdv();
            } else {
                com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip.VoipServiceEx", "cannot detach other's ui.");
            }
        }
        bbw = d.bbw();
        bbw.kuP = null;
        bbw.kuV = null;
        bbw.kuW = false;
        if (this.ktO) {
            this.ktN = new a(this);
            e.a(this.ktN, "VoipMgr_clean");
        } else {
            bcm();
        }
        if (!(this.ktJ == null || this.kuq == null)) {
            this.ktJ.listen(this.kuq, 0);
            this.kuq = null;
        }
        if (this.ktI != null) {
            this.ktI.cD(aa.getContext());
        }
        this.ktJ = null;
        ak.oJ().pT();
        k.bct().bcv();
        k.bct().kuD = null;
        ak.oH().cancel(40);
    }

    public final void bch() {
        v.i("MicroMsg.Voip.VoipMgr", "onNoResp");
        rI(4105);
        l.a(this.ktQ.field_username, this.ktS ? at.nvC : at.nvB, this.ktR ? 1 : 0, 4, aa.getContext().getString(2131235871));
        g.iuh.a(11518, true, true, new Object[]{Integer.valueOf(d.bbw().kuO.kqI.ksc.gFG), Long.valueOf(d.bbw().bcC()), Long.valueOf(d.bbw().bcD()), Integer.valueOf(6), Integer.valueOf(com.tencent.mm.sdk.platformtools.ak.getNetWorkType(getContext()))});
        bcg();
    }

    public final void onConnected() {
        rI(4102);
        this.ktX = be.Nh();
        if (this.ktK != null) {
            this.ktK.dr(this.ktX);
        }
        boolean bbF = d.bbw().kuO.kqI.bbF();
        boolean bbE = d.bbw().kuO.kqI.bbE();
        if (this.ktS && this.ktR && !bbE && !bbF) {
            d.bbw().rC(1);
        }
        if (!com.tencent.mm.plugin.voip.b.b.rZ(this.ktH.mState)) {
            g.iuh.h(11080, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0)});
        }
        n nVar = d.bbw().kuO;
        if (nVar.kve != null) {
            h hVar = nVar.kve;
            be.j(hVar.mContext, hVar.mContext.getSharedPreferences(aa.bti(), 0).getBoolean("settings_shake", true));
        }
        k.bct().bcu();
        k.bct().kuD = this;
    }

    public final void bci() {
        int i = 0;
        g gVar = g.iuh;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(d.bbw().kuO.kqI.ksc.gFG);
        objArr[1] = Long.valueOf(d.bbw().bcC());
        objArr[2] = Long.valueOf(d.bbw().bcD());
        if (!this.ktR) {
            i = 1;
        }
        objArr[3] = Integer.valueOf(i);
        objArr[4] = Integer.valueOf(1);
        gVar.a(11522, true, true, objArr);
    }

    public final void bcj() {
        String string;
        v.i("MicroMsg.Voip.VoipMgr", "onShutDown");
        if (com.tencent.mm.plugin.voip.b.b.rY(this.ktH.mState)) {
            string = aa.getContext().getString(2131235864, new Object[]{ao(be.ax(this.ktX))});
        } else {
            string = aa.getContext().getString(2131235861);
        }
        if (this.ktR || com.tencent.mm.plugin.voip.b.b.rY(this.ktH.mState)) {
            l.a(this.ktQ.field_username, this.ktS ? at.nvC : at.nvB, 0, 6, string);
        }
        if (this.ktS) {
            d.bbw().rO(0);
        } else {
            d.bbw().rO(1);
        }
        if (bco()) {
            this.ktU = 4106;
            return;
        }
        rI(4106);
        bcg();
    }

    public final void rK(int i) {
        v.i("MicroMsg.Voip.VoipMgr", "remote voip mode changed, cmd:%d", new Object[]{Integer.valueOf(i)});
        if (1 == i || 3 == i || 5 == i || 6 == i || 7 == i) {
            rI(4101);
            d.bbw().bcE();
            d.bbw().bcF();
        }
    }

    public final void a(int i, int i2, int i3, int[] iArr) {
        if (this.ktK != null) {
            this.ktK.a(i, i2, iArr);
        }
    }

    public final void bck() {
        if (this.ktK != null) {
            this.ktK.bck();
        }
    }

    public final void rL(int i) {
        boolean z = false;
        v.i("MicroMsg.Voip.VoipMgr", "onSessionBeingCalled, callType: " + i);
        if (this.ktH.sb(4110)) {
            m bbw = d.bbw();
            boolean z2 = i == 1;
            if (i == 1) {
                z = true;
            }
            bbw.u(z2, z);
            d.bbw().aCp();
            if (i == 1 && com.tencent.mm.plugin.voip.b.b.rZ(this.ktH.mState)) {
                rI(4101);
            }
            rI(4110);
        }
    }

    public final void bcl() {
        boolean z = true;
        v.d("MicroMsg.Voip.VoipMgr", "onPretreatmentForStartDev");
        if (ak.yX().ra() || ak.yX().qU() || 1 != this.ktW) {
            z = false;
        }
        gN(z);
    }

    private static String ao(long j) {
        return String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)});
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3) {
        if (!this.kub) {
            int i4;
            int i5 = this.ktL.bdH() ? OpenGlRender.kBy : 0;
            int i6 = this.ktL.bdI() ? OpenGlRender.kBx : OpenGlRender.kBw;
            int i7 = (int) j;
            g gVar = d.bbw().kuO.kqI.kse;
            if (gVar.ksy != 2) {
                i4 = 0;
            } else if (gVar.kqI.bbI()) {
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal = gVar.kqI.ksc;
                com_tencent_mm_plugin_voip_model_v2protocal.kwN++;
                i4 = gVar.kqI.ksc.videoEncodeToSend(bArr, i7, i, i2, i3);
            } else {
                i4 = 0;
            }
            if (this.ktK != null) {
                this.ktK.a(bArr, j, i, i2, i3, i5, i6, i4);
            }
            this.kuh = i5 == OpenGlRender.kBy;
            this.kui = i6 == OpenGlRender.kBx ? 270 : 90;
            com.tencent.mm.plugin.voip.video.j jVar = this.kud;
            jVar.kCq = i2;
            jVar.kCp = i;
        }
    }

    private void bcm() {
        synchronized (this.ktP) {
            d.bbw().aCp();
            bcn();
            ak.yX().setMode(0);
            if (this.aUX != null) {
                this.aUX.si();
            }
        }
    }

    private void bcn() {
        v.h("MicroMsg.Voip.VoipMgr", "uninitCaptureRender", new Object[0]);
        if (this.ktL != null) {
            if (this.kud != null) {
                com.tencent.mm.plugin.voip.video.j jVar = this.kud;
                if (jVar.epu.contains(this)) {
                    jVar.epu.remove(this);
                }
            }
            if (this.kue != null) {
                v.d("MicroMsg.Voip.VoipMgr", "stop face detect timer");
                this.kue.QI();
            }
            if (this.kuf != null) {
                v.d("MicroMsg.Voip.VoipMgr", "quit face detect thread");
                this.kuf.htb.getLooper().quit();
            }
            try {
                this.ktL.bdF();
                this.ktL.bdG();
            } catch (Exception e) {
                v.d("MicroMsg.Voip.VoipMgr", "stop capture error:" + e.toString());
            }
            this.ktL = null;
        }
    }

    public final void atR() {
        v.i("MicroMsg.Voip.VoipMgr", "onBadNetStatus");
        if (this.ktK != null) {
            this.ktK.bdl();
        }
        if (!com.tencent.mm.plugin.voip.b.b.rZ(this.ktH.mState) && !this.kua) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.gGB > 30000) {
                this.gGB = currentTimeMillis;
                d.bbw().bcH();
            }
        }
    }

    public final void atS() {
        v.i("MicroMsg.Voip.VoipMgr", "onResumeGoodNetStatus");
        if (this.ktK != null) {
            this.ktK.avv();
        }
    }

    private boolean bco() {
        if (!com.tencent.mm.plugin.voip.b.b.rY(this.ktH.mState)) {
            return false;
        }
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("voip_plugin_prefs", 0);
        if (sharedPreferences.getBoolean("voip_shortcut_has_added", false)) {
            return false;
        }
        String value = com.tencent.mm.h.j.sU().getValue("VOIPShortcutAutoadd");
        v.i("MicroMsg.Voip.VoipMgr", "voip shortcut autoAdd is %s", new Object[]{value});
        if (value != null && value.equals("0") && be.ax(this.ktX) > 30) {
            int i = sharedPreferences.getInt("voip_shortcut_prompt_times", 0);
            boolean z = sharedPreferences.getBoolean("voip_shortcut_never_show_anymore", false);
            if (i >= 3 || z) {
                return false;
            }
            Context context = getContext();
            View inflate = View.inflate(context, 2130903966, null);
            final CheckBox checkBox = (CheckBox) inflate.findViewById(2131758198);
            checkBox.setChecked(false);
            TextView textView = (TextView) inflate.findViewById(2131758197);
            if (1 == be.getInt(com.tencent.mm.h.j.sU().getValue("VOIPCallType"), 0)) {
                textView.setText(2131235851);
            } else {
                textView.setText(2131235852);
            }
            com.tencent.mm.ui.base.g.a(context, false, context.getString(2131231164), inflate, context.getString(2131231183), context.getString(2131231104), new OnClickListener(this) {
                final /* synthetic */ j kus;

                {
                    this.kus = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.kus.c(this.kus.getContext().getSharedPreferences("voip_plugin_prefs", 0));
                    if (4096 != this.kus.ktU) {
                        this.kus.rI(this.kus.ktU);
                        this.kus.ktU = 4096;
                    }
                    this.kus.gP(false);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ j kus;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (checkBox != null) {
                        this.kus.getContext().getSharedPreferences("voip_plugin_prefs", 0).edit().putBoolean("voip_shortcut_never_show_anymore", checkBox.isChecked()).commit();
                    }
                    if (4096 != this.kus.ktU) {
                        this.kus.rI(this.kus.ktU);
                        this.kus.ktU = 4096;
                    }
                    this.kus.gP(false);
                }
            });
            sharedPreferences.edit().putInt("voip_shortcut_prompt_times", i + 1).commit();
            return true;
        } else if (value == null || !value.equals("1") || be.ax(this.ktX) <= 15) {
            return false;
        } else {
            c(sharedPreferences);
            return false;
        }
    }

    private void c(SharedPreferences sharedPreferences) {
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra("duplicate", false);
        Object intent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
        intent2.addFlags(67108864);
        if (1 == be.getInt(com.tencent.mm.h.j.sU().getValue("VOIPCallType"), 0)) {
            intent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip");
            intent.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(2131231059));
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(getContext(), 2130839453));
        } else {
            intent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
            intent.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(2131231061));
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(getContext(), 2130839480));
        }
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
        getContext().sendBroadcast(intent);
        sharedPreferences.edit().putBoolean("voip_shortcut_has_added", true).commit();
    }

    private Context getContext() {
        Context context = null;
        if (this.ktK != null) {
            context = this.ktK.bdk();
        }
        if (context == null) {
            return aa.getContext();
        }
        return context;
    }

    public final void gQ(final boolean z) {
        v.h("MicroMsg.Voip.VoipMgr", "miniOnlyHidenVoip: %b", new Object[]{Boolean.valueOf(z)});
        v.i("MicroMsg.Voip.VoipMgr", "onMinimizeVoip, async to minimize");
        if (this.ktK != null) {
            this.ktK.uninit();
            this.ktK = null;
        }
        this.ihw.post(new Runnable(this) {
            final /* synthetic */ j kus;

            public final void run() {
                j.d(this.kus, z);
            }
        });
    }

    public final void bcp() {
        if (256 == this.ktH.mState || 257 == this.ktH.mState) {
            ak.yW();
            if (com.tencent.mm.model.c.vf().getInt(327945, 0) != 0 || this.ktK.bdk() == null) {
                d.cJ(aa.getContext());
                bcr();
                return;
            }
            ak.yW();
            com.tencent.mm.model.c.vf().setInt(327945, 1);
            com.tencent.mm.ui.base.h a = com.tencent.mm.ui.base.g.a(this.ktK.bdk(), 2131235917, 2131231164, new OnClickListener(this) {
                final /* synthetic */ j kus;

                {
                    this.kus = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.kus.bcr();
                }
            });
            a.setCancelable(false);
            a.setCanceledOnTouchOutside(false);
            a.show();
        }
    }

    public final void bcq() {
        this.kug = !this.kug;
        if (this.kug) {
            this.kue.QI();
        } else {
            bcs();
        }
    }

    public final void bcr() {
        d.bbw().kuU = d.bbw().kuO.kqI.ksc.gFG;
        l.a(this.ktQ.field_username, this.ktS ? at.nvC : at.nvB, this.ktR ? 1 : 0, 6, aa.getContext().getString(2131235867));
        d.bbw().aCp();
        rI(4108);
        this.ihw.postDelayed(new Runnable(this) {
            final /* synthetic */ j kus;

            {
                this.kus = r1;
            }

            public final void run() {
                this.kus.gP(true);
            }
        }, 2000);
    }

    public final void aCN() {
        if (true == this.hmU || this.ktK == null || this.ktK.bdk() == null) {
            v.d("MicroMsg.Voip.VoipMgr", "onCameraError, already show");
        } else if (!Build.MANUFACTURER.equalsIgnoreCase("meizu") || com.tencent.mm.compatible.e.b.sf()) {
            int i;
            v.d("MicroMsg.Voip.VoipMgr", "onCameraError, show dialog");
            g gVar = g.iuh;
            Object[] objArr = new Object[2];
            if (this.ktS) {
                i = 0;
            } else {
                i = 1;
            }
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(0);
            gVar.h(11306, objArr);
            com.tencent.mm.ui.base.h f = com.tencent.mm.ui.base.g.f(this.ktK.bdk(), 2131235929, 2131231164);
            if (f == null) {
                v.e("MicroMsg.Voip.VoipMgr", "new dialog failed");
                return;
            }
            f.setCancelable(false);
            f.setCanceledOnTouchOutside(false);
            f.show();
            this.hmU = true;
        } else {
            v.d("MicroMsg.Voip.VoipMgr", "onCameraError, meizu machine");
        }
    }

    private void bcs() {
        if (this.kue == null) {
            this.kuf = new ad("faceDetect");
            this.kue = new ah(this.kuf.htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
                final /* synthetic */ j kus;

                {
                    this.kus = r1;
                }

                public final boolean oU() {
                    j.w(this.kus);
                    return true;
                }
            }, true);
        }
        this.kue.ea(2000);
        this.kug = false;
    }

    public final void a(final int[] iArr, final boolean z, final int i) {
        ad.o(new Runnable(this) {
            final /* synthetic */ j kus;

            public final void run() {
                if (this.kus.ktL != null) {
                    this.kus.ktL.n(iArr);
                }
                if (this.kus.ktK != null) {
                    this.kus.ktK;
                }
            }
        });
    }
}
