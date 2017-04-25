package com.tencent.mm.ui.account;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.e.a.c;
import com.tencent.mm.ui.e.a.d;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import org.json.JSONObject;

public final class h {
    ac handler;
    private c nHN;
    a nKe;

    public interface a {
        void k(Bundle bundle);

        void onError(int i, String str);
    }

    static /* synthetic */ void a(h hVar, int i, String str) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i;
        obtain.obj = str;
        hVar.handler.sendMessage(obtain);
    }

    public h(c cVar, a aVar) {
        this.nHN = cVar;
        this.nKe = aVar;
    }

    public final void bAT() {
        this.handler = new ac(this) {
            final /* synthetic */ h nKf;

            {
                this.nKf = r1;
            }

            public final void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (this.nKf.nKe != null) {
                            this.nKf.nKe.onError(message.arg1, (String) message.obj);
                            return;
                        }
                        return;
                    case 2:
                        if (this.nKf.nKe != null) {
                            this.nKf.nKe.k(message.getData());
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        Bundle bundle = new Bundle();
        bundle.putString("client_id", "290293790992170");
        bundle.putString("client_secret", "6667e9307e67283c76028fd37189c096");
        bundle.putString("grant_type", "fb_exchange_token");
        bundle.putString("fb_exchange_token", this.nHN.oed);
        e.a(new com.tencent.mm.ui.e.a.a.AnonymousClass1(new com.tencent.mm.ui.e.a.a(this.nHN), "oauth/access_token", bundle, "GET", new com.tencent.mm.ui.e.a.a.a(this) {
            final /* synthetic */ h nKf;

            {
                this.nKf = r1;
            }

            public final void Oh(String str) {
                if (str == null || str.length() == 0) {
                    v.e("MicroMsg.RefreshTokenRunner", "response is null or nil");
                    h.a(this.nKf, 1, "response is null or nil");
                } else if (!str.contains("access_token") || str.length() <= 12) {
                    try {
                        if (str.equals("false")) {
                            throw new d("request failed");
                        }
                        if (str.equals("true")) {
                            str = "{value : true}";
                        }
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.has("error")) {
                            jSONObject = jSONObject.getJSONObject("error");
                            throw new d(jSONObject.getString("message"), jSONObject.getString("type"), 0);
                        } else if (jSONObject.has("error_code") && jSONObject.has("error_msg")) {
                            throw new d(jSONObject.getString("error_msg"), SQLiteDatabase.KeyEmpty, Integer.parseInt(jSONObject.getString("error_code")));
                        } else if (jSONObject.has("error_code")) {
                            throw new d("request failed", SQLiteDatabase.KeyEmpty, Integer.parseInt(jSONObject.getString("error_code")));
                        } else if (jSONObject.has("error_msg")) {
                            throw new d(jSONObject.getString("error_msg"));
                        } else {
                            if (jSONObject.has("error_reason")) {
                                throw new d(jSONObject.getString("error_reason"));
                            }
                            h.a(this.nKf, 2, "parseJson error");
                        }
                    } catch (Throwable e) {
                        v.e("MicroMsg.RefreshTokenRunner", "parseJson exception : " + e.getMessage());
                        v.a("MicroMsg.RefreshTokenRunner", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    } catch (Throwable e2) {
                        String str2 = "errCode = " + e2.esS + ", errType = " + e2.oNt + ", errMsg = " + e2.getMessage();
                        v.e("MicroMsg.RefreshTokenRunner", "parseJson facebookerror, " + str2);
                        v.a("MicroMsg.RefreshTokenRunner", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                        h.a(this.nKf, 3, str2);
                    }
                } else {
                    try {
                        Bundle Pq = com.tencent.mm.ui.e.a.e.Pq(str);
                        if (Pq.containsKey("access_token")) {
                            h hVar = this.nKf;
                            Message obtain = Message.obtain();
                            obtain.what = 2;
                            obtain.setData(Pq);
                            hVar.handler.sendMessage(obtain);
                            return;
                        }
                    } catch (Throwable e22) {
                        v.a("MicroMsg.RefreshTokenRunner", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                    h.a(this.nKf, 2, "decodeUrl fail");
                }
            }

            public final void a(IOException iOException) {
                v.e("MicroMsg.RefreshTokenRunner", "onIOException");
                h.a(this.nKf, 2, iOException.getMessage());
            }

            public final void a(FileNotFoundException fileNotFoundException) {
                v.e("MicroMsg.RefreshTokenRunner", "onFileNotFoundException");
                h.a(this.nKf, 2, fileNotFoundException.getMessage());
            }

            public final void a(MalformedURLException malformedURLException) {
                v.e("MicroMsg.RefreshTokenRunner", "onMalformedURLException");
                h.a(this.nKf, 2, malformedURLException.getMessage());
            }
        }, null), "AsyncFacebookRunner_request");
    }
}
