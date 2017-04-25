package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.g;
import java.util.List;

@TargetApi(16)
public class VideoCompressUI extends MMBaseActivity {
    private String bdZ;
    private String bou;
    private d gZK = new d(this);
    private VideoTransPara hlv;
    private ProgressDialog hsq;
    private a hsr = new a();
    private Runnable hss = new Runnable(this) {
        final /* synthetic */ VideoCompressUI hst;

        {
            this.hst = r1;
        }

        public final void run() {
            try {
                VideoCompressUI.a(this.hst, this.hst.bou);
                Intent intent = new Intent();
                Point j = VideoCompressUI.j(this.hst.hsr.geg, this.hst.hsr.gef, this.hst.hlv.width, this.hst.hlv.height);
                if (VideoCompressUI.b(this.hst, this.hst.hlv) || j != null) {
                    Point point;
                    if (j == null) {
                        point = new Point(this.hst.hsr.geg, this.hst.hsr.gef);
                    } else {
                        point = j;
                    }
                    String e = VideoCompressUI.e(this.hst);
                    SightVideoJNI.remuxing(this.hst.bou, e, point.x, point.y, this.hst.hlv.cGx, this.hst.hlv.cGn, 8, this.hst.hlv.cGm, 25.0f, (float) this.hst.hlv.cdg, null, 0);
                    intent.putExtra("K_SEGMENTVIDEOPATH", e);
                    intent.putExtra("KSEGMENTVIDEOTHUMBPATH", this.hst.cd(e, null));
                } else {
                    intent.putExtra("K_SEGMENTVIDEOPATH", this.hst.bou);
                    intent.putExtra("KSEGMENTVIDEOTHUMBPATH", this.hst.cd(this.hst.bou, this.hst.bdZ));
                }
                this.hst.setResult(-1, intent);
            } catch (Throwable e2) {
                v.a("VideoCompressUI", e2, "video compress failed e [%s]", new Object[]{e2.getMessage()});
            } finally {
                this.hst.finish();
            }
            ad.o(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 hsu;

                {
                    this.hsu = r1;
                }

                public final void run() {
                    if (this.hsu.hst.hsq != null) {
                        this.hsu.hst.hsq.dismiss();
                    }
                }
            });
        }
    };

    private class a {
        public int audioBitRate;
        public String gec;
        public String ged;
        public int gee;
        public int gef;
        public int geg;
        public int geh;
        final /* synthetic */ VideoCompressUI hst;
        public int videoBitRate;
        public int videoFrameRate;

        private a(VideoCompressUI videoCompressUI) {
            this.hst = videoCompressUI;
            this.gee = -1;
            this.gef = -1;
            this.geg = -1;
            this.videoBitRate = -1;
            this.geh = -1;
            this.videoFrameRate = -1;
            this.audioBitRate = -1;
        }
    }

    static /* synthetic */ void a(VideoCompressUI videoCompressUI, String str) {
        MediaFormat mediaFormat = null;
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(str);
            int trackCount = mediaExtractor.getTrackCount();
            MediaFormat mediaFormat2 = null;
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                if (trackFormat.containsKey("mime")) {
                    String string = trackFormat.getString("mime");
                    v.i("VideoCompressUI", "find video mime : %s", new Object[]{string});
                    if (string != null) {
                        if (string.startsWith("video/")) {
                            if (mediaFormat2 == null) {
                                mediaFormat2 = trackFormat;
                            }
                        } else if (string.startsWith("audio/") && r0 == null) {
                            mediaFormat = trackFormat;
                        }
                        if (!(mediaFormat == null || r1 == null)) {
                            break;
                        }
                    }
                    continue;
                }
            }
            MediaFormat mediaFormat3 = mediaFormat2;
            mediaFormat2 = mediaFormat;
            try {
                com.tencent.mm.plugin.sight.base.a zD = com.tencent.mm.plugin.sight.base.d.zD(str);
                if (zD == null) {
                    v.e("VideoCompressUI", "Get Media Info failed.");
                    videoCompressUI.finish();
                    return;
                }
                if (videoCompressUI.hsr != null && videoCompressUI.hsr.gee == -1) {
                    videoCompressUI.hsr.videoBitRate = zD.cGx;
                    videoCompressUI.hsr.audioBitRate = zD.cGk;
                    if (mediaFormat3 != null) {
                        videoCompressUI.hsr.gee = !mediaFormat3.containsKey("durationUs") ? 0 : (int) (mediaFormat3.getLong("durationUs") / 1000);
                        videoCompressUI.hsr.gef = !mediaFormat3.containsKey("height") ? 0 : mediaFormat3.getInteger("height");
                        videoCompressUI.hsr.geg = !mediaFormat3.containsKey("width") ? 0 : mediaFormat3.getInteger("width");
                        videoCompressUI.hsr.gec = !mediaFormat3.containsKey("mime") ? "" : mediaFormat3.getString("mime");
                        videoCompressUI.hsr.geh = !mediaFormat3.containsKey("i-frame-interval") ? 0 : mediaFormat3.getInteger("i-frame-interval");
                        videoCompressUI.hsr.videoFrameRate = !mediaFormat3.containsKey("frame-rate") ? 0 : mediaFormat3.getInteger("frame-rate");
                    }
                    if (mediaFormat2 != null) {
                        videoCompressUI.hsr.ged = !mediaFormat2.containsKey("mime") ? "" : mediaFormat2.getString("mime");
                    }
                }
                mediaExtractor.release();
            } catch (Throwable e) {
                v.a("VideoCompressUI", e, "Get MediaInfo failed", new Object[0]);
                videoCompressUI.finish();
                mediaExtractor.release();
            }
        } catch (Exception e2) {
            v.e("VideoCompressUI", "Video extractor init failed. video path = [%s] e = [%s]", new Object[]{str, e2.getMessage()});
        } finally {
            mediaExtractor.release();
        }
    }

    static /* synthetic */ boolean b(VideoCompressUI videoCompressUI, VideoTransPara videoTransPara) {
        boolean z = false;
        if (videoTransPara.cGl < videoCompressUI.hsr.geh) {
            z = true;
        }
        if (videoTransPara.cGx < videoCompressUI.hsr.videoBitRate) {
            z = true;
        }
        if (videoTransPara.cdg < videoCompressUI.hsr.videoFrameRate) {
            z = true;
        }
        return videoTransPara.cGk < videoCompressUI.hsr.audioBitRate ? true : z;
    }

    static /* synthetic */ String e(VideoCompressUI videoCompressUI) {
        final String str = CaptureMMProxy.getInstance().getAccVideoPath() + "video_send_preprocess_tmp_" + System.currentTimeMillis() + ".mp4";
        e.a(new Runnable(videoCompressUI) {
            final /* synthetic */ VideoCompressUI hst;

            public final void run() {
                List<FileEntry> A = FileOp.A(CaptureMMProxy.getInstance().getAccVideoPath(), false);
                if (A != null) {
                    for (FileEntry fileEntry : A) {
                        if (!(be.kS(fileEntry.name) || !fileEntry.name.contains("video_send_preprocess_tmp_") || str.equals(fileEntry.name))) {
                            FileOp.deleteFile(fileEntry.name);
                        }
                    }
                }
            }
        }, "delete other tmp path");
        return str;
    }

    static /* synthetic */ Point j(int i, int i2, int i3, int i4) {
        v.d("VideoCompressUI", "scale() called with: decoderOutputWidth = [" + i + "], decoderOutputHeight = [" + i2 + "], specWidth = [" + i3 + "], specHeight = [" + i4 + "]");
        if (i > i3 || i2 > i4) {
            int max = Math.max(i, i2);
            int min = Math.min(i, i2);
            int max2 = Math.max(i3, i4);
            int min2 = Math.min(i3, i4);
            if (max % 16 != 0 || Math.abs(max - max2) >= 16 || min % 16 != 0 || Math.abs(min - min2) >= 16) {
                int i5 = max / 2;
                max = min / 2;
                if (i5 % 16 != 0 || Math.abs(i5 - max2) >= 16 || max % 16 != 0 || Math.abs(max - min2) >= 16) {
                    Point point = new Point();
                    if (i < i2) {
                        i5 = Math.min(i3, i4);
                        max = (int) (((double) i2) / ((((double) i) * 1.0d) / ((double) i5)));
                    } else {
                        max = Math.min(i3, i4);
                        i5 = (int) (((double) i) / ((((double) i2) * 1.0d) / ((double) max)));
                    }
                    if (max % 2 != 0) {
                        max++;
                    }
                    if (i5 % 2 != 0) {
                        i5++;
                    }
                    v.i("VideoCompressUI", "calc scale, outputsize: %s %s", new Object[]{Integer.valueOf(i5), Integer.valueOf(max)});
                    point.x = i5;
                    point.y = max;
                    return point;
                }
                v.i("VideoCompressUI", "calc scale, double ratio divide by 16");
                i5 = i / 2;
                max = i2 / 2;
                if (i5 % 2 != 0) {
                    i5++;
                }
                if (max % 2 != 0) {
                    max++;
                }
                return new Point(i5, max);
            }
            v.i("VideoCompressUI", "calc scale, same len divide by 16, no need scale");
            return null;
        }
        v.i("VideoCompressUI", "calc scale, small or equal to spec size");
        return null;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130903145);
        Intent intent = getIntent();
        if (intent == null || be.kS(intent.getStringExtra("K_SEGMENTVIDEOPATH"))) {
            setResult(0);
            finish();
            return;
        }
        this.hsq = g.a(this, getString(2131231182), false, null);
        this.bou = intent.getStringExtra("K_SEGMENTVIDEOPATH");
        this.bdZ = intent.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.gZK));
        this.gZK.z(new Runnable(this) {
            final /* synthetic */ VideoCompressUI hst;

            {
                this.hst = r1;
            }

            public final void run() {
                this.hst.hlv = CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara();
                if (this.hst.hlv == null) {
                    v.e("VideoCompressUI", "VideoSendPreprocessTask para is null");
                    this.hst.setResult(0);
                    this.hst.finish();
                    return;
                }
                e.a(this.hst.hss, "video_remuxing_if_needed");
            }
        });
    }

    private String cd(String str, String str2) {
        final String str3;
        Throwable e;
        if (!be.kS(str2)) {
            return str2;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0);
            str3 = CaptureMMProxy.getInstance().getAccVideoPath() + "video_send_preprocess_thumb_" + System.currentTimeMillis() + ".jpg";
            e.a(new Runnable(this) {
                final /* synthetic */ VideoCompressUI hst;

                public final void run() {
                    List<FileEntry> A = FileOp.A(CaptureMMProxy.getInstance().getAccVideoPath(), false);
                    if (A != null) {
                        for (FileEntry fileEntry : A) {
                            if (!(be.kS(fileEntry.name) || !fileEntry.name.contains("video_send_preprocess_thumb_") || str3.equals(fileEntry.name))) {
                                FileOp.deleteFile(fileEntry.name);
                            }
                        }
                    }
                }
            }, "delete_thumb_path");
            try {
                com.tencent.mm.sdk.platformtools.d.a(frameAtTime, 80, CompressFormat.JPEG, str3, true);
                mediaMetadataRetriever.release();
            } catch (Exception e2) {
                e = e2;
                try {
                    v.a("VideoCompressUI", e, "get thumb error e [%s] videoMediaItem [%s] ", new Object[]{e.getMessage(), this.hsr});
                    return str3;
                } finally {
                    mediaMetadataRetriever.release();
                }
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            str3 = null;
            e = th;
            v.a("VideoCompressUI", e, "get thumb error e [%s] videoMediaItem [%s] ", new Object[]{e.getMessage(), this.hsr});
            return str3;
        }
        return str3;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.gZK != null) {
            this.gZK.release();
        }
    }
}
