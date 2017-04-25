package com.tencent.mm.ae;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class o implements com.tencent.mm.ae.b.c {
    List<c> cOD = new LinkedList();
    c cOE = null;
    boolean cOF = false;

    public interface a {
        void g(String str, Bitmap bitmap);
    }

    private static class b {
        public Bitmap bitmap;
        public String path;

        public b(String str, Bitmap bitmap) {
            this.path = str;
            this.bitmap = bitmap;
        }
    }

    private static class c {
        public a cOH;
        public String url;

        public c(String str, a aVar) {
            this.url = str;
            this.cOH = aVar;
        }
    }

    public final void a(String str, a aVar) {
        if (be.kS(str) || aVar == null) {
            v.e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
        } else if (this.cOE != null && this.cOE.url.equals(str) && this.cOE.cOH == aVar) {
            v.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
        } else {
            for (c cVar : this.cOD) {
                if (cVar.url.equals(str) && cVar.cOH == aVar) {
                    v.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
                    return;
                }
            }
            this.cOD.add(new c(str, aVar));
            GO();
        }
    }

    final void GO() {
        while (this.cOE == null && this.cOD.size() != 0) {
            this.cOE = (c) this.cOD.get(0);
            this.cOD.remove(0);
            this.cOF = false;
            n.GG();
            Bitmap gu = b.gu(this.cOE.url);
            if (gu != null) {
                v.d("MicroMsg.UrlImageCacheService", "find bitmap in cache of " + this.cOE.url);
                if (!this.cOF) {
                    this.cOE.cOH.g(this.cOE.url, gu);
                }
                this.cOE = null;
            } else {
                new AsyncTask<String, Integer, Bitmap>(this) {
                    final /* synthetic */ o cOG;

                    {
                        this.cOG = r1;
                    }

                    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
                        String[] strArr = (String[]) objArr;
                        if (strArr.length <= 0) {
                            return null;
                        }
                        String jc = o.jc(strArr[0]);
                        return new File(jc).exists() ? d.JV(jc) : null;
                    }

                    protected final /* synthetic */ void onPostExecute(Object obj) {
                        Bitmap bitmap = (Bitmap) obj;
                        if (bitmap != null) {
                            v.d("MicroMsg.UrlImageCacheService", "load from sdcard");
                            if (!this.cOG.cOF) {
                                n.GG();
                                b.f(this.cOG.cOE.url, bitmap);
                                this.cOG.cOE.cOH.g(this.cOG.cOE.url, bitmap);
                            }
                            this.cOG.cOE = null;
                            this.cOG.GO();
                            return;
                        }
                        v.i("MicroMsg.UrlImageCacheService", "try load from " + this.cOG.cOE.url);
                        n.GG().a(this.cOG.cOE.url, this.cOG);
                    }
                }.execute(new String[]{this.cOE.url});
                return;
            }
        }
        v.d("MicroMsg.UrlImageCacheService", "task is downing or no more task");
    }

    static String jc(String str) {
        try {
            String encode = URLEncoder.encode(str, "UTF-8");
            if (be.kS(encode)) {
                v.e("MicroMsg.UrlImageCacheService", "encode result is null: " + str);
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(e.cgf);
            int length = encode.length();
            int i = 0;
            while (i < length) {
                stringBuilder.append('/');
                if (i + 20 < length) {
                    stringBuilder.append(encode.substring(i, i + 20));
                    i += 20;
                } else {
                    stringBuilder.append(encode.substring(i, length));
                    i = length;
                }
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            v.e("MicroMsg.UrlImageCacheService", "try encode unsupport character: " + str);
            return null;
        }
    }

    public final void j(Bitmap bitmap) {
        if (bitmap == null) {
            v.e("MicroMsg.UrlImageCacheService", "load from url failed: " + this.cOE.url);
            this.cOE = null;
            GO();
            return;
        }
        v.i("MicroMsg.UrlImageCacheService", "load from %s successed", this.cOE.url);
        new AsyncTask<b, Integer, Integer>(this) {
            final /* synthetic */ o cOG;

            {
                this.cOG = r1;
            }

            protected final /* synthetic */ Object doInBackground(Object[] objArr) {
                return AnonymousClass2.a((b[]) objArr);
            }

            private static Integer a(b... bVarArr) {
                if (bVarArr.length == 0 || be.kS(bVarArr[0].path) || bVarArr[0].bitmap == null) {
                    v.e("MicroMsg.UrlImageCacheService", "nothing to save");
                } else {
                    try {
                        d.a(bVarArr[0].bitmap, 100, CompressFormat.PNG, bVarArr[0].path, false);
                    } catch (IOException e) {
                        v.e("MicroMsg.UrlImageCacheService", "save bitmap to image failed: " + e.toString());
                    }
                }
                return null;
            }
        }.execute(new b[]{new b(jc(this.cOE.url), bitmap)});
        if (!this.cOF) {
            n.GG();
            b.f(this.cOE.url, bitmap);
            this.cOE.cOH.g(this.cOE.url, bitmap);
        }
        this.cOE = null;
        GO();
    }
}
