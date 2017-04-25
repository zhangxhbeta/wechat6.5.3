package ct;

import android.text.TextUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class t {
    String a;
    Map b = new HashMap();

    public static class a {
        String a;
        public String b;
        public List c;
        public s d;
        long e;

        public a(String str, long j, String str2) {
            this.a = str;
            this.e = j;
            this.b = str2;
            this.c = new ArrayList();
        }

        public a(String str, long j, String str2, String str3, String str4) {
            s sVar;
            this.a = str;
            this.e = j;
            this.b = str3;
            this.c = a(str2);
            if (!TextUtils.isEmpty(str4)) {
                String[] split = str4.split(":");
                if (split != null && split.length > 0) {
                    sVar = new s(split[0], Integer.parseInt(split[1]));
                    this.d = sVar;
                }
            }
            sVar = null;
            this.d = sVar;
        }

        private static ArrayList a(String str) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(",");
                if (split != null && split.length > 0) {
                    for (String split2 : split) {
                        String[] split3 = split2.split(":");
                        if (split3 != null && split3.length > 0) {
                            arrayList.add(new s(split3[0], Integer.parseInt(split3[1])));
                        }
                    }
                }
            }
            return arrayList;
        }

        public final String a() {
            List<s> list = this.c;
            if (list == null || list.size() == 0) {
                return SQLiteDatabase.KeyEmpty;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (s a : list) {
                stringBuilder.append(a.a());
                stringBuilder.append(",");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return stringBuilder.toString();
        }

        public final boolean b() {
            return System.currentTimeMillis() - this.e > ((long) ((ct.b.a.b().b.e * 60) * 1000));
        }
    }

    public t(String str) {
        this.a = str;
    }

    public final void a(a aVar) {
        this.b.put(aVar.a, aVar);
    }
}
