package sea.dreamland.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import sea.dreamland.www.common.PageHelper;
import sea.dreamland.www.common.PageHelper.Page;
import sea.dreamland.www.dao.CommentMapper;
import sea.dreamland.www.dao.UserContentMapper;
import sea.dreamland.www.entity.Comment;
import sea.dreamland.www.entity.UserContent;
import sea.dreamland.www.service.UserContentService;

import java.util.List;

@Service
public class UserContentServiceImpl implements UserContentService {
    @Autowired
    private UserContentMapper userContentMapper;
    @Autowired
    private CommentMapper commentMapper;
    public void addContent(UserContent content) {
        userContentMapper.insert( content );
    }

    @Override
    public List<UserContent> findUserId(Long uid) {
        return null;
    }

    public List<UserContent> findByUserId(Long uid) {
        UserContent userContent = new UserContent();
        userContent.setuId(uid);
        List<UserContent> list = userContentMapper.select( userContent );
        return list;
    }

    public List<UserContent> findAll() {
        return userContentMapper.select( null );
    }

    @Override
    public UserContent findById(Long id) {
        return null;
    }

    public Page<UserContent> findAll(UserContent content, Integer pageNum, Integer pageSize) {
        //分页查询
        System.out.println("第"+pageNum+"页");
        System.out.println("每页显示："+pageSize+"条");
        PageHelper.startPage(pageNum, pageSize);//开始分页
        List<UserContent> list =  userContentMapper.select( content );
        //List<UserContent> list = userContentMapper.findAllContent();
        Page endPage = PageHelper.endPage();//分页结束
        List<UserContent> result = endPage.getResult();
        return endPage;
    }

    public Page<UserContent> findAll(UserContent content, Comment comment, Integer pageNum, Integer pageSize) {
        //分页查询
        System.out.println("第"+pageNum+"页");
        System.out.println("每页显示："+pageSize+"条");
        PageHelper.startPage(pageNum, pageSize);//开始分页
        List<UserContent> list =  userContentMapper.select( content );

        List<Comment> comments = commentMapper.select( comment );

        Page endPage = PageHelper.endPage();//分页结束
        List<UserContent> result = endPage.getResult();
        return endPage;
    }

    public Page<UserContent> findAllByUpvote(UserContent content, Integer pageNum, Integer pageSize) {
        Example e = new Example(UserContent.class);
        e.setOrderByClause("upvote DESC");
        PageHelper.startPage(pageNum, pageSize);//开始分页
        List<UserContent> list = userContentMapper.selectByExample(e);
        Page endPage = PageHelper.endPage();//分页结束
        return endPage;
    }

    public UserContent findById(long id) {
        UserContent userContent = new UserContent();
        userContent.setId( id );
        return userContentMapper.selectOne( userContent );
    }

    public void updateById(UserContent content) {
        userContentMapper.updateByPrimaryKeySelective( content );
    }


}
