package com.tencent.mm.plugin.mmsight.segment;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.v;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class FFmpegMetadataRetriever {
    public static final String METADATA_CHAPTER_COUNT = "chapter_count";
    public static final String METADATA_KEY_ALBUM = "album";
    public static final String METADATA_KEY_ALBUM_ARTIST = "album_artist";
    public static final String METADATA_KEY_ARTIST = "artist";
    public static final String METADATA_KEY_AUDIO_CODEC = "audio_codec";
    public static final String METADATA_KEY_CHAPTER_END_TIME = "chapter_end_time";
    public static final String METADATA_KEY_CHAPTER_START_TIME = "chapter_start_time";
    public static final String METADATA_KEY_COMMENT = "comment";
    public static final String METADATA_KEY_COMPOSER = "composer";
    public static final String METADATA_KEY_COPYRIGHT = "copyright";
    public static final String METADATA_KEY_CREATION_TIME = "creation_time";
    public static final String METADATA_KEY_DATE = "date";
    public static final String METADATA_KEY_DISC = "disc";
    public static final String METADATA_KEY_DURATION = "duration";
    public static final String METADATA_KEY_ENCODED_BY = "encoded_by";
    public static final String METADATA_KEY_ENCODER = "encoder";
    public static final String METADATA_KEY_FILENAME = "filename";
    public static final String METADATA_KEY_FILESIZE = "filesize";
    public static final String METADATA_KEY_FRAMERATE = "framerate";
    public static final String METADATA_KEY_GENRE = "genre";
    public static final String METADATA_KEY_ICY_METADATA = "icy_metadata";
    public static final String METADATA_KEY_LANGUAGE = "language";
    public static final String METADATA_KEY_PERFORMER = "performer";
    public static final String METADATA_KEY_PUBLISHER = "publisher";
    public static final String METADATA_KEY_SERVICE_NAME = "service_name";
    public static final String METADATA_KEY_SERVICE_PROVIDER = "service_provider";
    public static final String METADATA_KEY_TITLE = "title";
    public static final String METADATA_KEY_TRACK = "track";
    public static final String METADATA_KEY_VARIANT_BITRATE = "bitrate";
    public static final String METADATA_KEY_VIDEO_CODEC = "video_codec";
    public static final String METADATA_KEY_VIDEO_HEIGHT = "video_height";
    public static final String METADATA_KEY_VIDEO_ROTATION = "rotate";
    public static final String METADATA_KEY_VIDEO_WIDTH = "video_width";
    public static final int OPTION_CLOSEST = 3;
    public static final int OPTION_CLOSEST_SYNC = 2;
    public static final int OPTION_NEXT_SYNC = 1;
    public static final int OPTION_PREVIOUS_SYNC = 0;
    private static final String TAG = "FFmpegMetadataRetriever";
    private long mNativeContext;
    private Bitmap reuse;

    public class a {
        HashMap<String, String> hqA;
        final /* synthetic */ FFmpegMetadataRetriever hqB;

        public a(FFmpegMetadataRetriever fFmpegMetadataRetriever) {
            this.hqB = fFmpegMetadataRetriever;
        }
    }

    private native byte[] _getFrameAtTime(long j, int i);

    private native byte[] _getScaledFrameAtTime(long j, int i, int i2, int i3);

    private native void _setDataSource(String str, String[] strArr, String[] strArr2);

    private native void native_finalize();

    private final native HashMap<String, String> native_getMetadata(boolean z, boolean z2, HashMap<String, String> hashMap);

    private static native void native_init();

    private native void native_setup();

    public native String extractMetadata(String str);

    public native String extractMetadataFromChapter(String str, int i);

    public native void release();

    public native void setDataSource(FileDescriptor fileDescriptor, long j, long j2);

    static {
        native_init();
    }

    public FFmpegMetadataRetriever() {
        native_setup();
    }

    public void setDataSource(String str) {
        _setDataSource(str, null, null);
    }

    public void setDataSource(String str, Map<String, String> map) {
        String[] strArr = new String[map.size()];
        String[] strArr2 = new String[map.size()];
        int i = 0;
        for (Entry entry : map.entrySet()) {
            strArr[i] = (String) entry.getKey();
            strArr2[i] = (String) entry.getValue();
            i++;
        }
        _setDataSource(str, strArr, strArr2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        setDataSource(fileDescriptor, 0, 576460752303423487L);
    }

    public void setDataSource(Context context, Uri uri) {
        Throwable th;
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        String scheme = uri.getScheme();
        if (scheme == null || scheme.equals("file")) {
            setDataSource(uri.getPath());
            return;
        }
        AssetFileDescriptor assetFileDescriptor = null;
        AssetFileDescriptor openAssetFileDescriptor;
        try {
            openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, "r");
            if (openAssetFileDescriptor == null) {
                try {
                    throw new IllegalArgumentException();
                } catch (SecurityException e) {
                    assetFileDescriptor = openAssetFileDescriptor;
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                        } catch (IOException e2) {
                        }
                    }
                    setDataSource(uri.toString());
                } catch (Throwable th2) {
                    th = th2;
                    if (openAssetFileDescriptor != null) {
                        try {
                            openAssetFileDescriptor.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            }
            FileDescriptor fileDescriptor = openAssetFileDescriptor.getFileDescriptor();
            if (fileDescriptor.valid()) {
                if (openAssetFileDescriptor.getDeclaredLength() < 0) {
                    setDataSource(fileDescriptor);
                } else {
                    setDataSource(fileDescriptor, openAssetFileDescriptor.getStartOffset(), openAssetFileDescriptor.getDeclaredLength());
                }
                if (openAssetFileDescriptor != null) {
                    try {
                        openAssetFileDescriptor.close();
                        return;
                    } catch (IOException e4) {
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException();
        } catch (FileNotFoundException e5) {
            throw new IllegalArgumentException();
        } catch (SecurityException e6) {
            if (assetFileDescriptor != null) {
                assetFileDescriptor.close();
            }
            setDataSource(uri.toString());
        } catch (Throwable th3) {
            openAssetFileDescriptor = null;
            th = th3;
            if (openAssetFileDescriptor != null) {
                openAssetFileDescriptor.close();
            }
            throw th;
        }
    }

    public a getMetadata() {
        boolean z = false;
        a aVar = new a(this);
        HashMap native_getMetadata = native_getMetadata(false, false, null);
        if (native_getMetadata == null) {
            return null;
        }
        if (native_getMetadata != null) {
            aVar.hqA = native_getMetadata;
            z = true;
        }
        if (z) {
            return aVar;
        }
        return null;
    }

    public Bitmap getFrameAtTime(long j, int i) {
        if (i < 0 || i > 3) {
            throw new IllegalArgumentException("Unsupported option: " + i);
        }
        byte[] _getFrameAtTime = _getFrameAtTime(j, i);
        if (_getFrameAtTime != null) {
            return getBitmapFromPixels(_getFrameAtTime, -1, -1);
        }
        return null;
    }

    public Bitmap getFrameAtTime(long j) {
        byte[] _getFrameAtTime = _getFrameAtTime(j, 2);
        if (_getFrameAtTime != null) {
            return getBitmapFromPixels(_getFrameAtTime, -1, -1);
        }
        return null;
    }

    public Bitmap getFrameAtTime() {
        return getFrameAtTime(-1, 2);
    }

    public Bitmap getScaledFrameAtTime(long j, int i, int i2, int i3) {
        if (i < 0 || i > 3) {
            throw new IllegalArgumentException("Unsupported option: " + i);
        }
        byte[] _getScaledFrameAtTime = _getScaledFrameAtTime(j, i, i2, i3);
        if (_getScaledFrameAtTime != null) {
            return getBitmapFromPixels(_getScaledFrameAtTime, i2, i3);
        }
        return null;
    }

    public Bitmap getScaledFrameAtTime(long j, int i, int i2) {
        byte[] _getScaledFrameAtTime = _getScaledFrameAtTime(j, 0, i, i2);
        if (_getScaledFrameAtTime != null) {
            return getBitmapFromPixels(_getScaledFrameAtTime, i, i2);
        }
        return null;
    }

    public void reuseBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            if (this.reuse != null) {
                this.reuse.recycle();
            }
            this.reuse = bitmap;
        }
    }

    private Bitmap getBitmapFromPixels(byte[] bArr, int i, int i2) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        if (i == -1) {
            i = getVideoWidth();
        }
        if (i2 == -1) {
            i2 = getVideoHeight();
        }
        if (i <= 0 || i2 <= 0) {
            throw new IllegalStateException(String.format(Locale.CHINA, "Can not get bitmap width and height [%d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        }
        Bitmap bitmap = this.reuse;
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        }
        bitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
        return bitmap;
    }

    public int getVideoWidth() {
        try {
            String extractMetadata = extractMetadata(METADATA_KEY_VIDEO_ROTATION);
            if ("90".equals(extractMetadata) || "270".equals(extractMetadata)) {
                extractMetadata = extractMetadata(METADATA_KEY_VIDEO_HEIGHT);
            } else {
                extractMetadata = extractMetadata(METADATA_KEY_VIDEO_WIDTH);
            }
            return Integer.valueOf(extractMetadata).intValue();
        } catch (Exception e) {
            v.e(TAG, "can not get video width %s", new Object[]{e.getMessage()});
            return 0;
        }
    }

    public int getVideoRotation() {
        int i = 0;
        try {
            i = Integer.valueOf(extractMetadata(METADATA_KEY_VIDEO_ROTATION)).intValue();
        } catch (Exception e) {
            v.e(TAG, "can not get video rotation. %s", new Object[]{e.getMessage()});
        }
        return i;
    }

    public int getVideoHeight() {
        try {
            String extractMetadata;
            String extractMetadata2 = extractMetadata(METADATA_KEY_VIDEO_ROTATION);
            if ("90".equals(extractMetadata2) || "270".equals(extractMetadata2)) {
                extractMetadata = extractMetadata(METADATA_KEY_VIDEO_WIDTH);
            } else {
                extractMetadata = extractMetadata(METADATA_KEY_VIDEO_HEIGHT);
            }
            v.d(TAG, "video height %s rotate %s", new Object[]{extractMetadata, extractMetadata2});
            return Integer.valueOf(extractMetadata).intValue();
        } catch (Exception e) {
            v.e(TAG, "can not get video height %s", new Object[]{e.getMessage()});
            return 0;
        }
    }

    public byte[] getScaledFrameAtTimeUndecoded(long j, int i, int i2) {
        return _getScaledFrameAtTime(j, 2, i, i2);
    }

    protected void finalize() {
        try {
            native_finalize();
        } catch (Exception e) {
            v.e(TAG, "do nothing");
        } finally {
            super.finalize();
        }
    }
}
