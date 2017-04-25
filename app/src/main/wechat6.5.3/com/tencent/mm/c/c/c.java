package com.tencent.mm.c.c;

import com.tencent.mm.compatible.d.l;
import com.tencent.mm.h.j;
import com.tencent.mm.modelvoice.MediaRecorder;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public final class c implements a {
    private static com.tencent.mm.c.c.a.a aVW = new com.tencent.mm.c.c.a.a();
    private int aTB = 16000;
    public BlockingQueue<com.tencent.mm.c.b.g.a> aVO = new ArrayBlockingQueue(1024);
    public boolean aVP = false;
    private String aVQ;
    private int aVR = 0;
    private byte[] aVS = null;
    private int aVT = 16000;
    private Object aVU = new Object();
    public a aVV = null;
    private FileOutputStream mFileOutputStream;

    private final class a implements Runnable {
        final /* synthetic */ c aVX;

        private a(c cVar) {
            this.aVX = cVar;
        }

        public final void run() {
            v.i("MicroMsg.SilkWriter", "Silk Thread start run");
            while (true) {
                boolean a;
                synchronized (this.aVX) {
                    a = this.aVX.aVP;
                }
                v.d("MicroMsg.SilkWriter", "ThreadSilk in :" + a + " cnt :" + this.aVX.aVO.size());
                if (!a || !this.aVX.aVO.isEmpty()) {
                    try {
                        com.tencent.mm.c.b.g.a aVar = (com.tencent.mm.c.b.g.a) this.aVX.aVO.poll(200, TimeUnit.MILLISECONDS);
                        if (aVar == null) {
                            v.i("MicroMsg.SilkWriter", "poll byte null file:" + this.aVX.aVQ);
                        } else {
                            int size = this.aVX.aVO.size();
                            if (size > 10 || a) {
                                v.w("MicroMsg.SilkWriter", "speed up silkcodec queue:" + size + " stop:" + a);
                                size = 0;
                            } else if (size < 9) {
                                size = 1;
                            } else {
                                size = 1;
                            }
                            if (c.aVW.count >= 10 && c.aVW.aVK > 240) {
                                size = 0;
                            }
                            this.aVX.a(aVar, size);
                        }
                    } catch (InterruptedException e) {
                        v.i("MicroMsg.SilkWriter", "ThreadAmr poll null");
                    }
                } else {
                    return;
                }
            }
        }
    }

    public c(int i, int i2) {
        this.aTB = i;
        this.aVT = i2;
    }

    public final boolean bA(String str) {
        v.i("MicroMsg.SilkWriter", "initWriter path: " + str);
        if (str == null) {
            v.e("MicroMsg.SilkWriter", "path is null");
            return false;
        }
        this.aVQ = str;
        try {
            this.mFileOutputStream = new FileOutputStream(this.aVQ);
            int rx = l.rx();
            if ((rx & 1024) != 0) {
                rx = 4;
            } else if ((rx & 512) != 0) {
                rx = 2;
            } else {
                v.e("TAG", "initWriter cpuType error! silk don't support arm_v5!!!!");
                return false;
            }
            if (MediaRecorder.SilkEncInit(this.aTB, this.aVT, rx) != 0) {
                v.e("MicroMsg.SilkWriter", "initWriter SilkEncoderInit Error:%d", Integer.valueOf(MediaRecorder.SilkEncInit(this.aTB, this.aVT, rx)));
                return false;
            }
            this.aVS = new byte[(((this.aTB * 20) * 2) / 1000)];
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.SilkWriter", "initWriter FileOutputStream error:%s", e.getMessage());
            return false;
        }
    }

    public final void pv() {
        v.i("MicroMsg.SilkWriter", "waitStop");
        synchronized (this) {
            this.aVP = true;
        }
        if (this.aVV != null) {
            try {
                e.J(this.aVV);
            } catch (Throwable e) {
                v.e("MicroMsg.SilkWriter", "exception:%s", be.e(e));
            }
        }
        synchronized (this.aVU) {
            MediaRecorder.SilkEncUnInit();
        }
        v.i("MicroMsg.SilkWriter", "finish Thread file:" + this.aVQ);
        if (this.mFileOutputStream != null) {
            try {
                this.mFileOutputStream.close();
            } catch (Exception e2) {
                v.e("MicroMsg.SilkWriter", "close silk file:" + this.aVQ + "msg:" + e2.getMessage());
            }
            this.mFileOutputStream = null;
        }
    }

    public final int a(com.tencent.mm.c.b.g.a aVar, int i) {
        com.tencent.mm.compatible.util.g.a aVar2 = new com.tencent.mm.compatible.util.g.a();
        short s = (short) (((this.aTB * 20) * 2) / 1000);
        short s2 = this.aVR + aVar.aUT;
        int i2 = 0;
        Object obj = new byte[s];
        byte[] bArr = new byte[s];
        boolean z = true;
        String value = j.sU().getValue("VoiceNoiseSuppression");
        if (!be.kS(value)) {
            z = be.getInt(value, 1) == 1;
        }
        v.d("MicroMsg.SilkWriter", "noise suppression: %b", Boolean.valueOf(z));
        int i3 = 0;
        while (s2 >= s) {
            if (this.aVR > 0) {
                try {
                    System.arraycopy(this.aVS, 0, obj, 0, this.aVR);
                    System.arraycopy(aVar.buf, 0, obj, this.aVR, s - this.aVR);
                    i2 += s - this.aVR;
                    this.aVR = 0;
                } catch (Exception e) {
                    v.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode arraycopy failed, leftBufSize:%d copySize:%d error:%s", Integer.valueOf(this.aVR), Integer.valueOf(s - this.aVR), e.getMessage());
                    return -1;
                }
            }
            try {
                System.arraycopy(aVar.buf, i2, obj, 0, s);
                i2 += s;
            } catch (Exception e2) {
                v.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode arraycopy failed, offset:%d framelen:%d error:%s", Integer.valueOf(i2), Short.valueOf(s), e2.getMessage());
                return -1;
            }
            s2 -= s;
            short[] sArr = new short[1];
            synchronized (this.aVU) {
                int SilkDoEnc = MediaRecorder.SilkDoEnc(obj, s, bArr, sArr, z);
            }
            if (SilkDoEnc != 0) {
                this.aVR = 0;
                v.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode failed, ret:%d", Integer.valueOf(SilkDoEnc));
                return -1;
            }
            try {
                if (sArr[0] < s) {
                    this.mFileOutputStream.write(bArr, 0, sArr[0]);
                    i3 += sArr[0];
                }
            } catch (IOException e3) {
                v.e("MicroMsg.SilkWriter", "writeSilkFile Write File Error file:%s", this.aVQ);
                return -1;
            }
        }
        try {
            this.mFileOutputStream.flush();
            try {
                System.arraycopy(aVar.buf, i2, this.aVS, this.aVR, s2);
                this.aVR += s2;
                long sn = aVar2.sn();
                if (i == 1) {
                    com.tencent.mm.c.c.a.a aVar3 = aVW;
                    aVar3.aVK = ((aVar3.aVK * ((long) aVar3.count)) + sn) / ((long) (aVar3.count + 1));
                    aVar3.count++;
                }
                v.d("MicroMsg.SilkWriter", "writeSilkFile append2silkfile silkTime:" + sn + " useFloat:" + i + " avg:" + aVW.aVK + " cnt:" + aVW.count);
                return i3;
            } catch (Exception e22) {
                v.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode arraycopy failed, offset:%d leftBufSize:%d leftSize:%d error:%s", Integer.valueOf(i2), Integer.valueOf(this.aVR), Integer.valueOf(s2), e22.getMessage());
                return -1;
            }
        } catch (IOException e4) {
            v.e("MicroMsg.SilkWriter", "writeSilkFile flush File Error file:%s", this.aVQ);
            return -1;
        }
    }
}
