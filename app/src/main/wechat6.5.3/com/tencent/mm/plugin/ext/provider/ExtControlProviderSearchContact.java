package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.bg.d;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.ext.b.b;
import com.tencent.mm.pluginsdk.e.a.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.n;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderSearchContact extends ExtContentProviderBase {
    private static List<String> ejp = new ArrayList();
    private static final String[] fHP = new String[]{"userId", "nickname", "avatar", "content", "msgId", "msgType"};
    private Cursor fHT = null;

    static {
        int i = 0;
        String[] strArr = m.crG;
        int length = strArr.length;
        while (i < length) {
            ejp.add(strArr[i]);
            i++;
        }
        ejp.add("officialaccounts");
        ejp.add("helper_entry");
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        v.d("MicroMsg.ExtControlProviderSearchContact", "query()");
        a(uri, getContext(), 16);
        if (uri == null) {
            kB(3);
            return null;
        } else if (be.kS(this.fHh) || be.kS(akY())) {
            kB(3);
            return null;
        } else if (!WN()) {
            kB(1);
            return this.enz;
        } else if (!bG(getContext())) {
            v.w("MicroMsg.ExtControlProviderSearchContact", "invalid appid ! return null");
            kB(2);
            return null;
        } else if (strArr2 == null || strArr2.length == 0) {
            v.e("MicroMsg.ExtControlProviderSearchContact", "invaild selections");
            kB(3);
            return null;
        } else {
            String trim = strArr2[0].trim();
            if (be.kS(trim)) {
                v.e("MicroMsg.ExtControlProviderSearchContact", "filter should not be null or nil");
                kB(3);
                return null;
            }
            final Cursor a = ak.yW().cqX.a(trim, "@micromsg.no.verify.biz.qq.com", null, ejp, false, false, false, 1, null);
            if (a == null) {
                v.e("MicroMsg.ExtControlProviderSearchContact", "cursor is null");
                kB(3);
                return null;
            }
            final a aVar = new a();
            aVar.b(4000, new Runnable(this) {
                final /* synthetic */ ExtControlProviderSearchContact fHV;

                public final void run() {
                    this.fHV.fHT = ExtControlProviderSearchContact.c(a);
                    aVar.countDown();
                }
            });
            if (this.fHT != null) {
                kB(0);
            } else {
                kB(4);
            }
            return this.fHT;
        }
    }

    public static Cursor c(Cursor cursor) {
        Object dVar = new d(fHP, (byte) 0);
        try {
            if (cursor.moveToFirst()) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    ab uVar = new u();
                    uVar.b(cursor);
                    if (!m.dE(uVar.field_username)) {
                        ByteArrayOutputStream byteArrayOutputStream;
                        Bitmap b = n.Bq().b(uVar.field_username, true, 0);
                        if (b != null) {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            b.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                        } else {
                            v.w("MicroMsg.ExtControlProviderSearchContact", "get useravatar is null");
                            byteArrayOutputStream = null;
                        }
                        ak.yW();
                        at[] bU = c.wJ().bU(uVar.field_username, 1);
                        byte[] bArr;
                        if (bU == null || bU.length != 1) {
                            v.w("MicroMsg.ExtControlProviderSearchContact", "get msginfo failed");
                            Object[] objArr = new Object[6];
                            objArr[0] = com.tencent.mm.plugin.ext.a.a.bv((long) ((int) uVar.chr));
                            objArr[1] = uVar.tU();
                            if (byteArrayOutputStream == null) {
                                bArr = null;
                            } else {
                                bArr = byteArrayOutputStream.toByteArray();
                            }
                            objArr[2] = bArr;
                            objArr[3] = SQLiteDatabase.KeyEmpty;
                            objArr[4] = "0";
                            objArr[5] = Integer.valueOf(0);
                            dVar.addRow(objArr);
                        } else {
                            String str;
                            Object[] objArr2 = new Object[6];
                            objArr2[0] = com.tencent.mm.plugin.ext.a.a.bv((long) ((int) uVar.chr));
                            objArr2[1] = uVar.tU();
                            if (byteArrayOutputStream == null) {
                                bArr = null;
                            } else {
                                bArr = byteArrayOutputStream.toByteArray();
                            }
                            objArr2[2] = bArr;
                            if (bU[0].field_type == 1) {
                                str = bU[0].field_content;
                            } else {
                                str = SQLiteDatabase.KeyEmpty;
                            }
                            objArr2[3] = str;
                            objArr2[4] = com.tencent.mm.plugin.ext.a.a.bv(bU[0].field_msgId);
                            objArr2[5] = Integer.valueOf(b.D(bU[0]));
                            dVar.addRow(objArr2);
                        }
                    }
                    if (!cursor.moveToNext() || i2 >= 15) {
                        break;
                    }
                    i = i2;
                }
            }
            cursor.close();
            return dVar;
        } catch (Throwable e) {
            v.e("MicroMsg.ExtControlProviderSearchContact", e.getMessage());
            v.a("MicroMsg.ExtControlProviderSearchContact", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            if (cursor != null) {
                cursor.close();
            }
            dVar.close();
            return null;
        }
    }

    public String getType(Uri uri) {
        return null;
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
}
