package com.tencent.mm.plugin.qqmail.ui;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.qqmail.b.d;
import com.tencent.mm.plugin.qqmail.b.e;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.u;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.plugin.qqmail.b.x;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.File;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"SetJavaScriptEnabled"})
public class ComposeUI extends MMActivity {
    private static List<i> icM;
    private int iap = 1;
    private w ibF = x.aHH();
    private Map<String, String> ibM = new HashMap();
    private ScrollView icN;
    protected MailAddrsViewControl icO;
    private ImageView icP;
    private LinearLayout icQ;
    private LinearLayout icR;
    private MailAddrsViewControl icS;
    private ImageView icT;
    private LinearLayout icU;
    private MailAddrsViewControl icV;
    private ImageView icW;
    private EditText icX;
    private LinearLayout icY;
    private TextView icZ;
    private long icl;
    private ah idA = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ ComposeUI idI;

        {
            this.idI = r1;
        }

        public final boolean oU() {
            if (this.idI.idl && ComposeUI.a(this.idI, false) && this.idI.mode == 5) {
                ComposeUI.b(this.idI);
                if (this.idI.idk != null) {
                    this.idI.idk.dismiss();
                }
                this.idI.idk = s.a(this.idI, this.idI.getString(2131234202), 2000);
            }
            return true;
        }
    }, true);
    com.tencent.mm.plugin.qqmail.b.j.a idB = new com.tencent.mm.plugin.qqmail.b.j.a(this) {
        final /* synthetic */ ComposeUI idI;

        {
            this.idI = r1;
        }

        public final void onComplete() {
            com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.b bVar = new com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.b(this.idI, this.idI.idf.ya(null));
            this.idI.icO.a(bVar);
            this.idI.icS.a(bVar);
            this.idI.icV.a(bVar);
        }
    };
    private OnClickListener idC = new OnClickListener(this) {
        final /* synthetic */ ComposeUI idI;

        {
            this.idI = r1;
        }

        public final void onClick(View view) {
            this.idI.icQ.setVisibility(8);
            this.idI.icR.setVisibility(0);
            this.idI.icU.setVisibility(0);
            this.idI.icQ.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass7 idK;

                {
                    this.idK = r1;
                }

                public final void run() {
                    this.idK.idI.icR.requestFocus();
                    this.idK.idI.icS.aIn();
                    this.idK.idI.icV.aIn();
                }
            });
        }
    };
    private OnClickListener idD = new OnClickListener(this) {
        final /* synthetic */ ComposeUI idI;

        {
            this.idI = r1;
        }

        public final void onClick(View view) {
            g.a(this.idI, null, new String[]{this.idI.getString(2131234201), this.idI.getString(2131234198), this.idI.getString(2131234199)}, null, new com.tencent.mm.ui.base.g.c(this) {
                final /* synthetic */ AnonymousClass8 idL;

                {
                    this.idL = r1;
                }

                public final void gT(int i) {
                    switch (i) {
                        case 0:
                            v.i("MicroMsg.ComposeUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.idL.idI.nDR.nEl, "android.permission.CAMERA", 16, "", "")), be.bur(), this.idL.idI.nDR.nEl});
                            if (com.tencent.mm.pluginsdk.i.a.a(this.idL.idI.nDR.nEl, "android.permission.CAMERA", 16, "", "")) {
                                this.idL.idI.XQ();
                                return;
                            }
                            return;
                        case 1:
                            l.a(this.idL.idI, 4, null);
                            return;
                        case 2:
                            this.idL.idI.startActivityForResult(new Intent(this.idL.idI, FileExplorerUI.class), 5);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    };
    private OnMenuItemClickListener idE = new OnMenuItemClickListener(this) {
        final /* synthetic */ ComposeUI idI;

        {
            this.idI = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            if ((ComposeUI.a(this.idI, false) && this.idI.mode == 5) || this.idI.mode == 6) {
                g.b(this.idI.nDR.nEl, this.idI.getString(2131234208), "", this.idI.getString(2131234210), this.idI.getString(2131231010), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass10 idM;

                    {
                        this.idM = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.idM.idI.setResult(0);
                        this.idM.idI.finish();
                    }
                }, null);
            } else {
                this.idI.setResult(0);
                this.idI.finish();
            }
            return true;
        }
    };
    private OnClickListener idF = new OnClickListener(this) {
        final /* synthetic */ ComposeUI idI;

        {
            this.idI = r1;
        }

        public final void onClick(View view) {
            this.idI.axg();
            this.idI.icX.getText().toString();
            this.idI.aHU();
            if (this.idI.aHV()) {
                ComposeUI composeUI = this.idI;
                ComposeUI composeUI2 = this.idI;
                this.idI.getString(2131231164);
                composeUI.idi = g.a(composeUI2, this.idI.getString(2131234192), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass11 idN;

                    {
                        this.idN = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        this.idN.idI.idg.aId();
                        this.idN.idI.idg.ieJ = null;
                        x.aHG().cancel(this.idN.idI.icl);
                    }
                });
                if (this.idI.idg.aIe()) {
                    this.idI.icl = ComposeUI.H(this.idI);
                    return;
                }
                this.idI.idi.setMessage(this.idI.getString(2131234189));
                this.idI.idg.ieJ = new com.tencent.mm.plugin.qqmail.ui.b.b(this) {
                    final /* synthetic */ AnonymousClass11 idN;

                    {
                        this.idN = r1;
                    }

                    public final void aHW() {
                        this.idN.idI.idi.setMessage(this.idN.idI.getString(2131234189));
                    }

                    public final void onComplete() {
                        this.idN.idI.icl = ComposeUI.H(this.idN.idI);
                    }
                };
            }
        }
    };
    private OnClickListener idG = new OnClickListener(this) {
        final /* synthetic */ ComposeUI idI;

        {
            this.idI = r1;
        }

        public final void onClick(View view) {
            if (this.idI.idg.aIe()) {
                com.tencent.mm.pluginsdk.ui.tools.s.a(this.idI.ide, this.idI.idv, this.idI.idp);
                this.idI.idy = true;
                return;
            }
            this.idI.idi = g.a(this.idI, this.idI.getString(2131234189), true, new OnCancelListener(this) {
                final /* synthetic */ AnonymousClass13 idO;

                {
                    this.idO = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.idO.idI.idg.aId();
                    this.idO.idI.idg.ieJ = null;
                }
            });
            this.idI.idg.ieJ = new com.tencent.mm.plugin.qqmail.ui.b.b(this) {
                final /* synthetic */ AnonymousClass13 idO;

                {
                    this.idO = r1;
                }

                public final void aHW() {
                }

                public final void onComplete() {
                    this.idO.idI.idi.dismiss();
                    com.tencent.mm.pluginsdk.ui.tools.s.a(this.idO.idI.ide, this.idO.idI.idv, this.idO.idI.idp);
                    this.idO.idI.idy = true;
                }
            };
        }
    };
    private com.tencent.mm.plugin.qqmail.b.q.a idH = new com.tencent.mm.plugin.qqmail.b.q.a(this) {
        final /* synthetic */ ComposeUI idI;

        {
            this.idI = r1;
        }

        public final void onSuccess(String str, Map<String, String> map) {
            g.a(this.idI, 2131234193, 2131231164, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ AnonymousClass15 idP;

                {
                    this.idP = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    File file = new File(x.aHG().ibl.iao.iay + com.tencent.mm.plugin.qqmail.b.c.aK(this.idP.idI.idj, this.idP.idI.iap));
                    if (file.exists()) {
                        file.delete();
                    }
                    this.idP.idI.setResult(-1);
                    this.idP.idI.finish();
                }
            });
            this.idI.idf.aY(this.idI.icO.ifn);
            this.idI.idf.aY(this.idI.icS.ifn);
            this.idI.idf.aY(this.idI.icV.ifn);
        }

        public final void onError(int i, String str) {
            if (i == -5) {
                this.idI.idh.a(new com.tencent.mm.plugin.qqmail.ui.c.a(this) {
                    final /* synthetic */ AnonymousClass15 idP;

                    {
                        this.idP = r1;
                    }

                    public final void aHJ() {
                        ComposeUI.H(this.idP.idI);
                    }

                    public final void aHK() {
                    }
                });
            } else {
                g.a(this.idI, str, this.idI.getString(2131234191), null);
            }
        }

        public final void onComplete() {
            if (this.idI.idi != null) {
                this.idI.idi.dismiss();
                this.idI.idi = null;
            }
        }
    };
    private ImageView ida;
    private LinearLayout idb;
    private TextView idc;
    private EditText idd;
    private WebView ide;
    private j idf;
    private b idg;
    public c idh = new c(this);
    private p idi;
    private String idj;
    private o idk;
    public boolean idl = true;
    public boolean idm = true;
    public boolean idn = false;
    private String ido = ("(function() { \nvar imgList = document.getElementsByTagName('img');var result = ''; \nfor (var i = 0; i < imgList.length; i++) {var img = imgList[i];var info = img.id + '@@' + img.src;result += info + '&&'}return result;" + "})()".trim());
    private String idp = "document.getElementById('history').innerHTML";
    private String idq = "<div id=\"htmlContent\" contenteditable=\"true\" >";
    private String idr = "</div>";
    private String ids = null;
    private String idt = null;
    private String idu = "weixin://get_img_info/";
    private String idv = "weixin://get_mail_content/";
    private String idw = "weixin://img_onclick/";
    private boolean idx = false;
    private boolean idy = false;
    private ah idz = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ ComposeUI idI;

        {
            this.idI = r1;
        }

        public final boolean oU() {
            this.idI.iT(ComposeUI.a(this.idI, true));
            return true;
        }
    }, true);
    private int mode = 5;

    private class a extends WebChromeClient {
        final /* synthetic */ ComposeUI idI;

        private a(ComposeUI composeUI) {
            this.idI = composeUI;
        }

        @Deprecated
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            v.i("MicroMsg.ComposeUI", "console, consoleMessage: %s", new Object[]{consoleMessage});
            String If = com.tencent.mm.pluginsdk.ui.tools.s.If(consoleMessage != null ? consoleMessage.message() : null);
            String[] split;
            if (If.startsWith(this.idI.idw)) {
                this.idI.axg();
                try {
                    String[] split2 = URLDecoder.decode(If.substring(this.idI.idw.length()), ProtocolPackage.ServerEncoding).split("@@")[0].split(":");
                    String str = split2[0];
                    String str2 = split2[1];
                    v.i("MicroMsg.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", new Object[]{split[1], str, str2});
                    ak.yW();
                    at ek = com.tencent.mm.model.c.wJ().ek((long) Integer.valueOf(str).intValue());
                    Intent intent = new Intent(this.idI, MailImageDownloadUI.class);
                    intent.putExtra("img_msg_id", ek.field_msgId);
                    intent.putExtra("img_server_id", ek.field_msgSvrId);
                    intent.putExtra("img_download_compress_type", 0);
                    intent.putExtra("img_download_username", ek.field_talker);
                    this.idI.startActivity(intent);
                    return true;
                } catch (Exception e) {
                    v.w("MicroMsg.ComposeUI", "consoleMessage IMG_ONCLICK, ex = %s", new Object[]{e.getMessage()});
                }
            } else if (If.startsWith(this.idI.idv)) {
                try {
                    this.idI.idt = URLDecoder.decode(If.substring(this.idI.idv.length()), ProtocolPackage.ServerEncoding);
                } catch (Exception e2) {
                    v.w("MicroMsg.ComposeUI", "consoleMessage GET_MAIL_CONTENT, ex = %s", new Object[]{e2.getMessage()});
                }
                if (this.idI.idy) {
                    if (this.idI.idt.indexOf("<img") == -1) {
                        this.idI.ibM.clear();
                        ComposeUI.r(this.idI);
                        return true;
                    }
                    com.tencent.mm.pluginsdk.ui.tools.s.a(this.idI.ide, this.idI.idu, this.idI.ido);
                }
                return true;
            } else {
                if (If.startsWith(this.idI.idu)) {
                    this.idI.ibM.clear();
                    try {
                        String[] split3 = URLDecoder.decode(If.substring(this.idI.idu.length()), ProtocolPackage.ServerEncoding).split("&&");
                        for (String If2 : split3) {
                            split = If2.split("@@");
                            Object obj = split[0].split(":")[1];
                            Object obj2 = split[1];
                            if (obj2.startsWith("file://")) {
                                obj2 = obj2.replaceFirst("file://", "");
                            }
                            v.i("MicroMsg.ComposeUI", "put msgImgInfoMap, msgSvrId: %s, path: %s", new Object[]{obj, obj2});
                            this.idI.ibM.put(obj, obj2);
                        }
                        if (this.idI.idy) {
                            ComposeUI.r(this.idI);
                        }
                        return true;
                    } catch (Exception e22) {
                        v.w("MicroMsg.ComposeUI", "consoleMessage GET_IMG_INFO, ex = %s", new Object[]{e22.getMessage()});
                        return true;
                    }
                }
                return super.onConsoleMessage(consoleMessage);
            }
        }
    }

    private class b extends WebViewClient {
        final /* synthetic */ ComposeUI idI;
        private boolean idV;

        private b(ComposeUI composeUI) {
            this.idI = composeUI;
            this.idV = false;
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            v.d("MicroMsg.ComposeUI", "shouldOverrideUrlLoading, url = %s", new Object[]{str});
            String[] split;
            String str2;
            if (str.startsWith(this.idI.idw)) {
                this.idI.axg();
                try {
                    split = URLDecoder.decode(str.substring(this.idI.idw.length()), ProtocolPackage.ServerEncoding).split("@@")[0].split(":");
                    String str3 = split[0];
                    str2 = split[1];
                    v.i("MicroMsg.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", new Object[]{r0[1], str3, str2});
                    ak.yW();
                    at ek = com.tencent.mm.model.c.wJ().ek((long) Integer.valueOf(str3).intValue());
                    Intent intent = new Intent(this.idI, MailImageDownloadUI.class);
                    intent.putExtra("img_msg_id", ek.field_msgId);
                    intent.putExtra("img_server_id", ek.field_msgSvrId);
                    intent.putExtra("img_download_compress_type", 0);
                    intent.putExtra("img_download_username", ek.field_talker);
                    this.idI.startActivity(intent);
                } catch (Exception e) {
                    v.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading IMG_ONCLICK, ex = %s", new Object[]{e.getMessage()});
                }
            } else if (str.startsWith(this.idI.idv)) {
                try {
                    this.idI.idt = URLDecoder.decode(str.substring(this.idI.idv.length()), ProtocolPackage.ServerEncoding);
                } catch (Exception e2) {
                    v.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading GET_MAIL_CONTENT, ex = %s", new Object[]{e2.getMessage()});
                }
                if (this.idI.idy) {
                    if (this.idI.idt.indexOf("<img") == -1) {
                        this.idI.ibM.clear();
                        ComposeUI.r(this.idI);
                    } else {
                        com.tencent.mm.pluginsdk.ui.tools.s.a(this.idI.ide, this.idI.idu, this.idI.ido);
                    }
                }
            } else if (str.startsWith(this.idI.idu)) {
                this.idI.ibM.clear();
                try {
                    String[] split2 = URLDecoder.decode(str.substring(this.idI.idu.length()), ProtocolPackage.ServerEncoding).split("&&");
                    for (String str22 : split2) {
                        split = str22.split("@@");
                        Object obj = split[0].split(":")[1];
                        Object obj2 = split[1];
                        if (obj2.startsWith("file://")) {
                            obj2 = obj2.replaceFirst("file://", "");
                        }
                        v.i("MicroMsg.ComposeUI", "put msgImgInfoMap, msgSvrId: %s, path: %s", new Object[]{obj, obj2});
                        this.idI.ibM.put(obj, obj2);
                    }
                    if (this.idI.idy) {
                        ComposeUI.r(this.idI);
                    }
                } catch (Exception e22) {
                    v.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading GET_IMG_INFO, ex = %s", new Object[]{e22.getMessage()});
                }
            }
            return true;
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (!this.idI.idx) {
                com.tencent.mm.pluginsdk.ui.tools.s.d(this.idI.ide);
                this.idI.idx = true;
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            v.d("MicroMsg.ComposeUI", "onPageFinished, url = %s, firstTimeLoaded = %b", new Object[]{str, Boolean.valueOf(this.idV)});
            if (!this.idV) {
                this.idV = true;
                com.tencent.mm.pluginsdk.ui.tools.s.a(this.idI.ide, this.idI.idv, this.idI.idp);
            }
            super.onPageFinished(webView, str);
        }
    }

    private class c extends com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.c {
        final /* synthetic */ ComposeUI idI;
        private ImageView idW;
        private int tag;

        public c(ComposeUI composeUI, ImageView imageView, int i) {
            this.idI = composeUI;
            this.idW = imageView;
            this.tag = i;
        }

        public final void eS(boolean z) {
            ImageView imageView;
            int i = 0;
            ComposeUI.y(this.idI);
            if (this.idI.idn) {
                imageView = this.idW;
            } else {
                imageView = this.idW;
                if (!z) {
                    i = 4;
                }
            }
            imageView.setVisibility(i);
            if ((this.tag == 1 || this.tag == 2) && !z) {
                this.idI.icQ.postDelayed(new Runnable(this) {
                    final /* synthetic */ c idX;

                    {
                        this.idX = r1;
                    }

                    public final void run() {
                        if (!this.idX.idI.icS.ifo.isFocused() && !this.idX.idI.icV.ifo.isFocused() && this.idX.idI.icS.ifn.size() == 0 && this.idX.idI.icV.ifn.size() == 0 && this.idX.idI.icS.aIi() && this.idX.idI.icV.aIi()) {
                            this.idX.idI.icQ.setVisibility(0);
                            this.idX.idI.icR.setVisibility(8);
                            this.idX.idI.icU.setVisibility(8);
                        }
                    }
                }, 10);
            }
        }
    }

    static /* synthetic */ long H(ComposeUI composeUI) {
        Map hashMap = new HashMap();
        hashMap.put("from", "");
        hashMap.put("to", composeUI.icO.aIl());
        hashMap.put("cc", composeUI.icS.aIl());
        hashMap.put("bcc", composeUI.icV.aIl());
        hashMap.put("subject", composeUI.getSubject());
        hashMap.put("content", composeUI.aHU());
        hashMap.put("attachlist", composeUI.idg.aIb());
        hashMap.put("sendtype", (composeUI.iap == 4 ? 1 : composeUI.iap));
        hashMap.put("oldmailid", composeUI.idj);
        com.tencent.mm.plugin.qqmail.b.q.c cVar = new com.tencent.mm.plugin.qqmail.b.q.c();
        cVar.ibw = false;
        cVar.ibv = true;
        return x.aHG().a("/cgi-bin/composesendwithattach", hashMap, cVar, composeUI.idH);
    }

    static /* synthetic */ boolean a(ComposeUI composeUI, boolean z) {
        if (z && composeUI.icO.ifn.size() == 0 && composeUI.icS.ifn.size() == 0 && composeUI.icV.ifn.size() == 0 && !composeUI.icO.aIk() && !composeUI.icS.aIk() && !composeUI.icV.aIk()) {
            return false;
        }
        if (composeUI.mode == 5) {
            if (composeUI.icX.getText().toString().trim().length() == 0 && composeUI.idg.aIc().size() == 0 && composeUI.idd.getText().length() == 0) {
                return false;
            }
        } else if (composeUI.mode == 6 && composeUI.icX.getText().toString().trim().length() == 0 && composeUI.idg.aIc().size() == 0) {
            return false;
        }
        return true;
    }

    static /* synthetic */ void b(ComposeUI composeUI) {
        d dVar = new d();
        dVar.iap = composeUI.iap;
        dVar.iaq = composeUI.idj;
        dVar.iar = composeUI.icO.ifn;
        dVar.ias = composeUI.icS.ifn;
        dVar.iat = composeUI.icV.ifn;
        dVar.iav = composeUI.icX.getText().toString();
        dVar.iau = composeUI.idg.aIc();
        if (composeUI.mode != 6 && composeUI.mode == 5) {
            dVar.content = composeUI.aHU();
            dVar.iaw = composeUI.mode;
            v.i("MicroMsg.ComposeUI", "save draft mail as normal mode");
        }
        com.tencent.mm.plugin.qqmail.b.c cVar = x.aHG().ibl;
        try {
            cVar.iao.aHt();
            e.p(cVar.iao.iay + com.tencent.mm.plugin.qqmail.b.c.aK(dVar.iaq, dVar.iap), dVar.toByteArray());
        } catch (Throwable e) {
            v.a("MicroMsg.DraftBoxMgr", e, "", new Object[0]);
        }
    }

    static /* synthetic */ void r(ComposeUI composeUI) {
        String str = null;
        ak.yW();
        String oVar = new com.tencent.mm.a.o(((Integer) com.tencent.mm.model.c.vf().get(9, null)).intValue()).toString();
        oVar = !be.kS(oVar) ? oVar + "@qq.com" : null;
        com.tencent.mm.plugin.qqmail.b.v vVar = new com.tencent.mm.plugin.qqmail.b.v();
        vVar.bhM = oVar;
        vVar.iav = composeUI.getSubject();
        if (!be.kS(composeUI.icO.aIl())) {
            vVar.iaY = composeUI.icO.aIl().split(",");
        }
        if (!be.kS(composeUI.icS.aIl())) {
            vVar.iaZ = composeUI.icS.aIl().split(",");
        }
        if (!be.kS(composeUI.icV.aIl())) {
            vVar.iba = composeUI.icV.aIl().split(",");
        }
        oVar = composeUI.aHU();
        if (!be.kS(oVar)) {
            str = oVar.replaceAll("src=\"file://", "src=\"cid:").replaceAll("height=\"100\"", "style=\"max-width: 200px; max-width:300px;\"");
        }
        vVar.ibL = str;
        if (composeUI.ibM.size() > 0) {
            Map map = composeUI.ibM;
            vVar.ibM = new HashMap();
            vVar.ibM.putAll(map);
        }
        v.d("MicroMsg.ComposeUI", "send mail content: \n%s", new Object[]{str});
        v.d("MicroMsg.ComposeUI", "msgImgInfoMap.size: %d", new Object[]{Integer.valueOf(composeUI.ibM.size())});
        v.d("MicroMsg.ComposeUI", "uploadedAttachidMap.size: %d", new Object[]{Integer.valueOf(composeUI.idg.ieH.size())});
        if (composeUI.idg.ieH.size() > 0 && composeUI.idg.ieI.size() > 0) {
            map = composeUI.idg.ieH;
            vVar.ibN = new LinkedHashMap();
            vVar.ibN.putAll(map);
            map = composeUI.idg.ieI;
            vVar.ibO = new LinkedHashMap();
            vVar.ibO.putAll(map);
        }
        w wVar = composeUI.ibF;
        if (wVar.ibQ == null) {
            wVar.ibQ = new u();
        }
        wVar.ibQ.a(vVar);
        composeUI.idy = false;
        g.bf(composeUI.nDR.nEl, composeUI.getString(2131232839));
        ad.g(new Runnable(composeUI) {
            final /* synthetic */ ComposeUI idI;

            {
                this.idI = r1;
            }

            public final void run() {
                this.idI.setResult(-1);
                this.idI.finish();
            }
        }, 800);
    }

    static /* synthetic */ void y(ComposeUI composeUI) {
        composeUI.icP.setVisibility(4);
        composeUI.icT.setVisibility(4);
        composeUI.icW.setVisibility(4);
    }

    protected final int getLayoutId() {
        return 2130904213;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ids = this.idq + "%s" + this.idr;
        this.idx = false;
        this.idy = false;
        this.iap = getIntent().getIntExtra("composeType", 1);
        this.idj = getIntent().getStringExtra("mailid");
        if (this.idj == null) {
            this.idj = "";
        }
        this.mode = getIntent().getIntExtra("mail_mode", 5);
        v.d("MicroMsg.ComposeUI", "onCreate, mode = %d", new Object[]{Integer.valueOf(this.mode)});
        NI();
        this.idf = x.aHG().ibk;
        this.idf.a(this.idB);
        this.idf.aHv();
        this.idA.ea(180000);
    }

    protected void onResume() {
        super.onResume();
        this.idz.ea(1500);
    }

    protected void onPause() {
        super.onPause();
        axg();
        this.idz.QI();
        if (this.idk != null) {
            this.idk.dismiss();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (icM != null) {
            icM = null;
        }
        this.idg.aId();
        ak.vy().b(484, this.idg);
        this.idf.b(this.idB);
        this.idh.release();
        this.idA.QI();
    }

    private void aHS() {
        this.icO.clearFocus();
        this.icS.clearFocus();
        this.icV.clearFocus();
    }

    protected final void NI() {
        String str;
        CharSequence charSequence;
        this.icN = (ScrollView) findViewById(2131758700);
        this.icO = (MailAddrsViewControl) findViewById(2131758704);
        this.icP = (ImageView) findViewById(2131758705);
        this.icQ = (LinearLayout) findViewById(2131758706);
        this.icR = (LinearLayout) findViewById(2131758707);
        this.icS = (MailAddrsViewControl) findViewById(2131758708);
        this.icT = (ImageView) findViewById(2131758709);
        this.icU = (LinearLayout) findViewById(2131758710);
        this.icV = (MailAddrsViewControl) findViewById(2131758711);
        this.icW = (ImageView) findViewById(2131758712);
        this.icX = (EditText) findViewById(2131758714);
        this.icY = (LinearLayout) findViewById(2131758716);
        this.idc = (TextView) findViewById(2131758720);
        this.idd = (EditText) findViewById(2131758721);
        this.ide = com.tencent.mm.ui.widget.MMWebView.a.h(this, 2131758722);
        this.icZ = (TextView) findViewById(2131758717);
        this.ida = (ImageView) findViewById(2131758718);
        this.idb = (LinearLayout) findViewById(2131758719);
        this.icO.aIj();
        this.icS.aIj();
        this.icV.aIj();
        CharSequence stringExtra = getIntent().getStringExtra("mail_content");
        List<String> stringArrayListExtra = getIntent().getStringArrayListExtra("mail_attach");
        List stringArrayListExtra2 = getIntent().getStringArrayListExtra("mail_attach_title");
        d aJ = x.aHG().ibl.aJ(this.idj, this.iap);
        this.idg = new b(this, this.icZ, this.ida, this.idb, (byte) 0);
        if (!be.kS(stringExtra)) {
            v.i("MicroMsg.ComposeUI", "read mail from extra");
            if (this.mode == 6) {
                aHT();
                this.icO.requestFocus();
                this.idt = String.format(this.ids, new Object[]{stringExtra});
                this.ide.loadDataWithBaseURL("", this.idt, "text/html", ProtocolPackage.ServerEncoding, "");
                this.idd.setVisibility(8);
                this.ide.setVisibility(0);
            } else if (this.mode == 5) {
                this.idd.setVisibility(0);
                this.ide.setVisibility(8);
                if (stringExtra.indexOf("<div>") != -1) {
                    v.i("MicroMsg.ComposeUI", "set content in html format");
                    this.idd.setText(Html.fromHtml(stringExtra));
                } else {
                    this.idd.setText(stringExtra);
                }
            }
            this.idg.mode = this.mode;
            if (this.mode == 6) {
                int i = 0;
                for (String str2 : stringArrayListExtra) {
                    File file = new File(str2);
                    if (file.exists()) {
                        if (((int) file.length()) + this.idg.VI() > 52428800) {
                            g.a(this, 2131234230, 2131231164, null);
                            break;
                        }
                        v.i("MicroMsg.ComposeUI", "in upload file mode = %d", new Object[]{Integer.valueOf(this.mode)});
                        int i2 = i + 1;
                        this.idg.cm(str2, (String) stringArrayListExtra2.get(i));
                        i = i2;
                    }
                }
            }
        } else if (aJ == null || this.mode != 6) {
            v.i("MicroMsg.ComposeUI", "no extra or draf mail content");
            if (this.mode == 6) {
                aHT();
                this.icO.requestFocus();
                this.idt = String.format(this.ids, new Object[]{""});
                this.ide.loadDataWithBaseURL("", this.idt, "text/html", ProtocolPackage.ServerEncoding, "");
                this.idd.setVisibility(8);
                this.ide.setVisibility(0);
            } else if (this.mode == 5) {
                this.ide.setVisibility(8);
                this.idd.setVisibility(0);
            }
            this.idg.mode = this.mode;
        } else {
            v.i("MicroMsg.ComposeUI", "read mail from draftMail");
            this.icO.bb(aJ.iar);
            this.icS.bb(aJ.ias);
            this.icV.bb(aJ.iat);
            this.icX.setText(aJ.iav);
            charSequence = aJ.content;
            this.mode = 5;
            if (charSequence.indexOf("<div>") != -1) {
                v.i("MicroMsg.ComposeUI", "set content in html format");
                this.idd.setText(Html.fromHtml(charSequence));
            } else {
                this.idd.setText(charSequence);
            }
            this.idg.mode = this.mode;
            this.idg.ba(aJ.iau);
            this.idg.aIf();
            this.ide.setVisibility(8);
            this.idd.setVisibility(0);
        }
        String[] stringArrayExtra;
        if (this.iap != 1) {
            stringArrayExtra = getIntent().getStringArrayExtra("toList");
            String[] stringArrayExtra2 = getIntent().getStringArrayExtra("ccList");
            String[] stringArrayExtra3 = getIntent().getStringArrayExtra("bccList");
            String stringExtra2 = getIntent().getStringExtra("subject");
            this.icO.a(stringArrayExtra, false);
            this.icS.a(stringArrayExtra2, false);
            this.icV.a(stringArrayExtra3, false);
            if (!be.kS(stringExtra2)) {
                EditText editText = this.icX;
                StringBuilder stringBuilder = new StringBuilder();
                if (this.iap == 2) {
                    str2 = "Re:";
                } else {
                    str2 = "Fwd:";
                }
                editText.setText(stringBuilder.append(str2).append(stringExtra2).toString());
            }
        } else if (this.iap == 2 || this.iap == 3) {
            this.idc.setVisibility(0);
        } else if (this.iap == 4) {
            stringArrayExtra = getIntent().getStringArrayExtra("toList");
            if (stringArrayExtra != null && stringArrayExtra.length > 0) {
                this.icO.a(stringArrayExtra, false);
            }
        } else if (this.iap == 1) {
            charSequence = getIntent().getStringExtra("subject");
            if (!be.kS(charSequence)) {
                this.icX.setText(charSequence);
            }
        }
        if (this.icS.ifn.size() > 0 || this.icV.ifn.size() > 0) {
            this.icQ.setVisibility(8);
            this.icR.setVisibility(0);
            this.icU.setVisibility(0);
        }
        if (this.iap == 2 && this.mode != 6 && this.mode == 5) {
            this.idd.requestFocus();
            this.idd.setSelection(0);
            this.icN.postDelayed(new Runnable(this) {
                final /* synthetic */ ComposeUI idI;

                {
                    this.idI = r1;
                }

                public final void run() {
                    this.idI.icN.fullScroll(130);
                }
            }, 1000);
        }
        this.icO.ifq = new c(this, this.icP, 0);
        this.icS.ifq = new c(this, this.icT, 1);
        this.icV.ifq = new c(this, this.icW, 2);
        com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.a anonymousClass19 = new com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.a(this) {
            final /* synthetic */ ComposeUI idI;

            {
                this.idI = r1;
            }

            public final void b(final MailAddrsViewControl mailAddrsViewControl) {
                g.a(this.idI.nDR.nEl, this.idI.getString(2131234219), "", new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass19 idS;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        mailAddrsViewControl.ifo.setText("");
                        this.idS.idI.idA.postDelayed(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 idT;

                            {
                                this.idT = r1;
                            }

                            public final void run() {
                                this.idT.idS.idI.aHS();
                                mailAddrsViewControl.requestFocus();
                                this.idT.idS.idI.aJs();
                            }
                        }, 150);
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass19 idS;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.idS.idI.idA.postDelayed(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 idU;

                            {
                                this.idU = r1;
                            }

                            public final void run() {
                                this.idU.idS.idI.aHS();
                                mailAddrsViewControl.requestFocus();
                                this.idU.idS.idI.aJs();
                            }
                        }, 150);
                    }
                });
            }

            public final void aHX() {
                s.a(this.idI, this.idI.getString(2131234219), 1500);
            }
        };
        this.icO.ifs = anonymousClass19;
        this.icS.ifs = anonymousClass19;
        this.icV.ifs = anonymousClass19;
        this.icP.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ComposeUI idI;

            {
                this.idI = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.idI, MailAddrListUI.class);
                intent.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", this.idI.icO.a(false, null));
                intent.putExtra("MMActivity.OverrideExitAnimation", 2130968644);
                intent.putExtra("MMActivity.OverrideEnterAnimation", 2130968622);
                this.idI.startActivityForResult(intent, 0);
                this.idI.overridePendingTransition(2130968646, 2130968623);
            }
        });
        this.icT.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ComposeUI idI;

            {
                this.idI = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.idI, MailAddrListUI.class);
                intent.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", this.idI.icS.a(false, null));
                intent.putExtra("MMActivity.OverrideExitAnimation", 2130968644);
                intent.putExtra("MMActivity.OverrideEnterAnimation", 2130968622);
                this.idI.startActivityForResult(intent, 1);
                this.idI.overridePendingTransition(2130968646, 2130968623);
            }
        });
        this.icW.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ComposeUI idI;

            {
                this.idI = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.idI, MailAddrListUI.class);
                intent.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", this.idI.icV.a(false, null));
                intent.putExtra("MMActivity.OverrideExitAnimation", 2130968644);
                intent.putExtra("MMActivity.OverrideEnterAnimation", 2130968622);
                this.idI.startActivityForResult(intent, 2);
                this.idI.overridePendingTransition(2130968646, 2130968623);
            }
        });
        this.icQ.setOnClickListener(this.idC);
        final ImageView imageView = (ImageView) findViewById(2131758715);
        if (this.idm && this.icX.getText().length() > 0) {
            imageView.setVisibility(0);
        }
        this.icX.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ ComposeUI idI;

            {
                this.idI = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    this.idI.icX.setSelection(this.idI.icX.getText().length());
                }
            }
        });
        this.icX.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ ComposeUI idI;

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int i4 = 4;
                if (this.idI.idm) {
                    ImageView imageView = imageView;
                    if (this.idI.icX.getText().length() > 0) {
                        i4 = 0;
                    }
                    imageView.setVisibility(i4);
                    return;
                }
                imageView.setVisibility(4);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        imageView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ComposeUI idI;

            {
                this.idI = r1;
            }

            public final void onClick(View view) {
                this.idI.icX.getText().clear();
                this.idI.icX.requestFocus();
            }
        });
        this.icY.setOnClickListener(this.idD);
        vD(2131234213);
        if (getIntent().getBooleanExtra("show_qqmail", false)) {
            ak.yW();
            int intValue = ((Integer) com.tencent.mm.model.c.vf().get(9, null)).intValue();
            if (intValue == 0) {
                v.w("MicroMsg.ComposeUI", "want to show qqmail address, but unbind qq");
            } else {
                NY(new com.tencent.mm.a.o(intValue) + "@qq.com");
            }
        }
        b(this.idE);
        if (this.mode == 5) {
            a(0, getString(2131231149), new OnMenuItemClickListener(this) {
                final /* synthetic */ ComposeUI idI;

                {
                    this.idI = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.idI.idF.onClick(null);
                    return false;
                }
            });
        } else if (this.mode == 6) {
            v.i("MicroMsg.ComposeUI", "set onShareModeSendListener");
            a(0, getString(2131231149), new OnMenuItemClickListener(this) {
                final /* synthetic */ ComposeUI idI;

                {
                    this.idI = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.idI.idG.onClick(null);
                    return false;
                }
            });
        }
        iT(false);
        aHS();
    }

    private void aHT() {
        if (this.ide != null) {
            this.ide.clearFocus();
            this.ide.getSettings().setJavaScriptEnabled(true);
            this.ide.setWebViewClient(new b());
            this.ide.setWebChromeClient(new a());
            this.ide.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ ComposeUI idI;

                {
                    this.idI = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                        case 1:
                            if (!view.hasFocus()) {
                                view.requestFocus();
                                break;
                            }
                            break;
                    }
                    return false;
                }
            });
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        this.idE.onMenuItemClick(null);
        return true;
    }

    private void XQ() {
        if (!l.d(this, com.tencent.mm.compatible.util.e.cgg, "microMsg." + System.currentTimeMillis() + ".jpg", 3)) {
            Toast.makeText(this, getString(2131234875), 1).show();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.ComposeUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    XQ();
                    return;
                } else {
                    g.a(this, getString(2131234160), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ ComposeUI idI;

                        {
                            this.idI = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.idI.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }

    private String aHU() {
        if (this.mode == 6) {
            com.tencent.mm.pluginsdk.ui.tools.s.a(this.ide, this.idv, this.idp);
            if (this.idt != null) {
                int indexOf = this.idt.indexOf(this.idq);
                int lastIndexOf = this.idt.lastIndexOf(this.idr);
                if (indexOf == -1 || lastIndexOf == -1) {
                    return this.idt;
                }
                return this.idt.substring(indexOf + this.idq.length(), lastIndexOf + this.idr.length());
            }
        } else if (this.mode == 5) {
            return this.idd.getText().toString();
        }
        return null;
    }

    private String getSubject() {
        int i = 40;
        String obj = this.icX.getText().toString();
        if (obj.trim().length() > 0) {
            return obj;
        }
        obj = aHU();
        if (this.mode == 5) {
            if (obj.length() > 0) {
                if (obj.length() <= 40) {
                    i = obj.length();
                }
                return obj.substring(0, i);
            }
        } else if (this.mode == 6 && !be.kS(obj)) {
            if (obj.length() <= 40) {
                i = obj.length();
            }
            return obj.substring(0, i);
        }
        return getString(2131234209);
    }

    protected final boolean aHV() {
        if (!this.icO.aIm()) {
            Toast.makeText(this, 2131234215, 1).show();
            return false;
        } else if (!this.icS.aIm()) {
            Toast.makeText(this, 2131234206, 1).show();
            return false;
        } else if (!this.icV.aIm()) {
            Toast.makeText(this, 2131234204, 1).show();
            return false;
        } else if ((this.icO.ifn.size() + this.icS.ifn.size()) + this.icV.ifn.size() <= 20) {
            return true;
        } else {
            Toast.makeText(this, 2131234221, 1).show();
            return false;
        }
    }

    static void aZ(List<i> list) {
        icM = list;
    }

    private static void a(MailAddrsViewControl mailAddrsViewControl) {
        if (icM != null) {
            List list = icM;
            if (list != null) {
                int i;
                i iVar;
                int i2;
                for (i = 0; i < mailAddrsViewControl.ifn.size(); i++) {
                    iVar = (i) mailAddrsViewControl.ifn.get(i);
                    i2 = 0;
                    while (i2 < list.size()) {
                        if (iVar.gRG.equalsIgnoreCase(((i) list.get(i2)).gRG)) {
                            break;
                        }
                        i2++;
                    }
                    if (i2 == list.size()) {
                        mailAddrsViewControl.f(iVar);
                    }
                }
                for (i = 0; i < list.size(); i++) {
                    iVar = (i) list.get(i);
                    i2 = 0;
                    while (i2 < mailAddrsViewControl.ifn.size()) {
                        if (iVar.gRG.equalsIgnoreCase(((i) mailAddrsViewControl.ifn.get(i2)).gRG)) {
                            break;
                        }
                        i2++;
                    }
                    if (i2 == mailAddrsViewControl.ifn.size()) {
                        mailAddrsViewControl.e(iVar);
                    }
                }
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            String a;
            switch (i) {
                case 0:
                    a(this.icO);
                    aJs();
                    return;
                case 1:
                    a(this.icS);
                    aJs();
                    return;
                case 2:
                    a(this.icV);
                    aJs();
                    return;
                case 3:
                    ak.yW();
                    a = l.a(this, intent, com.tencent.mm.model.c.wP());
                    if (a != null) {
                        yg(a);
                        aHS();
                        return;
                    }
                    return;
                case 4:
                    if (intent != null) {
                        ak.yW();
                        a = com.tencent.mm.ui.tools.a.b(this, intent, com.tencent.mm.model.c.wP());
                        if (a != null && a.length() > 0) {
                            yg(a);
                            aHS();
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (intent != null) {
                        yg(intent.getStringExtra("choosed_file_path"));
                        aHS();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void yg(final String str) {
        final File file = new File(str);
        if (!file.exists()) {
            return;
        }
        if (this.idg.ieF.containsKey(str)) {
            g.f(this.nDR.nEl, 2131234228, 2131231164);
            return;
        }
        final int length = (int) file.length();
        if (length > 20971520) {
            g.a(this, 2131234229, 2131231164, null);
            return;
        }
        g.a(this, getString(2131234231, new Object[]{be.aw((long) length)}), getString(2131231164), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ ComposeUI idI;

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (this.idI.idg.VI() + length > 52428800) {
                    g.a(this.idI, 2131234230, 2131231164, null);
                    return;
                }
                if (this.idI.icX.getText().toString().trim().length() == 0) {
                    String trim = file.getName().trim();
                    int lastIndexOf = trim.lastIndexOf(".");
                    EditText j = this.idI.icX;
                    if (lastIndexOf <= 0) {
                        lastIndexOf = trim.length();
                    }
                    j.setText(trim.substring(0, lastIndexOf));
                }
                v.i("MicroMsg.ComposeUI", "in upload file mode = %d", new Object[]{Integer.valueOf(this.idI.mode)});
                this.idI.idg.cm(str, null);
            }
        }, null);
    }

    public void setRequestedOrientation(int i) {
    }
}
