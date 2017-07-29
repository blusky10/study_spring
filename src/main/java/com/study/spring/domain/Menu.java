package com.study.spring.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
	private String name;

	private String bindingId;

	private String url;

	private String description;

	private int praceOrder;

	@Column(nullable = false)
	private boolean isEnable;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_menu_uid")
	private Menu menu;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "menu")
	private List<Menu> menus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBindingId() {
		return bindingId;
	}

	public void setBindingId(String bindingId) {
		this.bindingId = bindingId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPraceOrder() {
		return praceOrder;
	}

	public void setPraceOrder(int praceOrder) {
		this.praceOrder = praceOrder;
	}

	public boolean isEnable() {
		return isEnable;
	}

	public void setEnable(boolean enable) {
		isEnable = enable;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
}
