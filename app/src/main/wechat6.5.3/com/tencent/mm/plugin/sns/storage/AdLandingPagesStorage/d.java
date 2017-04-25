package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import java.io.File;

public final class d {

    public interface a {
        void Bg(String str);

        void aRx();

        void aTV();
    }

    public interface b {
        void Bi(String str);

        void Bj(String str);

        void Bk(String str);
    }

    public static String cI(String str, String str2) {
        return Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/" + str + "_img_" + z.Kg(str2);
    }

    public static String cJ(String str, String str2) {
        FileOp.jS(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages");
        return Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/" + str + "_sight_" + z.Kg(str2);
    }

    public static Bitmap cK(String str, String str2) {
        Bitmap bitmap = null;
        if (!(be.kS(str2) || be.kS(str))) {
            try {
                String cI = cI(str, str2);
                if (!TextUtils.isEmpty(cI) && new File(cI).exists()) {
                    bitmap = BitmapFactory.decodeFile(cI);
                }
            } catch (Throwable e) {
                v.e("AdLandingPagesDownloadResourceHelper", "%s", new Object[]{be.e(e)});
            }
        }
        return bitmap;
    }

    public static void a(String str, int i, a aVar) {
        a("adId", str, false, i, 0, aVar);
    }

    public static void a(final String str, final String str2, boolean z, int i, int i2, final a aVar) {
        if (be.kS(str2) || be.kS(str)) {
            aVar.aTV();
            return;
        }
        v.i("AdLandingPagesDownloadResourceHelper", "start download img for " + str2 + " for adid:" + str);
        final String cI = cI(str, str2);
        new b(cI, z, i, 0, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.b.a() {
            public final void aRx() {
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 jBa;

                    {
                        this.jBa = r1;
                    }

                    public final void run() {
                        aVar.aRx();
                    }
                });
            }

            public final void aTV() {
                v.e("AdLandingPagesDownloadResourceHelper", " download error img for " + str2 + " for adid:" + str);
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 jBa;

                    {
                        this.jBa = r1;
                    }

                    public final void run() {
                        aVar.aTV();
                    }
                });
            }

            public final void aUi() {
                v.i("AdLandingPagesDownloadResourceHelper", " download success img for " + str2 + " for adid:" + str);
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 jBa;

                    {
                        this.jBa = r1;
                    }

                    public final void run() {
                        aVar.Bg(cI);
                    }
                });
            }
        }).execute(new String[]{str2});
    }

    public static void a(final String str, final String str2, boolean z, final a aVar) {
        FileOp.jS(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages");
        final String str3 = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/" + str + "_sight_" + z.Kg(str2);
        if (FileOp.aR(str3)) {
            ad.o(new Runnable() {
                public final void run() {
                    aVar.Bg(str3);
                }
            });
            return;
        }
        v.i("AdLandingPagesDownloadResourceHelper", "start download sight for " + str2 + " for adid:" + str);
        new b(str3, z, 61, 0, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.b.a() {
            public final void aRx() {
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 jBb;

                    {
                        this.jBb = r1;
                    }

                    public final void run() {
                        aVar.aRx();
                    }
                });
            }

            public final void aTV() {
                v.e("AdLandingPagesDownloadResourceHelper", " download error sight for " + str2 + " for adid:" + str);
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 jBb;

                    {
                        this.jBb = r1;
                    }

                    public final void run() {
                        aVar.aTV();
                    }
                });
            }

            public final void aUi() {
                v.i("AdLandingPagesDownloadResourceHelper", " download success sight for " + str2 + " for adid:" + str);
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 jBb;

                    {
                        this.jBb = r1;
                    }

                    public final void run() {
                        aVar.Bg(str3);
                    }
                });
            }
        }).execute(new String[]{str2});
    }

    public static void a(final String str, final String str2, boolean z, int i, final b bVar) {
        if (be.kS(str2) || be.kS(str)) {
            bVar.Bj("the res or adId is null");
            return;
        }
        cI(str, str2);
        String str3 = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages";
        String str4 = str + "_stream_" + z.Kg(str2);
        v.i("AdLandingPagesDownloadResourceHelper", "start download video for " + str2 + " for adid:" + str);
        new aa(str3, str4, z, i, 0, com.tencent.mm.plugin.sns.e.ad.aqz(), new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa.a() {
            public final void aW(final String str, final int i) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 jBd;

                    public final void run() {
                        bVar.Bi(str);
                    }
                });
            }

            public final void Bj(final String str) {
                v.e("AdLandingPagesDownloadResourceHelper", " download error video for " + str2 + " for adid:" + str);
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 jBd;

                    public final void run() {
                        bVar.Bj(str);
                    }
                });
            }

            public final void Bk(final String str) {
                v.i("AdLandingPagesDownloadResourceHelper", " download success video for " + str2 + " for adid:" + str);
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 jBd;

                    public final void run() {
                        bVar.Bk(str);
                    }
                });
            }
        }).execute(new String[]{str2});
    }
}
