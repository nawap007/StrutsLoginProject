package demo.model;

import java.sql.Connection;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import demo.DB.DBConnection;
import demo.bean.LoginBean;

public class Login implements Action, ModelDriven<LoginBean>,Preparable{

	LoginBean bean = new LoginBean();
	Connection con;

	public String execute() throws Exception {
		System.out.println("user name " + bean.getUsername());
		System.out.println("password " + bean.getPwd());
		
		System.out.println("hello GitHub");
		
		
		return "success";
	}


	public LoginBean getModel() {
		return bean;
	}


	public void prepare() throws Exception {
		System.out.println("in prepared method");

		con=DBConnection.getConnection();
		
		
	}

}
