package test.demo;

/**
 * <p/>
 * 作者：zhouyuan on  2016/12/26 16:43
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */

public class CustomImageSizeModelFutureStudio implements CustomImageSizeModel {
    String baseImageUrl;

    public CustomImageSizeModelFutureStudio(String baseImageUrl) {
        this.baseImageUrl = baseImageUrl;
    }

    @Override
    public String requestCustomSizeUrl(int width, int height) {
        // previous way: we directly accessed the images
        // https://futurestud.io/images/logo.png

        // new way, server could handle additional parameter and provide the image in a specific size
        // in this case, the server would serve the image in 400x300 pixel size
        // https://futurestud.io/images/logo.png?w=400&h=300
        return baseImageUrl + "?w=" + width + "&h=" + height;
    }
}
