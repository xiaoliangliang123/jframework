import com.framework.v1.Application;
import com.framework.v1.business.common.dao.UserDao;
import com.framework.v1.business.common.model.UserModel;
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
        List<Map<String,Object>> users =userDao.getAllUsers();
        System.out.println(users.size());
    }

    @Test
    public void testUpdateUser(){
        userDao.updateAllUsers();
    }


    @Test
    public void testSelectObject() throws Exception {

        UserModel userModel = new UserModel();
        userModel.setId("1");
        userModel =  (UserModel)userDao.getjBaseDao().selectModel(userModel);
        System.out.println(userModel.getId());

    }

    @Test
    public void testUpdateObject() throws Exception {


        UserModel userModel = new UserModel();
        userModel.setId("2");
        userModel.setPassword("wl22");
        userModel =  (UserModel)userDao.getjBaseDao().updateModel(userModel);
        System.out.println(userModel.getId());

    }

    @Test
    public void testInsertObject() throws Exception {

        long  start = System.currentTimeMillis();
        for(int i = 0 ; i < 1; i ++) {
            UserModel userModel = new UserModel();
            userModel.setId("xd010"+i);
            userModel.setUsername("wl22");
            userModel.setPassword("wl22");
            userModel = (UserModel) userDao.getjBaseDao().updateModel(userModel);
            //System.out.println(userModel.getId());
        }
        long  end = System.currentTimeMillis();
        System.out.println(end-start);

    }

    @Test
    public void testDeleteObject() throws Exception {

        UserModel userModel = new UserModel();
        userModel.setId("4");
        userModel =  (UserModel)userDao.getjBaseDao().deleteModel(userModel);
        System.out.println(userModel.getId());

    }


}
