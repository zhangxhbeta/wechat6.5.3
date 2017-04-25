package com.tencent.mm.plugin.multitalk.a;

import android.content.Context;
import com.tencent.mm.c.b.c.a;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.pb.talkroom.sdk.b;
import com.tencent.pb.talkroom.sdk.d;

public final class c implements e {
    a aUE = new a(this) {
        final /* synthetic */ c hze;

        {
            this.hze = r1;
        }

        public final void d(byte[] bArr, int i) {
            if (i <= 0) {
                v.e("MicroMsg.MT.MultiTalkEngine", "pcm data len <= 0");
            } else if (this.hze.hzb != null) {
                this.hze.hzb.C(bArr, i);
            }
        }

        public final void as(int i, int i2) {
            v.i("MicroMsg.MT.MultiTalkEngine", "OnPcmRecListener onRecError %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }
    };
    public d hyY;
    b hyZ;
    com.tencent.mm.c.b.c hza;
    com.tencent.pb.talkroom.sdk.c hzb;
    b hzc;
    com.tencent.mm.plugin.voip.model.a hzd = new com.tencent.mm.plugin.voip.model.a(this) {
        final /* synthetic */ c hze;

        {
            this.hze = r1;
        }

        public final int x(byte[] bArr, int i) {
            int B;
            if (this.hze.hzc != null) {
                B = this.hze.hzc.B(bArr, i);
            } else {
                B = 0;
            }
            if (B < 0) {
                return -1;
            }
            return 0;
        }
    };

    public c() {
        v.i("MicroMsg.MT.MultiTalkEngine", "init multiTalk engine");
        Context context = aa.getContext();
        com.tencent.wecall.talkroom.model.e bPz = com.tencent.wecall.talkroom.model.e.bPz();
        com.tencent.wecall.talkroom.model.e.gA(context);
        this.hyY = bPz;
        this.hyY.bMq();
        this.hyZ = new b();
        int f = be.f((Integer) ak.yT().get(1));
        this.hyY.a(o.aCG(), new com.tencent.pb.talkroom.sdk.e(this) {
            final /* synthetic */ c hze;

            {
                this.hze = r1;
            }

            public final boolean o(int i, String str, String str2) {
                switch (i) {
                    case 0:
                        v.v(str, str2);
                        break;
                    case 1:
                        v.d(str, str2);
                        break;
                    case 2:
                        v.i(str, str2);
                        break;
                    case 3:
                        v.w(str, str2);
                        break;
                    case 4:
                        v.e(str, str2);
                        break;
                    case 5:
                        v.f(str, str2);
                        break;
                    default:
                        v.v(str, str2);
                        break;
                }
                return false;
            }

            public final boolean a(int i, int i2, byte[] bArr) {
                v.i("MicroMsg.MT.MultiTalkEngine", "sendMultiTalkReq " + i + " cmdid " + i2);
                ak.vy().a(new n(i, i2, bArr), 0);
                return false;
            }

            public final boolean aBS() {
                int rx = l.rx();
                v.i("MicroMsg.MT.MultiTalkEngine", "loadVoipCodecLib cpuFlag:" + rx);
                if ((rx & 1024) != 0) {
                    com.tencent.mm.compatible.loader.d.v(aa.getContext(), "libvoipCodec_v7a.so");
                } else if ((rx & 512) != 0) {
                    com.tencent.mm.compatible.loader.d.v(aa.getContext(), "libvoipCodec.so");
                } else {
                    com.tencent.mm.compatible.loader.d.v(aa.getContext(), "libvoipCodec_v5.so");
                }
                return true;
            }

            public final int rx() {
                return l.rx();
            }

            public final int aBT() {
                ak.yW();
                String bxh = com.tencent.mm.model.c.vg().bxh();
                p.dr(bxh);
                v.i("MicroMsg.MT.MultiTalkEngine", "MTSDK audioAdapter startRecord setMultiTalkAppCmd info: " + bxh);
                return this.hze.hyY.a(p.ceB.cbE, p.ceB.cbG, p.ceB.cbF, p.ceB.cbH, p.ceB.cbK, p.ceB.cbL, p.ceB.cbM, p.ceB.cbN, p.ceB.cbB, p.ceB.cbC, p.ceB.ccd, p.ceB.cce, p.ceB.ccf, p.ceB.ccg);
            }

            public final boolean ey(boolean z) {
                v.i("MicroMsg.MT.MultiTalkEngine", "setMultiTalkSpeaker %b", new Object[]{Boolean.valueOf(z)});
                this.hze.hyZ.dE(z);
                return true;
            }

            public final int a(int i, int i2, b bVar) {
                int i3;
                this.hze.hzc = bVar;
                Object obj = this.hze.hyZ;
                com.tencent.mm.plugin.voip.model.a aVar = this.hze.hzd;
                if (obj.bhY) {
                    v.d("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, already start");
                    i3 = -1;
                } else {
                    v.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay");
                    if (obj.gGm == null) {
                        obj.gGm = new com.tencent.mm.plugin.voip.model.b();
                        obj.gGm.L(i, i2, 0);
                    }
                    obj.gGm.i(aa.getContext(), false);
                    obj.gGm.kqQ = aVar;
                    ak.yX().a(obj);
                    obj.gGA = ak.yX().ra();
                    obj.gGz = ak.yX().qU();
                    v.d("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b", new Object[]{Boolean.valueOf(obj.gGA), Boolean.valueOf(obj.gGz)});
                    i3 = obj.gGm.bbq();
                    obj.djL.requestFocus();
                    obj.gGv.a(aa.getContext(), obj);
                    obj.bhY = true;
                }
                v.i("MicroMsg.MT.MultiTalkEngine", "isSpeakerOn=%b isHandsFree=%b", new Object[]{Boolean.valueOf(ak.yX().qZ()), Boolean.valueOf(o.aCG().hzl)});
                if (ak.yX().qZ() != o.aCG().hzl) {
                    this.hze.hyZ.dE(o.aCG().hzl);
                }
                return i3;
            }

            public final int a(int i, int i2, com.tencent.pb.talkroom.sdk.c cVar) {
                this.hze.hzb = cVar;
                this.hze.hza = new com.tencent.mm.c.b.c(i, 7);
                this.hze.hza.cL(i2);
                this.hze.hza.am(true);
                this.hze.hza.pi();
                this.hze.hza.aUc = -19;
                this.hze.hza.r(1, false);
                this.hze.hza.al(true);
                this.hze.hza.aUn = this.hze.aUE;
                if (this.hze.hza.pj()) {
                    return 1;
                }
                return -1;
            }

            public final boolean aBU() {
                v.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer");
                b bVar = this.hze.hyZ;
                if (bVar.bhY) {
                    v.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlay");
                    synchronized (bVar.gGn) {
                        com.tencent.mm.sdk.i.e.a(new a(bVar, bVar.gGm), "MultiTalkAudioPlayer_stop");
                        bVar.bhY = false;
                        bVar.gGm = null;
                    }
                    bVar.gGv.cD(aa.getContext());
                    ak.yX().b(bVar);
                    bVar.djL.si();
                    ak.yX().qT();
                }
                return true;
            }

            public final boolean aBV() {
                v.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkRecord");
                try {
                    if (this.hze.hza != null) {
                        this.hze.hza.aUn = null;
                        this.hze.hza.pb();
                    }
                    this.hze.hza = null;
                    return true;
                } catch (Exception e) {
                    v.w("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer :" + e);
                    return false;
                }
            }
        });
        this.hyY.ay(f, k.xF());
        ak.vy().a(1918, this);
        ak.vy().a(1919, this);
        ak.vy().a(1927, this);
        ak.vy().a(1928, this);
        ak.vy().a(1929, this);
        ak.vy().a(1931, this);
        ak.vy().a(1932, this);
        ak.vy().a(1933, this);
        ak.vy().a(1935, this);
        ak.vy().a(1937, this);
        ak.vy().a(1938, this);
        ak.vy().a(1939, this);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        n nVar = (n) kVar;
        v.i("MicroMsg.MT.MultiTalkEngine", "onSceneEnd errtype " + i + " errCode " + i2 + " cmdid " + nVar.fra);
        this.hyY.c(i2, nVar.fqZ, nVar.fra, nVar.brw);
    }
}
