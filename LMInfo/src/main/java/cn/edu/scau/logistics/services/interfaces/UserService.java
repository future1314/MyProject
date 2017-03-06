package cn.edu.scau.logistics.services.interfaces;


import cn.edu.scau.logistics.entity.UserEntity;
import cn.edu.scau.logistics.util.Page;
/**
 * UserService接口
 * @author lan
 *
 */
public interface UserService {
	/**
	 * 用户登录
	 * @param UserEntity user
	 * @return
	 */
	public UserEntity login(UserEntity user);
	/**
	 * 分页用户查询
	 * @param map
	 * @return
	 */
	public Page queryAllUser(String info,int current);
	
	  /**
     * 获取总记录数
     * @param map
     * @return
     */
	public int getTotal(String info);
	
	  /**
     * 修改用户
     * @param user
     * @return影响的记录数
     */
    public int updateUser(UserEntity user);
    /**
     * 添加用户
     * @param user
     * @return影响的记录数
     */
    public int addUser(UserEntity user);
    /**
     * 删除用户
     * @param id
     * @return 
     */
    public int deleteUser(int userId);
	/**
	 * 根据账号查询用户
	 * @param account
	 * @return
	 */
    public UserEntity findAccount(String account);
    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    public UserEntity findUserById(int userId);
    
	public Page queryAllUser();
	

}
