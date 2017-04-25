package com.tencent.mm.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.model.a.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.n;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class av {
    private static av ctf;
    public b cte;

    public enum a {
        ;

        static {
            ctg = 1;
            cth = 2;
            cti = 3;
            ctj = 4;
            ctk = new int[]{ctg, cth, cti, ctj};
        }
    }

    public interface b {
        void zk();
    }

    public static av zh() {
        synchronized (av.class) {
            if (ctf == null) {
                ctf = new av();
            }
        }
        return ctf;
    }

    private av() {
    }

    public final boolean a(au auVar) {
        boolean z = true;
        if (auVar.type == 10000) {
            ak.yW();
            SharedPreferences dT = c.dT("banner");
            if (dT != null) {
                dT.edit().clear().commit();
            }
            if (this.cte == null) {
                return true;
            }
            this.cte.zk();
            return true;
        } else if (auVar.type == 57005) {
            return false;
        } else {
            ak.yW();
            SharedPreferences dT2 = c.dT("banner");
            if (dT2 == null) {
                return false;
            }
            Editor edit = dT2.edit();
            au zi = zi();
            if (fI("HistoryInfo").contains(Integer.valueOf(auVar.type))) {
                z = false;
            }
            if (zi != null && zi.aXx == 2) {
                List fI = fI("HistoryInfo");
                if (!fI.contains(Integer.valueOf(zi.type))) {
                    fI.add(Integer.valueOf(zi.type));
                }
                b("HistoryInfo", fI);
            }
            if (z) {
                edit.putInt("CurrentType", auVar.type).putInt("CurrentShowType", auVar.aXx).putString("CurrentData", auVar.data).commit();
            }
            if (this.cte == null) {
                return z;
            }
            this.cte.zk();
            return z;
        }
    }

    public static au zi() {
        ak.yW();
        SharedPreferences dT = c.dT("banner");
        if (dT == null) {
            return null;
        }
        int i = dT.getInt("CurrentType", -1);
        int i2 = dT.getInt("CurrentShowType", -1);
        String string = dT.getString("CurrentData", SQLiteDatabase.KeyEmpty);
        if (i == -1) {
            return null;
        }
        switch (i) {
            case 1:
                int zj = zj();
                if (zj == a.cti || zj == a.ctj || f.Aj().Ah()) {
                    if (f.Aj().Ah()) {
                        v.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind bind contacts banner.");
                    } else {
                        v.i("MicorMsg.MainFrameBannerStorage", "already Bind the Mobile");
                    }
                    return null;
                }
            case 2:
                if (zj() == a.cti || f.Aj().Ah()) {
                    if (f.Aj().Ah()) {
                        v.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind upload contacts banner.");
                    } else {
                        v.i("MicorMsg.MainFrameBannerStorage", "already upload the contacts");
                    }
                    return null;
                }
            case 3:
                n.Bn();
                if (n.Br()) {
                    v.i("MicorMsg.MainFrameBannerStorage", "avatar already existed");
                    return null;
                }
                break;
            case 5:
                ak.yW();
                String str = (String) c.vf().get(208903, null);
                if (str != null && str.length() > 0) {
                    v.i("MicorMsg.MainFrameBannerStorage", "already bind Google Account");
                    return null;
                }
            case 11:
                return null;
            case 10000:
            case 57005:
                return null;
        }
        return new au(i, i2, string);
    }

    public final void aE(int i, int i2) {
        ak.yW();
        SharedPreferences dT = c.dT("banner");
        if (dT != null) {
            Editor edit = dT.edit();
            switch (i2) {
                case 1:
                    edit.remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
                    break;
                case 2:
                    edit.remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
                    List fI = fI("HistoryInfo");
                    if (!fI.contains(Integer.valueOf(i))) {
                        fI.add(Integer.valueOf(i));
                    }
                    b("HistoryInfo", fI);
                    break;
                case 3:
                    if (i == 3) {
                        edit.remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
                        break;
                    }
                    break;
            }
            if (this.cte != null) {
                this.cte.zk();
            }
        }
    }

    private static boolean b(String str, List<Integer> list) {
        ak.yW();
        SharedPreferences dT = c.dT("banner");
        if (dT == null) {
            return false;
        }
        Editor edit = dT.edit();
        edit.putInt(str + "ArraySize", list.size());
        for (int i = 0; i < list.size(); i++) {
            edit.putInt(str + i, ((Integer) list.get(i)).intValue());
        }
        return edit.commit();
    }

    private static List<Integer> fI(String str) {
        ak.yW();
        SharedPreferences dT = c.dT("banner");
        if (dT == null) {
            return null;
        }
        int i = dT.getInt(str + "ArraySize", 0);
        List<Integer> arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(Integer.valueOf(dT.getInt(str + i2, 0)));
        }
        return arrayList;
    }

    public static int zj() {
        try {
            ak.yW();
            String str = (String) c.vf().get(4097, SQLiteDatabase.KeyEmpty);
            ak.yW();
            String str2 = (String) c.vf().get(6, SQLiteDatabase.KeyEmpty);
            boolean yj = k.yj();
            v.d("MicorMsg.MainFrameBannerStorage", "isUpload " + yj + " stat " + k.xJ());
            if (str == null || str.length() <= 0) {
                str = null;
            }
            if (str2 == null || str2.length() <= 0) {
                str2 = null;
            }
            if (str == null && r1 == null) {
                return a.ctg;
            }
            if (str != null && r1 == null) {
                return a.cth;
            }
            if (yj) {
                return a.cti;
            }
            return a.ctj;
        } catch (Exception e) {
            return a.ctg;
        }
    }
}
