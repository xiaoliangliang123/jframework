import com.framework.v1.Application;
import com.framework.v1.business.sysUsers.dao.UserDao;
import com.framework.v1.business.sysUsers.model.Sys_UserModel;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class DatabasesTester {


    private static Logger logger = Logger.getLogger(DatabasesTester.class);


    @Autowired
    private UserDao userDao;




    class MyCallAble implements Callable{

        @Override
        public Object call() throws Exception {
            return null;
        }
    }

    @Test
    public void testRollBack() throws InterruptedException, ExecutionException, TimeoutException {


            ExecutorService executorService = Executors.newSingleThreadExecutor();
            FutureTask futureTask = (FutureTask<Object>) executorService.submit(new MyCallAble() {
            });
            executorService.execute(futureTask);
            futureTask.get(8, TimeUnit.SECONDS);

    }



    @Test
    public void testGetUsers(){
        logger.warn("hhhhh");
        List<Map<String,Object>> users =userDao.getAllUsers();
        System.out.println(users.size());
    }

    @Test
    public void testUpdateUser(){
        userDao.updateAllUsers();
    }


    @Test
    public void testSelectObject() throws Exception {

        Sys_UserModel Sys_UserModel = new Sys_UserModel();
        Sys_UserModel.setId("3");
        Sys_UserModel =  (Sys_UserModel)userDao.getjBaseDao().selectModel(Sys_UserModel);
        System.out.println(Sys_UserModel.getId());

    }

    @Test
    public void testUpdateObject() throws Exception {


        Sys_UserModel Sys_UserModel = new Sys_UserModel();
        Sys_UserModel.setId("1");
        Sys_UserModel.setPassword("wl2241");
        Sys_UserModel =  (Sys_UserModel)userDao.getjBaseDao().updateModel(Sys_UserModel);
        System.out.println(Sys_UserModel.getId());

    }

    @Test
    public void testInsertObject() throws Exception {

        long  start = System.currentTimeMillis();
        for(int i = 0 ; i < 1; i ++) {
            Sys_UserModel Sys_UserModel = new Sys_UserModel();
            Sys_UserModel.setId("xd010"+i);
            Sys_UserModel.setUsername("wl22");
            Sys_UserModel.setPassword("wl22");
            Sys_UserModel = (Sys_UserModel) userDao.getjBaseDao().updateModel(Sys_UserModel);
            //System.out.println(Sys_UserModel.getId());
        }
        long  end = System.currentTimeMillis();
        System.out.println(end-start);

    }

    @Test
    public void testDeleteObject() throws Exception {

        Sys_UserModel Sys_UserModel = new Sys_UserModel();
        Sys_UserModel.setId("3");
        Sys_UserModel =  (Sys_UserModel)userDao.getjBaseDao().deleteModel(Sys_UserModel);
        System.out.println(Sys_UserModel.getId());

    }


}
