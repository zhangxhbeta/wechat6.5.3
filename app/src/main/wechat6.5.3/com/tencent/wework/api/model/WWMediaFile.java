package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;

public class WWMediaFile extends WWMediaObject {
    public String aST;
    private int contentLengthLimit = 10485760;
    public byte[] fileData;
    public String filePath;

    public final boolean checkArgs() {
        if (!super.checkArgs()) {
            return false;
        }
        if ((this.fileData == null || this.fileData.length == 0) && (this.filePath == null || this.filePath.length() == 0)) {
            return false;
        }
        if (this.fileData != null && this.fileData.length > this.contentLengthLimit) {
            return false;
        }
        if (this.filePath == null || WWMediaObject.getFileSize(this.filePath) <= this.contentLengthLimit) {
            return true;
        }
        return false;
    }

    public final void t(Bundle bundle) {
        bundle.putByteArray("_wwfileobject_fileData", this.fileData);
        bundle.putString("_wwfileobject_filePath", this.filePath);
        bundle.putString("_wwfileobject_fileName", this.aST);
        super.t(bundle);
    }
}
