package cn.edu.scau.logistics.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.scau.logistics.entity.UserEntity;
import cn.edu.scau.logistics.services.interfaces.UserService;
import cn.edu.scau.logistics.util.Page;
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	/**
	 * 登录功能
	 * @param user
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public String login(UserEntity user,HttpServletRequest request,Model model)throws Exception{
		System.out.println(user.getAccount() +" "+user.getUserPassword());
			UserEntity resultUser = userService.login(user);
			if(resultUser == null){
				request.setAttribute("user", resultUser);
				request.setAttribute("errorMsg", "用户或者密码错误");
				return "/login";	
			}
			else{
				HttpSession session = request.getSession();
				session.setAttribute("currenUser", resultUser);
				model.addAttribute("resultUser", resultUser);
				return "/main";
			}
			
	}
	
	@RequestMapping("/logout")
	public String logout(){
		return "/login";
	}
	
	
	/**
	 * 跳转到添加新用户界面
	 * @return
	 */
	@RequestMapping("/goAddUser")
	public String goAddUser()throws Exception{
		return "/user/addUser";
	}
	@RequestMapping(value="/goUpdate/{uid}")
	public String goUpdate(@PathVariable("uid") int uid ,Model model)throws Exception{
		UserEntity user = userService.findUserById(uid);
		model.addAttribute("user",user);
		return "user/updateUser";
	}
	
	
	/**
	 * 添加用户或者修改功能
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String  addUser(UserEntity user,HttpServletRequest request)throws Exception{
		user.setRole(request.getParameter("selectRole"));
		System.out.println(user.toString());
		if(user.getUserId() == 0){
			
			userService.addUser(user);
		}
		else{
			userService.updateUser(user);
		}
			return "redirect:/user/findUser";
	}
	
	/**
	 * 验证是否已经存在用户
	 * @param account
	 * @return
	 */
	@RequestMapping(value="/checkAccount",method = RequestMethod.POST)
	public @ResponseBody int checkAccount(String account) throws Exception{
		UserEntity resultAccount = userService.findAccount(account);
		if(resultAccount == null)
			return 1;
		else
			return 0;
	}
	
	/**
	 * 分页查询
	 * 
	 */
	@RequestMapping("/findUser")
	public String findUser(Integer current,Model model,String info)throws Exception{
		if( current == null )
			current = 1;
		Page page = userService.queryAllUser(info,current);
		System.out.println(page.toString());
		model.addAttribute("page",page);
		return "user/queryUser";
	}
	/**
	 * 删除用户功能
	 * @param uid
	 * @return
	 */
	@RequestMapping(value= "/deleteUser" , method = RequestMethod.POST)
	public @ResponseBody int  deleteUser( int uid ) throws Exception{
		int flag = 0;
		flag = userService.deleteUser(uid);
		if(flag != 0)
		return 1;
		else 
		return 0;
	}
	
	/**
	 * 获取查询信息
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findByInfo")
	public String findByInfo (HttpServletRequest request,ModelMap model)throws Exception{
		String info = request.getParameter("queryUser");
		model.put("info", info);
		
		return "redirect:/user/findUser";
	}
	
	
}
