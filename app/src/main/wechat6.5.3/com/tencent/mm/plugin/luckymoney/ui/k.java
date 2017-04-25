package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.v;

public final class k {

    private enum a {
        NOTSET,
        ON,
        OFF
    }

    public static void cg(Context context) {
        a aVar = a.NOTSET;
        if (context == null || aVar == null) {
            v.e("MicroMsg.LuckySoundUtil", "play Err context:%s pathId:%d speekeron:%s looping:%b", new Object[]{context, Integer.valueOf(2131233596), aVar, Boolean.valueOf(false)});
        } else if (com.tencent.mm.h.a.st() && com.tencent.mm.h.a.sv()) {
            final String string = context.getString(2131233596);
            MediaPlayer mediaPlayer = new MediaPlayer();
            if (aVar != a.NOTSET) {
                mediaPlayer.setAudioStreamType(aVar == a.ON ? 5 : 0);
            }
            v.i("MicroMsg.LuckySoundUtil", "play start mp:%d path:%s context:%s pathId:%d speakerOn:%s looping:%b ", new Object[]{Integer.valueOf(mediaPlayer.hashCode()), string, context, Integer.valueOf(2131233596), aVar, Boolean.valueOf(false)});
            try {
                final AssetFileDescriptor openFd = context.getAssets().openFd(string);
                mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                mediaPlayer.setLooping(false);
                mediaPlayer.prepare();
                mediaPlayer.start();
                mediaPlayer.setOnErrorListener(new OnErrorListener() {
                    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        v.i("MicroMsg.LuckySoundUtil", "onError, what: %d, extra: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                        return false;
                    }
                });
                mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        int i = -1;
                        String str = "MicroMsg.LuckySoundUtil";
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
                            str = "MicroMsg.LuckySoundUtil";
                            str2 = "play mp:%d fd close failed path:%s e:%s";
                            objArr = new Object[3];
                            if (mediaPlayer != null) {
                                i = mediaPlayer.hashCode();
                            }
                            objArr[0] = Integer.valueOf(i);
                            objArr[1] = string;
                            objArr[2] = e.getMessage();
                            v.e(str, str2, objArr);
                            v.a("MicroMsg.LuckySoundUtil", e, "", new Object[0]);
                        }
                    }
                });
            } catch (Throwable e) {
                v.e("MicroMsg.LuckySoundUtil", "play failed pathId:%d e:%s", new Object[]{Integer.valueOf(2131233596), e.getMessage()});
                v.a("MicroMsg.LuckySoundUtil", e, "", new Object[0]);
            }
        }
    }
}
