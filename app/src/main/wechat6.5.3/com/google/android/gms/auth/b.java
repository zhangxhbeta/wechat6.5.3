package com.google.android.gms.auth;

import android.accounts.Account;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.c.c.a;
import com.google.android.gms.c.i;
import com.google.android.gms.common.c;
import com.google.android.gms.common.d;
import com.google.android.gms.common.e;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.w;
import java.io.IOException;

public final class b {
    public static final String KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
    public static final String KEY_CALLER_UID = "callerUid";
    private static final ComponentName ajl = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
    private static final ComponentName ajm = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");

    static {
        int i = VERSION.SDK_INT;
        i = VERSION.SDK_INT;
    }

    private static Bundle a(Context context, Account account, String str, Bundle bundle) {
        Context applicationContext = context.getApplicationContext();
        w.W("Calling this from your main thread can lead to deadlock");
        try {
            e.x(applicationContext);
            Bundle bundle2 = new Bundle(bundle);
            String str2 = context.getApplicationInfo().packageName;
            bundle2.putString("clientPackageName", str2);
            if (TextUtils.isEmpty(bundle2.getString(KEY_ANDROID_PACKAGE_NAME))) {
                bundle2.putString(KEY_ANDROID_PACKAGE_NAME, str2);
            }
            ServiceConnection hVar = new h();
            m A = m.A(applicationContext);
            if (A.a(ajl, hVar, "GoogleAuthUtil")) {
                try {
                    Bundle a = a.m(hVar.kt()).a(account, str, bundle2);
                    if (a == null) {
                        throw new a("ServiceUnavailable");
                    } else if (TextUtils.isEmpty(a.getString("authtoken"))) {
                        String string = a.getString("Error");
                        Intent intent = (Intent) a.getParcelable("userRecoveryIntent");
                        Object obj = ("BadAuthentication".equals(string) || "CaptchaRequired".equals(string) || "DeviceManagementRequiredOrSyncDisabled".equals(string) || "NeedPermission".equals(string) || "NeedsBrowser".equals(string) || "UserCancel".equals(string) || "AppDownloadRequired".equals(string) || i.DM_SYNC_DISABLED.ayc.equals(string) || i.DM_ADMIN_BLOCKED.ayc.equals(string) || i.DM_ADMIN_PENDING_APPROVAL.ayc.equals(string) || i.DM_STALE_SYNC_REQUIRED.ayc.equals(string) || i.DM_DEACTIVATED.ayc.equals(string) || i.DM_REQUIRED.ayc.equals(string) || i.THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED.ayc.equals(string)) ? 1 : null;
                        if (obj != null) {
                            throw new d(string, intent);
                        }
                        Object obj2 = ("NetworkError".equals(string) || "ServiceUnavailable".equals(string) || "Timeout".equals(string)) ? 1 : null;
                        if (obj2 != null) {
                            throw new IOException(string);
                        }
                        throw new a(string);
                    } else {
                        A.b(ajl, hVar, "GoogleAuthUtil");
                        return a;
                    }
                } catch (RemoteException e) {
                    throw new IOException("remote exception");
                } catch (InterruptedException e2) {
                    throw new a("Interrupted");
                } catch (Throwable th) {
                    A.b(ajl, hVar, "GoogleAuthUtil");
                }
            } else {
                throw new IOException("Could not bind to service with the given context.");
            }
        } catch (d e3) {
            throw new c(e3.ajn, e3.getMessage(), new Intent(e3.OH));
        } catch (c e4) {
            throw new a(e4.getMessage());
        }
    }

    @Deprecated
    public static String c(Context context, String str, String str2) {
        return a(context, new Account(str, "com.google"), str2, new Bundle()).getString("authtoken");
    }
}
