package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.chatting.ImageDownloadUI;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.tools.CropImageView.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.f;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Array;
import junit.framework.Assert;

public class CropImageNewUI extends MMActivity {
    private int exT = 0;
    private String filePath;
    private final int oRc = 1;
    private final int oRd = 0;
    private int oRe;
    private int oRf = 0;
    private FilterImageView oRg;
    private LinearLayout oRh;
    private CropImageView oRi;
    private ImageView oRj;
    private View oRk;
    private int oRl = 0;
    private boolean oRm = false;
    private boolean oRn = false;
    private boolean oRo = false;

    static /* synthetic */ void a(CropImageNewUI cropImageNewUI, CropImageView cropImageView, View view) {
        v.d("MicroMsg.CropImageUI", "doCropImage" + cropImageNewUI.oRo);
        if (cropImageView != null && view != null) {
            if (cropImageNewUI.oRo) {
                v.d("MicroMsg.CropImageUI", "isCroping");
                return;
            }
            cropImageNewUI.oRo = true;
            Bitmap createBitmap = d.createBitmap(cropImageView.ggw.getWidth(), cropImageView.ggw.getHeight(), Config.ARGB_8888);
            if (createBitmap == null) {
                cropImageNewUI.setResult(-1);
                cropImageNewUI.finish();
                return;
            }
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate((float) cropImageView.getScrollX(), (float) cropImageView.getScrollY());
            cropImageView.draw(canvas);
            float[] fArr = new float[9];
            cropImageView.getImageMatrix().getValues(fArr);
            int left = view.getLeft();
            int top = view.getTop();
            int width = view.getWidth();
            Math.abs(fArr[0] != 0.0f ? fArr[0] : fArr[1]);
            float[][] b = n.b(a(cropImageView.getImageMatrix()));
            try {
                createBitmap = cropImageNewUI.exT == 1 ? a(b, (float) left, (float) (((int) (((double) width) * 0.125d)) + top), (float) (left + width), (float) ((top + width) - ((int) (((double) width) * 0.125d))), cropImageView) : a(b, (float) left, (float) top, (float) (left + width), (float) (top + width), cropImageView);
            } catch (OutOfMemoryError e) {
                createBitmap = null;
            }
            if (createBitmap == null) {
                v.e("MicroMsg.CropImageUI", "doCropImage: error");
            } else {
                v.d("MicroMsg.CropImageUI", "bm w: " + createBitmap.getWidth() + " " + createBitmap.getHeight());
                int width2 = createBitmap.getWidth();
                int height = createBitmap.getHeight();
                if (width2 != height) {
                    createBitmap = width2 > height ? Bitmap.createBitmap(createBitmap, (width2 - height) / 2, 0, height, height) : Bitmap.createBitmap(createBitmap, 0, (height - width2) / 2, width2, width2);
                }
                String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_OutputPath");
                if (stringExtra == null) {
                    stringExtra = e.cgg + g.m((cropImageNewUI.filePath + System.currentTimeMillis()).getBytes()) + "_crop.jpg";
                }
                if (cropImageNewUI.a(createBitmap, stringExtra, true)) {
                    Intent intent = new Intent();
                    intent.putExtra("CropImage_OutputPath", stringExtra);
                    if (cropImageNewUI.oRg != null) {
                        intent.putExtra("CropImage_filterId", cropImageNewUI.oRg.jdS);
                    }
                    cropImageNewUI.setResult(-1, intent);
                    cropImageNewUI.finish();
                }
            }
            cropImageNewUI.setResult(-1);
            cropImageNewUI.finish();
        }
    }

    static /* synthetic */ void a(CropImageNewUI cropImageNewUI, boolean z) {
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_OutputPath");
        if (t.kS(stringExtra)) {
            stringExtra = cropImageNewUI.filePath;
        } else {
            byte[] c = FileOp.c(cropImageNewUI.filePath, 0, -1);
            FileOp.b(stringExtra, c, c.length);
        }
        Intent intent = new Intent();
        intent.putExtra("CropImage_Compress_Img", z);
        intent.putExtra("CropImage_OutputPath", stringExtra);
        intent.putExtra("CropImage_rotateCount", cropImageNewUI.oRi.bha % 4);
        if (cropImageNewUI.oRg != null) {
            intent.putExtra("CropImage_filterId", cropImageNewUI.oRg.jdS);
        }
        intent.putExtra("from_source", cropImageNewUI.getIntent().getIntExtra("from_source", 0));
        cropImageNewUI.setResult(-1, intent);
        cropImageNewUI.finish();
    }

    static /* synthetic */ void d(CropImageNewUI cropImageNewUI) {
        if (cropImageNewUI.oRg.oSr == null) {
            cropImageNewUI.oRg.cm(cropImageNewUI.filePath, cropImageNewUI.oRl);
        }
        cropImageNewUI.oRh.setVisibility(8);
        cropImageNewUI.oRg.setVisibility(0);
        cropImageNewUI.oRj.setTag(Integer.valueOf(cropImageNewUI.oRj.getVisibility()));
        cropImageNewUI.oRj.setVisibility(8);
        cropImageNewUI.oRi.setVisibility(8);
    }

