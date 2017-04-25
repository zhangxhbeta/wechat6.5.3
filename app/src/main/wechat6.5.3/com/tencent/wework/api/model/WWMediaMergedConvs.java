package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;
import java.util.ArrayList;
import java.util.List;

public class WWMediaMergedConvs extends WWMediaObject {
    public List<WWMediaConversation> pKb = new ArrayList();

    public final boolean checkArgs() {
        if (!super.checkArgs() || this.pKb == null || this.pKb.size() == 0) {
            return false;
        }
        boolean z;
        for (BaseMessage checkArgs : this.pKb) {
            if (!checkArgs.checkArgs()) {
                z = false;
                break;
            }
        }
        z = true;
        return z;
    }

    public final void t(Bundle bundle) {
        bundle.putInt("_wwmergedconvobject_messageslen", this.pKb.size());
        for (int i = 0; i < this.pKb.size(); i++) {
            bundle.putBundle("_wwmergedconvobject_messages" + i, BaseMessage.b((BaseMessage) this.pKb.get(i)));
        }
        super.t(bundle);
    }
}
