package sea.dreamland.www.service;

import sea.dreamland.www.common.PageHelper;
import sea.dreamland.www.entity.Comment;
import sea.dreamland.www.entity.UserContent;
import java.util.List;

public interface UserContentService {

    /**
     * 查询所有Content并分页
     * @param content
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageHelper.Page<UserContent> findAll(UserContent content, Integer pageNum, Integer pageSize);
    PageHelper.Page<UserContent> findAll(UserContent content, Comment comment, Integer pageNum, Integer pageSize);
    PageHelper.Page<UserContent> findAllByUpvote(UserContent content, Integer pageNum, Integer pageSize);

    /**
     * 添加文章
     * @param userContent
     */
    void addContent(UserContent userContent);

    /**
     * 根据用户id查询文章集合
     * @param uid
     * @return
     */
    List<UserContent> findUserId(Long uid);

    /**
     * 查询所有文章
     * @return
     */
    List<UserContent> findAll();

    /**
     * 根据文章id查找文章
     * @param id
     * @return 
     */
    UserContent findById(Long id);

    /**
     * 根据文章id更新文章
     * @param content
     * @return
     */
    void updateById(UserContent content);
    
}