    static /* synthetic */ void g(CropImageNewUI cropImageNewUI) {
        cropImageNewUI.oRg.cm(cropImageNewUI.filePath, cropImageNewUI.oRl);
        cropImageNewUI.oRh.setVisibility(8);
        cropImageNewUI.oRg.setVisibility(0);
        cropImageNewUI.oRj.setTag(Integer.valueOf(cropImageNewUI.oRj.getVisibility()));
        cropImageNewUI.oRj.setVisibility(8);
        cropImageNewUI.oRi.setVisibility(8);
        cropImageNewUI.oRg.findViewById(2131756556).setVisibility(4);
    }

    static /* synthetic */ void h(CropImageNewUI cropImageNewUI) {
        v.d("MicroMsg.CropImageUI", "doShowOrNot");
        if (cropImageNewUI.oRh.getVisibility() == 0) {
            cropImageNewUI.oRh.setVisibility(4);
        } else if (cropImageNewUI.oRh.getVisibility() == 4) {
            cropImageNewUI.oRh.setVisibility(0);
        }
    }

    static /* synthetic */ void k(CropImageNewUI cropImageNewUI) {
        int[] bJe = cropImageNewUI.bJe();
        Bitmap dt = cropImageNewUI.dt(bJe[2], bJe[3]);
        Bitmap dt2 = cropImageNewUI.dt(bJe[0], bJe[1]);
        if (cropImageNewUI.oRl != 0) {
            Bitmap bitmap = dt;
            dt = dt2;
            dt2 = bitmap;
        }
        v.d("MicroMsg.CropImageUI", "docrop degree:" + cropImageNewUI.oRl);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_bg_vertical");
        String stringExtra2 = cropImageNewUI.getIntent().getStringExtra("CropImage_bg_horizontal");
        if (cropImageNewUI.a(dt, stringExtra, true) && cropImageNewUI.a(r0, stringExtra2, true)) {
            Intent intent = new Intent();
            intent.putExtra("CropImage_bg_vertical", stringExtra);
            intent.putExtra("CropImage_bg_horizontal", stringExtra2);
            if (cropImageNewUI.oRg != null) {
                intent.putExtra("CropImage_filterId", cropImageNewUI.oRg.jdS);
            }
            cropImageNewUI.setResult(-1, intent);
        } else {
            cropImageNewUI.setResult(-1);
        }
        cropImageNewUI.finish();
    }

