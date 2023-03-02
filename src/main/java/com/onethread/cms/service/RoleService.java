package com.onethread.cms.service;

import com.onethread.cms.model.Role;

public interface RoleService {
    Role findByName(String name);
}
