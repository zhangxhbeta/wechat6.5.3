package com.tencent.mm.ak;

import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;

public final class j extends g {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS oplog2 ( id INTEGER PRIMARY KEY , inserTime long , cmdId int , buffer blob , reserved1 int , reserved2 long , reserved3 text , reserved4 text ) "};
    com.tencent.mm.bg.g cuX;

    public static class b {
        int bkU = -1;
        byte[] buffer;
        long cJZ;
        int cTC;
        long cTD;
        String cTE;
        String cTF;
        com.tencent.mm.ba.a cTG;
        int cmdId;
        int id;

        public b(int i) {
            this.cmdId = i;
        }

        int getCmdId() {
            return this.cmdId;
        }

        final byte[] getBuffer() {
            if (this.buffer == null && this.cTG != null) {
                try {
                    this.buffer = this.cTG.toByteArray();
                } catch (IOException e) {
                    v.e("MicroMsg.OpLogStorage", "summeroplog Operation toByteArray err: " + e.getMessage());
                }
            }
            return this.buffer;
        }
    }

    public static class a extends b {
        private int cmdId;

        public a(int i, com.tencent.mm.ba.a aVar) {
            super(i);
            this.cmdId = i;
            this.cTG = aVar;
        }

        public final int getCmdId() {
            return this.cmdId;
        }
    }

    public j(com.tencent.mm.bg.g gVar) {
        this.cuX = gVar;
    }

    public final boolean a(b bVar) {
        if (bVar == null) {
            return true;
        }
        if (this.cuX.delete("oplog2", "id= ? AND inserTime= ?", new String[]{bVar.id, bVar.cJZ}) < 0) {
            return false;
        }
        return true;
    }
}
