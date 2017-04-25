package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

public class MailAttachListLinearLayout extends LinearLayout {
    Context context;
    List<String> ifE = new ArrayList();

    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ String ifF;
        final /* synthetic */ String ifG;
        final /* synthetic */ String ifH;
        final /* synthetic */ long ifI;
        final /* synthetic */ int ifJ;
        final /* synthetic */ String ifK;
        final /* synthetic */ MailAttachListLinearLayout ifL;

        AnonymousClass1(MailAttachListLinearLayout mailAttachListLinearLayout, String str, String str2, String str3, long j, int i, String str4) {
            this.ifL = mailAttachListLinearLayout;
            this.ifF = str;
            this.ifG = str2;
            this.ifH = str3;
            this.ifI = j;
            this.ifJ = i;
            this.ifK = str4;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.ifL.context, AttachDownloadPage.class);
            intent.putExtra("attach_name", this.ifF);
            intent.putExtra("mail_id", this.ifG);
            intent.putExtra("attach_id", this.ifH);
            intent.putExtra("total_size", this.ifI);
            intent.putExtra("is_preview", this.ifJ);
            intent.putExtra("is_compress", MailAttachListLinearLayout.yl(this.ifK));
            this.ifL.context.startActivity(intent);
        }
    }

    static /* synthetic */ boolean yl(String str) {
        return str != null && str.contains("/cgi-bin/viewcompress");
    }

    public MailAttachListLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    static String co(String str, String str2) {
        if (str == null || str.length() == 0 || str2.length() == 0) {
            return null;
        }
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return null;
        }
        int indexOf2 = str.indexOf("&", indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        return str.substring((indexOf + str2.length()) + 1, indexOf2);
    }
}
