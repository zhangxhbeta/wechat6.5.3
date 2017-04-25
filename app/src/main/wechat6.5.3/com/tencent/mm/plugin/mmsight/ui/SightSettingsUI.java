package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SightSettingsUI extends MMActivity {
    private ListView dyx;
    private d gZK = new d(this);
    private CaptureMMProxy hlE;
    private a hxu;
    private LinkedList<b> hxv = new LinkedList();

    class a extends BaseAdapter {
        final /* synthetic */ SightSettingsUI hxw;

        a(SightSettingsUI sightSettingsUI) {
            this.hxw = sightSettingsUI;
        }

        public final int getCount() {
            return this.hxw.hxv.size();
        }

        public final Object getItem(int i) {
            return this.hxw.hxv.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View textView = new TextView(this.hxw);
            final b bVar = (b) getItem(i);
            textView.setText(bVar.hxz + "->:" + bVar.nk(((Integer) bVar.hxw.hlE.get(bVar.hxC, Integer.valueOf(0))).intValue()));
            textView.setGravity(17);
            textView.setTextSize(1, 20.0f);
            textView.setHeight(com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 50));
            if (i % 2 == 1) {
                textView.setBackgroundColor(Color.parseColor("#e2efda"));
            }
            textView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a hxy;

                public final void onClick(View view) {
                    b bVar = bVar;
                    List linkedList = new LinkedList();
                    List linkedList2 = new LinkedList();
                    for (int i = 0; i < bVar.hxA.length; i++) {
                        linkedList.add(bVar.hxA[i]);
                        linkedList2.add(Integer.valueOf(i));
                    }
                    g.a(bVar.hxw, "", linkedList, linkedList2, "", new g.d(bVar) {
                        final /* synthetic */ b hxD;

                        {
                            this.hxD = r1;
                        }

                        public final void bw(int i, int i2) {
                            this.hxD.hxw.hlE.set(this.hxD.hxC, Integer.valueOf(this.hxD.hxB[i]));
                            this.hxD.hxw.hxu.notifyDataSetChanged();
                        }
                    });
                }
            });
            return textView;
        }
    }

    class b {
        String[] hxA;
        int[] hxB;
        com.tencent.mm.storage.t.a hxC;
        final /* synthetic */ SightSettingsUI hxw;
        public String hxz;

        public b(SightSettingsUI sightSettingsUI, String str, com.tencent.mm.storage.t.a aVar, String[] strArr, int[] iArr) {
            this.hxw = sightSettingsUI;
            this.hxz = str;
            this.hxA = strArr;
            this.hxC = aVar;
            this.hxB = iArr;
        }

        final String nk(int i) {
            int i2 = 0;
            while (i2 < this.hxB.length) {
                if (i == this.hxB[i2] && i2 < this.hxA.length) {
                    return this.hxA[i2];
                }
                i2++;
            }
            return this.hxA[0];
        }
    }

    static /* synthetic */ void a(SightSettingsUI sightSettingsUI) {
        SightSettingsUI sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.hxv.add(new b(sightSettingsUI2, "打开测试信息", com.tencent.mm.storage.t.a.ntB, new String[]{"Y", "N"}, new int[]{1, 0}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.hxv.add(new b(sightSettingsUI2, "打开旧的小视频入口", com.tencent.mm.storage.t.a.ntE, new String[]{"Y", "N"}, new int[]{1, 0}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.hxv.add(new b(sightSettingsUI2, "对焦方案", com.tencent.mm.storage.t.a.ntI, new String[]{"System", "啊..."}, new int[]{1, 0}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.hxv.add(new b(sightSettingsUI2, "裁剪方案", com.tencent.mm.storage.t.a.ntJ, new String[]{"default", "mediacodecv21", "mediacodecv", "ffmpeg"}, new int[]{-1, 1, 2, 3}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.hxv.add(new b(sightSettingsUI2, "是否把双通音频压成单通道", com.tencent.mm.storage.t.a.ntK, new String[]{"-1", "yes", "no"}, new int[]{-1, 1, 0}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.hxv.add(new b(sightSettingsUI2, "Thread", com.tencent.mm.storage.t.a.ntG, new String[]{"-1", "1", "2", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "4", "5", "6"}, new int[]{-1, 1, 2, 3, 4, 5, 6}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.hxv.add(new b(sightSettingsUI2, "裁剪预览MediaPlayer", com.tencent.mm.storage.t.a.ntL, new String[]{"系统方案", "MediaCodec解码播放方案"}, new int[]{1, 2}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.hxv.add(new b(sightSettingsUI2, "预设配置", com.tencent.mm.storage.t.a.ntF, new String[]{"跟后台配置", "MediaCodec+540p录制", "MediaCodec+720p双倍码率录制+后期压缩", "FFMpeg+540p录制", "FFMpeg+720p双倍码率录制+后期压缩", "MediaCodec+720p原码率录制", "FFMpeg+720p原码率录制", "MediaCodec+1080p+实时压缩", "MediaCodec+1080p+实时压缩/旋转", "FFMpeg+1080p+实时压缩", "FFMpeg+1080p+实时压缩/旋转"}, new int[]{-1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        sightSettingsUI.dyx = (ListView) sightSettingsUI.findViewById(2131755705);
        sightSettingsUI.hxu = new a(sightSettingsUI);
        sightSettingsUI.dyx.setAdapter(sightSettingsUI.hxu);
    }

    protected final int getLayoutId() {
        return 2130904407;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hlE = new CaptureMMProxy(this.gZK);
        this.gZK.z(new Runnable(this) {
            final /* synthetic */ SightSettingsUI hxw;

            {
                this.hxw = r1;
            }

            public final void run() {
                v.i("MicroMsg.SightSettingsUI", "has connect");
                SightSettingsUI.a(this.hxw);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SightSettingsUI hxw;

            {
                this.hxw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.hxw.finish();
                return false;
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        this.gZK.release();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }
}
