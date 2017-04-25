package ct;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class c {
    public static final int[] a = new int[]{80, 8080, 14000};
    public long b;
    private Map c;

    public c(an anVar) {
        try {
            this.b = anVar.b;
            this.c = new HashMap();
            for (Integer num : anVar.a.keySet()) {
                if (bc.a(num)) {
                    ArrayList arrayList = (ArrayList) anVar.a.get(num);
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        s sVar = new s();
                        if (sVar.a(str)) {
                            arrayList2.add(sVar);
                        }
                    }
                    this.c.put(num, arrayList2);
                }
            }
        } catch (Exception e) {
        }
    }

    private static String a(int i) {
        return i == 1 ? "access_cm" : i == 2 ? "access_uni" : i == 3 ? "access_ct" : SQLiteDatabase.KeyEmpty;
    }

    public final void a() {
        try {
            SharedPreferences sharedPreferences = p.a.getSharedPreferences("Access_Preferences", 0);
            this.b = sharedPreferences.getLong("timeStamp", 0);
            this.c = new HashMap();
            for (int i = 1; i <= 3; i++) {
                String string = sharedPreferences.getString(a(i), SQLiteDatabase.KeyEmpty);
                if (TextUtils.isEmpty(string)) {
                    string = SQLiteDatabase.KeyEmpty;
                    if (i == 1) {
                        string = "183.61.38.168:14000,117.135.171.182:14000";
                    } else if (i == 2) {
                        string = "112.90.140.213:14000,112.90.140.216:14000";
                    } else if (i == 3) {
                        string = "14.17.41.159:14000,140.206.160.242:14000";
                    }
                    bd.b();
                }
                String[] split = string.split(",");
                if (split.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String str : split) {
                        s sVar = new s();
                        if (sVar.a(str)) {
                            arrayList.add(sVar);
                        }
                    }
                    this.c.put(Integer.valueOf(i), arrayList);
                }
            }
        } catch (Exception e) {
        }
    }

    public final void b() {
        try {
            SharedPreferences sharedPreferences = p.a.getSharedPreferences("Access_Preferences", 0);
            if (this.c != null && this.c.size() > 0) {
                for (Integer num : this.c.keySet()) {
                    if (bc.a(num)) {
                        String a = a(num.intValue());
                        ArrayList arrayList = (ArrayList) this.c.get(num);
                        if (arrayList != null && arrayList.size() > 0) {
                            StringBuilder stringBuilder = new StringBuilder();
                            Iterator it = ((ArrayList) this.c.get(num)).iterator();
                            while (it.hasNext()) {
                                stringBuilder.append(((s) it.next()).a());
                                stringBuilder.append(",");
                            }
                            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                            sharedPreferences.edit().putString(a, stringBuilder.toString()).commit();
                        }
                    }
                }
                sharedPreferences.edit().putLong("timesStamp", this.b).commit();
            }
        } catch (Exception e) {
        }
    }

    public final synchronized ArrayList c() {
        ArrayList arrayList;
        int i = 0;
        synchronized (this) {
            arrayList = new ArrayList();
            try {
                int d = bc.d();
                if (bc.a(Integer.valueOf(d))) {
                    for (Integer num : this.c.keySet()) {
                        ArrayList arrayList2 = (ArrayList) this.c.get(num);
                        if (d == num.intValue()) {
                            arrayList.addAll(0, arrayList2);
                        } else {
                            arrayList.addAll(arrayList2);
                        }
                    }
                } else {
                    d = 0;
                    for (Integer num2 : this.c.keySet()) {
                        d = Math.max(d, ((ArrayList) this.c.get(num2)).size());
                    }
                    while (i < d) {
                        for (Integer num22 : this.c.keySet()) {
                            ArrayList arrayList3 = (ArrayList) this.c.get(num22);
                            if (i < arrayList3.size()) {
                                arrayList.add(arrayList3.get(i));
                            }
                        }
                        i++;
                    }
                }
            } catch (Exception e) {
            }
        }
        return arrayList;
    }
}
