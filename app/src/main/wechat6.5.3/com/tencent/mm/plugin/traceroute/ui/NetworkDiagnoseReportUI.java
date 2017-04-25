package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import java.io.File;

public class NetworkDiagnoseReportUI extends MMActivity {
    private static String kmO;
    private boolean knn = false;
    private Button kno;
    private Button knp;
    private ImageView knq;
    private TextView knr;
    private TextView kns;
    private TextView knt;

    static /* synthetic */ String a(NetworkDiagnoseReportUI networkDiagnoseReportUI) {
        String string = networkDiagnoseReportUI.getString(2131234551);
        File file = new File(kmO);
        if (!file.exists()) {
            return string;
        }
        String name = file.getName();
        if (be.kS(name)) {
            return string;
        }
        int indexOf = name.indexOf(".");
        StringBuilder append = new StringBuilder().append(string).append("_");
        if (indexOf <= 0) {
            indexOf = name.length();
        }
        return append.append(name.substring(0, indexOf)).toString();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected final void NI() {
        Fd("");
        this.knq = (ImageView) findViewById(2131758436);
        this.knr = (TextView) findViewById(2131758437);
        this.kns = (TextView) findViewById(2131758438);
        this.knn = getIntent().getBooleanExtra("diagnose_result", false);
        if (this.knn) {
            this.knq.setImageResource(2130838754);
            this.knr.setText(getString(2131235729));
            this.kns.setVisibility(0);
            a(0, getString(2131232285), new OnMenuItemClickListener(this) {
                final /* synthetic */ NetworkDiagnoseReportUI knu;

                {
                    this.knu = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.knu.finish();
                    return false;
                }
            });
            return;
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ NetworkDiagnoseReportUI knu;

            {
                this.knu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.knu.finish();
                return true;
            }
        });
        kmO = getIntent().getStringExtra("diagnose_log_file_path");
        this.knq.setImageResource(2130838753);
        this.knr.setText(getString(2131235728));
        if (kmO != null && e.aQ(kmO) > 0) {
            this.knt = (TextView) findViewById(2131758441);
            this.knt.setText(getString(2131234552, new Object[]{kmO.replace("mnt/", "")}));
            findViewById(2131758441).setVisibility(0);
            findViewById(2131758443).setVisibility(0);
            this.kno = (Button) findViewById(2131758442);
            this.kno.setVisibility(0);
            this.kno.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ NetworkDiagnoseReportUI knu;

                {
                    this.knu = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.addFlags(268435456);
                    intent.putExtra("android.intent.extra.EMAIL", new String[]{"WeChat_Log@qq.com"});
                    intent.putExtra("android.intent.extra.SUBJECT", NetworkDiagnoseReportUI.a(this.knu));
                    intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(NetworkDiagnoseReportUI.kmO)));
                    intent.setType("text/plain");
                    this.knu.startActivity(intent);
                }
            });
            this.knp = (Button) findViewById(2131758440);
            this.knp.setVisibility(0);
            this.knp.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ NetworkDiagnoseReportUI knu;

                {
                    this.knu = r1;
                }

                public final void onClick(View view) {
                    if (!be.kS(NetworkDiagnoseReportUI.kmO)) {
                        File file = new File(NetworkDiagnoseReportUI.kmO);
                        if (file.exists()) {
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setDataAndType(Uri.fromFile(file), "text/plain");
                            intent.addFlags(268435456);
                            this.knu.startActivity(intent);
                        }
                    }
                }
            });
        }
    }

    protected final int getLayoutId() {
        return 2130904124;
    }
}
