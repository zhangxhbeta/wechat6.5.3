package com.tencent.mm.at;

import android.os.Message;
import com.tencent.mm.at.g.a;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.beb;
import com.tencent.mm.protocal.c.bed;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.n;
import com.tencent.mm.v.n.AnonymousClass4;
import java.util.Iterator;

public final class b extends a implements j {
    private int aYJ = 0;
    private e cii;
    private int dag = 0;
    private boolean diB = false;
    private int djS = 120;
    g djT;
    private boolean djU = false;
    private boolean djV = false;
    private int djW = 0;
    private String[] djX = new String[0];
    private int djY = 3960;
    private ac djZ = new ac(this, ak.vA().htb.getLooper()) {
        final /* synthetic */ b dkb;

        public final void handleMessage(Message message) {
            if (message.what == 291 && this.dkb.LJ()) {
                ak.vy().a(this.dkb, 0);
            }
        }
    };
    private String filename = null;

    public final void LG() {
        this.diB = true;
    }

    public final String[] LH() {
        return this.djX;
    }

    public final long LI() {
        return 0;
    }

    public b(String str, String str2) {
        this.filename = str;
        this.djT = new g(str2);
    }

    public final boolean LJ() {
        v.d("MicroMsg.NetSceneNewVoiceInput", "preDoScene");
        this.djZ.removeMessages(291);
        if ((this.djT.LU() && this.diB) || this.djU) {
            v.i("MicroMsg.NetSceneNewVoiceInput", "preDoScene return");
            return false;
        }
        a gz = this.djT.gz(this.dag);
        if (gz != null) {
            int min = Math.min(com.tencent.mm.a.e.aQ(this.filename), gz.dkK);
            v.d("MicroMsg.NetSceneNewVoiceInput", "fileLength %s info.voiceFileMark %s nowMarkLen %s", Integer.valueOf(r3), Integer.valueOf(gz.dkK), Integer.valueOf(min));
            if (min <= 0) {
                v.e("MicroMsg.NetSceneNewVoiceInput", "nowMarkLen <= 0 read failed :%s", this.filename);
                this.aYJ = g.sk() + 40000;
                this.djW = 0;
                LK();
                this.cii.a(3, -1, "ReadFileLengthError", null);
                return false;
            }
            this.djW = min - this.dag;
            if (this.djW < 0) {
                v.i("MicroMsg.NetSceneNewVoiceInput", "canReadLen < 0 length:%s ", Integer.valueOf(this.djW));
                this.aYJ = g.sk() + 40000;
                this.djZ.sendEmptyMessageDelayed(291, (long) (this.djS * 2));
                return false;
            }
            v.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s,reqSeq:%s,interval:%s", Integer.valueOf(this.djW), Integer.valueOf(gz.dkL), Integer.valueOf(this.djS));
            if (this.djW >= 500 || gz.dkL <= 5) {
                this.djZ.sendEmptyMessageDelayed(291, (long) this.djS);
            } else {
                v.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s double interval", Integer.valueOf(this.djW));
                this.djZ.sendEmptyMessageDelayed(291, (long) (this.djS * 2));
            }
            return true;
        }
        this.djZ.sendEmptyMessageDelayed(291, (long) (this.djS * 2));
        return true;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new beb();
        aVar.czo = new bed();
        aVar.uri = "/cgi-bin/micromsg-bin/voicetrans";
        aVar.czm = 235;
        aVar.czp = 381;
        aVar.czq = 1000000381;
        p Bv = aVar.Bv();
        Bv.Bx().lWR = false;
        beb com_tencent_mm_protocal_c_beb = (beb) Bv.czk.czs;
        a gz = this.djT.gz(this.dag);
        if (gz == null) {
            com_tencent_mm_protocal_c_beb.mfg = new are();
            com_tencent_mm_protocal_c_beb.mfb = this.dag;
            com_tencent_mm_protocal_c_beb.mXJ = "0";
            com_tencent_mm_protocal_c_beb.mfh = 1;
            com_tencent_mm_protocal_c_beb.mXL = 0;
            com_tencent_mm_protocal_c_beb.miI = 0;
            com_tencent_mm_protocal_c_beb.mZL = this.djT.LS();
            com_tencent_mm_protocal_c_beb.mZK = com_tencent_mm_protocal_c_beb.mZL == null ? 0 : com_tencent_mm_protocal_c_beb.mZL.size();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            Iterator it = com_tencent_mm_protocal_c_beb.mZL.iterator();
            while (it.hasNext()) {
                stringBuilder.append(((arf) it.next()).mQy).append(", ");
            }
            stringBuilder.append("]");
            v.d("MicroMsg.NetSceneNewVoiceInput", "send empty packet fetch %s time %s", stringBuilder.toString(), Long.valueOf(System.currentTimeMillis()));
            return a(eVar, Bv, this);
        }
        int i;
        gz.dkI = true;
        if (this.djV) {
            gz.dkJ = true;
            com_tencent_mm_protocal_c_beb.mfg = new are();
            v.i("MicroMsg.NetSceneNewVoiceInput", "send last packet");
        } else {
            if (this.djW > this.djY) {
                this.djW = this.djY;
                gz.dkJ = false;
            } else if (this.djW <= this.djY && (gz.dkK != Integer.MAX_VALUE || this.diB)) {
                gz.dkJ = true;
            }
            com_tencent_mm_protocal_c_beb.mfg = new are().ba(com.tencent.mm.a.e.c(this.filename, this.dag, this.djW));
        }
        com_tencent_mm_protocal_c_beb.mfb = this.dag;
        com_tencent_mm_protocal_c_beb.mXJ = gz.dkH;
        if (gz.dkJ) {
            i = 1;
        } else {
            i = 0;
        }
        com_tencent_mm_protocal_c_beb.mfh = i;
        com_tencent_mm_protocal_c_beb.mXL = 0;
        i = gz.dkL + 1;
        gz.dkL = i;
        com_tencent_mm_protocal_c_beb.miI = i;
        com_tencent_mm_protocal_c_beb.mZL = this.djT.LS();
        com_tencent_mm_protocal_c_beb.mZK = com_tencent_mm_protocal_c_beb.mZL == null ? 0 : com_tencent_mm_protocal_c_beb.mZL.size();
        v.d("MicroMsg.NetSceneNewVoiceInput", "%s, read filename: %s, voiceFileMarkEnd: %s, oldReadOffset: %s, canReadLen %s, getILen %s, isRequestEnd: %s, Seq %s, FetchVoiceIds %s", g.sm(), this.filename, Integer.valueOf(gz.dkK), Integer.valueOf(this.dag), Integer.valueOf(this.djW), Integer.valueOf(com_tencent_mm_protocal_c_beb.mfg.mQu), Boolean.valueOf(gz.dkJ), Integer.valueOf(com_tencent_mm_protocal_c_beb.miI), com_tencent_mm_protocal_c_beb.mZL);
        this.dag = com_tencent_mm_protocal_c_beb.mfg.mQu + this.dag;
        v.i("MicroMsg.NetSceneNewVoiceInput", "clientId %s oldReadOffset %s", gz.dkH, Integer.valueOf(this.dag));
        if (gz.dkL == 1) {
            v.i("MicroMsg.NetSceneNewVoiceInput", "time flee send seq 1 time = %s", Long.valueOf(System.currentTimeMillis()));
        }
        v.d("MicroMsg.NetSceneNewVoiceInput", "send dispatch packet time %s", Long.valueOf(System.currentTimeMillis()));
        return a(eVar, Bv, this);
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    protected final int ul() {
        return 2000;
    }

    protected final void a(a aVar) {
        v.w("MicroMsg.NetSceneNewVoiceInput", g.sm() + " setSecurityCheckError e: %s", aVar);
        if (aVar == a.EReachMaxLimit) {
            LK();
            this.cii.a(3, -1, "SecurityCheckError", this);
        }
    }

    protected final boolean BB() {
        return true;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneNewVoiceInput", "%s time:%s errType: %s, errCode: %s, errMsg: %s", g.sm(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 3 && i3 == -1) {
            v.i("MicroMsg.NetSceneNewVoiceInput", "getStack([ %s ]), ThreadID: %s", be.bur(), Long.valueOf(Thread.currentThread().getId()));
        }
        beb com_tencent_mm_protocal_c_beb = (beb) ((com.tencent.mm.v.b) pVar).czk.czs;
        bed com_tencent_mm_protocal_c_bed = (bed) ((com.tencent.mm.v.b) pVar).czl.czs;
        if (i2 == 0 && i3 == 0) {
            v.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd voiceId = %s, seq = %s, time = %s", com_tencent_mm_protocal_c_beb.mXJ, Integer.valueOf(com_tencent_mm_protocal_c_beb.miI), Long.valueOf(System.currentTimeMillis()));
            this.djT.Q(com_tencent_mm_protocal_c_bed.mZO);
            if (this.djT.LU() && this.diB) {
                v.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd isAllRespEnd && isRecordFinish");
                LL();
            }
            this.djX = new String[]{this.djT.LT()};
            this.cii.a(i2, i3, str, this);
            this.djY = com_tencent_mm_protocal_c_bed.mZP <= 0 ? this.djY : com_tencent_mm_protocal_c_bed.mZP;
            this.djS = com_tencent_mm_protocal_c_bed.mOA < 0 ? 120 : com_tencent_mm_protocal_c_bed.mOA;
            v.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd max_send_byte_per_pack = %s, interval = %s", Integer.valueOf(this.djY), Integer.valueOf(this.djS));
            return;
        }
        v.i("MicroMsg.NetSceneNewVoiceInput", g.sm() + " onGYNetEnd file: %s errType:%s errCode:%s", this.filename, Integer.valueOf(i2), Integer.valueOf(i3));
        LK();
        this.cii.a(i2, i3, str, this);
    }

