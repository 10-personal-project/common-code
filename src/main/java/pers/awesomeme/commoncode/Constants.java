package pers.awesomeme.commoncode;

import cn.hutool.core.util.ReflectUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public interface Constants
{
    /**
     * 图片扩展名
     */
    class ImgType
    {
        public static final String PNG = "png";

        public static final String JPG = "jpg";

        public static final String JPEG = "jpeg";

        public static final String HEIC = "heic";

        public static final String ICO = "ico";

        public static final String BMP = "bmp";

        public static final String WEBP = "webp";

        public static final String GIF = "gif";

        public static final String TIFF = "tiff";

        public static final String TIF = "tif";

        public static final List<String> LIST;

        static
        {
            Field[] fieldArr = ReflectUtil.getFields(ImgType.class, field -> field.getType().getName().equals(String.class.getTypeName()));
            LIST = new ArrayList<>(fieldArr.length);
            try
            {
                for (Field el : fieldArr)
                {
                    LIST.add((String) el.get(null));
                }
            }
            catch (Exception e)
            {
                throw OptRuntimeException.getInstance(e);
            }
        }
    }

    class VideoType
    {
        public static String MOV = "mov";

        public static String MP4 = "mp4";

        public static String FLV = "flv";

        public static String AVI = "avi";

        public static String WMV = "wmv";

        public static String MKV = "mkv";

        public static String M4V = "m4v";

        public static final List<String> LIST;

        static
        {
            Field[] fieldArr = ReflectUtil.getFields(VideoType.class, field -> field.getType().getName().equals(String.class.getTypeName()));
            LIST = new ArrayList<>(fieldArr.length);
            try
            {
                for (Field el : fieldArr)
                {
                    LIST.add((String) el.get(null));
                }
            }
            catch (Exception e)
            {
                throw OptRuntimeException.getInstance(e);
            }
        }
    }
}
