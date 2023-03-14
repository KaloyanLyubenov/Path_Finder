package com.example.path_finder.web;

import com.example.path_finder.domain.dto.bading.RoleChangeForm;
import com.example.path_finder.domain.enums.Roles;
import com.example.path_finder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController  {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @PatchMapping("/changeUserPermission/{id}")
    @ResponseBody
    public Set<Roles> changeRoles(@PathVariable Long id,
                                  @RequestParam(defaultValue = "false") Boolean shouldReplacesRoles,
                                  @RequestBody RoleChangeForm roleName){
        return this.userService.changeUserPermissions(id, roleName, shouldReplacesRoles);
    }
}
