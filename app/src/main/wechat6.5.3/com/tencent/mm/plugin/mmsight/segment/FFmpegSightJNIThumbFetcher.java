package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.tencent.mm.memory.o;
import com.tencent.mm.memory.o.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.v;

public class FFmpegSightJNIThumbFetcher implements e {
    private static final String TAG = "MicroMsg.FFmpegSightJNIThumbFetcher";
    private int mBufId;
    private int mDurationMs;
    private Bitmap mReusedBitmap;
    private int mScaledHeight;
    private int mScaledWidth;

    private static class ReleaseRunnable implements Runnable {
        int mBufId;
        Bitmap mReusedBitmap;

        private ReleaseRunnable(Bitmap bitmap, int i) {
            this.mReusedBitmap = bitmap;
            this.mBufId = i;
        }

        public void run() {
            if (!(this.mReusedBitmap == null || this.mReusedBitmap.isRecycled())) {
                o.cnL.d(this.mReusedBitmap);
            }
            SightVideoJNI.freeObj(this.mBufId);
        }
    }

    public void init(String str, int i, int i2, int i3) {
        v.i(TAG, "init() called with: path = [" + str + "], segment_interval = [" + i + "], width = [" + i2 + "], height = [" + i3 + "]");
        this.mBufId = SightVideoJNI.openFile(str, 1, 16, false);
        if (this.mBufId < 0) {
            throw new m("open file error.");
        }
        int videoWidth = SightVideoJNI.getVideoWidth(this.mBufId);
        int videoHeight = SightVideoJNI.getVideoHeight(this.mBufId);
        this.mDurationMs = (int) (SightVideoJNI.getVideoDuration(this.mBufId) * 1000.0d);
        Point calculateScaledLength = calculateScaledLength(i2, i3, videoWidth, videoHeight, new Point());
        this.mScaledWidth = calculateScaledLength.x;
        this.mScaledHeight = calculateScaledLength.y;
        v.i(TAG, "FFmpegSightJNIThumbFetcher.init. scaled size is (%d, %d); raw size is (%d, %d)", new Object[]{Integer.valueOf(this.mScaledWidth), Integer.valueOf(this.mScaledHeight), Integer.valueOf(videoWidth), Integer.valueOf(videoHeight)});
    }

    private Point calculateScaledLength(int i, int i2, int i3, int i4, Point point) {
        if (point == null) {
            throw new IllegalArgumentException("FFmpegThumbFetcherImpl : Point to calculateScaledLength can not be null.");
        }
        if (i2 <= 0 && i <= 0) {
            point.x = i3;
            point.y = i4;
        } else if (i <= 0) {
            point.x = (int) ((((float) i2) / ((float) i4)) * ((float) i3));
            point.y = i2;
        } else if (i2 <= 0) {
            point.x = i;
            point.y = (int) ((((float) i) / ((float) i3)) * ((float) i4));
        } else if (((float) i2) / ((float) i) > ((float) i4) / ((float) i3)) {
            point.x = (int) ((((float) i3) * ((float) i2)) / ((float) i4));
            point.y = i2;
        } else {
            point.x = i;
            point.y = (int) ((((float) i4) * ((float) i)) / ((float) i3));
        }
        return point;
    }

    public void reuseBitmap(Bitmap bitmap) {
        v.i(TAG, "reuseBitmap() called with: bitmap = [" + bitmap + "]");
        if (bitmap != null) {
            this.mReusedBitmap = bitmap;
        }
    }

    public Bitmap getFrameAtTime(long j) {
        long j2;
        long j3 = 0;
        v.i(TAG, "getFrameAtTime() called with: timeMs = [%d], mBufId = [%d]", new Object[]{Long.valueOf(j), Integer.valueOf(this.mBufId)});
        if (j > ((long) this.mDurationMs)) {
            j2 = (long) this.mDurationMs;
        } else {
            j2 = j;
        }
        if (j2 >= 0) {
            j3 = j2;
        }
        int seekStreamWithFlag = SightVideoJNI.seekStreamWithFlag((double) (((float) j3) / 1000.0f), 1, this.mBufId);
        v.i(TAG, "getFrameAtTime() seekStream return %d", new Object[]{Integer.valueOf(seekStreamWithFlag)});
        if (this.mReusedBitmap == null || this.mReusedBitmap.isRecycled() || this.mReusedBitmap.getWidth() != this.mScaledWidth || this.mReusedBitmap.getHeight() != this.mScaledHeight) {
            if (!(this.mReusedBitmap == null || this.mReusedBitmap.isRecycled())) {
                o.cnL.d(this.mReusedBitmap);
            }
            this.mReusedBitmap = o.cnL.a(new b(this.mScaledWidth, this.mScaledHeight));
        }
        seekStreamWithFlag = SightVideoJNI.drawScaledFrame(this.mBufId, this.mReusedBitmap, this.mScaledWidth, this.mScaledHeight);
        v.i(TAG, "getFrameAtTime() dr return %d", new Object[]{Integer.valueOf(seekStreamWithFlag)});
        Bitmap bitmap = this.mReusedBitmap;
        this.mReusedBitmap = null;
        return bitmap;
    }

    public int getDurationMs() {
        v.i(TAG, "getDurationMs() returned: " + this.mDurationMs);
        return this.mDurationMs;
    }

    public int getScaledWidth() {
        v.i(TAG, "getScaledWidth() returned: " + this.mScaledWidth);
        return this.mScaledWidth;
    }

    public int getScaledHeight() {
        v.i(TAG, "getScaledHeight() returned: " + this.mScaledHeight);
        return this.mScaledHeight;
    }

    public void release() {
        v.i(TAG, "release() called");
        e.a(new ReleaseRunnable(this.mReusedBitmap, this.mBufId), "release");
    }
}
