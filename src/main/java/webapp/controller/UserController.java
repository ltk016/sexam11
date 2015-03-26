package webapp.controller;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import webapp.model.Address;
import webapp.model.User;

@Controller 
public class UserController {
	  
	// 
	//	/m/user/register?name=jjh&job=programmer&addrs[0].country=korea&addrs[0].city=seoul&addrs[0].gu=seodaemun
	//	/m/user/register?name=jjh&job=programmer&job=racer&job=player&addrs[0].country=korea&addrs[0].city=seoul&addrs[0].gu=seodaemun&addrs[1].country=england&addrs[1].city=london&addrs[1].gu=1st&addrs[2].country=france&addrs[2].city=paris&addrs[2].gu=sdglk
	//	
	@RequestMapping("/user/register")
	public void register(User user, PrintWriter out) {
		
		out.println("user.name = " + user.getName() + "<br>");
		out.println("user.age = " + user.getAge() + "<br>");
		out.println("user.birthday = " + user.getBirthday() + "<br>");
		out.println("<hr>");
		
		String[] job = user.getJob();
		if (job != null)
			for (String j : job) {
				out.println("user.job = " + j + "<br>");
				out.println("<hr>");
			}
		
		List<Address> addrs = user.getAddrs();
		if (addrs != null)
			for (Address a : addrs) {
				out.println("user.addrs.country = " + a.getCountry() + "<br>");
				out.println("user.addrs.city = " + a.getCity() + "<br>");
				out.println("user.addrs.gu = " + a.getGu() + "<br>");
				out.println("<hr>");
			}
		 
	}
}



