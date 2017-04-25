package com.tencent.mm.plugin.ipcall.b;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.mm.e.a.qi;
import com.tencent.mm.h.j;
import com.tencent.mm.protocal.c.aau;
import com.tencent.mm.protocal.c.anl;
import com.tencent.mm.protocal.c.beg;
import com.tencent.mm.protocal.c.beh;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class c {
    public static beh O(LinkedList<anl> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return null;
        }
        beh com_tencent_mm_protocal_c_beh = new beh();
        com_tencent_mm_protocal_c_beh.naa = linkedList.size();
        com_tencent_mm_protocal_c_beh.nab = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            anl com_tencent_mm_protocal_c_anl = (anl) it.next();
            beg com_tencent_mm_protocal_c_beg = new beg();
            com_tencent_mm_protocal_c_beg.mWf = vs(com_tencent_mm_protocal_c_anl.mGp);
            com_tencent_mm_protocal_c_beg.mNM = com_tencent_mm_protocal_c_anl.mNM;
            com_tencent_mm_protocal_c_beh.nab.add(com_tencent_mm_protocal_c_beg);
        }
        return com_tencent_mm_protocal_c_beh;
    }

    private static int vs(String str) {
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            if (address != null) {
                int i = 0;
                int i2 = 0;
                while (i < address.length) {
                    int i3 = (address[i] & 255) | (i2 << 8);
                    i++;
                    i2 = i3;
                }
                v.d("MicroMsg.IPCallUtil", "ipAddressStrToInt, ip: %s, result: %d", new Object[]{str, Integer.valueOf(i2)});
                return i2;
            }
        } catch (Throwable e) {
            v.a("MicroMsg.IPCallUtil", e, "", new Object[0]);
        }
        return 0;
    }

    public static int avA() {
        Context context = aa.getContext();
        if (ak.is2G(context)) {
            return 1;
        }
        if (ak.is3G(context)) {
            return 3;
        }
        if (ak.is4G(context)) {
            return 5;
        }
        if (ak.isWifi(context)) {
            return 4;
        }
        return 0;
    }

    public static String vt(String str) {
        return str.replace("-", "").replace(" ", "").replace("(", "").replace(")", "").trim();
    }

    public static String ml(int i) {
        Context context = aa.getContext();
        switch (i) {
            case 1:
                return context.getString(2131233395);
            case 2:
                return context.getString(2131233395);
            case 6:
                return context.getString(2131233391);
            case 7:
                return context.getString(2131233392);
            default:
                return context.getString(2131233395);
        }
    }

    public static CharSequence g(Context context, long j) {
        return DateFormat.format(context.getString(2131232889), j);
    }

    public static String af(Context context, String str) {
        int i = 0;
        String[] stringArray = context.getResources().getStringArray(2131296297);
        List arrayList = new ArrayList();
        arrayList.add("");
        for (int i2 = i; i2 < stringArray.length; i2++) {
            arrayList.add(stringArray[i2]);
        }
        try {
            i = be.getInt(str, 0);
        } catch (Exception e) {
        }
        if (i >= arrayList.size()) {
            return "";
        }
        return (String) arrayList.get(i);
    }

    public static String cd(long j) {
        Object obj = 1;
        Context context = aa.getContext();
        if ((ce(j) == 0 ? 1 : null) != null) {
            return new SimpleDateFormat("HH:mm", Locale.US).format(new Date(j));
        }
        if (ce(j) != -1) {
            obj = null;
        }
        if (obj != null) {
            return context.getString(2131233343);
        }
        return new SimpleDateFormat("MM/dd", Locale.US).format(new Date(j));
    }

    private static long ce(long j) {
        Calendar instance = Calendar.getInstance();
        long timeInMillis = instance.getTimeInMillis();
        instance.add(6, 1);
        long timeInMillis2 = instance.getTimeInMillis() - timeInMillis;
        return (j / timeInMillis2) - (Calendar.getInstance().getTimeInMillis() / timeInMillis2);
    }

    public static String cf(long j) {
        Context context = aa.getContext();
        if (((double) j) <= 60.0d) {
            return context.getString(2131233350, new Object[]{Long.valueOf(j)});
        }
        int i = (int) (((double) j) / 60.0d);
        if ((((double) j) / 60.0d) - ((double) i) > 0.0d) {
            i++;
        }
        return context.getString(2131233349, new Object[]{Integer.valueOf(i)});
    }

    public static boolean avB() {
        boolean z;
        boolean z2 = true;
        try {
            qi qiVar = new qi();
            qiVar.brC.bdn = 2;
            a.nhr.z(qiVar);
            z = qiVar.brD.brE;
        } catch (Throwable e) {
            v.a("MicroMsg.IPCallUtil", e, "", new Object[0]);
            z = false;
        }
        String str = "MicroMsg.IPCallUtil";
        String str2 = "check is Voip NOT Calling: %B";
        Object[] objArr = new Object[1];
        if (z) {
            z2 = false;
        }
        objArr[0] = Boolean.valueOf(z2);
        v.d(str, str2, objArr);
        return z;
    }

    public static void c(MMActivity mMActivity, String str) {
        ((ClipboardManager) mMActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, str));
    }

    public static String avC() {
        String string = aa.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryCode", "");
        if (be.kS(string)) {
            return a.avy();
        }
        return string.replace("+", "");
    }

    public static boolean avD() {
        return j.sU().getInt("WCOSecondPurchaseSwitch", 0) > 0;
    }

    public static aau avE() {
        com.tencent.mm.model.ak.yW();
        Object obj = com.tencent.mm.model.c.vf().get(t.a.nrH, null);
        if (obj != null) {
            aau com_tencent_mm_protocal_c_aau = new aau();
            try {
                com_tencent_mm_protocal_c_aau.az(be.KG(obj.toString()));
                v.i("MicroMsg.IPCallUtil", "[royle]parse success,Coupons:%s,Wording:%s,Title:%s,Desc:%s,UrlPath:%s,Balance:%s,PVWording:%s", new Object[]{com_tencent_mm_protocal_c_aau.mCd, com_tencent_mm_protocal_c_aau.gIE, com_tencent_mm_protocal_c_aau.aXz, com_tencent_mm_protocal_c_aau.gkC, com_tencent_mm_protocal_c_aau.mCe, com_tencent_mm_protocal_c_aau.mCf, com_tencent_mm_protocal_c_aau.mCg, com_tencent_mm_protocal_c_aau.mCh});
                return com_tencent_mm_protocal_c_aau;
            } catch (IOException e) {
                v.i("MicroMsg.IPCallUtil", "[royle]parse exception:%s", new Object[]{e.getMessage()});
            }
        }
        return null;
    }
}
