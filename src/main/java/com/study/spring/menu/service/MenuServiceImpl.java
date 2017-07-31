package com.study.spring.menu.service;

import com.study.spring.domain.Menu;
import com.study.spring.menu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<Menu> getMenus() {
        return menuRepository.findAll();
    }
}
