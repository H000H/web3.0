package DAO;

import java.util.List;

import pro.OB;
import pro.User;

public interface JDBCOperationDAO {
	public User login(User p);
	public boolean deleteUser(User user);
	public boolean updataUser(User user);
	public boolean insertUser(User user);
	public List<OB> selectUserOB(String userID);
	public List<User> selectUser();
	public List<OB> selectAllOb(int page,String id);
	public int selectOBPage();
}
