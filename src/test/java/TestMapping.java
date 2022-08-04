import com.mapper.DeptMapper;
import com.mapper.EmpMapper;
import com.pojo.Emp;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

/**
 * @author 张滨
 * @time 2022/07/31 15:09
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestMapping {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void test1() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        DeptMapper deptMapper = context.getBean(DeptMapper.class);

        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//        // 批量插入1000条员工数据
        for (int i = 0; i < 1000; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5) + i;
            mapper.insertSelective(
                    /* 生成a-b之间的随机数公式 = (int)(a + Math.random() * (b-a +1) ) */
                    new Emp(uid, (int) (1 + Math.random() * 50), "男", uid + "@126.com", (int) (1 + Math.random() * 2))
            );
        }
        List<Emp> emps = empMapper.selectByExampleWithDept(null);
        System.out.println(emps);
    }
}
