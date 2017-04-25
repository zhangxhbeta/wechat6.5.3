package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Process;
import android.widget.Toast;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public final class i implements d {
    private static Object diW = new Object();
    private static int diX = -1;
    private static int diY;
    public int aTB;
    public int aUr;
    private AudioTrack diO;
    private a diP;
    private b diQ;
    private com.tencent.mm.modelvoice.d.a diR;
    private d.b diS;
    private boolean diT;
    private String diU;
    private String diV;
    private int diZ;
    private int dja;
    private com.tencent.mm.c.c.b djb;
    private OnCompletionListener djc;
    private OnErrorListener djd;
    private String mFileName;
    private int mStatus;

    private class a implements Runnable {
        final /* synthetic */ i dje;

        private a(i iVar) {
            this.dje = iVar;
        }

        public final void run() {
            Process.setThreadPriority(-16);
            byte[] bArr = new byte[(AudioTrack.getMinBufferSize(this.dje.aTB, 2, 2) * 2)];
            short f = (short) ((this.dje.aTB * 20) / 1000);
            v.d("MicroMsg.SilkPlayer", "frameLen: %d, playBufferSize: %d", Short.valueOf(f), Integer.valueOf(AudioTrack.getMinBufferSize(this.dje.aTB, 2, 2) * 2));
            v.i("MicroMsg.SilkPlayer", "Thread start");
            while (true) {
                if (this.dje.mStatus != 1 && this.dje.mStatus != 2) {
                    break;
                }
                synchronized (i.diW) {
                    if (i.diY != this.dje.diZ) {
                        v.i("MicroMsg.SilkPlayer", "[%d] diff id, useDeocder: %d", Integer.valueOf(this.dje.diZ), Integer.valueOf(i.diY));
                        this.dje.lw(this.dje.mFileName);
                    }
                }
                int SilkDoDec = MediaRecorder.SilkDoDec(bArr, f);
                if (SilkDoDec < 0) {
                    this.dje.mStatus = 0;
                    g.iuh.a(161, 0, 1, false);
                    g.iuh.a(161, 4, 1, false);
                    v.e("MicroMsg.SilkPlayer", "[%d] SilkDoDec failed: %d", Integer.valueOf(this.dje.diZ), Integer.valueOf(SilkDoDec));
                    if (this.dje.djb != null && q.dqO) {
                        this.dje.djb.pw();
                    }
                } else {
                    if (q.dqO && this.dje.djb != null) {
                        this.dje.djb.h(bArr, f * 2);
                    }
                    while (this.dje.diT) {
                        v.d("MicroMsg.SilkPlayer", "waitting for switching complete");
                        Thread.sleep(20);
                    }
                    try {
                        this.dje.diO.write(bArr, 0, f * 2);
                    } catch (Exception e) {
                        v.e("MicroMsg.SilkPlayer", "write audio track failed: %s", e.getMessage());
                        g.iuh.a(161, 0, 1, false);
                        g.iuh.a(161, 5, 1, false);
                    }
                    this.dje.dja = this.dje.dja + 1;
                    if (SilkDoDec == 0) {
                        this.dje.mStatus = 0;
                        v.i("MicroMsg.SilkPlayer", "[%d] play completed", Integer.valueOf(this.dje.diZ));
                        if (this.dje.djb != null && q.dqO) {
                            this.dje.djb.pw();
                            ad.o(new Runnable(this) {
                                final /* synthetic */ a djf;

                                {
                                    this.djf = r1;
                                }

                                public final void run() {
                                    Toast.makeText(aa.getContext(), "Save to: " + this.djf.dje.djb.aVL, 1).show();
                                }
                            });
                        }
                    } else if (this.dje.mStatus == 2) {
                        synchronized (this.dje.diV) {
                            try {
                                v.v("MicroMsg.SilkPlayer", "before mOk.notify");
                                this.dje.diV.notify();
                                v.v("MicroMsg.SilkPlayer", "after mOk.notify");
                            } catch (Throwable e2) {
                                v.e("MicroMsg.SilkPlayer", "exception:%s", be.e(e2));
                            }
                        }
                        try {
                            synchronized (this.dje.diU) {
                                try {
                                    v.v("MicroMsg.SilkPlayer", "before mpause.wait");
                                    this.dje.diU.wait();
                                    v.v("MicroMsg.SilkPlayer", "after mpause.wait");
                                } catch (Throwable e22) {
                                    v.e("MicroMsg.SilkPlayer", "exception:%s", be.e(e22));
                                }
                            }
                        } catch (Throwable e222) {
                            g.iuh.a(161, 0, 1, false);
                            v.e("MicroMsg.SilkPlayer", "exception:%s", be.e(e222));
                            if (this.dje.djd != null) {
                                this.dje.djd.onError(null, 0, 0);
                            }
                            this.dje.mStatus = 0;
                        }
                    } else {
                        synchronized (this.dje.diV) {
                            try {
                                this.dje.diV.notify();
                            } catch (Throwable e2222) {
                                v.e("MicroMsg.SilkPlayer", "exception:%s", be.e(e2222));
                            }
                        }
                    }
                }
            }
            if (this.dje.mStatus != 3) {
                Thread.sleep(1000);
            }
            synchronized (i.diW) {
                if (i.diY == this.dje.diZ) {
                    MediaRecorder.SilkDecUnInit();
                    v.i("MicroMsg.SilkPlayer", "[%d] SilkDecUnInit", Integer.valueOf(this.dje.diZ));
                    i.diY = -1;
                }
            }
            if (this.dje.mStatus != 3) {
                if (this.dje.diR != null) {
                    this.dje.diR.pa();
                }
                if (this.dje.djc != null) {
                    this.dje.djc.onCompletion(null);
                }
            } else if (this.dje.diO != null) {
                v.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
                this.dje.diO.stop();
                this.dje.diO.release();
                this.dje.diO = null;
            }
        }
    }

    public final int getStatus() {
        return this.mStatus;
    }

    public i() {
        this.diR = null;
        this.diS = null;
        this.aUr = 2;
        this.aTB = 16000;
        this.mFileName = SQLiteDatabase.KeyEmpty;
        this.mStatus = 0;
        this.diT = false;
        this.diU = SQLiteDatabase.KeyEmpty;
        this.diV = SQLiteDatabase.KeyEmpty;
        this.dja = 0;
        this.djb = null;
        this.djc = new OnCompletionListener(this) {
            final /* synthetic */ i dje;

            {
                this.dje = r1;
            }

            public final void onCompletion(MediaPlayer mediaPlayer) {
                if (this.dje.diQ != null) {
                    this.dje.diQ.si();
                }
                try {
                    this.dje.mStatus = 0;
                    if (this.dje.diO != null) {
                        v.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
                        this.dje.diO.stop();
                        this.dje.diO.release();
                        this.dje.diO = null;
                    }
                } catch (Throwable e) {
                    v.e("MicroMsg.SilkPlayer", "exception:%s", be.e(e));
                    v.e("MicroMsg.SilkPlayer", "setCompletion File[" + this.dje.mFileName + "] ErrMsg[" + e.getStackTrace() + "]");
                }
            }
        };
        this.djd = new OnErrorListener(this) {
            final /* synthetic */ i dje;

            {
                this.dje = r1;
            }

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                v.i("MicroMsg.SilkPlayer", "onError");
                if (this.dje.diQ != null) {
                    this.dje.diQ.si();
                }
                if (this.dje.diS != null) {
                    this.dje.diS.onError();
                }
                try {
                    this.dje.mStatus = -1;
                    if (this.dje.diO != null) {
                        v.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
                        this.dje.diO.stop();
                        this.dje.diO.release();
                        this.dje.diO = null;
                    }
                } catch (Exception e) {
                    v.e("MicroMsg.SilkPlayer", "setErrorListener File[" + this.dje.mFileName + "] ErrMsg[" + e.getStackTrace() + "]");
                }
                return false;
            }
        };
        diX++;
        this.diZ = diX;
        v.i("MicroMsg.SilkPlayer", "[%d] new Instance", Integer.valueOf(this.diZ));
    }

    public i(Context context) {
        this();
        this.diQ = new b(context);
    }

    public final void a(com.tencent.mm.modelvoice.d.a aVar) {
        this.diR = aVar;
    }

    public final void a(d.b bVar) {
        this.diS = bVar;
    }

    public final void ak(boolean z) {
        v.d("MicroMsg.SilkPlayer", "setSpeakerOn: %b", Boolean.valueOf(z));
        this.diT = true;
        this.aUr = 2;
        bi(z);
        try {
            this.diO.play();
        } catch (Exception e) {
            g.iuh.a(161, 0, 1, false);
            g.iuh.a(161, 3, 1, false);
            v.e("MicroMsg.SilkPlayer", "audioTrack error:%s", e.getMessage());
        }
        this.diT = false;
    }

    private void bi(boolean z) {
        int i;
        int minBufferSize;
        AudioTrack audioTrack;
        if (this.diO != null) {
            v.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
            try {
                this.diO.stop();
                this.diO.release();
            } catch (Exception e) {
                v.e("MicroMsg.SilkPlayer", "mAudioTrack.stop() error: %s", e.getMessage());
            }
            this.diO = null;
        }
        int i2 = this.aTB;
        int i3 = this.aUr;
        int i4 = z ? 3 : 0;
        if (p.ceB.cbr) {
            p.ceB.dump();
            if (z && p.ceB.cbT >= 0) {
                i = p.ceB.cbT;
                minBufferSize = AudioTrack.getMinBufferSize(i2, i3, 2);
                v.i("AudioDeviceFactory", "speakerOn: %b, type: %d, sampleRate: %d, channelConfig: %d, PlayBufSize: %d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(minBufferSize));
                audioTrack = new AudioTrack(i, i2, i3, 2, minBufferSize * 8, 1);
                if (audioTrack.getState() == 0) {
                    v.i("AudioDeviceFactory", "reconstruct AudioTrack");
                    if (i == 0) {
                    }
                    audioTrack = new AudioTrack(i == 0 ? 3 : 0, i2, i3, 2, minBufferSize * 8, 1);
                }
                v.i("AudioDeviceFactory", "AudioTrack state: " + audioTrack.getState());
                this.diO = audioTrack;
                if (this.diO != null) {
                }
                g.iuh.a(161, 0, 1, false);
                g.iuh.a(161, 2, 1, false);
            } else if (!z && p.ceB.cbU >= 0) {
                i = p.ceB.cbU;
                minBufferSize = AudioTrack.getMinBufferSize(i2, i3, 2);
                v.i("AudioDeviceFactory", "speakerOn: %b, type: %d, sampleRate: %d, channelConfig: %d, PlayBufSize: %d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(minBufferSize));
                audioTrack = new AudioTrack(i, i2, i3, 2, minBufferSize * 8, 1);
                if (audioTrack.getState() == 0) {
                    v.i("AudioDeviceFactory", "reconstruct AudioTrack");
                    audioTrack = new AudioTrack(i == 0 ? 3 : 0, i2, i3, 2, minBufferSize * 8, 1);
                }
                v.i("AudioDeviceFactory", "AudioTrack state: " + audioTrack.getState());
                this.diO = audioTrack;
                if (this.diO != null || this.diO.getState() == 0) {
                    g.iuh.a(161, 0, 1, false);
                    g.iuh.a(161, 2, 1, false);
                }
                return;
            }
        }
        i = i4;
        minBufferSize = AudioTrack.getMinBufferSize(i2, i3, 2);
        v.i("AudioDeviceFactory", "speakerOn: %b, type: %d, sampleRate: %d, channelConfig: %d, PlayBufSize: %d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(minBufferSize));
        audioTrack = new AudioTrack(i, i2, i3, 2, minBufferSize * 8, 1);
        if (audioTrack.getState() == 0) {
            v.i("AudioDeviceFactory", "reconstruct AudioTrack");
            if (i == 0) {
            }
            audioTrack = new AudioTrack(i == 0 ? 3 : 0, i2, i3, 2, minBufferSize * 8, 1);
        }
        v.i("AudioDeviceFactory", "AudioTrack state: " + audioTrack.getState());
        this.diO = audioTrack;
        if (this.diO != null) {
        }
        g.iuh.a(161, 0, 1, false);
        g.iuh.a(161, 2, 1, false);
    }

    public final boolean E(String str, boolean z) {
        return F(str, z);
    }

    public final boolean c(String str, boolean z, int i) {
        return F(str, z);
    }

    private boolean F(String str, boolean z) {
        int i = 2;
        if (this.mStatus != 0) {
            v.e("MicroMsg.SilkPlayer", "startPlay error status:" + this.mStatus);
            return false;
        }
        if (q.dqO) {
            ae(str, com.tencent.mm.c.b.g.aUS);
        }
        v.i("MicroMsg.SilkPlayer", "startPlay");
        this.mStatus = 1;
        this.mFileName = str;
        synchronized (diW) {
            lw(str);
        }
        if (q.dqO) {
            int i2;
            String str2 = com.tencent.mm.c.b.g.aUR;
            if (this.aUr == 2) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            this.djb = new com.tencent.mm.c.c.b(str2, i2, this.aTB);
        }
        String str3 = "MicroMsg.SilkPlayer";
        String str4 = "startPlay, sampleRate: %d, channelCnt: %d ";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.aTB);
        if (this.aUr == 2) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        v.d(str3, str4, objArr);
        try {
            bj(z);
            return true;
        } catch (Throwable e) {
            try {
                bj(true);
                return true;
            } catch (Exception e2) {
                v.e("MicroMsg.SilkPlayer", "startPlay File[" + this.mFileName + "] failed");
                v.e("MicroMsg.SilkPlayer", "exception:%s", be.e(e));
                this.mStatus = -1;
                return false;
            }
        }
    }

    private void lw(String str) {
        diY = this.diZ;
        v.i("MicroMsg.SilkPlayer", "[%d] SilkDecInit", Integer.valueOf(this.diZ));
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            int available = fileInputStream.available();
            byte[] bArr = new byte[available];
            fileInputStream.read(bArr, 0, available);
            this.aTB = MediaRecorder.SilkGetEncSampleRate(new byte[]{bArr[0]});
            MediaRecorder.SilkDecUnInit();
            MediaRecorder.SilkDecInit(this.aTB, bArr, available);
            fileInputStream.close();
        } catch (Throwable e) {
            g.iuh.a(161, 0, 1, false);
            g.iuh.a(161, 1, 1, false);
            v.e("MicroMsg.SilkPlayer", "exception:%s", be.e(e));
        }
        v.d("MicroMsg.SilkPlayer", "[%d] skip %d frames", Integer.valueOf(this.diZ), Integer.valueOf(this.dja));
        byte[] bArr2 = new byte[(AudioTrack.getMinBufferSize(this.aTB, 2, 2) * 2)];
        short s = (short) ((this.aTB * 20) / 1000);
        for (int i = 0; i < this.dja; i++) {
            if (MediaRecorder.SilkDoDec(bArr2, s) <= 0) {
                v.e("MicroMsg.SilkPlayer", "[%d], skip frame failed: %d", Integer.valueOf(this.diZ), Integer.valueOf(MediaRecorder.SilkDoDec(bArr2, s)));
                return;
            }
        }
    }

    private void bj(boolean z) {
        if (e.aR(this.mFileName)) {
            try {
                bi(z);
                if (this.diQ != null) {
                    this.diQ.requestFocus();
                }
                if (this.diO != null) {
                    try {
                        v.i("MicroMsg.SilkPlayer", "play");
                        this.diO.play();
                        this.diP = new a();
                        com.tencent.mm.sdk.i.e.b(this.diP, "SilkPlayer_play_" + this.diZ, 10);
                    } catch (Exception e) {
                        v.e("MicroMsg.SilkPlayer", "audioTrack error:%s", e.getMessage());
                        g.iuh.a(161, 0, 1, false);
                        g.iuh.a(161, 3, 1, false);
                    }
                }
            } catch (Throwable e2) {
                if (this.diQ != null) {
                    this.diQ.si();
                }
                v.e("MicroMsg.SilkPlayer", "playImp : fail, exception = " + e2.getMessage());
                v.e("MicroMsg.SilkPlayer", "exception:%s", be.e(e2));
            }
        }
    }

    public final boolean pause() {
        if (this.mStatus != 1) {
            return false;
        }
        this.mStatus = 2;
        synchronized (this.diV) {
            try {
                v.v("MicroMsg.SilkPlayer", "before mOk.wait");
                long currentTimeMillis = System.currentTimeMillis();
                this.diV.wait();
                v.v("MicroMsg.SilkPlayer", "after mOk.wait time:" + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Throwable e) {
                v.e("MicroMsg.SilkPlayer", "exception:%s", be.e(e));
                return false;
            }
        }
        if (this.diQ != null) {
            this.diQ.si();
        }
        return true;
    }

    public final boolean oV() {
        if (this.mStatus != 2) {
            return false;
        }
        this.mStatus = 1;
        synchronized (this.diU) {
            try {
                v.v("MicroMsg.SilkPlayer", "before mpause.notify");
                this.diU.notify();
                v.v("MicroMsg.SilkPlayer", "after mpause.notify");
            } catch (Throwable e) {
                v.e("MicroMsg.SilkPlayer", "exception:%s", be.e(e));
                return false;
            }
        }
        if (this.diQ != null) {
            this.diQ.requestFocus();
        }
        return true;
    }

    public final boolean isPlaying() {
        return this.mStatus == 1;
    }

    public final boolean ph() {
        v.i("MicroMsg.SilkPlayer", "stop  status:" + this.mStatus);
        if (this.mStatus == 1 || this.mStatus == 2) {
            this.mStatus = 3;
            synchronized (this.diU) {
                try {
                    this.diU.notify();
                    if (this.diQ != null) {
                        this.diQ.si();
                    }
                } catch (Throwable e) {
                    v.e("MicroMsg.SilkPlayer", "exception:%s", be.e(e));
                    if (this.diQ != null) {
                        this.diQ.si();
                    }
                    return false;
                } catch (Throwable th) {
                    if (this.diQ != null) {
                        this.diQ.si();
                    }
                }
            }
            return true;
        }
        v.e("MicroMsg.SilkPlayer", "stop  error status:" + this.mStatus);
        return false;
    }

    public final double oY() {
        return 0.0d;
    }

    public final String ae(String str, String str2) {
        FileInputStream fileInputStream;
        Throwable e;
        String str3 = null;
        if (this.mStatus != 0) {
            v.e("MicroMsg.SilkPlayer", "startPlay error status:" + this.mStatus);
        } else {
            this.mStatus = 1;
            this.mFileName = str;
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    int available = fileInputStream.available();
                    byte[] bArr = new byte[available];
                    fileInputStream.read(bArr, 0, available);
                    this.aTB = MediaRecorder.SilkGetEncSampleRate(new byte[]{bArr[0]});
                    MediaRecorder.SilkDecInit(this.aTB, bArr, available);
                    v.i("MicroMsg.SilkPlayer", "[%d] SilkDecInit in silkToPcm", Integer.valueOf(this.diZ));
                    fileInputStream.close();
                    str3 = lx(str2);
                } catch (Exception e2) {
                    e = e2;
                    v.e("MicroMsg.SilkPlayer", "silkToPcm, file[%s], exception: %s", this.mFileName, e.getMessage());
                    v.e("MicroMsg.SilkPlayer", "exception:%s", be.e(e));
                    this.mStatus = -1;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e3) {
                            v.a("MicroMsg.SilkPlayer", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }
                    return str3;
                }
            } catch (Exception e4) {
                e3 = e4;
                fileInputStream = str3;
                v.e("MicroMsg.SilkPlayer", "silkToPcm, file[%s], exception: %s", this.mFileName, e3.getMessage());
                v.e("MicroMsg.SilkPlayer", "exception:%s", be.e(e3));
                this.mStatus = -1;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return str3;
            }
        }
        return str3;
    }

    private String lx(String str) {
        Throwable e;
        v.d("MicroMsg.SilkPlayer", "hakon silkToPcmImpl()");
        if (e.aR(this.mFileName)) {
            FileOutputStream fileOutputStream;
            try {
                v.d("MicroMsg.SilkPlayer", "hakon silkToPcmImpl thread start");
                Process.setThreadPriority(-16);
                byte[] bArr = new byte[(AudioTrack.getMinBufferSize(this.aTB, 2, 2) << 1)];
                short s = (short) ((this.aTB * 20) / 1000);
                ly(str);
                fileOutputStream = new FileOutputStream(str);
                while (true) {
                    if (this.mStatus != 1 && this.mStatus != 2) {
                        break;
                    }
                    int SilkDoDec = MediaRecorder.SilkDoDec(bArr, s);
                    if (SilkDoDec < 0) {
                        this.mStatus = 0;
                    } else {
                        while (this.diT) {
                            try {
                                Thread.sleep(20);
                            } catch (Exception e2) {
                                e = e2;
                            }
                        }
                        fileOutputStream.write(bArr, 0, s * 2);
                        fileOutputStream.flush();
                        if (SilkDoDec == 0) {
                            this.mStatus = 0;
                        }
                    }
                }
                v.d("MicroMsg.SilkPlayer", "hakon silkToPcmImpl thread end");
                fileOutputStream.close();
                int SilkDecUnInit = MediaRecorder.SilkDecUnInit();
                v.i("MicroMsg.SilkPlayer", "[%d] SilkDecUnInit in silkToPcmImpl", Integer.valueOf(this.diZ));
                if (SilkDecUnInit == 0) {
                    return str;
                }
                v.e("MicroMsg.SilkPlayer", "hakon silkToPcmImpl res: " + SilkDecUnInit);
                return str;
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                try {
                    v.e("MicroMsg.SilkPlayer", "hakon silkToPcmImpl thread exception: " + e.getMessage());
                    v.e("MicroMsg.SilkPlayer", "exception:%s", be.e(e));
                    this.mStatus = 0;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e4) {
                            v.a("MicroMsg.SilkPlayer", e4, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }
                    return null;
                } catch (Throwable e42) {
                    v.e("MicroMsg.SilkPlayer", "hakon silkToPcmImpl exception: " + e42.getMessage());
                    v.e("MicroMsg.SilkPlayer", "exception:%s", be.e(e42));
                    return null;
                }
            }
        }
        v.e("MicroMsg.SilkPlayer", "hakon silkToPcmImpl(), file not exist, fileName = %s", this.mFileName);
        return null;
    }

    private static boolean ly(String str) {
        if (str == null) {
            return false;
        }
        try {
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf == -1) {
                v.w("MicroMsg.SilkPlayer", "ensureFileFloder end == -1");
                return false;
            }
            File file = new File(str.substring(0, lastIndexOf + 1));
            if (!file.exists()) {
                boolean z = file.mkdirs() || file.isDirectory();
                v.i("MicroMsg.SilkPlayer", "ensureFileFloder mkdir:%s,sucess:%s", r3, Boolean.valueOf(z));
            }
            return true;
        } catch (Exception e) {
            v.w("MicroMsg.SilkPlayer", "ensureFileFloder Exception:", e.getMessage());
            return false;
        }
    }
}
