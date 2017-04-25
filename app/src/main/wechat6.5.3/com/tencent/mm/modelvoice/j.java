package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.d.a;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.FileInputStream;

public final class j implements d {
    String aST;
    b aVF;
    private int bkh;
    String diU;
    String diV;
    OnCompletionListener djc;
    OnErrorListener djd;
    AudioTrack djg;
    a djh;
    d.b dji;
    private int djj;
    private int djk;
    private int djl;
    private Runnable djm;
    com.tencent.qqpinyin.voicerecoapi.a djn;
    private int djo;
    int djp;
    boolean djq;
    byte[] djr;
    int djs;
    FileInputStream djt;
    int dju;
    int status;

    static /* synthetic */ void a(j jVar) {
        if (jVar.djm != null) {
            e.J(jVar.djm);
            jVar.djm = null;
        }
    }

    public final int getStatus() {
        return this.status;
    }

    public j() {
        int i = 0;
        this.aST = SQLiteDatabase.KeyEmpty;
        this.djh = null;
        this.dji = null;
        this.status = 0;
        this.djj = 2;
        this.djk = 16000;
        this.bkh = 1;
        this.djl = 20;
        this.djn = null;
        this.djp = 0;
        this.djq = false;
        this.diU = SQLiteDatabase.KeyEmpty;
        this.diV = SQLiteDatabase.KeyEmpty;
        this.djr = new byte[com.tencent.qqpinyin.voicerecoapi.a.ptv];
        this.djs = 0;
        this.djt = null;
        this.dju = 314;
        this.djc = new OnCompletionListener(this) {
            final /* synthetic */ j djv;

            {
                this.djv = r1;
            }

            public final void onCompletion(MediaPlayer mediaPlayer) {
                if (this.djv.aVF != null) {
                    this.djv.aVF.si();
                }
                try {
                    this.djv.status = 0;
                    if (this.djv.djg != null) {
                        this.djv.djg.stop();
                        this.djv.djg.release();
                        this.djv.djg = null;
                    }
                    try {
                        j.a(this.djv);
                    } catch (Throwable e) {
                        v.e("MicroMsg.SpeexPlayer", "exception:%s", be.e(e));
                    }
                } catch (Throwable e2) {
                    v.e("MicroMsg.SpeexPlayer", "exception:%s", be.e(e2));
                    v.e("MicroMsg.SpeexPlayer", "setCompletion File[" + this.djv.aST + "] ErrMsg[" + e2.getStackTrace() + "]");
                }
            }
        };
        this.djd = new OnErrorListener(this) {
            final /* synthetic */ j djv;

            {
                this.djv = r1;
            }

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                v.d("MicroMsg.SpeexPlayer", "onError");
                if (this.djv.aVF != null) {
                    this.djv.aVF.si();
                }
                if (this.djv.dji != null) {
                    this.djv.dji.onError();
                }
                try {
                    this.djv.status = -1;
                    if (this.djv.djg != null) {
                        this.djv.djg.stop();
                        this.djv.djg.release();
                        this.djv.djg = null;
                    }
                    try {
                        j.a(this.djv);
                    } catch (Throwable e) {
                        v.e("MicroMsg.SpeexPlayer", "exception:%s", be.e(e));
                    }
                } catch (Exception e2) {
                    v.e("MicroMsg.SpeexPlayer", "setErrorListener File[" + this.djv.aST + "] ErrMsg[" + e2.getStackTrace() + "]");
                }
                return false;
            }
        };
        this.djn = new com.tencent.qqpinyin.voicerecoapi.a();
        com.tencent.qqpinyin.voicerecoapi.a aVar = this.djn;
        if (aVar.ptz != 0) {
            i = -103;
        } else {
            int nativeTRSpeexDecodeInit = aVar.ptA.nativeTRSpeexDecodeInit();
            if (nativeTRSpeexDecodeInit == -1 || nativeTRSpeexDecodeInit == -100 || nativeTRSpeexDecodeInit == -101 || nativeTRSpeexDecodeInit == -102) {
                i = nativeTRSpeexDecodeInit;
            } else {
                aVar.ptz = nativeTRSpeexDecodeInit;
                aVar.ptx = new byte[(com.tencent.qqpinyin.voicerecoapi.a.ptv * 15)];
            }
        }
        if (i != 0) {
            v.e("speex", "res: " + i);
        }
    }

    public j(Context context) {
        this();
        this.aVF = new b(context);
    }

    public final void a(a aVar) {
        this.djh = aVar;
    }

    public final void a(d.b bVar) {
        this.dji = bVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ak(boolean r9) {
        /*
        r8 = this;
        r1 = 3;
        r7 = 0;
        r4 = 2;
        r6 = 1;
        r8.djq = r6;
        r0 = r8.bkh;
        if (r0 != r4) goto L_0x0052;
    L_0x000a:
        r8.djj = r1;
    L_0x000c:
        r0 = r8.djk;
        r2 = r8.djj;
        r0 = android.media.AudioTrack.getMinBufferSize(r0, r2, r4);
        r8.djo = r0;
        r0 = r8.djg;
        if (r0 == 0) goto L_0x0027;
    L_0x001a:
        r0 = r8.djg;
        r0.stop();
        r0 = r8.djg;
        r0.release();
        r0 = 0;
        r8.djg = r0;
    L_0x0027:
        if (r9 == 0) goto L_0x0055;
    L_0x0029:
        r0 = r1;
    L_0x002a:
        r2 = com.tencent.mm.compatible.d.p.ceB;
        r2 = r2.cbr;
        if (r2 == 0) goto L_0x006a;
    L_0x0030:
        r2 = com.tencent.mm.compatible.d.p.ceB;
        r2.dump();
        r2 = com.tencent.mm.compatible.d.p.ceB;
        r2 = r2.cby;
        if (r2 != r6) goto L_0x006a;
    L_0x003b:
        r0 = new android.media.AudioTrack;
        r2 = r8.djk;
        r3 = r8.djj;
        r5 = r8.djo;
        r5 = r5 * 8;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        r8.djg = r0;
        r0 = r8.djg;	 Catch:{ Exception -> 0x0057 }
        r0.play();	 Catch:{ Exception -> 0x0057 }
    L_0x004f:
        r8.djq = r7;
        return;
    L_0x0052:
        r8.djj = r4;
        goto L_0x000c;
    L_0x0055:
        r0 = r7;
        goto L_0x002a;
    L_0x0057:
        r0 = move-exception;
        r1 = "MicroMsg.SpeexPlayer";
        r2 = "audioTrack error:%s";
        r3 = new java.lang.Object[r6];
        r0 = r0.getMessage();
        r3[r7] = r0;
        com.tencent.mm.sdk.platformtools.v.e(r1, r2, r3);
        goto L_0x004f;
    L_0x006a:
        r1 = r0;
        goto L_0x003b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.j.ak(boolean):void");
    }

    public final boolean E(String str, boolean z) {
        return F(str, z);
    }

    public final boolean c(String str, boolean z, int i) {
        return F(str, z);
    }

    private boolean F(String str, boolean z) {
        if (this.status != 0) {
            v.e("MicroMsg.SpeexPlayer", "startPlay error status:" + this.status);
            return false;
        }
        v.i("MicroMsg.SpeexPlayer", "startPlay");
        this.status = 1;
        this.aST = str;
        try {
            bj(z);
        } catch (Throwable e) {
            try {
                bj(true);
            } catch (Exception e2) {
                v.e("MicroMsg.SpeexPlayer", "startPlay File[" + this.aST + "] failed");
                v.e("MicroMsg.SpeexPlayer", "exception:%s", be.e(e));
                this.status = -1;
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bj(boolean r10) {
        /*
        r9 = this;
        r1 = 3;
        r7 = 0;
        r8 = 1;
        r0 = r9.aST;
        r0 = com.tencent.mm.a.e.aR(r0);
        if (r0 != 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        if (r10 == 0) goto L_0x00b4;
    L_0x000e:
        r0 = r1;
    L_0x000f:
        r2 = com.tencent.mm.compatible.d.p.ceB;	 Catch:{ Exception -> 0x007d }
        r2 = r2.cbr;	 Catch:{ Exception -> 0x007d }
        if (r2 == 0) goto L_0x00cd;
    L_0x0015:
        r2 = com.tencent.mm.compatible.d.p.ceB;	 Catch:{ Exception -> 0x007d }
        r2.dump();	 Catch:{ Exception -> 0x007d }
        r2 = com.tencent.mm.compatible.d.p.ceB;	 Catch:{ Exception -> 0x007d }
        r2 = r2.cby;	 Catch:{ Exception -> 0x007d }
        if (r2 != r8) goto L_0x00cd;
    L_0x0020:
        r0 = r9.djk;	 Catch:{ Exception -> 0x007d }
        r2 = r9.djj;	 Catch:{ Exception -> 0x007d }
        r3 = 2;
        r0 = android.media.AudioTrack.getMinBufferSize(r0, r2, r3);	 Catch:{ Exception -> 0x007d }
        r9.djo = r0;	 Catch:{ Exception -> 0x007d }
        r0 = r9.djg;	 Catch:{ Exception -> 0x007d }
        if (r0 == 0) goto L_0x003c;
    L_0x002f:
        r0 = r9.djg;	 Catch:{ Exception -> 0x007d }
        r0.stop();	 Catch:{ Exception -> 0x007d }
        r0 = r9.djg;	 Catch:{ Exception -> 0x007d }
        r0.release();	 Catch:{ Exception -> 0x007d }
        r0 = 0;
        r9.djg = r0;	 Catch:{ Exception -> 0x007d }
    L_0x003c:
        r0 = new android.media.AudioTrack;	 Catch:{ Exception -> 0x007d }
        r2 = r9.djk;	 Catch:{ Exception -> 0x007d }
        r3 = r9.djj;	 Catch:{ Exception -> 0x007d }
        r4 = 2;
        r5 = r9.djo;	 Catch:{ Exception -> 0x007d }
        r5 = r5 * 8;
        r6 = 1;
        r0.<init>(r1, r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x007d }
        r9.djg = r0;	 Catch:{ Exception -> 0x007d }
        r0 = r9.djk;	 Catch:{ Exception -> 0x007d }
        r0 = r0 / 1000;
        r1 = r9.bkh;	 Catch:{ Exception -> 0x007d }
        r0 = r0 * r1;
        r1 = r9.djl;	 Catch:{ Exception -> 0x007d }
        r0 = r0 * r1;
        r0 = r0 * 2;
        r9.dju = r0;	 Catch:{ Exception -> 0x007d }
        r0 = r9.aVF;	 Catch:{ Exception -> 0x007d }
        if (r0 == 0) goto L_0x0064;
    L_0x005f:
        r0 = r9.aVF;	 Catch:{ Exception -> 0x007d }
        r0.requestFocus();	 Catch:{ Exception -> 0x007d }
    L_0x0064:
        r0 = r9.djg;	 Catch:{ Exception -> 0x007d }
        if (r0 == 0) goto L_0x000b;
    L_0x0068:
        r0 = r9.djg;	 Catch:{ Exception -> 0x00b7 }
        r0.play();	 Catch:{ Exception -> 0x00b7 }
        r0 = new com.tencent.mm.modelvoice.j$3;	 Catch:{ Exception -> 0x007d }
        r0.<init>(r9);	 Catch:{ Exception -> 0x007d }
        r9.djm = r0;	 Catch:{ Exception -> 0x007d }
        r0 = r9.djm;	 Catch:{ Exception -> 0x007d }
        r1 = "SpeexPlayer_play";
        com.tencent.mm.sdk.i.e.a(r0, r1);	 Catch:{ Exception -> 0x007d }
        goto L_0x000b;
    L_0x007d:
        r0 = move-exception;
        r1 = r9.aVF;
        if (r1 == 0) goto L_0x0087;
    L_0x0082:
        r1 = r9.aVF;
        r1.si();
    L_0x0087:
        r1 = "MicroMsg.SpeexPlayer";
        r2 = new java.lang.StringBuilder;
        r3 = "playImp : fail, exception = ";
        r2.<init>(r3);
        r3 = r0.getMessage();
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.v.e(r1, r2);
        r1 = "MicroMsg.SpeexPlayer";
        r2 = "exception:%s";
        r3 = new java.lang.Object[r8];
        r0 = com.tencent.mm.sdk.platformtools.be.e(r0);
        r3[r7] = r0;
        com.tencent.mm.sdk.platformtools.v.e(r1, r2, r3);
        goto L_0x000b;
    L_0x00b4:
        r0 = r7;
        goto L_0x000f;
    L_0x00b7:
        r0 = move-exception;
        r1 = "MicroMsg.SpeexPlayer";
        r2 = "audioTrack error:%s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x007d }
        r4 = 0;
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x007d }
        r3[r4] = r0;	 Catch:{ Exception -> 0x007d }
        com.tencent.mm.sdk.platformtools.v.e(r1, r2, r3);	 Catch:{ Exception -> 0x007d }
        goto L_0x000b;
    L_0x00cd:
        r1 = r0;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.j.bj(boolean):void");
    }

    public final boolean pause() {
        if (this.status != 1) {
            return false;
        }
        this.status = 2;
        synchronized (this.diV) {
            try {
                v.v("MicroMsg.SpeexPlayer", "before mOk.wait");
                long currentTimeMillis = System.currentTimeMillis();
                this.diV.wait();
                v.v("MicroMsg.SpeexPlayer", "after mOk.wait time:" + (System.currentTimeMillis() - currentTimeMillis));
                if (this.aVF != null) {
                    this.aVF.si();
                }
            } catch (Throwable e) {
                v.e("MicroMsg.SpeexPlayer", "exception:%s", be.e(e));
                if (this.aVF != null) {
                    this.aVF.si();
                }
                return false;
            } catch (Throwable th) {
                if (this.aVF != null) {
                    this.aVF.si();
                }
            }
        }
        return true;
    }

    public final boolean oV() {
        if (this.status != 2) {
            return false;
        }
        this.status = 1;
        synchronized (this.diU) {
            try {
                v.v("MicroMsg.SpeexPlayer", "before mpause.notify");
                this.diU.notify();
                v.v("MicroMsg.SpeexPlayer", "after mpause.notify");
                if (this.aVF != null) {
                    this.aVF.requestFocus();
                }
            } catch (Throwable e) {
                v.e("MicroMsg.SpeexPlayer", "exception:%s", be.e(e));
                if (this.aVF != null) {
                    this.aVF.requestFocus();
                }
                return false;
            } catch (Throwable th) {
                if (this.aVF != null) {
                    this.aVF.requestFocus();
                }
            }
        }
        return true;
    }

    public final boolean isPlaying() {
        return this.status == 1;
    }

    public final boolean ph() {
        v.e("MicroMsg.SpeexPlayer", "stop  status:" + this.status);
        if (this.status == 1 || this.status == 2) {
            this.status = 3;
            synchronized (this.diU) {
                try {
                    this.diU.notify();
                    if (this.aVF != null) {
                        this.aVF.si();
                    }
                } catch (Throwable e) {
                    v.e("MicroMsg.SpeexPlayer", "exception:%s", be.e(e));
                    if (this.aVF != null) {
                        this.aVF.si();
                    }
                    return false;
                } catch (Throwable th) {
                    if (this.aVF != null) {
                        this.aVF.si();
                    }
                }
            }
            return true;
        }
        v.e("MicroMsg.SpeexPlayer", "stop  error status:" + this.status);
        return false;
    }

    public final double oY() {
        return 0.0d;
    }
}
