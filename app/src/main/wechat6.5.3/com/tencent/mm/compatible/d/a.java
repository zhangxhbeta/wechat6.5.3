package com.tencent.mm.compatible.d;

import com.tencent.mm.sdk.platformtools.v;

public final class a {
    public int cbA;
    public int cbB;
    public int cbC;
    public int cbD;
    public int cbE;
    public int cbF;
    public int cbG;
    public int cbH;
    public int cbI;
    public int cbJ;
    public int cbK;
    public int cbL;
    public int cbM;
    public int cbN;
    public int cbO;
    public int cbP;
    public int cbQ;
    public int cbR;
    public int cbS;
    public int cbT;
    public int cbU;
    public boolean cbV;
    public int cbW;
    public int cbX;
    public int cbY;
    public int cbZ;
    public boolean cbr = false;
    public int cbs;
    public int cbt;
    public int cbu;
    public int cbv;
    public int cbw;
    public int cbx;
    public int cby;
    public int cbz;
    public int cca;
    public int ccb;
    public int ccc;
    public int ccd;
    public int cce;
    public int ccf;
    public int ccg;
    public int cch;
    public int cci;
    public int ccj;
    public int cck;
    public short[] ccl = new short[15];
    public short[] ccm = new short[2];
    public boolean ccn;
    public int cco;
    public boolean ccp = false;
    public int ccq;
    public int ccr;
    public int ccs;
    public int cct;
    public int ccu;
    public int ccv;
    public int ccw;
    public int ccx;
    public int ccy;
    public int ccz;

    public a() {
        reset();
    }

    public final void reset() {
        this.cbr = false;
        this.cbs = -1;
        this.cbt = -1;
        this.cbu = -1;
        this.cbv = -1;
        this.cbw = -1;
        this.cbx = -1;
        this.cby = -1;
        this.cbA = -1;
        this.cbz = -1;
        this.ccd = -1;
        this.cbB = -1;
        this.cbC = -1;
        this.cbD = -1;
        this.cbO = -1;
        this.cbP = -1;
        this.cbQ = -1;
        this.cbR = -1;
        this.cbS = -1;
        this.cbT = -1;
        this.cbU = -1;
        this.cbV = false;
        this.cbW = -1;
        this.cbX = -1;
        this.cbZ = -1;
        this.cbY = -1;
        this.ccc = -1;
        this.cca = -1;
        this.ccb = -1;
        this.cce = -1;
        this.ccf = -1;
        this.ccg = -1;
        this.cch = -1;
        this.cbE = -1;
        this.cbF = -1;
        this.cbG = -1;
        this.cbH = -1;
        this.cbK = -1;
        this.cbL = -1;
        this.cbM = -1;
        this.cbN = -1;
        this.cci = 0;
        this.ccj = 0;
        this.cck = -1;
        this.cbJ = -1;
        this.cbI = -1;
        this.ccn = false;
        this.ccm[0] = (short) -1;
        this.ccm[1] = (short) -1;
        this.cco = -1;
        this.ccw = -1;
        this.ccx = -1;
        this.ccy = -1;
        this.ccz = -1;
    }

    public final boolean rj() {
        if ((this.cbt < 0 || this.cbu >= 0) && ((this.cbt >= 0 || this.cbu < 0) && this.cbv <= 0)) {
            return false;
        }
        return true;
    }

    public final boolean rk() {
        return this.cbw >= 0;
    }

    public final boolean rl() {
        return this.cbx >= 0;
    }

    public final int rm() {
        if (!rk()) {
            return -1;
        }
        int i = (this.cbw & 224) >> 5;
        v.d("VoipAudioInfo", "getEnableMode " + i);
        if (i == 7) {
            return -1;
        }
        return i;
    }

    public final boolean rn() {
        if (!rk()) {
            return false;
        }
        boolean z;
        int i = this.cbw & 16;
        String str = "VoipAudioInfo";
        StringBuilder stringBuilder = new StringBuilder("enableSpeaker ");
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        v.d(str, stringBuilder.append(z).toString());
        if (i > 0) {
            return true;
        }
        return false;
    }

    public final int ro() {
        if (!rk()) {
            return -1;
        }
        int i = (this.cbw & 14) >> 1;
        v.d("VoipAudioInfo", "getDisableMode " + i);
        if (i == 7) {
            return -1;
        }
        return i;
    }

    public final boolean rp() {
        if (!rk()) {
            return false;
        }
        boolean z;
        int i = this.cbw & 1;
        String str = "VoipAudioInfo";
        StringBuilder stringBuilder = new StringBuilder("disableSpeaker ");
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        v.d(str, stringBuilder.append(z).toString());
        if (i > 0) {
            return true;
        }
        return false;
    }

