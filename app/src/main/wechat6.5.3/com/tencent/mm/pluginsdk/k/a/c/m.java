package com.tencent.mm.pluginsdk.k.a.c;

public final class m {
    public final String bsL;
    public final long bsM;
    public final String filePath;
    public final int httpStatusCode;
    public final String lCO;
    final String lEs;
    public final Exception lEv;
    public final int status;
    public final String url;

    private m(String str, String str2, String str3, String str4, long j, String str5, int i, Exception exception, int i2) {
        this.lEs = str;
        this.lCO = str2;
        this.url = str3;
        this.filePath = str4;
        this.bsM = j;
        this.bsL = str5;
        this.status = i;
        this.lEv = exception;
        this.httpStatusCode = i2;
    }

    public m(String str, String str2, String str3, String str4, long j, String str5, Exception exception) {
        this(str, str2, str3, str4, j, str5, 3, exception, -1);
    }

    public m(l lVar, long j) {
        this(lVar.Pa(), lVar.lCO, lVar.url, lVar.OZ(), j, null, 2, null, -1);
    }

    public m(f fVar, long j, String str) {
        this(fVar.Pa(), fVar.bnQ(), fVar.getURL(), fVar.OZ(), j, str, 2, null, -1);
    }

    public m(f fVar, Exception exception, int i, int i2) {
        this(fVar.Pa(), fVar.bnQ(), fVar.getURL(), fVar.OZ(), -1, null, i2, exception, i);
    }

    public m(f fVar, Exception exception) {
        this(fVar, exception, -1, 4);
    }

    public final String toString() {
        return "NetworkResponse{urlKey='" + this.lCO + '\'' + ", url='" + this.url + '\'' + ", filePath='" + this.filePath + '\'' + ", contentLength=" + this.bsM + ", contentType='" + this.bsL + '\'' + ", status=" + this.status + ", e=" + this.lEv + '}';
    }
}
