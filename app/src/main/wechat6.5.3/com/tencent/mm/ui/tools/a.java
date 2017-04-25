package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.format.DateFormat;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.p;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public final class a {

    static class AnonymousClass1 extends AsyncTask<Integer, Integer, Integer> {
        private String filePath;
        final /* synthetic */ Intent hia;
        final /* synthetic */ int nx;
        private ProgressDialog oQN;
        private boolean oQO;
        final /* synthetic */ String oQP;
        final /* synthetic */ a oQQ = null;
        final /* synthetic */ p omU;
        private Uri uri;
        final /* synthetic */ Intent val$intent;

        public AnonymousClass1(Intent intent, p pVar, String str, a aVar, Intent intent2, int i) {
            this.hia = intent;
            this.omU = pVar;
            this.oQP = str;
            this.val$intent = intent2;
            this.nx = 203;
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return bJa();
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            if (!(this.oQO || be.kS(this.filePath))) {
                if (this.oQQ != null) {
                    this.val$intent.putExtra("CropImage_OutputPath", this.oQQ.BX(this.filePath));
                }
                this.val$intent.putExtra("CropImage_ImgPath", this.filePath);
                this.omU.startActivityForResult(this.val$intent, this.nx);
            }
            this.oQN.dismiss();
        }

        protected final void onPreExecute() {
            try {
                this.uri = this.hia.getData();
                this.oQO = false;
                Context context = this.omU.nDR.nEl;
                this.omU.getString(2131231164);
                this.oQN = g.a(context, this.omU.getString(2131231072), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass1 oQR;

                    {
                        this.oQR = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        this.oQR.oQO = true;
                    }
                });
            } catch (Throwable e) {
                v.a("MicroMsg.AsyncObtainImage", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }

        private Integer bJa() {
            try {
                if (this.uri != null) {
                    this.filePath = a.t(this.oQP, d.k(this.uri));
                }
            } catch (Throwable e) {
                v.a("MicroMsg.AsyncObtainImage", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
            return null;
        }
    }

    public interface a {
        String BX(String str);
    }

    public static void a(Activity activity, Intent intent, Intent intent2, String str, int i) {
        b(activity, intent, intent2, str, i, null);
    }

    public static void b(Activity activity, Intent intent, Intent intent2, String str, int i, a aVar) {
        if (intent == null || intent.getData() == null) {
            boolean z;
            String str2 = "MicroMsg.AsyncObtainImage";
            String str3 = "param error, %b";
            Object[] objArr = new Object[1];
            if (intent == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            v.e(str2, str3, objArr);
        } else if (intent.getData().toString().startsWith("content://com.google.android.gallery3d")) {
            final Intent intent3 = intent;
            final Activity activity2 = activity;
            final String str4 = str;
            final a aVar2 = aVar;
            final Intent intent4 = intent2;
            final int i2 = i;
            new AsyncTask<Integer, Integer, Integer>() {
                private String filePath;
                private ProgressDialog oQN;
                private boolean oQO;
                private Uri uri;

                protected final /* synthetic */ Object doInBackground(Object[] objArr) {
                    return bJa();
                }

                protected final /* synthetic */ void onPostExecute(Object obj) {
                    if (this.oQO || be.kS(this.filePath)) {
                        v.e("MicroMsg.AsyncObtainImage", "onPostExecute error, filePath:%s", this.filePath);
                    } else {
                        if (aVar2 != null) {
                            intent4.putExtra("CropImage_OutputPath", aVar2.BX(this.filePath));
                        }
                        intent4.putExtra("CropImage_ImgPath", this.filePath);
                        activity2.startActivityForResult(intent4, i2);
                    }
                    this.oQN.dismiss();
                }

                protected final void onPreExecute() {
                    try {
                        this.uri = intent3.getData();
                        this.oQO = false;
                        Context context = activity2;
                        activity2.getString(2131231164);
                        this.oQN = g.a(context, activity2.getString(2131231072), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass2 oQT;

                            {
                                this.oQT = r1;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                this.oQT.oQO = true;
                            }
                        });
                    } catch (Throwable e) {
                        v.a("MicroMsg.AsyncObtainImage", e, "onPreExecute", new Object[0]);
                    }
                }

                private Integer bJa() {
                    try {
                        if (this.uri != null) {
                            this.filePath = a.t(str4, d.k(this.uri));
                        }
                    } catch (Throwable e) {
                        v.a("MicroMsg.AsyncObtainImage", e, "doInBackground", new Object[0]);
                    }
                    return null;
                }
            }.execute(new Integer[]{Integer.valueOf(0)});
        } else {
            String b = b(activity, intent, str);
            v.i("MicroMsg.AsyncObtainImage", "resolvePhotoFromIntent, filePath:%s", b);
            if (!be.kS(b)) {
                if (aVar != null) {
                    intent2.putExtra("CropImage_OutputPath", aVar.BX(b));
                }
                intent2.putExtra("CropImage_ImgPath", b);
                activity.startActivityForResult(intent2, i);
            }
        }
    }

    public static String b(Context context, Intent intent, String str) {
        String str2 = null;
        if (context == null || intent == null || str == null) {
            v.e("MicroMsg.AsyncObtainImage", "resolvePhotoFromIntent fail, invalid argument");
        } else {
            Uri parse = Uri.parse(intent.toURI());
            Cursor query = context.getContentResolver().query(parse, null, null, null, null);
            if (query != null && query.getCount() > 0) {
                v.i("MicroMsg.AsyncObtainImage", "resolve photo from cursor");
                try {
                    if (parse.toString().startsWith("content://com.google.android.gallery3d")) {
                        str2 = t(str, d.k(intent.getData()));
                    } else {
                        query.moveToFirst();
                        str2 = query.getString(query.getColumnIndex("_data"));
                        v.i("MicroMsg.AsyncObtainImage", "photo from resolver, path:" + str2);
                    }
                } catch (Throwable e) {
                    v.a("MicroMsg.AsyncObtainImage", e, "resolve photo error.", new Object[0]);
                }
            } else if (intent.getData() != null) {
                String path = intent.getData().getPath();
                if (!new File(path).exists()) {
                    path = null;
                }
                v.i("MicroMsg.AsyncObtainImage", "photo file from data, path:" + path);
                if (path == null) {
                    path = intent.getData().getHost();
                    if (new File(path).exists()) {
                        str2 = path;
                    }
                    v.i("MicroMsg.AsyncObtainImage", "photo file from data, host:" + str2);
                } else {
                    str2 = path;
                }
            } else if (intent.getAction() == null || !intent.getAction().equals("inline-data")) {
                if (query != null) {
                    query.close();
                }
                v.e("MicroMsg.AsyncObtainImage", "resolve photo from intent failed");
            } else {
                str2 = t(str, (Bitmap) intent.getExtras().get("data"));
                v.i("MicroMsg.AsyncObtainImage", "resolve photo from action-inline-data:%s", str2);
            }
            if (query != null) {
                query.close();
            }
        }
        return str2;
    }

    public static String t(String str, Bitmap bitmap) {
        try {
            String str2 = str + (com.tencent.mm.a.g.m(DateFormat.format("yyyy-MM-dd-HH-mm-ss", System.currentTimeMillis()).toString().getBytes()) + ".jpg");
            File file = new File(str2);
            if (!file.exists()) {
                file.createNewFile();
            }
            OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(CompressFormat.PNG, 100, bufferedOutputStream);
            bufferedOutputStream.close();
            v.i("MicroMsg.AsyncObtainImage", "photo image from data, path:" + str2);
            return str2;
        } catch (Throwable e) {
            v.a("MicroMsg.AsyncObtainImage", e, "saveBmp Error.", new Object[0]);
            return null;
        }
    }
}
