package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.media.AudioTrack;
import android.os.Process;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.Timer;
import java.util.TimerTask;

public final class b {
    private static float kqU = 0.0f;
    private Timer aUI = null;
    private boolean aUJ = false;
    private int cbQ = 3;
    Context context;
    AudioTrack djg = null;
    int djj = 2;
    private int djk = 0;
    private int djl = 0;
    private Runnable djm;
    private int djo = 0;
    int djp = 20;
    private boolean djq = false;
    public boolean kqF = false;
    boolean kqG = false;
    boolean kqH = true;
    e kqI = null;
    private int kqJ = 0;
    private byte[] kqK = null;
    private byte[] kqL = null;
    private byte[] kqM = null;
    private byte[] kqN = null;
    private byte[] kqO = null;
    private int kqP = 0;
    public a kqQ = null;
    private int kqR = 1;
    private int kqS = 1;
    private int kqT = 0;
    private int kqV = 0;
    private int kqW = 0;
    private int kqX = 0;
    private int kqY = 0;
    private int kqZ = 0;
    private int kra = 1;
    private int krb = 0;
    private long krc = 0;
    private long krd = 0;
    private int kre = 1;
    private int krf = 0;
    private int krg = -1;
    private int krh = 0;
    private long kri = 0;
    private int krj = 1;
    private int krk = 0;
    private final Object krl = new Object();
    private int krm = 0;
    private int krn = 0;
    private int kro = 0;
    private int krp = 0;
    private int krq = 0;

    class a extends TimerTask {
        final /* synthetic */ b krr;

        a(b bVar) {
            this.krr = bVar;
        }

        public final void run() {
            System.currentTimeMillis();
            if (this.krr.kqT == 1 && this.krr.kqF) {
                System.currentTimeMillis();
                if (this.krr.kqX + this.krr.djp < this.krr.kqJ && this.krr.krq == 0) {
                    this.krr.krp = 1;
                    int x = this.krr.kqQ.x(this.krr.kqO, this.krr.djp);
                    this.krr.krp = 0;
                    if (x < 0) {
                        v.d("MicroMsg.Voip.AudioPlayer", "Task AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :" + x);
                        return;
                    }
                    synchronized (this.krr.krl) {
                        System.arraycopy(this.krr.kqO, 0, this.krr.kqL, this.krr.kqX, this.krr.djp);
                        b.b(this.krr, this.krr.djp);
                        b.c(this.krr, this.krr.djp >> 1);
                    }
                }
            }
        }
    }

    static /* synthetic */ int b(b bVar, int i) {
        int i2 = bVar.kqX + i;
        bVar.kqX = i2;
        return i2;
    }

    static /* synthetic */ int c(b bVar, int i) {
        int i2 = bVar.kqW + i;
        bVar.kqW = i2;
        return i2;
    }

    static /* synthetic */ int g(b bVar, int i) {
        int i2 = bVar.krf + i;
        bVar.krf = i2;
        return i2;
    }

    static /* synthetic */ int h(b bVar, int i) {
        int i2 = bVar.krf - i;
        bVar.krf = i2;
        return i2;
    }

    static /* synthetic */ int j(b bVar, int i) {
        int i2 = bVar.krk + i;
        bVar.krk = i2;
        return i2;
    }

    static /* synthetic */ int k(b bVar, int i) {
        int i2 = bVar.kqX - i;
        bVar.kqX = i2;
        return i2;
    }

    static /* synthetic */ void m(b bVar, int i) {
        if (bVar.krn != -1 && i < 0) {
            bVar.krn++;
            if (bVar.krn >= 50) {
                bVar.krm = 5;
                bVar.krn = -1;
            }
        }
    }

    static /* synthetic */ int n(b bVar, int i) {
        int i2 = bVar.kqV + i;
        bVar.kqV = i2;
        return i2;
    }

    public final int bbo() {
        return (this.krk / this.djp) * this.djl;
    }

