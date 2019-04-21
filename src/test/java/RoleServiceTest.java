import com.microandroid.modules.sys.dto.Role;
import com.microandroid.modules.sys.service.IRoleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceTest extends SpringJunitTest {

    @Autowired
    private IRoleService roleService;

    @Test
    public void testSelectRolesByUsername() {
        List<Role> roles = roleService.selectRolesByUsername("z3");
        LOGGER.info("roles:{}", roles);
    }
}
