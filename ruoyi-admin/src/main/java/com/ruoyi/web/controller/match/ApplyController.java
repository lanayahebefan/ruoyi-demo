package com.ruoyi.web.controller.match;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.framework.web.domain.Server;
import com.ruoyi.system.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author : zhangqing
 * @date : 2022/10/11 23:03
 */
@RestController
@RequestMapping("/match")
public class ApplyController extends BaseController{
    @Autowired
    private ISysRoleService roleService;

    @PreAuthorize("@ss.hasPermi('match:apply:list')")
    @GetMapping("/apply/list")
    public TableDataInfo list(SysRole role)
    {
        startPage();
        List<SysRole> list = roleService.selectRoleList(role);
        return getDataTable(list);
    }
}


