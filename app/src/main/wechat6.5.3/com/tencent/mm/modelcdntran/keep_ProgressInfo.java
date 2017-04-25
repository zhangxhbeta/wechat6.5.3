package com.tencent.mm.modelcdntran;

public class keep_ProgressInfo {
    public int field_finishedLength;
    public boolean field_mtlnotify;
    public int field_status;
    public int field_toltalLength;
    public String mediaId;

    public String toString() {
        return String.format("id:%s total:%d finLen:%d status:%d,mtl:%b", new Object[]{this.mediaId, Integer.valueOf(this.field_toltalLength), Integer.valueOf(this.field_finishedLength), Integer.valueOf(this.field_status), Boolean.valueOf(this.field_mtlnotify)});
    }
}
