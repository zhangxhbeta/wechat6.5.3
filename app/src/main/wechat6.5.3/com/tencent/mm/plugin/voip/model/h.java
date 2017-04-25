package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.plugin.voip.b.a;

public final class h {
    long beginTime = 0;
    public int ksP;
    public int ksQ;
    public int ksR;
    public int ksS;
    byte ksT;
    byte ksU;
    byte ksV;
    byte ksW;
    byte ksX;
    byte ksY;
    byte ksZ;
    int kta;
    public int ktb;
    public int ktc;
    public int ktd;
    public int kte;
    public int ktf;
    public int ktg;
    public int kth;
    int kti;
    int ktj;
    int ktk;
    int ktl;
    int ktm;
    int ktn;
    int kto;
    int ktp;
    long ktq;
    long ktr;
    long kts;
    long ktt;
    public long ktu;
    long ktv;
    long ktw;
    long ktx;

    public h() {
        reset();
        bbR();
    }

    public final void bbQ() {
        if (this.ktu == 0) {
            this.ktl = 0;
        } else {
            this.ktl = (int) (System.currentTimeMillis() - this.ktu);
        }
        a.cS("MicroMsg.VoipDailReport", "devin:answerInvite current:" + System.currentTimeMillis());
        a.cS("MicroMsg.VoipDailReport", "devin:answerInvite:" + this.ktl);
    }

    public final void reset() {
        this.beginTime = 0;
        this.ksP = 0;
        this.ksQ = 0;
        this.ksR = 0;
        this.ksS = 0;
        this.ksT = (byte) 0;
        this.ksU = (byte) 0;
        this.ksV = (byte) 0;
        this.ksW = (byte) 0;
        this.ksX = (byte) 0;
        this.ksY = (byte) 0;
        this.ksZ = (byte) 0;
        this.kta = 0;
    }

    public final void bbR() {
        this.ktq = 0;
        this.ktt = 0;
        this.ktu = 0;
        this.ktv = 0;
        this.ktw = 0;
        this.ktx = 0;
        this.ktr = 0;
        this.kts = 0;
        this.ktb = 0;
        this.ktc = 0;
        this.ktd = 0;
        this.kte = 0;
        this.ktf = 0;
        this.ktg = 0;
        this.kth = 0;
        this.kti = 0;
        this.ktj = 0;
        this.ktk = 0;
        this.ktl = 0;
        this.ktm = 0;
        this.ktn = 0;
        this.kto = 0;
        this.ktp = 0;
    }

    public final String bbS() {
        return "," + this.ksZ;
    }
}