    public final int i(Context context, boolean z) {
        v.d("MicroMsg.Voip.AudioPlayer", "enter to Init...");
        this.context = context;
        if (this.kqP == 2) {
            this.djj = 3;
        } else {
            this.djj = 2;
        }
        this.djo = AudioTrack.getMinBufferSize(this.djk, this.djj, 2);
        if (this.djo == -2 || this.djo == -1) {
            this.krm = 1;
            return -1;
        }
        this.kqZ = this.djo;
        this.krf = this.kqZ * this.kre;
        this.djo *= this.krj;
        float f = ((float) (this.kqZ >> 1)) / ((float) this.djk);
        int rx = l.rx();
        int i = p.ceB.ccj;
        if ((rx & 1024) != 0) {
            if (i <= 0) {
                i = 0;
            }
            v.i("MicroMsg.Voip.AudioPlayer", "CPU ARMv7, ablePlayTimer: " + i);
        } else {
            i = 0;
        }
        if (1000.0f * f < 60.0f || this.kro != 0) {
            i = 0;
        }
        this.kqH = i != 0;
        v.d("MicroMsg.Voip.AudioPlayer", "playBufSize:" + this.djo + "  MinBufSizeInMs:" + f + ",bPlayTimer:" + this.kqH);
        int gM = gM(z);
        try {
            this.djg = new AudioTrack(gM, this.djk, this.djj, 2, this.djo, 1);
        } catch (Exception e) {
            v.w("MicroMsg.Voip.AudioPlayer", "new AudioTrack:", new Object[]{e});
            this.krm = 6;
        }
        if (this.djg == null || this.djg.getState() == 0) {
            this.krm = 2;
            v.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer audioTrack.getState() == AudioTrack.STATE_UNINITIALIZED");
            if (this.djg != null) {
                this.djg.release();
            }
            if (gM == 0) {
                this.djg = new AudioTrack(3, this.djk, this.djj, 2, this.djo, 1);
            } else {
                this.djg = new AudioTrack(0, this.djk, this.djj, 2, this.djo, 1);
            }
        }
        if (this.djg == null) {
            this.krm = 3;
            v.e("MicroMsg.Voip.AudioPlayer", "null == audioTrack return");
            return -1;
        } else if (this.djg.getState() == 0) {
            this.krm = 3;
            v.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer STATE_UNINITIALIZED call AudioTrack.release() and return");
            this.djg.release();
            this.djg = null;
            return -1;
        } else {
            this.kqK = new byte[this.djo];
            if (this.kqK == null) {
                v.e("MicroMsg.Voip.AudioPlayer", "null == playBuffer return");
                return -1;
            }
            this.kqN = new byte[this.djp];
            if (this.kqN == null) {
                v.e("MicroMsg.Voip.AudioPlayer", "null == frmBuffer return");
                return -1;
            }
            if (this.kqH) {
                this.kqJ = this.djo;
                this.kqL = new byte[this.kqJ];
                if (this.kqL == null) {
                    v.e("MicroMsg.Voip.AudioPlayer", "null == playTaskBuffer return");
                    return -1;
                }
                this.kqM = new byte[this.kqJ];
                if (this.kqM == null) {
                    v.e("MicroMsg.Voip.AudioPlayer", "null == playTaskBufferTmp return");
                    return -1;
                }
                this.kqO = new byte[this.djp];
                if (this.kqO == null) {
                    v.e("MicroMsg.Voip.AudioPlayer", "null == frmTaskBuffer return");
                    return -1;
                }
            }
            this.kqF = false;
            this.kqG = false;
            v.i("MicroMsg.Voip.AudioPlayer", "dkbt AudioTrack init ok, mode:%d issp:%b m:%d size %d,nSamplerate:%d", new Object[]{Integer.valueOf(ak.yX().cba.getMode()), Boolean.valueOf(ak.yX().cba.isSpeakerphoneOn()), Integer.valueOf(gM), Integer.valueOf(this.djo), Integer.valueOf(this.djk)});
            return (this.djo * BaseReportManager.MAX_READ_COUNT) / (this.djk * 2);
        }
    }

