package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mm.sdk.platformtools.v;

public final class Terminal extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!Terminal.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    private static final String TAG = "Terminal";
    public String androidId = "";
    public String androidIdSdCard = "";
    public String imei = "";
    public String imsi = "";
    public String macAdress = "";

    public final String className() {
        return "jce.Terminal";
    }

    public final String fullClassName() {
        return "com.tencent.tmassistantsdk.protocol.jce.Terminal";
    }

    public final String getImei() {
        return this.imei;
    }

    public final void setImei(String str) {
        this.imei = str;
    }

    public final String getMacAdress() {
        return this.macAdress;
    }

    public final void setMacAdress(String str) {
        this.macAdress = str;
    }

    public final String getAndroidId() {
        return this.androidId;
    }

    public final void setAndroidId(String str) {
        this.androidId = str;
    }

    public final String getAndroidIdSdCard() {
        return this.androidIdSdCard;
    }

    public final void setAndroidIdSdCard(String str) {
        this.androidIdSdCard = str;
    }

    public final String getImsi() {
        return this.imsi;
    }

    public final void setImsi(String str) {
        this.imsi = str;
    }

    public Terminal(String str, String str2, String str3, String str4, String str5) {
        this.imei = str;
        this.macAdress = str2;
        this.androidId = str3;
        this.androidIdSdCard = str4;
        this.imsi = str5;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return $assertionsDisabled;
        }
        Terminal terminal = (Terminal) obj;
        if (JceUtil.equals(this.imei, terminal.imei) && JceUtil.equals(this.macAdress, terminal.macAdress) && JceUtil.equals(this.androidId, terminal.androidId) && JceUtil.equals(this.androidIdSdCard, terminal.androidIdSdCard) && JceUtil.equals(this.imsi, terminal.imsi)) {
            return true;
        }
        return $assertionsDisabled;
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Throwable e) {
            v.a(TAG, e, "", new Object[0]);
            return 0;
        }
    }

    public final Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!$assertionsDisabled) {
                throw new AssertionError();
            }
        }
        return obj;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        if (this.imei != null) {
            jceOutputStream.write(this.imei, 0);
        }
        if (this.macAdress != null) {
            jceOutputStream.write(this.macAdress, 1);
        }
        if (this.androidId != null) {
            jceOutputStream.write(this.androidId, 2);
        }
        if (this.androidIdSdCard != null) {
            jceOutputStream.write(this.androidIdSdCard, 3);
        }
        if (this.imsi != null) {
            jceOutputStream.write(this.imsi, 4);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.imei = jceInputStream.readString(0, $assertionsDisabled);
        this.macAdress = jceInputStream.readString(1, $assertionsDisabled);
        this.androidId = jceInputStream.readString(2, $assertionsDisabled);
        this.androidIdSdCard = jceInputStream.readString(3, $assertionsDisabled);
        this.imsi = jceInputStream.readString(4, $assertionsDisabled);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.imei, "imei");
        jceDisplayer.display(this.macAdress, "macAdress");
        jceDisplayer.display(this.androidId, "androidId");
        jceDisplayer.display(this.androidIdSdCard, "androidIdSdCard");
        jceDisplayer.display(this.imsi, "imsi");
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.displaySimple(this.imei, true);
        jceDisplayer.displaySimple(this.macAdress, true);
        jceDisplayer.displaySimple(this.androidId, true);
        jceDisplayer.displaySimple(this.androidIdSdCard, true);
        jceDisplayer.displaySimple(this.imsi, (boolean) $assertionsDisabled);
    }
}
