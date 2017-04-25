package com.tencent.mm.at;

import com.tencent.mm.c.b.c;
import com.tencent.mm.c.c.d;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.smtt.sdk.WebView;
import java.io.File;

public final class f implements e {
    public static int aVI = 5000;
    private static final String dkj = (t.cng + "voice_temp.spx");
    private c aTF;
    private com.tencent.mm.c.b.c.a aUn = new com.tencent.mm.c.b.c.a(this) {
        final /* synthetic */ f dkA;
        short[] dkz;

        {
            this.dkA = r1;
        }

        public final void d(byte[] bArr, int i) {
            int i2;
            v.d("MicroMsg.SceneVoiceInputAddr", "OnRecPcmDataReady len: %s time: %s", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
            if (this.dkz == null || this.dkz.length < i / 2) {
                this.dkz = new short[(i / 2)];
            }
            for (i2 = 0; i2 < i / 2; i2++) {
                this.dkz[i2] = (short) ((bArr[i2 * 2] & WebView.NORMAL_MODE_ALPHA) | (bArr[(i2 * 2) + 1] << 8));
            }
            f.a(this.dkA, this.dkz, i / 2);
            if (this.dkA.dkx != null) {
                com.tencent.mm.at.a.c d = this.dkA.dkx;
                Object obj = this.dkz;
                int i3 = i / 2;
                v.d(com.tencent.mm.at.a.c.TAG, "input() called with: voice = [%s], length = [%s]", obj, Integer.valueOf(i3));
                if (obj != null && obj.length != 0 && i3 > 0 && i3 <= obj.length) {
                    if (d.dkZ) {
                        v.i(com.tencent.mm.at.a.c.TAG, "VoiceSilentDetectAPI is released.");
                        return;
                    }
                    int i4;
                    int i5;
                    com.qq.wx.voice.vad.a aVar = d.dlb;
                    if (aVar.aHg == 0) {
                        i2 = 1;
                    } else {
                        if (com.qq.wx.voice.vad.a.DEBUG) {
                            System.out.println("EVad AddData handle = " + aVar.aHg);
                        }
                        i2 = aVar.aHh.AddData(aVar.aHg, obj, i3);
                    }
                    v.d(com.tencent.mm.at.a.c.TAG, "currState = %s,prevState = %s,directFirstStart = %s,directTempState = %s", Integer.valueOf(i2), Integer.valueOf(d.dkU), Boolean.valueOf(d.dkV), Boolean.valueOf(d.dkW));
                    if (d.dkV) {
                        if (d.dkW) {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (d.dlc != null) {
                                d.dlc.LP();
                            }
                            d.dkX = currentTimeMillis;
                            if (!d.dkZ) {
                                i4 = d.dla.dkR;
                                int length = d.dld.length;
                                while (i4 > 0) {
                                    if (length > i4) {
                                        i5 = i4;
                                    } else {
                                        i5 = length;
                                    }
                                    d.dla.b(d.dld, i5);
                                    i4 -= i5;
                                    if (d.dlc != null) {
                                        d.dlc.a(d.dld, i5);
                                    }
                                }
                                d.dkW = false;
                                d.handler.removeMessages(0);
                                d.handler.sendEmptyMessageDelayed(0, (long) d.dkY);
                            } else {
                                return;
                            }
                        }
                        if (d.dkU == 3 && i2 == 2) {
                            d.dkV = false;
                        }
                        if (!(d.dkU == 3 && i2 == 3)) {
                            d.handler.removeMessages(0);
                            d.handler.sendEmptyMessageDelayed(0, (long) d.dkY);
                        }
                        d.dkT = false;
                        d.dkU = i2;
                    } else if (d.dkU == 3 && i2 == 2) {
                        d.dkU = i2;
                        d.handler.removeMessages(0);
                        d.handler.sendEmptyMessageDelayed(0, (long) d.dkY);
                        r0 = System.currentTimeMillis();
                        if (d.dlc != null) {
                            d.dlc.LP();
                        }
                        d.dkX = r0;
                        if (!d.dkZ) {
                            i5 = d.dla.dkR;
                            i4 = d.dld.length;
                            while (i5 > 0) {
                                if (i4 > i5) {
                                    i2 = i5;
                                } else {
                                    i2 = i4;
                                }
                                d.dla.b(d.dld, i2);
                                i5 -= i2;
                                if (d.dlc != null) {
                                    d.dlc.a(d.dld, i2);
                                }
                            }
                            d.dkT = false;
                        } else {
                            return;
                        }
                    } else if (d.dkU == 2 && i2 == 3) {
                        d.dkU = i2;
                        d.dkT = true;
                        d.handler.removeMessages(0);
                        d.handler.sendEmptyMessageDelayed(0, (long) d.dkY);
                        r0 = System.currentTimeMillis();
                        if (d.dlc != null) {
                            d.dlc.LO();
                        }
                        d.dkX = r0;
                        if (d.dkZ) {
                            return;
                        }
                    } else if (d.dkU == 3 && i2 == 3) {
                        d.dkT = true;
                    } else if (d.dkU == 2 && i2 == 2) {
                        d.dkT = false;
                        d.handler.removeMessages(0);
                        d.handler.sendEmptyMessageDelayed(0, (long) d.dkY);
                    }
                    if (!d.dkZ) {
                        com.tencent.mm.at.a.a aVar2 = d.dla;
                        if (obj.length >= 0) {
                            if (i3 > obj.length + 0) {
                                i5 = obj.length + 0;
                            } else {
                                i5 = i3;
                            }
                            if (i5 != 0) {
                                i2 = aVar2.dkS.length - aVar2.dkR;
                                if (i5 > i2) {
                                    i2 = i5 - i2;
                                    if (i2 != 0) {
                                        if (i2 >= aVar2.dkR) {
                                            i2 = aVar2.dkR;
                                        }
                                        if (i2 <= aVar2.dkS.length - aVar2.dkP) {
                                            aVar2.dkP += i2;
                                            if (aVar2.dkP >= aVar2.dkS.length) {
                                                aVar2.dkP = 0;
                                            }
                                        } else {
                                            aVar2.dkP = i2 - (aVar2.dkS.length - aVar2.dkP);
                                        }
                                        aVar2.dkR -= i2;
                                    }
                                }
                                if (i5 > aVar2.dkS.length) {
                                    i5 = (i5 - aVar2.dkS.length) + 0;
                                    i2 = aVar2.dkS.length;
                                } else {
                                    i2 = i5;
                                    i5 = 0;
                                }
                                if (i2 <= aVar2.dkS.length - aVar2.dkQ) {
                                    System.arraycopy(obj, i5, aVar2.dkS, aVar2.dkQ, i2);
                                    aVar2.dkQ += i2;
                                    if (aVar2.dkQ >= aVar2.dkS.length) {
                                        aVar2.dkQ = 0;
                                    }
                                } else {
                                    i4 = aVar2.dkS.length - aVar2.dkQ;
                                    System.arraycopy(obj, i5, aVar2.dkS, aVar2.dkQ, i4);
                                    int i6 = i2 - i4;
                                    System.arraycopy(obj, i5 + i4, aVar2.dkS, 0, i6);
                                    aVar2.dkQ = i6;
                                }
                                aVar2.dkR = i2 + aVar2.dkR;
                            }
                        }
                        v.d(com.tencent.mm.at.a.c.TAG, "isSilent %s", Boolean.valueOf(d.dkT));
                        if (!d.dkT && d.dlc != null) {
                            d.dlc.a(obj, i3);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            this.dkA.aW(9, -1);
            v.e("MicroMsg.SceneVoiceInputAddr", "mVoiceSilentDetectAPI is null");
        }

        public final void as(int i, int i2) {
            v.e("MicroMsg.SceneVoiceInputAddr", "onRecError state = %s detailState = %s", Integer.valueOf(i), Integer.valueOf(i2));
            this.dkA.aW(10, -1);
        }
    };
    public int dkl = 0;
    private int dkm = 0;
    private boolean dkn = false;
    private com.tencent.mm.c.c.a dkr;
    private a dkt = null;
    private boolean dkv = false;
    private b dkw = null;
    private com.tencent.mm.at.a.c dkx;
    private com.tencent.mm.at.a.c.a dky = new com.tencent.mm.at.a.c.a(this) {
        final /* synthetic */ f dkA;
        byte[] dkB;

        {
            this.dkA = r1;
        }

        public final void a(short[] sArr, int i) {
            if (sArr != null) {
                int i2;
                if (this.dkB == null || this.dkB.length < i * 2) {
                    this.dkB = new byte[(i * 2)];
                }
                for (i2 = 0; i2 < i; i2++) {
                    this.dkB[i2 * 2] = (byte) (sArr[i2] & WebView.NORMAL_MODE_ALPHA);
                    this.dkB[(i2 * 2) + 1] = (byte) ((sArr[i2] & 65280) >> 8);
                }
                if (this.dkA.dkr != null) {
                    i2 = this.dkA.dkr.a(new com.tencent.mm.c.b.g.a(this.dkB, i * 2), 0);
                } else {
                    i2 = -1;
                }
                if (-1 == i2) {
                    this.dkA.aW(4, -1);
                    v.e("MicroMsg.SceneVoiceInputAddr", "write to file failed");
                    return;
                }
                f.a(this.dkA, i2);
                if (!this.dkA.dkv && this.dkA.dkm > 200 && !this.dkA.dkn) {
                    ak.vA().x(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 dkC;

                        {
                            this.dkC = r1;
                        }

                        public final void run() {
                            v.i("MicroMsg.SceneVoiceInputAddr", "run NetSceneNewVoiceInput mWroteBytesCnt %s time %s", Integer.valueOf(this.dkC.dkA.dkm), Long.valueOf(System.currentTimeMillis()));
                            if (this.dkC.dkA.dkv || this.dkC.dkA.dkt == null || this.dkC.dkA.dkm == 0) {
                                v.w("MicroMsg.SceneVoiceInputAddr", "WorkerThread too busy can not do work");
                                return;
                            }
                            ak.vy().a(235, this.dkC.dkA);
                            if (!((b) this.dkC.dkA.dkt).LJ() || !ak.vy().a(this.dkC.dkA.dkt, 0)) {
                                this.dkC.dkA.aW(13, 131);
                            }
                        }
                    });
                    this.dkA.dkn = true;
                }
            }
        }

        public final void LO() {
            v.i("MicroMsg.SceneVoiceInputAddr", "onSpeakToSilent");
            if (this.dkA.dkt instanceof b) {
                try {
                    ((b) this.dkA.dkt).gy(com.tencent.mm.a.e.aQ(f.dkj));
                } catch (Throwable e) {
                    v.a("MicroMsg.SceneVoiceInputAddr", e, "cutShortSentence error", new Object[0]);
                    this.dkA.aW(6, -1);
                }
            }
        }

        public final void LP() {
            v.i("MicroMsg.SceneVoiceInputAddr", "onSilentToSpeak");
            if (this.dkA.dkt instanceof b) {
                try {
                    g gVar = ((b) this.dkA.dkt).djT;
                    v.i("MicroMsg.ShortSentenceContainer", "createNewShortSentence");
                    gVar.dkF.writeLock().lock();
                    com.tencent.mm.at.g.a aVar = new com.tencent.mm.at.g.a(gVar);
                    gVar.dkE.put(aVar.dkH, aVar);
                    gVar.dkF.writeLock().unlock();
                } catch (Throwable e) {
                    v.a("MicroMsg.SceneVoiceInputAddr", e, "createShortSentence error", new Object[0]);
                    this.dkA.aW(6, -1);
                }
            }
        }

        public final void LQ() {
            v.i("MicroMsg.SceneVoiceInputAddr", "Silent enough to finish time %s", Long.valueOf(System.currentTimeMillis()));
            this.dkA.bk(false);
        }
    };

    private class a implements Runnable {
        final /* synthetic */ f dkA;

        private a(f fVar) {
            this.dkA = fVar;
        }

        public final void run() {
            synchronized (this.dkA) {
                v.i("MicroMsg.SceneVoiceInputAddr", "initDeviceInLock time %s", Long.valueOf(System.currentTimeMillis()));
                long nanoTime = System.nanoTime() & 4294967295L;
                if (nanoTime < 0) {
                    nanoTime = Math.abs(nanoTime);
                }
                String valueOf = String.valueOf(nanoTime);
                try {
                    File file = new File(f.dkj);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    file = new File(f.dkj);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    file.delete();
                } catch (Throwable e) {
                    v.a("MicroMsg.SceneVoiceInputAddr", e, "delete file failed", new Object[0]);
                }
                this.dkA.aTF = new c(16000, 3);
                this.dkA.aTF.aUc = -19;
                this.dkA.aTF.al(false);
                this.dkA.dkr = new d();
                if (this.dkA.dkr.bA(f.dkj)) {
                    if (p.ceJ.cdA > 0) {
                        this.dkA.aTF.r(p.ceJ.cdA, true);
                    } else {
                        this.dkA.aTF.r(5, false);
                    }
                    this.dkA.aTF.cL(50);
                    this.dkA.aTF.am(false);
                    try {
                        this.dkA.dkx = new com.tencent.mm.at.a.c();
                        this.dkA.dkx.dlc = this.dkA.dky;
                        this.dkA.dkt = new b(f.dkj, valueOf);
                        this.dkA.aTF.aUn = this.dkA.aUn;
                        if (!this.dkA.aTF.pj()) {
                            v.e("MicroMsg.SceneVoiceInputAddr", "start record failed");
                            this.dkA.aW(8, -1);
                        }
                    } catch (Throwable e2) {
                        v.a("MicroMsg.SceneVoiceInputAddr", e2, "init VoiceDetectAPI failed", new Object[0]);
                        this.dkA.aW(7, -1);
                    }
                } else {
                    v.e("MicroMsg.SceneVoiceInputAddr", "init speex writer failed");
                    this.dkA.dkr.pv();
                    this.dkA.dkr = null;
                    this.dkA.aW(5, -1);
                }
            }
        }
    }

    public interface b {
        void LM();

        void LR();

        void f(String[] strArr);

        void u(int i, int i2, int i3);
    }

    static /* synthetic */ int a(f fVar, int i) {
        int i2 = fVar.dkm + i;
        fVar.dkm = i2;
        return i2;
    }

    static /* synthetic */ void a(f fVar, short[] sArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            short s = sArr[i2];
            if (s > fVar.dkl) {
                fVar.dkl = s;
            }
        }
        v.d("MicroMsg.SceneVoiceInputAddr", "setCurAmplitude mMaxAmpSinceLastCall = %s", Integer.valueOf(fVar.dkl));
    }

    public f(b bVar) {
        this.dkw = bVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        String[] LH = ((a) kVar).LH();
        String str2 = "MicroMsg.SceneVoiceInputAddr";
        String str3 = "onSceneEnd time %s errType:%s errCode:%s list:%s scene.hashCode():%s,this.hashCode():%s";
        Object[] objArr = new Object[6];
        objArr[0] = Long.valueOf(System.currentTimeMillis());
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(LH == null ? -1 : LH.length);
        objArr[4] = Integer.valueOf(kVar.hashCode());
        objArr[5] = Integer.valueOf(this.dkt == null ? -1 : this.dkt.hashCode());
        v.d(str2, str3, objArr);
        if (kVar.hashCode() != this.dkt.hashCode()) {
            v.d("MicroMsg.SceneVoiceInputAddr", "onSceneEnd scene.hashCode() != mVoiceRecogScene.hashCode()");
        } else if (this.dkw == null) {
        } else {
            if (i2 == 0 && i == 0) {
                this.dkw.f(LH);
                if ((kVar instanceof b) && this.dkm == 0 && ((b) kVar).djT.LU()) {
                    this.dkw.LR();
                    bl(false);
                    return;
                }
                return;
            }
            if (str != null && str.equalsIgnoreCase("SecurityCheckError")) {
                this.dkw.u(13, 132, -1);
            } else if (str == null || !str.equalsIgnoreCase("ReadFileLengthError")) {
                this.dkw.u(11, i, i2);
            } else {
                this.dkw.u(13, 133, -1);
            }
            bl(false);
        }
    }

    public final void aW(int i, int i2) {
        v.i("MicroMsg.SceneVoiceInputAddr", "error localCode = %s,errType = %s,errCode = %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(-1));
        if (this.dkw != null) {
            this.dkw.u(i, i2, -1);
        }
        e(false, true);
    }

    public final void bk(boolean z) {
        v.i("MicroMsg.SceneVoiceInputAddr", "stop fromUI = %s", Boolean.valueOf(z));
        if (!(z || this.dkw == null)) {
            this.dkw.LM();
        }
        e(true, true);
    }

    public final void bl(boolean z) {
        v.i("MicroMsg.SceneVoiceInputAddr", "cancel fromUI = %s", Boolean.valueOf(z));
        this.dkw = null;
        e(false, z);
    }

    private void e(boolean z, boolean z2) {
        v.i("MicroMsg.SceneVoiceInputAddr", "reset keepNetScene = %s,sendLastScene = %s", Boolean.valueOf(z), Boolean.valueOf(z2));
        synchronized (this) {
            this.dkv = true;
            if (this.aTF != null) {
                this.aTF.pb();
                this.aTF = null;
            }
            if (this.dkr != null) {
                this.dkr.pv();
                this.dkr = null;
            }
            if (this.dkx != null) {
                try {
                    com.tencent.mm.at.a.c cVar = this.dkx;
                    v.d(com.tencent.mm.at.a.c.TAG, "released");
                    cVar.dkZ = true;
                    cVar.dkV = false;
                    cVar.dkW = false;
                    if (cVar.dlb != null) {
                        int i;
                        com.qq.wx.voice.vad.a aVar = cVar.dlb;
                        if (aVar.aHg == 0) {
                            i = 1;
                        } else {
                            if (com.qq.wx.voice.vad.a.DEBUG) {
                                System.out.println("EVad Release handle = " + aVar.aHg);
                            }
                            i = aVar.aHh.Release(aVar.aHg);
                        }
                        if (i == 1) {
                            throw new com.tencent.mm.at.a.b();
                        }
                        cVar.dlb = null;
                    }
                    cVar.dla = null;
                    cVar.dld = null;
                    if (cVar.handler != null) {
                        cVar.handler.removeMessages(0);
                        cVar.handler = null;
                    }
                    cVar.dlc = null;
                    this.dkx = null;
                } catch (Throwable e) {
                    v.a("MicroMsg.SceneVoiceInputAddr", e, "mVoiceSilentDetectAPI.release error", new Object[0]);
                }
            }
            this.dkm = 0;
            if (this.dkt != null && (this.dkt instanceof b)) {
                this.dkt.LG();
                try {
                    ((b) this.dkt).gy(com.tencent.mm.a.e.aQ(dkj));
                } catch (Throwable e2) {
                    v.a("MicroMsg.SceneVoiceInputAddr", e2, "reset cutShortSentence error", new Object[0]);
                    aW(6, -1);
                }
            }
            if (z) {
                return;
            }
            if (this.dkt != null && (this.dkt instanceof b)) {
                v.i("MicroMsg.SceneVoiceInputAddr", "reset call stop() sendLastScene:%s", Boolean.valueOf(z2));
                if (z2) {
                    ((b) this.dkt).LK();
                }
                ak.vy().b(235, (e) this);
            }
            this.dkt = null;
            this.dkn = false;
        }
    }
}
