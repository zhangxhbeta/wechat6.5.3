package com.tencent.mm.plugin.talkroom.component;

import android.media.AudioTrack;
import android.os.Looper;
import com.tencent.mm.plugin.talkroom.component.e.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class h extends a implements Runnable {
    private static final int kjH = com.tencent.mm.plugin.talkroom.model.a.kjH;
    private int aGp = (((kjH / 1000) * 20) * 2);
    private boolean aSX = false;
    private boolean beg = true;
    private AudioTrack djg;
    private boolean djq = false;
    private boolean dkT = true;
    private int ehf = 0;
    private ac handler = new ac(Looper.getMainLooper());
    private int kjI = kjH;
    private final c kjJ;
    private boolean kjK = false;
    private long kjL = 0;
    private int kjM;
    private long kjN = 0;
    private v2engine kjr;
    private short kjs;
    private short kjt;
    private final Object lock = new Object();

    public h(v2engine com_tencent_mm_plugin_talkroom_component_v2engine, c cVar) {
        this.kjr = com_tencent_mm_plugin_talkroom_component_v2engine;
        this.kjJ = cVar;
        this.djq = true;
        if (this.djg != null && this.djg.getState() == 1) {
            this.djg.stop();
            this.djg.release();
        }
        v2engine.yX().d(true, false);
        int at = v2engine.yX().at(true);
        int minBufferSize = AudioTrack.getMinBufferSize(this.kjI, 2, 2);
        if (minBufferSize != -2 && minBufferSize != -1) {
            this.djg = new AudioTrack(at, this.kjI, 2, 2, minBufferSize * 8, 1);
            this.djq = false;
        }
    }

    public final void aPy() {
        this.beg = true;
        if (this.djg != null && this.djg.getState() == 1) {
            this.djg.pause();
        }
    }

    public final void aZU() {
        if (this.djg != null && this.djg.getState() == 1) {
            this.djg.play();
        }
        synchronized (this.lock) {
            this.beg = false;
            this.lock.notify();
        }
        this.kjt = (short) 0;
        this.kjs = (short) 0;
    }

    public final void release() {
        v.i("MicroMsg.TalkRoomPlayer", "release");
        this.aSX = true;
        if (this.djg != null && this.djg.getState() == 1) {
            this.djg.stop();
            this.djg.release();
        }
        synchronized (this.lock) {
            this.beg = false;
            this.lock.notify();
        }
    }

    public final void run() {
        while (!this.aSX) {
            if (this.djq) {
                try {
                    Thread.sleep(50);
                } catch (Throwable e) {
                    v.a("MicroMsg.TalkRoomPlayer", e, "", new Object[0]);
                }
            } else {
                synchronized (this.lock) {
                    if (this.beg) {
                        try {
                            this.lock.wait();
                        } catch (Throwable e2) {
                            v.a("MicroMsg.TalkRoomPlayer", e2, "", new Object[0]);
                        }
                    }
                }
                long j = this.kjN;
                this.kjN = be.Nj();
                j = this.kjN - j;
                if (j < 20 && j > 0) {
                    try {
                        synchronized (this.lock) {
                            this.lock.wait(j);
                        }
                    } catch (Throwable e22) {
                        v.a("MicroMsg.TalkRoomPlayer", e22, "", new Object[0]);
                    }
                }
                try {
                    int GetAudioData;
                    PByteArray pByteArray = new PByteArray();
                    final PInt pInt = new PInt();
                    final PInt pInt2 = new PInt();
                    int IsSilenceFrame = this.kjr.IsSilenceFrame();
                    if (IsSilenceFrame == 0) {
                        GetAudioData = this.kjr.GetAudioData(pByteArray, this.aGp, pInt, pInt2);
                    } else {
                        GetAudioData = 0;
                    }
                    if (GetAudioData < 0) {
                        this.ehf++;
                        v.e("MicroMsg.TalkRoomPlayer", "GetAudioData err %d,  errcount %d", new Object[]{Integer.valueOf(GetAudioData), Integer.valueOf(this.ehf)});
                        if (this.ehf >= 100) {
                            this.ehf = 0;
                            this.beg = true;
                        }
                    } else {
                        boolean z;
                        if (IsSilenceFrame == 0) {
                            if (this.djg.getPlayState() != 3) {
                                this.djg.play();
                            }
                            byte[] bArr = pByteArray.value;
                            int length = pByteArray.value.length;
                            for (GetAudioData = 0; GetAudioData < length / 2; GetAudioData++) {
                                short s = (short) ((bArr[GetAudioData * 2] & 255) | (bArr[(GetAudioData * 2) + 1] << 8));
                                if (s > this.kjs) {
                                    this.kjs = s;
                                }
                            }
                            this.djg.write(pByteArray.value, 0, pByteArray.value.length);
                        } else if (this.dkT) {
                            this.djg.pause();
                        }
                        if (IsSilenceFrame == 0) {
                            this.kjL = be.Nj();
                            z = false;
                        } else if (be.az(this.kjL) < 1000) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if ((!((!this.dkT && this.kjM == pInt2.value) || z || pInt.value == 0) || (!this.dkT && z)) && !this.kjK) {
                            if (!(z || pInt2.value == 0)) {
                                this.kjM = pInt2.value;
                            }
                            this.handler.postAtFrontOfQueueV2(new Runnable(this) {
                                final /* synthetic */ h kjR;

                                public final void run() {
                                    this.kjR.kjK = true;
                                    try {
                                        this.kjR.kjJ.h(pInt.value, pInt2.value, z);
                                    } catch (Throwable e) {
                                        v.a("MicroMsg.TalkRoomPlayer", e, "", new Object[0]);
                                    }
                                    this.kjR.kjK = false;
                                }
                            });
                            this.dkT = z;
                        }
                    }
                } catch (Throwable e222) {
                    v.a("MicroMsg.TalkRoomPlayer", e222, "", new Object[0]);
                    v.e("MicroMsg.TalkRoomPlayer", e222.toString());
                }
            }
        }
    }

    public final int aZT() {
        if (this.kjt < this.kjs) {
            this.kjt = this.kjs;
        }
        if (this.kjt == (short) 0) {
            return 0;
        }
        short s = (short) ((this.kjs * 100) / this.kjt);
        this.kjs = (short) 0;
        return s;
    }

    public final void start() {
        e.c(this, "TalkRoomPlayer_start").start();
    }
}
