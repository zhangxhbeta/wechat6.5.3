package com.tencent.mm.plugin.subapp.c;

import android.os.Message;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.h;
import com.tencent.mm.v.h.b;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class i implements com.tencent.mm.compatible.b.d.a, h {
    private static int aVI = 100;
    private String aST = SQLiteDatabase.KeyEmpty;
    private k aSV = null;
    private int ete = 0;
    private long fTb = 0;
    protected b kfI;
    protected com.tencent.mm.v.h.a kfJ = null;
    private boolean kfK = false;
    private a kfL;
    private long kfM = 0;
    private int kfN = 0;
    private ah kfO = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ i kfP;

        {
            this.kfP = r1;
        }

        public final boolean oU() {
            String a = this.kfP.aST;
            if (a != null) {
                g Ct = h.Ct(a);
                if (Ct == null) {
                    v.d("MicroMsg.VoiceRemindLogic", "startSend null record : " + a);
                } else if (Ct.field_status == 1) {
                    Ct.field_status = 2;
                    Ct.bkU = 64;
                    h.a(Ct);
                }
            }
            d.aZw().run();
            v.d("MicroMsg.VoiceRemindRecorder", "Start Send fileName :" + this.kfP.aST);
            return false;
        }
    }, true);

    private final class a implements Runnable {
        ac handler;
        final /* synthetic */ i kfP;

        public a(final i iVar) {
            this.kfP = iVar;
            this.handler = new ac(this) {
                final /* synthetic */ a kfR;

                public final void handleMessage(Message message) {
                    if (this.kfR.kfP.kfN > 0) {
                        v.d("MicroMsg.VoiceRemindRecorder", "On Part :" + (this.kfR.kfP.kfI == null));
                        this.kfR.kfP.kfN = 2;
                        if (this.kfR.kfP.kfI != null) {
                            this.kfR.kfP.kfI.Bw();
                        }
                    }
                }
            };
        }

        public final void run() {
            if (this.kfP.aSV == null) {
                v.e("MicroMsg.VoiceRemindRecorder", "Stop Record Failed recorder == null");
                return;
            }
            synchronized (this.kfP) {
                if (!this.kfP.aSV.bx(h.as(this.kfP.aST, true))) {
                    h.lG(this.kfP.aST);
                    this.kfP.aST = null;
                    v.d("MicroMsg.VoiceRemindRecorder", "Thread Start Record  Error fileName[" + this.kfP.aST + "]");
                    this.kfP.aSV = null;
                }
                this.kfP.fTb = be.Nj();
                v.d("MicroMsg.VoiceRemindRecorder", "Thread Started Record fileName[" + this.kfP.aST + "] time:" + be.az(this.kfP.kfM));
            }
            this.handler.sendEmptyMessageDelayed(0, 1);
        }
    }

    public final void cK(int i) {
        v.d("MicroMsg.VoiceRemindRecorder", " Recorder onBluetoothHeadsetStateChange :" + i);
        if (!this.kfK) {
            this.kfK = true;
            ak.yX().b((com.tencent.mm.compatible.b.d.a) this);
            this.aSV = new k();
            AnonymousClass2 anonymousClass2 = new com.tencent.mm.v.h.a(this) {
                final /* synthetic */ i kfP;

                {
                    this.kfP = r1;
                }

                public final void onError() {
                    v.e("MicroMsg.VoiceRemindRecorder", "Record Failed file:" + this.kfP.aST);
                    h.lG(this.kfP.aST);
                    if (this.kfP.kfJ != null) {
                        this.kfP.kfJ.onError();
                    }
                }
            };
            this.kfL = new a(this);
            e.a(this.kfL, "VoiceRemindRecorder_record");
            this.kfN = 1;
            this.kfO.ea(3000);
            v.d("MicroMsg.VoiceRemindRecorder", "start end time:" + be.az(this.kfM));
        }
    }

    public final int getMaxAmplitude() {
        if (this.aSV == null) {
            return 0;
        }
        int maxAmplitude = this.aSV.getMaxAmplitude();
        if (maxAmplitude > aVI) {
            aVI = maxAmplitude;
        }
        v.d("getMaxAmplitude", " map: " + maxAmplitude + " max:" + aVI + " per:" + ((maxAmplitude * 100) / aVI));
        return (maxAmplitude * 100) / aVI;
    }

    public final String getFileName() {
        return this.aST;
    }

    public final boolean pq() {
        if (this.aSV != null && this.aSV.mStatus == 1) {
            return true;
        }
        return false;
    }

    public final boolean by(String str) {
        String lb = k.lb(com.tencent.mm.model.k.xF());
        g gVar = new g();
        gVar.field_filename = lb;
        gVar.field_user = str;
        gVar.field_createtime = System.currentTimeMillis() / 1000;
        gVar.field_clientid = lb;
        gVar.field_lastmodifytime = System.currentTimeMillis() / 1000;
        gVar.field_status = 1;
        gVar.field_human = com.tencent.mm.model.k.xF();
        gVar.bkU = -1;
        k aZv = d.aZv();
        v.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert");
        int insert = (int) aZv.cie.insert("VoiceRemindInfo", SQLiteDatabase.KeyEmpty, gVar.py());
        v.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert result" + insert);
        if (insert == -1) {
            lb = null;
        }
        this.aST = lb;
        ak.yX().a((com.tencent.mm.compatible.b.d.a) this);
        int qS = ak.yX().qS();
        this.kfK = false;
        if (qS != 0) {
            cK(100);
        } else {
            new ac(this) {
                final /* synthetic */ i kfP;

                {
                    this.kfP = r1;
                }

                public final void handleMessage(Message message) {
                    v.d("MicroMsg.VoiceRemindRecorder", " Recorder handleMessage");
                    if (!this.kfP.kfK) {
                        ak.yX().b(this.kfP);
                        ak.yX().qT();
                        this.kfP.cK(200);
                    }
                }
            }.sendEmptyMessageDelayed(0, 50);
        }
        return false;
    }

    public final boolean cancel() {
        v.d("MicroMsg.VoiceRemindRecorder", "cancel Record :" + this.aST);
        synchronized (this) {
            v.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.aST);
            if (this.aSV != null) {
                this.aSV.pb();
            }
        }
        String str = this.aST;
        if (str != null) {
            v.d("MicroMsg.VoiceRemindLogic", "Mark Canceled fileName[" + str + "]");
            g Ct = h.Ct(str);
            if (Ct != null) {
                Ct.field_status = 8;
                Ct.field_totallen = c.le(h.as(str, false));
                Ct.bkU = 64;
                h.a(Ct);
            }
        }
        d.aZw().run();
        this.aST = SQLiteDatabase.KeyEmpty;
        return true;
    }

    public final boolean ph() {
        boolean z = true;
        boolean z2 = false;
        ak.yX().qT();
        v.d("MicroMsg.VoiceRemindRecorder", "stop Record :" + this.aST);
        synchronized (this) {
            v.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.aST);
            if (this.aSV != null) {
                this.aSV.pb();
            }
        }
        if (this.kfN != 2) {
            h.lG(this.aST);
            this.aST = null;
            v.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.aST + " by not onPart: " + be.az(this.kfM));
        } else {
            this.ete = (int) pr();
            if (((long) this.ete) < 800 || ((long) this.ete) < 1000) {
                v.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.aST + " by voiceLen: " + this.ete);
                h.lG(this.aST);
                this.aST = SQLiteDatabase.KeyEmpty;
                z = false;
            } else {
                String str = this.aST;
                int i = this.ete;
                if (str != null) {
                    v.d("MicroMsg.VoiceRemindLogic", "StopRecord fileName[" + str + "]");
                    g Ct = h.Ct(str);
                    if (Ct != null) {
                        if (!(Ct.field_status == 97 || Ct.field_status == 98)) {
                            Ct.field_status = 3;
                        }
                        Ct.field_totallen = c.le(h.as(str, false));
                        if (Ct.field_totallen <= 0) {
                            h.lh(str);
                        } else {
                            Ct.field_lastmodifytime = System.currentTimeMillis() / 1000;
                            Ct.field_voicelenght = i;
                            Ct.bkU = 3424;
                            at atVar = new at();
                            atVar.cH(Ct.field_user);
                            atVar.setType(34);
                            atVar.di(1);
                            atVar.cI(str);
                            if (Ct.field_status == 97) {
                                atVar.dh(2);
                                atVar.setContent(f.b(Ct.field_human, (long) Ct.field_voicelenght, false));
                            } else if (Ct.field_status == 98) {
                                atVar.dh(5);
                                atVar.setContent(f.b(Ct.field_human, -1, true));
                            } else {
                                atVar.dh(1);
                            }
                            atVar.z(aw.fN(Ct.field_user));
                            Ct.field_msglocalid = (int) aw.e(atVar);
                            h.a(Ct);
                        }
                    }
                }
                d.aZw().run();
                v.d("MicroMsg.VoiceRemindRecorder", "Stop file success: " + this.aST);
            }
            this.aST = SQLiteDatabase.KeyEmpty;
            z2 = z;
        }
        this.kfN = -1;
        return z2;
    }

    public final long pr() {
        if (this.fTb <= 0) {
            return 0;
        }
        return be.az(this.fTb);
    }

    public final void reset() {
        if (this.aSV != null) {
            this.aSV.pb();
            v.e("MicroMsg.VoiceRemindRecorder", "Reset recorder.stopReocrd");
        }
        this.aST = SQLiteDatabase.KeyEmpty;
        this.kfM = 0;
        this.kfL = null;
        this.kfN = 0;
        this.fTb = 0;
    }

    public final int pp() {
        return this.ete;
    }

    public final void a(com.tencent.mm.v.h.a aVar) {
        this.kfJ = aVar;
    }

    public final void a(b bVar) {
        this.kfI = bVar;
    }

    public final int pt() {
        return 0;
    }
}
