package com.tencent.pb.talkroom.sdk;

import com.tencent.mmdb.database.SQLiteDatabase;

public final class f {
    public String ptf = SQLiteDatabase.KeyEmpty;
    public int[] pth = new int[0];
    public int pti;
    public int ptj;
    public int ptk;
    public int ptl;
    public int ret;

    public final String toString() {
        return "MultiTalkVideoDecodeInfo [imgBuffer=" + (this.pth == null ? this.pth.length : this.pth.length) + ", imgBufferLen=" + this.pti + ", vedioWidth=" + this.ptj + ", vedioHeight=" + this.ptk + ", usrName=" + this.ptf + ", ret=" + this.ret + "]";
    }
}
