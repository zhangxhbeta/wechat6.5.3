package com.tencent.mm.plugin.bottle.a;

import android.content.ContentValues;
import com.tencent.mm.sdk.h.g;

public final class b extends g {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS bottleinfo1 ( parentclientid text  , childcount int  , bottleid text  PRIMARY KEY , bottletype int  , msgtype int  , voicelen int  , content text  , createtime long  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) "};
    public com.tencent.mm.bg.g cuX;

    public b(com.tencent.mm.bg.g gVar) {
        this.cuX = gVar;
    }

    public final boolean a(a aVar) {
        aVar.bkU = -1;
        ContentValues contentValues = new ContentValues();
        if ((aVar.bkU & 1) != 0) {
            contentValues.put("parentclientid", aVar.eta == null ? "" : aVar.eta);
        }
        if ((aVar.bkU & 2) != 0) {
            contentValues.put("childcount", Integer.valueOf(aVar.etb));
        }
        if ((aVar.bkU & 4) != 0) {
            contentValues.put("bottleid", aVar.Xx());
        }
        if ((aVar.bkU & 8) != 0) {
            contentValues.put("bottletype", Integer.valueOf(aVar.etd));
        }
        if ((aVar.bkU & 16) != 0) {
            contentValues.put("msgtype", Integer.valueOf(aVar.msgType));
        }
        if ((aVar.bkU & 32) != 0) {
            contentValues.put("voicelen", Integer.valueOf(aVar.ete));
        }
        if ((aVar.bkU & 64) != 0) {
            contentValues.put("content", aVar.pO());
        }
        if ((aVar.bkU & 128) != 0) {
            contentValues.put("createtime", Long.valueOf(aVar.etf));
        }
        if ((aVar.bkU & 256) != 0) {
            contentValues.put("reserved1", Integer.valueOf(aVar.cuT));
        }
        if ((aVar.bkU & 512) != 0) {
            contentValues.put("reserved2", Integer.valueOf(aVar.cHX));
        }
        if ((aVar.bkU & 1024) != 0) {
            contentValues.put("reserved3", aVar.cuV == null ? "" : aVar.cuV);
        }
        if ((aVar.bkU & 2048) != 0) {
            contentValues.put("reserved4", aVar.cuW == null ? "" : aVar.cuW);
        }
        if (((int) this.cuX.insert("bottleinfo1", "bottleid", contentValues)) != -1) {
            return true;
        }
        return false;
    }
}
