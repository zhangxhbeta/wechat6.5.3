package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.d;
import com.tencent.mm.wallet_core.b.q;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class e {
    private static SimpleDateFormat eXY = null;
    private static final String[] kSO = new String[]{"ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "COMM_DEBIT", "HSBC_DEBIT"};
    protected static final Pattern lQL = Pattern.compile("((?:(http|https|Http|Https):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?((?:(?:[a-zA-Z0-9][a-zA-Z0-9\\-\\_]{0,64}\\.)+(?:(?:aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(?:biz|b[abdefghijmnorstvwyz])|(?:cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(?:edu|e[cegrstu])|f[ijkmor]|(?:gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(?:info|int|i[delmnoqrst])|(?:jobs|j[emop])|k[eghimnrwyz]|l[abcikrstuvy]|(?:mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(?:name|net|n[acefgilopruz])|(?:org|om)|(?:pro|p[aefghklmnrstwy])|qa|r[eouw]|s[abcdeghijklmnortuvyz]|(?:tel|travel|t[cdfghjklmnoprtvwz])|u[agkmsyz]|v[aceginu]|w[fs]|y[etu]|z[amw]))|(?:(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?");

    public interface a {
        void B(Map<String, Object> map);
    }

    public interface b {
        void aZ(Object obj);
    }

    public static class c {
        public String apU = null;
        public Object nkM = null;

        public c(String str, Object obj) {
            this.apU = str;
            this.nkM = obj;
        }
    }

    static /* synthetic */ byte[] bv(Object obj) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
        return byteArrayOutputStream.toByteArray();
    }

    public static void setNoSystemInputOnEditText(EditText editText) {
        if (VERSION.SDK_INT < 11) {
            editText.setInputType(0);
            return;
        }
        Class cls = EditText.class;
        try {
            Method method = cls.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
            method.setAccessible(false);
            method.invoke(editText, new Object[]{Boolean.valueOf(false)});
        } catch (NoSuchMethodException e) {
            v.e("erik", "setShowSoftInputOnFocus exception!");
            try {
                Method method2 = cls.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});
                method2.setAccessible(false);
                method2.invoke(editText, new Object[]{Boolean.valueOf(false)});
            } catch (Throwable e2) {
                editText.setInputType(0);
                v.a("MicroMsg.WalletBaseUtil ", e2, "", new Object[0]);
            }
        } catch (Throwable e22) {
            v.a("MicroMsg.WalletBaseUtil ", e22, "", new Object[0]);
        }
    }

    public static void i(MMActivity mMActivity) {
        mMActivity.vE(2131236646);
    }

    public static String d(double d, String str) {
        if ("CNY".equals(str)) {
            return String.format("¥%.2f", new Object[]{Double.valueOf(d)});
        } else if ("ZAR".equals(str)) {
            return String.format("R%.2f", new Object[]{Double.valueOf(d)});
        } else if ("1".equals(str) || be.kS(str)) {
            return String.format(q.bLm() + "%.2f", new Object[]{Double.valueOf(d)});
        } else {
            return String.format("%s%.2f", new Object[]{str, Double.valueOf(d)});
        }
    }

    public static String l(double d) {
        return d(d, "");
    }

    public static String m(double d) {
        return String.format("%.2f", new Object[]{Double.valueOf(d)});
    }

    public static String PQ(String str) {
        if ("CNY".equals(str) || "1".equals(str) || be.kS(str)) {
            return "¥";
        }
        return str;
    }

    public static String yB(int i) {
        if (eXY == null) {
            eXY = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        }
        return eXY.format(new Date(((long) i) * 1000));
    }

    public static String yC(int i) {
        return a(i, new SimpleDateFormat("MM-dd HH:mm"), new SimpleDateFormat("yyyy-MM-dd HH:mm"));
    }

    public static String a(int i, SimpleDateFormat simpleDateFormat, SimpleDateFormat simpleDateFormat2) {
        long j = ((long) i) * 1000;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.setTimeInMillis(j);
        if (gregorianCalendar.get(1) == gregorianCalendar2.get(1)) {
            return simpleDateFormat.format(new Date(j));
        }
        return simpleDateFormat2.format(new Date(j));
    }

    public static void M(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            v.v("MicroMsg.WalletBaseUtil ", "username is null");
        } else if (m.eC(str)) {
            bj(context, str);
        } else {
            L(context, str);
        }
    }

    public static void l(Context context, String str, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", z);
        com.tencent.mm.ay.c.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }

    public static void bi(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        com.tencent.mm.ay.c.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 1);
    }

    public static void L(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            v.v("MicroMsg.WalletBaseUtil ", "username is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", str);
        intent.putExtra("force_get_contact", true);
        com.tencent.mm.ay.c.a(context, "com.tencent.mm.plugin.profile.ui.ContactInfoUI", intent);
    }

    public static void eS(Context context) {
        if (context == null) {
            v.e("MicroMsg.WalletBaseUtil ", "hy: jump to preference error. context is null");
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("preferred_tab", 3);
        com.tencent.mm.ay.c.a(context, "com.tencent.mm.ui.LauncherUI", intent);
    }

    public static void bj(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            v.v("MicroMsg.WalletBaseUtil ", "username is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("finish_direct", true);
        com.tencent.mm.ay.c.a(context, ".ui.chatting.ChattingUI", intent);
    }

    public static boolean PR(String str) {
        if (lQL.matcher(str).matches()) {
            return true;
        }
        return false;
    }

    public static String PS(String str) {
        if (be.kS(str)) {
            return str;
        }
        String str2 = "";
        for (int i = 0; i < str.length() - 1; i++) {
            str2 = str2 + "*";
        }
        return str2 + str.substring(str.length() - 1, str.length());
    }

    public static boolean e(JSONObject jSONObject, String str) {
        return "1".equals(jSONObject.optString(str, "0"));
    }

    public static String getUsername() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() != 0) {
            return k.xF();
        }
        throw new com.tencent.mm.model.b();
    }

    public static String PT(String str) {
        if (str == null || str.length() <= 8) {
            return str;
        }
        int length = str.length();
        String substring = str.substring(0, length - 8);
        return substring + "****" + str.substring(length - 4);
    }

    public static String PU(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        String substring = str.substring(1, str.length());
        v.d("MicroMsg.WalletBaseUtil ", "tail : " + substring);
        String substring2 = str.substring(0, 1);
        v.d("MicroMsg.WalletBaseUtil ", "head : " + substring2);
        v.d("MicroMsg.WalletBaseUtil ", "after : " + substring2);
        return "*" + substring;
    }

    public static void a(final Context context, final String str, String str2, boolean z, boolean z2) {
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(context.getString(2131236058));
        linkedList2.add(Integer.valueOf(0));
        if (str != null && z2) {
            linkedList.add(context.getString(2131236057));
            linkedList2.add(Integer.valueOf(1));
        }
        if (z && !be.kS(str2)) {
            linkedList.add(context.getString(2131236059, new Object[]{str2}));
            linkedList2.add(Integer.valueOf(2));
            linkedList.add(context.getString(2131236060, new Object[]{str2}));
            linkedList2.add(Integer.valueOf(3));
        }
        g.a(context, "", linkedList, linkedList2, "", new d() {
            public final void bw(int i, int i2) {
                Intent intent = new Intent();
                switch (i) {
                    case 0:
                        intent.putExtra("rawUrl", context.getString(2131235974, new Object[]{u.bsY()}));
                        break;
                    case 1:
                        if (str != null) {
                            intent.putExtra("rawUrl", context.getString(2131235973, new Object[]{u.bsY(), str}));
                            break;
                        }
                        break;
                    case 2:
                        if (str != null) {
                            intent.putExtra("rawUrl", context.getString(2131235975, new Object[]{u.bsY(), str}));
                            break;
                        }
                        break;
                    case 3:
                        if (str != null) {
                            intent.putExtra("rawUrl", context.getString(2131235976, new Object[]{u.bsY(), str}));
                            break;
                        }
                        break;
                }
                intent.putExtra("showShare", false);
                com.tencent.mm.ay.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
    }

    public static void d(MMActivity mMActivity, String str) {
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 7);
        intent.putExtra("bank_card_owner", str);
        com.tencent.mm.ay.c.b(mMActivity, "scanner", ".ui.BaseScanUI", intent);
    }

    public static String er(String str) {
        String str2 = null;
        ak.yW();
        com.tencent.mm.storage.u LW = com.tencent.mm.model.c.wH().LW(str);
        if (LW != null) {
            str2 = LW.tU();
        }
        return be.kS(str2) ? str : str2;
    }

    public static void bk(Context context, String str) {
        if (!be.kS(str)) {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static long n(double d) {
        return Math.round(100.0d * d);
    }

    public static void a(final c... cVarArr) {
        ak.vy().a(new ay(new com.tencent.mm.model.ay.a() {
            public final void a(com.tencent.mm.network.e eVar) {
                if (eVar != null && eVar.BU() != null) {
                    if (cVarArr == null || cVarArr.length == 0) {
                        v.w("MicroMsg.WalletBaseUtil ", "hy: kvs is null or length is 0");
                        return;
                    }
                    try {
                        for (c cVar : cVarArr) {
                            if (!(cVar == null || be.kS(cVar.apU))) {
                                eVar.BU().h(cVar.apU, e.bv(cVar.nkM));
                            }
                        }
                    } catch (Exception e) {
                        v.e("MicroMsg.WalletBaseUtil ", "hy: serialize failed: %s", new Object[]{e.toString()});
                    }
                }
            }
        }), 0);
    }

    public static void a(final String str, final b bVar) {
        ak.vy().a(new ay(new com.tencent.mm.model.ay.a() {
            public final void a(com.tencent.mm.network.e eVar) {
                if (eVar != null && eVar.BU() != null) {
                    if (be.kS(str)) {
                        v.w("MicroMsg.WalletBaseUtil ", "hy: key is null");
                        return;
                    }
                    try {
                        byte[] gS = eVar.BU().gS(str);
                        if (bVar == null) {
                            return;
                        }
                        if (gS != null) {
                            bVar.aZ(new ObjectInputStream(new ByteArrayInputStream(gS)).readObject());
                        } else {
                            bVar.aZ(null);
                        }
                    } catch (Exception e) {
                        v.e("MicroMsg.WalletBaseUtil ", "hy: deserialize failed: %s", new Object[]{e.toString()});
                        if (bVar != null) {
                            bVar.aZ(null);
                        }
                    }
                }
            }
        }), 0);
    }

    public static void bLF() {
        ak.vy().a(new ay(new com.tencent.mm.model.ay.a() {
            public final void a(com.tencent.mm.network.e eVar) {
                eVar.BW();
            }
        }), 0);
    }

    public static String PV(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length() / 4;
        for (int i = 0; i < length + 1; i++) {
            int min = Math.min((i + 1) * 4, str.length());
            stringBuilder.append(PW(str.substring(i * 4, min)));
            if (min - (i * 4) == 4) {
                stringBuilder.append("    ");
            }
        }
        return stringBuilder.toString();
    }

    public static void ae(ArrayList<Bitmap> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            for (int size = arrayList.size() - 1; size > 0; size--) {
                l((Bitmap) arrayList.remove(size));
            }
        }
    }

    public static void l(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    public static Bitmap k(Bitmap bitmap) {
        boolean z = true;
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(90.0f, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        String str = "MicroMsg.WalletBaseUtil ";
        StringBuilder stringBuilder = new StringBuilder("resultBmp is null: ");
        if (createBitmap != null) {
            z = false;
        }
        v.d(str, stringBuilder.append(z).append("  degree:90.0").toString());
        return createBitmap;
    }

    private static String PW(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.substring(i, i + 1));
            str.length();
        }
        return stringBuilder.toString();
    }

    public static void eT(Context context) {
        if (context == null) {
            v.e("MicroMsg.WalletBaseUtil ", "jumpToWalletSecure context is null");
            return;
        }
        String string;
        if (!p.o(context, "com.tencent.qqpimsecure")) {
            string = context.getResources().getString(2131235742);
        } else if (be.aZ(context, "com.tencent.qqpimsecure")) {
            string = context.getResources().getString(2131235742) + "&qqpimsecurestatus=1";
        } else {
            string = context.getResources().getString(2131235742) + "&qqpimsecurestatus=0";
        }
        v.v("MicroMsg.WalletBaseUtil ", "jump to %s", new Object[]{string + "&lang=" + u.bsY()});
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("showShare", false);
        intent.putExtra("pay_channel", 1);
        com.tencent.mm.ay.c.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }

    public static void a(final String[] strArr, final a aVar) {
        ak.vy().a(new ay(new com.tencent.mm.model.ay.a() {
            public final void a(com.tencent.mm.network.e eVar) {
                if (eVar != null && eVar.BU() != null) {
                    if (strArr == null || strArr.length == 0) {
                        v.w("MicroMsg.WalletBaseUtil ", "hy: keys is null");
                        return;
                    }
                    Map hashMap = new HashMap();
                    int i = 0;
                    while (i < strArr.length) {
                        try {
                            String str = strArr[i];
                            if (be.kS(str)) {
                                v.e("MicroMsg.WalletBaseUtil ", "hy: key is null");
                            } else {
                                byte[] gS = eVar.BU().gS(str);
                                if (gS != null) {
                                    hashMap.put(str, new ObjectInputStream(new ByteArrayInputStream(gS)).readObject());
                                }
                            }
                            i++;
                        } catch (Exception e) {
                            v.e("MicroMsg.WalletBaseUtil ", "hy: deserialize failed: %s", new Object[]{e.toString()});
                            if (aVar != null) {
                                aVar.B(null);
                                return;
                            }
                            return;
                        }
                    }
                    if (aVar != null) {
                        aVar.B(hashMap);
                    }
                }
            }
        }), 0);
    }

    public static void yD(int i) {
        com.tencent.mm.plugin.report.service.g.iuh.h(12719, new Object[]{Integer.valueOf(i), Integer.valueOf(1)});
    }

    public static void a(final TextView textView, final String str, String str2, final String str3) {
        if (textView == null) {
            v.e("MicroMsg.WalletBaseUtil ", "hy: text view is null.");
        } else if (be.kS(str2)) {
            v.w("MicroMsg.WalletBaseUtil ", "hy: msg is null. set text view to gone");
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(str2);
            com.tencent.mm.protocal.g.cq(PX(str), 0);
            if (!be.kS(str3)) {
                textView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        v.i("MicroMsg.WalletBaseUtil ", "hy: on click banner");
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", str3);
                        intent.putExtra("showShare", false);
                        com.tencent.mm.ay.c.b(textView.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                        com.tencent.mm.protocal.g.cq(e.PX(str), 1);
                    }
                });
            }
        }
    }

    private static int PX(String str) {
        if ("1".equals(str)) {
            return 0;
        }
        if ("2".equals(str)) {
            return 4;
        }
        if ("3".equals(str)) {
            return 12;
        }
        if ("4".equals(str)) {
            return 2;
        }
        if ("5".equals(str)) {
            return 8;
        }
        if ("6".equals(str)) {
            return 14;
        }
        if ("7".equals(str)) {
            return 16;
        }
        if ("8".equals(str)) {
            return 10;
        }
        return -1;
    }

    public static void b(int i, long j, int i2) {
        com.tencent.mm.plugin.report.service.g.iuh.h(13375, new Object[]{Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(j), Integer.valueOf(i2)});
    }

    public static String PY(String str) {
        if (!be.kS(str) && str.length() > 14) {
            return str.substring(0, 14) + "...";
        }
        return str;
    }
}
