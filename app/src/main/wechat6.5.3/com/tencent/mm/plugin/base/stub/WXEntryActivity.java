package com.tencent.mm.plugin.base.stub;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.o;
import com.tencent.mm.modelsimple.af;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.c.bad;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXTextObject;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.modelmsg.c;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.Map;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class WXEntryActivity extends AutoLoginActivity implements e {
    private String appId;
    private String authority;
    private String content;
    private ProgressDialog dwR;
    private int enr;
    private String tX;
    private Uri uri;

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public static class EntryReceiver extends BroadcastReceiver {
        private String appId;
        private String appName;
        private Context context;
        private long enN;
        private int enr;
        private String tX;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceive(android.content.Context r10, android.content.Intent r11) {
            /*
            r9 = this;
            r8 = 4;
            r2 = 1;
            r3 = 0;
            if (r10 == 0) goto L_0x0007;
        L_0x0005:
            if (r11 != 0) goto L_0x0008;
        L_0x0007:
            return;
        L_0x0008:
            com.tencent.mm.ay.c.brh();
            r9.context = r10;
            r0 = "_mmessage_content";
            r0 = com.tencent.mm.sdk.platformtools.r.g(r11, r0);
            r1 = "_mmessage_support_content_type";
            r4 = com.tencent.mm.sdk.platformtools.r.f(r11, r1);
            r9.enN = r4;
            r1 = "_mmessage_sdkVersion";
            r1 = com.tencent.mm.sdk.platformtools.r.a(r11, r1, r3);
            r9.enr = r1;
            r1 = r9.enr;
            r1 = com.tencent.mm.plugin.base.stub.WXEntryActivity.ip(r1);
            if (r1 != 0) goto L_0x0047;
        L_0x002e:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = new java.lang.StringBuilder;
            r2 = "sdk version is not supported, sdkVersion = ";
            r1.<init>(r2);
            r2 = r9.enr;
            r1 = r1.append(r2);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.v.e(r0, r1);
            goto L_0x0007;
        L_0x0047:
            r1 = "_mmessage_appPackage";
            r1 = com.tencent.mm.sdk.platformtools.r.g(r11, r1);
            r9.tX = r1;
            r1 = r9.tX;
            if (r1 == 0) goto L_0x005c;
        L_0x0054:
            r1 = r9.tX;
            r1 = r1.length();
            if (r1 > 0) goto L_0x0066;
        L_0x005c:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = "unknown package, ignore";
            com.tencent.mm.sdk.platformtools.v.e(r0, r1);
            goto L_0x0007;
        L_0x0066:
            r1 = "_mmessage_checksum";
            r1 = com.tencent.mm.sdk.platformtools.r.h(r11, r1);
            r4 = r9.enr;
            r5 = r9.tX;
            r4 = com.tencent.mm.plugin.base.stub.WXEntryActivity.i(r0, r4, r5);
            r1 = com.tencent.mm.plugin.base.stub.WXEntryActivity.f(r1, r4);
            if (r1 != 0) goto L_0x0085;
        L_0x007b:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = "checksum fail";
            com.tencent.mm.sdk.platformtools.v.e(r0, r1);
            goto L_0x0007;
        L_0x0085:
            if (r0 != 0) goto L_0x0092;
        L_0x0087:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = "check appid failed, null content";
            com.tencent.mm.sdk.platformtools.v.e(r0, r1);
            goto L_0x0007;
        L_0x0092:
            r0 = android.net.Uri.parse(r0);
            r1 = r0.getAuthority();
            r4 = "appid";
            r0 = r0.getQueryParameter(r4);	 Catch:{ Exception -> 0x00d2 }
            r9.appId = r0;	 Catch:{ Exception -> 0x00d2 }
            r0 = "MicroMsg.WXEntryActivity";
            r4 = new java.lang.StringBuilder;
            r5 = "onReceive, appId = ";
            r4.<init>(r5);
            r5 = r9.appId;
            r4 = r4.append(r5);
            r4 = r4.toString();
            com.tencent.mm.sdk.platformtools.v.i(r0, r4);
            r0 = r9.appId;
            if (r0 == 0) goto L_0x00c7;
        L_0x00bf:
            r0 = r9.appId;
            r0 = r0.length();
            if (r0 > 0) goto L_0x00e6;
        L_0x00c7:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = "invalid appid, ignore";
            com.tencent.mm.sdk.platformtools.v.e(r0, r1);
            goto L_0x0007;
        L_0x00d2:
            r0 = move-exception;
            r1 = "MicroMsg.WXEntryActivity";
            r4 = "init: %s";
            r2 = new java.lang.Object[r2];
            r0 = r0.toString();
            r2[r3] = r0;
            com.tencent.mm.sdk.platformtools.v.e(r1, r4, r2);
            goto L_0x0007;
        L_0x00e6:
            r0 = com.tencent.mm.model.ak.uz();
            if (r0 == 0) goto L_0x00f2;
        L_0x00ec:
            r0 = com.tencent.mm.model.ak.uG();
            if (r0 == 0) goto L_0x0108;
        L_0x00f2:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = "not login, just save the appid : %s";
            r2 = new java.lang.Object[r2];
            r4 = r9.appId;
            r2[r3] = r4;
            com.tencent.mm.sdk.platformtools.v.w(r0, r1, r2);
            r0 = r9.appId;
            com.tencent.mm.pluginsdk.model.app.p.GG(r0);
            goto L_0x0007;
        L_0x0108:
            r0 = com.tencent.mm.model.ak.yZ();
            if (r0 == 0) goto L_0x0124;
        L_0x010e:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = "not login accInitializing, just save the appid : %s";
            r2 = new java.lang.Object[r2];
            r4 = r9.appId;
            r2[r3] = r4;
            com.tencent.mm.sdk.platformtools.v.w(r0, r1, r2);
            r0 = r9.appId;
            com.tencent.mm.pluginsdk.model.app.p.GG(r0);
            goto L_0x0007;
        L_0x0124:
            r0 = "registerapp";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x030c;
        L_0x012d:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = new java.lang.StringBuilder;
            r4 = "handle app registeration: ";
            r1.<init>(r4);
            r4 = r9.tX;
            r1 = r1.append(r4);
            r4 = ", sdkver=";
            r1 = r1.append(r4);
            r4 = r9.enr;
            r1 = r1.append(r4);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.v.i(r0, r1);
            r0 = com.tencent.mm.model.ak.uz();
            if (r0 != 0) goto L_0x0163;
        L_0x0158:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = "no available account";
            com.tencent.mm.sdk.platformtools.v.e(r0, r1);
            goto L_0x0007;
        L_0x0163:
            r0 = r9.appId;
            r4 = com.tencent.mm.pluginsdk.model.app.g.aC(r0, r2);
            r0 = r9.context;
            r1 = r9.tX;
            r0 = com.tencent.mm.pluginsdk.model.app.p.b(r0, r4, r1);
            if (r0 != 0) goto L_0x0187;
        L_0x0173:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = "reg fail, check app fail";
            com.tencent.mm.sdk.platformtools.v.e(r0, r1);
            r0 = com.tencent.mm.pluginsdk.model.app.am.bnA();
            r1 = r9.appId;
            r0.Gx(r1);
            goto L_0x0007;
        L_0x0187:
            if (r4 == 0) goto L_0x019c;
        L_0x0189:
            r0 = r4.bnk();
            if (r0 == 0) goto L_0x019c;
        L_0x018f:
            r0 = com.tencent.mm.pluginsdk.j.a.lxN;
            if (r0 == 0) goto L_0x019c;
        L_0x0193:
            r1 = r9.context;
            r5 = r9.appId;
            r6 = r9.tX;
            r0.m(r1, r5, r6);
        L_0x019c:
            r1 = 0;
            r0 = r9.context;	 Catch:{ IncompatibleClassChangeError -> 0x01b7, Throwable -> 0x0277 }
            r0 = r0.getPackageManager();	 Catch:{ IncompatibleClassChangeError -> 0x01b7, Throwable -> 0x0277 }
            r5 = r9.tX;	 Catch:{ IncompatibleClassChangeError -> 0x01b7, Throwable -> 0x0277 }
            r6 = 0;
            r5 = r0.getApplicationInfo(r5, r6);	 Catch:{ IncompatibleClassChangeError -> 0x01b7, Throwable -> 0x0277 }
            if (r5 != 0) goto L_0x01d4;
        L_0x01ac:
            r0 = "MicroMsg.WXEntryActivity";
            r5 = "package not installed";
            com.tencent.mm.sdk.platformtools.v.e(r0, r5);	 Catch:{ IncompatibleClassChangeError -> 0x01b7, Throwable -> 0x0277 }
            goto L_0x0007;
        L_0x01b7:
            r0 = move-exception;
            r1 = "MicroMsg.Crash";
            r2 = "May cause dvmFindCatchBlock crash!";
            r3 = new java.lang.Object[r3];
            com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r3);
            r1 = new java.lang.IncompatibleClassChangeError;
            r2 = "May cause dvmFindCatchBlock crash!";
            r1.<init>(r2);
            r0 = r1.initCause(r0);
            r0 = (java.lang.IncompatibleClassChangeError) r0;
            r0 = (java.lang.IncompatibleClassChangeError) r0;
            throw r0;
        L_0x01d4:
            r6 = r5.loadLabel(r0);	 Catch:{ IncompatibleClassChangeError -> 0x01b7, Throwable -> 0x0277 }
            r6 = r6.toString();	 Catch:{ IncompatibleClassChangeError -> 0x01b7, Throwable -> 0x0277 }
            r9.appName = r6;	 Catch:{ IncompatibleClassChangeError -> 0x01b7, Throwable -> 0x0277 }
            r0 = r5.loadIcon(r0);	 Catch:{ IncompatibleClassChangeError -> 0x01b7, Throwable -> 0x0277 }
            r5 = r0 instanceof android.graphics.drawable.BitmapDrawable;	 Catch:{ IncompatibleClassChangeError -> 0x01b7, Throwable -> 0x0277 }
            if (r5 == 0) goto L_0x0382;
        L_0x01e6:
            r0 = (android.graphics.drawable.BitmapDrawable) r0;	 Catch:{ IncompatibleClassChangeError -> 0x01b7, Throwable -> 0x0277 }
            r0 = r0.getBitmap();	 Catch:{ IncompatibleClassChangeError -> 0x01b7, Throwable -> 0x0277 }
        L_0x01ec:
            r1 = r0;
        L_0x01ed:
            if (r4 == 0) goto L_0x0208;
        L_0x01ef:
            com.tencent.mm.pluginsdk.model.app.am.bnB();
            r0 = r9.appId;
            if (r0 == 0) goto L_0x01fc;
        L_0x01f6:
            r5 = r0.length();
            if (r5 != 0) goto L_0x0285;
        L_0x01fc:
            r0 = "MicroMsg.AppInfoStorage";
            r5 = "hasIcon, appId is null";
            com.tencent.mm.sdk.platformtools.v.e(r0, r5);
            r0 = r3;
        L_0x0206:
            if (r0 != 0) goto L_0x0211;
        L_0x0208:
            r0 = com.tencent.mm.pluginsdk.model.app.am.bnB();
            r5 = r9.appId;
            r0.r(r5, r1);
        L_0x0211:
            if (r4 != 0) goto L_0x028f;
        L_0x0213:
            r0 = new com.tencent.mm.pluginsdk.model.app.f;
            r0.<init>();
            r1 = r9.appId;
            r0.field_appId = r1;
            r1 = "";
            r0.field_appName = r1;
            r1 = r9.tX;
            r0.field_packageName = r1;
            r0.field_status = r3;
            r1 = r9.context;
            r2 = r9.tX;
            r1 = com.tencent.mm.pluginsdk.model.app.p.aM(r1, r2);
            if (r1 == 0) goto L_0x0233;
        L_0x0231:
            r0.field_signature = r1;
        L_0x0233:
            r2 = java.lang.System.currentTimeMillis();
            r0.field_modifyTime = r2;
            r2 = r9.enN;
            r0.field_appSupportContentType = r2;
            r1 = com.tencent.mm.pluginsdk.model.app.am.bnB();
            r1 = r1.m(r0);
            r2 = r9.appId;
            com.tencent.mm.pluginsdk.ui.tools.b.HS(r2);
            if (r1 == 0) goto L_0x0007;
        L_0x024c:
            r0 = r0.field_openId;
            r0 = com.tencent.mm.platformtools.t.kS(r0);
            if (r0 == 0) goto L_0x0007;
        L_0x0254:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = new java.lang.StringBuilder;
            r2 = "handleAppRegisteration, trigger getAppSetting, appId = ";
            r1.<init>(r2);
            r2 = r9.appId;
            r1 = r1.append(r2);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.v.d(r0, r1);
            r0 = com.tencent.mm.pluginsdk.model.app.am.bnF();
            r1 = r9.appId;
            r0.Ez(r1);
            goto L_0x0007;
        L_0x0277:
            r0 = move-exception;
            r5 = "MicroMsg.WXEntryActivity";
            r6 = "package not installed";
            r7 = new java.lang.Object[r3];
            com.tencent.mm.sdk.platformtools.v.a(r5, r0, r6, r7);
            goto L_0x01ed;
        L_0x0285:
            r0 = com.tencent.mm.pluginsdk.model.app.i.bB(r0, r2);
            r0 = com.tencent.mm.a.e.aR(r0);
            goto L_0x0206;
        L_0x028f:
            r0 = r4.field_appInfoFlag;
            r0 = r0 & 8192;
            if (r0 == 0) goto L_0x037f;
        L_0x0295:
            r0 = r9.enN;
            r6 = r4.field_appSupportContentType;
            r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
            if (r0 == 0) goto L_0x030a;
        L_0x029d:
            r0 = r2;
        L_0x029e:
            r6 = r9.enN;
            r4.field_appSupportContentType = r6;
        L_0x02a2:
            r1 = r4.field_status;
            r2 = 2;
            if (r1 == r2) goto L_0x02b2;
        L_0x02a7:
            r1 = r4.field_status;
            r2 = 3;
            if (r1 == r2) goto L_0x02b2;
        L_0x02ac:
            r1 = r4.field_status;
            if (r1 == r8) goto L_0x02b2;
        L_0x02b0:
            if (r0 == 0) goto L_0x02df;
        L_0x02b2:
            r0 = r4.bnk();
            if (r0 != 0) goto L_0x02bd;
        L_0x02b8:
            r0 = r9.appId;
            com.tencent.mm.pluginsdk.ui.tools.b.HS(r0);
        L_0x02bd:
            r4.field_status = r3;
            r0 = com.tencent.mm.pluginsdk.model.app.am.bnB();
            r1 = new java.lang.String[r3];
            r0 = r0.a(r4, r1);
            r1 = "MicroMsg.WXEntryActivity";
            r2 = new java.lang.StringBuilder;
            r3 = "handleAppRegisteration, updateRet = ";
            r2.<init>(r3);
            r0 = r2.append(r0);
            r0 = r0.toString();
            com.tencent.mm.sdk.platformtools.v.d(r1, r0);
        L_0x02df:
            r0 = r4.field_openId;
            r0 = com.tencent.mm.platformtools.t.kS(r0);
            if (r0 == 0) goto L_0x0007;
        L_0x02e7:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = new java.lang.StringBuilder;
            r2 = "handleAppRegisteration, trigger getAppSetting, appId = ";
            r1.<init>(r2);
            r2 = r9.appId;
            r1 = r1.append(r2);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.v.d(r0, r1);
            r0 = com.tencent.mm.pluginsdk.model.app.am.bnF();
            r1 = r9.appId;
            r0.Ez(r1);
            goto L_0x0007;
        L_0x030a:
            r0 = r3;
            goto L_0x029e;
        L_0x030c:
            r0 = "unregisterapp";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x0007;
        L_0x0315:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = new java.lang.StringBuilder;
            r2 = "handle app unregisteration: ";
            r1.<init>(r2);
            r2 = r9.tX;
            r1 = r1.append(r2);
            r2 = ", sdkver=";
            r1 = r1.append(r2);
            r2 = r9.enr;
            r1 = r1.append(r2);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.v.d(r0, r1);
            r0 = com.tencent.mm.model.ak.uz();
            if (r0 != 0) goto L_0x034b;
        L_0x0340:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = "no available account";
            com.tencent.mm.sdk.platformtools.v.e(r0, r1);
            goto L_0x0007;
        L_0x034b:
            r0 = r9.appId;
            r0 = com.tencent.mm.pluginsdk.model.app.g.aC(r0, r3);
            r1 = r9.context;
            r2 = r9.tX;
            r1 = com.tencent.mm.pluginsdk.model.app.p.b(r1, r0, r2);
            if (r1 != 0) goto L_0x0366;
        L_0x035b:
            r0 = "MicroMsg.WXEntryActivity";
            r1 = "unreg fail, check app fail";
            com.tencent.mm.sdk.platformtools.v.e(r0, r1);
            goto L_0x0007;
        L_0x0366:
            if (r0 == 0) goto L_0x0007;
        L_0x0368:
            r1 = r0.field_status;
            r2 = 5;
            if (r1 == r2) goto L_0x0007;
        L_0x036d:
            r0.field_status = r8;
            r1 = com.tencent.mm.pluginsdk.model.app.am.bnB();
            r2 = new java.lang.String[r3];
            r1.a(r0, r2);
            r0 = r9.appId;
            com.tencent.mm.pluginsdk.ui.tools.b.HT(r0);
            goto L_0x0007;
        L_0x037f:
            r0 = r3;
            goto L_0x02a2;
        L_0x0382:
            r0 = r1;
            goto L_0x01ec;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.base.stub.WXEntryActivity.EntryReceiver.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    public void onCreate(Bundle bundle) {
        r.i(getIntent(), "key_auto_login_wizard_exit");
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WXEntryActivity enM;

            {
                this.enM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.enM.goBack();
                return false;
            }
        });
    }

    private boolean q(Intent intent) {
        this.enr = r.a(intent, "_mmessage_sdkVersion", 0);
        this.content = r.g(intent, "_mmessage_content");
        if (this.content == null) {
            return false;
        }
        this.uri = Uri.parse(this.content);
        this.authority = this.uri.getAuthority();
        try {
            this.appId = this.uri.getQueryParameter("appid");
            this.tX = r.g(intent, "_mmessage_appPackage");
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.WXEntryActivity", "init: %s", e.toString());
            return false;
        }
    }

    protected final boolean p(Intent intent) {
        if (q(intent)) {
            if (!ak.uz() || ak.uG()) {
                v.w("MicroMsg.WXEntryActivity", "preLogin not login, save the appid : %s", this.appId);
                p.GG(this.appId);
            }
            if (!ip(this.enr)) {
                v.e("MicroMsg.WXEntryActivity", "sdk version is not supported, sdkVersion = " + this.enr);
                finish();
                return false;
            } else if (this.uri == null) {
                v.e("MicroMsg.WXEntryActivity", "check appid failed, null content");
                finish();
                return false;
            } else {
                v.i("MicroMsg.WXEntryActivity", "preLogin, appId = " + this.appId);
                if (t.kS(this.appId)) {
                    v.e("MicroMsg.WXEntryActivity", "invalid appid, ignore");
                    finish();
                    return false;
                }
                v.i("MicroMsg.WXEntryActivity", "preLogin, pkg = " + this.tX);
                if (t.kS(this.tX)) {
                    v.e("MicroMsg.WXEntryActivity", "unknown package, ignore");
                    finish();
                    return false;
                } else if (f(r.h(intent, "_mmessage_checksum"), i(this.content, this.enr, this.tX))) {
                    return true;
                } else {
                    v.e("MicroMsg.WXEntryActivity", "checksum fail");
                    finish();
                    return false;
                }
            }
        }
        v.e("MicroMsg.WXEntryActivity", "Init failed");
        finish();
        return false;
    }

    protected final void a(a aVar, Intent intent) {
        v.d("MicroMsg.WXEntryActivity", "postLogin, loginResult = " + aVar);
        q(intent);
        switch (aVar) {
            case LOGIN_OK:
                if (getIntent() == null || getIntent().getExtras() == null) {
                    v.e("MicroMsg.WXEntryActivity", "checkCanShare fail, invalid intent/extras");
                    finish();
                    return;
                }
                c.a aVar2 = new c.a(getIntent().getExtras());
                WXMediaMessage wXMediaMessage = aVar2.nhM;
                if (wXMediaMessage == null) {
                    v.e("MicroMsg.WXEntryActivity", "wxmsg is null, how could it be?, directly deal request");
                    g(null);
                    finish();
                    return;
                } else if (r.a(getIntent().getExtras(), "_wxapi_command_type", 0) == 1) {
                    v.i("MicroMsg.WXEntryActivity", "it is auth, just dealrequest");
                    g(null);
                    finish();
                    return;
                } else {
                    String format;
                    int i = aVar2.scene == 2 ? 3 : aVar2.scene == 1 ? 2 : aVar2.scene == 0 ? 1 : 0;
                    if (wXMediaMessage.getType() == 1) {
                        WXTextObject wXTextObject = (WXTextObject) wXMediaMessage.mediaObject;
                        format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s", new Object[]{this.appId, Integer.valueOf(i), pu(wXTextObject.text), SQLiteDatabase.KeyEmpty, wXMediaMessage.getType()});
                    } else if (wXMediaMessage.getType() == 5) {
                        WXWebpageObject wXWebpageObject = (WXWebpageObject) wXMediaMessage.mediaObject;
                        format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s", new Object[]{this.appId, Integer.valueOf(i), pu(wXMediaMessage.description), pu(wXWebpageObject.webpageUrl), wXMediaMessage.getType()});
                    } else {
                        format = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s", new Object[]{this.appId, Integer.valueOf(i), pu(wXMediaMessage.description), SQLiteDatabase.KeyEmpty, wXMediaMessage.getType()});
                    }
                    this.dwR = g.a(this.nDR.nEl, getString(2131231182), true, new OnCancelListener(this) {
                        final /* synthetic */ WXEntryActivity enM;

                        {
                            this.enM = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            this.enM.WP();
                            this.enM.finish();
                        }
                    });
                    ak.vy().a(1200, (e) this);
                    ak.vy().a(new af(format, 1, new LinkedList()), 0);
                    return;
                }
            case LOGIN_CANCEL:
                WP();
                v.e("MicroMsg.WXEntryActivity", "postLogin fail, loginResult = " + aVar);
                break;
            case LOGIN_FAIL:
                ReportUtil.a((Context) this, ReportUtil.a(r.T(getIntent()), -1));
                finish();
                v.e("MicroMsg.WXEntryActivity", "postLogin fail, loginResult = " + aVar);
                break;
            default:
                v.e("MicroMsg.WXEntryActivity", "postLogin, unknown login result = " + aVar);
                break;
        }
        finish();
    }

    private static String pu(String str) {
        if (!t.kS(str)) {
            try {
                str = URLEncoder.encode(str);
            } catch (Exception e) {
                v.e("MicroMsg.WXEntryActivity", "urlEncode fail, str = %s, ex = %s", str, e.getMessage());
            }
        }
        return str;
    }

    private boolean g(k kVar) {
        Intent intent = getIntent();
        if ("sendreq".equals(this.authority) || "sendresp".equals(this.authority)) {
            f aC = com.tencent.mm.pluginsdk.model.app.g.aC(this.appId, true);
            if (aC == null) {
                v.w("MicroMsg.WXEntryActivity", "app not reg, do nothing");
                return false;
            } else if (p.b(this, aC, this.tX)) {
                c.a aVar = new c.a(intent.getExtras());
                if (aVar.scene == 2) {
                    Intent intent2 = new Intent();
                    intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(67108864);
                    intent2.putExtras(intent.getExtras());
                    if (aVar.nhM != null && aVar.nhM.getType() == 5) {
                        v.d("MicroMsg.WXEntryActivity", "report(11954), appId : %s", aC.field_appId);
                        String fz = o.fz("app_" + aC.field_appId);
                        o.yx().n(fz, true).l("prePublishId", "app_" + aC.field_appId);
                        intent2.putExtra("reportSessionId", fz);
                    }
                    com.tencent.mm.ay.c.b((Context) this, "favorite", ".ui.FavOpenApiEntry", intent2);
                    return true;
                }
                if (!(kVar == null || aVar.nhM == null || aVar.nhM.getType() != 7)) {
                    bad Jy = ((af) kVar).Jy();
                    if (!(Jy == null || Jy.mWN == null || t.kS(Jy.mWN.url))) {
                        v.i("MicroMsg.WXEntryActivity", "change appextend to Webpage,url :%s", Jy.mWN.url);
                        aVar.nhM.mediaObject = new WXWebpageObject(Jy.mWN.url);
                        Bundle bundle = new Bundle();
                        aVar.t(bundle);
                        intent.putExtras(bundle);
                    }
                }
                startActivity(new Intent(this, UIEntryStub.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(67108864).putExtras(intent.getExtras()));
                return true;
            } else {
                v.e("MicroMsg.WXEntryActivity", "send fail, check app fail, force to get app info from server again : %s", this.appId);
                am.bnA().Gx(this.appId);
                int a = r.a(getIntent().getExtras(), "_wxapi_command_type", 0);
                WQ();
                AutoLoginActivity.a(this, aC, this.tX, a);
                return false;
            }
        }
        v.e("MicroMsg.WXEntryActivity", "unknown authority, should never reached, authority=" + this.authority);
        return false;
    }

    protected final int getLayoutId() {
        return 2130904306;
    }

    private static boolean ip(int i) {
        return i >= 553713665;
    }

    private static byte[] i(String str, int i, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        return com.tencent.mm.a.g.m(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
    }

    private static boolean f(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            v.e("MicroMsg.WXEntryActivity", "checkSumConsistent fail, invalid arguments");
            return false;
        } else if (bArr.length != bArr2.length) {
            v.e("MicroMsg.WXEntryActivity", "checkSumConsistent fail, length is different");
            return false;
        } else {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.WXEntryActivity", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        ak.vy().b(1200, (e) this);
        if (this.dwR != null && this.dwR.isShowing()) {
            this.dwR.dismiss();
        }
        if (i == 0 && i2 == 0) {
            g(kVar);
            finish();
        } else if (com.tencent.mm.ui.o.a.a(this, i, i2, null, 4)) {
            v.i("MicroMsg.WXEntryActivity", "mm error processor process this errcode");
            finish();
        } else {
            findViewById(2131758995).setVisibility(0);
            vD(2131235298);
            TextView textView = (TextView) findViewById(2131758996);
            if (!t.kS(str)) {
                if (str.startsWith("autoauth_errmsg_")) {
                    str = str.substring(16);
                }
                if (str.startsWith("<e>")) {
                    Map q = bf.q(str, "e");
                    if (!(q == null || t.kS((String) q.get(".e.Content")))) {
                        str = (String) q.get(".e.Content");
                    }
                }
                textView.setText(getString(2131235299, new Object[]{str}));
            }
            Button button = (Button) findViewById(2131758997);
            String n = com.tencent.mm.pluginsdk.model.app.g.n(this, this.appId);
            v.i("MicroMsg.WXEntryActivity", "appName = %s", n);
            if (t.kS(n)) {
                button.setText(2131235296);
            } else {
                button.setText(getString(2131235296) + n);
            }
            button.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WXEntryActivity enM;

                {
                    this.enM = r1;
                }

                public final void onClick(View view) {
                    this.enM.WQ();
                    this.enM.finish();
                }
            });
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0 || keyEvent.getKeyCode() != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        v.i("MicroMsg.WXEntryActivity", "user click back button");
        goBack();
        return true;
    }

    private void goBack() {
        View findViewById = findViewById(2131758995);
        if (findViewById == null || findViewById.getVisibility() == 8) {
            WP();
        } else {
            WQ();
        }
    }

    private void WP() {
        ReportUtil.a((Context) this, ReportUtil.a(r.T(getIntent()), -2));
        finish();
    }

    private void WQ() {
        ReportUtil.a((Context) this, ReportUtil.a(r.T(getIntent()), -6));
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(1200, (e) this);
    }
}
