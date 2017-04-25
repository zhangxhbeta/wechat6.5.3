package com.tencent.mm.ui.chatting;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.e.a.ly;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvoice.c;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.v.g;
import com.tencent.mm.v.g.b;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;

public final class o implements v, c, a, g.a, b {
    private static SensorController evt;
    private int aTg;
    private boolean evD = false;
    boolean evw;
    private av evx;
    long evy = -1;
    private boolean exd = false;
    g fLu;
    private List<at> olp;
    long olq = -1;
    private com.tencent.mm.ui.base.o olr;
    ChattingUI.a ols;
    com.tencent.mm.ui.base.o olt;
    boolean olu;
    boolean olv = true;
    boolean olw = false;
    com.tencent.mm.sdk.c.c olx = new com.tencent.mm.sdk.c.c<ly>(this) {
        final /* synthetic */ o olz;

        {
            this.olz = r2;
            this.nhz = ly.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            long j = ((ly) bVar).bnd.bao;
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.AutoPlay", "playingVoiceId: %s", this.olz.olq);
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.AutoPlay", "msg id is: %s", r11.bnd.bao);
            if (this.olz.olq == j) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 olA;

                    {
                        this.olA = r1;
                    }

                    public final void run() {
                        this.olA.olz.jE(false);
                        this.olA.olz.bDQ();
                    }
                });
            }
            return false;
        }
    };
    private ac oly = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ o olz;

        public final void handleMessage(Message message) {
            boolean z = true;
            super.handleMessage(message);
            try {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.AutoPlay", "reset speaker");
                this.olz.ols.ca(true);
                o oVar = this.olz;
                if (this.olz.ols.evz) {
                    z = false;
                }
                oVar.evw = z;
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.v.a("MicroMsg.AutoPlay", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
    };

    public o(ChattingUI.a aVar, String str) {
        this.ols = aVar;
        if (evt == null) {
            evt = new SensorController(aVar.bzo().getApplicationContext());
        }
        if (this.evx == null) {
            this.evx = new av(aVar.bzo().getApplicationContext());
        }
        OH(str);
        com.tencent.mm.sdk.c.a.nhr.e(this.olx);
        ak.oJ().a(this);
    }

    public final void OH(String str) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.AutoPlay", "changeTalker, isResumeFromDisableScreen: %b", Boolean.valueOf(this.olw));
        if (!this.olw && this.ols != null) {
            this.olp = new LinkedList();
            this.exd = false;
            this.olq = -1;
            this.evw = false;
            this.evy = -1;
            this.olu = false;
            this.aTg = 0;
            if (m.eY(str)) {
                this.aTg = 1;
                this.fLu = new com.tencent.mm.c.a.a(this.ols.bzo(), 1);
                return;
            }
            this.aTg = 0;
            this.fLu = new com.tencent.mm.c.a.a(this.ols.bzo(), 0);
        }
    }

    public final void bDQ() {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.AutoPlay", "clear play list, stack: %s", t.Nm());
        if (this.olr != null) {
            this.olr.dismiss();
        }
        this.olp.clear();
    }

    private void wV(int i) {
        while (this.ols != null) {
            cp bFV = this.ols.bFV();
            if (bFV == null) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.AutoPlay", "add next failed: null adapter");
                return;
            }
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.AutoPlay", "position : " + i + "adapter getCount = " + bFV.getCount());
            if (i >= 0 && i < bFV.getCount()) {
                at atVar = (at) bFV.getItem(i);
                if (atVar != null) {
                    if (atVar.bwb() && atVar.field_isSend == 0 && !q.y(atVar) && !q.z(atVar)) {
                        W(atVar);
                    }
                    i++;
                } else {
                    return;
                }
            }
            return;
        }
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.AutoPlay", "context is null");
    }

    private void W(at atVar) {
        if (atVar != null) {
            ak.yW();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                int size = this.olp.size();
                int i = 0;
                while (i < size) {
                    if (((at) this.olp.get(i)).field_msgId != atVar.field_msgId) {
                        i++;
                    } else {
                        return;
                    }
                }
                if (this.olu || this.olp.size() == 0) {
                    this.olp.add(atVar);
                }
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.AutoPlay", "add voice msg :" + this.olp.size());
            } else if (this.olp.size() > 0) {
                this.olp.clear();
                s.ey(this.ols.bzo());
            }
        }
    }

    public final void a(int i, at atVar) {
        if (atVar != null && atVar.bwb()) {
            n nVar = new n(atVar.field_content);
            if (nVar.time != 0 || atVar.field_isSend != 0) {
                if (atVar.field_status != 1 || atVar.field_isSend != 1) {
                    if (atVar.field_isSend != 0 || nVar.time != -1) {
                        bDQ();
                        ak.yW();
                        Boolean bool = (Boolean) com.tencent.mm.model.c.vf().get(4115, null);
                        if (bool == null || !bool.booleanValue()) {
                            ak.yW();
                            com.tencent.mm.model.c.vf().set(4115, Boolean.valueOf(true));
                            bDX();
                            this.olt = s.a(this.ols.bzo(), this.ols.getString(2131231850), 4000);
                        }
                        if (this.fLu.isPlaying() && atVar.field_msgId == this.olq) {
                            jE(true);
                            return;
                        }
                        W(atVar);
                        if (atVar.field_isSend == 0 && !q.y(atVar)) {
                            wV(i + 1);
                        }
                        bDU();
                    }
                }
            }
        }
    }

    public final void b(int i, at atVar) {
        if (atVar != null) {
            bDQ();
            ak.yW();
            Boolean bool = (Boolean) com.tencent.mm.model.c.vf().get(4115, null);
            if (bool == null || !bool.booleanValue()) {
                ak.yW();
                com.tencent.mm.model.c.vf().set(4115, Boolean.valueOf(true));
                bDX();
                this.olt = s.a(this.ols.bzo(), this.ols.getString(2131231850), 4000);
            }
            if (this.fLu.isPlaying() && atVar.field_msgId == this.olq) {
                jE(true);
                return;
            }
            W(atVar);
            if (atVar.field_isSend == 0 && !q.y(atVar)) {
                wV(i + 1);
            }
            bDU();
        }
    }

    public final void c(int i, at atVar) {
        if (atVar != null) {
            bDQ();
            ak.yW();
            Boolean bool = (Boolean) com.tencent.mm.model.c.vf().get(4115, null);
            if (bool == null || !bool.booleanValue()) {
                ak.yW();
                com.tencent.mm.model.c.vf().set(4115, Boolean.valueOf(true));
                bDX();
                this.olt = s.a(this.ols.bzo(), this.ols.getString(2131231850), 4000);
            }
            if (this.fLu.isPlaying() && atVar.field_msgId == this.olq) {
                jE(true);
                return;
            }
            W(atVar);
            if (atVar.field_isSend == 0 && !q.y(atVar)) {
                wV(i + 1);
            }
            bDU();
        }
    }

    public final void d(int i, at atVar) {
        if (atVar != null) {
            bDQ();
            ak.yW();
            Boolean bool = (Boolean) com.tencent.mm.model.c.vf().get(4115, null);
            if (bool == null || !bool.booleanValue()) {
                ak.yW();
                com.tencent.mm.model.c.vf().set(4115, Boolean.valueOf(true));
                bDX();
                this.olt = s.a(this.ols.bzo(), this.ols.getString(2131231850), 4000);
            }
            if (this.fLu.isPlaying() && atVar.field_msgId == this.olq) {
                jE(true);
                return;
            }
            W(atVar);
            if (atVar.field_isSend == 0 && !q.y(atVar)) {
                wV(i + 1);
            }
            bDU();
        }
    }

    public final void x(at atVar) {
        if ((!this.olv || !this.olp.isEmpty()) && atVar != null && atVar.bwb() && atVar.field_isSend != 1 && atVar.field_talker != null && atVar.field_talker.equals(this.ols.bEn()) && ak.vy().foreground && !this.ols.isFinishing()) {
            if (q.z(atVar)) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.AutoPlay", "should not in this route");
                return;
            }
            W(atVar);
            if (!this.exd && !this.fLu.isPlaying() && t.bm(this.ols.bzo())) {
                bDU();
            }
        }
    }

    public final void bDR() {
        this.exd = true;
        jE(true);
        bDQ();
    }

    public final void bDS() {
        this.exd = false;
        bDU();
    }

    private void bDT() {
        int size = this.olp.size();
        int i = 0;
        int i2 = -1;
        while (i < size) {
            int i3;
            if (((at) this.olp.get(i)).field_msgId == this.olq) {
                i3 = i;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        if (i2 != -1) {
            this.olp.remove(i2);
        }
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.AutoPlay", "remove voice msg : size = " + this.olp.size());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bDU() {
        /*
        r12 = this;
        r5 = 1;
        r6 = 0;
        r0 = "MicroMsg.AutoPlay";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00d0 }
        r2 = "play next: size = ";
        r1.<init>(r2);	 Catch:{ Exception -> 0x00d0 }
        r2 = r12.olp;	 Catch:{ Exception -> 0x00d0 }
        r2 = r2.size();	 Catch:{ Exception -> 0x00d0 }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00d0 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00d0 }
        com.tencent.mm.sdk.platformtools.v.d(r0, r1);	 Catch:{ Exception -> 0x00d0 }
        r0 = r12.olp;	 Catch:{ Exception -> 0x00d0 }
        r0 = r0.size();	 Catch:{ Exception -> 0x00d0 }
        if (r0 > 0) goto L_0x002f;
    L_0x0026:
        r0 = r12.oly;	 Catch:{ Exception -> 0x00d0 }
        r1 = 0;
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0.sendEmptyMessageDelayed(r1, r2);	 Catch:{ Exception -> 0x00d0 }
    L_0x002e:
        return;
    L_0x002f:
        r0 = r12.olp;	 Catch:{ Exception -> 0x00d0 }
        r1 = 0;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x00d0 }
        r0 = (com.tencent.mm.storage.at) r0;	 Catch:{ Exception -> 0x00d0 }
        r2 = r0.field_createTime;	 Catch:{ Exception -> 0x00d0 }
        r0 = r12.olp;	 Catch:{ Exception -> 0x00d0 }
        r7 = r0.size();	 Catch:{ Exception -> 0x00d0 }
        r4 = r5;
        r1 = r6;
    L_0x0042:
        if (r4 >= r7) goto L_0x0063;
    L_0x0044:
        r0 = r12.olp;	 Catch:{ Exception -> 0x00d0 }
        r0 = r0.get(r4);	 Catch:{ Exception -> 0x00d0 }
        r0 = (com.tencent.mm.storage.at) r0;	 Catch:{ Exception -> 0x00d0 }
        r8 = r0.field_createTime;	 Catch:{ Exception -> 0x00d0 }
        r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x018c;
    L_0x0052:
        r0 = r12.olp;	 Catch:{ Exception -> 0x00d0 }
        r0 = r0.get(r4);	 Catch:{ Exception -> 0x00d0 }
        r0 = (com.tencent.mm.storage.at) r0;	 Catch:{ Exception -> 0x00d0 }
        r0 = r0.field_createTime;	 Catch:{ Exception -> 0x00d0 }
        r2 = r4;
    L_0x005d:
        r4 = r4 + 1;
        r10 = r0;
        r1 = r2;
        r2 = r10;
        goto L_0x0042;
    L_0x0063:
        r0 = r12.olp;	 Catch:{ Exception -> 0x00d0 }
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x00d0 }
        r0 = (com.tencent.mm.storage.at) r0;	 Catch:{ Exception -> 0x00d0 }
        if (r0 == 0) goto L_0x002e;
    L_0x006d:
        if (r0 == 0) goto L_0x00e2;
    L_0x006f:
        r1 = r0.bwb();	 Catch:{ Exception -> 0x00d0 }
        if (r1 != 0) goto L_0x008f;
    L_0x0075:
        r1 = r0.bws();	 Catch:{ Exception -> 0x00d0 }
        if (r1 != 0) goto L_0x008f;
    L_0x007b:
        r1 = r0.field_type;	 Catch:{ Exception -> 0x00d0 }
        r2 = -1879048190; // 0xffffffff90000002 float:-2.5243555E-29 double:NaN;
        if (r1 != r2) goto L_0x00de;
    L_0x0082:
        r1 = r5;
    L_0x0083:
        if (r1 != 0) goto L_0x008f;
    L_0x0085:
        r1 = r0.field_type;	 Catch:{ Exception -> 0x00d0 }
        r2 = -1879048189; // 0xffffffff90000003 float:-2.5243558E-29 double:NaN;
        if (r1 != r2) goto L_0x00e0;
    L_0x008c:
        r1 = r5;
    L_0x008d:
        if (r1 == 0) goto L_0x00e2;
    L_0x008f:
        r1 = r5;
    L_0x0090:
        junit.framework.Assert.assertTrue(r1);	 Catch:{ Exception -> 0x00d0 }
        r1 = evt;	 Catch:{ Exception -> 0x00d0 }
        r1 = r1.nll;	 Catch:{ Exception -> 0x00d0 }
        if (r1 != 0) goto L_0x00af;
    L_0x0099:
        r1 = evt;	 Catch:{ Exception -> 0x00d0 }
        r1.a(r12);	 Catch:{ Exception -> 0x00d0 }
        r1 = new com.tencent.mm.ui.chatting.o$3;	 Catch:{ Exception -> 0x00d0 }
        r1.<init>(r12);	 Catch:{ Exception -> 0x00d0 }
        r2 = r12.evx;	 Catch:{ Exception -> 0x00d0 }
        r1 = r2.F(r1);	 Catch:{ Exception -> 0x00d0 }
        if (r1 == 0) goto L_0x00e4;
    L_0x00ab:
        r2 = 0;
        r12.evy = r2;	 Catch:{ Exception -> 0x00d0 }
    L_0x00af:
        com.tencent.mm.model.ak.yW();	 Catch:{ Exception -> 0x00d0 }
        r1 = com.tencent.mm.model.c.isSDCardAvailable();	 Catch:{ Exception -> 0x00d0 }
        if (r1 != 0) goto L_0x00e9;
    L_0x00b8:
        r1 = r0.field_imgPath;	 Catch:{ Exception -> 0x00d0 }
        r1 = com.tencent.mm.platformtools.t.kS(r1);	 Catch:{ Exception -> 0x00d0 }
        if (r1 != 0) goto L_0x00e9;
    L_0x00c0:
        r0 = r12.olp;	 Catch:{ Exception -> 0x00d0 }
        r0.clear();	 Catch:{ Exception -> 0x00d0 }
        r0 = r12.ols;	 Catch:{ Exception -> 0x00d0 }
        r0 = r0.bzo();	 Catch:{ Exception -> 0x00d0 }
        com.tencent.mm.ui.base.s.ey(r0);	 Catch:{ Exception -> 0x00d0 }
        goto L_0x002e;
    L_0x00d0:
        r0 = move-exception;
        r1 = "MicroMsg.AutoPlay";
        r2 = "";
        r3 = new java.lang.Object[r6];
        com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r3);
        goto L_0x002e;
    L_0x00de:
        r1 = r6;
        goto L_0x0083;
    L_0x00e0:
        r1 = r6;
        goto L_0x008d;
    L_0x00e2:
        r1 = r6;
        goto L_0x0090;
    L_0x00e4:
        r2 = -1;
        r12.evy = r2;	 Catch:{ Exception -> 0x00d0 }
        goto L_0x00af;
    L_0x00e9:
        com.tencent.mm.model.ak.yW();	 Catch:{ Exception -> 0x00d0 }
        r1 = com.tencent.mm.model.c.isSDCardAvailable();	 Catch:{ Exception -> 0x00d0 }
        if (r1 == 0) goto L_0x0119;
    L_0x00f2:
        r1 = r12.ols;	 Catch:{ Exception -> 0x00d0 }
        r1 = r1.evz;	 Catch:{ Exception -> 0x00d0 }
        if (r1 == 0) goto L_0x0119;
    L_0x00f8:
        r1 = r12.olr;	 Catch:{ Exception -> 0x00d0 }
        if (r1 == 0) goto L_0x0101;
    L_0x00fc:
        r1 = r12.olr;	 Catch:{ Exception -> 0x00d0 }
        r1.dismiss();	 Catch:{ Exception -> 0x00d0 }
    L_0x0101:
        r1 = r12.ols;	 Catch:{ Exception -> 0x00d0 }
        r1 = r1.bzo();	 Catch:{ Exception -> 0x00d0 }
        r2 = 2130838292; // 0x7f020314 float:1.7281562E38 double:1.052773997E-314;
        r3 = r12.ols;	 Catch:{ Exception -> 0x00d0 }
        r4 = 2131231733; // 0x7f0803f5 float:1.8079555E38 double:1.0529683826E-314;
        r3 = r3.getString(r4);	 Catch:{ Exception -> 0x00d0 }
        r1 = com.tencent.mm.ui.base.s.a(r1, r2, r3);	 Catch:{ Exception -> 0x00d0 }
        r12.olr = r1;	 Catch:{ Exception -> 0x00d0 }
    L_0x0119:
        r1 = "keep_app_silent";
        com.tencent.mm.sdk.platformtools.ab.Ki(r1);	 Catch:{ Exception -> 0x00d0 }
        com.tencent.mm.modelvoice.q.A(r0);	 Catch:{ Exception -> 0x00d0 }
        r1 = r12.fLu;	 Catch:{ Exception -> 0x00d0 }
        r1.stop();	 Catch:{ Exception -> 0x00d0 }
        r1 = r12.ols;	 Catch:{ Exception -> 0x00d0 }
        r1 = r1.oth;	 Catch:{ Exception -> 0x00d0 }
        r2 = 1;
        r1.setKeepScreenOn(r2);	 Catch:{ Exception -> 0x00d0 }
        r1 = r0.field_imgPath;	 Catch:{ Exception -> 0x00d0 }
        r2 = r12.aTg;	 Catch:{ Exception -> 0x00d0 }
        if (r2 != r5) goto L_0x016b;
    L_0x0135:
        r2 = 0;
        r1 = com.tencent.mm.plugin.subapp.c.h.as(r1, r2);	 Catch:{ Exception -> 0x00d0 }
    L_0x013a:
        r2 = "MicroMsg.AutoPlay";
        r3 = "startplay";
        com.tencent.mm.sdk.platformtools.v.i(r2, r3);	 Catch:{ Exception -> 0x00d0 }
        r2 = r12.fLu;	 Catch:{ Exception -> 0x00d0 }
        r3 = r12.evw;	 Catch:{ Exception -> 0x00d0 }
        r4 = 1;
        r5 = -1;
        r1 = r2.a(r1, r3, r4, r5);	 Catch:{ Exception -> 0x00d0 }
        if (r1 == 0) goto L_0x0170;
    L_0x014f:
        r1 = r12.fLu;	 Catch:{ Exception -> 0x00d0 }
        r1.a(r12);	 Catch:{ Exception -> 0x00d0 }
        r1 = r12.fLu;	 Catch:{ Exception -> 0x00d0 }
        r1.a(r12);	 Catch:{ Exception -> 0x00d0 }
        r0 = r0.field_msgId;	 Catch:{ Exception -> 0x00d0 }
        r12.olq = r0;	 Catch:{ Exception -> 0x00d0 }
    L_0x015d:
        r0 = r12.ols;	 Catch:{ Exception -> 0x00d0 }
        r0 = r0.bFV();	 Catch:{ Exception -> 0x00d0 }
        r0.notifyDataSetChanged();	 Catch:{ Exception -> 0x00d0 }
        r0 = 0;
        r12.olw = r0;	 Catch:{ Exception -> 0x00d0 }
        goto L_0x002e;
    L_0x016b:
        r1 = com.tencent.mm.modelvoice.q.iU(r1);	 Catch:{ Exception -> 0x00d0 }
        goto L_0x013a;
    L_0x0170:
        r0 = -1;
        r12.olq = r0;	 Catch:{ Exception -> 0x00d0 }
        r0 = r12.ols;	 Catch:{ Exception -> 0x00d0 }
        r0 = r0.bzo();	 Catch:{ Exception -> 0x00d0 }
        r1 = r12.ols;	 Catch:{ Exception -> 0x00d0 }
        r2 = 2131231868; // 0x7f08047c float:1.807983E38 double:1.0529684493E-314;
        r1 = r1.getString(r2);	 Catch:{ Exception -> 0x00d0 }
        r2 = 0;
        r0 = android.widget.Toast.makeText(r0, r1, r2);	 Catch:{ Exception -> 0x00d0 }
        r0.show();	 Catch:{ Exception -> 0x00d0 }
        goto L_0x015d;
    L_0x018c:
        r10 = r2;
        r2 = r1;
        r0 = r10;
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.o.bDU():void");
    }

    public final void bDV() {
        if (this.fLu != null && this.fLu.isPlaying()) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.AutoPlay", "switchSpeaker, isSpeakerOn: %b, isPlaying: %b", Boolean.valueOf(this.evw), Boolean.valueOf(this.fLu.isPlaying()));
            this.fLu.ak(this.evw);
        }
    }

    public final void release() {
        if (this.evx != null) {
            this.evx.btY();
        }
    }

    public final void jE(boolean z) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.AutoPlay", "stop play");
        ab.Kj("keep_app_silent");
        this.fLu.stop();
        this.ols.releaseWakeLock();
        bDT();
        if (this.olp.isEmpty()) {
            evt.btX();
            this.evx.btY();
        }
        if (z) {
            this.ols.bFV().notifyDataSetChanged();
        }
        this.olq = -1;
        bDX();
        this.olw = false;
    }

    private void bDW() {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.AutoPlay", "stop play complete");
        ab.Kj("keep_app_silent");
        this.ols.releaseWakeLock();
        bDT();
        if (this.olp.isEmpty()) {
            evt.btX();
            this.evx.btY();
        }
        this.ols.bFV().notifyDataSetChanged();
        this.olq = -1;
        bDX();
    }

    public final boolean isPlaying() {
        return this.fLu.isPlaying();
    }

    public final void pa() {
        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.AutoPlay", "voice play completion isSpeakerOn " + this.evw);
        if (this.ols != null) {
            bDW();
            this.ols.releaseWakeLock();
            if (ak.yX().qU()) {
                ad.g(new Runnable(this) {
                    final /* synthetic */ o olz;

                    {
                        this.olz = r1;
                    }

                    public final void run() {
                        this.olz.bDU();
                    }
                }, 500);
            } else {
                bDU();
            }
        }
    }

    public final void onError() {
        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.AutoPlay", "voice play error");
        jE(true);
        bDU();
    }

    public final void bZ(final boolean z) {
        boolean z2 = true;
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.AutoPlay", "onSensorEvent, isON:" + z + "  hasSkip:" + this.evD + " tick:" + t.az(this.evy) + "  lt:" + this.evy);
        if (this.evD) {
            if (z) {
                z2 = false;
            }
            this.evD = z2;
        } else if (this.ols == null) {
            evt.btX();
        } else {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.AutoPlay", "isScreenOn: %s", Boolean.valueOf(this.ols.nDR.nEb));
            if (z || this.evy == -1 || t.az(this.evy) <= 400) {
                this.evD = false;
                if (!this.fLu.oW()) {
                    if (ak.yX().qU()) {
                        bDX();
                        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.AutoPlay", "onSensorEvent, connecting bluetooth, omit sensor event");
                        return;
                    } else if (this.ols.evz) {
                        this.evw = false;
                        if (this.olq != -1) {
                            this.ols.ca(z);
                            this.olw = z;
                        } else {
                            this.ols.ca(true);
                            this.olw = true;
                        }
                        bDV();
                        return;
                    } else {
                        if (this.olq != -1) {
                            if (this.ols.nDR.nEb != z) {
                                this.ols.ca(z);
                                this.olw = z;
                                new ah(new ah.a(this) {
                                    final /* synthetic */ o olz;

                                    public final boolean oU() {
                                        if (z) {
                                            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.AutoPlay", "speaker true");
                                            this.olz.bDX();
                                            if (this.olz.ols != null) {
                                                this.olz.olt = s.a(this.olz.ols.bzo(), this.olz.ols.getString(2131232918), 2000);
                                            }
                                            this.olz.evw = true;
                                            this.olz.bDV();
                                        } else {
                                            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.AutoPlay", "speaker off");
                                            this.olz.evw = false;
                                            o oVar = this.olz;
                                            if (oVar.fLu.isPlaying()) {
                                                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.AutoPlay", "deal sensor event, play next");
                                                oVar.bDU();
                                            }
                                        }
                                        return false;
                                    }
                                }, false).ea(50);
                            } else {
                                return;
                            }
                        }
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.AutoPlay", "onSensorEvent, isResumeFromDisableScreen:%b", Boolean.valueOf(this.olw));
                        return;
                    }
                }
                return;
            }
            this.evD = true;
        }
    }

    final void bDX() {
        if (this.olt != null) {
            this.olt.dismiss();
        }
    }

    public final void yB() {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.AutoPlay", "phone or record stop, resume and do nothing");
    }

    public final void yC() {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.AutoPlay", "phone comming or record start, stop play");
        jE(true);
        bDQ();
    }
}
