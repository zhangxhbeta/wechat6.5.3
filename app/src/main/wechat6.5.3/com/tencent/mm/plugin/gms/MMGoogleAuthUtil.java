package com.tencent.mm.plugin.gms;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.auth.b;
import com.google.android.gms.auth.c;
import com.google.android.gms.auth.d;
import com.google.android.gms.common.e;
import java.io.IOException;

public class MMGoogleAuthUtil extends Activity {
    private String cKN;
    private String dHL;
    private String gDh;
    public int gDi = 0;

    class a extends AsyncTask<Void, Void, Void> {
        private String dHL;
        private String dHa;
        private int esS;
        private boolean gDj = false;
        private boolean gDk;
        private String gDl;
        final /* synthetic */ MMGoogleAuthUtil gDm;
        private Context mContext;

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return aty();
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
            if (!this.gDj) {
                Intent intent;
                if (this.gDk) {
                    intent = new Intent();
                    intent.putExtra("error_code", 0);
                    intent.putExtra("token", this.gDm.cKN);
                    this.gDm.setResult(-1, intent);
                    this.gDm.finish();
                    return;
                }
                intent = new Intent();
                intent.putExtra("error_code", -1);
                intent.putExtra("error_msg", this.dHa);
                this.gDm.setResult(-1, intent);
                this.gDm.finish();
            }
        }

        public a(MMGoogleAuthUtil mMGoogleAuthUtil, Context context, String str, String str2) {
            this.gDm = mMGoogleAuthUtil;
            this.mContext = context;
            this.gDl = str;
            this.dHL = str2;
            this.gDj = false;
        }

        protected final void onPreExecute() {
            super.onPreExecute();
            this.gDk = false;
        }

        private Void aty() {
            try {
                this.gDm.cKN = b.c(this.mContext, this.gDl, this.dHL);
                this.gDk = true;
                this.esS = 0;
            } catch (c e) {
                this.dHa = e.getMessage();
                this.esS = -2;
            } catch (d e2) {
                d dVar = e2;
                this.dHa = dVar.getMessage();
                this.esS = -3;
                if (this.gDm.gDi < 4) {
                    MMGoogleAuthUtil mMGoogleAuthUtil = this.gDm;
                    mMGoogleAuthUtil.gDi++;
                    this.gDj = true;
                    this.gDm.startActivityForResult(dVar.OH == null ? null : new Intent(dVar.OH), 2002);
                }
            } catch (IOException e3) {
                this.dHa = e3.getMessage();
                this.esS = -4;
            } catch (com.google.android.gms.auth.a e4) {
                this.dHa = e4.getMessage();
                this.esS = -5;
            } catch (Exception e5) {
                this.dHa = e5.getMessage();
                this.esS = -1;
            }
            return null;
        }
    }

    protected void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        requestWindowFeature(1);
        Intent intent = getIntent();
        Intent intent2 = new Intent();
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                if (action.equals("com.tencent.mm.gms.ACTION_CHOOSE_ACCOUNT")) {
                    String[] strArr = new String[]{"com.google"};
                    intent = new Intent();
                    intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
                    intent.setPackage("com.google.android.gms");
                    intent.putExtra("allowableAccounts", null);
                    intent.putExtra("allowableAccountTypes", strArr);
                    intent.putExtra("addAccountOptions", null);
                    intent.putExtra("selectedAccount", null);
                    intent.putExtra("alwaysPromptForAccount", false);
                    intent.putExtra("descriptionTextOverride", null);
                    intent.putExtra("authTokenType", null);
                    intent.putExtra("addAccountRequiredFeatures", null);
                    intent.putExtra("setGmsCoreAccount", false);
                    intent.putExtra("overrideTheme", 0);
                    intent.putExtra("overrideCustomTheme", 0);
                    startActivityForResult(intent, 2001);
                    return;
                } else if (action.equals("com.tencent.mm.gms.ACTION_GET_TOKEN")) {
                    this.gDh = intent.getStringExtra("gmail");
                    this.dHL = intent.getStringExtra("scope");
                    bO(this.gDh, this.dHL);
                    return;
                } else if (action.equals("com.tencent.mm.gms.CHECK_GP_SERVICES")) {
                    int v = e.v(this);
                    new StringBuilder().append(v);
                    action = "gpservices";
                    if (v != 0) {
                        z = false;
                    }
                    intent2.putExtra(action, z);
                    setResult(-1, intent2);
                    finish();
                }
            }
        }
        intent2.putExtra("error_msg", "null intent or action.");
        setResult(-1, intent2);
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 2001:
                    String stringExtra = intent.getStringExtra("authAccount");
                    Intent intent2 = new Intent();
                    intent2.putExtra("error_code", 0);
                    intent2.putExtra("account", stringExtra);
                    setResult(-1, intent2);
                    finish();
                    return;
                case 2002:
                    bO(this.gDh, this.dHL);
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 2001:
            case 2002:
                Intent intent3 = new Intent();
                intent3.putExtra("error_code", -1);
                intent3.putExtra("error_msg", "User Cancel.");
                setResult(i2, intent3);
                finish();
                return;
            default:
                return;
        }
    }

    private void bO(String str, String str2) {
        new a(this, this, str, str2).execute(new Void[0]);
    }
}
