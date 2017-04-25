package com.samsung.android.sdk.look.airbutton;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Files;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video;
import android.view.View;
import com.samsung.android.sdk.look.Slook;
import com.samsung.android.sdk.look.SlookResourceManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter.AirButtonItem;
import java.util.ArrayList;

public final class SlookAirButtonRecentMediaAdapter extends SlookAirButtonAdapter {
    public static final String AUDIO_TYPE = "audio";
    private static final String ID = "id";
    public static final String IMAGE_TYPE = "image";
    private static final String MIME_TYPE = "mime_type";
    private static final String ORIENTATION = "orientation";
    private static final String TAG = "AirButtonRecentMediaAdapter";
    private static final String TITLE = "title";
    public static final String VIDEO_TYPE = "video";
    private static final String VOLUME = "external";
    private boolean DEBUG = false;
    private Context mContext;
    private int mCount = 0;
    private ArrayList<Bundle> mData = new ArrayList();
    private String mFilter;
    private boolean mIsShowing = false;
    private int mMaxCount = 15;
    private boolean mNeedUpdate = true;
    private Slook mSlook = new Slook();

    public SlookAirButtonRecentMediaAdapter(View view, Bundle bundle) {
        if (view == null && bundle == null) {
            throw new IllegalArgumentException("You should set the View and Bundle in Param");
        } else if (isSupport(1)) {
            this.mFilter = getFilter(bundle);
            if (view != null) {
                this.mContext = view.getContext();
                this.DEBUG = true;
                this.mMaxCount = SlookResourceManager.getInt(3);
                setEmptyText(SlookResourceManager.getText(this.mContext, 1));
            }
        }
    }

    public final AirButtonItem getItem(int i) {
        Bundle bundle = (Bundle) this.mData.get(i);
        int i2 = bundle.getInt(ID);
        int i3 = bundle.getInt(MIME_TYPE);
        return new AirButtonItem(getThumbNail(i2, i3, bundle.getString(TITLE), bundle.getInt(ORIENTATION)), null, getUri(i2, i3));
    }

    public final int getCount() {
        return this.mCount;
    }

    private Drawable getThumbNail(int i, int i2, String str, int i3) {
        switch (i2) {
            case 1:
                Options options = new Options();
                options.inSampleSize = 2;
                Bitmap thumbnail = Thumbnails.getThumbnail(this.mContext.getContentResolver(), (long) i, 1, options);
                if (thumbnail == null) {
                    return null;
                }
                if (i3 != 90 && i3 != 180 && i3 != 270) {
                    return new BitmapDrawable(this.mContext.getResources(), thumbnail);
                }
                Matrix matrix = new Matrix();
                matrix.postRotate((float) i3);
                return new BitmapDrawable(this.mContext.getResources(), Bitmap.createBitmap(thumbnail, 0, 0, thumbnail.getWidth(), thumbnail.getHeight(), matrix, true));
            case 2:
                return getAudioDrawable(str);
            case 3:
                return new BitmapDrawable(this.mContext.getResources(), Video.Thumbnails.getThumbnail(this.mContext.getContentResolver(), (long) i, 3, null));
            default:
                return null;
        }
    }

    private Drawable getAudioDrawable(String str) {
        Bitmap createBitmap = Bitmap.createBitmap(200, 200, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Drawable drawable = this.mContext.getResources().getDrawable(SlookResourceManager.getDrawableId(2));
        drawable.setBounds(new Rect(0, 0, 200, 200));
        canvas.drawColor(-2236963, Mode.SRC);
        drawable.draw(canvas);
        return new BitmapDrawable(this.mContext.getResources(), createBitmap);
    }

    private Uri getUri(int i, int i2) {
        switch (i2) {
            case 1:
                return ContentUris.withAppendedId(Media.EXTERNAL_CONTENT_URI, (long) i);
            case 2:
                return ContentUris.withAppendedId(Audio.Media.EXTERNAL_CONTENT_URI, (long) i);
            case 3:
                return ContentUris.withAppendedId(Video.Media.EXTERNAL_CONTENT_URI, (long) i);
            default:
                return null;
        }
    }

    private String getFilter(Bundle bundle) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        if (bundle == null || bundle.getBoolean(IMAGE_TYPE)) {
            stringBuilder.append("media_type = ");
            stringBuilder.append(1);
            i = 1;
        }
        if (bundle == null || bundle.getBoolean(VIDEO_TYPE)) {
            if (i != 0) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("media_type = ");
            stringBuilder.append(3);
            i = 1;
        }
        if (bundle == null || bundle.getBoolean(AUDIO_TYPE)) {
            if (i != 0) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("media_type = ");
            stringBuilder.append(2);
        }
        String stringBuilder2 = stringBuilder.toString();
        if (stringBuilder2 == null || stringBuilder2.length() <= 0) {
            return null;
        }
        return stringBuilder2;
    }

    public final void onShow(View view) {
        updateData();
        this.mIsShowing = true;
        super.onShow(view);
    }

    public final void onHide(View view) {
        this.mIsShowing = false;
        this.mNeedUpdate = true;
        this.mData.clear();
        super.onHide(view);
    }

    public final void onDismiss(View view) {
        this.mIsShowing = false;
        this.mNeedUpdate = true;
        this.mData.clear();
        super.onDismiss(view);
    }

    private synchronized void updateData() {
        Throwable th;
        if (this.mNeedUpdate && !this.mIsShowing) {
            this.mNeedUpdate = false;
            this.mData.clear();
            Cursor query;
            try {
                query = this.mContext.getContentResolver().query(Files.getContentUri(VOLUME), new String[]{"_id", "media_type", TITLE, ORIENTATION}, this.mFilter, null, "date_modified DESC LIMIT " + this.mMaxCount);
                if (query != null) {
                    while (query.moveToNext()) {
                        try {
                            Bundle bundle = new Bundle();
                            bundle.putInt(ID, query.getInt(0));
                            bundle.putInt(MIME_TYPE, query.getInt(1));
                            bundle.putInt(ORIENTATION, query.getInt(3));
                            this.mData.add(bundle);
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                    this.mCount = this.mData.size();
                } else if (query != null) {
                    query.close();
                }
            } catch (Throwable th3) {
                th = th3;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        }
    }

    private boolean isSupport(int i) {
        if (this.mSlook.isFeatureEnabled(1)) {
            return true;
        }
        return false;
    }
}
