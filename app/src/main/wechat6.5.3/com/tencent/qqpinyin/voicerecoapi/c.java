package com.tencent.qqpinyin.voicerecoapi;

import com.tencent.mmdb.FileUtils;

public final class c {
    private int dMq;
    private int dko;
    private TRVADNative ptB;

    public static class a {
        public int ptC = 0;
        public int ptD = FileUtils.S_IRUSR;
        public int ptE = 512;
        private int ptF = 0;
        public int ptG = 0;
    }

    public c(int i) {
        this.ptB = new TRVADNative();
        this.dko = i;
        this.dMq = 5000000;
    }

    public c() {
        this.ptB = new TRVADNative();
        this.dko = 500000;
        this.dMq = 10000000;
    }

    public final int start() {
        int mfeInit = this.ptB.mfeInit(this.dko, this.dMq);
        if (mfeInit == 0) {
            mfeInit = this.ptB.mfeOpen();
            if (mfeInit == 0) {
                mfeInit = this.ptB.mfeEnableNoiseDetection(true);
                if (mfeInit == 0) {
                    mfeInit = this.ptB.mfeStart();
                }
            }
        }
        return mfeInit == 0 ? 0 : -1;
    }

    public final int stop() {
        int mfeStop = this.ptB.mfeStop();
        if (mfeStop == 0) {
            mfeStop = this.ptB.mfeClose();
            if (mfeStop == 0) {
                mfeStop = this.ptB.mfeExit();
            }
        }
        return mfeStop == 0 ? 0 : -1;
    }

    public final synchronized void a(short[] sArr, int i, a aVar) {
        double d = 26.0d;
        int i2 = 0;
        synchronized (this) {
            if (i > 0) {
                switch (this.ptB.mfeSendData(sArr, i)) {
                    case 1:
                        aVar.ptC = 1;
                        break;
                    case 2:
                        aVar.ptC = 2;
                        break;
                    case 3:
                        aVar.ptC = 3;
                        break;
                    default:
                        aVar.ptC = 0;
                        break;
                }
                int i3 = 0;
                while (i2 < i) {
                    i3 = (int) (((double) i3) + (Math.sqrt((double) (sArr[i2] * sArr[i2])) / ((double) i)));
                    i2++;
                }
                if (i3 < 100) {
                    d = 0.0d;
                } else if (i3 <= 16383) {
                    d = 26.0d * ((((double) i3) - 100.0d) / 32667.0d);
                }
                aVar.ptG = (int) d;
                new StringBuilder("volumn��").append(aVar.ptG);
            }
        }
    }
}