    public final int rq() {
        if (!rl()) {
            return -1;
        }
        int i = (this.cbx & 224) >> 5;
        v.d("VoipAudioInfo", "getEnableMode " + i);
        if (i == 7) {
            return -1;
        }
        return i;
    }

    public final int rr() {
        if (!rl()) {
            return -1;
        }
        int i = (this.cbx & 14) >> 1;
        v.d("VoipAudioInfo", "getDisableMode " + i);
        if (i == 7) {
            return -1;
        }
        return i;
    }

    public final void dump() {
        v.d("VoipAudioInfo", "streamtype " + this.cbs);
        v.d("VoipAudioInfo", "smode " + this.cbt);
        v.d("VoipAudioInfo", "omode " + this.cbu);
        v.d("VoipAudioInfo", "ospeaker " + this.cbv);
        v.d("VoipAudioInfo", "operating" + this.cbw);
        v.d("VoipAudioInfo", "moperating" + this.cbx);
        v.d("VoipAudioInfo", "mstreamtype" + this.cby);
        v.d("VoipAudioInfo", "mVoiceRecordMode" + this.cbz);
        v.d("VoipAudioInfo", "agcMode :" + this.ccd);
        v.d("VoipAudioInfo", "nsMode:" + this.cbC);
        v.d("VoipAudioInfo", "aecMode:" + this.cbB);
        v.d("VoipAudioInfo", "volumMode:" + this.cbD);
        v.d("VoipAudioInfo", "micMode:" + this.cbO);
        v.d("VoipAudioInfo", "sourceMode:" + this.cbP);
        v.d("VoipAudioInfo", "speakerMode:" + this.cbQ);
        v.d("VoipAudioInfo", "phoneMode:" + this.cbR);
        v.d("VoipAudioInfo", "voipstreamType:" + this.cbS);
        v.d("VoipAudioInfo", "speakerstreamtype:" + this.cbT);
        v.d("VoipAudioInfo", "phonestreamtype:" + this.cbU);
        v.d("VoipAudioInfo", "ringphonestream:" + this.cbW);
        v.d("VoipAudioInfo", "ringphonemode:" + this.cbX);
        v.d("VoipAudioInfo", "ringspeakerstream:" + this.cbY);
        v.d("VoipAudioInfo", "ringspeakermode:" + this.cbZ);
        v.d("VoipAudioInfo", "agcModeNew :" + this.ccc);
        v.d("VoipAudioInfo", "nsModeNew:" + this.ccb);
        v.d("VoipAudioInfo", "aecModeNew:" + this.cca);
        v.d("VoipAudioInfo", "agctargetdb:" + this.cce);
        v.d("VoipAudioInfo", "agcgaindb:" + this.ccf);
        v.d("VoipAudioInfo", "agcflag:" + this.ccg);
        v.d("VoipAudioInfo", "agclimiter:" + this.cch);
        v.d("VoipAudioInfo", "inputVolumeScale:" + this.cbE);
        v.d("VoipAudioInfo", "outputVolumeScale:" + this.cbF);
        v.d("VoipAudioInfo", "inputVolumeScaleForSpeaker:" + this.cbG);
        v.d("VoipAudioInfo", "outputVolumeScaleForSpeaker:" + this.cbH);
        v.d("VoipAudioInfo", "ehanceHeadsetEC:" + this.cbK);
        v.d("VoipAudioInfo", "setECModeLevelForHeadSet:" + this.cbL);
        v.d("VoipAudioInfo", "setECModeLevelForSpeaker:" + this.cbM);
        v.d("VoipAudioInfo", "enableSpeakerEnhanceEC:" + this.cbN);
        v.d("VoipAudioInfo", "enableRecTimer:" + this.cci);
        v.d("VoipAudioInfo", "enablePlayTimer:" + this.ccj);
        v.d("VoipAudioInfo", "setPlayerPrecorrectCofOnOrOff:" + this.cck);
        v.d("VoipAudioInfo", "outputVolumeGainForPhone:" + this.cbI);
        v.d("VoipAudioInfo", "outputVolumeGainForSpeaker:" + this.cbJ);
        v.d("VoipAudioInfo", "noisegateon" + this.ccn);
        v.d("VoipAudioInfo", "noisegatestrength[0]" + this.ccm[0]);
        v.d("VoipAudioInfo", "noisegatestrength[1]" + this.ccm[1]);
        v.d("VoipAudioInfo", "spkecenable:" + this.cco);
        v.d("VoipAudioInfo", "agcRxFlag:" + this.ccw);
        v.d("VoipAudioInfo", "agcRxTargetdb:" + this.ccx);
        v.d("VoipAudioInfo", "agcRxGaindb:" + this.ccy);
        v.d("VoipAudioInfo", "agcRxLimiter:" + this.ccz);
    }
}
