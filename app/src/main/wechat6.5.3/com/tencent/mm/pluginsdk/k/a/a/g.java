package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.mm.pluginsdk.k.a.c.r;
import com.tencent.mm.sdk.platformtools.be;

final class g extends com.tencent.mm.pluginsdk.k.a.c.a {
    final int aYo;
    final int aYp;
    private final boolean aYr;
    final boolean aYu;
    final long fileSize;
    private final String lCR;
    final int lCS;
    private final byte[] lCT;
    final String lCU;
    final long lCW;
    private final String lCX;
    final byte[] lDt;
    final boolean lDu;
    final boolean lDv;
    private final int lDw;

    public static final class a extends com.tencent.mm.pluginsdk.k.a.c.a.a<g> {
        int aYo;
        int aYp;
        int aYq;
        boolean aYr;
        boolean aYu;
        long fileSize = 0;
        String lCR;
        int lCS;
        byte[] lCT;
        String lCU;
        long lCW;
        String lCX;
        byte[] lDt;
        boolean lDu;
        boolean lDv;
        int lDw;

        public a(String str) {
            super(str);
        }

        public final com.tencent.mm.pluginsdk.k.a.c.a.a<g> GY(String str) {
            super.GY(str);
            this.aYq = be.getInt(str, 0);
            return this;
        }
    }

    public g(String str, String str2, int i, int i2, int i3, long j, String str3, int i4, int i5, long j2, String str4, byte[] bArr, String str5, boolean z, boolean z2, String str6, int i6, int i7, byte[] bArr2, long j3, boolean z3, boolean z4, int i8) {
        super(str, str2, String.valueOf(i), i2, i3, i.GZ(str2), j, str3, "CheckResUpdate", z3 ? "NewXml" : "CGI", i8);
        this.aYo = i4;
        this.aYp = i5;
        this.lCW = j2;
        this.lCX = str4;
        this.lCT = bArr;
        this.lCU = str5;
        this.lDu = z;
        this.lDv = z2;
        this.lCR = str6;
        this.lCS = i6;
        this.lDw = i7;
        this.lDt = bArr2;
        this.fileSize = j3;
        this.aYu = z3;
        this.aYr = z4;
    }

    public final String toString() {
        return "CheckResUpdateRequest | fileUpdated=" + this.aYr + ", resType=" + this.aYo + ", subType=" + this.aYp + ", reportId=" + this.lCW + ", sampleId='" + this.lCX + '\'' + ", originalMd5='" + this.lCU + '\'' + ", fileCompress=" + this.lDu + ", fileEncrypt=" + this.lDv + ", encryptKey='" + this.lCR + '\'' + ", keyVersion=" + this.lCS + ", EID=" + this.lDw + ", fileSize=" + this.fileSize + ", fromNewXml=" + this.aYu + " | " + super.toString();
    }

    public final String OZ() {
        return i.GZ(this.lCO);
    }

    public final r biU() {
        r biU = super.biU();
        biU.field_fileUpdated = this.aYr;
        biU.field_resType = this.aYo;
        biU.field_subType = this.aYp;
        biU.field_reportId = this.lCW;
        biU.field_sampleId = this.lCX;
        biU.field_eccSignature = this.lCT;
        biU.field_originalMd5 = this.lCU;
        biU.field_fileCompress = this.lDu;
        biU.field_fileEncrypt = this.lDv;
        biU.field_encryptKey = this.lCR;
        biU.field_keyVersion = this.lCS;
        biU.field_fileSize = this.fileSize;
        biU.field_EID = this.lDw;
        return biU;
    }

    protected final int GX(String str) {
        return be.getInt(this.lgE, 0) - be.getInt(str, 0);
    }
}
