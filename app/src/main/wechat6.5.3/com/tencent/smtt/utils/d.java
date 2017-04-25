package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public final class d {
    private static DexClassLoader pyH = null;
    private static Looper pyI = null;
    private static d pyJ = null;
    public String pyG = SQLiteDatabase.KeyEmpty;

    public interface a {
        void bNQ();

        void bNR();

        void hr(int i);
    }

    private d(Context context) {
        this.pyG = context.getDir("debugtbs", 0).getAbsolutePath() + File.separator + "plugin";
    }

    public static d fX(Context context) {
        if (pyJ == null) {
            pyJ = new d(context);
        }
        return pyJ;
    }

    @SuppressLint({"NewApi"})
    public final void a(String str, WebView webView, Context context, Looper looper) {
        TbsLog.i("debugtbs", "showPluginView -- url: " + str + "; webview: " + webView + "; context: " + context);
        String str2 = this.pyG + File.separator + "DebugPlugin.tbs";
        String str3 = this.pyG + File.separator + "DebugPlugin.apk";
        File file = new File(str2);
        File file2 = new File(str3);
        pyI = looper;
        if (file.exists()) {
            file2.delete();
            file.renameTo(file2);
        }
        if (file2.exists()) {
            try {
                str2 = c.c(context, new File(str3));
                if ("308203773082025fa003020102020448bb959d300d06092a864886f70d01010b0500306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e673020170d3136303532313039353730335a180f32303731303232323039353730335a306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e6730820122300d06092a864886f70d01010105000382010f003082010a02820101008c58deabefe95f699c6322f9a75620873b490d26520c7267eb8382a91da625a5876b2bd617116eb40b371c4f88c988c1ba73052caaa9964873c94b7755c3429fca47a6677229fb2e72908d3b17df82f1ebe70447b94c1e5b0a763dad8948312180322657325306f01e423e0409ef3a59e5c0e0b9c765a2322699a2dec2d4dbe58ec15f41752516192169d9596169f5bf08eaf8aab9893240ad679e82fc92b97d2ae98b28021dc5a752f0a69437ea603c541e6753cea52dbc8e8043fe21fd5da46066c92e0714905dfad3116f35aca52b13871c57481459aa4ca255a6482ba972bd17af90d0d2c21a57ef65376bbd4ce7078e6047060640669f3867fdc69fbb750203010001a321301f301d0603551d0e0416041450fb9b6362e829797b1b29ca55e6d5e082e93ff3300d06092a864886f70d01010b050003820101004952ffbfba7c00ee9b84f44b05ec62bc2400dc769fb2e83f80395e3fbb54e44d56e16527413d144f42bf8f21fa443bc42a7a732de9d5124df906c6d728e75ca94eefc918080876bd3ce6cb5f7f2d9cc8d8e708033afc1295c7f347fb2d2098be2e4a79220e9552171d5b5f8f59cff4c6478cc41dce24cbe942305757488d37659d3265838ee54ebe44fccbd1bec93d809f950034f5ef292f20179554d22f5856c03b4d44997fcb9b3579e16a49218fce0e2e6bfe1fd4aa0ab39f548344c244c171c203baff1a730883aaf4506b6865a45c3c9aba40c6326d4152b6ce09cc058864bec1d6422e83dad9496b83fb252b4bfb30d3a6badf996099793e11f9af618d".equals(str2)) {
                    str2 = this.pyG + File.separator + "opt";
                    file = new File(str2);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    if (pyH == null) {
                        pyH = new DexClassLoader(str3, str2, null, context.getClassLoader());
                    }
                    Map hashMap = new HashMap();
                    hashMap.put(SlookSmartClipMetaTag.TAG_TYPE_URL, str);
                    hashMap.put("tbs_version", WebView.getTbsSDKVersion(context));
                    hashMap.put("tbs_core_version", WebView.getTbsCoreVersion(context));
                    if (pyI != null) {
                        hashMap.put("looper", looper);
                    }
                    Object newInstance = pyH.loadClass("com.tencent.tbs.debug.plugin.DebugView").getConstructor(new Class[]{Context.class, Map.class}).newInstance(new Object[]{context, hashMap});
                    if (newInstance instanceof FrameLayout) {
                        FrameLayout frameLayout = (FrameLayout) newInstance;
                        webView.addView(frameLayout, new LayoutParams(-1, -1));
                        TbsLog.i("debugtbs", "show " + frameLayout + " successful in " + webView);
                        return;
                    }
                    TbsLog.e("debugtbs", "get debugview failure: " + newInstance);
                    return;
                }
                TbsLog.e("debugtbs", "verifyPlugin apk: " + str3 + " signature failed - sig: " + str2);
                Toast.makeText(context, "插件校验失败，请重试", 0).show();
                file.delete();
                file2.delete();
                return;
            } catch (Exception e) {
                e.F(file2);
                return;
            }
        }
        TbsLog.i("debugtbs", "showPluginView - going to download plugin...");
        final View relativeLayout = new RelativeLayout(context);
        final View textView = new TextView(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        textView.setText("加载中，请稍后...");
        relativeLayout.addView(textView, layoutParams);
        webView.addView(relativeLayout, new LayoutParams(-1, -1));
        final String str4 = this.pyG + File.separator + "DebugPlugin.tbs";
        e.F(new File(str4));
        final WebView webView2 = webView;
        final Context context2 = context;
        final String str5 = str;
        final a anonymousClass1 = new a(this) {
            final /* synthetic */ d pyN;

            public final void bNQ() {
                webView2.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 pyO;

                    {
                        this.pyO = r1;
                    }

                    public final void run() {
                        Toast.makeText(context2, "下载成功", 0).show();
                        relativeLayout.setVisibility(4);
                        this.pyO.pyN.a(str5, webView2, context2, d.pyI);
                    }
                });
            }

            public final void bNR() {
                webView2.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 pyO;

                    {
                        this.pyO = r1;
                    }

                    public final void run() {
                        Toast.makeText(context2, "下载失败，请检查网络", 0).show();
                    }
                });
            }

            public final void hr(final int i) {
                webView2.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 pyO;

                    public final void run() {
                        textView.setText("已下载" + i + "%");
                    }
                });
            }
        };
        new Thread() {
            public final void run() {
                InputStream inputStream;
                OutputStream H;
                InputStream inputStream2;
                Throwable th;
                Throwable th2;
                OutputStream outputStream = null;
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://soft.tbs.imtt.qq.com/17421/tbs_res_imtt_tbs_DebugPlugin_DebugPlugin.tbs").openConnection();
                    int contentLength = httpURLConnection.getContentLength();
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.connect();
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        H = e.H(new File(str4));
                        try {
                            byte[] bArr = new byte[1024];
                            int i = 0;
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                i += read;
                                H.write(bArr, 0, read);
                                anonymousClass1.hr((i * 100) / contentLength);
                            }
                            anonymousClass1.bNQ();
                            try {
                                inputStream.close();
                            } catch (Exception e) {
                            }
                            H.close();
                        } catch (Exception e2) {
                            inputStream2 = inputStream;
                            try {
                                anonymousClass1.bNR();
                                try {
                                    inputStream2.close();
                                } catch (Exception e3) {
                                }
                                try {
                                    H.close();
                                } catch (Exception e4) {
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream = inputStream2;
                                outputStream = H;
                                th2 = th;
                                try {
                                    inputStream.close();
                                } catch (Exception e5) {
                                }
                                try {
                                    outputStream.close();
                                } catch (Exception e6) {
                                }
                                throw th2;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            outputStream = H;
                            th2 = th;
                            inputStream.close();
                            outputStream.close();
                            throw th2;
                        }
                    } catch (Exception e7) {
                        H = null;
                        inputStream2 = inputStream;
                        anonymousClass1.bNR();
                        inputStream2.close();
                        H.close();
                    } catch (Throwable th5) {
                        th2 = th5;
                        inputStream.close();
                        outputStream.close();
                        throw th2;
                    }
                } catch (Exception e8) {
                    H = null;
                    anonymousClass1.bNR();
                    inputStream2.close();
                    H.close();
                } catch (Throwable th6) {
                    th2 = th6;
                    inputStream = null;
                    inputStream.close();
                    outputStream.close();
                    throw th2;
                }
            }
        }.start();
    }
}
