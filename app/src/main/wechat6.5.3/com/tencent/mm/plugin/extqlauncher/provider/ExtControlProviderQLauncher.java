package com.tencent.mm.plugin.extqlauncher.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.plugin.extqlauncher.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class ExtControlProviderQLauncher extends ExtContentProviderBase {
    private static final String[] fGL = new String[]{"retCode"};
    private static final UriMatcher fHn;
    private static final String[] fIK = new String[]{SlookAirButtonFrequentContactAdapter.ID, "count"};
    private Context context;
    private String[] fGX;
    private int fIL = -1;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        fHn = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.extqlauncher", "openQRCodeScan", 18);
        fHn.addURI("com.tencent.mm.plugin.extqlauncher", "batchAddShortcut", 19);
        fHn.addURI("com.tencent.mm.plugin.extqlauncher", "getUnreadCount", 20);
    }

    public ExtControlProviderQLauncher(String[] strArr, int i, Context context) {
        this.fGX = strArr;
        this.fIL = i;
        this.context = context;
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        v.d("MicroMsg.ExtControlProviderQLauncher", "query()");
        a(uri, this.context, this.fIL, this.fGX);
        if (uri == null) {
            kB(3);
            return null;
        } else if (be.kS(this.fHh) || be.kS(akY())) {
            kB(3);
            return null;
        } else if (!WN()) {
            kB(1);
            return this.enz;
        } else if (bG(this.context)) {
            Cursor matrixCursor;
            switch (this.fIL) {
                case 18:
                    v.d("MicroMsg.ExtControlProviderQLauncher", "toScanQRCode");
                    if (this.context == null) {
                        kB(4);
                        return null;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 1);
                    intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                    c.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                    matrixCursor = new MatrixCursor(fGL);
                    matrixCursor.addRow(new Object[]{Integer.valueOf(1)});
                    kB(0);
                    return matrixCursor;
                case 19:
                    v.d("MicroMsg.ExtControlProviderQLauncher", "toCreateShortcut");
                    if (this.context == null) {
                        kB(4);
                        return null;
                    }
                    c.b(this.context, "extqlauncher", ".ui.QLauncherCreateShortcutUI", new Intent());
                    matrixCursor = new MatrixCursor(fGL);
                    matrixCursor.addRow(new Object[]{Integer.valueOf(1)});
                    kB(0);
                    return matrixCursor;
                case 20:
                    return q(strArr2);
                default:
                    kB(3);
                    return null;
            }
        } else {
            v.w("MicroMsg.ExtControlProviderQLauncher", "invalid appid ! return null");
            kB(2);
            return null;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private Cursor q(String[] strArr) {
        v.d("MicroMsg.ExtControlProviderQLauncher", "getUnreadCount");
        if (this.context == null) {
            kB(4);
            return null;
        } else if (strArr == null || strArr.length <= 0) {
            v.e("MicroMsg.ExtControlProviderQLauncher", "wrong args");
            kB(3);
            return null;
        } else {
            MatrixCursor matrixCursor = new MatrixCursor(fIK);
            int i = 0;
            while (i < strArr.length && i < 10) {
                try {
                    if (!be.kS(strArr[i])) {
                        if (strArr[i].equals("0")) {
                            Object[] objArr = new Object[2];
                            objArr[0] = strArr[i];
                            b.alf();
                            objArr[1] = Integer.valueOf(b.alg());
                            matrixCursor.addRow(objArr);
                        } else {
                            String pq = com.tencent.mm.plugin.base.a.c.pq(strArr[i]);
                            if (be.kS(pq)) {
                                continue;
                            } else {
                                ak.yW();
                                if (com.tencent.mm.model.c.wK().Mh(pq) != null) {
                                    matrixCursor.addRow(new Object[]{strArr[i], Integer.valueOf(com.tencent.mm.model.c.wK().Mh(pq).field_unReadCount)});
                                } else {
                                    matrixCursor.addRow(new Object[]{strArr[i], Integer.valueOf(0)});
                                }
                            }
                        }
                    }
                    i++;
                } catch (Exception e) {
                    v.e("MicroMsg.ExtControlProviderQLauncher", "exception in updateShortcut, %s", new Object[]{e.getMessage()});
                    kB(4);
                    matrixCursor.close();
                    return null;
                }
            }
            kB(0);
            return matrixCursor;
        }
    }
}