    static /* synthetic */ void l(CropImageNewUI cropImageNewUI) {
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_OutputPath");
        String str = null;
        Intent intent = new Intent();
        if (cropImageNewUI.oRf == 0) {
            try {
                String m = g.m((System.currentTimeMillis()).getBytes());
                d.a(cropImageNewUI.oRi.ggw, 100, CompressFormat.PNG, stringExtra + m, false);
                str = g.m(FileOp.c(stringExtra + m, 0, (int) FileOp.jP(stringExtra + m)));
                if (com.tencent.mm.a.e.aR(stringExtra + str)) {
                    v.i("MicroMsg.CropImageUI", "file is exist. need no to copy!");
                    b.deleteFile(stringExtra + m);
                } else {
                    FileOp.n(stringExtra, m, str);
                }
                intent.putExtra("emoji_type", 0);
            } catch (Throwable e) {
                v.a("MicroMsg.CropImageUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                cropImageNewUI.setResult(-2);
            }
        } else if (cropImageNewUI.oRf == 1) {
            byte[] c = FileOp.c(cropImageNewUI.filePath, 0, -1);
            str = g.m(c);
            if (com.tencent.mm.a.e.aR(stringExtra + str)) {
                v.i("MicroMsg.CropImageUI", "file is exist. need no to copy!");
            } else {
                FileOp.b(stringExtra + str, c, c.length);
            }
            intent.putExtra("emoji_type", 1);
        }
        intent.putExtra("CropImage_OutputPath", stringExtra + str);
        if (cropImageNewUI.oRg != null) {
            intent.putExtra("CropImage_filterId", cropImageNewUI.oRg.jdS);
        }
        cropImageNewUI.setResult(-1, intent);
        cropImageNewUI.finish();
    }

    static /* synthetic */ void m(CropImageNewUI cropImageNewUI) {
        String[] strArr = (cropImageNewUI.oRm || cropImageNewUI.oRn) ? new String[]{cropImageNewUI.getString(2131232245)} : new String[]{cropImageNewUI.getString(2131232245)};
        com.tencent.mm.ui.base.g.a((Context) cropImageNewUI, SQLiteDatabase.KeyEmpty, strArr, SQLiteDatabase.KeyEmpty, false, new c(cropImageNewUI) {
            final /* synthetic */ CropImageNewUI oRp;

            {
                this.oRp = r1;
            }

            public final void gT(int i) {
                switch (i) {
                    case 0:
                        com.tencent.mm.ui.base.g.a((Context) this.oRp, this.oRp.getString(2131232243, new Object[]{Long.toString(FileOp.jP(this.oRp.filePath) / 1024)}), this.oRp.getString(2131231164), new OnClickListener(this.oRp) {
                            final /* synthetic */ CropImageNewUI oRp;

                            {
                                this.oRp = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                CropImageNewUI.a(this.oRp, false);
                            }
                        }, new OnClickListener(this.oRp) {
                            final /* synthetic */ CropImageNewUI oRp;

                            {
                                this.oRp = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        return;
                    default:
                        return;
                }
            }
        });
    }

    static /* synthetic */ void n(CropImageNewUI cropImageNewUI) {
        Context context = cropImageNewUI;
        com.tencent.mm.ui.base.g.a(context, SQLiteDatabase.KeyEmpty, new String[]{cropImageNewUI.getString(2131234560), cropImageNewUI.getString(2131234727)}, SQLiteDatabase.KeyEmpty, false, new c(cropImageNewUI) {
            final /* synthetic */ CropImageNewUI oRp;

            {
                this.oRp = r1;
            }

            public final void gT(int i) {
                switch (i) {
                    case 0:
                        CropImageNewUI.s(this.oRp);
                        return;
                    case 1:
                        l.h(this.oRp.getIntent().getStringExtra("CropImage_ImgPath"), this.oRp);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    static /* synthetic */ void r(CropImageNewUI cropImageNewUI) {
        long longExtra = cropImageNewUI.getIntent().getLongExtra("CropImage_Msg_Id", 0);
        long longExtra2 = cropImageNewUI.getIntent().getLongExtra("CropImage_Msg_Svr_Id", 0);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_Username");
        Intent intent = new Intent(cropImageNewUI, ImageDownloadUI.class);
        intent.putExtra("img_msg_id", longExtra);
        intent.putExtra("img_server_id", longExtra2);
        intent.putExtra("img_download_compress_type", 1);
        intent.putExtra("img_download_username", stringExtra);
        cropImageNewUI.startActivity(intent);
    }

    static /* synthetic */ void s(CropImageNewUI cropImageNewUI) {
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_ImgPath");
        int intExtra = cropImageNewUI.getIntent().getIntExtra("CropImage_CompressType", 0);
        int intExtra2 = cropImageNewUI.getIntent().getIntExtra("CropImage_Msg_Id", -1);
        Intent intent = new Intent(cropImageNewUI, MsgRetransmitUI.class);
        intent.putExtra("Retr_File_Name", stringExtra);
        intent.putExtra("Retr_Msg_Id", intExtra2);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("Retr_Compress_Type", intExtra);
        cropImageNewUI.startActivity(intent);
    }

    protected final int getLayoutId() {
        return 2130903443;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        NI();
    }

    public void onResume() {
        super.onResume();
        setRequestedOrientation(1);
    }

    public void onDestroy() {
        if (this.oRi != null) {
            CropImageView cropImageView = this.oRi;
            if (!(cropImageView.ggw == null || cropImageView.ggw.isRecycled())) {
                v.i("MicroMsg.CropImageView", "recycle bitmap:%s", cropImageView.ggw.toString());
                cropImageView.ggw.recycle();
            }
        }
        if (this.oRg != null) {
            FilterImageView filterImageView = this.oRg;
            filterImageView.oSn = null;
            if (!(filterImageView.oSr == null || filterImageView.oSr.isRecycled())) {
                v.i("MicroMsg.FilterView", "recycle bitmap:%s", filterImageView.oSr.toString());
                filterImageView.oSr.recycle();
            }
            filterImageView.oSr = null;
        }
        super.onDestroy();
        v.appenderClose();
        int myPid = Process.myPid();
        com.tencent.recovery.b.yH(13);
        Process.killProcess(myPid);
    }

    protected final void NI() {
        Fd(SQLiteDatabase.KeyEmpty);
        this.oRh = (LinearLayout) findViewById(2131756559);
        this.oRj = (ImageView) findViewById(2131756555);
        com.tencent.mm.platformtools.e.bw(this.oRj);
        this.oRk = findViewById(2131756554);
        this.oRe = getIntent().getIntExtra("CropImageMode", 0);
        Assert.assertTrue("the image mode must be set", this.oRe != 0);
        this.exT = getIntent().getIntExtra("CropImage_from_scene", 0);
        final boolean booleanExtra = getIntent().getBooleanExtra("CropImage_Filter", false);
        final boolean booleanExtra2 = getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false);
        if (booleanExtra) {
            b(new Runnable(this) {
                final /* synthetic */ CropImageNewUI oRp;

                {
                    this.oRp = r1;
                }

                public final void run() {
                    boolean z = false;
                    if (this.oRp.oRg != null) {
                        if (this.oRp.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                            Editor edit = this.oRp.getSharedPreferences(aa.bti(), 0).edit();
                            String str = "CropImage_Filter_Show";
                            if (this.oRp.oRg.findViewById(2131756556).getVisibility() == 0) {
                                z = true;
                            }
                            edit.putBoolean(str, z);
                            edit.commit();
                        }
                        String stringExtra = this.oRp.getIntent().getStringExtra("CropImage_OutputPath");
                        if (stringExtra == null) {
                            stringExtra = e.cgg + g.m((this.oRp.filePath + System.currentTimeMillis()).getBytes()) + "_fiter.jpg";
                        }
                        Intent intent = new Intent();
                        intent.putExtra("CropImage_Compress_Img", true);
                        if (this.oRp.oRg != null) {
                            intent.putExtra("CropImage_filterId", this.oRp.oRg.jdS);
                        }
                        if (this.oRp.oRg.jdS == 0) {
                            intent.putExtra("CropImage_OutputPath", this.oRp.filePath);
                            this.oRp.setResult(-1, intent);
                        } else if (this.oRp.a(this.oRp.oRg.oSr, stringExtra, false)) {
                            intent.putExtra("CropImage_OutputPath", stringExtra);
                            this.oRp.setResult(-1, intent);
                        } else {
                            this.oRp.setResult(-1);
                        }
                        this.oRp.finish();
                    }
                }
            }, new Runnable(this) {
                final /* synthetic */ CropImageNewUI oRp;

                {
                    this.oRp = r1;
                }

                public final void run() {
                    if (this.oRp.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                        this.oRp.finish();
                        return;
                    }
                    this.oRp.oRg.setVisibility(8);
                    this.oRp.oRh.setVisibility(0);
                    this.oRp.oRj.setVisibility(((Integer) this.oRp.oRj.getTag()).intValue());
                    this.oRp.oRi.setVisibility(0);
                }
            });
        }
        this.oRo = false;
        this.oRi = (CropImageView) findViewById(2131756558);
        com.tencent.mm.platformtools.e.bw(this.oRi);
        this.oRi.post(new Runnable(this) {
            final /* synthetic */ CropImageNewUI oRp;

            {
                this.oRp = r1;
            }

            public final void run() {
                if (!this.oRp.bJd()) {
                    return;
                }
                if (!this.oRp.oRm && !this.oRp.oRn && this.oRp.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                    CropImageNewUI.d(this.oRp);
                    if (!this.oRp.getSharedPreferences(aa.bti(), 0).getBoolean("CropImage_Filter_Show", true)) {
                        this.oRp.oRg.findViewById(2131756556).setVisibility(4);
                    }
                } else if (1 == this.oRp.oRe) {
                    CropImageNewUI.g(this.oRp);
                }
            }
        });
        this.oRi.oRR = new a(this) {
            final /* synthetic */ CropImageNewUI oRp;

            {
                this.oRp = r1;
            }

            public final void bJf() {
                CropImageNewUI.h(this.oRp);
            }
        };
        ((Button) findViewById(2131756561)).setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ CropImageNewUI oRp;

            {
                this.oRp = r1;
            }

            public final void onClick(View view) {
                CropImageView j = this.oRp.oRi;
                if (j.ggw == null) {
                    v.w("MicroMsg.CropImageView", "rotate not done! cause: btmp is null!");
                    return;
                }
                float[] fArr = new float[]{(float) (j.ggw.getWidth() / 2), (float) (j.ggw.getHeight() / 2)};
                j.getImageMatrix().mapPoints(fArr);
                j.getImageMatrix().postRotate(90.0f, fArr[0], fArr[1]);
                j.setImageBitmap(j.ggw);
                j.invalidate();
                j.bha++;
            }
        });
        Button button = (Button) findViewById(2131756563);
        button.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ CropImageNewUI oRp;

            {
                this.oRp = r1;
            }

            public final void onClick(View view) {
                this.oRp.oRi.bJh();
            }
        });
        Button button2 = (Button) findViewById(2131756562);
        button2.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ CropImageNewUI oRp;

            {
                this.oRp = r1;
            }

            public final void onClick(View view) {
                this.oRp.oRi.bJi();
            }
        });
        final ah ahVar = new ah(new ah.a(this) {
            final /* synthetic */ CropImageNewUI oRp;

            {
                this.oRp = r1;
            }

            public final boolean oU() {
                this.oRp.oRi.bJh();
                return true;
            }
        }, true);
        final ah ahVar2 = new ah(new ah.a(this) {
            final /* synthetic */ CropImageNewUI oRp;

            {
                this.oRp = r1;
            }

            public final boolean oU() {
                this.oRp.oRi.bJi();
                return true;
            }
        }, true);
        button.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ CropImageNewUI oRp;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        ahVar.ea(200);
                        break;
                    case 1:
                        ahVar.QI();
                        break;
                }
                return false;
            }
        });
        button2.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ CropImageNewUI oRp;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        ahVar2.ea(200);
                        break;
                    case 1:
                        ahVar2.QI();
                        break;
                }
                return false;
            }
        });
        switch (this.oRe) {
            case 1:
                b(new Runnable(this) {
                    final /* synthetic */ CropImageNewUI oRp;

                    {
                        this.oRp = r1;
                    }

                    public final void run() {
                        CropImageNewUI.a(this.oRp, this.oRp.oRg.oSq, this.oRp.oRg.oSo);
                        this.oRp.finish();
                    }
                }, new Runnable(this) {
                    final /* synthetic */ CropImageNewUI oRp;

                    {
                        this.oRp = r1;
                    }

                    public final void run() {
                        this.oRp.finish();
                    }
                });
                FilterImageView filterImageView = this.oRg;
                if (filterImageView.oSq != null) {
                    filterImageView.oSq.oRv = false;
                }
                filterImageView = this.oRg;
                if (filterImageView.oSq != null) {
                    filterImageView.oSq.setScaleType(ScaleType.MATRIX);
                    filterImageView.oSq.bJg();
                }
                filterImageView = this.oRg;
                if (filterImageView.oSp != null) {
                    filterImageView.oSp.setVisibility(0);
                }
                if (this.exT == 1) {
                    filterImageView = this.oRg;
                    if (filterImageView.oSp != null) {
                        filterImageView.oSp.setBackgroundResource(2130838763);
                        break;
                    }
                }
                break;
            case 2:
                this.oRi.oRS = false;
                findViewById(2131756560).setVisibility(8);
                findViewById(2131756564).setVisibility(8);
                break;
            case 3:
                this.oRh.setVisibility(8);
                break;
            case 5:
                int intExtra = getIntent().getIntExtra("CropImage_CompressType", 1);
                boolean booleanExtra3 = getIntent().getBooleanExtra("CropImage_BHasHD", false);
                if (intExtra != 1 && booleanExtra3) {
                    findViewById(2131756564).setVisibility(0);
                    button = (Button) findViewById(2131756565);
                    button.setBackgroundResource(2130837803);
                    button.setPadding(25, 8, 25, 8);
                    button.setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ CropImageNewUI oRp;

                        {
                            this.oRp = r1;
                        }

                        public final void onClick(View view) {
                            CropImageNewUI.r(this.oRp);
                        }
                    });
                    break;
                }
                findViewById(2131756564).setVisibility(8);
                break;
                break;
        }
        v.d("MicroMsg.CropImageUI", "mode is  " + this.oRe);
        OnMenuItemClickListener anonymousClass17 = new OnMenuItemClickListener(this) {
            final /* synthetic */ CropImageNewUI oRp;

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (!booleanExtra || !booleanExtra2) {
                    switch (this.oRp.oRe) {
                        case 1:
                            if (this.oRp.oRg == null) {
                                CropImageNewUI.a(this.oRp, this.oRp.oRi, this.oRp.oRk);
                                break;
                            }
                            CropImageNewUI.a(this.oRp, this.oRp.oRg.oSq, this.oRp.oRk);
                            break;
                        case 2:
                            CropImageNewUI.k(this.oRp);
                            break;
                        case 3:
                            CropImageNewUI.l(this.oRp);
                            break;
                        case 4:
                            CropImageNewUI.m(this.oRp);
                            break;
                        case 5:
                            CropImageNewUI.n(this.oRp);
                            break;
                        default:
                            break;
                    }
                }
                CropImageNewUI.a(this.oRp, true);
                return true;
            }
        };
        if (this.oRe == 5) {
            a(0, 2130838681, anonymousClass17);
        } else if (this.oRe == 4) {
            a(0, 2130838681, anonymousClass17);
            findViewById(2131756564).setVisibility(0);
            button = (Button) findViewById(2131756565);
            button.setText(2131232242);
            button.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ CropImageNewUI oRp;

                {
                    this.oRp = r1;
                }

                public final void onClick(View view) {
                    CropImageNewUI.a(this.oRp, true);
                }
            });
        } else {
            a(0, getString(2131232246), anonymousClass17, k.b.nET);
        }
        if (booleanExtra && booleanExtra2) {
            a(0, getString(2131232242), anonymousClass17, k.b.nET);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CropImageNewUI oRp;

            {
                this.oRp = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oRp.finish();
                return true;
            }
        });
        if (this.oRe == 6) {
            findViewById(2131756564).setVisibility(8);
            a(0, getString(2131232246), new OnMenuItemClickListener(this) {
                final /* synthetic */ CropImageNewUI oRp;

                {
                    this.oRp = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    f fVar = new f(this.oRp, f.pbS, false);
                    fVar.jXn = new n.c(this) {
                        final /* synthetic */ AnonymousClass20 oRu;

                        {
                            this.oRu = r1;
                        }

                        public final void a(com.tencent.mm.ui.base.l lVar) {
                            lVar.dg(0, 2131232251);
                            lVar.dg(1, 2131232255);
                        }
                    };
                    fVar.jXo = new n.d(this) {
                        final /* synthetic */ AnonymousClass20 oRu;

                        {
                            this.oRu = r1;
                        }

                        public final void c(MenuItem menuItem, int i) {
                            Intent intent;
                            switch (menuItem.getItemId()) {
                                case 0:
                                    intent = new Intent();
                                    intent.putExtra("CropImage_OutputPath", this.oRu.oRp.getIntent().getStringExtra("CropImage_OutputPath"));
                                    intent.putExtra("OP_CODE", 1);
                                    this.oRu.oRp.setResult(-1, intent);
                                    this.oRu.oRp.finish();
                                    return;
                                case 1:
                                    intent = new Intent();
                                    intent.putExtra("CropImage_OutputPath", this.oRu.oRp.getIntent().getStringExtra("CropImage_OutputPath"));
                                    intent.putExtra("OP_CODE", 2);
                                    this.oRu.oRp.setResult(-1, intent);
                                    this.oRu.oRp.finish();
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    fVar.bKh();
                    return true;
                }
            }, k.b.nET);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        v.d("MicroMsg.CropImageUI", "onConfigurationChanged, config.orientation = " + configuration.orientation);
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            v.v("MicroMsg.CropImageUI", "onConfigurationChanged");
            this.oRi.post(new Runnable(this) {
                final /* synthetic */ CropImageNewUI oRp;

                {
                    this.oRp = r1;
                }

                public final void run() {
                    this.oRp.bJd();
                }
            });
        }
        super.onConfigurationChanged(configuration);
    }

    private boolean bJd() {
        View findViewById;
        if (1 != this.oRe) {
            findViewById = findViewById(2131756557);
        } else if (this.oRg != null) {
            findViewById = this.oRg.oSo;
        } else {
            findViewById = findViewById(2131756554);
        }
        int width = findViewById.getWidth();
        int height = findViewById.getHeight();
        v.v("MicroMsg.CropImageUI", "scrWidth:" + width + " scrHeight:" + height);
        this.filePath = getIntent().getStringExtra("CropImage_ImgPath");
        if (FileOp.aR(this.filePath)) {
            boolean z;
            int i;
            Bitmap decodeFile;
            int i2;
            float f;
            int i3 = 960;
            int i4 = 960;
            if (this.oRe == 2) {
                z = true;
                i3 = height;
                i = width;
            } else if (this.oRe == 3) {
                Options options = new Options();
                options.inJustDecodeBounds = true;
                decodeFile = BitmapFactory.decodeFile(this.filePath, options);
                if (decodeFile != null) {
                    decodeFile.recycle();
                }
                int i5 = options.outWidth;
                i2 = options.outHeight;
                f = 1.0f;
                if (i5 <= 640 && i2 <= 640) {
                    i3 = i2;
                    i = i5;
                } else if (i5 > i2) {
                    f = ((float) i2) / ((float) i5);
                    i = 640;
                    i3 = (int) (((float) i2) * f);
                } else {
                    f = ((float) i5) / ((float) i2);
                    i3 = 640;
                    i = (int) (960.0f * f);
                }
                v.d("MicroMsg.CropImageUI", "w:%d h:%d width:%d height:%d scale:%f", Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3), Float.valueOf(f));
                Button button = (Button) findViewById(2131756565);
                if (button != null) {
                    button.setVisibility(8);
                }
                z = false;
            } else if (this.oRe == 1) {
                Options options2 = new Options();
                options2.inJustDecodeBounds = true;
                Bitmap decodeFile2 = BitmapFactory.decodeFile(this.filePath, options2);
                if (decodeFile2 != null) {
                    v.i("MicroMsg.CropImageUI", "recycle bitmap:%s", decodeFile2.toString());
                    decodeFile2.recycle();
                }
                if (options2.outWidth > options2.outHeight) {
                    i3 = (int) ((((double) (options2.outWidth * 960)) * 1.0d) / ((double) options2.outHeight));
                    if (i3 > 1920) {
                        i3 = 1920;
                    }
                } else {
                    i4 = (int) ((((double) (options2.outHeight * 960)) * 1.0d) / ((double) options2.outWidth));
                    if (i4 > 1920) {
                        i4 = 1920;
                    }
                }
                i = i3;
                i3 = i4;
                z = false;
            } else {
                Options options3 = new Options();
                options3.inJustDecodeBounds = true;
                d.a(options3);
                Bitmap decodeFile3 = BitmapFactory.decodeFile(this.filePath, options3);
                if (decodeFile3 != null) {
                    v.i("MicroMsg.CropImageUI", "recycle bitmap:%s", decodeFile3.toString());
                    decodeFile3.recycle();
                }
                boolean z2 = t.aZ(options3.outWidth, options3.outHeight) && options3.outWidth > 480;
                this.oRm = z2;
                z2 = t.aY(options3.outWidth, options3.outHeight) && options3.outHeight > 480;
                this.oRn = z2;
                if (this.oRm || this.oRn) {
                    i4 = options3.outHeight;
                    i3 = options3.outWidth;
                }
                v.e("MicroMsg.CropImageUI", "width is " + i3 + " height is " + i4);
                i = i3;
                i3 = i4;
                z = false;
            }
            this.oRl = ExifHelper.JQ(this.filePath);
            if (this.oRl == 90 || this.oRl == 270) {
                int i6 = i;
                i = i3;
                i3 = i6;
            }
            decodeFile = d.b(this.filePath, i3, i, z);
            byte[] c = FileOp.c(this.filePath, 0, 10);
            if (o.be(c)) {
                this.oRf = 1;
            } else {
                this.oRf = 0;
            }
            if (decodeFile == null) {
                finish();
                return false;
            }
            float height2;
            float f2;
            v.d("temBmp crop", "h:" + decodeFile.getHeight() + "w: " + decodeFile.getWidth());
            Bitmap b = d.b(decodeFile, (float) this.oRl);
            Matrix matrix = new Matrix();
            matrix.reset();
            float f3 = 1.0f;
            if (z) {
                f = ((float) b.getWidth()) / ((float) width);
                height2 = ((float) b.getHeight()) / ((float) height);
                f2 = f < height2 ? f : height2;
                f = width > height ? (float) height : (float) width;
                height2 = f / ((float) b.getWidth());
                f /= (float) b.getHeight();
                if (height2 > f) {
                    f = height2;
                }
                if (((double) f2) < 1.0d) {
                    matrix.postScale(f, f);
                }
            } else {
                f = ((float) b.getWidth()) / ((float) b.getHeight());
                f2 = ((float) b.getHeight()) / ((float) b.getWidth());
                v.v("MicroMsg.CropImageUI", "whDiv is " + f + " hwDiv is " + f2);
                if (f2 >= 2.0f && b.getHeight() >= 480) {
                    f2 = ((float) b.getWidth()) / ((float) width);
                    f = ((float) width) / ((float) b.getWidth());
                    if (1 == this.oRe) {
                        f2 = ((float) height) / ((float) b.getHeight());
                        if (f <= f2) {
                            f = f2;
                        }
                        matrix.postScale(f, f);
                        matrix.postTranslate(((((float) width) - (f * ((float) b.getWidth()))) / 2.0f) + ((float) findViewById.getLeft()), (float) findViewById.getTop());
                    } else if (((double) f2) > 1.0d) {
                        matrix.postScale(f, f);
                        b.getHeight();
                        matrix.postTranslate((((float) width) - (f * ((float) b.getWidth()))) / 2.0f, 0.0f);
                    } else {
                        matrix.postScale(1.0f, 1.0f);
                        if (3 == this.oRe) {
                            matrix.postTranslate((float) ((width - b.getWidth()) / 2), (float) ((height - b.getHeight()) / 2));
                        } else {
                            matrix.postTranslate((float) ((width - b.getWidth()) / 2), 0.0f);
                        }
                    }
                } else if (f < 2.0f || b.getWidth() < 480) {
                    f = ((float) width) / ((float) b.getWidth());
                    f2 = ((float) height) / ((float) b.getHeight());
                    float f4 = f < f2 ? f : f2;
                    if (f <= f2) {
                        f = f2;
                    }
                    if (1 == this.oRe) {
                        matrix.postScale(f, f);
                        matrix.postTranslate(((((float) width) - (((float) b.getWidth()) * f)) / 2.0f) + ((float) findViewById.getLeft()), ((((float) height) - (f * ((float) b.getHeight()))) / 2.0f) + ((float) findViewById.getTop()));
                    } else if (this.oRf == 1) {
                        CropImageView cropImageView = this.oRi;
                        String str = this.filePath;
                        try {
                            cropImageView.oak = true;
                            cropImageView.oal = com.tencent.mm.plugin.gif.b.atw().bL(str, str);
                            cropImageView.setImageDrawable(cropImageView.oal);
                        } catch (Exception e) {
                            cropImageView.oak = false;
                        }
                        this.oRi.bJj();
                        this.oRi.bJk();
                        f = ((float) this.oRi.bJj()) / ((float) width);
                        height2 = ((float) this.oRi.bJk()) / ((float) height);
                        if (f <= height2) {
                            f = height2;
                        }
                        if (((double) f) > 1.0d) {
                            matrix.postScale(f, f);
                        } else {
                            f = 1.0f;
                        }
                        matrix.postTranslate((((float) width) - (((float) this.oRi.bJj()) * f)) / 2.0f, (((float) height) - (f * ((float) this.oRi.bJk()))) / 2.0f);
                    } else {
                        f = ((float) b.getWidth()) / ((float) width);
                        height2 = ((float) b.getHeight()) / ((float) height);
                        if (f <= height2) {
                            f = height2;
                        }
                        if (((double) f) > 1.0d) {
                            matrix.postScale(f4, f4);
                            f3 = f4;
                        }
                        matrix.postTranslate((((float) width) - (((float) b.getWidth()) * f3)) / 2.0f, (((float) height) - (((float) b.getHeight()) * f3)) / 2.0f);
                    }
                } else {
                    f = ((float) b.getHeight()) / 480.0f;
                    f2 = 480.0f / ((float) b.getHeight());
                    if (1 == this.oRe) {
                        f = ((float) width) / ((float) b.getWidth());
                        f2 = ((float) height) / ((float) b.getHeight());
                        if (f <= f2) {
                            f = f2;
                        }
                        matrix.postScale(f, f);
                        matrix.postTranslate(((((float) width) - (((float) b.getWidth()) * f)) / 2.0f) + ((float) findViewById.getLeft()), ((((float) height) - (f * ((float) b.getHeight()))) / 2.0f) + ((float) findViewById.getTop()));
                    } else if (((double) f) > 1.0d) {
                        matrix.postScale(f, f2);
                        matrix.postTranslate(0.0f, (float) ((height - 480) / 2));
                    } else {
                        matrix.postScale(1.0f, 1.0f);
                        f = (float) ((height - b.getHeight()) / 2);
                        v.d("MicroMsg.CropImageUI", " offsety " + f);
                        matrix.postTranslate(0.0f, f);
                    }
                }
            }
            if (1 == this.oRe) {
                if (this.oRg != null) {
                    FilterImageView filterImageView = this.oRg;
                    if (filterImageView.oSq != null) {
                        filterImageView.oSq.setImageMatrix(matrix);
                    }
                    this.oRg.oSr = b;
                }
            } else if (this.oRf != 1) {
                this.oRi.setImageMatrix(matrix);
                this.oRi.setImageBitmap(b);
            }
            if (this.oRe == 3) {
                if (o.be(c)) {
                    this.oRf = 1;
                    try {
                        Drawable bL = com.tencent.mm.plugin.gif.b.atw().bL(this.filePath, this.filePath);
                        this.oRi.setImageDrawable(bL);
                        bL.start();
                        matrix.reset();
                        i2 = bL.getIntrinsicWidth();
                        i = bL.getIntrinsicHeight();
                        f = ((float) width) / ((float) i2);
                        height2 = ((float) height) / ((float) i);
                        f2 = f < height2 ? f : height2;
                        f = ((float) i2) / ((float) width);
                        height2 = ((float) i) / ((float) height);
                        if (f <= height2) {
                            f = height2;
                        }
                        if (((double) f) > 1.0d) {
                            matrix.postScale(f2, f2);
                            matrix.postTranslate((((float) width) - (((float) i2) * f2)) / 2.0f, (((float) height) - (f2 * ((float) i))) / 2.0f);
                        } else {
                            matrix.postTranslate((float) ((width - i2) / 2), (float) ((height - i) / 2));
                        }
                        this.oRi.setImageMatrix(matrix);
                    } catch (Throwable e2) {
                        v.e("MicroMsg.CropImageUI", be.e(e2));
                    }
                } else {
                    this.oRf = 0;
                }
                return true;
            }
            if (this.oRm || this.oRn) {
                findViewById(2131756561).setVisibility(8);
            }
            if (getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                findViewById(2131756564).setVisibility(8);
            }
            return true;
        }
        finish();
        return false;
    }

    private void b(Runnable runnable, Runnable runnable2) {
        this.oRg = (FilterImageView) findViewById(2131756566);
        com.tencent.mm.platformtools.e.bw(this.oRg);
        this.oRg.oSu = runnable;
        this.oRg.oSv = runnable2;
    }

    private int[] bJe() {
        int i;
        DisplayMetrics displayMetrics;
        int i2;
        int max;
        int i3;
        int i4;
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i5 = rect.top;
        v.e("MicroMsg.CropImageUI", "window TitleBar.h:" + i5);
        if (i5 == 0) {
            try {
                Class cls = Class.forName("com.android.internal.R$dimen");
                i5 = getResources().getDimensionPixelSize(t.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
                v.e("MicroMsg.CropImageUI", "sbar:" + i5);
                i = i5;
            } catch (Throwable e) {
                v.a("MicroMsg.CropImageUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
            displayMetrics = new DisplayMetrics();
            ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            i2 = (int) (((double) (67.0f * displayMetrics.density)) / 1.5d);
            i5 = Math.min(this.oRk.getWidth(), this.oRk.getHeight());
            max = Math.max(this.oRk.getWidth(), this.oRk.getHeight());
            i3 = max - (i2 * 2);
            i4 = (max + i) + i2;
            max = (i5 - (i2 * 2)) - i;
            if (this.oRl != 0) {
                i5 += i + (i2 * 2);
                i = max + i2;
            } else {
                i = max;
            }
            return new int[]{i5, i3, i, i4};
        }
        i = i5;
        displayMetrics = new DisplayMetrics();
        ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        i2 = (int) (((double) (67.0f * displayMetrics.density)) / 1.5d);
        i5 = Math.min(this.oRk.getWidth(), this.oRk.getHeight());
        max = Math.max(this.oRk.getWidth(), this.oRk.getHeight());
        i3 = max - (i2 * 2);
        i4 = (max + i) + i2;
        max = (i5 - (i2 * 2)) - i;
        if (this.oRl != 0) {
            i = max;
        } else {
            i5 += i + (i2 * 2);
            i = max + i2;
        }
        return new int[]{i5, i3, i, i4};
    }

    private Bitmap dt(int i, int i2) {
        Bitmap b = d.b(this.filePath, i2, i, true);
        if (this.oRl != 0) {
            Matrix matrix = new Matrix();
            matrix.reset();
            matrix.setRotate((float) this.oRl, (float) (b.getWidth() / 2), (float) (b.getHeight() / 2));
            Bitmap createBitmap = Bitmap.createBitmap(b, 0, 0, b.getWidth(), b.getHeight(), matrix, true);
            if (b != createBitmap) {
                v.i("MicroMsg.CropImageUI", "recycle bitmap:%s", b.toString());
                b.recycle();
            }
            b = createBitmap;
        }
        v.d("MicroMsg.CropImageUI", "getcrop degree:" + this.oRl);
        return b;
    }

    private static Bitmap a(float[][] fArr, float f, float f2, float f3, float f4, CropImageView cropImageView) {
        if (cropImageView == null) {
            return null;
        }
        float[] fArr2 = new float[]{f3, f4, 1.0f};
        float[] a = n.a(fArr, new float[]{f, f2, 1.0f});
        float[] a2 = n.a(fArr, fArr2);
        int min = (int) Math.min(a[0], a2[0]);
        int min2 = (int) Math.min(a[1], a2[1]);
        if (min < 0) {
            min = 0;
        }
        if (min2 < 0) {
            min2 = 0;
        }
        int abs = (int) Math.abs(a[0] - a2[0]);
        int abs2 = (int) Math.abs(a[1] - a2[1]);
        Matrix matrix = new Matrix();
        switch (cropImageView.bha % 4) {
            case 0:
                matrix.setRotate(0.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
            case 1:
                matrix.setRotate(90.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
            case 2:
                matrix.setRotate(180.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
            case 3:
                matrix.setRotate(270.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
        }
        Bitmap bitmap = cropImageView.ggw;
        if (min + abs > bitmap.getWidth()) {
            abs = bitmap.getWidth() - min;
        }
        if (min2 + abs2 > bitmap.getHeight()) {
            abs2 = bitmap.getHeight() - min2;
        }
        v.i("MicroMsg.CropImageUI", "rawWidth:%d, rawHeigth:%d, originalLX:%d, originalTY:%d, realWidth:%d, realHeight:%d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(min), Integer.valueOf(min2), Integer.valueOf(abs), Integer.valueOf(abs2));
        return Bitmap.createBitmap(bitmap, min, min2, abs, abs2, matrix, true);
    }

    private boolean a(Bitmap bitmap, String str, boolean z) {
        if (!(str == null || str.equals(SQLiteDatabase.KeyEmpty))) {
            try {
                if (this.exT == 1) {
                    d.a(bitmap, 30, CompressFormat.JPEG, str, z);
                    return true;
                }
                d.a(bitmap, 100, CompressFormat.PNG, str, z);
                return true;
            } catch (Throwable e) {
                v.a("MicroMsg.CropImageUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.e("MicroMsg.CropImageUI", "saveBitmapToImage failed:" + e.toString());
            }
        }
        return false;
    }

    private static float[][] a(Matrix matrix) {
        float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 3});
        float[] fArr2 = new float[9];
        matrix.getValues(fArr2);
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                fArr[i][i2] = fArr2[(i * 3) + i2];
            }
        }
        return fArr;
    }
}
