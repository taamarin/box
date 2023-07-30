package xyz.chz.bfm.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.caverock.androidsvg.SVG;
import xyz.chz.bfm.R;
import xyz.chz.bfm.util.svg.ExternalFileResolver;
import xyz.chz.bfm.util.svg.SvgDecoder;
import xyz.chz.bfm.util.svg.SvgDrawableTranscoder;
import me.zhanghai.android.appiconloader.glide.AppIconModelLoader;

import java.io.InputStream;

@GlideModule
public class AppModule extends AppGlideModule {
    @Override
    public void registerComponents(Context context, @NonNull Glide glide, Registry registry) {
        int iconSize = context.getResources().getDimensionPixelSize(R.dimen.app_icon_size);
        registry.prepend(PackageInfo.class, Bitmap.class, new AppIconModelLoader.Factory(iconSize,
                context.getApplicationInfo().loadIcon(context.getPackageManager()) instanceof AdaptiveIconDrawable, context));
        SVG.registerExternalFileResolver(new ExternalFileResolver());
        registry.register(SVG.class, Drawable.class, new SvgDrawableTranscoder(context))
                .append(InputStream.class, SVG.class, new SvgDecoder());
    }
}

