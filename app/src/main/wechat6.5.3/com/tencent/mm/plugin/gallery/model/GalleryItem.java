package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.be;

public final class GalleryItem {

    public static abstract class MediaItem implements Parcelable, Comparable<MediaItem> {
        public String gdY;
        public String gdZ;
        public long gea;
        public long geb;
        public String mMimeType;

        public abstract String aqB();

        public abstract int getType();

        public /* synthetic */ int compareTo(Object obj) {
            return a((MediaItem) obj);
        }

        public MediaItem() {
            this(0, "", "", "");
        }

        public MediaItem(long j) {
            this(j, "", "", "");
        }

        public MediaItem(long j, String str, String str2, String str3) {
            this.gea = j;
            this.gdY = str;
            this.gdZ = str2;
            this.mMimeType = str3;
        }

        public static MediaItem a(int i, long j, String str, String str2, String str3) {
            if (i == 1) {
                return new ImageMediaItem(j, str, str2, str3);
            }
            return new VideoMediaItem(j, str, str2, str3);
        }

        public static MediaItem s(int i, long j) {
            if (i == 1) {
                return new ImageMediaItem(j);
            }
            return new VideoMediaItem(j);
        }

        public final int a(MediaItem mediaItem) {
            if (this.geb > mediaItem.geb) {
                return 1;
            }
            return this.geb < mediaItem.geb ? -1 : -1;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof MediaItem)) {
                return false;
            }
            MediaItem mediaItem = (MediaItem) obj;
            if (this.gdY == null || !this.gdY.equals(mediaItem.gdY)) {
                return false;
            }
            return true;
        }

        public String toString() {
            return "MediaItem{mOrignalPath='" + this.gdY + '\'' + ", mThumbPath='" + this.gdZ + '\'' + ", origId=" + this.gea + ", addDate=" + this.geb + ", mMimeType='" + this.mMimeType + '\'' + '}';
        }
    }

    public static class a {
        public int bcq;
        public String gdW;
        public MediaItem gdX;

        public a(String str, int i) {
            this.gdW = be.ma(str);
            this.bcq = i;
        }

        public final String aqB() {
            if (this.gdX == null) {
                return null;
            }
            return this.gdX.aqB();
        }

        public final long aqC() {
            if (this.gdX == null) {
                return -1;
            }
            return this.gdX.gea;
        }
    }

    public static class ImageMediaItem extends MediaItem {
        public static final Creator<MediaItem> CREATOR = new Creator<MediaItem>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                MediaItem imageMediaItem = new ImageMediaItem();
                imageMediaItem.gdY = parcel.readString();
                imageMediaItem.gdZ = parcel.readString();
                imageMediaItem.gea = parcel.readLong();
                imageMediaItem.geb = parcel.readLong();
                imageMediaItem.mMimeType = parcel.readString();
                return imageMediaItem;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new MediaItem[i];
            }
        };

        public ImageMediaItem(long j) {
            super(j);
        }

        public ImageMediaItem(long j, String str, String str2, String str3) {
            super(j, str, str2, str3);
        }

        public final int getType() {
            return 1;
        }

        public final String aqB() {
            if (be.kS(this.gdZ)) {
                return this.gdY;
            }
            return this.gdZ;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.gdY);
            parcel.writeString(this.gdZ);
            parcel.writeLong(this.gea);
            parcel.writeLong(this.geb);
            parcel.writeString(this.mMimeType);
        }
    }

    public static class VideoMediaItem extends MediaItem {
        public static final Creator<MediaItem> CREATOR = new Creator<MediaItem>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                VideoMediaItem videoMediaItem = new VideoMediaItem();
                videoMediaItem.gdY = parcel.readString();
                videoMediaItem.gdZ = parcel.readString();
                videoMediaItem.gea = parcel.readLong();
                videoMediaItem.mMimeType = parcel.readString();
                videoMediaItem.geg = parcel.readInt();
                videoMediaItem.gef = parcel.readInt();
                videoMediaItem.gee = parcel.readInt();
                videoMediaItem.gec = parcel.readString();
                videoMediaItem.ged = parcel.readString();
                videoMediaItem.geh = parcel.readInt();
                videoMediaItem.videoFrameRate = parcel.readInt();
                videoMediaItem.videoBitRate = parcel.readInt();
                return videoMediaItem;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new MediaItem[i];
            }
        };
        public String gec;
        public String ged;
        public int gee = -1;
        public int gef = -1;
        public int geg = -1;
        public int geh = -1;
        public int videoBitRate = -1;
        public int videoFrameRate = -1;

        public VideoMediaItem(long j) {
            super(j);
        }

        public VideoMediaItem(long j, String str, String str2, String str3) {
            super(j, str, str2, str3);
        }

        public final int getType() {
            return 2;
        }

        public final String aqB() {
            if (be.kS(this.gdZ)) {
                return this.gdY;
            }
            return this.gdZ;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.gdY);
            parcel.writeString(this.gdZ);
            parcel.writeLong(this.gea);
            parcel.writeString(this.mMimeType);
            parcel.writeInt(this.geg);
            parcel.writeInt(this.gef);
            parcel.writeInt(this.gee);
            parcel.writeString(this.gec);
            parcel.writeString(this.ged);
            parcel.writeInt(this.geh);
            parcel.writeInt(this.videoFrameRate);
            parcel.writeInt(this.videoBitRate);
        }

        public String toString() {
            return "VideoMediaItem{base=" + super.toString() + ", videoTrackMime='" + this.gec + '\'' + ", audioTrackMime='" + this.ged + '\'' + ", durationMs=" + this.gee + ", videoHeight=" + this.gef + ", videoWidth=" + this.geg + ", videoBitRate=" + this.videoBitRate + ", videoIFrameInterval=" + this.geh + ", videoFrameRate=" + this.videoFrameRate + '}';
        }
    }
}
