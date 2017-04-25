package com.tencent.mm.plugin.webview.ui.tools;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.webview.d.ah;
import com.tencent.mm.plugin.webview.d.x;
import com.tencent.mm.pluginsdk.model.h;
import com.tencent.mm.pluginsdk.ui.tools.SightCaptureResult;
import com.tencent.mm.pluginsdk.ui.tools.SightParams;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.base.s;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@a(3)
public class OpenFileChooserUI extends MMActivity {
    private int count;
    private boolean dFy = false;
    private ProgressDialog dwR = null;
    private int gfV;
    private int gfw;
    private int jZq;
    private String lek;
    private boolean liX;
    private int liY;
    private int liZ;
    private String lja;
    private OnCancelListener ljb = null;

    static /* synthetic */ void b(OpenFileChooserUI openFileChooserUI, String str) {
        String str2 = null;
        if (openFileChooserUI.liZ == 0) {
            v.e("MicroMsg.OpenFileChooserUI", "don't need thumb image");
            return;
        }
        File file;
        if (TextUtils.isEmpty(openFileChooserUI.lek)) {
            v.e("MicroMsg.OpenFileChooserUI", "thumbFilePath is empty!");
            file = null;
        } else {
            file = new File(openFileChooserUI.lek);
        }
        if (file == null || !file.exists()) {
            v.e("MicroMsg.OpenFileChooserUI", "file == null or file not exist for path:%s!", new Object[]{openFileChooserUI.lek});
            String name = new File(str).getName();
            if (!TextUtils.isEmpty(name) && name.contains(".")) {
                str2 = name.substring(0, name.lastIndexOf("."));
            }
            if (TextUtils.isEmpty(str2)) {
                openFileChooserUI.lek = e.cgg + ("microMsg_" + System.currentTimeMillis()) + ".jpeg";
            } else if (e.cgg == null || !e.cgg.endsWith("/")) {
                openFileChooserUI.lek = e.cgg + "/" + str2 + ".jpeg";
            } else {
                openFileChooserUI.lek = e.cgg + str2 + ".jpeg";
            }
            if (new File(openFileChooserUI.lek).exists()) {
                v.i("MicroMsg.OpenFileChooserUI", "file is exist for path:%s!", new Object[]{openFileChooserUI.lek});
                return;
            }
            v.i("MicroMsg.OpenFileChooserUI", "file not exist for path:%s!", new Object[]{openFileChooserUI.lek});
            v.i("MicroMsg.OpenFileChooserUI", "create new thumb path:%s!", new Object[]{openFileChooserUI.lek});
            Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
            if (createVideoThumbnail == null) {
                v.e("MicroMsg.OpenFileChooserUI", "createVideoThumbnail bitmap fail for path:%s!", new Object[]{openFileChooserUI.lek});
                return;
            }
            try {
                d.a(ThumbnailUtils.extractThumbnail(createVideoThumbnail, 690, 400, 2), 30, CompressFormat.JPEG, openFileChooserUI.lek, true);
                return;
            } catch (IOException e) {
                v.e("MicroMsg.OpenFileChooserUI", "saveBitmapToImage exist IOException:" + e.getMessage());
                return;
            }
        }
        v.i("MicroMsg.OpenFileChooserUI", "file is exist!, path:%s", new Object[]{openFileChooserUI.lek});
    }

    static /* synthetic */ String d(OpenFileChooserUI openFileChooserUI) {
        if (TextUtils.isEmpty(openFileChooserUI.lek)) {
            return "";
        }
        x DT = x.DT(openFileChooserUI.lek);
        DT.lek = openFileChooserUI.lek;
        DT.lep = true;
        DT.bcp = 1;
        com.tencent.mm.plugin.webview.e.e.bjd().b(DT);
        return DT.bde;
    }

