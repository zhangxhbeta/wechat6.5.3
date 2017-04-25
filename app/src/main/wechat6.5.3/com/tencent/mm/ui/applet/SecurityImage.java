package com.tencent.mm.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.h;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;

public class SecurityImage extends LinearLayout {
    private h iji = null;
    public String nJJ = null;
    public String nJK = null;
    public int nJM = 0;
    ProgressBar nPV = null;
    ImageView nPW = null;
    Button nPX = null;
    EditText nPY = null;
    b nPZ;

    public static class a {
        public static SecurityImage a(Context context, int i, byte[] bArr, String str, String str2, final OnClickListener onClickListener, OnCancelListener onCancelListener, OnDismissListener onDismissListener, b bVar) {
            final SecurityImage securityImage = (SecurityImage) View.inflate(context, 2130904318, null);
            if (securityImage.nPZ != null) {
                securityImage.nPZ.nQc = null;
            }
            securityImage.nPZ = bVar;
            securityImage.nPZ.nQc = securityImage;
            securityImage.nPV = (ProgressBar) securityImage.findViewById(2131759024);
            securityImage.nPW = (ImageView) securityImage.findViewById(2131759023);
            securityImage.nPX = (Button) securityImage.findViewById(2131759025);
            securityImage.nPY = (EditText) securityImage.findViewById(2131759026);
            securityImage.nPX.setOnClickListener(new View.OnClickListener(securityImage) {
                final /* synthetic */ SecurityImage nQa;

                {
                    this.nQa = r1;
                }

                public final void onClick(View view) {
                    this.nQa.jf(false);
                    if (this.nQa.nPZ != null) {
                        this.nQa.nPZ.bAL();
                    }
                }
            });
            securityImage.a(i, bArr, str, str2);
            com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
            aVar.wm(2131234462);
            aVar.wp(2131231014).a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    onClickListener.onClick(dialogInterface, i);
                }
            });
            aVar.c(onCancelListener);
            aVar.cC(securityImage);
            aVar.jk(true);
            securityImage.iji = aVar.RX();
            securityImage.iji.setOnDismissListener(onDismissListener);
            securityImage.iji.show();
            return securityImage;
        }
    }

    public static abstract class b {
        public SecurityImage nQc;

        public abstract void bAL();
    }

    public SecurityImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(int i, byte[] bArr, String str, String str2) {
        jf(true);
        this.nJJ = str;
        this.nJK = str2;
        this.nJM = i;
        Bitmap bc = d.bc(bArr);
        if (bc != null) {
            v.i("MicroMsg.SecurityImage", "dkwt setSecImg sid:%s key:%s imgBuf:%d [%d %d]", str, str2, Integer.valueOf(bArr.length), Integer.valueOf(bc.getWidth()), Integer.valueOf(bc.getHeight()));
            this.nJJ = str;
            this.nJK = str2;
            this.nJM = i;
            if (bc != null) {
                this.nPW.setImageBitmap(bc);
                return;
            } else {
                v.e("MicroMsg.SecurityImage", "setSecImg failed, decode failed");
                return;
            }
        }
        String str3 = "MicroMsg.SecurityImage";
        String str4 = "dkwt setSecImg ERROR sid:%s key:%s imgBuf:%d";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        v.e(str3, str4, objArr);
    }

    public final String bBA() {
        return this.nPY == null ? SQLiteDatabase.KeyEmpty : this.nPY.getText().toString().trim();
    }

    public final void dismiss() {
        if (this.iji != null) {
            this.iji.dismiss();
            this.iji = null;
        }
    }

    private void jf(boolean z) {
        int i = 0;
        this.nPW.setAlpha(z ? WebView.NORMAL_MODE_ALPHA : 40);
        this.nPW.setBackgroundColor(z ? 0 : -5592406);
        ProgressBar progressBar = this.nPV;
        if (z) {
            i = 4;
        }
        progressBar.setVisibility(i);
    }
}
