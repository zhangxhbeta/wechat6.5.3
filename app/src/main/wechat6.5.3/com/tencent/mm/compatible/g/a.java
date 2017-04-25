package com.tencent.mm.compatible.g;

import com.tencent.mm.sdk.platformtools.v;

public final class a {
    public int aZk;
    public String cfS;
    public long cfT;
    public int cfU;

    public a() {
        this.cfS = null;
        this.cfT = -1;
        this.cfU = -1;
        this.aZk = -1;
        this.cfS = null;
        this.cfT = -1;
        this.cfU = -1;
        this.aZk = -1;
    }

    public final String sg() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cfS);
        stringBuffer.append(",");
        stringBuffer.append(this.cfT);
        stringBuffer.append(",");
        stringBuffer.append(this.cfU);
        stringBuffer.append(",");
        stringBuffer.append(this.aZk);
        v.d("MicroMsg.AudioRecorderInfo", " getStatInfo " + stringBuffer.toString());
        return stringBuffer.toString();
    }
}
