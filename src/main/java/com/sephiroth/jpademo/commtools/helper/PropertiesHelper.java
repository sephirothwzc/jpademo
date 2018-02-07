package com.sephiroth.jpademo.commtools.helper;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @Author: 吴占超
 * @Description:
 * @Date: Create in 16:22 2018/2/7
 * @Modified By:
 */
public class PropertiesHelper {
    private final ResourceBundle resource;
    private final String fileName;

    public PropertiesHelper(String fileName){
        this.fileName = fileName;
        Locale locale = new Locale("zh","CN");
        this.resource = ResourceBundle.getBundle(this.fileName,locale);
    }

    /**
     *  @Author: 吴占超
     *  @Description:
     *  @Date:  16:24 2018/2/7
     *  @param key
     *  @return
     */
    public String getValue(String key) throws Exception {
        // 解决中文乱码方案，properties文件必须为 UTF-8
        return new String(this.resource.getString(key).getBytes("ISO-8859-1"), "UTF-8");
    }
}
