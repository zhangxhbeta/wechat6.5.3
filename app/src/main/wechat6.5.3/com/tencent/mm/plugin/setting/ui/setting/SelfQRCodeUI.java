package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.FileObserver;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.am.b;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.f;
import com.tencent.mm.v.e;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class SelfQRCodeUI extends MMActivity implements e {
    private static final String iKd = (h.getExternalStorageDirectory().toString() + "/Pictures/Screenshots/");
    private Bitmap cxY = null;
    private ProgressDialog dwR = null;
    private ImageView eZn = null;
    private TextView iJZ = null;
    private ImageView iJz = null;
    private TextView iKa = null;
    private long iKb;
    private a iKc;
    String userName = "";

    public class a extends FileObserver {
        final /* synthetic */ SelfQRCodeUI iKe;
        private MMActivity iKf;
        private String iKg;

        public a(SelfQRCodeUI selfQRCodeUI, MMActivity mMActivity) {
            this.iKe = selfQRCodeUI;
            super(SelfQRCodeUI.iKd, 8);
            this.iKf = mMActivity;
        }

        public final void onEvent(int i, String str) {
            if (str != null && i == 8) {
                if (this.iKg == null || !str.equalsIgnoreCase(this.iKg)) {
                    this.iKg = str;
                    Uri.fromFile(new File(SelfQRCodeUI.iKd + str));
                    SelfQRCodeUI.aMT();
                    v.i("MicroMsg.SelfQRCodeNewUI$ScreenshotObserver", "Send event to listener.");
                }
            }
        }

        public final void start() {
            super.startWatching();
        }

        public final void stop() {
            super.stopWatching();
        }
    }

    static /* synthetic */ boolean c(SelfQRCodeUI selfQRCodeUI) {
        ak.yW();
        boolean z = be.f((Integer) c.vf().get(9, null)) != 0;
        List arrayList = new ArrayList();
        if (z) {
            arrayList.add(selfQRCodeUI.getString(2131234896));
        }
        if (!"zh_CN".equals(u.d(selfQRCodeUI.getSharedPreferences(aa.bti(), 0)))) {
            arrayList.add(selfQRCodeUI.getString(2131234895));
        }
        return arrayList.size() > 0;
    }

    protected final int getLayoutId() {
        return 2130904342;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iKc = new a(this, this);
        this.iKc.start();
        ak.vy().a(158, this);
        ak.vy().a(168, this);
        NI();
    }

    public void onDestroy() {
        ak.vy().b(168, this);
        ak.vy().b(158, this);
        if (this.iKc != null) {
            this.iKc.stop();
        }
        if (!(this.cxY == null || this.cxY.isRecycled())) {
            this.cxY.recycle();
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        aMR();
    }

    protected final void NI() {
        this.userName = getIntent().getStringExtra("from_userName");
        if (be.kS(this.userName)) {
            this.userName = k.xF();
        }
        if (m.dE(this.userName)) {
            vD(2131235127);
            ((TextView) findViewById(2131755313)).setText("");
            iT(false);
        } else if (com.tencent.mm.modelbiz.e.hB(this.userName)) {
            vD(2131232472);
            ((TextView) findViewById(2131755313)).setText(2131232473);
            iT(false);
        } else {
            vD(2131235115);
        }
        this.iJz = (ImageView) findViewById(2131755310);
        this.eZn = (ImageView) findViewById(2131755306);
        this.iJZ = (TextView) findViewById(2131755308);
        this.iKa = (TextView) findViewById(2131755309);
        aMR();
        CharSequence charSequence;
        if (!m.dE(this.userName) && !com.tencent.mm.modelbiz.e.hB(this.userName)) {
            ak.yW();
            String str = (String) c.vf().get(42, null);
            String string = getString(2131231058);
            if (be.kS(str)) {
                ak.yW();
                str = (String) c.vf().get(2, null);
                string = string + str;
                com.tencent.mm.storage.u.LL(str);
                str = string;
            } else {
                str = string + str;
            }
            v.d("MicroMsg.SelfQRCodeNewUI", "display user name = %s", new Object[]{str});
            this.cxY = b.HU();
            if (this.cxY == null) {
                v.d("MicroMsg.SelfQRCodeNewUI", "%s", new Object[]{"bitmap == null"});
                zn(this.userName);
            } else {
                this.iJz.setImageBitmap(this.cxY);
            }
            com.tencent.mm.pluginsdk.ui.a.b.m(this.eZn, k.xF());
            ak.yW();
            v.d("MicroMsg.SelfQRCodeNewUI", "nick name = %s", new Object[]{(String) c.vf().get(4, null)});
            this.iJZ.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this, str, com.tencent.mm.bd.a.N(this.nDR.nEl, 2131493128)));
            bf zO = bf.zO();
            string = be.ma(zO.getProvince());
            v.d("MicroMsg.SelfQRCodeNewUI", "display location = %s", new Object[]{l.eu(string) + " " + be.ma(zO.getCity())});
            this.iKa.setText(charSequence);
            ak.yW();
            switch (be.a((Integer) c.vf().get(12290, null), 0)) {
                case 1:
                    this.iJZ.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bd.a.a(this, 2131165606), null);
                    break;
                case 2:
                    this.iJZ.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bd.a.a(this, 2131165605), null);
                    break;
                default:
                    break;
            }
        }
        if (this.cxY == null) {
            v.d("MicroMsg.SelfQRCodeNewUI", "%s", new Object[]{"bitmap == null"});
            aP(this.userName, 0);
        } else {
            this.iJz.setImageBitmap(this.cxY);
        }
        com.tencent.mm.pluginsdk.ui.a.b.m(this.eZn, this.userName);
        ak.yW();
        com.tencent.mm.storage.u LX = c.wH().LX(this.userName);
        this.iJZ.setSingleLine(false);
        this.iJZ.setMaxLines(3);
        this.iJZ.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        if (LX != null) {
            charSequence = LX.field_nickname;
            if (be.kS(charSequence)) {
                charSequence = ak.yW().wO().LD(this.userName).field_displayname;
            }
            this.iJZ.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this, charSequence, this.iJZ.getTextSize()));
        } else {
            this.iJZ.setVisibility(8);
        }
        this.iKa.setVisibility(8);
        this.iJz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SelfQRCodeUI iKe;

            {
                this.iKe = r1;
            }

            public final void onClick(View view) {
                if (!m.dE(this.iKe.userName) && !com.tencent.mm.modelbiz.e.hB(this.iKe.userName) && (this.iKe.iKb & 2) == 0) {
                    this.iKe.aMS();
                }
            }
        });
        a(0, 2130838681, new OnMenuItemClickListener(this) {
            final /* synthetic */ SelfQRCodeUI iKe;

            {
                this.iKe = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                SelfQRCodeUI selfQRCodeUI = this.iKe;
                f fVar = new f(selfQRCodeUI, f.pbS, false);
                fVar.jXn = new n.c(selfQRCodeUI) {
                    final /* synthetic */ SelfQRCodeUI iKe;

                    {
                        this.iKe = r1;
                    }

                    public final void a(com.tencent.mm.ui.base.l lVar) {
                        boolean dE = m.dE(this.iKe.userName);
                        boolean hB = com.tencent.mm.modelbiz.e.hB(this.iKe.userName);
                        if (dE) {
                            lVar.dg(2, 2131234636);
                        } else if (!hB) {
                            if (SelfQRCodeUI.c(this.iKe)) {
                                lVar.dg(2, 2131234884);
                            }
                            lVar.dg(3, 2131234879);
                        }
                        lVar.dg(1, 2131234883);
                        if (!hB) {
                            lVar.dg(4, 2131234898);
                        }
                    }
                };
                fVar.jXo = new d(selfQRCodeUI) {
                    final /* synthetic */ SelfQRCodeUI iKe;

                    {
                        this.iKe = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        FileOutputStream fileOutputStream;
                        Throwable e;
                        switch (menuItem.getItemId()) {
                            case 1:
                                byte[] toByteArray;
                                SelfQRCodeUI selfQRCodeUI = this.iKe;
                                if (m.dE(selfQRCodeUI.userName) || com.tencent.mm.modelbiz.e.hB(selfQRCodeUI.userName)) {
                                    g.iuh.a(219, 10, 1, true);
                                    Bitmap cv = com.tencent.mm.sdk.platformtools.d.cv(selfQRCodeUI.findViewById(2131759056));
                                    if (cv != null) {
                                        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                        cv.compress(CompressFormat.PNG, 90, byteArrayOutputStream);
                                        toByteArray = byteArrayOutputStream.toByteArray();
                                    } else {
                                        toByteArray = null;
                                    }
                                    if (toByteArray == null) {
                                        toByteArray = b.jv(selfQRCodeUI.userName);
                                    }
                                } else {
                                    String xF = k.xF();
                                    ak.yW();
                                    be.f((Integer) c.vf().get(66561, null));
                                    toByteArray = b.jv(xF);
                                }
                                if (toByteArray != null && toByteArray.length > 0) {
                                    String str = com.tencent.mm.pluginsdk.ui.tools.l.bqT() + "mmqrcode" + System.currentTimeMillis() + ".png";
                                    try {
                                        fileOutputStream = new FileOutputStream(str);
                                        try {
                                            fileOutputStream.write(toByteArray);
                                            Toast.makeText(selfQRCodeUI, selfQRCodeUI.getString(2131232244, new Object[]{com.tencent.mm.pluginsdk.ui.tools.l.bqT()}), 1).show();
                                            com.tencent.mm.pluginsdk.ui.tools.l.c(str, selfQRCodeUI);
                                            try {
                                                fileOutputStream.close();
                                                return;
                                            } catch (Exception e2) {
                                                return;
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            try {
                                                v.a("MicroMsg.SelfQRCodeNewUI", e, "", new Object[0]);
                                                if (fileOutputStream != null) {
                                                    try {
                                                        fileOutputStream.close();
                                                        return;
                                                    } catch (Exception e4) {
                                                        return;
                                                    }
                                                }
                                                return;
                                            } catch (Throwable th) {
                                                e = th;
                                                if (fileOutputStream != null) {
                                                    try {
                                                        fileOutputStream.close();
                                                    } catch (Exception e5) {
                                                    }
                                                }
                                                throw e;
                                            }
                                        }
                                    } catch (Exception e6) {
                                        e = e6;
                                        fileOutputStream = null;
                                        v.a("MicroMsg.SelfQRCodeNewUI", e, "", new Object[0]);
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                            return;
                                        }
                                        return;
                                    } catch (Throwable th2) {
                                        e = th2;
                                        fileOutputStream = null;
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        throw e;
                                    }
                                }
                                return;
                            case 2:
                                if (m.dE(this.iKe.userName) || com.tencent.mm.modelbiz.e.hB(this.iKe.userName)) {
                                    com.tencent.mm.ay.c.b(this.iKe, "qqmail", ".ui.RoomInfoShareQrUI", new Intent().putExtra("from_userName", this.iKe.userName).putExtra("qrcode_file_path", b.ju(this.iKe.userName)));
                                    return;
                                }
                                this.iKe.aMS();
                                return;
                            case 3:
                                this.iKe.zn(this.iKe.userName);
                                return;
                            case 4:
                                if (!com.tencent.mm.as.u.bi(this.iKe.nDR.nEl) && !com.tencent.mm.ah.a.aT(this.iKe.nDR.nEl)) {
                                    com.tencent.mm.ay.c.w(this.iKe.nDR.nEl, "scanner", ".ui.BaseScanUI");
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                };
                fVar.bKh();
                return true;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SelfQRCodeUI iKe;

            {
                this.iKe = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iKe.axg();
                this.iKe.finish();
                return true;
            }
        });
    }

    private void aMR() {
        View findViewById = findViewById(2131755311);
        this.iKb = k.xK();
        v.d("MicroMsg.SelfQRCodeNewUI", (this.iKb & 2) + ",extstatus:" + this.iKb);
        if ((this.iKb & 2) != 0) {
            findViewById.setVisibility(0);
            this.iJz.setAlpha(0.1f);
            findViewById(2131755312).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SelfQRCodeUI iKe;

                {
                    this.iKe = r1;
                }

                public final void onClick(View view) {
                    com.tencent.mm.ay.c.w(this.iKe, "setting", ".ui.setting.SettingsAddMeUI");
                }
            });
            return;
        }
        findViewById.setVisibility(8);
        this.iJz.setAlpha(1.0f);
    }

    private void aP(final String str, int i) {
        final com.tencent.mm.am.a aVar = new com.tencent.mm.am.a(str, i);
        ak.vy().a(aVar, 0);
        ActionBarActivity actionBarActivity = this.nDR.nEl;
        getString(2131231164);
        this.dwR = com.tencent.mm.ui.base.g.a(actionBarActivity, getString(2131234882), true, new OnCancelListener(this) {
            final /* synthetic */ SelfQRCodeUI iKe;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(aVar);
                if (m.dE(str) || com.tencent.mm.modelbiz.e.hB(str)) {
                    this.iKe.finish();
                }
            }
        });
    }

    final void zn(String str) {
        ak.yW();
        aP(str, be.f((Integer) c.vf().get(66561, null)));
    }

    final void aMS() {
        ak.yW();
        int i = be.f((Integer) c.vf().get(9, null)) != 0 ? 1 : 0;
        List arrayList = new ArrayList();
        if (i != 0) {
            arrayList.add(getString(2131234896));
        }
        if (!"zh_CN".equals(u.d(getSharedPreferences(aa.bti(), 0)))) {
            arrayList.add(getString(2131234895));
        }
        final String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        com.tencent.mm.ui.base.g.a(this, "", strArr, "", new com.tencent.mm.ui.base.g.c(this) {
            final /* synthetic */ SelfQRCodeUI iKe;

            public final void gT(int i) {
                if (i >= 0 && i < strArr.length) {
                    int i2 = -1;
                    if (strArr[i].equals(this.iKe.getString(2131234896))) {
                        i2 = 2;
                    } else if (strArr[i].equals(this.iKe.getString(2131234897))) {
                        i2 = 3;
                    } else if (strArr[i].equals(this.iKe.getString(2131234895))) {
                        i2 = 4;
                    }
                    if (i2 > 0) {
                        Intent intent = new Intent();
                        intent.putExtra("show_to", i2);
                        com.tencent.mm.plugin.setting.a.drp.p(intent, this.iKe);
                    }
                }
            }
        });
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        Bitmap bitmap = null;
        v.i("MicroMsg.SelfQRCodeNewUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (kVar.getType() == 168 && !com.tencent.mm.plugin.setting.a.drq.b(this.nDR.nEl, i, i2, str)) {
            if (i == 0 && i2 == 0) {
                if (m.dE(this.userName) || com.tencent.mm.modelbiz.e.hB(this.userName)) {
                    iT(true);
                    byte[] jv = b.jv(this.userName);
                    if (jv != null) {
                        bitmap = com.tencent.mm.sdk.platformtools.d.bc(jv);
                    }
                    this.cxY = bitmap;
                    TextView textView = (TextView) findViewById(2131755313);
                    CharSequence charSequence = ((com.tencent.mm.am.a) kVar).cUG;
                    if (!(textView == null || be.kS(charSequence))) {
                        textView.setText(charSequence);
                    }
                } else {
                    this.cxY = b.HU();
                }
                this.iJz.setImageBitmap(this.cxY);
                return;
            }
            Toast.makeText(this, getString(2131232922, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }

    public static void aMT() {
        g.iuh.a(219, 14, 1, true);
    }
}
