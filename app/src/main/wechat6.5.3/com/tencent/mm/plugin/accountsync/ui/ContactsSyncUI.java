package com.tencent.mm.plugin.accountsync.ui;

import android.accounts.AccountAuthenticatorResponse;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mmdb.database.SQLiteDatabase;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public final class ContactsSyncUI extends MMActivity {
    private AccountAuthenticatorResponse dwG = null;
    Bundle dwH = null;

    private final class a implements com.tencent.mm.plugin.accountsync.model.b.a {
        final /* synthetic */ ContactsSyncUI dwJ;
        private boolean dwK;
        private com.tencent.mm.modelsimple.d.a dwL = new com.tencent.mm.modelsimple.d.a(this) {
            final /* synthetic */ a dwM;

            {
                this.dwM = r1;
            }

            public final void l(Bundle bundle) {
                ContactsSyncUI contactsSyncUI = this.dwM.dwJ;
                contactsSyncUI.dwH = bundle;
                contactsSyncUI.finish();
            }
        };

        public a(ContactsSyncUI contactsSyncUI, boolean z) {
            this.dwJ = contactsSyncUI;
            this.dwK = z;
        }

        public final int bq(final Context context) {
            if (!ak.uN() || ak.uG()) {
                return 4;
            }
            if (this.dwK) {
                ak.yW();
                final String str = (String) c.vf().get(6, SQLiteDatabase.KeyEmpty);
                if (be.kS(str)) {
                    v.e("MicroMsg.ProcessorAddAccount", "not bind mobile phone");
                    return 2;
                } else if (!m.EX()) {
                    return G(context, str);
                } else {
                    g.a(context, 2131232223, 2131231164, 2131231107, 2131231010, new OnClickListener(this) {
                        final /* synthetic */ a dwM;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ak.yW();
                            c.vf().set(12322, Boolean.valueOf(true));
                            this.dwM.dwJ.getSharedPreferences(aa.bti(), 0).edit().putBoolean("upload_contacts_already_displayed", true).commit();
                            this.dwM.G(context, str);
                            if (context instanceof Activity) {
                                ((Activity) context).finish();
                            }
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ a dwM;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ak.yW();
                            c.vf().set(12322, Boolean.valueOf(false));
                            this.dwM.dwJ.getSharedPreferences(aa.bti(), 0).edit().putBoolean("upload_contacts_already_displayed", true).commit();
                            if (context instanceof Activity) {
                                ((Activity) context).finish();
                            }
                        }
                    });
                    return 5;
                }
            }
            v.i("MicroMsg.ProcessorAddAccount", "no need to bind mobile");
            d.a(this.dwJ, this.dwL);
            return 0;
        }

        final int G(Context context, String str) {
            if (context == null) {
                return 1;
            }
            int a = d.a(context, str, this.dwL);
            if (a == 2) {
                Toast.makeText(context, this.dwJ.getString(2131232225), 1).show();
                return 1;
            } else if (a != 3) {
                return 0;
            } else {
                Toast.makeText(context, this.dwJ.getString(2131232224), 1).show();
                return 1;
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fd(SQLiteDatabase.KeyEmpty);
        int a = r.a(getIntent(), "wizard_activity_result_code", 0);
        v.i("MicroMsg.ContactsSyncUI", "onCreate() resultCode[%d]", Integer.valueOf(a));
        switch (a) {
            case -1:
            case 0:
                v.i("MicroMsg.ContactsSyncUI", "summerper checkPermission checkContacts read[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), be.bur());
                if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
                    v.i("MicroMsg.ContactsSyncUI", "summerper checkPermission checkContacts write[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.WRITE_CONTACTS", 48, null, null)), be.bur());
                    if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.WRITE_CONTACTS", 48, null, null)) {
                        NI();
                        return;
                    }
                    return;
                }
                return;
            case 1:
                finish();
                return;
            default:
                v.e("MicroMsg.ContactsSyncUI", "onCreate, should not reach here, resultCode = " + a);
                finish();
                return;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void NI() {
        /*
        r10 = this;
        r3 = 0;
        r4 = 2;
        r5 = -1;
        r1 = 1;
        r2 = 0;
        r0 = com.tencent.mm.model.ak.uN();
        if (r0 == 0) goto L_0x0011;
    L_0x000b:
        r0 = com.tencent.mm.model.ak.uG();
        if (r0 == 0) goto L_0x0023;
    L_0x0011:
        r0 = new android.content.Intent;
        r1 = com.tencent.mm.ui.account.SimpleLoginUI.class;
        r0.<init>(r10, r1);
        r1 = r10.getIntent();
        com.tencent.mm.ui.MMWizardActivity.b(r10, r0, r1);
        r10.finish();
    L_0x0022:
        return;
    L_0x0023:
        r0 = r10.getIntent();
        if (r0 != 0) goto L_0x0036;
    L_0x0029:
        r0 = "MicroMsg.ContactsSyncUI";
        r1 = "initView fail, intent is null";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        r10.finish();
        goto L_0x0022;
    L_0x0036:
        r0 = r10.getIntent();
        r6 = "contact_sync_scene";
        r0 = com.tencent.mm.sdk.platformtools.r.a(r0, r6, r5);
        r6 = r10.getIntent();
        r6 = r6.getAction();
        if (r6 == 0) goto L_0x006c;
    L_0x004b:
        r6 = r10.getIntent();
        r6 = r6.getAction();
        r7 = "com.tencent.mm.login.ACTION_LOGIN";
        r6 = r6.equalsIgnoreCase(r7);
        if (r6 == 0) goto L_0x006c;
    L_0x005c:
        r0 = 4;
    L_0x005d:
        if (r0 != r5) goto L_0x00de;
    L_0x005f:
        r0 = "MicroMsg.ContactsSyncUI";
        r1 = "unkown scene, finish";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        r10.finish();
        goto L_0x0022;
    L_0x006c:
        r6 = r10.getIntent();
        r6 = r6.resolveType(r10);
        r7 = "MicroMsg.ContactsSyncUI";
        r8 = new java.lang.StringBuilder;
        r9 = "scheme = ";
        r8.<init>(r9);
        r8 = r8.append(r6);
        r9 = ", action = ";
        r8 = r8.append(r9);
        r9 = r10.getIntent();
        r9 = r9.getAction();
        r8 = r8.append(r9);
        r8 = r8.toString();
        com.tencent.mm.sdk.platformtools.v.i(r7, r8);
        r7 = com.tencent.mm.sdk.platformtools.be.kS(r6);
        if (r7 != 0) goto L_0x005d;
    L_0x00a3:
        r0 = "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile";
        r0 = r6.equals(r0);
        if (r0 == 0) goto L_0x00ae;
    L_0x00ac:
        r0 = r4;
        goto L_0x005d;
    L_0x00ae:
        r0 = "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip";
        r0 = r6.equals(r0);
        if (r0 == 0) goto L_0x00ba;
    L_0x00b7:
        r0 = 12;
        goto L_0x005d;
    L_0x00ba:
        r0 = "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video";
        r0 = r6.equals(r0);
        if (r0 == 0) goto L_0x00c6;
    L_0x00c3:
        r0 = 13;
        goto L_0x005d;
    L_0x00c6:
        r0 = "vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline";
        r0 = r6.equals(r0);
        if (r0 == 0) goto L_0x00d1;
    L_0x00cf:
        r0 = 3;
        goto L_0x005d;
    L_0x00d1:
        r0 = "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.phonenum";
        r0 = r6.equals(r0);
        if (r0 == 0) goto L_0x00dc;
    L_0x00da:
        r0 = 6;
        goto L_0x005d;
    L_0x00dc:
        r0 = r5;
        goto L_0x005d;
    L_0x00de:
        switch(r0) {
            case 1: goto L_0x019f;
            case 2: goto L_0x00f0;
            case 3: goto L_0x013d;
            case 4: goto L_0x0156;
            case 5: goto L_0x00e1;
            case 6: goto L_0x00f0;
            case 7: goto L_0x00e1;
            case 8: goto L_0x00e1;
            case 9: goto L_0x00e1;
            case 10: goto L_0x00e1;
            case 11: goto L_0x00e1;
            case 12: goto L_0x0109;
            case 13: goto L_0x0123;
            default: goto L_0x00e1;
        };
    L_0x00e1:
        r0 = r3;
    L_0x00e2:
        if (r0 == 0) goto L_0x0239;
    L_0x00e4:
        r0 = r0.bq(r10);
        switch(r0) {
            case 0: goto L_0x00eb;
            case 1: goto L_0x00eb;
            case 2: goto L_0x01d4;
            case 3: goto L_0x01fb;
            case 4: goto L_0x0216;
            case 5: goto L_0x0022;
            default: goto L_0x00eb;
        };
    L_0x00eb:
        r10.finish();
        goto L_0x0022;
    L_0x00f0:
        r0 = r10.getIntent();
        r2 = r0.getData();
        r0 = r10.getIntent();
        r3 = "k_phone_num";
        r3 = com.tencent.mm.sdk.platformtools.r.g(r0, r3);
        r0 = new com.tencent.mm.plugin.accountsync.model.b$b;
        r0.<init>(r1, r3, r2);
        goto L_0x00e2;
    L_0x0109:
        r0 = r10.getIntent();
        r2 = r0.getData();
        r0 = r10.getIntent();
        r3 = "k_phone_num";
        r3 = com.tencent.mm.sdk.platformtools.r.g(r0, r3);
        r0 = new com.tencent.mm.plugin.accountsync.model.b$b;
        r5 = 3;
        r0.<init>(r5, r3, r2);
        goto L_0x00e2;
    L_0x0123:
        r0 = r10.getIntent();
        r2 = r0.getData();
        r0 = r10.getIntent();
        r3 = "k_phone_num";
        r3 = com.tencent.mm.sdk.platformtools.r.g(r0, r3);
        r0 = new com.tencent.mm.plugin.accountsync.model.b$b;
        r5 = 4;
        r0.<init>(r5, r3, r2);
        goto L_0x00e2;
    L_0x013d:
        r0 = r10.getIntent();
        r2 = r0.getData();
        r0 = r10.getIntent();
        r3 = "k_phone_num";
        r3 = com.tencent.mm.sdk.platformtools.r.g(r0, r3);
        r0 = new com.tencent.mm.plugin.accountsync.model.b$b;
        r0.<init>(r4, r3, r2);
        goto L_0x00e2;
    L_0x0156:
        r0 = r10.getIntent();
        r5 = "accountAuthenticatorResponse";
        r0 = r0.getParcelableExtra(r5);
        r10.dwG = r3;
        if (r0 == 0) goto L_0x016d;
    L_0x0165:
        r5 = r0 instanceof android.accounts.AccountAuthenticatorResponse;
        if (r5 == 0) goto L_0x016d;
    L_0x0169:
        r0 = (android.accounts.AccountAuthenticatorResponse) r0;
        r10.dwG = r0;
    L_0x016d:
        r0 = r10.dwG;
        if (r0 == 0) goto L_0x0176;
    L_0x0171:
        r0 = r10.dwG;
        r0.onRequestContinued();
    L_0x0176:
        r0 = com.tencent.mm.sdk.platformtools.aa.bti();
        r0 = r10.getSharedPreferences(r0, r2);
        r5 = "upload_contacts_already_displayed";
        r0 = r0.getBoolean(r5, r2);
        if (r0 != 0) goto L_0x00e1;
    L_0x0187:
        r3 = new com.tencent.mm.plugin.accountsync.ui.ContactsSyncUI$a;
        r0 = r10.getIntent();
        r5 = "k_login_without_bind_mobile";
        r0 = com.tencent.mm.sdk.platformtools.r.a(r0, r5, r2);
        if (r0 != 0) goto L_0x019d;
    L_0x0196:
        r0 = r1;
    L_0x0197:
        r3.<init>(r10, r0);
        r0 = r3;
        goto L_0x00e2;
    L_0x019d:
        r0 = r2;
        goto L_0x0197;
    L_0x019f:
        r0 = r10.getIntent();
        r5 = "accountAuthenticatorResponse";
        r0 = r0.getParcelableExtra(r5);
        r10.dwG = r3;
        if (r0 == 0) goto L_0x01b6;
    L_0x01ae:
        r3 = r0 instanceof android.accounts.AccountAuthenticatorResponse;
        if (r3 == 0) goto L_0x01b6;
    L_0x01b2:
        r0 = (android.accounts.AccountAuthenticatorResponse) r0;
        r10.dwG = r0;
    L_0x01b6:
        r0 = r10.dwG;
        if (r0 == 0) goto L_0x01bf;
    L_0x01ba:
        r0 = r10.dwG;
        r0.onRequestContinued();
    L_0x01bf:
        r0 = new com.tencent.mm.plugin.accountsync.ui.ContactsSyncUI$a;
        r3 = r10.getIntent();
        r5 = "k_login_without_bind_mobile";
        r3 = com.tencent.mm.sdk.platformtools.r.a(r3, r5, r2);
        if (r3 != 0) goto L_0x01cf;
    L_0x01ce:
        r2 = r1;
    L_0x01cf:
        r0.<init>(r10, r2);
        goto L_0x00e2;
    L_0x01d4:
        r0 = r10.getIntent();
        r2 = com.tencent.mm.plugin.accountsync.ui.ContactsSyncUI.class;
        r0.setClass(r10, r2);
        r2 = new android.content.Intent;
        r2.<init>();
        r3 = com.tencent.mm.ui.bindmobile.BindMContactIntroUI.class;
        r2.setClass(r10, r3);
        r3 = "key_upload_scene";
        r2.putExtra(r3, r4);
        r3 = "is_bind_for_contact_sync";
        r2.putExtra(r3, r1);
        com.tencent.mm.ui.MMWizardActivity.b(r10, r2, r0);
        r10.finish();
        goto L_0x00eb;
    L_0x01fb:
        r0 = r10.getIntent();
        r1 = com.tencent.mm.plugin.accountsync.ui.ContactsSyncUI.class;
        r0.setClass(r10, r1);
        r1 = new android.content.Intent;
        r1.<init>();
        r2 = com.tencent.mm.ui.account.SimpleLoginUI.class;
        r1.setClass(r10, r2);
        com.tencent.mm.ui.MMWizardActivity.b(r10, r1, r0);
        r10.finish();
        goto L_0x00eb;
    L_0x0216:
        r0 = r10.getIntent();
        r1 = com.tencent.mm.plugin.accountsync.ui.ContactsSyncUI.class;
        r0.setClass(r10, r1);
        r1 = new android.content.Intent;
        r1.<init>();
        r2 = com.tencent.mm.ui.account.SimpleLoginUI.class;
        r1.setClass(r10, r2);
        r2 = "accountAuthenticatorResponse";
        r3 = r10.dwG;
        r1.putExtra(r2, r3);
        com.tencent.mm.ui.MMWizardActivity.b(r10, r1, r0);
        r10.finish();
        goto L_0x00eb;
    L_0x0239:
        r0 = "MicroMsg.ContactsSyncUI";
        r1 = "unkown scene, finish";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        goto L_0x00eb;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.accountsync.ui.ContactsSyncUI.NI():void");
    }

    public final void finish() {
        if (this.dwG != null) {
            if (this.dwH != null) {
                this.dwG.onResult(this.dwH);
            } else {
                this.dwG.onError(4, "canceled");
            }
            this.dwG = null;
        }
        super.finish();
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            int i2;
            String str = "MicroMsg.ContactsSyncUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            if (iArr == null) {
                i2 = -1;
            } else {
                i2 = iArr.length;
            }
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = be.bur();
            v.w(str, str2, objArr);
            return;
        }
        v.i("MicroMsg.ContactsSyncUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] == 0) {
                    final String str3 = strArr[0];
                    new ac().post(new Runnable(this) {
                        final /* synthetic */ ContactsSyncUI dwJ;

                        public final void run() {
                            v.i("MicroMsg.ContactsSyncUI", "summerper checkPermission checkContacts [%b], oldPermission[%s], stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.dwJ, str3.equals("android.permission.READ_CONTACTS") ? "android.permission.WRITE_CONTACTS" : "android.permission.READ_CONTACTS", 48, null, null)), str3, be.bur());
                            if (com.tencent.mm.pluginsdk.i.a.a(this.dwJ, str3.equals("android.permission.READ_CONTACTS") ? "android.permission.WRITE_CONTACTS" : "android.permission.READ_CONTACTS", 48, null, null)) {
                                this.dwJ.NI();
                            }
                        }

                        public final String toString() {
                            return super.toString() + "|checkContacts";
                        }
                    });
                    return;
                }
                g.a((Context) this, getString(2131234161), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                    final /* synthetic */ ContactsSyncUI dwJ;

                    {
                        this.dwJ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.dwJ.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ ContactsSyncUI dwJ;

                    {
                        this.dwJ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.dwJ.finish();
                    }
                });
                return;
            default:
                return;
        }
    }
}
