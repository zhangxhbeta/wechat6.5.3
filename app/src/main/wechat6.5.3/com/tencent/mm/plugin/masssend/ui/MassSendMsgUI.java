package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.af.b;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.mmsight.model.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.tools.SightCaptureResult;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.c.ahn;
import com.tencent.mm.protocal.c.ahy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MassSendMsgUI extends MMActivity implements e {
    private static String hkr = "";
    private p dwg = null;
    private String filePath;
    private ChatFooter hjH;
    private String hjJ;
    private List<String> hjK;
    private boolean hjL = false;
    private TextView hkp;
    private TextView hkq;
    private h hks;
    private b hkt;
    private a hku = new a(this) {
        final /* synthetic */ MassSendMsgUI hkv;

        {
            this.hkv = r1;
        }

        public final void azq() {
            Toast.makeText(this.hkv, this.hkv.getString(2131233825), 0).show();
        }

        public final void azr() {
            Toast.makeText(this.hkv, this.hkv.getString(2131233808), 0).show();
        }

        public final void azs() {
            Toast.makeText(this.hkv, this.hkv.getString(2131233823), 0).show();
        }

        public final void azt() {
            Toast.makeText(this.hkv, this.hkv.getString(2131233817), 0).show();
        }

        public final void azu() {
            Toast.makeText(this.hkv, this.hkv.getString(2131233808), 0).show();
        }

        public final void mS(int i) {
            switch (i) {
                case 0:
                    File file = new File(com.tencent.mm.compatible.util.e.cgg);
                    if (file.exists() || file.mkdir()) {
                        v.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.hkv.nDR.nEl, "android.permission.CAMERA", 16, "", "")), be.bur(), this.hkv.nDR.nEl});
                        if (com.tencent.mm.pluginsdk.i.a.a(this.hkv.nDR.nEl, "android.permission.CAMERA", 16, "", "")) {
                            this.hkv.XQ();
                            return;
                        }
                        return;
                    }
                    Toast.makeText(this.hkv, this.hkv.getString(2131231905), 1).show();
                    return;
                case 1:
                    l.a(this.hkv, 1, 1, 0, 3, false, null);
                    return;
                default:
                    return;
            }
        }

        public final void c(f fVar) {
        }

        public final void azv() {
            com.tencent.mm.plugin.masssend.a.drp.am(this.hkv);
        }

        public final void azw() {
            Toast.makeText(this.hkv, this.hkv.getString(2131233808), 0).show();
        }

        public final void azx() {
        }

        public final void azy() {
            Intent intent = new Intent();
            intent.putExtra("preceding_scence", 13);
            c.b(this.hkv, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
        }

        public final void azz() {
            MassSendMsgUI.d(this.hkv);
        }

        public final void azA() {
            Toast.makeText(this.hkv, this.hkv.getString(2131233818), 0).show();
        }

        public final void azB() {
        }

        public final void azC() {
        }

        public final void azD() {
        }
    };

    static /* synthetic */ void a(MassSendMsgUI massSendMsgUI, String str, int i) {
        com.tencent.mm.plugin.masssend.a.a aVar = new com.tencent.mm.plugin.masssend.a.a();
        aVar.hjq = massSendMsgUI.hjJ;
        aVar.hjr = massSendMsgUI.hjK.size();
        aVar.filename = str;
        aVar.hjs = i;
        aVar.hjv = 2;
        aVar.msgType = 43;
        final com.tencent.mm.plugin.masssend.a.f fVar = new com.tencent.mm.plugin.masssend.a.f(aVar, massSendMsgUI.hjL);
        ak.vy().a(fVar, 0);
        if (massSendMsgUI.dwg != null && massSendMsgUI.dwg.isShowing()) {
            massSendMsgUI.dwg.setOnCancelListener(new OnCancelListener(massSendMsgUI) {
                final /* synthetic */ MassSendMsgUI hkv;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(fVar);
                }
            });
        }
    }

    static /* synthetic */ void d(MassSendMsgUI massSendMsgUI) {
        v.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(massSendMsgUI, "android.permission.CAMERA", 18, "", "")), be.bur(), massSendMsgUI});
        if (com.tencent.mm.pluginsdk.i.a.a(massSendMsgUI, "android.permission.CAMERA", 18, "", "")) {
            v.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(massSendMsgUI, "android.permission.RECORD_AUDIO", 18, "", "")), be.bur(), massSendMsgUI});
            if (com.tencent.mm.pluginsdk.i.a.a(massSendMsgUI, "android.permission.RECORD_AUDIO", 18, "", "")) {
                g.iuh.h(13822, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
                l.a(massSendMsgUI, 8, new Intent(), 1, massSendMsgUI.hjJ, 0);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(193, this);
        this.hjL = getIntent().getBooleanExtra("mass_send_again", false);
        this.hjJ = getIntent().getStringExtra("mass_send_contact_list");
        String str = this.hjJ;
        this.hjK = new ArrayList();
        if (!(str == null || str.equals(""))) {
            String[] split = str.split(";");
            if (split != null && split.length > 0) {
                this.hjK = be.g(split);
            }
        }
        NI();
    }

    protected void onResume() {
        super.onResume();
        if (this.hjH != null) {
            this.hjH.l(hkr, -1, true);
            this.hjH.a(this.nDR.nEl, this);
        }
    }

    public static void wq(String str) {
        hkr = str;
    }

    protected void onDestroy() {
        ak.vy().b(193, this);
        super.onDestroy();
        if (this.hjH != null) {
            this.hjH.destroy();
        }
    }

    protected void onPause() {
        this.hjH.anf();
        this.hjH.onPause();
        super.onPause();
    }

    protected final int getLayoutId() {
        return 2130903957;
    }

    protected final void NI() {
        CharSequence spannableString;
        boolean z = false;
        vD(2131233819);
        this.hkp = (TextView) findViewById(2131758176);
        this.hkq = (TextView) findViewById(2131758175);
        TextView textView = this.hkp;
        int textSize = (int) this.hkp.getTextSize();
        if (this.hjK == null) {
            spannableString = new SpannableString("");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < this.hjK.size(); i++) {
                String er = com.tencent.mm.model.l.er((String) this.hjK.get(i));
                if (i == this.hjK.size() - 1) {
                    stringBuilder.append(er);
                } else {
                    stringBuilder.append(er + ",  ");
                }
            }
            spannableString = com.tencent.mm.pluginsdk.ui.d.e.a(this, stringBuilder.toString(), textSize);
        }
        textView.setText(spannableString);
        this.hkq.setText(getResources().getQuantityString(2131361809, this.hjK.size(), new Object[]{Integer.valueOf(this.hjK.size())}));
        this.hjH = (ChatFooter) findViewById(2131756055);
        ((MassSendLayout) findViewById(2131758174)).eKS = this.hjH.lMo;
        this.hjH.uk(2131758174);
        this.hkt = new b(this, this.hjH, this.hjJ, this.hjK, this.hjL);
        this.hjH.lMu = this.hkt;
        this.hjH.b(new d(this));
        ChatFooter chatFooter = this.hjH;
        ak.yW();
        int intValue = ((Integer) com.tencent.mm.model.c.vf().get(18, Integer.valueOf(-1))).intValue();
        if (intValue == -1) {
            intValue = 1;
        }
        chatFooter.R(intValue, true);
        this.hjH.HH("masssendapp");
        this.hjH.bqd();
        ak.yW();
        if (((Boolean) com.tencent.mm.model.c.vf().get(66832, Boolean.valueOf(false))).booleanValue()) {
            this.hjH.bqb();
            this.hjH.bpY();
        }
        this.hjH.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ MassSendMsgUI hkv;

            {
                this.hkv = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String valueOf = String.valueOf(charSequence);
                final String substring = valueOf.substring(i, i + i3);
                if ((this.hkv.hks == null || !this.hkv.hks.isShowing()) && o.JY(substring)) {
                    Bitmap b = d.b(substring, 300, 300, false);
                    if (b == null) {
                        v.e("MicroMsg.MassSendMsgUI", "showAlert fail, bmp is null");
                        return;
                    }
                    View imageView = new ImageView(this.hkv);
                    imageView.setImageBitmap(b);
                    int dimensionPixelSize = this.hkv.getResources().getDimensionPixelSize(2131493135);
                    imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                    this.hkv.hks = com.tencent.mm.ui.base.g.a(this.hkv, this.hkv.getString(2131231896), imageView, this.hkv.getString(2131231107), this.hkv.getString(2131231010), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass8 hkC;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent();
                            intent.putExtra("CropImage_OutputPath", substring);
                            this.hkC.hkv.B(intent);
                        }
                    }, null);
                    String str = valueOf.substring(0, i) + valueOf.substring(i + i3);
                    this.hkv.hjH.l(str, -1, false);
                    MassSendMsgUI.hkr = str;
                }
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.hjH.bpX();
        this.hjH.bpP();
        this.hjH.bpW();
        this.hjH.bpS();
        this.hjH.bpV();
        this.hjH.ii(true);
        this.hjH.a(this.hku);
        ChatFooter chatFooter2 = this.hjH;
        c.brh();
        if (b.GZ() || (k.xQ() & 33554432) != 0) {
            z = true;
        }
        chatFooter2.ij(z);
        this.hjH.bpR();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MassSendMsgUI hkv;

            {
                this.hkv = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.hkv.finish();
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0 || !this.hjH.bqe()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.hjH.bqg();
        return true;
    }

    private void XQ() {
        if (!l.d(this, com.tencent.mm.compatible.util.e.cgg, "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
            Toast.makeText(this, getString(2131234875), 1).show();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.MassSendMsgUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    XQ();
                    return;
                } else {
                    com.tencent.mm.ui.base.g.a(this, getString(2131234160), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                        final /* synthetic */ MassSendMsgUI hkv;

                        {
                            this.hkv = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.hkv.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }

    private void A(Intent intent) {
        String stringExtra = intent.getStringExtra("VideoRecorder_FileName");
        int intExtra = intent.getIntExtra("VideoRecorder_VideoLength", 0);
        com.tencent.mm.plugin.masssend.a.a aVar = new com.tencent.mm.plugin.masssend.a.a();
        aVar.hjq = this.hjJ;
        aVar.hjr = this.hjK.size();
        aVar.filename = stringExtra;
        aVar.hjs = intExtra;
        aVar.msgType = 43;
        final com.tencent.mm.plugin.masssend.a.f fVar = new com.tencent.mm.plugin.masssend.a.f(aVar, this.hjL);
        ak.vy().a(fVar, 0);
        ActionBarActivity actionBarActivity = this.nDR.nEl;
        getString(2131231164);
        this.dwg = com.tencent.mm.ui.base.g.a(actionBarActivity, getString(2131234922), true, new OnCancelListener(this) {
            final /* synthetic */ MassSendMsgUI hkv;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(fVar);
            }
        });
    }

    private void B(Intent intent) {
        String stringExtra = intent.getStringExtra("CropImage_OutputPath");
        if (stringExtra != null) {
            int i = k.a(stringExtra, null, intent.getBooleanExtra("CropImage_Compress_Img", true)) ? 1 : 0;
            com.tencent.mm.plugin.masssend.a.h.azf();
            com.tencent.mm.plugin.masssend.a.a f = com.tencent.mm.plugin.masssend.a.b.f(stringExtra, this.hjJ, this.hjK.size(), i);
            if (f != null) {
                final com.tencent.mm.plugin.masssend.a.f fVar = new com.tencent.mm.plugin.masssend.a.f(f, this.hjL, i);
                ak.vy().a(fVar, 0);
                ActionBarActivity actionBarActivity = this.nDR.nEl;
                getString(2131231164);
                this.dwg = com.tencent.mm.ui.base.g.a(actionBarActivity, getString(2131234922), true, new OnCancelListener(this) {
                    final /* synthetic */ MassSendMsgUI hkv;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(fVar);
                    }
                });
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.MassSendMsgUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent == null) {
                        return;
                    }
                    if (intent.getBooleanExtra("is_video", false)) {
                        String stringExtra = intent.getStringExtra("video_full_path");
                        Intent intent2 = new Intent();
                        intent2.setData(Uri.parse("file://" + stringExtra));
                        C(intent2);
                        return;
                    }
                    Intent intent3 = new Intent();
                    intent3.putExtra("CropImageMode", 4);
                    intent3.putExtra("CropImage_Filter", true);
                    com.tencent.mm.pluginsdk.h hVar = com.tencent.mm.plugin.masssend.a.drp;
                    ak.yW();
                    hVar.a(this, intent, intent3, com.tencent.mm.model.c.wP(), 4, null);
                    return;
                case 2:
                    Context applicationContext = getApplicationContext();
                    ak.yW();
                    this.filePath = l.a(applicationContext, intent, com.tencent.mm.model.c.wP());
                    if (this.filePath != null) {
                        Intent intent4 = new Intent();
                        intent4.putExtra("CropImageMode", 4);
                        intent4.putExtra("CropImage_Filter", true);
                        intent4.putExtra("CropImage_ImgPath", this.filePath);
                        com.tencent.mm.plugin.masssend.a.drp.a(this.nDR.nEl, intent4, 4);
                        return;
                    }
                    return;
                case 4:
                    B(intent);
                    return;
                case 5:
                    A(intent);
                    return;
                case 6:
                    C(intent);
                    return;
                case 7:
                    if (intent == null) {
                        return;
                    }
                    if (intent.getBooleanExtra("from_record", false)) {
                        A(intent);
                        return;
                    } else {
                        C(intent);
                        return;
                    }
                case 8:
                    SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        return;
                    }
                    String str;
                    if (sightCaptureResult.lTX) {
                        str = sightCaptureResult.lUf;
                        if (!be.kS(str)) {
                            try {
                                boolean z = sightCaptureResult.lTY;
                                v.i("MicroMsg.MassSendMsgUI", "doSendChattingImage, path: %s", new Object[]{str});
                                com.tencent.mm.plugin.masssend.a.h.azf();
                                com.tencent.mm.plugin.masssend.a.a f = com.tencent.mm.plugin.masssend.a.b.f(str, this.hjJ, this.hjK.size(), 0);
                                if (f != null) {
                                    final com.tencent.mm.plugin.masssend.a.f fVar = new com.tencent.mm.plugin.masssend.a.f(f, this.hjL, 0);
                                    ak.vy().a(fVar, 0);
                                    ActionBarActivity actionBarActivity = this.nDR.nEl;
                                    getString(2131231164);
                                    this.dwg = com.tencent.mm.ui.base.g.a(actionBarActivity, getString(2131234922), true, new OnCancelListener(this) {
                                        final /* synthetic */ MassSendMsgUI hkv;

                                        public final void onCancel(DialogInterface dialogInterface) {
                                            ak.vy().c(fVar);
                                        }
                                    });
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                v.e("MicroMsg.MassSendMsgUI", "doSendChattingImage error: %s", new Object[]{e.getMessage()});
                                return;
                            }
                        }
                        return;
                    }
                    v.i("MicroMsg.MassSendMsgUI", "video path %s thumb path ", new Object[]{sightCaptureResult.lTZ, sightCaptureResult.lUa});
                    com.tencent.mm.as.k.KV();
                    str = com.tencent.mm.as.o.lc(sightCaptureResult.lUb);
                    if (!sightCaptureResult.lTZ.equals(str)) {
                        v.i("MicroMsg.MassSendMsgUI", "filepath not videopath and move it %s %s", new Object[]{sightCaptureResult.lTZ, str});
                        FileOp.ab(sightCaptureResult.lTZ, str);
                    }
                    str = sightCaptureResult.lUb;
                    final int i3 = sightCaptureResult.lUd;
                    final com.tencent.mm.as.a aVar = new com.tencent.mm.as.a();
                    getString(2131231164);
                    this.dwg = com.tencent.mm.ui.base.g.a(this, getString(2131231182), true, new OnCancelListener(this) {
                        final /* synthetic */ MassSendMsgUI hkv;

                        public final void onCancel(DialogInterface dialogInterface) {
                            aVar.dgj = null;
                        }
                    });
                    com.tencent.mm.sdk.i.e.a(new Runnable(this) {
                        final /* synthetic */ MassSendMsgUI hkv;

                        public final void run() {
                            VideoTransPara Ej = com.tencent.mm.modelcontrol.d.En().Ej();
                            ahn com_tencent_mm_protocal_c_ahn = new ahn();
                            com_tencent_mm_protocal_c_ahn.mHd = true;
                            if (i.a(str, Ej, com_tencent_mm_protocal_c_ahn, new com.tencent.mm.pluginsdk.ui.tools.f(this) {
                                final /* synthetic */ AnonymousClass15 hkE;

                                {
                                    this.hkE = r1;
                                }

                                public final boolean azE() {
                                    return false;
                                }
                            })) {
                                i.b(str, Ej, com_tencent_mm_protocal_c_ahn, new com.tencent.mm.pluginsdk.ui.tools.f(this) {
                                    final /* synthetic */ AnonymousClass15 hkE;

                                    {
                                        this.hkE = r1;
                                    }

                                    public final boolean azE() {
                                        return false;
                                    }
                                });
                            }
                            ad.o(new Runnable(this) {
                                final /* synthetic */ AnonymousClass15 hkE;

                                {
                                    this.hkE = r1;
                                }

                                public final void run() {
                                    MassSendMsgUI.a(this.hkE.hkv, str, i3);
                                }
                            });
                        }
                    }, "MassSend_Remux");
                    return;
                default:
                    v.e("MicroMsg.MassSendMsgUI", "onActivityResult: not found this requestCode");
                    return;
            }
        }
    }

    private void C(final Intent intent) {
        if (aa.bk(this)) {
            D(intent);
        } else {
            com.tencent.mm.ui.base.g.a(this, 2131235789, 2131231164, new OnClickListener(this) {
                final /* synthetic */ MassSendMsgUI hkv;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.hkv.D(intent);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ MassSendMsgUI hkv;

                {
                    this.hkv = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }

    private void D(Intent intent) {
        final com.tencent.mm.as.a aVar = new com.tencent.mm.as.a();
        getString(2131231164);
        this.dwg = com.tencent.mm.ui.base.g.a(this, getString(2131231182), true, new OnCancelListener(this) {
            final /* synthetic */ MassSendMsgUI hkv;

            public final void onCancel(DialogInterface dialogInterface) {
                aVar.dgj = null;
            }
        });
        aVar.a(this, intent, new com.tencent.mm.as.a.a(this) {
            final /* synthetic */ MassSendMsgUI hkv;

            {
                this.hkv = r1;
            }

            public final void a(int i, final String str, final String str2, final int i2) {
                v.d("MicroMsg.MassSendMsgUI", "onImportFinish, ret: %s, fileName: %s, importPath: %s", new Object[]{Integer.valueOf(i), str, str2});
                if (i >= 0 || i == -50002) {
                    com.tencent.mm.sdk.i.e.a(new Runnable(this) {
                        final /* synthetic */ AnonymousClass5 hkz;

                        public final void run() {
                            if (this.hkz.hkv.cc(str, str2)) {
                                ad.o(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 hkA;

                                    {
                                        this.hkA = r1;
                                    }

                                    public final void run() {
                                        MassSendMsgUI.a(this.hkA.hkz.hkv, str, i2);
                                    }
                                });
                            } else {
                                ad.o(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 hkA;

                                    {
                                        this.hkA = r1;
                                    }

                                    public final void run() {
                                        Toast.makeText(this.hkA.hkz.hkv, this.hkA.hkz.hkv.getString(2131235788), 0).show();
                                        if (this.hkA.hkz.hkv.dwg != null) {
                                            this.hkA.hkz.hkv.dwg.dismiss();
                                            this.hkA.hkz.hkv.dwg = null;
                                        }
                                    }
                                });
                            }
                        }
                    }, "MassSend_Remux");
                    return;
                }
                Toast.makeText(this.hkv, this.hkv.getString(2131235787), 0).show();
                if (this.hkv.dwg != null) {
                    this.hkv.dwg.dismiss();
                    this.hkv.dwg = null;
                }
            }
        });
    }

    private boolean cc(String str, String str2) {
        double d;
        boolean is2G = com.tencent.mm.sdk.platformtools.ak.is2G(this);
        int i = is2G ? 10485760 : 26214400;
        if (is2G) {
            d = 60000.0d;
        } else {
            d = 300000.0d;
        }
        v.i("MicroMsg.MassSendMsgUI", "check remuxing, ret %d", new Object[]{Integer.valueOf(SightVideoJNI.shouldRemuxing(str2, 660, 500, i, d, 1000000))});
        switch (SightVideoJNI.shouldRemuxing(str2, 660, 500, i, d, 1000000)) {
            case -6:
            case -5:
            case -4:
            case -3:
            case ai.CTRL_INDEX /*-2*/:
            case -1:
                return false;
            case 0:
                String ld;
                com.tencent.mm.as.k.KV();
                String lc = com.tencent.mm.as.o.lc(str);
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str2);
                v.i("MicroMsg.MassSendMsgUI", "start remux, targetPath: %s", new Object[]{lc});
                int i2 = be.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                int i3 = be.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                int i4 = 0;
                i = i3;
                int i5 = i2;
                while (i4 < 3) {
                    if (i5 % 2 != 0 || i % 2 != 0) {
                        return false;
                    }
                    if ((i5 < i || (i5 > 640 && i > 480)) && (i5 > i || (i5 > 480 && i > 640))) {
                        i /= 2;
                        i4++;
                        i5 /= 2;
                    }
                    if (SightVideoJNI.remuxing(str2, lc, i5, i, com.tencent.mm.plugin.sight.base.b.iTu, com.tencent.mm.plugin.sight.base.b.iTt, 8, 2, 25.0f, com.tencent.mm.plugin.sight.base.b.iTv, null, 0) >= 0) {
                        v.w("MicroMsg.MassSendMsgUI", "remuxing video error");
                        return false;
                    }
                    wr(lc);
                    com.tencent.mm.as.k.KV();
                    ld = com.tencent.mm.as.o.ld(str);
                    if (!FileOp.aR(ld)) {
                        v.i("MicroMsg.MassSendMsgUI", "thumb not exist create one, thumbPath: %s", new Object[]{ld});
                        try {
                            d.a(ThumbnailUtils.createVideoThumbnail(lc, 1), 60, CompressFormat.JPEG, ld, true);
                        } catch (Throwable e) {
                            v.a("MicroMsg.MassSendMsgUI", e, "", new Object[0]);
                            v.e("MicroMsg.MassSendMsgUI", "create thumb error: %s", new Object[]{e.getMessage()});
                        }
                    }
                    v.i("MicroMsg.MassSendMsgUI", "do remux, targetPath: %s, outputWidth: %s, outputHeight: %s, retDuration: %s", new Object[]{lc, Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(i3)});
                    return true;
                }
                i5 = i2;
                i = i3;
                if (SightVideoJNI.remuxing(str2, lc, i5, i, com.tencent.mm.plugin.sight.base.b.iTu, com.tencent.mm.plugin.sight.base.b.iTt, 8, 2, 25.0f, com.tencent.mm.plugin.sight.base.b.iTv, null, 0) >= 0) {
                    wr(lc);
                    com.tencent.mm.as.k.KV();
                    ld = com.tencent.mm.as.o.ld(str);
                    if (FileOp.aR(ld)) {
                        v.i("MicroMsg.MassSendMsgUI", "thumb not exist create one, thumbPath: %s", new Object[]{ld});
                        d.a(ThumbnailUtils.createVideoThumbnail(lc, 1), 60, CompressFormat.JPEG, ld, true);
                    }
                    v.i("MicroMsg.MassSendMsgUI", "do remux, targetPath: %s, outputWidth: %s, outputHeight: %s, retDuration: %s", new Object[]{lc, Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(i3)});
                    return true;
                }
                v.w("MicroMsg.MassSendMsgUI", "remuxing video error");
                return false;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                com.tencent.mm.as.k.KV();
                wr(com.tencent.mm.as.o.lc(str));
                return true;
            default:
                return false;
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.MassSendMsgUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.dwg != null) {
            this.dwg.dismiss();
            this.dwg = null;
        }
        if (this.hkt != null) {
            b bVar = this.hkt;
            if (bVar.dwg != null) {
                bVar.dwg.dismiss();
                bVar.dwg = null;
            }
        }
        if (i == 0 && i2 == 0) {
            hkr = "";
            Intent intent = new Intent(this, MassSendHistoryUI.class);
            intent.addFlags(67108864);
            startActivity(intent);
            finish();
        } else if (i == 4 && i2 == -24) {
            v.e("MicroMsg.MassSendMsgUI", "onSceneEnd, masssend err spam");
            Toast.makeText(this, 2131233814, 0).show();
        } else {
            if (i == 2 || i == 1 || i == 3) {
                this.hjH.l(hkr, -1, true);
            }
            com.tencent.mm.plugin.masssend.a.drq.a(this.nDR.nEl, i, i2, str);
            switch (i2) {
                case -71:
                    com.tencent.mm.ui.base.g.a(this, getString(2131233824, new Object[]{Integer.valueOf(((ahy) ((com.tencent.mm.plugin.masssend.a.f) kVar).cif.czl.czs).mHL)}), getString(2131231164), new OnClickListener(this) {
                        final /* synthetic */ MassSendMsgUI hkv;

                        {
                            this.hkv = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.hkv.finish();
                        }
                    });
                    return;
                case -34:
                    Toast.makeText(this, 2131233813, 0).show();
                    return;
                default:
                    Toast.makeText(this, 2131234920, 0).show();
                    return;
            }
        }
    }

    private static void wr(String str) {
        long aQ = (long) com.tencent.mm.a.e.aQ(str);
        int f = be.f((Integer) g.a((int) (aQ / 1024), new int[]{512, 1024, 2048, 5120, 8192, 10240, 15360, 20480}, 247, 255));
        g.iuh.a(106, (long) f, 1, false);
        g.iuh.a(106, 246, 1, false);
        v.d("MicroMsg.MassSendMsgUI", "report video size res : " + f + " hadCompress : true fileLen : " + (aQ / 1024) + "K");
    }
}
