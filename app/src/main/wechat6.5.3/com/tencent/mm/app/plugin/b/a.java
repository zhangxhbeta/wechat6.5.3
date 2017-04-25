package com.tencent.mm.app.plugin.b;

import android.database.Cursor;
import com.tencent.mm.e.a.dy;
import com.tencent.mm.e.a.ec;
import com.tencent.mm.e.a.ef;
import com.tencent.mm.e.a.eh;
import com.tencent.mm.e.a.ei;
import com.tencent.mm.e.a.ej;
import com.tencent.mm.e.a.ek;
import com.tencent.mm.e.a.eo;
import com.tencent.mm.e.a.ep;
import com.tencent.mm.h.j;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.pluginsdk.j.ak;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class a {

    public static class a extends com.tencent.mm.sdk.c.c<dy> {
        i aSK;
        e aSL;
        f aSM;
        d aSN;
        h aSO;
        g aSP;
        c aSQ;
        b aSR;

        public a() {
            this.nhz = dy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            dy dyVar = (dy) bVar;
            if (dyVar.bbR.op == 1) {
                v.i("MicroMsg.SubCoreExtAgent", "ExtAgentLifeEventListener init");
                this.aSK = new i();
                this.aSL = new e();
                this.aSM = new f();
                this.aSN = new d();
                this.aSO = new h();
                this.aSP = new g();
                this.aSQ = new c();
                this.aSR = new b();
                com.tencent.mm.sdk.c.a.nhr.e(this.aSK);
                com.tencent.mm.sdk.c.a.nhr.e(this.aSL);
                com.tencent.mm.sdk.c.a.nhr.e(this.aSM);
                com.tencent.mm.sdk.c.a.nhr.e(this.aSN);
                com.tencent.mm.sdk.c.a.nhr.e(this.aSO);
                com.tencent.mm.sdk.c.a.nhr.e(this.aSP);
                com.tencent.mm.sdk.c.a.nhr.e(this.aSQ);
                com.tencent.mm.sdk.c.a.nhr.e(this.aSR);
            } else if (dyVar.bbR.op == 2) {
                if (this.aSK != null) {
                    com.tencent.mm.sdk.c.a.nhr.f(this.aSK);
                }
                if (this.aSL != null) {
                    com.tencent.mm.sdk.c.a.nhr.f(this.aSL);
                }
                if (this.aSM != null) {
                    com.tencent.mm.sdk.c.a.nhr.f(this.aSM);
                }
                if (this.aSN != null) {
                    com.tencent.mm.sdk.c.a.nhr.f(this.aSN);
                }
                if (this.aSO != null) {
                    com.tencent.mm.sdk.c.a.nhr.f(this.aSO);
                }
                if (this.aSP != null) {
                    com.tencent.mm.sdk.c.a.nhr.f(this.aSP);
                }
                if (this.aSQ != null) {
                    com.tencent.mm.sdk.c.a.nhr.f(this.aSQ);
                }
                if (this.aSR != null) {
                    com.tencent.mm.sdk.c.a.nhr.f(this.aSR);
                }
            }
            return true;
        }
    }

    public static class b extends com.tencent.mm.sdk.c.c<ec> {
        public b() {
            this.nhz = ec.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ec ecVar = (ec) bVar;
            if (ak.lyk != null) {
                ecVar.bcg.bbY = ak.lyk.BD(ecVar.bcf.bch);
            }
            return true;
        }
    }

    public static class c extends com.tencent.mm.sdk.c.c<ef> {
        public c() {
            this.nhz = ef.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ef efVar = (ef) bVar;
            k iVar = new com.tencent.mm.modelmulti.i(efVar.bcz.bcB, efVar.bcz.content, efVar.bcz.type);
            efVar.bcA.bcC = iVar;
            efVar.bcA.bao = iVar.bao;
            return true;
        }
    }

    public static class d extends com.tencent.mm.sdk.c.c<eh> {
        com.tencent.mm.c.a.a aSS;
        String aST;

        public d() {
            this.nhz = eh.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            eh ehVar = (eh) bVar;
            if (be.kS(ehVar.bcF.aST) && ehVar.bcF.op == 1) {
                v.e("MicroMsg.SubCoreExtAgent", "fileName(%s) is null or nil.", ehVar.bcF.aST);
            } else if (ehVar.bcF.op == 1) {
                if (this.aSS == null) {
                    this.aSS = new com.tencent.mm.c.a.a(aa.getContext());
                } else if (!ehVar.bcF.aST.equals(this.aST)) {
                    if (this.aSS.isPlaying()) {
                        this.aSS.stop();
                    }
                    this.aST = ehVar.bcF.aST;
                } else if (this.aSS.oZ()) {
                    ehVar.bcG.aYN = this.aSS.oV();
                } else if (this.aSS.isPlaying()) {
                    ehVar.bcG.aYN = false;
                }
                this.aSS.aTk = ehVar.bcF.bcI;
                this.aSS.aTj = ehVar.bcF.bcJ;
                ehVar.bcG.aYN = this.aSS.a(ehVar.bcF.aST, ehVar.bcF.aTe, ehVar.bcF.bcH, -1);
            } else if (ehVar.bcF.op == 2) {
                if (this.aSS != null) {
                    this.aSS.stop();
                }
            } else if (ehVar.bcF.op == 4 && this.aSS != null && this.aSS.isPlaying()) {
                ehVar.bcG.aYN = this.aSS.pause();
            }
            return true;
        }
    }

    public static class e extends com.tencent.mm.sdk.c.c<ei> {
        String aST;
        com.tencent.mm.c.b.h aSU;

        public e() {
            this.aST = SQLiteDatabase.KeyEmpty;
            this.nhz = ei.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ei eiVar = (ei) bVar;
            if (eiVar.bcK.op == 1) {
                if (this.aSU == null) {
                    this.aSU = new com.tencent.mm.c.b.h(aa.getContext(), false);
                }
                eiVar.bcL.aYN = this.aSU.by(eiVar.bcK.username);
                this.aST = this.aSU.getFileName();
                v.d("MicroMsg.SubCoreExtAgent", "data.op = [%s], ret = [%s]", Integer.valueOf(eiVar.bcK.op), Boolean.valueOf(eiVar.bcL.aYN));
            } else if (eiVar.bcK.op == 2 && this.aSU != null) {
                eiVar.bcL.aST = this.aST;
                eiVar.bcL.aYN = this.aSU.ph();
                v.d("MicroMsg.SubCoreExtAgent", "data.op = [%s], fileName = [%s], ret = [%s]", Integer.valueOf(eiVar.bcK.op), this.aST, Boolean.valueOf(eiVar.bcL.aYN));
                this.aST = SQLiteDatabase.KeyEmpty;
            }
            return true;
        }
    }

    public static class f extends com.tencent.mm.sdk.c.c<ek> {
        String aST;
        com.tencent.mm.modelvoice.k aSV;
        ah aSW;
        boolean aSX;
        boolean aSY;
        boolean aSZ;
        ek aTa;
        Runnable aTb;

        public f() {
            this.aST = SQLiteDatabase.KeyEmpty;
            this.nhz = ek.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ek ekVar = (ek) bVar;
            if (ekVar instanceof ek) {
                if (ekVar.bcM.op == 1) {
                    if (this.aSV == null) {
                        this.aSV = new com.tencent.mm.modelvoice.k();
                    }
                    this.aTb = ekVar.bcM.aTb;
                    if (this.aSV.mStatus == 1) {
                        this.aSV.pb();
                    }
                    ekVar.bcN.aYN = this.aSV.bx(ekVar.bcM.filePath);
                    v.i("MicroMsg.SubCoreExtAgent", "MaxVoiceRecordTime (%d)", Long.valueOf((long) (be.getInt(j.sV().z("OpenApi", "maxVoiceRecordTime"), 60) * 1000)));
                    if (this.aSW == null) {
                        this.aSW = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
                            final /* synthetic */ f aTc;

                            {
                                this.aTc = r1;
                            }

                            public final boolean oU() {
                                v.i("MicroMsg.SubCoreExtAgent", "Voice record timeout.");
                                this.aTc.aSZ = true;
                                this.aTc.oT();
                                return false;
                            }
                        }, false);
                    }
                    if (this.aSW.btC()) {
                        this.aSW.QI();
                    }
                    this.aSZ = false;
                    this.aSW.ea(r2);
                    this.aSX = false;
                    v.d("MicroMsg.SubCoreExtAgent", "data.op = [%s], ret = [%s]", Integer.valueOf(ekVar.bcM.op), Boolean.valueOf(ekVar.bcN.aYN));
                } else if (ekVar.bcM.op == 2 && this.aSV != null) {
                    if (!this.aSX) {
                        this.aSW.QI();
                        v.i("MicroMsg.SubCoreExtAgent", "Voice record stop.");
                        oT();
                    }
                    ekVar.bcN.aYN = this.aSY;
                    v.d("MicroMsg.SubCoreExtAgent", "data.op = [%s], fileName = [%s], ret = [%s]", Integer.valueOf(ekVar.bcM.op), this.aST, Boolean.valueOf(ekVar.bcN.aYN));
                    this.aST = SQLiteDatabase.KeyEmpty;
                    this.aSY = false;
                }
                return true;
            }
            v.f("MicroMsg.SubCoreExtAgent", "mismatched event");
            return false;
        }

        final void oT() {
            if (this.aSV != null) {
                this.aSY = this.aSV.pb();
                if (this.aTb != null) {
                    if (this.aTa != null) {
                        this.aTa.bcN.bcO = this.aSV.aTF.aUs;
                        this.aTa = null;
                    }
                    if (this.aSZ) {
                        this.aTb.run();
                    }
                    this.aTb = null;
                }
                this.aSX = true;
            }
        }
    }

    public static class g extends com.tencent.mm.sdk.c.c<eo> {
        public g() {
            this.nhz = eo.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            p pVar = null;
            eo eoVar = (eo) bVar;
            if (m.Lz() == null) {
                v.e("MicroMsg.SubCoreExtAgent", "SubCoreVoice.getVoiceStg() == null" + be.bur());
            }
            u Lz = m.Lz();
            String str = eoVar.bdh.aST;
            if (str != null) {
                String str2 = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId" + " FROM voiceinfo WHERE FileName= ?";
                Cursor rawQuery = Lz.cuX.rawQuery(str2, new String[]{str});
                v.d("MicroMsg.VoiceStorage", "getInfoByFilename fileName[" + str + "] ResCount:" + rawQuery.getCount());
                if (rawQuery.moveToFirst()) {
                    pVar = new p();
                    pVar.b(rawQuery);
                }
                rawQuery.close();
            }
            if (pVar != null) {
                eoVar.bdi.bao = (long) pVar.dhL;
            }
            return true;
        }
    }

    public static class h extends com.tencent.mm.sdk.c.c<ep> {
        public h() {
            this.nhz = ep.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ep epVar = (ep) bVar;
            if (m.Lz() == null) {
                v.e("MicroMsg.SubCoreExtAgent", "SubCoreVoice.getVoiceStg()" + be.bur());
                epVar.bdk.aST = SQLiteDatabase.KeyEmpty;
            }
            p gx = m.Lz().gx((int) epVar.bdj.bao);
            if (gx == null) {
                epVar.bdk.aST = SQLiteDatabase.KeyEmpty;
            } else {
                epVar.bdk.aST = gx.aST;
            }
            return true;
        }
    }

    public static class i extends com.tencent.mm.sdk.c.c<ej> {
        public i() {
            this.nhz = ej.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            v.i("MicroMsg.SubCoreExtAgent", "requestAccountSync()");
            if (aa.getContext() == null) {
                v.w("MicroMsg.SubCoreExtAgent", "MMApplicationContext.getContext() == null");
                return false;
            }
            com.tencent.mm.modelsimple.d.bb(aa.getContext());
            return true;
        }
    }
}
