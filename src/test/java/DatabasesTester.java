import com.database.web.Application;
import com.database.web.business.UserDao;
import com.database.web.business.UserModel;
import com.database.web.framework.database.base.BaseModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class DatabasesTester {


    @Autowired
    private UserDao userDao;



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

        UserModel userModel = new UserModel();
        userModel.setId("4");
        userModel.setUsername("wl22");
        userModel.setPassword("wl22");
        userModel =  (UserModel)userDao.getjBaseDao().insertModel(userModel);
        System.out.println(userModel.getId());

    }

    @Test
    public void testDeleteObject() throws Exception {

        UserModel userModel = new UserModel();
        userModel.setId("4");
        userModel =  (UserModel)userDao.getjBaseDao().deleteModel(userModel);
        System.out.println(userModel.getId());

    }


}
