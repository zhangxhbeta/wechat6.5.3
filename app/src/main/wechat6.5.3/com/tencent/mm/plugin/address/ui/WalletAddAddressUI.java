package com.tencent.mm.plugin.address.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.plugin.address.model.f;
import com.tencent.mm.plugin.address.model.i;
import com.tencent.mm.plugin.address.ui.AddrEditView.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.k;
import com.tencent.mm.v.e;
import java.util.List;

public class WalletAddAddressUI extends MMActivity implements b, e {
    private String blB = "";
    private Dialog dxy = null;
    private int dyg = 0;
    private AddrEditView dyh;
    private AddrEditView dyi;
    private AddrEditView dyj;
    private AddrEditView dyk;
    private AddrEditView dyl;
    private com.tencent.mm.plugin.address.c.b dym = null;
    private com.tencent.mm.plugin.address.c.b dyn = new com.tencent.mm.plugin.address.c.b();

    static /* synthetic */ void o(WalletAddAddressUI walletAddAddressUI) {
        if (walletAddAddressUI.dyg != 0) {
            v.d("MicroMsg.WalletAddAddressUI", "modify save addr " + walletAddAddressUI.dyn.toString());
            a.Oq().Os();
            ak.vy().a(new f(walletAddAddressUI.dyn), 0);
            walletAddAddressUI.dxy = g.a(walletAddAddressUI, "", true, new OnCancelListener(walletAddAddressUI) {
                final /* synthetic */ WalletAddAddressUI dyo;

                {
                    this.dyo = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            return;
        }
        v.d("MicroMsg.WalletAddAddressUI", "add save addr " + walletAddAddressUI.dyn.toString());
        ak.vy().a(new com.tencent.mm.plugin.address.model.a(walletAddAddressUI.dyn), 0);
        walletAddAddressUI.dxy = g.a(walletAddAddressUI, "", true, new OnCancelListener(walletAddAddressUI) {
            final /* synthetic */ WalletAddAddressUI dyo;

            {
                this.dyo = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(415, this);
        ak.vy().a(418, this);
        v.d("MicroMsg.WalletAddAddressUI", "index Oncreate");
        v.uZ(0);
        this.dyg = getIntent().getIntExtra("address_id", 0);
        if (this.dyg == 0) {
            vD(2131230833);
        } else {
            vD(2131230861);
        }
        NI();
    }

    public final void NI() {
        a.Oq().Or();
        MMScrollView mMScrollView = (MMScrollView) findViewById(2131758524);
        mMScrollView.a(mMScrollView, mMScrollView);
        this.dyh = (AddrEditView) findViewById(2131759762);
        this.dyi = (AddrEditView) findViewById(2131759764);
        this.dyj = (AddrEditView) findViewById(2131759765);
        this.dyk = (AddrEditView) findViewById(2131759766);
        this.dyl = (AddrEditView) findViewById(2131759763);
        this.dyh.dxM = this;
        this.dyi.dxM = this;
        this.dyj.dxM = this;
        this.dyk.dxM = this;
        this.dyl.dxM = this;
        this.dyh.dxL = new AddrEditView.a(this) {
            final /* synthetic */ WalletAddAddressUI dyo;

            {
                this.dyo = r1;
            }

            public final void onClick() {
                v.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.dyo, "android.permission.READ_CONTACTS", 48, null, null)), be.bur()});
                if (com.tencent.mm.pluginsdk.i.a.a(this.dyo, "android.permission.READ_CONTACTS", 48, null, null)) {
                    this.dyo.Oz();
                }
            }
        };
        this.dyi.dxL = new AddrEditView.a(this) {
            final /* synthetic */ WalletAddAddressUI dyo;

            {
                this.dyo = r1;
            }

            public final void onClick() {
                v.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.dyo, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null))});
                if (com.tencent.mm.pluginsdk.i.a.a(this.dyo, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                    this.dyo.OA();
                }
            }
        };
        this.dyi.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletAddAddressUI dyo;

            {
                this.dyo = r1;
            }

