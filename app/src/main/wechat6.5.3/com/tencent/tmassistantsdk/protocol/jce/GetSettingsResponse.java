package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

public final class GetSettingsResponse extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!GetSettingsResponse.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    private static final String TAG = "GetSettingsResponse";
    static ArrayList<SettingsCfg> cache_settings;
    public int ret = 0;
    public ArrayList<SettingsCfg> settings = null;

    public final String className() {
        return "jce.GetSettingsResponse";
    }

    public final String fullClassName() {
        return "com.tencent.tmassistantsdk.protocol.jce.GetSettingsResponse";
    }

    public final int getRet() {
        return this.ret;
    }

    public final void setRet(int i) {
        this.ret = i;
    }

    public final ArrayList<SettingsCfg> getSettings() {
        return this.settings;
    }

    public final void setSettings(ArrayList<SettingsCfg> arrayList) {
        this.settings = arrayList;
    }

    public GetSettingsResponse(int i, ArrayList<SettingsCfg> arrayList) {
        this.ret = i;
        this.settings = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return $assertionsDisabled;
        }
        GetSettingsResponse getSettingsResponse = (GetSettingsResponse) obj;
        if (JceUtil.equals(this.ret, getSettingsResponse.ret) && JceUtil.equals(this.settings, getSettingsResponse.settings)) {
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
        jceOutputStream.write(this.ret, 0);
        if (this.settings != null) {
            jceOutputStream.write(this.settings, 1);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        if (cache_settings == null) {
            cache_settings = new ArrayList();
            cache_settings.add(new SettingsCfg());
        }
        this.settings = (ArrayList) jceInputStream.read(cache_settings, 1, (boolean) $assertionsDisabled);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.ret, "ret");
        jceDisplayer.display(this.settings, "settings");
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.displaySimple(this.ret, true);
        jceDisplayer.displaySimple(this.settings, (boolean) $assertionsDisabled);
    }
}
