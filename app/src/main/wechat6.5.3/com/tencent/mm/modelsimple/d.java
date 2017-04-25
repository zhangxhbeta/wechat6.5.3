package com.tencent.mm.modelsimple;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.Settings;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.regex.Pattern;

public final class d {

    public interface a {
        void l(Bundle bundle);
    }

    public static int a(Context context, a aVar) {
        if (context == null) {
            v.e("MicroMsg.MMAccountManager", "context is null");
            return 0;
        }
        String IQ = IQ();
        if (be.kS(IQ)) {
            v.e("MicroMsg.MMAccountManager", "account username is null or nil");
            ak.yW();
            IQ = (String) c.vf().get(6, SQLiteDatabase.KeyEmpty);
            if (be.kS(IQ)) {
                return 0;
            }
        }
        if (B(context, IQ)) {
            return 3;
        }
        if (!com.tencent.mm.pluginsdk.i.a.aP(context, "android.permission.READ_CONTACTS")) {
            return 2;
        }
        try {
            AccountManager accountManager = AccountManager.get(context);
            Account account = new Account(IQ, "com.tencent.mm.account");
            if (accountManager.addAccountExplicitly(account, SQLiteDatabase.KeyEmpty, null)) {
                ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
                Bundle bundle = new Bundle();
                bundle.putString("authAccount", IQ);
                bundle.putString("accountType", "com.tencent.mm.account");
                if (aVar != null) {
                    aVar.l(bundle);
                }
                return 1;
            }
        } catch (Throwable e) {
            v.a("MicroMsg.MMAccountManager", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.MMAccountManager", "exception in addAccountNoNeedBindMobile() " + e.getMessage());
        }
        if (aVar != null) {
            aVar.l(null);
        }
        return 2;
    }

    public static int a(Context context, String str, a aVar) {
        if (context == null) {
            v.e("MicroMsg.MMAccountManager", "activity is null");
            return 0;
        } else if (be.kS(str)) {
            v.e("MicroMsg.MMAccountManager", "account username is null or nil");
            return 0;
        } else {
            String IQ = IQ();
            if (!be.kS(IQ)) {
                str = IQ;
            }
            try {
                AccountManager accountManager = AccountManager.get(context);
                Account account = new Account(str, "com.tencent.mm.account");
                if (!com.tencent.mm.pluginsdk.i.a.aP(context, "android.permission.READ_CONTACTS")) {
                    return 2;
                }
                if (B(context, str)) {
                    ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
                    return 3;
                }
                z(context, null);
                if (accountManager.addAccountExplicitly(account, SQLiteDatabase.KeyEmpty, null)) {
                    ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
                    Bundle bundle = new Bundle();
                    bundle.putString("authAccount", str);
                    bundle.putString("accountType", "com.tencent.mm.account");
                    if (aVar != null) {
                        aVar.l(bundle);
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("account_name", str);
                    contentValues.put("account_type", "com.tencent.mm.account");
                    contentValues.put("should_sync", Integer.valueOf(1));
                    contentValues.put("ungrouped_visible", Integer.valueOf(1));
                    context.getContentResolver().insert(Settings.CONTENT_URI, contentValues);
                    return 1;
                }
                if (aVar != null) {
                    aVar.l(null);
                }
                return 2;
            } catch (Throwable e) {
                v.a("MicroMsg.MMAccountManager", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.e("MicroMsg.MMAccountManager", "exception in addAccount() " + e.getMessage());
            }
        }
    }

    public static void aX(Context context) {
        com.tencent.mm.ay.c.brh();
        if (f.aQc == 0) {
            v.d("MicroMsg.MMAccountManager", "do not auto add account");
        } else if (f.aQc == 1) {
            if (m.EY() == com.tencent.mm.modelfriend.m.a.SUCC) {
                v.d("MicroMsg.MMAccountManager", "auto add account result: " + a(context, m.Fa(), null));
                return;
            }
            v.i("MicroMsg.MMAccountManager", "the user not bind mobile or not aggreed to upload addressbook");
        } else if (f.aQc == 2) {
            v.d("MicroMsg.MMAccountManager", "auto add account result: " + a(context, null));
        }
    }

    public static boolean z(Context context, String str) {
        boolean kS = be.kS(str);
        v.v("MicroMsg.MMAccountManager", "remove account : " + str);
        if (context == null) {
            v.e("MicroMsg.MMAccountManager", "null context");
            return false;
        }
        try {
            Account[] bd = bd(context);
            if (bd == null || bd.length == 0) {
                v.d("MicroMsg.MMAccountManager", "get account info is null or nil");
                return true;
            }
            AccountManager accountManager = AccountManager.get(context);
            for (Account account : bd) {
                if (kS) {
                    accountManager.removeAccount(account, null, null);
                } else if (account.name.equals(str)) {
                    accountManager.removeAccount(account, null, null);
                    v.i("MicroMsg.MMAccountManager", "remove account success: " + str);
                }
            }
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.MMAccountManager", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.MMAccountManager", "exception in removeAccount() " + e.getMessage());
            return false;
        }
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.INTENTCHECK})
    public static boolean aY(Context context) {
        boolean z = false;
        if (context != null) {
            Intent intent = new Intent("com.tencent.mm.login.ACTION_LOGOUT");
            intent.putExtra("accountName", IQ());
            intent.putExtra("accountType", "com.tencent.mm.account");
            z = z(context, IQ());
            if (z) {
                context.sendBroadcast(intent);
            }
        }
        return z;
    }

    private static String IQ() {
        if (ak.uz()) {
            String str = SQLiteDatabase.KeyEmpty;
            ak.yW();
            String str2 = (String) c.vf().get(4, null);
            if (be.kS(str2)) {
                str2 = k.xG();
                if (be.kS(str2)) {
                    str2 = k.xF();
                    if (be.kS(str2) || u.LL(str2)) {
                        str2 = str;
                    }
                }
            }
            return kg(str2);
        }
        v.e("MicroMsg.MMAccountManager", "getCurrentAccountName MMCore.acc Not Ready");
        return SQLiteDatabase.KeyEmpty;
    }

    public static void aZ(Context context) {
        if (ba(context)) {
            e.c(new b(context, bc(context)), "MMAccountManager_updateAllContact").start();
            return;
        }
        z(context, null);
        v.d("MicroMsg.MMAccountManager", "no account added or not current account");
    }

    public static void A(Context context, String str) {
        if (ba(context)) {
            e.c(new b(context, bc(context), str), "MMAccountManager_deleteSpecifiedContact").start();
            return;
        }
        z(context, null);
        v.d("MicroMsg.MMAccountManager", "no account added or not current account");
    }

    public static boolean ba(Context context) {
        Account bc = bc(context);
        if (bc != null && bc.name.equals(IQ())) {
            return true;
        }
        return false;
    }

    public static boolean bb(Context context) {
        if (!ba(context)) {
            v.e("MicroMsg.MMAccountManager", "no account added or not current account");
            return false;
        } else if (!com.tencent.mm.pluginsdk.i.a.aP(context, "android.permission.READ_CONTACTS")) {
            return false;
        } else {
            Account bc = bc(context);
            if (bc != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("expedited", true);
                bundle.putBoolean("do_not_retry", true);
                ContentResolver.requestSync(bc, "com.android.contacts", bundle);
                return true;
            }
            v.e("MicroMsg.MMAccountManager", "no account added");
            return false;
        }
    }

    public static Account bc(Context context) {
        String IQ = IQ();
        if (be.kS(IQ)) {
            ak.yW();
            IQ = (String) c.vf().get(6, SQLiteDatabase.KeyEmpty);
        }
        if (!be.kS(IQ)) {
            Account[] bd = bd(context);
            if (bd == null) {
                return null;
            }
            for (Account account : bd) {
                if (account.name.equals(IQ)) {
                    return account;
                }
            }
        }
        return null;
    }

    private static Account[] bd(Context context) {
        try {
            return AccountManager.get(context).getAccountsByType("com.tencent.mm.account");
        } catch (Throwable e) {
            v.e("MicroMsg.MMAccountManager", "get all accounts failed");
            v.a("MicroMsg.MMAccountManager", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return null;
        }
    }

    private static boolean B(Context context, String str) {
        Account[] bd = bd(context);
        if (bd == null || bd.length == 0) {
            return false;
        }
        for (Account account : bd) {
            if (account.name.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private static Account[] C(Context context, String str) {
        Account[] accountArr = null;
        try {
            accountArr = AccountManager.get(context).getAccountsByType(str);
        } catch (Throwable e) {
            v.e("MicroMsg.MMAccountManager", "get all accounts failed");
            v.a("MicroMsg.MMAccountManager", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        return accountArr;
    }

    public static String be(Context context) {
        Account[] C = C(context, "com.google");
        String str = null;
        if (C != null && C.length > 0) {
            for (Account account : C) {
                str = account.name;
                if (!be.kS(str) && be.Kx(str)) {
                    break;
                }
            }
        }
        return str;
    }

    private static String kg(String str) {
        try {
            str = Pattern.compile("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#¥￥%……&*（）——+|{}【】‘；：”“’。，、？]").matcher(str).replaceAll("_").trim();
        } catch (Throwable e) {
            v.e("MicroMsg.MMAccountManager", "stringFilter failed, %s, %s", str, e.getMessage());
            v.a("MicroMsg.MMAccountManager", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        return str;
    }
}
