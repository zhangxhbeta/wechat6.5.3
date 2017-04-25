package com.tencent.mm.modelvoice;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.np;
import com.tencent.mm.protocal.c.nq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.b;
import com.tencent.mm.v.k;
import com.tencent.mmdb.FileUtils;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class e extends k implements j {
    private static List<c> diA = new ArrayList();
    private static ac diz = null;
    public String aST;
    public int aYJ = 0;
    private String ble;
    private b cif;
    private com.tencent.mm.v.e cii;
    private ah cxS = new ah(new a(this) {
        final /* synthetic */ e diE;

        {
            this.diE = r1;
        }

        public final boolean oU() {
            if (this.diE.a(this.diE.czE, this.diE.cii) == -1) {
                this.diE.cii.a(3, -1, "doScene failed", this.diE);
            }
            return false;
        }
    }, false);
    private boolean diB = false;
    private boolean diC = false;
    private String diy;

    public static void a(ac acVar) {
        if (diz == null) {
            diz = acVar;
        }
    }

    public static void a(c cVar) {
        if (!diA.contains(cVar)) {
            diA.add(cVar);
        }
    }

    public static void b(c cVar) {
        diA.remove(cVar);
    }

    private void Ls() {
        at atVar;
        String str = this.aST;
        if (str == null) {
            atVar = null;
        } else {
            p lJ = m.Lz().lJ(str);
            if (lJ == null) {
                atVar = null;
            } else {
                ak.yW();
                atVar = c.wJ().ek((long) lJ.dhL);
            }
        }
        if (atVar != null) {
            if (diz != null) {
                diz.a(atVar);
            }
            for (final c cVar : diA) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ e diE;

                    public final void run() {
                        cVar.x(atVar);
                    }
                });
            }
        }
    }

    public e(p pVar) {
        boolean z;
        Assert.assertTrue(pVar != null);
        this.aST = pVar.aST;
        if (this.aST != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        this.diy = pVar.diy;
        this.ble = pVar.ble;
        v.d("MicroMsg.NetSceneDownloadVoice", "NetSceneDownloadVoice:  file[%s] voiceFormat[%s] user[%s]", this.aST, this.diy, this.ble);
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        if (this.aST == null) {
            v.e("MicroMsg.NetSceneDownloadVoice", "doScene:  filename null!");
            this.aYJ = g.sk() + 10000;
            return -1;
        }
        p lJ = m.Lz().lJ(this.aST);
        if (lJ == null || !lJ.LC()) {
            v.e("MicroMsg.NetSceneDownloadVoice", "Get info Failed file:" + this.aST);
            this.aYJ = g.sk() + 10000;
            return -1;
        }
        v.d("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.aST + " netTimes:" + lJ.dhM);
        if (q.lB(this.aST)) {
            int i = lJ.dgC - lJ.dhE;
            if (i > 0) {
                if (lJ.cyu == lJ.dgC) {
                    this.diB = true;
                }
                b.a aVar = new b.a();
                aVar.czn = new np();
                aVar.czo = new nq();
                aVar.uri = "/cgi-bin/micromsg-bin/downloadvoice";
                aVar.czm = FileUtils.S_IWUSR;
                aVar.czp = 20;
                aVar.czq = 1000000020;
                this.cif = aVar.Bv();
                np npVar = (np) this.cif.czk.czs;
                npVar.mcN = lJ.clientId;
                npVar.mcb = lJ.bmL;
                npVar.mff = i;
                npVar.mfb = lJ.dhE;
                if (m.dE(this.ble)) {
                    npVar.moN = this.ble;
                    npVar.mpv = lJ.djG;
                }
                v.i("MicroMsg.NetSceneDownloadVoice", "doScene req.ClientMsgId:%s req.MsgId:%d req.Length:%d req.Offset:%d req.ChatRoomName:%s req.MasterBufId %d", npVar.mcN, Integer.valueOf(npVar.mbT), Integer.valueOf(npVar.mff), Integer.valueOf(npVar.mfb), npVar.moN, Long.valueOf(npVar.mpv));
                return a(eVar, this.cif, this);
            } else if (lJ.status == 5) {
                this.diC = true;
                v.e("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.aST + " Net:" + lJ.dgC + " Local:" + lJ.dhE);
                this.aYJ = g.sk() + 10000;
                return -1;
            } else {
                q.a(this.aST, lJ.dhE, null);
                this.aYJ = g.sk() + 10000;
                return -1;
            }
        }
        v.e("MicroMsg.NetSceneDownloadVoice", "checkVoiceNetTimes Failed file:" + this.aST);
        q.lh(this.aST);
        this.aYJ = g.sk() + 10000;
        return -1;
    }

    protected final int a(p pVar) {
        np npVar = (np) ((b) pVar).czk.czs;
        if (npVar.mcb != 0 && npVar.mcN != null && npVar.mcN.length() != 0 && npVar.mff > 0 && npVar.mfb >= 0) {
            return b.czU;
        }
        q.lh(this.aST);
        return b.czV;
    }

    protected final int ul() {
        return 100;
    }

    protected final void a(a aVar) {
        com.tencent.mm.plugin.report.service.g.iuh.a(111, 233, 1, false);
        q.lh(this.aST);
    }

    public final boolean BA() {
        boolean BA = super.BA();
        if (BA) {
            com.tencent.mm.plugin.report.service.g.iuh.a(111, 232, 1, false);
        }
        return BA;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.aST + " + id:" + i + " errtype:" + i2 + " errCode:" + i3);
        nq nqVar = (nq) ((b) pVar).czl.czs;
        if (nqVar.mfd == 1) {
            v.v("MicroMsg.NetSceneDownloadVoice", this.aST + " cancelFlag = 1");
            q.lF(this.aST);
        } else if (i3 == -22) {
            q.lh(this.aST);
            this.cii.a(i2, i3, str, this);
        } else if (i2 == 4 && i3 != 0) {
            com.tencent.mm.plugin.report.service.g.iuh.a(111, 231, 1, false);
            q.lh(this.aST);
            this.cii.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            v.d("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.aST + " Recv:" + nqVar.mfg.mQu + " fileOff:" + nqVar.mfb);
            if (nqVar.mfg.mQw == null) {
                v.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd get recv Buffer null");
                q.lh(this.aST);
                this.cii.a(i2, i3, str, this);
                return;
            }
            byte[] toByteArray = nqVar.mfg.mQw.toByteArray();
            if (toByteArray.length == 0) {
                v.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Recv Buf ZERO length ");
                q.lh(this.aST);
                this.cii.a(i2, i3, str, this);
                return;
            }
            int write = q.af(this.diy, this.aST).write(toByteArray, toByteArray.length, nqVar.mfb);
            if (write < 0) {
                v.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Write Failed File:" + this.aST + " ret:" + write);
                q.lh(this.aST);
                this.cii.a(i2, i3, str, this);
                return;
            }
            v.i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd : file:" + this.aST + " filesize:" + write + " voiceFormat:" + this.diy);
            write = q.a(this.aST, write, null);
            if (write < 0) {
                com.tencent.mm.plugin.report.service.g.iuh.a(111, 229, 1, false);
                v.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.aST + "updateAfterRecv Ret:" + write);
                this.cii.a(i2, i3, str, this);
            } else if (write == 1) {
                Ls();
                this.cii.a(i2, i3, str, this);
            } else {
                long j = 1000;
                if (this.diB) {
                    j = 0;
                }
                this.cxS.ea(j);
            }
        } else {
            com.tencent.mm.plugin.report.service.g.iuh.a(111, 230, 1, false);
            v.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " resp:" + pVar.ze().lWU);
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return FileUtils.S_IWUSR;
    }
}
