package imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.glassfish.external.statistics.annotations.Reset;

import pro.JDBCConnection;
import pro.OB;
import pro.User;
import DAO.JDBCOperationDAO;

public class OperationDAOimpl implements JDBCOperationDAO{
	private Connection conn=null;
	public User login(User p) {
		if((conn=getConnect())==null){
			return null;
		}
		String sql="select name,password,whatfuck from myuser where id=?";
		User user=new User();
		ResultSet rs=null;
		PreparedStatement pst=null;
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, p.getId());
			rs=pst.executeQuery();
			if(rs.next())
			{
				user.setId(p.getId());
				user.setName(rs.getString(1));
			user.setPassword(rs.getString(2));
			user.setWhatfuck(rs.getString(3));
			}System.out.print(user.getName()+user.getPassword());
			closefun1(pst, rs);
		} catch (SQLException e) {
			e.printStackTrace();
			closefun1(pst,rs);
			return null;
		}
		return user;
	}

	private void closefun1(PreparedStatement pst, ResultSet rs) {
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				try {
					pst.close();
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				e.printStackTrace();
			}
		}if(pst!=null){
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public boolean deleteUser(User p) {
		if((conn=getConnect())==null){
			return false;
		}
		String sql="delete from myuser where id=?";
		PreparedStatement pst=null;
		int number=0;
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, p.getId());
			number=pst.executeUpdate();
			closefun1(pst, null);
		} catch (SQLException e) {
			e.printStackTrace();
			closefun1(pst,null);
			return false;
		}
		return true;
	}

	public boolean updataUser(User p) {
		if((conn=getConnect())==null){
			return false;
		}
		String sql="update myuser set name=?,password=?,whatfuck=? where id=?";
		PreparedStatement pst=null;
		int number=0;
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, p.getName());
			pst.setString(4, p.getId());
			pst.setString(2, p.getPassword());
			pst.setString(3, p.getWhatfuck());			
			number=pst.executeUpdate();
			closefun1(pst, null);
			if(number!=1)
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			closefun1(pst,null);
			return false;
		}
		return true;
	}

	public boolean insertUser(User p) {
		if((conn=getConnect())==null){
			return false;
		}
		String sql="insert into myuser values(?,?,?,?)";
		PreparedStatement pst=null;
		int number=0;
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, p.getName());
			pst.setString(2, p.getId());
			pst.setString(3, p.getPassword());
			pst.setString(4, p.getWhatfuck());			
			number=pst.executeUpdate();
			closefun1(pst, null);
			if(number!=1)
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			closefun1(pst,null);
			return false;
		}
		return true;
	}

	protected Connection getConnect() {
		return JDBCConnection.getConnection();
	}

	public List<OB> selectUserOB(String userID) {
		if((conn=getConnect())==null){
			return null;
		}
		String sql="select * from myob where obuserid=?";
		List<OB> list=new ArrayList<OB>();
		OB ob= null;
		ResultSet rs=null;
		PreparedStatement pst=null;
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, userID);
			rs=pst.executeQuery();
			while(rs.next()){
				ob=new OB();
				ob.setName(rs.getString(1));
				ob.setNumber(rs.getString(2));
				ob.setContent(rs.getString(3));
				ob.setSize(rs.getInt(4));
				ob.setRelation(rs.getString(5));
				ob.setId(rs.getString(6));
				list.add(ob);
			}
			closefun1(pst, rs);
		} catch (SQLException e) {
			e.printStackTrace();
			closefun1(pst,rs);
			return null;
		}
		return list;
	}

	@Override
	public List<User> selectUser() {
		if((conn=getConnect())==null){
			return null;
		}
		String sql="select * from myuser";
		List<User> list=new ArrayList<User>();
		User ob= null;
		ResultSet rs=null;
		PreparedStatement pst=null;
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				ob=new User();
				ob.setName(rs.getString(1));
				ob.setId(rs.getString(2));
				ob.setPassword(rs.getString(2));
				ob.setWhatfuck(rs.getString(2));
				list.add(ob);
			}
			closefun1(pst, rs);
		} catch (SQLException e) {
			e.printStackTrace();
			closefun1(pst,rs);
			return null;
		}
		return list;
	}

	@Override
	public List<OB> selectAllOb(int page,String id) {
		int thispage=page*5;
		int ppage=thispage-4;
		if((conn=getConnect())==null){
			return null;
		}
		String sql="SELECT * FROM (SELECT A.*, rownum RN FROM (SELECT * FROM myob) A WHERE rownum <=?) WHERE RN >= ? and obuserid=?";
		ResultSet rs=null;
		PreparedStatement pst=null;
		List<OB> list=new ArrayList<OB>();
		OB ob= null;
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, thispage);
			pst.setInt(2, ppage);
			pst.setString(3, id);
			rs=pst.executeQuery();
			while(rs.next()){
				ob=new OB();
				ob.setName(rs.getString(1));
				ob.setNumber(rs.getString(2));
				ob.setContent(rs.getString(3));
				ob.setSize(rs.getInt(4));
				ob.setRelation(rs.getString(5));
				ob.setId(rs.getString(6));
				list.add(ob);
			}
			closefun1(pst, rs);
		} catch (SQLException e) {
			e.printStackTrace();
			closefun1(pst,rs);
			return null;
		}
		return list;
		}

	@Override
	public int selectOBPage() {
		if((conn=getConnect())==null){
			return 0;
		}
		String sql="select count(*) from myob where obuserid='wangziyi'";
		PreparedStatement pst=null;
		ResultSet rs=null;
		int number=0;
		try {
			pst=conn.prepareStatement(sql);			
			rs=pst.executeQuery();
			if(rs.next()){
				number=rs.getInt(1);
				number/=5;
				number++;
			}
			closefun1(pst, null);
		} catch (SQLException e) {
			e.printStackTrace();
			closefun1(pst,null);
			return 0;
		}
		return number;
	}
	

}
