package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.mp;
import com.tencent.mm.e.a.mr;
import com.tencent.mm.model.m;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class SnsAdNativeLandingTestUI extends MMActivity {
    private ac cnC = new ac();
    private int duration = 0;
    private int gef;
    private int geg;
    private double iVE = 0.0d;
    SnsAdNativeLandingPagesVideoPlayerLoadingBar jzT;
    private int jzn;
    private VideoSightView jzo;

    private static class a extends AsyncTask<String, Void, Void> {
        private static Set<String> jAr = new HashSet();
        private static byte[] jAs = new byte[0];
        final String aST;
        final String filePath;
        final ac handler;
        final String jAt;
        final String jAu;
        final String jAv;
        final int jAx;
        final a jLP;

        interface a {
            void Bj(String str);

            void Bk(String str);

            void aW(String str, int i);
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return t((String[]) objArr);
        }

        public a(String str, String str2, ac acVar, a aVar) {
            this(str, str2, acVar, aVar, 0);
        }

        public a(String str, String str2, final ac acVar, final a aVar, int i) {
            FileOp.jS(str);
            this.jAv = str;
            this.aST = str2;
            this.filePath = str + "/" + str2;
            this.jAu = "temp_" + str2;
            this.jAt = str + "/" + this.jAu;
            this.handler = acVar;
            this.jAx = i;
            this.jLP = new a(this) {
                final /* synthetic */ a jLR;

                public final void aW(final String str, final int i) {
                    acVar.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 jLS;

                        public final void run() {
                            aVar.aW(str, i);
                        }
                    });
                }

                public final void Bj(final String str) {
                    acVar.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 jLS;

                        public final void run() {
                            aVar.Bj(str);
                        }
                    });
                }

                public final void Bk(final String str) {
                    acVar.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 jLS;

                        public final void run() {
                            aVar.Bk(str);
                        }
                    });
                }
            };
        }

        private Void t(String... strArr) {
            InputStream inputStream;
            Exception exception;
            HttpURLConnection httpURLConnection;
            Throwable th;
            Exception exception2;
            HttpURLConnection httpURLConnection2 = null;
            int i = 0;
            synchronized (jAs) {
                if (jAr.contains(strArr[0])) {
                } else {
                    jAr.add(strArr[0]);
                    OutputStream fileOutputStream;
                    try {
                        if (FileOp.aR(this.filePath)) {
                            this.jLP.Bk(this.filePath);
                            synchronized (jAs) {
                                jAr.remove(strArr[0]);
                            }
                        } else {
                            if (FileOp.aR(this.jAt)) {
                                FileOp.deleteFile(this.jAt);
                            }
                            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(strArr[0]).openConnection();
                            try {
                                httpURLConnection3.connect();
                                if (httpURLConnection3.getResponseCode() != 200) {
                                    this.jLP.Bj("Server returned HTTP " + httpURLConnection3.getResponseCode() + " " + httpURLConnection3.getResponseMessage());
                                    if (httpURLConnection3 != null) {
                                        httpURLConnection3.disconnect();
                                    }
                                    synchronized (jAs) {
                                        jAr.remove(strArr[0]);
                                    }
                                } else {
                                    httpURLConnection3.getContentLength();
                                    inputStream = httpURLConnection3.getInputStream();
                                    try {
                                        fileOutputStream = new FileOutputStream(this.jAt);
                                    } catch (Exception e) {
                                        fileOutputStream = null;
                                        HttpURLConnection httpURLConnection4 = httpURLConnection3;
                                        exception = e;
                                        httpURLConnection = httpURLConnection4;
                                        try {
                                            this.jLP.Bj(exception.getMessage());
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (IOException e2) {
                                                    if (httpURLConnection != null) {
                                                        httpURLConnection.disconnect();
                                                    }
                                                    synchronized (jAs) {
                                                        jAr.remove(strArr[0]);
                                                    }
                                                    return null;
                                                }
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            synchronized (jAs) {
                                                jAr.remove(strArr[0]);
                                            }
                                            return null;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            httpURLConnection2 = httpURLConnection;
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (IOException e3) {
                                                    if (httpURLConnection2 != null) {
                                                        httpURLConnection2.disconnect();
                                                    }
                                                    synchronized (jAs) {
                                                        jAr.remove(strArr[0]);
                                                    }
                                                    throw th;
                                                }
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (httpURLConnection2 != null) {
                                                httpURLConnection2.disconnect();
                                            }
                                            synchronized (jAs) {
                                                jAr.remove(strArr[0]);
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        fileOutputStream = null;
                                        httpURLConnection2 = httpURLConnection3;
                                        th = th3;
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection2 != null) {
                                            httpURLConnection2.disconnect();
                                        }
                                        synchronized (jAs) {
                                            jAr.remove(strArr[0]);
                                        }
                                        throw th;
                                    }
                                    try {
                                        byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
                                        int i2 = 0;
                                        while (true) {
                                            int read = inputStream.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            fileOutputStream.write(bArr, 0, read);
                                            i2 += read;
                                            if (this.jAx != 0 && i2 - r1 >= this.jAx) {
                                                this.jLP.aW(this.jAt, i2);
                                                i = i2;
                                            }
                                        }
                                        FileOp.ab(this.jAt, this.filePath);
                                        this.jLP.Bk(this.filePath);
                                        try {
                                            fileOutputStream.close();
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                        } catch (IOException e4) {
                                        }
                                        if (httpURLConnection3 != null) {
                                            httpURLConnection3.disconnect();
                                        }
                                        synchronized (jAs) {
                                            jAr.remove(strArr[0]);
                                        }
                                    } catch (Exception e5) {
                                        exception2 = e5;
                                        httpURLConnection = httpURLConnection3;
                                        exception = exception2;
                                        this.jLP.Bj(exception.getMessage());
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        synchronized (jAs) {
                                            jAr.remove(strArr[0]);
                                        }
                                        return null;
                                    } catch (Throwable th32) {
                                        httpURLConnection2 = httpURLConnection3;
                                        th = th32;
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection2 != null) {
                                            httpURLConnection2.disconnect();
                                        }
                                        synchronized (jAs) {
                                            jAr.remove(strArr[0]);
                                        }
                                        throw th;
                                    }
                                }
                            } catch (Exception e52) {
                                fileOutputStream = null;
                                inputStream = null;
                                exception2 = e52;
                                httpURLConnection = httpURLConnection3;
                                exception = exception2;
                                this.jLP.Bj(exception.getMessage());
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                synchronized (jAs) {
                                    jAr.remove(strArr[0]);
                                }
                                return null;
                            } catch (Throwable th322) {
                                fileOutputStream = null;
                                inputStream = null;
                                httpURLConnection2 = httpURLConnection3;
                                th = th322;
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                synchronized (jAs) {
                                    jAr.remove(strArr[0]);
                                }
                                throw th;
                            }
                        }
                    } catch (Exception e6) {
                        exception = e6;
                        httpURLConnection = null;
                        fileOutputStream = null;
                        inputStream = null;
                        this.jLP.Bj(exception.getMessage());
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        synchronized (jAs) {
                            jAr.remove(strArr[0]);
                        }
                        return null;
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = null;
                        inputStream = null;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        synchronized (jAs) {
                            jAr.remove(strArr[0]);
                        }
                        throw th;
                    }
                }
            }
            return null;
        }
    }

    static /* synthetic */ void b(SnsAdNativeLandingTestUI snsAdNativeLandingTestUI) {
        snsAdNativeLandingTestUI.iVE = snsAdNativeLandingTestUI.jzo.aPB();
        snsAdNativeLandingTestUI.jzo.pause();
        snsAdNativeLandingTestUI.cnC.post(new Runnable(snsAdNativeLandingTestUI) {
            final /* synthetic */ SnsAdNativeLandingTestUI jLL;

            {
                this.jLL = r1;
            }

            public final void run() {
                this.jLL.jzT.fA(false);
            }
        });
    }

    static /* synthetic */ void c(SnsAdNativeLandingTestUI snsAdNativeLandingTestUI) {
        snsAdNativeLandingTestUI.jzo.i(snsAdNativeLandingTestUI.iVE);
        snsAdNativeLandingTestUI.jzo.start();
        snsAdNativeLandingTestUI.cnC.post(new Runnable(snsAdNativeLandingTestUI) {
            final /* synthetic */ SnsAdNativeLandingTestUI jLL;

            {
                this.jLL = r1;
            }

            public final void run() {
                this.jLL.jzT.fA(true);
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nDR.bAj();
        getWindow().setFlags(1024, 1024);
        ((Button) findViewById(2131759263)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsAdNativeLandingTestUI jLL;

            {
                this.jLL = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("Select_Conv_Type", 259);
                intent.putExtra("select_is_ret", true);
                c.a(this.jLL, ".ui.transmit.SelectConversationUI", intent, 0, new com.tencent.mm.ui.MMActivity.a(this) {
                    final /* synthetic */ AnonymousClass1 jLM;

                    {
                        this.jLM = r1;
                    }

                    public final void a(int i, int i2, Intent intent) {
                        if (i2 == -1) {
                            final String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                            if (stringExtra == null || stringExtra.length() == 0) {
                                v.e("MicroMsg.Sns.SnsAdNativieLandingTestUI", "mmOnActivityResult fail, toUser is null");
                                return;
                            }
                            final SnsAdNativeLandingTestUI snsAdNativeLandingTestUI = this.jLM.jLL;
                            com.tencent.mm.pluginsdk.ui.applet.c.a(((MMActivity) snsAdNativeLandingTestUI).nDR, "test title", "http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150", "test desc", true, snsAdNativeLandingTestUI.getResources().getString(2131231149), new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
                                final /* synthetic */ AnonymousClass1 jLN;

                                public final void a(boolean z, String str, int i) {
                                    if (z) {
                                        WXMediaMessage wXMediaMessage = new WXMediaMessage();
                                        wXMediaMessage.title = "test title";
                                        wXMediaMessage.description = "test desc";
                                        WXWebpageObject wXWebpageObject = new WXWebpageObject();
                                        wXWebpageObject.canvasPageXml = "<xml></xml>";
                                        wXWebpageObject.webpageUrl = "http://www.baidu.com/";
                                        wXMediaMessage.mediaObject = wXWebpageObject;
                                        String str2 = (Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages") + "/" + ("adId" + "_image_" + z.Kg("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150"));
                                        Bitmap c = FileOp.aR(str2) ? b.c(str2, 1.0f) : null;
                                        if (!(c == null || c.isRecycled())) {
                                            v.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "thumb image is not null");
                                            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                            c.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                            wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                                        }
                                        mp mpVar = new mp();
                                        mpVar.bnP.bhh = wXMediaMessage;
                                        mpVar.bnP.toUser = stringExtra;
                                        mpVar.bnP.bnQ = 49;
                                        mpVar.bnP.bnR = "";
                                        mpVar.bnP.bnS = "";
                                        com.tencent.mm.sdk.c.a.nhr.z(mpVar);
                                        if (!TextUtils.isEmpty(str)) {
                                            mr mrVar = new mr();
                                            mrVar.boa.bob = stringExtra;
                                            mrVar.boa.content = str;
                                            mrVar.boa.type = m.fp(stringExtra);
                                            mrVar.boa.flags = 0;
                                            com.tencent.mm.sdk.c.a.nhr.z(mrVar);
                                        }
                                        g.bf(snsAdNativeLandingTestUI, snsAdNativeLandingTestUI.getString(2131231155));
                                    }
                                }
                            });
                        }
                    }
                });
            }
        });
        ViewGroup viewGroup = (ViewGroup) findViewById(2131759262);
        LayoutInflater layoutInflater = (LayoutInflater) this.nDR.nEl.getSystemService("layout_inflater");
        WindowManager windowManager = (WindowManager) this.nDR.nEl.getSystemService("window");
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        String str = "adId";
        String str2 = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages";
        String str3 = str + "_image_" + z.Kg("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150");
        str = str + "_stream_" + z.Kg("http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400");
        View inflate = layoutInflater.inflate(2130904427, null);
        inflate.setMinimumHeight(height);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(2131759251);
        this.jzo = new VideoSightView(this.nDR.nEl);
        this.jzo.fD(false);
        viewGroup2.addView(this.jzo, 0, new LayoutParams(-1, -1));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = b.a(this.nDR.nEl, this.nDR.nEl.getResources().getDimension(2131493158));
        this.jzT = new SnsAdNativeLandingPagesVideoPlayerLoadingBar(this.nDR.nEl);
        this.jzT.setVisibility(0);
        this.jzo.fE(true);
        ((ViewGroup) inflate).addView(this.jzT, layoutParams);
        this.jzT.iUG = new com.tencent.mm.plugin.sight.decode.ui.b(this) {
            final /* synthetic */ SnsAdNativeLandingTestUI jLL;

            {
                this.jLL = r1;
            }

            public final void aPv() {
            }

            public final void pB(int i) {
                v.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "onSeek time " + i);
                this.jLL.iVE = (double) i;
                this.jLL.jzo.i((double) i);
            }
        };
        this.jzT.d(new OnClickListener(this) {
            final /* synthetic */ SnsAdNativeLandingTestUI jLL;

            {
                this.jLL = r1;
            }

            public final void onClick(View view) {
                if (this.jLL.jzo.isPlaying()) {
                    SnsAdNativeLandingTestUI.b(this.jLL);
                } else {
                    SnsAdNativeLandingTestUI.c(this.jLL);
                }
            }
        });
        this.jzT.fA(this.jzo.isPlaying());
        this.jzT.setVisibility(0);
        this.jzT.py(0);
        this.jzo.iVc = new com.tencent.mm.pluginsdk.ui.tools.g.a(this) {
            final /* synthetic */ SnsAdNativeLandingTestUI jLL;

            {
                this.jLL = r1;
            }

            public final void abH() {
                if (this.jLL.jzT.bee) {
                    SnsAdNativeLandingTestUI.c(this.jLL);
                }
            }

            public final void bp(int i, int i2) {
                this.jLL.jzo.stop();
            }

            public final void pa() {
            }

            public final int bq(final int i, final int i2) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass5 jLO;

                    public final void run() {
                        v.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "play time " + i + " video time " + i2);
                        if (i2 > 0) {
                            this.jLO.jLL.duration = i2;
                            this.jLO.jLL.jzn = i2;
                        }
                        if (this.jLO.jLL.jzT.iUN != i2) {
                            this.jLO.jLL.jzT.pz(i2);
                        }
                        this.jLO.jLL.jzT.py(i);
                    }
                });
                return 0;
            }

            public final void br(int i, int i2) {
                this.jLL.geg = i;
                this.jLL.gef = i2;
            }
        };
        this.jzo.lUB = false;
        this.jzo.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsAdNativeLandingTestUI jLL;

            {
                this.jLL = r1;
            }

            public final void onClick(View view) {
                if (!"".equals(this.jLL.jzo.iUW.iTJ) && this.jLL.jzo.iUW.iTJ != null) {
                    if (this.jLL.jzT.getVisibility() == 0) {
                        this.jLL.jzT.setVisibility(4);
                    } else {
                        this.jLL.jzT.setVisibility(0);
                    }
                }
            }
        });
        viewGroup.addView(inflate, new LayoutParams(width, height));
        this.jzo.post(new Runnable(this) {
            final /* synthetic */ SnsAdNativeLandingTestUI jLL;

            {
                this.jLL = r1;
            }

            public final void run() {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                if (this.jLL.nDR.nEl instanceof MMActivity) {
                    ((MMActivity) this.jLL.nDR.nEl).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    this.jLL.jzo.pv(displayMetrics.widthPixels);
                }
                this.jLL.jzo.requestLayout();
                this.jLL.jzo.postInvalidate();
            }
        });
        new a(str2, str3, com.tencent.mm.plugin.sns.e.ad.aqz(), new a(this) {
            final /* synthetic */ SnsAdNativeLandingTestUI jLL;

            {
                this.jLL = r1;
            }

            public final void aW(String str, int i) {
            }

            public final void Bj(String str) {
            }

            public final void Bk(String str) {
                this.jLL.jzo.v(BitmapFactory.decodeFile(str));
            }
        }).execute(new String[]{"http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150"});
        new a(str2, str, com.tencent.mm.plugin.sns.e.ad.aqz(), new a(this) {
            final /* synthetic */ SnsAdNativeLandingTestUI jLL;

            {
                this.jLL = r1;
            }

            public final void aW(String str, int i) {
                if (!this.jLL.jzo.isPlaying()) {
                    this.jLL.jzo.fD(false);
                    if (!str.equals(this.jLL.jzo.iUW.iTJ)) {
                        this.jLL.jzo.setVideoPath(str);
                    }
                    if (this.jLL.jzT.bee) {
                        this.jLL.jzo.i(this.jLL.iVE);
                        this.jLL.jzo.start();
                    }
                }
            }

            public final void Bj(String str) {
                v.e("MicroMsg.Sns.SnsAdNativieLandingTestUI", str);
            }

            public final void Bk(String str) {
                this.jLL.jzo.setVideoPath(str);
                this.jLL.jzo.fD(true);
                if (this.jLL.jzT.bee) {
                    this.jLL.jzo.i(this.jLL.iVE);
                    this.jLL.jzo.start();
                }
            }
        }, Downloads.SPLIT_RANGE_SIZE_WAP).execute(new String[]{"http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400"});
    }

    protected final int getLayoutId() {
        return 2130904432;
    }
}
