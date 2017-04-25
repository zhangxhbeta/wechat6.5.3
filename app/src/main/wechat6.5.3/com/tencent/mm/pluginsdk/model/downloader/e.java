package com.tencent.mm.pluginsdk.model.downloader;

import com.tencent.mmdb.database.SQLiteDatabase;

public final class e {
    public String dzg;
    String gpe;
    public String lCg;
    String lCh;
    int lCi;
    boolean lCj;
    boolean lCk;
    public boolean lCl;
    boolean lCm;
    String mFileName;

    public static final class a {
        public e lCn = new e();

        public final void GQ(String str) {
            this.lCn.lCg = str;
        }

        public final void GR(String str) {
            this.lCn.mFileName = str;
        }

        public final void GS(String str) {
            this.lCn.lCh = str;
        }

        public final void setAppId(String str) {
            this.lCn.dzg = str;
        }

        public final void tE(int i) {
            this.lCn.lCi = i;
        }

        public final void hO(boolean z) {
            this.lCn.lCj = z;
        }

        public final void hP(boolean z) {
            this.lCn.lCk = z;
        }

        public final void GT(String str) {
            this.lCn.gpe = str;
        }

        public final void hQ(boolean z) {
            this.lCn.lCm = z;
        }
    }

    private e() {
        this.lCg = SQLiteDatabase.KeyEmpty;
        this.mFileName = SQLiteDatabase.KeyEmpty;
        this.lCh = SQLiteDatabase.KeyEmpty;
        this.lCi = 1;
        this.dzg = SQLiteDatabase.KeyEmpty;
        this.gpe = SQLiteDatabase.KeyEmpty;
        this.lCj = false;
        this.lCk = true;
        this.lCl = false;
        this.lCm = false;
    }
}
