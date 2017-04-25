package com.tencent.mm.plugin.subapp.c;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class j implements e {
    private static int aVy = 0;
    private ah aVA = new ah(ak.vA().htb.getLooper(), new a(this) {
        final /* synthetic */ j kfS;

        {
            this.kfS = r1;
        }

        public final boolean oU() {
            v.d("MicroMsg.VoiceRemindService", "onTimerExpired");
            try {
                j.h(this.kfS);
            } catch (Throwable e) {
                v.a("MicroMsg.VoiceRemindService", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
            return false;
        }
    }, false);
    Queue<String> aVq = new LinkedList();
    Queue<String> aVr = new LinkedList();
    Map<String, g.a> aVs = new HashMap();
    private boolean aVt = false;
    private boolean aVu = false;
    private boolean aVv = false;
    int aVw = 0;
    private long aVx = 0;
    g.a aVz = new g.a();

    static /* synthetic */ void h(j jVar) {
        jVar.aVx = System.currentTimeMillis();
        if ((!jVar.aVt && jVar.aVr.size() == 0) || (!jVar.aVu && jVar.aVq.size() == 0)) {
            Cursor rawQuery = d.aZv().cie.rawQuery(("SELECT filename, user, msgid, offset, filenowsize, totallen, status, createtime, lastmodifytime, clientid, voicelenght, msglocalid, human, voiceformat, nettimes, reserved1, reserved2" + " FROM VoiceRemindInfo") + " WHERE status<97  order by createtime", null);
            int count = rawQuery.getCount();
            v.d("MicroMsg.VoiceRemindStorage", "getUnfinishInfo resCount:" + count);
            List list;
            if (count == 0) {
                rawQuery.close();
                list = null;
            } else {
                list = new ArrayList();
                for (int i = 0; i < count; i++) {
                    rawQuery.moveToPosition(i);
                    g gVar = new g();
                    gVar.b(rawQuery);
                    list.add(gVar);
                }
                rawQuery.close();
            }
            if (r0 == null) {
                v.d("MicroMsg.VoiceRemindService", "getNeedRunInfo null ");
            } else {
                v.d("MicroMsg.VoiceRemindService", "getNeedRunInfo " + r0.size());
            }
            if (!(r0 == null || r0.size() == 0)) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                String ec = be.ec(currentTimeMillis);
                for (g gVar2 : r0) {
                    if (jVar.aVs.containsKey(gVar2.field_filename)) {
                        v.d("MicroMsg.VoiceRemindService", "File is Already running:" + gVar2.field_filename);
                    } else {
                        v.d("MicroMsg.VoiceRemindService", "Get file:" + gVar2.field_filename + " status:" + gVar2.field_status + " user" + gVar2.field_user + " human:" + gVar2.field_human + " create:" + be.ec(gVar2.field_createtime) + " last:" + be.ec(gVar2.field_lastmodifytime) + " now:" + be.ec(currentTimeMillis) + " " + (currentTimeMillis - gVar2.field_lastmodifytime));
                        Object obj = (gVar2.field_status == 5 || gVar2.field_status == 6) ? 1 : null;
                        if (obj != null) {
                            if (currentTimeMillis - gVar2.field_lastmodifytime > 80 && gVar2.field_status == 5) {
                                v.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + be.ec(gVar2.field_lastmodifytime) + " now:" + ec);
                                h.lh(gVar2.field_filename);
                            } else if (currentTimeMillis - gVar2.field_lastmodifytime > 300 && gVar2.field_status == 6) {
                                v.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + be.ec(gVar2.field_lastmodifytime) + " now:" + ec);
                                h.lh(gVar2.field_filename);
                            } else if (gVar2.field_filenowsize >= gVar2.field_offset) {
                                v.d("MicroMsg.VoiceRemindService", "file: " + gVar2.field_filename + " stat:" + gVar2.field_status + " now:" + gVar2.field_filenowsize + " net:" + gVar2.field_offset);
                            } else {
                                jVar.aVr.offer(gVar2.field_filename);
                                jVar.aVs.put(gVar2.field_filename, null);
                            }
                        }
                        if (gVar2.LD()) {
                            v.d("MicroMsg.VoiceRemindService", "now " + currentTimeMillis + "info.getLastModifyTime()  " + gVar2.field_lastmodifytime + "  info.getStatus() " + gVar2.field_status + "  info.getCreateTime() " + gVar2.field_createtime);
                            if (currentTimeMillis - gVar2.field_lastmodifytime > 10 && (gVar2.field_status == 2 || gVar2.field_status == 1)) {
                                v.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + be.ec(gVar2.field_lastmodifytime) + " now:" + ec);
                                h.lh(gVar2.field_filename);
                            } else if (currentTimeMillis - gVar2.field_createtime > 600 && gVar2.field_status == 3) {
                                v.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + be.ec(gVar2.field_lastmodifytime) + " now:" + ec);
                                h.lh(gVar2.field_filename);
                            } else if (gVar2.field_user.length() <= 0) {
                                v.e("MicroMsg.VoiceRemindService", "Create a new ChatRoom? , set username first :" + gVar2.field_filename);
                            } else {
                                jVar.aVq.offer(gVar2.field_filename);
                                jVar.aVs.put(gVar2.field_filename, null);
                            }
                        }
                    }
                }
                v.d("MicroMsg.VoiceRemindService", "GetNeedRun procing:" + jVar.aVs.size() + " [recv:" + jVar.aVr.size() + ",send:" + jVar.aVq.size() + "]");
                jVar.aVr.size();
                jVar.aVq.size();
            }
        }
        if (jVar.aVt || jVar.aVr.size() != 0 || jVar.aVu || jVar.aVq.size() != 0) {
            String str;
            if (!jVar.aVt && jVar.aVr.size() > 0) {
                str = (String) jVar.aVr.poll();
                v.d("MicroMsg.VoiceRemindService", "Start Recv :" + str);
                if (str != null) {
                    jVar.aVs.put(str, new g.a());
                    jVar.aVt = true;
                    v.d("MicroMsg.VoiceRemindService", "tiger download voice");
                }
            }
            if (!jVar.aVu && jVar.aVq.size() > 0) {
                str = (String) jVar.aVq.poll();
                v.d("MicroMsg.VoiceRemindService", "Start Send :" + str);
                if (str != null) {
                    jVar.aVs.put(str, new g.a());
                    jVar.aVu = true;
                    ak.vy().a(new b(str), 0);
                    return;
                }
                return;
            }
            return;
        }
        jVar.pu();
        v.d("MicroMsg.VoiceRemindService", "No Data Any More , Stop Service");
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

    public j() {
        ak.vy().a(329, (e) this);
    }

    public final void a(final int i, final int i2, String str, final k kVar) {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ j kfS;

            public final void run() {
                int i;
                String str;
                j.ou();
                String str2;
                if (kVar.getType() == FileUtils.S_IWUSR) {
                    this.kfS.aVt = false;
                    str2 = ((com.tencent.mm.modelvoice.e) kVar).aST;
                    i = ((com.tencent.mm.modelvoice.e) kVar).aYJ;
                    str = str2;
                } else if (kVar.getType() == 329) {
                    this.kfS.aVu = false;
                    str2 = ((b) kVar).aST;
                    i = ((b) kVar).aYJ;
                    str = str2;
                } else {
                    v.e("MicroMsg.VoiceRemindService", "onSceneEnd Error SceneType:" + kVar.getType());
                    j.ov();
                    return;
                }
                long j = 0;
                if (!(str == null || this.kfS.aVs.get(str) == null)) {
                    j = ((g.a) this.kfS.aVs.get(str)).sn();
                    this.kfS.aVs.remove(str);
                }
                v.d("MicroMsg.VoiceRemindService", "onSceneEnd SceneType:" + kVar.getType() + " errtype:" + i + " errCode:" + i2 + " retCode:" + i + " file:" + str + " time:" + j);
                if (i == 3 && i != 0) {
                    this.kfS.aVw = this.kfS.aVw - 1;
                } else if (i != 0) {
                    this.kfS.aVw = 0;
                }
                v.d("MicroMsg.VoiceRemindService", "onSceneEnd  inCnt:" + j.aVy + " stop:" + this.kfS.aVw + " running:" + this.kfS.aVv + " recving:" + this.kfS.aVt + " sending:" + this.kfS.aVu);
                if (this.kfS.aVw > 0) {
                    j.h(this.kfS);
                } else if (!(this.kfS.aVu || this.kfS.aVt)) {
                    this.kfS.pu();
                }
                j.ov();
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
        v.d("MicroMsg.VoiceRemindService", "Finish service use time(ms):" + this.aVz.sn());
    }

    public final void run() {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ j kfS;

            {
                this.kfS = r1;
            }

            public final void run() {
                long currentTimeMillis = System.currentTimeMillis() - this.kfS.aVx;
                v.d("MicroMsg.VoiceRemindService", "Try Run service runningFlag:" + this.kfS.aVv + " timeWait:" + currentTimeMillis + " sending:" + this.kfS.aVu + " recving:" + this.kfS.aVt);
                if (this.kfS.aVv) {
                    if (currentTimeMillis >= 60000) {
                        v.e("MicroMsg.VoiceRemindService", "ERR: Try Run service runningFlag:" + this.kfS.aVv + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + this.kfS.aVu + " recving:" + this.kfS.aVt);
                    } else {
                        return;
                    }
                }
                this.kfS.aVv = true;
                this.kfS.aVu = false;
                this.kfS.aVw = 3;
                this.kfS.aVt = false;
                this.kfS.aVz.cgu = SystemClock.elapsedRealtime();
                this.kfS.aVA.ea(10);
            }
        });
    }
}
