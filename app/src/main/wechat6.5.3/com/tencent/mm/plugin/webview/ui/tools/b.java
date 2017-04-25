package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.http.SslCertificate;
import android.net.http.SslCertificate.DName;
import android.util.Base64;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.WebView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20141210", reviewer = 20, vComment = {EType.HTTPSCHECK})
public final class b {
    Context context;
    WebView liG;
    d liH;
    Map<String, List<SslErrorHandler>> liI;
    Map<String, Boolean> liJ;
    private final SimpleDateFormat liK = new SimpleDateFormat("yyyy-MM-dd HH:mmZ", Locale.getDefault());

    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ String liL;
        final /* synthetic */ b liM;

        AnonymousClass1(b bVar, String str) {
            this.liM = bVar;
            this.liL = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            List<SslErrorHandler> list = (List) this.liM.liI.get(this.liL);
            if (list == null) {
                v.e("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, continue selected, list should not be null");
                return;
            }
            this.liM.liJ.put(this.liL, Boolean.valueOf(true));
            v.i("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, continue selected, list size = %d", new Object[]{Integer.valueOf(list.size())});
            for (SslErrorHandler proceed : list) {
                proceed.proceed();
            }
            list.clear();
        }
    }

    class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ String liL;
        final /* synthetic */ b liM;

        AnonymousClass2(b bVar, String str) {
            this.liM = bVar;
            this.liL = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            List<SslErrorHandler> list = (List) this.liM.liI.get(this.liL);
            if (list == null) {
                v.e("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, cancel selected, list should not be null");
                return;
            }
            this.liM.liJ.put(this.liL, Boolean.valueOf(false));
            v.i("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, cancel selected, list size = %d", new Object[]{Integer.valueOf(list.size())});
            for (SslErrorHandler cancel : list) {
                cancel.cancel();
            }
            list.clear();
            this.liM.liG.clearSslPreferences();
        }
    }

    public b(Context context, WebView webView, d dVar) {
        this.context = context;
        this.liG = webView;
        this.liH = dVar;
        this.liI = new HashMap();
        this.liJ = new HashMap();
    }

    @TargetApi(14)
    final String a(String str, SslError sslError) {
        try {
            Object obj;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<sslerror>");
            stringBuilder.append("<primaryerror>");
            if (sslError == null) {
                obj = "-1";
            } else {
                obj = Integer.valueOf(sslError.getPrimaryError());
            }
            stringBuilder.append(obj);
            stringBuilder.append("</primaryerror>");
            stringBuilder.append("<clienttime>");
            stringBuilder.append(Base64.encodeToString(this.liK.format(new Date()).getBytes(), 0));
            stringBuilder.append("</clienttime>");
            stringBuilder.append("<currenturl>");
            if (!be.kS(str)) {
                stringBuilder.append(be.KJ(str));
            }
            stringBuilder.append("</currenturl>");
            SslCertificate certificate = sslError == null ? null : sslError.getCertificate();
            if (certificate != null) {
                DName issuedBy = certificate.getIssuedBy();
                if (issuedBy != null) {
                    stringBuilder.append("<issuedby>");
                    if (issuedBy.getDName() != null) {
                        stringBuilder.append(Base64.encodeToString(issuedBy.getDName().getBytes(), 0));
                    }
                    stringBuilder.append("</issuedby>");
                }
                issuedBy = certificate.getIssuedTo();
                if (issuedBy != null) {
                    stringBuilder.append("<issuedto>");
                    if (issuedBy.getDName() != null) {
                        stringBuilder.append(Base64.encodeToString(issuedBy.getDName().getBytes(), 0));
                    }
                    stringBuilder.append("</issuedto>");
                }
                String validNotAfter = certificate.getValidNotAfter();
                if (validNotAfter != null) {
                    stringBuilder.append("<getvalidnotafter>");
                    stringBuilder.append(Base64.encodeToString(validNotAfter.getBytes(), 0));
                    stringBuilder.append("</getvalidnotafter>");
                }
                String validNotBefore = certificate.getValidNotBefore();
                if (validNotBefore != null) {
                    stringBuilder.append("<getvalidnotbefore>");
                    stringBuilder.append(Base64.encodeToString(validNotBefore.getBytes(), 0));
                    stringBuilder.append("</getvalidnotbefore>");
                }
            }
            stringBuilder.append("</sslerror>");
            return stringBuilder.toString();
        } catch (Exception e) {
            v.w("MicroMsg.WebView.MMSslErrorHandler", "buildXml ex = %s", new Object[]{e.getMessage()});
            return "";
        }
    }
}
