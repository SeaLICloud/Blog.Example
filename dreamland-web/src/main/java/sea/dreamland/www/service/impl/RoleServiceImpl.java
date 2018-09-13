package sea.dreamland.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sea.dreamland.www.dao.RoleMapper;
import sea.dreamland.www.entity.Role;
import sea.dreamland.www.service.RoleService;

/**
 * Created by wly on 2017/12/15.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public Role findById(long id) {
        Role role = new Role();
        role.setId( id );
        return roleMapper.selectOne( role );
    }

    @Override
    public int add(Role role) {
        return roleMapper.insert(role);
    }
}
