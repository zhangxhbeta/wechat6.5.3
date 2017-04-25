package com.tencent.mm.ak;

import com.tencent.mm.ak.j.b;
import com.tencent.mm.protocal.c.afj;
import com.tencent.mm.protocal.c.afk;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;

@Deprecated
public final class i extends b {
    private afk cTA;

    public static class a {
        afj cTB;
        private int key;
        private String value;

        public a() {
            this.key = 0;
            this.value = SQLiteDatabase.KeyEmpty;
            this.cTB = new afj();
            this.cTB.itH = 0;
            this.cTB.itR = SQLiteDatabase.KeyEmpty;
        }

        public a(int i, String str) {
            this.key = i;
            this.value = str;
            this.cTB = new afj();
            this.cTB.itH = i;
            this.cTB.itR = str;
        }
    }

    public i(List<a> list) {
        super(36);
        LinkedList linkedList = new LinkedList();
        for (a aVar : list) {
            linkedList.add(aVar.cTB);
        }
        this.cTA = new afk();
        this.cTA.eet = list.size();
        this.cTA.eeu = linkedList;
        this.cTG = this.cTA;
    }
}
