package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.as.a.f;
import com.tencent.mm.as.p;
import com.tencent.mm.h.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;

public final class k {
    String bhO;
    int dAz;
    String filename;
    int icJ = 0;
    int jHY = 0;
    HashMap<String, Integer> jHZ = new HashMap();
    f jIa;
    int jIc;
    int jId;
    int jIe;
    boolean jIf;
    int jIg = 0;
    private int jIh;
    boolean jIi = false;
    private int jIj = 0;
    long jIk;
    long jIl;
    private long jIm;
    private long jIn;
    private int jIo;
    String mediaId;
    i oDs;
    int oDt;
    int oDu;
    String oDv;
    a oDw;

    private static class a {
        int jIr;
        int jIs;
        int jIt;
        int oDy;

        private a() {
        }
    }

    public k(i iVar) {
        int i;
        this.oDs = iVar;
        reset();
        this.jIa = new f();
        this.oDw = new a();
        String value = j.sU().getValue("AndroidOnlineVideoArgs");
        if (!be.kS(value)) {
            v.i("MicroMsg.OnlineVideoUIHelper", "online video config : " + value);
            String[] split = value.split(";");
            if (split != null && split.length >= 4) {
                this.oDw.jIr = be.getInt(split[0], 5);
                this.oDw.jIs = be.getInt(split[1], 1);
                this.oDw.jIt = be.getInt(split[2], 75);
                this.oDw.oDy = be.getInt(split[3], 1) * 1048576;
                i = 1;
                if (i == 0) {
                    this.oDw.jIr = 5;
                    this.oDw.jIs = 1;
                    this.oDw.jIt = 75;
                    this.oDw.oDy = 1048576;
                }
                v.i("MicroMsg.OnlineVideoUIHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", Integer.valueOf(this.oDw.jIr), Integer.valueOf(this.oDw.jIs), Integer.valueOf(this.oDw.jIt), Integer.valueOf(this.oDw.oDy));
                this.jIh = this.oDw.jIr;
            }
        }
        boolean z = false;
        if (i == 0) {
            this.oDw.jIr = 5;
            this.oDw.jIs = 1;
            this.oDw.jIt = 75;
            this.oDw.oDy = 1048576;
        }
        v.i("MicroMsg.OnlineVideoUIHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", Integer.valueOf(this.oDw.jIr), Integer.valueOf(this.oDw.jIs), Integer.valueOf(this.oDw.jIt), Integer.valueOf(this.oDw.oDy));
        this.jIh = this.oDw.jIr;
    }

    public final void reset() {
        String str = SQLiteDatabase.KeyEmpty;
        this.mediaId = str;
        this.filename = str;
        this.jIe = -1;
        this.jId = 0;
        this.dAz = 0;
        this.jIg = 0;
        this.jIc = 0;
        this.jIj = 0;
        this.jHY = 0;
        this.icJ = 0;
        this.jIf = false;
        this.jIi = false;
        this.jHZ.clear();
        if (this.oDw != null) {
            this.jIh = this.oDw.jIr;
        }
        this.jIl = 0;
        this.jIk = 0;
        this.jIo = 0;
        this.jIn = 0;
        this.jIm = 0;
        str = SQLiteDatabase.KeyEmpty;
        this.oDv = str;
        this.bhO = str;
    }

    public final void bHg() {
        v.i("MicroMsg.OnlineVideoUIHelper", "stop stream download video.");
        if (this.icJ == 3) {
            int i = 1;
        } else {
            boolean z = false;
        }
        this.icJ = 0;
        if (!be.kS(this.mediaId)) {
            if (this.jId >= this.oDw.jIt && r0 == 0) {
                v.i("MicroMsg.OnlineVideoUIHelper", "start complete video, downloaded (%d) more than config (%d).", Integer.valueOf(this.jId), Integer.valueOf(this.oDw.jIt));
                p.F(this.filename, 2);
                g.iuh.a(354, 10, 1, false);
            }
            com.tencent.mm.modelcdntran.g.DY().b(this.mediaId, bHi());
            g.iuh.a(354, 2, 1, false);
        }
    }

    public final boolean alC() {
        return !be.kS(this.mediaId) && this.icJ == 1;
    }

    public final boolean BW(String str) {
        return be.dC(str, this.mediaId);
    }

    final void aWg() {
        v.i("MicroMsg.OnlineVideoUIHelper", "play offline video %s ", this.filename);
        ad.o(new Runnable(this) {
            final /* synthetic */ k oDx;

            {
                this.oDx = r1;
            }

            public final void run() {
                if (this.oDx.oDs != null) {
                    this.oDx.oDs.aq(this.oDx.filename, false);
                }
            }
        });
    }

