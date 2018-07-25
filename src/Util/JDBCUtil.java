package Util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.util.Properties;
/*
* 数据库连接
* */
public class JDBCUtil {
    public static DataSource ds = null;

    static {
        try {
            //1.加载配置文件
            Properties p = new Properties();
            FileInputStream in = null;
            in = new FileInputStream(JDBCUtil.class.getClassLoader().getResource("db.properties").getPath());
            p.load(in);
            ds = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static  QueryRunner queryRunner(){
        return new QueryRunner(ds);
    }
}
