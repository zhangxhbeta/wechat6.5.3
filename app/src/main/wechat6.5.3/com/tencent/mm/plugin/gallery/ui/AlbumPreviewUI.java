package com.tencent.mm.plugin.gallery.ui;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.as.u;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.g.a;
import com.tencent.mm.plugin.gallery.model.g.b;
import com.tencent.mm.plugin.gallery.stub.GalleryStubService;
import com.tencent.mm.pluginsdk.ui.tools.SightCaptureResult;
import com.tencent.mm.pluginsdk.ui.tools.SightParams;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.DrawedCallBackFrameLayout;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.k;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

@com.tencent.mm.ui.base.a(19)
public class AlbumPreviewUI extends MMActivity implements b {
    private String bhM;
    private ProgressDialog dwR;
    private com.tencent.mm.plugin.gallery.stub.a geI = null;
    private long gfA = 0;
    private long gfB;
    private int gfC = -1;
    private ServiceConnection gfD = new ServiceConnection(this) {
        final /* synthetic */ AlbumPreviewUI gfG;

        {
            this.gfG = r1;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            v.d("MicroMsg.AlbumPreviewUI", "onServiceConnected");
            this.gfG.geI = com.tencent.mm.plugin.gallery.stub.a.a.N(iBinder);
            if (this.gfG.gfi != null) {
                this.gfG.gfi.geI = this.gfG.geI;
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            v.d("MicroMsg.AlbumPreviewUI", "onServiceDisconnected");
            this.gfG.geI = null;
        }
    };
    private com.tencent.mm.plugin.gallery.ui.a.a gfE = new com.tencent.mm.plugin.gallery.ui.a.a(this) {
        private OnClickListener fQr = new OnClickListener(this) {
            final /* synthetic */ AnonymousClass6 gfJ;

            {
                this.gfJ = r1;
            }

            private void aqS() {
                String stringExtra = this.gfJ.gfG.getIntent().getStringExtra("to_user");
                String stringExtra2 = this.gfJ.gfG.getIntent().getStringExtra("file_name");
                String stringExtra3 = this.gfJ.gfG.getIntent().getStringExtra("video_path");
                String stringExtra4 = this.gfJ.gfG.getIntent().getStringExtra("video_full_path");
                String stringExtra5 = this.gfJ.gfG.getIntent().getStringExtra("video_thumb_path");
                try {
                    Intent intent = new Intent();
                    intent.setClassName(this.gfJ.gfG.nDR.nEl.getPackageName(), "com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI");
                    intent.putExtra("VideoRecorder_ToUser", stringExtra);
                    intent.putExtra("VideoRecorder_FileName", stringExtra2);
                    intent.putExtra("VideoRecorder_VideoPath", stringExtra3);
                    intent.putExtra("VideoRecorder_VideoFullPath", stringExtra4);
                    intent.putExtra("VideoRecorder_VideoThumbPath", stringExtra5);
                    v.d("MicroMsg.AlbumPreviewUI", "try to record video, dump intent:\n%s", new Object[]{intent});
                    this.gfJ.gfG.startActivityForResult(intent, 4371);
                } catch (Exception e) {
                    v.w("MicroMsg.AlbumPreviewUI", e.toString());
                    if (!u.bi(this.gfJ.gfG.nDR.nEl) && !com.tencent.mm.ah.a.aT(this.gfJ.gfG.nDR.nEl)) {
                        com.tencent.mm.compatible.i.b.c(this.gfJ.gfG.nDR.nEl, 4372);
                    }
                }
            }

            public final void onClick(View view) {
                v.d("MicroMsg.AlbumPreviewUI", "on click open camera, valid click times[%d]", new Object[]{Integer.valueOf(this.gfJ.gfG.gfy)});
                if (this.gfJ.gfG.gfu) {
                    v.w("MicroMsg.AlbumPreviewUI", "click open camera, but camera is opening");
                    return;
                }
                AlbumPreviewUI.v(this.gfJ.gfG);
                this.gfJ.gfG.gfu = true;
                if (c.aqn().aqM() == 2) {
                    if (this.gfJ.gfG.getIntent().getBooleanExtra("record_video_force_sys_camera", false)) {
                        int intExtra = this.gfJ.gfG.getIntent().getIntExtra("record_video_quality", 0);
                        int intExtra2 = this.gfJ.gfG.getIntent().getIntExtra("record_video_time_limit", 0);
                        l.a(this.gfJ.gfG.nDR.nEl, this.gfJ.gfG.getIntent().getStringExtra("video_full_path"), 4372, intExtra2, intExtra, false);
                    } else if (this.gfJ.gfG.getIntent().getBooleanExtra("record_video_is_sight_capture", false)) {
                        if (((SightParams) this.gfJ.gfG.getIntent().getParcelableExtra("KEY_SIGHT_PARAMS")) == null) {
                            v.e("MicroMsg.AlbumPreviewUI", "takeMMSight, sightParams == null");
                        }
                        l.a(this.gfJ.gfG.nDR.nEl, 4375, this.gfJ.gfG.getIntent(), 3, 1);
                    } else if (p.ceJ.cdC == 2) {
                        aqS();
                    } else if (p.ceJ.cdC != 1 || u.bi(this.gfJ.gfG.nDR.nEl) || com.tencent.mm.ah.a.aT(this.gfJ.gfG.nDR.nEl)) {
                        aqS();
                    } else {
                        com.tencent.mm.compatible.i.b.c(this.gfJ.gfG.nDR.nEl, 4372);
                    }
                } else if (c.aqn().aqM() == 1 || c.aqn().aqM() == 3) {
                    File file = new File(e.cgg);
                    if (file.exists() || file.mkdir()) {
                        v.i("MicroMsg.AlbumPreviewUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.gfJ.gfG.nDR.nEl, "android.permission.CAMERA", 16, "", "")), be.bur(), this.gfJ.gfG.nDR.nEl});
                        if (com.tencent.mm.pluginsdk.i.a.a(this.gfJ.gfG.nDR.nEl, "android.permission.CAMERA", 16, "", "")) {
                            this.gfJ.gfG.XQ();
                            return;
                        }
                        return;
                    }
                    Toast.makeText(this.gfJ.gfG.nDR.nEl, this.gfJ.gfG.getString(2131231905), 1).show();
                }
            }
        };
        final /* synthetic */ AlbumPreviewUI gfG;

        {
            this.gfG = r2;
        }

        public final View getView() {
            View inflate = View.inflate(this.gfG.nDR.nEl, 2130903269, null);
            inflate.setOnClickListener(this.fQr);
            TextView textView = (TextView) inflate.findViewById(2131756015);
            if (c.aqn().aqM() == 2) {
                textView.setText(2131233052);
            } else if (c.aqn().aqM() == 1) {
                textView.setText(2131233051);
            }
            inflate.setLayerType(1, null);
            return inflate;
        }
    };
    private boolean gfF = false;
    private GridView gff;
    private TextView gfg;
    private TextView gfh;
    private a gfi;
    private TextView gfj;
    private ImageFolderMgrView gfk;
    private String gfl;
    private String gfm;
    private int gfn;
    private String gfo;
    private boolean gfp = false;
    private boolean gfq = false;
    private boolean gfr = false;
    private boolean gfs = false;
    private boolean gft = false;
    private boolean gfu = false;
    private int gfv;
    private int gfw;
    boolean gfx = false;
    private int gfy = 0;
    private int gfz = 0;
    private String toUser;

    private static class a implements Runnable {
        public WeakReference<a> gfL;
        public WeakReference<ProgressDialog> gfM;
        public ArrayList<MediaItem> gfN;

        private a() {
        }

        public final void run() {
            String str = "MicroMsg.AlbumPreviewUI";
            String str2 = "on NotifyMediaItemsChanged, size %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(this.gfN == null ? -1 : this.gfN.size());
            v.d(str, str2, objArr);
            if (this.gfL != null) {
                a aVar = (a) this.gfL.get();
                if (aVar != null) {
                    aVar.geJ.addAll(this.gfN);
                    aVar.notifyDataSetChanged();
                    if (this.gfM != null) {
                        ProgressDialog progressDialog = (ProgressDialog) this.gfM.get();
                        if (progressDialog != null && progressDialog.isShowing()) {
                            progressDialog.dismiss();
                        }
                    }
                }
            }
        }

        public final String toString() {
            return super.toString() + "|notifyRunnable";
        }
    }

    static /* synthetic */ void a(AlbumPreviewUI albumPreviewUI, com.tencent.mm.plugin.gallery.model.GalleryItem.a aVar) {
        if (aVar != null) {
            if (be.ah(albumPreviewUI.gfm, "").equals(aVar.gdW)) {
                v.w("MicroMsg.AlbumPreviewUI", "want to reset folder, same folder, return");
                return;
            }
            v.d("MicroMsg.AlbumPreviewUI", "reset folder[%s], path[%s]", new Object[]{aVar.gdW, aVar.aqB()});
            albumPreviewUI.gfl = aVar.aqB();
            albumPreviewUI.gfm = aVar.gdW;
            if (aVar.gdX != null) {
                albumPreviewUI.gfn = aVar.gdX.getType();
            }
            if (be.kS(albumPreviewUI.gfl)) {
                v.w("MicroMsg.AlbumPreviewUI", "reset folder path failed");
                albumPreviewUI.gfl = albumPreviewUI.gfm;
            }
            if (be.kS(albumPreviewUI.gfm)) {
                if (albumPreviewUI.getIntent().getBooleanExtra("show_header_view", true)) {
                    albumPreviewUI.gfi.a(albumPreviewUI.gfE);
                }
                albumPreviewUI.adg();
                albumPreviewUI.gfn = c.aqn().aqM();
            } else {
                a aVar2 = albumPreviewUI.gfi;
                com.tencent.mm.plugin.gallery.ui.a.a aVar3 = albumPreviewUI.gfE;
                if (aVar3 == null) {
                    v.w("MicroMsg.AlbumAdapter", "removeHeader error, header is null");
                } else {
                    aVar2.geN.remove(aVar3);
                }
                albumPreviewUI.gfh.setText(albumPreviewUI.gfm);
            }
            albumPreviewUI.gfi.geJ.clear();
            albumPreviewUI.ll(albumPreviewUI.gfi.geK.size());
            albumPreviewUI.gfi.notifyDataSetChanged();
            if (albumPreviewUI.dwR != null) {
                albumPreviewUI.dwR.dismiss();
            }
            albumPreviewUI.getString(2131231164);
            albumPreviewUI.dwR = g.a(albumPreviewUI, albumPreviewUI.getString(2131231182), true, new OnCancelListener(albumPreviewUI) {
                final /* synthetic */ AlbumPreviewUI gfG;

                {
                    this.gfG = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            String str = albumPreviewUI.gfm;
            if (aVar.gdX != null) {
                int type = aVar.gdX.getType();
                if (aVar.gdX.getType() == 2) {
                    str = "";
                }
                if (be.kS(aVar.gdW)) {
                    type = 3;
                }
                c.aqn().aA(str, type);
            }
        }
    }

    static /* synthetic */ void m(AlbumPreviewUI albumPreviewUI) {
        g.f(albumPreviewUI, 2131235787, 2131233049);
        v.w("MicroMsg.AlbumPreviewUI", "video is import error");
    }

    static /* synthetic */ void n(AlbumPreviewUI albumPreviewUI) {
        g.f(albumPreviewUI, 2131233048, 2131233049);
        v.w("MicroMsg.AlbumPreviewUI", "video is over size");
    }

    static /* synthetic */ int o(AlbumPreviewUI albumPreviewUI) {
        int i = albumPreviewUI.gfz + 1;
        albumPreviewUI.gfz = i;
        return i;
    }

    static /* synthetic */ int v(AlbumPreviewUI albumPreviewUI) {
        int i = albumPreviewUI.gfy + 1;
        albumPreviewUI.gfy = i;
        return i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gfB = System.currentTimeMillis();
        v.i("MicroMsg.AlbumPreviewUI", "onCreate");
        if (bundle != null) {
            v.i("MicroMsg.AlbumPreviewUI", "savedInstanceState not null");
            this.gfw = bundle.getInt("constants_key");
            c.aqn().li(this.gfw);
        }
        getString(2131231164);
        this.dwR = g.a(this, getString(2131231182), true, new OnCancelListener(this) {
            final /* synthetic */ AlbumPreviewUI gfG;

            {
                this.gfG = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        int intExtra = getIntent().getIntExtra("query_source_type", 3);
        int intExtra2 = getIntent().getIntExtra("query_media_type", 1);
        v.i("MicroMsg.AlbumPreviewUI", "query souce: " + intExtra + ", queryType: " + intExtra2);
        c.aqn().lh(intExtra2);
        c.aqn().li(intExtra);
        NI();
        c.aqn().geu.add(this);
        com.tencent.mm.plugin.gallery.model.l aqn = c.aqn();
        aqn.aA(this.gfm, aqn.gew);
        bindService(new Intent(this.nDR.nEl, GalleryStubService.class), this.gfD, 1);
    }

    protected void onPause() {
        super.onPause();
        this.gfu = true;
        c.aqo().aqz().removeCallbacksAndMessages(null);
        c.aqo().aqA();
        v.d("MicroMsg.AlbumPreviewUI", "shouldSaveLastChoosePath: " + this.gfq);
        if (this.gfq) {
            aqR();
        }
        if (this.gfk.Su) {
            ImageFolderMgrView imageFolderMgrView = this.gfk;
            if (!imageFolderMgrView.Su) {
                v.w("MicroMsg.ImageFolderMgrView", "want to close, but it was closed");
            } else if (imageFolderMgrView.ggl) {
                v.d("MicroMsg.ImageFolderMgrView", "want to close, but it is in animation");
            } else {
                imageFolderMgrView.ggh.setVisibility(8);
                imageFolderMgrView.Su = false;
            }
        }
    }

    protected void onResume() {
        super.onResume();
        v.d("MicroMsg.AlbumPreviewUI", "on resume");
        this.gfu = false;
    }

    protected void onDestroy() {
        super.onDestroy();
        v.i("MicroMsg.AlbumPreviewUI", "onDestroy");
        c.aqn().a(this.gfk);
        c.aqn().geu.remove(this);
        if (this.gfy > 0 || this.gfz > 0) {
            v.d("MicroMsg.AlbumPreviewUI", "report click camera count[%d], click folder count[%d]", new Object[]{Integer.valueOf(this.gfy), Integer.valueOf(this.gfz)});
            try {
                this.geI.Q(11187, this.gfy + "," + this.gfz);
            } catch (Throwable e) {
                v.e("MicroMsg.AlbumPreviewUI", "report error, %s", new Object[]{e.getMessage()});
                v.a("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
            }
        } else {
            v.w("MicroMsg.AlbumPreviewUI", "do not click camera or folder!");
        }
        try {
            unbindService(this.gfD);
        } catch (Throwable e2) {
            v.a("MicroMsg.AlbumPreviewUI", e2, "Failed to unbindService when Activity.onDestroy is invoked.", new Object[0]);
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        this.gfw = c.aqn().aqL();
        bundle.putInt("constants_key", this.gfw);
    }

    protected final int getLayoutId() {
        return 2130904302;
    }

    private void adg() {
        if (c.aqn().aqM() == 3) {
            vD(2131233018);
            this.gfh.setText(2131233018);
        } else if (c.aqn().aqM() == 1) {
            vD(2131233047);
            this.gfh.setText(2131233017);
        } else {
            vD(2131233019);
            this.gfh.setText(2131233019);
        }
    }

    public final void B(int i, boolean z) {
        boolean z2 = true;
        switch (c.aqn().aqM()) {
            case 3:
                if (!be.kS(this.bhM) && !"medianote".equals(this.toUser)) {
                    if (be.Nj() - this.gfA < 1000) {
                        v.w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
                        return;
                    }
                    v.i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
                    MediaItem mediaItem = (MediaItem) this.gfi.geJ.get(i);
                    if (mediaItem.getType() != 2) {
                        try {
                            com.tencent.mm.plugin.gallery.stub.a aVar = this.geI;
                            String str = mediaItem.gdY;
                            String str2 = this.toUser;
                            if (!this.gfp && this.gft) {
                                z2 = false;
                            }
                            aVar.a(str, str2, z2, 0, z);
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final void NI() {
        boolean z;
        for (String str : getIntent().getExtras().keySet()) {
            v.d("MicroMsg.AlbumPreviewUI", "key=%s | value=%s", new Object[]{str, getIntent().getExtras().get(str)});
        }
        this.bhM = getIntent().getStringExtra("GalleryUI_FromUser");
        this.toUser = getIntent().getStringExtra("GalleryUI_ToUser");
        this.gfv = getIntent().getIntExtra("max_select_count", 9);
        this.gfp = c.aqn().aqL() == 4;
        if (c.aqn().aqL() == 5) {
            z = true;
        } else {
            z = false;
        }
        this.gfr = z;
        if (c.aqn().aqL() == 9) {
            z = true;
        } else {
            z = false;
        }
        this.gfs = z;
        this.gfl = getIntent().getStringExtra("folder_path");
        this.gfm = getIntent().getStringExtra("folder_name");
        if (be.kS(this.gfl)) {
            v.e("MicroMsg.AlbumPreviewUI", "get folder path failed");
            this.gfl = this.gfm;
        }
        this.gft = getIntent().getBooleanExtra("key_send_raw_image", false);
        findViewById(2131758978).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AlbumPreviewUI gfG;

            {
                this.gfG = r1;
            }

            public final void onClick(View view) {
            }
        });
        this.gfj = (TextView) findViewById(2131757464);
        this.gfg = (TextView) findViewById(2131758983);
        if (c.aqn().aqL() == 0 || c.aqn().aqL() == 5 || c.aqn().aqL() == 10 || c.aqn().aqL() == 11) {
            findViewById(2131758982).setVisibility(8);
            this.gfg.setVisibility(8);
        } else {
            this.gfg.setVisibility(0);
            this.gfg.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ AlbumPreviewUI gfG;

                {
                    this.gfG = r1;
                }

                public final void onClick(View view) {
                    c.A(this.gfG.gfi.geJ);
                    Intent intent = new Intent(this.gfG, ImagePreviewUI.class);
                    intent.putStringArrayListExtra("preview_image_list", this.gfG.gfi.aqO());
                    intent.putExtra("max_select_count", this.gfG.gfv);
                    intent.putExtra("send_raw_img", this.gfG.gft);
                    intent.putExtra("GalleryUI_FromUser", this.gfG.bhM);
                    intent.putExtra("GalleryUI_ToUser", this.gfG.toUser);
                    this.gfG.startActivityForResult(intent, 0);
                }
            });
            if ((c.aqn().aqM() == 1 || c.aqn().aqM() == 2 || c.aqn().aqM() == 3) && this.gfv > 0) {
                OnMenuItemClickListener anonymousClass12 = new OnMenuItemClickListener(this) {
                    final /* synthetic */ AlbumPreviewUI gfG;

                    {
                        this.gfG = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        boolean z = false;
                        v.d("MicroMsg.AlbumPreviewUI", "send image, previewImageCount:%d, chooseForTimeline:%b", new Object[]{Integer.valueOf(c.aqs()), Boolean.valueOf(this.gfG.gfp)});
                        try {
                            this.gfG.geI.Q(11610, (this.gfG.gfp ? 3 : 2) + "," + c.aqs());
                        } catch (Throwable e) {
                            v.e("MicroMsg.AlbumPreviewUI", "report error, %s", new Object[]{e.getMessage()});
                            v.a("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
                        }
                        if (this.gfG.gfC < 0) {
                            try {
                                this.gfG.gfC = this.gfG.geI.aqN();
                            } catch (Throwable e2) {
                                this.gfG.gfC = 26214400;
                                v.e("MicroMsg.AlbumPreviewUI", "getMaxSendVideoSize error, %s", new Object[]{e2.getMessage()});
                                v.a("MicroMsg.AlbumPreviewUI", e2, "", new Object[0]);
                            }
                        }
                        c.aqr();
                        if (this.gfG.gfi.aqO().size() == 0) {
                            v.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick");
                            this.gfG.setResult(-2);
                            this.gfG.finish();
                        } else {
                            Intent intent = new Intent();
                            int aqM = c.aqn().aqM();
                            if (this.gfG.gfp) {
                                aqM = 1;
                            }
                            if (aqM == 1) {
                                String str = "CropImage_Compress_Img";
                                boolean z2 = this.gfG.gfp ? true : !this.gfG.gft;
                                intent.putExtra(str, z2);
                                intent.putStringArrayListExtra("CropImage_OutputPath_List", this.gfG.gfi.aqO());
                                intent.putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.gfG.gfB);
                                this.gfG.gfB = 0;
                                this.gfG.setResult(-1, intent);
                                this.gfG.gfq = true;
                                if (be.kS(this.gfG.bhM) || "medianote".equals(this.gfG.toUser)) {
                                    this.gfG.finish();
                                } else if (be.Nj() - this.gfG.gfA < 1000) {
                                    v.w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
                                } else {
                                    v.i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
                                    this.gfG.gfA = be.Nj();
                                    intent.setClassName(this.gfG, "com.tencent.mm.ui.chatting.SendImgProxyUI");
                                    intent.putExtra("GalleryUI_FromUser", this.gfG.bhM);
                                    intent.putExtra("GalleryUI_ToUser", this.gfG.toUser);
                                    this.gfG.startActivityForResult(intent, 4373);
                                }
                            } else if (aqM == 2) {
                                v.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick video");
                                com.tencent.mm.pluginsdk.ui.c.a HL = com.tencent.mm.pluginsdk.ui.c.a.HL((String) this.gfG.gfi.aqO().get(0));
                                HL.hO = this.gfG.gfC;
                                aqM = HL.bqB();
                                if (aqM == 0) {
                                    intent.setData(Uri.fromFile(new File((String) this.gfG.gfi.aqO().get(0))));
                                    intent.putStringArrayListExtra("key_select_video_list", this.gfG.gfi.aqO());
                                    this.gfG.setResult(-1, intent);
                                    this.gfG.gfq = true;
                                    this.gfG.finish();
                                } else if (aqM == 2) {
                                    AlbumPreviewUI.m(this.gfG);
                                } else {
                                    AlbumPreviewUI.n(this.gfG);
                                }
                            } else if (aqM != 3) {
                                v.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick default");
                                this.gfG.setResult(-2);
                                this.gfG.finish();
                            } else if (be.Nj() - this.gfG.gfA < 1000) {
                                v.w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
                            } else {
                                this.gfG.gfA = be.Nj();
                                ArrayList arrayList = this.gfG.gfi.geK;
                                ArrayList arrayList2 = new ArrayList();
                                ArrayList arrayList3 = new ArrayList();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    MediaItem mediaItem = (MediaItem) it.next();
                                    if (mediaItem.getType() == 1) {
                                        arrayList3.add(mediaItem.gdY);
                                    } else if (mediaItem.getType() == 2) {
                                        com.tencent.mm.pluginsdk.ui.c.a HL2 = com.tencent.mm.pluginsdk.ui.c.a.HL(mediaItem.gdY);
                                        HL2.hO = this.gfG.gfC;
                                        int bqB = HL2.bqB();
                                        if (bqB == 0) {
                                            arrayList2.add(mediaItem.gdY);
                                        } else if (bqB == 2) {
                                            AlbumPreviewUI.m(this.gfG);
                                        } else {
                                            AlbumPreviewUI.n(this.gfG);
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                                String str2 = "CropImage_Compress_Img";
                                if (this.gfG.gfp) {
                                    z = true;
                                } else if (!this.gfG.gft) {
                                    z = true;
                                }
                                intent.putExtra(str2, z);
                                intent.putStringArrayListExtra("key_select_video_list", arrayList2);
                                intent.putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.gfG.gfB);
                                this.gfG.gfB = 0;
                                if (arrayList3.size() > 0) {
                                    intent.setClassName(this.gfG, "com.tencent.mm.ui.chatting.SendImgProxyUI");
                                    intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList3);
                                    intent.putExtra("GalleryUI_FromUser", this.gfG.bhM);
                                    intent.putExtra("GalleryUI_ToUser", this.gfG.toUser);
                                    v.i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
                                    this.gfG.startActivityForResult(intent, 4373);
                                } else {
                                    v.i("MicroMsg.AlbumPreviewUI", "QueryTypeImageAndVideo");
                                    this.gfG.setResult(-1, intent);
                                    this.gfG.finish();
                                }
                            }
                        }
                        return true;
                    }
                };
                if (be.kS(this.gfo)) {
                    a(0, lm(0), anonymousClass12, k.b.nET);
                } else {
                    a(0, this.gfo, anonymousClass12);
                }
            }
        }
        this.gfk = (ImageFolderMgrView) findViewById(2131758984);
        com.tencent.mm.plugin.gallery.model.g.a aVar = this.gfk;
        c.aqn().a(aVar);
        c.aqn().get.add(aVar);
        com.tencent.mm.plugin.gallery.model.l aqn = c.aqn();
        if (aqn.gev == null) {
            v.f("MicroMsg.MediaQueryService", "media query not init, init again");
            aqn.aqK();
        }
        c.aqo().n(new Runnable(aqn) {
            final /* synthetic */ l gex;

            {
                this.gex = r1;
            }

            public final void run() {
                ArrayList aqE = this.gex.gev.aqE();
                l lVar = this.gex;
                a[] aVarArr = new a[lVar.get.size()];
                lVar.get.toArray(aVarArr);
                for (a B : aVarArr) {
                    B.B(aqE);
                }
            }

            public final String toString() {
                return super.toString() + "|queryAlbums";
            }
        });
        this.gfk.ggg = new com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView.a(this) {
            final /* synthetic */ AlbumPreviewUI gfG;

            {
                this.gfG = r1;
            }

            public final void a(com.tencent.mm.plugin.gallery.model.GalleryItem.a aVar) {
                AlbumPreviewUI.a(this.gfG, aVar);
            }
        };
        this.gfo = getIntent().getStringExtra("send_btn_string");
        findViewById(2131758979).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AlbumPreviewUI gfG;

            {
                this.gfG = r1;
            }

            public final void onClick(View view) {
                AlbumPreviewUI.o(this.gfG);
                this.gfG.gfk.aqT();
                v.d("MicroMsg.AlbumPreviewUI", "click folder times[%d]", new Object[]{Integer.valueOf(this.gfG.gfz)});
            }
        });
        this.gfh = (TextView) findViewById(2131758980);
        if (this.gfr) {
            iU(false);
        }
        iT(false);
        this.gff = (GridView) findViewById(2131758977);
        this.gff.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ AlbumPreviewUI gfG;

            {
                this.gfG = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, final int i, long j) {
                MediaItem lk;
                if (c.aqn().aqL() == 0 || c.aqn().aqL() == 5 || c.aqn().aqL() == 10 || c.aqn().aqL() == 11) {
                    if (c.aqn().aqM() == 2) {
                        g.a(this.gfG, true, this.gfG.getString(2131233050), "", this.gfG.getString(2131231149), this.gfG.getString(2131231010), new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass15 gfK;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                MediaItem lk = this.gfK.gfG.gfi.lk(i);
                                if (lk == null) {
                                    v.w("MicroMsg.AlbumPreviewUI", "get item for video error, null, position %d", new Object[]{Integer.valueOf(i)});
                                    this.gfK.gfG.setResult(0);
                                } else {
                                    v.i("MicroMsg.AlbumPreviewUI", "ShowAlert");
                                    Intent intent = new Intent();
                                    intent.setData(Uri.parse("file://" + Uri.encode(lk.gdY)));
                                    this.gfK.gfG.setResult(-1, intent);
                                }
                                this.gfK.gfG.finish();
                            }
                        }, null);
                        return;
                    }
                    lk = this.gfG.gfi.lk(i);
                    if (lk == null) {
                        v.w("MicroMsg.AlbumPreviewUI", "get item error, null, position %d", new Object[]{Integer.valueOf(i)});
                        this.gfG.setResult(0);
                    } else {
                        Intent intent = new Intent();
                        if (lk.getType() == 2) {
                            intent.putExtra("is_video", true);
                            intent.putExtra("video_full_path", lk.gdY);
                        }
                        if (c.aqn().aqL() == 10) {
                            intent.putExtra("CropImage_OutputPath", lk.gdY);
                        }
                        intent.setData(Uri.parse(Uri.encode(lk.gdY)));
                        v.i("MicroMsg.AlbumPreviewUI", "getItem ok");
                        this.gfG.setResult(-1, intent);
                    }
                    this.gfG.finish();
                } else if (c.aqn().aqL() == 4) {
                    if (i < this.gfG.gfi.geN.size()) {
                        v.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
                        return;
                    }
                    lk = this.gfG.gfi.lk(i);
                    if (lk == null) {
                        v.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!! MediaItem == null.");
                    } else if (lk.getType() != 2 || this.gfG.gfi.geK.size() == 0) {
                        ArrayList lj = this.gfG.gfi.lj(lk.getType());
                        c.A(lj);
                        Intent intent2 = new Intent(this.gfG, ImagePreviewUI.class);
                        intent2.putStringArrayListExtra("preview_image_list", this.gfG.gfi.aqO());
                        intent2.putExtra("preview_all", true);
                        intent2.putExtra("preview_position", lj.indexOf(lk));
                        this.gfG.B(i - this.gfG.gfi.geN.size(), true);
                        intent2.putExtra("send_raw_img", this.gfG.gft);
                        intent2.putExtra("max_select_count", this.gfG.gfv);
                        intent2.putExtra("GalleryUI_FromUser", this.gfG.bhM);
                        intent2.putExtra("GalleryUI_ToUser", this.gfG.toUser);
                        this.gfG.startActivityForResult(intent2, 0);
                    } else {
                        g.bf(this.gfG.nDR.nEl, com.tencent.mm.bd.a.O(this.gfG.nDR.nEl, 2131233025));
                    }
                } else if (i < this.gfG.gfi.geN.size()) {
                    v.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
                } else {
                    c.A(this.gfG.gfi.geJ);
                    Intent intent3 = new Intent(this.gfG, ImagePreviewUI.class);
                    intent3.putStringArrayListExtra("preview_image_list", this.gfG.gfi.aqO());
                    intent3.putExtra("preview_all", true);
                    intent3.putExtra("preview_position", i - this.gfG.gfi.geN.size());
                    this.gfG.B(i - this.gfG.gfi.geN.size(), true);
                    intent3.putExtra("send_raw_img", this.gfG.gft);
                    intent3.putExtra("max_select_count", this.gfG.gfv);
                    intent3.putExtra("GalleryUI_FromUser", this.gfG.bhM);
                    intent3.putExtra("GalleryUI_ToUser", this.gfG.toUser);
                    this.gfG.startActivityForResult(intent3, 0);
                }
            }
        });
        this.gfi = new a(this, new a.b(this) {
            final /* synthetic */ AlbumPreviewUI gfG;

            {
                this.gfG = r1;
            }

            public final void A(int i, int i2, int i3) {
                this.gfG.ll(i);
                this.gfG.B(i2, i3 == 0);
            }
        });
        if (this.gfp) {
            this.gfi.geO = true;
        }
        this.gff.setNumColumns(3);
        this.gff.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ AlbumPreviewUI gfG;
            private Runnable gfH = new Runnable(this) {
                final /* synthetic */ AnonymousClass3 gfI;

                {
                    this.gfI = r1;
                }

                public final void run() {
                    this.gfI.gfG.gfj.startAnimation(AnimationUtils.loadAnimation(this.gfI.gfG.nDR.nEl, 2130968623));
                    this.gfI.gfG.gfj.setVisibility(8);
                }
            };

            {
                this.gfG = r2;
            }

            private void dk(boolean z) {
                if (z) {
                    this.gfG.gfj.removeCallbacks(this.gfH);
                    if (this.gfG.gfj.getVisibility() != 0) {
                        this.gfG.gfj.clearAnimation();
                        Animation loadAnimation = AnimationUtils.loadAnimation(this.gfG.nDR.nEl, 2130968622);
                        this.gfG.gfj.setVisibility(0);
                        this.gfG.gfj.startAnimation(loadAnimation);
                        return;
                    }
                    return;
                }
                this.gfG.gfj.removeCallbacks(this.gfH);
                this.gfG.gfj.postDelayed(this.gfH, 256);
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                v.d("MicroMsg.AlbumPreviewUI", "scroll state[%d]", new Object[]{Integer.valueOf(i)});
                if (1 == i) {
                    dk(true);
                } else if (i == 0) {
                    dk(false);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a a = this.gfG.gfi;
                if (i < a.geN.size()) {
                    v.d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", new Object[]{Integer.valueOf(i)});
                    i = a.geN.size();
                }
                v.d("MicroMsg.AlbumPreviewUI", "data:[%s]", new Object[]{com.tencent.mm.ui.tools.gridviewheaders.a.bJA().a(new Date(a.lk(i).geb), a.mContext)});
                this.gfG.gfj.setText(r0);
            }
        });
        if (getIntent().getBooleanExtra("show_header_view", true)) {
            this.gfi.a(this.gfE);
        }
        this.gfi.geM = c.aqn().aqM();
        this.gfi.geH = this.gfv;
        v.i("MicroMsg.AlbumPreviewUI", "limit count = " + getIntent().getIntExtra("max_select_count", 9));
        this.gff.setAdapter(this.gfi);
        adg();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AlbumPreviewUI gfG;

            {
                this.gfG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                v.i("MicroMsg.AlbumPreviewUI", "backBtn");
                this.gfG.setResult(-2);
                if (this.gfG.gfk.Su) {
                    this.gfG.gfk.aqT();
                } else {
                    this.gfG.finish();
                }
                return true;
            }
        });
        ViewGroup viewGroup = (ViewGroup) findViewById(2131755452);
        if (viewGroup instanceof DrawedCallBackFrameLayout) {
            ((DrawedCallBackFrameLayout) viewGroup).nSA = new com.tencent.mm.ui.base.DrawedCallBackFrameLayout.a(this) {
                final /* synthetic */ AlbumPreviewUI gfG;

                {
                    this.gfG = r1;
                }

                public final void oo() {
                    try {
                        this.gfG.geI.oo();
                    } catch (Throwable e) {
                        v.a("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
                    }
                    if (this.gfG.gfx) {
                        try {
                            this.gfG.unbindService(this.gfG.gfD);
                        } catch (Throwable e2) {
                            v.a("MicroMsg.AlbumPreviewUI", e2, "Failed to unbindService when onViewDrawed is invoked.", new Object[0]);
                        }
                        this.gfG.gfx = false;
                    }
                }
            };
        }
    }

    private void XQ() {
        if (l.d(this.nDR.nEl, e.cgg, "microMsg." + System.currentTimeMillis() + ".jpg", 4369)) {
            c.aqo().lg(0);
            System.gc();
            return;
        }
        Toast.makeText(this.nDR.nEl, getString(2131234875), 1).show();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            v.i("MicroMsg.AlbumPreviewUI", "onKeyDown");
            setResult(-2);
            if (this.gfk.Su) {
                this.gfk.aqT();
                return true;
            }
            finish();
            return true;
        } else if (i != 82) {
            return super.onKeyDown(i, keyEvent);
        } else {
            this.gfz++;
            this.gfk.aqT();
            return true;
        }
    }

    protected final int NO() {
        return 1;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z = false;
        v.i("MicroMsg.AlbumPreviewUI", "on activity result, requestCode[%d] resultCode[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        String a;
        if (4369 == i) {
            if (-1 == i2) {
                a = l.a(this.nDR.nEl.getApplicationContext(), intent, e.cgg);
                if (be.kS(a)) {
                    v.w("MicroMsg.AlbumPreviewUI", "take photo, but result is null");
                    return;
                }
                v.i("MicroMsg.AlbumPreviewUI", "take photo, result[%s]", new Object[]{a});
                if (c.aqn().aqL() == 0 || c.aqn().aqL() == 5 || c.aqn().aqL() == 11) {
                    Intent intent2 = new Intent();
                    intent2.setData(Uri.parse("file://" + Uri.encode(a)));
                    v.i("MicroMsg.AlbumPreviewUI", "take photo finish");
                    setResult(-1, intent2);
                    finish();
                    return;
                }
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(a);
                Intent intent3 = new Intent(this, ImagePreviewUI.class);
                intent3.putExtra("isTakePhoto", true);
                intent3.putExtra("max_select_count", 1);
                intent3.putExtra("send_raw_img", this.gft);
                intent3.putStringArrayListExtra("preview_image_list", arrayList);
                intent3.putExtra("GalleryUI_FromUser", this.bhM);
                intent3.putExtra("GalleryUI_ToUser", this.toUser);
                startActivityForResult(intent3, 4370);
            }
        } else if (4370 == i) {
            if (-1 != i2) {
                return;
            }
            if (intent.getBooleanExtra("GalleryUI_IsSendImgBackground", false)) {
                v.i("MicroMsg.AlbumPreviewUI", "test onActivityResult");
                setResult(-1, intent);
                finish();
                return;
            }
            r2 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
            if (r2 == null || r2.isEmpty()) {
                v.w("MicroMsg.AlbumPreviewUI", "send filepath is null or nil");
                return;
            }
            v.i("MicroMsg.AlbumPreviewUI", "gallery photo:%s", new Object[]{r2});
            setResult(-1, intent);
            finish();
        } else if (4371 == i) {
            if (-1 == i2) {
                if (intent != null) {
                    intent.putExtra("from_record", true);
                }
                v.i("MicroMsg.AlbumPreviewUI", "custom record video, result[%s]", new Object[]{intent});
                setResult(-1, intent);
                finish();
            }
        } else if (4372 == i) {
            if (-1 == i2) {
                if (intent == null) {
                    intent = new Intent();
                }
                v.i("MicroMsg.AlbumPreviewUI", "system record video, result[%s]", new Object[]{intent});
                Serializable arrayList2 = new ArrayList();
                a = getIntent().getStringExtra("video_full_path");
                if (!be.kS(a)) {
                    arrayList2.add(a);
                    intent.putExtra("key_select_video_list", arrayList2);
                    intent.putExtra("key_selected_video_is_from_sys_camera", true);
                }
                setResult(-1, intent);
                finish();
            }
        } else if (4373 == i) {
            if (intent != null) {
                intent.putExtra("GalleryUI_IsSendImgBackground", true);
                v.e("MicroMsg.AlbumPreviewUI", "send img background, data is null!!");
            }
            v.i("MicroMsg.AlbumPreviewUI", "Request code sendimg proxy");
            setResult(-1, intent);
            this.gfx = true;
            finish();
        } else if (4375 != i) {
            switch (i2) {
                case ai.CTRL_INDEX /*-2*/:
                    v.e("MicroMsg.AlbumPreviewUI", "WTF!!!");
                    finish();
                    return;
                case -1:
                    if (intent == null) {
                        intent = new Intent();
                        intent.putExtra("CropImage_Compress_Img", true);
                        intent.putStringArrayListExtra("CropImage_OutputPath_List", this.gfi.aqO());
                    }
                    v.i("MicroMsg.AlbumPreviewUI", "onActivity Result ok");
                    setResult(-1, intent);
                    aqR();
                    finish();
                    return;
                case 0:
                    if (intent != null) {
                        r2 = intent.getStringArrayListExtra("preview_image_list");
                        if (r2 != null) {
                            this.gfi.D(r2);
                            this.gfi.notifyDataSetChanged();
                            ll(r2.size());
                        }
                        if (!intent.getBooleanExtra("CropImage_Compress_Img", true)) {
                            z = true;
                        }
                        this.gft = z;
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (-1 == i2) {
            if (intent == null) {
                intent = new Intent();
            }
            v.i("MicroMsg.AlbumPreviewUI", "sight capture record video, result[%s]", new Object[]{intent});
            SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
            if (sightCaptureResult == null) {
                v.e("MicroMsg.AlbumPreviewUI", "sight capture result is null!");
                setResult(1);
                finish();
            }
            Serializable arrayList3 = new ArrayList();
            String str = sightCaptureResult.lTZ;
            if (!be.kS(str)) {
                arrayList3.add(str);
                intent.putExtra("key_select_video_list", arrayList3);
            }
            setResult(-1, intent);
            finish();
        }
    }

    private void ll(int i) {
        if (i == 0) {
            this.gfg.setEnabled(false);
            iT(false);
        } else {
            this.gfg.setEnabled(true);
            iT(true);
        }
        if (i == 0) {
            this.gfg.setText(2131233032);
        } else {
            this.gfg.setText(getString(2131233032) + "(" + i + ")");
        }
        aq(0, lm(i));
    }

    private String lm(int i) {
        switch (c.aqn().aqL()) {
            case 4:
            case 7:
            case 8:
                if (i == 0 || this.gfv <= 1) {
                    return getString(2131233033);
                }
                return getString(2131233033) + "(" + i + "/" + this.gfv + ")";
            default:
                if (i == 0 || this.gfv <= 1) {
                    return getString(2131231149);
                }
                return getString(2131233026, new Object[]{Integer.valueOf(i), Integer.valueOf(this.gfv)});
        }
    }

    public final void C(ArrayList<MediaItem> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add((MediaItem) it.next());
            }
        }
        if (this.gfi != null) {
            Runnable aVar = new a();
            aVar.gfL = new WeakReference(this.gfi);
            aVar.gfM = new WeakReference(this.dwR);
            aVar.gfN = arrayList2;
            c.aqo().o(aVar);
        }
    }

    private void aqR() {
        if (this.gfF) {
            SharedPreferences sharedPreferences = getSharedPreferences("gallery_last_choose_album", 0);
            v.i("MicroMsg.AlbumPreviewUI", "last selected folderName and path: " + this.gfm + ", " + this.gfl);
            sharedPreferences.edit().putString(c.aqn().aqM(), this.gfm + "|" + this.gfl + "|" + this.gfn).commit();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.AlbumPreviewUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    XQ();
                    return;
                } else {
                    g.a(this, getString(2131234160), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AlbumPreviewUI gfG;

                        {
                            this.gfG = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.gfG.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }
}
