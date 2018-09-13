package sea.dreamland.www.service;

import sea.dreamland.www.entity.UserInfo;

public interface UserInfoService {

    /**
     * 根据用户id查找用户详细信息
     * @param id
     * @return UserInfo
     */
    UserInfo findByUid(Long id);

    /**
     * 更新用户详细信息
     * @param userInfo
     */
    void update(UserInfo userInfo);

    /**
     * 添加用户信息
     * @param userInfo
     */
    void add(UserInfo userInfo);
}
