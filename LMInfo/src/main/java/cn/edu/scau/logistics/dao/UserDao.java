package cn.edu.scau.logistics.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.edu.scau.logistics.entity.UserEntity;

/**
 * 用户管理接口
 * @author lan
 *
 */
public interface UserDao {
	/**
	 * 用户登录
	 * @param UserEntity user
	 * @return
	 */
	public UserEntity login(UserEntity user);
	/**
	 * 用户查询
	 * @param map
	 * @return
	 */
	public List<UserEntity> queryAllUser(@Param("info")String info,@Param("start") int start, @Param("size")int size);
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
     * 用户通过账户查询
     * @param account
     * @return
     */
    public UserEntity findAccount(String account);
    /**
     * 通过用户的ID查询
     * @param userId
     * @return
     */
    public UserEntity findUserById(int userId);

    
    
}
