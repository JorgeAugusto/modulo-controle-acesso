package net.marcoreis.seguranca.controller;

import org.primefaces.model.DefaultMenuModel;

public class ControladorMenu {
  private DefaultMenuModel model;

  public void init() {
    model = new DefaultMenuModel();
    //First submenu
    DefaultSubMenu firstSubmenu = new DefaultSubMenu("Dynamic Submenu");
    DefaultMenuItem item = new DefaultMenuItem("External");
    item.setUrl("http://www.primefaces.org");
    item.setIcon("ui-icon-home");
    firstSubmenu.addElement(item);
    model.addElement(firstSubmenu);
    //Second submenu
    DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");
    item = new DefaultMenuItem("Save");
    item.setIcon("ui-icon-disk");
    item.setCommand("#{menuBean.save}");
    item.setUpdate("messages");
    secondSubmenu.addElement(item);
    item = new DefaultMenuItem("Delete");
    item.setIcon("ui-icon-close");
    item.setCommand("#{menuBean.delete}");
    item.setAjax(false);
    secondSubmenu.addElement(item);
    item = new DefaultMenuItem("Redirect");
    item.setIcon("ui-icon-search");
    item.setCommand("#{menuBean.redirect}");
    secondSubmenu.addElement(item);
    model.addElement(secondSubmenu);
  }
}
