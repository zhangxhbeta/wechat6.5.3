package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j.aa;
import com.tencent.mm.protocal.c.aqa;
import com.tencent.mm.protocal.c.azu;
import com.tencent.mm.protocal.c.bda;
import com.tencent.mm.protocal.c.oz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class o implements aa, e {
    public boolean aSZ = false;
    public com.tencent.mm.modelgeo.a.a bYl = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ o gTk;

        {
            this.gTk = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (!z) {
                return false;
            }
            v.d("MicorMsg.TrackRefreshManager", "onGetlocatoin fLongitude:%f, fLatitude:%f, locType:%d, speed:%f", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d)});
            if (this.gTk.gTg) {
                this.gTk.gTg = false;
                this.gTk.gTi = System.currentTimeMillis();
                long j = this.gTk.gTi - this.gTk.gTh;
                v.d("MicorMsg.TrackRefreshManager", "locate time:%d", new Object[]{Long.valueOf(j)});
                g.iuh.h(10997, new Object[]{"10", "", Integer.valueOf(0), Long.valueOf(j)});
            }
            if (!(this.gTk.gSX == null || this.gTk.gSX.mZb == null)) {
                this.gTk.gSX.mZb.mhZ = (double) f2;
                this.gTk.gSX.mZb.mhY = (double) f;
            }
            return true;
        }
    };
    public boolean bhY = false;
    public c cCR;
    private int eWB;
    private int ehf = 0;
    private String gRI;
    public double gRK = -1000.0d;
    public double gRL = -1000.0d;
    private int gST = 1000;
    public i gSU;
    public HashSet<WeakReference<b>> gSV = new HashSet();
    public int gSW = 1;
    public bda gSX;
    public LocationInfo gSY = new LocationInfo((byte) 0);
    public boolean gSZ = false;
    public boolean gTa = false;
    public int gTb = this.gSW;
    public String gTc = "";
    boolean gTd = false;
    public a gTe = null;
    public int gTf = -1;
    public boolean gTg = true;
    public long gTh = 0;
    long gTi = 0;
    public com.tencent.mm.plugin.location.model.i.a gTj = new com.tencent.mm.plugin.location.model.i.a(this) {
        final /* synthetic */ o gTk;

        {
            this.gTk = r1;
        }

        public final void f(double d) {
            if (this.gTk.gSX != null) {
                this.gTk.gSX.mZb.mNp = d;
            }
        }
    };
    ac mHandler = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ o gTk;

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message != null) {
                o oVar = this.gTk;
                switch (message.what) {
                    case 1:
                        oVar.aws();
                        return;
                    default:
                        return;
                }
            }
        }
    };
    public int zoom = -1;

    public interface a {
        void awu();
    }

    public interface b {
        void a(aqa com_tencent_mm_protocal_c_aqa);

        void awv();

        void aww();

        void onError(int i, String str);
    }

    public final void stop() {
        v.i("MicorMsg.TrackRefreshManager", "stop location");
        if (this.cCR != null) {
            this.cCR.c(this.bYl);
        }
        if (this.gSU != null) {
            this.gSU.b(this.gTj);
        }
        ak.vy().b(492, this);
        ak.vy().b(490, this);
        ak.vy().b(491, this);
        this.gSW = 1;
        this.bhY = false;
        this.gTf = -1;
        m awl = l.awl();
        v.d("MicroMsg.TrackAvatarCacheService", "clearCache");
        for (String str : awl.gSS.snapshot().keySet()) {
            Bitmap bitmap = (Bitmap) awl.gSS.get(str);
            if (!(bitmap == null || bitmap.isRecycled())) {
                bitmap.recycle();
            }
        }
        awl.gSS.trimToSize(-1);
    }

    public final boolean awn() {
        return awt() && this.gSZ;
    }

    public final void mp(int i) {
        v.i("MicorMsg.TrackRefreshManager", "track endTrack");
        if (awt()) {
            String str = this.gRI;
            v.d("MicorMsg.TrackRefreshManager", "exitTrack, scene=%d", new Object[]{Integer.valueOf(i)});
            com.tencent.mm.plugin.location.model.a.a aVar = new com.tencent.mm.plugin.location.model.a.a(str);
            ((oz) aVar.cif.czk.czs).maG = i;
            ak.vy().a(aVar, 0);
            this.gRI = "";
        }
        if (!be.kS(this.gTc)) {
            com.tencent.mm.plugin.location.a.a vI = l.awj().vI(this.gTc);
            if (vI != null) {
                vI.biC.remove(k.xF());
                l.awj().a(this.gTc, vI.biC, vI.latitude, vI.longitude, vI.gRG, null, null);
            }
        }
        l.awj().vK("");
        this.gRI = "";
        this.gTc = "";
        this.gSZ = false;
        this.gTa = false;
        this.gRK = -1000.0d;
        this.gRL = -1000.0d;
        this.zoom = -1;
        this.gTf = -1;
    }

    public final void awo() {
        v.d("MicorMsg.TrackRefreshManager", "resume refresh");
        this.gTd = false;
        v.d("MicorMsg.TrackRefreshManager", "trigerRefresh");
        if (awt()) {
            v.d("MicorMsg.TrackRefreshManager", "trigerRefresh, joinSuccess");
            this.cCR = c.FY();
            this.cCR.a(this.bYl);
            if (this.gSU == null) {
                this.gSU = l.awk();
            }
            this.gSU.a(this.gTj);
            aws();
        }
    }

    public final String awp() {
        return this.gTc;
    }

    public final List<String> awq() {
        return l.awj().vH(this.gTc);
    }

    public final void awr() {
        if (this.gSW == 1) {
            this.gSW = 3;
        } else if (this.gSW == 3) {
            this.gSW = 2;
        }
    }

    public final void aws() {
        boolean z = true;
        String str;
        if (!this.bhY || !this.gSZ || this.gSY == null) {
            str = "MicorMsg.TrackRefreshManager";
            StringBuilder append = new StringBuilder("error to exit refresh isStart: ").append(this.bhY).append(" isShared: ").append(this.gSZ).append(" ");
            if (this.gSY != null) {
                z = false;
            }
            v.e(str, append.append(z).toString());
        } else if (this.gSX == null || this.gSX.mZb.mhZ == -1000.0d || this.gSX.mZb.mhY == -1000.0d) {
            v.e("MicorMsg.TrackRefreshManager", "error to get my location ");
            this.mHandler.sendEmptyMessageDelayed(1, (long) this.gST);
        } else {
            String xF = k.xF();
            azu com_tencent_mm_protocal_c_azu = new azu();
            com_tencent_mm_protocal_c_azu.mMa = this.gSY.gRM;
            com_tencent_mm_protocal_c_azu.mhZ = this.gSY.gRK;
            com_tencent_mm_protocal_c_azu.mhY = this.gSY.gRL;
            com_tencent_mm_protocal_c_azu.gkB = xF;
            this.gSX.mdw = xF;
            this.gSX.mZb.mNp = l.awk().awb();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("refreshLoopImpl, [trackRoomId:" + this.gRI + "]");
            switch (this.gSW) {
                case 0:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomUpload ");
                    break;
                case 1:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomDownload ");
                    break;
                case 2:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomUploadAndDownLoad ");
                    break;
                case 3:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomFirstUpload ");
                    stringBuffer.append("[ trackItem " + com_tencent_mm_protocal_c_azu.mhZ + " " + com_tencent_mm_protocal_c_azu.mhY + " ]");
                    break;
            }
            stringBuffer.append("[ mMyPosiItem " + this.gSX.mZb.mhZ + " " + this.gSX.mZb.mhY + " " + this.gSX.mZb.mNp + " ]");
            v.d("MicorMsg.TrackRefreshManager", stringBuffer.toString());
            str = this.gRI;
            int i = this.gSW;
            bda com_tencent_mm_protocal_c_bda = this.gSX;
            int i2 = this.eWB + 1;
            this.eWB = i2;
            ak.vy().a(new com.tencent.mm.plugin.location.model.a.c(str, i, com_tencent_mm_protocal_c_bda, i2, com_tencent_mm_protocal_c_azu), 0);
        }
    }

    public final boolean awt() {
        return !be.kS(this.gRI);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.d("MicorMsg.TrackRefreshManager", "onSceneEnd scene type %d errType %d errCode %d", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        WeakReference weakReference;
        if (kVar.getType() == 490) {
            Iterator it;
            if (i2 == 0 || i2 >= 1000) {
                this.gRI = ((com.tencent.mm.plugin.location.model.a.b) kVar).gRI;
                l.awj().vK(this.gRI);
                if (awt()) {
                    v.i("MicorMsg.TrackRefreshManager", "join sucess %s", new Object[]{this.gRI});
                    LinkedList vH = com.tencent.mm.pluginsdk.j.a.lxQ.vH(this.gTc);
                    vH.add(k.xF());
                    if (this.gSY != null) {
                        com.tencent.mm.pluginsdk.j.a.lxQ.a(this.gTc, vH, this.gSY.gRK, this.gSY.gRL, this.gSY.gRM, "", "");
                    } else {
                        com.tencent.mm.pluginsdk.j.a.lxQ.a(this.gTc, vH, -1000.0d, -1000.0d, "", "", "");
                    }
                    if (this.gSV != null) {
                        it = this.gSV.iterator();
                        while (it.hasNext()) {
                            weakReference = (WeakReference) it.next();
                            if (!(weakReference == null || weakReference.get() == null)) {
                                ((b) weakReference.get()).awv();
                            }
                        }
                    }
                    aws();
                    return;
                }
                return;
            }
            if (i2 == 17 && this.gSV != null) {
                it = this.gSV.iterator();
                while (it.hasNext()) {
                    weakReference = (WeakReference) it.next();
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((b) weakReference.get()).aww();
                    }
                }
            }
            if (this.gSV != null) {
                Iterator it2 = this.gSV.iterator();
                while (it2.hasNext()) {
                    weakReference = (WeakReference) it2.next();
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((b) weakReference.get()).onError(0, ((com.tencent.mm.plugin.location.model.a.b) kVar).gTq);
                    }
                }
            }
        } else if (i == 0 && i2 == 0) {
            if (kVar.getType() == 492) {
                r0 = ((com.tencent.mm.plugin.location.model.a.c) kVar).gTu;
                if (!(r0 == null || r0.mQl == null)) {
                    if (r0.mQl.mcj == 12) {
                        this.aSZ = true;
                        if (this.gTe != null) {
                            this.gTe.awu();
                        }
                    } else {
                        this.aSZ = false;
                    }
                    v.d("MicorMsg.TrackRefreshManager", "refresh track room, timeout = %b, ret = %d", new Object[]{Boolean.valueOf(this.aSZ), Integer.valueOf(r0.mQl.mcj)});
                }
                if (this.ehf > 0) {
                    g.iuh.h(10997, new Object[]{"9", "", Integer.valueOf(this.ehf), Integer.valueOf(0)});
                }
                this.ehf = 0;
                this.gST = ((com.tencent.mm.plugin.location.model.a.c) kVar).gTr;
                int i3 = ((com.tencent.mm.plugin.location.model.a.c) kVar).gTv;
                if (this.gSV != null && (i3 == 2 || i3 == 1 || i3 == 3)) {
                    Iterator it3 = this.gSV.iterator();
                    while (it3.hasNext()) {
                        weakReference = (WeakReference) it3.next();
                        if (!(weakReference == null || weakReference.get() == null)) {
                            ((b) weakReference.get()).a(((com.tencent.mm.plugin.location.model.a.c) kVar).gTu);
                        }
                    }
                }
                if (!(this.gSW == 1)) {
                    awr();
                }
                this.mHandler.removeMessages(1);
                if (awt() && !this.gTd && !this.aSZ) {
                    this.mHandler.sendEmptyMessageDelayed(1, (long) this.gST);
                }
            } else if (kVar.getType() == 491) {
                l.awj().vK("");
            }
        } else if (kVar.getType() == 492) {
            this.ehf++;
            this.mHandler.removeMessages(1);
            if (this.ehf >= 10) {
                this.mHandler.removeMessages(1);
                if (this.gSV != null) {
                    Iterator it4 = this.gSV.iterator();
                    while (it4.hasNext()) {
                        weakReference = (WeakReference) it4.next();
                        if (!(weakReference == null || weakReference.get() == null)) {
                            ((b) weakReference.get()).onError(1, ((com.tencent.mm.plugin.location.model.a.c) kVar).gTq);
                        }
                    }
                }
            } else if (awt() && !this.gTd) {
                r0 = ((com.tencent.mm.plugin.location.model.a.c) kVar).gTu;
                if (!(r0 == null || r0.mQl == null)) {
                    if (r0.mQl.mcj == 12) {
                        this.aSZ = true;
                        if (this.gTe != null) {
                            this.gTe.awu();
                        }
                    } else {
                        this.aSZ = false;
                    }
                    v.d("MicorMsg.TrackRefreshManager", "refresh track room, in error status, timeout = %b, ret = %d", new Object[]{Boolean.valueOf(this.aSZ), Integer.valueOf(r0.mQl.mcj)});
                }
                if (!this.aSZ) {
                    this.mHandler.sendEmptyMessageDelayed(1, (long) this.gST);
                }
            }
        }
    }
}
