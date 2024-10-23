package pers.baberuth.commoncode;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

import java.io.File;

public class Util
{
    /**
     * 判断文件是不是图片
     * @param filePath 文件
     * @return true-是 <br/>
     * false-不是
     */
    public static boolean isImg(String filePath)
    {
        return isImg(FileUtil.file(filePath));
    }

    /**
     * 判断文件是不是图片
     * @param file 文件
     * @return true-是 <br/>
     * false-不是
     */
    public static boolean isImg(File file)
    {
        Assert.notNull(file, "文件不能为null");
        Assert.isTrue(FileUtil.exist(file), "文件不存在");
        Assert.isTrue(FileUtil.isFile(file), "不是文件");
        String type = FileUtil.getType(file);
        String imgTypeStr = String.join(StrUtil.COMMA, Constants.ImgType.LIST);
        return StrUtil.containsIgnoreCase(imgTypeStr, type);
    }

    /**
     * 判断是不是视频
     * @param filePath 文件
     * @return 是不是
     */
    public static boolean isVideo(String filePath)
    {
        return isVideo(FileUtil.file(filePath));
    }

    /**
     * 判断是不是视频
     * @param file 文件
     * @return 是不是
     */
    public static boolean isVideo(File file)
    {
        Assert.notNull(file, "文件不能为null");
        Assert.isTrue(FileUtil.exist(file), "文件不存在");
        Assert.isTrue(FileUtil.isFile(file), "不是文件");
        String type = FileUtil.getType(file);
        String videoTypeStr = String.join(StrUtil.COMMA, Constants.VideoType.LIST);
        return StrUtil.containsIgnoreCase(videoTypeStr, type);
    }
}