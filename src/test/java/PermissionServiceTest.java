import com.microandroid.modules.sys.dto.Permission;
import com.microandroid.modules.sys.service.IPermissionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PermissionServiceTest extends SpringJunitTest {

    @Autowired
    private IPermissionService permissionService;

    @Test
    public void testSelectRolesByUsername() {
        List<Permission> permissions = permissionService.selectPermissionsByUsername("z3");
        LOGGER.info("permissions:{}", permissions);
    }

    @Test
    public void testSelectByIdAndUsername() {
        Permission permission = permissionService.selectByIdAndUsername(5, "z3");
        LOGGER.info("permission:{}", permission);
    }
}
