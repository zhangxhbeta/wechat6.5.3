package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.as.a.f;
import com.tencent.mm.h.j;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class ac {
    String bap;
    aib boL;
    int cLB;
    String hqT;
    int iJK;
    int icJ = 0;
    int jHY = 0;
    HashMap<String, Integer> jHZ = null;
    f jIa;
    a jIb;
    int jIc;
    int jId;
    int jIe;
    private boolean jIf;
    int jIg = 0;
    private int jIh;
    boolean jIi = false;
    int jIj = 0;
    long jIk;
    long jIl;
    long jIm;
    long jIn;
    int jIo;
    b jIp;
    String jop;
    int progress;

    public interface a {
        void aVX();

        void aVY();

        int aWb();

        int aWc();

        int aWd();

        void aq(String str, boolean z);

        void py(int i);
    }

    private static class b {
        int jIr;
        int jIs;
        int jIt;

        private b() {
        }
    }

    public ac(a aVar) {
        this.jIb = aVar;
        this.jIa = new f();
        this.jHZ = new HashMap();
        this.jIp = new b();
        this.jIp.jIr = j.sU().getInt("SnsVideoPreloadSec", 5);
        this.jIp.jIs = j.sU().getInt("SnsVideoDownloadSec", 1);
        this.jIp.jIt = j.sU().getInt("SnsVideoFullDownloadPercent", 101);
        v.i("MicroMsg.OnlineVideoViewHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d]", new Object[]{Integer.valueOf(this.jIp.jIr), Integer.valueOf(this.jIp.jIs), Integer.valueOf(this.jIp.jIt)});
        reset();
    }

    public final void reset() {
        this.jop = "";
        this.jIe = -1;
        this.jIg = 0;
        this.jIc = 0;
        this.jIj = 0;
        this.jHY = 0;
        this.icJ = 0;
        this.jIf = false;
        this.jIi = false;
        this.jHZ.clear();
        this.boL = null;
        this.cLB = 0;
        this.bap = null;
        if (this.jIp != null) {
            this.jIh = this.jIp.jIr;
        }
        this.jIl = 0;
        this.jIk = 0;
        this.jIo = 0;
        this.jIn = 0;
        this.jIm = 0;
    }

    public final boolean BW(String str) {
        return be.dC(this.jop, str);
    }

    public final boolean qN(int i) {
        int i2;
        if (this.jIe != -1) {
            i2 = this.jIe;
        } else {
            i2 = i;
        }
        v.i("MicroMsg.OnlineVideoViewHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d downloadStatus %d cdnMediaId %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.jIg), Integer.valueOf(this.jIc), Integer.valueOf(this.icJ), this.jop});
        switch (this.icJ) {
            case 1:
                boolean z;
                boolean z2;
                if (!qO(i2)) {
                    this.jIf = true;
                    if (this.jIg > 0) {
                        v.i("MicroMsg.OnlineVideoViewHelper", "pause by load data cdnMediaId %s, pauseByLoadDataCount %d, playStatus %d", new Object[]{this.jop, Integer.valueOf(this.jIj), Integer.valueOf(this.jHY)});
                        this.jIn = be.Ni();
                        if (!(this.jHY == 2 || this.jHY == 4)) {
                            this.jIh += this.jIp.jIr;
                            this.jIh = Math.min(this.jIh, 60);
                            this.jIj++;
                            this.jHY = 4;
                        }
                        this.jIb.aVY();
                    } else if (this.jIe == -1) {
                        this.jHY = 1;
                    } else {
                        this.jHY = 2;
                    }
                    z = false;
                } else if (this.jIi) {
                    if (this.jIf) {
                        if (this.jIj == 0 && this.jIm == 0) {
                            aWh();
                        } else if (this.jIn > 0) {
                            this.jIo = (int) (((long) this.jIo) + be.ay(this.jIn));
                        }
                        v.i("MicroMsg.OnlineVideoViewHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d cdnMediaId %s", new Object[]{Integer.valueOf(this.jIj), Integer.valueOf(this.jIo), this.jop});
                        if (this.jIe != -1) {
                            this.jIb.py(this.jIe);
                            this.jIe = -1;
                        } else {
                            this.jIb.aVX();
                        }
                        this.jIf = false;
                    }
                    this.jHY = 3;
                    z = true;
                } else {
                    this.jIb.aq(this.hqT, true);
                    this.jIi = true;
                    z = true;
                }
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                pInt.value = Math.max(i2, this.jIg);
                if (this.jHY == 1) {
                    pInt.value = i2;
                    pInt2.value = pInt.value + this.jIh;
                }
                if (this.jHY == 2) {
                    pInt.value = i2 - 8;
                    if (pInt.value < 0) {
                        pInt.value = 0;
                    }
                    pInt2.value = (pInt.value + this.jIh) + 8;
                }
                if (this.jHY == 3 || this.jHY == 4) {
                    pInt.value = this.jIg;
                    pInt2.value = (this.jIh + i2) + this.jIp.jIs;
                }
                if (pInt2.value >= this.jIc + 1) {
                    pInt2.value = this.jIc + 1;
                }
                if (pInt2.value <= pInt.value) {
                    pInt2.value = pInt.value + this.jIp.jIs;
                    z2 = false;
                } else {
                    v.i("MicroMsg.OnlineVideoViewHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[]{Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i2), Integer.valueOf(this.jHY), Integer.valueOf(this.jIg), Integer.valueOf(this.jIh)});
                    z2 = true;
                }
                if (!z2) {
                    v.d("MicroMsg.OnlineVideoViewHelper", "can not calc download.");
                    g.DY();
                    com.tencent.mm.modelcdntran.f.requestVideoData(this.jop, 0, -1, 0);
                } else if (cw(pInt.value, pInt2.value)) {
                    this.jIg = pInt2.value;
                    return true;
                }
                return z;
            case 2:
                v.w("MicroMsg.OnlineVideoViewHelper", "download error.");
                return true;
            case 3:
                if (!this.jIi) {
                    this.jIb.aq(this.hqT, true);
                    this.jIi = true;
                    return true;
                } else if (!this.jIf) {
                    return true;
                } else {
                    if (this.jIe != -1) {
                        this.jIb.py(this.jIe);
                        this.jIe = -1;
                    } else {
                        this.jIb.aVX();
                    }
                    this.jIf = false;
                    return true;
                }
            default:
                v.w("MicroMsg.OnlineVideoViewHelper", "check time default.");
                return true;
        }
    }

    private boolean qO(int i) {
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
            boolean isVideoDataAvailable = g.DY().isVideoDataAvailable(this.jop, pInt.value, pInt2.value);
            if (isVideoDataAvailable) {
                return isVideoDataAvailable;
            }
            this.jIg = i;
            return isVideoDataAvailable;
        } catch (Exception e) {
            v.e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + e.toString());
            return false;
        }
    }

    private boolean cw(int i, int i2) {
        boolean isVideoDataAvailable;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            this.jIa.a(i, i2, pInt, pInt2);
            isVideoDataAvailable = g.DY().isVideoDataAvailable(this.jop, pInt.value, pInt2.value);
        } catch (Exception e) {
            v.e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + e.toString());
            isVideoDataAvailable = false;
        }
        if (isVideoDataAvailable) {
            v.i("MicroMsg.OnlineVideoViewHelper", "already had video data.");
        } else if (!this.jHZ.containsKey(this.jop + 0 + "_-1")) {
            String str = this.jop + pInt.value + "_" + pInt2.value;
            if (this.jHZ.containsKey(str)) {
                v.i("MicroMsg.OnlineVideoViewHelper", "already request video : " + str);
            } else {
                v.i("MicroMsg.OnlineVideoViewHelper", "request video data [%d, %d]", new Object[]{Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value)});
                g.DY();
                com.tencent.mm.modelcdntran.f.requestVideoData(this.jop, pInt.value, pInt2.value, i2 - i);
                this.jHZ.put(str, Integer.valueOf(i2));
            }
        }
        return isVideoDataAvailable;
    }

    final void aWg() {
        v.i("MicroMsg.OnlineVideoViewHelper", "play offline video %s ", new Object[]{this.jop});
        ad.o(new Runnable(this) {
            final /* synthetic */ ac jIq;

            {
                this.jIq = r1;
            }

            public final void run() {
                if (this.jIq.jIb != null) {
                    this.jIq.jIb.aq(this.jIq.hqT, false);
                }
            }
        });
    }

    final void aWh() {
        if (this.jIm == 0) {
            this.jIm = be.Ni();
        }
    }
}
