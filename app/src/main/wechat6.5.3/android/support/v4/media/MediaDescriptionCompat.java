package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR = new Creator<MediaDescriptionCompat>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return VERSION.SDK_INT < 21 ? new MediaDescriptionCompat(parcel) : MediaDescriptionCompat.f(MediaDescription.CREATOR.createFromParcel(parcel));
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };
    private final Bundle mExtras;
    private final String uo;
    private final CharSequence up;
    private final CharSequence uq;
    private final CharSequence ur;
    private final Bitmap us;
    private final Uri ut;
    private final Uri uu;
    private Object uv;

    public static final class a {
        Bundle mExtras;
        String uo;
        CharSequence up;
        CharSequence uq;
        CharSequence ur;
        Bitmap us;
        Uri ut;
        Uri uu;
    }

    private MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.uo = str;
        this.up = charSequence;
        this.uq = charSequence2;
        this.ur = charSequence3;
        this.us = bitmap;
        this.ut = uri;
        this.mExtras = bundle;
        this.uu = uri2;
    }

    private MediaDescriptionCompat(Parcel parcel) {
        this.uo = parcel.readString();
        this.up = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.uq = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.ur = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.us = (Bitmap) parcel.readParcelable(null);
        this.ut = (Uri) parcel.readParcelable(null);
        this.mExtras = parcel.readBundle();
        this.uu = (Uri) parcel.readParcelable(null);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (VERSION.SDK_INT < 21) {
            parcel.writeString(this.uo);
            TextUtils.writeToParcel(this.up, parcel, i);
            TextUtils.writeToParcel(this.uq, parcel, i);
            TextUtils.writeToParcel(this.ur, parcel, i);
            parcel.writeParcelable(this.us, i);
            parcel.writeParcelable(this.ut, i);
            parcel.writeBundle(this.mExtras);
            parcel.writeParcelable(this.uu, i);
            return;
        }
        Object obj;
        if (this.uv != null || VERSION.SDK_INT < 21) {
            obj = this.uv;
        } else {
            Bundle bundle;
            Builder builder = new Builder();
            builder.setMediaId(this.uo);
            builder.setTitle(this.up);
            builder.setSubtitle(this.uq);
            builder.setDescription(this.ur);
            builder.setIconBitmap(this.us);
            builder.setIconUri(this.ut);
            Bundle bundle2 = this.mExtras;
            if (VERSION.SDK_INT >= 23 || this.uu == null) {
                bundle = bundle2;
            } else {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                    bundle2.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                }
                bundle2.putParcelable("android.support.v4.media.description.MEDIA_URI", this.uu);
                bundle = bundle2;
            }
            builder.setExtras(bundle);
            if (VERSION.SDK_INT >= 23) {
                builder.setMediaUri(this.uu);
            }
            this.uv = builder.build();
            obj = this.uv;
        }
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }

    public final String toString() {
        return this.up + ", " + this.uq + ", " + this.ur;
    }

    public static MediaDescriptionCompat f(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Uri uri;
        Bundle bundle;
        MediaDescriptionCompat mediaDescriptionCompat;
        a aVar = new a();
        aVar.uo = ((MediaDescription) obj).getMediaId();
        aVar.up = ((MediaDescription) obj).getTitle();
        aVar.uq = ((MediaDescription) obj).getSubtitle();
        aVar.ur = ((MediaDescription) obj).getDescription();
        aVar.us = ((MediaDescription) obj).getIconBitmap();
        aVar.ut = ((MediaDescription) obj).getIconUri();
        Bundle extras = ((MediaDescription) obj).getExtras();
        if (extras == null) {
            uri = null;
        } else {
            uri = (Uri) extras.getParcelable("android.support.v4.media.description.MEDIA_URI");
        }
        if (uri != null) {
            if (extras.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && extras.size() == 2) {
                bundle = null;
                aVar.mExtras = bundle;
                if (uri != null) {
                    aVar.uu = uri;
                } else if (VERSION.SDK_INT >= 23) {
                    aVar.uu = ((MediaDescription) obj).getMediaUri();
                }
                mediaDescriptionCompat = new MediaDescriptionCompat(aVar.uo, aVar.up, aVar.uq, aVar.ur, aVar.us, aVar.ut, aVar.mExtras, aVar.uu);
                mediaDescriptionCompat.uv = obj;
                return mediaDescriptionCompat;
            }
            extras.remove("android.support.v4.media.description.MEDIA_URI");
            extras.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        }
        bundle = extras;
        aVar.mExtras = bundle;
        if (uri != null) {
            aVar.uu = uri;
        } else if (VERSION.SDK_INT >= 23) {
            aVar.uu = ((MediaDescription) obj).getMediaUri();
        }
        mediaDescriptionCompat = new MediaDescriptionCompat(aVar.uo, aVar.up, aVar.uq, aVar.ur, aVar.us, aVar.ut, aVar.mExtras, aVar.uu);
        mediaDescriptionCompat.uv = obj;
        return mediaDescriptionCompat;
    }
}