    public final void LK() {
        v.d("MicroMsg.NetSceneNewVoiceInput", g.sm());
        if (!this.djV) {
            this.djV = true;
            LL();
            n vy = ak.vy();
            v.j("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", Integer.valueOf(hashCode()));
            vy.ckz.x(new AnonymousClass4(vy, r1));
            final a gz = this.djT.gz(this.dag);
            if (gz != null) {
                this.djW = 0;
                ak.vA().x(new Runnable(this) {
                    final /* synthetic */ b dkb;

                    public final void run() {
                        v.i("MicroMsg.NetSceneNewVoiceInput", "real doLastScene voiceId:%s, voiceFileMarkEnd:%s,hashCode:%s", gz.dkH, Integer.valueOf(gz.dkK), Integer.valueOf(this.dkb.hashCode()));
                        ak.vy().a(this.dkb, 0);
                    }
                });
            }
        }
    }

    private void LL() {
        v.d("MicroMsg.NetSceneNewVoiceInput", g.sm());
        if (this.djZ != null) {
            this.djZ.removeMessages(291);
        }
        this.djU = true;
    }

    public final int getType() {
        return 235;
    }

    public final void gy(int i) {
        v.d("MicroMsg.NetSceneNewVoiceInput", "%s %s", g.sm(), Integer.valueOf(i));
        if (i < 0) {
            throw new IllegalStateException();
        }
        this.djT.gy(i);
    }
}
