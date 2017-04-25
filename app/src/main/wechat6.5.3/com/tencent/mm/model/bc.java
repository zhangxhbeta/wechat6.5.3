package com.tencent.mm.model;

import android.database.Cursor;
import junit.framework.Assert;

public final class bc {
    int bkU = -1;
    public String cqI = "";
    public String cqK = "";
    public String cuM = "";
    public String cuN = "";
    public String cuO = "";
    public long cuP = 0;
    public String cuQ = "";
    public String cuR = "";
    public int cuS = 0;
    public int cuT = 0;
    public long cuU = 0;
    public String cuV = "";
    String cuW = "";
    public String name = "";
    public long time = 0;
    public String title = "";
    public int type = 0;
    public String url = "";

    public final void b(Cursor cursor) {
        this.cuM = cursor.getString(0);
        this.time = cursor.getLong(1);
        this.type = cursor.getInt(2);
        this.name = cursor.getString(3);
        this.title = cursor.getString(4);
        this.url = cursor.getString(5);
        this.cuN = cursor.getString(6);
        this.cuO = cursor.getString(7);
        this.cuP = cursor.getLong(8);
        this.cuQ = cursor.getString(9);
        this.cuR = cursor.getString(10);
        this.cuS = cursor.getInt(11);
        this.cqI = cursor.getString(12);
        this.cqK = cursor.getString(13);
        this.cuT = cursor.getInt(14);
        this.cuU = cursor.getLong(15);
        this.cuV = cursor.getString(16);
        this.cuW = cursor.getString(17);
    }

    public static String eO(int i) {
        if (i == 20) {
            return "newsapp";
        }
        if (i == 11) {
            return "blogapp";
        }
        Assert.assertTrue("INFO TYPE NEITHER NEWS NOR WEIBO", false);
        return null;
    }

    public final void M(long j) {
        this.cuU = j;
    }

    public final boolean zF() {
        return this.cuT == 1;
    }

    public final String zG() {
        return this.cuM == null ? "" : this.cuM;
    }

    public final String getName() {
        return this.name == null ? "" : this.name;
    }

    public final String getTitle() {
        return this.title == null ? "" : this.title;
    }

    public final String getUrl() {
        return this.url == null ? "" : this.url;
    }

    public final String zH() {
        return this.cuN == null ? "" : this.cuN;
    }

    public final String zI() {
        return this.cuQ == null ? "" : this.cuQ;
    }

    public final String zJ() {
        return this.cuR == null ? "" : this.cuR;
    }

    public final String zK() {
        if (this.cqI == null) {
            return "";
        }
        String[] split = this.cqI.split("\\|");
        if (split == null || split.length <= 0) {
            return "";
        }
        return split[0];
    }

    public final String zL() {
        return this.cqK == null ? "" : this.cqK;
    }

    public final String zM() {
        return this.cuV == null ? "" : this.cuV;
    }
}
