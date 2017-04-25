package ct;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class d {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public ao f;

    public d(aj ajVar) {
        this.a = ajVar.a;
        this.b = ajVar.b;
        this.c = ajVar.c;
        this.d = ajVar.d;
        this.e = ajVar.e;
        this.f = ajVar.f;
    }

    private void c() {
        if (this.a < 10000 || this.a > 30000) {
            this.a = 20000;
        }
        if (this.b < 10000 || this.b > 30000) {
            this.b = 20000;
        }
        if (this.c < 3 || this.c > 15) {
            this.c = 8;
        }
        if (this.d <= 0 || this.d > 5) {
            this.d = 2;
        }
        if (this.e < 5 || this.e > 240) {
            this.e = 60;
        }
    }

    public final void a() {
        ao aoVar = null;
        SharedPreferences sharedPreferences = p.a.getSharedPreferences("Access_Preferences", 0);
        this.a = sharedPreferences.getInt("connectTimeout", 20000);
        this.b = sharedPreferences.getInt("readTimeout", 20000);
        this.c = sharedPreferences.getInt("apnCachedNum", 8);
        this.d = sharedPreferences.getInt("parallelNum", 2);
        this.e = sharedPreferences.getInt("expireTime", 30);
        String string = sharedPreferences.getString("samplingInfo", null);
        if (string != null) {
            String[] split = string.split(";");
            ao aoVar2 = new ao();
            Map hashMap = new HashMap();
            for (int i = 0; i < split.length - 1; i++) {
                String[] split2 = split[i].split(",");
                hashMap.put(Integer.valueOf(Integer.parseInt(split2[0])), Byte.valueOf(Byte.parseByte(split2[1])));
            }
            aoVar2.a = hashMap;
            aoVar2.b = Byte.parseByte(split[split.length - 1]);
            aoVar = aoVar2;
        }
        this.f = aoVar;
        c();
    }

    public final void b() {
        String stringBuilder;
        SharedPreferences sharedPreferences = p.a.getSharedPreferences("Access_Preferences", 0);
        c();
        sharedPreferences.edit().putInt("connectTimeout", this.a).commit();
        sharedPreferences.edit().putInt("readTimeout", this.b).commit();
        sharedPreferences.edit().putInt("apnCachedNum", this.c).commit();
        sharedPreferences.edit().putInt("parallelNum", this.d).commit();
        sharedPreferences.edit().putInt("expireTime", this.e).commit();
        Editor edit = sharedPreferences.edit();
        String str = "samplingInfo";
        ao aoVar = this.f;
        StringBuilder stringBuilder2 = new StringBuilder();
        if (aoVar.a != null) {
            for (Entry entry : aoVar.a.entrySet()) {
                stringBuilder2.append(entry.getKey() + "," + entry.getValue() + ";");
            }
            stringBuilder2.append(aoVar.b);
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = null;
        }
        edit.putString(str, stringBuilder).commit();
    }

    public final String toString() {
        return "connectTimeout:" + this.a + ",readTimeout:" + this.b + ",apnCachedNum:" + this.c + ",parallelNum:" + this.d + ",expireTime:" + this.e;
    }
}
