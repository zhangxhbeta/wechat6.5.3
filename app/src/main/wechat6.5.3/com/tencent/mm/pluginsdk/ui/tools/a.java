package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.webkit.MimeTypeMap;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.r;
import com.tencent.mm.ui.d.d;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class a {
    private static Intent lRL;
    private static WeakReference<Activity> lRM;
    private static final HashMap<String, String> lRN;

    public enum a {
        NOT_INSTALL,
        INSTALL_BUT_NEED_UPDATE,
        INSTALL_BUT_NOT_SUPPORT,
        INSTALL_AND_SUPPORT
    }

    public static boolean b(Activity activity, String str, String str2, int i) {
        v.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d", str, Boolean.valueOf(r0.exists()), Long.valueOf(new File(str).length()));
        if (new File(str).exists()) {
            int i2;
            String HR = HR(str2);
            String HQ = HQ(HR);
            if (!HQ.equals(SQLiteDatabase.KeyEmpty)) {
                v.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", HQ);
                Intent dp = dp(HR, str);
                dp.setPackage(HQ);
                if (be.m(activity, dp)) {
                    v.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType");
                    activity.startActivity(dp);
                    return false;
                }
                v.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType");
                v.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType");
            }
            v.i("MicroMsg.AppChooserIntentUtil", "QQBrowser status is %s", v(activity, HR, str).name());
            if (v(activity, HR, str) == a.INSTALL_AND_SUPPORT) {
                Intent dr = dr(str, str2);
                if (be.m(activity, dr)) {
                    dr.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    activity.startActivity(dr);
                    g.iuh.h(11168, Integer.valueOf(5), Integer.valueOf(i));
                    return false;
                }
                dr.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                Intent dq = dq(HR, str);
                if (be.m(activity, dq)) {
                    activity.startActivity(dq);
                    g.iuh.h(11168, Integer.valueOf(5), Integer.valueOf(i));
                    v.e("MicroMsg.AppChooserIntentUtil", "Occur error, has bugs, status is install and support but not found support activity");
                } else {
                    v.e("MicroMsg.AppChooserIntentUtil", "Occur error, has bugs, status is install and support but not found support activity");
                    return true;
                }
            }
            if (!be.kS(str2)) {
                ak.yW();
                HR = (String) c.vf().get(com.tencent.mm.storage.t.a.USERINFO_MINIQB_SUPPORT_FILE_TYPE_STRING_SYNC, SQLiteDatabase.KeyEmpty);
                if (!be.kS(HR) && HR.contains(str2)) {
                    i2 = 1;
                    if (i2 != 0) {
                        return true;
                    }
                    b(activity, str, str2);
                    return false;
                }
            }
            i2 = 0;
            if (i2 != 0) {
                return true;
            }
            b(activity, str, str2);
            return false;
        }
        v.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
        return true;
    }

    public static void c(Activity activity, String str, String str2, int i) {
        boolean z = true;
        v.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d", str, Boolean.valueOf(r0.exists()), Long.valueOf(new File(str).length()));
        if (new File(str).exists()) {
            boolean z2;
            boolean z3;
            Parcelable dp;
            String HR = HR(str2);
            String HQ = HQ(HR);
            if (!HQ.equals(SQLiteDatabase.KeyEmpty)) {
                v.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", HQ);
                Intent dp2 = dp(HR, str);
                dp2.setPackage(HQ);
                if (be.m(activity, dp2)) {
                    v.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType");
                    activity.startActivity(dp2);
                    return;
                }
                v.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType");
            }
            v.i("MicroMsg.AppChooserIntentUtil", "QQBrowser status is %s", v(activity, HR, str).name());
            Object dp3;
            switch (v(activity, HR, str)) {
                case NOT_INSTALL:
                    z2 = false;
                    dp3 = dp(HR, str);
                    z3 = true;
                    break;
                case INSTALL_BUT_NOT_SUPPORT:
                    z2 = false;
                    dp3 = dp(HR, str);
                    z3 = false;
                    break;
                case INSTALL_BUT_NEED_UPDATE:
                    z2 = true;
                    dp3 = dp(HR, str);
                    z3 = true;
                    break;
                case INSTALL_AND_SUPPORT:
                    Intent dr = dr(str, str2);
                    if (!be.m(activity, dr)) {
                        z2 = false;
                        dp3 = dp(HR, str);
                        z3 = true;
                        break;
                    }
                    activity.startActivity(dr);
                    return;
                default:
                    z2 = false;
                    dp = dp(HR, str);
                    z3 = true;
                    break;
            }
            String HR2 = HR(str2);
            Uri fromFile = Uri.fromFile(new File(str));
            Bundle bundle = new Bundle();
            bundle.putString("targeturl", fromFile.toString());
            bundle.putString("filepath", str);
            bundle.putString("fileext", str2);
            bundle.putParcelable("targetintent", dp);
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_TITLE, activity.getResources().getString(2131231923));
            intent.putExtra("needupate", z2);
            HQ = "not_show_recommend_app";
            if (z3) {
                z = false;
            }
            intent.putExtra(HQ, z);
            intent.putExtra("mimetype", HR2);
            intent.putExtra("targetintent", dp);
            intent.putExtra("transferback", bundle);
            intent.putExtra("scene", i);
            b(activity, str, str2);
            lRL = intent;
            lRM = new WeakReference(activity);
            return;
        }
        v.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
    }

    private static void b(Activity activity, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("file_path", str);
        intent.putExtra("file_ext", str2);
        intent.setComponent(new ComponentName(d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE");
        activity.sendBroadcast(intent);
    }

    public static void Q(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("MINIQB_OPEN_RET_VAL", false);
        intent.getStringExtra("file_path");
        Object stringExtra = intent.getStringExtra("file_ext");
        v.i("MicroMsg.AppChooserIntentUtil", "miniQB retVal:%b", Boolean.valueOf(booleanExtra));
        ak.yW();
        Object obj = (String) c.vf().get(com.tencent.mm.storage.t.a.USERINFO_MINIQB_SUPPORT_FILE_TYPE_STRING_SYNC, SQLiteDatabase.KeyEmpty);
        if (!booleanExtra) {
            obj = obj.replace(stringExtra, SQLiteDatabase.KeyEmpty);
        } else if (!obj.contains(stringExtra)) {
            obj = obj.concat(stringExtra);
        }
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.USERINFO_MINIQB_SUPPORT_FILE_TYPE_STRING_SYNC, obj);
        if (!(booleanExtra || lRL == null || lRM == null || lRM.get() == null)) {
            lRL.setClass((Context) lRM.get(), AppChooserUI.class);
            ((Activity) lRM.get()).startActivityForResult(lRL, 2);
        }
        lRL = null;
    }

    public static void a(Activity activity, int i, int i2, Intent intent, boolean z, int i3) {
        if (i != 2) {
            return;
        }
        if (-1 == i2 && intent != null) {
            String stringExtra = intent.getStringExtra("selectpkg");
            Bundle bundleExtra = intent.getBundleExtra("transferback");
            Intent intent2 = (Intent) bundleExtra.getParcelable("targetintent");
            String string = bundleExtra.getString("filepath");
            String string2 = bundleExtra.getString("fileext");
            if (intent2 != null) {
                Intent dr;
                v.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI select package name %s and target intent is not null", stringExtra);
                if ("com.tencent.mtt".equals(stringExtra) && string != null) {
                    dr = dr(string, string2);
                    dr.addFlags(524288);
                    dr.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, "com.tencent.mm");
                    dr.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, 4);
                    if (be.m(activity, dr)) {
                        v.i("MicroMsg.AppChooserIntentUtil", "user has installed new version of QQbrowser");
                        activity.startActivity(dr);
                        g.iuh.h(11168, Integer.valueOf(5), Integer.valueOf(i3));
                        return;
                    }
                }
                dr = new Intent(intent2);
                dr.setPackage(stringExtra);
                dr.addFlags(524288);
                if (be.m(activity, dr)) {
                    activity.startActivity(dr);
                    return;
                }
                v.e("MicroMsg.AppChooserIntentUtil", "Always Intent is not support mimetype");
                if (z) {
                    com.tencent.mm.ui.base.g.f(activity, 2131232300, 2131232301);
                    return;
                }
                return;
            }
            v.e("MicroMsg.AppChooserIntentUtil", "AppChooserUI target intent is null in handlerResultOfAppChooserUI");
            if (z) {
                com.tencent.mm.ui.base.g.f(activity, 2131232300, 2131232301);
            }
        } else if (4098 == i2) {
            v.e("MicroMsg.AppChooserIntentUtil", "Not Found App Support media type");
            if (z) {
                com.tencent.mm.ui.base.g.f(activity, 2131232300, 2131232301);
            }
        } else if (4097 == i2) {
            v.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is no choice");
            if (z) {
                com.tencent.mm.ui.base.g.f(activity, 2131232300, 2131232301);
            }
        } else {
            v.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is not ok or data is null");
        }
    }

    private static Intent dp(String str, String str2) {
        Uri fromFile = Uri.fromFile(new File(str2));
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(fromFile, str);
        return intent;
    }

    private static Intent dq(String str, String str2) {
        Intent intent = new Intent();
        intent.setPackage("com.tencent.mtt");
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(str2)), str);
        return intent;
    }

    private static Intent dr(String str, String str2) {
        Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
        File file = new File(str);
        intent.setPackage("com.tencent.mtt");
        intent.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, "com.tencent.mm");
        intent.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, 4);
        intent.putExtra("key_reader_sdk_id", 1);
        intent.putExtra("key_reader_sdk_type", 0);
        intent.putExtra("key_reader_sdk_format", str2);
        intent.putExtra("key_reader_sdk_path", str);
        intent.setData(Uri.fromFile(file));
        return intent;
    }

    private static String HQ(String str) {
        int i = 274528;
        ak.yW();
        r vf = c.vf();
        if (str != null) {
            i = 274528 + str.hashCode();
        }
        return (String) vf.get(i, SQLiteDatabase.KeyEmpty);
    }

    private static a v(Context context, String str, String str2) {
        if (!p.dd(context)) {
            return a.NOT_INSTALL;
        }
        if (be.m(context, dq(str, str2))) {
            return a.INSTALL_AND_SUPPORT;
        }
        if (p.Gs(str)) {
            return a.INSTALL_BUT_NEED_UPDATE;
        }
        return a.INSTALL_BUT_NOT_SUPPORT;
    }

    private static String HR(String str) {
        String str2 = null;
        if (str != null && str.length() > 0) {
            str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        }
        if (str2 == null || str2.length() == 0) {
            str2 = (String) lRN.get(str);
        }
        if (str2 != null && str2.length() != 0) {
            return str2;
        }
        v.w("MicroMsg.AppChooserIntentUtil", "getMimeType fail, not a built-in mimetype, use \"*/{fileext}\" instead");
        return "*/" + str;
    }

    static {
        HashMap hashMap = new HashMap();
        lRN = hashMap;
        hashMap.put("wps", "application/wps");
        lRN.put("ett", "application/ett");
        lRN.put("log", "application/log");
        lRN.put("wpt", "application/wpt");
        lRN.put("et", "application/et");
        lRN.put("ksdps", "application/ksdps");
        lRN.put("kset", "application/kset");
        lRN.put("kswps", "application/kswps");
    }
}
