package com.tencent.mm.plugin.ipcall.a;

import android.database.Cursor;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.h.j;
import com.tencent.mm.plugin.ipcall.a.g.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {
    private static c gEA;
    private ArrayList<Integer> gEB = new ArrayList();
    ArrayList<Integer> gEC = new ArrayList();
    public boolean isInit = false;

    private c() {
    }

    public static c atY() {
        if (gEA == null) {
            gEA = new c();
        }
        return gEA;
    }

    public final void dx(boolean z) {
        Throwable e;
        InputStream inputStream = null;
        if (!this.isInit || z) {
            aua();
            try {
                File file = new File(e.cng + "ipcallCountryCodeConfig.cfg");
                String str;
                if (file.exists()) {
                    InputStream fileInputStream = new FileInputStream(file);
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                        str = "";
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                str = str + readLine;
                            } else {
                                v.d("MicroMsg.IPCallCountryCodeConfig", "config file content: %s", new Object[]{str});
                                uH(str);
                                this.isInit = true;
                                com.tencent.mm.a.e.c(fileInputStream);
                                return;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        inputStream = fileInputStream;
                        try {
                            v.a("MicroMsg.IPCallCountryCodeConfig", e, "", new Object[0]);
                            v.e("MicroMsg.IPCallCountryCodeConfig", "initConfig error: %s", new Object[]{e.getMessage()});
                            com.tencent.mm.a.e.c(inputStream);
                        } catch (Throwable th) {
                            e = th;
                            com.tencent.mm.a.e.c(inputStream);
                            throw e;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        inputStream = fileInputStream;
                        com.tencent.mm.a.e.c(inputStream);
                        throw e;
                    }
                }
                v.d("MicroMsg.IPCallCountryCodeConfig", "initConfig, file: %s not exist!", new Object[]{str});
                this.isInit = true;
                com.tencent.mm.a.e.c(null);
            } catch (Exception e3) {
                e = e3;
                v.a("MicroMsg.IPCallCountryCodeConfig", e, "", new Object[0]);
                v.e("MicroMsg.IPCallCountryCodeConfig", "initConfig error: %s", new Object[]{e.getMessage()});
                com.tencent.mm.a.e.c(inputStream);
            }
        }
    }

    private void uH(String str) {
        if (!be.kS(str)) {
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("restriction");
                v.d("MicroMsg.IPCallCountryCodeConfig", "restrictionCountryCode: %d", new Object[]{Integer.valueOf(jSONArray.length())});
                this.gEC.clear();
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.gEC.add(Integer.valueOf(jSONArray.getInt(i)));
                }
            } catch (Throwable e) {
                v.a("MicroMsg.IPCallCountryCodeConfig", e, "", new Object[0]);
                v.e("MicroMsg.IPCallCountryCodeConfig", "initConfigFromContent error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    private void atZ() {
        this.gEB.clear();
        String value = j.sU().getValue("WeChatOutTopCountryCode");
        v.d("MicroMsg.IPCallCountryCodeConfig", "popularCountryConfig: %s", new Object[]{value});
        if (!be.kS(value)) {
            String[] split = value.trim().split(",");
            int length = split.length;
            try {
                int i = length;
                for (String str : split) {
                    Integer valueOf = Integer.valueOf(be.getInt(str, 0));
                    this.gEB.add(valueOf);
                    i.aut().t(valueOf.intValue(), (long) i);
                    i--;
                }
            } catch (NumberFormatException e) {
                v.e("MicroMsg.IPCallCountryCodeConfig", "initPopularCountryFromDynamicConfig error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public final void aua() {
        com.tencent.mm.plugin.ipcall.a.g.j aut = i.aut();
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ORDER BY IPCallPopularCountry.callTimeCount DESC,IPCallPopularCountry.lastCallTime DESC");
        Cursor rawQuery = aut.cie.rawQuery("SELECT IPCallPopularCountry.countryCode,IPCallPopularCountry.callTimeCount,IPCallPopularCountry.lastCallTime FROM IPCallPopularCountry  " + stringBuilder.toString(), null);
        if (rawQuery != null && rawQuery.moveToFirst()) {
            ArrayList arrayList2 = new ArrayList();
            while (!rawQuery.isAfterLast()) {
                i iVar = new i();
                iVar.b(rawQuery);
                arrayList.add(Integer.valueOf(iVar.field_countryCode));
                rawQuery.moveToNext();
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        if (arrayList.size() > 0) {
            this.gEB = arrayList;
        } else {
            atZ();
        }
    }

    public final List<Integer> aub() {
        if (!this.isInit) {
            dx(false);
        }
        return this.gEB;
    }

    public final boolean lU(int i) {
        if (!this.isInit) {
            dx(false);
        }
        if (this.gEC == null || this.gEC.size() <= 0) {
            return false;
        }
        return this.gEC.contains(Integer.valueOf(i));
    }
}
