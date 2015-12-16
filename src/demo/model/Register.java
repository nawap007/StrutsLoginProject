package demo.model;



import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import demo.bean.RegisterBean;
import demo.pojo.RegisterPojo;

public class Register extends ActionSupport implements ModelDriven<RegisterBean>{

	RegisterBean bean = new RegisterBean();


	public void addStudent(Session se ) {

		RegisterPojo rt =new RegisterPojo();
		System.out.println("city "+bean.getCity());
		rt.setUsername(bean.getUsername());
		rt.setPwd(bean.getPwd());
		rt.setCity(bean.getCity());
		rt.setMail(bean.getMail());
		se.beginTransaction();

		se.save(rt);
		se.getTransaction().commit();
		System.out.println("records inserted.");
	}




	public String execute(){

		Session se = new Configuration().configure().buildSessionFactory().openSession();
		System.out.println("city "+bean.getCity());
		addStudent(se);
		return SUCCESS;	
	}





	public RegisterBean getModel() {
		return bean;
	}


}
