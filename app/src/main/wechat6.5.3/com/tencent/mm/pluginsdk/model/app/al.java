package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class al {

    public static class a implements e {
        private static int aVy = 0;
        private ah aVA = new ah(ak.vA().htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
            final /* synthetic */ a lBl;

            {
                this.lBl = r1;
            }

            public final boolean oU() {
                a.i(this.lBl);
                return false;
            }

            public final String toString() {
                return super.toString() + "|scenePusher";
            }
        }, false);
        Queue<Long> aVq = new LinkedList();
        Queue<Long> aVr = new LinkedList();
        Map<Long, com.tencent.mm.compatible.util.g.a> aVs = new HashMap();
        private boolean aVt = false;
        private boolean aVu = false;
        private boolean aVv = false;
        int aVw = 0;
        private long aVx = 0;
        com.tencent.mm.compatible.util.g.a aVz = new com.tencent.mm.compatible.util.g.a();
        private HashMap<Long, String> lBk = new HashMap();

        static /* synthetic */ void i(a aVar) {
            long currentTimeMillis;
            String ec;
            v.d("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene recving[%b][%d], sending[%b][%d]", Boolean.valueOf(aVar.aVt), Integer.valueOf(aVar.aVr.size()), Boolean.valueOf(aVar.aVu), Integer.valueOf(aVar.aVq.size()));
            aVar.aVx = System.currentTimeMillis();
            if ((!aVar.aVt && aVar.aVr.size() == 0) || (!aVar.aVu && aVar.aVq.size() == 0)) {
                Cursor rawQuery = am.Wf().rawQuery("select *  , rowid  from appattach where status = 101", new String[0]);
                List list;
                if (rawQuery == null) {
                    list = null;
                } else {
                    int count = rawQuery.getCount();
                    v.d("MicroMsg.AppAttachInfoStorage", "getUnfinishInfo resCount:" + count);
                    if (count == 0) {
                        rawQuery.close();
                        list = null;
                    } else {
                        list = new ArrayList();
                        for (int i = 0; i < count; i++) {
                            rawQuery.moveToPosition(i);
                            b bVar = new b();
                            bVar.b(rawQuery);
                            list.add(bVar);
                        }
                        rawQuery.close();
                    }
                }
                if (!(r0 == null || r0.size() == 0)) {
                    currentTimeMillis = System.currentTimeMillis() / 1000;
                    ec = be.ec(currentTimeMillis);
                    for (b bVar2 : r0) {
                        if (aVar.aVs.containsKey(Long.valueOf(bVar2.nmb))) {
                            v.d("MicroMsg.SceneAppMsg", "summerbig File is Already running:" + bVar2.nmb);
                        } else {
                            v.d("MicroMsg.SceneAppMsg", "summerbig Get file:" + bVar2.field_fileFullPath + " status:" + bVar2.field_status + " create:(" + be.ec(bVar2.field_createTime) + "," + be.ec(bVar2.field_createTime / 1000) + ", last:" + be.ec(bVar2.field_lastModifyTime) + " now:" + be.ec(currentTimeMillis) + " " + (currentTimeMillis - bVar2.field_lastModifyTime));
                            if (bVar2.field_isUpload) {
                                if (currentTimeMillis - bVar2.field_lastModifyTime <= 600 || bVar2.field_status != 101) {
                                    aVar.aVq.offer(Long.valueOf(bVar2.nmb));
                                    aVar.aVs.put(Long.valueOf(bVar2.nmb), null);
                                } else {
                                    v.e("MicroMsg.SceneAppMsg", "summerbig time out file: " + bVar2.field_fileFullPath + " last:" + be.ec(bVar2.field_lastModifyTime) + " now:" + ec);
                                    l.dA(bVar2.nmb);
                                }
                            }
                        }
                    }
                    v.d("MicroMsg.SceneAppMsg", "summerbig GetNeedRun procing:" + aVar.aVs.size() + " [recv:" + aVar.aVr.size() + ",send:" + aVar.aVq.size() + "]");
                    aVar.aVr.size();
                    aVar.aVq.size();
                }
            }
            if (!aVar.aVt && aVar.aVr.size() == 0 && !aVar.aVu && aVar.aVq.size() == 0) {
                aVar.pu();
                v.d("MicroMsg.SceneAppMsg", "summerbig No Data Any More , Stop Service");
            } else if (!aVar.aVu && aVar.aVq.size() > 0) {
                currentTimeMillis = be.a((Long) aVar.aVq.poll(), -1);
                v.d("MicroMsg.SceneAppMsg", "summerbig Start Send :" + currentTimeMillis);
                if (currentTimeMillis != -1) {
                    aVar.aVs.put(Long.valueOf(currentTimeMillis), new com.tencent.mm.compatible.util.g.a());
                    aVar.aVu = true;
                    c bVar3 = new b();
                    at ek;
                    if (am.Wf().b(currentTimeMillis, bVar3)) {
                        if (bVar3.field_type == 8) {
                            String str;
                            ak.yW();
                            bx ek2 = com.tencent.mm.model.c.wJ().ek(bVar3.field_msgInfoId);
                            if (ek2.field_msgId == 0) {
                                v.e("MicroMsg.SceneAppMsg", "getEmoticonMd5 fail, msg is null :" + bVar3.field_msgInfoId);
                                str = null;
                            } else {
                                com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(ek2.field_content);
                                str = dV != null ? dV.cod : ag.Mv(ek2.field_content).aZy;
                            }
                            if (str == null) {
                                v.e("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene fail, send emoji, emoticonMd5 can not be null");
                                ak.yW();
                                ek = com.tencent.mm.model.c.wJ().ek(bVar3.field_msgInfoId);
                                ek.dh(5);
                                ak.yW();
                                com.tencent.mm.model.c.wJ().a(ek.field_msgId, ek);
                                aVar.aVu = false;
                                return;
                            }
                            ec = str;
                        } else {
                            ec = null;
                        }
                        ak.vy().a(new aj(currentTimeMillis, ec, (String) aVar.lBk.get(Long.valueOf(bVar3.field_msgInfoId))), 0);
                        return;
                    }
                    v.e("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene fail, getAttachInfo fail, infoId = " + currentTimeMillis);
                    ak.yW();
                    ek = com.tencent.mm.model.c.wJ().ek(bVar3.field_msgInfoId);
                    ek.dh(5);
                    ak.yW();
                    com.tencent.mm.model.c.wJ().a(ek.field_msgId, ek);
                    aVar.aVu = false;
                }
            }
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

        public a() {
            ak.vy().a(220, (e) this);
            ak.vy().a(221, (e) this);
            ak.vy().a(222, (e) this);
        }

        protected final void finalize() {
            ak.vy().b(220, (e) this);
            ak.vy().b(221, (e) this);
            ak.vy().b(222, (e) this);
            this.lBk.clear();
            super.finalize();
        }

        public final void o(long j, String str) {
            this.lBk.put(Long.valueOf(j), str);
        }

        public static void dC(long j) {
            ak.vy().a(new ag(j, null, null), 0);
        }

        public static void p(long j, String str) {
            ak.vy().a(new ag(j, str, null), 0);
        }

        public static void c(long j, String str, String str2) {
            ak.vy().a(new ag(j, str, str2), 0);
        }

        public final void a(final int i, final int i2, String str, final k kVar) {
            v.d("MicroMsg.SceneAppMsg", "summersafecdn onSceneEnd type:%d errType:%d errCode:%d", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ a lBl;

                public final void run() {
                    int i;
                    long j;
                    long j2 = 0;
                    a.ou();
                    if (kVar.getType() == 222) {
                        v.d("MicroMsg.SceneAppMsg", "onSceneEnd  SendAppMsg errtype:" + i + " errCode:" + i2);
                        i = 0;
                        j = -1;
                    } else if (kVar.getType() == 221) {
                        this.lBl.aVt = false;
                        j = ((aa) kVar).iFb;
                        i = ((aa) kVar).aYJ;
                    } else if (kVar.getType() == 220) {
                        this.lBl.aVu = false;
                        long j3 = ((aj) kVar).iFb;
                        int i2 = ((aj) kVar).aYJ;
                        aj ajVar = (aj) kVar;
                        String str = ajVar.lAG == null ? null : ajVar.lAG.field_mediaSvrId;
                        ajVar = (aj) kVar;
                        String str2 = (String) this.lBl.lBk.remove(Long.valueOf(ajVar.lAG == null ? 0 : ajVar.lAG.field_msgInfoId));
                        if (be.kS(((aj) kVar).cMU)) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                        if (i == 0 && !be.kS(str)) {
                            c bVar = new b();
                            am.Wf().b(j3, bVar);
                            if (bVar.nmb == j3) {
                                l.n(bVar.field_msgInfoId, str);
                                v.d("MicroMsg.SceneAppMsg", "onSceneEnd, finish update app attach, start send app msg");
                                a.p(bVar.field_msgInfoId, str2);
                            }
                        }
                        i = i2;
                        j = j3;
                    } else {
                        v.e("MicroMsg.SceneAppMsg", "onSceneEnd Error SceneType:" + kVar.getType());
                        a.ov();
                        return;
                    }
                    if (!(j == -1 || this.lBl.aVs.get(Long.valueOf(j)) == null)) {
                        j2 = ((com.tencent.mm.compatible.util.g.a) this.lBl.aVs.get(Long.valueOf(j))).sn();
                        this.lBl.aVs.remove(Long.valueOf(j));
                    }
                    v.d("MicroMsg.SceneAppMsg", "onSceneEnd SceneType:" + kVar.getType() + " errtype:" + i + " errCode:" + i2 + " retCode:" + i + " rowid:" + j + " time:" + j2);
                    if (i == 3 && i != 0) {
                        this.lBl.aVw = this.lBl.aVw - 1;
                    } else if (i != 0) {
                        this.lBl.aVw = 0;
                    }
                    v.d("MicroMsg.SceneAppMsg", "onSceneEnd  inCnt:" + a.aVy + " stop:" + this.lBl.aVw + " running:" + this.lBl.aVv + " recving:" + this.lBl.aVt + " sending:" + this.lBl.aVu);
                    if (this.lBl.aVw > 0) {
                        a.i(this.lBl);
                    } else if (!(this.lBl.aVu || this.lBl.aVt)) {
                        this.lBl.pu();
                    }
                    a.ov();
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
            v.d("MicroMsg.SceneAppMsg", "Finish service use time(ms):" + this.aVz.sn());
        }

        public final void run() {
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ a lBl;

                {
                    this.lBl = r1;
                }

                public final void run() {
                    long currentTimeMillis = System.currentTimeMillis() - this.lBl.aVx;
                    v.d("MicroMsg.SceneAppMsg", "summerbig Try Run service runningFlag:" + this.lBl.aVv + " timeWait:" + currentTimeMillis + " sending:" + this.lBl.aVu + " recving:" + this.lBl.aVt);
                    if (this.lBl.aVv) {
                        if (currentTimeMillis >= 180000) {
                            v.e("MicroMsg.SceneAppMsg", "summerbig ERR: Try Run service runningFlag:" + this.lBl.aVv + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + this.lBl.aVu + " recving:" + this.lBl.aVt);
                        } else {
                            return;
                        }
                    }
                    this.lBl.aVv = true;
                    this.lBl.aVu = false;
                    this.lBl.aVw = 4;
                    this.lBl.aVt = false;
                    this.lBl.aVz.cgu = SystemClock.elapsedRealtime();
                    this.lBl.aVA.ea(10);
                }

                public final String toString() {
                    return super.toString() + "|run";
                }
            });
        }
    }
}
