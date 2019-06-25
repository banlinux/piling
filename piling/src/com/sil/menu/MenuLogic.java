/**
 * 
 */
package com.sil.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author sumanta roy
 *
 */
@Service
@Repository
public class MenuLogic {
	private MenuDao menuDao;
	public MenuBean getUserPermission(String userId) {
		// TODO Auto-generated method stub
		return menuDao.getUserPermission(userId);
	}
	/**
	 * @param menuDao the menuDao to set
	 */
	@Autowired
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

}
