package com.tencent.recovery.a;

public final class b {
    public String processName;
    public a ptX;
    public long ptY;
    public long ptZ;
    public boolean pua;
    public boolean pub;
    public String puc;
    public String pud;

    public static final class a {
        public String processName;
        public a ptX;
        public long ptY;
        public long ptZ;
        public boolean pua;
        public boolean pub;
        public String puc;
        public String pud;

        public final b bMC() {
            return new b(this.processName, this.ptY, this.ptZ, this.ptX, this.pua, this.pub, this.puc, this.pud);
        }
    }

    private b(String str, long j, long j2, a aVar, boolean z, boolean z2, String str2, String str3) {
        this.processName = str;
        this.ptY = j;
        this.ptZ = j2;
        this.ptX = aVar;
        this.pua = z;
        this.pub = z2;
        this.puc = str2;
        this.pud = str3;
    }

    public final String toString() {
        return this.processName + "[activityDelayTime-" + this.ptY + " bgDelayTime-" + this.ptZ + " recoveryExpress-" + this.ptX.toString() + " isForegroundProcess-" + this.pua + " canStartRecoveryUI-" + this.pub + " configUrl-" + this.pud + "]";
    }
}
