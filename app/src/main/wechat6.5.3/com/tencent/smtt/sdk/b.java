package com.tencent.smtt.sdk;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.export.external.interfaces.DownloadListener;
import com.tencent.smtt.sdk.a.c;

final class b implements DownloadListener {
    private WebView dOZ;
    private DownloadListener puw;

    public b(WebView webView, DownloadListener downloadListener) {
        this.puw = downloadListener;
        this.dOZ = webView;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        onDownloadStart(str, null, null, str2, str3, str4, j, null, null);
    }

    public final void onDownloadStart(String str, String str2, byte[] bArr, String str3, String str4, String str5, long j, String str6, String str7) {
        if (this.puw != null) {
            this.puw.onDownloadStart(str, str3, str4, str5, j);
        } else if (QbSdk.canOpenMimeFileType(this.dOZ.getContext(), str5)) {
            Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("key_reader_sdk_url", str);
            intent.putExtra("key_reader_sdk_type", 1);
            intent.setData(Uri.parse(str));
            this.dOZ.getContext().startActivity(intent);
        } else {
            c.a(this.dOZ.getContext(), str, null, null);
        }
    }

    public final void onDownloadVideo(String str, long j, int i) {
    }
}
