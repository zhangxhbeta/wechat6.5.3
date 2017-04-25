package com.tencent.mm.c.b;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.FileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class i implements e {
    private static int aVy = 0;
    private ah aVA = new ah(ak.vA().htb.getLooper(), new a(this) {
        final /* synthetic */ i aVE;

        {
            this.aVE = r1;
        }

        public final boolean oU() {
            v.d("MicroMsg.SceneVoiceService", "onTimerExpired");
            i.h(this.aVE);
            return false;
        }

        public final String toString() {
            return super.toString() + "|scenePusher";
        }
    }, false);
    Queue<String> aVq = new LinkedList();
    Queue<p> aVr = new LinkedList();
    Map<String, g.a> aVs = new HashMap();
    private boolean aVt = false;
    private boolean aVu = false;
    private boolean aVv = false;
    public int aVw = 0;
    private long aVx = 0;
    g.a aVz = new g.a();

    static /* synthetic */ void h(i iVar) {
        String ec;
        p pVar;
        iVar.aVx = System.currentTimeMillis();
        if ((!iVar.aVt && iVar.aVr.size() == 0) || (!iVar.aVu && iVar.aVq.size() == 0)) {
            u Lz = m.Lz();
            Cursor rawQuery = Lz.cuX.rawQuery(("SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId" + " FROM voiceinfo") + " WHERE Status<97 and User!=\"_USER_FOR_THROWBOTTLE_\"   order by CreateTime", null);
            int count = rawQuery.getCount();
            v.d("MicroMsg.VoiceStorage", "getUnfinishInfo resCount:" + count);
            List list;
            if (count == 0) {
                rawQuery.close();
                list = null;
            } else {
                list = new ArrayList();
                for (int i = 0; i < count; i++) {
                    rawQuery.moveToPosition(i);
                    p pVar2 = new p();
                    pVar2.b(rawQuery);
                    list.add(pVar2);
                }
                rawQuery.close();
            }
            if (!(r0 == null || r0.size() == 0)) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                ec = be.ec(currentTimeMillis);
                for (p pVar3 : r0) {
                    if (iVar.aVs.containsKey(pVar3.aST)) {
                        v.d("MicroMsg.SceneVoiceService", "File is Already running:" + pVar3.aST);
                    } else {
                        v.d("MicroMsg.SceneVoiceService", "Get file:" + pVar3.aST + " status:" + pVar3.status + " user" + pVar3.ble + " human:" + pVar3.dhC + " create:" + be.ec(pVar3.dhH) + " last:" + be.ec(pVar3.dhI) + " now:" + be.ec(currentTimeMillis) + " " + (currentTimeMillis - pVar3.dhI));
                        if (pVar3.LC()) {
                            if (currentTimeMillis - pVar3.dhI > 80 && pVar3.status == 5) {
                                v.e("MicroMsg.SceneVoiceService", "time out file: " + pVar3.aST + " last:" + be.ec(pVar3.dhI) + " now:" + ec + " msgLocalId:" + pVar3.dhL + " status:" + pVar3.status);
                                if (pVar3.dhL == 0) {
                                    pVar3.dhI = System.currentTimeMillis() / 1000;
                                    pVar3.bkU = 320;
                                    m.Lz().a(pVar3.aST, pVar3);
                                } else {
                                    q.lh(pVar3.aST);
                                }
                            }
                            if (currentTimeMillis - pVar3.dhI > 300 && pVar3.status == 6) {
                                v.e("MicroMsg.SceneVoiceService", "time out file: " + pVar3.aST + " last:" + be.ec(pVar3.dhI) + " now:" + ec + " msgLocalId:" + pVar3.dhL + " status:" + pVar3.status);
                                if (pVar3.dhL == 0) {
                                    pVar3.dhI = System.currentTimeMillis() / 1000;
                                    pVar3.bkU = 320;
                                    m.Lz().a(pVar3.aST, pVar3);
                                } else {
                                    q.lh(pVar3.aST);
                                }
                            }
                            if (pVar3.dhE >= pVar3.dgC) {
                                v.d("MicroMsg.SceneVoiceService", "file: " + pVar3.aST + " stat:" + pVar3.status + " now:" + pVar3.dhE + " net:" + pVar3.dgC);
                            } else {
                                iVar.aVr.offer(pVar3);
                                iVar.aVs.put(pVar3.aST, null);
                            }
                        }
                        if (pVar3.LD()) {
                            v.d("MicroMsg.SceneVoiceService", "now " + currentTimeMillis + "info.getLastModifyTime()  " + pVar3.dhI + "  info.getStatus() " + pVar3.status + "  info.getCreateTime() " + pVar3.dhH);
                            if (currentTimeMillis - pVar3.dhI > 10 && (pVar3.status == 2 || pVar3.status == 1)) {
                                v.e("MicroMsg.SceneVoiceService", "time out file: " + pVar3.aST + " last:" + be.ec(pVar3.dhI) + " now:" + ec);
                                q.lh(pVar3.aST);
                            } else if (currentTimeMillis - pVar3.dhH > 600 && pVar3.status == 3) {
                                v.e("MicroMsg.SceneVoiceService", "time out file: " + pVar3.aST + " last:" + be.ec(pVar3.dhI) + " now:" + ec);
                                q.lh(pVar3.aST);
                            } else if (pVar3.ble.length() <= 0) {
                                v.e("MicroMsg.SceneVoiceService", "Create a new ChatRoom? , set username first :" + pVar3.aST);
                            } else {
                                iVar.aVq.offer(pVar3.aST);
                                iVar.aVs.put(pVar3.aST, null);
                            }
                        }
                    }
                }
                v.d("MicroMsg.SceneVoiceService", "GetNeedRun procing:" + iVar.aVs.size() + " [recv:" + iVar.aVr.size() + ",send:" + iVar.aVq.size() + "]");
                iVar.aVr.size();
                iVar.aVq.size();
            }
        }
        if (iVar.aVt || iVar.aVr.size() != 0 || iVar.aVu || iVar.aVq.size() != 0) {
            if (!iVar.aVt && iVar.aVr.size() > 0) {
                pVar3 = (p) iVar.aVr.poll();
                ec = pVar3.aST;
                v.d("MicroMsg.SceneVoiceService", "Start Recv :" + ec);
                if (ec != null) {
                    iVar.aVs.put(ec, new g.a());
                    iVar.aVt = true;
                    ak.vy().a(new com.tencent.mm.modelvoice.e(pVar3), 0);
                }
            }
            if (!iVar.aVu && iVar.aVq.size() > 0) {
                String str = (String) iVar.aVq.poll();
                v.d("MicroMsg.SceneVoiceService", "Start Send :" + str);
                if (str != null) {
                    iVar.aVs.put(str, new g.a());
                    iVar.aVu = true;
                    ak.vy().a(new f(str), 0);
                    return;
                }
                return;
            }
            return;
        }
        iVar.pu();
        v.d("MicroMsg.SceneVoiceService", "No Data Any More , Stop Service");
    }

    static /* synthetic */ int ou() {
        int i = aVy;
        aVy = i + 1;
        return i;
    }

    static /* synthetic */ int ov() {
        int i = aVy;
        aVy = i - 1;
        return i;
    }

    public i() {
        ak.vy().a(127, (e) this);
        ak.vy().a((int) FileUtils.S_IWUSR, (e) this);
    }

    public final void a(final int i, final int i2, String str, final k kVar) {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ i aVE;

            public final void run() {
                int i;
                String str;
                i.ou();
                String str2;
                if (kVar.getType() == FileUtils.S_IWUSR) {
                    this.aVE.aVt = false;
                    str2 = ((com.tencent.mm.modelvoice.e) kVar).aST;
                    i = ((com.tencent.mm.modelvoice.e) kVar).aYJ;
                    str = str2;
                } else if (kVar.getType() == 127) {
                    this.aVE.aVu = false;
                    str2 = ((f) kVar).aST;
                    i = ((f) kVar).aYJ;
                    str = str2;
                } else {
                    v.e("MicroMsg.SceneVoiceService", "onSceneEnd Error SceneType:" + kVar.getType());
                    i.ov();
                    return;
                }
                long j = 0;
                if (!(str == null || this.aVE.aVs.get(str) == null)) {
                    j = ((g.a) this.aVE.aVs.get(str)).sn();
                    this.aVE.aVs.remove(str);
                }
                v.d("MicroMsg.SceneVoiceService", "onSceneEnd SceneType:" + kVar.getType() + " errtype:" + i + " errCode:" + i2 + " retCode:" + i + " file:" + str + " time:" + j);
                if (i == 3 && i != 0) {
                    this.aVE.aVw = this.aVE.aVw - 1;
                } else if (i != 0) {
                    this.aVE.aVw = 0;
                }
                v.d("MicroMsg.SceneVoiceService", "onSceneEnd  inCnt:" + i.aVy + " stop:" + this.aVE.aVw + " running:" + this.aVE.aVv + " recving:" + this.aVE.aVt + " sending:" + this.aVE.aVu);
                if (this.aVE.aVw > 0) {
                    i.h(this.aVE);
                } else if (!(this.aVE.aVu || this.aVE.aVt)) {
                    this.aVE.pu();
                }
                i.ov();
            }

            public final String toString() {
                return super.toString() + "|onSceneEnd";
            }
        });
    }

    private void pu() {
        this.aVs.clear();
        this.aVq.clear();
        this.aVr.clear();
        this.aVu = false;
        this.aVt = false;
        this.aVv = false;
        v.d("MicroMsg.SceneVoiceService", "Finish service use time(ms):" + this.aVz.sn());
    }

    public final void run() {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ i aVE;

            {
                this.aVE = r1;
            }

            public final void run() {
                long currentTimeMillis = System.currentTimeMillis() - this.aVE.aVx;
                v.d("MicroMsg.SceneVoiceService", "Try Run service runningFlag:" + this.aVE.aVv + " timeWait:" + currentTimeMillis + " sending:" + this.aVE.aVu + " recving:" + this.aVE.aVt);
                if (this.aVE.aVv) {
                    if (currentTimeMillis >= 60000) {
                        v.e("MicroMsg.SceneVoiceService", "ERR: Try Run service runningFlag:" + this.aVE.aVv + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + this.aVE.aVu + " recving:" + this.aVE.aVt);
                    } else {
                        return;
                    }
                }
                this.aVE.aVv = true;
                this.aVE.aVu = false;
                this.aVE.aVw = 3;
                this.aVE.aVt = false;
                this.aVE.aVz.cgu = SystemClock.elapsedRealtime();
                this.aVE.aVA.ea(10);
            }

            public final String toString() {
                return super.toString() + "|run";
            }
        });
    }
}
