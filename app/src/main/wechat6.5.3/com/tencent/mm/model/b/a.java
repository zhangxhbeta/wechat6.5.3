package com.tencent.mm.model.b;

import android.content.SharedPreferences;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class a implements d {
    protected com.tencent.mm.model.b.d.a cvZ;
    protected String cwa = Al();
    protected String[] cwb = Ak();

    public abstract String Al();

    public final boolean gg(String str) {
        ak.yW();
        SharedPreferences dT = c.dT("banner");
        if (dT == null || !dT.getBoolean(this.cwa + str, false)) {
            return false;
        }
        return true;
    }

    public final void a(String str, boolean z, String[] strArr) {
        ak.yW();
        SharedPreferences dT = c.dT("banner");
        if (dT != null) {
            dT.edit().putBoolean(this.cwa + str, z).commit();
            if (!(this.cwb == null || strArr == null || this.cwb.length != strArr.length)) {
                int i = 0;
                for (String str2 : this.cwb) {
                    if (str2 != null) {
                        dT.edit().putString(this.cwa + str2 + str, strArr[i] != null ? strArr[i] : SQLiteDatabase.KeyEmpty).commit();
                    }
                    i++;
                }
            }
            if (this.cvZ != null) {
                this.cvZ.Am();
            }
        }
    }

    public final String M(String str, String str2) {
        ak.yW();
        SharedPreferences dT = c.dT("banner");
        if (dT == null) {
            return null;
        }
        return dT.getString(this.cwa + str2 + str, null);
    }

    public final void gh(String str) {
        ak.yW();
        SharedPreferences dT = c.dT("banner");
        if (dT != null) {
            dT.edit().remove(this.cwa + str).commit();
            if (this.cwb != null) {
                for (String str2 : this.cwb) {
                    if (str2 != null) {
                        dT.edit().remove(this.cwa + str2 + str).commit();
                    }
                }
            }
            if (this.cvZ != null) {
                this.cvZ.An();
            }
        }
    }

    public final void a(com.tencent.mm.model.b.d.a aVar) {
        this.cvZ = aVar;
    }

    protected String[] Ak() {
        return null;
    }
}
