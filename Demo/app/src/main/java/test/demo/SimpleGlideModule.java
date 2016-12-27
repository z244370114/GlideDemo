package test.demo;

import android.content.Context;
import android.os.Environment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.GlideModule;

import java.io.InputStream;

/**
 * <p/>
 * 作者：zhouyuan on  2016/12/22 17:00
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */

public class SimpleGlideModule implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        // todo
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        MemorySizeCalculator calculator = new MemorySizeCalculator(context);
        //1.获取内存缓存的大小与Bitmap位图池的大小
        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();
        int defaultBitmapPoolSize = calculator.getBitmapPoolSize();
        //2.app 需要 20% 大的缓存作为 Glide 的默认值
        int customMemoryCacheSize = (int) (1.2 * defaultMemoryCacheSize);
        int customBitmapPoolSize = (int) (1.2 * defaultBitmapPoolSize);

        builder.setMemoryCache(new LruResourceCache(customMemoryCacheSize));
        builder.setBitmapPool(new LruBitmapPool(customBitmapPoolSize));
        int cacheSize100MegaBytes = 104857600;
        //设置内部缓存，只有当前APP有访问权限
        builder.setDiskCache(
                new InternalCacheDiskCacheFactory(context, cacheSize100MegaBytes)
        );
        //设置外部缓存，不止它自己能访问
        builder.setDiskCache(new ExternalCacheDiskCacheFactory(context, cacheSize100MegaBytes));

        // or any other path
        String downloadDirectoryPath = Environment.getDownloadCacheDirectory().getPath();
        //如果你要让磁盘缓存到指定的目录，你要使用 DiskLruCacheFactory：
        builder.setDiskCache(
                new DiskLruCacheFactory(downloadDirectoryPath, cacheSize100MegaBytes)
        );
        //如果您想要指定一个缓存到自己设置的文件名
        builder.setDiskCache(
                new DiskLruCacheFactory(downloadDirectoryPath, "glidecache", cacheSize100MegaBytes)
        );

    }

    @Override
    public void registerComponents(Context context, Glide glide) {
        // todo
        glide.register(CustomImageSizeModel.class, InputStream.class, new CustomImageSizeModelFactory());
    }
}