    public final boolean gL(boolean z) {
        v.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter to switchSpeakerPhone...");
        int gM = gM(z);
        if (ak.yX().qU()) {
            gM = 0;
        }
        v.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:speakerOn:" + z + ":streamtype:" + gM);
        if (this.djg == null || gM != this.djg.getStreamType()) {
            bbs();
            this.djq = true;
            if (this.kqP == 2) {
                this.djj = 3;
            } else {
                this.djj = 2;
            }
            this.djo = AudioTrack.getMinBufferSize(this.djk, this.djj, 2);
            if (this.djo == -2 || this.djo == -1) {
                this.djq = false;
                return false;
            }
            this.kqV = 0;
            this.kqY = 0;
            this.kra = 1;
            this.krb = 0;
            this.krc = 0;
            this.krd = 0;
            this.kre = 1;
            this.krg = -1;
            this.krh = 0;
            this.kqZ = this.djo;
            this.krf = this.kqZ * this.kre;
            this.djo *= this.krj;
            v.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:playBufSize:" + this.djo + "  MinBufSizeInMs:" + (((float) this.kqZ) / 16.0f));
            if (this.djg != null) {
                try {
                    this.djg.stop();
                } catch (Exception e) {
                    v.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone audioTrack.stop Exception:%s", new Object[]{e.getMessage()});
                }
                this.djg.release();
                this.djg = null;
            }
            v.i("MicroMsg.Voip.AudioPlayer", "AudioPlayer dkbt switchSpeakerPhone mode:%d issp:%b m:%d size %d,nSamplerate:%d", new Object[]{Integer.valueOf(ak.yX().cba.getMode()), Boolean.valueOf(ak.yX().cba.isSpeakerphoneOn()), Integer.valueOf(gM), Integer.valueOf(this.djo), Integer.valueOf(this.djk)});
            this.djg = new AudioTrack(gM, this.djk, this.djj, 2, this.djo, 1);
            if (this.djg == null || this.djg.getState() != 0) {
                v.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer leave  switchSpeakerPhone...");
                if (this.djg != null) {
                    this.djq = false;
                    bbq();
                    return true;
                }
                this.djq = false;
                return false;
            }
            v.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone STATE_UNINITIALIZED call AudioTrack.release() and return");
            this.djg.release();
            this.djg = null;
            return false;
        }
        v.d("MicroMsg.Voip.AudioPlayer", "switchSpeakerPhone:stream type do not need to  change");
        return false;
    }

    private int gM(boolean z) {
        int i = 0;
        if (p.ceB.cbs > 0) {
            i = ak.yX().at(z);
        } else if (p.ceB.cbS >= 0) {
            i = p.ceB.cbS;
        }
        if (z && p.ceB.cbT >= 0) {
            i = p.ceB.cbT;
        } else if (!z && p.ceB.cbU >= 0) {
            i = p.ceB.cbU;
        }
        if (1 != this.kro) {
            return i;
        }
        if (p.ceB.cct >= 0) {
            i = p.ceB.cct;
        }
        if (z && p.ceB.ccu >= 0) {
            return p.ceB.ccu;
        }
        if (z || p.ceB.ccv < 0) {
            return i;
        }
        return p.ceB.ccv;
    }

    public final int bbp() {
        if (this.djg != null) {
            this.djg.release();
            this.djg = null;
        }
        this.kqF = false;
        this.kqG = false;
        return 1;
    }

    public final int L(int i, int i2, int i3) {
        if (true == this.kqF) {
            return 0;
        }
        this.djk = i;
        this.kqP = 1;
        this.djl = i2;
        this.kro = i3;
        this.djp = (((this.djk / BaseReportManager.MAX_READ_COUNT) * 1) * this.djl) * 2;
        this.krh = (this.djk * 60) / BaseReportManager.MAX_READ_COUNT;
        return 1;
    }

