package ct;

import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ak extends bh {
    private static ArrayList k;
    private static Map l;
    private String a = SQLiteDatabase.KeyEmpty;
    private String b = SQLiteDatabase.KeyEmpty;
    private ArrayList c = null;
    private String d = SQLiteDatabase.KeyEmpty;
    private String e = SQLiteDatabase.KeyEmpty;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private String i = SQLiteDatabase.KeyEmpty;
    private Map j = null;

    public ak(String str, String str2, ArrayList arrayList, String str3, String str4, int i, int i2, int i3, String str5, Map map) {
        this.a = str;
        this.b = str2;
        this.c = arrayList;
        this.d = str3;
        this.e = str4;
        this.f = i;
        this.g = i2;
        this.h = i3;
        this.i = str5;
        this.j = map;
    }

    public final void a(bf bfVar) {
        this.a = bfVar.a(0, true);
        this.b = bfVar.a(1, true);
        if (k == null) {
            k = new ArrayList();
            k.add(SQLiteDatabase.KeyEmpty);
        }
        this.c = (ArrayList) bfVar.a(k, 2, true);
        this.d = bfVar.a(3, false);
        this.e = bfVar.a(4, false);
        this.f = bfVar.a(this.f, 5, false);
        this.g = bfVar.a(this.g, 6, false);
        this.h = bfVar.a(this.h, 7, false);
        this.i = bfVar.a(8, false);
        if (l == null) {
            l = new HashMap();
            l.put(SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
        }
        this.j = (Map) bfVar.a(l, 9, false);
    }

    public final void a(bg bgVar) {
        bgVar.a(this.a, 0);
        bgVar.a(this.b, 1);
        bgVar.a(this.c, 2);
        if (this.d != null) {
            bgVar.a(this.d, 3);
        }
        if (this.e != null) {
            bgVar.a(this.e, 4);
        }
        bgVar.a(this.f, 5);
        bgVar.a(this.g, 6);
        bgVar.a(this.h, 7);
        if (this.i != null) {
            bgVar.a(this.i, 8);
        }
        if (this.j != null) {
            bgVar.a(this.j, 9);
        }
    }
}
