package com.tencent.mm.plugin.bbom;

import android.bluetooth.BluetoothAdapter;
import android.content.SharedPreferences;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.text.TextUtils;
import com.tencent.mm.ae.n;
import com.tencent.mm.as.k;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.booter.h;
import com.tencent.mm.booter.i;
import com.tencent.mm.booter.l;
import com.tencent.mm.booter.o;
import com.tencent.mm.e.a.ab;
import com.tencent.mm.e.a.ey;
import com.tencent.mm.e.a.hf;
import com.tencent.mm.e.a.if;
import com.tencent.mm.e.a.io;
import com.tencent.mm.e.a.iq;
import com.tencent.mm.e.a.jx;
import com.tencent.mm.e.a.lu;
import com.tencent.mm.e.a.nf;
import com.tencent.mm.e.a.om;
import com.tencent.mm.e.a.pd;
import com.tencent.mm.e.a.qg;
import com.tencent.mm.e.a.qi;
import com.tencent.mm.model.ab.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.aj;
import com.tencent.mm.modelstat.f;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.zero.a.e;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.abq;
import com.tencent.mm.protocal.c.aia;
import com.tencent.mm.protocal.c.ask;
import com.tencent.mm.protocal.c.azo;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.p;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.r;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.v.t;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;

public final class j implements e {
    private static long enZ = 0;

    public final void WZ() {
        m.LB().run();
        k.KY().run();
        n.GF().run();
        am.bnE().run();
        if (a.csd != null) {
            a.csd.yH();
        }
        com.tencent.mm.sdk.c.a.nhr.z(new om());
    }

