package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.d.a;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class s implements d {
    String aST;
    MediaPlayer djK;
    b djL;
    a djh;
    d.b dji;
    int status;

    public final boolean oV() {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1439)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1461)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r5 = this;
        r1 = 1;
        r0 = 0;
        r2 = r5.status;
        r3 = 2;
        if (r2 == r3) goto L_0x0020;
    L_0x0007:
        r1 = "MicroMsg.VoicePlayer";
        r2 = new java.lang.StringBuilder;
        r3 = "resume not STATUS_PAUSE error status:";
        r2.<init>(r3);
        r3 = r5.status;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.v.e(r1, r2);
    L_0x001f:
        return r0;
    L_0x0020:
        r2 = r5.djK;	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r2.start();	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r0 = r5.djL;
        if (r0 == 0) goto L_0x002e;
    L_0x0029:
        r0 = r5.djL;
        r0.requestFocus();
    L_0x002e:
        r5.status = r1;
        r0 = r1;
        goto L_0x001f;
    L_0x0032:
        r1 = move-exception;
        r2 = "MicroMsg.VoicePlayer";	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r4 = "resume File[";	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r4 = r5.aST;	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r4 = "] ErrMsg[";	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r1 = r1.getStackTrace();	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r1 = r3.append(r1);	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r3 = "]";	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        com.tencent.mm.sdk.platformtools.v.e(r2, r1);	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r1 = -1;	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r5.status = r1;	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r1 = r5.djL;
        if (r1 == 0) goto L_0x001f;
    L_0x0068:
        r1 = r5.djL;
        r1.requestFocus();
        goto L_0x001f;
    L_0x006e:
        r0 = move-exception;
        r1 = r5.djL;
        if (r1 == 0) goto L_0x0078;
    L_0x0073:
        r1 = r5.djL;
        r1.requestFocus();
    L_0x0078:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.s.oV():boolean");
    }

    public final boolean pause() {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1439)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1461)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r5 = this;
        r1 = 1;
        r0 = 0;
        r2 = r5.status;
        if (r2 == r1) goto L_0x001f;
    L_0x0006:
        r1 = "MicroMsg.VoicePlayer";
        r2 = new java.lang.StringBuilder;
        r3 = "pause not STATUS_PLAYING error status:";
        r2.<init>(r3);
        r3 = r5.status;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.v.e(r1, r2);
    L_0x001e:
        return r0;
    L_0x001f:
        r2 = r5.djK;	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r2.pause();	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r0 = r5.djL;
        if (r0 == 0) goto L_0x002d;
    L_0x0028:
        r0 = r5.djL;
        r0.si();
    L_0x002d:
        r0 = 2;
        r5.status = r0;
        r0 = r1;
        goto L_0x001e;
    L_0x0032:
        r1 = move-exception;
        r2 = "MicroMsg.VoicePlayer";	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r4 = "pause File[";	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r4 = r5.aST;	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r4 = "] ErrMsg[";	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r1 = r1.getStackTrace();	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r1 = r3.append(r1);	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r3 = "]";	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        com.tencent.mm.sdk.platformtools.v.e(r2, r1);	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r1 = -1;	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r5.status = r1;	 Catch:{ Exception -> 0x0032, all -> 0x006e }
        r1 = r5.djL;
        if (r1 == 0) goto L_0x001e;
    L_0x0068:
        r1 = r5.djL;
        r1.si();
        goto L_0x001e;
    L_0x006e:
        r0 = move-exception;
        r1 = r5.djL;
        if (r1 == 0) goto L_0x0078;
    L_0x0073:
        r1 = r5.djL;
        r1.si();
    L_0x0078:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.s.pause():boolean");
    }

    public final boolean ph() {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1439)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1461)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r5 = this;
        r1 = 1;
        r0 = 0;
        r2 = r5.status;
        if (r2 == r1) goto L_0x0024;
    L_0x0006:
        r2 = r5.status;
        r3 = 2;
        if (r2 == r3) goto L_0x0024;
    L_0x000b:
        r1 = "MicroMsg.VoicePlayer";
        r2 = new java.lang.StringBuilder;
        r3 = "stop not STATUS_PLAYING or STATUS_PAUSE error status:";
        r2.<init>(r3);
        r3 = r5.status;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.v.e(r1, r2);
    L_0x0023:
        return r0;
    L_0x0024:
        r2 = r5.djK;	 Catch:{ Exception -> 0x003b, all -> 0x0077 }
        r2.stop();	 Catch:{ Exception -> 0x003b, all -> 0x0077 }
        r2 = r5.djK;	 Catch:{ Exception -> 0x003b, all -> 0x0077 }
        r2.release();	 Catch:{ Exception -> 0x003b, all -> 0x0077 }
        r2 = r5.djL;
        if (r2 == 0) goto L_0x0037;
    L_0x0032:
        r2 = r5.djL;
        r2.si();
    L_0x0037:
        r5.status = r0;
        r0 = r1;
        goto L_0x0023;
    L_0x003b:
        r1 = move-exception;
        r2 = "MicroMsg.VoicePlayer";	 Catch:{ Exception -> 0x003b, all -> 0x0077 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x003b, all -> 0x0077 }
        r4 = "stop File[";	 Catch:{ Exception -> 0x003b, all -> 0x0077 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x003b, all -> 0x0077 }
        r4 = r5.aST;	 Catch:{ Exception -> 0x003b, all -> 0x0077 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x003b, all -> 0x0077 }
        r4 = "] ErrMsg[";	 Catch:{ Exception -> 0x003b, all -> 0x0077 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x003b, all -> 0x0077 }
        r1 = r1.getStackTrace();	 Catch:{ Exception -> 0x003b, all -> 0x0077 }
        r1 = r3.append(r1);	 Catch:{ Exception -> 0x003b, all -> 0x0077 }
        r3 = "]";	 Catch:{ Exception -> 0x003b, all -> 0x0077 }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x003b, all -> 0x0077 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x003b, all -> 0x0077 }
        com.tencent.mm.sdk.platformtools.v.e(r2, r1);	 Catch:{ Exception -> 0x003b, all -> 0x0077 }
        r1 = -1;	 Catch:{ Exception -> 0x003b, all -> 0x0077 }
        r5.status = r1;	 Catch:{ Exception -> 0x003b, all -> 0x0077 }
        r1 = r5.djL;
        if (r1 == 0) goto L_0x0023;
    L_0x0071:
        r1 = r5.djL;
        r1.si();
        goto L_0x0023;
    L_0x0077:
        r0 = move-exception;
        r1 = r5.djL;
        if (r1 == 0) goto L_0x0081;
    L_0x007c:
        r1 = r5.djL;
        r1.si();
    L_0x0081:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.s.ph():boolean");
    }

    public final int getStatus() {
        return this.status;
    }

    public s() {
        this.aST = SQLiteDatabase.KeyEmpty;
        this.djh = null;
        this.dji = null;
        this.status = 0;
        this.djK = new MediaPlayer();
        LE();
        LF();
    }

    public s(Context context) {
        this();
        this.djL = new b(context);
    }

    public final void a(a aVar) {
        this.djh = aVar;
    }

    public final void a(d.b bVar) {
        this.dji = bVar;
    }

    private void LE() {
        this.djK.setOnCompletionListener(new OnCompletionListener(this) {
            final /* synthetic */ s djM;

            {
                this.djM = r1;
            }

            public final void onCompletion(MediaPlayer mediaPlayer) {
                if (this.djM.djL != null) {
                    this.djM.djL.si();
                }
                if (this.djM.djh != null) {
                    this.djM.djh.pa();
                }
                try {
                    this.djM.djK.release();
                    this.djM.status = 0;
                } catch (Exception e) {
                    v.e("MicroMsg.VoicePlayer", "setCompletion File[" + this.djM.aST + "] ErrMsg[" + e.getStackTrace() + "]");
                }
            }
        });
    }

    private void LF() {
        this.djK.setOnErrorListener(new OnErrorListener(this) {
            final /* synthetic */ s djM;

            {
                this.djM = r1;
            }

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (this.djM.djL != null) {
                    this.djM.djL.si();
                }
                if (this.djM.dji != null) {
                    this.djM.dji.onError();
                }
                try {
                    this.djM.djK.release();
                    this.djM.status = -1;
                } catch (Exception e) {
                    v.e("MicroMsg.VoicePlayer", "setErrorListener File[" + this.djM.aST + "] ErrMsg[" + e.getStackTrace() + "]");
                }
                return false;
            }
        });
    }

    public final void ak(boolean z) {
        v.d("MicroMsg.VoicePlayer", "setSpeakerOn=" + z);
        if (this.djK != null) {
            if (an.brE) {
                v.v("MicroMsg.VoicePlayer", "setSpeakOn return when calling");
                return;
            }
            int currentPosition = this.djK.getCurrentPosition();
            ph();
            this.djK = new MediaPlayer();
            LE();
            LF();
            d(this.aST, z, currentPosition);
        }
    }

    public final boolean E(String str, boolean z) {
        return d(str, z, 0);
    }

    public final boolean c(String str, boolean z, int i) {
        return d(str, z, i);
    }

    private boolean d(String str, boolean z, int i) {
        if (this.status != 0) {
            v.e("MicroMsg.VoicePlayer", "startPlay error status:" + this.status);
            return false;
        }
        v.i("MicroMsg.VoicePlayer", "startPlay");
        this.aST = str;
        try {
            b(z, i);
        } catch (Throwable e) {
            try {
                b(true, i);
            } catch (Exception e2) {
                v.e("MicroMsg.VoicePlayer", "startPlay File[" + this.aST + "] failed");
                v.e("MicroMsg.VoicePlayer", "exception:%s", be.e(e));
                this.status = -1;
                return false;
            }
        }
        this.status = 1;
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(boolean r7, int r8) {
        /*
        r6 = this;
        r0 = 3;
        r5 = 1;
        r2 = 0;
        r1 = r6.aST;
        r1 = com.tencent.mm.a.e.aR(r1);
        if (r1 != 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        if (r7 == 0) goto L_0x007d;
    L_0x000e:
        r1 = r0;
    L_0x000f:
        r3 = com.tencent.mm.compatible.d.p.ceB;	 Catch:{ Exception -> 0x0047 }
        r3 = r3.cbr;	 Catch:{ Exception -> 0x0047 }
        if (r3 == 0) goto L_0x007f;
    L_0x0015:
        r3 = com.tencent.mm.compatible.d.p.ceB;	 Catch:{ Exception -> 0x0047 }
        r3.dump();	 Catch:{ Exception -> 0x0047 }
        r3 = com.tencent.mm.compatible.d.p.ceB;	 Catch:{ Exception -> 0x0047 }
        r3 = r3.cby;	 Catch:{ Exception -> 0x0047 }
        if (r3 != r5) goto L_0x007f;
    L_0x0020:
        r1 = r6.djL;	 Catch:{ Exception -> 0x0047 }
        if (r1 == 0) goto L_0x0029;
    L_0x0024:
        r1 = r6.djL;	 Catch:{ Exception -> 0x0047 }
        r1.requestFocus();	 Catch:{ Exception -> 0x0047 }
    L_0x0029:
        r1 = r6.djK;	 Catch:{ Exception -> 0x0047 }
        r1.setAudioStreamType(r0);	 Catch:{ Exception -> 0x0047 }
        r0 = r6.djK;	 Catch:{ Exception -> 0x0047 }
        r1 = r6.aST;	 Catch:{ Exception -> 0x0047 }
        r0.setDataSource(r1);	 Catch:{ Exception -> 0x0047 }
        r0 = r6.djK;	 Catch:{ Exception -> 0x0047 }
        r0.prepare();	 Catch:{ Exception -> 0x0047 }
        if (r8 <= 0) goto L_0x0041;
    L_0x003c:
        r0 = r6.djK;	 Catch:{ Exception -> 0x0047 }
        r0.seekTo(r8);	 Catch:{ Exception -> 0x0047 }
    L_0x0041:
        r0 = r6.djK;	 Catch:{ Exception -> 0x0047 }
        r0.start();	 Catch:{ Exception -> 0x0047 }
        goto L_0x000b;
    L_0x0047:
        r0 = move-exception;
        r1 = "MicroMsg.VoicePlayer";
        r3 = new java.lang.StringBuilder;
        r4 = "playImp : fail, exception = ";
        r3.<init>(r4);
        r4 = r0.getMessage();
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.v.e(r1, r3);
        r1 = "MicroMsg.VoicePlayer";
        r3 = "exception:%s";
        r4 = new java.lang.Object[r5];
        r0 = com.tencent.mm.sdk.platformtools.be.e(r0);
        r4[r2] = r0;
        com.tencent.mm.sdk.platformtools.v.e(r1, r3, r4);
        r0 = r6.djL;
        if (r0 == 0) goto L_0x000b;
    L_0x0077:
        r0 = r6.djL;
        r0.si();
        goto L_0x000b;
    L_0x007d:
        r1 = r2;
        goto L_0x000f;
    L_0x007f:
        r0 = r1;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.s.b(boolean, int):void");
    }

    public final boolean isPlaying() {
        return this.status == 1;
    }

    public final double oY() {
        if (this.status != 1 && this.status != 2) {
            return 0.0d;
        }
        try {
            int currentPosition = this.djK.getCurrentPosition();
            int duration = this.djK.getDuration();
            if (duration != 0) {
                return ((double) currentPosition) / ((double) duration);
            }
            v.e("MicroMsg.VoicePlayer", "getDuration File[" + this.aST + "] Failed");
            return 0.0d;
        } catch (Exception e) {
            v.e("MicroMsg.VoicePlayer", "getNowProgress File[" + this.aST + "] ErrMsg[" + e.getStackTrace() + "]");
            ph();
            return 0.0d;
        }
    }
}
