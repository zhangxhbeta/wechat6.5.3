package com.tencent.mm.ui.bindgooglecontact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.n;
import com.tencent.mm.modelfriend.o;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.protocal.c.agi;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.d;
import com.tencent.mm.ui.friend.InviteFriendUI;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleFriendUI extends MMActivity implements OnItemClickListener, com.tencent.mm.u.d.a, a, e {
    private boolean QK = false;
    private HashMap<String, o> cKM = new HashMap();
    private String cKN;
    private int dRm;
    private ProgressDialog eZg;
    private String gQQ;
    private TextView gwc;
    private boolean hVG = false;
    private String odQ;
    private String oeh;
    private ListView oep;
    private a oeq;
    private com.tencent.mm.ad.c oer;
    private ArrayList<o> oes = new ArrayList();

    public enum a {
        SUCCESS,
        NO_CONTACT,
        ACCESS_DEDY,
        OTHER
    }

    class b extends AsyncTask<Void, Void, Void> {
        private String cKN;
        private Context mContext;
        private a oeB;
        final /* synthetic */ GoogleFriendUI oet;

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return aty();
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
            v.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "onPostExecute");
            if (this.oeB != a.SUCCESS) {
                GoogleFriendUI.a(this.oet, this.oeB, null);
            } else if (this.oet.oes == null || this.oet.oes.size() <= 0) {
                GoogleFriendUI.a(this.oet, a.NO_CONTACT, null);
            } else {
                GoogleFriendUI.a(this.oet, a.SUCCESS, this.oet.oes);
            }
        }

        private b(GoogleFriendUI googleFriendUI, Context context, String str) {
            this.oet = googleFriendUI;
            this.oeB = a.OTHER;
            this.mContext = context;
            this.cKN = str;
        }

        protected final void onPreExecute() {
            super.onPreExecute();
            v.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "onPreExecute");
            this.oet.oes.clear();
            this.oet.cKM.clear();
        }

        private Void aty() {
            v.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "doInBackground");
            int i = 0;
            int i2 = 1;
            while (true) {
                try {
                    String l;
                    Object obj;
                    v.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "startInde:%d, totalCount:%d", Integer.valueOf(i2), Integer.valueOf(i));
                    v.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "requestURL:%s", new URL("https://www.google.com/m8/feeds/contacts/default/property-email?alt=" + "json" + "&max-results=100&start-index=" + i2 + "&access_token=" + this.cKN).toString());
                    HttpURLConnection httpURLConnection = (HttpURLConnection) r6.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(20000);
                    int responseCode = httpURLConnection.getResponseCode();
                    v.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "responseCode:%d", Integer.valueOf(responseCode));
                    if (responseCode == 200) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        l = l(inputStream);
                        inputStream.close();
                    } else {
                        if (responseCode == 401) {
                            v.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Server OAuth Error,Please Try Again.");
                        } else {
                            v.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Unknow Error.");
                        }
                        httpURLConnection.disconnect();
                        l = null;
                    }
                    responseCode = new JSONObject(l).getJSONObject("feed").getJSONObject("openSearch$totalResults").getInt("$t");
                    if (responseCode > 0) {
                        OA(l);
                    }
                    if (responseCode - i2 > 100) {
                        i2 += 100;
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null || this.oet.QK) {
                        this.oeB = a.SUCCESS;
                    } else {
                        i = responseCode;
                    }
                } catch (IOException e) {
                    this.oeB = a.ACCESS_DEDY;
                    v.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "IOException" + e.getMessage());
                } catch (JSONException e2) {
                    this.oeB = a.OTHER;
                    v.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "JSONException" + e2.getMessage());
                }
            }
            this.oeB = a.SUCCESS;
            return null;
        }

        private static String l(InputStream inputStream) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[20480];
            while (true) {
                int read = inputStream.read(bArr, 0, 20480);
                if (read == -1) {
                    return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        }

        private void OA(String str) {
            JSONArray jSONArray = new JSONObject(str).getJSONObject("feed").getJSONArray("entry");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string;
                    int lastIndexOf;
                    int i2;
                    String string2;
                    CharSequence substring;
                    int i3;
                    o oVar;
                    String str2 = SQLiteDatabase.KeyEmpty;
                    String str3 = SQLiteDatabase.KeyEmpty;
                    String str4 = SQLiteDatabase.KeyEmpty;
                    JSONObject optJSONObject = jSONArray.getJSONObject(i).optJSONObject("id");
                    JSONObject optJSONObject2 = jSONArray.getJSONObject(i).optJSONObject(SlookSmartClipMetaTag.TAG_TYPE_TITLE);
                    JSONArray optJSONArray = jSONArray.getJSONObject(i).optJSONArray("gd$email");
                    JSONArray optJSONArray2 = jSONArray.getJSONObject(i).optJSONArray("link");
                    if (optJSONObject != null) {
                        string = optJSONObject.getString("$t");
                        lastIndexOf = string.lastIndexOf("/");
                        if (lastIndexOf > 0) {
                            string = string.substring(lastIndexOf + 1);
                            if (optJSONObject2 == null) {
                                str2 = optJSONObject2.getString("$t");
                            } else {
                                str2 = str3;
                            }
                            if (optJSONArray2 != null) {
                                for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                    string2 = optJSONArray2.getJSONObject(i2).getString("rel");
                                    lastIndexOf = string2.lastIndexOf("#");
                                    if (lastIndexOf > 0) {
                                        substring = string2.substring(lastIndexOf + 1);
                                        if (!TextUtils.isEmpty(substring) && "photo".equals(substring)) {
                                            str4 = optJSONArray2.getJSONObject(i2).getString("href");
                                        }
                                    }
                                }
                            }
                            str3 = str4;
                            if (optJSONArray != null) {
                                for (i3 = 0; i3 < optJSONArray.length(); i3++) {
                                    string2 = optJSONArray.getJSONObject(i3).getString("address");
                                    if (!(TextUtils.isEmpty(string2) || !be.Kx(string2) || string2.equals(this.oet.odQ))) {
                                        oVar = new o();
                                        oVar.field_googleid = string;
                                        oVar.field_googleitemid = string + string2;
                                        oVar.field_googlename = str2;
                                        oVar.field_googlephotourl = str3;
                                        oVar.field_googlegmail = string2;
                                        if (!this.oet.cKM.containsKey(string2)) {
                                            this.oet.oes.add(oVar);
                                            this.oet.cKM.put(string2, oVar);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    string = str2;
                    if (optJSONObject2 == null) {
                        str2 = str3;
                    } else {
                        str2 = optJSONObject2.getString("$t");
                    }
                    if (optJSONArray2 != null) {
                        for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            string2 = optJSONArray2.getJSONObject(i2).getString("rel");
                            lastIndexOf = string2.lastIndexOf("#");
                            if (lastIndexOf > 0) {
                                substring = string2.substring(lastIndexOf + 1);
                                str4 = optJSONArray2.getJSONObject(i2).getString("href");
                            }
                        }
                    }
                    str3 = str4;
                    if (optJSONArray != null) {
                        for (i3 = 0; i3 < optJSONArray.length(); i3++) {
                            string2 = optJSONArray.getJSONObject(i3).getString("address");
                            oVar = new o();
                            oVar.field_googleid = string;
                            oVar.field_googleitemid = string + string2;
                            oVar.field_googlename = str2;
                            oVar.field_googlephotourl = str3;
                            oVar.field_googlegmail = string2;
                            if (!this.oet.cKM.containsKey(string2)) {
                                this.oet.oes.add(oVar);
                                this.oet.cKM.put(string2, oVar);
                            }
                        }
                    }
                }
            }
        }
    }

    class c extends AsyncTask<Void, Void, Void> {
        private String oed;
        private boolean oef;
        private String oeh;
        final /* synthetic */ GoogleFriendUI oet;

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return aty();
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
            v.i("MicroMsg.GoogleContact.GoogleFriendUI", "onPostExecute");
            GoogleFriendUI.a(this.oet, this.oef, this.oed);
        }

        public c(GoogleFriendUI googleFriendUI, String str) {
            this.oet = googleFriendUI;
            this.oeh = str;
        }

        protected final void onPreExecute() {
            super.onPreExecute();
            v.i("MicroMsg.GoogleContact.GoogleFriendUI", "onPreExecute");
            this.oef = false;
        }

        private Void aty() {
            v.i("MicroMsg.GoogleContact.GoogleFriendUI", "doInBackground");
            try {
                String str = SQLiteDatabase.KeyEmpty;
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://accounts.google.com/o/oauth2/token").openConnection();
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setReadTimeout(20000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                List arrayList = new ArrayList();
                arrayList.add(new BasicNameValuePair("refresh_token", this.oeh));
                arrayList.add(new BasicNameValuePair("client_id", "369820936870.apps.googleusercontent.com"));
                arrayList.add(new BasicNameValuePair("client_secret", "wcFhvo-s7wNcmQ9Zjr00H06u"));
                arrayList.add(new BasicNameValuePair("grant_type", "refresh_token"));
                String F = n.F(arrayList);
                v.i("MicroMsg.GoogleContact.GoogleFriendUI", "QueryString:%s" + F);
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
                bufferedWriter.write(F);
                bufferedWriter.flush();
                bufferedWriter.close();
                int responseCode = httpURLConnection.getResponseCode();
                v.e("MicroMsg.GoogleContact.GoogleFriendUI", "responseCode:" + responseCode);
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
                    str = stringBuffer.toString();
                    v.i("MicroMsg.GoogleContact.GoogleFriendUI", "exchange token respone:%s" + str);
                }
                httpURLConnection.disconnect();
                v.i("MicroMsg.GoogleContact.GoogleFriendUI", "refresh response:%s", str);
                this.oed = new JSONObject(str).optString("access_token");
                this.oef = true;
            } catch (ProtocolException e) {
                v.e("MicroMsg.GoogleContact.GoogleFriendUI", "ProtocolException:%s", e.getMessage());
            } catch (MalformedURLException e2) {
                v.e("MicroMsg.GoogleContact.GoogleFriendUI", "MalformedURLException:%s", e2.getMessage());
            } catch (IOException e3) {
                v.e("MicroMsg.GoogleContact.GoogleFriendUI", "IOException:%s", e3.getMessage());
            } catch (JSONException e4) {
                v.e("MicroMsg.GoogleContact.GoogleFriendUI", "JSONException:%s", e4.getMessage());
            }
            return null;
        }
    }

    static /* synthetic */ void a(GoogleFriendUI googleFriendUI, a aVar, ArrayList arrayList) {
        v.i("MicroMsg.GoogleContact.GoogleFriendUI", "[handleGetGoogleContactListTaskReturn] success:%s", aVar);
        if (aVar == a.SUCCESS && !googleFriendUI.QK) {
            googleFriendUI.oer = new com.tencent.mm.ad.c(arrayList, googleFriendUI.dRm, googleFriendUI.cKM, googleFriendUI.cKN);
            ak.vy().a(googleFriendUI.oer, 0);
        } else if (aVar == a.NO_CONTACT) {
            googleFriendUI.Sb();
            v.i("MicroMsg.GoogleContact.GoogleFriendUI", "Google Contact is Empty.");
            googleFriendUI.jA(true);
        } else if (aVar == a.ACCESS_DEDY) {
            googleFriendUI.Sb();
            if (com.tencent.mm.sdk.platformtools.ak.isConnected(googleFriendUI)) {
                v.i("MicroMsg.GoogleContact.GoogleFriendUI", "[handleGetGoogleContactListTaskReturn] start bindGoogleContactUI No Login or network unavaile.");
                googleFriendUI.startActivity(new Intent(googleFriendUI, BindGoogleContactUI.class));
                googleFriendUI.finish();
                return;
            }
            googleFriendUI.jA(false);
        } else if (!googleFriendUI.QK) {
            v.i("MicroMsg.GoogleContact.GoogleFriendUI", "[handleGetGoogleContactListTaskReturn] start bindGoogleContactUI unknow error");
            googleFriendUI.Sb();
            googleFriendUI.startActivity(new Intent(googleFriendUI, BindGoogleContactUI.class));
            googleFriendUI.finish();
        }
    }

    static /* synthetic */ void a(GoogleFriendUI googleFriendUI, boolean z, String str) {
        if (!z || TextUtils.isEmpty(str)) {
            googleFriendUI.Sb();
            googleFriendUI.jA(false);
            return;
        }
        googleFriendUI.cKN = str;
        ak.yW();
        com.tencent.mm.model.c.vf().set(208902, str);
        googleFriendUI.bDk();
    }

    protected final int getLayoutId() {
        return 2130903770;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.yW();
        this.odQ = (String) com.tencent.mm.model.c.vf().get(208903, null);
        if (TextUtils.isEmpty(this.odQ)) {
            finish();
        }
        this.dRm = getIntent().getIntExtra("enter_scene", 0);
        this.oeq = new a(this, this.odQ);
        this.oeq.oei = this;
        NI();
        this.hVG = n.aP(this);
        if (this.hVG) {
            v.d("MicroMsg.GoogleContact.GoogleFriendUI", "startActivityCheckGooglePlayServices");
            startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 2005);
        } else {
            aEL();
        }
        ah.FT().clear();
    }

    protected void onResume() {
        super.onResume();
        ak.vy().a(488, (e) this);
        ak.vy().a(489, (e) this);
        com.tencent.mm.u.n.AX().d(this);
        if (this.oeq != null) {
            this.oeq.Ol();
        }
    }

    protected void onStop() {
        super.onStop();
        ak.vy().b(488, (e) this);
        ak.vy().b(489, (e) this);
        com.tencent.mm.u.n.AX().e(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        ah.FT().clear();
    }

    protected final void NI() {
        vD(2131233146);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GoogleFriendUI oet;

            {
                this.oet = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oet.finish();
                return true;
            }
        });
        this.gwc = (TextView) findViewById(2131755597);
        this.oep = (ListView) findViewById(2131757399);
        this.oep.setAdapter(this.oeq);
        this.oep.setOnItemClickListener(this);
        p pVar = new p(true, true);
        pVar.oUs = new com.tencent.mm.ui.tools.p.b(this) {
            final /* synthetic */ GoogleFriendUI oet;

            {
                this.oet = r1;
            }

            public final boolean mk(String str) {
                return false;
            }

            public final void ml(String str) {
                this.oet.gQQ = be.lZ(str);
                if (this.oet.oeq != null) {
                    this.oet.oeq.uU(this.oet.gQQ);
                }
            }

            public final void Of() {
            }

            public final void Og() {
            }

            public final void Oh() {
            }
        };
        a(pVar);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        v.d("MicroMsg.GoogleContact.GoogleFriendUI", "onItemClick position:%d,", Integer.valueOf(i));
        if (this.oeq != null) {
            o oVar = (o) this.oeq.getItem(i - this.oep.getHeaderViewsCount());
            if (oVar != null) {
                String str = oVar.field_username;
                v.d("MicroMsg.GoogleContact.GoogleFriendUI", "jumpToProfile email:%s, username:%s", oVar.field_googlegmail, str);
                ak.yW();
                ab LX = com.tencent.mm.model.c.wH().LX(str);
                Intent intent;
                if ((LX == null || !com.tencent.mm.i.a.ei(LX.field_type)) && TextUtils.isEmpty(oVar.field_nickname)) {
                    intent = new Intent(this, InviteFriendUI.class);
                    intent.putExtra("friend_type", 2);
                    intent.putExtra("friend_user_name", str);
                    intent.putExtra("friend_num", oVar.field_googlegmail);
                    intent.putExtra("friend_nick", oVar.field_googlename);
                    intent.putExtra("friend_weixin_nick", oVar.field_nickname);
                    intent.putExtra("friend_googleID", oVar.field_googleid);
                    intent.putExtra("friend_googleItemID", oVar.field_googleitemid);
                    intent.putExtra("friend_scene", 58);
                    intent.putExtra("Contact_Scene", 58);
                    startActivity(intent);
                    return;
                }
                intent = new Intent();
                intent.putExtra("Contact_User", str);
                intent.putExtra("Contact_Nick", oVar.field_nickname);
                intent.putExtra("Contact_ShowFMessageList", true);
                intent.putExtra("verify_gmail", oVar.field_googlegmail);
                intent.putExtra("profileName", oVar.field_googlename);
                intent.putExtra("Contact_Source_FMessage", 58);
                intent.putExtra("Contact_Scene", 58);
                if (str != null && str.length() > 0) {
                    com.tencent.mm.plugin.a.a.drp.d(intent, this.nDR.nEl);
                }
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.GoogleContact.GoogleFriendUI", "requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i != 2005) {
            return;
        }
        if (i2 == -1) {
            this.hVG = intent.getBooleanExtra("gpservices", false);
            aEL();
            return;
        }
        this.hVG = intent.getBooleanExtra("gpservices", false);
        finish();
    }

    private void aEL() {
        v.d("MicroMsg.GoogleContact.GoogleFriendUI", "updateToken");
        if (this.hVG) {
            ak.yW();
            this.cKN = (String) com.tencent.mm.model.c.vf().get(208901, null);
        } else {
            ak.yW();
            this.cKN = (String) com.tencent.mm.model.c.vf().get(208902, null);
            ak.yW();
            this.oeh = (String) com.tencent.mm.model.c.vf().get(208904, null);
        }
        if (TextUtils.isEmpty(this.cKN) || (!this.hVG && TextUtils.isEmpty(this.oeh))) {
            q(BindGoogleContactUI.class);
            finish();
        } else if (this.hVG) {
            bDk();
        } else {
            ags();
            new c(this, this.oeh).execute(new Void[0]);
        }
    }

    public final void wR(int i) {
        if (this.oeq != null) {
            o oVar = (o) this.oeq.getItem(i);
            if (oVar != null) {
                switch (oVar.field_status) {
                    case 0:
                        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this, new com.tencent.mm.pluginsdk.ui.applet.a.a(this) {
                            final /* synthetic */ GoogleFriendUI oet;

                            {
                                this.oet = r1;
                            }

                            public final void a(boolean z, boolean z2, String str, String str2) {
                                v.d("MicroMsg.GoogleContact.GoogleFriendUI", "MicroMsg.AddContact ok:%b hasSentVerify:%b", Boolean.valueOf(z), Boolean.valueOf(z2));
                                if (z || z2) {
                                    v.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", str2);
                                    ah.FT().t(str2, 1);
                                } else {
                                    ah.FT().t(str2, 2);
                                }
                                this.oet.oeq.Ol();
                            }
                        });
                        String str = oVar.field_googleitemid;
                        aVar.lJl = false;
                        aVar.lJk = true;
                        aVar.lJm = str;
                        aVar.lJl = false;
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(Integer.valueOf(58));
                        aVar.b(oVar.field_username, linkedList, true);
                        oVar.field_googlecgistatus = 0;
                        ah.FT().b(oVar);
                        this.oeq.Ol();
                        return;
                    case 1:
                        Cursor iJ = ah.FT().iJ(oVar.field_googleid);
                        if (iJ == null || iJ.getCount() <= 1) {
                            a(oVar, null);
                        } else {
                            a(iJ, oVar);
                        }
                        if (iJ != null) {
                            iJ.close();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "MicroMsg.GoogleContact.GoogleFriendUI";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = TextUtils.isEmpty(str) ? SQLiteDatabase.KeyEmpty : str;
        v.i(str2, str3, objArr);
        int type = kVar.getType();
        if (i != 0 || i2 != 0) {
            switch (type) {
                case 30:
                case 137:
                    if (i2 == -87) {
                        g.A(this, getString(2131232009), SQLiteDatabase.KeyEmpty);
                    } else if (i2 == -24 && !be.kS(str)) {
                        Toast.makeText(this, str, 1).show();
                    }
                    if (this.oeq != null) {
                        v.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", ((m) kVar).cKG);
                        ah.FT().t(r0, 2);
                        this.oeq.Ol();
                        break;
                    }
                    break;
                case 488:
                    jA(false);
                    break;
                case 489:
                    if (this.oeq != null) {
                        v.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", Integer.valueOf(((com.tencent.mm.ad.b) kVar).Gi().eet));
                        v.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", r11.cKG);
                        ah.FT().t(r0, 1);
                        this.oeq.Ol();
                        break;
                    }
                    break;
                default:
                    v.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
                    break;
            }
        }
        switch (type) {
            case 30:
            case 137:
                if (this.oeq != null) {
                    v.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", ((m) kVar).cKG);
                    ah.FT().t(r0, 1);
                    this.oeq.Ol();
                    break;
                }
                break;
            case 488:
                a(((com.tencent.mm.ad.c) kVar).Gj());
                break;
            case 489:
                if (this.oeq != null) {
                    v.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", Integer.valueOf(((com.tencent.mm.ad.b) kVar).Gi().eet));
                    v.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", r11.cKG);
                    ah.FT().t(r0, 1);
                    this.oeq.Ol();
                    break;
                }
                break;
            default:
                v.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
                break;
        }
        Sb();
    }

    public final void gM(String str) {
        if (this.oeq != null) {
            this.oeq.notifyDataSetChanged();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    private void a(Cursor cursor, final o oVar) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        if (cursor != null) {
            cursor.moveToFirst();
            int count = cursor.getCount();
            for (int i = 0; i < count; i++) {
                o oVar2 = new o();
                oVar2.b(cursor);
                arrayList.add(oVar2.field_googlegmail);
                arrayList2.add(Integer.valueOf(i));
                arrayList3.add(oVar2);
                cursor.moveToNext();
            }
            arrayList2.add(Integer.valueOf(-1));
        }
        Context context = this.nDR.nEl;
        String string = getResources().getString(2131233153);
        getResources().getString(2131231010);
        g.a(context, string, arrayList, arrayList2, new d(this) {
            final /* synthetic */ GoogleFriendUI oet;

            public final void bw(int i, int i2) {
                if (i2 != -1) {
                    this.oet.a((o) arrayList3.get(i2), oVar);
                }
            }
        });
    }

    private void a(o oVar, o oVar2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(oVar.field_googlegmail);
        k bVar = new com.tencent.mm.ad.b(arrayList);
        v.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", oVar.field_googleitemid);
        ak.vy().a(bVar, 0);
        if (oVar2 == null) {
            bVar.cKG = oVar.field_googleitemid;
            oVar.field_googlecgistatus = 0;
            ah.FT().b(oVar);
        } else {
            bVar.cKG = oVar2.field_googleitemid;
            oVar2.field_googlecgistatus = 0;
            ah.FT().b(oVar2);
        }
        this.oeq.Ol();
    }

    private void bDk() {
        this.QK = false;
        ags();
        new b(this, this.cKN).execute(new Void[0]);
    }

    private synchronized void a(agi com_tencent_mm_protocal_c_agi) {
        v.i("MicroMsg.GoogleContact.GoogleFriendUI", "handleListGoogleContactCGIResponse Count:%d", Integer.valueOf(com_tencent_mm_protocal_c_agi.eet));
        if (this.oeq != null) {
            this.oeq.Ol();
        }
    }

    private void jA(boolean z) {
        CharSequence string;
        this.gwc.setVisibility(0);
        if (!com.tencent.mm.sdk.platformtools.ak.isConnected(this)) {
            string = getString(2131233152);
        } else if (z) {
            string = getString(2131233145);
        } else {
            string = getString(2131233144);
        }
        this.gwc.setText(string);
    }

    private void ags() {
        if (this.eZg == null || !this.eZg.isShowing()) {
            getString(2131231164);
            this.eZg = g.a((Context) this, getString(2131231182), true, new OnCancelListener(this) {
                final /* synthetic */ GoogleFriendUI oet;

                {
                    this.oet = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.oet.QK = true;
                    ak.vy().c(this.oet.oer);
                }
            });
        }
    }

    private void Sb() {
        if (this.eZg != null && this.eZg.isShowing()) {
            this.eZg.dismiss();
        }
    }
}
