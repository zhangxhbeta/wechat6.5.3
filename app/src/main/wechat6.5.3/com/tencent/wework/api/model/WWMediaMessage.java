package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import java.io.File;

public class WWMediaMessage extends WWBaseMessage {
    public String description;
    public byte[] thumbData;
    public String title;

    public static abstract class WWMediaObject extends WWMediaMessage {
        protected static int getFileSize(String str) {
            if (!(str == null || str.length() == 0)) {
                File file = new File(str);
                if (file.exists()) {
                    return (int) file.length();
                }
            }
            return 0;
        }
    }

    public void t(Bundle bundle) {
        super.t(bundle);
        bundle.putString("_wwobject_title", this.title);
        bundle.putString("_wwobject_description", this.description);
        bundle.putByteArray("_wwobject_thumbdata", this.thumbData);
    }

    public boolean checkArgs() {
        if (this.thumbData != null && this.thumbData.length > WXMediaMessage.THUMB_LENGTH_LIMIT) {
            return false;
        }
        if (this.title != null && this.title.length() > 512) {
            return false;
        }
        if (this.description == null || this.description.length() <= 1024) {
            return true;
        }
        return false;
    }
}
