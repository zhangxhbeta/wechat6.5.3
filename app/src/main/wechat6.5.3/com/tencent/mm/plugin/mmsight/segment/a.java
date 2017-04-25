package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@TargetApi(16)
public abstract class a implements g {
    private String ffx;
    String hql;
    String hqm;
    private MediaExtractor hqn;
    private List<a> hqo = new ArrayList();
    private List<a> hqp = new ArrayList();
    long hqq;
    long hqr;
    int hqs = -1;
    private boolean hqt = false;
    VideoTransPara hqu;
    int hqv = -1;

    class a {
        MediaFormat hpY;
        final /* synthetic */ a hqw;
        int index;

        a(a aVar, MediaFormat mediaFormat, int i) {
            this.hqw = aVar;
            this.hpY = mediaFormat;
            this.index = i;
        }
    }

    public abstract int wA(String str);

    public void a(String str, String str2, VideoTransPara videoTransPara) {
        v.d("BaseMediaCodecClipper", "init() called with: src = [" + str + "], dst = [" + str2 + "], para = [" + videoTransPara + "]");
        long Nj = be.Nj();
        if (be.kS(str) || be.kS(str2) || videoTransPara == null) {
            throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument's null or nil. src = %s; dst = %s; param = %s", new Object[]{str, str2, videoTransPara}));
        }
        File file = new File(str);
        File file2 = new File(str2);
        if (FileOp.aR(str) && file.canRead() && file.length() != 0) {
            this.hqm = str;
            this.hql = str2;
            this.hqu = videoTransPara;
            this.hqn = new MediaExtractor();
            this.hqn.setDataSource(str);
            a(this.hqn);
            if (this.hqo == null || this.hqo.size() == 0) {
                throw new m("Can not find video or audio track in this video file.");
            }
            this.hqs = aAG();
            this.hqv = wA(str);
            this.hqt = true;
            v.e("BaseMediaCodecClipper", "init cost time %dms", new Object[]{Long.valueOf(be.az(Nj))});
            return;
        }
        throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument src video file can not be read or empty %s", new Object[]{str}));
    }

    private void a(MediaExtractor mediaExtractor) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
            if (trackFormat.containsKey("mime") && !be.kS(trackFormat.getString("mime"))) {
                String string = trackFormat.getString("mime");
                v.i("BaseMediaCodecClipper", "mime: %s", new Object[]{string});
                if (string.startsWith("audio/")) {
                    this.hqp.add(new a(this, trackFormat, i));
                } else if (string.startsWith("video/")) {
                    this.hqo.add(new a(this, trackFormat, i));
                }
            }
        }
        v.i("BaseMediaCodecClipper", "findMediaFormat mAudioSelectedTrackList.size() = %d, mVideoSelectedTrackList.size() = %d", new Object[]{Integer.valueOf(this.hqp.size()), Integer.valueOf(this.hqo.size())});
    }

    public int k(long j, long j2) {
        if (this.hqt) {
            if (j < 0) {
                j = 0;
            }
            this.hqq = j;
            MediaFormat mediaFormat = ((a) this.hqo.get(0)).hpY;
            if (mediaFormat.containsKey("durationUs")) {
                if (j2 <= 0 || j2 > mediaFormat.getLong("durationUs") / 1000) {
                    j2 = mediaFormat.getLong("durationUs") / 1000;
                }
                this.hqr = j2;
                return a(this.hqn, this.hqp, this.hqo);
            }
            throw new m("Can not find duration.");
        }
        v.e("BaseMediaCodecClipper", "checkTimeParameter has not been initialized.");
        throw new IllegalStateException("Please init this component first.");
    }

    protected int a(MediaExtractor mediaExtractor, List<a> list, List<a> list2) {
        return 0;
    }

    protected final String aAF() {
        if (this.ffx == null) {
            this.ffx = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_clip_temp.mp4";
        }
        return this.ffx;
    }

    public final void release() {
        this.hqt = false;
        if (this.hqn != null) {
            this.hqn.release();
        }
    }

    private int aAG() {
        int i;
        int i2 = -1;
        if (!(this.hqp == null || this.hqp.size() == 0)) {
            i = -1;
            for (a aVar : this.hqp) {
                if (aVar.hpY.containsKey("max-input-size")) {
                    i2 = Math.max(aVar.hpY.getInteger("max-input-size"), i);
                } else {
                    i2 = i;
                }
                i = i2;
            }
            i2 = i;
        }
        if (this.hqo == null || this.hqo.size() == 0) {
            return i2;
        }
        i = i2;
        for (a aVar2 : this.hqo) {
            if (aVar2.hpY.containsKey("max-input-size")) {
                i2 = Math.max(aVar2.hpY.getInteger("max-input-size"), i);
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }
}
