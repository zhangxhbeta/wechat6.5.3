package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;

public class WWMediaText extends WWMediaObject {
    public String text;

    public WWMediaText(String str) {
        this.text = str;
    }

    public final boolean checkArgs() {
        if (super.checkArgs() && this.text != null && this.text.length() != 0 && this.text.length() <= 10240) {
            return true;
        }
        return false;
    }

    public final void t(Bundle bundle) {
        bundle.putString("_wwtextobject_text", this.text);
        super.t(bundle);
    }
}
