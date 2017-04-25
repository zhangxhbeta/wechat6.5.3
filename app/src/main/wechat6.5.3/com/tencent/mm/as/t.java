package com.tencent.mm.as;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import junit.framework.Assert;

public final class t {
    public static String din = null;

    public static class a implements e {
        private static int aVy = 0;
        private ah aVA = null;
        Queue<String> aVq = new LinkedList();
        Queue<String> aVr = new LinkedList();
        Map<String, com.tencent.mm.compatible.util.g.a> aVs = new HashMap();
        private boolean aVt = false;
        private boolean aVu = false;
        private boolean aVv = false;
        int aVw = 0;
        private long aVx = 0;
        com.tencent.mm.compatible.util.g.a aVz = new com.tencent.mm.compatible.util.g.a();
        HandlerThread dio = com.tencent.mm.sdk.i.e.bJ("VideoService_runThread", 0);
        ac dip;
        boolean diq = false;
        public List<r> dir = new ArrayList();
        Queue<String> dis = new LinkedList();
        public b dit = null;
        d diu = null;

        static /* synthetic */ int Bm() {
            int i = aVy;
            aVy = i + 1;
            return i;
        }

        static /* synthetic */ int Lq() {
            int i = aVy;
            aVy = i - 1;
            return i;
        }

        static /* synthetic */ void a(a aVar) {
            String str;
            boolean z = true;
            aVar.aVx = System.currentTimeMillis();
            if ((!aVar.aVt && aVar.aVr.size() + aVar.dis.size() == 0) || (!aVar.aVu && aVar.aVq.size() == 0)) {
                long Nj = be.Nj();
                List<String> Ln = k.KV().Ln();
                List<String> Ll = k.KV().Ll();
                List<String> Lm = k.KV().Lm();
                if (Ln != null) {
                    v.d("MicroMsg.VideoService", "getNeedRunInfo needSendList size: " + Ln.size());
                    for (String str2 : Ln) {
                        if (aVar.aVs.containsKey(str2)) {
                            v.d("MicroMsg.VideoService", "File is Already running:" + str2);
                        } else {
                            aVar.aVq.offer(str2);
                            aVar.aVs.put(str2, null);
                        }
                    }
                }
                if (Ll != null) {
                    v.d("MicroMsg.VideoService", "getNeedRunInfo needRecvList size: " + Ll.size());
                    for (String str22 : Ll) {
                        if (aVar.aVs.containsKey(str22)) {
                            v.d("MicroMsg.VideoService", "File is Already running:" + str22);
                        } else {
                            aVar.aVr.offer(str22);
                            aVar.aVs.put(str22, null);
                        }
                    }
                }
                if (Lm != null) {
                    v.d("MicroMsg.VideoService", "getNeedRunInfo online video list size: " + Lm.size());
                    for (String str222 : Lm) {
                        if (aVar.aVs.containsKey(str222)) {
                            v.d("MicroMsg.VideoService", "File is Already running:" + str222);
                        } else {
                            aVar.dis.offer(str222);
                            aVar.aVs.put(str222, null);
                        }
                    }
                }
                v.i("MicroMsg.VideoService", "GetNeedRun cost time[%d] procing[%d] [recv:%d, online:%d, send:%d]", Long.valueOf(be.az(Nj)), Integer.valueOf(aVar.aVs.size()), Integer.valueOf(aVar.aVr.size()), Integer.valueOf(aVar.dis.size()), Integer.valueOf(aVar.aVq.size()));
                aVar.aVr.size();
                aVar.aVq.size();
                aVar.dis.size();
            }
            if (aVar.aVt || aVar.aVr.size() + aVar.dis.size() != 0 || aVar.aVu || aVar.aVq.size() != 0) {
                if (!aVar.aVt && (aVar.aVr.size() > 0 || aVar.dis.size() > 0)) {
                    if (aVar.dis.size() > 0) {
                        str222 = (String) aVar.dis.poll();
                        v.d("MicroMsg.VideoService", "Start Recv :" + str222);
                        if (!be.kS(str222)) {
                            aVar.aVs.put(str222, new com.tencent.mm.compatible.util.g.a());
                            aVar.aVt = true;
                            Assert.assertTrue("sceneDown should null", aVar.dit == null);
                            aVar.dit = new b(str222, true);
                            ak.vy().a(aVar.dit, 0);
                        }
                    }
                    if (!aVar.aVt) {
                        str222 = (String) aVar.aVr.poll();
                        v.d("MicroMsg.VideoService", "Start Recv :" + str222);
                        if (str222 != null) {
                            aVar.aVs.put(str222, new com.tencent.mm.compatible.util.g.a());
                            aVar.aVt = true;
                            Assert.assertTrue("sceneDown should null", aVar.dit == null);
                            aVar.dit = new b(str222);
                            ak.vy().a(aVar.dit, 0);
                        }
                    }
                }
                if (!aVar.aVu && aVar.aVq.size() > 0) {
                    str222 = (String) aVar.aVq.poll();
                    v.d("MicroMsg.VideoService", "Start Send :" + str222);
                    if (str222 != null) {
                        aVar.aVs.put(str222, new com.tencent.mm.compatible.util.g.a());
                        aVar.aVu = true;
                        String str3 = "sceneUp should null";
                        if (aVar.diu != null) {
                            z = false;
                        }
                        Assert.assertTrue(str3, z);
                        if (aVar.dir != null && aVar.dir.size() > 0) {
                            for (r lt : aVar.dir) {
                                lt.lt(str222);
                            }
                        }
                        aVar.diu = new d(str222);
                        ak.vy().a(aVar.diu, 0);
                        return;
                    }
                    return;
                }
                return;
            }
            aVar.pu();
            v.d("MicroMsg.VideoService", "No Data Any More , Stop Service");
        }

