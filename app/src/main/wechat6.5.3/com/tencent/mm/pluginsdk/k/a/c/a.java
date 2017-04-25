package com.tencent.mm.pluginsdk.k.a.c;

public abstract class a {
    public final String aZy;
    private volatile int cTV;
    private final long dby;
    private final String filePath;
    public final String lCO;
    public final int lCY;
    private final String lEd;
    private final String lEe;
    public final String lgE;
    public final int networkType;
    public final int priority;
    protected volatile int status = 0;
    public final String url;

    public static abstract class a<T extends a> {
        public String aZy;
        public long dby;
        protected String filePath;
        public String lCO;
        public int lCY;
        public String lgE;
        public int networkType;
        public int priority;
        public final String url;

        public a(String str) {
            this.url = str;
        }

        public a<T> GY(String str) {
            this.lgE = str;
            return this;
        }

        public final a<T> Hc(String str) {
            this.filePath = str;
            return this;
        }
    }

    public a(String str, String str2, String str3, int i, int i2, String str4, long j, String str5, String str6, String str7, int i3) {
        this.url = str;
        this.lCO = str2;
        this.lgE = str3;
        this.networkType = i;
        this.lCY = i2;
        this.cTV = this.lCY;
        this.filePath = str4;
        this.dby = j;
        this.lEd = str6;
        this.lEe = str7;
        this.aZy = str5;
        this.priority = i3;
    }

    public String OZ() {
        return this.filePath;
    }

    public r biU() {
        r rVar = new r();
        rVar.field_url = this.url;
        rVar.field_urlKey = this.lCO;
        rVar.field_fileVersion = this.lgE;
        rVar.field_networkType = this.networkType;
        rVar.field_maxRetryTimes = this.lCY;
        rVar.field_retryTimes = this.cTV;
        rVar.field_filePath = this.filePath;
        rVar.field_status = this.status;
        rVar.field_expireTime = this.dby;
        rVar.field_groupId1 = this.lEd;
        rVar.field_groupId2 = this.lEe;
        rVar.field_md5 = this.aZy;
        rVar.field_priority = this.priority;
        return rVar;
    }

    public int GX(String str) {
        return 0;
    }

    public String toString() {
        return "BaseResDownloadRequest | urlKey='" + this.lCO + '\'' + ", networkType=" + this.networkType + ", expireTime=" + this.dby + ", fileVersion=" + this.lgE + ", maxRetryTimes=" + this.lCY + ", md5='" + this.aZy + '\'' + ", groupId1='" + this.lEd + '\'' + ", groupId2='" + this.lEe + '\'' + ", filePath='" + this.filePath + '\'' + ", retryTimes=" + this.cTV + ", status=" + this.status + ", priority=" + this.priority;
    }
}
