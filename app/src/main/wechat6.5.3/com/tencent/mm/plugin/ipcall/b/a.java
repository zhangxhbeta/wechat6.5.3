package com.tencent.mm.plugin.ipcall.b;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.PhoneNumberUtils;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.aj;
import com.tencent.mm.model.bf;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.u.b;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public final class a {
    public static String gPA = "00";
    public static String gPB = null;
    private static al gPC = new al();
    private static HashMap<String, b> gPD = new HashMap();
    private static HashMap<String, String> gPE = new HashMap();
    private static HashMap<String, String> gPF = new HashMap();
    private static HashMap<String, String> gPG = new HashMap();
    private static HashMap<String, String> gPH = new HashMap();
    public static int gPy = 3;
    public static String gPz = "+";

    private static class a implements Comparator<String> {
        private a() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((String) obj).length() - ((String) obj2).length();
        }
    }

    public static String aa(Context context, String str) {
        String str2 = null;
        if (com.tencent.mm.pluginsdk.i.a.aP(context, "android.permission.READ_CONTACTS")) {
            Cursor query = context.getContentResolver().query(Phone.CONTENT_URI, new String[]{"contact_id", "data1"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        while (!query.isAfterLast()) {
                            if (PhoneNumberUtils.compare(com.tencent.mm.pluginsdk.a.yt(str), query.getString(1))) {
                                str2 = query.getString(0);
                                break;
                            }
                            query.moveToNext();
                        }
                    }
                } catch (Exception e) {
                    v.d("MicroMsg.IPCallAddressUtil", "getNicknameByPhonenumber, error: %s", new Object[]{e.getMessage()});
                    if (query != null) {
                        query.close();
                    }
                } catch (Throwable th) {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } else {
            v.e("MicroMsg.IPCallAddressUtil", "no contact permission");
        }
        return str2;
    }

    public static String ab(Context context, String str) {
        String aa = aa(context, str);
        if (be.kS(aa)) {
            return null;
        }
        return com.tencent.mm.pluginsdk.a.g(aa, context);
    }

    public static String ac(Context context, String str) {
        if (be.kS(str)) {
            return null;
        }
        return com.tencent.mm.pluginsdk.a.g(str, context);
    }

    public static Bitmap ad(Context context, String str) {
        return d(context, str, false);
    }

    public static Bitmap d(Context context, String str, boolean z) {
        if (be.kS(str)) {
            return null;
        }
        return com.tencent.mm.pluginsdk.a.b(str, context, z);
    }

    public static Bitmap ae(Context context, String str) {
        String aa = aa(context, str);
        Bitmap bitmap = null;
        if (!be.kS(aa)) {
            bitmap = d(context, aa, true);
        }
        if (bitmap != null || !Fb()) {
            return bitmap;
        }
        aa = vg(str);
        v.d("MicroMsg.IPCallAddressUtil", "getAvatarByPhoneNumber, username: %s", new Object[]{aa});
        if (be.kS(aa)) {
            return bitmap;
        }
        return b.b(aa, 320, 320, 4);
    }

    public static String vg(String str) {
        if (be.kS(str)) {
            return null;
        }
        return com.tencent.mm.pluginsdk.j.a.lxY.iD(g.m(c.vt(str).getBytes()));
    }

    public static String vh(String str) {
        if (be.kS(str)) {
            return null;
        }
        return com.tencent.mm.pluginsdk.j.a.lxY.iE(str);
    }

    public static String mk(int i) {
        Context context = aa.getContext();
        switch (i) {
            case 1:
                return context.getString(2131234173);
            case 2:
                return context.getString(2131234175);
            case 4:
                return context.getString(2131234172);
            case 5:
                return context.getString(2131234174);
            case 10:
                return context.getString(2131234171);
            default:
                return context.getString(2131234176);
        }
    }

    private static void avw() {
        String str;
        gPE.clear();
        gPF.clear();
        gPG.clear();
        gPH.clear();
        gPD.clear();
        InputStream inputStream = null;
        String str2 = "";
        try {
            inputStream = aa.getContext().getAssets().open("ipcall_country_code.txt");
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            str = new String(bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e) {
                    v.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[]{be.e(e)});
                }
            }
        } catch (Throwable e2) {
            v.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[]{be.e(e2)});
            if (inputStream != null) {
                try {
                    inputStream.close();
                    str = str2;
                } catch (Throwable e22) {
                    v.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[]{be.e(e22)});
                    str = str2;
                }
            } else {
                str = str2;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e3) {
                    v.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[]{be.e(e3)});
                }
            }
        }
        String[] split = str.trim().split("\n");
        for (String str3 : split) {
            String[] split2 = str3.trim().split(" ");
            if (split2.length < 2) {
                v.e("MicroMsg.IPCallAddressUtil", "this country item has problem %s", new Object[]{split[r1]});
            } else {
                b bVar = new b();
                bVar.gPI = split2[0];
                bVar.gPJ = split2[1];
                RegionCodeDecoder.bxc();
                str3 = RegionCodeDecoder.getLocName(split2[0]);
                if (be.kS(str3)) {
                    str3 = new Locale("", split2[0]).getDisplayCountry(aa.getResources().getConfiguration().locale);
                }
                bVar.gPK = str3;
                gPG.put(bVar.gPJ, bVar.gPI);
                gPH.put(bVar.gPI, bVar.gPJ);
                gPE.put(bVar.gPJ, bVar.gPK);
                gPF.put(bVar.gPK, bVar.gPJ);
                gPD.put(bVar.gPI, bVar);
            }
        }
    }

    public static HashMap<String, b> avx() {
        if (gPD.size() == 0) {
            avw();
        }
        return gPD;
    }

    public static String vi(String str) {
        if (gPD.size() == 0) {
            avw();
        }
        if (be.kS(str)) {
            return null;
        }
        b bVar = (b) gPD.get(str);
        return bVar != null ? bVar.gPK : null;
    }

    public static String vj(String str) {
        if (gPE.size() == 0) {
            avw();
        }
        if (be.kS(str)) {
            return null;
        }
        return (String) gPE.get(str);
    }

    public static String vk(String str) {
        if (gPG.size() == 0) {
            avw();
        }
        if (be.kS(str)) {
            return null;
        }
        return (String) gPG.get(str);
    }

    public static int bT(String str, String str2) {
        if (be.kS(str) || be.kS(str2)) {
            return -1;
        }
        int bU = bU(str, str2);
        if (bU != -1 || !str2.startsWith("+")) {
            return bU;
        }
        String vl = vl(str2);
        if (!be.kS(vl)) {
            str2 = str2.substring(("+" + vl).length());
        }
        return bU(str, str2);
    }

    private static int bU(String str, String str2) {
        if (com.tencent.mm.pluginsdk.i.a.aP(aa.getContext(), "android.permission.READ_CONTACTS")) {
            Cursor query = aa.getContext().getContentResolver().query(Phone.CONTENT_URI, null, "contact_id=?", new String[]{str}, null);
            String vt = c.vt(str2);
            int i;
            try {
                if (query.moveToFirst()) {
                    while (!query.isAfterLast()) {
                        i = query.getInt(query.getColumnIndex("data2"));
                        if (c.vt(query.getString(query.getColumnIndex("data1"))).equals(vt)) {
                            return i;
                        }
                        query.moveToNext();
                    }
                }
                query.close();
            } catch (Exception e) {
                Object[] objArr = new Object[1];
                i = e.getMessage();
                objArr[0] = i;
                v.e("MicroMsg.IPCallAddressUtil", "getPhoneTypeByContactIdAndPhoneNumber error: %s", objArr);
            } finally {
                query.close();
            }
            return -1;
        }
        v.e("MicroMsg.IPCallAddressUtil", "no contact permission");
        return -1;
    }

    public static String vl(String str) {
        if (gPE.size() == 0) {
            avw();
        }
        if (vn(str)) {
            String vt = c.vt(vo(str));
            List<String> arrayList = new ArrayList(gPE.keySet());
            Collections.sort(arrayList, Collections.reverseOrder(new a()));
            for (String str2 : arrayList) {
                if (vt.startsWith(str2)) {
                    return str2;
                }
            }
        }
        return null;
    }

    public static boolean vm(String str) {
        if (gPE.size() == 0) {
            avw();
        }
        if (gPE.containsKey(str)) {
            return true;
        }
        return false;
    }

    public static boolean vn(String str) {
        if (be.kS(str) || (!str.startsWith(gPz) && !str.startsWith(gPA))) {
            return false;
        }
        return true;
    }

    public static String vo(String str) {
        if (be.kS(str)) {
            return str;
        }
        if (str.startsWith(gPz)) {
            return str.substring(gPz.length());
        }
        if (str.startsWith(gPA)) {
            return str.substring(gPA.length());
        }
        return str;
    }

    public static String vp(String str) {
        String vt = c.vt(str);
        String vt2 = c.vt(vt);
        String str2 = null;
        if (vn(vt2)) {
            str2 = vl(vt2);
        }
        if (be.kS(str2)) {
            str2 = al.Kp(vt);
        } else {
            vt = vo(vt2).substring(str2.length());
            vt2 = al.formatNumber(str2, vt);
            if (!be.kS(vt2)) {
                vt = vt2;
            }
            str2 = !vt.startsWith("+") ? "+" + str2 + " " + vt : "+" + str2 + " " + vt.replace("+", "");
        }
        if (str2.length() > 25) {
            return str2.substring(0, 25) + "...";
        }
        return str2;
    }

    public static String avy() {
        if (gPF.size() == 0) {
            avw();
        }
        String buo = be.buo();
        if (!be.kS(buo)) {
            v.i("MicroMsg.IPCallAddressUtil", "simCountryCode: %s", new Object[]{buo});
            buo = (String) gPH.get(buo.toUpperCase());
            if (!be.kS(buo)) {
                v.i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", new Object[]{buo});
                if (!be.kS(buo)) {
                    return buo;
                }
                buo = bf.zO().bfd;
                v.i("MicroMsg.IPCallAddressUtil", "personalInfoCountryCode: %s", new Object[]{buo});
                if (!be.kS(buo)) {
                    buo = (String) gPH.get(buo);
                    if (!be.kS(buo)) {
                        v.i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", new Object[]{buo});
                        return buo;
                    }
                }
                v.i("MicroMsg.IPCallAddressUtil", "fallbackCountryCode: %s", new Object[]{aa.getContext().getString(2131232237)});
                return aa.getContext().getString(2131232237).replace("+", "");
            }
        }
        buo = "";
        if (!be.kS(buo)) {
            return buo;
        }
        buo = bf.zO().bfd;
        v.i("MicroMsg.IPCallAddressUtil", "personalInfoCountryCode: %s", new Object[]{buo});
        if (be.kS(buo)) {
            buo = (String) gPH.get(buo);
            if (be.kS(buo)) {
                v.i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", new Object[]{buo});
                return buo;
            }
        }
        v.i("MicroMsg.IPCallAddressUtil", "fallbackCountryCode: %s", new Object[]{aa.getContext().getString(2131232237)});
        return aa.getContext().getString(2131232237).replace("+", "");
    }

    public static void avz() {
        avw();
    }

    public static String vq(String str) {
        if (gPE.size() == 0) {
            avw();
        }
        if (!vn(str)) {
            return str;
        }
        str = c.vt(vo(str));
        List<String> arrayList = new ArrayList(gPE.keySet());
        Collections.sort(arrayList, Collections.reverseOrder(new a()));
        for (String str2 : arrayList) {
            if (str.startsWith(str2)) {
                return str.substring(str2.length());
            }
        }
        return str;
    }

    public static boolean Fb() {
        aj ajVar = new aj();
        com.tencent.mm.sdk.c.a.nhr.z(ajVar);
        v.d("MicroMsg.IPCallAddressUtil", "canSyncAddrBook: %b", new Object[]{Boolean.valueOf(ajVar.aXZ.aXR)});
        return ajVar.aXZ.aXR;
    }

    public static ArrayList<String> vr(String str) {
        ArrayList<String> arrayList = new ArrayList();
        if (com.tencent.mm.pluginsdk.i.a.aP(aa.getContext(), "android.permission.READ_CONTACTS")) {
            Cursor query = aa.getContext().getContentResolver().query(Phone.CONTENT_URI, null, "data1 LIKE ?", new String[]{"%" + str + "%"}, null);
            try {
                if (query.moveToFirst()) {
                    while (!query.isAfterLast()) {
                        arrayList.add(query.getString(query.getColumnIndex("contact_id")));
                        query.moveToNext();
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e) {
                v.e("MicroMsg.IPCallAddressUtil", "getQueryPhoneNumberContactIdList error: %s", new Object[]{e.getMessage()});
                return arrayList;
            } finally {
                if (query != null) {
                    query.close();
                }
            }
            return arrayList;
        }
        v.e("MicroMsg.IPCallAddressUtil", "no contact permission");
        return arrayList;
    }
}
