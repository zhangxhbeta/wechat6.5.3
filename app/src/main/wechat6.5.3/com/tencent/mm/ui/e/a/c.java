package com.tencent.mm.ui.e.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;

public final class c {
    protected static String oNi = "https://m.facebook.com/dialog/";
    protected static String oNj = "https://graph.facebook.com/";
    protected static String oNk = "https://api.facebook.com/restserver.php";
    private String dzg;
    private long oNl = 0;
    public long oNm = 0;
    private Activity oNn;
    private String[] oNo;
    private int oNp;
    private a oNq;
    private final long oNr = 86400000;
    public String oed = null;

    public interface a {
        void a(b bVar);

        void a(d dVar);

        void k(Bundle bundle);

        void onCancel();
    }

    public c(String str) {
        this.dzg = str;
    }

    public final void a(Activity activity, String[] strArr, a aVar) {
        this.oNq = aVar;
        a(activity, strArr);
    }

    private void a(Activity activity, String[] strArr) {
        Bundle bundle = new Bundle();
        if (strArr.length > 0) {
            bundle.putString("scope", TextUtils.join(",", strArr));
        }
        CookieSyncManager.createInstance(activity);
        a(activity, "oauth", bundle, new a(this) {
            final /* synthetic */ c oNs;

            {
                this.oNs = r1;
            }

            public final void k(Bundle bundle) {
                CookieSyncManager.getInstance().sync();
                this.oNs.Po(bundle.getString("access_token"));
                this.oNs.Pp(bundle.getString("expires_in"));
                if (this.oNs.bID()) {
                    v.d("Facebook-authorize", "Login Success! access_token=" + this.oNs.oed + " expires=" + this.oNs.oNm);
                    this.oNs.oNq.k(bundle);
                    return;
                }
                this.oNs.oNq.a(new d("Failed to receive access token."));
            }

            public final void a(b bVar) {
                v.d("Facebook-authorize", "Login failed: " + bVar);
                this.oNs.oNq.a(bVar);
            }

            public final void a(d dVar) {
                v.d("Facebook-authorize", "Login failed: " + dVar);
                this.oNs.oNq.a(dVar);
            }

            public final void onCancel() {
                v.d("Facebook-authorize", "Login canceled");
                this.oNs.oNq.onCancel();
            }
        });
    }

    public final void d(int i, int i2, Intent intent) {
        if (i != this.oNp) {
            return;
        }
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra("error");
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("error_type");
            }
            if (stringExtra == null) {
                Po(intent.getStringExtra("access_token"));
                Pp(intent.getStringExtra("expires_in"));
                if (bID()) {
                    v.d("Facebook-authorize", "Login Success! access_token=" + this.oed + " expires=" + this.oNm);
                    this.oNq.k(intent.getExtras());
                    return;
                }
                this.oNq.a(new d("Failed to receive access token."));
            } else if (stringExtra.equals("service_disabled") || stringExtra.equals("AndroidAuthKillSwitchException")) {
                v.d("Facebook-authorize", "Hosted auth currently disabled. Retrying dialog auth...");
                a(this.oNn, this.oNo);
            } else if (stringExtra.equals("access_denied") || stringExtra.equals("OAuthAccessDeniedException")) {
                v.d("Facebook-authorize", "Login canceled by user.");
                this.oNq.onCancel();
            } else {
                String stringExtra2 = intent.getStringExtra("error_description");
                if (stringExtra2 != null) {
                    stringExtra = stringExtra + ":" + stringExtra2;
                }
                v.d("Facebook-authorize", "Login failed: " + stringExtra);
                this.oNq.a(new d(stringExtra));
            }
        } else if (i2 != 0) {
        } else {
            if (intent != null) {
                v.d("Facebook-authorize", "Login failed: " + intent.getStringExtra("error"));
                this.oNq.a(new b(intent.getStringExtra("error"), intent.getIntExtra("error_code", -1), intent.getStringExtra("failing_url")));
                return;
            }
            v.d("Facebook-authorize", "Login canceled by user.");
            this.oNq.onCancel();
        }
    }

    public final String eI(Context context) {
        CookieSyncManager.createInstance(context);
        CookieManager.getInstance().removeAllCookie();
        Po(null);
        this.oNm = 0;
        return null;
    }

    public final String a(String str, Bundle bundle, String str2) {
        bundle.putString("format", "json");
        if (bID()) {
            bundle.putString("access_token", this.oed);
        }
        return e.d(str != null ? oNj + str : oNk, str2, bundle);
    }

    public final void a(Context context, String str, Bundle bundle, a aVar) {
        String str2 = oNi + str;
        bundle.putString("display", "touch");
        bundle.putString("redirect_uri", "fbconnect://success");
        if (str.equals("oauth")) {
            bundle.putString("type", "user_agent");
            bundle.putString("client_id", this.dzg);
        } else {
            bundle.putString("app_id", this.dzg);
        }
        if (bID()) {
            bundle.putString("access_token", this.oed);
        }
        str2 = str2 + "?" + e.W(bundle);
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            e.B(context, "Error", "Application requires permission to access the Internet");
        } else {
            new f(context, str2, aVar).show();
        }
    }

    public final boolean bID() {
        return this.oed != null && (this.oNm == 0 || System.currentTimeMillis() < this.oNm);
    }

    public final void Po(String str) {
        this.oed = str;
        this.oNl = System.currentTimeMillis();
    }

    public final void Pp(String str) {
        if (str != null) {
            this.oNm = str.equals("0") ? 0 : System.currentTimeMillis() + (Long.parseLong(str) * 1000);
        }
    }
}
