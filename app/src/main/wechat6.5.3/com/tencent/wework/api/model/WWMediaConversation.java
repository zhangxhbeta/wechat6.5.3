package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;

public class WWMediaConversation extends WWMediaObject {
    public long date;
    public String fSb;
    public String name;
    public byte[] pJY;
    public WWMediaObject pJZ;

    public final boolean checkArgs() {
        if (!super.checkArgs()) {
            return false;
        }
        if (this.pJY != null && this.pJY.length > 10485760) {
            return false;
        }
        if (this.fSb != null && this.fSb.length() > 10240) {
            return false;
        }
        if ((this.fSb == null || WWMediaObject.getFileSize(this.fSb) <= 10485760) && this.pJZ != null && this.pJZ.checkArgs()) {
            return true;
        }
        return false;
    }

    public final void t(Bundle bundle) {
        super.t(bundle);
        bundle.putString("_wwconvobject_name", this.name);
        bundle.putLong("_wwconvobject_date", this.date);
        bundle.putByteArray("_wwconvobject_avatarData", this.pJY);
        bundle.putString("_wwconvobject_avatarPath", this.fSb);
        bundle.putBundle("_wwconvobject_message", BaseMessage.b(this.pJZ));
    }
}
