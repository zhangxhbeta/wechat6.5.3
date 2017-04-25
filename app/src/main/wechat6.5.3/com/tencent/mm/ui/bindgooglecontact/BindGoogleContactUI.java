package com.tencent.mm.ui.bindgooglecontact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelfriend.n;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public class BindGoogleContactUI extends MMActivity implements e {
    private boolean cAv = false;
    private WebView dOZ;
    private int dRm;
    private ProgressDialog eZg;
    private boolean edL = false;
    private TextView gwc;
    private boolean hVG = false;
    String odQ;
    private boolean odW = false;
    private String odX;
    String odY;
    String odZ;
    private com.tencent.mm.ad.a oea;

    class AnonymousClass4 implements OnClickListener {
        final /* synthetic */ BindGoogleContactUI oeb;
        final /* synthetic */ String oec;

        AnonymousClass4(BindGoogleContactUI bindGoogleContactUI, String str) {
            this.oeb = bindGoogleContactUI;
            this.oec = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.oeb.cd(this.oec, com.tencent.mm.ad.a.cKv);
        }
    }

    class a extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ BindGoogleContactUI oeb;
        private String oed;
        private String oee;
        private boolean oef;

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return aty();
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
            v.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPostExecute");
            Context context = this.oeb;
            boolean z = this.oef;
            String str = this.oee;
            if (!z || TextUtils.isEmpty(str)) {
                context.Sb();
                context.bDi();
            } else if (TextUtils.isEmpty(context.odQ) || TextUtils.isEmpty(str) || context.odQ.equalsIgnoreCase(str)) {
                context.odQ = str;
                context.cd(context.odQ, com.tencent.mm.ad.a.cKv);
            } else {
                context.Sb();
                g.a(context, context.getString(2131233151), SQLiteDatabase.KeyEmpty, new AnonymousClass4(context, str), new OnClickListener(context) {
                    final /* synthetic */ BindGoogleContactUI oeb;

                    {
                        this.oeb = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ak.yW();
                        c.vf().set(208905, Boolean.valueOf(true));
                        this.oeb.finish();
                    }
                });
            }
        }

        public a(BindGoogleContactUI bindGoogleContactUI, String str) {
            this.oeb = bindGoogleContactUI;
            this.oed = str;
        }

        protected final void onPreExecute() {
            super.onPreExecute();
            v.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPreExecute");
            this.oef = false;
        }

        private Void aty() {
            v.i("MicroMsg.GoogleContact.BindGoogleContactUI", "doInBackground");
            try {
                String str = this.oed;
                String str2 = SQLiteDatabase.KeyEmpty;
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + str).openConnection();
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setReadTimeout(20000);
                int responseCode = httpURLConnection.getResponseCode();
                v.e("MicroMsg.GoogleContact.BindGoogleContactUI", "responseCode:" + responseCode);
                if (200 == responseCode) {
                    StringBuffer stringBuffer = new StringBuffer();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    bufferedReader.close();
                    str2 = stringBuffer.toString();
                    v.i("MicroMsg.GoogleContact.BindGoogleContactUI", "get EmailAccount respone:%s", str2);
                }
                httpURLConnection.disconnect();
                this.oee = new JSONObject(str2).optString("email");
                if (!TextUtils.isEmpty(this.oee)) {
                    this.oef = true;
                }
            } catch (MalformedURLException e) {
                v.e("MicroMsg.GoogleContact.BindGoogleContactUI", "MalformedURLException:%s", e.getMessage());
            } catch (ProtocolException e2) {
                v.e("MicroMsg.GoogleContact.BindGoogleContactUI", "ProtocolException:%s", e2.getMessage());
            } catch (UnsupportedEncodingException e3) {
                v.e("MicroMsg.GoogleContact.BindGoogleContactUI", "UnsupportedEncodingException:%s", e3.getMessage());
            } catch (IOException e4) {
                v.e("MicroMsg.GoogleContact.BindGoogleContactUI", "IOException:%s", e4.getMessage());
            } catch (Throwable e5) {
                v.a("MicroMsg.GoogleContact.BindGoogleContactUI", e5, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
            return null;
        }
    }

    class b extends AsyncTask<Void, Void, Void> {
        private boolean bbq;
        final /* synthetic */ BindGoogleContactUI oeb;
        private String oed;
        private String oeg;
        private String oeh;

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return aty();
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
            v.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPostExecute");
            BindGoogleContactUI bindGoogleContactUI = this.oeb;
            boolean z = this.bbq;
            Object obj2 = this.oed;
            String str = this.oeh;
            if (!z || TextUtils.isEmpty(obj2)) {
                bindGoogleContactUI.Sb();
                bindGoogleContactUI.bDi();
                return;
            }
            bindGoogleContactUI.odY = obj2;
            bindGoogleContactUI.odZ = str;
            new a(bindGoogleContactUI, bindGoogleContactUI.odY).execute(new Void[0]);
        }

        public b(BindGoogleContactUI bindGoogleContactUI, String str) {
            this.oeb = bindGoogleContactUI;
            this.oeg = str;
        }

        protected final void onPreExecute() {
            super.onPreExecute();
            v.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPreExecute");
            this.oed = SQLiteDatabase.KeyEmpty;
            this.oeh = SQLiteDatabase.KeyEmpty;
            this.bbq = false;
        }

        private Void aty() {
            try {
                String str = this.oeg;
                String str2 = SQLiteDatabase.KeyEmpty;
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://accounts.google.com/o/oauth2/token").openConnection();
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setReadTimeout(20000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                List arrayList = new ArrayList();
                arrayList.add(new BasicNameValuePair("code", str));
                arrayList.add(new BasicNameValuePair("client_id", "369820936870.apps.googleusercontent.com"));
                arrayList.add(new BasicNameValuePair("client_secret", "wcFhvo-s7wNcmQ9Zjr00H06u"));
                arrayList.add(new BasicNameValuePair("redirect_uri", "urn:ietf:wg:oauth:2.0:oob"));
                arrayList.add(new BasicNameValuePair("grant_type", "authorization_code"));
                str = n.F(arrayList);
                v.i("MicroMsg.GoogleContact.BindGoogleContactUI", "QueryString:%s", str);
                httpURLConnection.setRequestProperty("Content-length", String.valueOf(str.getBytes().length));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
                bufferedWriter.write(str);
                bufferedWriter.flush();
                bufferedWriter.close();
                int responseCode = httpURLConnection.getResponseCode();
                v.e("MicroMsg.GoogleContact.BindGoogleContactUI", "responseCode:" + responseCode);
                if (200 == responseCode) {
                    StringBuffer stringBuffer = new StringBuffer();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    bufferedReader.close();
                    str2 = stringBuffer.toString();
                    v.i("MicroMsg.GoogleContact.BindGoogleContactUI", "exchange token respone:%s", str2);
                }
                httpURLConnection.disconnect();
                this.oed = new JSONObject(str2).optString("access_token");
                this.oeh = new JSONObject(str2).optString("refresh_token");
                v.i("MicroMsg.GoogleContact.BindGoogleContactUI", "response:%s", str2);
                v.i("MicroMsg.GoogleContact.BindGoogleContactUI", "mAccessToken:%s", this.oed);
                v.i("MicroMsg.GoogleContact.BindGoogleContactUI", "mRefreshToken:%s", this.oeh);
                this.bbq = true;
            } catch (MalformedURLException e) {
                v.e("MicroMsg.GoogleContact.BindGoogleContactUI", "MalformedURLException:%s" + e.getMessage());
            } catch (ProtocolException e2) {
                v.e("MicroMsg.GoogleContact.BindGoogleContactUI", "ProtocolException:%s" + e2.getMessage());
            } catch (IOException e3) {
                v.e("MicroMsg.GoogleContact.BindGoogleContactUI", "IOException:%s" + e3.getMessage());
            } catch (JSONException e4) {
                v.e("MicroMsg.GoogleContact.BindGoogleContactUI", "JSONException:%s" + e4.getMessage());
            }
            return null;
        }
    }

    static /* synthetic */ void a(BindGoogleContactUI bindGoogleContactUI, String str) {
        String substring = str.substring(30);
        v.d("MicroMsg.GoogleContact.BindGoogleContactUI", "keep_GET_TOKEN_CODE value:" + substring);
        bindGoogleContactUI.ags();
        new b(bindGoogleContactUI, substring).execute(new Void[0]);
        v.d("MicroMsg.GoogleContact.BindGoogleContactUI", "keep_GET_TOKEN_CODE End.");
    }

    protected final int getLayoutId() {
        return 2130903168;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dRm = getIntent().getIntExtra("enter_scene", 0);
        this.edL = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.hVG = n.aP(this);
        ak.yW();
        this.odQ = (String) c.vf().get(208903, null);
        NI();
        if (this.hVG) {
            startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), MMBitmapFactory.ERROR_IO_FAILED);
        } else {
            av();
        }
    }

    private void av() {
        if (this.hVG) {
            this.dOZ.setVisibility(8);
            ags();
            startActivityForResult(new Intent("com.tencent.mm.gms.ACTION_CHOOSE_ACCOUNT"), MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED);
            return;
        }
        this.gwc.setVisibility(4);
        this.dOZ.setVisibility(0);
        bDh();
    }

    protected void onResume() {
        super.onResume();
        ak.vy().a(487, (e) this);
        ak.yW();
        this.odW = ((Boolean) c.vf().get(208905, Boolean.valueOf(false))).booleanValue();
        if (this.odW) {
            bDj();
            this.odW = false;
            ak.yW();
            c.vf().set(208905, Boolean.valueOf(false));
        }
    }

    protected void onPause() {
        super.onPause();
        ak.vy().b(487, (e) this);
    }

    protected final void NI() {
        vD(2131233143);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BindGoogleContactUI oeb;

            {
                this.oeb = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oeb.finish();
                return true;
            }
        });
        this.dOZ = com.tencent.mm.ui.widget.MMWebView.a.h(this, 2131755596);
        this.gwc = (TextView) findViewById(2131755597);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.GoogleContact.BindGoogleContactUI", "requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 == -1) {
            switch (i) {
                case MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED /*1003*/:
                    v.i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d ", Integer.valueOf(intent.getIntExtra("error_code", -1)));
                    if (intent.getIntExtra("error_code", -1) == 0) {
                        this.odQ = intent.getStringExtra("account");
                        if (this.cAv) {
                            Sb();
                            return;
                        }
                        v.d("MicroMsg.GoogleContact.BindGoogleContactUI", "startAcitivtyForGetToken");
                        Intent intent2 = new Intent("com.tencent.mm.gms.ACTION_GET_TOKEN");
                        intent2.putExtra("gmail", this.odQ);
                        intent2.putExtra("scope", "oauth2:https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds");
                        startActivityForResult(intent2, MMBitmapFactory.ERROR_BEGIN_SAMPLE_FAILED);
                        return;
                    }
                    Sb();
                    bDi();
                    return;
                case MMBitmapFactory.ERROR_BEGIN_SAMPLE_FAILED /*1004*/:
                    int intExtra = intent.getIntExtra("error_code", -1);
                    String stringExtra = intent.getStringExtra("error_msg");
                    v.i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d errorMsg:%s", Integer.valueOf(intExtra), stringExtra);
                    if (intExtra == 0) {
                        this.odX = intent.getStringExtra("token");
                        wQ(com.tencent.mm.ad.a.cKv);
                        return;
                    }
                    Sb();
                    bDi();
                    return;
                case MMBitmapFactory.ERROR_IO_FAILED /*1005*/:
                    this.hVG = intent.getBooleanExtra("gpservices", false);
                    av();
                    return;
                default:
                    return;
            }
        } else if (i == MMBitmapFactory.ERROR_IO_FAILED) {
            this.hVG = intent.getBooleanExtra("gpservices", false);
            av();
        } else {
            Sb();
            bDi();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "MicroMsg.GoogleContact.BindGoogleContactUI";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = SQLiteDatabase.KeyEmpty;
        }
        objArr[2] = str;
        v.i(str2, str3, objArr);
        Sb();
        if (i == 0 && i2 == 0) {
            if (this.hVG) {
                ak.yW();
                c.vf().set(208903, this.odQ);
                ak.yW();
                c.vf().set(208901, this.odX);
            } else {
                ak.yW();
                c.vf().set(208903, this.odQ);
                ak.yW();
                c.vf().set(208902, this.odY);
                ak.yW();
                c.vf().set(208904, this.odZ);
            }
            ak.yW();
            c.vf().iB(true);
            Intent intent = new Intent(this, GoogleFriendUI.class);
            intent.putExtra("enter_scene", this.dRm);
            startActivity(intent);
            finish();
            if (this.edL) {
                com.tencent.mm.plugin.report.service.g.iuh.h(11002, Integer.valueOf(6), Integer.valueOf(5));
            }
        } else if (i2 == com.tencent.mm.ad.a.cKx) {
            g.a((Context) this, getString(2131233150), SQLiteDatabase.KeyEmpty, new OnClickListener(this) {
                final /* synthetic */ BindGoogleContactUI oeb;

                {
                    this.oeb = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.oeb.wQ(com.tencent.mm.ad.a.cKw);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ BindGoogleContactUI oeb;

                {
                    this.oeb = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.oeb.bDj();
                    this.oeb.bDh();
                }
            });
        } else {
            bDi();
        }
    }

    private void bDh() {
        ags();
        this.dOZ.getSettings().setJavaScriptEnabled(true);
        this.dOZ.setWebViewClient(new WebViewClient(this) {
            final /* synthetic */ BindGoogleContactUI oeb;

            {
                this.oeb = r1;
            }

            public final void onPageFinished(WebView webView, String str) {
                v.d("MicroMsg.GoogleContact.BindGoogleContactUI", "onPageFinished URL:" + str);
                if (!(this.oeb.dOZ == null || this.oeb.dOZ.getVisibility() == 0)) {
                    this.oeb.dOZ.setVisibility(0);
                    if (this.oeb.gwc != null) {
                        this.oeb.gwc.setVisibility(4);
                    }
                }
                this.oeb.Sb();
                if (webView != null) {
                    String title = webView.getTitle();
                    v.d("MicroMsg.GoogleContact.BindGoogleContactUI", "title:%s", title);
                    if (!TextUtils.isEmpty(title)) {
                        if (title.toLowerCase().contains("success")) {
                            if (this.oeb.dOZ != null) {
                                this.oeb.dOZ.setVisibility(4);
                            }
                            s.a(this.oeb.dOZ, "weixin://private/googlegetcode", "document.getElementById('code').value");
                        } else if (title.toLowerCase().contains("error")) {
                            v.w("MicroMsg.GoogleContact.BindGoogleContactUI", "failed." + title.substring(title.indexOf("=")));
                        }
                    }
                }
            }

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                v.d("MicroMsg.GoogleContact.BindGoogleContactUI", "shouldOverrideUrlLoading, url = %s", str);
                if (!str.toLowerCase().startsWith("weixin://private/googlegetcode")) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                BindGoogleContactUI.a(this.oeb, str);
                return true;
            }
        });
        this.dOZ.setWebChromeClient(new WebChromeClient(this) {
            final /* synthetic */ BindGoogleContactUI oeb;

            {
                this.oeb = r1;
            }

            public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                String If = s.If(consoleMessage != null ? consoleMessage.message() : null);
                if (!If.toLowerCase().startsWith("weixin://private/googlegetcode")) {
                    return super.onConsoleMessage(consoleMessage);
                }
                BindGoogleContactUI.a(this.oeb, If);
                return true;
            }
        });
        v.i("MicroMsg.GoogleContactLogic", "getRequestCodeUrl:%s", "https://accounts.google.com/o/oauth2/auth?scope=https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds&redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=code&client_id=369820936870.apps.googleusercontent.com");
        this.dOZ.loadUrl("https://accounts.google.com/o/oauth2/auth?scope=https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds&redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=code&client_id=369820936870.apps.googleusercontent.com");
    }

    private void wQ(int i) {
        this.oea = new com.tencent.mm.ad.a(com.tencent.mm.ad.a.a.cKC, this.odQ, i);
        ak.vy().a(this.oea, 0);
        v.i("MicroMsg.GoogleContact.BindGoogleContactUI", "doScene mAppToken:%s, mWebToke:%s", this.odX, this.odY);
    }

    final void cd(String str, int i) {
        this.odQ = str;
        wQ(i);
    }

    final void bDi() {
        CharSequence string;
        if (this.dOZ != null) {
            this.dOZ.setVisibility(4);
        }
        if (this.gwc != null) {
            this.gwc.setVisibility(0);
        }
        if (com.tencent.mm.sdk.platformtools.ak.isConnected(this)) {
            string = getString(2131233144);
        } else {
            string = getString(2131233152);
        }
        this.gwc.setText(string);
    }

    private void bDj() {
        try {
            CookieSyncManager.createInstance(this);
            CookieManager.getInstance().removeAllCookie();
        } catch (Exception e) {
            v.d("Google Login", "Clear cookie failed");
        }
    }

    private void ags() {
        if (this.eZg == null || !this.eZg.isShowing()) {
            getString(2131231164);
            this.eZg = g.a((Context) this, getString(2131231182), true, new OnCancelListener(this) {
                final /* synthetic */ BindGoogleContactUI oeb;

                {
                    this.oeb = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.oeb.cAv = true;
                    if (this.oeb.oea != null) {
                        ak.vy().c(this.oeb.oea);
                    }
                }
            });
        }
    }

    final void Sb() {
        if (this.eZg != null && this.eZg.isShowing()) {
            this.eZg.dismiss();
        }
    }
}