            public final void onClick(View view) {
                this.dyo.startActivityForResult(new Intent(this.dyo, WalletMultiRcptSelectUI.class), 1);
            }
        });
        if (this.dyg != 0) {
            this.dym = a.Oq().gP(this.dyg);
            this.dyh.mo(this.dym.dxI);
            StringBuilder stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty(this.dym.dxD)) {
                stringBuilder.append(this.dym.dxD);
            }
            if (!TextUtils.isEmpty(this.dym.dxE)) {
                stringBuilder.append(" ");
                stringBuilder.append(this.dym.dxE);
            }
            if (!TextUtils.isEmpty(this.dym.dxF)) {
                stringBuilder.append(" ");
                stringBuilder.append(this.dym.dxF);
            }
            this.dyi.mo(stringBuilder.toString());
            this.dyj.mo(this.dym.dxH);
            this.dyk.mo(this.dym.dxG);
            this.dyl.mo(this.dym.dxJ);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletAddAddressUI dyo;

            {
                this.dyo = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.dyo.Oy();
                return true;
            }
        });
        a(0, getString(2131231146), new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletAddAddressUI dyo;

            {
                this.dyo = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.dyo.Ox()) {
                    if (this.dyo.dyg != 0) {
                        this.dyo.dym = a.Oq().gP(this.dyo.dyg);
                        v.d("MicroMsg.WalletAddAddressUI", "get addr " + this.dyo.dym.toString());
                        WalletAddAddressUI.a(this.dyo.dym, this.dyo.dyn);
                    } else {
                        this.dyo.dym = new com.tencent.mm.plugin.address.c.b();
                    }
                    String text = this.dyo.dyh.getText();
                    String text2 = this.dyo.dyi.getText();
                    String text3 = this.dyo.dyj.getText();
                    String text4 = this.dyo.dyk.getText();
                    String text5 = this.dyo.dyl.getText();
                    String[] split = text2.split(" ");
                    if (split.length > 0) {
                        this.dyo.dyn.dxD = split[0];
                    }
                    if (split.length >= 2) {
                        this.dyo.dyn.dxE = split[1];
                    }
                    if (split.length >= 3) {
                        this.dyo.dyn.dxF = split[2];
                    } else {
                        this.dyo.dyn.dxF = "";
                    }
                    this.dyo.dyn.dxH = text3;
                    this.dyo.dyn.dxI = text;
                    this.dyo.dyn.dxJ = text5;
                    this.dyo.dyn.dxG = text4;
                    if (!be.kS(this.dyo.blB)) {
                        this.dyo.dyn.dxK = this.dyo.blB;
                    }
                    WalletAddAddressUI.o(this.dyo);
                }
                return true;
            }
        }, k.b.nET);
        Ox();
    }

    public void onDestroy() {
        super.onDestroy();
        ak.vy().b(415, this);
        ak.vy().b(418, this);
        i Oq = a.Oq();
        v.i("MicroMsg.WalletAddrMgr", "clean data");
        for (List clear : Oq.dxs.values()) {
            clear.clear();
        }
        for (List clear2 : Oq.dxt.values()) {
            clear2.clear();
        }
        Oq.dxr.clear();
        Oq.dxs.clear();
        Oq.dxt.clear();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str = null;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    str = intent.getStringExtra("karea_result");
                    if (!be.kS(str)) {
                        v.d("MicroMsg.WalletAddAddressUI", "AREA_RESULT:" + str);
                        this.dyi.mo(str);
                    }
                    str = intent.getStringExtra("kpost_code");
                    if (!be.kS(str)) {
                        v.d("MicroMsg.WalletAddAddressUI", "post:" + str);
                        this.dyk.mo(str);
                    }
                    this.blB = intent.getStringExtra("kwcode");
                    return;
                }
                return;
            case 2:
                if (i2 == -1) {
                    Uri data = intent.getData();
                    if (data == null) {
                        v.d("MicroMsg.WalletAddAddressUI", "uri == null");
                        return;
                    }
                    String str2;
                    String[] a = com.tencent.mm.pluginsdk.a.a(getBaseContext(), data);
                    if (a == null || a.length != 2) {
                        g.A(this, getString(2131233801), "");
                        str2 = null;
                    } else {
                        str = a[0];
                        str2 = a[1];
                    }
                    this.dyh.mo(str);
                    this.dyl.mo(str2);
                    if (PhoneNumberUtils.isGlobalPhoneNumber(str2)) {
                        Ox();
                        return;
                    } else {
                        g.A(this, getString(2131233801), "");
                        return;
                    }
                }
                return;
            case 3:
                if (i2 == -1) {
                    Addr addr = (Addr) intent.getParcelableExtra("key_pick_addr");
                    if (addr != null) {
                        v.d("MicroMsg.WalletAddAddressUI", "addr: " + addr.toString());
                        if (addr != null) {
                            StringBuilder stringBuilder;
                            if (a.Oq().s(addr.cJh, addr.cJj, addr.cJk)) {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(addr.cJh);
                                stringBuilder.append(" ");
                                stringBuilder.append(addr.cJj);
                                if (!TextUtils.isEmpty(addr.cJk)) {
                                    stringBuilder.append(" ");
                                    stringBuilder.append(addr.cJk);
                                }
                                this.dyi.mo(stringBuilder.toString());
                            } else {
                                this.dyi.mo("");
                            }
                            stringBuilder = new StringBuilder();
                            if (!TextUtils.isEmpty(addr.cJl)) {
                                stringBuilder.append(addr.cJl);
                            }
                            if (!TextUtils.isEmpty(addr.cJm)) {
                                stringBuilder.append(addr.cJm);
                            }
                            if (!TextUtils.isEmpty(addr.cJn)) {
                                stringBuilder.append(addr.cJn);
                            }
                            if (!TextUtils.isEmpty(addr.cJp)) {
                                stringBuilder.append(" ");
                                stringBuilder.append(addr.cJp);
                            }
                            this.dyj.mo(stringBuilder.toString());
                            RcptItem r = a.Oq().r(addr.cJh, addr.cJj, addr.cJk);
                            if (r != null) {
                                this.dyk.mo(r.dxo);
                                this.blB = r.code;
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                v.i("MicroMsg.WalletAddAddressUI", "MallRecharge pay result : cancel");
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return 2130904602;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (this.dxy != null) {
            this.dxy.dismiss();
        }
        if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.address.c.a aVar = a.Oq().dxq;
            if (aVar.dxB.size() > 0) {
                a(this.dyn, this.dym);
                com.tencent.mm.plugin.address.c.b bVar = (com.tencent.mm.plugin.address.c.b) aVar.dxB.getFirst();
                if (bVar != null) {
                    setResult(-1, com.tencent.mm.plugin.address.d.a.b(bVar));
                } else {
                    setResult(0);
                }
            } else {
                setResult(0);
            }
            finish();
            return;
        }
        switch (i2) {
            case -3104:
            case -3103:
            case -3102:
                g.a(this, str, "", new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WalletAddAddressUI dyo;

                    {
                        this.dyo = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                return;
            case -3100:
                g.a(this, 2131230832, 0, false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WalletAddAddressUI dyo;

                    {
                        this.dyo = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.dyo.finish();
                    }
                });
                return;
            default:
                g.a(this, 2131230830, 0, false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WalletAddAddressUI dyo;

                    {
                        this.dyo = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return;
        }
    }

    private boolean Ox() {
        boolean z = false;
        boolean z2 = true;
        if (!this.dyh.Ou()) {
            z2 = false;
        }
        if (!this.dyj.Ou()) {
            z2 = false;
        }
        if (!this.dyi.Ou()) {
            z2 = false;
        }
        if (!this.dyk.Ou()) {
            z2 = false;
        }
        if (this.dyl.Ou()) {
            z = z2;
        }
        iT(z);
        return z;
    }

    public final void Ow() {
        Ox();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        Oy();
        return true;
    }

    private void Oy() {
        int i;
        int i2 = 1;
        int i3 = 2131230836;
        if (this.dyg == 0) {
            i3 = 2131230835;
        }
        if (this.dyh.Ov()) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.dyj.Ov()) {
            i = 1;
        }
        if (this.dyi.Ov()) {
            i = 1;
        }
        if (this.dyk.Ov()) {
            i = 1;
        }
        if (!this.dyl.Ov()) {
            i2 = i;
        }
        if (i2 != 0) {
            g.a(this, i3, 2131231164, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ WalletAddAddressUI dyo;

                {
                    this.dyo = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.dyo.setResult(0);
                    this.dyo.finish();
                }
            }, null);
            return;
        }
        setResult(0);
        finish();
    }

    private void Oz() {
        startActivityForResult(new Intent("android.intent.action.PICK", Contacts.CONTENT_URI), 2);
    }

    private void OA() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.dyi.getText())) {
            stringBuilder.append(this.dyi.getText());
        }
        if (!TextUtils.isEmpty(this.dyj.getText())) {
            stringBuilder.append(this.dyj.getText());
        }
        Intent intent = new Intent();
        intent.putExtra("wallet_address", stringBuilder.toString());
        intent.putExtra("map_view_type", 8);
        c.b(this, "location", ".ui.RedirectUI", intent, 3);
    }

    private static void a(com.tencent.mm.plugin.address.c.b bVar, com.tencent.mm.plugin.address.c.b bVar2) {
        if (bVar != null && bVar2 != null) {
            bVar2.id = bVar.id;
            bVar2.dxD = bVar.dxD;
            bVar2.dxE = bVar.dxE;
            bVar2.dxF = bVar.dxF;
            bVar2.dxH = bVar.dxH;
            bVar2.dxI = bVar.dxI;
            bVar2.dxJ = bVar.dxJ;
            bVar2.dxG = bVar.dxG;
            bVar2.dxK = bVar.dxK;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.WalletAddAddressUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 48:
                if (iArr[0] == 0) {
                    Oz();
                    return;
                } else {
                    g.a(this, getString(2131234161), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ WalletAddAddressUI dyo;

                        {
                            this.dyo = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.dyo.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ WalletAddAddressUI dyo;

                        {
                            this.dyo = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            case 64:
                if (iArr[0] == 0) {
                    OA();
                    return;
                } else {
                    g.a(this, getString(2131234162), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ WalletAddAddressUI dyo;

                        {
                            this.dyo = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.dyo.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ WalletAddAddressUI dyo;

                        {
                            this.dyo = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }
}