    static /* synthetic */ String h(String str, List list) {
        int[] iArr = new int[2];
        h.a(str, iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        String str2 = e.cgg + "microMsg." + System.currentTimeMillis() + ".mp4";
        v.i("MicroMsg.OpenFileChooserUI", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", new Object[]{str, str2, Integer.valueOf(SightVideoJNI.remuxing(str, str2, i, i2, b.iTu, b.iTt, 8, 2, 25.0f, b.iTv, null, 0)), Integer.valueOf(i), Integer.valueOf(i2)});
        x DV = x.DV(str2);
        DV.width = i;
        DV.height = i2;
        DV.duration = r0;
        DV.size = com.tencent.mm.a.e.aQ(str2);
        list.add(DV.bde);
        com.tencent.mm.plugin.webview.e.e.bjd().b(DV);
        return DV.bde;
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        Intent intent;
        boolean z;
        super.onCreate(bundle);
        this.count = getIntent().getIntExtra("key_pick_local_pic_count", 0);
        if (this.count <= 0 || this.count > 9) {
            this.count = 9;
        }
        this.jZq = this.count;
        this.gfw = getIntent().getIntExtra("key_pick_local_pic_query_source_type", 8);
        this.gfV = getIntent().getIntExtra("query_media_type", 1);
        this.liX = getIntent().getBooleanExtra("key_pick_local_pic_send_raw", false);
        this.liY = getIntent().getIntExtra("key_pick_local_pic_capture", 3);
        this.liZ = getIntent().getIntExtra("key_pick_local_media_video_type", 0);
        if (this.gfw == 7 && this.gfV == 2) {
            if (!bjQ()) {
                s.makeText(this, getString(2131236613), 1).show();
                this.dFy = true;
            }
            intent = new Intent();
            intent.putExtra("key_send_raw_image", this.liX);
            intent.putExtra("query_media_type", this.gfV);
            int intExtra;
            int intExtra2;
            if (this.liZ == 1) {
                if (this.liY != 4096 && (this.liY & 4096) > 0) {
                    intExtra = getIntent().getIntExtra("key_pick_local_media_quality", 1);
                    intExtra2 = getIntent().getIntExtra("key_pick_local_media_duration", 60);
                    intent.putExtra("KEY_SIGHT_PARAMS", sW(1));
                    intent.putExtra("record_video_force_sys_camera", false);
                    intent.putExtra("show_header_view", true);
                    intent.putExtra("record_video_is_sight_capture", true);
                    intent.putExtra("record_video_quality", intExtra);
                    intent.putExtra("record_video_time_limit", intExtra2);
                    intent.putExtra("video_full_path", this.lja);
                    l.c(this, this.jZq, this.gfw, intent);
                } else if (this.liY == 16 || this.liY == 256) {
                    intent.putExtra("KEY_SIGHT_PARAMS", sW(1));
                    l.a(this, 6, intent, 3, 1);
                } else if (this.liY == 4096) {
                    intent.putExtra("show_header_view", false);
                    l.c(this, this.jZq, this.gfw, intent);
                }
            } else if (this.liZ == 2) {
                if (this.liY != 4096 && (this.liY & 4096) > 0) {
                    v.e("MicroMsg.OpenFileChooserUI", "choose media from local or camera is not support");
                    setResult(1);
                    finish();
                } else if (this.liY == 16 || this.liY == 256) {
                    intent.putExtra("KEY_SIGHT_PARAMS", sW(0));
                    l.a(this, 7, intent, 3, 1);
                } else if (this.liY == 4096) {
                    v.e("MicroMsg.OpenFileChooserUI", "choose media from local is not support");
                    setResult(1);
                    finish();
                }
            } else if (this.liY != 4096 && (this.liY & 4096) > 0) {
                this.lja = e.cgg + "microMsg." + System.currentTimeMillis() + ".mp4";
                intExtra = getIntent().getIntExtra("key_pick_local_media_quality", 1);
                intExtra2 = getIntent().getIntExtra("key_pick_local_media_duration", 60);
                intent.putExtra("record_video_force_sys_camera", true);
                intent.putExtra("record_video_quality", intExtra);
                intent.putExtra("record_video_time_limit", intExtra2);
                intent.putExtra("video_full_path", this.lja);
                l.c(this, this.jZq, this.gfw, intent);
            } else if (this.liY == 16 || this.liY == 256) {
                this.lja = e.cgg + "microMsg." + System.currentTimeMillis() + ".mp4";
                l.a(this, this.lja, 5, getIntent().getIntExtra("key_pick_local_media_duration", 60), getIntent().getIntExtra("key_pick_local_media_quality", 1), this.liY == 16);
            } else if (this.liY == 4096) {
                intent.putExtra("show_header_view", false);
                l.c(this, this.jZq, this.gfw, intent);
            }
            z = (this.liY == 4096 || (this.liY & 4096) <= 0) ? (this.liY == 16 || this.liY == 256) ? true : this.liY == 4096 : true;
        } else {
            z = false;
        }
        if (!z) {
            if (!bjQ()) {
                s.makeText(this, getString(2131236613), 1).show();
                this.dFy = true;
            }
            intent = new Intent();
            intent.putExtra("key_send_raw_image", this.liX);
            intent.putExtra("query_media_type", this.gfV);
            switch (this.liY) {
                case 1:
                    intent.putExtra("show_header_view", false);
                    l.a(this, 1, this.jZq, this.gfw, intent);
                    return;
                case 2:
                    g.a(this, "", new String[]{getString(2131236606)}, "", true, new c(this) {
                        final /* synthetic */ OpenFileChooserUI ljc;

                        {
                            this.ljc = r1;
                        }

                        public final void gT(int i) {
                            v.i("MicroMsg.OpenFileChooserUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.ljc.nDR.nEl, "android.permission.CAMERA", 16, "", "")), be.bur(), this.ljc.nDR.nEl});
                            if (com.tencent.mm.pluginsdk.i.a.a(this.ljc.nDR.nEl, "android.permission.CAMERA", 16, "", "")) {
                                l.d(this.ljc.nDR.nEl, e.cgg, "microMsg." + System.currentTimeMillis() + ".jpg", 2);
                            }
                        }
                    }, new OnCancelListener(this) {
                        final /* synthetic */ OpenFileChooserUI ljc;

                        {
                            this.ljc = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            this.ljc.setResult(0);
                            this.ljc.finish();
                        }
                    });
                    return;
                case 3:
                    l.a(this, 1, this.count, this.gfw, intent);
                    return;
                default:
                    v.e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
                    setResult(0);
                    finish();
                    return;
            }
        }
    }

    private boolean bjQ() {
        v.i("MicroMsg.OpenFileChooserUI", "avaiableMem = %d", new Object[]{Long.valueOf(be.dX(this))});
        if (be.dX(this) <= 200) {
            return false;
        }
        return true;
    }

    private SightParams sW(int i) {
        String str = "microMsg_" + System.currentTimeMillis();
        this.lja = e.cgg + str + ".mp4";
        this.lek = e.cgg + str + ".jpeg";
        int intExtra = getIntent().getIntExtra("key_pick_local_media_duration", 60);
        SightParams sightParams = new SightParams(3, 1);
        sightParams.hww = this.liY == 16 ? 1 : 2;
        sightParams.mode = i;
        if (sightParams.hnB == null) {
            sightParams.hnB = new VideoTransPara();
        }
        sightParams.hnB.duration = intExtra;
        sightParams.l(str, this.lja, this.lek, e.cgg + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
        return sightParams;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.OpenFileChooserUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    l.d(this.nDR.nEl, e.cgg, "microMsg." + System.currentTimeMillis() + ".jpg", 2);
                    return;
                } else {
                    g.a(this, getString(2131234160), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                        final /* synthetic */ OpenFileChooserUI ljc;

                        {
                            this.ljc = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.ljc.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }

    protected void onActivityResult(int i, final int i2, final Intent intent) {
        File file = null;
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            Intent intent2 = new Intent();
            intent2.putExtra("key_pick_local_media_show_memory_warning", this.dFy);
            setResult(i2, intent2);
            finish();
            return;
        }
        String a;
        Intent intent3;
        SightCaptureResult sightCaptureResult;
        switch (i) {
            case 1:
            case 3:
                ak.vA().x(new Runnable(this) {
                    final /* synthetic */ OpenFileChooserUI ljc;

                    public final void run() {
                        List<String> stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                        boolean booleanExtra = intent.getBooleanExtra("isTakePhoto", false);
                        boolean booleanExtra2 = intent.getBooleanExtra("CropImage_Compress_Img", true);
                        ArrayList arrayList = new ArrayList();
                        for (String DT : stringArrayListExtra) {
                            x DT2 = x.DT(DT);
                            String str = DT2.bde;
                            DT2.lep = booleanExtra2;
                            com.tencent.mm.plugin.webview.e.e.bjd().b(DT2);
                            v.i("MicroMsg.OpenFileChooserUI", "now filepath is : %s, local id is : %s", new Object[]{DT, str});
                            arrayList.add(str);
                        }
                        v.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", new Object[]{ah.T(arrayList)});
                        Intent intent = new Intent();
                        intent.putExtra("key_pick_local_pic_callback_local_ids", DT);
                        intent.putExtra("key_pick_local_pic_source_type", booleanExtra ? "camera" : "album");
                        intent.putExtra("key_pick_local_media_show_memory_warning", this.ljc.dFy);
                        this.ljc.setResult(i2, intent);
                        this.ljc.finish();
                    }
                });
                return;
            case 2:
                a = l.a(this.nDR.nEl.getApplicationContext(), intent, e.cgg);
                if (be.kS(a)) {
                    v.w("MicroMsg.OpenFileChooserUI", "take photo, but result is null");
                    setResult(-2, intent);
                    finish();
                    return;
                }
                v.i("MicroMsg.OpenFileChooserUI", "take photo, result[%s]", new Object[]{a});
                intent3 = new Intent();
                intent3.putExtra("key_send_raw_image", this.liX);
                intent3.putExtra("max_select_count", this.jZq);
                intent3.putExtra("query_source_type", this.gfw);
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(a);
                intent3.putStringArrayListExtra("preview_image_list", arrayList);
                intent3.putExtra("preview_image", true);
                intent3.addFlags(67108864);
                com.tencent.mm.ay.c.b(this, "gallery", ".ui.GalleryEntryUI", intent3, 3);
                return;
            case 4:
                List stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                if (stringArrayListExtra == null || stringArrayListExtra.size() == 0) {
                    v.e("MicroMsg.OpenFileChooserUI", "choose video failed, path is null");
                    setResult(1);
                    finish();
                    return;
                }
                v.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_GALLERY_VIDEO");
                v.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", new Object[]{stringArrayListExtra.get(0)});
                if (this.liZ == 1 && !EV(this.lek)) {
                    v.i("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
                }
                ES((String) stringArrayListExtra.get(0));
                return;
            case 5:
                if (new File(this.lja).exists()) {
                    ES(this.lja);
                    return;
                }
                v.e("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_VIDEO, file not exist : %s", new Object[]{this.lja});
                setResult(1);
                finish();
                return;
            case 6:
                v.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_SIGHT_VIDEO");
                if (intent != null) {
                    v.i("MicroMsg.OpenFileChooserUI", "data is valid!");
                    sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        v.e("MicroMsg.OpenFileChooserUI", "sight capture result is null!");
                        setResult(1);
                        finish();
                    }
                    this.lja = sightCaptureResult.lTZ;
                    v.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", new Object[]{this.lja});
                    if (!EV(this.lek) && EV(sightCaptureResult.lUa)) {
                        this.lek = sightCaptureResult.lUa;
                    }
                    if (!TextUtils.isEmpty(this.lja)) {
                        file = new File(this.lja);
                    }
                    if (file == null || !file.exists()) {
                        v.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", new Object[]{this.lja});
                    } else {
                        v.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", new Object[]{this.lja});
                        ES(this.lja);
                        return;
                    }
                }
                v.e("MicroMsg.OpenFileChooserUI", "data is null!");
                setResult(1);
                finish();
                return;
            case 7:
                v.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA");
                if (intent != null) {
                    v.i("MicroMsg.OpenFileChooserUI", "data is valid!");
                    sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        v.e("MicroMsg.OpenFileChooserUI", "sight capture result is null!");
                        setResult(1);
                        finish();
                        return;
                    } else if (sightCaptureResult.lTX) {
                        a = sightCaptureResult.lUf;
                        v.e("MicroMsg.OpenFileChooserUI", "picture_picturePath file is not exist! path:%s", new Object[]{a});
                        if (be.kS(a)) {
                            v.e("MicroMsg.OpenFileChooserUI", "pic file is not exist! path:%s", new Object[]{a});
                        } else {
                            x DT = x.DT(a);
                            DT.lep = true;
                            DT.bcp = 1;
                            com.tencent.mm.plugin.webview.e.e.bjd().b(DT);
                            intent3 = new Intent();
                            intent3.putExtra("key_pick_local_media_local_id", DT.bde);
                            intent3.putExtra("key_pick_local_media_callback_type", 2);
                            setResult(i2, intent3);
                            finish();
                            return;
                        }
                    } else {
                        File file2;
                        this.lja = sightCaptureResult.lTZ;
                        v.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", new Object[]{this.lja});
                        if (!EV(this.lek) && EV(sightCaptureResult.lUa)) {
                            this.lek = sightCaptureResult.lUa;
                        }
                        if (TextUtils.isEmpty(this.lja)) {
                            file2 = null;
                        } else {
                            file2 = new File(this.lja);
                        }
                        if (file2 == null || !file2.exists()) {
                            v.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", new Object[]{this.lja});
                        } else {
                            v.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", new Object[]{this.lja});
                            ES(this.lja);
                            return;
                        }
                    }
                }
                v.e("MicroMsg.OpenFileChooserUI", "data is null!");
                setResult(1);
                finish();
                return;
            default:
                v.e("MicroMsg.OpenFileChooserUI", "unknown request code = %d", new Object[]{Integer.valueOf(i)});
                setResult(1);
                finish();
                return;
        }
    }

    private void ES(final String str) {
        this.ljb = new OnCancelListener(this) {
            final /* synthetic */ OpenFileChooserUI ljc;

            {
                this.ljc = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.ljc.setResult(0);
                this.ljc.finish();
            }
        };
        getString(2131231164);
        this.dwR = g.a(this, getString(2131236603), true, this.ljb);
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ OpenFileChooserUI ljc;

            public final void run() {
                List arrayList = new ArrayList();
                int a = this.ljc.EU(str);
                if (a == -50002) {
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass6 ljd;

                        {
                            this.ljd = r1;
                        }

                        public final void run() {
                            if (this.ljd.ljc.gfw == 7 && this.ljd.ljc.gfV == 2) {
                                g.a(this.ljd.ljc, this.ljd.ljc.getString(2131236604), this.ljd.ljc.getString(2131231164), this.ljd.ljc.getString(2131231075), false, new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass1 lje;

                                    {
                                        this.lje = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        this.lje.ljd.ljc.setResult(1);
                                        this.lje.ljd.ljc.finish();
                                    }
                                });
                                return;
                            }
                            Toast.makeText(this.ljd.ljc, this.ljd.ljc.getString(2131235788), 0).show();
                            this.ljd.ljc.setResult(1);
                            this.ljd.ljc.finish();
                        }
                    });
                    return;
                }
                String h;
                String d;
                if (a == -50006) {
                    h = OpenFileChooserUI.h(str, arrayList);
                    OpenFileChooserUI.b(this.ljc, str);
                    d = OpenFileChooserUI.d(this.ljc);
                } else if (a == 1) {
                    h = this.ljc.ET(str);
                    OpenFileChooserUI.b(this.ljc, str);
                    d = OpenFileChooserUI.d(this.ljc);
                    if (be.kS(h) && this.ljc.gfw == 7 && this.ljc.gfV == 2) {
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass6 ljd;

                            {
                                this.ljd = r1;
                            }

                            public final void run() {
                                g.a(this.ljd.ljc, this.ljd.ljc.getString(2131236605), this.ljd.ljc.getString(2131231164), this.ljd.ljc.getString(2131231075), false, new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass2 ljf;

                                    {
                                        this.ljf = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        this.ljf.ljd.ljc.setResult(1);
                                        this.ljf.ljd.ljc.finish();
                                    }
                                });
                            }
                        });
                        return;
                    }
                } else {
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass6 ljd;

                        {
                            this.ljd = r1;
                        }

                        public final void run() {
                            this.ljd.ljc.setResult(1);
                            this.ljd.ljc.finish();
                        }
                    });
                    return;
                }
                if (be.kS(h)) {
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass6 ljd;

                        {
                            this.ljd = r1;
                        }

                        public final void run() {
                            this.ljd.ljc.setResult(1);
                            this.ljd.ljc.finish();
                        }
                    });
                } else {
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass6 ljd;

                        public final void run() {
                            Intent intent = new Intent();
                            intent.putExtra("key_pick_local_media_callback_type", 1);
                            intent.putExtra("key_pick_local_media_local_id", h);
                            intent.putExtra("key_pick_local_media_thumb_local_id", d);
                            v.i("MicroMsg.OpenFileChooserUI", "thumbLocalId:%s", new Object[]{d});
                            this.ljd.ljc.setResult(-1, intent);
                            this.ljd.ljc.finish();
                        }
                    });
                }
            }
        });
    }

    private String ET(String str) {
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
        } catch (Exception e) {
            v.e("MicroMsg.OpenFileChooserUI", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[]{e});
            mediaMetadataRetriever = null;
        }
        if (mediaMetadataRetriever == null) {
            return null;
        }
        int i = be.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
        int i2 = be.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
        int i3 = be.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
        x DV = x.DV(str);
        DV.duration = (i3 + 500) / BaseReportManager.MAX_READ_COUNT;
        DV.width = i;
        DV.height = i2;
        DV.size = com.tencent.mm.a.e.aQ(str);
        if (this.liZ == 1) {
            DV.lek = this.lek;
        }
        com.tencent.mm.plugin.webview.e.e.bjd().b(DV);
        return DV.bde;
    }

    private int EU(String str) {
        com.tencent.mm.compatible.i.a.a l;
        Intent intent = new Intent();
        intent.setData(Uri.parse("file://" + str));
        com.tencent.mm.compatible.i.a.a aVar = null;
        com.tencent.mm.sdk.platformtools.ak.is2G(this);
        try {
            l = com.tencent.mm.compatible.i.a.l(this, intent);
        } catch (Throwable e) {
            v.a("MicroMsg.OpenFileChooserUI", e, "", new Object[0]);
            l = aVar;
        }
        if (l == null) {
            v.e("MicroMsg.OpenFileChooserUI", "compressVideo filed.");
            return -50005;
        }
        int i;
        String str2 = l.filename;
        boolean kR = com.tencent.mm.as.a.d.kR(str2);
        v.i("MicroMsg.OpenFileChooserUI", "isMp4 = %b", new Object[]{Boolean.valueOf(kR)});
        int i2 = -10000;
        if (kR) {
            i2 = SightVideoJNI.shouldRemuxing(str2, 660, 500, 26214400, 300000.0d, 1000000);
            v.i("MicroMsg.OpenFileChooserUI", "check remuxing, ret %d", new Object[]{Integer.valueOf(i2)});
        }
        if (i2 == -1 || !kR) {
            v.i("MicroMsg.OpenFileChooserUI", "fileLenght = %d", new Object[]{Integer.valueOf(com.tencent.mm.a.e.aQ(str2))});
            if (com.tencent.mm.a.e.aQ(str2) > 26214400) {
                i2 = -1;
            } else {
                i2 = 1;
            }
        }
        switch (i2) {
            case -6:
            case -5:
            case -4:
            case -3:
            case ai.CTRL_INDEX /*-2*/:
            case -1:
                return -50002;
            case 0:
                i = 1;
                i2 = 0;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                i = 0;
                i2 = 1;
                break;
            default:
                v.e("MicroMsg.OpenFileChooserUI", "unknown check type");
                return -50001;
        }
        if (i != 0) {
            i2 = -50006;
        }
        i = l.duration / BaseReportManager.MAX_READ_COUNT;
        v.i("MicroMsg.OpenFileChooserUI", "finish to import %s  ret %d | duration %d", new Object[]{str2, Integer.valueOf(i2), Integer.valueOf(i)});
        return i2;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.dwR != null && this.dwR.isShowing()) {
            this.dwR.dismiss();
        }
    }

    private static boolean EV(String str) {
        if (TextUtils.isEmpty(str)) {
            v.e("MicroMsg.OpenFileChooserUI", "video thumb file path is null");
            return false;
        }
        File file = new File(str);
        v.i("MicroMsg.OpenFileChooserUI", "thumbFilePath:%s", new Object[]{str});
        if (file.exists()) {
            v.i("MicroMsg.OpenFileChooserUI", "video thumb file is exist");
            return true;
        }
        v.e("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
        return false;
    }
}
