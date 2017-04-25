package com.tencent.mm.plugin.qmessage.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.aw.a;
import com.tencent.mm.model.m;
import com.tencent.mm.model.n;
import com.tencent.mm.plugin.qmessage.a.c;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.protocal.c.wp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.j;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import junit.framework.Assert;

public class QConversationUI extends MMActivity implements e {
    private TextView euo;
    private d eus = new d(this) {
        final /* synthetic */ QConversationUI iah;

        {
            this.iah = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            QConversationUI.a(this.iah, this.iah.iag);
        }
    };
    private boolean eut = false;
    private u fnD;
    private ListView hZZ;
    private boolean hkl = false;
    private c iaa;
    private c iab;
    private boolean iac = false;
    private String iad;
    private String iae;
    private boolean iaf = false;
    private String iag;

    static /* synthetic */ void a(QConversationUI qConversationUI, int i) {
        if (i <= 0) {
            qConversationUI.euo.setVisibility(0);
            qConversationUI.hZZ.setVisibility(8);
            return;
        }
        qConversationUI.euo.setVisibility(8);
        qConversationUI.hZZ.setVisibility(0);
    }

    static /* synthetic */ void a(QConversationUI qConversationUI, final String str) {
        ak.yW();
        at MH = com.tencent.mm.model.c.wJ().MH(str);
        ak.yW();
        com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.d(str, MH.field_msgSvrId));
        qConversationUI.eut = false;
        qConversationUI.getString(2131231164);
        final p a = g.a(qConversationUI, qConversationUI.getString(2131231182), true, new OnCancelListener(qConversationUI) {
            final /* synthetic */ QConversationUI iah;

            {
                this.iah = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.iah.eut = true;
            }
        });
        aw.a(str, new a(qConversationUI) {
            final /* synthetic */ QConversationUI iah;

            public final boolean zp() {
                return this.iah.eut;
            }

            public final void zo() {
                ak.yW();
                com.tencent.mm.model.c.wK().Mf(str);
                if (a != null) {
                    a.dismiss();
                }
            }
        });
    }

    static /* synthetic */ void a(QConversationUI qConversationUI, String str, String str2) {
        if (str == null) {
            v.d("MicroMsg.QConversationUI", "jacks open QQ appId == null");
            return;
        }
        f aC = com.tencent.mm.pluginsdk.model.app.g.aC(str, true);
        if (aC == null || !com.tencent.mm.pluginsdk.model.app.p.o(qConversationUI.nDR.nEl, aC.field_packageName)) {
            if (be.kS(str2)) {
                str2 = com.tencent.mm.pluginsdk.model.app.p.t(qConversationUI.nDR.nEl, str, "message");
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            com.tencent.mm.ay.c.b(qConversationUI.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
        } else if (aC.field_status == 3) {
            v.e("MicroMsg.QConversationUI", "requestAppShow fail, app is in blacklist, packageName = " + aC.field_packageName);
        } else if (com.tencent.mm.pluginsdk.model.app.p.b(qConversationUI.nDR.nEl, aC)) {
            v.d("MicroMsg.QConversationUI", "jacks open QQ");
            Intent intent2 = new Intent("android.intent.action.MAIN", null);
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.addFlags(268435456);
            intent2.setClassName(aC.field_packageName, al(qConversationUI.nDR.nEl, aC.field_packageName));
            intent2.putExtra("platformId", "wechat");
            ak.yW();
            Object obj = com.tencent.mm.model.c.vf().get(9, null);
            int intValue = (obj == null || !(obj instanceof Integer)) ? 0 : ((Integer) obj).intValue();
            if (intValue != 0) {
                try {
                    byte[] bytes = String.valueOf(intValue).getBytes(ProtocolPackage.ServerEncoding);
                    byte[] bytes2 = "asdfghjkl;'".getBytes(ProtocolPackage.ServerEncoding);
                    int length = bytes2.length;
                    intValue = 0;
                    int i = 0;
                    while (intValue < length) {
                        byte b = bytes2[intValue];
                        if (i >= bytes.length) {
                            break;
                        }
                        int i2 = i + 1;
                        bytes[i] = (byte) (b ^ bytes[i]);
                        intValue++;
                        i = i2;
                    }
                    intent2.putExtra("tencent_gif", bytes);
                } catch (Throwable e) {
                    v.a("MicroMsg.QConversationUI", e, "", new Object[0]);
                }
            }
            try {
                qConversationUI.startActivity(intent2);
            } catch (Exception e2) {
            }
        } else {
            v.e("MicroMsg.QConversationUI", "The app %s signature is incorrect.", new Object[]{aC.field_appName});
            Toast.makeText(qConversationUI.nDR.nEl, qConversationUI.getString(2131233088, new Object[]{com.tencent.mm.pluginsdk.model.app.g.a(qConversationUI.nDR.nEl, aC, null)}), 1).show();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected final int getLayoutId() {
        return 2130904546;
    }

    public void onDestroy() {
        this.iaa.avc();
        if (this.iab != null) {
            ak.vy().c(this.iab);
            ak.vy().b(this.iab.getType(), this);
            this.iab = null;
        }
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        aHo();
        ak.yW();
        com.tencent.mm.model.c.wK().a(this.iaa);
        this.iaa.a(null, null);
    }

    private static void aHo() {
        ak.yW();
        at vh = com.tencent.mm.model.c.wJ().vh(2);
        if (vh != null && vh.field_msgId > 0) {
            v.d("MicroMsg.QConversationUI", "resetUnread: lastReadTime = " + vh.field_createTime);
            ak.yW();
            com.tencent.mm.model.c.vf().set(12295, Long.valueOf(vh.field_createTime));
        }
        ak.yW();
        ab Mh = com.tencent.mm.model.c.wK().Mh("qmessage");
        if (Mh == null || be.ma(Mh.field_username).length() <= 0) {
            v.e("MicroMsg.QConversationUI", "resetUnread: can not find QMessage");
            return;
        }
        Mh.df(0);
        ak.yW();
        if (com.tencent.mm.model.c.wK().a(Mh, Mh.field_username, true) == -1) {
            v.e("MicroMsg.QConversationUI", "reset qmessage unread failed");
        }
    }

    public void onPause() {
        v.v("MicroMsg.QConversationUI", "on pause");
        ak.yW();
        com.tencent.mm.model.c.wK().b(this.iaa);
        aHo();
        this.iaa.onPause();
        super.onPause();
    }

    protected final void NI() {
        this.hkl = getIntent().getBooleanExtra("finish_direct", false);
        v.d("MicroMsg.QConversationUI", "isFromSearch  " + this.hkl);
        ak.yW();
        this.fnD = com.tencent.mm.model.c.wH().LX("qmessage");
        String str = "can not find qmessage";
        boolean z = this.fnD != null && ((int) this.fnD.chr) > 0;
        Assert.assertTrue(str, z);
        this.hZZ = (ListView) findViewById(2131756759);
        this.euo = (TextView) findViewById(2131756760);
        this.euo.setText(2131232447);
        this.iaa = new c(this, new j.a(this) {
            final /* synthetic */ QConversationUI iah;

            {
                this.iah = r1;
            }

            public final void Oi() {
                QConversationUI qConversationUI = this.iah;
                String tT = this.iah.fnD.tT();
                int fv = n.fv(m.crC);
                if (fv <= 0) {
                    qConversationUI.Fd(tT);
                } else {
                    qConversationUI.Fd(tT + "(" + fv + ")");
                }
                QConversationUI.a(this.iah, this.iah.iaa.getCount());
            }

            public final void Oj() {
            }
        });
        this.iaa.a(new MMSlideDelView.c(this) {
            final /* synthetic */ QConversationUI iah;

            {
                this.iah = r1;
            }

            public final int bN(View view) {
                return this.iah.hZZ.getPositionForView(view);
            }
        });
        this.iaa.a(new MMSlideDelView.f(this) {
            final /* synthetic */ QConversationUI iah;

            {
                this.iah = r1;
            }

            public final void p(View view, int i) {
                this.iah.hZZ.performItemClick(view, i, 0);
            }
        });
        this.iaa.a(new MMSlideDelView.e(this) {
            final /* synthetic */ QConversationUI iah;

            {
                this.iah = r1;
            }

            public final void aE(Object obj) {
                if (obj == null) {
                    v.e("MicroMsg.QConversationUI", "onItemDel object null");
                } else {
                    QConversationUI.a(this.iah, obj.toString());
                }
            }
        });
        this.hZZ.setAdapter(this.iaa);
        this.hZZ.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ QConversationUI iah;

            {
                this.iah = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ab abVar = (ab) this.iah.iaa.getItem(i);
                Intent intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", abVar.field_username);
                intent.putExtra("key_need_send_video", false);
                com.tencent.mm.plugin.qmessage.a.drp.e(intent, this.iah.nDR.nEl);
            }
        });
        final l lVar = new l(this);
        this.hZZ.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ QConversationUI iah;

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < this.iah.hZZ.getHeaderViewsCount()) {
                    v.w("MicroMsg.QConversationUI", "on header view long click, ignore");
                } else {
                    lVar.a(view, i, j, this.iah, this.iah.eus);
                }
                return true;
            }
        });
        com.tencent.mm.plugin.qmessage.a.hZE.cH(1010);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ QConversationUI iah;

            {
                this.iah = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iah.goBack();
                return true;
            }
        });
        AnonymousClass12 anonymousClass12 = new OnClickListener(this) {
            final /* synthetic */ QConversationUI iah;

            {
                this.iah = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.iah.hZZ);
            }
        };
        ak.yW();
        this.iad = (String) com.tencent.mm.model.c.vf().get(77, "");
        ak.yW();
        this.iae = (String) com.tencent.mm.model.c.vf().get(78, "");
        if (this.iab == null) {
            this.iab = new c();
            ak.vy().a(this.iab.getType(), this);
        }
        ak.vy().a(this.iab, 0);
        aHp();
        com.tencent.mm.plugin.qmessage.a.hZE.cH(1010);
    }

    private static String al(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                return resolveInfo.activityInfo.name;
            }
        } catch (Throwable e) {
            v.a("MicroMsg.QConversationUI", e, "", new Object[0]);
        }
        return null;
    }

    private void aHp() {
        this.nDR.bAi();
        if (!be.kS(this.iad)) {
            this.iac = true;
            a(0, 2131230794, 2131165851, new OnMenuItemClickListener(this) {
                final /* synthetic */ QConversationUI iah;

                {
                    this.iah = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    if (!be.kS(this.iah.iad)) {
                        QConversationUI.a(this.iah, this.iah.iad, this.iah.iae);
                    }
                    return true;
                }
            });
        }
        a(2, 2131230797, 2131165208, new OnMenuItemClickListener(this) {
            final /* synthetic */ QConversationUI iah;

            {
                this.iah = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", this.iah.fnD.field_username);
                intent.putExtra("Chat_Readonly", true);
                com.tencent.mm.plugin.qmessage.a.drp.d(intent, this.iah.nDR.nEl);
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        if (this.hkl) {
            finish();
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        com.tencent.mm.plugin.qmessage.a.drp.t(intent, this);
        overridePendingTransition(2130968589, 2130968642);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        ab abVar = (ab) this.iaa.getItem(((AdapterContextMenuInfo) contextMenuInfo).position);
        ak.yW();
        contextMenu.setHeaderTitle(com.tencent.mm.model.c.wH().LX(abVar.field_username).tU());
        contextMenu.add(0, 0, 0, 2131233710);
        this.iag = abVar.field_username;
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = null;
        v.d("MicroMsg.QConversationUI", "on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (kVar.getType()) {
            case 630:
                if (i == 0 && i2 == 0) {
                    wp wpVar;
                    Object obj;
                    String str3;
                    c cVar = (c) kVar;
                    if (cVar.dcy != null) {
                        wpVar = (wp) cVar.dcy.czl.czs;
                        if (wpVar != null) {
                            obj = wpVar.myT;
                            if (cVar.dcy != null) {
                                wpVar = (wp) cVar.dcy.czl.czs;
                                if (wpVar != null) {
                                    str3 = wpVar.mhw;
                                    if (cVar.dcy != null) {
                                        wpVar = (wp) cVar.dcy.czl.czs;
                                        if (wpVar != null) {
                                            str2 = wpVar.myU;
                                        }
                                    }
                                    if (!be.kS(str2)) {
                                        this.iad = str2;
                                        ak.yW();
                                        com.tencent.mm.model.c.vf().set(77, str2);
                                    }
                                    this.iae = str3;
                                    ak.yW();
                                    com.tencent.mm.model.c.vf().set(78, str3);
                                    if (!this.iac) {
                                        aHp();
                                    }
                                    v.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", new Object[]{obj, str3, str2});
                                    return;
                                }
                            }
                            str3 = null;
                            if (cVar.dcy != null) {
                                wpVar = (wp) cVar.dcy.czl.czs;
                                if (wpVar != null) {
                                    str2 = wpVar.myU;
                                }
                            }
                            if (be.kS(str2)) {
                                this.iad = str2;
                                ak.yW();
                                com.tencent.mm.model.c.vf().set(77, str2);
                            }
                            this.iae = str3;
                            ak.yW();
                            com.tencent.mm.model.c.vf().set(78, str3);
                            if (this.iac) {
                                aHp();
                            }
                            v.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", new Object[]{obj, str3, str2});
                            return;
                        }
                    }
                    String str4 = null;
                    if (cVar.dcy != null) {
                        wpVar = (wp) cVar.dcy.czl.czs;
                        if (wpVar != null) {
                            str3 = wpVar.mhw;
                            if (cVar.dcy != null) {
                                wpVar = (wp) cVar.dcy.czl.czs;
                                if (wpVar != null) {
                                    str2 = wpVar.myU;
                                }
                            }
                            if (be.kS(str2)) {
                                this.iad = str2;
                                ak.yW();
                                com.tencent.mm.model.c.vf().set(77, str2);
                            }
                            this.iae = str3;
                            ak.yW();
                            com.tencent.mm.model.c.vf().set(78, str3);
                            if (this.iac) {
                                aHp();
                            }
                            v.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", new Object[]{obj, str3, str2});
                            return;
                        }
                    }
                    str3 = null;
                    if (cVar.dcy != null) {
                        wpVar = (wp) cVar.dcy.czl.czs;
                        if (wpVar != null) {
                            str2 = wpVar.myU;
                        }
                    }
                    if (be.kS(str2)) {
                        this.iad = str2;
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(77, str2);
                    }
                    this.iae = str3;
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(78, str3);
                    if (this.iac) {
                        aHp();
                    }
                    v.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", new Object[]{obj, str3, str2});
                    return;
                }
                return;
            default:
                return;
        }
    }
}
