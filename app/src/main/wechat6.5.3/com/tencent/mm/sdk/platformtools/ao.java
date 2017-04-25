package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class ao {

    public interface a {
        void pa();
    }

    private enum b {
        NOTSET,
        ON,
        OFF
    }

    public static void a(Context context, int i, b bVar, boolean z, final a aVar) {
        if (context == null || bVar == null) {
            v.e("MicroMsg.PlaySound", "play Err context:%s pathId:%d speekeron:%s looping:%b listener:%s", context, Integer.valueOf(i), bVar, Boolean.valueOf(false), aVar);
            return;
        }
        final String string = context.getString(i);
        MediaPlayer mediaPlayer = new MediaPlayer();
        if (bVar != b.NOTSET) {
            mediaPlayer.setAudioStreamType(bVar == b.ON ? 3 : 0);
        }
        v.i("MicroMsg.PlaySound", "play start mp:%d path:%s context:%s pathId:%d speakerOn:%s looping:%b listener:%s ", Integer.valueOf(mediaPlayer.hashCode()), string, context, Integer.valueOf(i), bVar, Boolean.valueOf(false), aVar);
        try {
            final AssetFileDescriptor openFd = context.getAssets().openFd(string);
            mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            mediaPlayer.setLooping(false);
            mediaPlayer.prepare();
            mediaPlayer.start();
            mediaPlayer.setOnErrorListener(new OnErrorListener() {
                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    v.i("MicroMsg.PlaySound", "onError, what: %d, extra: %d", Integer.valueOf(i), Integer.valueOf(i2));
                    return false;
                }
            });
            mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
                public final void onCompletion(MediaPlayer mediaPlayer) {
                    int i = -1;
                    String str = "MicroMsg.PlaySound";
                    String str2 = "play completion mp:%d  path:%s";
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(mediaPlayer == null ? -1 : mediaPlayer.hashCode());
                    objArr[1] = string;
                    v.i(str, str2, objArr);
                    if (mediaPlayer != null) {
                        mediaPlayer.release();
                    }
                    try {
                        openFd.close();
                    } catch (Throwable e) {
                        str = "MicroMsg.PlaySound";
                        str2 = "play mp:%d fd close failed path:%s e:%s";
                        objArr = new Object[3];
                        if (mediaPlayer != null) {
                            i = mediaPlayer.hashCode();
                        }
                        objArr[0] = Integer.valueOf(i);
                        objArr[1] = string;
                        objArr[2] = e.getMessage();
                        v.e(str, str2, objArr);
                        v.a("MicroMsg.PlaySound", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                    if (aVar != null) {
                        aVar.pa();
                    }
                }
            });
        } catch (Throwable e) {
            v.e("MicroMsg.PlaySound", "play failed pathId:%d e:%s", Integer.valueOf(i), e.getMessage());
            v.a("MicroMsg.PlaySound", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static void a(Context context, a aVar) {
        a(context, 2131235643, b.ON, false, aVar);
    }

    public static void a(Context context, int i, a aVar) {
        a(context, i, b.NOTSET, false, aVar);
    }

    public static void T(Context context, int i) {
        a(context, i, b.NOTSET, false, null);
    }
}
