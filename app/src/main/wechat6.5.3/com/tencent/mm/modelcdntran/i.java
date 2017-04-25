package com.tencent.mm.modelcdntran;

public final class i extends h {
    public int bhN;
    public int cFS = 1;
    public String cFT;
    public int cFU;
    public boolean cFV;
    public String cFW;
    public int cFX;
    public int cFY = 0;
    public String filename;
    public String host;
    public String[] iplist;
    public String referer;
    public String url;

    public final boolean Eb() {
        return this.cFS == 1;
    }

    public final String toString() {
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("isPlayMode: ").append(this.cFV);
        if ((this.cFS == 2 ? 1 : 0) != 0) {
            stringBuffer.append(" url : ").append(this.url);
            stringBuffer.append(" host : ").append(this.host);
            stringBuffer.append(" referer : ").append(this.referer);
            StringBuffer append = stringBuffer.append(" ip size : ");
            if (this.iplist != null) {
                i = this.iplist.length;
            }
            append.append(i);
        } else {
            stringBuffer.append(" filename : ").append(this.filename);
            stringBuffer.append(" field_mediaId : ").append(this.field_mediaId);
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
