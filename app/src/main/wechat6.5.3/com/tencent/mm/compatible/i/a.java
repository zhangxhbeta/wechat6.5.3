package com.tencent.mm.compatible.i;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore.Video.Media;
import android.provider.MediaStore.Video.Thumbnails;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class a {

    public static class a {
        public Bitmap bitmap = null;
        public int duration = 0;
        public String filename = null;
    }

    @TargetApi(5)
    public static a l(Context context, Intent intent) {
        if (intent == null || intent.getData() == null) {
            v.e("MicroMsg.GetVideoMetadata", "input invalid");
            return null;
        }
        long Nj = be.Nj();
        String dataString = intent.getDataString();
        v.i("MicroMsg.GetVideoMetadata", "dataString " + dataString);
        if (dataString == null) {
            v.e("MicroMsg.GetVideoMetadata", "dataString empty");
            return null;
        }
        Cursor query;
        ContentResolver contentResolver = context.getContentResolver();
        a aVar = new a();
        if (dataString.startsWith(Media.EXTERNAL_CONTENT_URI.toString())) {
            query = contentResolver.query(intent.getData(), null, null, null, null);
        } else {
            if (dataString.startsWith("content://")) {
                aVar.filename = be.d(context, intent.getData());
            } else if (dataString.startsWith("file://")) {
                if (intent.getExtras() != null) {
                    Uri uri = (Uri) intent.getExtras().getParcelable("android.intent.extra.STREAM");
                    if (!(uri == null || be.kS(uri.getPath()))) {
                        aVar.filename = uri.getPath();
                    }
                }
                if (aVar.filename == null) {
                    aVar.filename = dataString.substring(7);
                }
            }
            if (aVar.filename != null) {
                if (aVar.filename.startsWith("/storage/emulated/legacy")) {
                    aVar.filename = h.getExternalStorageDirectory().getAbsolutePath() + aVar.filename.substring(24);
                } else if (aVar.filename.startsWith("/sdcard")) {
                    aVar.filename = h.getExternalStorageDirectory().getAbsolutePath() + aVar.filename.substring(7);
                }
                query = contentResolver.query(Media.EXTERNAL_CONTENT_URI, null, "_data LIKE " + DatabaseUtils.sqlEscapeString(aVar.filename), null, null);
            } else {
                query = null;
            }
        }
        int i = Integer.MAX_VALUE;
        if (query != null) {
            if (query.getCount() > 0) {
                query.moveToFirst();
                i = query.getInt(query.getColumnIndexOrThrow("_id"));
                if (aVar.filename == null) {
                    aVar.filename = query.getString(query.getColumnIndexOrThrow("_data"));
                }
                aVar.duration = query.getInt(query.getColumnIndexOrThrow("duration"));
                if (aVar.duration == 0) {
                    MediaPlayer mediaPlayer = null;
                    try {
                        v.i("MicroMsg.GetVideoMetadata", "get video duration through MediaPlayer");
                        mediaPlayer = MediaPlayer.create(context, Uri.parse(aVar.filename));
                        aVar.duration = mediaPlayer != null ? mediaPlayer.getDuration() : 0;
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                    } catch (Throwable e) {
                        v.a("MicroMsg.GetVideoMetadata", e, "get duration error, %s", aVar.filename);
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                    } catch (Throwable th) {
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                    }
                }
                aVar.bitmap = null;
            }
            query.close();
        }
        if (i != Integer.MAX_VALUE) {
            try {
                aVar.bitmap = Thumbnails.getThumbnail(contentResolver, (long) i, 1, null);
            } catch (Throwable e2) {
                v.a("MicroMsg.GetVideoMetadata", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                aVar.bitmap = null;
            }
        }
        if (!be.kS(aVar.filename) && aVar.bitmap == null) {
            v.i("MicroMsg.GetVideoMetadata", "createVideoThumbnail manual");
            aVar.bitmap = ThumbnailUtils.createVideoThumbnail(aVar.filename, 1);
            if (aVar.bitmap == null) {
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + aVar.bitmap)));
            }
        }
        v.i("MicroMsg.GetVideoMetadata", "get video meta data cost time: %d meta[%s, %d]", Long.valueOf(be.az(Nj)), aVar.filename, Integer.valueOf(aVar.duration));
        if (aVar.filename != null) {
            return aVar;
        }
        return null;
    }
}