    public final int bbq() {
        if (true == this.kqF) {
            return 1;
        }
        if (this.djg == null) {
            v.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: audioTrack is null!!");
            return 0;
        }
        this.kqF = true;
        try {
            this.djg.play();
        } catch (Exception e) {
            v.e("MicroMsg.Voip.AudioPlayer", "audioTrack.play Exception:%s", new Object[]{e.getMessage()});
        }
        if (this.djg.getPlayState() != 3) {
            this.krm = 4;
            v.e("MicroMsg.Voip.AudioPlayer", "audioTrack play error: AudioTrack.PLAYSTATE_PLAYING, play do not start !");
            return 0;
        } else if (this.djg.getState() == 0) {
            v.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: AudioTrack.STATE_UNINITIALIZED, no more AudioTrack resource!!");
            return 0;
        } else {
            if (this.kqH) {
                int i;
                if (this.aUJ || this.aUI != null) {
                    v.w("MicroMsg.Voip.AudioPlayer", "Timer has been created or, timer has been started, " + this.aUJ);
                    i = -1;
                } else {
                    this.aUI = new Timer();
                    i = this.aUI == null ? -1 : 0;
                }
                if (i != 0) {
                    v.e("MicroMsg.Voip.AudioPlayer", new StringBuilder("InitAudioRecTimer failed, error code = -1").toString());
                    return 0;
                }
                this.aUI.scheduleAtFixedRate(new a(this), 0, 20);
                this.aUJ = true;
            }
            this.djm = new Runnable(this) {
                final /* synthetic */ b krr;

                {
                    this.krr = r1;
                }

                public final void run() {
                    Process.setThreadPriority(-19);
                    v.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter  to start....");
                    int i = 0;
                    while (this.krr.kqF && this.krr.djg != null) {
                        int playbackHeadPosition;
                        int l;
                        try {
                            playbackHeadPosition = this.krr.djg.getPlaybackHeadPosition();
                        } catch (Exception e) {
                            v.w("MicroMsg.Voip.AudioPlayer", "getPlaybackHeadPosition: ", new Object[]{e});
                            this.krr.krm = 7;
                            playbackHeadPosition = 0;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        this.krr.kqY = this.krr.kqV - playbackHeadPosition;
                        if (this.krr.kra == 1) {
                            this.krr.krb = playbackHeadPosition;
                            this.krr.krc = currentTimeMillis;
                            this.krr.krd = currentTimeMillis;
                            this.krr.kra = 0;
                            this.krr.kri = currentTimeMillis;
                        } else {
                            l = playbackHeadPosition - this.krr.krb;
                            if (l > this.krr.krg) {
                                this.krr.krg = l;
                            } else {
                                this.krr.krg = (int) (((((float) this.krr.krg) * 49999.0f) / 50000.0f) + (((float) l) / 50000.0f));
                            }
                            this.krr.kri = currentTimeMillis;
                            if (this.krr.kqY == 0) {
                                b.g(this.krr, this.krr.kqZ);
                            } else if (currentTimeMillis > this.krr.krd + 5000) {
                                this.krr.krd = currentTimeMillis;
                                if (this.krr.krg < (this.krr.krf >> 1)) {
                                    b.h(this.krr, this.krr.kqZ >> 2);
                                }
                                if (this.krr.krg > this.krr.krf) {
                                    this.krr.krf = this.krr.krg;
                                }
                            }
                            if (this.krr.krf < this.krr.krh) {
                                this.krr.krf = this.krr.krh;
                            }
                            if (this.krr.krf < this.krr.kqZ) {
                                this.krr.krf = this.krr.kqZ;
                            }
                            if (l > 0) {
                                this.krr.krb = playbackHeadPosition;
                            }
                        }
                        if (playbackHeadPosition != 0 && this.krr.kqH) {
                            this.krr.kqT = 1;
                        }
                        if (this.krr.kqQ != null) {
                            b.j(this.krr, this.krr.djp);
                            if (this.krr.kqT == 0) {
                                playbackHeadPosition = this.krr.kqQ.x(this.krr.kqN, this.krr.djp);
                            } else {
                                System.currentTimeMillis();
                                if (this.krr.kqX >= this.krr.djp) {
                                    synchronized (this.krr.krl) {
                                        System.arraycopy(this.krr.kqL, 0, this.krr.kqN, 0, this.krr.djp);
                                        l = this.krr.kqX - this.krr.djp;
                                        System.arraycopy(this.krr.kqL, this.krr.djp, this.krr.kqM, 0, l);
                                        System.arraycopy(this.krr.kqM, 0, this.krr.kqL, 0, l);
                                        b.k(this.krr, this.krr.djp);
                                    }
                                    playbackHeadPosition = 0;
                                } else if (this.krr.kqY >= (this.krr.djk * 5) / BaseReportManager.MAX_READ_COUNT || this.krr.krp != 0) {
                                    com.tencent.mm.plugin.voip.b.a.rT(2);
                                } else {
                                    this.krr.krq = 1;
                                    playbackHeadPosition = this.krr.kqQ.x(this.krr.kqN, this.krr.djp);
                                    this.krr.krq = 0;
                                }
                            }
                            if (playbackHeadPosition < 0) {
                                com.tencent.mm.plugin.voip.b.a.rT(5);
                                v.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :" + playbackHeadPosition);
                            } else if (this.krr.djq) {
                                v.d("MicroMsg.Voip.AudioPlayer", "isSwitching " + this.krr.djq);
                                com.tencent.mm.plugin.voip.b.a.rT(10);
                            } else {
                                this.krr.krc = currentTimeMillis;
                                if (this.krr.djo < this.krr.djp) {
                                    System.arraycopy(this.krr.kqN, 0, this.krr.kqK, i, this.krr.djo - i);
                                    playbackHeadPosition = this.krr.djg.write(this.krr.kqK, 0, this.krr.kqK.length);
                                    if (playbackHeadPosition < 0) {
                                        b.m(this.krr, playbackHeadPosition);
                                        v.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :" + playbackHeadPosition);
                                    }
                                    b.n(this.krr, this.krr.kqK.length >> 1);
                                    playbackHeadPosition = this.krr.djo - i;
                                    i = this.krr.djp - playbackHeadPosition;
                                    while (i >= this.krr.djo) {
                                        this.krr.djg.write(this.krr.kqN, playbackHeadPosition, this.krr.djo);
                                        playbackHeadPosition += this.krr.djo;
                                        i -= this.krr.djo;
                                        b.n(this.krr, this.krr.djo >> 1);
                                    }
                                    System.arraycopy(this.krr.kqN, playbackHeadPosition, this.krr.kqK, 0, i);
                                } else if (!this.krr.djq) {
                                    playbackHeadPosition = this.krr.djg.write(this.krr.kqN, 0, this.krr.djp);
                                    if (playbackHeadPosition < 0) {
                                        b.m(this.krr, playbackHeadPosition);
                                        v.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :" + playbackHeadPosition);
                                    }
                                    b.n(this.krr, this.krr.djp >> 1);
                                }
                            }
                        } else {
                            com.tencent.mm.plugin.voip.b.a.rT(10);
                        }
                    }
                }
            };
            e.b(this.djm, "AudioPlayer_play", 10);
            return 1;
        }
    }

    public final int bbr() {
        if (this.djg == null) {
            v.d("MicroMsg.Voip.AudioPlayer", "  audioTrack==null,m_iPlayBufSizeOrg:" + this.kqZ + ",nSamplerate:" + this.djk);
            return (this.kqZ * BaseReportManager.MAX_READ_COUNT) / this.djk;
        } else if (!this.kqF || this.djg.getState() == 0) {
            return (this.kqZ * BaseReportManager.MAX_READ_COUNT) / this.djk;
        } else {
            try {
                return ((this.kqV - this.djg.getPlaybackHeadPosition()) * BaseReportManager.MAX_READ_COUNT) / this.djk;
            } catch (Exception e) {
                v.e("MicroMsg.Voip.AudioPlayer", "audioTrack getPlaybackHeadPosition error:%s", new Object[]{e.getMessage()});
                return (this.kqZ * BaseReportManager.MAX_READ_COUNT) / this.djk;
            }
        }
    }

    public final int bbs() {
        if (this.aUJ && this.aUI != null) {
            this.aUI.cancel();
            this.aUJ = false;
        }
        if (this.kqF) {
            this.kqF = false;
            this.krk = 0;
            try {
                if (this.djm != null) {
                    e.J(this.djm);
                }
            } catch (Throwable e) {
                v.a("MicroMsg.Voip.AudioPlayer", e, "", new Object[0]);
            }
            try {
                if (this.djg != null) {
                    this.djg.stop();
                    this.djg.release();
                    v.i("MicroMsg.Voip.AudioPlayer", "StopPlay stop audioTrack");
                }
            } catch (Exception e2) {
                v.e("MicroMsg.Voip.AudioPlayer", "StopPlay audioTrack.stop Exception:%s", new Object[]{e2.getMessage()});
            }
        }
        return 1;
    }

    public final int bbt() {
        v.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer  mAudioPlayErrState:" + this.krm);
        return this.krm;
    }

    public final int bbu() {
        if (this.djg != null) {
            return this.djg.getStreamType();
        }
        return gM(true);
    }
}
