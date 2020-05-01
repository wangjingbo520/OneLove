package com.yxna.onelove.utils.glide.glide;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class GlideUtils {

    private GlideUtils() {
    }

    public static void setNetImage(Context context, String url, ImageView imageView) {
        if (context != null) {
            if (context instanceof Activity && ((Activity) context).isDestroyed()) {
                return;
            } else {
                RequestOptions options = new RequestOptions()
                        //.transform(new GlideCircleTransform(context))
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        //.skipMemoryCache(false)
                        //.dontAnimate()
                        //.placeholder(imageView.getDrawable())
                        ;
                Glide.with(context)
                        .load(url)
                        .apply(options)
                        .into(imageView);
            }
        }
    }

    public static void setNoDefaultNetImage(Context context, String url, ImageView imageView) {
        if (context != null) {
            RequestOptions options = new RequestOptions()
                    //.transform(new GlideCircleTransform(context))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    //.skipMemoryCache(false)
                    //.dontAnimate()
                    //.placeholder(imageView.getDrawable())
                    ;
            Glide.with(context)
                    .load(url)
                    .apply(options)
                    .into(imageView);
        }
    }

    public static void setNetCardImage(Context context, String url, ImageView imageView) {
        if (context != null) {
            RequestOptions options = new RequestOptions()
                    //.transform(new GlideCircleTransform(context))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    //.skipMemoryCache(false)
                    //.dontAnimate()
                    //.placeholder(imageView.getDrawable())
                    ;
            Glide.with(context)
                    .load(url)
                    .apply(options)
                    .into(imageView);
        }

    }

    public static void setNetCircleImageWithCache(Context context, String url, ImageView imageView) {
        if (context != null) {
            if (context instanceof Activity && ((Activity) context).isDestroyed()) {
                return;
            } else {
                RequestOptions options = new RequestOptions()
                        .transform(new GlideCircleTransform(context))
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .skipMemoryCache(false)
                        .dontAnimate()
                        .placeholder(imageView.getDrawable());

                String urls = url;
                Glide.with(context)
                        .load(urls)
                        .apply(options)
                        .into(imageView);
            }
        }
    }

    public static void setNetCircleImage(Context context, String url, ImageView imageView) {
        if (context != null) {
            if (context instanceof Activity && ((Activity) context).isDestroyed()) {
                return;
            } else {
                RequestOptions options = new RequestOptions()
                        .transform(new GlideCircleTransform(context))
                        .diskCacheStrategy(DiskCacheStrategy.ALL);

                String urls = url;
                Glide.with(context)
                        .load(urls)
                        .apply(options)
                        .into(imageView);
            }
        }
    }

    public static void setNativeCircleImage(Context context, Bitmap bitmap, ImageView imageView) {
        if (context != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
            byte[] bytes = baos.toByteArray();
            RequestOptions options = new RequestOptions()
                    .transform(new GlideCircleTransform(context))
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
            Glide.with(context)
                    .load(bytes)
                    .apply(options)
                    .into(imageView);
        }
    }

    public static void setNativeCircleImageTwo(Context context, String path, ImageView imageView) {
        if (context != null) {
            RequestOptions options = new RequestOptions()
                    .transform(new GlideCircleTransform(context))
                    .diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(context)
                    .load(Uri.fromFile(new File(path)))
                    .apply(options)
                    .into(imageView);
        }
    }

    public static void setNetCircleImageTwo(Context context, String url, ImageView imageView) {
        if (context != null) {
            if (context instanceof Activity && ((Activity) context).isDestroyed()) {
                return;
            } else {
                RequestOptions options = new RequestOptions()
                        .transform(new GlideCircleTransformTwo(context, 2, Color.parseColor("#DDDDDD")))
                        .diskCacheStrategy(DiskCacheStrategy.ALL);
                String urls = url;
                Glide.with(context)
                        .load(urls)
                        .apply(options)
                        .into(imageView);
            }
        }
    }

    public static void setColorFilterImage(Context context, String url, ImageView imageView) {
        if (context != null) {
            RequestOptions options = new RequestOptions()
                    //.transform(new GlideCircleTransform(context))
                    .diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(context)
                    .load(url)
                    .apply(options)
//                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
//                    .bitmapTransform(new ColorFilterTransformation(context, 0x000000))
                    .into(imageView);
        }

    }

    public static void setBlurImage(Context context, String url, ImageView imageView) {
        if (context != null) {
            RequestOptions options = new RequestOptions()
                    //硬盘缓存功能
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
            Glide.with(context)
                    .load(url)
//                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
//                    .placeholder(R.mipmap.ic_launcher)
//                    .error(R.mipmap.ic_launcher)
//                    .bitmapTransform(new BlurTransformation(context, 25, 3))
                    .into(imageView);
        }

    }

    public static void setBlurRoundImage(Context context, String url, ImageView imageView) {
        if (context != null) {
            RequestOptions options = new RequestOptions()
                    //硬盘缓存功能
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
            Glide.with(context)
                    .load(url)
//                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
//                    .bitmapTransform(new BlurTransformation(context, 25, 3), new CenterCrop(context), new GlideRoundTransform(context, 4))
//                    .placeholder(R.mipmap.ic_launcher)
//                    .error(R.mipmap.ic_launcher)
                    .into(imageView);
        }

    }


    public static void setNetRoundImage(Context context, String url, ImageView imageView, float round) {
        if (context != null) {
            if (context instanceof Activity && ((Activity) context).isDestroyed()) {
                return;
            } else {
                String urls = url;
                RequestOptions options = new RequestOptions()
                        //硬盘缓存功能
                        .transform(new GlideRoundTransform(context, (int) round))
                        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
                Glide.with(context)
                        .load(urls)
                        .apply(options)
                        .into(imageView);
            }
        }

    }


    public static void setNetRoundImage(Context context, String url, ImageView imageView) {
        if (context != null) {
            if (context instanceof Activity && ((Activity) context).isDestroyed()) {
                return;
            } else {
                String urls = url;
                RequestOptions options = new RequestOptions()
                        //硬盘缓存功能
                        .transform(new GlideRoundTransform(context, 5))
                        .diskCacheStrategy(DiskCacheStrategy.ALL);
                Glide.with(context)
                        .load(urls)
                        .apply(options)
                        .into(imageView);
            }
        }

    }

    public static void setNetRoundImageNoPlaceHolder(Context context, String url, ImageView imageView) {
        if (context != null) {
            String urls = url;
            RequestOptions options = new RequestOptions()
                    //硬盘缓存功能
                    .transform(new GlideRoundTransform(context, 4))
                    .diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(context)
                    .load(urls)
                    .apply(options)
                    .into(imageView);
        }
    }

    public static void setNativeImage(Context context, String path, ImageView imageView) {
        if (context != null) {
            RequestOptions options = new RequestOptions()
                    //硬盘缓存功能
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
            Glide.with(context)
                    .load(Uri.fromFile(new File(path)))
                    .apply(options)
                    .into(imageView);
        }
    }

    public static void setNativeRoundImage(Context context, String path, ImageView imageView) {
        if (context != null) {
            if (context instanceof Activity && ((Activity) context).isDestroyed()) {
                return;
            } else {
                RequestOptions options = new RequestOptions()
                        //硬盘缓存功能
                        .transform(new GlideRoundTransform(context, 5))
                        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
                Glide.with(context)
                        .load(Uri.fromFile(new File(path)))
                        .apply(options)
                        .into(imageView);
            }
        }
    }

    public static void savaBitmap(Context context, String imgName, byte[] bytes) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            String filePath = null;
            FileOutputStream fos = null;
            try {
                filePath = Environment.getExternalStorageDirectory().getCanonicalPath() + "/MyImg";
                File imgDir = new File(filePath);
                if (!imgDir.exists()) {
                    imgDir.mkdirs();
                }
                imgName = filePath + "/" + imgName;
                fos = new FileOutputStream(imgName);
                fos.write(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fos != null) {
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            Toast.makeText(context, "请检查SD卡是否可用", Toast.LENGTH_SHORT).show();
        }
    }
}
