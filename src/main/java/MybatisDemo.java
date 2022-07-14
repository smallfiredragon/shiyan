import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import sun.font.CompositeFont;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MybatisDemo {
    public  void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlsession对象，用它执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //获取接口代理对象
//        BrandMapper brandMapper =sqlSession.getMapper(BrandMapper.class);
//        //执行sql语句
//        List<Brand> brands = BrandMapper.selectAll();
//        List<Brand> brands = sqlSession.selectList("com.itheima.mapper.BrandMapper.selectAll");
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);


        sqlSession.close();
    }
}
