package experiment_9And10.experiment10.user.dao.implement;

import Tools.DateTime.GetDate;
import Tools.LinkDatabases.GetData;
import Tools.ReturnInformation.ReturnInformation;
import experiment_1And2.experiment2.User;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.SQLException;
import java.util.Collection;

import static org.junit.Assert.*;

//@RunWith(Arquillian.class)
public class ImplementOperationUserTest {
    /*@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(ImplementOperationUser.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/

    private ImplementOperationUser implementOperationUser = null;

    public void createImplementOperationUser() {
        this.implementOperationUser = new ImplementOperationUser();
    }

    public ImplementOperationUser getImplementOperationUser() {
        return implementOperationUser;
    }

    public void setImplementOperationUser(ImplementOperationUser implementOperationUser) {
        this.implementOperationUser = implementOperationUser;
    }

    @Before
    public void setUp() throws Exception {
        this.createImplementOperationUser();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addUser() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setUserID("22KJB12312RFVG4");
        user.setUserName("liupeng");
        user.setMoney(123.45);
        user.setPasswordValue("123".hashCode());
        user.setRegisteredDate(new GetDate().getMyDaye());
        ReturnInformation returnInformation = this.getImplementOperationUser().addUser(user);
        System.out.println(returnInformation.toString());
    }

    @Test
    public void resetUser() throws SQLException, ClassNotFoundException {
        String userID = "12KJB12312RFVG4";
        ReturnInformation returnInformation = this.getImplementOperationUser().resetUser(userID, "newName");
        System.out.println(returnInformation.toString());
    }

    @Test
    public void resetUserPassword() throws SQLException, ClassNotFoundException {
        String userID = "12KJB12312RFVG4";
        ReturnInformation returnInformation = this.getImplementOperationUser().resetUserPassword(userID, "123345");
        System.out.println(returnInformation.toString());
    }

    @Test
    public void howMoney() throws SQLException, ClassNotFoundException {
        String userID = "12KJB12312RFVG4";
        ReturnInformation returnInformation = this.getImplementOperationUser().howMoney(userID);
        System.out.println(returnInformation.toString());
    }

    @Test
    public void addMoney() throws SQLException, ClassNotFoundException {
        String userID = "12KJB12312RFVG4";
        ReturnInformation returnInformation = this.getImplementOperationUser().addMoney(userID, 1000);
        System.out.println(returnInformation.toString());
    }

    @Test
    public void subMoney() throws SQLException, ClassNotFoundException {
        String userID = "12KJB12312RFVG4";
        ReturnInformation returnInformation = this.getImplementOperationUser().subMoney(userID, 100000);
        System.out.println(returnInformation.toString());
    }

    @Test
    public void getUserByUserID() throws SQLException, ClassNotFoundException {
        String userID = "12KJB12312RFVG4";
        ReturnInformation returnInformation = this.getImplementOperationUser().getUserByUserID(userID);
        System.out.println(returnInformation.toString());
        System.out.println(returnInformation.getObject().toString());
    }

    @Test
    public void landing() throws SQLException, ClassNotFoundException {
        String userID = "12KJB12312RFVG4";
        ReturnInformation returnInformation = this.getImplementOperationUser().landing(userID, "123345");
        System.out.println(returnInformation.toString());
    }

}
