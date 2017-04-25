package com.tencent.mm.storage;

import com.tencent.mmdb.database.SQLiteDatabase;

public final class ak {
    public static final ak nvp = new ak("timeline");
    public static final ak nvq = new ak("album_friend");
    public static final ak nvr = new ak("album_self");
    public static final ak nvs = new ak("album_stranger");
    public static final ak nvt = new ak("profile_friend");
    public static final ak nvu = new ak("profile_stranger");
    public static final ak nvv = new ak("comment");
    public static final ak nvw = new ak("comment_detail");
    public static final ak nvx = new ak("other");
    public static final ak nvy = new ak("snssight");
    public static final ak nvz = new ak("fts");
    public int hrm = 0;
    public String tag = SQLiteDatabase.KeyEmpty;

    public static ak bvR() {
        return new ak("timeline");
    }

    public static ak bvS() {
        return new ak("album_friend");
    }

    public static ak bvT() {
        return new ak("album_self");
    }

    public static ak bvU() {
        return new ak("album_stranger");
    }

    public static ak bvV() {
        return new ak("snssight");
    }

    public ak(String str) {
        this.tag = str;
    }

    public final ak vf(int i) {
        this.hrm = i;
        return this;
    }

    public static ak a(ak akVar, int i) {
        ak akVar2 = new ak(akVar.tag);
        akVar2.hrm = i;
        return akVar2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ak) {
            return ((ak) obj).tag.equals(this.tag);
        }
        return super.equals(obj);
    }

    public final String toString() {
        return this.tag + "@" + this.hrm;
    }
}
