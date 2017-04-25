package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.a.e;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.qqmail.b.q;
import com.tencent.mm.plugin.qqmail.b.x;
import com.tencent.mm.pluginsdk.model.d;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.c;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AttachDownloadPage extends MMActivity {
    private long beE;
    private TextView dtE;
    private ProgressBar elJ;
    private Button fQD;
    private Button fQF;
    private View fQI;
    private String iaq;
    private String ibe;
    private ImageView icA;
    private TextView icB;
    private TextView icC;
    private String icD;
    private int icE;
    private boolean icF = false;
    private String icG;
    private long icH = 0;
    private boolean icI = true;
    private int icJ = 0;
    private long icl;
    private MMImageView icy;
    private ImageView icz;
    private int retryCount = 0;

    static /* synthetic */ void a(AttachDownloadPage attachDownloadPage, String str) {
        bp bpVar = new bp();
        d.a(bpVar, 9, str, e.aT(str), "");
        bpVar.aZd.aXH = attachDownloadPage;
        bpVar.aZd.aZl = 6;
        a.nhr.z(bpVar);
    }

    static /* synthetic */ void b(AttachDownloadPage attachDownloadPage, String str) {
        String aS = e.aS(str);
        if (aS != null && aS.length() != 0) {
            com.tencent.mm.pluginsdk.ui.tools.a.c(attachDownloadPage, str, aS, 3);
        }
    }

    static /* synthetic */ void g(AttachDownloadPage attachDownloadPage) {
        if (attachDownloadPage.icF) {
            Intent intent = new Intent(attachDownloadPage.nDR.nEl, CompressPreviewUI.class);
            intent.putExtra("mail_id", attachDownloadPage.iaq);
            intent.putExtra("attach_id", attachDownloadPage.ibe);
            intent.putExtra("attach_size", attachDownloadPage.beE);
            intent.putExtra("attach_name", attachDownloadPage.icG);
            attachDownloadPage.nDR.nEl.startActivity(intent);
            return;
        }
        String[] strArr = new String[]{"mailid=" + attachDownloadPage.iaq, "attachid=" + attachDownloadPage.ibe, "texttype=html"};
        Intent intent2 = new Intent();
        intent2.putExtra("uri", "/cgi-bin/viewdocument");
        intent2.putExtra("params", strArr);
        intent2.putExtra("baseurl", q.aHA());
        intent2.putExtra("method", "get");
        intent2.putExtra("singleColumn", FileExplorerUI.HV(attachDownloadPage.icG));
        intent2.putExtra("title", attachDownloadPage.icG);
        intent2.setClass(attachDownloadPage, MailWebViewUI.class);
        attachDownloadPage.startActivity(intent2);
    }

    static /* synthetic */ void j(AttachDownloadPage attachDownloadPage) {
        long length = new File(attachDownloadPage.eR(true)).length();
        v.d("MicroMsg.AttachDownloadPage", "cur download size:" + length);
        attachDownloadPage.icH = length;
        attachDownloadPage.elJ.setProgress((int) ((100 * length) / attachDownloadPage.beE));
        attachDownloadPage.icB.setText(attachDownloadPage.getString(2131233683, new Object[]{be.aw(length), be.aw(attachDownloadPage.beE)}));
        if (attachDownloadPage.icJ != 1 || attachDownloadPage.icl == 0) {
            attachDownloadPage.icB.setVisibility(8);
        } else {
            attachDownloadPage.icB.setVisibility(0);
        }
    }

    protected final int getLayoutId() {
        return 2130903137;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.icE = getIntent().getIntExtra("is_preview", 0);
        this.icF = getIntent().getBooleanExtra("is_compress", false);
        this.icG = getIntent().getStringExtra("attach_name");
        this.iaq = getIntent().getStringExtra("mail_id");
        this.ibe = getIntent().getStringExtra("attach_id");
        this.beE = getIntent().getLongExtra("total_size", 0);
        x.aHG();
        this.icD = q.aHB();
        Fd(this.icG);
        NI();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        x.aHG().cancel(this.icl);
    }

    protected final void NI() {
        this.icy = (MMImageView) findViewById(2131755470);
        this.fQI = findViewById(2131755471);
        this.elJ = (ProgressBar) findViewById(2131755472);
        this.icz = (ImageView) findViewById(2131755473);
        this.icA = (ImageView) findViewById(2131755474);
        this.icB = (TextView) findViewById(2131755475);
        this.fQD = (Button) findViewById(2131755476);
        this.fQF = (Button) findViewById(2131755477);
        this.dtE = (TextView) findViewById(2131755478);
        this.icC = (TextView) findViewById(2131755479);
        if (FileExplorerUI.HV(this.icG)) {
            this.icy.setBackgroundResource(2131165477);
        } else if (FileExplorerUI.HW(this.icG)) {
            this.icy.setImageResource(2131165244);
        } else {
            int Gt = p.Gt(e.aS(this.icG));
            if (Gt > 0) {
                this.icy.setImageResource(Gt);
            } else {
                this.icy.setImageResource(2131165241);
            }
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AttachDownloadPage icK;

            {
                this.icK = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.icK.finish();
                return true;
            }
        });
        a(0, 2131165801, new OnMenuItemClickListener(this) {
            final /* synthetic */ AttachDownloadPage icK;

            {
                this.icK = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                g.a(this.icK, "", new String[]{this.icK.getString(2131234180)}, "", false, new c(this) {
                    final /* synthetic */ AnonymousClass2 icL;

                    {
                        this.icL = r1;
                    }

                    public final void gT(int i) {
                        switch (i) {
                            case 0:
                                AttachDownloadPage.a(this.icL.icK, this.icL.icK.eR(false));
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
        iT(false);
        aHR();
        if (this.icJ == 1) {
            aHM();
        } else {
            aHN();
        }
    }

    private void aHM() {
        this.fQI.setVisibility(0);
        this.fQD.setVisibility(8);
        this.fQF.setVisibility(8);
        this.icz.setVisibility(0);
        this.icA.setVisibility(8);
        this.icB.setVisibility(8);
        this.dtE.setVisibility(8);
        this.icC.setVisibility(8);
        this.icz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AttachDownloadPage icK;

            {
                this.icK = r1;
            }

            public final void onClick(View view) {
                this.icK.icJ = 2;
                x.aHG().cancel(this.icK.icl);
                this.icK.icl = 0;
                this.icK.aHN();
            }
        });
        this.icA.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AttachDownloadPage icK;

            {
                this.icK = r1;
            }

            public final void onClick(View view) {
                this.icK.retryCount = 0;
                this.icK.aHO();
            }
        });
    }

    private void aHN() {
        if (this.icE == 1) {
            if (FileExplorerUI.HV(this.icG)) {
                if (this.icJ == 3) {
                    Intent intent = new Intent();
                    intent.putExtra("key_favorite", true);
                    intent.putExtra("key_favorite_source_type", 9);
                    intent.putExtra("key_image_path", eR(false));
                    com.tencent.mm.plugin.qqmail.a.a.drp.c(this.nDR.nEl, intent);
                    finish();
                    return;
                } else if (this.icJ == 0 || this.icI) {
                    this.retryCount = 0;
                    this.icI = false;
                    aHO();
                    aHM();
                    return;
                }
            }
            this.fQI.setVisibility(8);
            this.dtE.setVisibility(0);
            this.icB.setVisibility(8);
            this.fQD.setVisibility(0);
            this.fQF.setVisibility(8);
            this.icC.setVisibility(0);
            this.fQD.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ AttachDownloadPage icK;

                {
                    this.icK = r1;
                }

                public final void onClick(View view) {
                    AttachDownloadPage.g(this.icK);
                }
            });
            if (this.icJ == 3) {
                this.dtE.setText(2131233688);
                this.icC.setText(2131233685);
                this.icC.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ AttachDownloadPage icK;

                    {
                        this.icK = r1;
                    }

                    public final void onClick(View view) {
                        AttachDownloadPage.b(this.icK, this.icK.eR(false));
                    }
                });
                iT(true);
                return;
            }
            this.dtE.setText(2131233688);
            if (this.icJ == 2) {
                this.icC.setText(2131233687);
            } else {
                this.icC.setText(2131233686);
            }
            this.icC.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ AttachDownloadPage icK;

                {
                    this.icK = r1;
                }

                public final void onClick(View view) {
                    this.icK.retryCount = 0;
                    this.icK.aHO();
                    this.icK.aHM();
                }
            });
        } else if (this.icE == 0) {
            this.fQI.setVisibility(8);
            this.fQD.setVisibility(8);
            this.fQF.setVisibility(0);
            this.icB.setVisibility(8);
            this.dtE.setVisibility(0);
            this.icC.setVisibility(8);
            if (this.icJ == 3) {
                this.fQF.setText(2131233682);
                iT(true);
            } else if (this.icJ == 2) {
                this.fQF.setText(2131233689);
            } else {
                this.fQF.setText(2131233680);
            }
            this.dtE.setText(2131233681);
            this.fQF.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ AttachDownloadPage icK;

                {
                    this.icK = r1;
                }

                public final void onClick(View view) {
                    if (this.icK.icJ == 3) {
                        AttachDownloadPage.b(this.icK, this.icK.eR(false));
                        return;
                    }
                    this.icK.aHM();
                    this.icK.retryCount = 0;
                    this.icK.aHO();
                }
            });
        }
    }

    private void aHO() {
        aHR();
        if (this.icJ == 4) {
            if (this.retryCount < 5) {
                this.retryCount++;
                aHO();
            } else {
                aHN();
            }
        } else if (this.icJ == 3) {
            e.h(this.icD, aHP() + ".temp", aHP());
            this.icJ = 3;
            aHN();
        }
        Map hashMap = new HashMap();
        hashMap.put("mailid", this.iaq);
        hashMap.put("attachid", this.ibe);
        hashMap.put("username", "");
        hashMap.put("offset", this.icH);
        hashMap.put("datalen", this.beE);
        hashMap.put("default_attach_name", aHP() + ".temp");
        q.c cVar = new q.c();
        cVar.ibw = false;
        cVar.ibx = false;
        this.icl = x.aHG().a("/cgi-bin/mmdownload", hashMap, cVar, new q.a(this) {
            final /* synthetic */ AttachDownloadPage icK;

            {
                this.icK = r1;
            }

            public final void onProgress(int i) {
                v.d("MicroMsg.AttachDownloadPage", "download progress : " + i);
                AttachDownloadPage.j(this.icK);
                this.icK.icJ = 1;
            }

            public final void onSuccess(String str, Map<String, String> map) {
                e.h(this.icK.icD, this.icK.aHP() + ".temp", this.icK.aHP());
                this.icK.icJ = 3;
                Toast.makeText(this.icK, this.icK.getString(2131232306) + " : " + this.icK.eR(false), 5000).show();
                this.icK.aHN();
            }

            public final void onError(int i, String str) {
                this.icK.icJ = 4;
                if (this.icK.retryCount < 5) {
                    this.icK.retryCount = this.icK.retryCount + 1;
                    this.icK.aHO();
                    return;
                }
                this.icK.aHN();
            }

            public final void onComplete() {
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a(this, i, i2, intent, true, 3);
    }

    private String aHP() {
        String substring;
        int hashCode = this.ibe.hashCode() & 65535;
        int lastIndexOf = this.icG.lastIndexOf(".");
        String str = "";
        if (lastIndexOf != -1) {
            substring = this.icG.substring(0, lastIndexOf);
            str = this.icG.substring(lastIndexOf, this.icG.length());
        } else {
            substring = this.icG;
        }
        return String.format("%s_%d%s", new Object[]{substring, Integer.valueOf(hashCode), str});
    }

    private String eR(boolean z) {
        return this.icD + aHP() + (!z ? "" : ".temp");
    }

    private String aHQ() {
        return this.icD + this.icG;
    }

    private void aHR() {
        if (e.aR(eR(true))) {
            this.icH = (long) e.aQ(eR(true));
            this.icJ = 2;
        } else if (e.aR(eR(false))) {
            this.icJ = 3;
        } else if (!e.aR(aHQ())) {
            this.icH = 0;
            this.icJ = 0;
        } else if (((long) e.aQ(aHQ())) == this.beE) {
            e.h(this.icD, this.icG, aHP());
            this.icJ = 3;
        } else if (((long) e.aQ(aHQ())) > this.beE) {
            b.deleteFile(aHQ());
            this.icH = 0;
            this.icJ = 4;
        } else {
            this.icH = 0;
            this.icJ = 0;
        }
    }
}