        public a() {
            ak.vy().a(149, (e) this);
            ak.vy().a(150, (e) this);
            this.dio.start();
            this.diq = true;
            this.dip = new ac(this.dio.getLooper());
            this.aVA = new ah(this.dio.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
                final /* synthetic */ a div;

                {
                    this.div = r1;
                }

                public final boolean oU() {
                    a.a(this.div);
                    return false;
                }

                public final String toString() {
                    return super.toString() + "|scenePusher";
                }
            }, false);
            v.i("MicroMsg.VideoService", "create VideoService, start video send thread");
        }

        public final void a(final int i, final int i2, String str, final k kVar) {
            if (this.dio == null || !this.diq || this.dip == null) {
                v.e("MicroMsg.VideoService", "onSceneEnd error!, handler or thread is null!");
            } else {
                this.dip.post(new Runnable(this) {
                    final /* synthetic */ a div;

                    public final void run() {
                        int i;
                        String str;
                        a.Bm();
                        String str2;
                        if (kVar.getType() == 150) {
                            this.div.aVt = false;
                            str2 = ((b) kVar).aST;
                            t.din = str2;
                            int i2 = ((b) kVar).aYJ;
                            this.div.dit = null;
                            i = i2;
                            str = str2;
                        } else if (kVar.getType() == 149) {
                            this.div.aVu = false;
                            this.div.diu = null;
                            if (kVar instanceof d) {
                                str2 = ((d) kVar).aST;
                                i = ((d) kVar).aYJ;
                                str = str2;
                            } else if (kVar instanceof e) {
                                i = 0;
                                str = ((e) kVar).aST;
                            } else {
                                i = 0;
                                str = null;
                            }
                        } else {
                            v.e("MicroMsg.VideoService", "onSceneEnd Error SceneType:" + kVar.getType());
                            a.Lq();
                            return;
                        }
                        long j = 0;
                        if (!(str == null || this.div.aVs.get(str) == null)) {
                            j = ((com.tencent.mm.compatible.util.g.a) this.div.aVs.get(str)).sn();
                            this.div.aVs.remove(str);
                        }
                        v.d("MicroMsg.VideoService", "onSceneEnd SceneType:" + kVar.getType() + " errtype:" + i + " errCode:" + i2 + " retCode:" + i + " file:" + str + " time:" + j);
                        if (i == 3 && i != 0) {
                            this.div.aVw = this.div.aVw - 1;
                        } else if (i != 0) {
                            this.div.aVw = 0;
                        }
                        v.d("MicroMsg.VideoService", "onSceneEnd  inCnt:" + a.aVy + " stop:" + this.div.aVw + " running:" + this.div.aVv + " recving:" + this.div.aVt + " sending:" + this.div.aVu);
                        if (this.div.aVw > 0) {
                            a.a(this.div);
                        } else if (!(this.div.aVu || this.div.aVt)) {
                            this.div.pu();
                        }
                        a.Lq();
                    }

                    public final String toString() {
                        return super.toString() + "|onSceneEnd";
                    }
                });
            }
        }

        public final void pu() {
            this.aVs.clear();
            this.aVq.clear();
            this.aVr.clear();
            this.dis.clear();
            this.aVu = false;
            this.aVt = false;
            this.aVv = false;
            v.d("MicroMsg.VideoService", "Finish service use time(ms):" + this.aVz.sn());
        }

        public final void run() {
            if (this.dio == null || !this.diq || this.dip == null) {
                v.e("MicroMsg.VideoService", "run error!, handler or thread is null!");
            } else {
                this.dip.post(new Runnable(this) {
                    final /* synthetic */ a div;

                    {
                        this.div = r1;
                    }

                    public final void run() {
                        long currentTimeMillis = System.currentTimeMillis() - this.div.aVx;
                        v.d("MicroMsg.VideoService", "Try Run service runningFlag:" + this.div.aVv + " timeWait:" + currentTimeMillis + " sending:" + this.div.aVu + " recving:" + this.div.aVt);
                        if (this.div.aVv) {
                            if (currentTimeMillis >= 60000) {
                                v.e("MicroMsg.VideoService", "ERR: Try Run service runningFlag:" + this.div.aVv + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + this.div.aVu + " recving:" + this.div.aVt);
                            } else {
                                return;
                            }
                        }
                        this.div.aVw = 3;
                        this.div.aVv = true;
                        this.div.aVu = false;
                        this.div.aVt = false;
                        this.div.diu = null;
                        this.div.dit = null;
                        this.div.aVz.cgu = SystemClock.elapsedRealtime();
                        this.div.aVA.ea(10);
                    }

                    public final String toString() {
                        return super.toString() + "|run";
                    }
                });
            }
        }

        public final boolean Lp() {
            boolean ph;
            if (this.dit != null) {
                ph = this.dit.ph();
                this.aVv = false;
            } else {
                ph = false;
            }
            this.aVs.clear();
            this.aVq.clear();
            this.aVr.clear();
            this.dis.clear();
            return ph;
        }
    }
}