    public final void b(int i, byte[] bArr, byte[] bArr2) {
        b nfVar;
        switch (i) {
            case 10:
                v.d("MicroMsg.NotifyReceiverDelegateImpl", "on direct send notify");
                d bVar = new p.b();
                bVar.deviceID = com.tencent.mm.compatible.d.p.rK();
                try {
                    if (new t(bVar, 10).a(10, bArr, null)) {
                        ak.vy().a(0, 0, SQLiteDatabase.KeyEmpty, new com.tencent.mm.modelsimple.j(bVar));
                        return;
                    }
                    return;
                } catch (Throwable e) {
                    v.a("MicroMsg.NotifyReceiverDelegateImpl", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    return;
                }
            case 120:
                Xb();
                if (bArr != null && bArr.length > 0) {
                    if (bArr[0] == (byte) 1) {
                        v.d("MicroMsg.NotifyReceiverDelegateImpl", "dealWithNotify case MM_VOIP_PUSHTYPE_INVITE, will launch voipUI");
                        T(bArr);
                        return;
                    } else if (bArr[0] == (byte) 101) {
                        v.d("MicroMsg.NotifyReceiverDelegateImpl", "dealWithNotify case MM_PSTN_PUSHTYPE_INVITE");
                        W(bArr);
                        return;
                    } else if (bArr[0] == (byte) 3) {
                        v.d("MicroMsg.NotifyReceiverDelegateImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_CANCEL");
                        U(bArr);
                        return;
                    } else if (bArr[0] == (byte) 2) {
                        v.d("MicroMsg.NotifyReceiverDelegateImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
                        V(bArr);
                        return;
                    } else if (bArr[0] == (byte) 102) {
                        v.d("MicroMsg.NotifyReceiverDelegateImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
                        Y(bArr);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case 174:
                v.i("MicroMsg.NotifyReceiverDelegateImpl", "dealWithNotify MMFunc_VoipSync do VoipSync");
                X(bArr);
                return;
            case 192:
                b eyVar = new ey();
                eyVar.bdO.bdP = bArr;
                com.tencent.mm.sdk.c.a.nhr.z(eyVar);
                return;
            case 241:
                v.i("MicroMsg.NotifyReceiverDelegateImpl", "jacks do voice notify UI");
                S(bArr);
                return;
            case 318:
                byte[] decodeSecureNotifyData;
                String str = "MicroMsg.NotifyReceiverDelegateImpl";
                String str2 = "summerbadcr on MM_PKT_SILENCE_NOTIFY notify respBuf len[%d]";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                v.i(str, str2, objArr);
                if (bArr != null) {
                    ask com_tencent_mm_protocal_c_ask = new ask();
                    try {
                        com_tencent_mm_protocal_c_ask.az(bArr);
                        v.i("MicroMsg.NotifyReceiverDelegateImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData[%d, %d, %d, %d, %d, %d]", Integer.valueOf(com_tencent_mm_protocal_c_ask.mQZ), Integer.valueOf(com_tencent_mm_protocal_c_ask.mRa), Integer.valueOf(com_tencent_mm_protocal_c_ask.mRb), Integer.valueOf(com_tencent_mm_protocal_c_ask.mRc), Integer.valueOf(com_tencent_mm_protocal_c_ask.mRd), Integer.valueOf(com_tencent_mm_protocal_c_ask.mRe));
                        decodeSecureNotifyData = MMProtocalJni.decodeSecureNotifyData(bArr2, com_tencent_mm_protocal_c_ask.mQZ, com_tencent_mm_protocal_c_ask.mRa, com_tencent_mm_protocal_c_ask.mRb, com_tencent_mm_protocal_c_ask.mRc, com_tencent_mm_protocal_c_ask.mRd, com_tencent_mm_protocal_c_ask.mRe, com_tencent_mm_protocal_c_ask.mRf, com_tencent_mm_protocal_c_ask.mQh.lVU);
                    } catch (Exception e2) {
                        v.e("MicroMsg.NotifyReceiverDelegateImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData parseFrom e: " + e2.getMessage());
                    }
                    if (decodeSecureNotifyData == null) {
                        v.i("MicroMsg.NotifyReceiverDelegateImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data len:%d", Integer.valueOf(decodeSecureNotifyData.length));
                        nfVar = new nf();
                        nfVar.boy.data = decodeSecureNotifyData;
                        com.tencent.mm.sdk.c.a.nhr.z(nfVar);
                        return;
                    }
                    v.e("MicroMsg.NotifyReceiverDelegateImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data is null");
                    return;
                }
                decodeSecureNotifyData = null;
                if (decodeSecureNotifyData == null) {
                    v.e("MicroMsg.NotifyReceiverDelegateImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data is null");
                    return;
                }
                v.i("MicroMsg.NotifyReceiverDelegateImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data len:%d", Integer.valueOf(decodeSecureNotifyData.length));
                nfVar = new nf();
                nfVar.boy.data = decodeSecureNotifyData;
                com.tencent.mm.sdk.c.a.nhr.z(nfVar);
                return;
            case 319:
                v.i("MicroMsg.NotifyReceiverDelegateImpl", "hy: notify test newyear shake");
                try {
                    nfVar = new io();
                    v.i("MicroMsg.NotifyReceiverDelegateImpl", "hy: test level: %d", Integer.valueOf(((azo) new azo().az(bArr)).mIZ));
                    nfVar.bja.bjb = r0;
                    com.tencent.mm.sdk.c.a.nhr.z(nfVar);
                    return;
                } catch (Exception e22) {
                    v.e("MicroMsg.NotifyReceiverDelegateImpl", "hy: exception occurs when parsing : " + e22.toString());
                    return;
                }
            case 268369923:
                if (!be.bl(bArr)) {
                    String str3 = new String(bArr);
                    nfVar = new ab();
                    nfVar.aXt.type = 4;
                    nfVar.aXt.aXv = str3;
                    com.tencent.mm.sdk.c.a.nhr.z(nfVar);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void c(int i, byte[] bArr, byte[] bArr2) {
        b nfVar;
        switch (i) {
            case 10:
                v.d("MicroMsg.NotifyReceiverDelegateImpl", "on direct send notify");
                d bVar = new p.b();
                bVar.deviceID = com.tencent.mm.compatible.d.p.rK();
                try {
                    if (new t(bVar, 10).a(10, bArr, null)) {
                        ak.vy().a(0, 0, SQLiteDatabase.KeyEmpty, new com.tencent.mm.modelsimple.j(bVar));
                        return;
                    }
                    return;
                } catch (Throwable e) {
                    v.a("MicroMsg.NotifyReceiverDelegateImpl", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    return;
                }
            case MMGIFException.D_GIF_ERR_READ_FAILED /*102*/:
                v.i("MicroMsg.NotifyReceiverDelegateImpl", "dealWithNotify MM_VOIP_CS_PUSHTYPE_SYN do VoipSync");
                break;
            case 120:
                NotifyService.cT("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
                Xb();
                if (bArr != null && bArr.length > 0) {
                    if (bArr[0] == (byte) 1) {
                        v.d("MicroMsg.NotifyReceiverDelegateImpl", "dealWithNotify case MM_VOIP_PUSHTYPE_INVITE, will launch voipUI");
                        T(bArr);
                        return;
                    } else if (bArr[0] == (byte) 101) {
                        v.d("MicroMsg.NotifyReceiverDelegateImpl", "dealWithNotify case MM_PSTN_PUSHTYPE_INVITE");
                        W(bArr);
                        return;
                    } else if (bArr[0] == (byte) 3) {
                        v.d("MicroMsg.NotifyReceiverDelegateImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_CANCEL");
                        U(bArr);
                        return;
                    } else if (bArr[0] == (byte) 2) {
                        v.d("MicroMsg.NotifyReceiverDelegateImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
                        V(bArr);
                        return;
                    } else if (bArr[0] == (byte) 102) {
                        v.d("MicroMsg.NotifyReceiverDelegateImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
                        Y(bArr);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case 174:
                v.i("MicroMsg.NotifyReceiverDelegateImpl", "dealWithNotify MMFunc_VoipSync do VoipSync");
                X(bArr);
                return;
            case 192:
                break;
            case 241:
                v.i("MicroMsg.NotifyReceiverDelegateImpl", "jacks do voice notify UI");
                S(bArr);
                return;
            case 318:
                byte[] decodeSecureNotifyData;
                String str = "MicroMsg.NotifyReceiverDelegateImpl";
                String str2 = "summerbadcr on MM_PKT_SILENCE_NOTIFY notify respBuf len[%d]";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                v.i(str, str2, objArr);
                if (bArr != null) {
                    ask com_tencent_mm_protocal_c_ask = new ask();
                    try {
                        com_tencent_mm_protocal_c_ask.az(bArr);
                        v.i("MicroMsg.NotifyReceiverDelegateImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData[%d, %d, %d, %d, %d, %d]", Integer.valueOf(com_tencent_mm_protocal_c_ask.mQZ), Integer.valueOf(com_tencent_mm_protocal_c_ask.mRa), Integer.valueOf(com_tencent_mm_protocal_c_ask.mRb), Integer.valueOf(com_tencent_mm_protocal_c_ask.mRc), Integer.valueOf(com_tencent_mm_protocal_c_ask.mRd), Integer.valueOf(com_tencent_mm_protocal_c_ask.mRe));
                        decodeSecureNotifyData = MMProtocalJni.decodeSecureNotifyData(bArr2, com_tencent_mm_protocal_c_ask.mQZ, com_tencent_mm_protocal_c_ask.mRa, com_tencent_mm_protocal_c_ask.mRb, com_tencent_mm_protocal_c_ask.mRc, com_tencent_mm_protocal_c_ask.mRd, com_tencent_mm_protocal_c_ask.mRe, com_tencent_mm_protocal_c_ask.mRf, com_tencent_mm_protocal_c_ask.mQh.lVU);
                    } catch (Exception e2) {
                        v.e("MicroMsg.NotifyReceiverDelegateImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData parseFrom e: " + e2.getMessage());
                    }
                    if (decodeSecureNotifyData == null) {
                        v.i("MicroMsg.NotifyReceiverDelegateImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data len:%d", Integer.valueOf(decodeSecureNotifyData.length));
                        nfVar = new nf();
                        nfVar.boy.data = decodeSecureNotifyData;
                        com.tencent.mm.sdk.c.a.nhr.z(nfVar);
                        return;
                    }
                    v.e("MicroMsg.NotifyReceiverDelegateImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data is null");
                    return;
                }
                decodeSecureNotifyData = null;
                if (decodeSecureNotifyData == null) {
                    v.e("MicroMsg.NotifyReceiverDelegateImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data is null");
                    return;
                }
                v.i("MicroMsg.NotifyReceiverDelegateImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data len:%d", Integer.valueOf(decodeSecureNotifyData.length));
                nfVar = new nf();
                nfVar.boy.data = decodeSecureNotifyData;
                com.tencent.mm.sdk.c.a.nhr.z(nfVar);
                return;
            case 268369923:
                NotifyService.cT("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
                if (!be.bl(bArr)) {
                    String str3 = new String(bArr);
                    nfVar = new ab();
                    nfVar.aXt.type = 4;
                    nfVar.aXt.aXv = str3;
                    com.tencent.mm.sdk.c.a.nhr.z(nfVar);
                    return;
                }
                return;
            default:
                return;
        }
        b eyVar = new ey();
        eyVar.bdO.bdP = bArr;
        com.tencent.mm.sdk.c.a.nhr.z(eyVar);
    }

    public final void a(final NotifyReceiver.a aVar, int i, int i2, String str) {
        if (i == 4 && !ak.vy().foreground) {
            switch (i2) {
                case -999999:
                    new ac().post(new Runnable(this) {
                        final /* synthetic */ j eoa;

                        {
                            this.eoa = r1;
                        }

                        public final void run() {
                            ak.hold();
                            MMAppMgr.iX(true);
                        }
                    });
                    break;
                case -311:
                case -310:
                case -205:
                case -72:
                case -9:
                case -6:
                case -4:
                case -3:
                    ak.oH().dc(aa.getContext().getString(2131233717));
                    ak.hold();
                    break;
                case -140:
                    v.e("MicroMsg.NotifyReceiverDelegateImpl", "alpha need whitelist : [%s]", str);
                    if (be.kS(str)) {
                        ak.oH().dc(aa.getContext().getString(2131233717));
                    } else {
                        ak.oH().dc(str);
                    }
                    ak.hold();
                    break;
                case -100:
                    ak.oH().dc(aa.getContext().getString(2131233716));
                    com.tencent.mm.modelsimple.d.aY(aa.getContext());
                    ak.hold();
                    break;
                case -17:
                case -16:
                    SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences("system_config_prefs", 0);
                    long j = sharedPreferences.getLong("recomended_update_ignore", -1);
                    if (j != -1 && be.ax(j) < 86400) {
                        v.d("MicroMsg.NotifyReceiverDelegateImpl", "skip update notification, last check=" + j);
                        break;
                    }
                    int i3;
                    com.tencent.mm.model.aa oH = ak.oH();
                    if (i2 == -17) {
                        i3 = 2;
                    } else {
                        i3 = 1;
                    }
                    oH.dz(i3);
                    sharedPreferences.edit().putLong("recomended_update_ignore", be.Nh()).commit();
                    g.iuh.a(405, 27, 1, true);
                    break;
                default:
                    if (i == 0 && i2 == 0) {
                        ak.oH().oz();
                        break;
                    }
            }
        }
        if (ak.uz()) {
            Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                final /* synthetic */ j eoa;

                public final boolean queueIdle() {
                    ak.vA().x(new Runnable(this.eoa, aVar) {
                        final /* synthetic */ j eoa;

                        public final void run() {
                            if (ak.uz()) {
                                ak.yW();
                                if ((be.f((Integer) c.vf().get(15, null)) == 0 ? 1 : null) != null) {
                                    v.e("MicroMsg.NotifyReceiverDelegateImpl", "not init finish , do not post sync task");
                                    return;
                                }
                                long Ni = be.Ni();
                                if (Ni - j.enZ <= 0 || Ni - j.enZ >= 10000) {
                                    long Nh;
                                    j.enZ = Ni;
                                    v.i("MicroMsg.NotifyReceiverDelegateImpl", "begin post sync task");
                                    long Nj = be.Nj();
                                    if (a.csb != null) {
                                        a.csb.yG();
                                    }
                                    v.d("MicroMsg.PostTaskCollectGoupCard", "collectGroupCard");
                                    LinkedList linkedList = new LinkedList();
                                    LinkedList linkedList2 = new LinkedList();
                                    List bvi = ak.yW().wO().bvi();
                                    if (bvi != null) {
                                        for (int i = 0; i < bvi.size(); i++) {
                                            v.d("MicroMsg.PostTaskCollectGoupCard", "groupCard " + ((String) bvi.get(i)));
                                            abq com_tencent_mm_protocal_c_abq = new abq();
                                            com_tencent_mm_protocal_c_abq.mCK = (String) bvi.get(i);
                                            linkedList.add(com_tencent_mm_protocal_c_abq);
                                        }
                                        b ifVar = new if();
                                        ifVar.bil.bim = linkedList;
                                        com.tencent.mm.sdk.c.a.nhr.z(ifVar);
                                    }
                                    Object obj = (ak.uz() && !ak.uG() && (com.tencent.mm.model.k.xQ() & 16) == 0) ? 1 : null;
                                    if (obj != null && h.qh()) {
                                        aia com_tencent_mm_protocal_c_aia;
                                        ak.yW();
                                        r vf = c.vf();
                                        int f = com.tencent.mm.platformtools.t.f((Integer) vf.get(67073, null));
                                        int f2 = com.tencent.mm.platformtools.t.f((Integer) vf.get(67074, null));
                                        int f3 = com.tencent.mm.platformtools.t.f((Integer) vf.get(67075, null));
                                        int f4 = com.tencent.mm.platformtools.t.f((Integer) vf.get(67076, null));
                                        ak.yW();
                                        au wJ = c.wJ();
                                        int bS = wJ.bS("medianote", 1);
                                        int bS2 = wJ.bS("medianote", 3);
                                        int bS3 = wJ.bS("medianote", 34);
                                        int bS4 = wJ.bS("medianote", 43);
                                        if (bS - f > 0) {
                                            aia com_tencent_mm_protocal_c_aia2 = new aia();
                                            com_tencent_mm_protocal_c_aia2.mHM = bS - f;
                                            com_tencent_mm_protocal_c_aia2.mHN = 1;
                                            vf.set(67073, Integer.valueOf(bS));
                                        }
                                        if (bS2 - f2 > 0) {
                                            com_tencent_mm_protocal_c_aia = new aia();
                                            com_tencent_mm_protocal_c_aia.mHM = bS2 - f2;
                                            com_tencent_mm_protocal_c_aia.mHN = 3;
                                            vf.set(67074, Integer.valueOf(bS2));
                                        }
                                        if (bS3 - f3 > 0) {
                                            com_tencent_mm_protocal_c_aia = new aia();
                                            com_tencent_mm_protocal_c_aia.mHM = bS3 - f3;
                                            com_tencent_mm_protocal_c_aia.mHN = 34;
                                            vf.set(67075, Integer.valueOf(bS3));
                                        }
                                        if (bS4 - f4 > 0) {
                                            com_tencent_mm_protocal_c_aia = new aia();
                                            com_tencent_mm_protocal_c_aia.mHM = bS4 - f4;
                                            com_tencent_mm_protocal_c_aia.mHN = 43;
                                            vf.set(67076, Integer.valueOf(bS4));
                                        }
                                        ak.yW();
                                        c.vf().set(66817, Long.valueOf(com.tencent.mm.platformtools.t.Nh()));
                                    }
                                    com.tencent.mm.az.a.run();
                                    l.run();
                                    bl.zQ().zR();
                                    i.run();
                                    if (com.tencent.mm.az.d.qh()) {
                                        com.tencent.mm.az.d.bro();
                                    }
                                    o.run();
                                    com.tencent.mm.booter.g.run();
                                    if (ak.uz() && !ak.uG()) {
                                        if (be.kS(com.tencent.mm.az.c.brn())) {
                                            ax.fR("ver" + com.tencent.mm.protocal.d.lWh);
                                        } else {
                                            ak.yW();
                                            if (be.ax(be.a((Long) c.vf().get(77833, null), 0)) * 1000 >= 604800000) {
                                                g.iuh.h(10719, com.tencent.mm.az.c.brj(), com.tencent.mm.az.c.brk(), com.tencent.mm.az.c.brl(), com.tencent.mm.az.c.getRomInfo(), com.tencent.mm.az.c.brm(), SQLiteDatabase.KeyEmpty, com.tencent.mm.az.c.brn());
                                                ak.yW();
                                                c.vf().set(77833, Long.valueOf(be.Nh()));
                                                v.d("MicroMsg.PostTaskHardwareInfo", "report PostTaskHardwareInfo done ");
                                            }
                                        }
                                    }
                                    if (ak.uz() && !ak.uG()) {
                                        Nh = be.Nh();
                                        ak.yW();
                                        if (be.a((Long) c.vf().get(331777, null), 0) < Nh) {
                                            ak.yW();
                                            c.vf().set(331777, Long.valueOf(Nh + 259200));
                                            com.tencent.mm.plugin.report.b.c.aKw();
                                        }
                                        com.tencent.mm.plugin.report.b.c.j(3, 0, SQLiteDatabase.KeyEmpty);
                                    }
                                    com.tencent.mm.az.b.run();
                                    if (ak.uz()) {
                                        ak.yW();
                                        Ni = be.d((Long) c.vf().get(74, null));
                                        if (10010 == q.dqj && q.dqk > 0) {
                                            Ni = be.Nh() - ((long) q.dqk);
                                            v.d("MicroMsg.PostTaskReportDataFlow", "GET DK_TEST_LAST_REPORT_DATAFLOW val:%d old:%d", Integer.valueOf(q.dqk), Long.valueOf(Ni));
                                            q.dqk = 0;
                                        }
                                        Nh = be.Nh();
                                        v.d("MicroMsg.PostTaskReportDataFlow", " now:%d old:%d diff:%d", Long.valueOf(Nh), Long.valueOf(Ni), Long.valueOf(Nh - Ni));
                                        if ((Nh - Ni) * 1000 >= 86400000) {
                                            ak.yW();
                                            c.vf().set(74, Long.valueOf(Nh));
                                            if (com.tencent.mm.modelstat.p.Km() == null) {
                                                v.e("MicroMsg.PostTaskReportDataFlow", "ERR: SubCoreStat.getNetStatStg() is null");
                                            } else {
                                                Nh = (be.Ni() / 86400000) - 1;
                                                com.tencent.mm.modelstat.j gm = com.tencent.mm.modelstat.p.Km().gm((int) Nh);
                                                if (gm == null || gm.dcz != ((int) Nh)) {
                                                    String str = "MicroMsg.PostTaskReportDataFlow";
                                                    String str2 = "ERR: NetStatInfo:%d lastDate:%d";
                                                    Object[] objArr = new Object[2];
                                                    objArr[0] = Integer.valueOf(gm == null ? -1 : gm.dcz);
                                                    objArr[1] = Long.valueOf(Nh);
                                                    v.e(str, str2, objArr);
                                                } else if (com.tencent.mm.modelstat.p.Kk() == null) {
                                                    v.e("MicroMsg.PostTaskReportDataFlow", "ERR: SubCoreStat.getMobileInfoStg() is null");
                                                } else {
                                                    f.a Kb = com.tencent.mm.modelstat.p.Kk().Kb();
                                                    if (Kb == null) {
                                                        v.w("MicroMsg.PostTaskReportDataFlow", "SubCoreStat.getMobileInfoStg().checkInfo null , give default.");
                                                        Kb = new f.a();
                                                    }
                                                    v.i("MicroMsg.PostTaskReportDataFlow", "last:%d peroid:%d [%d,%d][%d,%d][%d,%d][%d,%d] ispCode:%d subType:%d ispname:%s extra:%s", Long.valueOf(Nh), Integer.valueOf(gm.dcz), Integer.valueOf(gm.dcL), Integer.valueOf(gm.dcX), Integer.valueOf(gm.dcK), Integer.valueOf(gm.dcW), Integer.valueOf(gm.dcJ), Integer.valueOf(gm.dcV), Integer.valueOf(gm.dcI), Integer.valueOf(gm.dcU), Integer.valueOf(Kb.dct), Integer.valueOf(Kb.aYp), Kb.ispName, Kb.extraInfo);
                                                    g.iuh.h(10900, Long.valueOf((Nh * 86400000) / 1000), Integer.valueOf(gm.dcL), Integer.valueOf(gm.dcX), Integer.valueOf(gm.dcK), Integer.valueOf(gm.dcW), Integer.valueOf(gm.dcJ), Integer.valueOf(gm.dcV), Integer.valueOf(gm.dcI), Integer.valueOf(gm.dcU), Integer.valueOf(Kb.dct), Integer.valueOf(Kb.aYp), Kb.ispName, Kb.extraInfo);
                                                }
                                            }
                                        }
                                    } else {
                                        v.e("MicroMsg.PostTaskReportDataFlow", "Account is not ready");
                                    }
                                    aj.run();
                                    ak.yW();
                                    if ((com.tencent.mm.platformtools.t.ay(com.tencent.mm.platformtools.t.d((Long) c.vf().get(282881, null))) > 172800000 ? 1 : null) != null) {
                                        ak.yW();
                                        c.vf().set(282881, Long.valueOf(com.tencent.mm.platformtools.t.Ni()));
                                        com.tencent.mm.sdk.c.a.nhr.z(new lu());
                                    }
                                    if (ak.uz() && !ak.uG()) {
                                        Nh = be.Nh();
                                        ak.yW();
                                        if (be.a((Long) c.vf().get(com.tencent.mm.storage.t.a.USERINFO_SELFINFO_GETPROFILE_TIME_LONG, null), 0) < Nh) {
                                            Ni = 604800 + Nh;
                                            ak.yW();
                                            c.vf().a(com.tencent.mm.storage.t.a.USERINFO_SELFINFO_GETPROFILE_TIME_LONG, Long.valueOf(Ni));
                                            obj = com.tencent.mm.model.k.xF();
                                            if (!TextUtils.isEmpty(obj)) {
                                                ak.vy().a(new com.tencent.mm.modelsimple.q(obj), 0);
                                            }
                                        }
                                    }
                                    if (ak.uz() && !ak.uG()) {
                                        Nh = be.Nh();
                                        ak.yW();
                                        if (be.a((Long) c.vf().get(com.tencent.mm.storage.t.a.USERINFO_SHAKE_KV_STAT_BLUETOOTH_POWER_STATE_TIME_LONG, null), 0) < Nh) {
                                            Ni = (be.bul() / 1000) + 86400;
                                            ak.yW();
                                            c.vf().a(com.tencent.mm.storage.t.a.USERINFO_SHAKE_KV_STAT_BLUETOOTH_POWER_STATE_TIME_LONG, Long.valueOf(Ni));
                                            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                                            if (defaultAdapter != null) {
                                                if (defaultAdapter.getState() == 12) {
                                                    g.iuh.h(11921, Integer.valueOf(1));
                                                } else if (defaultAdapter.getState() == 10) {
                                                    g.iuh.h(11921, Integer.valueOf(0));
                                                }
                                            }
                                        }
                                    }
                                    com.tencent.mm.booter.k.run();
                                    com.tencent.mm.booter.m.run();
                                    com.tencent.mm.booter.n.run();
                                    com.tencent.mm.booter.j.run();
                                    com.tencent.mm.sdk.c.a.nhr.z(new jx());
                                    v.i("MicroMsg.NotifyReceiverDelegateImpl", "end post sync task, cost=%d, Idle done", Long.valueOf(be.az(Nj)));
                                    r3.C(3000);
                                    return;
                                }
                                v.d("MicroMsg.NotifyReceiverDelegateImpl", "sync task limit now - last : %d", Long.valueOf(Ni - j.enZ));
                            }
                        }

                        public final String toString() {
                            return super.toString() + "|doPostSyncTask";
                        }
                    });
                    return false;
                }
            });
        }
    }

    public final void Xa() {
        a.bZF.k(-1, null);
    }

    private static void Xb() {
        b pdVar = new pd();
        pdVar.bqt.bqv = true;
        com.tencent.mm.sdk.c.a.nhr.z(pdVar);
        String str = pdVar.bqu.bqx;
        if (!be.kS(str)) {
            v.v("MicroMsg.NotifyReceiverDelegateImpl", "voipinvite, exit talkroom first: " + str);
            pdVar = new pd();
            pdVar.bqt.bqw = true;
            com.tencent.mm.sdk.c.a.nhr.z(pdVar);
        }
    }

    private static void S(byte[] bArr) {
        if (bArr.length >= 8) {
            Object obj = new byte[4];
            Object obj2 = new byte[4];
            System.arraycopy(bArr, 0, obj, 0, 4);
            System.arraycopy(bArr, 4, obj2, 0, 4);
            b iqVar = new iq();
            iqVar.bjd.bje = com.tencent.mm.a.n.c(obj, 0);
            iqVar.bjd.bjf = com.tencent.mm.a.n.c(obj2, 0);
            v.i("MicroMsg.NotifyReceiverDelegateImpl", "notifyId: %d, sequence: %d", Integer.valueOf(iqVar.bjd.bje), Integer.valueOf(iqVar.bjd.bjf));
            com.tencent.mm.sdk.c.a.nhr.z(iqVar);
        }
    }

    private static void T(byte[] bArr) {
        b qiVar = new qi();
        qiVar.brC.bdn = 3;
        qiVar.brC.brw = bArr;
        com.tencent.mm.sdk.c.a.nhr.z(qiVar);
    }

    private static void U(byte[] bArr) {
        b qiVar = new qi();
        qiVar.brC.bdn = 9;
        qiVar.brC.brw = bArr;
        com.tencent.mm.sdk.c.a.nhr.z(qiVar);
    }

    private static void V(byte[] bArr) {
        b qiVar = new qi();
        qiVar.brC.bdn = 10;
        qiVar.brC.brw = bArr;
        com.tencent.mm.sdk.c.a.nhr.z(qiVar);
    }

    private static void W(byte[] bArr) {
        b hfVar = new hf();
        hfVar.bgW.bgX = bArr;
        com.tencent.mm.sdk.c.a.nhr.z(hfVar);
    }

    private static void X(byte[] bArr) {
        b qiVar = new qi();
        qiVar.brC.bdn = 6;
        qiVar.brC.brw = bArr;
        com.tencent.mm.sdk.c.a.nhr.z(qiVar);
    }

    private static void Y(byte[] bArr) {
        b qgVar = new qg();
        qgVar.brv.brw = bArr;
        com.tencent.mm.sdk.c.a.nhr.z(qgVar);
    }
}