    public final boolean xQ(int i) {
        boolean z;
        switch (this.icJ) {
            case 1:
                this.jHY = 2;
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                a(i, pInt, pInt2);
                if (!l(pInt.value, pInt2.value, true)) {
                    this.jIe = i;
                    this.jIf = true;
                    this.oDs.aVY();
                    z = false;
                    break;
                }
                this.jIe = -1;
                this.jIf = false;
                this.jIg = pInt2.value;
                this.jHY = 3;
                break;
            case 3:
                break;
        }
        this.oDs.py(i);
        z = true;
        v.i("MicroMsg.OnlineVideoUIHelper", "seek video time %d, download status %d playStatus %d", Integer.valueOf(i), Integer.valueOf(this.icJ), Integer.valueOf(this.jHY));
        g.iuh.a(354, 4, 1, false);
        return z;
    }

    public final boolean qN(int i) {
        int i2;
        if (this.jIe != -1) {
            i2 = this.jIe;
        } else {
            i2 = i;
        }
        v.i("MicroMsg.OnlineVideoUIHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d downloadStatus %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.jIg), Integer.valueOf(this.jIc), Integer.valueOf(this.icJ));
        switch (this.icJ) {
            case 1:
                boolean z;
                if (!qO(i2)) {
                    this.jIf = true;
                    if (this.jIg > 0) {
                        v.i("MicroMsg.OnlineVideoUIHelper", "pause by load data pauseByLoadDataCount : " + this.jIj + " playStatus : " + this.jHY);
                        this.jIn = be.Ni();
                        if (this.jHY != 2) {
                            this.jIh += this.oDw.jIr;
                            this.jIh = Math.min(this.jIh, 60);
                            this.jIj++;
                            this.jHY = 4;
                        }
                        this.oDs.aVY();
                    } else if (this.jIe == -1) {
                        this.jHY = 1;
                    } else {
                        this.jHY = 2;
                    }
                    z = false;
                } else if (this.jIi) {
                    this.oDs.Pc(this.filename);
                    if (this.jIf) {
                        if (this.jIj == 0 && this.jIm == 0) {
                            this.jIm = be.Ni();
                        } else if (this.jIn > 0) {
                            this.jIo = (int) (((long) this.jIo) + be.ay(this.jIn));
                        }
                        v.i("MicroMsg.OnlineVideoUIHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d", Integer.valueOf(this.jIj), Integer.valueOf(this.jIo));
                        if (this.jIe != -1) {
                            this.oDs.py(this.jIe);
                            this.jIe = -1;
                        } else {
                            this.oDs.aVX();
                        }
                        this.jIf = false;
                    }
                    this.jHY = 3;
                    z = true;
                } else {
                    this.oDs.aq(this.filename, true);
                    this.jIi = true;
                    z = true;
                }
                this.oDs.xP(i2);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                if (!a(i2, pInt, pInt2)) {
                    v.d("MicroMsg.OnlineVideoUIHelper", "can not calc download.");
                } else if (l(pInt.value, pInt2.value, false)) {
                    this.jIg = pInt2.value;
                    return true;
                }
                return z;
            case 3:
                if (this.jIf) {
                    if (this.jIe != -1) {
                        this.oDs.py(this.jIe);
                        this.jIe = -1;
                    } else {
                        this.oDs.aVX();
                    }
                    this.jIf = false;
                }
                this.oDs.xP(i2);
                return true;
            default:
                return true;
        }
    }

    public final boolean qO(int i) {
        boolean isVideoDataAvailable;
        Throwable e;
        if (this.icJ == 3) {
            return true;
        }
        if (this.jIg - i <= 2 && this.jIg < this.jIc) {
            return false;
        }
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            this.jIa.a(i, i + 2, pInt, pInt2);
            isVideoDataAvailable = com.tencent.mm.modelcdntran.g.DY().isVideoDataAvailable(this.mediaId, pInt.value, pInt2.value);
            if (isVideoDataAvailable) {
                return isVideoDataAvailable;
            }
            try {
                this.jIg = i;
                return isVideoDataAvailable;
            } catch (Exception e2) {
                e = e2;
                v.a("MicroMsg.OnlineVideoUIHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + e.toString());
                return isVideoDataAvailable;
            }
        } catch (Throwable e3) {
            e = e3;
            isVideoDataAvailable = false;
            v.a("MicroMsg.OnlineVideoUIHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + e.toString());
            return isVideoDataAvailable;
        }
    }

    private boolean a(int i, PInt pInt, PInt pInt2) {
        pInt.value = Math.max(i, this.jIg);
        if (this.jHY == 1) {
            pInt.value = i;
            pInt2.value = pInt.value + this.jIh;
        }
        if (this.jHY == 2) {
            pInt.value = i - 8;
            if (pInt.value < 0) {
                pInt.value = 0;
            }
            pInt2.value = (pInt.value + this.jIh) + 8;
        }
        if (this.jHY == 3 || this.jHY == 4) {
            pInt.value = this.jIg;
            pInt2.value = (this.jIh + i) + this.oDw.jIs;
        }
        if (pInt2.value >= this.jIc + 1) {
            pInt2.value = this.jIc + 1;
        }
        if (pInt2.value <= pInt.value) {
            pInt2.value = pInt.value + this.oDw.jIs;
            return false;
        }
        v.i("MicroMsg.OnlineVideoUIHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i), Integer.valueOf(this.jHY), Integer.valueOf(this.jIg), Integer.valueOf(this.jIh));
        return true;
    }

    private boolean l(int i, int i2, boolean z) {
        boolean isVideoDataAvailable;
        int i3 = 0;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            this.jIa.a(i, i2, pInt, pInt2);
            isVideoDataAvailable = com.tencent.mm.modelcdntran.g.DY().isVideoDataAvailable(this.mediaId, pInt.value, pInt2.value);
        } catch (Throwable e) {
            v.a("MicroMsg.OnlineVideoUIHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + e.toString());
            isVideoDataAvailable = false;
        }
        if (isVideoDataAvailable) {
            v.i("MicroMsg.OnlineVideoUIHelper", "already had video data.");
        } else if (!this.jHZ.containsKey(this.mediaId + 0 + "_-1")) {
            String str = this.mediaId + pInt.value + "_" + pInt2.value;
            if (this.jHZ.containsKey(str)) {
                v.i("MicroMsg.OnlineVideoUIHelper", "already request video : " + str);
            } else {
                v.i("MicroMsg.OnlineVideoUIHelper", "request video data [%d, %d]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value));
                com.tencent.mm.modelcdntran.g.DY();
                String str2 = this.mediaId;
                int i4 = pInt.value;
                int i5 = pInt2.value;
                if (!z) {
                    i3 = i2 - i;
                }
                com.tencent.mm.modelcdntran.f.requestVideoData(str2, i4, i5, i3);
                this.jHZ.put(str, Integer.valueOf(i2));
            }
        }
        return isVideoDataAvailable;
    }

    public final void bHh() {
        String str = this.mediaId + 0 + "_-1";
        if (!this.jHZ.containsKey(str)) {
            v.i("MicroMsg.OnlineVideoUIHelper", "request all data. [%s]", this.mediaId);
            com.tencent.mm.modelcdntran.g.DY();
            com.tencent.mm.modelcdntran.f.requestVideoData(this.mediaId, 0, -1, 0);
            this.jHZ.put(str, Integer.valueOf(0));
            g.iuh.a(354, 24, 1, false);
            v.w("MicroMsg.OnlineVideoUIHelper", "%d rpt request all video %s ", Integer.valueOf(hashCode()), this.filename);
            g.iuh.h(13836, Integer.valueOf(303), Long.valueOf(be.Nh()), SQLiteDatabase.KeyEmpty);
        }
        this.jHY = 5;
    }

    final Object[] bHi() {
        int i = 0;
        Object[] objArr = new Object[7];
        i iVar = this.oDs;
        if (iVar.jHQ < 0) {
            iVar.jHQ = 0;
        }
        v.i("MicroMsg.Imagegallery.handler.video", "get[%s] play video duration [%d]", iVar.filename, Integer.valueOf(iVar.jHQ));
        objArr[0] = Integer.valueOf(iVar.jHQ);
        if (this.jIm <= 0) {
            this.jIm = be.Ni();
        }
        int i2 = (int) (this.jIm - this.jIk);
        if (i2 <= 0) {
            i2 = 0;
        }
        objArr[1] = Integer.valueOf(i2);
        if (this.jIl <= 0) {
            this.jIl = be.Ni();
        }
        i2 = (int) (this.jIl - this.jIk);
        if (i2 <= 0) {
            i2 = 0;
        }
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(this.jIj);
        if (this.jIj > 0) {
            if (this.jIo == 0) {
                this.jIo = (int) (((long) this.jIo) + be.ay(this.jIn));
            }
            objArr[4] = Integer.valueOf(this.jIo / this.jIj);
        } else {
            objArr[4] = Integer.valueOf(0);
        }
        iVar = this.oDs;
        if (iVar.jHI <= 0 || iVar.jHH <= 0) {
            i2 = 0;
        } else {
            i2 = (int) (iVar.jHI - iVar.jHH);
        }
        if (i2 >= 0) {
            i = i2;
        }
        objArr[5] = Integer.valueOf(i);
        objArr[6] = Integer.valueOf(this.oDs.jHJ);
        return objArr;
    }
}
