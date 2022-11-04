package threephone.group.service.role;

import org.springframework.beans.factory.annotation.Autowired;
import threephone.group.model.Role;
import threephone.group.model.RoleName;
import threephone.group.repository.IRoleRepository;

import java.util.Optional;

public class RoleServiceIMPL implements IRoleService{
    @Autowired
    private IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName roleName) {
        return roleRepository.findByName(roleName);
    }
}
